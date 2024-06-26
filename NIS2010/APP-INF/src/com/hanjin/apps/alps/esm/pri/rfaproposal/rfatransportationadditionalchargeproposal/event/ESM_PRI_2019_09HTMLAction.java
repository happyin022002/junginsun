/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_2019_09.jsp
*@FileTitle : RFA Proposal &amp; Amendment Inquiry - Arbitrary (For AEE/AEW)
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.25
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.06.25 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.CstPriRpScpTrspAddChgVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriRpScpTrspAddChgVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RFAProposalSC로 실행요청<br>
 * - RFAProposalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Chloe Mijin SEO
 * @see RFAProposalEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_2019_09HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_2019_09HTMLAction 객체를 생성
	 */
	public ESM_PRI_2019_09HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCProposalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri201909Event event = new EsmPri201909Event();
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setPriRpScpTrspAddChgVO((PriRpScpTrspAddChgVO)getVO(request, PriRpScpTrspAddChgVO .class));
		} else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setCstPriRpScpTrspAddChgVO((CstPriRpScpTrspAddChgVO)getVO(request, CstPriRpScpTrspAddChgVO .class));
		} else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setCstPriRpScpTrspAddChgVO((CstPriRpScpTrspAddChgVO)getVO(request, CstPriRpScpTrspAddChgVO .class));
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