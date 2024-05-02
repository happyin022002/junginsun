/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_090HTMLAction.java
*@FileTitle : US Domestic 물량 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-10
*@LastModifier : ChungEunHo
*@LastVersion : 1.0
* 2009-08-10 ChungEunHo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0090ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.EqrScnrSlseVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.scenariomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ScenarioManageSC로 실행요청<br>
 * - ScenarioManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author ChungEunHo
 * @see EesEqr0090Event 참조
 * @since J2EE 1.6
 */
public class EES_EQR_0090HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EES_EQR_090HTMLAction 객체를 생성
	 */
	public EES_EQR_0090HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EES_EQR_090Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand f_cmd  = FormCommand.fromRequest(request);

		EesEqr0090Event event = new EesEqr0090Event();  
		event.setConditionVO((EesEqr0090ConditionVO)getVO(request,EesEqr0090ConditionVO.class));
		EesEqr0090ConditionVO condiVO = event.getConditionVO();
		String newTitle = condiVO.getTitleWeekly();//JSPUtil.getParameter(request, "title_weekly".trim(),"");
		newTitle = Utils.replaceStringAll(newTitle,"|",",");
		
		//ECC_COMMON

		
		String  perfix_month   = condiVO.getPerfixMonth();//JSPUtil.getParameter(request, "perfix_month".trim(), "");//200609,200610,200611,200612
		String  perfix_weekly  = condiVO.getPerfixWeekly();//JSPUtil.getParameter(request, "perfix_weekly".trim(), "");//200636,200637,200638,200639
		String  monthly_count  = condiVO.getMonthlyCount();//JSPUtil.getParameter(request, "monthly_count".trim(), "");//4,4,5,3
		
		// Share 버튼 클릭시
		if(f_cmd.isCommand(FormCommand.MULTI)) {
			EqrScnrSlseVO eqrScnrSlseVO = new EqrScnrSlseVO();
		    List<String>   month  = null;
		    List<String>   week  = null;
		    List<String>   monthWeekCnt  = null;
		    
		    month               = eqrScnrSlseVO.fromRequestPerfixMonth(request, "s1_", perfix_month);//
		    week                = eqrScnrSlseVO.fromRequestPerfixWeek(request, perfix_weekly);
		    monthWeekCnt        = eqrScnrSlseVO.fromRequestPerfixMonthWeekCnt(request, monthly_count);//
		    event.getConditionVO().setMonth(month);
		    event.getConditionVO().setWeek(week);
		    event.getConditionVO().setMonthWeekCnt(monthWeekCnt);

		}
		
		// Save 버튼 클릭시
		if(f_cmd.isCommand(FormCommand.MULTI01)) {		
			EqrScnrSlseVO eqrScnrSlseVO = new EqrScnrSlseVO();
			event.setEqrScnrSlseVOS(eqrScnrSlseVO.fromRequestGridEqrScnrSlseVOS(request, newTitle));
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