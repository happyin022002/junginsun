/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_2001HTMLAction.java
*@FileTitle : Guarantee Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.13 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeCntrInfoVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TesGnteCntrListVO;
import com.hanjin.syscommon.common.table.TesGnteHdrVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.tes.serviceproviderguaranteemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value 를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event 로 변환, request 에 담아 ServiceProviderGuaranteeManageSC로 실행요청<br>
 * - ServiceProviderGuaranteeManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request 에 셋팅<br>
 * @author yOng hO lEE
 * @see GuaranteeManageEvent 참조
 * @since J2EE 1.6
 */

public class ESD_TES_2001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_TES_2001HTMLAction 객체를 생성
	 */
	public ESD_TES_2001HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value 를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GuaranteeManageEvent로 파싱하여 request 에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface 를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand			command = FormCommand.fromRequest(request);
		EsdTes2001Event		event	= new EsdTes2001Event();
		
		
		event.setTesGnteHdrVO			((TesGnteHdrVO)			getVO(request, TesGnteHdrVO .class));
		event.setTesGnteCntrListVOs		(((TesGnteCntrListVO[])	getVOs(request, TesGnteCntrListVO .class, "")) );
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setSearchUSGuaranteeCntrInfoVO	((SearchUSGuaranteeCntrInfoVO)getVO(request, SearchUSGuaranteeCntrInfoVO .class));
		}

		return  event;
	}

	/**
	 * HttpRequest의 attribute 에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request 에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface 를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute 에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request 에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface 를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}