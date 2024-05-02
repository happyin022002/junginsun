/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EES_DOD_0005HTMLAction.java
*@FileTitle : Tariff Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.02
*@LastModifier : YOON, Yong-Sang
*@LastVersion : 1.0
* 2015.11.02 YOON, Yong-Sang
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.vo.SearchDodTariffListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.tpb.candidatemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 StatusInquiryManageSC로 실행요청<br>
 * - StatusInquiryManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author YOON, Yong-Sang
 * @see EesDod0005Event 참조
 * @since J2EE 1.6
 */

public class EES_DOD_0005HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_DOD_0005HTMLAction 객체를 생성
	 */
	public EES_DOD_0005HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 StatusInquiryManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesDod0005Event event = new EesDod0005Event();
		
		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setSearchDodTariffListVO( (SearchDodTariffListVO)getVO(request, SearchDodTariffListVO .class));
		} else if(command.isCommand(FormCommand.SEARCH01)){
			event.setSearchDodTariffListVOS( (SearchDodTariffListVO[])getVOs(request, SearchDodTariffListVO .class,"sheet1_"));
			event.setSearchDodTariffListVO( (SearchDodTariffListVO)getVO(request, SearchDodTariffListVO .class));
		} else if(command.isCommand(FormCommand.SEARCH02)){
			event.setSearchDodTariffListVOS( (SearchDodTariffListVO[])getVOs(request, SearchDodTariffListVO .class,"sheet2_"));
			event.setSearchDodTariffListVO( (SearchDodTariffListVO)getVO(request, SearchDodTariffListVO .class));
		} else if(command.isCommand(FormCommand.SEARCH03)){
			event.setSearchDodTariffListVO( (SearchDodTariffListVO)getVO(request, SearchDodTariffListVO .class));
		} else if(command.isCommand(FormCommand.SEARCH04)){
			event.setSearchDodTariffListVO( (SearchDodTariffListVO)getVO(request, SearchDodTariffListVO .class));
		} else if(command.isCommand(FormCommand.MULTI01)){
			event.setSearchDodTariffListVOS( (SearchDodTariffListVO[])getVOs(request, SearchDodTariffListVO .class,"sheet1_"));
			event.setSearchDodTariffListVO( (SearchDodTariffListVO)getVO(request, SearchDodTariffListVO .class));
		} else if(command.isCommand(FormCommand.MULTI02)){
			event.setSearchDodTariffListVOS( (SearchDodTariffListVO[])getVOs(request, SearchDodTariffListVO .class,"sheet2_"));
			event.setSearchDodTariffListVO( (SearchDodTariffListVO)getVO(request, SearchDodTariffListVO .class));
		} else if(command.isCommand(FormCommand.COMMAND01)){
			event.setSearchDodTariffListVOS( (SearchDodTariffListVO[])getVOs(request, SearchDodTariffListVO .class,"sheet1_"));
			event.setSearchDodTariffListVO( (SearchDodTariffListVO)getVO(request, SearchDodTariffListVO .class));
		} else if(command.isCommand(FormCommand.COMMAND02)){
			event.setSearchDodTariffListVOS( (SearchDodTariffListVO[])getVOs(request, SearchDodTariffListVO .class,"sheet2_"));
			event.setSearchDodTariffListVO( (SearchDodTariffListVO)getVO(request, SearchDodTariffListVO .class));
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