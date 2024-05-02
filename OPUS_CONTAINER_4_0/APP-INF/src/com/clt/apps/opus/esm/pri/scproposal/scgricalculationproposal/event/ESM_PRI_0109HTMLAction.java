/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0109HTMLAction.java
*@FileTitle : GRI Calculation - Arbitrary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 서호열
*@LastVersion : 1.0
* 2009.07.10 서호열
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgCombo1VO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLAllListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLArbitraryListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLSubListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.PriSpScpArbGriGrpVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.scproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCProposalSC로 실행요청<br>
 * - SCProposalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author HoYeolSea
 * @see SCProposalEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_0109HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_0109HTMLAction 객체를 생성
	 */
	public ESM_PRI_0109HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCProposalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri0109Event event = new EsmPri0109Event();
		
		if(command.isCommand(FormCommand.SEARCH)) { // 상단 그리드 조회
			event.setPriSpScpTrspAddChgGriArbOKCLListVO((PriSpScpTrspAddChgGriArbOKCLListVO)getVO(request, PriSpScpTrspAddChgGriArbOKCLListVO.class));
		}else if(command.isCommand(FormCommand.SEARCH01)) { // 하단 그리드 조회
			event.setPriSpScpTrspAddChgGriArbOKCLSubListVO((PriSpScpTrspAddChgGriArbOKCLSubListVO)getVO(request, PriSpScpTrspAddChgGriArbOKCLSubListVO.class));
		}else if(command.isCommand(FormCommand.SEARCH02)) { // 히든 콤보 : 콤보 필터를 위한 데이터 조회
			event.setPriSpScpTrspAddChgCombo1VO((PriSpScpTrspAddChgCombo1VO)getVO(request, PriSpScpTrspAddChgCombo1VO.class));
		}else if(command.isCommand(FormCommand.SEARCH03)) { // 적용가능 모든 GRI Calculation 조회
			event.setPriSpScpTrspAddChgGriArbOKCLAllListVO((PriSpScpTrspAddChgGriArbOKCLAllListVO)getVO(request, PriSpScpTrspAddChgGriArbOKCLAllListVO.class));
		}else if(command.isCommand(FormCommand.SEARCH04)) { // 적용가능 모든 Abitrary 조회
			event.setPriSpScpTrspAddChgGriArbOKCLArbitraryListVO((PriSpScpTrspAddChgGriArbOKCLArbitraryListVO)getVO(request, PriSpScpTrspAddChgGriArbOKCLArbitraryListVO.class));
		}else if(command.isCommand(FormCommand.MULTI)) { // 상단 하단 그리드 저장
			event.setPriSpScpArbGriGrpVOS((PriSpScpArbGriGrpVO[])getVOs(request, PriSpScpArbGriGrpVO.class, "sheet1_"));
			event.setPriSpScpTrspAddChgGriArbOKCLSubListVOS((PriSpScpTrspAddChgGriArbOKCLSubListVO[])getVOs(request, PriSpScpTrspAddChgGriArbOKCLSubListVO.class, "sheet2_"));
		}else if(command.isCommand(FormCommand.MULTI02) || command.isCommand(FormCommand.MULTI03)) { // 적용, // 적용 취소
			event.setPriSpScpTrspAddChgGriArbOKCLListVOS((PriSpScpTrspAddChgGriArbOKCLListVO[])getVOs(request, PriSpScpTrspAddChgGriArbOKCLListVO.class, ""));		
		}
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