/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0018HTMLAction.java
*@FileTitle : Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2009.10.13 정행룡
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.StatusCondVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * CPS_CNI_0018 Status
 * HTTP Parser<br>
 * @author 정행룡
 * @see CpsCni0018Event 참조
 * @since J2EE 1.4
 */

public class CPS_CNI_0018HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_CNI_0018HTMLAction 객체를 생성
	 */
	public CPS_CNI_0018HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CpsCni0018Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		
		//이벤트 객체 생성 
		CpsCni0018Event event = new CpsCni0018Event();
		
		// ----------------------------------------------------
		// 이벤트 처리 
		// ----------------------------------------------------		
		// [open , retrieve]
		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			StatusCondVO statusCondVO = (StatusCondVO)getVO(request, StatusCondVO.class);
			event.setStatusCondVO(statusCondVO);
			
		} else if(command.isCommand(FormCommand.PRINT)) {
			StatusCondVO statusCondVO = (StatusCondVO)getVO(request, StatusCondVO.class);
			event.setStatusCondVO(statusCondVO);
		}
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