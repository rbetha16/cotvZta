package com.cotiviti.zerotouch.project.repositories;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cotiviti.zerotouch.project.models.CPTICDLinksMasterTestPlan;

@Repository
public interface CPTICDLinksMasterTestPlanCustomRepository {

	//get all master test cases
	List<CPTICDLinksMasterTestPlan> findAll();
	
	// getAll
	List<CPTICDLinksMasterTestPlan> findAll(String projectName);

	// get Single
	CPTICDLinksMasterTestPlan findByTagNameAndTestScriptName(String projectName, String tagName, String testscriptName);

	// add Single
	void addSingleMasterTestCase(HashMap<String, String> fieldValues);

	// edit Single
	boolean editSingleMasterTestCase(HashMap<String, String> fieldValues);
	
	//delete Single
	boolean deleteSingleMasterTestCase(String projectName, String tagName, String testscriptName);

}
