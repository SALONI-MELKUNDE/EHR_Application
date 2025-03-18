package com.ehr.controller;

import java.io.IOException;


import java.util.List;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.ehr.entity.Patient;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
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

		return patientService.uploadPdf(file, patient_id, date);
	}




	@GetMapping("/download/{patientId}")
	public ResponseEntity<byte[]> downloadAllFilesByPatientId(@PathVariable String patientId) {
		List<Patient> files = patientService.getFile(patientId);

		System.out.println("Fetched files for patient ID " + patientId + ": " + files);

		if (files == null || files.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No files found".getBytes());
		}
		try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			 ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream)) {

			for (Patient file : files) {
				if (file.getData() == null) continue; // Skip empty files

				ZipEntry zipEntry = new ZipEntry(file.getFileName());
				zipOutputStream.putNextEntry(zipEntry);
				zipOutputStream.write(file.getData());
				zipOutputStream.closeEntry();
			}

			zipOutputStream.finish();
			byte[] zipBytes = byteArrayOutputStream.toByteArray();

			return ResponseEntity.ok()
					.contentType(MediaType.APPLICATION_OCTET_STREAM)
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"patient_files.zip\"")
					.body(zipBytes);

		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(("Error creating ZIP: " + e.getMessage()).getBytes());
		}
	}

	@DeleteMapping("/deleteFile/{patientId}")
	public ResponseEntity<String> deleteFileByPatientId(@PathVariable String patientId) {
		boolean isDeleted = patientService.deleteFile(patientId);

		if (isDeleted) {
			return ResponseEntity.ok("File deleted successfully for patient ID: " + patientId);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("No file found for patient ID: " + patientId);
	}

}


