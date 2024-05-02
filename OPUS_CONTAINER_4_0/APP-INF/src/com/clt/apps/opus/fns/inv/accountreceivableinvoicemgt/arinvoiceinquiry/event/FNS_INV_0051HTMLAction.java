/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0051HTMLAction.java
*@FileTitle : Customer Preferable Report -Item Select
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.08.28 한동훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvCprtTmpltChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TemplateVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Han Dong Hoon
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.6
 */

public class FNS_INV_0051HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0051HTMLAction 객체를 생성
	 */
	public FNS_INV_0051HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0051Event event = new FnsInv0051Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setRptTmpltNm(request.getParameter("select_tmplt"));
			event.setOfcCd(request.getParameter("tmplt_ofc_cd"));
			
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setRptTmpltNm(request.getParameter("rpt_tmplt_nm2"));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setRptAuthId(request.getParameter("rpt_auth_id"));
		}else if(command.isCommand(FormCommand.MULTI)) {
		    event.setTemplateVOs((TemplateVO[])getVOs(request, TemplateVO .class,"sheet1_"));
		    event.setInvCprtTmpltChgVOs((InvCprtTmpltChgVO[])getVOs(request, InvCprtTmpltChgVO.class,"sheet2_"));
			
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setRptTmpltNm(request.getParameter("select_tmplt"));
			event.setOfcCd(request.getParameter("tmplt_ofc_cd"));
		}

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param EventResponse eventResponse
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param Event event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}