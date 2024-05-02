/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0003_05HTMLAction.java
*@FileTitle : S/C Proposal Origin/Destination IHC Charge-Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.05.22 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.CstPriSpScpTrspAddChgVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.PriSpScpTrspAddChgVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.scproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCProposalSC로 실행요청<br>
 * - SCProposalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author JaeYeon Kim
 * @see SCProposalEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_0003_05HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_0003_05HTMLAction 객체를 생성
	 */
	public ESM_PRI_0003_05HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCProposalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri000305Event event = new EsmPri000305Event();

		if(command.isCommand(FormCommand.SEARCH01)) {			//retrive
			event.setPriSpScpTrspAddChgVO((PriSpScpTrspAddChgVO)getVO(request, PriSpScpTrspAddChgVO .class));
		} else if(command.isCommand(FormCommand.SEARCH02)) { //font style
			event.setCstPriSpScpTrspAddChgVO((CstPriSpScpTrspAddChgVO)getVO(request, CstPriSpScpTrspAddChgVO .class));
		} else if(command.isCommand(FormCommand.MULTI01)) { //save
			event.setPriSpScpTrspAddChgVOS((PriSpScpTrspAddChgVO[])getVOs(request, PriSpScpTrspAddChgVO .class));
//		} else if(command.isCommand(FormCommand.MULTI02)) { //guideline copy
//			event.setPriSpScpTrspAddChgVO((PriSpScpTrspAddChgVO)getVO(request, PriSpScpTrspAddChgVO .class));
		} else if(command.isCommand(FormCommand.MULTI03)) { //Accept
			event.setPriSpScpTrspAddChgVOS((PriSpScpTrspAddChgVO[])getVOs(request, PriSpScpTrspAddChgVO .class));
		} else if(command.isCommand(FormCommand.MULTI04)) { //Accept Cancel
			event.setPriSpScpTrspAddChgVOS((PriSpScpTrspAddChgVO[])getVOs(request, PriSpScpTrspAddChgVO .class));
		} else if(command.isCommand(FormCommand.MULTI05)) { //Accept All
			event.setPriSpScpTrspAddChgVOS((PriSpScpTrspAddChgVO[])getVOs(request, PriSpScpTrspAddChgVO .class));
		} else if(command.isCommand(FormCommand.MULTI06)) { //Cancel All
			event.setPriSpScpTrspAddChgVOS((PriSpScpTrspAddChgVO[])getVOs(request, PriSpScpTrspAddChgVO .class));
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