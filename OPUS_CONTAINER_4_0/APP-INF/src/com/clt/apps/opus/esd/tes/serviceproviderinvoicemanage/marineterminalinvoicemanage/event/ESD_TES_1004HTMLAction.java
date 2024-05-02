/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_1004HTMLAction.java
*@FileTitle : Marine Terminal Invoice 등록 및 Confirm화면-Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-20
*@LastModifier : PARK CHAE HEUNG
*@LastVersion : 1.0
* 2009-11-20 PARK CHAE HEUNG
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.syscommon.common.table.TesMgstFuelChgVO;

/**
 *   ESD 1004 Request를 해당 VO에 넣어준다. <br>
 * 
 *   @author 9009637
 *   @see  EsdTes1004Event.java
 *   @since J2EE 1.6
 */
public class ESD_TES_1004HTMLAction extends HTMLActionSupport {

	public ESD_TES_1004HTMLAction() {
		log.debug("\n\n  constr - ESD_TES_1004HTMLAction  \n\n");
	}

	/**
	 *  perform request를 vo에 담아준다.
	 *  
	 *  @param request HttpServletRequest
	 *  @return Event
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
//		java.util.HashMap param_map = new java.util.HashMap();
//		String param_name = null;
//		java.util.Enumeration enums = request.getParameterNames();
//		while (enums.hasMoreElements()){
//			param_name = (String)enums.nextElement();
//			log.debug("[param_name:" + param_name + "] - value:" + request.getParameter(param_name));
//		}
		
		EsdTes1004Event event = new EsdTes1004Event();

		event.setMarineTerminalInvoiceCommonVO( (MarineTerminalInvoiceCommonVO)getVO(request, MarineTerminalInvoiceCommonVO.class) );
		event.setTesMgstFuelChgVOs( (TesMgstFuelChgVO[])getVOs(request, TesMgstFuelChgVO.class, "") );
		
		return event;
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
