/*=========================================================
 *Copyright(c) SMLines. All Rights Reserved.
 *@FileName : ESM_BKG_N002HTMLAction.java
 *@FileTitle : ESM_BKG_N002HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion :
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing한 정보를 Event로 변환, request에 담아 CustomsDeclarationCanadaExpSC로 실행요청<br>
 * - CustomsDeclarationCanadaExpSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author
 * @see EsmBkgN002Event 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_N002HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * ESM_BKG_N002HTMLAction 객체를 생성
	 */
	public ESM_BKG_N002HTMLAction() {
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
		EsmBkgN002Event event = new EsmBkgN002Event();
		if (command.isCommand(FormCommand.SEARCH)) {    // 상단 조회
			event.setCstmsManifestCondVO((CndCstmsManifestCondVO) getVO(request, CndCstmsManifestCondVO.class));

		} else if (command.isCommand(FormCommand.SEARCH01)) {    // 하단 Detail 조회
			event.setCstmsManifestCondVO((CndCstmsManifestCondVO) getVO(request, CndCstmsManifestCondVO.class));

		} else if (command.isCommand(FormCommand.MODIFY)) {    // Delete
			CndCstmsBlVO[] cndCstmsBlVO = new CndCstmsBlVO[1];
			cndCstmsBlVO[0] = new CndCstmsBlVO();
			cndCstmsBlVO[0].setBlNo(request.getParameter("bl_no"));
			cndCstmsBlVO[0].setMfStsCd("D");
			cndCstmsBlVO[0].setPgmNo("ESM_BKG_N002");
			event.setCstmsBlVOs(cndCstmsBlVO);

		} else if (command.isCommand(FormCommand.MULTI)) {    // Transmit
			String[] sBlNos = request.getParameterValues("bl_no");
			CndCstmsManifestVO cndCstmsManifestVO = new CndCstmsManifestVO();
			cndCstmsManifestVO.setPgmNo("ESM_BKG_N002");
			cndCstmsManifestVO.setBlNos(sBlNos);
			if ("Terminal".equals(request.getParameter("type"))) cndCstmsManifestVO.setIbflag("Terminal");
			// A6A전송 시 Terminal 자동전송을 하는 경우 세팅
			cndCstmsManifestVO.setTerminalAutoSnd(request.getParameter("terminal_auto_snd"));
			event.setManifestTransmitVO(cndCstmsManifestVO);

		} else if (command.isCommand(FormCommand.SEARCH03)) {
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