package com.project.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Users;
import com.project.repo.UserDao;

@Service
public class UserService {

	private UserDao uDAO;
	
	public UserService(UserDao dao)
	{
		super();
		uDAO = dao;
	}

	public UserDao getuDAO() {
		return uDAO;
	}
	
	@Autowired
	public void setuDAO(UserDao uDAO) {
		this.uDAO = uDAO;
	}
	
	public List<Users> findAllUsers()
	{
		return uDAO.findAll();
	}
	
	//Can be overloaded
	public Users getUser(String username, String password)
	{
		//Converts the password to md5 hash
		String newPass = "";
		try {
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] hashPass = md.digest(password.getBytes());
			newPass = hexString(hashPass);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return uDAO.findByCredentials(username, newPass);
	}
	
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
}
