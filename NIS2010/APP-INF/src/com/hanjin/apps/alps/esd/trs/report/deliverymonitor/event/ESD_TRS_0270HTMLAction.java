/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_TRS_0270HTMLAction.java
*@FileTitle : Delivery Monitoring Detail
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.deliverymonitor.event;


import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.codemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_080SC로 실행요청<br>
 * - ESD_TRS_3023SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 
 * @see EsdTrs0270Event 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0270HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_3023HTMLAction 객체를 생성
	 */
	public ESD_TRS_0270HTMLAction(){}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_080Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
public Event perform(HttpServletRequest request) throws HTMLActionException {

    	EsdTrs0270Event event = new EsdTrs0270Event();    	
    	event.setsFromDt(JSPUtil.getParameter(request,"s_fm_dt",""));
    	event.setsToDt(JSPUtil.getParameter(request,"s_to_dt",""));
    	event.setsOfcCd(JSPUtil.getParameter(request,"s_so_ofc_cd",""));
    	
    	event.setsBndCd(JSPUtil.getParameter(request,"s_bnd_cd",""));
    	event.setsDoYn(JSPUtil.getParameter(request,"s_do_yn",""));
    	event.setsStsCd(JSPUtil.getParameter(request,"s_sts_cd",""));
    	event.setsBkgNo(JSPUtil.getParameter(request,"s_bkg_no",""));
    	event.setsCntrNo(JSPUtil.getParameter(request,"s_cntr_no",""));
    	event.setsSoNo(JSPUtil.getParameter(request,"s_so_no",""));
    	event.setsWoNo(JSPUtil.getParameter(request,"s_wo_no",""));
    	event.setsFmLoc(JSPUtil.getParameter(request,"s_fm_nod_cd",""));
    	event.setsViaLoc(JSPUtil.getParameter(request,"s_via_nod_cd",""));
    	event.setsToLoc(JSPUtil.getParameter(request,"s_to_nod_cd",""));
    	event.setsDrLoc(JSPUtil.getParameter(request,"s_dor_nod_cd",""));
    	event.setsSoTpCd(JSPUtil.getParameter(request,"s_so_tp_cd",""));
    	event.setsYrWeek(JSPUtil.getParameter(request,"s_yr_week",""));
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