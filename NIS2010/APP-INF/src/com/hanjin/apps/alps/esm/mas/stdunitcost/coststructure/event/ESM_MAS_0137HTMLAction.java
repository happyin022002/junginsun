/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0137HTMLAction.java
*@FileTitle : Node/Link U/C Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.02
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.08.02 임옥영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.TableColumnVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.NodLnkCostCodeVO;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.mas.stdunitcost 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 STDUnitCostSC로 실행요청<br>
 * - STDUnitCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author OK-YOUNG IM
 * @see STDUnitCostEvent 참조
 * @since J2EE 1.6
 */

public class ESM_MAS_0137HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_MAS_0137HTMLAction 객체를 생성
	 */
	public ESM_MAS_0137HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 STDUnitCostEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmMas0137Event event = new EsmMas0137Event();
		
		event.setFTableName(request.getParameter("f_table_name"));//f_table_name 조건 세팅
		//if(command.isCommand(FormCommand.SEARCH01)||command.isCommand(FormCommand.SEARCH02)) {}
		if(command.isCommand(FormCommand.SEARCH03)||command.isCommand(FormCommand.SEARCH04)) {
			event.setTableColumnVOs((TableColumnVO[])getVOs(request, TableColumnVO.class, ""));
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			event.setNodLnkCostCodeVOs((NodLnkCostCodeVO[])getVOs(request, NodLnkCostCodeVO .class,""));
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