/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_2001_04HTMLAction.java
 *@FileTitle : RFA Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.06
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.06 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RfaRtGlineCmdtVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RfaRtGlineRoutVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.PriRgRtCmdtHdrVO;
import com.clt.syscommon.common.table.PriRgRtCmdtRoutVO;
import com.clt.syscommon.common.table.PriRgRtCmdtVO;
import com.clt.syscommon.common.table.PriRgRtRoutPntVO;
import com.clt.syscommon.common.table.PriRgRtRoutViaVO;
import com.clt.syscommon.common.table.PriRgRtVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.scguideline 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCGuidelineSC로 실행요청<br>
 * - SCGuidelineSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Moon Dong Gyu
 * @see SCGuidelineEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_2001_04HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * UI_PRI_0030HTMLAction 객체를 생성
	 */
	public ESM_PRI_2001_04HTMLAction() {
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
		EsmPri200104Event event = new EsmPri200104Event();

		if (command.isCommand(FormCommand.SEARCH01)) {
			event.setPriRgRtCmdtHdrVO((PriRgRtCmdtHdrVO) getVO(request, PriRgRtCmdtHdrVO.class));
		} else if (command.isCommand(FormCommand.SEARCH02)) {
			event.setPriRgRtCmdtRoutVO((PriRgRtCmdtRoutVO) getVO(request, PriRgRtCmdtRoutVO.class));
		} else if (command.isCommand(FormCommand.SEARCH03)) {
			event.setPriRgRtVO((PriRgRtVO) getVO(request, PriRgRtVO.class));
		} else if (command.isCommand(FormCommand.SEARCH10)) {
			event.setPriRgRtCmdtHdrVO((PriRgRtCmdtHdrVO) getVO(request, PriRgRtCmdtHdrVO.class));
        } else if (command.isCommand(FormCommand.SEARCH11)) {
            event.setPriRgRtCmdtHdrVO((PriRgRtCmdtHdrVO) getVO(request, PriRgRtCmdtHdrVO.class));
		} else if (command.isCommand(FormCommand.MULTI01)) {
			RfaRtGlineCmdtVO vo = new RfaRtGlineCmdtVO();
			vo.setPriRgRtCmdtHdrVOS((PriRgRtCmdtHdrVO[]) getVOs(request, PriRgRtCmdtHdrVO.class, "sheet1_"));
			vo.setPriRgRtCmdtVOS((PriRgRtCmdtVO[]) getVOs(request, PriRgRtCmdtVO.class, "sheet4_"));
			event.setRfaRtGlineCmdtVO(vo);
		} else if (command.isCommand(FormCommand.MULTI02)) {
			RfaRtGlineRoutVO vo = new RfaRtGlineRoutVO();
			vo.setPriRgRtCmdtRoutVOS((PriRgRtCmdtRoutVO[]) getVOs(request, PriRgRtCmdtRoutVO.class, "sheet2_"));
			vo.setPriRgRtRoutOrgPntVOS((PriRgRtRoutPntVO[]) getVOs(request, PriRgRtRoutPntVO.class, "sheet5_"));
			vo.setPriRgRtRoutOrgViaVOS((PriRgRtRoutViaVO[]) getVOs(request, PriRgRtRoutViaVO.class, "sheet6_"));
			vo.setPriRgRtRoutDestViaVOS((PriRgRtRoutViaVO[]) getVOs(request, PriRgRtRoutViaVO.class, "sheet7_"));
			vo.setPriRgRtRoutDestPntVOS((PriRgRtRoutPntVO[]) getVOs(request, PriRgRtRoutPntVO.class, "sheet8_"));
			vo.setPriRgRtVOS((PriRgRtVO[]) getVOs(request, PriRgRtVO.class, "sheet3_"));
			event.setRfaRtGlineRoutVO(vo);
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