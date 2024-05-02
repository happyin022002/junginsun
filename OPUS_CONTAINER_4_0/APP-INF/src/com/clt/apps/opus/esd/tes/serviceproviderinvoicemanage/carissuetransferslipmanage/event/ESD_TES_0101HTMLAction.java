/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_0101HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-10-30 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.syscommon.common.table.ApInvHdrVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ServiceProviderInvoiceManageSC로 실행요청<br>
 * - ServiceProviderInvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author yoo
 * @see EsdTes0101Event , EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TES_0101HTMLAction extends HTMLActionSupport {

	public ESD_TES_0101HTMLAction() {
	}
	
	/** perform 수행
	 * 
	 *  @param HttpServletRequest request
	 *  @return Event
	 *  @throws HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("\n#####################################\nESD_TES_0101HTMLAction\n#####################################\n");
		
		EsdTes0101Event event = new EsdTes0101Event();
		event.setApInvHdrVO((ApInvHdrVO)getVO(request, ApInvHdrVO.class));
		event.setApInvHdrVOs((ApInvHdrVO[])getVOs(request, ApInvHdrVO.class));
		
////		FormCommand f_cmd = FormCommand.fromRequest(request);
//		
//		EsdTes0101Event event = null; 
//		AP_INV_HDR ap_inv_hdr = null;
//		Collection ap_inv_hdrs = null; 
//		
//		int codeLength = 0;
//        
//		HashMap param_map = new HashMap();
//		String param_name = null;
//		Enumeration enums = request.getParameterNames();
//		while (enums.hasMoreElements()){
//			param_name = (String)enums.nextElement();
//			param_map.put(param_name,request.getParameter(param_name));
//			log.debug("[param_name:" + param_name + "] - value:" + request.getParameter(param_name));
//		}         
//		
//		codeLength = request.getParameterValues("ibflag")!=null?request.getParameterValues("ibflag").length:0;
//		log.debug("\n codeLength:"+codeLength);
//		ap_inv_hdr 	= AP_INV_HDR.fromRequest(request);
//		ap_inv_hdrs	= AP_INV_HDR.fromRequest(request,codeLength);
//
//		event = new EsdTes0101Event(
//				ap_inv_hdr,  
//				ap_inv_hdrs, 
//				param_map
//				);			
//
//		request.setAttribute("Event", event);

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
