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

@RestController
//@RequestMapping("/servermanager/v1")
public class ServerController {

	@Autowired
	private ServerService sService;
	
	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return ResponseEntity.ok().body("API check  v8");
	}
	

	@GetMapping("/getallserver")
	public ResponseEntity<Collection<ServerModel>> getServerList() {
		return ResponseEntity.ok().body(sService.getServerList());
	}
	
	@GetMapping("/getserver/{ip}")
	public ResponseEntity<ServerModel> getServerByID(@PathVariable("ip") String ip) {
		return ResponseEntity.ok().body(sService.getServerByIP(ip));
	}
	
	@PostMapping("/addserver")
	public ResponseEntity<ServerModel> addServer(@Valid @RequestBody ServerModel server) {
		
		System.out.println(server); // Just to inspect values for demo
		ServerModel sv = sService.addServer(server);
		return ResponseEntity.ok().body(sv);
	} 
	

	@PostMapping("/updateserver")
	public ResponseEntity<ServerModel> updateServer(@Valid @RequestBody ServerModel server) {
		
		System.out.println(server); // Just to inspect values for demo
		ServerModel sv = sService.addServer(server);
		return ResponseEntity.ok().body(sv);
	} 
	
	@DeleteMapping("/deleteserver/{ID}")
	public ResponseEntity<String> deleteServer(@PathVariable("ID") Long id) {
		Boolean isDeleted = sService.deleteServer(id);
		String msg = isDeleted?"Server is successfully deleted":"Unfortunately, server is not deleted";
		return ResponseEntity.ok().body(msg);
	} 
	

	@GetMapping("/pingserver/{ip}")
	public ResponseEntity<ServerModel> ping(@PathVariable("ip") String ip){
		return ResponseEntity.ok().body(sService.pingServer(ip));
	}
		
}