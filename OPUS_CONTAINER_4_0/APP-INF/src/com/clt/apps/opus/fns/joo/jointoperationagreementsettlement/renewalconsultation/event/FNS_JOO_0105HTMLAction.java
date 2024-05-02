/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FNS_JOO_0079HTMLAction.java
*@FileTitle : Authority Office Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.15 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.ActualDetailVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.ConsultationConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

 

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 JointOperationMasterDataMgtSC로 실행요청<br>
 * - JointOperationMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author jang kang cheol
 * @see JointOperationMasterDataMgtEvent 참조
 * @since J2EE 1.6
 */

public class FNS_JOO_0105HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_JOO_0079HTMLAction 객체를 생성
	 */
	public FNS_JOO_0105HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 JointOperationMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsJoo0105Event event = new FnsJoo0105Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setActualDetailVOS((ActualDetailVO[])getVOs(request, ActualDetailVO.class,"sheet1_"));
		}else if(command.isCommand(FormCommand.SEARCH)) {
            event.setConsultationConditionVO((ConsultationConditionVO)getVO(request, ConsultationConditionVO.class));
		}else if(command.isCommand(FormCommand.SEARCH01)) {
            event.setConsultationConditionVO((ConsultationConditionVO)getVO(request, ConsultationConditionVO.class));
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