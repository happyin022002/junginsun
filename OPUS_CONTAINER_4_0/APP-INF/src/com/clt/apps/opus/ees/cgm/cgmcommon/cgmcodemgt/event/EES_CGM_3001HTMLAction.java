/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_3001HTMLAction.java
*@FileTitle : EES_CGM_3001HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.12 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboMGTVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CgmCommonSC로 실행요청<br>
 * - CgmCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM CHANG SIK
 * @see EesCgm3001Event 참조
 * @since J2EE 1.4
 */
public class EES_CGM_3001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * EES_CGM_3001HTMLAction 객체를 생성
	 */
	public EES_CGM_3001HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ChassisMgsetMgtEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EesCgm3001Event event = new EesCgm3001Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			event.setComboINVO((ComboINVO) getVO(request, ComboINVO.class));
		} else if (command.isCommand(FormCommand.MULTI)) {
			event.setComboMGTVOs((ComboMGTVO[]) getVOs(request, ComboMGTVO.class, "sheet1_"));
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
