/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_PRD_0001HTMLAction.java
 *@FileTitle : Geographic Hierarchy 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-08-30
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-08-30 kimyoungchul
 * 1.0 최초 생성
 * 2009.07.01 alps framework 구조로 변경 Noh Seung Bae
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.geohierarchymanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.prd.networknodemanage.geohierarchymanage.vo.SearchGeoHierarchyManageVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.prd.networknodemanage 화면을 통해 서버로 전송되는 HTML DOM
 * 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 NetworkNodeManageSC로 실행요청<br>
 * - NetworkNodeManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author kimyoungchul
 * @see EsdPrd0001Event , EsdPrd001EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_PRD_0001HTMLAction extends HTMLActionSupport{

	/**
	 * ESD_PRD_0001HTMLAction 객체를 생성
	 */
	public ESD_PRD_0001HTMLAction(){
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdPrd001Event로 파싱하여 request에 셋팅<br>
	 * @param request
	 * @return Event
	 * @throws com.hanjin.framework.core.controller.html.HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException{
		/* Get Parameters from Http Request */
		FormCommand command = FormCommand.fromRequest(request);
		EsdPrd0001Event event = new EsdPrd0001Event();
		event.setAttribute("pgmNo", request.getServletPath().substring(1,13));

		if(command.isCommand(FormCommand.SEARCH)){
			event.setSearchGeoHierarchyManageVO((SearchGeoHierarchyManageVO) getVO(request, SearchGeoHierarchyManageVO.class));
		}

		request.setAttribute("Event", event);
		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface를 구현한 객체
	 */
	@Override
	public void doEnd(HttpServletRequest request, EventResponse eventResponse){
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event){
		request.setAttribute("Event", event);
	}
}
