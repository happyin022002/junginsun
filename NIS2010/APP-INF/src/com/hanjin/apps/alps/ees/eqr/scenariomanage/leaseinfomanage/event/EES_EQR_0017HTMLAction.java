/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0017HTMLAction.java
*@FileTitle : ST On-Hire
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.27 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.vo.EesEqr0017ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.EqrScnrShrtTermOnhCondVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.ees.eqr.scenariomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ScenarioManageSC로 실행요청<br>
 * - ScenarioManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Haeng-ji,Lee
 * @see ScenarioManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0017HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0017HTMLAction 객체를 생성
	 */
	public EES_EQR_0017HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ScenarioManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		
		EesEqr0017Event event = new EesEqr0017Event();
		EqrScnrShrtTermOnhCondVO eqrScnrShrtTermOnhCondVO = new EqrScnrShrtTermOnhCondVO();
		EqrScnrShrtTermOnhCondVO[] eqrScnrShrtTermOnhCondVOs = null;
		EesEqr0017ConditionVO eesEqr0017ConditionVO = new EesEqr0017ConditionVO();		
		
		eesEqr0017ConditionVO.fromRequest(request);
		
		// Scenario ID를 조합해서 검색조건 VO에 Setting해주기..
		String scnr_id	= "";
		String yyyyww	= eesEqr0017ConditionVO.getYyyyww();
		String seq		= eesEqr0017ConditionVO.getSeq();
		String tpsztype	= eesEqr0017ConditionVO.getTpsztype();
		
		if(!yyyyww.equals("") && !seq.equals("")){
			scnr_id = Constants.SCNR_WORD + yyyyww + Constants.SCNR_WEEK + seq;  
		}
		eesEqr0017ConditionVO.setScnrId(scnr_id);
		
		// 검색조건 VO Setting
		event.setEesEqr0017ConditionVO(eesEqr0017ConditionVO);
		
		if(command.isCommand(FormCommand.MULTI)) {
			eqrScnrShrtTermOnhCondVOs = eqrScnrShrtTermOnhCondVO.fromRequestGridArrayList(request, tpsztype);
			event.setEqrScnrShrtTermOnhCondVOS(eqrScnrShrtTermOnhCondVOs);
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