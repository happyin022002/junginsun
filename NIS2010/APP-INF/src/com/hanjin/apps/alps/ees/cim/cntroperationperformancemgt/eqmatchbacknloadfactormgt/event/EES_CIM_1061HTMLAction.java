/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EES_CIM_1061HTMLAction.java
*@FileTitle : Location M/B by COA BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.19
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.19 박명신
* 1.0 Creation
*======================================================  */
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBSearchOptionCOABKGVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.es.cim.cntroperationperformancemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CNTROperatioNPerformanceMgtSC로 실행요청<br>
 * - CNTROperatioNPerformanceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 박명신
 * @see EesCim1061Event 참조
 * @since J2EE 1.4
 */
public class EES_CIM_1061HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * UI_CIM_1054HTMLAction 객체를 생성
	 */
	public EES_CIM_1061HTMLAction() {}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CNTROperatioNPerformanceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */	
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EesCim1061Event event = new EesCim1061Event();
			
		//Month 조회 기간을 주형태로 조회
		if(command.isCommand(FormCommand.COMMAND01)) {		
			event.setMBSearchOptionCOABKGVO((MBSearchOptionCOABKGVO)getVO(request, MBSearchOptionCOABKGVO .class));	
		//Location을 초기화			
		} else if(command.isCommand(FormCommand.COMMAND02)) {		
			event.setMBSearchOptionCOABKGVO((MBSearchOptionCOABKGVO)getVO(request, MBSearchOptionCOABKGVO .class));	
		//조회전 로케이션 선택여부 체크 
		} else if(command.isCommand(FormCommand.COMMAND03)) {		
			event.setMBSearchOptionCOABKGVO((MBSearchOptionCOABKGVO)getVO(request, MBSearchOptionCOABKGVO .class));	
		//SaveFormat 
		} else if(command.isCommand(FormCommand.COMMAND04)) {		
			event.setMBSearchOptionCOABKGVO((MBSearchOptionCOABKGVO)getVO(request, MBSearchOptionCOABKGVO .class));	
		//RecallFormat
		} else if(command.isCommand(FormCommand.COMMAND05)) {		
			event.setMBSearchOptionCOABKGVO((MBSearchOptionCOABKGVO)getVO(request, MBSearchOptionCOABKGVO .class));	
		//Detail 탭 조회			
		} else if(command.isCommand(FormCommand.SEARCH)){		
			event.setMBSearchOptionCOABKGVO((MBSearchOptionCOABKGVO)getVO(request, MBSearchOptionCOABKGVO .class));
		//Trend 탭 조회		
		} else if(command.isCommand(FormCommand.SEARCH01)){		
			event.setMBSearchOptionCOABKGVO((MBSearchOptionCOABKGVO)getVO(request, MBSearchOptionCOABKGVO .class));
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
