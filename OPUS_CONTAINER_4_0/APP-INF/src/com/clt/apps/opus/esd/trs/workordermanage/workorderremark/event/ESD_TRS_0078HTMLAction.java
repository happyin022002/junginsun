/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_TRS_0078HTMLAction.java
 *@FileTitle : Office별로 Cost/Trans Mode 및 IN/OUT Bound 별 W/O에 공통 적용할 비고 사항을 관리하는 화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-08
 *@LastModifier : poong_yeon
 *@LastVersion : 1.0
 * 2006-11-08 poong_yeon
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderremark.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.trs.workordermanage.workorderremark.vo.WorkOrderRemarkVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.workordermanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WorkOrderManageSC로 실행요청<br>
 * - WorkOrderManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author poong_yeon
 * @see EsdTrs0078Event , ESD_TRS_078EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0078HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1762503351987143665L;

	/**
	 * ESD_TRS_0078HTMLAction 객체를 생성
	 */
	public ESD_TRS_0078HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_078Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0078Event event = new EsdTrs0078Event();

		WorkOrderRemarkVO workOrderRemarkVO = new WorkOrderRemarkVO();
		if (command.isCommand(FormCommand.SEARCH02)) {
			event.setWorkOrderRemarkVO((WorkOrderRemarkVO) getVO(request, WorkOrderRemarkVO.class));
		} else if (command.isCommand(FormCommand.REMOVE01)) {
			event.setWorkOrderRemarkVO((WorkOrderRemarkVO) getVO(request, WorkOrderRemarkVO.class));
			event.setWorkOrderRemarkVOs(workOrderRemarkVO.fromRequestGrid(request));
		} else if (command.isCommand(FormCommand.MULTI01)) {
			event.setWorkOrderRemarkVO((WorkOrderRemarkVO) getVO(request, WorkOrderRemarkVO.class));
			event.setWorkOrderRemarkVOs(workOrderRemarkVO.fromRequestGrid(request));
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