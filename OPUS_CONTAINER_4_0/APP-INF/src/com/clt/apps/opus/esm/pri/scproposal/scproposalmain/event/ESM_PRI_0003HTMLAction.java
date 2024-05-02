/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0003HTMLAction.java
*@FileTitle : Proposal & Amendment Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.08 변영주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.ScPropProgVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SchCustVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SchSaleLeadVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.ComBakEndJbVO;
import com.clt.syscommon.common.table.PriSpAmdtSmryVO;
import com.clt.syscommon.common.table.PriSpCtrtCustTpVO;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;
import com.clt.syscommon.common.table.PriSpDurVO;
import com.clt.syscommon.common.table.PriSpHdrVO;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpMqcVO;
import com.clt.syscommon.common.table.PriSpProgVO;
import com.clt.syscommon.common.table.PriSpScpAmdtSmryVO;
import com.clt.syscommon.common.table.PriSpScpDurVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpMqcVO;
import com.clt.syscommon.common.table.PriSpScpProgVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.scproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCProposalSC로 실행요청<br>
 * - SCProposalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Byeon Young Joo
 * @see SCProposalEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_0003HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_0003HTMLAction 객체를 생성
	 */
	public ESM_PRI_0003HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCProposalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri0003Event event = new EsmPri0003Event();
		

		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setPriSpHdrVO((PriSpHdrVO)getVO(request, PriSpHdrVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setSchCustVO((SchCustVO)getVO(request, SchCustVO .class));
		}	
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setPriSpAmdtSmryVO((PriSpAmdtSmryVO)getVO(request, PriSpAmdtSmryVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setPriSpScpAmdtSmryVO((PriSpScpAmdtSmryVO)getVO(request, PriSpScpAmdtSmryVO .class));
		}			
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setPriSpMnVO((PriSpMnVO)getVO(request, PriSpMnVO .class));
		}			
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setPriSpMnVO((PriSpMnVO)getVO(request, PriSpMnVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setPriSpMnVO((PriSpMnVO)getVO(request, PriSpMnVO .class));
			event.setPriSpScpMnVO((PriSpScpMnVO)getVO(request, PriSpScpMnVO .class));
		}	
		else if(command.isCommand(FormCommand.SEARCH08)) {
			event.setPriSpScpMnVO((PriSpScpMnVO)getVO(request, PriSpScpMnVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setPriSpScpMnVO((PriSpScpMnVO)getVO(request, PriSpScpMnVO .class));
		}	
		else if(command.isCommand(FormCommand.SEARCH10)) {
			event.setPriSpMnVO((PriSpMnVO)getVO(request, PriSpMnVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH11)) {
			event.setSchSaleLeadVO((SchSaleLeadVO)getVO(request, SchSaleLeadVO .class));
		}	
		else if(command.isCommand(FormCommand.SEARCH12)) {
			event.setSchSaleLeadVO((SchSaleLeadVO)getVO(request, SchSaleLeadVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH13)) {
			event.setPriSpMnVO((PriSpMnVO)getVO(request, PriSpMnVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH14)) {
			event.setPriSpMnVO((PriSpMnVO)getVO(request, PriSpMnVO .class));
		}			
		else if(command.isCommand(FormCommand.SEARCH15)) {
			event.setComBakEndJbVO((ComBakEndJbVO)getVO(request, ComBakEndJbVO.class));
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
		}	
		else if(command.isCommand(FormCommand.SEARCH16)) {
			event.setComBakEndJbVO((ComBakEndJbVO)getVO(request, ComBakEndJbVO .class));
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
		}		
		else if(command.isCommand(FormCommand.SEARCH17)) {
			event.setPriSpMnVO((PriSpMnVO)getVO(request, PriSpMnVO .class));
		}				
		else if(command.isCommand(FormCommand.SEARCH18)) {
			event.setPriSpMnVO((PriSpMnVO)getVO(request, PriSpMnVO .class));
		}			
		else if(command.isCommand(FormCommand.SEARCH19)) {
			event.setPriSpMnVO((PriSpMnVO)getVO(request, PriSpMnVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH20)) {
			event.setPriSpMnVO((PriSpMnVO)getVO(request, PriSpMnVO .class));
		}			
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setPriSpMnVO((PriSpMnVO)getVO(request, PriSpMnVO .class));
		}			
//		else if(command.isCommand(FormCommand.SEARCH10)) {
//			event.setPriSpScpMnVO((PriSpScpMnVO)getVO(request, PriSpScpMnVO .class));
//		}		//주석처리 - 사용안함(추후삭제)
		else if(command.isCommand(FormCommand.MULTI01)) {
			ScPropMnVO vo = new ScPropMnVO();
			
			vo.setPriSpHdrVOs((PriSpHdrVO[])getVOs(request, PriSpHdrVO.class, "sheet1_"));		
			vo.setPriSpMnVOs((PriSpMnVO[])getVOs(request, PriSpMnVO.class, "sheet1_"));
			vo.setPriSpDurVOs((PriSpDurVO[])getVOs(request, PriSpDurVO.class, "sheet1_"));
			vo.setPriSpMqcVOs((PriSpMqcVO[])getVOs(request, PriSpMqcVO.class, "sheet1_"));
			vo.setPriSpProgVOs((PriSpProgVO[])getVOs(request, PriSpProgVO.class, "sheet1_"));
			vo.setPriSpCtrtPtyVOs((PriSpCtrtPtyVO[])getVOs(request, PriSpCtrtPtyVO.class, "sheet1_"));
			vo.setPriSpCtrtCustTpVOs((PriSpCtrtCustTpVO[])getVOs(request, PriSpCtrtCustTpVO.class, "sheet1_"));
			vo.setPriSpAmdtSmryVOs((PriSpAmdtSmryVO[])getVOs(request, PriSpAmdtSmryVO.class, "sheet1_"));
			
			vo.setPriSpScpMnVOs((PriSpScpMnVO[])getVOs(request, PriSpScpMnVO.class, "sheet2_"));
			vo.setPriSpScpDurVOs((PriSpScpDurVO[])getVOs(request, PriSpScpDurVO.class, "sheet2_"));
			vo.setPriSpScpMqcVOs((PriSpScpMqcVO[])getVOs(request, PriSpScpMqcVO.class, "sheet2_"));
			vo.setPriSpScpProgVOs((PriSpScpProgVO[])getVOs(request, PriSpScpProgVO.class, "sheet2_"));
			vo.setPriSpScpAmdtSmryVOs((PriSpScpAmdtSmryVO[])getVOs(request, PriSpScpAmdtSmryVO.class, "sheet2_"));
			
			String saleLeadOri = request.getParameter("sale_lead_ori");
			
			event.setScPropMnVO(vo);	
			event.setSaleLeadOri(saleLeadOri);
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			ScPropProgVO vo = new ScPropProgVO();
			ScPropMnVO mnVo = new ScPropMnVO();
			
			vo.setPriSpMnVOs((PriSpMnVO[])getVOs(request, PriSpMnVO.class, "sheet1_"));
			vo.setPriSpProgVOs((PriSpProgVO[])getVOs(request, PriSpProgVO.class, "sheet1_"));
			
			mnVo.setPriSpMnVOs((PriSpMnVO[])getVOs(request, PriSpMnVO.class, "sheet1_"));
			mnVo.setPriSpDurVOs((PriSpDurVO[])getVOs(request, PriSpDurVO.class, "sheet1_"));
			mnVo.setPriSpMqcVOs((PriSpMqcVO[])getVOs(request, PriSpMqcVO.class, "sheet1_"));
			mnVo.setPriSpCtrtCustTpVOs((PriSpCtrtCustTpVO[])getVOs(request, PriSpCtrtCustTpVO.class, "sheet1_"));
			
			mnVo.setPriSpScpMnVOs((PriSpScpMnVO[])getVOs(request, PriSpScpMnVO.class, "sheet2_"));
			mnVo.setPriSpScpDurVOs((PriSpScpDurVO[])getVOs(request, PriSpScpDurVO.class, "sheet2_"));
			mnVo.setPriSpScpMqcVOs((PriSpScpMqcVO[])getVOs(request, PriSpScpMqcVO.class, "sheet2_"));
			
			event.setScPropProgVO(vo);	
			event.setScPropMnVO(mnVo);
		}
		else if(command.isCommand(FormCommand.MULTI03)) {
			ScPropProgVO vo = new ScPropProgVO();
			vo.setPriSpMnVOs((PriSpMnVO[])getVOs(request, PriSpMnVO.class));
			vo.setPriSpProgVOs((PriSpProgVO[])getVOs(request, PriSpProgVO.class));		
			event.setScPropProgVO(vo);			
		}		
		else if(command.isCommand(FormCommand.MULTI04)) {
			ScPropProgVO vo = new ScPropProgVO();
			ScPropMnVO mnVo = new ScPropMnVO();
			
			vo.setPriSpMnVOs((PriSpMnVO[])getVOs(request, PriSpMnVO.class, "sheet1_"));
			vo.setPriSpProgVOs((PriSpProgVO[])getVOs(request, PriSpProgVO.class, "sheet1_"));
			
			mnVo.setPriSpMnVOs((PriSpMnVO[])getVOs(request, PriSpMnVO.class, "sheet1_"));
			mnVo.setPriSpDurVOs((PriSpDurVO[])getVOs(request, PriSpDurVO.class, "sheet1_"));
			mnVo.setPriSpMqcVOs((PriSpMqcVO[])getVOs(request, PriSpMqcVO.class, "sheet1_"));
			mnVo.setPriSpCtrtCustTpVOs((PriSpCtrtCustTpVO[])getVOs(request, PriSpCtrtCustTpVO.class, "sheet1_"));
			
			mnVo.setPriSpScpMnVOs((PriSpScpMnVO[])getVOs(request, PriSpScpMnVO.class, "sheet2_"));
			mnVo.setPriSpScpDurVOs((PriSpScpDurVO[])getVOs(request, PriSpScpDurVO.class, "sheet2_"));
			mnVo.setPriSpScpMqcVOs((PriSpScpMqcVO[])getVOs(request, PriSpScpMqcVO.class, "sheet2_"));
			
			event.setPriSpHdrVO((PriSpHdrVO)getVO(request, PriSpHdrVO .class));
			event.setScPropProgVO(vo);	
			event.setScPropMnVO(mnVo);
			
		}
		else if(command.isCommand(FormCommand.MULTI05)) {
			event.setPriSpAmdtSmryVO((PriSpAmdtSmryVO)getVO(request, PriSpAmdtSmryVO .class));		
		}
		else if(command.isCommand(FormCommand.MULTI06)) {
			event.setPriSpScpAmdtSmryVO((PriSpScpAmdtSmryVO)getVO(request, PriSpScpAmdtSmryVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI07)) {
			event.setPriSpMnVO((PriSpMnVO)getVO(request, PriSpMnVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI08)) {

//			ScPropProgVO vo = new ScPropProgVO();
//			vo.setPriSpMnVOs((PriSpMnVO[])getVOs(request, PriSpMnVO.class, "sheet1_"));
//			vo.setPriSpProgVOs((PriSpProgVO[])getVOs(request, PriSpProgVO.class, "sheet1_"));
//			event.setScPropProgVO(vo);
			//-------------------------------------------------------------------
			event.setPriSpProgVOS((PriSpProgVO[])getVOs(request, PriSpProgVO.class, "sheet1_"));
			event.setPriSpScpProgVOS((PriSpScpProgVO[])getVOs(request, PriSpScpProgVO.class, "sheet2_"));
			

			//-------------------------------------------------------------------

		}
        else {
            event.setPriSpMnVO((PriSpMnVO)getVO(request, PriSpMnVO.class));
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