package com.ehr.service;


import com.ehr.entity.Patient;
import com.ehr.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository doctorRepository;



	@Override
	public String uploadPdf(MultipartFile file, String patientId, String date) throws IOException {
		Patient document = new Patient();
		document.setFileName(file.getOriginalFilename());
		document.setContentType(file.getContentType());
		document.setData(file.getBytes());
		document.setPatient_id(patientId);
		document.setDate(String.valueOf(date));

		//return String.valueOf(doctorRepository.save(document));

		doctorRepository.save(document);
		return "File uploaded successfully with ID: " + document.getPatient_id();
	}

	@Override
	public List<Patient> getFile(String patient_id) {

		return doctorRepository.findByPatientId(patient_id);
	}


}









	


 



