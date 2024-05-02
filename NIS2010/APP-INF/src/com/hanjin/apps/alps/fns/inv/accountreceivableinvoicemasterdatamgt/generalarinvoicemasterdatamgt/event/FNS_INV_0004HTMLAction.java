/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0004HTMLAction.java
*@FileTitle : Bank Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.05.06 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArBankListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.InvArBankVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.fns.inv.accountreceivableinvoicemasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jung Hwi Taek
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class FNS_INV_0004HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0004HTMLAction 객체를 생성
	 */
	public FNS_INV_0004HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		//log.info("########## FNS_INV_0004HTMLAction");
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0004Event event = new FnsInv0004Event();

		if(command.isCommand(FormCommand.MULTI)) {
			
			event.setInvArBankVOS((InvArBankVO[])getVOs(request, InvArBankVO .class,""));
		}
		
		else if(command.isCommand(FormCommand.SEARCH)) {			

			String arOfc = request.getParameter("ar_ofc_cd2");
			String saleOfc = request.getParameter("ofc_cd");			
	
			event.setArOfc(arOfc);
			event.setSaleOfc(saleOfc);
			
			event.setInvArBankListVO((InvArBankListVO)getVO(request, InvArBankListVO .class));
		}
		
        else if(command.isCommand(FormCommand.SEARCH03)) {			

			String arOfc = request.getParameter("ar_ofc_cd2");
			String saleOfc = request.getParameter("ofc_cd2");	
			
			//log.info("########## arOfc"+arOfc);
	
			event.setArOfc(arOfc);
			event.setSaleOfc(saleOfc);
			
			event.setInvArBankListVO((InvArBankListVO)getVO(request, InvArBankListVO .class));
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