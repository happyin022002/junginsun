/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_014HTMLAction.java
*@FileTitle : Brokerage Detail & History fo BL
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-23
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-23 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.AGTBRKGRateInfoVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailBasicbyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailChargebyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailHistorybyBLVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.agt.agtaudit 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AGTAuditSC로 실행요청<br>
 * - AGTAuditSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Hwang GyeongNam
 * @see EsmAgt0014Event , ESM_AGT_014EventResponse 참조
 * @since J2EE 1.4
 */
public class ESM_AGT_0014HTMLAction extends HTMLActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_AGT_014HTMLAction 객체를 생성
	 */
	public ESM_AGT_0014HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESM_AGT_014Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsmAgt0014Event event = new EsmAgt0014Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setBrkgCommDetailBasicbyBLVO((BRKGCommDetailBasicbyBLVO)getVO(request, BRKGCommDetailBasicbyBLVO.class));
		}
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setBrkgCommDetailChargebyBLVO((BRKGCommDetailChargebyBLVO)getVO(request, BRKGCommDetailChargebyBLVO.class));
		}
		
		if(command.isCommand(FormCommand.SEARCH02)) {
			event.setBrkgCommDetailHistorybyBLVO((BRKGCommDetailHistorybyBLVO)getVO(request, BRKGCommDetailHistorybyBLVO.class));
		}
		
		if(command.isCommand(FormCommand.SEARCH03)) {
			event.setAgtBRKGRateInfoVO((AGTBRKGRateInfoVO)getVO(request, AGTBRKGRateInfoVO.class));
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
