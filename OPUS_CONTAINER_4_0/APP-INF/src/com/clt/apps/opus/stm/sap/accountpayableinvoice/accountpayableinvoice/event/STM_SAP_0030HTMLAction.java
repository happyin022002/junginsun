/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : STM_SAP_0030HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* Created by Hannah Lee
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoicePrintVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountPayableInvoiceSC로 실행요청<br>
 * - AccountPayableInvoiceSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author hannah lee
 * @see StmSap0030Event 참조
 * @since J2EE 1.4
 */

public class STM_SAP_0030HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * STM_SAP_0030HTMLAction 객체를 생성
	 */
	public STM_SAP_0030HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param HttpServletRequest request
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	StmSap0030Event event = new StmSap0030Event();

    	if(command.isCommand(FormCommand.SEARCH)) {								
			InvoiceSlipCondVO vo = (InvoiceSlipCondVO)getVO(request, InvoiceSlipCondVO.class);
			event.setInvoiceSlipCondVO(vo);
		}else if(command.isCommand(FormCommand.SEARCH02)) {	
			event.setInvSeq(request.getParameter("hid_inv_seq"));
			event.setInvCurrCd(request.getParameter("hid_inv_curr_cd"));
		}else if(command.isCommand(FormCommand.SEARCH03)) {	
			event.setInvSeq(request.getParameter("hid_inv_seq"));
		} else if (command.isCommand(FormCommand.PRINT)) {
			event.setInvoicePrintVOs((InvoicePrintVO[])getVOs(request, InvoicePrintVO.class, "sheet1_"));
		}       
		
		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param EventResponse eventResponse
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param Event event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}