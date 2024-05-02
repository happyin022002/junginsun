/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0020HTMLAction.java
*@FileTitle : MQC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.13 변영주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.CstAcceptMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.CstMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.SchPriSpScpMqcVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriSpScpMqcVO;
import com.hanjin.syscommon.common.table.PriSpSubMqcVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCProposalSC로 실행요청<br>
 * - SCProposalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Byeon Young Joo
 * @see SCProposalEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_0020HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_0020HTMLAction 객체를 생성
	 */
	public ESM_PRI_0020HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCProposalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri0020Event event = new EsmPri0020Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setPriSpScpMqcVOS((PriSpScpMqcVO[])getVOs(request, PriSpScpMqcVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setCstMqcVO((CstMqcVO)getVO(request, CstMqcVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			event.setSchPriSpScpMqcVOS((SchPriSpScpMqcVO[])getVOs(request, SchPriSpScpMqcVO .class,""));
		}
		else if(command.isCommand(FormCommand.MODIFY01)) {
			event.setSchPriSpScpMqcVO((SchPriSpScpMqcVO)getVO(request, SchPriSpScpMqcVO .class));
		}
		else if(command.isCommand(FormCommand.MODIFY02)) {
			event.setSchPriSpScpMqcVO((SchPriSpScpMqcVO)getVO(request, SchPriSpScpMqcVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setPriSpSubMqcVO((PriSpSubMqcVO)getVO(request, PriSpSubMqcVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.setPriSpSubMqcVOs((PriSpSubMqcVO[])getVOs(request, PriSpSubMqcVO .class,""));
		}		
		else if(command.isCommand(FormCommand.MODIFY11)) {
			event.setPriSpSubMqcVO((PriSpSubMqcVO)getVO(request, PriSpSubMqcVO .class));
		}		
		else if(command.isCommand(FormCommand.MODIFY12)) {
			event.setPriSpSubMqcVO((PriSpSubMqcVO)getVO(request, PriSpSubMqcVO .class));
		}		
		else if(command.isCommand(FormCommand.MODIFY05)) {
			event.setCstAcceptMqcVO((CstAcceptMqcVO)getVO(request, CstAcceptMqcVO .class));
		}		
		else if(command.isCommand(FormCommand.MODIFY06)) {
			event.setCstAcceptMqcVO((CstAcceptMqcVO)getVO(request, CstAcceptMqcVO .class));
		}			
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setPriSpScpMqcVO((PriSpScpMqcVO)getVO(request, PriSpScpMqcVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setPriSpScpMqcVO((PriSpScpMqcVO)getVO(request, PriSpScpMqcVO .class));
		}	
		else if(command.isCommand(FormCommand.SEARCH05)) {
				event.setPriSpScpMqcVO((PriSpScpMqcVO)getVO(request, PriSpScpMqcVO .class));		
		}else{
			event.setRsltCdListVO((RsltCdListVO)getVO(request, RsltCdListVO .class));
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