/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0037HTMLAction.java
*@FileTitle : Tariff Value Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.12.23 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffValueMgtGRPVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YardChargeVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YdChgObjVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.vop.pso.portsomasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PortSOMasterDataMgtSC로 실행요청<br>
 * - PortSOMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jeong Myounghun
 * @see PortSOMasterDataMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_PSO_0037HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_PSO_0037HTMLAction 객체를 생성
	 */
	public VOP_PSO_0037HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PortSOMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopPso0037Event event = new VopPso0037Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			//event.setYardChargeVOs((YardChargeVO[])getVOs(request, YardChargeVO.class, "sheet1_"));	//Master
			//event.setYdChgObjVOs((YdChgObjVO[])getVOs(request, YdChgObjVO.class, "sheet2_"));		//Detail
			YardChargeVO[] yardChargeVOs = (YardChargeVO[])getVOs(request, YardChargeVO.class, "sheet1_");
			YdChgObjVO[]   ydChgObjVOs =   (YdChgObjVO[])getVOs(request, YdChgObjVO.class, "sheet2_");
			
			TariffValueMgtGRPVO tariffValueMgtGRPVO = new TariffValueMgtGRPVO();
			tariffValueMgtGRPVO.setYardChargeVOs(yardChargeVOs);
			tariffValueMgtGRPVO.setYdChgObjVOs(ydChgObjVOs);
			event.setTariffValueMgtGRPVO(tariffValueMgtGRPVO);
		} else if(command.isCommand(FormCommand.SEARCH)) {
			event.setYardChargeVO((YardChargeVO)getVO(request, YardChargeVO.class));
		} else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setYdChgObjVO((YdChgObjVO)getVO(request, YdChgObjVO.class));
		} else if(command.isCommand(FormCommand.COMMAND02)) {
			event.setYardChargeVO((YardChargeVO)getVO(request, YardChargeVO.class));
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