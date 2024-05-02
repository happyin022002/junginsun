/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_PRD_0058HTMLAction.java
 *@FileTitle : USA IRG FULL 에서 priority 변경시 사용
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-08-06
 *@LastModifier : kimkwijin
 *@LastVersion : 1.1 
 * 1.0 최초 생성
 * 2006-09-22 jungsunyong
 *
 * 1.1 수정
 * 2009-08-06 kimkwijin
 *
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.lnlandRouteUSVO;
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
 * @see ESD_PRD_058Event , ESD_PRD_058EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_PRD_0058HTMLAction extends HTMLActionSupport{

	/**
	 * ESD_PRD_0058HTMLAction 객체를 생성
	 */
	public ESD_PRD_0058HTMLAction(){
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_PRD_058Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException{

		FormCommand command = FormCommand.fromRequest(request);
		EsdPrd0058Event event = new EsdPrd0058Event();
		event.setAttribute("pgmNo", request.getServletPath().substring(1,13));
		
		if(command.isCommand(FormCommand.SEARCHLIST) || command.isCommand(FormCommand.SEARCH12)){ //FULL 기본데이타 조회
			event.setInlandRouteUSVO((lnlandRouteUSVO) getVO(request, lnlandRouteUSVO.class));
			request.setAttribute("Event", event);

		}else if(command.isCommand(FormCommand.MULTI)){ //PRIO_SEQ 수정
			event.setInlandRouteUSVOs((lnlandRouteUSVO[]) getVOs(request, lnlandRouteUSVO.class, ""));
		}


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
