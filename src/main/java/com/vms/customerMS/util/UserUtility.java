package com.vms.customerMS.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Component
public class UserUtility {
	
	//create a custom Response
		public Map<String,String> customResponse(String message, HttpStatus httpsStatus, boolean error){
			Map<String,String> response= new HashMap<String,String>();
			if(error) {
				response.put("message", message);
			}else {
				response.put("error", message);
			}
			response.put("httpStatus", httpsStatus.toString());
			return response;
		}
	
		public Map<String,String> customResponse(String message, HttpStatus httpsStatus){
			Map<String,String> response= new HashMap<String,String>();
			response.put("error", message);
			response.put("httpStatus", httpsStatus.toString());
			return response;
		}

}
