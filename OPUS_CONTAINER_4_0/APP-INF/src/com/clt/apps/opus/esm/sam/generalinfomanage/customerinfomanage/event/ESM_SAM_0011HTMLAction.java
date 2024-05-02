/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_SAM_0011HTMLAction.java
*@FileTitle : Customer Performance Group Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.23
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2012.02.23 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.CustomerGroupCodeVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.sam.generalinfomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralInfoManageSC로 실행요청<br>
 * - GeneralInfoManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CHLOE MIJIN SEO
 * @see GeneralInfoManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SAM_0011HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SAM_0004HTMLAction 객체를 생성
	 */
	public ESM_SAM_0011HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralInfoManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	
	
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsmSam0011Event event = new EsmSam0011Event();
		
		if (command.isCommand(FormCommand.SEARCH)){
			CustomerGroupCodeVO vo = (CustomerGroupCodeVO)getVO(request, CustomerGroupCodeVO .class);
			event.setCustomerGroupCodeVO(vo);
		}
		else if (command.isCommand(FormCommand.SEARCH01)){
			CustomerGroupCodeVO vo = (CustomerGroupCodeVO)getVO(request, CustomerGroupCodeVO .class);
			event.setCustomerGroupCodeVO(vo);
		}
		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}