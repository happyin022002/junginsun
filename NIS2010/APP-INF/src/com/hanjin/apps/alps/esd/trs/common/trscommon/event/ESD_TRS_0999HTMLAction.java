/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_TRS_0999HTMLAction.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.19
*@LastModifier : 유선오
*@LastVersion : 1.4
* 2011.02.10 민정호
* 1.0 Creation
* -----------------------------------------------------------
* * History
* 1.0 2011.02.10 민정호 [CHM-201108602] [TRS]미주지역 Appt./Deli. time update 기능 추가
* 1.1 2011.02.18  손은주 [CHM-201108834-01]	[TRS] Rail performance Report 부분의 주 단위 data 조회기능 추가 요청- 월별 주차별 검색기간 추가
* 1.2 2011.03.28 손은주 [CHM-201109560-01] Split 04-Intra - Europe Business 관련 VAT 기능 개발 - 대륙코드 조회 추가
* 1.3 2011.08.31 유선오 [CHM-201112874] OTHER S/O Creation 화면상 오류 수정요청
* 1.4 2011.10.19 유선오 [CHM-201112874] OTHER S/O Creation 화면상 오류 수정요청
* 2012.01.06 김종호 [CHM-201109410] [TRS] CNTR No. 유효성에 대한 Validation 절차 추가요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.trscommon.event;

import javax.servlet.http.HttpServletRequest;


import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.common 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CommonSC로 실행요청<br>
 * - CommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Min Jung Ho
 * @see CommonEvent 참조
 * @since J2EE 1.6
 */

public class ESD_TRS_0999HTMLAction extends HTMLActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_0999HTMLAction 객체를 생성
	 */
	public ESD_TRS_0999HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {		
		EsdTrs0999Event event = new EsdTrs0999Event();
		
		FormCommand   command = FormCommand.fromRequest(request);
		String custCd = request.getParameter("input_cust_cd");
        if (command.isCommand(FormCommand.SEARCH02)) {
        	event.setFChkPrd(JSPUtil.getParameter(request, "f_chkprd", ""));
        	event.setFYear(JSPUtil.getParameter(request, "f_year", ""));
        	event.setFFmMon(JSPUtil.getParameter(request, "f_fm_mon", ""));
        	event.setFToMon(JSPUtil.getParameter(request, "f_to_mon", ""));
        	event.setFFmWk(JSPUtil.getParameter(request, "f_fm_wk", ""));
        	event.setFToWk(JSPUtil.getParameter(request, "f_to_wk", ""));	
        }else if (command.isCommand(FormCommand.SEARCH03)) {
        	event.setOfcCd(JSPUtil.getParameter(request, "FORM_USR_OFC_CD", ""));
        }else if (command.isCommand(FormCommand.SEARCH04)) {
        	event.setCmdtCd(JSPUtil.getParameter(request, "commodity_cd", ""));
        }else if (command.isCommand(FormCommand.SEARCH05)) {
        	custCd = (custCd !=null)?custCd.toUpperCase():custCd;
        	event.setCustCd(custCd);        	
        }else if (command.isCommand(FormCommand.SEARCH07)){ // CNTR Validation
			event.setTrsTrspSvcOrdVOS((TrsTrspSvcOrdVO[])getVOs(request, TrsTrspSvcOrdVO.class, ""));
			event.setRow(JSPUtil.getParameter(request, "row", ""));
        }else if (command.isCommand(FormCommand.SEARCH08)) {
        	event.setFChkPrd(JSPUtil.getParameter(request, "f_chkprd", ""));
        	event.setFYear(JSPUtil.getParameter(request, "f_year", ""));
        	event.setIFmWm(JSPUtil.getParameter(request, "i_fm_wm", ""));
        	event.setIToWm(JSPUtil.getParameter(request, "i_to_wm", ""));
        }
        event.setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));

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