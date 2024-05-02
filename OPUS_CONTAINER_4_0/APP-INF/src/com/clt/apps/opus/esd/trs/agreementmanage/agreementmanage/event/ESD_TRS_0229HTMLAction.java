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
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.agreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CYDoorSOManageSC로 실행요청<br>
 * - CYDoorSOManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author jong hyek choi
 * @see EsdTrs0228Event , ESD_TRS_0229EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0229HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

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
		FormCommand command = FormCommand.fromRequest(request);

		EsdTrs0229Event event = new EsdTrs0229Event();
		
        if(!command.isCommand(FormCommand.SEARCH04)) {
			String fm_agmtno             = request.getParameter("fm_agmtno")!=null?request.getParameter("fm_agmtno"):"";
			String fm_eq_knd_cd          = request.getParameter("fm_eq_knd_cd")!=null?request.getParameter("fm_eq_knd_cd"):"";
			String page_size             = request.getParameter("page_size")!=null?request.getParameter("page_size"):"";
			String cur_page_cnt          = request.getParameter("cur_page_cnt")!=null?request.getParameter("cur_page_cnt"):"";
			String grid_flg              = request.getParameter("grid_flg")!=null?request.getParameter("grid_flg"):"";
			String fm_effective_agmt     = request.getParameter("fm_effective_agmt")!=null?request.getParameter("fm_effective_agmt"):"";
			
			event.setFm_agmtno              (fm_agmtno);
			event.setFm_eq_knd_cd           (fm_eq_knd_cd);
			event.setPage_size              (page_size);
			event.setCur_page_cnt           (cur_page_cnt);
			event.setGrid_flg               (grid_flg);
			event.setFmEffectiveAgmt        (fm_effective_agmt);
        	event.setFm_trsp_agmt_rt_tp_ser_no(request.getParameter("fm_trsp_agmt_rt_tp_ser_no")!=null?request.getParameter("fm_trsp_agmt_rt_tp_ser_no"):"");
        } else if(command.isCommand(FormCommand.SEARCH04)) { // More Candidate Popup(ESD_TRS_0921) Surcharge Rate
        	event.setFmCostModCd(request.getParameter("fm_cost_mod_cd")!=null?request.getParameter("fm_cost_mod_cd"):"");
        	event.setFmCrrModCd(request.getParameter("fm_crr_mod_cd")!=null?request.getParameter("fm_crr_mod_cd"):"");
        	event.setFmCgoTpCd(request.getParameter("fm_cgo_tp_cd")!=null?request.getParameter("fm_cgo_tp_cd"):"");
        	event.setFmLoce(request.getParameter("fm_loce")!=null?request.getParameter("fm_loce"):"");
        	event.setFmYard(request.getParameter("fm_yard")!=null?request.getParameter("fm_yard"):"");
        	event.setViaLoce(request.getParameter("via_loce")!=null?request.getParameter("via_loce"):"");
        	event.setViaYard(request.getParameter("via_yard")!=null?request.getParameter("via_yard"):"");
        	event.setToLoce(request.getParameter("to_loce")!=null?request.getParameter("to_loce"):"");
        	event.setToYard(request.getParameter("to_yard")!=null?request.getParameter("to_yard"):"");
        	event.setDorLoce(request.getParameter("dor_loce")!=null?request.getParameter("dor_loce"):"");
        	event.setDorYard(request.getParameter("dor_yard")!=null?request.getParameter("dor_yard"):"");
        	event.setEqTpszCd(request.getParameter("eq_tpsz_cd")!=null?request.getParameter("eq_tpsz_cd"):"");
        	event.setCntrWgt(request.getParameter("cntr_wgt")!=null?request.getParameter("cntr_wgt"):"");
        	event.setCntrWgtTpCd(request.getParameter("cntr_wgt_tp_cd")!=null?request.getParameter("cntr_wgt_tp_cd"):"");
        	event.setWayType(request.getParameter("way_type")!=null?request.getParameter("way_type"):"");
        	event.setAgmtNo(request.getParameter("agmt_no")!=null?request.getParameter("agmt_no"):"");
        	event.setFm_trsp_agmt_rt_tp_ser_no(request.getParameter("trsp_agmt_rt_tp_ser_no")!=null?request.getParameter("trsp_agmt_rt_tp_ser_no"):"");
        	event.setVndrSeq(request.getParameter("vndr_seq")!=null?request.getParameter("vndr_seq"):"");
        	event.setTrspBndCd(request.getParameter("trsp_bnd_cd")!=null?request.getParameter("bound_cd"):"");
        	event.setSpclCgoCntrTpCd(request.getParameter("spcl_cgo_cntr_tp_cd")!=null?request.getParameter("spcl_cgo_cntr_tp_cd"):"");
        	event.setTrspAgmtEqTpSzCd(request.getParameter("trsp_agmt_eq_tp_sz_cd")!=null?request.getParameter("trsp_agmt_eq_tp_sz_cd"):"");
        	event.setUsrDefRmk(request.getParameter("usr_def_rmk")!=null?request.getParameter("usr_def_rmk"):"");
        	event.setBasicRate(request.getParameter("basic_rate")!=null?request.getParameter("basic_rate"):"");
        	event.setNegoAmt(request.getParameter("nego_amt")!=null?request.getParameter("nego_amt"):"");
        	event.setTotalAmt(request.getParameter("total_amt")!=null?request.getParameter("total_amt"):"");
        	event.setBasisDt(request.getParameter("basis_dt")!=null?request.getParameter("basis_dt"):"");
        	event.setCurrCd(request.getParameter("curr_cd")!=null?request.getParameter("curr_cd"):"");
        }
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