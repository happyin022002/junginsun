/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9191HTMLAction.java
*@FileTitle : R/H된 Volume Adjustment Inquiry PopUp 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-10-30
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2007-10-30 kimjinjoo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;
import com.clt.syscommon.common.table.TesTmlSoRvisListVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ServiceProviderInvoiceManageSC로 실행요청<br>
 * - ServiceProviderInvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author parkyeonjin
 * @see EsdTes9191Event , ESD_TES_9191EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TES_9191HTMLAction extends HTMLActionSupport {
	/**
	 * ESD_TES_9191HTMLAction 객체를 생성
	 */
	public ESD_TES_9191HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TES_9191Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EsdTes9191Event event = new EsdTes9191Event();
		event.setTesTmlSoHdrVO((TesTmlSoHdrVO)getVO(request, TesTmlSoHdrVO .class));
		event.setTesTmlSoRvisListVO((TesTmlSoRvisListVO)getVO(request, TesTmlSoRvisListVO .class));
		event.setTesCommonVo((TesCommonVO)getVO(request, TesCommonVO .class));
		
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