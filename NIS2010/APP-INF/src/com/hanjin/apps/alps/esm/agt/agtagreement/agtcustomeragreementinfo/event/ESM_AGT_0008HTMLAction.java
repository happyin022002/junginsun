/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_008HTMLAction.java
*@FileTitle : 구주 FAC 계약 요율 Creation/Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-13
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-12-13 Hwang GyeongNam
* 1.0 최초 생성
* 2009-09-04 : Ho-Jin Lee Alps 전환
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.AgtFacAgmtRtVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.enis.esm.agt.agtagreement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AGTAgreementSC로 실행요청<br>
 * - AGTAgreementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Hwang GyeongNam
 * @see EsmAgt0008Event , ESM_AGT_008EventResponse 참조
 * @since J2EE 1.4
 */
public class ESM_AGT_0008HTMLAction extends HTMLActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default 생성자<br>
	 */
	public ESM_AGT_0008HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESM_AGT_008Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsmAgt0008Event event = new EsmAgt0008Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setAgtFacAgmtRtVO((AgtFacAgmtRtVO)getVO(request, AgtFacAgmtRtVO.class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setAgtFacAgmtRtVO((AgtFacAgmtRtVO)getVO(request, AgtFacAgmtRtVO.class));
		}else if(command.isCommand(FormCommand.MULTI)){
			event.setAgtFacAgmtRtVOS((AgtFacAgmtRtVO[])getVOs(request, AgtFacAgmtRtVO.class));
		}else if(command.isCommand(FormCommand.MULTI01)){
			event.setAgtFacAgmtRtVOS((AgtFacAgmtRtVO[])getVOs(request, AgtFacAgmtRtVO.class));
		}else if(command.isCommand(FormCommand.MULTI02)){
			event.setAgtFacAgmtRtVOS((AgtFacAgmtRtVO[])getVOs(request, AgtFacAgmtRtVO.class));
		}else if(command.isCommand(FormCommand.MULTI03)){
			event.setAgtFacAgmtRtVOS((AgtFacAgmtRtVO[])getVOs(request, AgtFacAgmtRtVO.class));
		}

		return  event;	
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