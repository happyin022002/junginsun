/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0060HTMLAction.java
*@FileTitle : Vessel R.Capa.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.06 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.EesEqr0060ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.syscommon.common.table.EqrScnrVslRsdlCapaVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.scenariomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ScenarioManageSC로 실행요청<br>
 * - ScenarioManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Haeng-ji,Lee
 * @see ScenarioManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0060HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0060HTMLAction 객체를 생성
	 */
	public EES_EQR_0060HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ScenarioManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0060Event event = new EesEqr0060Event();
		EesEqr0060ConditionVO eesEqr0060ConditionVO = new EesEqr0060ConditionVO();
		EqrScnrVslRsdlCapaVO eqrScnrVslRsdlCapaVO	= new EqrScnrVslRsdlCapaVO();
		EqrScnrVslRsdlCapaVO[] eqrScnrVslRsdlCapaVOs = null;

		/* 검색조건 VO Setting..
		 * 1. fromRequest 함수를 이용해서 넘겨받은 변수를 Setting..
		 * 2. 넘겨받은 변수로  From Week, To Week, typeby를 변형해서  검색조건 VO에 Setting해주기.
		 */
		
		eesEqr0060ConditionVO.fromRequest(request);
		String frweek = eesEqr0060ConditionVO.getFrdtyy() + eesEqr0060ConditionVO.getFrdtmm();
		String toweek = eesEqr0060ConditionVO.getTodtyy() + eesEqr0060ConditionVO.getTodtmm();
		String typeby = eesEqr0060ConditionVO.getTypeby();
		
		typeby = Utils.locationType(typeby);	// R - RCC_CD, L - LCC_CD, E - ECC_CD
		
		eesEqr0060ConditionVO.setFrweek(frweek);
		eesEqr0060ConditionVO.setToweek(toweek);
		eesEqr0060ConditionVO.setTypeby(typeby);
		
		event.setEesEqr0060ConditionVO(eesEqr0060ConditionVO);
		
		if(command.isCommand(FormCommand.MULTI)) {
			eqrScnrVslRsdlCapaVOs = eqrScnrVslRsdlCapaVO.fromRequestGridArrayList(request, "");
			event.setEqrScnrVslRsdlCapaVOS(eqrScnrVslRsdlCapaVOs);
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