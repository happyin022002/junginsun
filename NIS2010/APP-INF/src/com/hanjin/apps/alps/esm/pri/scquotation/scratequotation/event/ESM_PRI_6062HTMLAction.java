/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6016HTMLAction.java
*@FileTitle : PRS-Cost Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.13 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.InPriPrsRoutCsVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.InCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriPrsCostListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriSqRtUsdRoutCsVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCProfitabilitySimulationSC로 실행요청<br>
 * - SCProfitabilitySimulationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SONG MIN SEOK
 * @see SCProposalEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_6062HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_6016HTMLAction 객체를 생성
	 */
	public ESM_PRI_6062HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCProposalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri6062Event event = new EsmPri6062Event();
 
		
		if(command.isCommand(FormCommand.MULTI)) {
			RsltPriPrsCostListVO[] vos = (RsltPriPrsCostListVO[])getVOs(request, RsltPriPrsCostListVO .class);
			event.setRsltPriPrsCostListVOS(vos);
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setRsltPriPrsCostListVO((RsltPriPrsCostListVO)getVO(request, RsltPriPrsCostListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setRsltPriPrsCostDetailVO((RsltPriPrsCostDetailVO)getVO(request, RsltPriPrsCostDetailVO .class));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			
			RsltPriPrsCostListVO[] vos = (RsltPriPrsCostListVO[])getVOs(request, RsltPriPrsCostListVO .class);
			event.setRsltPriPrsCostListVOS(vos);	
			PriSqRtUsdRoutCsVO routCsVO = (PriSqRtUsdRoutCsVO)getVO(request, PriSqRtUsdRoutCsVO .class);
			event.setPriSqRtUsdRoutCsVO(routCsVO); 
			
			InPriPrsRoutCsVO inPriPrsRoutCsVO = (InPriPrsRoutCsVO)getVO(request, InPriPrsRoutCsVO .class);
			event.setInPriPrsRoutCsVO(inPriPrsRoutCsVO); 
			
			InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO = (InCostSimulationCheckRouteVO)getVO(request, InCostSimulationCheckRouteVO .class);
			event.setInCostSimulationCheckRouteVO(inCostSimulationCheckRouteVO); 
			
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