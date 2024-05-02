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
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RFAQutationMainVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltSearchGlineExistVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scquotation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCQuotationSC로 실행요청<br>
 * - SCQuotationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Seung-Jun,Lee
 * @see SCQuotationEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_6058HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_6058HTMLAction 객체를 생성
	 */
	public ESM_PRI_6058HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCQuotationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri6058Event event = new EsmPri6058Event();
		
		RFAQutationMainVO qutationMainVO = new RFAQutationMainVO();
		
		event.setQutationMainVO(qutationMainVO) ;
		//Gline copy
		if(command.isCommand(FormCommand.MULTI01)) {
			event.getQutationMainVO().setRsltPriRqMnVO((RsltPriRqMnVO)getVO(request, RsltPriRqMnVO .class));
			event.getQutationMainVO().setRsltSearchGlineExistVO((RsltSearchGlineExistVO)getVO(request, RsltSearchGlineExistVO .class));
			
//			event.getQutationMainVO().setRsltSearchGlineExistVOs((RsltSearchGlineExistVO[])getVOs(request, RsltSearchGlineExistVO.class,"sheet1_"));
//			event.getQutationMainVO().setSqScpGlineCopyVO((SqScpGlineCopyVO)getVO(request, SqScpGlineCopyVO .class));
//			
//			event.getQutationMainVO().setSqScpGlineCopyVOs((SqScpGlineCopyVO[])getVOs(request, SqScpGlineCopyVO.class,""));
//			log.debug("33333333333333333333333333getRsltSearchGlineExistVO3333333333333333333333333");
			log.debug(event.getQutationMainVO().getRsltSearchGlineExistVO().toString());
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