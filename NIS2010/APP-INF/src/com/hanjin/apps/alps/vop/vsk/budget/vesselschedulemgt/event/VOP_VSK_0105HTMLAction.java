/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0105HTMLAction.java
*@FileTitle : Budget VSL SKD Creation by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.10 진마리아
* 1.0 Creation
* 
* History
* 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneDirVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.vop.vsk.scheduleplanningoperation.vesselschedulemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SchedulePlanningOperationSC로 실행요청<br>
 * - SchedulePlanningOperationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Maria Chin
 * @see VopVsk0105Event 참조
 * @since J2EE 1.5
 */

public class VOP_VSK_0105HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0105HTMLAction 객체를 생성
	 */
	public VOP_VSK_0105HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SchedulePlanningOperationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopVsk0105Event event = new VopVsk0105Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setCstSkdByVvdVO((CstSkdByVvdVO)getVO(request, CstSkdByVvdVO .class));
		} else if (command.isCommand(FormCommand.SEARCH01)){
			event.setYardVO((YardVO)getVO(request, YardVO .class));
		} else if (command.isCommand(FormCommand.SEARCH02)){
			event.setPfLaneTypeVO((PfLaneTypeVO)getVO(request, PfLaneTypeVO .class));
		} else if (command.isCommand(FormCommand.SEARCH03)){
			event.setCstSkdByVvdVO((CstSkdByVvdVO)getVO(request, CstSkdByVvdVO .class));
		} else if (command.isCommand(FormCommand.SEARCH05)){
			event.setMdmVslSvcLaneDirVO((MdmVslSvcLaneDirVO)getVO(request, MdmVslSvcLaneDirVO .class));
		} else if (command.isCommand(FormCommand.SEARCH10)){
			event.setVvdVO((VvdVO)getVO(request, VvdVO .class));
		} else if (command.isCommand(FormCommand.MULTI)){
			event.setCstSkdByVvdVO((CstSkdByVvdVO)getVO(request, CstSkdByVvdVO .class));
			event.setCstSkdByVvdVOS((CstSkdByVvdVO[])getVOs(request, CstSkdByVvdVO .class, "sheet1_"));
		} else if (command.isCommand(FormCommand.MULTI01)){
			event.setCstSkdByVvdVO((CstSkdByVvdVO)getVO(request, CstSkdByVvdVO .class));
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