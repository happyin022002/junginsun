/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0229HTMLAction.java
*@FileTitle : e-Booking & SI Process Detail(BOOKING)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.07.02 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

//import java.util.ArrayList;
//import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EBookingConductSC로 실행요청<br>
 * - EBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jun Yong Jin
 * @see EBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0229_01HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0229HTMLAction 객체를 생성
	 */
	public ESM_BKG_0229_01HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg022901Event event = new EsmBkg022901Event();

		if(command.isCommand(FormCommand.DEFAULT)||command.isCommand(FormCommand.SEARCH)) {// 기본 조회
			event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO.class));
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request,BkgBlNoVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) { // cmdt_name
			event.setCmdtCd(request.getParameter("cmdt_cd"));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) { // vessel name
			event.setBkgTrunkVvd(request.getParameter("bkg_trunk_vvd"));	
		}
//		else if(command.isCommand(FormCommand.SEARCH03)) { //find bkg -> search04로 변경
//			event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO.class));
//			event.setBkgBlNoVO((BkgBlNoVO)getVO(request,BkgBlNoVO.class));
//		}
		else if(command.isCommand(FormCommand.SEARCH04)) {//find bkg
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request,BkgBlNoVO.class));
		}
		else if(command.isCommand(FormCommand.MODIFY01) || command.isCommand(FormCommand.MODIFY02)) {//reinstate/ cancel
			event.setXterRqstNoVOs((XterRqstNoVO[])getVOs(request, XterRqstNoVO.class, "sheet4_"));
		} 
		else if(command.isCommand(FormCommand.COMMAND04)) { // black customer check
			event.setBlCustomerInfoVO((BlCustomerInfoVO)getVO(request, BlCustomerInfoVO.class));
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