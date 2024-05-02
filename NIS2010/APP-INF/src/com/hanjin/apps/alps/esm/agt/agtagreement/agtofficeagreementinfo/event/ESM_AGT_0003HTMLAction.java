/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESMAGT0003HTMLAction.java
*@FileTitle : Agent Agreement Rate Creation 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.08.17 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.AgtAgnAgmtMstVO;
import com.hanjin.syscommon.common.table.AgtAgnAgmtRtVO;
import com.hanjin.syscommon.common.table.AgtAgnAgmtVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.agt.agtagreement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AGTAgreementSC로 실행요청<br>
 * - AGTAgreementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Ho Jin
 * @see AGTAgreementEvent 참조
 * @since J2EE 1.6
 */

public class ESM_AGT_0003HTMLAction extends HTMLActionSupport {

	/**
	 * ESMAGT0003HTMLAction 객체를 생성
	 */
	public ESM_AGT_0003HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AGTAgreementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmAgt0003Event event = new EsmAgt0003Event();
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setAgtAgnAgmtMstVO((AgtAgnAgmtMstVO)getVO(request, AgtAgnAgmtMstVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setAgtAgnAgmtVO((AgtAgnAgmtVO)getVO(request, AgtAgnAgmtVO .class));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setAgtAgnAgmtRtVO((AgtAgnAgmtRtVO)getVO(request, AgtAgnAgmtRtVO .class));
		}else if(command.isCommand(FormCommand.ADD)){
			event.setAgtAgnAgmtVOS((AgtAgnAgmtVO[])getVOs(request, AgtAgnAgmtVO.class, ""));
		}else if(command.isCommand(FormCommand.COMMAND03)){
			event.setAgtAgnAgmtVOS((AgtAgnAgmtVO[])getVOs(request, AgtAgnAgmtVO.class, ""));
		}else if(command.isCommand(FormCommand.MULTI)){
			event.setAgtAgnAgmtRtVOS((AgtAgnAgmtRtVO[])getVOs(request, AgtAgnAgmtRtVO.class, ""));		
		}else if(command.isCommand(FormCommand.MULTI02)){
			event.setAgtAgnAgmtVO((AgtAgnAgmtVO)getVO(request, AgtAgnAgmtVO .class));
			event.setAgtAgnAgmtVOS((AgtAgnAgmtVO[])getVOs(request, AgtAgnAgmtVO.class, ""));	
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