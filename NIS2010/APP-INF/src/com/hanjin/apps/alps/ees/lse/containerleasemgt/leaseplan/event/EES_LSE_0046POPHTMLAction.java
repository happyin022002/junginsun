/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0008POPHTMLAction.java
*@FileTitle : Invoice File Data Inquery
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.09.23 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePlanSearchVO;
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

public class EES_LSE_0046POPHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_LSE_0008HTMLAction 객체를 생성
	 */
	public EES_LSE_0046POPHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ContainerRentalCostEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EesLse0046PopEvent event = new EesLse0046PopEvent();
    	OffHirePlanSearchVO offHirePlanSearchVO = new OffHirePlanSearchVO();
		
		if ( command.isCommand(FormCommand.SEARCH)) {
			offHirePlanSearchVO.setLocTp(request.getParameter("loc_tp").trim());
			offHirePlanSearchVO.setLocCd(request.getParameter("loc_cd").trim());
			offHirePlanSearchVO.setLstmCd(request.getParameter("lstm_cd").trim());
			offHirePlanSearchVO.setCntrTpszCd(request.getParameter("cntr_tpsz_cd").trim());
		}

		event.setOffHirePlanSearchVO(offHirePlanSearchVO);

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