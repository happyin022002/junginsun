/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : EES_CIM_0063HTMLAction.java
*@FileTitle : Uncollected Cargo Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.23
*@LastModifier : 김현주
*@LastVersion : 1.0
* 2014.06.23 김현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.UncollectedCargoAuthorizerVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.UncollectedCargoVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CustomShpYdVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 LongstayingUnclaimEQMgtSC로 실행요청<br>
 * - LongstayingUnclaimEQMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author kim jong jun
 * @see LongstayingUnclaimEQMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_CIM_0072HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CIM_0063HTMLAction 객체를 생성
	 */
	public EES_CIM_0072HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 LongstayingUnclaimEQMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EesCim0072Event event = new EesCim0072Event();
				
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setUncollectedCargoAuthorizerVO((UncollectedCargoAuthorizerVO)getVO(request, UncollectedCargoAuthorizerVO.class));	// 조회
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setUncollectedCargoAuthorizerVO((UncollectedCargoAuthorizerVO)getVO(request, UncollectedCargoAuthorizerVO.class));    // office 별 입력가능한 사번인지 체크
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setUncollectedCargoAuthorizerVOs((UncollectedCargoAuthorizerVO[])getVOs(request, UncollectedCargoAuthorizerVO.class,""));
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