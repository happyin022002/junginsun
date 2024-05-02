/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0070HTMLAction.java
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.01 한상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.SpcFcastDwnLodSkdVO;
import com.clt.syscommon.common.table.SpcNshwRsltVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.spc.spaceallocationmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SpaceAllocationManageSC로 실행요청<br>
 * - SpaceAllocationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Han Sang Hoon
 * @see SpaceAllocationManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SPC_0070HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SPC_0070HTMLAction 객체를 생성
	 */
	public ESM_SPC_0070HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SpaceAllocationManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSpc0070Event event = new EsmSpc0070Event();
		
		if(command.isCommand(FormCommand.MULTI01)) {
			event.setSpcNshwRsltVOS((SpcNshwRsltVO[])getVOs(request, SpcNshwRsltVO .class,""));
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.setSpcFcastDwnLodSkdVOS((SpcFcastDwnLodSkdVO[])getVOs(request, SpcFcastDwnLodSkdVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST02)) {
			//event.setSearchNoShowDownloadDateListVO((SearchNoShowDownloadDateListVO)getVO(request, SearchNoShowDownloadDateListVO .class));
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST01)) {
			//event.setSearchNoShowAdjustmentListVO((SearchNoShowAdjustmentListVO)getVO(request, SearchNoShowAdjustmentListVO .class));
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
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