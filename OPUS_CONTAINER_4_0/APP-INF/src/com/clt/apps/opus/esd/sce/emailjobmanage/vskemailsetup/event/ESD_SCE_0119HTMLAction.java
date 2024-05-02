/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_SCE_0119HTMLAction.java
*@FileTitle : VSL SKD e-mailing Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.06
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.08.06 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.vo.VslSkdEmlSetUpVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.sce.emailjobmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EmailJobManageSC로 실행요청<br>
 * - EmailJobManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Park Jun Yong
 * @see EmailJobManageEvent 참조
 * @since J2EE 1.6
 */

public class ESD_SCE_0119HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_SCE_0119HTMLAction 객체를 생성
	 */
	public ESD_SCE_0119HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EmailJobManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdSce0119Event event = new EsdSce0119Event();
		
		String laneCdVerify       = JSPUtil.getNull(request.getParameter("laneCdVerify"));
		String portCdVerify       = JSPUtil.getNull(request.getParameter("portCdVerify"));
		
		if(command.isCommand(FormCommand.MULTI01)) {
			event.setVslSkdEmlSetUpVos((VslSkdEmlSetUpVO[])getVOs(request, VslSkdEmlSetUpVO.class, ""));
		}else if(command.isCommand(FormCommand.REMOVE01)){
			event.setVslSkdEmlSetUpVos((VslSkdEmlSetUpVO[])getVOs(request, VslSkdEmlSetUpVO.class, ""));
		}else if(command.isCommand(FormCommand.SEARCH02)){
			event.setLaneCdVerify(laneCdVerify);
		}else if(command.isCommand(FormCommand.SEARCH03)){
			event.setPortCdVerify(portCdVerify);
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