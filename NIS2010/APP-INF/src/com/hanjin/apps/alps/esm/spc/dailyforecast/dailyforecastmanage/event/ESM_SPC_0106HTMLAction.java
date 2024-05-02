/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0106HTMLAction.java
*@FileTitle : dailyforecastmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.21 한상훈
* 1.0 Creation
* 2015.11.19 이혜민 [CHM-201538569] FCST Input > Account Add/Del 사용시 Data 확인 및 팝업처리 요청
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchSalesRepInfoVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.SpcSlsRepCustMapgVO;
import com.hanjin.syscommon.common.table.SpcSlsRepCustVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.spc.dailyforecast 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DailyForecastSC로 실행요청<br>
 * - DailyForecastSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Han Sang Hoon
 * @see DailyForecastEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SPC_0106HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SPC_0106HTMLAction 객체를 생성
	 */
	public ESM_SPC_0106HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DailyForecastEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSpc0106Event event = new EsmSpc0106Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setSpcSlsRepCustVOS((SpcSlsRepCustVO[])getVOs(request, SpcSlsRepCustVO .class,""));
		}else if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setSearchSalesRepInfoVO((SearchSalesRepInfoVO)getVO(request, SearchSalesRepInfoVO .class, ""));
		}else if(command.isCommand(FormCommand.SEARCHLIST02)) {
			event.setSearchSalesRepInfoVO((SearchSalesRepInfoVO)getVO(request, SearchSalesRepInfoVO .class, ""));
		}else if(command.isCommand(FormCommand.SEARCHLIST03)) {
			event.setSearchSalesRepInfoVO((SearchSalesRepInfoVO)getVO(request, SearchSalesRepInfoVO .class, ""));
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