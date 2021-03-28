package com.cotiviti.zerotouch.project.repositories;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.cotiviti.zerotouch.project.models.CPTICDLinksMasterTestPlan;

public class CPTICDLinksMasterTestPlanRepositoryImpl implements CPTICDLinksMasterTestPlanCustomRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public List<CPTICDLinksMasterTestPlan> findAll() {

		Query query = new Query();
		return mongoTemplate.find(query, CPTICDLinksMasterTestPlan.class);
	}
	
	
	@Override
	public List<CPTICDLinksMasterTestPlan> findAll(String projectName) {
		List<CPTICDLinksMasterTestPlan> returnList = null;
		if (projectName.equals("CPTICDLinks")) {
			returnList = mongoTemplate.findAll(CPTICDLinksMasterTestPlan.class);
		}
		return returnList;
	}

	@Override
	public CPTICDLinksMasterTestPlan findByTagNameAndTestScriptName(String projectName, String tagName, String testscriptName) {
		Query query = new Query();
		query.addCriteria((CriteriaDefinition) Criteria.where("tagName").is(tagName).and("testscriptName").is(testscriptName));
		return (CPTICDLinksMasterTestPlan) mongoTemplate.find(query, CPTICDLinksMasterTestPlan.class);
	}

	@Override
	public void addSingleMasterTestCase(HashMap<String, String> fieldValues) {
		Query query = new Query();
		query.addCriteria((CriteriaDefinition) Criteria.where("tagName").is(fieldValues.get("tagName")).and("testscriptName").is(fieldValues.get("testscriptName")));
		
		CPTICDLinksMasterTestPlan returnedDoc = (CPTICDLinksMasterTestPlan) mongoTemplate.find(query, CPTICDLinksMasterTestPlan.class);
		
		long docExists = mongoTemplate.count(query, CPTICDLinksMasterTestPlan.class);
		
		if (docExists == 0L) {
			CPTICDLinksMasterTestPlan mTest = new CPTICDLinksMasterTestPlan(fieldValues);
			mongoTemplate.insert(mTest);
		}		
		
	}

	@Override
	public boolean editSingleMasterTestCase(HashMap<String, String> fieldValues) {
		Query query = new Query();
		query.addCriteria((CriteriaDefinition) Criteria.where("tagName").is(fieldValues.get("tagName")).and("testscriptName").is(fieldValues.get("testscriptName")));
		
		Update updt = new Update().push("featureName", fieldValues.get("featureName")).push("testscriptName", fieldValues.get("testscriptName"))
				.push("tagName", fieldValues.get("tagName")).push("priority", fieldValues.get("priority"));
		
		
		return mongoTemplate.upsert(query, updt, CPTICDLinksMasterTestPlan.class).wasAcknowledged();
	}

	@Override
	public boolean deleteSingleMasterTestCase(String projectName, String tagName, String testscriptName) {
		Query query = new Query();
		query.addCriteria((CriteriaDefinition) Criteria.where("tagName").is(tagName).and("testscriptName").is(testscriptName));
		return mongoTemplate.remove(query, CPTICDLinksMasterTestPlan.class).wasAcknowledged();
	}

}
