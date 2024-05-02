/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_CGM_1201HTMLAction.java
*@FileTitle : EES_CGM_1201
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.15
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.03.15 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSScExptListINVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.cgm.cgmcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CgmCommonSC로 실행요청<br>
 * - CgmCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author LEE YOUNG HEON
 * @see EesCgm1201Event 참조
 * @since J2EE 1.4
 */

public class EES_CGM_1201HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CGM_1201HTMLAction 객체를 생성
	 */
	public EES_CGM_1201HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EesCgm1201Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesCgm1201Event event = new EesCgm1201Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setCpsScExptListINVO((CPSScExptListINVO)getVO(request, CPSScExptListINVO .class));
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setCpsScExptListINVO((CPSScExptListINVO)getVO(request, CPSScExptListINVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setCpsScExptListINVO((CPSScExptListINVO)getVO(request, CPSScExptListINVO .class));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setCpsScExptListINVO((CPSScExptListINVO)getVO(request, CPSScExptListINVO .class));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setCpsScExptListINVO((CPSScExptListINVO)getVO(request, CPSScExptListINVO .class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setCpsScExptListINVOS((CPSScExptListINVO[])getVOs(request, CPSScExptListINVO .class));
		}
		
		request.setAttribute("Event", event);

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