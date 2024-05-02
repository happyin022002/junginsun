/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_929Event.java
*@FileTitle : Rail Invoice Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-11
*@LastModifier : Kildong_hong
*@LastVersion : 1.0 
* 2006-12-11 Kildong_hong
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.event;

import java.util.HashMap;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_929 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_929HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kildong_hong
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0929Event extends EventSupport {

	private String  cntrNo   = "";

	private HashMap hashParam = new HashMap();
	
	public EsdTrs0929Event(){}

	
	public String getCntr_no() {
		return cntrNo;
	}

	public void setCntr_no(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	private HashMap<String, String> hashColumns = new HashMap<String, String>();
	
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_no", getCntr_no());
		return this.hashColumns;
	}
	
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_no", "cntr_no");
		return this.hashFields;
	}

	public HashMap getHashParam(){
		return this.hashParam;
	}
	
	public void setHashParam(HashMap hashParamValue){
		this.hashParam = hashParamValue;
	}
	
	public String getEventName() {
		return "EsdTrs0929Event";
	}

	public String toString() {
		return "EsdTrs0929Event";
	}

}
