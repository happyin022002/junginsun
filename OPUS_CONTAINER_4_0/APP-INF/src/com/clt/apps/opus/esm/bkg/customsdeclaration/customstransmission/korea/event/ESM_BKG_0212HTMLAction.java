/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0212HTMLAction.java
 *@FileTitle : ESM_BKG_0212HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.15
 *@LastModifier : 박상훈
 *@LastVersion : 1.0
 * 2009.08.15 박상훈
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDgCgoVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDgmVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestDGMTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestDGNTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgCstmsKrDgCgoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgCstmsKrDgCgoVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorDgCgoManifestCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorDgCgoManifestVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 박상훈
 * @see EsmBkg0212Event 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_0212HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	public ESM_BKG_0212HTMLAction() {}

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
		EsmBkg0212Event event = new EsmBkg0212Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			// 조회
			KorDgCgoManifestVO korDgCgoManifestVO = (KorDgCgoManifestVO)getVO(request, KorDgCgoManifestVO.class);
			event.setKorDgCgoManifestVO(korDgCgoManifestVO);
		} else  if (command.isCommand(FormCommand.MULTI)) {
			// 수정
			// 메인 객체
			KorDgCgoManifestCondVO korDgCgoManifestCondVO = (KorDgCgoManifestCondVO)getVO(request, KorDgCgoManifestCondVO.class);
			// VVD INFO 객체
			BkgCstmsKrDgCgoVvdVO bkgCstmsKrDgCgoVvdVO = (BkgCstmsKrDgCgoVvdVO)getVO(request, BkgCstmsKrDgCgoVvdVO.class);
			// Container 객체
			BkgCstmsKrDgCgoVO[] bkgCstmsKrDgCgoVOs = (BkgCstmsKrDgCgoVO[])getVOs(request, BkgCstmsKrDgCgoVO.class, "sheet1_");


			// 하위 객체 SET
			korDgCgoManifestCondVO.setBkgCstmsKrDgCgoVvdVO(bkgCstmsKrDgCgoVvdVO);
			korDgCgoManifestCondVO.setBkgCstmsKrDgCgoVOs(bkgCstmsKrDgCgoVOs);

			// Event 에 넘김
			event.setKorDgCgoManifestCondVO(korDgCgoManifestCondVO);
		} else  if (command.isCommand(FormCommand.MULTI01)) {
			// 반입신고서 전송
			event.setTransmitMode("DGN");
			KorManifestDGNTransmitVO korManifestDGNTransmitVO = new KorManifestDGNTransmitVO();
			// VVD 객체
			KorDgCgoVvdVO korDgCgoVvdVO = (KorDgCgoVvdVO)getVO(request, KorDgCgoVvdVO.class);
			// 하위 객체 SET
			korManifestDGNTransmitVO.setKorDgCgoVvdVO(korDgCgoVvdVO);

			// Event에 넘김
			event.setKorManifestDGNTransmitVO(korManifestDGNTransmitVO);

		} else  if (command.isCommand(FormCommand.MULTI02)) {
			// 적하일람표 전송
			event.setTransmitMode("DGM");
			KorManifestDGMTransmitVO korManifestDGMTransmitVO = new KorManifestDGMTransmitVO();
			// VVD 객체
			KorDgmVvdVO korDgmVvdVO = (KorDgmVvdVO)getVO(request, KorDgmVvdVO.class);
			// Container 객체
			BkgCstmsKrDgCgoVO[] bkgCstmsKrDgCgoVOs = (BkgCstmsKrDgCgoVO[])getVOs(request, BkgCstmsKrDgCgoVO.class, "sheet1_");
			// 하위 객체 SET
			korManifestDGMTransmitVO.setKorDgmVvdVO(korDgmVvdVO);
			korManifestDGMTransmitVO.setBkgCstmsKrDgCgoVOs(bkgCstmsKrDgCgoVOs);

			// Event에 넘김
			event.setKorManifestDGMTransmitVO(korManifestDGMTransmitVO);
		}

		request.setAttribute("Event", event);

		return event;
	}
}
