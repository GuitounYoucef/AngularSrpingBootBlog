package com.blog.controllers;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ImageDownloadController {
	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;
	//Download main image of the post
	//post-statement : <img [src]="post.imageLink" class="card-img" alt="..."> 
	
	@RequestMapping(value="/images/{fileName}",method = RequestMethod.GET)
	   public @ResponseBody void getImageOfPost(@PathVariable String fileName,HttpServletResponse response,HttpServletRequest request) throws 
	      IOException,NullPointerException
	       {
		    // img : folder location that contains the images files in the server
	        String img=FILE_DIRECTORY+fileName;
 	        File imageFile = new File(img);
	        response.setContentType("image/jpeg");
	        InputStream in=new FileInputStream(imageFile);
	        IOUtils.copy(in, response.getOutputStream());
	       }
}


