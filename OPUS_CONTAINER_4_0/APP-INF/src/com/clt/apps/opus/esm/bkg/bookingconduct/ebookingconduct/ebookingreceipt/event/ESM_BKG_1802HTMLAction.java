/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1802HTMLAction.java
*@FileTitle : Pegasus XML View
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.05
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterRevMsgVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EBookingConductSC로 실행요청<br>
 * - EBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jun Yong Jin
 * @see EBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_1802HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1801HTMLAction 객체를 생성
	 */
	public ESM_BKG_1802HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1802Event event = new EsmBkg1802Event();


		if(command.isCommand(FormCommand.DEFAULT)) {
			event.setBkgXterRevMsgVO((BkgXterRevMsgVO)getVO(request, BkgXterRevMsgVO .class));
		} else if(command.isCommand(FormCommand.SEARCH)) {
			event.setBkgXterRevMsgVO((BkgXterRevMsgVO)getVO(request, BkgXterRevMsgVO .class));
			event.setSndrId(JSPUtil.getParameter(request, "xter_sndr_id"));
			event.setRqstNo(JSPUtil.getParameter(request, "xter_rqst_no"));
			event.setRqstSeq(JSPUtil.getParameter(request, "xter_rqst_seq"));
			event.setMsgSeq(JSPUtil.getParameter(request, "xter_rqst_msg_seq"));

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