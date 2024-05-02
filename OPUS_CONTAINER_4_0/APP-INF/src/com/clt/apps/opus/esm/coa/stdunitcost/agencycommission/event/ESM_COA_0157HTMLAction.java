/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0157HTMLAction.java
*@FileTitle :  Agent Other Commission Inquiry (PA/RA)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 장영석
*@LastVersion : 1.1
* 2009.09.18 장영석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.agencycommission.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.coa.common.Utils;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.agencycommission.vo.SearchAgnOtrCommCostListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.CoaOtrCommVO;

import java.util.HashMap;





/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.coa.stdunitcost 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 STDUnitCostSC로 실행요청<br>
 * - STDUnitCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jang Yeong-seok
 * @see STDUnitCostEvent 참조
 * @since J2EE 1.6
 */

public class ESM_COA_0157HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_0157HTMLAction 객체를 생성
	 */
	public ESM_COA_0157HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 STDUnitCostEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmCoa0157Event event = new EsmCoa0157Event();
		
		HashMap hash = new HashMap();
		hash = Utils.requestToHashMap(request);	
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setCoaOtrCommVOS((CoaOtrCommVO[])getVOs(request, CoaOtrCommVO .class,""));
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO .class));

		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchAgnOtrCommCostListVO((SearchAgnOtrCommCostListVO)getVO(request, SearchAgnOtrCommCostListVO .class));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
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