package com.web.service.rmi.model;

import java.io.Serializable;

public class RmiFmcObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String defaultServer = null;
	private String soapAction = null;
	private String message = null;
	private String userId = null;
	private String UserPasswd = null;
	private int callTimeOut = 100000;

	public String getDefaultServer() {
		return defaultServer;
	}

	public void setDefaultServer(String defaultServer) {
		this.defaultServer = defaultServer;
	} 

	public String getSoapAction() {
		return soapAction;
	}

	public void setSoapAction(String soapAction) {
		this.soapAction = soapAction;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCallTimeOut() {
		return callTimeOut;
	}

	public void setCallTimeOut(int callTimeOut) {
		this.callTimeOut = callTimeOut;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPasswd() {
		return UserPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		UserPasswd = userPasswd;
	}

}
