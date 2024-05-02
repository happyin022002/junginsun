/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0730HTMLAction.java
*@FileTitle : ESM_BKG-0730
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.05.26 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.VvdJapanTerminalEdiVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM SEUNG MIN
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */
public class ESM_BKG_0479HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0730HTMLAction 객체를 생성
	 */
	public ESM_BKG_0479HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unused")
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
    	EsmBkg0479Event event = new EsmBkg0479Event();
		JapanManifestTransmitVO[] japanManifestTransmitVOs = null;
		VvdJapanTerminalEdiVO[] vvdJapanTerminalEdiVOs = null;
		//ManifestTransmitVO manifestTransmitVO = new ManifestTransmitVO();

		if (command.isCommand(FormCommand.SEARCH)) {
			event.setJapanTerminalEdiCondVO((JapanTerminalEdiCondVO)getVO(request, JapanTerminalEdiCondVO .class));

		} else if (command.isCommand(FormCommand.SEARCH01)){
			event.setJapanTerminalEdiCondVO((JapanTerminalEdiCondVO)getVO(request, JapanTerminalEdiCondVO .class));

		} else if (command.isCommand(FormCommand.MULTI)) {
			vvdJapanTerminalEdiVOs = (VvdJapanTerminalEdiVO[])getVOs(request, VvdJapanTerminalEdiVO.class, "");
			event.setVvdJapanTerminalEdiVOS((VvdJapanTerminalEdiVO[])vvdJapanTerminalEdiVOs);

		} else if(command.isCommand(FormCommand.MULTI01)) {
			vvdJapanTerminalEdiVOs = (VvdJapanTerminalEdiVO[])getVOs(request, VvdJapanTerminalEdiVO.class, "");
			event.setVvdJapanTerminalEdiVOS((VvdJapanTerminalEdiVO[])vvdJapanTerminalEdiVOs);
			event.setVvdJapanTerminalEdiVO((VvdJapanTerminalEdiVO)getVO(request, VvdJapanTerminalEdiVO .class));

		} else if (command.isCommand(FormCommand.SEARCH10)) {
			// BackEndJob 으로 돌린 후 결과코드 조회
			japanManifestTransmitVOs = (JapanManifestTransmitVO[])getVOs(request, JapanManifestTransmitVO.class, "");
			//event.setManifestTransmitVOS((JapanManifestTransmitVO[])japanManifestTransmitVOs);
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
