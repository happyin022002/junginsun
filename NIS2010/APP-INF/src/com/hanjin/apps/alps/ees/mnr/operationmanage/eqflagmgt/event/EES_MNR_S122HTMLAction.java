/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_S122HTMLAction.java
*@FileTitle : Damage Flagging/Unflagging
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.19 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrFlgHisVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListINVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mnr.operationmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OperationManageSC로 실행요청<br>
 * - OperationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author park myoung sin
 * @see OperationManageEvent 참조
 * @since J2EE 1.4
 */

public class EES_MNR_S122HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/** 
	 * EES_MNR_0139HTMLAction 객체를 생성
	 */
	public EES_MNR_S122HTMLAction() {} 

	/**  
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 OperationManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */  
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		 
    	FormCommand command = FormCommand.fromRequest(request); 
		EesMnrS122Event event = new EesMnrS122Event();  
		 
		if(command.isCommand(FormCommand.SEARCH)) {                  
			event.setEQFlagListINVO((EQFlagListINVO)getVO(request, EQFlagListINVO .class));
		} else if(command.isCommand(FormCommand.MULTI)) {     
			event.setEQFlagListINVO((EQFlagListINVO)getVO(request, EQFlagListINVO .class));
			event.setCustomMnrEqStsVOs((CustomMnrEqStsVO[])getVOs(request, CustomMnrEqStsVO .class,""));
			event.setCustomMnrFlgHisVOs((CustomMnrFlgHisVO[])getVOs(request, CustomMnrFlgHisVO .class,""));
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