/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_1015HTMLAction.java
*@FileTitle : Application Request & Approval Status - DG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.26 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgRequestListOptionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.ScgLodRjctCdVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.vop.scg.cargoloadingapproval 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CargoLoadingApprovalSC로 실행요청<br>
 * - CargoLoadingApprovalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Dohyoung Lee
 * @see CargoLoadingApprovalEvent 참조
 * @since J2EE 1.6
 */

public class VOP_SCG_1015HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_SCG_1015HTMLAction 객체를 생성
	 */
	public VOP_SCG_1015HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CargoLoadingApprovalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopScg1015Event event = new VopScg1015Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setScgRequestListOptionVO((ScgRequestListOptionVO)getVO(request, ScgRequestListOptionVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			event.setScgRequestListOptionVOS((ScgRequestListOptionVO[])getVOs(request, ScgRequestListOptionVO .class,""));
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