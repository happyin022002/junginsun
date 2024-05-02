/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6032HTMLAction.java
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

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsProposalCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsProposalSummarySimulationSetVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsProposalSummarySimulationVO;
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

public class ESM_PRI_6032HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_6032HTMLAction 객체를 생성
	 */
	public ESM_PRI_6032HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ProfitabilitySimulationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri6032Event event = new EsmPri6032Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			InPrsProposalSummarySimulationSetVO voSet = new InPrsProposalSummarySimulationSetVO(); 
			InPrsProposalSummarySimulationVO[] vos1 = (InPrsProposalSummarySimulationVO[])getVOs(request, InPrsProposalSummarySimulationVO .class,"sheet1_");
			InPrsProposalSummarySimulationVO[] vos2 = (InPrsProposalSummarySimulationVO[])getVOs(request, InPrsProposalSummarySimulationVO .class,"sheet2_");
			InPrsProposalSummarySimulationVO[] vos3 = (InPrsProposalSummarySimulationVO[])getVOs(request, InPrsProposalSummarySimulationVO .class,"sheet3_");
			InPrsProposalSummarySimulationVO[] vos4 = (InPrsProposalSummarySimulationVO[])getVOs(request, InPrsProposalSummarySimulationVO .class,"sheet4_");
			InPrsProposalSummarySimulationVO[] vos5 = (InPrsProposalSummarySimulationVO[])getVOs(request, InPrsProposalSummarySimulationVO .class,"sheet5_");
			if( vos1 != null && vos1.length != 0 ){
				voSet.addInPrsProposalSummarySimulationVOS( vos1, "sheet1");
			}
			if( vos2 != null && vos2.length != 0 ){
				voSet.addInPrsProposalSummarySimulationVOS( vos2, "sheet2");
			}
			if( vos3 != null && vos3.length != 0 ){
				voSet.addInPrsProposalSummarySimulationVOS( vos3, "sheet3");
			}
			if( vos4 != null && vos4.length != 0 ){
				voSet.addInPrsProposalSummarySimulationVOS( vos4, "sheet4");
			}
			if( vos5 != null && vos5.length != 0 ){
				voSet.addInPrsProposalSummarySimulationVOS( vos5, "sheet5");
			}
			event.setInPrsProposalCmSummaryVO((InPrsProposalCmSummaryVO)getVO(request, InPrsProposalCmSummaryVO .class));
			event.setInPrsProposalSummarySimulationSetVO(voSet);
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setInPrsProposalCmSummaryVO((InPrsProposalCmSummaryVO)getVO(request, InPrsProposalCmSummaryVO .class));
		}else{
			event.setInPrsProposalSummarySimulationVO( (InPrsProposalSummarySimulationVO)getVO(request, InPrsProposalSummarySimulationVO .class));
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