/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6031HTMLAction.java
*@FileTitle : CM,OP Summary And Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.10 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentSummarySimulationSetVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentSummarySimulationVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.profitabilitysimulation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ProfitabilitySimulationSC로 실행요청<br>
 * - ProfitabilitySimulationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SONG MIN SEOK
 * @see ProfitabilitySimulationEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_6031HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_6031HTMLAction 객체를 생성
	 */
	public ESM_PRI_6031HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ProfitabilitySimulationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri6031Event event = new EsmPri6031Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			InPrsAmendmentSummarySimulationSetVO voSet = new InPrsAmendmentSummarySimulationSetVO(); 
			InPrsAmendmentSummarySimulationVO[] vos1 = (InPrsAmendmentSummarySimulationVO[])getVOs(request, InPrsAmendmentSummarySimulationVO .class,"sheet1_");
			InPrsAmendmentSummarySimulationVO[] vos2 = (InPrsAmendmentSummarySimulationVO[])getVOs(request, InPrsAmendmentSummarySimulationVO .class,"sheet2_");
			InPrsAmendmentSummarySimulationVO[] vos3 = (InPrsAmendmentSummarySimulationVO[])getVOs(request, InPrsAmendmentSummarySimulationVO .class,"sheet3_");
			InPrsAmendmentSummarySimulationVO[] vos4 = (InPrsAmendmentSummarySimulationVO[])getVOs(request, InPrsAmendmentSummarySimulationVO .class,"sheet4_");
			InPrsAmendmentSummarySimulationVO[] vos5 = (InPrsAmendmentSummarySimulationVO[])getVOs(request, InPrsAmendmentSummarySimulationVO .class,"sheet5_");
			if( vos1 != null && vos1.length != 0 ){
				voSet.addInPrsAmendmentSummarySimulationVOS( vos1, "sheet1");
			}
			if( vos2 != null && vos2.length != 0 ){
				voSet.addInPrsAmendmentSummarySimulationVOS( vos2, "sheet2");
			}
			if( vos3 != null && vos3.length != 0 ){
				voSet.addInPrsAmendmentSummarySimulationVOS( vos3, "sheet3");
			}
			if( vos4 != null && vos4.length != 0 ){
				voSet.addInPrsAmendmentSummarySimulationVOS( vos4, "sheet4");
			}
			if( vos5 != null && vos5.length != 0 ){
				voSet.addInPrsAmendmentSummarySimulationVOS( vos5, "sheet5");
			}
			event.setInPrsAmendmentCmSummaryVO((InPrsAmendmentCmSummaryVO)getVO(request, InPrsAmendmentCmSummaryVO .class));
			event.setInPrsAmendmentSummarySimulationSetVO(voSet);
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setInPrsAmendmentCmSummaryVO((InPrsAmendmentCmSummaryVO)getVO(request, InPrsAmendmentCmSummaryVO .class));
		}else{
			event.setInPrsAmendmentSummarySimulationVO( (InPrsAmendmentSummarySimulationVO)getVO(request, InPrsAmendmentSummarySimulationVO .class));
		}

		event.setAttribute("KEY", request.getParameter("backendjob_key"));
		
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