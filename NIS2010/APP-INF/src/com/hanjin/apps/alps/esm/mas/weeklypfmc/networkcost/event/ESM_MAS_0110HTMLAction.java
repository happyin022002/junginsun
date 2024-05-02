/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0110HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.03 김기대
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.NetworkCostCommonVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.MasNtwkCostCreVO;
import com.hanjin.syscommon.common.table.MasSltChtrInfoVO;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 NetworkCostSC로 실행요청<br>
 * - NetworkCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Ki Dae
 * @see EsmMas0110Event 참조
 * @since J2EE 1.6
 */
public class ESM_MAS_0110HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_MAS_0110HTMLAction 객체를 생성
	 */
	public ESM_MAS_0110HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmMas0110Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmMas0110Event event = new EsmMas0110Event();  		
    	
		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setNetworkCostCommonVO((NetworkCostCommonVO)getVO(request, NetworkCostCommonVO.class));
		}	
		else if(command.isCommand(FormCommand.SEARCHLIST02)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setNetworkCostCommonVO((NetworkCostCommonVO)getVO(request, NetworkCostCommonVO.class));
		}		
		else if(command.isCommand(FormCommand.SEARCHLIST03)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setNetworkCostCommonVO((NetworkCostCommonVO)getVO(request, NetworkCostCommonVO.class));
		}	
		else if(command.isCommand(FormCommand.SEARCHLIST04)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setNetworkCostCommonVO((NetworkCostCommonVO)getVO(request, NetworkCostCommonVO.class));
		}			
		else if(command.isCommand(FormCommand.MULTI01)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setNetworkCostCommonVO((NetworkCostCommonVO)getVO(request, NetworkCostCommonVO.class));
			event.setMasNtwkCostCreVOs((MasNtwkCostCreVO[])getVOs(request, MasNtwkCostCreVO.class));
		}				
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setNetworkCostCommonVO((NetworkCostCommonVO)getVO(request, NetworkCostCommonVO.class));
			event.setMasSltChtrInfoVOs((MasSltChtrInfoVO[])getVOs(request, MasSltChtrInfoVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH11)) {
			event.setComBakEndJbVO((ComBakEndJbVO)getVO(request, ComBakEndJbVO.class));
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
		}	
		else if(command.isCommand(FormCommand.SEARCH12)) {
			event.setComBakEndJbVO((ComBakEndJbVO)getVO(request, ComBakEndJbVO .class));
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
		}
		else{
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setNetworkCostCommonVO((NetworkCostCommonVO)getVO(request, NetworkCostCommonVO.class));
		}

		request.setAttribute("Event", event);
		
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
