/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_919HTMLAction.java
*@FileTitle : R/H된 Volume Adjustment PopUp 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-14
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-14 parkyeonjin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.syscommon.common.table.TesTmlSoDtlVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;
import com.clt.syscommon.common.table.TesTmlSoRvisListVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ServiceProviderInvoiceManageSC로 실행요청<br>
 * - ServiceProviderInvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author parkyeonjin
 * @see EsdTes9190Event , ESD_TES_919EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TES_9190HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TES_919HTMLAction 객체를 생성
	 */
	public ESD_TES_9190HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TES_919Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		EsdTes9190Event event = new EsdTes9190Event();
		
		event.setTesTmlSoHdrVO((TesTmlSoHdrVO)getVO(request, TesTmlSoHdrVO .class)); 
		event.setTesTmlSoDtlVO((TesTmlSoDtlVO)getVO(request, TesTmlSoDtlVO .class)); 
		event.setTesTmlSoRvisListVO((TesTmlSoRvisListVO)getVO(request, TesTmlSoRvisListVO .class)); 
		event.setTesTmlSoDtlVO((TesTmlSoDtlVO)getVO(request, TesTmlSoDtlVO .class)); 
		event.setTesCommonVo((TesCommonVO)getVO(request, TesCommonVO .class)); 
		event.setMarineTerminalInvoiceCommonVO((MarineTerminalInvoiceCommonVO)getVO(request, MarineTerminalInvoiceCommonVO .class)); 
		
		event.setMarineTerminalInvoiceCommonVOs((MarineTerminalInvoiceCommonVO[])getVOs(request, MarineTerminalInvoiceCommonVO.class,""));
		
		
		
/*
		Collection terminal_invoice_rvis_list = null;
		int codeLength = 0;
		codeLength = request.getParameterValues("rvis_ibflag")!=null?request.getParameterValues("rvis_ibflag").length:0;

		HashMap param_map = new HashMap();
		String param_name = null;
		Enumeration enums = request.getParameterNames();
		while (enums.hasMoreElements()){
			param_name = (String)enums.nextElement();
			param_map.put(param_name,request.getParameter(param_name));
			log.debug("[param_name:" + param_name + "] - value:" + request.getParameter(param_name));
		}

		terminal_invoice_rvis_list = TerminalInvoiceRvisList.fromRequest(request, codeLength);
*/		

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