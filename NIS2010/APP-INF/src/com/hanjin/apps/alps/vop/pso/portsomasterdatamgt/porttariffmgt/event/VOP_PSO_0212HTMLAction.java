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

import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PortTariffCodeGRPVO;
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

public class VOP_PSO_0212HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_PSO_0212HTMLAction 객체를 생성
	 */
	public VOP_PSO_0212HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 portsomasterdatamgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopPso0212Event event = new VopPso0212Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setPortTariffCodeGRPVO((PortTariffCodeGRPVO)getVO(request,PortTariffCodeGRPVO.class));
		} else if( command.isCommand(FormCommand.SEARCHLIST01 )) {
			String ofcCd = (String) request.getParameter("ofc_cd");
			String psoObjCd = (String) request.getParameter("pso_obj_cd");
			String types = (String) request.getParameter("types");
			String portCd = (String) request.getParameter("port_cd");
			String costCd = (String) request.getParameter("cost_cd");
			//parameter로 넘어온 vndrSeq를 event객체에 set한다.
			event.setOfcCd(ofcCd);
			event.setPsoObjCd(psoObjCd);
			event.setTypes(types);
			event.setPortCd(portCd);
			event.setCostCd(costCd);
		} else if( command.isCommand(FormCommand.SEARCHLIST02 )) {
			String ofcCd = (String) request.getParameter("ofc_cd");
			String psoObjCd = (String) request.getParameter("pso_obj_cd");
			String types = (String) request.getParameter("types");
			//parameter로 넘어온 vndrSeq를 event객체에 set한다.
			event.setOfcCd(ofcCd);
			event.setPsoObjCd(psoObjCd);
			event.setTypes(types);
		} else if(command.isCommand(FormCommand.COMMAND01)) {
			String combo1 = (String) request.getParameter("combo1");
			String vndrSeq = (String) request.getParameter("vndr_seq");
			String acctCd = (String) request.getParameter("acct_cd");
			//parameter로 넘어온 vndrSeq를 event객체에 set한다.
			if(combo1 !=null)
				event.setCombo1( combo1 );
			if(combo1 !=null)
				event.setVndrSeq( vndrSeq );
			if(combo1 !=null)
				event.setAcctCd( acctCd );
		} else if(command.isCommand(FormCommand.COMMAND02)) {
			event.setPortTariffCodeGRPVO((PortTariffCodeGRPVO)getVO(request,PortTariffCodeGRPVO.class));
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