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

import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportFormVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportSettingVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingReportSC로 실행요청<br>
 * - BookingReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Eun jung Park
 * @see EsmBkg12136Event 참조
 * @since J2EE 1.5
 */
public class ESM_BKG_1211HTMLAction  extends HTMLActionSupport {

	
	/**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsmBkg0066Event로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1211Event event = new EsmBkg1211Event();
		
		
		if (command.isCommand(FormCommand.SEARCH)){
		    event.putValue("usr_id", (JSPUtil.getNull(request.getParameter("strUsr_id"))));
		    event.putValue("bkg_ofc", (JSPUtil.getNull(request.getParameter("bkg_ofc")).toUpperCase()));
		    
		}else if (command.isCommand(FormCommand.MULTI)|| command.isCommand(FormCommand.MULTI01)){
		    event.setReportSettingVOs((DashboardReportSettingVO[]) getVOs(request, DashboardReportSettingVO.class));
		    event.putValue("usr_id", (JSPUtil.getNull(request.getParameter("strUsr_id"))));
		    event.putValue("bkg_ofc", (JSPUtil.getNull(request.getParameter("bkg_ofc")).toUpperCase()));
		}
		return event;
	}

}
