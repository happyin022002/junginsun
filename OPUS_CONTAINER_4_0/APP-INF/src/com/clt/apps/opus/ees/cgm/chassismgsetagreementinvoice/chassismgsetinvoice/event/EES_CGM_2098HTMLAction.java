/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2098HTMLAction.java
*@FileTitle : Payable Charge Audit Result & Payable Amount Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.08.21 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountINVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ChassisMgsetAgreementInvoiceSC로 실행요청<br>
 * - ChassisMgsetAgreementInvoiceSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM CHANG SIK
 * @see ChassisMgsetAgreementInvoiceEvent 참조
 * @since J2EE 1.4   
 */

public class EES_CGM_2098HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CGM_2098HTMLAction 객체를 생성
	 */
	public EES_CGM_2098HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ChassisMgsetAgreementInvoiceEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EesCgm2098Event event = new EesCgm2098Event();
		
		MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO1 = new MGSConfirmPayableAmountINVO();
		MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO2 = new MGSConfirmPayableAmountINVO();
		MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO3 = new MGSConfirmPayableAmountINVO();
		
		if(command.isCommand(FormCommand.SEARCH)) {		
			
			MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO = (MGSConfirmPayableAmountINVO)getVO(request, MGSConfirmPayableAmountINVO.class);
			mgsConfirmPayableAmountINVO.setCostYrmon(mgsConfirmPayableAmountINVO.getCostYrmon().replace("-", ""));
			
			event.setMgsConfirmPayableAmountINVO(mgsConfirmPayableAmountINVO);
			
		} else if(command.isCommand(FormCommand.MULTI01)) {
			
			MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO = (MGSConfirmPayableAmountINVO)getVO(request, MGSConfirmPayableAmountINVO.class);
			mgsConfirmPayableAmountINVO.setCostYrmon(mgsConfirmPayableAmountINVO.getCostYrmon().replace("-", ""));
			
			event.setMgsConfirmPayableAmountINVO(mgsConfirmPayableAmountINVO);
			
			event.setMgsConfirmPayableAmountINVOS1(mgsConfirmPayableAmountINVO1.fromRequestGrid(request,"t1sheet1"));
			event.setMgsConfirmPayableAmountINVOS2(mgsConfirmPayableAmountINVO2.fromRequestGrid(request,"t2sheet1"));
			event.setMgsConfirmPayableAmountINVOS3(mgsConfirmPayableAmountINVO3.fromRequestGrid(request,"t4sheet1"));
		
		} else if(command.isCommand(FormCommand.MULTI02)) {
			
			MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO = (MGSConfirmPayableAmountINVO)getVO(request, MGSConfirmPayableAmountINVO.class);
			
			mgsConfirmPayableAmountINVO.setCostYrmon(mgsConfirmPayableAmountINVO.getCostYrmon().replace("-", ""));
			mgsConfirmPayableAmountINVO.setInvDt(mgsConfirmPayableAmountINVO.getInvDt().replace("-", ""));
			
			event.setMgsConfirmPayableAmountINVO(mgsConfirmPayableAmountINVO);
			event.setMgsConfirmPayableAmountINVOS((MGSConfirmPayableAmountINVO[])getVOs(request, MGSConfirmPayableAmountINVO.class, ""));
				
		} else if(command.isCommand(FormCommand.REMOVE)) {		
			
			MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO = (MGSConfirmPayableAmountINVO)getVO(request, MGSConfirmPayableAmountINVO.class);
			mgsConfirmPayableAmountINVO.setCostYrmon(mgsConfirmPayableAmountINVO.getCostYrmon().replace("-", ""));
			
			event.setMgsConfirmPayableAmountINVO(mgsConfirmPayableAmountINVO);
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