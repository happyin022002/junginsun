/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0098HTMLAction.java
*@FileTitle : POL Simulation Analyes
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.03 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0012ConditionVO;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.simulationmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SimulationManageSC로 실행요청<br>
 * - SimulationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Chae Change Ho
 * @see SimulationManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0098HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0098HTMLAction 객체를 생성
	 */
	public EES_EQR_0098HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SimulationManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0098Event event = new EesEqr0098Event();
		EesEqr0012ConditionVO conditonVO = new EesEqr0012ConditionVO();

		// html input 값을 넘겨준다. 
		// SEARCHLIST , SEARCHLIST01 , SEARCHLIST02 할당값을 넘겨줌 
	 	conditonVO.setYyyyww(JSPUtil.getParameter(request, "yyyyww".trim(), ""));
	 	conditonVO.setSeq(JSPUtil.getParameter(request, "seq".trim(), ""));
	 	conditonVO.setScnrId(JSPUtil.getParameter(request, "scnr_id".trim(),""));
	 	conditonVO.setFmecccd(JSPUtil.getParameter(request,"fmEccCD".trim(),""));
	 	conditonVO.setToecccd(JSPUtil.getParameter(request, "toEccCd".trim() ,""));
	    log.debug("scnr_id =================>" + JSPUtil.getParameter(request, "scnr_id".trim(),""));
		//From LOC
	    conditonVO.setFmtype(JSPUtil.getParameter(request, "fmType".trim(), ""));
	    conditonVO.setFmecccd(JSPUtil.getParameter(request, "fmEccCd".trim(), ""));
	    conditonVO.setFmplnyr(JSPUtil.getParameter(request, "fmPlnYr".trim(), ""));
	    conditonVO.setFmplnwk(JSPUtil.getParameter(request, "fmPlnWk".trim(), ""));
	    conditonVO.setToplnyr(JSPUtil.getParameter(request, "toPlnYr".trim(), "")); 
	    conditonVO.setToplnwk(JSPUtil.getParameter(request, "toPlnWk".trim(), ""));
    	
        //To LOC	
	    conditonVO.setTotype(JSPUtil.getParameter(request, "toType".trim(), ""));
	    conditonVO.setToecccd(JSPUtil.getParameter(request, "toEccCd".trim(), ""));
	    conditonVO.setFmtoplnyr(JSPUtil.getParameter(request, "fmToPlnYr".trim(), ""));
	    conditonVO.setFmtoplnwk(JSPUtil.getParameter(request, "fmToPlnWk".trim(), ""));
	    conditonVO.setTotoplnyr(JSPUtil.getParameter(request, "toToPlnYr".trim(), "")); 
	    conditonVO.setTotoplnwk(JSPUtil.getParameter(request, "toToPlnWk".trim(), ""));
	    conditonVO.setCntrtpszcd(JSPUtil.getParameter(request, "cntrTpszCd".trim(), ""));
	    conditonVO.setConti(JSPUtil.getParameter(request, "conti".trim(),""));
	    conditonVO.setTrade(JSPUtil.getParameter(request,"trade".trim(),""));
	    conditonVO.setLane(JSPUtil.getParameter(request,"lane".trim(),""));
	    conditonVO.setLane1(JSPUtil.getParameter(request, "lane_1".trim(),""));
	    conditonVO.setVvd(JSPUtil.getParameter(request, "vvd".trim(),""));
	    conditonVO.setVvd1(JSPUtil.getParameter(request, "vvd_1".trim()));
	    conditonVO.setNewrepoId(JSPUtil.getParameter(request,"Plna_Id".trim(),""));
	    conditonVO.setSearchkey(JSPUtil.getParameter(request,"searchKey".trim(),""));
	    event.setEesEqr0012ConditionVO(conditonVO);
    	event.setCommandClassName("SimulationManageSC");
        event.setFormCommand(command);

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