/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_930HTMLAction.java
*@FileTitle : Office Transfer Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-16
*@LastModifier : z_kim_sang_geun
*@LastVersion : 1.0
* 2006-10-16 z_kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.cydoorsomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CYDoorSOManageSC로 실행요청<br>
 * - CYDoorSOManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author z_kim_sang_geun
 * @see EsdTrs0930Event , ESD_TRS_930EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0930HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_930HTMLAction 객체를 생성
	 */
	public ESD_TRS_0930HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_930Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);

		EsdTrs0930Event event = new EsdTrs0930Event();
		SingleTransportationVO singleTransportationVO   = new SingleTransportationVO();

		if(command.isCommand(FormCommand.MODIFY) || command.isCommand(FormCommand.MODIFY01)) {
			event.setSingleTransportationVOs(singleTransportationVO.fromRequestGrid(request));
		}
		
		String new_trns_rqst_ofc_cd = request.getParameter("new_trns_rqst_ofc_cd");
		event.setNew_trns_rqst_ofc_cd(new_trns_rqst_ofc_cd);
		
		String new_trns_rqst_rsn = request.getParameter("new_trns_rqst_rsn");

		event.setNew_trns_rqst_rsn(new_trns_rqst_rsn);
		
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