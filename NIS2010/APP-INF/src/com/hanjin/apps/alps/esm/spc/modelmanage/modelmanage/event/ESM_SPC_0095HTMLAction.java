/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_SPC_0095HTMLAction.java
*@FileTitle : Import Modelship
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.22 진마리아
* 1.0 Creation
* 2013.01.22 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2015.07.23 이혜민 [CHM-201536881] SMP 보완 요청 (Import 팝업 Acct.add시 계약번호 Valid 및 MVC, C.OFC 가져옴)
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.CustManageVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.spc.modelmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ModelManageSC로 실행요청<br>
 * - ModelManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Maria Chin
 * @see ModelManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SPC_0095HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SPC_0030HTMLAction 객체를 생성
	 */
	public ESM_SPC_0095HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ModelManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSpc0095Event event = new EsmSpc0095Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setCustManageVO((CustManageVO)getVO(request, CustManageVO .class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setCustManageVOs((CustManageVO[])getVOs(request, CustManageVO.class, ""));
		}else if(command.isCommand(FormCommand.INIT)) {
			event.setCustManageVO((CustManageVO)getVO(request, CustManageVO .class));
		}else if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setCustManageVO((CustManageVO)getVO(request, CustManageVO .class));
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