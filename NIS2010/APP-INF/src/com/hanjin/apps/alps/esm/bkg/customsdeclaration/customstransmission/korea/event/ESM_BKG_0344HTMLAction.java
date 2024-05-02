/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0344HTMLAction.java
 *@FileTitle : ESM_BKG_0344HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.04
 *@LastModifier : 박상훈
 *@LastVersion : 1.0
 * 2009.08.04 박상훈
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmendManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCancelManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDischManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorEmpAmdManiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManiSumCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestSmryCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorVslInfoNManifestCondVO;
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
 * @see EsmBkg0344Event 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_0344HTMLAction extends HTMLActionSupport 
{

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
	public Event perform(HttpServletRequest request) throws HTMLActionException 
	{
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0344Event event = new EsmBkg0344Event();

		if (command.isCommand(FormCommand.SEARCH)) 
		{
			// Receive Log 조회
			KorVslInfoNManifestCondVO condVO = (KorVslInfoNManifestCondVO)getVO(request, KorVslInfoNManifestCondVO.class);
			event.setKorVslInfoNManifestCondVO(condVO);
		}else if (command.isCommand(FormCommand.MODIFY)) {
			// 정보 수정
			KorManifestSmryCondVO condVO = (KorManifestSmryCondVO)getVO(request, KorManifestSmryCondVO.class);
			event.setKorManifestSmryCondVO(condVO);
		}else if (command.isCommand(FormCommand.REMOVE)) {
			// Manifest 삭제
			KorManiSumCondVO condVO = (KorManiSumCondVO)getVO(request, KorManiSumCondVO.class);
			event.setKorManiSumCondVO(condVO);
		}else if (command.isCommand(FormCommand.MULTI04)) {
			// Trans Discharge
			KorDischManifestTransmitVO condVO = (KorDischManifestTransmitVO)getVO(request, KorDischManifestTransmitVO.class);
			event.setKorDischManifestTransmitVO(condVO);
		}else if (command.isCommand(FormCommand.MULTI05)) {
			// Trans Manifest
			KorManifestTransmitVO korManifestTransmitVO = (KorManifestTransmitVO)getVO(request, KorManifestTransmitVO.class);
			event.setKorManifestTransmitVO(korManifestTransmitVO);
		}else if (command.isCommand(FormCommand.MULTI02)) {
			// Trans Amdentment to PA
			KorAmendManifestTransmitVO condVO = (KorAmendManifestTransmitVO)getVO(request, KorAmendManifestTransmitVO.class);
			event.setKorAmendManifestTransmitVO(condVO);
		}else if (command.isCommand(FormCommand.MULTI06)) {
			// Trans Empty Amend
			KorAmendManifestTransmitVO condVO = (KorAmendManifestTransmitVO)getVO(request, KorAmendManifestTransmitVO.class);			
			KorEmpAmdManiVO[] korEmpAmdManiVOs = (KorEmpAmdManiVO[])getVOs(request, KorEmpAmdManiVO.class, "tsinfo_");
			event.setKorAmendManifestTransmitVO(condVO);
			event.setKorEmpAmdManiVOs(korEmpAmdManiVOs);
		}else if (command.isCommand(FormCommand.MULTI07)) {
			// Cancel Per BL
			KorCancelManifestTransmitVO korCancelManifestTransmitVO = (KorCancelManifestTransmitVO)getVO(request, KorCancelManifestTransmitVO.class);
			event.setKorCancelManifestTransmitVO(korCancelManifestTransmitVO);
		}
		
		request.setAttribute("Event", event);

		return event;
	}
}
