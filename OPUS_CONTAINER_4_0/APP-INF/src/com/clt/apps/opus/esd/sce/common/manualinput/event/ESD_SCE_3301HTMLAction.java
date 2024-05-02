/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TMP_STD_0001HTMLAction.java
*@FileTitle : Customs Error Code
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.04.09 이영헌
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.sce.common.manualinput.vo.ActualActivityMappingVO;
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
 * @author YoungHeon Lee
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.6
 */
public class ESD_SCE_3301HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_SCE_3301HTMLAction Object creation
	 */
	public ESD_SCE_3301HTMLAction() {}

	/**
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsdSce3301Event event = new EsdSce3301Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setActualActivityMappingVO((ActualActivityMappingVO)getVO(request, ActualActivityMappingVO .class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setActualActivityMappingVOs((ActualActivityMappingVO[])getVOs(request, ActualActivityMappingVO .class));
		}else if(command.isCommand(FormCommand.COMMAND01)) {
			event.setActualActivityMappingVO((ActualActivityMappingVO)getVO(request, ActualActivityMappingVO .class));
		}else if(command.isCommand(FormCommand.COMMAND02)) {
			event.setActualActivityMappingVO((ActualActivityMappingVO)getVO(request, ActualActivityMappingVO .class));
		}

		return  event;
	}
	/**
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}