/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1166HTMLAction.java
*@FileTitle : Arbitrary Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.07
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.06.08 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralBookingConductSC로 실행요청<br>
 * - GeneralBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Moon Hwam Choi
 * @see GeneralBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_1166HTMLAction extends HTMLActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_BKG_1166HTMLAction 객체를 생성
	 */
	public ESM_BKG_1166HTMLAction() {}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SpecialCargoBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

//    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1166Event event = new EsmBkg1166Event();

		request.setAttribute("Event", event);

		return  event;
	}
}
