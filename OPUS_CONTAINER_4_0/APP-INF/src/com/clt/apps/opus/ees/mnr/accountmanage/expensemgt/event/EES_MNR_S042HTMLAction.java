/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_S042HTMLAction.java
*@FileTitle : MNR Invoice Creation & Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.08.17 함형석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.CustomPayableINVInquiryListVO;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.PayableINVInquiryINVO;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.PayableInvoiceGRPVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.mnr.accountmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountManageSC로 실행요청<br>
 * - AccountManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 함형석
 * @see AccountManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_MNR_S042HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_S042HTMLAction 객체를 생성
	 */
	public EES_MNR_S042HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMnrS042Event event = new EesMnrS042Event();
		
		PayableInvoiceGRPVO payableInvoiceGRPVO = new PayableInvoiceGRPVO();
		//조회 리스트
		if(command.isCommand(FormCommand.SEARCH)) {
			payableInvoiceGRPVO.setPayableINVInquiryINVO((PayableINVInquiryINVO)getVO(request, PayableINVInquiryINVO.class));
		} 
		//Detail 조회 리스트
		else if(command.isCommand(FormCommand.SEARCH01)) {
			payableInvoiceGRPVO.setPayableINVInquiryINVO((PayableINVInquiryINVO)getVO(request, PayableINVInquiryINVO .class));
			payableInvoiceGRPVO.setArrayCustomPayableINVInquiryListVOs((CustomPayableINVInquiryListVO[])getVOs(request, CustomPayableINVInquiryListVO.class));
		}		
		event.setPayableInvoiceGRPVO(payableInvoiceGRPVO);

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