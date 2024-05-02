/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1079HTMLAction.java
*@FileTitle : Audit by CNTR Qty Discrepancy
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.19 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCNTRQtyDiscrepancyListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BkgRevUmchBkgVO;

/**
 * HTTP Parser<br>
* - com.clt.apps.opus.esm.bkg.revenueaudit 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RevenueAuditSC로 실행요청<br>
 * - RevenueAuditSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Day-Hoh, Kim
 * @see RevenueAuditEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_1079HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1079HTMLAction 객체를 생성
	 */
	public ESM_BKG_1079HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RevenueAuditEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1079Event event = new EsmBkg1079Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setRsltSearchAuditByCNTRQtyDiscrepancyListVO((RsltSearchAuditByCNTRQtyDiscrepancyListVO)getVO(request, RsltSearchAuditByCNTRQtyDiscrepancyListVO.class));
			log.debug("qwer qqq:"+event.getRsltSearchAuditByCNTRQtyDiscrepancyListVO().getCtrtCntrTpszCd());
		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			
		
			event.setRsltSearchAuditByCNTRQtyDiscrepancyListVOS((RsltSearchAuditByCNTRQtyDiscrepancyListVO[])getVOs(request, RsltSearchAuditByCNTRQtyDiscrepancyListVO.class, ""));
			
			
			
		}
		
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