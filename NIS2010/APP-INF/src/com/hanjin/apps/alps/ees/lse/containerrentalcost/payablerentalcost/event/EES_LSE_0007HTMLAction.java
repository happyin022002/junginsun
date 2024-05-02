/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0007HTMLAction.java
*@FileTitle : Container Rental Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.09.10 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostCreatVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostInvoiceCreateVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostVO;
import com.hanjin.framework.component.util.StringUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.lse.containerrentalcost 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ContainerRentalCostSC로 실행요청<br>
 * - ContainerRentalCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Nho Jung Yong
 * @see ContainerRentalCostEvent 참조
 * @since J2EE 1.6
 */

public class EES_LSE_0007HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_LSE_0007HTMLAction 객체를 생성
	 */
	public EES_LSE_0007HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ContainerRentalCostEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EesLse0007Event event = new EesLse0007Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			PayableRentalCostVO payableRentalCostVO = new PayableRentalCostVO();

			payableRentalCostVO.setChgCostYrmon(StringUtil.replace(request.getParameter("chg_cost_yrmon").trim(),"-",""));
			payableRentalCostVO.setVndrSeq(request.getParameter("vndr_seq").trim());
			payableRentalCostVO.setLstmCd(request.getParameter("lstm_cd").trim());

			event.setPayableRentalCostVO(payableRentalCostVO);
		} else if( command.isCommand(FormCommand.COMMAND01)
				|| command.isCommand(FormCommand.COMMAND02) ) {
			PayableRentalCostVO payableRentalCostVO = new PayableRentalCostVO();

			payableRentalCostVO.setChgCostYrmon(StringUtil.replace(request.getParameter("chg_cost_yrmon"),"-",""));
			payableRentalCostVO.setPayableRentalCostCreatVO((PayableRentalCostCreatVO[])getVOs(request, PayableRentalCostCreatVO.class, "sheet1_"));

			event.setPayableRentalCostVO(payableRentalCostVO);
		} else if ( command.isCommand(FormCommand.COMMAND03) ) {
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
		} else if ( command.isCommand(FormCommand.COMMAND04) ) {
			PayableRentalCostVO payableRentalCostVO = new PayableRentalCostVO();

			payableRentalCostVO.setRentalCostCreatVO((PayableRentalCostCreatVO)getVO(request, PayableRentalCostCreatVO.class));

			event.setPayableRentalCostVO(payableRentalCostVO);
		} else if ( command.isCommand(FormCommand.COMMAND05) ) {
			PayableRentalCostVO payableRentalCostVO = new PayableRentalCostVO();

			payableRentalCostVO.setChgSeq(request.getParameter("chg_seq"));

			event.setPayableRentalCostVO(payableRentalCostVO);
		} else if ( command.isCommand(FormCommand.COMMAND06) ) {
			PayableRentalCostVO payableRentalCostVO = new PayableRentalCostVO();

			payableRentalCostVO.setChgCostYrmon(StringUtil.replace(request.getParameter("chg_cost_yrmon").trim(),"-",""));
			payableRentalCostVO.setVndrSeq(request.getParameter("vndr_seq").trim());
			payableRentalCostVO.setRentalCostCreatVO((PayableRentalCostCreatVO)getVO(request, PayableRentalCostCreatVO.class));
			payableRentalCostVO.setPayableRentalCostCreatVO((PayableRentalCostCreatVO[])getVOs(request, PayableRentalCostCreatVO.class, "sheet2_"));
			payableRentalCostVO.setArrPayableRentalCostInvoiceCreateVO((PayableRentalCostInvoiceCreateVO[])getVOs(request, PayableRentalCostInvoiceCreateVO.class, "sheet3_"));

			event.setPayableRentalCostVO(payableRentalCostVO);
		}

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