/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0077HTMLAction.java
*@FileTitle : Booking Copy
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.09 김병규
* 1.0 Creation
 * ------------------------------------------------------
 * HISTORY
 * 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgReactivateVO;
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
 * @author KimByungKyu
 * @see GeneralBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0078HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0077HTMLAction 객체를 생성
	 */
	public ESM_BKG_0078HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0078Event event = new EsmBkg0078Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			String bkgNo = JSPUtil.getParameter(request, "bkgNo");
			String tVvd = JSPUtil.getParameter(request, "trunkVVD");
			String polCd = JSPUtil.getParameter(request, "polCd");
			String podCd = JSPUtil.getParameter(request, "podCd");
			String sts = JSPUtil.getParameter(request, "sts");
			String cxlRsn = JSPUtil.getParameter(request, "cxlRsn");
			event.setBkgNo(bkgNo);
			event.setTrunkVVD(tVvd);
			event.setPolCd(polCd);
			event.setPodCd(podCd);
			event.setSts(sts);
			event.setCxlRsn(cxlRsn);
		}else if(command.isCommand(FormCommand.COMMAND01)){
//			BkgReactivateVO[] bkgReactivateVOs 	= (BkgReactivateVO[])getVOs(request, BkgReactivateVO .class,"");
			BkgReactivateVO bkgReactivateVO 	= (BkgReactivateVO)getVO(request, BkgReactivateVO .class,"");
//			event.setBkgUserSmsListVOs((BkgUserSmsListVO[])getVOs(request, BkgUserSmsListVO .class,""));
//			event.setBkgReactivateVOs(bkgReactivateVOs);
			event.setBkgReactivateVO(bkgReactivateVO);
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