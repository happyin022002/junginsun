/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2019HTMLAction.java
*@FileTitle : RFA Proposal Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.10.08 공백진
* 1.0 Creation
 =========================================================
* History
* 2014.09.15 최성환  [CHM-201431899] Guideline RFA 생성 요청  
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstShRInqVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriRpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCProposalSC로 실행요청<br>
 * - SCProposalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Byeon Young Joo
 * @see SCProposalEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_2019HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_2019HTMLAction 객체를 생성
	 */
	public ESM_PRI_2019HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCProposalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri2019Event event = new EsmPri2019Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setCstShRInqVO((CstShRInqVO)getVO(request, CstShRInqVO .class));
		}  //2119 -Main Retrieve - SEARCH10
		else if(command.isCommand(FormCommand.SEARCH10)) {
			event.setCstShRInqVO((CstShRInqVO)getVO(request, CstShRInqVO .class));
		}			
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setPriRpMnVO((PriRpMnVO)getVO(request, PriRpMnVO .class));
		} //2119 - Detail Retrieve - SEARCH11
		else if(command.isCommand(FormCommand.SEARCH11)) {
			event.setPriRpMnVO((PriRpMnVO)getVO(request, PriRpMnVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setPriSpCtrtPtyVO((PriSpCtrtPtyVO)getVO(request, PriSpCtrtPtyVO .class));
		}	
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setPriRpAmdtSmryVO((PriRpAmdtSmryVO)getVO(request, PriRpAmdtSmryVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setPriRpScpAmdtSmryVO((PriRpScpAmdtSmryVO)getVO(request, PriRpScpAmdtSmryVO .class));
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