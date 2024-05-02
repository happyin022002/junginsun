/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0174HTMLAction.java
*@FileTitle : Average U/C(OP fixed/variable cost, SPC CHT Rev/Chraterage)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.03
*@LastModifier : Choi In Kyung
*@LastVersion : 1.0
* 2009.07.03 Choi In Kyung
* 1.0 Creation
* 2010.01.11 김기식 0174 화면 New FrameWork 적용
* 2010.12.01 김기종 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.AverageUCVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 NetworkCostSC로 실행요청<br>
 * - NetworkCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Choi In Kyung
 * @see EsmMas0174Event 참조
 * @since J2EE 1.6
 */
public class ESM_MAS_0174HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * TESTHTMLAction 객체를 생성
	 */
	public ESM_MAS_0174HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmMas0174Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmMas0174Event event = new EsmMas0174Event();  
    	
		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setAverageUCVO((AverageUCVO)getVO(request, AverageUCVO.class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setAverageUCVOs((AverageUCVO[])getVOs(request, AverageUCVO.class));
		}else if(command.isCommand(FormCommand.MULTI02)) {
			event.setAverageUCVOs((AverageUCVO[])getVOs(request, AverageUCVO.class));
		}else{
			event.setAverageUCVO((AverageUCVO)getVO(request, AverageUCVO.class));
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
