/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_PRD_0056HTMLAction.java
 *@FileTitle : Inland Route 정보관리화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-04
 *@LastModifier : jungsunyong
 *@LastVersion : 1.0
 * 2006-09-04 jungsunyong
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.EmptySaveInlandRouteDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.EmptySaveInlandRouteMstVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.prd.networklinkmanager 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 NetworkLinkManageSC로 실행요청<br>
 * - NetworkLinkManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author jungsunyong
 * @see EsdPrd0056Event , ESD_PRD_056EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_PRD_0056HTMLAction extends HTMLActionSupport{

	/**
	 * ESD_PRD_0056HTMLAction 객체를 생성
	 */
	public ESD_PRD_0056HTMLAction(){
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_PRD_056Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException{
		FormCommand command = FormCommand.fromRequest(request);

		EsdPrd0056Event event = new EsdPrd0056Event();
		event.setAttribute("pgmNo", request.getServletPath().substring(1,13));

		event.setSearchConditionVO((SearchConditionVO) getVO(request, SearchConditionVO.class));

//		if(command.isCommand(FormCommand.SEARCHLIST)){
//		}else 
		if(command.isCommand(FormCommand.SEARCH)){
			event.setInlandRouteDetVO((InlandRouteDetVO) getVO(request, InlandRouteDetVO.class));
		}else if(command.isCommand(FormCommand.MULTI)){
			event.setEmptySaveInlandRouteMstVOs((EmptySaveInlandRouteMstVO[]) getVOs(request, EmptySaveInlandRouteMstVO.class, ""));
		}else if(command.isCommand(FormCommand.MULTI01)){
			event.setEmptySaveInlandRouteDetVO((EmptySaveInlandRouteDetVO) getVO(request, EmptySaveInlandRouteDetVO.class));
			event.setEmptySaveInlandRouteDetVOs((EmptySaveInlandRouteDetVO[]) getVOs(request, EmptySaveInlandRouteDetVO.class, ""));
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
