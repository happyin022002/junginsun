/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName 		: EES_CGM_1157HTMLAction.java
*@FileTitle 	: Land Inventory Monitoring
*Open Issues 	: 
*Change history :
*@LastModifyDate: 2014.04.16
*@LastModifier 	: 최덕우
*@LastVersion 	: 1.0
* 2014.04.16 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.vo.LandInvMonitoringVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ChassisMgsetAgreementInvoiceSC로 실행요청<br>
 * - ChassisMgsetAgreementInvoiceSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 최덕우
 * @see ChassisMgsetAgreementInvoiceEvent 참조
 * @since J2EE 1.4  
 */

public class EES_CGM_1157HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CGM_1155HTMLAction 객체를 생성
	 */
	public EES_CGM_1157HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ChassisMgsetAgreementInvoiceEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		/**
        ibSheet 사용시 fromRequestGrid를 사용하는데
        prefix는 주로 멀티 Sheet 처리시에 사용하게 된다. (  sheet ID 형태의 prefix 구분자 )
        String prefix = "" ;
        COM_USER com_user = COM_USER.fromRequestGrid(request, prefix);
       */
		FormCommand command = FormCommand.fromRequest(request);
   		
		EesCgm1157Event event = new EesCgm1157Event();
		
		if(command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.SEARCH02) ) {		// 1 - Start Bakc End Job
			event.setLandInvMonitoringVO((LandInvMonitoringVO)getVO(request, LandInvMonitoringVO.class));
		} else if (command.isCommand(FormCommand.SEARCHLIST02)       // 2 - Get status of Back End Job,
				|| command.isCommand(FormCommand.SEARCHLIST03)) {    // 3 - Result return
			event.setAttribute("backEndJob_Key", request.getParameter("backEndJob_Key"));
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