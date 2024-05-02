/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ComboxEventResponse.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :  
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.event;

import com.clt.framework.support.layer.event.EventResponseSupport;
import com.clt.framework.component.rowset.DBRowSet;
import java.lang.String;
import java.util.HashMap;

/** 
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 *
 * @author 
 * @see CommonHTMLAction 
 * @since J2EE 1.4
 */

public class ComboxEventResponse extends EventResponseSupport {

	DBRowSet rowSet = null;

	DBRowSet[] rowSets = null;

	String successFlag = null;

	HashMap h = null;

	/**
	 * ComboxEventResponse 
	 */
	public ComboxEventResponse() {
		h = new HashMap();
	}

	/**
	 * Combox DB ResultSet
	 * 
	 * @param rowSet 
	 */
	public ComboxEventResponse(DBRowSet rowSet) {
		this();
		this.rowSet = rowSet;
	}

	/**
	 * Combox DB ResultSet
	 * 
	 * @param rowSet 
	 * @param successFlag 
	 */
	public ComboxEventResponse(DBRowSet rowSet, String successFlag) {
		this(rowSet);
		this.successFlag = successFlag;
	}

	/**
	 * Combox DB ResultSet
	 * 
	 * @param rowSet 
	 * @param h 
	 * @param successFlag 
	 */
	public ComboxEventResponse(DBRowSet rowSet, HashMap h, String successFlag) {
		this(rowSet, successFlag);
		this.h = h;
	}

	/**
	 * Combox DB ResultSet
	 * 
	 * @param rowSets 
	 */
	public ComboxEventResponse(DBRowSet[] rowSets) {
		this();
		this.rowSets = rowSets;
	}

	/**
	 * Combox DB ResultSet
	 * 
	 * @param rowSets 
	 * @param successFlag 
	 */
	public ComboxEventResponse(DBRowSet[] rowSets, String successFlag) {
		this(rowSets);
		this.successFlag = successFlag;
	}

	/**
	 * Combox DB ResultSet
	 * 
	 * @param rowSets 
	 * @param h
	 * @param successFlag 
	 */
	public ComboxEventResponse(DBRowSet[] rowSets, HashMap h, String successFlag) {
		this(rowSets, successFlag);
		this.h = h;
	}

	/**
	 * Hash 
	 * 
	 * @param key  
	 * @return String key
	 */
	public String getHashData(String key) {
		String ret = (String) h.get(key);
		return ret;
	}

	/**
	 * HashMap
	 * 
	 * @return HashMap HashMap
	 */
	public HashMap getHashMap() {
		return this.h;
	}

	/**
	 * DBRowSet
	 * 
	 * @return DBRowSet DBRowSet
	 */
	public DBRowSet getRs() {
		if (rowSet != null)
			return rowSet;
		if (rowSets.length > 0)
			return rowSets[0];
		return null;
	}

	/**
	 * DBRowSet
	 * 
	 * @param i  
	 * @return DBRowSet 
	 */
	public DBRowSet getRs(int i) {
		if (rowSet != null && i == 0)
			return rowSet;
		if (rowSets.length > 0 && i >= 0 && i < rowSets.length)
			return rowSets[i];
		return null;
	}

	/**
	 * @return DBRowSet[]
	 */
	public DBRowSet[] getRowSets() {
		return rowSets;
	}

	/**
	 * @return String 
	 */
	public String getSuccessFlag() {
		return this.successFlag;
	}

	/**
	 * @return String 
	 */
	public String getEventName() {
		return "ComboxEventResponse";
	}
}