package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.ImeiCheckImpl;

@RestController
public class MyController {
	
	@Autowired
	public ImeiCheckImpl imeiCheck;
	
	@PostMapping("/imei")
	public String check(@RequestBody String imeiNo) {
		return this.imeiCheck.checkValidIMEI(imeiNo);
		
	}

}
