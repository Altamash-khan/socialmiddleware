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


import com.social.dao.JobDAO;
import com.social.model.Blog;
import com.social.model.Job;

@RestController
public class JobController
{
	@Autowired
	JobDAO jobDAO;
	
	
	@GetMapping(value="/getJob/{jobId}")
	public ResponseEntity<Job> getJob(@PathVariable("jobId")int jobId)
	{
		Job job=jobDAO.getJob(jobId);
		
		if(job!=null)
		{
			return new ResponseEntity<Job>(job, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Job>(job,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value="/addJobDetail")
	public ResponseEntity<String> addJobDetail(@RequestBody Job job)
	{
		
		//job.setCreateDate(new java.util.Date());
		if(jobDAO.addJobDetail(job))
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}
	
	@PostMapping(value="/updateJob")
	public ResponseEntity<String> updateJob(@RequestBody Job job)
	{
		
		
		if(jobDAO.updatejobDetail(job))
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}
	

	@GetMapping(value="/deleteJob/{jobId}")
	public ResponseEntity<String> deleteJob(@PathVariable("jobId")int jobId)
	{
		Job job=jobDAO.getJob(jobId);
		
		if(jobDAO.deletejobDetails(job))
		{
			return new ResponseEntity<String>("Successfull", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error", HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/getJobDetails")
	public ResponseEntity<List<Job>> getJobDetails()

	{
		List<Job> listJobDetails = (List<Job>) jobDAO.getJobdetails();
		if (listJobDetails.size() > 0) 
		{
			return new ResponseEntity<List<Job>>(listJobDetails, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Job>>(listJobDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}