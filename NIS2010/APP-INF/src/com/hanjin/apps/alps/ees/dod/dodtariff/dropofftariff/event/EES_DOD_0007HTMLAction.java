package com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.event;

import com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.vo.SearchDodTariffListVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import javax.servlet.http.HttpServletRequest;



public class EES_DOD_0007HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * EES_DOD_0007HTMLAction 객체를 생성
	 */
	public EES_DOD_0007HTMLAction() {}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DodDropOffEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException 
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EesDod0007Event event = new EesDod0007Event();
		
		
		if(command.isCommand(FormCommand.SEARCH) ){
			event.setSearchDodTariffListVO((SearchDodTariffListVO)getVO(request, SearchDodTariffListVO .class));
			
			String sTrfDivCd = JSPUtil.getParameter(request,"s_trf_div_cd");
			event.setsTrfDivCd(sTrfDivCd);
			
		}else if (command.isCommand(FormCommand.MULTI)){
			event.setSearchDodTariffListVOs((SearchDodTariffListVO[])getVOs(request, SearchDodTariffListVO .class,"sheet1_"));
		}else if (command.isCommand(FormCommand.MULTI01)){
			event.setSearchDodTariffListVOs((SearchDodTariffListVO[])getVOs(request, SearchDodTariffListVO .class,"sheet2_"));
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


