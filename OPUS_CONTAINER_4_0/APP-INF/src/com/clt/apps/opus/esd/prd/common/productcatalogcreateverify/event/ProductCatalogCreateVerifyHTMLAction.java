/*=========================================================
 *	Copyright(c) 2006 CyberLogitec
 *	@FileName : ProductCatalogCreateVerifyHTMLAction.java
 *	@FileTitle :
 *	Open Issues :
 *	Change history :
 *	@LastModifyDate : 2008-07-09
 *	@LastModifier : jsy
 *	@LastVersion : 1.0
 * 	2008-07-09 jsy
 * 	1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.common.productcatalogcreateverify.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.prd.common.prdcommon.basic.PrdRequestEvent;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * 018 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * Parsing 한 정보를 Event로 변환, request에 담아 SC로 실행요청<br>
 * SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author sungseok, choi
 * @see COM_ENS_0C1Event , COM_ENS_0C1EventResponse 참조
 * @since J2EE 1.4
 */
public class ProductCatalogCreateVerifyHTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * @title ProductCatalogCreateVerifyHTMLAction Obejct Creation<br>
	 * @authorjsy
	 * @date 2008-07-09
	 */
	public ProductCatalogCreateVerifyHTMLAction() {
	}

	/**
	 * ProductCatalogCreateVerifyHTMLAction 객체를 생성
	 * 
	 * @param request
	 * @return
	 * @throws HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand f_cmd = FormCommand.fromRequest(request);

		ProductCatalogCreateVerifyEvent event = new ProductCatalogCreateVerifyEvent();

		event.setFormCommand(f_cmd);

		PrdRequestEvent prdEv = PrdRequestEvent.getInstance(request);

		log.debug("\n\n prdEv:=" + prdEv.toString());
		event.putValue("prdEv", prdEv);

		request.setAttribute("Event", event);

		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface를 구현한 객체
	 */
	@Override
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
