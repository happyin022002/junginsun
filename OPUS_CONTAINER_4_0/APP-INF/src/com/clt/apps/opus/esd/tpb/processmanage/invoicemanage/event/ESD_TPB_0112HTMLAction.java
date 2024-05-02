/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0112HTMLAction.java
*@FileTitle : InvoiceManageConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event;
  
import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceStatusVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tpb.InvoiceManagemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InvoiceManageManageSC로 실행요청<br>
 * - InvoiceManageManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author GUN-HA HWANG
 * @see InvoiceManageManageEvent 참조
 * @since J2EE 1.6
 */

public class ESD_TPB_0112HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_TPB_0112HTMLAction 객체를 생성
	 */
	public ESD_TPB_0112HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InvoiceManageManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsdTpb0112Event event = new EsdTpb0112Event();
		
		String ref = request.getHeader("Referer");
//		String s_lnk_n3pty_inv_no = JSPUtil.getParameter(request, "s_lnk_n3pty_inv_no");

		if(ref != null){
			// log.debug("======================= s_final_flg "+JSPUtil.getParameter(request, "s_final_flg"));
			if((ref.indexOf("ESD_TPB_0111.do") >= 0 || ref.indexOf("ESD_TPB_0026.do") >= 0)
				&& JSPUtil.getParameter(request, "s_final_flg").equals("Y")){ //Finale Invoice 일 경우
				event.setAttribute("erp_visible_flag","Y");
			}
			if(ref.indexOf("ESD_TPB_0110.do") >= 0){
				event.setAttribute("issue_visible_flag","Y");
			//}else if((ref.indexOf("ESD_TPB_032.do") >= 0 || ref.indexOf("ESD_TPB_026.do") >= 0) && !s_france.equals("Y")){ // France 지역 점소도 타지역과 대등하게 처리 
			}else if( ref.indexOf("ESD_TPB_0111.do") >= 0 || ref.indexOf("ESD_TPB_0026.do") >= 0){ // France 지역 점소도 타지역과 대등하게 처리 ...  Changed By O Wan-Ki In 2007-10-14
				event.setAttribute("issue_visible_flag","Y");
			}
		}

		if(command.isCommand(FormCommand.MULTI)) {
			event.setSearchInvoiceStatusVOs((SearchInvoiceStatusVO[])getVOs(request, SearchInvoiceStatusVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)||command.isCommand(FormCommand.MODIFY)) {
			event.setSearchInvoiceStatusVO((SearchInvoiceStatusVO)getVO(request, SearchInvoiceStatusVO .class));
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