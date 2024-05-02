/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2044HTMLAction.java
*@FileTitle : RFA Proposal Creation [Copy]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.09.28 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.rfaproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCProposalSC로 실행요청<br>
 * - RFAProposalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Moon Dong Gyu
 * @see RFAProposalEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_2044HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_2044HTMLAction 객체를 생성
	 */
	public ESM_PRI_2044HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RFAProposalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri2044Event event = new EsmPri2044Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setRsltRfaPropCopyVO((RsltRfaPropCopyVO)getVO(request, RsltRfaPropCopyVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI)) {
            event.setRsltPropCpBlplAfilListVOs((RsltRfaPropCopyVO[])getVOs(request, RsltRfaPropCopyVO.class, "sheet1_"));
            event.setRsltRfaPropCopyVOs((RsltRfaPropCopyVO[])getVOs(request, RsltRfaPropCopyVO.class, "sheet2_"));
            event.setRsltRfaPropCopyVO((RsltRfaPropCopyVO)getVO(request, RsltRfaPropCopyVO.class));
		}
		else {
		    event.setRsltRfaPropCopyVO((RsltRfaPropCopyVO)getVO(request, RsltRfaPropCopyVO.class));
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