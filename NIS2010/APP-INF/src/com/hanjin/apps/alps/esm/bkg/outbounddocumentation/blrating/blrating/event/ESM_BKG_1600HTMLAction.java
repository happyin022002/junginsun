/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1600HTMLAction.java
*@FileTitle : Charge Amend Request
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthDetailVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthRefUserVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralBookingConductSC로 실행요청<br>
 * - GeneralBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Nam Kyung
 * @see GeneralBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_1600HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1600HTMLAction 객체를 생성
	 */
	public ESM_BKG_1600HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1600Event event = new EsmBkg1600Event();
		
		event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
		String bkgNo = JSPUtil.getParameter(request, "bkg_no");
		String chgCd = JSPUtil.getParameter(request, "chg_cd");
		event.setBkgNo(bkgNo);
		event.setChgCd(chgCd);
		
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));	
		} 
		else if(command.isCommand(FormCommand.MULTI)) {  //Request
			ChargeAmendAuthVO chargeExemptVO = (ChargeAmendAuthVO)getVO(request, ChargeAmendAuthVO.class,"sheet3_");
			ChargeAmendAuthRefUserVO[] chargeAmendAuthRefUserVOs = (ChargeAmendAuthRefUserVO[])getVOs(request, ChargeAmendAuthRefUserVO.class,"sheet4_");
			ChargeAmendAuthDetailVO[] chargeAmendAuthDetailVOs = (ChargeAmendAuthDetailVO[])getVOs(request, ChargeAmendAuthDetailVO.class,"sheet2_");
			event.setChargeAmendAuthVO(chargeExemptVO);
			event.setChargeAmendAuthDetailVOs(chargeAmendAuthDetailVOs);
			event.setChargeAmendAuthRefUserVOs(chargeAmendAuthRefUserVOs);
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