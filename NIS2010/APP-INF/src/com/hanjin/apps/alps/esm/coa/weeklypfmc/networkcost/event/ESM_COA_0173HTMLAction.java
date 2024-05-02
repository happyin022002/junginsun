/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName 		: ESM_COA_173HTMLAction.java
*@FileTitle 	: Average U/C Copy 화면
*Open Issues 	:
*Change history :
*@LastModifyDate: 
*@LastModifier 	: 
*@LastVersion 	: 
* 2009-09-10 CHOI IN KYUNG
* 1.0 최초 생성
* 2010.01.11 김기식 0173 화면 New FrameWork 적용
* 2012.08.02 이석준[CHM-201219334-01] EQ Holding Cost 화면 Month Copy 기능 추가 
* 2012.08.27 이석준[CHM-201219844-01]   ABC(PA)/STP Cost(RA)화면에 Month Copy 기능 추가 
* 2012.09.10 이석준 [CHM-201220070-01] EQ Repo Cost (PA) 화면에 Month Copy 기능 추가 
* 2012.09.12 이석준 [CHM-201220073-01] EMU Cost (RA) 에 Month Copy 기능 추가
* 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
* 2013.05.08 성미영 [CHM-201324182] Daily Hire by Cht-VSL / AVG hire by Own VSL / SMU 단가 화면 전월 copy 기능 추가 
* 2013.05.10 최성민 [CHM-201324573-01] [COA] Domestic Saving Credit 화면 버튼 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event.EsmCoa0173Event;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO; 

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.enis.esm.coa.weeklypfmc 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WeeklyPFMCSC로 실행요청 <br>
 * - WeeklyPFMCSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author CHOI IN KYUNG
 * @see ESM_COA_173Event , ESM_COA_173EventResponse 참조
 * @since J2EE 1.4
 */
public class ESM_COA_0173HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_COA_173HTMLAction 객체를 생성
	 */
	public ESM_COA_0173HTMLAction() {
		//
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESM_COA_173Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
    	EsmCoa0173Event event = new EsmCoa0173Event();  
    	
		if(command.isCommand(FormCommand.MULTI01)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
		} else if(command.isCommand(FormCommand.MULTI02)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
		} else if(command.isCommand(FormCommand.MULTI03)) { //0013 EQ Holding Cost에서 호출
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
		} else if(command.isCommand(FormCommand.MULTI04)) { //0012 STP/ABC에서 호출
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
		} else if(command.isCommand(FormCommand.MULTI05)) { //0009 MT Repo Cost에서 호출
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
		} else if(command.isCommand(FormCommand.COMMAND02)) { //0009 MT Repo Cost에서 호출 :	//BackEndJob - 결과로드
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
		} else if(command.isCommand(FormCommand.MULTI06)) { //0115 EMU Cost에서 호출
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
		} else if(command.isCommand(FormCommand.MULTI07)) { //0021 Manual Cost Setup에서 호출
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
		} else if(command.isCommand(FormCommand.MULTI11)) { //0014 Domestic Saving Credit에서 호출
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
		} else if(command.isCommand(FormCommand.MULTI08)) { //0042 Dailyhire by Cht-VSL (PA)에서 호출
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
		} else if(command.isCommand(FormCommand.MULTI09)) { //0043 AVG-hire by Own-VSL (PA)에서 호출
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
		} else if(command.isCommand(FormCommand.MULTI10)) { //0117 SMU Cost (RA)에서 호출
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
		} else if(command.isCommand(FormCommand.MULTI12)) { //0177 Lane Table (1Cycle)
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
		}
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