/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0016HTMLAction.java
*@FileTitle : Charterer's Account
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.13
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.13 정윤태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondCharterInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSdmsSettlementVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - OPUS.APP-INF.src.com.clt.apps.opus.esm.fms.timecharterinoutaccounting 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TimeCharterInOutAccountingSC로 실행요청<br>
 * - TimeCharterInOutAccountingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author JUNGINSUN
 * @see EsmFms0016Event 참조
 * @since J2EE 1.5
 */

public class ESM_FMS_0016HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_FMS_0016HTMLAction 객체를 생성
	 */
	public ESM_FMS_0016HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TimeCharterInOutAccountingEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmFms0016Event event = new EsmFms0016Event();
		
		String inv_prefix = "inv_";
		String sdms_prefix = "sdms_";
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setCondCharterInvoiceVO((CondCharterInvoiceVO)getVO(request, CondCharterInvoiceVO.class));
			
			event.setCustomInvoiceVO((CustomInvoiceVO)getVO(request, CustomInvoiceVO.class));
			event.setCustomInvDtlVOS((CustomInvDtlVO[])getVOs(request, CustomInvDtlVO.class, inv_prefix));
			event.setCustomSdmsSettlementVOS((CustomSdmsSettlementVO[])getVOs(request, CustomSdmsSettlementVO.class, sdms_prefix));
			
		} else if(command.isCommand(FormCommand.SEARCH)) {
			event.setCondCharterInvoiceVO((CondCharterInvoiceVO)getVO(request, CondCharterInvoiceVO.class));
			
		} else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setFletCtrtNo(request.getParameter("flet_ctrt_no"));
			event.setRevYrmon(request.getParameter("rev_yrmon"));
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