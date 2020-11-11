package com.example;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.project.model.Users;
import com.project.repo.UserDao;

public class Driver {
	
	public static void main(String[] args) throws IOException {
		
//		Users u2 = new Users(0, "big", "pass", "Pat", "Forty", "asdm@todfdfmmy.todm", "http://www.wow.com/", "happy", "I'm old", "I like to eat bugs", new HashSet<>(), new HashSet<>());
//		Posts p1 = new Posts(0, "wowowowowow", u1, new HashSet<>());
//		Posts p2 = new Posts(0, "tehthrhtrh", u1, new HashSet<>());
//		u.getPosts().add(p1);
//		u.getPosts().add(p2);
//		u.getPosts().add(p3);
		
//		PostDao pDAO = new PostDao();
//		
//		ApplicationContext ac = new ClassPathXmlApplicationContext("testBeans.xml");
//		UserDao uDAO = ac.getBean(UserDao.class);
//		Users u1 = new Users(0, "tyj", "tyh", "rth", "rth", "hm@asd.asdm", "http://www.hm.com/", "qwe", "I'm qwe", "I qwe qwe stuff", new HashSet<>(), new HashSet<>());
////		uDAO.save(u1);
//		System.out.println(uDAO.findAll());
//		System.out.println(uDAO.findByUsernamePass("ye", "ye"));
//		System.out.println(uDAO.findById(1));
		
//		uDAO.save(u2);
//		pDAO.save(p1);
//		pDAO.save(p2);
		
//		ApplicationContext ac = new ClassPathXmlApplicationContext("beanConfig.xml");
//		UserService us = ac.getBean(UserService.class, "userservice");
//		ac.getBean(UserService.class);
//		ac.getBean(UserService.class);
//		ac.getBean(UserService.class);
//		ac.getBean(UserService.class);
//		System.out.println(us.getAllUsers());

		
		Regions region = Regions.US_EAST_2;
		
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(region).build();
		String bucket = "revature-mochi-circle";
		String fileName = "avatar/userid";
//		
//		CreateBucketRequest createBucketRequest = CreateBucketRequest.builder().bucket(bucket)
//				.createBucketConfiguration(CreateBucketConfiguration.builder()
//						.locationConstraint(region.id())
//						.build())
//				.build();
//		
//		s3.createBucket(createBucketRequest);
		
//		s3.putObject(PutObjectRequest.builder().bucket(bucket).key(key).build(), RequestBody.fromByteBuffer(getRandomByteBuffer(10000)));
		PutObjectRequest request = new PutObjectRequest(bucket, fileName, new File("C:\\Users\\carlo\\OneDrive\\Desktop\\Images\\Profile Pictures\\dance_man.png")).withCannedAcl(CannedAccessControlList.PublicRead);
		System.out.println(":)");
		s3Client.putObject(request);

		System.out.println(s3Client.getUrl(bucket, fileName).toString());
		
	}
}
