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

import com.social.dao.ForumDAO;
import com.social.model.Forum;

@RestController
public class ForumController
{
	@Autowired
	ForumDAO forumDAO;
	
	@GetMapping(value = "/getForumDetails")
	public ResponseEntity<List<Forum>> getForumDetails()

	{
		List<Forum> listForums = (List<Forum>)forumDAO.getAllForums();
		if (listForums.size() > 0) 
		{
			return new ResponseEntity<List<Forum>>(listForums, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Forum>>(listForums, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/addForum")
	public ResponseEntity<String> addForum(@RequestBody Forum forum)
	{
		
		if(forumDAO.addForum(forum))
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}
	
	@PostMapping(value="/updateForum")
	public ResponseEntity<String> updateForum(@RequestBody Forum forum)
	{
		
		if(forumDAO.updateForum(forum))
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/deleteForum/{forumId}")
	public ResponseEntity<String> deleteForum(@PathVariable("forumId")int forumId)
	{
		Forum forum=forumDAO.getForum(forumId);
		
		if(forumDAO.deleteForum(forum))
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/approveForum/{forumId}")
	public ResponseEntity<String> approveForum(@PathVariable("forumId")int forumId)
	{
		Forum forum=forumDAO.getForum(forumId);
		
		if(forumDAO.approveForum(forum))
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/rejectForum/{forumId}")
	public ResponseEntity<String> rejectForum(@PathVariable("forumId")int forumId)
	{
		Forum forum=forumDAO.getForum(forumId);
		
		if(forumDAO.rejectforum(forum))
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/getForum/{forumId}")
	public ResponseEntity<Forum> getForum(@PathVariable("forumId")int forumId)
	{
		Forum forum=forumDAO.getForum(forumId);
		
		if(forum!=null)
		{
			return new ResponseEntity<Forum>(forum, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Forum>(forum,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}