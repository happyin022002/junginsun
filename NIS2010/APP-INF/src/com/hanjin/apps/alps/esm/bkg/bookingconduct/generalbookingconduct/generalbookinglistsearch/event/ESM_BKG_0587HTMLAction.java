/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0587HTMLAction.java
*@FileTitle : Booking Closing Bayplan
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.22 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBayPlanInputVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgCoffTmVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralBookingConductSC로 실행요청<br>
 * - GeneralBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Choi Yeoung Hee
 * @see GeneralBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0587HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0587HTMLAction 객체를 생성
	 */
	public ESM_BKG_0587HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0587Event event = new EsmBkg0587Event();


		if(command.isCommand(FormCommand.SEARCH)) {
			event.setBkgListForBayPlanInputVO((BkgListForBayPlanInputVO)getVO(request, BkgListForBayPlanInputVO .class));
			String subChk = JSPUtil.getParameter(request, "sub_chk");
			event.setSubChk(subChk);
		}else if(command.isCommand(FormCommand.COMMAND01)||command.isCommand(FormCommand.DEFAULT)){
			String spolCd = JSPUtil.getParameter(request, "pol_cd");
			String svslCd = JSPUtil.getParameter(request, "vsl_cd");
			event.setPolCd(spolCd);
			event.setVslCd(svslCd);
		}else if(command.isCommand(FormCommand.MULTI01)||command.isCommand(FormCommand.MULTI02)||command.isCommand(FormCommand.COMMAND02)){
			event.setBkgCoffTmVOs((BkgCoffTmVO[])getVOs(request, BkgCoffTmVO .class,"sheet1_"));
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