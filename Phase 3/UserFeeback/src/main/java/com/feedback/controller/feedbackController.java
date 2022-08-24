package com.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.dao.FeedbackDao;
import com.feedback.model.feedback;

@RestController
public class feedbackController 
{
	@Autowired
	FeedbackDao dao;
	@PostMapping(value="/submitFeedback")
	public String submit(feedback f)
	{
		dao.save(f);
		return "Feedback is submitted successfully";
	}

}
