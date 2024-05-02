/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1046HTMLAction.java
 *@FileTitle : ESM_BKG_1046HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.25
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.08.25 이수빈
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.TransKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.VvdKeyVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.CommonWebKeys;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 이수빈
 * @see EsmBkg1046Event 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_1046HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	public ESM_BKG_1046HTMLAction() {}

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
		EsmBkg1046Event event = new EsmBkg1046Event();

		if (command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.MULTI01)) {
			event.setVvdKeyVO((VvdKeyVO)getVO(request, VvdKeyVO.class));

		} else if (command.isCommand(FormCommand.MULTI)) {
			// Delete
			event.setChinaBlInfoListVOs((ChinaBlInfoListVO[])getVOs(request, ChinaBlInfoListVO.class));

		} else if (command.isCommand(FormCommand.MULTI02) || command.isCommand(FormCommand.MULTI04)) {
			// Transmit
			ChinaManifestTransmitVO transmitVO = new ChinaManifestTransmitVO();
			transmitVO.setChinaBlInfoListVOs((ChinaBlInfoListVO[])getVOs(request, ChinaBlInfoListVO.class));
			transmitVO.setTransKeyVO((TransKeyVO)getVO(request, TransKeyVO.class));
			event.setChinaManifestTransmitVO(transmitVO);

		} else if (command.isCommand(FormCommand.MULTI03)) {
			// BackEndJob 으로 돌린 후 결과코드 조회
			event.setKey(request.getParameter("key"));

		} else {
			// INIT
			// China POL & POD Office 메뉴
			SignOnUserAccount account = (SignOnUserAccount)request.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			String pgmNo = request.getParameter("pgmNo");
			if (pgmNo.endsWith("1") || pgmNo.endsWith("V")) {
				if (account.getCnt_cd().startsWith("CN")) {    // 중국 내 지역 (홍콩 제외)
					if (account.getOfc_cd().startsWith("HKG")) {
						event.setTransMode("O");
					} else {
						event.setTransMode("D");
					}

				} else {   // 중국 외 지역
					event.setTransMode("O");
				}

			} else if (pgmNo.endsWith("2") || pgmNo.endsWith("W")) {    // China Office O/B Only 메뉴
				event.setTransMode("P");
			}
		}

		request.setAttribute("Event", event);
		return event;
	}
}
