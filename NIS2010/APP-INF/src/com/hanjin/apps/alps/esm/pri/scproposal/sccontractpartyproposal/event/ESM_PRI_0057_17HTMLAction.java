/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0017HTMLAction.java
*@FileTitle : Amendment History Inquiry - Customer Type
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.09.17 박성수
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriSpCtrtCustTpVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCProposalSC로 실행요청<br>
 * - SCProposalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Byeon Young Joo
 * @see SCProposalEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_0057_17HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_0057_17HTMLAction 객체를 생성
	 */
	public ESM_PRI_0057_17HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCProposalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */ 
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri005717Event event = new EsmPri005717Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setPriSpCtrtCustTpVOS((PriSpCtrtCustTpVO[])getVOs(request, PriSpCtrtCustTpVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setPriSpCtrtCustTpVO((PriSpCtrtCustTpVO)getVO(request, PriSpCtrtCustTpVO .class));
			event.setPriSpHistoryInquiryParamVO((PriSpHistoryInquiryParamVO)getVO(request, PriSpHistoryInquiryParamVO .class));
		}
		else if(command.isCommand(FormCommand.MODIFY01)) {
			event.setPriSpCtrtCustTpVO((PriSpCtrtCustTpVO)getVO(request, PriSpCtrtCustTpVO .class));
		}
		else if(command.isCommand(FormCommand.MODIFY02)) {
			event.setPriSpCtrtCustTpVO((PriSpCtrtCustTpVO)getVO(request, PriSpCtrtCustTpVO .class));
		}		
		else if(command.isCommand(FormCommand.MODIFY03)) {
			event.setPriSpCtrtCustTpVO((PriSpCtrtCustTpVO)getVO(request, PriSpCtrtCustTpVO .class));
		}		
		else if(command.isCommand(FormCommand.MODIFY04)) {
			event.setPriSpCtrtCustTpVO((PriSpCtrtCustTpVO)getVO(request, PriSpCtrtCustTpVO .class));
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