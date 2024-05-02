/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0031HTMLAction.java
 *@FileTitle : ESM_BKG_0031HTMLAction
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

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlAmdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCntrCorrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorContainerCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCorrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCustCorrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorExpCorrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestAmdManiVO;
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
 * @see EsmBkg0031Event 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_0031HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	public ESM_BKG_0031HTMLAction() {}

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
		EsmBkg0031Event event = new EsmBkg0031Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			// 조회
			KorBlInfoCondVO korBlInfoCondVO = (KorBlInfoCondVO)getVO(request, KorBlInfoCondVO.class);
			event.setKorBlInfoCondVO(korBlInfoCondVO);
		} else  if (command.isCommand(FormCommand.MULTI)) {
			// SAVE
			KorManifestAmdManiVO korManifestAmdManiVO = new KorManifestAmdManiVO();

			KorBlAmdVO korBlAmdVO = (KorBlAmdVO)getVO(request, KorBlAmdVO.class);
			KorCntrCorrVO[] korCntrCorrVOs 	= (KorCntrCorrVO[])getVOs(request, KorCntrCorrVO.class, "sheet1_");
			KorCustCorrVO   korCustCorrVO   = (KorCustCorrVO)getVO(request, KorCustCorrVO.class);
			KorExpCorrVO[]  korExpCorrVOs 	= (KorExpCorrVO[])getVOs(request, KorExpCorrVO.class, "sheet2_");
			KorCorrListVO[] korCorrListVOs 	= (KorCorrListVO[])getVOs(request, KorCorrListVO.class, "sheet3_");

			// 추가 정보 매핑
			korManifestAmdManiVO.setMode  (request.getParameter("mode")   );
			korManifestAmdManiVO.setPolLoc(request.getParameter("pol_loc"));
			korManifestAmdManiVO.setPodLoc(request.getParameter("pod_loc"));
			korManifestAmdManiVO.setPortCd(request.getParameter("port_cd"));
			korManifestAmdManiVO.setBlNo  (request.getParameter("bl_no")  );

			// 객체 매핑
			korManifestAmdManiVO.setKorBlAmdVO		(korBlAmdVO		);
			korManifestAmdManiVO.setKorCntrCorrVOs	(korCntrCorrVOs	);
			korManifestAmdManiVO.setKorCustCorrVO	(korCustCorrVO	);
			korManifestAmdManiVO.setKorExpCorrVOs	(korExpCorrVOs	);
			korManifestAmdManiVO.setKorCorrListVOs	(korCorrListVOs	);

			// 이벤트에 전달
			event.setKorManifestAmdManiVO(korManifestAmdManiVO);
		} else  if (command.isCommand(FormCommand.MODIFY01)) {
			// TRANSMIT
			KorAmdManifestTransmitVO korAmdManifestTransmitVO = new KorAmdManifestTransmitVO();

			KorBlAmdVO korBlAmdVO = (KorBlAmdVO)getVO(request, KorBlAmdVO.class);
			KorCntrCorrVO[] korCntrCorrVOs 	= (KorCntrCorrVO[])getVOs(request, KorCntrCorrVO.class, "sheet1_");
			KorCustCorrVO   korCustCorrVO   = (KorCustCorrVO)getVO(request, KorCustCorrVO.class);
			KorExpCorrVO[]  korExpCorrVOs 	= (KorExpCorrVO[])getVOs(request, KorExpCorrVO.class, "sheet2_");
			KorCorrListVO[] korCorrListVOs 	= (KorCorrListVO[])getVOs(request, KorCorrListVO.class, "sheet3_");

			// 추가 정보 매핑
			korAmdManifestTransmitVO.setMode  (request.getParameter("mode")   );
			korAmdManifestTransmitVO.setPolLoc(request.getParameter("pol_loc"));
			korAmdManifestTransmitVO.setPodLoc(request.getParameter("pod_loc"));
			korAmdManifestTransmitVO.setCTrnsSeq(request.getParameter("c_trns_seq"));
			korAmdManifestTransmitVO.setDmstPortCd(request.getParameter("dmst_port_cd"));
			// 객체 매핑
			korAmdManifestTransmitVO.setKorBlAmdVO		(korBlAmdVO		);
			korAmdManifestTransmitVO.setKorCntrCorrVOs	(korCntrCorrVOs	);
			korAmdManifestTransmitVO.setKorCustCorrVO	(korCustCorrVO	);
			korAmdManifestTransmitVO.setKorExpCorrVOs	(korExpCorrVOs	);
			korAmdManifestTransmitVO.setKorCorrListVOs	(korCorrListVOs	);

			// 이벤트에 전달
			event.setKorAmdManifestTransmitVO(korAmdManifestTransmitVO);
		} else  if (command.isCommand(FormCommand.COMMAND02)) {
			// Container 입력시 코드 조회
			KorContainerCondVO containerCondVO = (KorContainerCondVO)getVO(request, KorContainerCondVO.class);

			event.setKorContainerCondVO(containerCondVO);
		}

		request.setAttribute("Event", event);

		return event;
	}
}
