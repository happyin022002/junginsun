/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : STM_SAR_0002HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableCommonSC로 실행요청<br>
 * - AccountReceivableCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSar0002Event 참조
 * @since J2EE 1.4
 */

public class STM_SAR_0002HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * STM_SAR_0002HTMLAction 객체를 생성
	 */
	public STM_SAR_0002HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	StmSar0002Event event = new StmSar0002Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			String vndr_lgl_eng_nm = JSPUtil.getParameter(request, "vndr_lgl_eng_nm" , "");
		    String vndr_seq	       = JSPUtil.getParameter(request, "vndr_seq" , "");
		    String delt_flg        = JSPUtil.getParameter(request, "delt_flg" , "");
		    
			event.setVndr_lgl_eng_nm(vndr_lgl_eng_nm);
			event.setVndr_seq(vndr_seq);
			event.setDelt_flg(delt_flg);
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