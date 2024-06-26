/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_0017HTMLAction.java
*@FileTitle : Marine Terminal Container List 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-03
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2007-01-03 kimjinjoo
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
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoDtlVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ServiceProvideInvoiceManageSC로 실행요청<br>
 * - ServiceProvideInvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author kimjinjoo
 * @see EsdTes0017Event , ESD_TES_0017EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TES_0017HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TES_0017HTMLAction 객체를 생성
	 */
	public ESD_TES_0017HTMLAction() {
		if(log.isDebugEnabled())log.debug("\n\n==========ESD_TES_0017HTMLAction============");
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdTes0017Event 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		if(log.isDebugEnabled())log.debug("\n==========ESD_TES_0017HTMLAction    perform ============");
		
		EsdTes0017Event		event	= new EsdTes0017Event();
		
		event.setTesTmlSoHdrVO((TesTmlSoHdrVO)getVO(request, TesTmlSoHdrVO .class)); 
		event.setTesCommonVo((TesCommonVO)getVO(request, TesCommonVO .class));
		event.setMarineTerminalInvoiceCommonVO((MarineTerminalInvoiceCommonVO)getVO(request, MarineTerminalInvoiceCommonVO .class));
		event.setTesTmlSoCntrListVO((TesTmlSoCntrListVO)getVO(request, TesTmlSoCntrListVO .class)); 
		event.setTesTmlSoDtlVO((TesTmlSoDtlVO)getVO(request, TesTmlSoDtlVO .class)); 
		
		/*
         ibSheet 사용시 fromRequestGrid를 사용하는데
         prefix는 주로 멀티 Sheet 처리시에 사용하게 된다. (  sheet ID 형태의 prefix 구분자 )
         String prefix = "" ;
         TES_TML_SO_HDR tes_tml_so_hdr = TES_TML_SO_HDR.fromRequestGrid(request, prefix);
        */
/*        TES_TML_SO_HDR tes_tml_so_hdr = TES_TML_SO_HDR.fromRequest(request);

        HashMap param_map = new HashMap();
        String param_name = null;
        Enumeration enums = request.getParameterNames();
        while(enums.hasMoreElements()){
        	param_name = (String)enums.nextElement();
        	param_map.put(param_name, request.getParameter(param_name));

        	if(log.isDebugEnabled())log.debug("\n"+param_map);
//        	if(log.isDebugEnabled())log.debug("\n[param_name:" + param_name + "] - value:" + request.getParameter(param_name));
        }

		EsdTes0017Event event = new EsdTes0017Event(
                tes_tml_so_hdr ,// table value object
                param_map);
*/
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