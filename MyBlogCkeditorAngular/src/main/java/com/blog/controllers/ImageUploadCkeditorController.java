package com.blog.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
	public Map<String, Object> fileUpload(@RequestParam("upload") MultipartFile file) throws IOException {
		System.out.print("image uploading ...");
		try {
			File myFile = new File(FILE_DIRECTORY + file.getOriginalFilename());
			myFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(myFile);
			fos.write(file.getBytes());
			fos.close();
			
			/*
			 Ckfinder FileUpload response format :
			{
			    "resourceType": "Files",
			    "currentFolder": {
			        "path": "/",
			        "url": "/ckfinder/userfiles/files/",
			        "acl": 255
			    },
			    "fileName": "fileName.jpg",
			    "uploaded": 1
			}
			*/
			
		    HashMap<String, Object> currentFolder = new HashMap<>();
		    currentFolder.put("path", "/");
		    currentFolder.put("url", "http://localhost:8080/images/" + file.getOriginalFilename());
		    currentFolder.put("acl", 255);
		    

		    HashMap<String, Object> reponse = new HashMap<>();
		    reponse.put("resourceType", "Files");
		    reponse.put("currentFolder", currentFolder);
		    reponse.put("fileName", file.getOriginalFilename());
		    reponse.put("uploaded", 1);
		    
		    
			

			
			return reponse;
		} catch (Exception e) {
			return new HashMap<>();
		}

	}

}