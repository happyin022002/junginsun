/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_3010HTMLAction.java
 *@FileTitle : TRI GRI Calculation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.12.10
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.12.10 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.vo.TriGriCalcVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropGRIVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.PriTriGriCmdtVO;
import com.clt.syscommon.common.table.PriTriGriGrpVO;
import com.clt.syscommon.common.table.PriTriGriRoutPntVO;
import com.clt.syscommon.common.table.PriTriGriRoutViaVO;
import com.clt.syscommon.common.table.PriTriGriRtVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.scguideline 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCGuidelineSC로 실행요청<br>
 * - SCGuidelineSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Sungsoo, Park
 * @see SCGuidelineEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_3010HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * UI_PRI_0030HTMLAction 객체를 생성
	 */
	public ESM_PRI_3010HTMLAction() {
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
		EsmPri3010Event event = new EsmPri3010Event();

		if (command.isCommand(FormCommand.SEARCH01)) {
			event.setPriTriGriGrpVO((PriTriGriGrpVO) getVO(request, PriTriGriGrpVO.class));
		} else if (command.isCommand(FormCommand.SEARCH02)) {
			event.setPriTriGriGrpVO((PriTriGriGrpVO) getVO(request, PriTriGriGrpVO.class));
		} else if (command.isCommand(FormCommand.SEARCH10)) {
			event.setTriPropGRIVO((TriPropGRIVO) getVO(request, TriPropGRIVO.class));
		} else if (command.isCommand(FormCommand.MULTI01)) {
			TriGriCalcVO vo = new TriGriCalcVO();

			vo.setPriTriGriGrpVOS((PriTriGriGrpVO[]) getVOs(request, PriTriGriGrpVO.class, "sheet1_"));
			vo.setPriTriGriRtVOS((PriTriGriRtVO[]) getVOs(request, PriTriGriRtVO.class, "sheet2_"));
			vo.setPriTriGriCmdtVOS((PriTriGriCmdtVO[]) getVOs(request, PriTriGriCmdtVO.class, "sheet3_"));
			vo.setPriTriGriRoutOrgPntVOS((PriTriGriRoutPntVO[]) getVOs(request, PriTriGriRoutPntVO.class, "sheet4_"));
			vo.setPriTriGriRoutOrgViaVOS((PriTriGriRoutViaVO[]) getVOs(request, PriTriGriRoutViaVO.class, "sheet5_"));
			vo.setPriTriGriRoutDestViaVOS((PriTriGriRoutViaVO[]) getVOs(request, PriTriGriRoutViaVO.class, "sheet6_"));
			vo.setPriTriGriRoutDestPntVOS((PriTriGriRoutPntVO[]) getVOs(request, PriTriGriRoutPntVO.class, "sheet7_"));
			
			event.setTriGriCalcVO(vo);
		} else if (command.isCommand(FormCommand.MODIFY01)) {
			event.setTriPropGRIVO((TriPropGRIVO) getVO(request, TriPropGRIVO.class));
			TriGriCalcVO vo = new TriGriCalcVO();
			vo.setPriTriGriGrpVOS((PriTriGriGrpVO[]) getVOs(request, PriTriGriGrpVO.class, "sheet1_"));
			event.setTriGriCalcVO(vo);
		} else if (command.isCommand(FormCommand.MODIFY02)) {
			event.setTriPropGRIVO((TriPropGRIVO) getVO(request, TriPropGRIVO.class));
			TriGriCalcVO vo = new TriGriCalcVO();
			vo.setPriTriGriGrpVOS((PriTriGriGrpVO[]) getVOs(request, PriTriGriGrpVO.class, "sheet1_"));
			event.setTriGriCalcVO(vo);
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