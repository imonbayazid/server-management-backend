package com.imon.servermanagement.service;

import java.io.IOException;
import java.util.Collection;

import com.imon.servermanagement.model.ServerModel;

public interface ServerService {

	ServerModel addServer(ServerModel server);
	Collection<ServerModel> getServerList();
	ServerModel getServerByIP(String ip);
	ServerModel updateServer(ServerModel server);
	Boolean deleteServer(Long serverID);
	
	ServerModel pingServer(String ipAddress);
}
