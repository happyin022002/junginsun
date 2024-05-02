/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_920HTMLAction.java
*@FileTitle : CY & Door S/O Creation Matchmaking Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-29
*@LastModifier : z_kim_sang_geun
*@LastVersion : 1.0
* 2006-09-29 z_kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.cydoorsomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CYDoorSOManageSC로 실행요청<br>
 * - CYDoorSOManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author z_kim_sang_geun
 * @see EsdTrs0920Event 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0920HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_0920HTMLAction 객체를 생성
	 */
	public ESD_TRS_0920HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdTrs0920Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0920Event event = new EsdTrs0920Event();
		if(command.isCommand(FormCommand.SEARCH01)){
			//CB II Matchmaking Popup- from ESD_TRS_0920
			event.setTrspCostDtlModCd(JSPUtil.getParameter(request, "trsp_cost_dtl_mod_cd".trim(), ""));
			event.setLstNodPlnDt(JSPUtil.getParameter(request, "lst_nod_pln_dt".trim(), ""));
			event.setLstNodPlnDtHms(JSPUtil.getParameter(request, "lst_nod_pln_dt_hms".trim(), ""));
			event.setToNodCd(JSPUtil.getParameter(request, "to_nod_cd".trim(), ""));
			event.setToNodYard(JSPUtil.getParameter(request, "to_nod_yard".trim(), ""));
			event.setDorNodPlnDt(JSPUtil.getParameter(request, "dor_nod_pln_dt".trim(), ""));
			event.setDorNodPlnDtHms(JSPUtil.getParameter(request, "dor_nod_pln_dt_hms".trim(), ""));
			event.setDorNodCd(JSPUtil.getParameter(request, "dor_nod_cd".trim(), ""));
			event.setDorNodYard(JSPUtil.getParameter(request, "dor_nod_yard ".trim(), ""));
			event.setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd".trim(), ""));
			event.setUiContiCd(JSPUtil.getParameter(request, "ui_conti_cd".trim(), ""));
			event.setCydoorDiv(JSPUtil.getParameter(request, "cydoor_div".trim(), ""));
			event.setTrspSoOfcCtyCd(JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd".trim(), ""));
			
			
		}else if(command.isCommand(FormCommand.SEARCH02)){
			/*Matchmaking One Popup -service Order>Correction>CY&Door 에서 
			 *Matchmaking for Combined Case 2 버튼 클릭시 팝업 (ESD_TRS_0952)
			*/
			event.setTrspCostDtlModCd(JSPUtil.getParameter(request, "trsp_cost_dtl_mod_cd".trim(), ""));
			event.setLstNodPlnDt(JSPUtil.getParameter(request, "lst_nod_pln_dt".trim(), ""));
			event.setLstNodPlnDtHms(JSPUtil.getParameter(request, "lst_nod_pln_dt_hms".trim(), ""));
			event.setToNodCd(JSPUtil.getParameter(request, "to_nod_cd".trim(), ""));
			event.setToNodYard(JSPUtil.getParameter(request, "to_nod_yard".trim(), ""));
			event.setDorNodPlnDt(JSPUtil.getParameter(request, "dor_nod_pln_dt".trim(), ""));
			event.setDorNodPlnDtHms(JSPUtil.getParameter(request, "dor_nod_pln_dt_hms".trim(), ""));
			event.setDorNodCd(JSPUtil.getParameter(request, "dor_nod_cd".trim(), ""));
			event.setDorNodYard(JSPUtil.getParameter(request, "dor_nod_yard".trim(), ""));
			event.setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd".trim(), ""));
			event.setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd".trim(), ""));
			
		}else if(command.isCommand(FormCommand.SEARCH03)){
			//Matchmaking Two Popup- Service Order Office 조회시 팝업(ESD_TRS_0964)
			event.setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd".trim(), ""));
		}
		
		return event;		
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