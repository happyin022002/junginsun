/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0016HTMLAction.java
*@FileTitle : EQ repo 회송 기여도 Credit setting
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.08.03 장영석
* 1.0 Creation
* 
*Change history
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
* 2012.03.22 김종준 [CHM-201217091-01] EMU 관련 로직 보완/변경 검토 요청의 건 -POR 별 Credit Ratio를 setup 할수 있는 화면추가 (Rule-set) 
=========================================================*/
package com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.CoaCntrRepoRuleVO;
import com.hanjin.syscommon.common.table.CoaCntrRepoShtgInfoVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.coa.eqbalance 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EQBalanceSC로 실행요청<br>
 * - EQBalanceSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jang Yeong-seok
 * @see EQBalanceEvent 참조
 * @since J2EE 1.6
 */

public class ESM_COA_0016HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_0016HTMLAction 객체를 생성
	 */
	public ESM_COA_0016HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EQBalanceEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EsmCoa0016Event event = new EsmCoa0016Event();
		if(command.isCommand(FormCommand.MULTI01)) {
			event.setCoaCntrRepoRuleVOS((CoaCntrRepoRuleVO[])getVOs(request, CoaCntrRepoRuleVO .class,""));
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO .class));
		}		
		else if(command.isCommand(FormCommand.MULTI03)) {
			event.setCoaCntrRepoShtgInfoVOS((CoaCntrRepoShtgInfoVO[])getVOs(request, CoaCntrRepoShtgInfoVO .class,""));
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO .class));
			String excel_load_yn = request.getParameter("excel_load_yn");
			event.setAttribute("excel_load_yn", excel_load_yn);
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO .class));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
		} else if(command.isCommand(FormCommand.SEARCH04)) {
			String eccCd = request.getParameter("eccCd");
			event.setAttribute("eccCd", eccCd);
			request.setAttribute("Event", event);
		} else if (command.isCommand(FormCommand.INIT) || 
			command.isCommand(FormCommand.SEARCHLIST01) ||
			command.isCommand(FormCommand.SEARCHLIST02) ||
			command.isCommand(FormCommand.SEARCHLIST03)
			) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO .class));
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