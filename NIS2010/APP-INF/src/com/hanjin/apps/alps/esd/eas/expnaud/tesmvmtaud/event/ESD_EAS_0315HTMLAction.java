/*=========================================================
*Copyright(c) 2015 CyberLogitec 
*@FileName : ESD_EAS_0315HTMLAction.java
*@FileTitle : Contianer Movement - Reefer
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015-02-02 9014613
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.vo.SearchMvmtLegListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * @author 9014613
 * @see EsdEas0315Event , ESD_EAS_0315EventResponse 참조
 * @since J2EE 1.6
 */
public class ESD_EAS_0315HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_EAS_0315HTMLAction 객체를 생성
	 */
	public ESD_EAS_0315HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PsoAdvanceAuditEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdEas0315Event event = new EsdEas0315Event();
		

		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setSearchMvmtLegListVO((SearchMvmtLegListVO)getVO(request, SearchMvmtLegListVO .class));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setSearchMvmtLegListVOs((SearchMvmtLegListVO[])getVOs(request, SearchMvmtLegListVO .class));
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