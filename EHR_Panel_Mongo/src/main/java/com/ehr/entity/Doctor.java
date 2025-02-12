package com.ehr.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "doctors") // Define MongoDB collection name
public class Doctor {

	@Id
	private String id;
	private String fileName;
	private String contentType;
	private byte[] data;

	public Doctor(String id, String fileName, String contentType, byte[] data) {
		this.id = id;
		this.fileName = fileName;
		this.contentType = contentType;
		this.data = data;
	}

	public Doctor() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
