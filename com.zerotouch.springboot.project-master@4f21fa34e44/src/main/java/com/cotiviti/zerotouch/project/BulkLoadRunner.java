package com.cotiviti.zerotouch.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.cotiviti.zerotouch.project.models.CPTICDLinksMasterTestPlan;
import com.cotiviti.zerotouch.project.repositories.CPTICDLinksMasterTestPlanRepository;
import com.cotiviti.zerotouch.project.utilities.ZerotouchUtils;

@Component
public class BulkLoadRunner implements CommandLineRunner {
	
	/*@Autowired
	private CPTICDLinksMasterTestPlanRepository masterRepository;
	
	@Value("classpath:CPTICDLinks_Master_Plan.csv")
	private Resource res;*/
	
	@Override
	public void run(String... arg0) throws Exception {
		/*Resource resource = new ClassPathResource("CPTICDLinks_Master_Plan.csv");
		List<CPTICDLinksMasterTestPlan> masterTests = ZerotouchUtils.loadObjectList(CPTICDLinksMasterTestPlan.class, resource.getFilename());
		
		masterRepository.save(masterTests);*/
		
	}

}
