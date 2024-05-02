/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_TRS_980HTMLAction.java
*@FileTitle : More CNT Candidates
*Open Issues :
*Change history :
*@LastModifyDate : 2014-11-19
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2014-11-19 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.vo.WoIssueListVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.invoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_921SC로 실행요청<br>
 * - ESD_TRS_921SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Kildong_hong
 * @see EsdTrs0980Event , ESD_TRS_980EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0980HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_921HTMLAction 객체를 생성
	 */
	public ESD_TRS_0980HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_921Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EsdTrs0980Event event = new EsdTrs0980Event();

	    String sc_no  		= JSPUtil.getNull(request.getParameter("sc_no"));
	    String rfa_no 		= JSPUtil.getNull(request.getParameter("rfa_no"));
	    String vndr_seq 	= JSPUtil.getNull(request.getParameter("vndr_seq"));
	    String trsp_bnd_cd	= JSPUtil.getNull(request.getParameter("trsp_bnd_cd"));
	    String fm_nod_cd   	= JSPUtil.getNull(request.getParameter("fm_nod_cd"));
	    String fm_nod_yard 	= JSPUtil.getNull(request.getParameter("fm_nod_yard"));
	    String via_nod_cd   = JSPUtil.getNull(request.getParameter("via_nod_cd"));
	    String via_nod_yard = JSPUtil.getNull(request.getParameter("via_nod_yard"));
	    String to_nod_cd   	= JSPUtil.getNull(request.getParameter("to_nod_cd"));
	    String to_nod_yard 	= JSPUtil.getNull(request.getParameter("to_nod_yard"));
	    String dor_nod_cd  	= JSPUtil.getNull(request.getParameter("dor_nod_cd"));
	    String dor_nod_yard = JSPUtil.getNull(request.getParameter("dor_nod_yard"));
	    String ctrl_ofc_cd  = JSPUtil.getNull(request.getParameter("ctrl_ofc_cd"));
	    String chk_row 		= JSPUtil.getNull(request.getParameter("chk_row"));
	    String scrn_mode    = JSPUtil.getNull(request.getParameter("scrn_mode"));
	    
	    String cgo_tp_cd 			= JSPUtil.getNull(request.getParameter("cgo_tp_cd"));
	    String trsp_crr_mod_cd 		= JSPUtil.getNull(request.getParameter("trsp_crr_mod_cd"));
	    String trsp_cost_dtl_mod_cd = JSPUtil.getNull(request.getParameter("trsp_cost_dtl_mod_cd"));
	    String cust_nomi_trkr_flg 	= JSPUtil.getNull(request.getParameter("cust_nomi_trkr_flg"));
	    String cust_cnt_cd			= JSPUtil.getNull(request.getParameter("cust_cnt_cd"));
	    String cust_seq 			= JSPUtil.getNull(request.getParameter("cust_seq"));
	    String cmdt_cd 				= JSPUtil.getNull(request.getParameter("cmdt_cd"));
	    String wgt_meas_ut_cd 		= JSPUtil.getNull(request.getParameter("wgt_meas_ut_cd"));
	    String cntr_wgt 			= JSPUtil.getNull(request.getParameter("cntr_wgt"));
	    String wtr_rcv_term_cd      = JSPUtil.getNull(request.getParameter("wtr_rcv_term_cd"));
	    String wtr_de_term_cd       = JSPUtil.getNull(request.getParameter("wtr_de_term_cd"));
	    String spcl_cgo_cntr_tp_cd  = JSPUtil.getNull(request.getParameter("spcl_cgo_cntr_tp_cd"));
	    String cust_cnt_cd_seq      = JSPUtil.getNull(request.getParameter("cust_cnt_cd_seq"));
	    String eq_knd_cd      		= JSPUtil.getNull(request.getParameter("eq_knd_cd"));
	    String eq_tpsz_cd      		= JSPUtil.getNull(request.getParameter("eq_tpsz_cd"));
	    String bundling_no          = JSPUtil.getNull(request.getParameter("bundling_no"));
	    String trsp_agmt_wy_tp_cd    = JSPUtil.getNull(request.getParameter("trsp_agmt_wy_tp_cd"));
	    
	    event.setSc_no(sc_no);
	    event.setRfa_no(rfa_no);
	    event.setVndr_seq(vndr_seq);
	    event.setTrsp_bnd_cd(trsp_bnd_cd);
	    event.setCgo_tp_cd(cgo_tp_cd);
	    event.setFm_nod_cd(fm_nod_cd);
	    event.setFm_nod_yard(fm_nod_yard);
	    event.setVia_nod_cd(via_nod_cd);
	    event.setVia_nod_yard(via_nod_yard);
	    event.setDor_nod_cd(dor_nod_cd);
	    event.setDor_nod_yard(dor_nod_yard);	    
	    event.setTo_nod_cd(to_nod_cd);
	    event.setTo_nod_yard(to_nod_yard);
	    event.setScrn_mode(scrn_mode);

	    event.setCtrl_ofc_cd(ctrl_ofc_cd);
	    event.setChk_row(chk_row);
	    event.setTrsp_crr_mod_cd(trsp_crr_mod_cd);
	    event.setTrsp_cost_dtl_mod_cd(trsp_cost_dtl_mod_cd);
	    event.setCust_cnt_cd(cust_cnt_cd);
	    event.setCust_seq(cust_seq);
	    event.setCmdt_cd(cmdt_cd);
	    event.setWgt_meas_ut_cd(wgt_meas_ut_cd);
	    event.setCntr_wgt(cntr_wgt);
	    event.setCust_nomi_trkr_flg(cust_nomi_trkr_flg);
	    event.setWtr_de_term_cd(wtr_de_term_cd);
	    event.setWtr_rcv_term_cd(wtr_rcv_term_cd);
	    event.setSpcl_cgo_cntr_tp_cd(spcl_cgo_cntr_tp_cd);
	    event.setCust_cnt_cd_seq(cust_cnt_cd_seq);
	    event.setEq_knd_cd(eq_knd_cd);
	    event.setEq_tpsz_cd(eq_tpsz_cd);
	    event.setBundling_no(bundling_no);
	    event.setTrsp_agmt_wy_tp_cd(trsp_agmt_wy_tp_cd);
	    
	    
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