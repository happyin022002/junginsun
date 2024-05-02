/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0401HTMLAction.java
*@FileTitle : Insurance Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.13 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.insurance.insurance.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.CustomInsuranceVO;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.CustomPremiumInstallmentVO;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.CustomPremiumVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.cps.cni.insurance 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InsuranceSC로 실행요청<br>
 * - InsuranceSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Yoon, Seyeong
 * @see InsuranceEvent 참조
 * @since J2EE 1.6
 */

public class CPS_CNI_0401HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * CPS_CNI_0401HTMLAction 객체를 생성
	 */
	public CPS_CNI_0401HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InsuranceEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		CpsCni0401Event event = new CpsCni0401Event();

		FormCommand command = FormCommand.fromRequest(request);
		
		if(command.isCommand(FormCommand.MODIFY)) {
 			event.setCustomInsuranceVO((CustomInsuranceVO)getVO(request, CustomInsuranceVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setInsurTpCd(request.getParameter("insur_tp_cd"));
			event.setInsurPlcyYr(request.getParameter("insur_plcy_yr"));
			event.setInsurClmPtyNo(request.getParameter("insur_clm_pty_no"));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setInsurTpCd(request.getParameter("insur_tp_cd"));
			event.setInsurPlcyYr(request.getParameter("insur_plcy_yr"));
			event.setInsurClmPtyNo(request.getParameter("insur_clm_pty_prm_no"));
			event.setInsurPrmTpCd(request.getParameter("insur_prm_tp_cd"));
		} 
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setInsurTpCd(request.getParameter("insur_tp_cd"));
			event.setInsurPlcyYr(request.getParameter("insur_plcy_yr"));
			event.setInsurClmPtyNo(request.getParameter("insur_clm_pty_no"));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setInsurTpCd(request.getParameter("insur_tp_cd"));
			event.setInsurPlcyYr(request.getParameter("insur_plcy_yr"));
			event.setInsurClmPtyNo(request.getParameter("insur_clm_pty_prm_no"));
			event.setInsurPrmTpCd(request.getParameter("insur_prm_tp_cd"));
		} 
		else if(command.isCommand(FormCommand.MODIFY01)) {
 			event.setCustomPremiumVO((CustomPremiumVO)getVO(request, CustomPremiumVO.class));
 			event.setCustomPremiumInstallmentVOS((CustomPremiumInstallmentVO[])getVOs(request, CustomPremiumInstallmentVO.class,"sheet_"));
		}
		else if(command.isCommand(FormCommand.MODIFY02)) {
			event.setInsurTpCd(request.getParameter("insur_tp_cd"));
			event.setInsurPlcyYr(request.getParameter("insur_plcy_yr"));
			event.setInsurClmPtyNo(request.getParameter("insur_clm_pty_no"));
		}
		else if(command.isCommand(FormCommand.MODIFY03)) {
			event.setInsurTpCd(request.getParameter("insur_tp_cd"));
			event.setInsurPlcyYr(request.getParameter("insur_plcy_yr"));
			event.setInsurClmPtyNo(request.getParameter("insur_clm_pty_prm_no"));
			event.setInsurPrmTpCd(request.getParameter("insur_prm_tp_cd"));
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