/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0024HTMLAction.java
*@FileTitle : VOP_VSK_0024HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.09.09 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalTransitBkgVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalTransitTargetVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdBerthWdoVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - VOP_VSK_0024 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 VSKCommonSC로 실행요청<br>
 * - VSKCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Ryu Hyuk
 * @see VopVsk0024Event 참조
 * @since J2EE 1.5
 */

public class VOP_VSK_0024HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0024HTMLAction 객체를 생성
	 */
	public VOP_VSK_0024HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VSKCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		VopVsk0024Event event = new VopVsk0024Event();
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setCanalTransitTargetVvdVO((CanalTransitTargetVvdVO)getVO(request, CanalTransitTargetVvdVO.class));
		}else if(command.isCommand(FormCommand.COMMAND07)) {
			event.setCanalTransitTargetVvdVO((CanalTransitTargetVvdVO)getVO(request, CanalTransitTargetVvdVO.class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setCanalTransitTargetVvdVO((CanalTransitTargetVvdVO)getVO(request, CanalTransitTargetVvdVO.class));
		}else if(command.isCommand(FormCommand.MULTI)){
			CanalTransitTargetVvdVO[] canalTransitTargetVvdVOs = (CanalTransitTargetVvdVO[])getVOs(request, CanalTransitTargetVvdVO.class, "sheet1_");
			for(int i=0; i<canalTransitTargetVvdVOs.length; i++){
				canalTransitTargetVvdVOs[i].setStartDate(request.getParameter("start_date"));
				canalTransitTargetVvdVOs[i].setPortCd(request.getParameter("port_cd"));
				canalTransitTargetVvdVOs[i].setVslSlanCd(request.getParameter("vsl_slan_cd"));
				canalTransitTargetVvdVOs[i].setVndrSeq(request.getParameter("vndr_seq"));
			}
			event.setCanalTransitTargetVvdVOS(canalTransitTargetVvdVOs);
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