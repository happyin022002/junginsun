/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1108HTMLAction.java
*@FileTitle : ESM_BKG-1108
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.03
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.09.03 김경섭
* 1.0 Creation
* -------------------------------------------------------
* History
* 2013.06.25 김보배 [CHM-201324814] [ENS FI] Finland 세관 ENS 개발 요청 (IE344, IE347)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EnsListVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
 
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM GYOUNG SUB
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_1108HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1108HTMLAction 객체를 생성 
	 */
	public ESM_BKG_1108HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1108Event event = new EsmBkg1108Event();
		Eu24EnsListVO vo = new Eu24EnsListVO(); 
		String pType = "";
		
		if(command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH01)) {

			pType = request.getParameter("p_type");
			
			
			if("ENS".equals(pType)){
				vo = (Eu24EnsListVO)getVO(request, Eu24EnsListVO.class);
				
			}else{
				vo = (Eu24EnsListVO)getVO(request, Eu24EnsListVO.class);
				
				vo.setPVvd(		 request.getParameter("p_fi_vvd"));
				vo.setPPol(		 request.getParameter("p_fi_pol"));
				vo.setPPolYd(	 request.getParameter("p_fi_pol_yd"));
				vo.setPPofe(	 request.getParameter("p_fi_pofe")+request.getParameter("p_fi_pofe_yd"));
				vo.setPPofeYd(	 request.getParameter("p_fi_pofe")+request.getParameter("p_fi_pofe_yd"));
				vo.setBkgOfcCd(	 request.getParameter("p_fi_b_ofc_cd"));
				vo.setPCancelYn( request.getParameter("p_fi_cancel_yn"));
			}
			
			vo.setPType(pType);
			event.setEu24EnsListVO(vo);
		
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
