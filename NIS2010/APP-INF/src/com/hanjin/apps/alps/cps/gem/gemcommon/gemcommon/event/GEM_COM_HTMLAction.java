/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : gemCommonHTMLAction.java
 *@FileTitle : gemCommon
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.16 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeMgtVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.cps.gem.gemcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의
 * Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 gemCommonSC로 실행요청<br>
 * - gemCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Park Sungsoo
 * @see gemCommonEvent 참조
 * @since J2EE 1.4
 */

public class GEM_COM_HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * GEM_COM_HTMLAction 객체를 생성
	 */
	public GEM_COM_HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GemCommonEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);

		// 이벤트 객체 생성
		GemCommonEvent event = new GemCommonEvent();

		// ----------------------------------------------------
		// 이벤트 처리
		// ----------------------------------------------------
		// BU , HO , HQ 콤보 리스트 취득
		if (command.isCommand(FormCommand.SEARCHLIST01)
				|| command.isCommand(FormCommand.SEARCHLIST02)
				|| command.isCommand(FormCommand.SEARCHLIST03)
				|| command.isCommand(FormCommand.SEARCHLIST04)
				|| command.isCommand(FormCommand.SEARCHLIST05)
				|| command.isCommand(FormCommand.SEARCHLIST06)
				|| command.isCommand(FormCommand.SEARCHLIST07)
				|| command.isCommand(FormCommand.SEARCHLIST08)
				|| command.isCommand(FormCommand.SEARCHLIST09)) {

			event.setOfficeMgtVO((OfficeMgtVO) getVO(request, OfficeMgtVO.class));
		}

		request.setAttribute("Event", event);

		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param eventResponse
	 *            EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param event
	 *            Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}