/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_BKG_2001HTMLAction.java
*@FileTitle : Customs Common Code
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsCdConvVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see EsmBkg2001Event 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_2001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_2001HTMLAction 객체를 생성
	 */
	public ESM_BKG_2001HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 customsdeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg2001Event event = new EsmBkg2001Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setCstmsCdConvVO((CstmsCdConvVO)getVO(request, CstmsCdConvVO .class));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setCstmsCdConvVOs((CstmsCdConvVO[])getVOs(request, CstmsCdConvVO .class));
		}else if(command.isCommand(FormCommand.MULTI02)) {
			event.setCstmsCdConvVOs((CstmsCdConvVO[])getVOs(request, CstmsCdConvVO .class));
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setCstmsCdConvVO((CstmsCdConvVO)getVO(request, CstmsCdConvVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setCstmsCdConvVO((CstmsCdConvVO)getVO(request, CstmsCdConvVO .class));
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