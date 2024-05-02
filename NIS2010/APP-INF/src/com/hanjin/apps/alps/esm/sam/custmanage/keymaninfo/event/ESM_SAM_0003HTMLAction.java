/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : ESM_SAM_0003HTMLAction.java
*@FileTitle : KeyMan Info Management
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 이창원
*@LastVersion : 1.0
* 2011.05.09 이창원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.keymaninfo.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.SearchCustomerVO;
import com.hanjin.apps.alps.esm.sam.custmanage.keymaninfo.vo.SamKeyManInfoVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.sam.generalinfomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralInfoManageSC로 실행요청<br>
 * - GeneralInfoManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author LEECHANGWON
 * @see GeneralInfoManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SAM_0003HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/** 
	 * ESM_SAM_0003HTMLAction 객체를 생성
	 */
	public ESM_SAM_0003HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralInfoManageEvent로 파싱하여 request에 셋팅<br>
	 * @param HttpServletRequest request
	 * @return Event event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);  
		
    	EsmSam0003Event event = new EsmSam0003Event();
		if (command.isCommand(FormCommand.SEARCH)) {
			event.setSearchCustomerVO((SearchCustomerVO)getVO(request, SearchCustomerVO .class));
		}
		else if (command.isCommand(FormCommand.SEARCH01)) {
			event.setSamKeyManInfoVO((SamKeyManInfoVO)getVO(request, SamKeyManInfoVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setSamKeyManInfoVO((SamKeyManInfoVO)getVO(request, SamKeyManInfoVO .class));
		}
		else if (command.isCommand(FormCommand.MULTI)) {
			event.setSamKeyManInfoVO((SamKeyManInfoVO)getVO(request, SamKeyManInfoVO .class));
		}
		else if (command.isCommand(FormCommand.MULTI01)) {
			event.setSamKeyManInfoVOs((SamKeyManInfoVO[])getVOs(request, SamKeyManInfoVO.class));
		}
		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param EventResponse eventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param Event event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}