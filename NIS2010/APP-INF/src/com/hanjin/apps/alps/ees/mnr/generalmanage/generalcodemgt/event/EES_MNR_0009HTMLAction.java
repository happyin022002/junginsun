/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESS_MNR_0009HTMLAction.java
*@FileTitle : M&R Other Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.05.14 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.vo.CustomMnrGenCdVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.vo.GeneralCodeMgtINVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mnr.generalmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralManageSC로 실행요청<br>
 * - GeneralManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author WanGyu Kim 
 * @see GeneralManageEvent 참조
 * @since J2EE 1.4
 */

public class EES_MNR_0009HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0009HTMLAction 객체를 생성
	 */
	public EES_MNR_0009HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EesMnr0009Event event = new EesMnr0009Event();
		//저장
		if(command.isCommand(FormCommand.MULTI)) { 
			event.setCustomMnrGenCdVOs((CustomMnrGenCdVO[])getVOs(request, CustomMnrGenCdVO .class,""));
		}
		//조회
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setGeneralCodeMgtINVO((GeneralCodeMgtINVO)getVO(request, GeneralCodeMgtINVO .class));
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