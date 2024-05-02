/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0161HTMLAction.java
*@FileTitle : To(DEL) RCC For EQ Repo. Contribution
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 박수훈
*@LastVersion : 1.1
* 2008.09.01 전윤주 CSR No.N200808260006 EQ repo rule-set(Rlane setting을 From-To ECC setting으로)
* 2009.10.06 박수훈 Alps New Framework 적용[0161]
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.event;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.syscommon.common.table.MasCntrRepoRoutEccVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.vo.SearchEQBalance0161ListVO;
import com.hanjin.apps.alps.esm.mas.common.Utils;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.mas.eqbalance 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EQBalanceSC로 실행요청<br>
 * - EQBalanceSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SOO HOON PARK
 * @see EQBalanceEvent 참조
 * @since J2EE 1.6
 */

public class ESM_MAS_0161HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_MAS_0161HTMLAction 객체를 생성
	 */
	public ESM_MAS_0161HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EQBalanceEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmMas0161Event event = new EsmMas0161Event();
		HashMap hash = new HashMap();
		hash = Utils.requestToHashMap(request);
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setMasCntrRepoRoutEccVOS((MasCntrRepoRoutEccVO[])getVOs(request, MasCntrRepoRoutEccVO .class,""));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchEQBalance0161ListVO((SearchEQBalance0161ListVO)getVO(request, SearchEQBalance0161ListVO .class));
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