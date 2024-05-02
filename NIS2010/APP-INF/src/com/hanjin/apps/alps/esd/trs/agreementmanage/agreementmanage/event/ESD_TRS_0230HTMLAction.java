/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : ESD_TRS_0230HTMLAction.java
 *@FileTitle : Agreement Surcharge Rate History Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011-05-11
 *@LastModifier : 민정호
 *@LastVersion : 1.1
 * 2010-03-26 jong hyek choi
 * 1.0 최초 생성
 * 
 * 1.1 2011.05.11 민정호 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TrsAgmtScgRtHisVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.agreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CYDoorSOManageSC로 실행요청<br>
 * - CYDoorSOManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author jong hyek choi
 * @see EsdTrs0230Event , ESD_TRS_0230EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0230HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_0220HTMLAction 객체를 생성
	 */
	public ESD_TRS_0230HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_0230Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		
		TrsAgmtScgRtHisVO trsAgmtEqRtHisVO   = new TrsAgmtScgRtHisVO();
		TrsAgmtScgRtHisVO[] tcz = null; 
		
		if(command.isCommand(FormCommand.MULTI) || command.isCommand(FormCommand.MULTI01) || command.isCommand(FormCommand.MULTI02)) {
			tcz = trsAgmtEqRtHisVO.fromRequestGrid(request);
		}

		EsdTrs0230Event event = new EsdTrs0230Event();
		String fm_agmtno             = request.getParameter("fm_agmtno") != null?request.getParameter("fm_agmtno"):"";
		String fm_trsp_agmt_rt_tp_cd = request.getParameter("fm_trsp_agmt_rt_tp_cd") != null?request.getParameter("fm_trsp_agmt_rt_tp_cd"):"";
		String fm_eq_knd_cd          = request.getParameter("fm_eq_knd_cd")!=null?request.getParameter("fm_eq_knd_cd"):"";
		String fm_trsp_cost_mod_cd   = request.getParameter("fm_trsp_cost_mod_cd") != null?request.getParameter("fm_trsp_cost_mod_cd"):"";
		String fm_agmt_trsp_tp_cd    = request.getParameter("fm_agmt_trsp_tp_cd") != null?request.getParameter("fm_agmt_trsp_tp_cd"):"";
		String fm_cgo_tp_cd          = request.getParameter("fm_cgo_tp_cd") != null?request.getParameter("fm_cgo_tp_cd"):"";
		String fm_cust_cd            = request.getParameter("fm_cust_cd") != null?request.getParameter("fm_cust_cd"):"";
		String fm_cmdt_grp_cd        = request.getParameter("fm_cmdt_grp_cd") != null?request.getParameter("fm_cmdt_grp_cd"):"";
		String fm_rail_svc_tp_cd     = request.getParameter("fm_rail_svc_tp_cd") != null?request.getParameter("fm_rail_svc_tp_cd"):"";
		String fm_fm_nod_cd          = request.getParameter("fm_fm_nod_cd") != null?request.getParameter("fm_fm_nod_cd"):"";
		String fm_via_nod_cd         = request.getParameter("fm_via_nod_cd") != null?request.getParameter("fm_via_nod_cd"):"";
		String fm_dor_nod_cd         = request.getParameter("fm_dor_nod_cd") != null?request.getParameter("fm_dor_nod_cd"):"";
		String fm_to_nod_cd          = request.getParameter("fm_to_nod_cd") != null?request.getParameter("fm_to_nod_cd"):"";
		String fm_trsp_scg_cd        = request.getParameter("fm_trsp_scg_cd") != null?request.getParameter("fm_trsp_scg_cd"):"";
		String fm_agmt_route_all_flg = request.getParameter("fm_agmt_route_all_flg") != null?request.getParameter("fm_agmt_route_all_flg"):"";
		String fm_fm_nod_yd          = request.getParameter("fm_fm_nod_yd") != null?request.getParameter("fm_fm_nod_yd"):"";
		String fm_via_nod_yd         = request.getParameter("fm_via_nod_yd") != null?request.getParameter("fm_via_nod_yd"):"";
		String fm_dor_nod_yd         = request.getParameter("fm_dor_nod_yd") != null?request.getParameter("fm_dor_nod_yd"):"";
		String fm_to_nod_yd          = request.getParameter("fm_to_nod_yd") != null?request.getParameter("fm_to_nod_yd"):"";
		String fm_eqtpsz		     = request.getParameter("fm_eqtpsz") != null?request.getParameter("fm_eqtpsz"):"";
		String fm_trsp_dist_tp_cd    = request.getParameter("fm_trsp_dist_tp_cd")!=null?request.getParameter("fm_trsp_dist_tp_cd"):"";
		String fm_trsp_agmt_dist     = request.getParameter("fm_trsp_agmt_dist")!=null?request.getParameter("fm_trsp_agmt_dist"):"";
		String fm_dist_meas_ut_cd    = request.getParameter("fm_dist_meas_ut_cd")!=null?request.getParameter("fm_dist_meas_ut_cd"):"";
		String fm_account_usr_id 	 = request.getParameter("fm_account_usr_id")!=null?request.getParameter("fm_account_usr_id"):"";
		String effective_date 	 	 = request.getParameter("effective_date")!=null?request.getParameter("effective_date"):"";	
		String delete_yn 	 	 	 = request.getParameter("delete_yn")!=null?request.getParameter("delete_yn"):"";		
						
		event.setFm_agmtno             (fm_agmtno);
		event.setFm_trsp_agmt_rt_tp_cd (fm_trsp_agmt_rt_tp_cd);
		event.setFm_eq_knd_cd          (fm_eq_knd_cd);
		event.setFm_trsp_cost_mod_cd   (fm_trsp_cost_mod_cd);
		event.setFm_agmt_trsp_tp_cd    (fm_agmt_trsp_tp_cd);
		event.setFm_cgo_tp_cd          (fm_cgo_tp_cd);
		event.setFm_cust_cd            (fm_cust_cd);
		event.setFm_cmdt_grp_cd        (fm_cmdt_grp_cd);
		event.setFm_rail_svc_tp_cd     (fm_rail_svc_tp_cd);
		event.setFm_fm_nod_cd          (fm_fm_nod_cd);
		event.setFm_via_nod_cd         (fm_via_nod_cd);
		event.setFm_dor_nod_cd         (fm_dor_nod_cd);
		event.setFm_to_nod_cd          (fm_to_nod_cd);
		event.setFm_trsp_scg_cd        (fm_trsp_scg_cd);
		event.setFm_agmt_route_all_flg (fm_agmt_route_all_flg);
		event.setFm_fm_nod_yd          (fm_fm_nod_yd);
		event.setFm_via_nod_yd         (fm_via_nod_yd);
		event.setFm_dor_nod_yd         (fm_dor_nod_yd);
		event.setFm_to_nod_yd          (fm_to_nod_yd);
		event.setFm_eqtpsz             (fm_eqtpsz);		
		event.setFm_trsp_dist_tp_cd    (fm_trsp_dist_tp_cd);
		event.setFm_trsp_agmt_dist     (fm_trsp_agmt_dist);
		event.setFm_dist_meas_ut_cd    (fm_dist_meas_ut_cd);
		event.setFm_Account_Usr_Id	   (fm_account_usr_id);
		event.setFm_eqtpsz	   		   (fm_eqtpsz);
		event.setEffective_date	   	   (effective_date);
		event.setDelete_yn	   	   	   (delete_yn);
		
				
		event.setTrsAgmtScgRtHisVOS(tcz);		
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