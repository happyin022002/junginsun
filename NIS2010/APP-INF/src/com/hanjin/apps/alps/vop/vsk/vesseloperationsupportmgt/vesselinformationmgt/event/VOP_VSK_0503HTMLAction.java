/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0503HTMLAction.java
*@FileTitle : Vessel Information inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.22 김종옥
* 1.0 Creation
* 
* History
* 2012.04.02 진마리아 CHM-201217105-01 Local Vessel name 칼럼 추가 요청건
* 2014.03.17 박다은 	 CHM-201428939-01 vessel particular - performance
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselInformationMgtConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.PerformanceInfoVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.vop.vsk.vesseloperationsupportmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 VesselOperationSupportMgtSC로 실행요청<br>
 * - VesselOperationSupportMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Jong Ock
 * @see VesselOperationSupportMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_VSK_0503HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0503HTMLAction 객체를 생성
	 */
	public VOP_VSK_0503HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VesselOperationSupportMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopVsk0503Event event = new VopVsk0503Event();
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setVesselInformationMgtConditionVO((VesselInformationMgtConditionVO)getVO(request, VesselInformationMgtConditionVO .class));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setVesselInformationMgtConditionVO((VesselInformationMgtConditionVO)getVO(request, VesselInformationMgtConditionVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setVesselVO((VesselVO)getVO(request, VesselVO .class));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setVesselInformationMgtConditionVO((VesselInformationMgtConditionVO)getVO(request, VesselInformationMgtConditionVO .class));
		}else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setVesselInformationMgtConditionVO((VesselInformationMgtConditionVO)getVO(request, VesselInformationMgtConditionVO .class));
		}else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setVesselInformationMgtConditionVO((VesselInformationMgtConditionVO)getVO(request, VesselInformationMgtConditionVO .class));
		}else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setVesselInformationMgtConditionVO((VesselInformationMgtConditionVO)getVO(request, VesselInformationMgtConditionVO .class));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setPerformanceInfoVO((PerformanceInfoVO)getVO(request, PerformanceInfoVO .class));
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