/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3507HTMLAction.java
*@FileTitle : Tariff Rule Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.06
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.06 최성민
* 1.0 Creation
=========================================================
* History
* 2011.04.19 이행지 [CHM-201110201-01] Tariff Rule 관련 Status 변경 관리자 기능 추가 요청
*                                  - SuperUser일 경우 Publish Cacel권한 부여
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffrule.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.vo.PriTrfRuleListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriTrfRuleVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.tariff 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TariffSC로 실행요청<br>
 * - TariffSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CHOI SUNGMIN
 * @see TariffEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_3507HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_3507HTMLAction 객체를 생성
	 */
	public ESM_PRI_3507HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TariffEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri3507Event event = new EsmPri3507Event();
		
		if(command.isCommand(FormCommand.MULTI01)) {
			PriTrfRuleListVO vo = new PriTrfRuleListVO();
			vo.setPriTrfRuleVOs((PriTrfRuleVO[])getVOs(request, PriTrfRuleVO .class,""));
			vo.setTrfRuleCtnt(request.getParameter("trf_rule_ctnt"));
			event.setPriTrfRuleListVO(vo);
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setPriTrfRuleVO((PriTrfRuleVO)getVO(request, PriTrfRuleVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setPriTrfRuleVO((PriTrfRuleVO)getVO(request, PriTrfRuleVO .class));
		}
		else if(command.isCommand(FormCommand.MODIFY01)) {
			event.setPriTrfRuleVO((PriTrfRuleVO)getVO(request, PriTrfRuleVO .class));
		}
		else if(command.isCommand(FormCommand.MODIFY02)) {
			event.setPriTrfRuleVO((PriTrfRuleVO)getVO(request, PriTrfRuleVO .class));
		}

		else if(command.isCommand(FormCommand.MODIFY03)) {
			event.setPriTrfRuleVO((PriTrfRuleVO)getVO(request, PriTrfRuleVO .class));
		}

		else if(command.isCommand(FormCommand.MODIFY04)) {
			event.setPriTrfRuleVO((PriTrfRuleVO)getVO(request, PriTrfRuleVO .class));
		}

		else if(command.isCommand(FormCommand.MODIFY05)) {
			event.setPriTrfRuleVO((PriTrfRuleVO)getVO(request, PriTrfRuleVO .class));
		}

		else if(command.isCommand(FormCommand.MODIFY06)) {
			event.setPriTrfRuleVO((PriTrfRuleVO)getVO(request, PriTrfRuleVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.setPriTrfRuleVO((PriTrfRuleVO)getVO(request, PriTrfRuleVO .class));
			PriTrfRuleListVO vo = new PriTrfRuleListVO();
			vo.setPriTrfRuleVOs((PriTrfRuleVO[])getVOs(request, PriTrfRuleVO .class,""));
			vo.setTrfRuleCtnt(request.getParameter("trf_rule_ctnt"));
			event.setPriTrfRuleListVO(vo);
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