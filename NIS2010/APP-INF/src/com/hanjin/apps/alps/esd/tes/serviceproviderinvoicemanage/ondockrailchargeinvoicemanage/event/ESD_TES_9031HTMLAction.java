/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_903_1HTMLAction.java
*@FileTitle : Volume Adjustment PopUp 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-15
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-15 parkyeonjin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.vo.OndockRailChargeInvoiceCommonVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.syscommon.common.table.TesTmlSoCntrListVO;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;



/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ServiceProviderInvoiceManageSC로 실행요청<br>
 * - ServiceProviderInvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author parkyeonjin
 * @see EsdTes9031Event , ESD_TES_903_1EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TES_9031HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TES_903_1HTMLAction 객체를 생성
	 */
	public ESD_TES_9031HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TES_903_1Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		EsdTes9031Event event = new EsdTes9031Event();
		
		event.setOndockRailChargeInvoiceCommonVO((OndockRailChargeInvoiceCommonVO)getVO(request, OndockRailChargeInvoiceCommonVO .class));
		event.setTesTmlSoCntrListVO((TesTmlSoCntrListVO)getVO(request, TesTmlSoCntrListVO.class));
		event.setTesTmlSoDtlVO((TesTmlSoDtlVO)getVO(request, TesTmlSoDtlVO.class));
		//event.setTesTmlSoCntrListVOs((TesTmlSoCntrListVO[])getVOs(request, TesTmlSoCntrListVO.class,""));
		event.setOndockRailChargeInvoiceCommonVOs((OndockRailChargeInvoiceCommonVO[])getVOs(request, OndockRailChargeInvoiceCommonVO.class,""));

		
		HashMap param_map = new HashMap();
		String param_name = null;
		Enumeration enums = request.getParameterNames();
		while (enums.hasMoreElements()){
			param_name = (String)enums.nextElement();
			param_map.put(param_name,request.getParameter(param_name));
			if(log.isDebugEnabled())log.debug("[param_name:" + param_name + "] - value:" + request.getParameter(param_name));
		}

//		int codeLength = 0;
//
//		codeLength = request.getParameterValues("ibflag")!=null?request.getParameterValues("ibflag").length:0;
//		Collection 			 	tes_tml_so_cntr_lists 		 = TES_TML_SO_CNTR_LIST	  	 .fromRequest(request, codeLength);

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