/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_2030HTMLAction.java
 *@FileTitle : RFA Proposal Creation - Route Popup (Add-On Tariff Management)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.09.25
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.FicCheckCYPortLocationVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.FicRouteGroupVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutViaVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scguideline 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCGuidelineSC로 실행요청<br>
 * - SCGuidelineSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Eunsup, Lee
 * @see SCGuidelineEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_2030HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * UI_PRI_2030HTMLAction 객체를 생성
	 */
	public ESM_PRI_2030HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCGuidelineEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsmPri2030Event event = new EsmPri2030Event();

		if (command.isCommand(FormCommand.MODIFY01)) {
			event.setPriRpScpRtCmdtHdrVO((PriRpScpRtCmdtHdrVO) getVO(request, PriRpScpRtCmdtHdrVO.class));

			PriRpScpRtCmdtHdrVO hdrVO = event.getPriRpScpRtCmdtHdrVO();
			if ("A".equals(hdrVO.getFicRtTpCd())) {
				event.setPriRpScpRtRoutOrgPntVO((PriRpScpRtRoutPntVO[]) getVOs(request, PriRpScpRtRoutPntVO.class, "sheet5_"));
				event.setPriRpScpRtRoutDestPntVO((PriRpScpRtRoutPntVO[]) getVOs(request, PriRpScpRtRoutPntVO.class, "sheet6_"));

			} else {
				event.setPriRpScpRtRoutOrgPntVO((PriRpScpRtRoutPntVO[]) getVOs(request, PriRpScpRtRoutPntVO.class, "sheet1_"));
				event.setPriRpScpRtRoutDestPntVO((PriRpScpRtRoutPntVO[]) getVOs(request, PriRpScpRtRoutPntVO.class, "sheet4_"));
			}

			event.setPriRpScpRtRoutOrgViaVO((PriRpScpRtRoutViaVO[]) getVOs(request, PriRpScpRtRoutViaVO.class, "sheet2_"));
			event.setPriRpScpRtRoutDestViaVO((PriRpScpRtRoutViaVO[]) getVOs(request, PriRpScpRtRoutViaVO.class, "sheet3_"));

		} else if (command.isCommand(FormCommand.MODIFY02)) {
			event.setPriRpScpRtCmdtHdrVO((PriRpScpRtCmdtHdrVO) getVO(request, PriRpScpRtCmdtHdrVO.class));

			PriRpScpRtCmdtHdrVO hdrVO = event.getPriRpScpRtCmdtHdrVO();
			if ("A".equals(hdrVO.getFicRtTpCd())) {
				event.setPriRpScpRtRoutOrgPntVO((PriRpScpRtRoutPntVO[]) getVOs(request, PriRpScpRtRoutPntVO.class, "sheet5_"));
				event.setPriRpScpRtRoutDestPntVO((PriRpScpRtRoutPntVO[]) getVOs(request, PriRpScpRtRoutPntVO.class, "sheet6_"));
			} else {
				event.setPriRpScpRtRoutOrgPntVO((PriRpScpRtRoutPntVO[]) getVOs(request, PriRpScpRtRoutPntVO.class, "sheet1_"));
				event.setPriRpScpRtRoutDestPntVO((PriRpScpRtRoutPntVO[]) getVOs(request, PriRpScpRtRoutPntVO.class, "sheet4_"));
			}

			event.setPriRpScpRtRoutOrgViaVO((PriRpScpRtRoutViaVO[]) getVOs(request, PriRpScpRtRoutViaVO.class, "sheet2_"));
			event.setPriRpScpRtRoutDestViaVO((PriRpScpRtRoutViaVO[]) getVOs(request, PriRpScpRtRoutViaVO.class, "sheet3_"));

		} else if (command.isCommand(FormCommand.SEARCH01)) {
			event.setFicRouteGroupVO((FicRouteGroupVO) getVO(request, FicRouteGroupVO.class));
		} else if (command.isCommand(FormCommand.SEARCH02)) {
			event.setFicCheckCYPortLocationVO((FicCheckCYPortLocationVO) getVO(request, FicCheckCYPortLocationVO.class));
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