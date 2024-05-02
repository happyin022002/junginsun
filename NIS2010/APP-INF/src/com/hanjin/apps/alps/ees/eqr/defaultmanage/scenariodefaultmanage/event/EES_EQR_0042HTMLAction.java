/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EES_EQR_042HTMLAction.java
*@FileTitle : Holiday Effect 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009-07-15
*@LastModifier : eun ho chung
*@LastVersion : 1.0
* 2009-07-15 eun ho chung
*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0042ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.EqrHolEffRtoVO;
import com.hanjin.syscommon.common.table.EqrHolidayVO;



/**
 * HTTP Parser<br>
 * - com.hanjin.apps.enis.ees.eqr.defaultmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DefaultManageSC로 실행요청<br>
 * - DefaultManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Eun ho Chung
 * @see EesEqr0116Event 참조
 *  @since J2EE 1.6
 */
public class EES_EQR_0042HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EES_EQR_042HTMLAction 객체를 생성
	 */
	public EES_EQR_0042HTMLAction() {
	}
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EES_EQR_042Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command  = FormCommand.fromRequest(request);
		
		EesEqr0042Event event = new EesEqr0042Event();
		
		

		if (command.isCommand(FormCommand.MULTI)){//grid 0 save.
	       	event.setEqrHolidayVOS((EqrHolidayVO[])getVOs(request, EqrHolidayVO .class,"")); // 변경 될 DTD setting
	       	event.setConditionVO((EesEqr0042ConditionVO)getVO(request, EesEqr0042ConditionVO.class)); // 조건 DTD setting
	    }
		
		if (command.isCommand(FormCommand.MULTI01)){//grid1(O/B) save.
			event.setEqrHolEffRtoVOS((EqrHolEffRtoVO[])getVOs(request, EqrHolEffRtoVO .class,""));
			event.setConditionVO((EesEqr0042ConditionVO)getVO(request, EesEqr0042ConditionVO.class)); // 조건 DTD setting
			
			// hol_eff_rto 배열 셋팅 hol_eff_wk+'_irto' 의  파마메타 명으로 입력받아 설정한다.
			event.setEqrHolEffRtoVOSHolEffRto(request);			
	    }	
	       
	    if (command.isCommand(FormCommand.SEARCHLIST) || command.isCommand(FormCommand.SEARCHLIST01)){
             event.setConditionVO((EesEqr0042ConditionVO)getVO(request, EesEqr0042ConditionVO.class)); // 조건 DTD setting             
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