/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_COMHTMLAction.java
*@FileTitle : ESD_SPE_COM
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.common.util.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.esd.spe.common.util.vo.UtillVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.spe.common 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CommonSC로 실행요청<br>
 * - CommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author HI
 * @see CommonEvent 참조
 * @since J2EE 1.6
 */

public class ESD_SPE_COMHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_SPE_COMHTMLAction 객체를 생성
	 */
	public ESD_SPE_COMHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdSpeComEvent event = new EsdSpeComEvent();
		


		
		if(command.isCommand(FormCommand.COMMAND01)) { // RHQ 를 조회한다.
			event.setUtillVO((UtillVO)getVO(request, UtillVO .class));
		}else if(command.isCommand(FormCommand.COMMAND02)) { // 지역 office 를 조회한다. 
			event.setUtillVO((UtillVO)getVO(request, UtillVO .class));
	    }else if(command.isCommand(FormCommand.SEARCH01)) { // 공통코드 값을 조회한다 코드와 명을 붙여온다.
	    	event.setUtillVO((UtillVO)getVO(request, UtillVO .class));
    	}else if(command.isCommand(FormCommand.SEARCH02)) { // 공통코드 값을 조회한다 구분자를 텝 으로 코드와 명을 붙여온다.
	    	event.setUtillVO((UtillVO)getVO(request, UtillVO .class));
    	}else if(command.isCommand(FormCommand.SEARCH03)) { // 공통코드 값을 조회한다
	    	event.setUtillVO((UtillVO)getVO(request, UtillVO .class));
    	}else if(command.isCommand(FormCommand.COMMAND03)) {  // 사용자가 입력한 Control Office 코드가 존재하는 값인지 조회한다.
    		event.setUtillVO((UtillVO)getVO(request, UtillVO .class));
    	}else if(command.isCommand(FormCommand.COMMAND04)) { // 사용자가 입력한 Vender 코드가 존재하는 값인지 조회한다.
    		event.setUtillVO((UtillVO)getVO(request, UtillVO .class));
		}else if(command.isCommand(FormCommand.COMMAND05)) { // 사용자가 입력한 USER 코드로 조회한다
			event.setUtillVO((UtillVO)getVO(request, UtillVO .class));
		}else if(command.isCommand(FormCommand.COMMAND06)) { // 사용자가 입력한 USER 코드로 조회한다
			event.setUtillVO((UtillVO)getVO(request, UtillVO .class));
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