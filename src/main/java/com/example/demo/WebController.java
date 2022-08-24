package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


	@SpringBootApplication
public class WebController {

	public static void main(String[	] args) {
			SpringApplication.run(WebController.class, args);
	}


}

//
//@SpringBootApplication
//@Controller
//public class WebController {
//
//	public static void main(String[] args) {
//		SpringApplication.run(WebController.class, args);
//	}
//
//	// MAKE IT THE SPRING BOOT WAY
//	DataServices dataServices = new DataServices();
//
//	@RequestMapping("/login-attempt")
//	public String logIn(@RequestParam(value = "username", defaultValue = "") String username, @RequestParam(value = "password", defaultValue = "") String password) {
//		if(dataServices.logIn(username, password)){
//			// success logging in
//			return "source-upload.html";
//		}
//		else{
//			// wrong login details
//			return "login-failed.html";
//		}
//	}
//
//	@GetMapping("/uploading-source-files")
//	public String uploadSourceFile(@RequestParam(value = "location", defaultValue = "") String location, @RequestParam(value = "format", defaultValue = "") String format) {
//		if (true){
//			// success, go to target file upload
//			return "target-upload.html";
//		}else{
//			return "source-upload-fail.html";
//			// failed, try again
//		}
//	}
//
//	@GetMapping("/")
//	public String main(){
//		return "index.html";
//	}
//
//
//	@PostMapping("/upload")
//	public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file ) {
//
//		String fileName = file.getOriginalFilename();
//		try {
//			file.transferTo( new File(fileName));
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//		return ResponseEntity.ok("File uploaded successfully.");
//	}
//
//
//
//}