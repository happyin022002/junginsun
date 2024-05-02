/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0003HTMLAction.java
*@FileTitle : Customer Advisory Send
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.20
*@LastModifier : LeeInYoung
*@LastVersion : 1.0
* 2011.07.20 LeeInYoung
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.04.02 변종건 [CHM-201216424-01] ALPS Customer Advisory 기능 보완 검토 요청 (Template 문서 첨부 등)
* 2012.09.17 김보배 [CHM-201220181] [BKG] ALPS Bkg/Doc Customer Advisory Send 기능 보완 요청 (30초룰 해제)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSchVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSndVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcUploadVO;
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
 * @author LeeInYoung
 * @see GeneralBookingConductEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0003HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0003HTMLAction 객체를 생성
	 */
	public ESM_BKG_0003HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0003Event event = new EsmBkg0003Event();

	   if(command.isCommand(FormCommand.SEARCH)) {
		   event.setBkgCustAvcNtcSchVO((BkgCustAvcNtcSchVO)getVO(request, BkgCustAvcNtcSchVO .class));
		   
	   } else if(command.isCommand(FormCommand.SEARCH01)){
		   event.setCustCntCd(request.getParameter("cust_cnt_cd"));
		   event.setCustSeq(request.getParameter("cust_seq"));
		   
	   } else if(command.isCommand(FormCommand.MULTI) || command.isCommand(FormCommand.MULTI02) || command.isCommand(FormCommand.MULTI03)){
		   event.setOfcCd(request.getParameter("ofc_cd"));
		   event.setUrlPath("http://"+request.getServerName()+":"+request.getServerPort());
		   event.setBkgCustAvcNtcSndVOs((BkgCustAvcNtcSndVO[])getVOs(request, BkgCustAvcNtcSndVO.class, ""));
		   
	   } else if(command.isCommand(FormCommand.MULTI04)) {
		   event.setBkgCustAvcNtcSchVO((BkgCustAvcNtcSchVO)getVO(request, BkgCustAvcNtcSchVO .class));
		   event.setBkgCustAvcNtcUploadVOs((BkgCustAvcNtcUploadVO[])getVOs(request, BkgCustAvcNtcUploadVO.class, "sheet2_"));
	   } else if (command.isCommand(FormCommand.SEARCH02)) {
			// BackEndJob 으로 돌린 후 결과코드 조회
			event.setKey(request.getParameter("key"));		
   	   } else if(command.isCommand(FormCommand.MULTI05)){
			event.setBkgCustAvcNtcSchVO((BkgCustAvcNtcSchVO)getVO(request, BkgCustAvcNtcSchVO .class));
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