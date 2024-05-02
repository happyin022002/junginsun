/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : EsmSaqCodEvent.java
*@FileTitle      : 공통
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.saq.common.common.event;

import java.util.HashMap;
 
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_SAQ_COD 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_CODHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김원섭
 * @see ESM_SAQ_CODHTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmSaqCodEvent extends EventSupport {
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
	 * 
	 * @param masterCode
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
		return "EsmSaqCodEvent";
	}

	/**
	 * event 명을 반환한다.
	 * 
	 * @return String 
	 */
	public String toString() {
		return "EsmSaqCodEvent";
	}
}