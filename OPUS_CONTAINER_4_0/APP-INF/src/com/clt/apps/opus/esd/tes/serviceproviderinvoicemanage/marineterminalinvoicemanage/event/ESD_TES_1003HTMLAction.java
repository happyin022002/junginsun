/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_1003HTMLAction.java
*@FileTitle : TerminalInvoiceSummary
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2006-10-30 kimjinjoo
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
import com.clt.syscommon.common.table.TesTmlSoVvdListVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ServiceProviderInvoiceManageSC로 실행요청<br>
 * - ServiceProviderInvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author kimjinjoo
 * @see EsdTes0014Event , ESD_TES_013_1EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TES_1003HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TES_013_1HTMLAction 객체를 생성
	 */
	public ESD_TES_1003HTMLAction() {
		log.debug("\n\nESD_TES_1003HTMLAction\n\n");
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TES_013_1Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("\n\nESD_TES_1003HTMLAction\n\n");
		
		EsdTes1003Event event = new EsdTes1003Event();
		
		event.setTesTmlSoDtlVO((TesTmlSoDtlVO)getVO(request, TesTmlSoDtlVO .class));
		event.setTesTmlSoDtlVOs((TesTmlSoDtlVO[])getVOs(request, TesTmlSoDtlVO.class,""));
		event.setMarineTerminalInvoiceCommonVO((MarineTerminalInvoiceCommonVO)getVO(request, MarineTerminalInvoiceCommonVO.class));
		
		
/*
		int codeLength = 0;
		codeLength = request.getParameterValues("ibflag")!=null?request.getParameterValues("ibflag").length:0;
		log.debug("\n\nESD_TES_TML_1003HTMLAction -> codeLenght = "+codeLength +"\n\n");

        TES_TML_SO_DTL tes_tml_so_dtl = TES_TML_SO_DTL.fromRequest(request);
        Collection tes_tml_so_dtls	= TES_TML_SO_DTL.fromRequest(request,codeLength);
        if(tes_tml_so_dtls == null){
        	log.debug("\tes_tml_so_dtls == null!");
        }else{
        	log.debug("tes_tml_so_dtls != null\n");
        }

        HashMap param_map = new HashMap();
		String param_name = null;
		Enumeration enums = request.getParameterNames();

        while (enums.hasMoreElements()){
			param_name = (String)enums.nextElement();
			param_map.put(param_name,request.getParameter(param_name));
		}

		EsdTes1003Event event = new EsdTes1003Event();
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