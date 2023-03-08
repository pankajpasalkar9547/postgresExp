package com.jersey.Service;

import java.util.List;

import org.glassfish.jersey.server.Uri;
import org.springframework.stereotype.Service;

import com.jersey.DTO.StudentInfoDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;



@Service
public class JerseyService {
	
	
	public List<StudentInfoDTO> getData() {
		Client clent = Client.create(); 	
		WebResource webResource = clent.resource("http://localhost:8089/student/all");
		ClientResponse response = null;
		response = (ClientResponse)((WebResource.Builder)webResource.accept(new String[] {"application/json"}).type("application/json"))
				.post(ClientResponse.class);
		System.out.println("Status : " +response.getStatus());
		String r = response.getEntity(String.class);
		return null;
	}

}
