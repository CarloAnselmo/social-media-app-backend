package com.project.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Users;
import com.project.repo.UserDao;

@Service(value="userservice")
public class UserService {

	@Autowired
	private UserDao udao;

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
		//hashing the password formula
		String newPass="";
		try {
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] hashPass = md.digest(pass.getBytes());
			newPass = hexString(hashPass);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		Users temp = udao.findByUsernamePass(username, newPass);
		temp.setPassword(null);
		temp.setPosts(null);
		temp.setLikedPosts(null);
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
		return temp;
	}
	
	/* ----------------------------------------- Updating user info ----------------------------------------- */
	
	public Users updateBasicInfo(int id, String username, String firstname, String lastname) {
		Users temp = udao.findById(id);
		temp.setUsername(username);
		temp.setFirstname(firstname);
		temp.setLastname(lastname);
		
		return udao.update(temp);
	}
	
	public Users updateEmail(int id, String email) {
		Users temp = udao.findById(id);
		temp.setEmail(email);
		
		return udao.update(temp);
	}
	
	public Users updateProfilePic(int id, String picurl) {
		Users temp = udao.findById(id);
		temp.setPicUrl(picurl);
		
		return udao.update(temp);
	}

	public Users updatePassword(int id, String password) {
		Users temp = udao.findById(id);
		temp.setPassword(password);
		
		return udao.update(temp);
	}
	
	public Users updateBio(int id, String bio, String interests) {
		Users temp = udao.findById(id);
		temp.setBio(bio);
		temp.setInterests(interests);
		
		return udao.update(temp);
	}
	
	public String updateUserStatus(int id, String newStatus) {
		Users u = udao.findById(id);
		u.setStatus(newStatus);
		Users nu = udao.update(u);
		return nu.getStatus();
	}

}
