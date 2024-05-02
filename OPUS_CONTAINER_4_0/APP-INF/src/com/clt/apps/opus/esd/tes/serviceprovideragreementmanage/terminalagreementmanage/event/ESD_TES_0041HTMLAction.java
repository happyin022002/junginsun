/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_0041HTMLAction.java
*@FileTitle : China Special Feeder
*Open Issues :
*Change history :
*@LastModifyDate : 2012-04-17
*@LastModifier : JEONGMIN CHO
*@LastVersion : 1.0
* 2012-04-17 JEONGMIN CHO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo.ChinaFdCodVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tes.serviceprovideragreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ServiceProviderAgreementManageSC로 실행요청<br>
 * - ServiceProviderAgreementManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author JEONGMIN CHO
 * @see EsdTes0041Event , ESD_TES_041EventResponse 참조
 * @since J2EE 1.4
 * 
 * @author JEONGMIN CHO
 * @see EsdTes0041Event 참조
 * @since J2EE 1.6
 */
public class ESD_TES_0041HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TES_0040HTMLAction 객체를 생성
	 */
	public ESD_TES_0041HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdTes0040Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsdTes0041Event event = new EsdTes0041Event();
	

		if(command.isCommand(FormCommand.SEARCH)) {
			
			event.setChinaFdCodVO((ChinaFdCodVO)getVO(request, ChinaFdCodVO .class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			
			event.setChinaFdCodVOs((ChinaFdCodVO[])getVOs(request, ChinaFdCodVO .class));
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			
			event.setChinaFdCodVO((ChinaFdCodVO)getVO(request, ChinaFdCodVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			
			event.setChinaFdCodVO((ChinaFdCodVO)getVO(request, ChinaFdCodVO .class));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			
			event.setChinaFdCodVO((ChinaFdCodVO)getVO(request, ChinaFdCodVO .class));
		}

		return  event; //vo를 받아서 event를 통해 서버로 들어가겠다
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