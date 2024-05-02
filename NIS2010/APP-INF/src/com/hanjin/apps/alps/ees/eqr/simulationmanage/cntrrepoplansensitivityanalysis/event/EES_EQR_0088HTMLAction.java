/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0088HTMLAction.java
*@FileTitle : 민감도조회/분석
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.22 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.vo.EesEqr0088ConditionVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.simulationmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SimulationManageSC로 실행요청<br>
 * - SimulationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Chae Change Ho
 * @see SimulationManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0088HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0088HTMLAction 객체를 생성
	 */
	public EES_EQR_0088HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SimulationManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0088Event event = new EesEqr0088Event();
		EesEqr0088ConditionVO conditonVO = new EesEqr0088ConditionVO();
		
		conditonVO.setYyyyww(JSPUtil.getParameter(request, "yyyyww".trim(), ""));
		conditonVO.setSeq(JSPUtil.getParameter(request, "seq".trim(), ""));
		conditonVO.setRepormk(JSPUtil.getParameter(request, "repo_rmk".trim(), ""));
		
		conditonVO.setRepoplanid2(JSPUtil.getParameter(request, "repoPlanID2".trim(), ""));
	
		conditonVO.setFmtoat(JSPUtil.getParameter(request, "fmToAt".trim(), ""));
		conditonVO.setFmtype(JSPUtil.getParameter(request, "fmType".trim(), ""));
		conditonVO.setFmecccd(JSPUtil.getParameter(request, "fmEccCd".trim(), ""));
		conditonVO.setTotype(JSPUtil.getParameter(request, "toType".trim(), ""));
		conditonVO.setToecccd(JSPUtil.getParameter(request, "toEccCd".trim(), ""));
		conditonVO.setAttype(JSPUtil.getParameter(request, "atType".trim(), ""));
		conditonVO.setAtecccd(JSPUtil.getParameter(request, "atEccCd".trim(), ""));

		conditonVO.setFmstartyear(JSPUtil.getParameter(request, "fmStartYear".trim(), ""));
		conditonVO.setFmstartweek(JSPUtil.getParameter(request, "fmStartWeek".trim(), ""));
		conditonVO.setFmendyear(JSPUtil.getParameter(request, "fmEndYear".trim(), ""));
		conditonVO.setFmendweek(JSPUtil.getParameter(request, "fmEndWeek".trim(), ""));

		conditonVO.setTostartyear(JSPUtil.getParameter(request, "toStartYear".trim(), ""));
		conditonVO.setTostartweek(JSPUtil.getParameter(request, "toStartWeek".trim(), ""));
		conditonVO.setToendyear(JSPUtil.getParameter(request, "toEndYear".trim(), ""));
		conditonVO.setToendweek(JSPUtil.getParameter(request, "toEndWeek".trim(), ""));

		conditonVO.setAtstartyear(JSPUtil.getParameter(request, "atStartYear".trim(), ""));
		conditonVO.setAtstartweek(JSPUtil.getParameter(request, "atStartWeek".trim(), ""));
		conditonVO.setAtendyear(JSPUtil.getParameter(request, "atEndYear".trim(), ""));
		conditonVO.setAtendweek(JSPUtil.getParameter(request, "atEndWeek".trim(), ""));

		conditonVO.setCntrtpszcd(JSPUtil.getParameter(request, "cntrTpszCd".trim(), ""));
		conditonVO.setSens(JSPUtil.getParameter(request, "sens".trim(), ""));
		conditonVO.setCostobj(JSPUtil.getParameter(request, "costObj".trim(), ""));
		conditonVO.setLimitobj(JSPUtil.getParameter(request, "limitObj".trim(), ""));
        
		conditonVO.setSenscode(JSPUtil.getParameter(request, "sensCode".trim(), ""));
		conditonVO.setSenstext(JSPUtil.getParameter(request, "sensText".trim(), ""));
		conditonVO.setObjectcode(JSPUtil.getParameter(request, "objCode".trim(), ""));
		conditonVO.setObjecttext(JSPUtil.getParameter(request, "objText".trim(), ""));
		
		conditonVO.setSheet1week(JSPUtil.getParameter(request, "Sheet1_Week".trim(), ""));
		conditonVO.setSheet1costcd(JSPUtil.getParameter(request, "Sheet1_CostCd".trim(), ""));
		
		event.setEesEqr0088ConditionVO(conditonVO);
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