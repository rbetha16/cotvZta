package com.cotiviti.zerotouch.project.models;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CPTICDLinksMasterTestPlan {
	
	@Id
	private String Id;
	private String tagName;
	private String featureNo;
	private String featureName;
	private String userstoryNo;
	private String testscriptName;
	private String testType;	
	private String priority;
	
	public CPTICDLinksMasterTestPlan() {
		
	}
	
	public CPTICDLinksMasterTestPlan(String arg_tagName, String arg_featureNo, String arg_featureName, String arg_userstoryNo, String arg_testscriptName, String arg_testType, String arg_priority) {
		this.tagName = arg_tagName;
		this.featureNo = arg_featureNo;
		this.featureName = arg_featureName;
		this.userstoryNo = arg_userstoryNo;
		this.testscriptName = arg_testscriptName;
		this.testType = arg_testType;	
		this.priority = arg_priority;
	}
	
	public CPTICDLinksMasterTestPlan(HashMap<String, String> fieldValues) {
		this.tagName = fieldValues.get("tagName");
		this.featureNo = fieldValues.get("featureNo");
		this.featureName = fieldValues.get("featureName");
		this.userstoryNo = fieldValues.get("userstoryNo");
		this.testscriptName = fieldValues.get("testscriptName");
		this.testType = fieldValues.get("testType");
		this.priority = fieldValues.get("priority");
	}
	
	
	public String getFeatureName() {
		return featureName;
	}
	
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	
	public String getTestscriptName() {
		return testscriptName;
	}
	
	public void setTestscriptName(String testscriptName) {
		this.testscriptName = testscriptName;
	}
	
	public String getTagName() {
		return tagName;
	}
	
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getFeatureNo() {
		return featureNo;
	}

	public void setFeatureNo(String featureNo) {
		this.featureNo = featureNo;
	}

	public String getUserstoryNo() {
		return userstoryNo;
	}

	public void setUserstoryNo(String userstoryNo) {
		this.userstoryNo = userstoryNo;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}
	
}
