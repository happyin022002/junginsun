/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0228HTMLAction.java
*@FileTitle : e-Booking n SI Process
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.05.21 전용진
* 1.0 Creation
* --------------------------------------------------------
* HISTORY
* 2010.11.04 김영철 [CHM-201005975-01] SEANACCS ACL 변경 요청 (E-BKG&SI & DPCS 관련) - EDI로 들어온 Data가 처리되었는지 Validation 추가 요청
* 2011.06.24 손은주 [CHM-201111279-01] s-si Process 개선 사항 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.ModifySiValAutoVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EBookingConductSC로 실행요청<br>
 * - EBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jun Yong Jin
 * @see EBookingConductEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0228HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0228HTMLAction 객체를 생성
	 */
	public ESM_BKG_0228HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0228Event event = new EsmBkg0228Event();

		if(command.isCommand(FormCommand.MODIFY01)) {
			event.setXterRqstNoVOs((XterRqstNoVO[])getVOs(request, XterRqstNoVO .class,""));
		}
		else if(command.isCommand(FormCommand.MODIFY02)) {
			event.setXterRqstNoVOs((XterRqstNoVO[])getVOs(request, XterRqstNoVO .class,""));
		}
		else if(command.isCommand(FormCommand.MODIFY03)) {
			event.setXterRqstNoVOs((XterRqstNoVO[])getVOs(request, XterRqstNoVO .class,""));
//			event.setXterRqstNoVOs((XterRqstNoVO[])getVOs(request, XterRqstNoVO.class, "sheet1_"));
		}else if(command.isCommand(FormCommand.MODIFY04)) {
			event.setModifySiValAutoVO((ModifySiValAutoVO)getVO(request, ModifySiValAutoVO .class));
		}
		else if(command.isCommand(FormCommand.MODIFY05)) {
			event.setXterRqstNoVOs((XterRqstNoVO[])getVOs(request, XterRqstNoVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setXterRqstListInputVO((ExternalRqstListInputVO)getVO(request, ExternalRqstListInputVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setBkgcombovo((BkgComboVO)getVO(request, BkgComboVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setXterRqstListInputVO((ExternalRqstListInputVO)getVO(request, ExternalRqstListInputVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND01)) {
			event.setMsg(request.getParameter("msg"));
			event.setCommit(request.getParameter("commit"));
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