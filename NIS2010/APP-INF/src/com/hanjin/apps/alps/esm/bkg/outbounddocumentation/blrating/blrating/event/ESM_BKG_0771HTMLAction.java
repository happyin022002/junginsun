/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0771HTMLAction.java
*@FileTitle : Covered B/L
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.07.08 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CoveredBlListVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BlRatingSC로 실행요청<br>
 * - BlRatingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Jin Seo
 * @see BlRatingEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0771HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0771HTMLAction 객체를 생성
	 */
	public ESM_BKG_0771HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BlRatingEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0771Event event = new EsmBkg0771Event();
		log.debug("::CALL:: ESM_BKG_0771HTMLAction : " + command.getCommand());
		
		if(command.isCommand(FormCommand.SEARCH)) {
			String bkg_no = JSPUtil.getParameter(request, "bkg_no");
			String bl_no = JSPUtil.getParameter(request, "bl_no");

			event.setBkg_no(bkg_no);
			event.setBl_no(bl_no);
			
		}else if(command.isCommand(FormCommand.MULTI)) {
			String bkg_no = JSPUtil.getParameter(request, "bkg_no");
			String bl_no = JSPUtil.getParameter(request, "bl_no");
			CoveredBlListVO[] coveredBlListVOs 	= (CoveredBlListVO[])getVOs(request, CoveredBlListVO .class,"sheet1_");
			
			event.setBkg_no(bkg_no);
			event.setBl_no(bl_no);
			event.setCoveredBlListVOs(coveredBlListVOs);
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