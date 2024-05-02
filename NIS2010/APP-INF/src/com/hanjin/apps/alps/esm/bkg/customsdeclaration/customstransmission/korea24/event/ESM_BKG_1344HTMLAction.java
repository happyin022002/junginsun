/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1344HTMLAction.java
 *@FileTitle : ESM_BKG_1344HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.04
 *@LastModifier : 박상훈
 *@LastVersion : 1.0
 * 2009.08.04 박상훈
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24AmendManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24CancelManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24DischManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24EmpAmdManiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManiSumCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManifestSmryCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24VslInfoNManifestCondVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Kyoung Jong Yun
 * @see EsmBkg1344Event 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_1344HTMLAction extends HTMLActionSupport
{

	private static final long serialVersionUID = 1L;

	public ESM_BKG_1344HTMLAction() {}

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
		EsmBkg1344Event event = new EsmBkg1344Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			// Receive Log 조회
			Kor24VslInfoNManifestCondVO condVO = (Kor24VslInfoNManifestCondVO)getVO(request, Kor24VslInfoNManifestCondVO.class);
			event.setKor24VslInfoNManifestCondVO(condVO);
		}else if (command.isCommand(FormCommand.MODIFY)) {
			// 정보 수정
			Kor24ManifestSmryCondVO condVO = (Kor24ManifestSmryCondVO)getVO(request, Kor24ManifestSmryCondVO.class);
			event.setKor24ManifestSmryCondVO(condVO);
		}else if (command.isCommand(FormCommand.REMOVE)) {
			// Manifest 삭제
			Kor24ManiSumCondVO condVO = (Kor24ManiSumCondVO)getVO(request, Kor24ManiSumCondVO.class);
			event.setKor24ManiSumCondVO(condVO);
		}else if (command.isCommand(FormCommand.MULTI04)) {
			// Trans Discharge
			Kor24DischManifestTransmitVO condVO = (Kor24DischManifestTransmitVO)getVO(request, Kor24DischManifestTransmitVO.class);
			event.setKor24DischManifestTransmitVO(condVO);
		}else if (command.isCommand(FormCommand.MULTI05)) {
			// Trans Manifest
			Kor24ManifestTransmitVO korManifestTransmitVO = (Kor24ManifestTransmitVO)getVO(request, Kor24ManifestTransmitVO.class);
			event.setKor24ManifestTransmitVO(korManifestTransmitVO);
		}else if (command.isCommand(FormCommand.MULTI02)) {
			// Trans Amdentment to PA
			Kor24AmendManifestTransmitVO condVO = (Kor24AmendManifestTransmitVO)getVO(request, Kor24AmendManifestTransmitVO.class);
			event.setKor24AmendManifestTransmitVO(condVO);
		}else if (command.isCommand(FormCommand.MULTI06)) {
			// Trans Empty Amend
			Kor24AmendManifestTransmitVO condVO = (Kor24AmendManifestTransmitVO)getVO(request, Kor24AmendManifestTransmitVO.class);
			Kor24EmpAmdManiVO[] korEmpAmdManiVOs = (Kor24EmpAmdManiVO[])getVOs(request, Kor24EmpAmdManiVO.class, "tsinfo_");
			event.setKor24AmendManifestTransmitVO(condVO);
			event.setKor24EmpAmdManiVOs(korEmpAmdManiVOs);
		}else if (command.isCommand(FormCommand.MULTI07)) {
			// Cancel Per BL
			Kor24CancelManifestTransmitVO korCancelManifestTransmitVO = (Kor24CancelManifestTransmitVO)getVO(request, Kor24CancelManifestTransmitVO.class);
			event.setKor24CancelManifestTransmitVO(korCancelManifestTransmitVO);
		}else if (command.isCommand(FormCommand.COMMAND01)) {
			event.setAttribute("key", request.getParameter("key"));
		}

		request.setAttribute("Event", event);
		return event;
	}
}
