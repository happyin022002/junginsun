/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSar0001Event.java
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
 * @see StmSar0001Event 참조
 * @since J2EE 1.4
 */

public class StmSar0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String ofcCd = "";  // ofc_cd 에 오른마우스 -> SOURCE -> Generate Getters and Setters...을 선택하면 밑에 get/set 이 생긴다.

	public String getOfccd() {
		return ofcCd;
	}

	public void setOfccd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
}