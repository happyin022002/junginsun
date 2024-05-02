/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0144HTMLAction.java
*@FileTitle : Bank Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.23
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2009.05.06 이석준
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
import com.hanjin.syscommon.common.table.InvEdiIntgCdDtlVO;
import com.hanjin.syscommon.common.table.InvEdiIntgCdVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.fns.inv.accountreceivableinvoicemasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jung Hwi Taek
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */
 
public class FNS_INV_0114HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0114HTMLAction 객체를 생성
	 */
	public FNS_INV_0114HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		//log.info("########## FNS_INV_0144HTMLAction");
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0114Event event = new FnsInv0114Event();

		if(command.isCommand(FormCommand.MULTI)) {
			
			event.setInvEdiIntgCdDtlVOs((InvEdiIntgCdDtlVO[])getVOs(request, InvEdiIntgCdDtlVO .class,""));
		}
		
		else if(command.isCommand(FormCommand.SEARCH)) {			

			event.setInvEdiIntgCdVO((InvEdiIntgCdVO)getVO(request, InvEdiIntgCdVO .class));
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