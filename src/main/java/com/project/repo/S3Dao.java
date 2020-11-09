package com.project.repo;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Component
public class S3Dao {
	Regions region;
	AmazonS3 s3Client;
	String bucket;
	
	public S3Dao() {
		region = Regions.US_EAST_2;
		s3Client = AmazonS3ClientBuilder.standard().withRegion(region).build();
		bucket = "revature-mochi-circle";
	}
	
	public String upload(String fileName, MultipartFile image) {
		InputStream fileInput = null;
		try {
			fileInput = image.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectMetadata metadata = new ObjectMetadata();
		
        metadata.setContentLength(image.getSize());
		System.out.println("Uploading to S3 Bucket: " + bucket + " with file path: " + fileName);
		PutObjectRequest request = new PutObjectRequest(bucket, fileName, fileInput, metadata).withCannedAcl(CannedAccessControlList.PublicRead);
		s3Client.putObject(request);
		System.out.println("Upload Successful");
		return s3Client.getUrl(bucket, fileName).toString();
	}
}
