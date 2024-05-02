/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_SAM_0006HTMLAction.java
*@FileTitle : Customer List by Sales Rep
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.05.09 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.CommonWebKeys;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.view.signon.SignOnUserAccount;
/**
 * HTTP Parser<br>
 * - com.clt.apps.opuse.ESM.SAM.generalinfomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralInfoManageSC로 실행요청<br>
 * - GeneralInfoManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author LEECHANGNWON
 * @see GeneralInfoManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SAM_0006HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SAM_0006HTMLAction 객체를 생성
	 */
	public ESM_SAM_0006HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralInfoManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */

	
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);  
    	
		EsmSam0006Event event = new EsmSam0006Event();
		if (command.isCommand(FormCommand.SEARCH)){ 
			SearchCustomerVO vo = (SearchCustomerVO)getVO(request, SearchCustomerVO .class);
			event.setSearchCustomerVO(vo);
		}
		else if (command.isCommand(FormCommand.SEARCH01)){ 
			SearchCustomerVO vo = (SearchCustomerVO)getVO(request, SearchCustomerVO .class);
			event.setSearchCustomerVO(vo);
		}
		else if (command.isCommand(FormCommand.SEARCH02)){ 
			SearchCustomerVO vo = (SearchCustomerVO)getVO(request, SearchCustomerVO .class);
			event.setSearchCustomerVO(vo);
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