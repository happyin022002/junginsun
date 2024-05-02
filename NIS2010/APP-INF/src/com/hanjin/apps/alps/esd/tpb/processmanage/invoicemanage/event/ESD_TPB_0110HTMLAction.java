/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0110HTMLAction.java
*@FileTitle : InvoiceManageConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.GetIndiaTaxInfoVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceManageListVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceSettingVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchOtsGrpInfoVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchOutstandingDetailListForInvoiceCreationVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchThirdPartyInfoVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.enis.esd.tpb.InvoiceManagemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InvoiceManageManageSC로 실행요청<br>
 * - InvoiceManageManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author GUN-HA HWANG
 * @see InvoiceManageManageEvent 참조
 * @since J2EE 1.6
 */

public class ESD_TPB_0110HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_TPB_0110HTMLAction 객체를 생성
	 */
	public ESD_TPB_0110HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InvoiceManageManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdTpb0110Event event = new EsdTpb0110Event();
		
		if( command.isCommand(FormCommand.MULTI) ){
			event.setInvoiceCreationVOs((InvoiceCreationVO[])getVOs(request, InvoiceCreationVO .class,""));
		} else if( command.isCommand(FormCommand.SEARCH) ){
			event.setSearchInvoiceManageListVO((SearchInvoiceManageListVO)getVO(request, SearchInvoiceManageListVO .class));
			event.setInvoiceCreationVO((InvoiceCreationVO)getVO(request, InvoiceCreationVO .class));
			event.setSearchInvoiceSettingVO((SearchInvoiceSettingVO)getVO(request, SearchInvoiceSettingVO .class));
			event.setSearchThirdPartyInfoVO((SearchThirdPartyInfoVO)getVO(request, SearchThirdPartyInfoVO .class));
			event.setSearchOtsGrpInfoVO((SearchOtsGrpInfoVO)getVO(request, SearchOtsGrpInfoVO .class));
			event.setGetIndiaTaxInfoVO((GetIndiaTaxInfoVO)getVO(request, GetIndiaTaxInfoVO .class));
			event.setSearchOutstandingDetailListForInvoiceCreationVO((SearchOutstandingDetailListForInvoiceCreationVO)getVO(request, SearchOutstandingDetailListForInvoiceCreationVO .class));
			
			request.setAttribute("Event", event);
		} else if( command.isCommand(FormCommand.ADD) ){
//			log.debug("HttpServletRequest====>");
			event.setInvoiceCreationVOs((InvoiceCreationVO[])getVOs(request, InvoiceCreationVO .class,""));
			event.setInvoiceCreationVO((InvoiceCreationVO)getVO(request, InvoiceCreationVO .class));
		} else if( command.isCommand(FormCommand.SEARCH03) ){
			event.setInvoiceCreationVO((InvoiceCreationVO)getVO(request, InvoiceCreationVO .class));
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