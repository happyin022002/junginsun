/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSar0002Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableCommonSC로 실행요청<br>
 * - AccountReceivableCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSar0002Event 참조
 * @since J2EE 1.4
 */

public class StmSar0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String vndr_lgl_eng_nm ="";
	private String vndr_seq ="";
	private String delt_flg ="";
	
	
	public String getVndr_lgl_eng_nm() {
		return vndr_lgl_eng_nm;
	}

	public void setVndr_lgl_eng_nm(String vndr_lgl_eng_nm) {
		this.vndr_lgl_eng_nm = vndr_lgl_eng_nm;
	}
	
	public String getVndr_seq() {
		return vndr_seq;
	}

	public void setVndr_seq(String vndr_seq) {
		this.vndr_seq = vndr_seq;
	}

	public String getDelt_flg() {
		return delt_flg;
	}

	public void setDelt_flg(String delt_flg) {
		this.delt_flg = delt_flg;
	}
}