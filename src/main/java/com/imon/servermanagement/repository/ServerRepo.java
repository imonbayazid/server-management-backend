package com.imon.servermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imon.servermanagement.model.ServerModel;

public interface ServerRepo extends JpaRepository<ServerModel, Long> {
	
	ServerModel findByServerIpAddress(String ipAddress);

}
