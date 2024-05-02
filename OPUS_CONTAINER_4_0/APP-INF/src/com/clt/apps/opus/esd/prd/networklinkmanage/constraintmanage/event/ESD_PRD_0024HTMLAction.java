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
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.CheckCommodityVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.ConstraintVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchHubConstraintListVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchLinkConstraintVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchNodeConstraintVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchRouteConstraintVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.event 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 Constarint ManagementSC로 실행요청<br>
 * - Constarint ManagementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Su-Jung Kim
 * @see EsdPrd0024Event , ESD_PRD_024EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_PRD_0024HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 7021164363597636346L;

	/**
	 * ESD_PRD_0024HTMLAction 객체를 생성
	 */
	public ESD_PRD_0024HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_PRD_024Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsdPrd0024Event event = new EsdPrd0024Event();
		event.setAttribute("pgmNo", request.getServletPath().substring(1, 13));

		ConstraintVO constraintVO = (ConstraintVO) getVO(request, ConstraintVO.class);

		if (command.isCommand(FormCommand.MULTI01)) {
			event.setSearchNodeConstraintVOs((SearchNodeConstraintVO[]) getVOs(request, SearchNodeConstraintVO.class, ""));
		} else if (command.isCommand(FormCommand.MULTI02)) {
			event.setSearchLinkConstraintVOs((SearchLinkConstraintVO[]) getVOs(request, SearchLinkConstraintVO.class, ""));
		} else if (command.isCommand(FormCommand.MULTI03)) {
			event.setSearchRouteConstraintVOs((SearchRouteConstraintVO[]) getVOs(request, SearchRouteConstraintVO.class, ""));
		} else if (command.isCommand(FormCommand.MULTI04)) {
			event.setSearchHubConstraintListVOs((SearchHubConstraintListVO[]) getVOs(request, SearchHubConstraintListVO.class, ""));
		} else if (command.isCommand(FormCommand.SEARCH11)) {
			event.setCheckCommodityVO((CheckCommodityVO) getVO(request, CheckCommodityVO.class));
			event.setRow(JSPUtil.getNull(request.getParameter("row")));
		} else if (command.isCommand(FormCommand.SEARCH12)) {
			constraintVO.setpGubun("TP");
		} else if (command.isCommand(FormCommand.SEARCH13)) {
			constraintVO.setpGubun("SZ");
		}
		event.setConstraintVO(constraintVO);
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
