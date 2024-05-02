/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0216HTMLAction.java
*@FileTitle : M&R Guideline & Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2009.06.08 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.planmanage.planmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.mnr.planmanage.planmgt.vo.CustomMnrGuidelineVO;
import com.clt.apps.opus.ees.mnr.planmanage.planmgt.vo.GuidelineGRPVO;
import com.clt.apps.opus.ees.mnr.planmanage.planmgt.vo.GuidelineINVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.mnr.planmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PlanManageSC로 실행요청<br>
 * - PlanManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author LEE JU HYUN
 * @see PlanManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_MNR_0216HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0216HTMLAction 객체를 생성
	 */
	public EES_MNR_0216HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PlanManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EesMnr0216Event event = new EesMnr0216Event();
		
		GuidelineGRPVO guidelineGRPVO = new GuidelineGRPVO();
		
		//조회  	
		if(command.isCommand(FormCommand.SEARCH)) { 
			guidelineGRPVO.setGuidelineINVO((GuidelineINVO)getVO(request, GuidelineINVO .class));
		}			 
		//저장
		else if(command.isCommand(FormCommand.MULTI)) {
			guidelineGRPVO.setCustomMnrGuidelineVOs((CustomMnrGuidelineVO[])getVOs(request, CustomMnrGuidelineVO.class, ""));
		}		 
		event.setGuidelineGRPVO(guidelineGRPVO);				
		request.setAttribute("Event", event);

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