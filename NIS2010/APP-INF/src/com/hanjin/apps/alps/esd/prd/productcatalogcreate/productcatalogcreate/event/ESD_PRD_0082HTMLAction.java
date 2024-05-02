/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0081HTMLAction.java
*@FileTitle : ProductCatalogCreate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.22
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.08.22 정선용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSearchParamVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.prd.productcatalogcreate 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ProductCatalogCreateSC로 실행요청<br>
 * - ProductCatalogCreateSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author sun yong Jung
 * @see ProductCatalogCreateEvent 참조
 * @since J2EE 1.6
 */

public class ESD_PRD_0082HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_PRD_0081HTMLAction 객체를 생성
	 */
	public ESD_PRD_0082HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ProductCatalogCreateEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdPrd0082Event event = new EsdPrd0082Event();
		event.setAttribute("pgmNo", request.getServletPath().substring(1,13));
		log.debug("\n\n ESD_PRD_0082HTMLAction-------------------------------------------------------");
		log.debug("\n\n f_cmf:");

//		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setAttribute("request", request);
			

//		}
		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setPrdSearchParamVO ((PrdSearchParamVO)getVO(request, PrdSearchParamVO.class ));
			log.debug("\n\n PrdSearchParamVO::"+event.getPrdSearchParamVO().toString());
		}

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