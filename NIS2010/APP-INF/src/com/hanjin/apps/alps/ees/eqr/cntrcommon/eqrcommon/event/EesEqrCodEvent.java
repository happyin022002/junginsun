/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EssEqrCodEvent.java
*@FileTitle : 공통
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-27
*@LastModifier :  SHIN DONG IL
*@LastVersion : 1.0
* 2013-05-27  SHIN DONG IL
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.event;

import java.util.HashMap;

import com.hanjin.framework.support.layer.event.EventSupport;

/** 
 * ESM_EQR_COD 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_EQR_CODHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHIN DONG IL
 * @see ESM_EQR_CODHTMLAction 참조
 * @since J2EE 1.4
 */

public class EesEqrCodEvent extends EventSupport {
	HashMap params = null;
	String masterCode = "";
	
	/**
	 * sel 멤버변수의 getter method
	 * 
	 * @return HashMap 
	 */
	public HashMap getParams() {
		return params;
	}

	/**
	 * sel 멤버변수의 setter method
	 * 
	 * @param params 
	 */
	public void setParams(HashMap params) {
		this.params = params;
		this.masterCode = (String)params.get("mcode");
	}

	/**
	 * sel 멤버변수의 getter method
	 * 
	 * @return HashMap 
	 */
	public String getMasterCode() {
		return masterCode;
	}

	/**
	 * sel 멤버변수의 setter method
	 * 
	 * @param params 
	 */
	public void setMasterCode(String masterCode) {
		this.masterCode = masterCode;
	}

	/**
	 * event 명을 반환한다.
	 * 
	 * @return String 
	 */
	public String getEventName() {
		return "EesEqrCodEvent";
	}

	/**
	 * event 명을 반환한다.
	 * 
	 * @return String 
	 */
	public String toString() {
		return "EesEqrCodEvent";
	}
	

	
}