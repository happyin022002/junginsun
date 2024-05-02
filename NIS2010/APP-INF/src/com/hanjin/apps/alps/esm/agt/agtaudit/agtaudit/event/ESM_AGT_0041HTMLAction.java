/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_041HTMLAction.java
*@FileTitle : Customized Report Form
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-15
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-03-15 Hwang GyeongNam
* 1.0 최초 생성
* 2009-10-05 : Ho-jin Lee Alps 전환
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.event;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AgtRptItmInfoMstDtlVO;
import com.hanjin.apps.alps.esm.agt.common.Utils;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.enis.esm.agt.agtaudit 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AGTAuditSC로 실행요청<br>
 * - AGTAuditSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Hwang GyeongNam
 * @see EsmAgt0041Event 
 * @since J2EE 1.4
 */
public class ESM_AGT_0041HTMLAction extends HTMLActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_AGT_041HTMLAction 객체를 생성
	 */
	public ESM_AGT_0041HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESM_AGT_041Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsmAgt0041Event event = new EsmAgt0041Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setAgtRptItmInfoMstDtlVO((AgtRptItmInfoMstDtlVO)getVO(request, AgtRptItmInfoMstDtlVO .class));
		}
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setAgtRptItmInfoMstDtlVO((AgtRptItmInfoMstDtlVO)getVO(request, AgtRptItmInfoMstDtlVO .class));
		}
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setAgtRptItmInfoMstDtlVO((AgtRptItmInfoMstDtlVO)getVO(request, AgtRptItmInfoMstDtlVO .class));
			event.setAgtRptItmInfoMstDtlVOS((AgtRptItmInfoMstDtlVO[])getVOs(request, AgtRptItmInfoMstDtlVO .class, ""));
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
