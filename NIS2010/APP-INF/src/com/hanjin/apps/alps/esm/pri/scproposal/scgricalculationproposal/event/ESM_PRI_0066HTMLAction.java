/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UI_PRI_0030HTMLAction.java
 *@FileTitle : Guideline MQC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.05.25 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.ScGriCalcVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriSpScpGriActCustVO;
import com.hanjin.syscommon.common.table.PriSpScpGriCmdtVO;
import com.hanjin.syscommon.common.table.PriSpScpGriGrpVO;
import com.hanjin.syscommon.common.table.PriSpScpGriRoutPntVO;
import com.hanjin.syscommon.common.table.PriSpScpGriRoutViaVO;
import com.hanjin.syscommon.common.table.PriSpScpGriRtVO;

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

public class ESM_PRI_0066HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * UI_PRI_0030HTMLAction 객체를 생성
	 */
	public ESM_PRI_0066HTMLAction() {
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
		EsmPri0066Event event = new EsmPri0066Event();

		if (command.isCommand(FormCommand.SEARCH01)) {
			event.setPriSpScpGriGrpVO((PriSpScpGriGrpVO) getVO(request, PriSpScpGriGrpVO.class));
		} else if (command.isCommand(FormCommand.SEARCH02)) {
			event.setPriSpScpGriGrpVO((PriSpScpGriGrpVO) getVO(request, PriSpScpGriGrpVO.class));
		} else if (command.isCommand(FormCommand.MULTI01)) {
			ScGriCalcVO vo = new ScGriCalcVO();

			vo.setPriSpScpGriGrpVOS((PriSpScpGriGrpVO[]) getVOs(request, PriSpScpGriGrpVO.class, "sheet1_"));
			vo.setPriSpScpGriRtVOS((PriSpScpGriRtVO[]) getVOs(request, PriSpScpGriRtVO.class, "sheet2_"));
			vo.setPriSpScpGriCmdtVOS((PriSpScpGriCmdtVO[]) getVOs(request, PriSpScpGriCmdtVO.class, "sheet3_"));
			vo.setPriSpScpGriActCustVOS((PriSpScpGriActCustVO[]) getVOs(request, PriSpScpGriActCustVO.class, "sheet4_"));
			vo.setPriSpScpGriRoutOrgPntVOS((PriSpScpGriRoutPntVO[]) getVOs(request, PriSpScpGriRoutPntVO.class, "sheet5_"));
			vo.setPriSpScpGriRoutOrgViaVOS((PriSpScpGriRoutViaVO[]) getVOs(request, PriSpScpGriRoutViaVO.class, "sheet6_"));
			vo.setPriSpScpGriRoutDestViaVOS((PriSpScpGriRoutViaVO[]) getVOs(request, PriSpScpGriRoutViaVO.class, "sheet7_"));
			vo.setPriSpScpGriRoutDestPntVOS((PriSpScpGriRoutPntVO[]) getVOs(request, PriSpScpGriRoutPntVO.class, "sheet8_"));
			
			event.setScGriCalcVO(vo);
		} else if (command.isCommand(FormCommand.MODIFY01)) {
			event.setPriSpScpGriGrpVO((PriSpScpGriGrpVO) getVO(request, PriSpScpGriGrpVO.class));
			ScGriCalcVO vo = new ScGriCalcVO();
			vo.setPriSpScpGriGrpVOS((PriSpScpGriGrpVO[]) getVOs(request, PriSpScpGriGrpVO.class, "sheet1_"));			
			event.setScGriCalcVO(vo);
		} else if (command.isCommand(FormCommand.MODIFY02)) {
			event.setPriSpScpGriGrpVO((PriSpScpGriGrpVO) getVO(request, PriSpScpGriGrpVO.class));
			ScGriCalcVO vo = new ScGriCalcVO();
			vo.setPriSpScpGriGrpVOS((PriSpScpGriGrpVO[]) getVOs(request, PriSpScpGriGrpVO.class, "sheet1_"));			
			event.setScGriCalcVO(vo);
        } else if (command.isCommand(FormCommand.MODIFY03)) {
            event.setPriSpScpGriGrpVO((PriSpScpGriGrpVO) getVO(request, PriSpScpGriGrpVO.class));
            ScGriCalcVO vo = new ScGriCalcVO();
            vo.setPriSpScpGriGrpVOS((PriSpScpGriGrpVO[]) getVOs(request, PriSpScpGriGrpVO.class, "sheet1_"));           
            event.setScGriCalcVO(vo);		
        } else if (command.isCommand(FormCommand.MULTI02)) {
            ScGriCalcVO vo = new ScGriCalcVO();
            vo.setPriSpScpGriGrpVOS((PriSpScpGriGrpVO[]) getVOs(request, PriSpScpGriGrpVO.class));
            event.setScGriCalcVO(vo);
        } else if (command.isCommand(FormCommand.MULTI03)) {
             event.setPriSpScpGriGrpVO((PriSpScpGriGrpVO) getVO(request, PriSpScpGriGrpVO.class));
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