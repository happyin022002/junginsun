/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_040HTMLAction.java
*@FileTitle : Service Porvider로 부터 접수한 Refund Invoice 를 Audit 하고 수정하여 Confirm 하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-18
*@LastModifier : chkong
*@LastVersion : 1.0
* 2007-01-18 chkong
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.syscommon.common.table.TrsTrspRfndInvVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_040SC로 실행요청<br>
 * - ESD_TRS_040SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author chkong
 * @see EsdTrs0040Event , ESD_TRS_040EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0040HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_040HTMLAction 객체를 생성
	 */
	public ESD_TRS_0040HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_040Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
	
		TrsTrspRfndInvVO trsTrspRfndInvVO = new TrsTrspRfndInvVO();
		EsdTrs0040Event event = new EsdTrs0040Event();
		event.setTrsTrspRfndInvVOs(trsTrspRfndInvVO.fromRequestGrid(request));
		
		request.setAttribute("Event", event);
		event.setInv_no(JSPUtil.getNull(request.getParameter("inv_no")));
		event.setInv_curr_cd(JSPUtil.getNull(request.getParameter("inv_curr_cd")));
		event.setInv_whld_tax_amt(JSPUtil.getNull(request.getParameter("inv_whld_tax_amt")));
		event.setInsflag(JSPUtil.getNull(request.getParameter("insflag")));
		event.setPaymt_sp_cd(JSPUtil.getNull(request.getParameter("paymt_sp_cd")));
		event.setUsr_id(JSPUtil.getNull(request.getParameter("usr_id")));
		event.setOfc_cd(JSPUtil.getNull(request.getParameter("ofc_cd")));
		event.setCombo_svc_provider(JSPUtil.getNull(request.getParameter("combo_svc_provider")));
		event.setInv_rcv_dt(JSPUtil.getNull(request.getParameter("inv_rcv_dt")));
		event.setInv_iss_dt(JSPUtil.getNull(request.getParameter("inv_iss_dt")));
		event.setInv_bzc_amt(JSPUtil.getNull(request.getParameter("inv_bzc_amt")));
		event.setInv_vat_amt(JSPUtil.getNull(request.getParameter("inv_vat_amt")));
		event.setInv_ttl_amt(JSPUtil.getNull(request.getParameter("inv_ttl_amt")));

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