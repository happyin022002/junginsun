/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0003_03HTMLAction.java
*@FileTitle : S/C Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.25 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.vo.GrpCmdtPropVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.PriSpScpGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriSpScpGrpCmdtVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.scproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCProposalSC로 실행요청<br>
 * - SCProposalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CHOI SUNG MIN
 * @see SCProposalEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_0003_03HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_0003_03HTMLAction 객체를 생성
	 */
	public ESM_PRI_0003_03HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCProposalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri000303Event event = new EsmPri000303Event();

		event.setPropNo(request.getParameter("prop_no"));
		event.setAmdtSeq(request.getParameter("amdt_seq"));
		event.setSvcScpCd(request.getParameter("svc_scp_cd"));		
		
		if(command.isCommand(FormCommand.MULTI01)) { //save			
			GrpCmdtPropVO vo = new GrpCmdtPropVO();
			vo.setPriSpScpGrpCmdtVOs((PriSpScpGrpCmdtVO[])getVOs(request, PriSpScpGrpCmdtVO .class,"sheet1_"));
			vo.setPriSpScpGrpCmdtDtlVOs((PriSpScpGrpCmdtDtlVO[])getVOs(request, PriSpScpGrpCmdtDtlVO .class,"sheet2_"));
			event.setGrpCmdtPropVO(vo);
		}
		else if(command.isCommand(FormCommand.MULTI02)) { //accept all
			event.setPriSpScpGrpCmdtDtlVO((PriSpScpGrpCmdtDtlVO)getVO(request, PriSpScpGrpCmdtDtlVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI03)) { //accept all cancel
			event.setPriSpScpGrpCmdtDtlVO((PriSpScpGrpCmdtDtlVO)getVO(request, PriSpScpGrpCmdtDtlVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI04)) { //accept
			event.setPriSpScpGrpCmdtDtlVOS((PriSpScpGrpCmdtDtlVO[])getVOs(request, PriSpScpGrpCmdtDtlVO .class,""));
		}
		else if(command.isCommand(FormCommand.MULTI05)) { //accept cancel
			event.setPriSpScpGrpCmdtDtlVOS((PriSpScpGrpCmdtDtlVO[])getVOs(request, PriSpScpGrpCmdtDtlVO .class,""));
		}
		else if(command.isCommand(FormCommand.MULTI06)) { //G/L copy
			PriSpScpGrpCmdtDtlVO vo = (PriSpScpGrpCmdtDtlVO)getVO(request, PriSpScpGrpCmdtDtlVO .class);
			vo.setN1stCmncDt(request.getParameter("eff_dt"));
			vo.setPrcProgStsCd(request.getParameter("prc_cust_tp_cd"));
			event.setPriSpScpGrpCmdtDtlVO(vo);			
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setPriSpScpGrpCmdtVO((PriSpScpGrpCmdtVO)getVO(request, PriSpScpGrpCmdtVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setPriSpScpGrpCmdtDtlVO((PriSpScpGrpCmdtDtlVO)getVO(request, PriSpScpGrpCmdtDtlVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setPriSpScpGrpCmdtVOS((PriSpScpGrpCmdtVO[])getVOs(request, PriSpScpGrpCmdtVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setPriSpScpGrpCmdtVOS((PriSpScpGrpCmdtVO[])getVOs(request, PriSpScpGrpCmdtVO .class));
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