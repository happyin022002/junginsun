/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESM_SPC_0115HTMLAction.java
*@FileTitle : Constraint Mastertable
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.23
*@LastModifier : Seung-Man KIM
*@LastVersion : 1.0
* 2015.01.23 Seung-Man KIM
* 1.0 Creation
* 2016.05.12 이혜민 CHM-201640880 T/S History 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SpcAlocMgmtVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.spc.basicdatamanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BasicDataManageSC로 실행요청<br>
 * - BasicDataManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Seung-Man KIM
 * @see BasicDataManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SPC_0115HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SPC_0115HTMLAction 객체를 생성
	 */
	public ESM_SPC_0115HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BasicDataManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsmSpc0115Event event = new EsmSpc0115Event();
		log.debug("***** ESM_BKG_0115HTMLAction : " + command.getCommand());
		
		if(command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH02) 
				|| command.isCommand(FormCommand.SEARCH03) || command.isCommand(FormCommand.SEARCH04) 
				|| command.isCommand(FormCommand.SEARCH05) || command.isCommand(FormCommand.REMOVE)
				||command.isCommand(FormCommand.SEARCH10)||command.isCommand(FormCommand.SEARCH11)||command.isCommand(FormCommand.SEARCH12)) {           
            event.setSpcAlocMgmtVO((SpcAlocMgmtVO)getVO(request, SpcAlocMgmtVO.class));
		} else if(command.isCommand(FormCommand.MULTI)) {
            event.setSpcAlocMgmtVOs((SpcAlocMgmtVO[])getVOs(request, SpcAlocMgmtVO.class));
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