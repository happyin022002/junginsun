/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_137HTMLAction.java
*@FileTitle : Constraint by Lane/POD
*Open Issues :
*Change history :
* No.    Ver.   Modifier         modifier date    explanation
* 1      1.0    ChangHoChae      2008-03-07       1.0 최초 생성
* 2      1.5    Haeng-ji, Lee    2009-04-02       CSR No : R200903240002 - Cntr Tpsz 자동화(Dry, Refer에 해당하는 Tpsz를 DB기반으로 수정)
*@LastModifyDate : 2009.07.21
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.21 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0137ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.syscommon.common.table.EqrPortDchgCnstVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.ees.eqr.defaultmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DefaultManageSC로 실행요청<br>
 * - DefaultManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Haeng-ji,Lee
 * @see DefaultManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0137HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_137HTMLAction 객체를 생성
	 */
	public EES_EQR_0137HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DefaultManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EesEqr0137Event event = new EesEqr0137Event();
    	EqrPortDchgCnstVO	eqrPortDchgCnstVO	= new EqrPortDchgCnstVO();
    	EqrPortDchgCnstVO[] eqrPortDchgCnstVOs	= null;    	   	

    	// 검색조건 VO Setting
		event.setEesEqr0137ConditionVO((EesEqr0137ConditionVO)getVO(request, EesEqr0137ConditionVO.class));    	
    	
		if(command.isCommand(FormCommand.MULTI)) {
			// Cntr Tpsz 형태에 맞게 Vo에 Setting해주기 위해서 Table VO에 새로만든 함수 호출해서 Vo Settting
	    	String tpsztype = event.getEesEqr0137ConditionVO().getTpsz();
			eqrPortDchgCnstVOs = eqrPortDchgCnstVO.fromRequestGridArrayList(request, tpsztype);
			event.setEqrPortDchgCnstVOS(eqrPortDchgCnstVOs);
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