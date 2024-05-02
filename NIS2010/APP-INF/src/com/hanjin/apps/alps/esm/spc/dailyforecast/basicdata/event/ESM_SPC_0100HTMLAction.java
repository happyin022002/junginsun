/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0100HTMLAction.java
*@FileTitle : DailyForecast
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.07.23 한상훈
* 1.0 Creation
* 
* History
* 2013.05.20 진마리아 [CHM-201324741-01] Lane Office POL 화면 로직 보완 - validation 및 error handling
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByVvdListConditionVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo.SpcFcastOfcPolMapgConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
//import com.hanjin.syscommon.common.table.SpcFcastOfcPolMapgVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo.SpcFcastOfcPolMapgVO;
//import com.hanjin.syscommon.common.table.SpcIrrFcastOfcPolMapgVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo.SpcIrrFcastOfcPolMapgVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.spc.dailyforecast 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DailyForecastSC로 실행요청<br>
 * - DailyForecastSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Han Sang Hoon
 * @see DailyForecastEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SPC_0100HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SPC_0100HTMLAction 객체를 생성
	 */
	public ESM_SPC_0100HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DailyForecastEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSpc0100Event event = new EsmSpc0100Event();
		SpcFcastOfcPolMapgVO spcFcastOfcPolMapgVO = new SpcFcastOfcPolMapgVO();
		SpcIrrFcastOfcPolMapgVO spcIrrFcastOfcPolMapgVO = new SpcIrrFcastOfcPolMapgVO();
		
		if(command.isCommand(FormCommand.MULTI01)) {			
			//event.setSpcFcastOfcPolMapgVOS((SpcFcastOfcPolMapgVO[])getVOs(request, SpcFcastOfcPolMapgVO .class,""));
			event.setSpcFcastOfcPolMapgVOS(spcFcastOfcPolMapgVO.fromRequestGrid(request));
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			//event.setSpcIrrFcastOfcPolMapgVOS(spcIrrFcastOfcPolMapgVO.fromRequestGrid(request));
			event.setSpcIrrFcastOfcPolMapgVOs(spcIrrFcastOfcPolMapgVO.fromRequestGrid(request));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST01)) {		
			event.setSpcFcastOfcPolMapgConditionVO((SpcFcastOfcPolMapgConditionVO)getVO(request, SpcFcastOfcPolMapgConditionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST02)) {		
			event.setSearchDailyForcastManageByVvdListConditionVO((SearchDailyForcastManageByVvdListConditionVO)getVO(request, SearchDailyForcastManageByVvdListConditionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) { //lane,bd,oit,port 정합성 체크		
			event.setSpcFcastOfcPolMapgVO((SpcFcastOfcPolMapgVO)getVO(request, SpcFcastOfcPolMapgVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) { //rgn ofc 정합성 체크		
			event.setSpcFcastOfcPolMapgVO((SpcFcastOfcPolMapgVO)getVO(request, SpcFcastOfcPolMapgVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) { //vvd 정합성 체크		
			event.setSpcIrrFcastOfcPolMapgVO((SpcIrrFcastOfcPolMapgVO)getVO(request, SpcIrrFcastOfcPolMapgVO .class));
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