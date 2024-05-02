/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CPS_CNI_0001HTMLAction.java
 *@FileTitle : Client Default Setup
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.10.05 진윤오 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.FindCondVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * CPS_CNI_0001  Client Default Setup
 * HTTP Parser<br>
 * @author 진윤오
 * @see CpsCni0001Event 참조
 * @since J2EE 1.4
 */

public class CPS_CNI_0001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_CNI_0001HTMLAction 객체를 생성
	 */
	public CPS_CNI_0001HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CpsCni0001Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
				
		//이벤트 객체 생성 
		CpsCni0001Event event = new CpsCni0001Event();
		
		// ----------------------------------------------------
		// 공통화면 정보 설정 
		// ----------------------------------------------------
		String clmAreaCd = JSPUtil.getParameter(request, "clm_area_cd");
		String ofcCd = JSPUtil.getParameter(request, "ofc_cd");
		
		event.setClmAreaCd(clmAreaCd);
		event.setOfcCd(ofcCd);		
		// ----------------------------------------------------
		// 이벤트 처리 
		// ----------------------------------------------------
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