/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0108_02HTMLAction.java
*@FileTitle : S/C Performance Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.02 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCInfromationVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerformanceBulletListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailSumVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCTradeSubTradeLaneListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.ComBakEndJbVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.screport 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCReportSC로 실행요청<br>
 * - SCReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Day-Hoh, Kim
 * @see SCReportEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_0108_02HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_0108_02HTMLAction 객체를 생성
	 */
	public ESM_PRI_0108_02HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCReportEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri010802Event event = new EsmPri010802Event();
		if(command.isCommand(FormCommand.COMMAND01)) {
			event.setRsltSearchSCPerformanceDetailListVO((RsltSearchSCPerformanceDetailListVO)getVO(request, RsltSearchSCPerformanceDetailListVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setComBakEndJbVO((ComBakEndJbVO)getVO(request, ComBakEndJbVO.class));
		}else if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setComBakEndJbVO((ComBakEndJbVO)getVO(request, ComBakEndJbVO.class));
		}
		else if (command.isCommand(FormCommand.SEARCH01)) { // trade, sub trade, lane 콤보
			event.setRsltSearchSCTradeSubTradeLaneListVO((RsltSearchSCTradeSubTradeLaneListVO)getVO(request, RsltSearchSCTradeSubTradeLaneListVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setRsltSearchSCInfromationVO((RsltSearchSCInfromationVO)getVO(request, RsltSearchSCInfromationVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setRsltSearchSCPerformanceBulletListVO((RsltSearchSCPerformanceBulletListVO)getVO(request, RsltSearchSCPerformanceBulletListVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setRsltSearchSCPerformanceDetailSumVO((RsltSearchSCPerformanceDetailSumVO)getVO(request, RsltSearchSCPerformanceDetailSumVO.class));
		}
		event.setAttribute("KEY", request.getParameter("backendjob_key"));
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