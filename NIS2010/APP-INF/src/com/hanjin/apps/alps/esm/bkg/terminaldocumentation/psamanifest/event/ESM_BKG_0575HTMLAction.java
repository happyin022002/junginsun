/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0575HTMLAction.java
*@FileTitle : ESM_BKG_0575HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 4.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 9. 4. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaVvdVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * ESM_BKG_0575 의 HTML Action Class
 * 
 * @author 박상훈
 * @see HTMLActionSupport
 * @since J2EE 1.6
 */
public class ESM_BKG_0575HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	public ESM_BKG_0575HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EsmBkg0575Event event = new EsmBkg0575Event();
		FormCommand command = FormCommand.fromRequest(request);
		
		if(command.isCommand(FormCommand.SEARCH)) {
			// 조회 처리
			PsaVvdVO psaVvdVO = (PsaVvdVO)getVO(request, PsaVvdVO.class);
			event.setPsaVvdVO(psaVvdVO);
		}else if(command.isCommand(FormCommand.COMMAND01)) {
			// VSL 이름 조회
			PsaVvdVO psaVvdVO = (PsaVvdVO)getVO(request, PsaVvdVO.class);
			event.setPsaVvdVO(psaVvdVO);
		}else if(command.isCommand(FormCommand.MULTI)) {
			// 정보 수정
			PsaVvdVO[] psaVvdVOs = (PsaVvdVO[])getVOs(request, PsaVvdVO.class);
			event.setPsaVvdVOs(psaVvdVOs);
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
