/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0007HTMLAction.java
*@FileTitle : Formula & Condition Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.08.05 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.FormulaGRPVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo.FormulaVO;
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
 * @author Kim Jin Ihl
 * @see PortSOMasterDataMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_PSO_0007HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_PSO_0007HTMLAction 객체를 생성
	 */
	public VOP_PSO_0007HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PortSOMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopPso0007Event event = new VopPso0007Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {//RetrieveBtnClick
			event.setId(request.getParameter("txtid"));
			event.setFlag(request.getParameter("radioflag"));
		}
		else if(command.isCommand(FormCommand.REMOVE)) {//DeleteBtnClick
			event.setId(request.getParameter("txtid"));
			event.setFlag(request.getParameter("radioflag"));
		}
		else if(command.isCommand(FormCommand.MULTI)) {//SaveBtnClick
			event.setId(request.getParameter("txtid"));
			event.setFlag(request.getParameter("radioflag"));
			FormulaGRPVO vo = new FormulaGRPVO();
			vo.setId(request.getParameter("txtid"));
			vo.setFlag(request.getParameter("radioflag"));
			vo.setUsrId(request.getParameter("usr_id"));
			vo.setFormulaVOs((FormulaVO[])getVOs(request, FormulaVO.class,"sheet1_"));
			vo.setFormulaSysVOs((FormulaVO[])getVOs(request, FormulaVO.class,"sheet2_"));
			event.setFormulaGRPVO(vo);
		}
		else{//최초 Open시 ?
			log.debug("VOP_PSO_0007HTMLAction>>>ELSE");
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