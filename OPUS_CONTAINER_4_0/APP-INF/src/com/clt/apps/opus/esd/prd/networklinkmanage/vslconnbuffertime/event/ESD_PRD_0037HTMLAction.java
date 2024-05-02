/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_PRD_0037HTMLAction.java
 *@FileTitle :ESD_PRD_0037HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.08.03
 *@LastModifier : 
 *@LastVersion : 1.0
 =========================================================*/

package com.clt.apps.opus.esd.prd.networklinkmanage.vslconnbuffertime.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.prd.networklinkmanage.vslconnbuffertime.vo.VslConnBufferTimeListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * 
 * @author
 * @see EsdPrd0037Event , ESD_PRD_0037HTMLAction 참조
 * @since J2EE 1.4
 */
public class ESD_PRD_0037HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_PRD_0037HTMLAction 객체를 생성
	 */
	public ESD_PRD_0037HTMLAction() {
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
		EsdPrd0037Event event = new EsdPrd0037Event();
		event.setAttribute("pgmNo", request.getServletPath().substring(1, 13));

		if (command.isCommand(FormCommand.SEARCH)) {
			event.setVslConnBufferTimeListVO((VslConnBufferTimeListVO) getVO(request, VslConnBufferTimeListVO.class));
		} else if (command.isCommand(FormCommand.MULTI)) {
			event.setVslConnBufferTimeListVOs((VslConnBufferTimeListVO[]) getVOs(request, VslConnBufferTimeListVO.class));
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
