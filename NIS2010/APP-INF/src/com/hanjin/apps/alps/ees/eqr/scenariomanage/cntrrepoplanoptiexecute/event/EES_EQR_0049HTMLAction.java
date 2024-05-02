/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0049HTMLAction.java
*@FileTitle : run_optimizer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.28 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo.EesEqr0049ConditionVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.scenariomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ScenarioManageSC로 실행요청<br>
 * - ScenarioManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Chae Change Ho
 * @see ScenarioManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0049HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0049HTMLAction 객체를 생성
	 */
	public EES_EQR_0049HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ScenarioManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0049Event event = new EesEqr0049Event();
		EesEqr0049ConditionVO eesEqr0049ConditionVO = new EesEqr0049ConditionVO();
		
		// Scenario ID
		eesEqr0049ConditionVO.setScnrYrWk(JSPUtil.getParameter(request, "yyyyww".trim(), ""));
		eesEqr0049ConditionVO.setScnrSeq(JSPUtil.getParameter(request, "seq".trim(), ""));
    	// Plan Period
    	// Flag infomation
		eesEqr0049ConditionVO.setInclu_onh_flg(	JSPUtil.getParameter(request, "inclu_onh_flg".trim(), ""));
		eesEqr0049ConditionVO.setInclu_offh_flg(	JSPUtil.getParameter(request, "inclu_offh_flg".trim(), ""));
		eesEqr0049ConditionVO.setRepo_auto_gen_flg(JSPUtil.getParameter(request, "repo_auto_gen_flg".trim(), ""));
		eesEqr0049ConditionVO.setSold_flg(JSPUtil.getParameter(request, "sold_flg".trim(), ""));
    	// Duration
		eesEqr0049ConditionVO.setDuration(JSPUtil.getParameter(request, "duration".trim(), ""));
    	// TP/SZ
		eesEqr0049ConditionVO.setCntrTpszCd(JSPUtil.getParameter(request, "cntrTpszCd".trim(), ""));    
    	// 현재주차와 SCNR주차의 관계 flag
		eesEqr0049ConditionVO.setFlag(JSPUtil.getParameter(request, "flag".trim(), ""));
    	
	 	
    	// Start Date
		eesEqr0049ConditionVO.setStyear(JSPUtil.getParameter(request, "st_year".trim(), ""));
		eesEqr0049ConditionVO.setStmonth(JSPUtil.getParameter(request, "st_month".trim(), ""));
		eesEqr0049ConditionVO.setStweekly(JSPUtil.getParameter(request, "st_weekly".trim(), ""));
    	
    	// End Date
		eesEqr0049ConditionVO.setEndyear(JSPUtil.getParameter(request, "end_year".trim(), ""));
		eesEqr0049ConditionVO.setEndmonth(JSPUtil.getParameter(request, "end_month".trim(), ""));
		eesEqr0049ConditionVO.setEndweekly(JSPUtil.getParameter(request, "end_weekly".trim(), ""));
		
		event.setEesEqr0049ConditionVO(eesEqr0049ConditionVO);
		
		event.setCommandClassName("ScenarioMangeSC");
        event.setFormCommand(command);
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
