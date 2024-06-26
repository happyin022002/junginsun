/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0001HTMLAction.java
*@FileTitle : Lease Agreement Creation & Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.05.22 노정용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementRegistrationVO;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.lse.containerleaseagreementregistration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ContainerLeaseAgreementRegistrationSC로 실행요청<br>
 * - ContainerLeaseAgreementRegistrationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Nho Jung Yong
 * @see ContainerLeaseAgreementRegistrationEvent 참조
 * @since J2EE 1.6
 */

public class EES_LSE_0096HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_LSE_0001HTMLAction 객체를 생성
	 */
	public EES_LSE_0096HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ContainerLeaseAgreementRegistrationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EesLse0096Event event = new EesLse0096Event();
		AgreementRegistrationVO agmtRegVO = new AgreementRegistrationVO();
		agmtRegVO.setAgreementVO((AgreementVO)getVO(request, AgreementVO.class));
		event.setAgreementRegistrationVO(agmtRegVO);
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