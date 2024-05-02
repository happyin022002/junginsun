/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0089HTMLAction.java
*@FileTitle : Ex Rate Entry by Cusomtomer - Multi Cust
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CustDailyExRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.MultiCustomerVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.fns.inv.accountreceivableinvoicemasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author saeil kim
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class FNS_INV_0089HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0089HTMLAction 객체를 생성
	 */
	public FNS_INV_0089HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0089Event event = new FnsInv0089Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setMultiCustomerVOs((MultiCustomerVO[])getVOs(request, MultiCustomerVO.class,"sheet1_"));
			event.setCustDailyExRateVOs((CustDailyExRateVO[])getVOs(request, CustDailyExRateVO.class,"sheet2_"));
			
			MultiCustomerVO[] vos = (MultiCustomerVO[])getVOs(request, MultiCustomerVO .class,"sheet1_");
			ExchangeRateVO[] vos2 = (ExchangeRateVO[])getVOs(request, ExchangeRateVO .class,"sheet2_");
			
			for (int i = 0; i < vos.length; i++) {
				for (int j = 0; j < vos2.length; j++) {
					ExchangeRateVO exchangeRateVO = vos2[j];
					exchangeRateVO.setCustCntCd(vos[i].getCustCntCd());
					exchangeRateVO.setCustSeq(vos[i].getCustSeq());
				}
			}
			
			event.setExchangeRateVOs(vos2);
		
		}else if(command.isCommand(FormCommand.SEARCH)) {
				String custCndCd = request.getParameter("cust_cnt_cd");
				String custSeq = request.getParameter("cust_seq");
				String mon = request.getParameter("mon");
				event.setCustCndCd(custCndCd);	
				event.setCustSeq(custSeq);
				event.setMon(mon);
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