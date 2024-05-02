/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : ESD_TRS_0226HTMLAction.java
 *@FileTitle : Agreement Rate Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.05
 *@LastModifier : 최종혁
 *@LastVersion : 1.1
 * 2010.03.26 최종혁
 * 1.0 최초 생성
-----------------------------------------------------------
 * History
 * 2010.10.05 최 선     1.1 [CHM-201006313] From, Via, Door, To POP UP 조회 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.agreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CYDoorSOManageSC로 실행요청<br>
 * - CYDoorSOManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author jong hyek choi
 * @see EsdTrs0225Event , ESD_TRS_0225EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0226HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_0220HTMLAction 객체를 생성
	 */
	public ESD_TRS_0226HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_0225Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
//		FormCommand command = FormCommand.fromRequest(request);

		EsdTrs0226Event event = new EsdTrs0226Event();
		String fm_agmtno             = request.getParameter("fm_agmtno")!=null?request.getParameter("fm_agmtno"):"";
		String cur_page_cnt          = request.getParameter("cur_page_cnt")!=null?request.getParameter("cur_page_cnt"):"";
		String fm_trsp_agmt_rt_tp_ser_no = request.getParameter("fm_trsp_agmt_rt_tp_ser_no")!=null?request.getParameter("fm_trsp_agmt_rt_tp_ser_no"):"";

		String search_fm_loc          = request.getParameter("search_fm_loc")!=null?request.getParameter("search_fm_loc"):"";
		String search_fm_yard          = request.getParameter("search_fm_yard")!=null?request.getParameter("search_fm_yard"):"";
		String search_via_loc         = request.getParameter("search_via_loc")!=null?request.getParameter("search_via_loc"):"";
		String search_via_yard         = request.getParameter("search_via_yard")!=null?request.getParameter("search_via_yard"):"";
		String search_door_loc         = request.getParameter("search_door_loc")!=null?request.getParameter("search_door_loc"):"";
		String search_door_yard         = request.getParameter("search_door_yard")!=null?request.getParameter("search_door_yard"):"";
		String search_to_loc          = request.getParameter("search_to_loc")!=null?request.getParameter("search_to_loc"):"";
		String search_to_yard          = request.getParameter("search_to_yard")!=null?request.getParameter("search_to_yard"):"";
		String fm_trsp_agmt_dist     = request.getParameter("fm_trsp_agmt_dist")!=null?request.getParameter("fm_trsp_agmt_dist"):"";
		String fm_eq_knd_cd          = request.getParameter("fm_eq_knd_cd")!=null?request.getParameter("fm_eq_knd_cd"):"";
		String page_size             = request.getParameter("page_size")!=null?request.getParameter("page_size"):"";
		String grid_flg              = request.getParameter("grid_flg")!=null?request.getParameter("grid_flg"):"";
		String fm_effective_agmt     = request.getParameter("fm_effective_agmt")!=null?request.getParameter("fm_effective_agmt"):"";
		String fm_cfm_flg     = request.getParameter("fm_cfm_flg")!=null?request.getParameter("fm_cfm_flg"):"";

		event.setFm_agmtno              (fm_agmtno);
		event.setCur_page_cnt           (cur_page_cnt);
		event.setFm_trsp_agmt_rt_tp_ser_no    (fm_trsp_agmt_rt_tp_ser_no);
		
		event.setSearchFmLoc           (search_fm_loc);
		event.setSearchFmYard           (search_fm_yard);
		event.setSearchViaLoc          (search_via_loc);
		event.setSearchViaYard          (search_via_yard);
		event.setSearchDoorLoc          (search_door_loc);
		event.setSearchDoorYard          (search_door_yard);
		event.setSearchToLoc           (search_to_loc);
		event.setSearchToYard           (search_to_yard);
		event.setFm_trsp_agmt_dist      (fm_trsp_agmt_dist);	
		event.setFm_eq_knd_cd           (fm_eq_knd_cd);	
		event.setPage_size              (page_size);
		event.setGrid_flg               (grid_flg);
		event.setFmEffectiveAgmt        (fm_effective_agmt);
		event.setFmCfmFlg(fm_cfm_flg);
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