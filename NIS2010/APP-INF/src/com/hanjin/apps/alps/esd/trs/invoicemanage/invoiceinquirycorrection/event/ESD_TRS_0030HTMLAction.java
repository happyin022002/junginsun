/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_030HTMLAction.java
*@FileTitle : Service Provider로부터 W/O실행 이후 비용 지불을 위한 Invoice를 일괄 Confirm하거나, Confirmed or Interfaced Invoice를 취소하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-26
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2007-01-26 poong_yeon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.vo.SearchInvoiceInquiryVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.syscommon.common.table.TrsTrspInvWrkVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.invoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InvoiceManageSC로 실행요청<br>
 * - InvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author poong_yeon
 * @see EsdTrs0030Event , ESD_TRS_030EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0030HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_030HTMLAction 객체를 생성
	 */
	public ESD_TRS_0030HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_030Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		
		EsdTrs0030Event event = new EsdTrs0030Event();
		
		event.setTrsTrspInvWrkVOs((TrsTrspInvWrkVO[])getVOs(request, TrsTrspInvWrkVO.class, ""));
		event.setSearchInvoiceInquiryVO((SearchInvoiceInquiryVO)getVO(request, SearchInvoiceInquiryVO.class));


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