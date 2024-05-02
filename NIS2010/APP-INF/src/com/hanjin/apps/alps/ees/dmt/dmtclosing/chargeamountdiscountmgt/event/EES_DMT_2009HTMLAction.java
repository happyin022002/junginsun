/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2009HTMLAction.java
*@FileTitle : DEM/DET Adjustment Request - After Booking Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.09.21 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGCNTRRequestVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGRequestVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterProgressVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerParmVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.dmt.dmtclosing 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DMTClosingSC로 실행요청<br>
 * - DMTClosingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SungHoon, Lee
 * @see DMTClosingEvent 참조
 * @since J2EE 1.6
 */

public class EES_DMT_2009HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_DMT_2008HTMLAction 객체를 생성
	 */
	public EES_DMT_2009HTMLAction() {}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DMTClosingEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EesDmt2009Event event = new EesDmt2009Event();
		
		//Request Detail 조회
		if (command.isCommand(FormCommand.SEARCH)) {
			event.setAfterBKGListInputVO((AfterBKGListInputVO)getVO(request, AfterBKGListInputVO .class));
		}
		//searchChargeByBooking
		else if (command.isCommand(FormCommand.SEARCH01)) {
			event.setChargeBookingContainerParmVO((ChargeBookingContainerParmVO)getVO(request, ChargeBookingContainerParmVO .class));
		}		
		//searchBookingData
		else if (command.isCommand(FormCommand.SEARCH02)) {
			event.setAfterBKGDetailInputVO((AfterBKGDetailInputVO)getVO(request, AfterBKGDetailInputVO .class));
		}
		//searchCommentHistory
		else if (command.isCommand(FormCommand.SEARCH03)) {
			event.setAfterBKGListInputVO((AfterBKGListInputVO)getVO(request, AfterBKGListInputVO .class));
		}
		//checkCalcuationType
		else if (command.isCommand(FormCommand.SEARCH04)) {
			event.setAfterBKGListInputVO((AfterBKGListInputVO)getVO(request, AfterBKGListInputVO .class));
		}
		//checkDupTariffBKGBLNo
		else if (command.isCommand(FormCommand.SEARCH05)) {
			event.setAfterBKGListInputVO((AfterBKGListInputVO)getVO(request, AfterBKGListInputVO .class));
		}
		//checkBalanceCharge
		else if (command.isCommand(FormCommand.SEARCH06)) {
			event.setAfterBKGListInputVO((AfterBKGListInputVO)getVO(request, AfterBKGListInputVO .class));
		}
		//Cancel
		else if (command.isCommand(FormCommand.SEARCH08)) {
			event.setAfterProgressVO((AfterProgressVO)getVO(request, AfterProgressVO .class));
		}
		//Approval
		else if (command.isCommand(FormCommand.SEARCH09)) {
			event.setAfterProgressVO((AfterProgressVO)getVO(request, AfterProgressVO .class));
		}	
		//Counter Offer
		else if (command.isCommand(FormCommand.SEARCH10)) {
			event.setAfterProgressVO((AfterProgressVO)getVO(request, AfterProgressVO .class));
		}	
		//Reject
		else if (command.isCommand(FormCommand.SEARCH11)) {
			event.setAfterProgressVO((AfterProgressVO)getVO(request, AfterProgressVO .class));
		}			
		//requestAfterBookingDAR
		else if (command.isCommand(FormCommand.MULTI)) {
			//Comment History
			event.setAfterProgressVO((AfterProgressVO)getVO(request, AfterProgressVO .class));
			
			AfterBKGRequestVO afterBKGRequestVO = new AfterBKGRequestVO();
			event.setAfterBKGRequestVOS(afterBKGRequestVO.fromRequestGrid(request, "subBKG"));
			
			AfterBKGCNTRRequestVO afterBKGCNTRRequestVO = new AfterBKGCNTRRequestVO();
			event.setAfterBKGCNTRRequestVOS(afterBKGCNTRRequestVO.fromRequestGrid(request, "subBKGCNTR"));			
		}
		else if (command.isCommand(FormCommand.COMMAND01)) {
			event.setAfterProgressVO((AfterProgressVO)getVO(request, AfterProgressVO .class));
			
			AfterBKGRequestVO afterBKGRequestVO = new AfterBKGRequestVO();
			event.setAfterBKGRequestVOS(afterBKGRequestVO.fromRequestGrid(request, "subBKG"));
			
			AfterBKGCNTRRequestVO afterBKGCNTRRequestVO = new AfterBKGCNTRRequestVO();
			event.setAfterBKGCNTRRequestVOS(afterBKGCNTRRequestVO.fromRequestGrid(request, "subBKGCNTR"));			
		}
		else if (command.isCommand(FormCommand.COMMAND02)) {
			event.setAfterProgressVO((AfterProgressVO)getVO(request, AfterProgressVO .class));
		}
		else if (command.isCommand(FormCommand.COMMAND03)) {
			event.setAfterProgressVO((AfterProgressVO)getVO(request, AfterProgressVO .class));
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
