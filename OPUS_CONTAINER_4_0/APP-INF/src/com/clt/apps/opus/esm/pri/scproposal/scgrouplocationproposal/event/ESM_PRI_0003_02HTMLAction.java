/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0003_02HTMLAction.java
*@FileTitle : S/C Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 蹂�쁺二�
*@LastVersion : 1.0
* 2009.05.06 蹂�쁺二�
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgrouplocationproposal.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.pri.scproposal.scgrouplocationproposal.vo.GrpLocPropVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.PriSpScpGrpLocDtlVO;
import com.clt.syscommon.common.table.PriSpScpGrpLocVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.scproposal �붾㈃���듯빐 �쒕쾭濡��꾩넚�섎뒗 HTML DOM 媛앹껜��Value瑜��먮컮 蹂�닔濡�Parsing<br>
 * - Parsing ���뺣낫瑜�Event濡�蹂�솚, request���댁븘 SCProposalSC濡��ㅽ뻾�붿껌<br>
 * - SCProposalSC�먯꽌 View(JSP)濡��ㅽ뻾寃곌낵瑜��꾩넚�섎뒗 EventResponse瑜�request���뗮똿<br>
 * @author Byeon Young Joo
 * @see SCProposalEvent 李몄“
 * @since J2EE 1.4
 */

public class ESM_PRI_0003_02HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_0003_02HTMLAction 媛앹껜瑜��앹꽦
	 */
	public ESM_PRI_0003_02HTMLAction() {}

	/**
	 * HTML DOM 媛앹껜��Value瑜��먮컮 蹂�닔濡�Parsing<br>
	 * HttpRequst���뺣낫瑜�SCProposalEvent濡��뚯떛�섏뿬 request���뗮똿<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface瑜�援ы쁽��媛앹껜
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri000302Event event = new EsmPri000302Event();
	
		event.setPropNo(request.getParameter("prop_no"));
		event.setAmdtSeq(request.getParameter("amdt_seq"));
		event.setSvcScpCd(request.getParameter("svc_scp_cd"));		
		
		if(command.isCommand(FormCommand.MULTI01)) {
			GrpLocPropVO vo = new GrpLocPropVO();
			vo.setPriSpScpGrpLocVOs((PriSpScpGrpLocVO[])getVOs(request, PriSpScpGrpLocVO.class, "sheet1_"));
			vo.setPriSpScpGrpLocDtlVOs((PriSpScpGrpLocDtlVO[])getVOs(request, PriSpScpGrpLocDtlVO.class, "sheet2_"));
			event.setGrpLocPropVO(vo);
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.setPriSpScpGrpLocDtlVO((PriSpScpGrpLocDtlVO)getVO(request, PriSpScpGrpLocDtlVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI03)) {
			event.setPriSpScpGrpLocDtlVO((PriSpScpGrpLocDtlVO)getVO(request, PriSpScpGrpLocDtlVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI04)) {
			event.setPriSpScpGrpLocDtlVOS((PriSpScpGrpLocDtlVO[])getVOs(request, PriSpScpGrpLocDtlVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI05)) {
			event.setPriSpScpGrpLocDtlVOS((PriSpScpGrpLocDtlVO[])getVOs(request, PriSpScpGrpLocDtlVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI06)) {
			PriSpScpGrpLocDtlVO vo = (PriSpScpGrpLocDtlVO)getVO(request, PriSpScpGrpLocDtlVO .class);
			vo.setN1stCmncDt(request.getParameter("eff_dt"));
			event.setPriSpScpGrpLocDtlVO(vo);
		}		
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setPriSpScpGrpLocVO((PriSpScpGrpLocVO)getVO(request, PriSpScpGrpLocVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setPriSpScpGrpLocDtlVO((PriSpScpGrpLocDtlVO)getVO(request, PriSpScpGrpLocDtlVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setPriSpScpGrpLocVOS((PriSpScpGrpLocVO[])getVOs(request, PriSpScpGrpLocVO .class));
		}	
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setPriSpScpGrpLocVOS((PriSpScpGrpLocVO[])getVOs(request, PriSpScpGrpLocVO .class));
		}	
		
		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * HttpRequest��attribute���낅Т�쒕굹由ъ삤 �섑뻾寃곌낵 媛���옣<br>
	 * ServiceCommand�먯꽌 View(JSP)濡��ㅽ뻾寃곌낵瑜��꾩넚�섎뒗 ResultSet��request���뗮똿<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface瑜�援ы쁽��媛앹껜
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest��attribute��HttpRequest �뚯떛 �섑뻾寃곌낵 媛���옣<br>
	 * HttpRequest �뚯떛 �섑뻾寃곌낵 媛�request���뗮똿<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface瑜�援ы쁽��媛앹껜
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}