/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdTss0290Event.java
*@FileTitle : D/O notification Report
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-03
*@LastModifier : 
*@LastVersion : 1.0
* 2016-06-03
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CodeManageSC로 실행요청<br>
 * - CodeManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author SHIN DONG IL
 * @see EsdTrs0290Event , ESD_TRS_0290EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0291HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_0290HTMLAction 객체를 생성 
	 */
	public ESD_TRS_0291HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdTrs0290Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
	  	EsdTrs0291Event event = new EsdTrs0291Event();
	  	 
		if(command.isCommand(FormCommand.SEARCH01)) {	
			String f_sent_fm_dt	= JSPUtil.getParameter(request, "f_sent_fm_dt", "");
			String f_sent_to_dt 	= JSPUtil.getParameter(request, "f_sent_to_dt", "");
			String f_ctrl_ofc_cd	= JSPUtil.getParameter(request, "f_ctrl_ofc_cd", "");
			String f_fm_node = JSPUtil.getParameter(request, "f_fm_node", "");
			String f_to_node = JSPUtil.getParameter(request, "f_to_node", "");
			String f_latest = JSPUtil.getParameter(request, "f_latest", "");
			String f_door = JSPUtil.getParameter(request, "f_door", "");
			String f_trnk_vvd = JSPUtil.getParameter(request, "f_trnk_vvd", "");
			String f_bkg_no = JSPUtil.getParameter(request, "f_bkg_no", "");
			String f_cntr_no = JSPUtil.getParameter(request, "f_cntr_no", "");
			String f_sc_no = JSPUtil.getParameter(request, "f_sc_no", "");
			
			event.setF_sent_fm_dt(f_sent_fm_dt);
			event.setF_sent_to_dt(f_sent_to_dt);
			event.setF_ctrl_ofc_cd(f_ctrl_ofc_cd);
			event.setF_fm_node(f_fm_node);
			event.setF_to_node(f_to_node);
			event.setF_latest(f_latest);
			event.setF_door(f_door);
			event.setF_trnk_vvd(f_trnk_vvd);
			event.setF_bkg_no(f_bkg_no);
			event.setF_cntr_no(f_cntr_no);
			event.setF_sc_no(f_sc_no);
		}
		
		request.setAttribute("Event", event);
  	  	return  event;
		
	}
	
	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request
	 * @param eventResponse         
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request
	 * @param event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}
		