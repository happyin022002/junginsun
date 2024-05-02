/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_SCE_0123HTMLAction.java
*@FileTitle : 화주전송 Schedule 관리화면
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.01.08 함대성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.AdjustmentVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.RouteForBLVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.sce.visibilitymanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AdjustmentVO로 실행요청<br>
 * - AdjustmentVO에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author HAM DAE SUNG
 * @see VisibilityManageEvent 참조
 * @since J2EE 1.6
 */

public class ESD_SCE_0123HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_SCE_0123HTMLAction 객체를 생성
	 */
	public ESD_SCE_0123HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VisibilityManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdSce0123Event event = new EsdSce0123Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setAdjustmentVO((AdjustmentVO)getVO(request, AdjustmentVO .class));
		}
		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setRouteForBLVO((RouteForBLVO)getVO(request, RouteForBLVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			event.setAdjustmentVOs((AdjustmentVO[])getVOs(request, AdjustmentVO .class,"sheet2_"));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.putValue("cust_trd_prnr_id", request.getParameter("cust_trd_prnr_id"));
			event.putValue("partnerName", request.getParameter("partnerName"));
		}
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