/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0704HTMLAction.java
*@FileTitle : DOC Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.06
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2015.11.06 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.DocLocVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
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

public class ESM_BKG_0704HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0704HTMLAction 객체를 생성
	 */
	public ESM_BKG_0704HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BlRatingEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
    	EsmBkg0704Event event = new EsmBkg0704Event();

		event.setCaFlg(JSPUtil.getParameter(request, "caFlg"));
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setRateMainInfoVO((RateMainInfoVO)getVO(request, RateMainInfoVO .class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			RateMainInfoVO rateVO = new RateMainInfoVO();
			rateVO.setBkgNo(JSPUtil.getParameter(request, "bkg_no"));
			rateVO.setDocLocCd(JSPUtil.getParameter(request, "doc_loc_cd"));
			event.setRateMainInfoVO(rateVO);			
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			RateMainInfoVO rateVO = new RateMainInfoVO();
			rateVO.setDocLocCd(JSPUtil.getParameter(request, "doc_loc_cd"));
			event.setRateMainInfoVO(rateVO);			
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