/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0097HTMLAction.java
*@FileTitle : Vessel Schedule Change Simulation Analysis
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.08 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
//import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.vo.EesEqr0011ConditionVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.simulationmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SimulationManageSC로 실행요청<br>
 * - SimulationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Chae Change Ho
 * @see SimulationManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0097HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0097HTMLAction 객체를 생성
	 */
	public EES_EQR_0097HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SimulationManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
//    	FormCommand command = FormCommand.fromRequest(request);
		 EesEqr0097Event event = new EesEqr0097Event();
		 EesEqr0011ConditionVO conditonVO  = new EesEqr0011ConditionVO( );
  		// 모든 이벤트
    	  
    	  conditonVO.setYyyyww(JSPUtil.getParameter(request, "yyyyww".trim(), ""));
    	  conditonVO.setSeq(JSPUtil.getParameter(request, "seq".trim(), ""));		
      	// Preiod
    	  conditonVO.setEtbsyr(JSPUtil.getParameter(request, "etbSYr".trim(), ""));
    	  conditonVO.setEtbswk(JSPUtil.getParameter(request, "etbSWk".trim(), ""));
    	  conditonVO.setEtbeyr(JSPUtil.getParameter(request, "etbEYr".trim(), ""));
    	  conditonVO.setEtbewk(JSPUtil.getParameter(request, "etbEWk".trim(), ""));
      	// Company
    	  conditonVO.setCocd(JSPUtil.getParameter(request, "coCd".trim(), ""));
      	// Lane
    	  conditonVO.setVslslancd(JSPUtil.getParameter(request, "vslSlanCd".trim(), ""));
      	// VVD
    	  conditonVO.setVvd(JSPUtil.getParameter(request, "vvd".trim(), ""));		
  		// Repo Plan ID2
    	  conditonVO.setRepoplnid2(JSPUtil.getParameter(request, "repoPlnId2".trim(), ""));
  		// New SCNR ID
    	  conditonVO.setNewscnrid(JSPUtil.getParameter(request, "newScnrId".trim(), ""));
          event.setEesEqr0011ConditionVO(conditonVO);
  		//  event.setEesEqr0011ConditionVO((EesEqr0011ConditionVO)getVO(request, EesEqr0011ConditionVO .class));

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP) 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
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