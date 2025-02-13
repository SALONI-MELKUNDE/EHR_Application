package com.ehr.controller;

import java.io.IOException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.ehr.entity.Patient;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ehr.service.PatientService;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class PatientController {

	@Autowired
	PatientService patientService;


	@PostMapping("/upload")
	public String uploadPdf(@RequestParam("file") MultipartFile file,
							@RequestParam("patient_id") String patient_id,
							@RequestParam("date") String date) throws IOException {

		return patientService.uploadPdf(file,patient_id, date);
	}





	@GetMapping("/download/{patientId}")
	public ResponseEntity<byte[]> downloadFileByPatientId(@PathVariable String patientId) {
		List<Patient> files = patientService.getFile(patientId);

		if (files.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		// Get the first file (or modify logic if multiple files exist)
		Patient file = files.get(0);

		System.out.println("✅ File '" + file.getFileName() + "' downloaded successfully for patient ID: " + patientId);;
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(file.getContentType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
				//.body(new FileDownloadResponse("File downloaded successfully", file.getData()));
				.body(file.getData());
	}
}






