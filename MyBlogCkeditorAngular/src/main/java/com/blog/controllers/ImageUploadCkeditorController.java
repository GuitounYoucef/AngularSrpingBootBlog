package com.blog.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/image")
@CrossOrigin
public class ImageUploadCkeditorController {

	
	@GetMapping("/test")
	public String test() {
		return "test Upload work";
	}

	@GetMapping("/testUpload")
	public String GetMessage() {
		return "test Upload work !!";
	}

	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;

	
	// Upload image with Ckeditor the response is information of image (UrlImage: JSON Object) in the server  
	@RequestMapping(value = "uploadFile", method = RequestMethod.POST, produces = {
			MimeTypeUtils.APPLICATION_JSON_VALUE })
	public UrlImage fileUpload(@RequestParam("upload") MultipartFile file) throws IOException {
		try {
			File myFile = new File(FILE_DIRECTORY + file.getOriginalFilename());
			myFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(myFile);
			fos.write(file.getBytes());
			fos.close();
			return new UrlImage(true,
					file.getOriginalFilename(), "http://localhost:8080/images/" + file.getOriginalFilename());
		} catch (Exception e) {
			return new UrlImage(false,"","");
		}

	}

}