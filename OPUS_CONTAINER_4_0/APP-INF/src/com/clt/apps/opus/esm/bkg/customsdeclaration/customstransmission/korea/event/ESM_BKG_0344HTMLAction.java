/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_BKG_0344HTMLAction.java
 *@FileTitle : ESM_BKG_0344HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmendManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCancelManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDischManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorEmpAmdManiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManiSumCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestSmryCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorVslInfoNManifestCondVO;
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
 * @author Kyoung Jong Yun
 * @see EsmBkg0344Event 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_0344HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	public ESM_BKG_0344HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0344Event event = new EsmBkg0344Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			// Receive Log 조회
			event.setKorVslInfoNManifestCondVO((KorVslInfoNManifestCondVO)getVO(request, KorVslInfoNManifestCondVO.class));
		} else if (command.isCommand(FormCommand.MODIFY)) {
			// 정보 수정
			event.setKorManifestSmryCondVO((KorManifestSmryCondVO)getVO(request, KorManifestSmryCondVO.class));
		} else if (command.isCommand(FormCommand.REMOVE)) {
			// Manifest 삭제
			event.setKorManiSumCondVO((KorManiSumCondVO)getVO(request, KorManiSumCondVO.class));
		} else if (command.isCommand(FormCommand.MULTI04)) {
			// Trans Discharge
			event.setKorDischManifestTransmitVO((KorDischManifestTransmitVO)getVO(request, KorDischManifestTransmitVO.class));
		} else if (command.isCommand(FormCommand.MULTI05)) {
			// Trans Manifest
			event.setKorManifestTransmitVO((KorManifestTransmitVO)getVO(request, KorManifestTransmitVO.class));
		} else if (command.isCommand(FormCommand.MULTI02)) {
			// Trans Amdentment to PA
			event.setKorAmendManifestTransmitVO((KorAmendManifestTransmitVO)getVO(request, KorAmendManifestTransmitVO.class));
		} else if (command.isCommand(FormCommand.MULTI06)) {
			// Trans Empty Amend
			event.setKorAmendManifestTransmitVO((KorAmendManifestTransmitVO)getVO(request, KorAmendManifestTransmitVO.class));
			event.setKorEmpAmdManiVOs((KorEmpAmdManiVO[])getVOs(request, KorEmpAmdManiVO.class, "tsinfo_"));
		} else if (command.isCommand(FormCommand.MULTI07)) {
			// Cancel Per BL
			event.setKorCancelManifestTransmitVO((KorCancelManifestTransmitVO)getVO(request, KorCancelManifestTransmitVO.class));
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
