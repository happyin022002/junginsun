/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0015HTMLAction.java
*@FileTitle : S/C Master Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.07.07 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ChkScNoVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScPropProgVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SchCustVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriSpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriSpCtrtCustTpVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;
import com.hanjin.syscommon.common.table.PriSpDurVO;
import com.hanjin.syscommon.common.table.PriSpHdrVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpMqcVO;
import com.hanjin.syscommon.common.table.PriSpProgVO;
import com.hanjin.syscommon.common.table.PriSpScpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriSpScpDurVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpMqcVO;
import com.hanjin.syscommon.common.table.PriSpScpProgVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCProposalSC로 실행요청<br>
 * - SCProposalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Moon Dong Gyu
 * @see SCProposalEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_0015HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_0015HTMLAction 객체를 생성
	 */
	public ESM_PRI_0015HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCProposalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri0015Event event = new EsmPri0015Event();
		
        if(command.isCommand(FormCommand.SEARCH01)) {
            event.setPriSpHdrVO((PriSpHdrVO)getVO(request, PriSpHdrVO .class));
        }
        else if(command.isCommand(FormCommand.SEARCH02)) {
            event.setSchCustVO((SchCustVO)getVO(request, SchCustVO .class));
        }
        else if(command.isCommand(FormCommand.SEARCH03)) {
            event.setChkScNoVO((ChkScNoVO)getVO(request, ChkScNoVO.class));
        }
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
            
            event.setScPropMnVO(vo);    
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
            event.setPriSpHdrVO((PriSpHdrVO)getVO(request, PriSpHdrVO.class));
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