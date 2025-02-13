package com.ehr.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ehr.entity.Doctor;
import org.springframework.web.multipart.MultipartFile;


public interface PatientService {
	



	String uploadPdf(MultipartFile file) throws IOException;


	

	

	
  
}