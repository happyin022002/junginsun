/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0127HTMLAction.java
*@FileTitle : JOInvoiceManageConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.InvoiceDetailListForRevisionVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceDefaultDataVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceSettingVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceSheetSetVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.enis.esd.tpb.JOCandidateConfirm 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 JOInvoiceManageManageSC로 실행요청<br>
 * - JOInvoiceManageManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author GUN-HA HWANG
 * @see JOInvoiceManageManageEvent 참조
 * @since J2EE 1.6
 */

public class ESD_TPB_0127HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_TPB_0127HTMLAction 객체를 생성
	 */
	public ESD_TPB_0127HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 JOInvoiceManageManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdTpb0127Event event = new EsdTpb0127Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setInvoiceDetailListForRevisionVOs((InvoiceDetailListForRevisionVO[])getVOs(request, InvoiceDetailListForRevisionVO .class,""));
			event.setInvoiceCreationVOs((InvoiceCreationVO[])getVOs(request, InvoiceCreationVO .class,""));
		}else if(command.isCommand(FormCommand.SEARCH)) {
			event.setInvoiceDetailListForRevisionVO((InvoiceDetailListForRevisionVO)getVO(request, InvoiceDetailListForRevisionVO .class));
			event.setSearchInvoiceSettingVO((SearchInvoiceSettingVO)getVO(request, SearchInvoiceSettingVO .class));
			event.setSearchInvoiceSheetSetVO((SearchInvoiceSheetSetVO)getVO(request, SearchInvoiceSheetSetVO .class));
			event.setInvoiceCreationVO((InvoiceCreationVO)getVO(request, InvoiceCreationVO .class));
			
			request.setAttribute("Event", event);
		}else if(command.isCommand(FormCommand.REMOVE)) {
			event.setInvoiceDetailListForRevisionVO((InvoiceDetailListForRevisionVO)getVO(request, InvoiceDetailListForRevisionVO .class));
			event.setInvoiceCreationVOs((InvoiceCreationVO[])getVOs(request, InvoiceCreationVO .class,""));
			event.setInvoiceCreationVO((InvoiceCreationVO)getVO(request, InvoiceCreationVO .class));
		}else if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setSearchInvoiceDefaultDataVO((SearchInvoiceDefaultDataVO)getVO(request, SearchInvoiceDefaultDataVO .class));
		}else if(command.isCommand(FormCommand.ADD)) {
			event.setInvoiceCreationVOs((InvoiceCreationVO[])getVOs(request, InvoiceCreationVO .class,""));
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