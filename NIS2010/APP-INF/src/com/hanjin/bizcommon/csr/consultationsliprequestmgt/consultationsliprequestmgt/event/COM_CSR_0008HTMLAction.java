/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_CSR_0008HTMLAction.java
*@FileTitle : CSR Interface Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.16 함대성
* 1.0 Creation
* -------------------------------------------------------
* History
* 2014.11.19 김영신 [CHM-201432872] 10만불 이상 G/W연동 관련 로직 추가
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.bizcommon.approval.vo.ApprovalCsrVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CsrParmVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.IfCsrListInputVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.PayInvVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.bizcommon.csr.consultationsliprequestmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ConsultationSlipRequestMgtSC로 실행요청<br>
 * - ConsultationSlipRequestMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author HAM DAE SUNG
 * @see ConsultationSlipRequestMgtEvent 참조
 * @since J2EE 1.6
 */

public class COM_CSR_0008HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * COM_CSR_0008HTMLAction 객체를 생성
	 */
	public COM_CSR_0008HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ConsultationSlipRequestMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		ComCsr0008Event event = new ComCsr0008Event();
		
		/**
		 * MULTI10 : GW URL open
		 * COMMAND03 : GW Result
		 * MULTI11 : 3만불 이하 ALPS 결재
		 * SEARCH10 : Apro Step 정보 조회
		 */
		if(command.isCommand(FormCommand.SEARCHLIST) || command.isCommand(FormCommand.SEARCH01) 
				|| command.isCommand(FormCommand.MULTI) || command.isCommand(FormCommand.MULTI10)
				|| command.isCommand(FormCommand.SEARCH10)) {
			event.setIfCsrListInputVO((IfCsrListInputVO)getVO(request, IfCsrListInputVO .class));
		} else if(command.isCommand(FormCommand.COMMAND03)) {
			event.setComCsrInfoVO((ComCsrInfoVO)getVO(request, ComCsrInfoVO .class));	
		} else if(command.isCommand(FormCommand.SEARCH02) || command.isCommand(FormCommand.MULTI11)){
			/* 
	        ibSheet 사용시 fromRequestGrid를 사용하는데 
	        prefix는 주로 멀티 Sheet 처리시에 사용하게 된다. (  sheet ID 형태의 prefix 구분자 ) 
	        String prefix = "" ;  
	        ApPayInvVO apPayInvVO = ApPayInvVO.fromRequestGrid(request, prefix);
	       */
			PayInvVO payInvVO =PayInvVO.fromRequest(request);
			Collection payInvs = null;
			payInvs = PayInvVO.fromRequestGrid(request, "");
			CsrParmVO csrParmVO = CsrParmVO.fromRequest(request, "");
			ComCsrInfoVO comCsrInfoVO = (ComCsrInfoVO)getVO(request, ComCsrInfoVO .class);
			
			int codeLength = 0;
			
			String[] chks = request.getParameterValues("chk");
			for (int i=0; chks!=null && i<chks.length; i++){
				log.debug("\n - chks["+i+"]:"+chks[i]);
			}
			log.debug("\n - chks.length:"+(chks!=null?chks.length:0)+"\n------------------------------------------------------------\n");
			
			codeLength = request.getParameterValues("ibflag")!=null?request.getParameterValues("ibflag").length:0;
			payInvs	= PayInvVO.fromRequest(request,codeLength);
	       
			 event = new ComCsr0008Event(
	               payInvVO,
	               payInvs,
	               csrParmVO,
	               comCsrInfoVO); // table value object
			
			request.setAttribute("Event", event);
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