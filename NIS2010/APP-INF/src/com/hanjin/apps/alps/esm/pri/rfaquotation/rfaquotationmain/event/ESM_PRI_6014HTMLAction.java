/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6014HTMLAction.java
*@FileTitle : RFA Quotation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.02 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltPriAuthorizationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RFAQutationMainVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriRqHdrVO;
import com.hanjin.syscommon.common.table.PriRqMnVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.rfaquotation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RFAQuotationSC로 실행요청<br>
 * - RFAQuotationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Seung-Jun,Lee
 * @see RFAQuotationEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_6014HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_6014HTMLAction 객체를 생성
	 */
	public ESM_PRI_6014HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RFAQuotationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsmPri6014Event event = new EsmPri6014Event();
		
		RFAQutationMainVO qutationMainVO = new RFAQutationMainVO();
		
		event.setQutationMainVO(qutationMainVO) ;
		//save
		if(command.isCommand(FormCommand.MULTI01)) {
			event.getQutationMainVO().setPriRqHdrVO((PriRqHdrVO)getVO(request, PriRqHdrVO .class));
			event.getQutationMainVO().setPriRqMnVO((PriRqMnVO)getVO(request, PriRqMnVO .class));
			event.getQutationMainVO().setRsltPriRqMnVO((RsltPriRqMnVO)getVO(request, RsltPriRqMnVO .class));
		}
		//delete
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.getQutationMainVO().setPriRqHdrVO((PriRqHdrVO)getVO(request, PriRqHdrVO .class));
		}
		//cancel
		else if(command.isCommand(FormCommand.MULTI03)) {
			event.getQutationMainVO().setPriRqHdrVO((PriRqHdrVO)getVO(request, PriRqHdrVO .class));
		}
		//ADD VERSION
		else if(command.isCommand(FormCommand.MULTI04)) {
			event.getQutationMainVO().setRsltCopyToQuotationVO((RsltCopyToQuotationVO)getVO(request, RsltCopyToQuotationVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.getQutationMainVO().setRsltPriRqMnVO((RsltPriRqMnVO)getVO(request, RsltPriRqMnVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.getQutationMainVO().setPriRqMnVO((PriRqMnVO)getVO(request, PriRqMnVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.getQutationMainVO().setRsltPriRqMnVO((RsltPriRqMnVO)getVO(request, RsltPriRqMnVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.getQutationMainVO().setRsltPriRqMnVO((RsltPriRqMnVO)getVO(request, RsltPriRqMnVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.getQutationMainVO().setRsltPriRqMnVO((RsltPriRqMnVO)getVO(request, RsltPriRqMnVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.getQutationMainVO().setRsltPriRqMnVO((RsltPriRqMnVO)getVO(request, RsltPriRqMnVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH10)) {
			event.getQutationMainVO().setRsltPriRqMnVO((RsltPriRqMnVO)getVO(request, RsltPriRqMnVO .class));
		}
		// auth 체크
		else {
			event.getQutationMainVO().setRsltPriAuthorizationVO((RsltPriAuthorizationVO)getVO(request, RsltPriAuthorizationVO .class));
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