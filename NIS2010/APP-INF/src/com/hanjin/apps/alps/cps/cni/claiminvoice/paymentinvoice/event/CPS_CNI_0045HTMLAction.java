/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0045HTMLAction.java
*@FileTitle :  Invoice Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.10.05 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.claiminvoice.paymentinvoice.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.cps.cni.claiminvoice.paymentinvoice.vo.PaymentInvoiceInfoVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event.CpsCni0042Event;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.VvdSkdCondVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.vo.CniCgoClmInsurVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * CPS_GEM_0045  Invoice Creation
 * HTTP Parser<br>
 * @author 진윤오
 * @see CpsCni0042Event 참조
 * @since J2EE 1.4
 */

public class CPS_CNI_0045HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_GNI_0042HTMLAction 객체를 생성
	 */
	public CPS_CNI_0045HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CpsCni0042Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		
		//이벤트 객체 생성 
		CpsCni0045Event event = new CpsCni0045Event();
		
		// ----------------------------------------------------
		// 공통화면 정보 설정 
		// ----------------------------------------------------
		
		// ----------------------------------------------------
		// 이벤트 처리 
		// ----------------------------------------------------		
		// [retrive]
		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			String cgoClmNo = JSPUtil.getParameter(request, "cgo_clm_no", "");
			event.setCgoClmNo(cgoClmNo);
		} else if (command.isCommand(FormCommand.SEARCHLIST02)) {
			String cgoClmPayNo = JSPUtil.getParameter(request, "cgo_clm_pay_no", "");
			event.setCgoClmPayNo(cgoClmPayNo);		
		} else if (command.isCommand(FormCommand.MULTI)) {
			PaymentInvoiceInfoVO paymentInvoiceInfoVO = 
				(PaymentInvoiceInfoVO) getVO(request, PaymentInvoiceInfoVO.class);
			event.setPaymentInvoiceInfoVO(paymentInvoiceInfoVO);
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