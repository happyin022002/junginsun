package com.web.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.web.service.rmi.model.RmiFmcObject;

public interface RMIInterface extends Remote {
	
	public String fmc(RmiFmcObject obj) throws RemoteException;
	
} 