package com.cotiviti.zerotouch.project.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cotiviti.zerotouch.project.models.CPTICDLinksMasterTestPlan;

@Repository
public interface CPTICDLinksMasterTestPlanRepository extends MongoRepository<CPTICDLinksMasterTestPlan, String>, CPTICDLinksMasterTestPlanCustomRepository {
	
}
