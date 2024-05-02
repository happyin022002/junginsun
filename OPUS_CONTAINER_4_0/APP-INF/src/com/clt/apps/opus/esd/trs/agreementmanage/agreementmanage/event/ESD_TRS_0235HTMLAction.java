/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : ESD_TRS_0235HTMLAction.java
 *@FileTitle : Agreement Header
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-05-17
 *@LastModifier : pjy
 *@LastVersion : 1.0
 * 2010-05-17 pjy
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.agreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CYDoorSOManageSC로 실행요청<br>
 * - CYDoorSOManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author jong hyek choi
 * @see EsdTrs0223Event , ESD_TRS_0223EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0235HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_0220HTMLAction 객체를 생성
	 */
	public ESD_TRS_0235HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_002Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		EsdTrs0235Event event = new EsdTrs0235Event();
		
		String fm_rail_svc_tp_cd         = JSPUtil.getNull(request.getParameter("fm_rail_svc_tp_cd"));
		String fm_agmt_trsp_tp_cd        = JSPUtil.getNull(request.getParameter("fm_agmt_trsp_tp_cd"));
		String fm_trsp_agmt_ofc_cty_cd   = JSPUtil.getNull(request.getParameter("fm_trsp_agmt_ofc_cty_cd"));
		String fm_trsp_agmt_seq          = JSPUtil.getNull(request.getParameter("fm_trsp_agmt_seq"));
		String fm_trsp_agmt_rt_tp_ser_no = JSPUtil.getNull(request.getParameter("fm_trsp_agmt_rt_tp_ser_no"));
		String fm_vndr_seq               = JSPUtil.getNull(request.getParameter("fm_vndr_seq"));
		String fm_ctrt_ofc_cd            = JSPUtil.getNull(request.getParameter("fm_ctrt_ofc_cd"));
		String fm_eq_knd_cd              = JSPUtil.getNull(request.getParameter("fm_eq_knd_cd"));
		String fm_trsp_agmt_eq_tp_sz_cd  = JSPUtil.getNull(request.getParameter("fm_trsp_agmt_eq_tp_sz_cd"));
		String fm_cgo_tp_cd              = JSPUtil.getNull(request.getParameter("fm_cgo_tp_cd"));
		String fm_trsp_cost_mod_cd       = JSPUtil.getNull(request.getParameter("fm_trsp_cost_mod_cd"));
		String fm_trsp_bnd_cd            = JSPUtil.getNull(request.getParameter("fm_trsp_bnd_cd"));
		String fm_fm_nod_cd              = JSPUtil.getNull(request.getParameter("fm_fm_nod_cd"));
		String fm_via_nod_cd             = JSPUtil.getNull(request.getParameter("fm_via_nod_cd"));
		String fm_dor_nod_cd             = JSPUtil.getNull(request.getParameter("fm_dor_nod_cd"));
		String fm_to_nod_cd              = JSPUtil.getNull(request.getParameter("fm_to_nod_cd"));
		String fm_trsp_agmt_bdl_qty      = JSPUtil.getNull(request.getParameter("fm_trsp_agmt_bdl_qty"));
		String fm_wgt_meas_ut_cd         = JSPUtil.getNull(request.getParameter("fm_wgt_meas_ut_cd"));
		String fm_basic_rt               = JSPUtil.getNull(request.getParameter("fm_basic_rt"));
		String fm_curr_cd                = JSPUtil.getNull(request.getParameter("fm_curr_cd"));
		String fm_way                    = JSPUtil.getNull(request.getParameter("fm_way"));

		event.setFm_rail_svc_tp_cd         (fm_rail_svc_tp_cd);
		event.setFm_agmt_trsp_tp_cd        (fm_agmt_trsp_tp_cd);
		event.setFm_trsp_agmt_ofc_cty_cd   (fm_trsp_agmt_ofc_cty_cd);
		event.setFm_trsp_agmt_seq          (fm_trsp_agmt_seq);
		event.setFm_trsp_agmt_rt_tp_ser_no (fm_trsp_agmt_rt_tp_ser_no);
		event.setFm_vndr_seq               (fm_vndr_seq);
		event.setFm_ctrt_ofc_cd            (fm_ctrt_ofc_cd);
		event.setFm_eq_knd_cd              (fm_eq_knd_cd);
		event.setFm_trsp_agmt_eq_tp_sz_cd  (fm_trsp_agmt_eq_tp_sz_cd);
		event.setFm_cgo_tp_cd              (fm_cgo_tp_cd);

		event.setFmTrspCostModCd(fm_trsp_cost_mod_cd);
		event.setFmTrspBndCd(fm_trsp_bnd_cd);
		
		event.setFm_fm_nod_cd              (fm_fm_nod_cd);
		event.setFm_via_nod_cd             (fm_via_nod_cd);
		event.setFm_dor_nod_cd             (fm_dor_nod_cd);
		event.setFm_to_nod_cd              (fm_to_nod_cd);
		event.setFm_trsp_agmt_bdl_qty      (fm_trsp_agmt_bdl_qty);
		event.setFm_wgt_meas_ut_cd         (fm_wgt_meas_ut_cd);
		event.setFm_basic_rt               (fm_basic_rt);
		event.setFm_curr_cd                (fm_curr_cd);	
		event.setFm_way                    (fm_way);	

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