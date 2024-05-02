/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0044HTMLAction.java
*@FileTitle : Receivable Invoice - Container List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.09 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceCostVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.SearchParamVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.lse.containerleasemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ContainerLeaseMgtSC로 실행요청<br>
 * - ContainerRentalCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jang Jun-Woo
 * @see EesLse0044Event 참조
 * @since J2EE 1.6
 */

public class EES_LSE_0044HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_LSE_0044HTMLAction 객체를 생성
	 */
	public EES_LSE_0044HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ContainerLeaseMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EesLse0044Event event = new EesLse0044Event();		

		switch(command.getCommand()) {			
			case FormCommand.SEARCH :	//목록조회	
				event.setSearchParamVO((SearchParamVO)getVO(request, SearchParamVO.class));
				break;
			case FormCommand.MULTI :	//목록저장
				event.setReceivableInvoiceCostVOs((ReceivableInvoiceCostVO[])getVOs(request, ReceivableInvoiceCostVO.class));
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