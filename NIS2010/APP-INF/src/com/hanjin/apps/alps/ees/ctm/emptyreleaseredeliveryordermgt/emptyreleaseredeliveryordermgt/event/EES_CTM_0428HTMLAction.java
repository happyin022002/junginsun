/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0428HTMLAction.java
*@FileTitle : Territories Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.05.04 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.CimTerritoryVO;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.MdmCountryVO;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.MdmOrganizationVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EmptyReleaseRedeliveryOrderMgtSC로 실행요청<br>
 * - EmptyReleaseRedeliveryOrderMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM, Sang-Soo
 * @see EmptyReleaseRedeliveryOrderMgtEvent 참조
 * @since J2EE 1.4
 */
public class EES_CTM_0428HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CTM_0428HTMLAction 객체를 생성
	 */
	public EES_CTM_0428HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EmptyReleaseRedeliveryOrderMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EesCtm0428Event event = new EesCtm0428Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setCimTerritoryVO((CimTerritoryVO)getVO(request, CimTerritoryVO .class));
			event.setMdmCountryVO((MdmCountryVO)getVO(request, MdmCountryVO .class));
			event.setMdmOrganizationVO((MdmOrganizationVO)getVO(request, MdmOrganizationVO .class));
		} else if(command.isCommand(FormCommand.MULTI)) {
			event.setCimTerritoryVOS((CimTerritoryVO[])getVOs(request, CimTerritoryVO .class,""));
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