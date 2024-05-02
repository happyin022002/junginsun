/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0037HTMLAction.java
*@FileTitle : Revenue VVD Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.06.01 윤세영
* 1.0 Creation
* --------------------------------------------------------------
* History
* 2011.01.19 이준범 [CHM-201108373-01] Revenuse VVD Creation 관련
* 작업내용 : 1) ERP Target VVD 선정 I/F 시 FMS에 임의로 생성된 VVD 삭제
*          2) finalizingFlg 추가
=========================================================*/ 

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomVvdVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.fms.timecharterinoutaccounting 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TimeCharterInOutAccountingSC로 실행요청<br>
 * - TimeCharterInOutAccountingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Yoon, Seyeong
 * @see TimeCharterInOutAccountingEvent 참조
 * @since J2EE 1.6
 */

public class ESM_FMS_0037HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_FMS_0037HTMLAction 객체를 생성
	 */
	public ESM_FMS_0037HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TimeCharterInOutAccountingEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmFms0037Event event = new EsmFms0037Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			String finalizingFlg = JSPUtil.getParameter(request, "finalizing_flg","");
			event.setFinalizingFlg(finalizingFlg);
			event.setCustomVvdVOS((CustomVvdVO[])getVOs(request, CustomVvdVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setRevYrmon(request.getParameter("rev_yrmon"));
			event.setSlanCd(request.getParameter("slan_cd"));
			event.setRlaneCd(request.getParameter("rlane_cd"));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setRevYrmon(request.getParameter("rev_yrmon"));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setRevYrmon(request.getParameter("rev_yrmon"));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setRevYrmon(request.getParameter("rev_yrmon"));
		}
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