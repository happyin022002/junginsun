/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EES_EQR_1101HTMLAction.java
*@FileTitle : EQ Forecast Summary Filter
*Open Issues :
*Change history :
*@LastModifyDate : 2015-12-11
*@LastModifier : Jeong Min Park
*@LastVersion : 1.0
* 2015-12-11 Jeong Min Park
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.vo.EQBalanceSheetListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.vo.EQForecastSummaryINVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.bizcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BIZCOMMONSC로 실행요청<br>
 * - BIZCOMMONSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Hyung Choon_Roh
 * @see EesEqr1101Event , EES_EQR_1007EventResponse 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class EES_EQR_1101HTMLAction extends HTMLActionSupport {

	/**
	 * EES_EQR_1007HTMLAction 객체를 생성
	 */
	public EES_EQR_1101HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EES_EQR_1007Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand f_cmd = FormCommand.fromRequest(request);
    	
    	EesEqr1101Event event = new EesEqr1101Event();
    	
    	if(f_cmd.isCommand(FormCommand.SEARCH)) {
    		event.setEQForecastSummaryINVO((EQForecastSummaryINVO)getVO(request, EQForecastSummaryINVO.class));
    	}else if(f_cmd.isCommand(FormCommand.MULTI)) {
 			event.setEQBalanceSheetListVOS((EQBalanceSheetListVO[])getVOs(request, EQBalanceSheetListVO.class));
    	}else if(f_cmd.isCommand(FormCommand.SEARCH01)) {
    		event.setEQForecastSummaryINVO((EQForecastSummaryINVO)getVO(request, EQForecastSummaryINVO.class));
    	}
                 
        event.setCommandClassName("CntrFcstSimulSC");
        event.setFormCommand(f_cmd);
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