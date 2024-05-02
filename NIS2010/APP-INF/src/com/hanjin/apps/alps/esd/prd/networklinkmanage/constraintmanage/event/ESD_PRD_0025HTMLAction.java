/*=========================================================
 *Copyright(c) 2018 SM Lines
 *@FileName : ESD_PRD_0025HTMLAction.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2018-01-08
 *@LastModifier :
 *@LastVersion : 1.0 
 * 2018-01-08
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchListCnstExptVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.CommonWebKeys;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


public class ESD_PRD_0025HTMLAction extends HTMLActionSupport{

	/**
	 * ESD_PRD_0024HTMLAction 객체를 생성
	 */
	public ESD_PRD_0025HTMLAction(){
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_PRD_024Event로 파싱하여 request에 셋팅<br>
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

		FormCommand command = FormCommand.fromRequest(request);
		EsdPrd0025Event event = new EsdPrd0025Event();
		
		event.putValue("userId", userId);
		
		event.setSearchListCnstExptVO((SearchListCnstExptVO) getVO(request, SearchListCnstExptVO.class));
		
		if(command.isCommand(FormCommand.MULTI)){
			event.setSearchListCnstExptVOs((SearchListCnstExptVO[]) getVOs(request, SearchListCnstExptVO.class));
		}else if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchListCnstExptVO((SearchListCnstExptVO) getVO(request, SearchListCnstExptVO.class));
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
