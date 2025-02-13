package com.ehr.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Patient_Data") // Define MongoDB collection name
public class Patient {

	@Id
	private String id;
	private String patient_id;
	private String Date;
	private String fileName;
	private String contentType;
	private byte[] data;

	public Patient(String id, String patient_id, String date, String fileName, String contentType) {
		this.id = id;
		this.patient_id = patient_id;
		Date = date;
		this.fileName = fileName;
		this.contentType = contentType;
		this.data = data;
	}

	public Patient() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
}
