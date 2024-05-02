/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : STM_SAP_0210HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchSelectedListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountPayablePaymentSC 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author ORKIM
 * @see AccountPayablePaymentSC 참조
 * @since J2EE 1.4
 */

public class STM_SAP_0210HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0013HTMLAction 객체를 생성
	 */
	public STM_SAP_0210HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param HttpServletRequest request
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	StmSap0210Event event = new StmSap0210Event();

		if(command.isCommand(FormCommand.SEARCH)) {								
			event.setPaymentBatchCondVO((PaymentBatchCondVO)getVO(request, PaymentBatchCondVO.class));
		} else if(command.isCommand(FormCommand.SEARCH02)) {								
			event.setPayBatSeq(request.getParameter("pay_bat_seq"));
			event.setPayBatNm(request.getParameter("pay_bat_nm"));
		} else if(command.isCommand(FormCommand.SEARCH03)) {	
			event.setInvNo(request.getParameter("inv_no"));
			event.setPayBatSeq(request.getParameter("pay_bat_seq"));
			event.setPayBatNm(request.getParameter("pay_bat_nm"));
		} else if(command.isCommand(FormCommand.COMMAND01)) {								
			event.setPayBatSeq(request.getParameter("pay_bat_seq"));
			event.setPayBatNm(request.getParameter("pay_bat_nm"));
		} else if (   command.isCommand(FormCommand.MULTI01)
				   || command.isCommand(FormCommand.MULTI02)
				   || command.isCommand(FormCommand.MULTI03)
				   || command.isCommand(FormCommand.MULTI04)) {
			event.setPaymentBatchListVOs((PaymentBatchListVO[])getVOs(request, PaymentBatchListVO.class, "sheet1_"));
			event.setPaymentBatchSelectedListVOs((PaymentBatchSelectedListVO[])getVOs(request, PaymentBatchSelectedListVO.class, "sheet2_"));
			event.setFunctionalCurrency(request.getParameter("f_curr"));		
		} else {
			event.setSapCommonVO((SapCommonVO)getVO(request, SapCommonVO.class));
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