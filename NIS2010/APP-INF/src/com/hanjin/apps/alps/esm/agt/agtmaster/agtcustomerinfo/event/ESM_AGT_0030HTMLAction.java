/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_030HTMLAction.java
*@FileTitle : FAC Shipper 관계 관리 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-28
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-11-28 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.AgtFacCustRltVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.enis.esm.agt.agtmaster 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AGTMasterSC로 실행요청<br>
 * - AGTMasterSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Hwang GyeongNam
 * @see EsmAgt0030Event , ESM_AGT_030EventResponse 참조
 * @since J2EE 1.4
 */
public class ESM_AGT_0030HTMLAction extends HTMLActionSupport {

	/**
	 * Default 생성자<br>
	 */		
	public ESM_AGT_0030HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESM_AGT_030Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsmAgt0030Event event = new EsmAgt0030Event();
		
		if(command.isCommand(FormCommand.SEARCH)){
			event.setAgtFacCustRltVO((AgtFacCustRltVO)getVO(request, AgtFacCustRltVO.class));
		}
		
		if(command.isCommand(FormCommand.MULTI)){
			event.setAgtFacCustRltVOs((AgtFacCustRltVO[])getVOs(request, AgtFacCustRltVO.class));
		}
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