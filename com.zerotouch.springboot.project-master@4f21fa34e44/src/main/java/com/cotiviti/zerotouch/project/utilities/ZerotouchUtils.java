package com.cotiviti.zerotouch.project.utilities;

import java.io.File;
import java.util.Collections;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class ZerotouchUtils {
	
	private static ZerotouchUtils instance = null;
	private ZerotouchUtils() {
	      // Exists only to defeat instantiation.
	}

	/**
	 * @return WebControlUtils instance
	 */
	public static ZerotouchUtils getInstance() {
		if(instance == null) {
	         instance = new ZerotouchUtils();
	    }
	      return instance;
	}

	public static <T> List<T> loadObjectList(Class<T> type, String fileName) {
	    try {
	        CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
	        CsvMapper mapper = new CsvMapper();
	        File file = new ClassPathResource(fileName).getFile();
	        MappingIterator<T> readValues = 
	          mapper.reader(type).with(bootstrapSchema).readValues(file);
	        return readValues.readAll();
	    } catch (Exception e) {
	        System.out.println("Error occurred while loading object list from file " + fileName + " " + e);
	        return Collections.emptyList();
	    }
	}
	
}
