/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_AOC_3022HTMLAction.java
*@FileTitle : Ocean Feeder Cost Management(EUR)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.10.04 변종건 [CHM-201220395] Ocean Feeder Cost Management(EUR) 신규 개발
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.event;


import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederDgCostVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederMgtCondVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederReeferCostVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ChangeOfDestinationMgtSC로 실행요청<br>
 * - InlandCostManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see InlandCostManageEvent 참조
 * @since J2EE 1.6
 */
public class ESD_AOC_3022HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_AOC_3022HTMLAction 객체를 생성
	 */
	public ESD_AOC_3022HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CostManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsdAoc3022Event event = new EsdAoc3022Event();
		
		if( command.isCommand(FormCommand.SEARCH) ){
			event.setEurFeederMgtCondVO((EurFeederMgtCondVO)getVO(request, EurFeederMgtCondVO .class));
		} else if( command.isCommand(FormCommand.SEARCH02) ){
			event.setEurFeederMgtCondVO((EurFeederMgtCondVO)getVO(request, EurFeederMgtCondVO .class));
		} else if( command.isCommand(FormCommand.SEARCH03) ){
			event.setEurFeederMgtCondVO((EurFeederMgtCondVO)getVO(request, EurFeederMgtCondVO .class));
		} else if( command.isCommand(FormCommand.MULTI01) ){
			event.setEurFeederMgtCondVO((EurFeederMgtCondVO)getVO(request, EurFeederMgtCondVO .class));
			event.setEurFeederCostVOs((EurFeederCostVO[])getVOs(request, EurFeederCostVO .class,""));
		} else if( command.isCommand(FormCommand.MULTI02) ){
			event.setEurFeederMgtCondVO((EurFeederMgtCondVO)getVO(request, EurFeederMgtCondVO .class));
			event.setEurFeederReeferCostVOs((EurFeederReeferCostVO[])getVOs(request, EurFeederReeferCostVO .class,""));
		} else if( command.isCommand(FormCommand.MULTI03) ){
			event.setEurFeederMgtCondVO((EurFeederMgtCondVO)getVO(request, EurFeederMgtCondVO .class));
		} else if( command.isCommand(FormCommand.MULTI04) ){
			event.setEurFeederMgtCondVO((EurFeederMgtCondVO)getVO(request, EurFeederMgtCondVO .class));
		} else if( command.isCommand(FormCommand.MULTI05) ){
			event.setEurFeederMgtCondVO((EurFeederMgtCondVO)getVO(request, EurFeederMgtCondVO .class));
			event.setEurFeederDgCostVOs((EurFeederDgCostVO[])getVOs(request, EurFeederDgCostVO .class,""));
		} else if( command.isCommand(FormCommand.MULTI06) ){
			event.setEurFeederMgtCondVO((EurFeederMgtCondVO)getVO(request, EurFeederMgtCondVO .class));
			event.setEurFeederCostVOs((EurFeederCostVO[])getVOs(request, EurFeederCostVO .class,""));
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