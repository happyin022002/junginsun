/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_923_3HTMLAction.java
*@FileTitle : Off-dock CY Invoice 3rd 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-27
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-11-27 byungheeyoo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.tes.common.tescommon.basic.TESCommonBC;
import com.clt.apps.opus.esd.tes.common.tescommon.util.TESUtil;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.vo.OffdockCYInvoiceManageVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;
import com.clt.syscommon.common.table.TesTmlSoRvisListVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ServiceProviderInvoiceManageSC로 실행요청<br>
 * - ServiceProviderInvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author byungheeyoo
 * @see EsdTes9233Event , ESD_TES_923_3EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TES_9233HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TES_923_3HTMLAction 객체를 생성
	 */
	public ESD_TES_9233HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TES_923_3Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		EsdTes9233Event event = new EsdTes9233Event();
		
		// Performance 추적용 Log 추가.
		java.util.HashMap<String, Object>	paramMap	= new java.util.HashMap<String, Object>();
		java.util.Enumeration	enums	= request.getParameterNames();
		String	paramName	= null;

		while (enums.hasMoreElements()){
			paramName	= (String)enums.nextElement();
			paramMap.put( paramName,request.getParameter(paramName) );
		}
		paramMap.put(TESCommonBC.PERF_PAGE_URL_PARAMETER_NAME,request.getRequestURI());
		
		String	pageURL		= TESUtil.getPerfPageURL(paramMap);		
		String	perfParams	= TESUtil.getParamNotNullValueChkPerfParamSize(paramMap);
		
		event.setPageURL	( pageURL );
		event.setPerfParams	( perfParams );
		
		
		event.setOffdockCYInvoiceManageVO( (OffdockCYInvoiceManageVO)getVO(request, OffdockCYInvoiceManageVO.class) );	
		event.setOffdockCYInvoiceManageVOs( (OffdockCYInvoiceManageVO[])getVOs(request, OffdockCYInvoiceManageVO.class) );
		event.setTesN3rdPtyIfVO( (TesN3rdPtyIfVO)getVO(request, TesN3rdPtyIfVO.class) );
		event.setTesN3rdPtyIfVOs( (TesN3rdPtyIfVO[])getVOs(request, TesN3rdPtyIfVO.class) );
		
		event.setTesTmlSoHdrVO( (TesTmlSoHdrVO)getVO(request, TesTmlSoHdrVO.class) );
		event.setTesTmlSoCntrListVOs( (TesTmlSoCntrListVO[])getVOs(request, TesTmlSoCntrListVO.class, "") );
		event.setTesTmlSoRvisListVOs( (TesTmlSoRvisListVO[])getVOs(request, TesTmlSoRvisListVO.class, "") );		
		event.setMarineTerminalInvoiceCommonVOs( (MarineTerminalInvoiceCommonVO[])getVOs(request, MarineTerminalInvoiceCommonVO.class, "") );		
		event.setTesTmlSoCntrListVO( (TesTmlSoCntrListVO)getVO(request, TesTmlSoCntrListVO.class) );
		
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