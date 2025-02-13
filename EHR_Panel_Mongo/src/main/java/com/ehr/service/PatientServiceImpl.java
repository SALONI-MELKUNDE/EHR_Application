package com.ehr.service;


import com.ehr.entity.Doctor;
import com.ehr.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	DoctorRepository doctorRepository;



	@Override
	public String uploadPdf(MultipartFile file) throws IOException {
		Doctor document = new Doctor();
		document.setFileName(file.getOriginalFilename());
		document.setContentType(file.getContentType());
		document.setData(file.getBytes());
		//return String.valueOf(doctorRepository.save(document));

		doctorRepository.save(document);
		return "File uploaded successfully with ID: " + document.getId();
	}
}










	


 



