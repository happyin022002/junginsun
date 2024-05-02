/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_TRS_0280HTMLAction.java
*@FileTitle : Fuel Surcharge Mamange
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.15
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.DummyAgmtRateVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.basic.FuelScgManageBC 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CodeManageSC로 실행요청<br>
 * - AgreementManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author SHIN DONG IN
 * @see EsdTrs0280Event , ESD_TRS_280EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0280HTMLAction extends HTMLActionSupport {
	/**
	 * ESD_TRS_0280HTMLAction 객체를 생성
	 */
	public ESD_TRS_0280HTMLAction() {}
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_280Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		
		DummyAgmtRateVO dummyAgmtRateVO   = new DummyAgmtRateVO();
		DummyAgmtRateVO[] dummyAgmtRateVOs = null; 
		
		EsdTrs0280Event event = new EsdTrs0280Event(); // table value object
		String fm_agmtno 			= JSPUtil.getParameter(request, "fm_agmtno", "");
		String fm_ctrt_ofc_cd 		= JSPUtil.getParameter(request, "fm_ctrt_ofc_cd", "");
		String fm_effective_agmt 	= JSPUtil.getParameter(request, "fm_effective_agmt", "");
		String fm_vndr_prmry_seq	= JSPUtil.getParameter(request, "fm_vndr_prmry_seq", "");
		String fm_trsp_cost_mod_cd  = JSPUtil.getParameter(request, "fm_trsp_cost_mod_cd", "");
		String fm_agmt_trsp_tp_cd 	= JSPUtil.getParameter(request, "fm_agmt_trsp_tp_cd", "");
		String header_row         	= request.getParameter("header_row")!=null?request.getParameter("header_row"):"";
		
		if(command.isCommand(FormCommand.SEARCH01)) {
		}else if(command.isCommand(FormCommand.SEARCH02)
			  || command.isCommand(FormCommand.MULTI01)
			  || command.isCommand(FormCommand.REMOVE01))  {
			dummyAgmtRateVOs = dummyAgmtRateVO.fromRequestGrid(request);
		}
		
		event.setFm_agmtno(fm_agmtno);
		event.setFm_ctrt_ofc_cd(fm_ctrt_ofc_cd);
		event.setFm_effective_agmt(fm_effective_agmt);
		event.setFm_vndr_prmry_seq(fm_vndr_prmry_seq);
		event.setFm_trsp_cost_mod_cd(fm_trsp_cost_mod_cd);
		event.setFm_agmt_trsp_tp_cd(fm_agmt_trsp_tp_cd);
		event.setHeaderRow(header_row);
		event.setDummyAgmtRateVOs(dummyAgmtRateVOs);
		
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