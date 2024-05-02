/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_PRD_0036HTMLAction.java
 *@FileTitle : Yard별 CCT
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-09
 *@LastModifier : Jeongseon An
 *@LastVersion : 1.0
 * 20090608 jsy
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.event;

import com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.vo.NewCCTManageVO;
import com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.vo.PrdCstSkdByPortVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * HTTP Parser<br>
 * - com.clt.apps.esd.prd.networknodemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 NetworkNodeManageSC로 실행요청<br>
 * - NetworkNodeManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Jeongseon An
 * @see EsdPrd0036Event , ESD_PRD_036EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_PRD_0036HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 6333237295305704560L;

	/**
	 * ESD_PRD_0036HTMLAction 객체를 생성
	 */
	public ESD_PRD_0036HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_PRD_036Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsdPrd0036Event event = new EsdPrd0036Event();
		event.setAttribute("pgmNo", request.getServletPath().substring(1, 13));

		if (command.isCommand(FormCommand.SEARCH)) {
			event.setNewCCTManageVO((NewCCTManageVO) getVO(request, NewCCTManageVO.class));
		} else if (command.isCommand(FormCommand.MULTI)) {
			event.setNewCCTManageVOs((NewCCTManageVO[]) getVOs(request, NewCCTManageVO.class));
		} else if (command.isCommand(FormCommand.SEARCH01)) {
			event.setPrdCstSkdByPortVO((PrdCstSkdByPortVO) getVO(request, PrdCstSkdByPortVO.class));
		} else if (command.isCommand(FormCommand.MULTI01)) {
			event.setPrdCstSkdByPortVOs((PrdCstSkdByPortVO[]) getVOs(request, PrdCstSkdByPortVO.class, "sheet2_"));
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
