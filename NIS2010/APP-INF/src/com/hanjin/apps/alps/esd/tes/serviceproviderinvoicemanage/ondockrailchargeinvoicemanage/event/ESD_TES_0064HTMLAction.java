/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_0064HTMLAction.java
*@FileTitle : On-dock Rail Charge Invoice 등록 및 Confirm화면-Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-28
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-28 parkyeonjin
* 1.0 최초 생성
* 2009-03-12 [R200903110001] : TES_TML_SO_PAY_DYS 테이블 미사용 제거 주석처리
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.vo.OndockRailChargeInvoiceCommonVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.syscommon.common.table.TesTmlSoCntrListVO;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ServiceProviderInvoiceManageSC로 실행요청<br>
 * - ServiceProviderInvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author parkyeonjin
 * @see EsdTes0064Event , ESD_TES_0064EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TES_0064HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TES_0064HTMLAction 객체를 생성
	 */
	public ESD_TES_0064HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TES_0064Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		if(log.isDebugEnabled())log.debug("==========ESD_TES_0064HTMLAction    perform ============");
		
		EsdTes0064Event event = new EsdTes0064Event();
		
		event.setTesTmlSoHdrVO((TesTmlSoHdrVO)getVO(request, TesTmlSoHdrVO .class));
		event.setOndockRailChargeInvoiceCommonVO((OndockRailChargeInvoiceCommonVO)getVO(request, OndockRailChargeInvoiceCommonVO .class));
		
		event.setTesTmlSoCntrListVOs((TesTmlSoCntrListVO[])getVOs(request, TesTmlSoCntrListVO.class,""));
		event.setTesTmlSoDtlVOs((TesTmlSoDtlVO[])getVOs(request, TesTmlSoDtlVO.class,""));

//        HashMap param_map = new HashMap();
//		String param_name = null;
//		Enumeration enums = request.getParameterNames();
//		while (enums.hasMoreElements()){
//			param_name = (String)enums.nextElement();
//			param_map.put(param_name,request.getParameter(param_name));
//
//			if(log.isDebugEnabled())log.debug("[param_name:" + param_name + "] - value:" + request.getParameter(param_name));
//		}

/*		
		int codeLength = 0;
		int codeLength2 = 0;
		int codeLength3 = 0;
		int codeLength4 = 0;
		codeLength 	= request.getParameterValues("ibflag")!=null?request.getParameterValues("ibflag").length:0;
		//codeLength2 = request.getParameterValues("ibflag")!=null?request.getParameterValues("ibflag").length:0;
		codeLength3 = request.getParameterValues("rvis_ibflag")!=null?request.getParameterValues("rvis_ibflag").length:0;
		codeLength4 = request.getParameterValues("n3rd_ibflag")!=null?request.getParameterValues("n3rd_ibflag").length:0;
		if(log.isDebugEnabled())log.debug("\n\n ESD_TES_0064HTMLAction -> codeLength = "+codeLength+"\n\n");
		if(log.isDebugEnabled())log.debug("\n\n ESD_TES_0064HTMLAction -> codeLength2 = "+codeLength2+"\n\n");
		if(log.isDebugEnabled())log.debug("\n\n ESD_TES_0064HTMLAction -> codeLength3 = "+codeLength3+"\n\n");
		if(log.isDebugEnabled())log.debug("\n\n ESD_TES_0064HTMLAction -> codeLength4 = "+codeLength4+"\n\n");
 
		TerminalInvoceContainer tes_tml_so_cntr_list  		 = TerminalInvoceContainer	 .fromRequest(request);
        TES_TML_SO_DTL       	tes_tml_so_dtl        		 = TES_TML_SO_DTL      		 .fromRequest(request);
        TES_TML_SO_HDR   		tes_tml_so_hdr        		 = TES_TML_SO_HDR			 .fromRequest(request);
		Collection 			 	tes_tml_so_cntr_lists 		 = TerminalInvoceContainer	 .fromRequest(request, codeLength);
		Collection 			 	tes_tml_so_dtls      		 = TES_TML_SO_DTL			 .fromRequest(request, codeLength);
		Collection 			 	terminal_invoice_rvis_lists  = TerminalInvoiceRvisList	 .fromRequest(request, codeLength3);
		Collection 			 	temp_rvis_lists 			 = TerminalInvoiceRvisList	 .fromRequest(request, codeLength3);
		Collection 			 	terminal_invoice_n3pty_lists = TerminalInvoiceN3rdPartyIF.fromRequest(request, codeLength4);
		Collection 			 	temp_n3pty_lists 			 = TerminalInvoiceN3rdPartyIF.fromRequest(request, codeLength4);
		if(log.isDebugEnabled())log.debug("0064EVENT tes_tml_so_hdr " + tes_tml_so_hdr);
//		if(log.isDebugEnabled())log.debug("001EVENT tes_tml_so_dtls " + tes_tml_so_dtls);
//		if(log.isDebugEnabled())log.debug("001EVENT terminal_invoice_rvis_lists " + terminal_invoice_rvis_lists);
//		if(log.isDebugEnabled())log.debug("001EVENT terminal_invoice_n3pty_lists " + terminal_invoice_n3pty_lists);
//		if(log.isDebugEnabled())log.debug("001EVENT temp_n3pty_lists " + temp_n3pty_lists);
        HashMap param_map = new HashMap();
		String param_name = null;
		Enumeration enums = request.getParameterNames();
		while (enums.hasMoreElements()){
			param_name = (String)enums.nextElement();
			param_map.put(param_name,request.getParameter(param_name));

			if(log.isDebugEnabled())log.debug("[param_name:" + param_name + "] - value:" + request.getParameter(param_name));
		}
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