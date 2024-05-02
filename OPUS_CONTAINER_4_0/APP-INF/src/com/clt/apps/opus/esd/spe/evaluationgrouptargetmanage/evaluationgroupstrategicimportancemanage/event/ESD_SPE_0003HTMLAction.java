/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SPE_0003HTMLAction.java
*@FileTitle : SI Analysis Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 권정화
*@LastVersion : 1.0
* 2009.07.29 권정화
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.event;
import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.vo.SearchInputListVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdAllListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.SpeEvGrpStrgImptRsltVO;

 
/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EvaluationGroupTargetManageSC로 실행요청<br>
 * - EvaluationGroupTargetManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kown Jeong hwa
 * @see EvaluationGroupTargetManageEvent 참조
 * @since J2EE 1.6
 */

public class ESD_SPE_0003HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_SPE_0003HTMLAction 객체를 생성
	 */
	public ESD_SPE_0003HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EvaluationGroupTargetManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdSpe0003Event event = new EsdSpe0003Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setSpeEvGrpStrgImptRsltVOs((SpeEvGrpStrgImptRsltVO[])getVOs(request, SpeEvGrpStrgImptRsltVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchInputListVO((SearchInputListVO) getVO(request, SearchInputListVO .class));
		}
		else {
			event.setSearchEGIdAllListVO((SearchEGIdAllListVO)getVO(request, SearchEGIdAllListVO .class));
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