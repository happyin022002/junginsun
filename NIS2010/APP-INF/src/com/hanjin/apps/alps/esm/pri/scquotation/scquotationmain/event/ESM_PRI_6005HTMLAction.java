/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6005HTMLAction.java
*@FileTitle : S/C Quotation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.06 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltPriAuthorizationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.QutationMainVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriSqHdrVO;
import com.hanjin.syscommon.common.table.PriSqMnVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scquotation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCQuotationSC로 실행요청<br>
 * - SCQuotationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Seung-Jun,Lee
 * @see SCQuotationEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_6005HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_6005HTMLAction 객체를 생성
	 */
	public ESM_PRI_6005HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCQuotationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri6005Event event = new EsmPri6005Event();
		
		QutationMainVO qutationMainVO = new QutationMainVO();
		
		event.setQutationMainVO(qutationMainVO);
		//save
		if(command.isCommand(FormCommand.MULTI01)) {
			event.getQutationMainVO().setPriSqHdrVO((PriSqHdrVO)getVO(request, PriSqHdrVO .class));
			event.getQutationMainVO().setPriSqMnVO((PriSqMnVO)getVO(request, PriSqMnVO .class));
			event.getQutationMainVO().setRsltPriSqMnVO((RsltPriSqMnVO)getVO(request, RsltPriSqMnVO .class));
		}
		//delete
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.getQutationMainVO().setPriSqHdrVO((PriSqHdrVO)getVO(request, PriSqHdrVO .class));
		}
		//cancel
		else if(command.isCommand(FormCommand.MULTI03)) {
			event.getQutationMainVO().setPriSqHdrVO((PriSqHdrVO)getVO(request, PriSqHdrVO .class));
		}
		//ADD VERSION
		else if(command.isCommand(FormCommand.MULTI04)) {
			event.getQutationMainVO().setRsltCopyToQuotationVO((RsltCopyToQuotationVO)getVO(request, RsltCopyToQuotationVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.getQutationMainVO().setRsltPriSqMnVO((RsltPriSqMnVO)getVO(request, RsltPriSqMnVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.getQutationMainVO().setPriSqMnVO((PriSqMnVO)getVO(request, PriSqMnVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.getQutationMainVO().setRsltPriSqMnVO((RsltPriSqMnVO)getVO(request, RsltPriSqMnVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.getQutationMainVO().setRsltPriSqMnVO((RsltPriSqMnVO)getVO(request, RsltPriSqMnVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.getQutationMainVO().setRsltPriSqMnVO((RsltPriSqMnVO)getVO(request, RsltPriSqMnVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.getQutationMainVO().setRsltPriSqMnVO((RsltPriSqMnVO)getVO(request, RsltPriSqMnVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH10)) {
			event.getQutationMainVO().setRsltPriSqMnVO((RsltPriSqMnVO)getVO(request, RsltPriSqMnVO .class));
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