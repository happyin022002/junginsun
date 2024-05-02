/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : STM_SAR_1003HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingHdrByBlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingHisByDateVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableOutstandingSC로 실행요청<br>
 * - AccountReceivableOutstandingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSar1003Event 참조
 * @since J2EE 1.4
 */

public class STM_SAR_1003HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * STM_SAR_1003HTMLAction 객체를 생성
	 */
	public STM_SAR_1003HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	//FormCommand command = FormCommand.fromRequest(request);
    	StmSar1003Event event = new StmSar1003Event();

    	OutstandingHisByDateVO paramVO = (OutstandingHisByDateVO)getVO(request, OutstandingHisByDateVO.class);
    	String condDt = paramVO.getCondDt(); 
    	if (condDt != null) {
    		paramVO.setCondDt(condDt.replaceAll("\\-", ""));
    	}
    	
		event.setOutstandingHisByDateVO(paramVO);

    	/*if(command.isCommand(FormCommand.SEARCHLIST)) {								
		}*/
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