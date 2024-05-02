/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0074HTMLAction.java
*@FileTitle : Inventory Container List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.24 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.EesEqr0074ConditionVO;
import com.hanjin.apps.alps.ees.eqr.common.Constants;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.repoplanmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RepoPlanManageSC로 실행요청<br>
 * - RepoPlanManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Chae Change Ho
 * @see RepoPlanManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0074HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0074HTMLAction 객체를 생성
	 */
	public EES_EQR_0074HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RepoPlanManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	
		EesEqr0074Event event = new EesEqr0074Event();
		EesEqr0074ConditionVO conditionVO = new EesEqr0074ConditionVO();
		
		conditionVO.setBased(JSPUtil.getParameter(request, "based".trim(), "")); // Repo Plan, Performance : 1,2  
		conditionVO.setReport(JSPUtil.getParameter(request, "report".trim(), "")); // Report : Summary, by Lane, by VVD
		conditionVO.setCompany(JSPUtil.getParameter(request, "company".trim(), "")); //  company : 0, 1, 2
		conditionVO.setLoctype(JSPUtil.getParameter(request, "loctype".trim(), "")); // Loc Type
		conditionVO.setLoclist(JSPUtil.getParameter(request, "loclist".trim(), ""));
	   	
//   	 REPO PLAN ID
    	// 화면에서 입력한 YYYY, SEQ 정보 --> 조회시 SCNR ID로 사용됨
		conditionVO.setYyyyww(JSPUtil.getParameter(request, "yyyyww".trim(), ""));
		conditionVO.setSeq(JSPUtil.getParameter(request, "seq".trim(), ""));
		conditionVO.setRepoplanid(Constants.REPO_WORD + conditionVO.getYyyyww() + Constants.SCNR_WEEK + conditionVO.getSeq());
		
		// PERIOD - FROM WEEK, TO WEEK	
		conditionVO.setFrYyyy(JSPUtil.getParameter(request, "fr_yyyy".trim(), ""));
		conditionVO.setFrWeek(JSPUtil.getParameter(request, "fr_week".trim(), ""));
		conditionVO.setToYyyy(JSPUtil.getParameter(request, "to_yyyy".trim(), ""));
		conditionVO.setToWeek(JSPUtil.getParameter(request, "to_week".trim(), ""));
		
    	//option
		conditionVO.setTrade(JSPUtil.getParameter(request, "trade".trim(), ""));
		conditionVO.setLane(JSPUtil.getParameter(request, "lane".trim(), ""));
		conditionVO.setVvd(JSPUtil.getParameter(request, "vvd".trim(), ""));
    	
		event.setEesEqr0074ConditionVO(conditionVO);

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