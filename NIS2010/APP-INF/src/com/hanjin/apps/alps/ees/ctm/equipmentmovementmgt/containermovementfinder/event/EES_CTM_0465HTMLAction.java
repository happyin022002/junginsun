/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : EES_CTM_0465HTMLAction.java
 * @FileTitle : Multi Container Inquiry
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2013.12.09
 * @LastModifier : 문동선
 * @LastVersion : 1.0
 * 2013.12.09 문동선 (EES_CTM_0408 화면 Copy 로 생성) 1.0 Creation
 * 2016.08.01 김상현 [CHM-201642497] Multi Container(VGM) Inquiry에 Tab 추가하여 MVMT error+ignored 인경우 별도 tab에서 조회
 */
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEdiMsgVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByMultiContainerVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EquipmentMovementMgtSC로 실행요청<br>
 * - EquipmentMovementMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Moon, Dong-sun
 * @see EquipmentMovementMgtEvent 참조
 * @since J2EE 1.4
 */

public class EES_CTM_0465HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CTM_0465HTMLAction 객체를 생성
	 */
	public EES_CTM_0465HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EquipmentMovementMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EesCtm0465Event event = new EesCtm0465Event();

		if (command.isCommand(FormCommand.SEARCH)) { // Ok Success
			event.setSearchMovementListByMultiContainerVO((SearchMovementListByMultiContainerVO)getVO(request, SearchMovementListByMultiContainerVO.class));
			event.setSearchEdiMsgVO((SearchEdiMsgVO)getVO(request, SearchEdiMsgVO.class));
		} else if (command.isCommand(FormCommand.SEARCHLIST01)) { // Error, Ignore
			event.setSearchMovementListByMultiContainerVO((SearchMovementListByMultiContainerVO)getVO(request, SearchMovementListByMultiContainerVO.class));
			event.setSearchEdiMsgVO((SearchEdiMsgVO)getVO(request, SearchEdiMsgVO.class));
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