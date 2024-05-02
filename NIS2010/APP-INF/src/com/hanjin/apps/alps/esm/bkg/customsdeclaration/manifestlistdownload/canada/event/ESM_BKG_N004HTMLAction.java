/*=========================================================
 *Copyright(c) SMLines
 *@FileName : ESM_BKG_N004HTMLAction.java
 *@FileTitle : ESM_BKG_N004HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlCustVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlMainVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author
 * @see EsmBkgN004Event 참조
 * @since
 */
public class ESM_BKG_N004HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * ESM_BKG_N004HTMLAction 객체를 생성
	 */
	public ESM_BKG_N004HTMLAction() {
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
		EsmBkgN004Event event = new EsmBkgN004Event();
		if (command.isCommand(FormCommand.SEARCH)) {
			event.setCndCstmsBlCondVO((CndCstmsBlCondVO) getVO(request, CndCstmsBlCondVO.class));

		} else if (command.isCommand(FormCommand.MODIFY) || command.isCommand(FormCommand.MODIFY01)) {
			CndCstmsBlContainerVO[] containerVOs = new CndCstmsBlContainerVO[1];
			containerVOs[0] = new CndCstmsBlContainerVO();
			// BL Main
			containerVOs[0].setCndCstmsBlMainVO((CndCstmsBlMainVO) getVO(request, CndCstmsBlMainVO.class));
			// Customer
			containerVOs[0].setCndCstmsBlCustVO((CndCstmsBlCustVO) getVO(request, CndCstmsBlCustVO.class));
			event.setCstmsBlVOs(containerVOs);
			// 전송을 위해서 세팅
			event.setManifestTransmitVO((CndCstmsManifestVO) getVO(request, CndCstmsManifestVO.class));

		} else if (command.isCommand(FormCommand.REMOVE) || command.isCommand(FormCommand.REMOVE01)) {
			CndCstmsBlVO[] cndCstmsBlVOs = new CndCstmsBlVO[1];
			cndCstmsBlVOs[0] = (CndCstmsBlVO) getVO(request, CndCstmsBlVO.class);
			event.setCstmsBlVOs(cndCstmsBlVOs);

			// 전송을 위해서 세팅
			event.setManifestTransmitVO((CndCstmsManifestVO) getVO(request, CndCstmsManifestVO.class));

		} else if (command.isCommand(FormCommand.MODIFY02)) {
			// 전송
			CndCstmsManifestVO cndCstmsManifestVO = (CndCstmsManifestVO) getVO(request, CndCstmsManifestVO.class);
			cndCstmsManifestVO.setPgmNo("ESM_BKG_N004");
			// BL Main
			event.setCndCstmsBlMainVO((CndCstmsBlMainVO) getVO(request, CndCstmsBlMainVO.class));
			event.setManifestTransmitVO(cndCstmsManifestVO);

		} else if (command.isCommand(FormCommand.SEARCH02)) {
			// HUB, LOCATION OF GOODS 가져오기
			event.setPodCd(request.getParameter("frm_pod_cd"));
			event.setPodNodCd(request.getParameter("frm_pod_nod_cd"));
			event.setDelCd(request.getParameter("frm_del_cd"));

		} else if (command.isCommand(FormCommand.SEARCH03)) {
			event.setCustCntCd(request.getParameter("cust_cnt_cd"));
			event.setCustSeq(request.getParameter("cust_seq"));
			event.setCustTp(request.getParameter("cust_tp"));

		} else if (command.isCommand(FormCommand.MODIFY03)) {
			// 전송
			CndCstmsManifestVO cndCstmsManifestVO = (CndCstmsManifestVO) getVO(request, CndCstmsManifestVO.class);
			cndCstmsManifestVO.setPgmNo("ESM_BKG_N004");
			cndCstmsManifestVO.setIbflag("Terminal");
			// BL Main
			event.setCndCstmsBlMainVO((CndCstmsBlMainVO) getVO(request, CndCstmsBlMainVO.class));
			event.setManifestTransmitVO(cndCstmsManifestVO);
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