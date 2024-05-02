/*========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName     : ESM_COA_4012HTMLAction.java
*@FileTitle    : Pendulum Service Setup (PA) 
*Open Issues   :
*Change history 
*@LastModifyDate : 
*@LastModifier   :  
*@LastVersion    :  1.0
* 2015.10.01 SJH 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.PndlmSvcVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.coa.stdunitcost 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 STDUnitCostSC로 실행요청<br>
 * - STDUnitCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SOO HOON PARK
 * @see STDUnitCostEvent 참조
 * @since J2EE 1.6 
 */

public class ESM_COA_4012HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_4012HTMLAction 객체를 생성
	 */
	public ESM_COA_4012HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 STDUnitCostEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmCoa4012Event event = new EsmCoa4012Event();
		CommonCoaRsVO commonCoaRsVO = new CommonCoaRsVO();

		if(command.isCommand(FormCommand.SEARCH01)||
		   command.isCommand(FormCommand.SEARCH02)) {			
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);			
			svo.unDataFormat();
			event.setSearchConditionVO(svo);			
			event.setCommonCoaRsVO(commonCoaRsVO);
		}
		else if(command.isCommand(FormCommand.MULTI01)||
				command.isCommand(FormCommand.MULTI03)) {
			event.setPndlmSvcVOS((PndlmSvcVO[])getVOs(request, PndlmSvcVO .class));
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO .class));
			event.setCommonCoaRsVO(commonCoaRsVO);
			event.setPndlmSvcVOS((PndlmSvcVO[])getVOs(request, PndlmSvcVO .class));
			event.getCommonCoaRsVO().requestToHashMap(request);			
		}		
		else{
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO .class));
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