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

import com.social.dao.FriendDAO;
import com.social.model.Friend;

@RestController
public class FriendController 
{
	@Autowired
	FriendDAO friendDAO;

	@GetMapping(value = "/getFriendDetails")
	public ResponseEntity<List<Friend>> getFriendDetails()

	{
		List<Friend> listFriends = (List<Friend>)friendDAO.getAllFriends();
		if (listFriends.size() > 0) 
		{
			return new ResponseEntity<List<Friend>>(listFriends, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(listFriends, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/addFriend")
	public ResponseEntity<String> addFriend(@RequestBody Friend friend)
	{
		
		if(friendDAO.addFriend(friend))
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}
	
	@PostMapping(value="/updateFriend")
	public ResponseEntity<String> updateFriend(@RequestBody Friend friend)
	{
		
		if(friendDAO.updateFriend(friend))
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/deleteFriend/{friendId}")
	public ResponseEntity<String> deleteFriend(@PathVariable("friendId")int friendId)
	{
		Friend friend=friendDAO.getFriend(friendId);
		
		if(friendDAO.deleteFriend(friend))
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/approveFriend/{friendId}")
	public ResponseEntity<String> approveFriend(@PathVariable("friendId")int friendId)
	{
		Friend friend=friendDAO.getFriend(friendId);
		
		if(friendDAO.approveFriend(friend))
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/rejectFriend/{friendId}")
	public ResponseEntity<String> rejectFriend(@PathVariable("friendId")int friendId)
	{
		Friend friend=friendDAO.getFriend(friendId);
		
		if(friendDAO.rejectFriend(friend))
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/getFriend/{friendId}")
	public ResponseEntity<Friend> getFriend(@PathVariable("friendId")int friendId)
	{
		Friend friend=friendDAO.getFriend(friendId);
		
		if(friend!=null)
		{
			return new ResponseEntity<Friend>(friend, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Friend>(friend,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
