package com.imon.servermanagement.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imon.servermanagement.model.ServerModel;
import com.imon.servermanagement.repository.ServerRepo;

import static com.imon.servermanagement.utils.ServerStatusEnum.SERVER_UP;
import static com.imon.servermanagement.utils.ServerStatusEnum.SERVER_DOWN;


@Service
@Transactional
public class ServerServiceImpl implements ServerService {
	
	@Autowired
	private ServerRepo repository;

	@Override
	public ServerModel addServer(ServerModel server) {
		// TODO Auto-generated method stub
        
		return repository.save(server);
	}

	@Override
	public Collection<ServerModel> getServerList() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public ServerModel getServerByIP(String ip) {
		// TODO Auto-generated method stub
		return repository.findByServerIpAddress(ip);
	}

	@Override
	public ServerModel updateServer(ServerModel server) {
		// TODO Auto-generated method stub
		return repository.save(server);
	}

	@Override
	public Boolean deleteServer(Long serverID) {
		// TODO Auto-generated method stub
		 repository.deleteById(serverID);
		 return true;
	}

	@Override
	public ServerModel pingServer(String ipAddress) {
		// TODO Auto-generated method stub
		ServerModel server = repository.findByServerIpAddress(ipAddress);
		InetAddress address = null;
		try {
			address = InetAddress.getByName(ipAddress);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			address = null;
		}
		Boolean isReachable = false;
		try {
			isReachable = address.isReachable(10000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isReachable = false;
		} 
		server.setServerStatus(isReachable? SERVER_UP: SERVER_DOWN);
		repository.save(server);
		return server;
	}


	
	
}
