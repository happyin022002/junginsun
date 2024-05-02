/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : ESD_TRS_0224HTMLAction.java
 *@FileTitle : Agreement Correction Summary
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-03-26
 *@LastModifier : jong hyek choi
 *@LastVersion : 1.0
 * 2010-03-26 jong hyek choi
 * 1.0 최초 생성
-----------------------------------------------------------
 * History
 * 2014.05.28 최종혁 [CHM-201430241] AGMT Confirm 기능 추가
 * 2014.10.29 최종혁 [CHM-201432544] Link 조회 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.SearchCorrSumAgmtVO;
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
 * @see EsdTrs0224Event , ESD_TRS_0224EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0224HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_0220HTMLAction 객체를 생성
	 */
	public ESD_TRS_0224HTMLAction() {
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
		FormCommand command = FormCommand.fromRequest(request);

		SearchCorrSumAgmtVO searchCorrSumAgmtVO   = new SearchCorrSumAgmtVO();
		SearchCorrSumAgmtVO[] tcz = null; 
		if(command.isCommand(FormCommand.REMOVE02) || command.isCommand(FormCommand.MODIFY01)
			) {
			tcz = searchCorrSumAgmtVO.fromRequestGrid(request);
		}

		EsdTrs0224Event event = new EsdTrs0224Event();
		String fm_agmtno          = request.getParameter("fm_agmtno")!=null?request.getParameter("fm_agmtno"):"";
		String fm_vndr_prmry_seq     = request.getParameter("fm_vndr_prmry_seq")!=null?request.getParameter("fm_vndr_prmry_seq"):"";
		String fm_ctrt_ofc_cd        = request.getParameter("fm_ctrt_ofc_cd")!=null?request.getParameter("fm_ctrt_ofc_cd"):"";
		String fm_trsp_agmt_rt_tp_cd = request.getParameter("fm_trsp_agmt_rt_tp_cd")!=null?request.getParameter("fm_trsp_agmt_rt_tp_cd"):"";
		String fm_effective_agmt     = request.getParameter("fm_effective_agmt")!=null?request.getParameter("fm_effective_agmt"):"";
		String fm_hjscnt             = request.getParameter("fm_hjscnt")!=null?request.getParameter("fm_hjscnt"):"";
		String fm_cust_cd            = request.getParameter("fm_cust_cd")!=null?request.getParameter("fm_cust_cd"):"";
		String fm_trsp_cost_mod_cd   = request.getParameter("fm_trsp_cost_mod_cd")!=null?request.getParameter("fm_trsp_cost_mod_cd"):"";
		String fm_agmt_trsp_tp_cd    = request.getParameter("fm_agmt_trsp_tp_cd")!=null?request.getParameter("fm_agmt_trsp_tp_cd"):"";
		String fm_cgo_tp_cd          = request.getParameter("fm_cgo_tp_cd")!=null?request.getParameter("fm_cgo_tp_cd"):"";
		String fm_rail_svc_tp_cd     = request.getParameter("fm_rail_svc_tp_cd")!=null?request.getParameter("fm_rail_svc_tp_cd"):"";
		String fm_cmdt_grp_cd        = request.getParameter("fm_cmdt_grp_cd")!=null?request.getParameter("fm_cmdt_grp_cd"):"";
		String fm_trsp_scg_cd        = request.getParameter("fm_trsp_scg_cd")!=null?request.getParameter("fm_trsp_scg_cd"):"";
		
		String fm_account_ofc_cd  = request.getParameter("fm_account_ofc_cd")!=null?request.getParameter("fm_account_ofc_cd"):"";
		String fm_account_usr_id  = request.getParameter("fm_account_usr_id")!=null?request.getParameter("fm_account_usr_id"):"";
		String fm_cfm_flg  = request.getParameter("fm_cfm_flg")!=null?request.getParameter("fm_cfm_flg"):"";
		String fm_link_flg  = request.getParameter("fm_link_flg")!=null?request.getParameter("fm_link_flg"):"";

		event.setFm_agmtno             (fm_agmtno);
		event.setFm_vndr_prmry_seq     (fm_vndr_prmry_seq);
		event.setFm_ctrt_ofc_cd        (fm_ctrt_ofc_cd);
		event.setFm_trsp_agmt_rt_tp_cd (fm_trsp_agmt_rt_tp_cd);
		event.setFm_effective_agmt     (fm_effective_agmt);
		event.setFm_hjscnt             (fm_hjscnt);
		event.setFm_cust_cd            (fm_cust_cd);
		event.setFm_trsp_cost_mod_cd   (fm_trsp_cost_mod_cd);
		event.setFm_agmt_trsp_tp_cd    (fm_agmt_trsp_tp_cd);
		event.setFm_cgo_tp_cd          (fm_cgo_tp_cd);
		event.setFm_rail_svc_tp_cd     (fm_rail_svc_tp_cd);
		event.setFm_cmdt_grp_cd        (fm_cmdt_grp_cd);
		event.setFm_trsp_scg_cd        (fm_trsp_scg_cd);
		event.setFm_account_ofc_cd(fm_account_ofc_cd);
		event.setFm_account_usr_id(fm_account_usr_id);
		event.setFmCfmFlg(fm_cfm_flg);
		event.setFmLinkFlg(fm_link_flg);
		
		event.setSearchCorrSumAgmtVOs(tcz);	
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