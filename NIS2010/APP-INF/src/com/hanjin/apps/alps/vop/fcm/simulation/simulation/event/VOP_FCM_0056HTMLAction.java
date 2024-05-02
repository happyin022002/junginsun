/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName       : VOP_FCM_0056HTMLAction.java
 *@FileTitle      : Standard FOC
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : 2014.04.16
 *@LastModifier   : 
 *@LastVersion    : 1.0
 * 2014.04.16 [CHM-201429874] Standard FOC 생성 및 단계별 저장 기능 개발
 * 1.0 Creation
 * 
 * History
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.simulation.simulation.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.BnkReqSimVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.StandardFocVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.FcmVslPortStndFuelOilVO;

/**
 * HTTP Parser<br>
 * - VOP_FCM_0056 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 Temp1SC로 실행요청<br>
 * - Temp1SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author CHOI Yun Sung
 * @see VSKCommonEvent 참조
 * @since J2EE 1.4
 */

public class VOP_FCM_0056HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_FCM_0056HTMLAction 객체를 생성
	 */
	public VOP_FCM_0056HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VSKCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopFcm0056Event event = new VopFcm0056Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setStandardFocVO((StandardFocVO)getVO(request, StandardFocVO.class));
			event.setBnkReqSimVO((BnkReqSimVO)getVO(request, BnkReqSimVO.class));
		}else if(command.isCommand(FormCommand.MULTI)){
			event.setFcmVslPortStndFuelOilVOs((FcmVslPortStndFuelOilVO[])getVOs(request, FcmVslPortStndFuelOilVO.class));
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