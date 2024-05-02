/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_038HTMLAction.java
*@FileTitle : Rail Invoice Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-11
*@LastModifier : Kildong_hong
*@LastVersion : 1.0
* 2006-12-11 Kildong_hong
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.syscommon.common.table.TrsTrspRailInvDtlVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.invoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_038SC로 실행요청<br>
 * - ESD_TRS_038SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Kildong_hong
 * @see EsdTrs0038Event , ESD_TRS_038EventResponse 참조
 * @since J2EE 1.4
 */ 
public class ESD_TRS_0038HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_038HTMLAction 객체를 생성
	 */
	public ESD_TRS_0038HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_038Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EsdTrs0038Event event = new EsdTrs0038Event();		
		
		String invNo 		= JSPUtil.getNull(request.getParameter("inv_no"));
		String railRoadCode = JSPUtil.getNull(request.getParameter("rail_road_code"));
		String invVndrSeq = JSPUtil.getNull(request.getParameter("payment_vndr_code"));
		String invRecDt = JSPUtil.getNull(request.getParameter("receive_dt"));
		String invIssDt = JSPUtil.getNull(request.getParameter("issue_dt"));
		String invBacAmt = JSPUtil.getNull(request.getParameter("invoice_amt"));
		String invVatAmt = JSPUtil.getNull(request.getParameter("vat_amt"));
		String invTtlAmt = JSPUtil.getNull(request.getParameter("total_amt"));
		String sStsCd = JSPUtil.getNull(request.getParameter("sts_cd"));
		String invCurrCd = JSPUtil.getNull(request.getParameter("currency"));
		String sOfcCd = JSPUtil.getNull(request.getParameter("ofc_cd"));
		String sUsrId = JSPUtil.getNull(request.getParameter("usr_id"));
		String sSeq = JSPUtil.getNull(request.getParameter("seq"));
		String sCntrNo = JSPUtil.getNull(request.getParameter("cntr_no"));
		
		event.setTrsTrspRailInvDtlVos((TrsTrspRailInvDtlVO[])getVOs(request, TrsTrspRailInvDtlVO.class, ""));
		event.setInvNo(invNo);
		event.setRailRoadCode(railRoadCode);
		event.setInvVndrSeq(invVndrSeq);
		event.setInvRecDt(invRecDt);
		event.setInvIssDt(invIssDt);
		event.setInvBacAmt(invBacAmt);
		event.setInvVatAmt(invVatAmt);
		event.setInvTtlAmt(invTtlAmt);
		event.setSStsCd(sStsCd);
		event.setInvCurrCd(invCurrCd);
		event.setSOfcCd(sOfcCd);
		event.setSUsrId(sUsrId);
		event.setSSeq(sSeq);
		event.setSCntrNo(sCntrNo);
		
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