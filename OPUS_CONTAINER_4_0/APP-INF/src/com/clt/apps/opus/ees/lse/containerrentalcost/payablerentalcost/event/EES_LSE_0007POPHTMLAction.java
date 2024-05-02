/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0007POPHTMLAction.java
*@FileTitle : Container Rental Charge Creation Audit & Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.09.30 노정용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostAuditSearchVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostAuditVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.lse.containerrentalcost 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ContainerRentalCostSC로 실행요청<br>
 * - ContainerRentalCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Nho Jung Yong
 * @see ContainerRentalCostEvent 참조
 * @since J2EE 1.6
 */

public class EES_LSE_0007POPHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_LSE_0007POPHTMLAction 객체를 생성
	 */
	public EES_LSE_0007POPHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ContainerRentalCostEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
    	EesLse0007PopEvent event = new EesLse0007PopEvent();
    	PayableRentalCostVO payableRentalCostVO = new PayableRentalCostVO();

		if(command.isCommand(FormCommand.SEARCH)) {
			payableRentalCostVO.setPayableRentalCostAuditSearchVO((PayableRentalCostAuditSearchVO)getVO(request, PayableRentalCostAuditSearchVO.class));
		} else if(command.isCommand(FormCommand.MULTI)) {
			payableRentalCostVO.setChgSeq(request.getParameter("chg_seq"));
			payableRentalCostVO.setAgmtCtyCd(request.getParameter("agmt_cty_cd"));
			payableRentalCostVO.setAgmtSeq(request.getParameter("agmt_seq"));
			payableRentalCostVO.setPayableRentalCostAuditVO((PayableRentalCostAuditVO[])getVOs(request, PayableRentalCostAuditVO.class, "t1sheet1_"));
		} else if(command.isCommand(FormCommand.MULTI01)) {
			payableRentalCostVO.setPayableRentalCostAuditSearchVO((PayableRentalCostAuditSearchVO)getVO(request, PayableRentalCostAuditSearchVO.class));
		} else if (command.isCommand(FormCommand.COMMAND01)) {
			payableRentalCostVO.setPayableRentalCostAuditSearchVO((PayableRentalCostAuditSearchVO)getVO(request, PayableRentalCostAuditSearchVO.class));
		} else if (command.isCommand(FormCommand.COMMAND02) || command.isCommand(FormCommand.COMMAND03)) {
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
		}
		event.setPayableRentalCostVO(payableRentalCostVO);

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