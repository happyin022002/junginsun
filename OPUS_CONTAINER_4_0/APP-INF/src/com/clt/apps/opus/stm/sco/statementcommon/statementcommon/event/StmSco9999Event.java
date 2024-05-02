/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : StmSco9999Event.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아
 * AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는
 * EventResponse를 request에 셋팅<br>
 * 
 * @author Han Dong Hoon
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSco9999Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String jobNm = null;
	private String acclYm = null;
	
	
	public StmSco9999Event(){}


	public String getJobNm() {
		return jobNm;
	}


	public void setJobNm(String jobNm) {
		this.jobNm = jobNm;
	}


	public String getAcclYm() {
		return acclYm;
	}


	public void setAcclYm(String acclYm) {
		this.acclYm = acclYm;
	}

}