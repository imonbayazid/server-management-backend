package com.imon.servermanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.imon.servermanagement.utils.ServerStatusEnum;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;


@Entity
public class ServerModel {
	
	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;
	@Column(unique = true)
	@NotEmpty(message = "server IP should be unique")
	private String serverIpAddress;
	private String serverName;
	private String serverLocation;
	private ServerStatusEnum serverStatus;
	
	
	public Long getId() {
		return id;
	}
	public ServerModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServerModel(Long id, @NotEmpty(message = "server IP should be unique") String serverIpAddress,
			String serverName, String serverLocation, ServerStatusEnum serverStatus) {
		super();
		this.id = id;
		this.serverIpAddress = serverIpAddress;
		this.serverName = serverName;
		this.serverLocation = serverLocation;
		this.serverStatus = serverStatus;
	}
	public String getServerIpAddress() {
		return serverIpAddress;
	}
	public void setServerIpAddress(String serverIpAddress) {
		this.serverIpAddress = serverIpAddress;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getServerLocation() {
		return serverLocation;
	}
	public void setServerLocation(String serverLocation) {
		this.serverLocation = serverLocation;
	}
	public ServerStatusEnum getServerStatus() {
		return serverStatus;
	}
	public void setServerStatus(ServerStatusEnum serverStatus) {
		this.serverStatus = serverStatus;
	}

}
