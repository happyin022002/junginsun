/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0009HTMLAction.java
*@FileTitle : Accrual Mail Setting
*Open Issues :
*Change history :2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.09.18
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.09.18 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchAccrualEmailSettingVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchParameterAccrualEmailSettingVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.LeaEmlSetVO;

//import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SendTestAccrualEmailSetting;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.lea.logisticsexpenseaccrual 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 LogisticsExpenseAccrualSC로 실행요청<br>
 * - LogisticsExpenseAccrualSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jeon Jae Hong
 * @see LogisticsExpenseAccrualEvent 참조
 * @since J2EE 1.6
 */

public class ESD_LEA_0009HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_LEA_0009HTMLAction 객체를 생성
	 */
	public ESD_LEA_0009HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 LogisticsExpenseAccrualEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdLea0009Event event = new EsdLea0009Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setLeaEmlSetVOS((LeaEmlSetVO[])getVOs(request, LeaEmlSetVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
//			event.setSendTestAccrualEmailSetting((SendTestAccrualEmailSetting)getVO(request, SendTestAccrualEmailSetting .class));
			event.setSearchParameterAccrualEmailSettingVO((SearchParameterAccrualEmailSettingVO)getVO(request, SearchParameterAccrualEmailSettingVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setSearchParameterAccrualEmailSettingVO((SearchParameterAccrualEmailSettingVO)getVO(request, SearchParameterAccrualEmailSettingVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setSearchAccrualEmailSettingVO((SearchAccrualEmailSettingVO)getVO(request, SearchAccrualEmailSettingVO .class));
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