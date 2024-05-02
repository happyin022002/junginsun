/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0065HTMLAction.java
*@FileTitle : 민감도 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.18 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.vo.EesEqr0065ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.vo.EesEqr0065MultiVO;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.simulationmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SimulationManageSC로 실행요청<br>
 * - SimulationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Chae Change Ho
 * @see SimulationManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0065HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0065HTMLAction 객체를 생성
	 */
	public EES_EQR_0065HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SimulationManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0065Event event = new EesEqr0065Event();
		EesEqr0065ConditionVO conditionVO = new EesEqr0065ConditionVO();
		EesEqr0065MultiVO multiVO = new EesEqr0065MultiVO();
		EesEqr0065MultiVO[] multiVOs = null;
		conditionVO.setYyyyww(JSPUtil.getParameter(request, "yyyyww".trim(), ""));
		conditionVO.setSeq(JSPUtil.getParameter(request, "seq".trim(), ""));
		conditionVO.setRepormk(JSPUtil.getParameter(request, "repo_rmk".trim(), ""));

		conditionVO.setFmtoat(JSPUtil.getParameter(request, "fmToAt".trim(), ""));
		conditionVO.setFmtype(JSPUtil.getParameter(request, "fmType".trim(), ""));
		conditionVO.setFmecccd(JSPUtil.getParameter(request, "fmEccCd".trim(), ""));
		conditionVO.setTotype(JSPUtil.getParameter(request, "toType".trim(), ""));
		conditionVO.setToecccd(JSPUtil.getParameter(request, "toEccCd".trim(), ""));
		conditionVO.setAttype(JSPUtil.getParameter(request, "atType".trim(), ""));
		conditionVO.setAtecccd(JSPUtil.getParameter(request, "atEccCd".trim(), ""));

		conditionVO.setFmstartyear(JSPUtil.getParameter(request, "fmStartYear".trim(), ""));
		conditionVO.setFmstartweek(JSPUtil.getParameter(request, "fmStartWeek".trim(), ""));
		conditionVO.setFmendyear(JSPUtil.getParameter(request, "fmEndYear".trim(), ""));
		conditionVO.setFmendweek(JSPUtil.getParameter(request, "fmEndWeek".trim(), ""));

		conditionVO.setTostartyear(JSPUtil.getParameter(request, "toStartYear".trim(), ""));
		conditionVO.setTostartweek(JSPUtil.getParameter(request, "toStartWeek".trim(), ""));
		conditionVO.setToendyear(JSPUtil.getParameter(request, "toEndYear".trim(), ""));
		conditionVO.setToendweek(JSPUtil.getParameter(request, "toEndWeek".trim(), ""));

		conditionVO.setAtstartyear(JSPUtil.getParameter(request, "atStartYear".trim(), ""));
		conditionVO.setAtstartweek(JSPUtil.getParameter(request, "atStartWeek".trim(), ""));
		conditionVO.setAtendyear(JSPUtil.getParameter(request, "atEndYear".trim(), ""));
		conditionVO.setAtendweek(JSPUtil.getParameter(request, "atEndWeek".trim(), ""));

		conditionVO.setCntrtpszcd(JSPUtil.getParameter(request, "cntrTpszCd".trim(), ""));
		conditionVO.setSens(JSPUtil.getParameter(request, "sens".trim(), ""));
		conditionVO.setCostobj(JSPUtil.getParameter(request, "costObj".trim(), ""));
		conditionVO.setLimitobj(JSPUtil.getParameter(request, "limitObj".trim(), ""));
        
		conditionVO.setSenstext(JSPUtil.getParameter(request, "sens_txt".trim(), ""));
		conditionVO.setObjecttext(JSPUtil.getParameter(request, "obj_txt".trim(), ""));
        
		conditionVO.setScnrid(JSPUtil.getParameter(request, "scnr_id".trim(), ""));
		//---------------grid에서 해당 변수값을 가져온다. ---------------------------
		multiVOs = multiVO.fromRequestGrid(request ,"");
		event.setEesEqr0065MultiVOs(multiVOs);
		
//		event.putValue("ibflag"           , request.getParameterValues("ibflag"));
//		event.putValue("week"             , request.getParameterValues("week"));
//		event.putValue("sensity"          , request.getParameterValues("sensity"));
//		event.putValue("obj"              , request.getParameterValues("obj"));
//		event.putValue("fm_loc"           , request.getParameterValues("fm_loc"));
//		event.putValue("to_loc"           , request.getParameterValues("to_loc"));
//		event.putValue("ts_type"          , request.getParameterValues("ts_type"));
//		event.putValue("curr_cost"        , request.getParameterValues("curr_cost"));
//		event.putValue("curr_limit"       , request.getParameterValues("curr_limit"));
//		event.putValue("lane"             , request.getParameterValues("lane"));
//		event.putValue("vvd"              , request.getParameterValues("vvd"));
		
		//-------------grid에서 해당 변수값을 가져오기 끝 ---------------------------
		event.setEesEqr0065ConditionVO(conditionVO);
		event.setCommandClassName("SimulationManageSC");

	
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