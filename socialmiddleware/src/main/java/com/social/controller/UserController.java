package com.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.social.dao.UserDAO;
import com.social.model.Blog;
import com.social.model.UserDetail;

@RestController
public class UserController 
{
	@Autowired
	UserDAO userDAO;
	
	@PostMapping(value="/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody UserDetail user)
	{
		
		if(userDAO.registerUser(user))
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/getUser/{userName}")
	public ResponseEntity<UserDetail> getUser(@PathVariable("userName")String userName)
	{
		UserDetail user=userDAO.getUser(userName);
		
		if(user!=null)
		{
			return new ResponseEntity<UserDetail>(user, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<UserDetail>(user,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/deleteUser/{userName}")
	public ResponseEntity<String> deleteUser(@PathVariable("userName")String userName)
	{
		UserDetail user=userDAO.getUser(userName);
		
		if(userDAO.deleteUser(user))
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/approveUser/{userName}")
	public ResponseEntity<String> approveUser(@PathVariable("userName")String userName)
	{
		UserDetail user=userDAO.getUser(userName);
		
		if(userDAO.approveUser(user))
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}
	
	
	@PostMapping(value="/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody UserDetail user)
	{
		
		//blog.setCreateDate(new java.util.Date());
		if(userDAO.updateUser(user))
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/rejectUser/{userName}")
	public ResponseEntity<String> rejectUser(@PathVariable("userName")String userName)
	{
		UserDetail user=userDAO.getUser(userName);
		
		if(userDAO.rejectUser(user))
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}

}