/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0190HTMLAction.java
*@FileTitle : Local Tariff File Import_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.06.22 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.VerifyTariffFileListINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.mnr.agreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AgreementManageSC로 실행요청<br>
 * - AgreementManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author WanGyu Kim 
 * @see AgreementManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_MNR_0190HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0190HTMLAction 객체를 생성
	 */
	public EES_MNR_0190HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AgreementManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMnr0190Event event = new EesMnr0190Event();

		if(command.isCommand(FormCommand.MULTI)) {            
			event.setCustomMnrDatVrfyVOs((CustomMnrDatVrfyVO[])getVOs(request, CustomMnrDatVrfyVO .class,""));
			event.setVerifyTariffFileListINVO((VerifyTariffFileListINVO)getVO(request, VerifyTariffFileListINVO .class));
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