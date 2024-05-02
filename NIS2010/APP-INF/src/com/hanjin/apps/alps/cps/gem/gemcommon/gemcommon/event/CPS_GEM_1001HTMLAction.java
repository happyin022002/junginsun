/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_GEM_1001HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.04.21 최정미
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.cps.gem.gemcommon.gemclosingschedulemgt.vo.GemMonClzVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemclosingschedulemgt.vo.MonClzVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.vo.SlipPerfCondVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningStatusCondVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * CPS_GEM_1001HTMLAction
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.gae.gaecommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GEMCommonSC로 실행요청<br>
 * - GEMCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author choijungmi
 * @see GEMCommonEvent 참조
 * @since J2EE 1.4
 */

public class CPS_GEM_1001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_GEM_0007HTMLAction 객체를 생성
	 */
	public CPS_GEM_1001HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GEMCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		
		//이벤트 객체 생성 
		CpsGem1001Event event = new CpsGem1001Event();
		
		// ----------------------------------------------------
		// 전표 실적,예산 데이타 정규화
		// ----------------------------------------------------		
		if(command.isCommand(FormCommand.MULTI01)) {
			SlipPerfCondVO  slipPerfCondVO = 
				(SlipPerfCondVO) getVO(request,
						SlipPerfCondVO.class);			
			event.setSlipPerfCondVO(slipPerfCondVO);			
		// ----------------------------------------------------
		// 전표 실적,예산 데이타 정규화
		// ----------------------------------------------------
		} else if(command.isCommand(FormCommand.MULTI02)) {
			SlipPerfCondVO  slipPerfCondVO = 
				(SlipPerfCondVO) getVO(request,
						SlipPerfCondVO.class);			
			event.setSlipPerfCondVO(slipPerfCondVO);
						
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