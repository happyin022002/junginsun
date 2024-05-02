/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0019HTMLAction.java
*@FileTitle : Receivable Charge & Invoice Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.08.24 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableChargeVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.SearchParamVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.lse.containerleasemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ContainerLeaseMgtSC로 실행요청<br>
 * - ContainerRentalCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jang Jun-Woo
 * @see EesLse0019Event 참조
 * @since J2EE 1.6
 */

public class EES_LSE_0019HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_LSE_0019HTMLAction 객체를 생성
	 */
	public EES_LSE_0019HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ContainerLeaseMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
    	EesLse0019Event event = new EesLse0019Event();

		switch(command.getCommand()) {
			case FormCommand.SEARCH :		//목록조회
			case FormCommand.SEARCH01 :		//조건체크
			case FormCommand.SEARCH02 :		//결과확인
			case FormCommand.SEARCH04 :		//선택조회
			case FormCommand.SEARCH05 :		//내용확인
			case FormCommand.COMMAND01 :	//저장-Preparation
				event.setSearchParamVO((SearchParamVO)getVO(request, SearchParamVO.class));
				break;
			case FormCommand.SEARCH03 :		//Invoice No 조회
				event.setQtyYrmon(request.getParameter("qty_yrmon").replaceAll("-", ""));
				break;
			case FormCommand.SEARCH06 :		//유효성 검증
				event.setAgmtSeq(request.getParameter("agmt_seq"));
				event.setQtyYrmon(request.getParameter("qty_yrmon"));
				break;
			case FormCommand.MULTI01 :	//저장-Charge Creation
			case FormCommand.MULTI02 :	//저장-RE Creation
				event.setReceivableChargeVOs((ReceivableChargeVO[])getVOs(request, ReceivableChargeVO.class, "sheet1_"));
				break;
			case FormCommand.MULTI03 :	//저장-Invoice Creation
			case FormCommand.MULTI04 :	//저장-Invoice Confirm
				event.setSearchParamVO((SearchParamVO)getVO(request, SearchParamVO.class));
				event.setReceivableInvoiceVOs((ReceivableInvoiceVO[])getVOs(request, ReceivableInvoiceVO.class, "sheet2_"));
				break;
			default :	//do nothing
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