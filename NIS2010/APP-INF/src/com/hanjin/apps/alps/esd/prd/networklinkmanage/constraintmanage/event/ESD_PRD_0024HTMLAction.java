/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_PRD_0024HTMLAction.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2008-01-15
 *@LastModifier : Su-Jung Kim
 *@LastVersion : 1.0 
 * 2008-01-15 Su-Jung Kim
 * 1.0 최초 생성
 * 2012.06.07 이준근 [CHM-201217814-01] Constraint Management 입력 Data Validation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.CheckCommodityVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.ConstraintVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchLinkConstraintVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchNodeConstraintVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchRouteConstraintVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.event 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 Constarint ManagementSC로 실행요청<br>
 * - Constarint ManagementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Su-Jung Kim
 * @see EsdPrd0024Event , ESD_PRD_024EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_PRD_0024HTMLAction extends HTMLActionSupport{

	/**
	 * ESD_PRD_0024HTMLAction 객체를 생성
	 */
	public ESD_PRD_0024HTMLAction(){
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
//		SignOnUserAccount account = (SignOnUserAccount) request.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
//		String userId = account.getUsr_id();
//		String[] userAuth = account.getUserAuth();

		FormCommand command = FormCommand.fromRequest(request);
		EsdPrd0024Event event = new EsdPrd0024Event();
		event.setAttribute("pgmNo", request.getServletPath().substring(1,13));
		event.setConstraintVO((ConstraintVO) getVO(request, ConstraintVO.class));

		if(command.isCommand(FormCommand.MULTI01)){
			event.setSearchNodeConstraintVOs((SearchNodeConstraintVO[]) getVOs(request, SearchNodeConstraintVO.class, "s_"));
		}else if(command.isCommand(FormCommand.MULTI02)){
			event.setSearchLinkConstraintVOs((SearchLinkConstraintVO[]) getVOs(request, SearchLinkConstraintVO.class, "s_"));
		}else if(command.isCommand(FormCommand.MULTI03)){
			event.setSearchRouteConstraintVOs((SearchRouteConstraintVO[]) getVOs(request, SearchRouteConstraintVO.class, "s_"));
		}else if(command.isCommand(FormCommand.COMMAND03)){
			event.setSearchRouteConstraintVOs((SearchRouteConstraintVO[]) getVOs(request, SearchRouteConstraintVO.class, "s_"));
		}else if(command.isCommand(FormCommand.SEARCH11)){
			event.setCheckCommodityVO((CheckCommodityVO) getVO(request, CheckCommodityVO.class));
			event.setRow(JSPUtil.getNull(request.getParameter("row")));
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