/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : ESD_TRS_0229HTMLAction.java
 *@FileTitle : Agreement Surcharge Correction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-03-26
 *@LastModifier : jong hyek choi
 *@LastVersion : 1.0
 * 2010-03-26 jong hyek choi
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.agreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CYDoorSOManageSC로 실행요청<br>
 * - CYDoorSOManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author jong hyek choi
 * @see EsdTrs0228Event , ESD_TRS_0229EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0229HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_0229HTMLAction 객체를 생성
	 */
	public ESD_TRS_0229HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_0229Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
//		FormCommand command = FormCommand.fromRequest(request);

		EsdTrs0229Event event = new EsdTrs0229Event();
		String fm_agmtno             = request.getParameter("fm_agmtno")!=null?request.getParameter("fm_agmtno"):"";
		String fm_trsp_agmt_rt_tp_ser_no = request.getParameter("fm_trsp_agmt_rt_tp_ser_no")!=null?request.getParameter("fm_trsp_agmt_rt_tp_ser_no"):"";
		String fm_eq_knd_cd          = request.getParameter("fm_eq_knd_cd")!=null?request.getParameter("fm_eq_knd_cd"):"";
		String page_size             = request.getParameter("page_size")!=null?request.getParameter("page_size"):"";
		String cur_page_cnt          = request.getParameter("cur_page_cnt")!=null?request.getParameter("cur_page_cnt"):"";
		String grid_flg              = request.getParameter("grid_flg")!=null?request.getParameter("grid_flg"):"";
		String fm_effective_agmt     = request.getParameter("fm_effective_agmt")!=null?request.getParameter("fm_effective_agmt"):"";
		
		event.setFm_agmtno              (fm_agmtno);
		event.setFm_trsp_agmt_rt_tp_ser_no    (fm_trsp_agmt_rt_tp_ser_no);
		event.setFm_eq_knd_cd           (fm_eq_knd_cd);	
		event.setPage_size              (page_size);	
		event.setCur_page_cnt           (cur_page_cnt);
		event.setGrid_flg               (grid_flg);
		event.setFmEffectiveAgmt        (fm_effective_agmt);
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