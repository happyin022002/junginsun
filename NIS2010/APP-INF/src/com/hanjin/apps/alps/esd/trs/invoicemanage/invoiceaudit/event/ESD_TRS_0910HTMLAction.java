/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_910HTMLAction.java
*@FileTitle : Currency Change Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-06
*@LastModifier : Lee_SangWoo
*@LastVersion : 1.0
* 2006-12-06 Lee_SangWoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0910Event;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.syscommon.common.table.TrsTrspScgDtlVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.invoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InvoiceManageSC로 실행요청<br>
 * - InvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Lee_SangWoo
 * @see EsdTrs0910Event , ESD_TRS_910EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0910HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_910HTMLAction 객체를 생성
	 */
	public ESD_TRS_0910HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_910Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
				
		TrsTrspScgDtlVO tableSingle = new TrsTrspScgDtlVO();
		tableSingle.fromRequest(request);
	
		EsdTrs0910Event event = new EsdTrs0910Event(); 
		event.setTrsTrspScgDtlVO(tableSingle);
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