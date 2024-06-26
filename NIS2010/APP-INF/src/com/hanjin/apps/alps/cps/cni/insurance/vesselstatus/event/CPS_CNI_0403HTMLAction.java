/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0403HTMLAction.java
*@FileTitle : Vessel Status Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.13 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.vo.CondSearchVesselStatusListVO;
import com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.vo.CustomVesselStatusVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.cps.cni.insurance 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InsuranceSC로 실행요청<br>
 * - InsuranceSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Yoon, Seyeong
 * @see InsuranceEvent 참조
 * @since J2EE 1.6
 */

public class CPS_CNI_0403HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * CPS_CNI_0403HTMLAction 객체를 생성
	 */
	public CPS_CNI_0403HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InsuranceEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		CpsCni0403Event event = new CpsCni0403Event();

		FormCommand command = FormCommand.fromRequest(request);
		
		if(command.isCommand(FormCommand.MULTI)) {
 			event.setCustomVesselStatusVOS((CustomVesselStatusVO[])getVOs(request, CustomVesselStatusVO.class,"sheet_"));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
 			event.setCondSearchVesselStatusListVO((CondSearchVesselStatusListVO)getVO(request, CondSearchVesselStatusListVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setVslCd(request.getParameter("vsl_cd"));
		} 
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setFlag(request.getParameter("flag"));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setVslCd(request.getParameter("vsl_cd"));
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