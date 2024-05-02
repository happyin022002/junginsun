/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0505HTMLAction.java
*@FileTitle : ESM_BKG_0505HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.01 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlInqInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCntrInqInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorContainerCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCustInqInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorElnoInqInfoVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Min Jeong
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 **/
public class ESM_BKG_0505HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
	/**************************************************************************
	 * ESM_BKG_0329HTMLAction 객체를 생성
	 **************************************************************************/
	public ESM_BKG_0505HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0505Event event = new EsmBkg0505Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			// EDIT 모드시 조회
			KorBlInqInfoVO korBlInqInfoVO = (KorBlInqInfoVO)getVO(request, KorBlInqInfoVO.class);
			event.setKorBlInqInfoVO(korBlInqInfoVO);
		} else if (command.isCommand(FormCommand.MULTI)) {
			// SAVE 처리
			KorBlInqInfoVO 		korBlInqInfoVO 		= (KorBlInqInfoVO)getVO		(request, KorBlInqInfoVO.class	);
			KorCntrInqInfoVO[] 	korCntrInqInfoVOs 	= (KorCntrInqInfoVO[])getVOs(request, KorCntrInqInfoVO.class);
			KorCustInqInfoVO 	korCustInqInfoVO 	= (KorCustInqInfoVO)getVO	(request, KorCustInqInfoVO.class);
			KorElnoInqInfoVO[] 	korElnoInqInfoVOs	= (KorElnoInqInfoVO[])getVOs(request, KorElnoInqInfoVO.class);

			event.setKorBlInqInfoVO		(korBlInqInfoVO		);
			event.setKorCntrInqInfoVOs	(korCntrInqInfoVOs	);
			event.setKorCustInqInfoVO	(korCustInqInfoVO	);
			event.setKorElnoInqInfoVOs	(korElnoInqInfoVOs	);

		} else if (command.isCommand(FormCommand.COMMAND02)) {
			// Container 입력시 코드 조회
			KorContainerCondVO containerCondVO = (KorContainerCondVO)getVO(request, KorContainerCondVO.class);

			event.setKorContainerCondVO(containerCondVO);
		}
		request.setAttribute("Event", event);

		return  event;
	}
}