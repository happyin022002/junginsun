/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0008HTMLAction.java
*@FileTitle : Ex. Rate Entry by Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CustDailyExRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchExRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExRateHistoryVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.InvCustAndDlyXchRtVO;
import com.clt.syscommon.common.table.MdmCurrencyVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author saeil kim
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class FNS_INV_0008HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0008HTMLAction 객체를 생성
	 */
	public FNS_INV_0008HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0008Event event = new FnsInv0008Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			if(request.getParameter("call_page_name") != null && request.getParameter("call_page_name").equals("FNS_INV_0008") ) { 
				event.setCustDailyExRateVOs((CustDailyExRateVO[])getVOs(request, CustDailyExRateVO.class,"sheet2_"));
				event.setExchangeRateVOs((ExchangeRateVO[])getVOs(request, ExchangeRateVO .class,"sheet2_"));
				event.setExRateHistoryVOs((ExRateHistoryVO[])getVOs(request, ExRateHistoryVO .class,"sheet2_"));
				event.setSearchExRateVO((SearchExRateVO)getVO(request, SearchExRateVO.class));
				event.setCallPageName(request.getParameter("call_page_name"));
				event.setMultiOfficeList(request.getParameter("multi_office_list"));
			} else {
				event.setCustDailyExRateVOs((CustDailyExRateVO[])getVOs(request, CustDailyExRateVO.class,""));
				event.setExchangeRateVOs((ExchangeRateVO[])getVOs(request, ExchangeRateVO .class,""));
				event.setExRateHistoryVOs((ExRateHistoryVO[])getVOs(request, ExRateHistoryVO .class,""));
				event.setSearchExRateVO((SearchExRateVO)getVO(request, SearchExRateVO.class));
				event.setCallPageName(request.getParameter("call_page_name"));
			}
		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			event.setCustDailyExRateVOs((CustDailyExRateVO[])getVOs(request, CustDailyExRateVO.class,"sheet1_"));
			event.setExchangeRateVOs((ExchangeRateVO[])getVOs(request, ExchangeRateVO .class,"sheet1_"));
			event.setExRateHistoryVOs((ExRateHistoryVO[])getVOs(request, ExRateHistoryVO .class,"sheet1_"));
			event.setSearchExRateVO((SearchExRateVO)getVO(request, SearchExRateVO.class));
			event.setCallPageName(request.getParameter("call_page_name"));
			event.setMultiOfficeList(request.getParameter("multi_office_list"));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setSearchExRateVO((SearchExRateVO)getVO(request, SearchExRateVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			String pageType = request.getParameter("pagetype");
			event.setPageType(pageType);	
			event.setMdmCurrencyVO((MdmCurrencyVO)getVO(request, MdmCurrencyVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setInvCustAndDlyXchRtVO((InvCustAndDlyXchRtVO)getVO(request, InvCustAndDlyXchRtVO .class));
			event.setMultiOfficeList(request.getParameter("multi_office_list"));
			event.setTmpPK(request.getParameter("tmp_pk"));
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
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param Event event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}