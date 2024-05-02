/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_3001HTMLAction.java
 *@FileTitle : TRI Creation & Amendment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.13
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.11.13 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.vo.PriTriNoteConvListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropParamVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriTriMnVO;
import com.hanjin.syscommon.common.table.PriTriRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriTriRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriTriRtVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.triproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TRIProposalSC로 실행요청<br>
 * - TRIProposalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Sungsoo Park
 * @see TRIProposalEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_3001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_PRI_3001HTMLAction 객체를 생성
	 */
	public ESM_PRI_3001HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TRIProposalEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsmPri3001Event event = new EsmPri3001Event();

		if (command.isCommand(FormCommand.SEARCH01)) {
			event.setTriPropParamVO((TriPropParamVO) getVO(request, TriPropParamVO.class));
		} else if (command.isCommand(FormCommand.SEARCH02)) {
			event.setPriTriMnVO((PriTriMnVO) getVO(request, PriTriMnVO.class));
		} else if (command.isCommand(FormCommand.SEARCH03)) {
			event.setTriPropParamVO((TriPropParamVO) getVO(request, TriPropParamVO.class));
		} else if(command.isCommand(FormCommand.SEARCH04)) { //Calculate
			PriTriRtVO vo = (PriTriRtVO) getVO(request, PriTriRtVO.class);
			event.setPriTriRtVO(vo);
		} else if(command.isCommand(FormCommand.SEARCH05)) { //Calculate
			PriTriRtVO vo = (PriTriRtVO) getVO(request, PriTriRtVO.class);
			event.setPriTriRtVO(vo);
		} else if (command.isCommand(FormCommand.MULTI01)) {
			TriPropVO vo = new TriPropVO();

			vo.setPriTriMnVO((PriTriMnVO) getVO(request, PriTriMnVO.class));
			vo.setPriTriRtVOS((PriTriRtVO[]) getVOs(request, PriTriRtVO.class, "sheet2_"));
			vo.setPriTriRtRoutOrgPntVOS((PriTriRtRoutPntVO[]) getVOs(request, PriTriRtRoutPntVO.class, "sheet3_"));
			vo.setPriTriRtRoutOrgViaVOS((PriTriRtRoutViaVO[]) getVOs(request, PriTriRtRoutViaVO.class, "sheet4_"));
			vo.setPriTriRtRoutDestViaVOS((PriTriRtRoutViaVO[]) getVOs(request, PriTriRtRoutViaVO.class, "sheet5_"));
			vo.setPriTriRtRoutDestPntVOS((PriTriRtRoutPntVO[]) getVOs(request, PriTriRtRoutPntVO.class, "sheet6_"));

			event.setTriPropVO(vo);
			event.setPriTriNoteConvListVOs((PriTriNoteConvListVO[])getVOs(request, PriTriNoteConvListVO.class, "sheet7_"));
			
		} else if (command.isCommand(FormCommand.MODIFY01)) {
			event.setPriTriRtVO((PriTriRtVO) getVO(request, PriTriRtVO.class));
		} else if (command.isCommand(FormCommand.MODIFY02)) {
			event.setPriTriRtVO((PriTriRtVO) getVO(request, PriTriRtVO.class));
		} else if (command.isCommand(FormCommand.MODIFY03)) {
			event.setPriTriRtVO((PriTriRtVO) getVO(request, PriTriRtVO.class));
		} else if (command.isCommand(FormCommand.MODIFY04)) {
			event.setPriTriRtVO((PriTriRtVO) getVO(request, PriTriRtVO.class));
//		} else if (command.isCommand(FormCommand.MODIFY05)) {
//			event.setPriTriRtVO((PriTriRtVO) getVO(request, PriTriRtVO.class));
		} else if (command.isCommand(FormCommand.MODIFY06)) {
			event.setPriTriMnVO((PriTriMnVO) getVO(request, PriTriMnVO.class));
		} else if (command.isCommand(FormCommand.MODIFY07)) {
			event.setPriTriRtVO((PriTriRtVO) getVO(request, PriTriRtVO.class));
		} else if (command.isCommand(FormCommand.MODIFY11)) {
			event.setPriTriRtVOs((PriTriRtVO[]) getVOs(request, PriTriRtVO.class));
		} else if (command.isCommand(FormCommand.MODIFY12)) {
			event.setPriTriRtVOs((PriTriRtVO[]) getVOs(request, PriTriRtVO.class));
//		} else if (command.isCommand(FormCommand.MODIFY13)) {
//			event.setPriTriRtVOs((PriTriRtVO[]) getVOs(request, PriTriRtVO.class));
		} else if (command.isCommand(FormCommand.MODIFY15)) {
			event.setPriTriRtVOs((PriTriRtVO[]) getVOs(request, PriTriRtVO.class));
		} else if (command.isCommand(FormCommand.MODIFY16)) {
			event.setPriTriRtVOs((PriTriRtVO[]) getVOs(request, PriTriRtVO.class));
		}
		event.setAttribute("KEY", request.getParameter("backendjob_key"));
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