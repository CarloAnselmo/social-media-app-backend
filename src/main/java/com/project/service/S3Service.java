package com.project.service;

import java.util.UUID;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.model.Users;
import com.project.repo.S3Dao;
import com.project.repo.UserDao;

@Service(value="s3service")
public class S3Service {

	@Autowired
	private S3Dao s3d;
	
	@Autowired
	private UserDao ud;
	
	public S3Service() {
		super();
	}
	
	public S3Service(S3Dao s3d, UserDao ud) {
		this.s3d = s3d;
		this.ud = ud;
	}
	
	public void setS3d(S3Dao s3d) {
		this.s3d = s3d;
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	private String Upload(String filePath, MultipartFile image) {
		String originalName = image.getOriginalFilename();
		String parts[] = originalName.split("\\.");
		System.out.println(parts.length);
		String extension = parts[parts.length - 1];
		filePath += UUID.randomUUID() + "." + extension;
		return s3d.upload(filePath, image);
	}
	
	public String UploadAvatar(int userId, MultipartFile image) {
		Users user = ud.findById(userId);
		String filePath = "avatars/" + userId + "-" + user.getUsername() + "/";
		String location = Upload(filePath, image);
		return location;
	}
	
	public String UploadAttachment(int postId, MultipartFile filePart) {
		String filePath = "posts/" + postId + "/";
		return Upload(filePath, filePart);
	}
}
