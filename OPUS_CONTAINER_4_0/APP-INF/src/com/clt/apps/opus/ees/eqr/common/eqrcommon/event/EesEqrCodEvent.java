/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EssEqrCodEvent.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :  
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.common.eqrcommon.event;

import java.util.HashMap;

import com.clt.framework.support.layer.event.EventSupport;

/** 
 * ESM_EQR_COD PDTO(Data Transfer Object including Parameters)<br>
 *
 * @author 
 * @see ESM_EQR_CODHTMLAction
 * @since J2EE 1.4
 */

public class EesEqrCodEvent extends EventSupport {
	HashMap params = null;
	String masterCode = "";
	
	/**
	 * sel getter method
	 * 
	 * @return HashMap 
	 */
	public HashMap getParams() {
		return params;
	}

	/**
	 * sel setter method
	 * 
	 * @param params 
	 */
	public void setParams(HashMap params) {
		this.params = params;
		this.masterCode = (String)params.get("mcode");
	}

	/**
	 * sel getter method
	 * 
	 * @return HashMap 
	 */
	public String getMasterCode() {
		return masterCode;
	}

	/**
	 * sel setter method
	 * 
	 * @param params 
	 */
	public void setMasterCode(String masterCode) {
		this.masterCode = masterCode;
	}

	/**
	 * event 
	 * 
	 * @return String 
	 */
	public String getEventName() {
		return "EesEqrCodEvent";
	}

	/**
	 * event 
	 * 
	 * @return String 
	 */
	public String toString() {
		return "EesEqrCodEvent";
	}
	

	
}