/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSar5003Event.java
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

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASAInquiryListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableAgentSC로 실행요청<br>
 * - AccountReceivableAgentSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSar5003Event 참조
 * @since J2EE 1.4
 */

public class StmSar5003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ASAInquiryListVO aSAInquiryListVO = null;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ASAInquiryListVO getASAInquiryListVO() {
		return aSAInquiryListVO;
	}

	public void setASAInquiryListVO(ASAInquiryListVO aSAInquiryListVO) {
		this.aSAInquiryListVO = aSAInquiryListVO;
	}

	
	public StmSar5003Event(){}

}