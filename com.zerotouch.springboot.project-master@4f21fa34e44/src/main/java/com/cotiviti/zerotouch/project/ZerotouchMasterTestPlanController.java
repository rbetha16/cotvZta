package com.cotiviti.zerotouch.project;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cotiviti.zerotouch.project.models.CPTICDLinksMasterTestPlan;
import com.cotiviti.zerotouch.project.repositories.CPTICDLinksMasterTestPlanRepository;

@RestController
@RequestMapping(value = "/")
public class ZerotouchMasterTestPlanController {

	private final CPTICDLinksMasterTestPlanRepository masterRepository;

	public ZerotouchMasterTestPlanController(CPTICDLinksMasterTestPlanRepository userRepository) {
		this.masterRepository = userRepository;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<CPTICDLinksMasterTestPlan> getAllTestCases() {
		System.out.println("Getting all MasterTestPlan test cases");
		return masterRepository.findAll();
	}
	
	@RequestMapping(value = "{projectName}", method = RequestMethod.GET)
	public List<CPTICDLinksMasterTestPlan> getAllTestCasesForProjectName(@RequestParam("projectName") String projectName) {
		System.out.println("Getting all MasterTestPlan test cases");
		return masterRepository.findAll(projectName);
	}
}