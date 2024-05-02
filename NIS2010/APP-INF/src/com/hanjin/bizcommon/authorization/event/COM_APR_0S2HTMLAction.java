/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : COM_APR_0S2HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.23
*@LastModifier : 심성윤
*@LastVersion : 1.0
* 2015.07.23 심성윤
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.authorization.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.bizcommon.authorization.vo.AuthorizationCommonVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationProgramInfoVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationRouteVO;
import com.hanjin.bizcommon.authorization.vo.SearchAuthAproVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.bizcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BIZCOMMONSC로 실행요청<br>
 * - BIZCOMMONSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 심성윤
 * @see ComApr0S1Event , COM_APR_0S1EventResponse 참조
 * @since J2EE 1.4
 */
public class COM_APR_0S2HTMLAction extends HTMLActionSupport {

	/**
	 * COM_APR_0S1HTMLAction 객체를 생성
	 */
	public COM_APR_0S2HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 COM_ENS_0S1Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		ComApr0S2Event event = new ComApr0S2Event(); 
    	
    	//event.setAuthorizationStaffVO((AuthorizationStaffVO)getVO(request, AuthorizationStaffVO.class)); 
    	//event.setAuthorizationCsrVO((AuthorizationCsrVO)getVO(request, AuthorizationCsrVO.class));
    	event.setAuthorizationRouteVOS((AuthorizationRouteVO[])getVOs(request, AuthorizationRouteVO.class, ""));
    	event.setAuthorizationCommonVO((AuthorizationCommonVO)getVO(request, AuthorizationCommonVO.class));
    	event.setSearchAuthAproVO((SearchAuthAproVO)getVO(request, SearchAuthAproVO.class));
    	
    	event.setAuthorizationProgramInfoVO((AuthorizationProgramInfoVO)getVO(request, AuthorizationProgramInfoVO.class));
    	event.setAuthorizationProgramInfoVOS((AuthorizationProgramInfoVO[])getVOs(request, AuthorizationProgramInfoVO.class,  ""));
    	event.setCommandClassName("AuthorizationSC");
        event.setFormCommand(command);
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