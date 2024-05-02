/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0091HTMLAction.java
*@FileTitle : Agreement No. Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.28 노정용
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
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.lse.containerleaseagreementregistration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ContainerLeaseAgreementRegistrationSC로 실행요청<br>
 * - ContainerLeaseAgreementRegistrationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Nho Jung Yong
 * @since J2EE 1.4
 * @see ...
 */

public class EES_LSE_0004HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_LSE_0091HTMLAction 객체를 생성
	 */
	public EES_LSE_0004HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesLse0004Event event = new EesLse0004Event();

		if ( command.isCommand(FormCommand.SEARCH) ) {
			event.setOrgCntrTpszCd(request.getParameter("org_cntr_tpsz_cd"));
			event.setExpFromDt(request.getParameter("exp_from_dt").replaceAll("-", ""));
			event.setExpToDt(request.getParameter("exp_to_dt").replaceAll("-", ""));
			event.setVndrSeq(request.getParameter("vndr_seq"));
			event.setLstmCd(request.getParameter("lstm_cd"));
			event.setOfcCd(request.getParameter("ofc_cd"));
			event.setAllLstmCd(request.getParameter("all_lstm_cd"));
			event.setLsePayTpCd(request.getParameter("lse_pay_tp_cd"));
		} else if ( command.isCommand(FormCommand.SEARCH01) ) {
			AgreementRegistrationVO agmtRegVO = new AgreementRegistrationVO();
			agmtRegVO.setAgreementVO((AgreementVO)getVO(request, AgreementVO.class));
			event.setAgreementRegistrationVO(agmtRegVO);
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