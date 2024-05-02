/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BCM_CCD_0023HTMLAction.java
*@FileTitle : leasing company yard
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.location.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.bcm.ccd.commoncode.location.vo.LseComYardVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.bcm.ccd.commoncode 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 commoncodeSC로 실행요청<br>
 * - commoncodeSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see commoncodeEvent 참조
 * @since J2EE 1.6
 */

public class BCM_CCD_0023HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * BCM_CCD_0023HTMLAction 객체를 생성
	 */
	public BCM_CCD_0023HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 commoncodeEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		BcmCcd0023Event event = new BcmCcd0023Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setLseCoYdCd(request.getParameter("lse_co_yd_cd"));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setLseCoYdVO((LseComYardVO)getVO(request, LseComYardVO .class));
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setLseCoVndrSeq1(request.getParameter("lse_co_vndr_seq1"));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setLseCoVndrSeq2(request.getParameter("lse_co_vndr_seq2"));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setLseCoVndrSeq3(request.getParameter("lse_co_vndr_seq3"));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setLseCoVndrSeq4(request.getParameter("lse_co_vndr_seq4"));
		}else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setLseCoVndrSeq5(request.getParameter("lse_co_vndr_seq5"));
		}else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setLseCoVndrSeq6(request.getParameter("lse_co_vndr_seq6"));
		}else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setLseCoVndrSeq7(request.getParameter("lse_co_vndr_seq7"));
		}else if(command.isCommand(FormCommand.SEARCH08)) {
			event.setLseCoVndrSeq8(request.getParameter("lse_co_vndr_seq8"));
		}else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setLseCoVndrSeq9(request.getParameter("lse_co_vndr_seq9"));
		}else if(command.isCommand(FormCommand.SEARCH10)) {
			event.setLseCoVndrSeq10(request.getParameter("lse_co_vndr_seq10"));
		}else if(command.isCommand(FormCommand.SEARCH11)) {
			event.setLseCoVndrSeq11(request.getParameter("lse_co_vndr_seq11"));
		}else if(command.isCommand(FormCommand.SEARCH12)) {
			event.setLseCoVndrSeq12(request.getParameter("lse_co_vndr_seq12"));
		}else if(command.isCommand(FormCommand.SEARCH13)) {
			event.setLseCoVndrSeq13(request.getParameter("lse_co_vndr_seq13"));
		}else if(command.isCommand(FormCommand.SEARCH14)) {
			event.setLseCoVndrSeq14(request.getParameter("lse_co_vndr_seq14"));
		}else if(command.isCommand(FormCommand.SEARCH15)) {
			event.setLseCoVndrSeq15(request.getParameter("lse_co_vndr_seq15"));
		}else if(command.isCommand(FormCommand.SEARCH16)) {
			event.setLseCoVndrSeq16(request.getParameter("lse_co_vndr_seq16"));
		}else if(command.isCommand(FormCommand.SEARCH17)) {
			event.setLseCoVndrSeq17(request.getParameter("lse_co_vndr_seq17"));
		}else if(command.isCommand(FormCommand.SEARCH18)) {
			event.setLseCoVndrSeq18(request.getParameter("lse_co_vndr_seq18"));
		}else if(command.isCommand(FormCommand.SEARCH19)) {
			event.setLseCoVndrSeq19(request.getParameter("lse_co_vndr_seq19"));
		}else if(command.isCommand(FormCommand.SEARCH20)) {
			event.setLseCoVndrSeq20(request.getParameter("lse_co_vndr_seq20"));
		}else if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setLseCoYdCd(request.getParameter("lse_co_yd_cd"));
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