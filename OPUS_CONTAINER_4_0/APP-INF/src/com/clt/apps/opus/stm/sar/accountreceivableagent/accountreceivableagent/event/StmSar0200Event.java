/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSar0200Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.event;

import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableAgentSC로 실행요청<br>
 * - AccountReceivableAgentSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSar0200Event 참조
 * @since J2EE 1.4
 */

public class StmSar0200Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String asaNo  = "";  //오른쪽 마우스 source-Generate Getters and Setters
	private String asaOfcCd  = "";
	private String flag_cd  = "";
	
	
	public String getFlag_cd() {
		return flag_cd;
	}
	public void setFlag_cd(String flag_cd) {
		this.flag_cd = flag_cd;
	}
	public String getAsaOfcCd() {
		return asaOfcCd;
	}
	public void setAsaOfcCd(String asaOfcCd) {
		this.asaOfcCd = asaOfcCd;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getAsaNo() {
		return asaNo;
	}
	public void setAsaNo(String asaNo) {
		this.asaNo = asaNo;
	}

}