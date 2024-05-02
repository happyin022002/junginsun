/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_PRI_0087HTMLAction.java
*@FileTitle : S/C Proposal & Amendment View
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.09
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2011.08.09 김민아
* 1.0 Creation
===========================================================
* History
* 2011.08.09 김민아 [CHM-201112688-01] Contract별 Inquiry 화면을 요청 : 특정 S/C 한건에 대한 조회  View Popup 신규 개발
===========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;
import com.hanjin.syscommon.common.table.PriSpHdrVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpAmdtSmryVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCProposalSC로 실행요청<br>
 * - SCProposalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Byeon Young Joo
 * @see SCProposalEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_0087HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_0087HTMLAction 객체를 생성
	 */
	public ESM_PRI_0087HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCProposalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri0087Event event = new EsmPri0087Event();
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setPriSpMnVO((PriSpMnVO)getVO(request, PriSpMnVO .class));
			event.setPriSpHdrVO((PriSpHdrVO)getVO(request, PriSpHdrVO .class));			
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setPriSpScpAmdtSmryVO((PriSpScpAmdtSmryVO)getVO(request, PriSpScpAmdtSmryVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH14)) {
			event.setPriSpMnVO((PriSpMnVO)getVO(request, PriSpMnVO .class));
		}			
		else if(command.isCommand(FormCommand.SEARCH15)) {
			event.setComBakEndJbVO((ComBakEndJbVO)getVO(request, ComBakEndJbVO.class));
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
		}	
		else if(command.isCommand(FormCommand.SEARCH16)) {
			event.setComBakEndJbVO((ComBakEndJbVO)getVO(request, ComBakEndJbVO .class));
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
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