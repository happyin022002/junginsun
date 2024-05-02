/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0079_08HTMLAction.java
*@FileTitle : Freight & Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.26 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BlRatingSC로 실행요청<br>
 * - BlRatingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Jin Seo
 * @see BlRatingEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0079_08HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0079_08HTMLAction 객체를 생성
	 */
	public ESM_BKG_0079_08HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BlRatingEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg007908Event event = new EsmBkg007908Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			
			String bkg_no = JSPUtil.getParameter(request, "bkg_no");
			String bl_no = JSPUtil.getParameter(request, "bl_no");
			event.setBkg_no(bkg_no);
			event.setBl_no(bl_no);
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			RateMainInfoVO[] rateMainInfoVOs = (RateMainInfoVO[])getVOs(request, RateMainInfoVO.class,"t10sheet1_");
			BkgChgRateVO[] bkgChgRateVOs = (BkgChgRateVO[])getVOs(request, BkgChgRateVO.class,"t10sheet2_");
			BkgChgRateVO[] bkgChgRateHisVOs = (BkgChgRateVO[])getVOs(request, BkgChgRateVO.class,"t10sheet7_");
			String bkg_no = JSPUtil.getParameter(request, "bkg_no");
			String bl_no = JSPUtil.getParameter(request, "bl_no");
			String caflag = JSPUtil.getParameter(request, "caflag");
			String autoRate = JSPUtil.getParameter(request, "autoRate");
			String removeAll = JSPUtil.getParameter(request, "removeAll");
			String covered_bl = JSPUtil.getParameter(request, "covered_name_c");
			event.setBkg_no(bkg_no);
			event.setBl_no(bl_no);
			event.setCaflag(caflag);
			event.setAutoRate(autoRate);
			event.setRemoveAll(removeAll);
			event.setCovered_bl(covered_bl);
			event.setRateMainInfoVOs(rateMainInfoVOs);
			event.setBkgChgRateVOs(bkgChgRateVOs);
			event.setBkgChgRateHisVOs(bkgChgRateHisVOs);
		}
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