package com.ehr.service;

import java.io.IOException;
import java.util.List;

import com.ehr.entity.Patient;
import org.springframework.web.multipart.MultipartFile;


public interface PatientService {

	String uploadPdf(MultipartFile file, String patientId, String date) throws IOException;
	List<Patient> getFile(String patientiId);
	boolean deleteFile(String patientiId);
}