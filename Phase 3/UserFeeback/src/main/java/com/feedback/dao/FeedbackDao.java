package com.feedback.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.feedback.model.feedback;

@Repository
public interface FeedbackDao extends CrudRepository <feedback,Integer>
{
	

}
