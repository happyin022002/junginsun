/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MST_0021HTMLAction.java
*@FileTitle :  Container Specification Creation &amp; Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.05.11 김석준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.MstCntrSpecVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.mst.equipmentmanagement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EquipmentManagementSC로 실행요청<br>
 * - EquipmentManagementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Suk Jun Kim
 * @see EquipmentManagementEvent 참조
 * @since J2EE 1.4
 */

public class EES_MST_0021HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MST_0021HTMLAction 객체를 생성
	 */
	public EES_MST_0021HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EquipmentManagementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMst0021Event event = new EesMst0021Event();
		
		if(command.isCommand(FormCommand.MODIFY) ||
				command.isCommand(FormCommand.REMOVE) ||
				command.isCommand(FormCommand.ADD)) 
		{
			event.setMstCntrSpecVO((MstCntrSpecVO)getVO(request, MstCntrSpecVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH))
		{
			event.setMstCntrSpecVO((MstCntrSpecVO)getVO(request, MstCntrSpecVO .class));
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