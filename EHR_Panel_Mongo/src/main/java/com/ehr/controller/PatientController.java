package com.ehr.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ehr.entity.Doctor;

import com.ehr.service.PatientService;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PatientController {

	@Autowired
	PatientService patientService;


	@PostMapping("/upload")
	public String uploadPdf(@RequestParam("file") MultipartFile file) throws IOException {
		return patientService.uploadPdf(file);
	}


}
