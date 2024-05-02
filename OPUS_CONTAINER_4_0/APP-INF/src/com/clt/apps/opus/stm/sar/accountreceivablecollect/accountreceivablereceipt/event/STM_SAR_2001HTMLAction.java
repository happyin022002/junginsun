/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : STM_SAR_2001HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyDetailVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyHeaderVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyListCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptMainVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableCollectSC로 실행요청<br>
 * - AccountReceivableCollectSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSar2001Event 참조
 * @since J2EE 1.4
 */

public class STM_SAR_2001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * STM_SAR_2001HTMLAction 객체를 생성
	 */
	public STM_SAR_2001HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	StmSar2001Event event = new StmSar2001Event();
		
    	if(command.isCommand(FormCommand.SEARCH)) {		
			event.setRctOfcCd(request.getParameter("ots_ofc_cd"));
			event.setRctNo(request.getParameter("rct_no"));
			
		} else if(command.isCommand(FormCommand.SEARCH01)) {		
			event.setApplyListCondVO((ApplyListCondVO)getVO(request, ApplyListCondVO .class));
		} else if(command.isCommand(FormCommand.SEARCH02)) {		
			event.setApplyListCondVO((ApplyListCondVO)getVO(request, ApplyListCondVO .class));
		} else if(command.isCommand(FormCommand.SEARCH03)) {		
			event.setAgnOfcCd(request.getParameter("agn_ofc_cd"));
			event.setRctNo(request.getParameter("rct_no"));
		} else if(command.isCommand(FormCommand.SEARCH04)) {		
			event.setApplyListCondVO((ApplyListCondVO)getVO(request, ApplyListCondVO .class));
		} else if(command.isCommand(FormCommand.SEARCH05)) {		
			event.setBackendjobKey(request.getParameter("backendjob_key"));
		} else if(command.isCommand(FormCommand.SEARCH06)) {		
			event.setBackendjobKey(request.getParameter("backendjob_key"));	
		} else if(command.isCommand(FormCommand.MULTI)) {		
			event.setReceiptMainVO((ReceiptMainVO)getVO(request, ReceiptMainVO .class));
			event.setApplyHeaderVOs((ApplyHeaderVO[])getVOs(request, ApplyHeaderVO .class, "sheet1_"));
			event.setApplyDetailVOs((ApplyDetailVO[])getVOs(request, ApplyDetailVO .class, "sheet2_"));
			
		}

		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param EventResponse eventResponse
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param Event event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}