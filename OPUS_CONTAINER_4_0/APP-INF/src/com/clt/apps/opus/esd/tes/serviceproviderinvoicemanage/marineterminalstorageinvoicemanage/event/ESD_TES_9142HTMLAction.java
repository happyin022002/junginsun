/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_914HTMLAction.java
*@FileTitle : Off-dock CY Invoice의 ByPool fileupload 및 verify
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-24
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-24 byungheeyoo
* 1.0 최초 생성
* 2009-01-16 : 성능측정 관련 pageURL 찍기 추가 
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.tes.common.tescommon.basic.TESCommonBC;
import com.clt.apps.opus.esd.tes.common.tescommon.util.TESUtil;
import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.syscommon.common.table.TesFileImpTmpVO;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;



/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ServiceProviderInvoiceManageSC로 실행요청<br>
 * - ServiceProviderInvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author byungheeyoo
 * @see EsdTes9142Event , ESD_TES_9142EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TES_9142HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TES_9142HTMLAction 객체를 생성
	 */
	public ESD_TES_9142HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TES_9142Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		HashMap param_map = new HashMap();
		String param_name = null;
		java.util.Enumeration enums = request.getParameterNames();
		while (enums.hasMoreElements()){
			param_name = (String)enums.nextElement();
			param_map.put( param_name,request.getParameter(param_name) );
		}		
		param_map.put(TESCommonBC.PERF_PAGE_URL_PARAMETER_NAME,request.getRequestURI());
		
		String pageURL = TESUtil.getPerfPageURL(param_map);		
		String perfParams = TESUtil.getParamNotNullValueChkPerfParamSize(param_map);
		
		EsdTes9142Event event = new EsdTes9142Event();

		event.setPageURL( pageURL );
		event.setPerfParams( perfParams );
		//event.setCommonVO( (MarineTerminalStorageInvoiceManageVO)getVO( request, MarineTerminalStorageInvoiceManageVO.class ) );
		event.setTesTmlSoHdrVO( (TesTmlSoHdrVO)getVO(request, TesTmlSoHdrVO.class) );
		event.setTesFileImpTmpVOs( (TesFileImpTmpVO[])getVOs(request, TesFileImpTmpVO.class, "") );
		
		event.setTesTmlSoCntrListVO((TesTmlSoCntrListVO)getVO( request, TesTmlSoCntrListVO.class ));
		event.setTesCommonVO((TesCommonVO)getVO( request, TesCommonVO.class ));
		
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