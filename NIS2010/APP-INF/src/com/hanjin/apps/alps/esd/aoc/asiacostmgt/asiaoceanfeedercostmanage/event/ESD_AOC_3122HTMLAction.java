/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_AOC_3122HTMLAction.java
*@FileTitle : Ocean Feeder Cost Management(Asia)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.event;


import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederDgCostVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederMgtCondVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederReeferCostVO;
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
public class ESD_AOC_3122HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_AOC_3122HTMLAction 객체를 생성
	 */
	public ESD_AOC_3122HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CostManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsdAoc3122Event event = new EsdAoc3122Event();
		
		if( command.isCommand(FormCommand.SEARCH) ){
			event.setAsiaFeederMgtCondVO((AsiaFeederMgtCondVO)getVO(request, AsiaFeederMgtCondVO .class));
		} else if( command.isCommand(FormCommand.SEARCH02) ){
			event.setAsiaFeederMgtCondVO((AsiaFeederMgtCondVO)getVO(request, AsiaFeederMgtCondVO .class));
		} else if( command.isCommand(FormCommand.SEARCH03) ){
			event.setAsiaFeederMgtCondVO((AsiaFeederMgtCondVO)getVO(request, AsiaFeederMgtCondVO .class));
		} else if( command.isCommand(FormCommand.MULTI01) ){
			event.setAsiaFeederMgtCondVO((AsiaFeederMgtCondVO)getVO(request, AsiaFeederMgtCondVO .class));
			event.setAsiaFeederCostVOs((AsiaFeederCostVO[])getVOs(request, AsiaFeederCostVO .class,""));
		} else if( command.isCommand(FormCommand.MULTI02) ){
			event.setAsiaFeederMgtCondVO((AsiaFeederMgtCondVO)getVO(request, AsiaFeederMgtCondVO .class));
			event.setAsiaFeederReeferCostVOs((AsiaFeederReeferCostVO[])getVOs(request, AsiaFeederReeferCostVO .class,""));
		} else if( command.isCommand(FormCommand.MULTI03) ){
			event.setAsiaFeederMgtCondVO((AsiaFeederMgtCondVO)getVO(request, AsiaFeederMgtCondVO .class));
		} else if( command.isCommand(FormCommand.MULTI04) ){
			event.setAsiaFeederMgtCondVO((AsiaFeederMgtCondVO)getVO(request, AsiaFeederMgtCondVO .class));
		} else if( command.isCommand(FormCommand.MULTI05) ){
			event.setAsiaFeederMgtCondVO((AsiaFeederMgtCondVO)getVO(request, AsiaFeederMgtCondVO .class));
			event.setAsiaFeederDgCostVOs((AsiaFeederDgCostVO[])getVOs(request, AsiaFeederDgCostVO .class,""));
		} else if( command.isCommand(FormCommand.MULTI06) ){
			event.setAsiaFeederMgtCondVO((AsiaFeederMgtCondVO)getVO(request, AsiaFeederMgtCondVO .class));
			event.setAsiaFeederCostVOs((AsiaFeederCostVO[])getVOs(request, AsiaFeederCostVO .class,""));
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