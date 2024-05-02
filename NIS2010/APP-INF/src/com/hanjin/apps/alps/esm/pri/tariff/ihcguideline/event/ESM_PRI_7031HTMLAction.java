/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7031HTMLAction.java
 *@FileTitle : US Inland Add-on Creation & Amendment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.11.07
 *@LastModifier : SEO MI JIN
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCGuidelineMainVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriTrfIhcProgVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.tariff 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TariffSC로 실행요청<br>
 * - TariffSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author SEO MI JIN
 * @see TariffEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_7031HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_PRI_7031HTMLAction 객체를 생성
	 */
	public ESM_PRI_7031HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TariffEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsmPri7031Event event = new EsmPri7031Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			event.setiHCGuidelineMainVO((IHCGuidelineMainVO) getVO(request, IHCGuidelineMainVO.class));
		} else if (command.isCommand(FormCommand.SEARCH01)) {
			event.setiHCGuidelineMainVO((IHCGuidelineMainVO) getVO(request, IHCGuidelineMainVO.class));
		} else if (command.isCommand(FormCommand.SEARCH02)) {
			event.setiHCGuidelineMainVO((IHCGuidelineMainVO) getVO(request, IHCGuidelineMainVO.class));			
		} else if (command.isCommand(FormCommand.SEARCH03)) {
			event.setiHCGuidelineMainVO((IHCGuidelineMainVO) getVO(request, IHCGuidelineMainVO.class));		
		} else if (command.isCommand(FormCommand.MULTI)) {
			event.setiHCGuidelineMainVO((IHCGuidelineMainVO) getVO(request, IHCGuidelineMainVO.class));
		} else if (command.isCommand(FormCommand.MULTI02)) {
			event.setiHCGuidelineMainVO((IHCGuidelineMainVO) getVO(request, IHCGuidelineMainVO.class));
		} else if (command.isCommand(FormCommand.MULTI03)) {
			event.setiHCGuidelineMainVO((IHCGuidelineMainVO) getVO(request, IHCGuidelineMainVO.class));
			event.setPriTrfIhcProgVO((PriTrfIhcProgVO) getVO(request, PriTrfIhcProgVO.class));
		} else if (command.isCommand(FormCommand.MULTI04)) {
			event.setiHCGuidelineMainVO((IHCGuidelineMainVO) getVO(request, IHCGuidelineMainVO.class));
		} else if (command.isCommand(FormCommand.MULTI05)) {
			event.setiHCGuidelineMainVO((IHCGuidelineMainVO) getVO(request, IHCGuidelineMainVO.class));
		}
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