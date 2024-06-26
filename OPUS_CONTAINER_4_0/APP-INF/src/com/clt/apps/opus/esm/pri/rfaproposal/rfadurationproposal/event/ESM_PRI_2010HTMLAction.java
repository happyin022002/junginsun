/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0019HTMLAction.java
*@FileTitle : Duration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.18 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.CstAuthorityVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpScpDurVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.CstScpDurVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.PriRpDurVO;
import com.clt.syscommon.common.table.PriRpScpDurVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.scproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCProposalSC로 실행요청<br>
 * - SCProposalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kong Back Jin
 * @see SCProposalEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_2010HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_0019HTMLAction 객체를 생성
	 */
	public ESM_PRI_2010HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCProposalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri2010Event event = new EsmPri2010Event();
		 
		if(command.isCommand(FormCommand.MULTI)) {
			event.setCstPriRpScpDurVOs((CstPriRpScpDurVO[])getVOs(request, CstPriRpScpDurVO .class,""));
			event.setPriRpScpDurVOs((PriRpScpDurVO[])getVOs(request, PriRpScpDurVO .class,""));
			//getPriRpScpDurVOs
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
//			event.setPriRpScpDurVO((PriRpScpDurVO)getVO(request, PriRpScpDurVO .class));
			event.setCstAuthorityVO((CstAuthorityVO)getVO(request, CstAuthorityVO .class));
		}
//		else if(command.isCommand(FormCommand.MODIFY01)) {
//			event.setPriRpScpDurVO((PriRpScpDurVO)getVO(request, PriRpScpDurVO .class));
//		}
		else if(command.isCommand(FormCommand.MODIFY01)) {
			event.setCstScpDurVO((CstScpDurVO)getVO(request, CstScpDurVO .class));
		}		
		else if(command.isCommand(FormCommand.MODIFY02)) {
			event.setPriRpScpDurVO((PriRpScpDurVO)getVO(request, PriRpScpDurVO .class));
		}		
		else if(command.isCommand(FormCommand.MODIFY03)) {
			event.setPriRpScpDurVO((PriRpScpDurVO)getVO(request, PriRpScpDurVO .class));
		}		
		else if(command.isCommand(FormCommand.MODIFY04)) {
			event.setPriRpScpDurVO((PriRpScpDurVO)getVO(request, PriRpScpDurVO .class));
		}
		else if(command.isCommand(FormCommand.MODIFY05)) {
			event.setPriRpDurVO((PriRpDurVO)getVO(request, PriRpDurVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setPriRpScpDurVO((PriRpScpDurVO)getVO(request, PriRpScpDurVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setPriRpScpDurVO((PriRpScpDurVO)getVO(request, PriRpScpDurVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setPriRpScpDurVO((PriRpScpDurVO)getVO(request, PriRpScpDurVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setPriRpDurVO((PriRpDurVO)getVO(request, PriRpDurVO .class));
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