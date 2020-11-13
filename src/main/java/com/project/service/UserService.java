package com.project.service;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Users;
import com.project.model.Verify;
import com.project.repo.UserDao;
import com.project.repo.VerifyDao;

@Service(value="userservice")
public class UserService {
	
	@Autowired
	private UserDao udao;
	
	@Autowired
	private VerifyDao vdao;

	public UserService() {
		super();
	}
	
	public UserService(UserDao udao) {
		super();
		this.udao = udao;
	}
	
	public UserDao getUdao() {
		return udao;
	}

	public void setUdao(UserDao udao) {
		this.udao = udao;
	}

	public List<Users> getAllUsers() {
		List<Users> temp = udao.findAll();
		for(Users u : temp) {
			u.setEmail(null);
			u.setPassword(null);
			u.setPosts(null);
			u.setLikedPosts(null);
		}
		return temp;
	}
	
	public Users findUserNoPass(int id) {
		Users temp = udao.findById(id);
		temp.setEmail(null);
		temp.setUsername(null);
		temp.setPassword(null);
		temp.setPosts(null);
		temp.setLikedPosts(null);
		return temp;
	}
	
    public Users validateLogin(String username, String pass) {
        //hashing the password algorithm
        String newPass="";
        try {
            
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashPass = md.digest(pass.getBytes());
            newPass = hexString(hashPass);
            
            //System.out.println("java hash of ye: " + newPass);
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        Users temp = udao.findByUsernamePass(username, newPass);
        if (temp != null)
        {
        	temp.setPassword("");
            temp.setPosts(null);
            temp.setLikedPosts(null);
        }
        
        return temp;
    }
	
	//------------------------------------------------------------------------------------------------
	//function found at: https://stackoverflow.com/questions/1033947/mysql-md5-and-java-md5-not-equal
	//meant to encode the hashed password into base 16 to match the password in the db.
	public String hexString( byte[] bytes ) 
	{
		StringBuffer sb = new StringBuffer();
		for( int i=0; i<bytes.length; i++ )     
		{
			byte b = bytes[ i ];
			String hex = Integer.toHexString((int) 0x00FF & b);
			if (hex.length() == 1) 
			{
			   sb.append("0");
			}
			sb.append( hex );
		}
		return sb.toString();
	}
	//--------------------------------------------------------------------------------------------------
	
	public Users createUser(String username, String pass, String firstName, String lastName,
			String email) {
		Users temp = new Users(0, username, pass, firstName, lastName, email,
				"https://lh3.googleusercontent.com/-A4A1LeF0JkU/WYtlfnSNNDI/AAAAAAAAGOg/"
				+"NAZQvaeEkLIqd40OCaVSiHJ7Rr9ZV6ZIwCHMYCw/s5000/%255BUNSET%255D","N/A","N/A","N/A",
				null, null);
		udao.save(temp);
				
		//generate random 6-digit verification code
		Random rand = new Random();
		int code = rand.nextInt(1000000);
		        
		Users newUser = udao.findByUsername(username);
		Verify veri = new Verify(code,newUser.getId(),false);
		        
		//check if the randomly generated code already exists in the table
		boolean test = false;
		do
		{
		    test = vdao.save(veri);      	
		}
		while(test == false);
		        
		EmailService.sendMail(email, "Welcome to Mochi Circle!", 
		       		"Have you had a mochi donut today? You better. Anyway, just click this link to validate your account: "
		       		+ "<a href=\"http://localhost:8080/MochiCircle/api/verify/"+code+"\">http://localhost:8080/MochiCircle/api/verify/"+code+"</a>."
		       				+ "<br/><br/>Thank you. I can't promise that we won't spam your email, but you know.");
		       
		return temp;
	}
	
	public String forgotPass(String email)
	{
		try {
			//get user from their email
			Users user = udao.findByEmail(email);
			
			//create new random password
			Random rand = new Random();
			String newPass = Integer.toString(rand.nextInt(1000000));
			
			//update user with new password
			user.setPassword(newPass);
			udao.update(user);
			
			//send email with their new random password inside it
			EmailService.sendMail(email, "Here's your new temporary password!", 
		       		"Have you had a mochi donut today? You better. Anyway, here is your temporary password: "
					+ newPass);
			
			return "sent";
		}catch(Exception e)
		{
			e.printStackTrace();
			return "not sent";
		}
		
	}
	
	/* ----------------------------------------- Updating user info ----------------------------------------- */
	
	public Users updateBasicInfo(Users u) {
		Users temp = udao.findById(u.getId());
		temp.setUsername(u.getUsername());
		temp.setFirstname(u.getFirstname());
		temp.setLastname(u.getLastname());
		temp.setBio(u.getBio());
		temp.setInterests(u.getInterests());
		if(u.getPicUrl() != null) {
			temp.setPicUrl(u.getPicUrl());
		}

		try {
			return udao.update(temp);
		} catch (Exception e) {
			temp = u;
			temp.setUsername("exception");
			return temp;
		}
	}
	
	public Users updateEmail(int id, String email) {
		Users temp = udao.findById(id);
		temp.setEmail(email);
		
		try {
			return udao.update(temp);
		} catch (Exception e) {
			temp = new Users();
			temp.setEmail("exception");
			return temp;
		}
	}
	
	public Users updatePassword(int id, String password) {
		Users temp = udao.findById(id);
		temp.setPassword(password);
		
		return udao.update(temp);
	}
	
	public String updateUserStatus(int id, String newStatus) {
		Users u = udao.findById(id);
		u.setStatus(newStatus);
		Users nu = udao.update(u);
		return nu.getStatus();
	}

	public VerifyDao getVdao() {
		return vdao;
	}

	public void setVdao(VerifyDao vdao) {
		this.vdao = vdao;
	}

}
