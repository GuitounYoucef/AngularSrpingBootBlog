package com.blog.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageUploadCkeditorController {

	@RequestMapping("/testUpload")
	public String GetMessage() {
		return "test Upload work !!";
	}

	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;

	
	// Upload image with Ckeditor the response is information of image (UrlImage: JSON Object) in the server  
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "uploadFile", method = RequestMethod.POST, produces = {
			MimeTypeUtils.APPLICATION_JSON_VALUE })
	public ResponseEntity<UrlImage> fileUpload(@RequestParam("upload") MultipartFile file) throws IOException {
		try {
			File myFile = new File(FILE_DIRECTORY + file.getOriginalFilename());
			myFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(myFile);
			fos.write(file.getBytes());
			fos.close();
			return new ResponseEntity<UrlImage>(new UrlImage(true,
					file.getOriginalFilename(), "http://localhost:8080/images/" + file.getOriginalFilename()),
					HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<UrlImage>(HttpStatus.BAD_REQUEST);
		}

	}

}