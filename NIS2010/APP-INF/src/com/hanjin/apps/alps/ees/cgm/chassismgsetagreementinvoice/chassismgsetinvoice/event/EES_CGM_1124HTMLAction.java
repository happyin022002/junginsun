/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1124HTMLAction.java
*@FileTitle : Neutral Pool Payable Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.08.21 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSNuPoolChargeINVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.ees.cgm.chassismgsetagreementinvoice 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ChassisMgsetAgreementInvoiceSC로 실행요청<br>
 * - ChassisMgsetAgreementInvoiceSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM CHANG SIK
 * @see ChassisMgsetAgreementInvoiceEvent 참조
 * @since J2EE 1.4   
 */

public class EES_CGM_1124HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CGM_1124HTMLAction 객체를 생성
	 */
	public EES_CGM_1124HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ChassisMgsetAgreementInvoiceEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EesCgm1124Event event = new EesCgm1124Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			CHSNuPoolChargeINVO chsNuPoolChargeINVO = (CHSNuPoolChargeINVO)getVO(request, CHSNuPoolChargeINVO .class);
			chsNuPoolChargeINVO.setCostYrmon(chsNuPoolChargeINVO.getCostYrmon().replace("-", ""));
			chsNuPoolChargeINVO.setInvDt(chsNuPoolChargeINVO.getInvDt().replace("-", ""));
			
			event.setChsNuPoolChargeINVO(chsNuPoolChargeINVO);		
			event.setChsNuPoolChargeINVOS((CHSNuPoolChargeINVO[])getVOs(request, CHSNuPoolChargeINVO .class, ""));
		}
		else {
			
			CHSNuPoolChargeINVO chsNuPoolChargeINVO = (CHSNuPoolChargeINVO)getVO(request, CHSNuPoolChargeINVO .class);
			chsNuPoolChargeINVO.setCostYrmon(chsNuPoolChargeINVO.getCostYrmon().replace("-", ""));
			chsNuPoolChargeINVO.setInvDt(chsNuPoolChargeINVO.getInvDt().replace("-", ""));
			
			event.setChsNuPoolChargeINVO(chsNuPoolChargeINVO);	
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