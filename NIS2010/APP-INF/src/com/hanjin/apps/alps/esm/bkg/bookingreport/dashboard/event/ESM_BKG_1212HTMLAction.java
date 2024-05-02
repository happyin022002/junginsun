/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : ESM_BKG_1201HTMLAction.java
 *@FileTitle : Dashboard
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.10.17
 *@LastModifier : Poong-yeon Cho
 *@LastVersion : 1.0
 * 2009.06.01 Poong-yeon Cho
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 =========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportColumnVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportFormVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingReportSC로 실행요청<br>
 * - BookingReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Gyoung Sub
 * @see EsmBkg0066Event 참조
 * @since J2EE 1.5
 */

public class ESM_BKG_1212HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;
    /**
     * ESM_BKG_0066HTMLAction 객체를 생성
     */
    public ESM_BKG_1212HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsmBkg0066Event로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);

		EsmBkg1212Event event = new EsmBkg1212Event();
		
		if (command.isCommand(FormCommand.SEARCH)){
		    event.putValue("usr_id", (JSPUtil.getNull(request.getParameter("strUsr_id"))));
		    
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.putValue("rpt_fom_nm", (JSPUtil.getNull(request.getParameter("f_rptFomNm"))));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setReportFormVOs((DashboardReportFormVO[]) getVOs(request, DashboardReportFormVO.class));
		}else if(command.isCommand(FormCommand.MULTI01)) {

			event.putValue("f_rptFomNo", (JSPUtil.getNull(request.getParameter("f_rptFomNo"))));
			event.putValue("f_rptFomNm", (JSPUtil.getNull(request.getParameter("f_rptFomNm"))));
			event.putValue("f_rptFomDesc", (JSPUtil.getNull(request.getParameter("f_rptFomDesc"))));
			event.putValue("checkIbflag", (JSPUtil.getNull(request.getParameter("checkIbflag"))));
			event.putValue("savedStatus", (JSPUtil.getNull(request.getParameter("savedStatus"))));
			event.setReportColumnVOs((DashboardReportColumnVO[]) getVOs(request, DashboardReportColumnVO.class));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.putValue("rpt_fom_nm", (JSPUtil.getNull(request.getParameter("reportName"))));
		}
		request.setAttribute("Event", event);

		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param eventResponse
	 *            EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param event
	 *            Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}