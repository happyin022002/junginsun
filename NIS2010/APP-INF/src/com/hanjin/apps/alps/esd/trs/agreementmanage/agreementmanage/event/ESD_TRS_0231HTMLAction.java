/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : ESD_TRS_0231HTMLAction.java
 *@FileTitle : Agreement Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011-05-11
 *@LastModifier : 민정호
 *@LastVersion : 1.1
 * 2010-03-26 jong hyek choi
 * 1.0 최초 생성
 * 
 * 1.1 2011.05.11 민정호 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
 * 1.2 2011.06.29 민정호 [CHM-201111442] R9 CNTR 추가관련 로직 변경요청
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
 * @see EsdTrs0231Event , ESD_TRS_0231EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0231HTMLAction extends HTMLActionSupport {
	/**
	 * ESD_TRS_0231HTMLAction 객체를 생성
	 */
	public ESD_TRS_0231HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_0231Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
//		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0231Event event = new EsdTrs0231Event();

		String search_fm_loc    = request.getParameter("search_fm_loc")!=null?request.getParameter("search_fm_loc"):"";
		String search_fm_yard   = request.getParameter("search_fm_yard")!= null?request.getParameter("search_fm_yard"):"";
		String search_via_loc   = request.getParameter("search_via_loc")!= null?request.getParameter("search_via_loc"):"";
		String search_via_yard  = request.getParameter("search_via_yard")!=null?request.getParameter("search_via_yard"):"";
		String search_door_loc  = request.getParameter("search_door_loc")!=null?request.getParameter("search_door_loc"):"";
		String search_door_yard = request.getParameter("search_door_yard")!=null?request.getParameter("search_door_yard"):"";
		String search_to_loc    = request.getParameter("search_to_loc")!=null?request.getParameter("search_to_loc"):"";
		String search_to_yard   = request.getParameter("search_to_yard")!=null?request.getParameter("search_to_yard"):"";
		String costmode         = request.getParameter("costmode")!=null?request.getParameter("costmode"):"";
		String cargo            = request.getParameter("cargo")!=null?request.getParameter("cargo"):"";
		String eqtype           = request.getParameter("eqtype")!=null?request.getParameter("eqtype"):"";
		String eqtpsz           = request.getParameter("eqtpsz")!=null?request.getParameter("eqtpsz"):"";
		String fmAgmtTrspTpCd   = request.getParameter("fm_agmt_trsp_tp_cd")!=null?request.getParameter("fm_agmt_trsp_tp_cd"):"";
		String fmEffectiveAgmt  = request.getParameter("fm_effective_agmt")!=null?request.getParameter("fm_effective_agmt"):"";
		String fmVndrPrmrySeq   = request.getParameter("fm_vndr_prmry_seq")!=null?request.getParameter("fm_vndr_prmry_seq"):"";
		String curPageCnt       = request.getParameter("cur_page_cnt")!=null?request.getParameter("cur_page_cnt"):"";
		String pageSize         = request.getParameter("page_size")!=null?request.getParameter("page_size"):"";
		String fmAgmtno			= request.getParameter("fm_agmtno")!=null?request.getParameter("fm_agmtno"):"";
		String effectiveDate    = request.getParameter("effective_date")!=null?request.getParameter("effective_date"):"";
		String curPageCnt2      = request.getParameter("cur_page_cnt2")!=null?request.getParameter("cur_page_cnt2"):"";
		String pageSize2        = request.getParameter("page_size2")!=null?request.getParameter("page_size2"):"";
		String deleteYn         = request.getParameter("delete_yn")!=null?request.getParameter("delete_yn"):"";
		String approvalDate     = request.getParameter("approval_date")!=null?request.getParameter("approval_date"):"";

		event.setSearch_fm_loc    (search_fm_loc);
		event.setSearch_fm_yard   (search_fm_yard);
		event.setSearch_via_loc   (search_via_loc);
		event.setSearch_via_yard  (search_via_yard);
		event.setSearch_door_loc  (search_door_loc);
		event.setSearch_door_yard (search_door_yard);
		event.setSearch_to_loc    (search_to_loc);
		event.setSearch_to_yard   (search_to_yard);
		event.setCostmode         (costmode);
		event.setCargo            (cargo);
		event.setEqtype           (eqtype);
		event.setEqtpsz           (eqtpsz);
		event.setFmAgmtTrspTpCd   (fmAgmtTrspTpCd);
		event.setFmEffectiveAgmt  (fmEffectiveAgmt);
		event.setFmVndrPrmrySeq   (fmVndrPrmrySeq);
		event.setCurPageCnt       (curPageCnt);
		event.setPageSize         (pageSize);
		event.setFmAgmtno		  (fmAgmtno);
		event.setEffectiveDate	  (effectiveDate);
		event.setCurPageCnt2      (curPageCnt2);
		event.setPageSize2        (pageSize2);
		event.setDeleteYn         (deleteYn);
		event.setApprovalDate	  (approvalDate);
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