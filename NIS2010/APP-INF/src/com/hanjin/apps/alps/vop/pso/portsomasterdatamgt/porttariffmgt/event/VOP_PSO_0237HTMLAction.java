/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0002HTMLAction.java
*@FileTitle : Service Provider Help
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.06.03 박명종
* 1.0 Creation
*
* History
* 2010.11.24 CHM-201006949-01 박희동 특정 Tariff가 존재하는 Yard List를 조회한다.
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.InvAuditDataValidVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.vo.SvcLaneVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.ConditionVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PortTariffCodeGRPVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YdChgNoDataInfoVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgNonDgCgoKwVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vsm.pso.portsomasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 portsomasterdatamgtSC로 실행요청<br>
 * - portsomasterdatamgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Park MyoungJong
 * @see portsomasterdatamgtEvent 참조
 * @since J2EE 1.4
 */

public class VOP_PSO_0237HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_PSO_0212HTMLAction 객체를 생성
	 */
	public VOP_PSO_0237HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 portsomasterdatamgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopPso0237Event event = new VopPso0237Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setYdChgNoDataInfoVO((YdChgNoDataInfoVO)getVO(request,YdChgNoDataInfoVO.class));
		} 
		else if(command.isCommand(FormCommand.MULTI)) {
			String newYdCd1 = (String) request.getParameter("new_yd_cd1");
			String newYdCd2 = (String) request.getParameter("new_yd_cd2");
			String newYdCd3 = (String) request.getParameter("new_yd_cd3");
			String newYdCd4 = (String) request.getParameter("new_yd_cd4");
			String newYdCd5 = (String) request.getParameter("new_yd_cd5");
			String allInfo = (String) request.getParameter("all_info");

			event.setNewYdCd1(newYdCd1 );
			event.setNewYdCd2(newYdCd2 );
			event.setNewYdCd3(newYdCd3 );
			event.setNewYdCd4(newYdCd4 );
			event.setNewYdCd5(newYdCd5 );
			
			event.setAllInfo(allInfo );
			event.setYdChgNoDataInfoVOs((YdChgNoDataInfoVO[])getVOs(request,YdChgNoDataInfoVO.class,"sheet1_"));
			
		} 
		
		else if(command.isCommand(FormCommand.COMMAND01)||command.isCommand(FormCommand.COMMAND02)) {
			String vndr_seq2 = (String) request.getParameter("vndr_seq2");
			event.setVndrSeq2(vndr_seq2);
		}
		
       else if(command.isCommand(FormCommand.COMMAND03)) {
			
    	   String ydCd = (String) request.getParameter("new_yd_cd");
		   event.setNewYdCd(ydCd);
		}
		
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