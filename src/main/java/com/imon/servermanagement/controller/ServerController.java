package com.imon.servermanagement.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imon.servermanagement.model.ServerModel;
import com.imon.servermanagement.service.ServerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
//@RequestMapping("/servermanager/v1")
public class ServerController {

	@Autowired
	private ServerService sService;
	
	@ApiOperation("Use this method to check whether the backend is working or not.")
	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return ResponseEntity.ok().body("API check  v8");
	}
	

	@ApiOperation("Use this method to get all available server list")
	@GetMapping("/getallserver")
	public ResponseEntity<Collection<ServerModel>> getServerList() {
		return ResponseEntity.ok().body(sService.getServerList());
	}
	
	@ApiOperation("Use this method to get a specific server details")
	@GetMapping("/getserver/{ip}")
	public ResponseEntity<ServerModel> getServerByID(@ApiParam("Provide the ip address") @PathVariable("ip") String ip) {
		return ResponseEntity.ok().body(sService.getServerByIP(ip));
	}
	
	@ApiOperation("Use this method to add a new server")
	@PostMapping("/addserver")
	public ResponseEntity<ServerModel> addServer(@Valid @RequestBody ServerModel server) {
		
		System.out.println(server); // Just to inspect values for demo
		ServerModel sv = sService.addServer(server);
		return ResponseEntity.ok().body(sv);
	} 
	
	@ApiOperation("Use this method to update server information")
	@PostMapping("/updateserver")
	public ResponseEntity<ServerModel> updateServer(@Valid @RequestBody ServerModel server) {
		
		System.out.println(server); // Just to inspect values for demo
		ServerModel sv = sService.addServer(server);
		return ResponseEntity.ok().body(sv);
	} 
	
	@ApiOperation("Use this method to delete a server using server ID")
	@DeleteMapping("/deleteserver/{ID}")
	public ResponseEntity<String> deleteServer(@ApiParam("Provide the ID of the server") @PathVariable("ID") Long id) {
		Boolean isDeleted = sService.deleteServer(id);
		String msg = isDeleted?"Server is successfully deleted":"Unfortunately, server is not deleted";
		return ResponseEntity.ok().body(msg);
	} 
	

	@ApiOperation("Use this method to PING a server using server IP address")
	@GetMapping("/pingserver/{ip}")
	public ResponseEntity<ServerModel> ping(@ApiParam("Provide the ip address of the server") @PathVariable("ip") String ip){
		return ResponseEntity.ok().body(sService.pingServer(ip));
	}
		
}