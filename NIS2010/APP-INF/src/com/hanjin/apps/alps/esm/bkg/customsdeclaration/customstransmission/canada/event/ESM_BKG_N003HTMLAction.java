/*=========================================================
 *Copyright(c) 2017 SMLines
 *@FileName : ESM_BKG_N003HTMLAction.java
 *@FileTitle : Canada Export: Amendment Transmit (AI) HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0 
 * 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestAmendmentCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestAmendmentVO;
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
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */
public class ESM_BKG_N003HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * ESM_BKG_N003HTMLAction 객체를 생성
	 */
	public ESM_BKG_N003HTMLAction() {
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
		EsmBkgN003Event event = new EsmBkgN003Event();
		// US와 CA가 같은 화면을 사용하기때문에 나라세팅 SC에서 분기해서 비지니스로직 수행
		event.setCntCd(request.getParameter("cnt_cd"));
		event.setAiDiv(request.getParameter("ai_div"));		
		if (command.isCommand(FormCommand.SEARCH)){
			String sPageNo = request.getParameter("page_no");
			if (sPageNo == null) sPageNo = "1";
			int iPageNo   = Integer.parseInt(sPageNo);
			int iStartNo  = 0;
			int iEndNo    = 0;
			int iPagerows = 100;
			iStartNo      = (iPageNo * iPagerows) - iPagerows + 1;
			iEndNo        = iStartNo + iPagerows - 1;
			// 마지막행까지 조회
			if (request.getParameter("end_no") != null) {
				if (iEndNo < Integer.parseInt(request.getParameter("end_no"))) {
					iEndNo = Integer.parseInt(request.getParameter("end_no"));
				}
			}
			
			CndCstmsManifestAmendmentCondVO cndCondVO = (CndCstmsManifestAmendmentCondVO) getVO(request,CndCstmsManifestAmendmentCondVO.class);
			cndCondVO.setStartNo(iStartNo + "");
			cndCondVO.setEndNo(iEndNo + "");
			event.setCstmsManifestAmendmentCondVO(cndCondVO);

		} else if (command.isCommand(FormCommand.MULTI) ||    // Transmit - Start AI
				   command.isCommand(FormCommand.MULTI01)) {  // Transmit -Immediate Delete & AI
			event.setCstmsManifestAmendmentVO((CndCstmsManifestAmendmentVO) getVO(request, CndCstmsManifestAmendmentVO.class));

		} else if (command.isCommand(FormCommand.MULTI02)) {    // Save
			event.setCstmsManifestAmendmentVOs((CndCstmsManifestAmendmentVO[]) getVOs(request, CndCstmsManifestAmendmentVO.class));
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