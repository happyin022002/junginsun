/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0192HTMLAction.java
*@FileTitle : P&L by Lane (After Adjustment)
*Open Issues :
*Change history :
*@LastModifyDate : 2015-05-19
*@LastModifier : Young-Heon Lee
*@LastVersion : 1.0
* 2015-05-19 Young-Heon Lee
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.RepoPfmcConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.mas.multidimensionrpt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MultiDimensionRPTSC로 실행요청<br>
 * - MultiDimensionRPTSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Young-Heon Lee
 * @see EsmMas0192Event , ESM_MAS_0192EventResponse 참조
 * @since J2EE 1.4
 */ 

public class ESM_MAS_0192HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESM_MAS_192Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		//FormCommand command = FormCommand.fromRequest(request);
		EsmMas0192Event event = new EsmMas0192Event();

		event.setRepoPfmcConditionVO((RepoPfmcConditionVO)getVO(request, RepoPfmcConditionVO .class));
		return event;
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