package com.cotiviti.zerotouch.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import com.cotiviti.zerotouch.project.models.CPTICDLinksMasterTestPlan;
import com.cotiviti.zerotouch.project.repositories.CPTICDLinksMasterTestPlanRepository;
import com.cotiviti.zerotouch.project.utilities.ZerotouchUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
public class Application {	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner init(CPTICDLinksMasterTestPlanRepository masterRepository) {
		
		return args -> {
			List<CPTICDLinksMasterTestPlan> mstrTstPln = (List<CPTICDLinksMasterTestPlan>) masterRepository.findAll("CPTICDLinks");
			
			for (int i = 0; i < mstrTstPln.size(); i++) {
				System.out.println(mstrTstPln.get(i));
			}			
			
			List<CPTICDLinksMasterTestPlan> mstrTestPlan = (List<CPTICDLinksMasterTestPlan>) masterRepository.findAll();
			
			for (int j = 0; j < mstrTestPlan.size(); j++) {
				System.out.println(mstrTestPlan.get(j));
			}
			
			long n = masterRepository.count();
			System.out.println("The number of Documents in MasterTestPlan collection are: " + n);
			
			HashMap<String, String> keyValuePairs = new HashMap<String, String>();
			keyValuePairs.put("projectName", "Medicaid");
			keyValuePairs.put("tagName", "Test functionality");
			keyValuePairs.put("featureNo", "F2255");
			keyValuePairs.put("featureName", "Establish Operational Audit Functionality - June Release");
			keyValuePairs.put("userstoryNo", "US20653");
			keyValuePairs.put("testscriptName", "US24466-Dynamic filter for Assignee on Target view & Admin should have role of AdminOps");
			keyValuePairs.put("testType", "Regression");
			keyValuePairs.put("priority", "3");
			
			masterRepository.addSingleMasterTestCase(keyValuePairs);
			
			//masterRepository.editSingleMasterTestCase(keyValuePairs);
			
			masterRepository.deleteSingleMasterTestCase("Medicaid", "US24466DynamicFilterforAssigneeonTargetviewAdminshouldhaveRoleofAdminOps", "US24466-Dynamic filter for Assignee on Target view & Admin should have role of AdminOps");
		};
	}

}
 