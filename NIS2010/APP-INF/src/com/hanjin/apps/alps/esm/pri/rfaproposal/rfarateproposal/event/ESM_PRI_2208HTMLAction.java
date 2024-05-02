/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_2060HTMLAction.java
 *@FileTitle : RFA Proposal Creation - Rate [Load Excel] (H Type)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.04.14
 *@LastModifier : 박근환
 *@LastVersion : 1.0
 * 2016.04.14 박근환
 * 1.0 Creation
 =========================================================
 * History
 * [CHM-201640671] RFA 효율화를 위한 요청 (1차)
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriRfaNoteConvVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;

/**
 * HTTP Parser<br>
 * @author Geunhwna, Park
 * @see EsmPri2208Event 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_2208HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_PRI_2208HTMLAction 객체를 생성
	 */
	public ESM_PRI_2208HTMLAction() {
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
		EsmPri2208Event event = new EsmPri2208Event();
		event.setFicRtTpCd(JSPUtil.getParameter(request, "fic_rt_tp_cd", ""));
		event.setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		
		if (command.isCommand(FormCommand.SEARCH01)) {
			event.setPriRpScpRtCmdtHdrVO((PriRpScpRtCmdtHdrVO) getVO(request, PriRpScpRtCmdtHdrVO.class));
			event.setRsltRtListHorizontalExcelVOS((RsltRtListHorizontalExcelVO[]) getVOs(request, RsltRtListHorizontalExcelVO.class, ""));
		} else if (command.isCommand(FormCommand.MODIFY01)) {
			event.setPriRpScpRtCmdtHdrVO((PriRpScpRtCmdtHdrVO) getVO(request, PriRpScpRtCmdtHdrVO.class));
			event.setRsltRtListHorizontalExcelVOS((RsltRtListHorizontalExcelVO[]) getVOs(request, RsltRtListHorizontalExcelVO.class, ""));
		} else if (command.isCommand(FormCommand.MODIFY02)) {
			event.setPriRpScpRtCmdtHdrVO((PriRpScpRtCmdtHdrVO) getVO(request, PriRpScpRtCmdtHdrVO.class));
			event.setRsltRtListHorizontalExcelVOS((RsltRtListHorizontalExcelVO[]) getVOs(request, RsltRtListHorizontalExcelVO.class, ""));
		} else {
			event.setPriRfaNoteConvVO((PriRfaNoteConvVO) getVO(request, PriRfaNoteConvVO.class));
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