/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_2233HTMLAction.java
 *@FileTitle : Master RFA Proposal Creation - General Update [GRI Calculation]
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.26
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.vo.RfaGriCalcVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriRpScpGriActCustVO;
import com.hanjin.syscommon.common.table.PriRpScpGriCmdtVO;
import com.hanjin.syscommon.common.table.PriRpScpGriGrpVO;
import com.hanjin.syscommon.common.table.PriRpScpGriRoutPntVO;
import com.hanjin.syscommon.common.table.PriRpScpGriRoutViaVO;
import com.hanjin.syscommon.common.table.PriRpScpGriRtVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scguideline 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCGuidelineSC로 실행요청<br>
 * - SCGuidelineSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Sungsoo, Park
 * @see SCGuidelineEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_2233HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_PRI_2233HTMLAction 객체를 생성
	 */
	public ESM_PRI_2233HTMLAction() {
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
		EsmPri2233Event event = new EsmPri2233Event();

		event.setFicRtTpCd(JSPUtil.getParameter(request, "fic_rt_tp_cd", ""));
		if (command.isCommand(FormCommand.SEARCH01)) {
			event.setPriRpScpGriGrpVO((PriRpScpGriGrpVO) getVO(request, PriRpScpGriGrpVO.class));
		} else if (command.isCommand(FormCommand.SEARCH02)) {
			event.setPriRpScpGriGrpVO((PriRpScpGriGrpVO) getVO(request, PriRpScpGriGrpVO.class));
		} else if (command.isCommand(FormCommand.MULTI01)) {
			RfaGriCalcVO vo = new RfaGriCalcVO();

			vo.setPriRpScpGriGrpVOS((PriRpScpGriGrpVO[]) getVOs(request, PriRpScpGriGrpVO.class, "sheet1_"));
			vo.setPriRpScpGriRtVOS((PriRpScpGriRtVO[]) getVOs(request, PriRpScpGriRtVO.class, "sheet2_"));
			vo.setPriRpScpGriCmdtVOS((PriRpScpGriCmdtVO[]) getVOs(request, PriRpScpGriCmdtVO.class, "sheet3_"));
			vo.setPriRpScpGriActCustVOS((PriRpScpGriActCustVO[]) getVOs(request, PriRpScpGriActCustVO.class, "sheet4_"));
			vo.setPriRpScpGriRoutOrgPntVOS((PriRpScpGriRoutPntVO[]) getVOs(request, PriRpScpGriRoutPntVO.class, "sheet5_"));
			vo.setPriRpScpGriRoutOrgViaVOS((PriRpScpGriRoutViaVO[]) getVOs(request, PriRpScpGriRoutViaVO.class, "sheet6_"));
			vo.setPriRpScpGriRoutDestViaVOS((PriRpScpGriRoutViaVO[]) getVOs(request, PriRpScpGriRoutViaVO.class, "sheet7_"));
			vo.setPriRpScpGriRoutDestPntVOS((PriRpScpGriRoutPntVO[]) getVOs(request, PriRpScpGriRoutPntVO.class, "sheet8_"));

			event.setRfaGriCalcVO(vo);
		} else if (command.isCommand(FormCommand.MODIFY01)) {
			event.setPriRpScpGriGrpVO((PriRpScpGriGrpVO) getVO(request, PriRpScpGriGrpVO.class));
			RfaGriCalcVO vo = new RfaGriCalcVO();
			vo.setPriRpScpGriGrpVOS((PriRpScpGriGrpVO[]) getVOs(request, PriRpScpGriGrpVO.class, "sheet1_"));
			event.setRfaGriCalcVO(vo);
		} else if (command.isCommand(FormCommand.MODIFY02)) {
			event.setPriRpScpGriGrpVO((PriRpScpGriGrpVO) getVO(request, PriRpScpGriGrpVO.class));
			RfaGriCalcVO vo = new RfaGriCalcVO();
			vo.setPriRpScpGriGrpVOS((PriRpScpGriGrpVO[]) getVOs(request, PriRpScpGriGrpVO.class, "sheet1_"));
			event.setRfaGriCalcVO(vo);
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