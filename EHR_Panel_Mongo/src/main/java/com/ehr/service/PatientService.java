package com.ehr.service;

import java.io.IOException;
import java.util.List;

import com.ehr.entity.Patient;
import org.springframework.web.multipart.MultipartFile;


public interface PatientService {




	String uploadPdf(MultipartFile file, String patientId, String date) throws IOException;


	//Patient getFile(String id);

	List<Patient> getFile(String patientId);
}