/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : STM_SAR_3001HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustDtlListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustHdrListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * @author 
 * @see StmSar3001Event
 * @since J2EE 1.4
 */

public class STM_SAR_3001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * STM_SAR_3001HTMLAction
	 */
	public STM_SAR_3001HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	StmSar3001Event event = new StmSar3001Event();
		
    	
		if(command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH01) 
				|| command.isCommand(FormCommand.SEARCH03)) {								
			event.setAdjustCondVO((AdjustCondVO)getVO(request, AdjustCondVO.class, ""));
		}else if(command.isCommand(FormCommand.MULTI) || command.isCommand(FormCommand.MULTI01)){
			event.setAdjustCondVO((AdjustCondVO)getVO(request, AdjustCondVO.class, ""));
			event.setAdjustHdrListVOs((AdjustHdrListVO[])getVOs(request, AdjustHdrListVO.class, "sheet1_"));
			event.setAdjustDtlListVOs((AdjustDtlListVO[])getVOs(request, AdjustDtlListVO.class, "sheet2_"));
		}else if(command.isCommand(FormCommand.SEARCH02)){
			event.setAdjustCondVO((AdjustCondVO)getVO(request, AdjustCondVO.class, ""));
			event.setAdjustDtlListVOs((AdjustDtlListVO[])getVOs(request, AdjustDtlListVO.class, "sheet2_"));
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