/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqrCodEvent.java
*@FileTitle : 공통
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-27
*@LastModifier :  SHIN DONG IL
*@LastVersion : 1.0
* 2013-05-27  SHIN DONG IL
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.event;

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
 * @author SHIN DONG IL
 * @see EsmSpcCodEvent , ESM_SPC_CODEventResponse 참조
 * @since J2EE 1.4
 */

public class EES_EQR_CODHTMLAction extends HTMLActionSupport {

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
			
			if("|f_cmd|mcode|ipc|del|mrhq|trdCd|subTrdCd".indexOf(key) >= 0){
				params.put(key, request.getParameter(key));
			}
			else{
				params.put(key, request.getParameterValues(key));
			}
		}
		EesEqrCodEvent event = new EesEqrCodEvent();
		event.setParams(params);
		event.setCommandClassName("CntrCommonSC");
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