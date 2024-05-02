/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_915HTMLAction.java
*@FileTitle : Off-dock CY Invoice의 ByPool fileupload 및 verify
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-24
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-24 byungheeyoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9150Event;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.syscommon.common.table.TesFileImpTmpVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ServiceProviderInvoiceManageSC로 실행요청<br>
 * - ServiceProviderInvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author byungheeyoo
 * @see EsdTes9150Event , ESD_TES_915EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TES_9152HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TES_9152HTMLAction 객체를 생성
	 */
	public ESD_TES_9152HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TES_9152Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		String mode = "";
//		java.util.HashMap param_map = new java.util.HashMap();
//		String param_name = null;
//		java.util.Enumeration enums = request.getParameterNames();
//		while (enums.hasMoreElements()){
//			param_name = (String)enums.nextElement();
//			//param_map.put(param_name,JSPUtil.getNull(request.getParameter(param_name)));
//			
//			if( "mode".equals(param_name) ) mode = JSPUtil.getNull(request.getParameter(param_name));
//			
//			log.debug("[param_name:" + param_name + "] - value:" + request.getParameter(param_name));
//		}
		
		EsdTes9152Event event = new EsdTes9152Event();
		log.debug(">>>>>>>>>>>>>>>>>> mode : "+mode);
		
		event.setMode(request.getParameter("mode"));
		event.setTesTmlSoHdrVO( (TesTmlSoHdrVO)getVO(request, TesTmlSoHdrVO.class) );
		event.setTesFileImpTmpVOs( (TesFileImpTmpVO[])getVOs(request, TesFileImpTmpVO.class, "") );
		
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