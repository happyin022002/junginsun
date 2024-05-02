/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0011HTMLAction.java
*@FileTitle : Operational Lease Payable Invoice Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.10.09 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostCreatVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostInvoiceCreateVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostOperationalInvoiceVO;
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

public class EES_LSE_0011HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_LSE_0011HTMLAction 객체를 생성
	 */
	public EES_LSE_0011HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ContainerRentalCostEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesLse0011Event event = new EesLse0011Event();
		
		if ( command.isCommand(FormCommand.MULTI) ) {
			PayableRentalCostVO payableRentalCostVO = new PayableRentalCostVO();
			payableRentalCostVO.setArrPayableRentalCostOperationalInvoiceVO((PayableRentalCostOperationalInvoiceVO[])getVOs(request, PayableRentalCostOperationalInvoiceVO.class,""));
			event.setPayableRentalCostVO(payableRentalCostVO);
		} else if(command.isCommand(FormCommand.SEARCH)) {
			event.setVndrSeq(request.getParameter("vndr_seq"));
			event.setBilFmDt(StringUtil.replace(request.getParameter("bil_fm_dt"),"-",""));
			event.setBilToDt(StringUtil.replace(request.getParameter("bil_to_dt"),"-",""));
		} else if(command.isCommand(FormCommand.COMMAND01)) {
			PayableRentalCostVO payableRentalCostVO = new PayableRentalCostVO();
			payableRentalCostVO.setRentalCostCreatVO((PayableRentalCostCreatVO)getVO(request, PayableRentalCostCreatVO.class));
			payableRentalCostVO.setArrPayableRentalCostOperationalInvoiceVO((PayableRentalCostOperationalInvoiceVO[])getVOs(request, PayableRentalCostOperationalInvoiceVO.class,"sheet1_"));
			payableRentalCostVO.setArrPayableRentalCostInvoiceCreateVO((PayableRentalCostInvoiceCreateVO[])getVOs(request, PayableRentalCostInvoiceCreateVO.class, "sheet2_"));
			event.setPayableRentalCostVO(payableRentalCostVO);
		} else if(command.isCommand(FormCommand.COMMAND02)) {
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
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