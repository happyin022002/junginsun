/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_SPC_CODHTMLAction.java
*@FileTitle : 공통
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-17
*@LastModifier : 김원섭
*@LastVersion : 1.0
* 2006-10-17 김원섭
* 1.0 최초 생성
* 2011.05.16 이석준 [CHM-201110710-01] Daily F"cast Status 화면 조건 추가
*           - RHQ가 multi select 된것인지 구분자 mrhq 추가
* 2016.05.03 이혜민 CHM-201640928 Daily Forecast Status 모든 조회 옵션 및 탭 > 그리드 화면에 SELCS, TYOSC 독립 RHQ 분리 요청           
=========================================================*/

package com.hanjin.apps.alps.esm.spc.common.common.event;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.spc.common 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CommonSC로 실행요청<br>
 * - CommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 김원섭
 * @see EsmSpcCodEvent , ESM_SPC_CODEventResponse 참조
 * @since J2EE 1.4
 */

public class ESM_SPC_CODHTMLAction extends HTMLActionSupport {

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmSpcCodEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException 
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand f_cmd = FormCommand.fromRequest(request);
		HashMap params = new HashMap();
		Enumeration e = request.getParameterNames();
		while(e.hasMoreElements()){
			String key = (String)e.nextElement();
			
			if("|f_cmd|mcode|ipc|del|mrhq|trdCd|subTrdCd|mrhq1".indexOf(key) >= 0){
				params.put(key, request.getParameter(key));
			}
			else{
				params.put(key, request.getParameterValues(key));
			}
		}
		EsmSpcCodEvent event = new EsmSpcCodEvent();
		event.setParams(params);
		event.setCommandClassName("CommonSC");
		event.setFormCommand(f_cmd);
		request.setAttribute("Event", event);
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