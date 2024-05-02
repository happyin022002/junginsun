/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0002HTMLAction.java
 *@FileTitle : CndCustomsTransmission
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlVO;
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
 * 
 * @author Kim Min Jeong
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */
public class ESM_BKG_0002HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * ESM_BKG_0002HTMLAction 객체를 생성
	 */
	public ESM_BKG_0002HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0002Event event = new EsmBkg0002Event();
		if (command.isCommand(FormCommand.SEARCH))
		{
			// 상단 조회
			event.setCstmsManifestCondVO((CndCstmsManifestCondVO) getVO(request, CndCstmsManifestCondVO.class));
		}
		else if (command.isCommand(FormCommand.SEARCH01))
		{
			// 하단 Detail 조회
			event.setCstmsManifestCondVO((CndCstmsManifestCondVO) getVO(request, CndCstmsManifestCondVO.class));
		}
		else if (command.isCommand(FormCommand.MODIFY))
		{
			// Delete
			CndCstmsBlVO[] cndCstmsBlVO = new CndCstmsBlVO[1];
			cndCstmsBlVO[0] = new CndCstmsBlVO();
			cndCstmsBlVO[0].setBlNo(request.getParameter("bl_no"));
			cndCstmsBlVO[0].setMfStsCd("D");
			event.setCstmsBlVOs(cndCstmsBlVO);
		}
		else if (command.isCommand(FormCommand.MULTI))
		{
			// Transmit
			String[] sBlNos = request.getParameterValues("bl_no");
			CndCstmsManifestVO vo = new CndCstmsManifestVO();
			vo.setBlNos(sBlNos);
			if ("Terminal".equals(request.getParameter("type")))
			{
				vo.setIbflag("Terminal");
			}
			// A6A전송 시 Terminal 자동전송을 하는 경우 세팅 
			vo.setTerminalAutoSnd(request.getParameter("terminal_auto_snd"));
			event.setManifestTransmitVO(vo);
		}
		else if (command.isCommand(FormCommand.SEARCH03))
		{
			// BackEndJob 으로 돌린 후 결과코드 조회
			event.setKey(request.getParameter("key"));
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