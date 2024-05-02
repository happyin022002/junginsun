/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0014HTMLAction.java
*@FileTitle : Service Order 생성화면 - Chassis or Genset
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.04
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2006.10.04 조풍연
* 1.0 최초 생성
* ----------------------------------------------------------
* History
* 2011.01.04 최 선         1.1 [CHM-201108174] Report 화면 중 S/P code 선택 시 오류팝업 수정요청
=========================================================*/
package com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.vo.ChassisGensetVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.chassisgensetsomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ChassisGensetSOManageSC로 실행요청<br>
 * - ChassisGensetSOManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author poong
 * @see EsdTrs0014Event , ESD_TRS_0014EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0014HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_014HTMLAction 객체를 생성
	 */
	public ESD_TRS_0014HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_014Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		ChassisGensetVO[] chassisGensetVOs = (new ChassisGensetVO()).fromRequestGrid(request);
		EsdTrs0014Event event = new EsdTrs0014Event();

		event.setChassisGensetVOs(chassisGensetVOs); //Correction, Delete

		event.setComboSvcProvider		(JSPUtil.getParameter(request, "combo_svc_provider", ""));
		event.setComboSvcProviderChld	(JSPUtil.getParameter(request, "combo_svc_provider_chld", ""));
		event.setComboSvcProviderPrnt	(JSPUtil.getParameter(request, "combo_svc_provider_prnt", ""));
		event.setFormUsrId				(JSPUtil.getParameter(request, "FORM_CRE_USR_ID", ""));
		event.setFormUsrOfcCd			(JSPUtil.getParameter(request, "FORM_USR_OFC_CD", "")); 	
		event.setFmdate					(JSPUtil.getParameter(request, "fmdate", ""));
		event.setTodate					(JSPUtil.getParameter(request, "todate", ""));
		event.setKndChassis				(JSPUtil.getParameter(request, "kind_chassis", ""));  	
		event.setTrsTpCd				(JSPUtil.getParameter(request, "trs_tp_cd", ""));		
		event.setSearchFmLoc			(JSPUtil.getParameter(request, "search_fm_loc", "")); 
		event.setSearchFmYard			(JSPUtil.getParameter(request, "search_fm_yard", ""));
		event.setSearchToLoc			(JSPUtil.getParameter(request, "search_to_loc", ""));
		event.setSearchToYard			(JSPUtil.getParameter(request, "search_to_yard", ""));
		event.setTrsMdCd				(JSPUtil.getParameter(request, "trs_md_cd", ""));
		event.setFormEqNo				(JSPUtil.getParameter(request, "form_eq_no", ""));
		event.setEqNo					(JSPUtil.getParameter(request, "eq_no", ""));
		event.setHireLoc				(JSPUtil.getParameter(request, "hire_loc", ""));
		event.setHireYd					(JSPUtil.getParameter(request, "hire_yd", ""));
		event.setKindHire				(JSPUtil.getParameter(request, "kind_hire", ""));
		event.setSoTpCd					(JSPUtil.getParameter(request, "TRSP_SO_TP_CD", ""));
		event.setSoStsCd				(JSPUtil.getParameter(request, "TRSP_SO_STS_CD", ""));
		event.setEqTpszCd				(JSPUtil.getParameter(request, "EQ_TPSZ_CD", ""));
		event.setVndrCntCd				(JSPUtil.getParameter(request, "VNDR_CNT_CD", ""));
		event.setVndrComboSearchBound	(JSPUtil.getParameter(request, "VNDR_COMBO_SEARCH_BOUND", ""));
		event.setRow					(JSPUtil.getParameter(request, "row", ""));
		request.setAttribute("Event", event);
		
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