/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6001HTMLAction.java
*@FileTitle : CMPB Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.30 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.CmpbGuidelineVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltDurationCreationOfficeVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriCmpbGlineAmtVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineBseVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineCmdtVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineCustVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineMnVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineRoutPntVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineRoutViaVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineSvcLaneVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.profitabilitysimulation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ProfitabilitySimulationSC로 실행요청<br>
 * - ProfitabilitySimulationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Seung-Jun,Lee
 * @see ProfitabilitySimulationEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_6001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_6001HTMLAction 객체를 생성
	 */
	public ESM_PRI_6001HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ProfitabilitySimulationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri6001Event event = new EsmPri6001Event();
		
		CmpbGuidelineVO cmpbGuidelineVO = new CmpbGuidelineVO();
		
		event.setCmpbGuidelineVO(cmpbGuidelineVO) ;
		
		if (command.isCommand(FormCommand.SEARCH01)) {
			event.getCmpbGuidelineVO().setRsltDurationCreationOfficeVO((RsltDurationCreationOfficeVO) getVO(request, RsltDurationCreationOfficeVO.class));
		} else if (command.isCommand(FormCommand.SEARCH02)) {
			event.getCmpbGuidelineVO().setPriCmpbGlineBseVO((PriCmpbGlineBseVO) getVO(request, PriCmpbGlineBseVO.class));
		} else if (command.isCommand(FormCommand.SEARCH03)) {
			event.getCmpbGuidelineVO().setPriCmpbGlineBseVO((PriCmpbGlineBseVO) getVO(request, PriCmpbGlineBseVO.class));
		} else if (command.isCommand(FormCommand.SEARCH04)) {
			event.getCmpbGuidelineVO().setPriCmpbGlineBseVO((PriCmpbGlineBseVO) getVO(request, PriCmpbGlineBseVO.class));
		} else if (command.isCommand(FormCommand.SEARCH05)) {
			event.getCmpbGuidelineVO().setRsltDurationCreationOfficeVO((RsltDurationCreationOfficeVO) getVO(request, RsltDurationCreationOfficeVO.class));
		} else if (command.isCommand(FormCommand.MULTI01)) {
			event.getCmpbGuidelineVO().setPriCmpbGlineMnVO((PriCmpbGlineMnVO) getVO(request, PriCmpbGlineMnVO.class));
			event.getCmpbGuidelineVO().setPriCmpbGlineCustVO((PriCmpbGlineCustVO) getVO(request, PriCmpbGlineCustVO.class));
			event.getCmpbGuidelineVO().setPriCmpbGlineBseVO((PriCmpbGlineBseVO) getVO(request, PriCmpbGlineBseVO.class));
			event.getCmpbGuidelineVO().setRsltDurationCreationOfficeVO((RsltDurationCreationOfficeVO) getVO(request, RsltDurationCreationOfficeVO.class));
			event.getCmpbGuidelineVO().setPriCmpbGlineBseVOs((PriCmpbGlineBseVO[]) getVOs(request, PriCmpbGlineBseVO.class, "sheet1_"));
			event.getCmpbGuidelineVO().setPriCmpbGlineAmtVOs((PriCmpbGlineAmtVO[]) getVOs(request, PriCmpbGlineAmtVO.class, "sheet2_"));
			event.getCmpbGuidelineVO().setPriCmpbGlineSvcLaneVOs((PriCmpbGlineSvcLaneVO[]) getVOs(request, PriCmpbGlineSvcLaneVO.class, "sheet3_"));
			event.getCmpbGuidelineVO().setPriCmpbGlineCmdtVOs((PriCmpbGlineCmdtVO[]) getVOs(request, PriCmpbGlineCmdtVO.class, "sheet4_"));
			event.getCmpbGuidelineVO().setPriCmpbGlineOrgRoutPntVOs((PriCmpbGlineRoutPntVO[]) getVOs(request, PriCmpbGlineRoutPntVO.class, "sheet5_"));
			event.getCmpbGuidelineVO().setPriCmpbGlineOrgRoutViaVOs((PriCmpbGlineRoutViaVO[]) getVOs(request, PriCmpbGlineRoutViaVO.class, "sheet6_"));
			event.getCmpbGuidelineVO().setPriCmpbGlineDestRoutViaVOs((PriCmpbGlineRoutViaVO[]) getVOs(request, PriCmpbGlineRoutViaVO.class, "sheet7_"));
			event.getCmpbGuidelineVO().setPriCmpbGlineDestRoutPntVOs((PriCmpbGlineRoutPntVO[]) getVOs(request, PriCmpbGlineRoutPntVO.class, "sheet8_"));
		} else if (command.isCommand(FormCommand.MULTI02)) {
			event.getCmpbGuidelineVO().setPriCmpbGlineAmtVOs((PriCmpbGlineAmtVO[]) getVOs(request, PriCmpbGlineAmtVO.class));
		} else if (command.isCommand(FormCommand.MULTI03)) {
			event.getCmpbGuidelineVO().setPriCmpbGlineMnVO((PriCmpbGlineMnVO) getVO(request, PriCmpbGlineMnVO.class));
			event.getCmpbGuidelineVO().setPriCmpbGlineBseVO((PriCmpbGlineBseVO) getVO(request, PriCmpbGlineBseVO.class));
		} else if (command.isCommand(FormCommand.MULTI04)) {
			event.getCmpbGuidelineVO().setPriCmpbGlineMnVO((PriCmpbGlineMnVO) getVO(request, PriCmpbGlineMnVO.class));
		} else if (command.isCommand(FormCommand.MULTI05)) {
			event.getCmpbGuidelineVO().setPriCmpbGlineMnVO((PriCmpbGlineMnVO) getVO(request, PriCmpbGlineMnVO.class));
		} 
		//헤더저장
		else if (command.isCommand(FormCommand.MULTI06)) {
			event.getCmpbGuidelineVO().setPriCmpbGlineMnVO((PriCmpbGlineMnVO) getVO(request, PriCmpbGlineMnVO.class));
			event.getCmpbGuidelineVO().setPriCmpbGlineCustVO((PriCmpbGlineCustVO) getVO(request, PriCmpbGlineCustVO.class));
			event.getCmpbGuidelineVO().setRsltDurationCreationOfficeVO((RsltDurationCreationOfficeVO) getVO(request, RsltDurationCreationOfficeVO.class));
		}

		request.setAttribute("Event", event);

		return  event;
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