/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_0122HTMLAction.java
*@FileTitle : MOT Surcharge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 강효진
*@LastVersion : 1.0
* 2010.04.21 강효진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.CustomerReportVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.PriMotChgRtVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltPriMotChgRtVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.screport 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCReportSC로 실행요청<br>
 * - SCReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SHKIM
 * @see SCReportEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_0122HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_0121HTMLAction 객체를 생성
	 */
	public ESM_PRI_0122HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCReportEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmPri0122Event event = new EsmPri0122Event();
		
    	log.info("###########COMMAND NO :"+command.getCommand()+"################");

		if(command.isCommand(FormCommand.COMMAND01)) {
			event.setCustomerReportVO((CustomerReportVO)getVO(request, CustomerReportVO.class));
		} else if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setRsltPriMotChgRtVO((RsltPriMotChgRtVO)getVO(request, RsltPriMotChgRtVO.class));
		} else if(command.isCommand(FormCommand.MULTI01)) {
			event.setPriMotChgRtVOs((PriMotChgRtVO[])getVOs(request, PriMotChgRtVO.class, "sheet1_"));
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