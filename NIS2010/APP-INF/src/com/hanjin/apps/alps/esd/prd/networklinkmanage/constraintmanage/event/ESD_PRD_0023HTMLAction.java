/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_PRD_0023HTMLAction.java
 *@FileTitle : Link Constraint Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-16
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-10-16 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.CommonWebKeys;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.prd.networklinkmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 NetworkLinkManageSC로 실행요청<br>
 * - NetworkLinkManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author kimyoungchul
 * @see EsdPrd0023Event , ESD_PRD_023EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_PRD_0023HTMLAction extends HTMLActionSupport{

	/**
	 * ESD_PRD_0023HTMLAction 객체를 생성
	 */
	public ESD_PRD_0023HTMLAction(){
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_PRD_023Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException{
		log.debug("\n**********************************************************************"
				+ "\n[CALL] HTML Action ----------------------------- ");

		/* Login User's Identification */
		SignOnUserAccount account = (SignOnUserAccount) request.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		String userId = account.getUsr_id();
		String[] userAuth = account.getUserAuth();
		log.debug("\n >>> userAuth : " + userAuth);

		/* Get Parameters from Http Request */
		EsdPrd0023Event event = new EsdPrd0023Event();
		event.setAttribute("pgmNo", request.getServletPath().substring(1,13));
		
		event.putValue("link_div", request.getParameter("link_div"));
		event.putValue("orgi_node", request.getParameter("orgi_node"));
		event.putValue("dest_node", request.getParameter("dest_node"));
		event.putValue("userId", userId);
		event.putValue("userDept", "SELCOL");

		/* case of MULTI 
		 * -1 - null
		 *  0 -
		 *  1 -
		 *  2 - SEARCH /w Event
		 *  3 -
		 *  4 - MODIFY
		 *  5 -
		 *  6 -
		 *  7 - MULTI
		 *  8 -
		 *  9 -
		 */
		FormCommand f_cmd = FormCommand.fromRequest(request);

		if(f_cmd.isCommand(FormCommand.MULTI)){ // IBSheet 저장
			event.putValue("sStatus", request.getParameterValues("sStatus"));
			event.putValue("sNodeFm", request.getParameterValues("sNodeFm"));
			event.putValue("sNodeTo", request.getParameterValues("sNodeTo"));
			event.putValue("sTsMode", request.getParameterValues("sTsMode"));
			event.putValue("sCateCode", request.getParameterValues("sCateCode"));
			event.putValue("sItemCode", request.getParameterValues("sItemCode"));
			event.putValue("sItemName", request.getParameterValues("sItemName"));
			event.putValue("sReject", request.getParameterValues("sReject"));
			event.putValue("sCnstVal", request.getParameterValues("sCnstVal"));
			event.putValue("sCnstUnit", request.getParameterValues("sCnstUnit"));
			event.putValue("sEffFm", request.getParameterValues("sEffFm"));
			event.putValue("sEffTo", request.getParameterValues("sEffTo"));
			event.putValue("sCreDt", request.getParameterValues("sCreDt"));
			event.putValue("sCnstRmk", request.getParameterValues("sCnstRmk"));
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
