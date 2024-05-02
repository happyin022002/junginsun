/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0088HTMLAction.java
*@FileTitle : Estimate Performance Change Status I
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.10
*@LastModifier : 조병연
*@LastVersion : 1.0
* 2012.01.10 조병연
* 1.0 Creation
* -------------------------------------------------------
* 2012.02.10 조병연[CHM-201215990-01]
* Title : [ALPS JOO] Estimate Performance Change Status II 신규개발 (2012년 1월 2차) 
* 내용 :
* - ALPS JOO 전월 대상항차 Estimate 변동 현황 분석기능 개발 
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsStatusVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusIIRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusIIVO;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 JointOperationAgreementSettlementSC로 실행요청<br>
 * - JointOperationAgreementSettlementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jo Byeang Yean
 * @see JointOperationAgreementSettlementEvent 참조
 * @since J2EE 1.6
 */

public class FNS_JOO_0089HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_JOO_0089HTMLAction 객체를 생성
	 */
	public FNS_JOO_0089HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 JointOperationAgreementSettlementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsJoo0089Event event = new FnsJoo0089Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setEstmPerformanceChangeStatusIIVO( (EstmPerformanceChangeStatusIIVO)getVO(request, EstmPerformanceChangeStatusIIVO .class) );
		}else{
			event.setEstmPerformanceChangeStatusIIVO( (EstmPerformanceChangeStatusIIVO)getVO(request, EstmPerformanceChangeStatusIIVO .class) );
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