/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0026HTMLAction.java
*@FileTitle : Safty Stock
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.11 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.syscommon.common.table.EqrScnrEccSftStkVO;
import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.vo.EesEqr0026ConditionVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps..ees.eqr.scenariomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ScenarioManageSC로 실행요청<br>
 * - ScenarioManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Haeng-ji,Lee
 * @see ScenarioManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0026HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0026HTMLAction 객체를 생성
	 */
	public EES_EQR_0026HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ScenarioManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand				command		= FormCommand.fromRequest(request);
		EesEqr0026Event			event		= new EesEqr0026Event();
		EesEqr0026ConditionVO	eesEqr0026ConditionVO	= new EesEqr0026ConditionVO();
		EqrScnrEccSftStkVO		eqrScnrEccSftStkVO		= new EqrScnrEccSftStkVO();
		EqrScnrEccSftStkVO[]	eqrScnrEccSftStkVOs		= null;
		
		eesEqr0026ConditionVO.fromRequest(request);
		String scnrId = Constants.SCNR_WORD + eesEqr0026ConditionVO.getYyyyww() + 
						Constants.SCNR_WEEK + eesEqr0026ConditionVO.getSeq();
		String status = eesEqr0026ConditionVO.getStatus();
		String locationStr = Utils.locationType(status);
		eesEqr0026ConditionVO.setScnrId(scnrId);
		eesEqr0026ConditionVO.setStatus(locationStr);
		
		String tpsztype = eesEqr0026ConditionVO.getTpsztype();
		
		if(command.isCommand(FormCommand.MULTI)) {
			eqrScnrEccSftStkVOs = eqrScnrEccSftStkVO.fromRequestGridArrayList(request, tpsztype);
			event.setEqrScnrEccSftStkVOS(eqrScnrEccSftStkVOs);
		} else if(command.isCommand(FormCommand.SEARCHLIST)) {			// Retrieve
			event.setEesEqr0026ConditionVO(eesEqr0026ConditionVO);
		} else if(command.isCommand(FormCommand.SEARCHLIST02)) {		// level 변경시 Qty Check
			event.setEesEqr0026ConditionVO(eesEqr0026ConditionVO);
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