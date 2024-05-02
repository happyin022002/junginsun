/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_COA_0050HTMLAction.java
*@FileTitle : TS Allocation2
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.07
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.01.07 김기종
* 1.0 Creation
=========================================================
* History
* 2013.02.07 서미진 [CHM-201322638] 한 주차만 생성 가능하던 로직을 여러 주차 생성 가능하도록 신규 배치 생성으로 변경
========================================================= */
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo.NetworkDistributionCommonVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.coa.weeklypfmc 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WeeklyPFMCSC로 실행요청<br>
 * - WeeklyPFMCSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Ki Jong
 * @see WeeklyPFMCEvent 참조
 * @since J2EE 1.6
 */

public class ESM_COA_0050HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_0050HTMLAction 객체를 생성
	 */
	public ESM_COA_0050HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 WeeklyPFMCEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmCoa0050Event event = new EsmCoa0050Event();
		

		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setNetworkDistributionCommonVO((NetworkDistributionCommonVO)getVO(request, NetworkDistributionCommonVO.class));
		}	
		else if(command.isCommand(FormCommand.MULTI01)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setNetworkDistributionCommonVO((NetworkDistributionCommonVO)getVO(request, NetworkDistributionCommonVO.class));
		}	
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setNetworkDistributionCommonVO((NetworkDistributionCommonVO)getVO(request, NetworkDistributionCommonVO.class));
		}	
		else{
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setNetworkDistributionCommonVO((NetworkDistributionCommonVO)getVO(request, NetworkDistributionCommonVO.class));
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