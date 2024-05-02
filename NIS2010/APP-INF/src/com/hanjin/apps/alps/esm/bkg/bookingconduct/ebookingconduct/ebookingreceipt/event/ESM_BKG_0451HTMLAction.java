/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0451HTMLAction.java
*@FileTitle : bookringreport
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.25
*@LastModifier : jsy
*@LastVersion : 1.0
* 2011.08.25 jsy
* 1.0 Creation
* 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchBkgSrProcHisListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.bookingreport 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingReportSC로 실행요청<br>
 * - BookingReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author kang dong yun
 * @see BookingReportEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0451HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0451HTMLAction 객체를 생성
	 */
	public ESM_BKG_0451HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BookingReportEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0451Event event = new EsmBkg0451Event();
		

//		if(command.isCommand(FormCommand.SEARCHLIST01)) {
//			String srMtchStsCd 	= JSPUtil.getParameter(request, "sr_mtch_sts_cd");
//            String fromDt 		= JSPUtil.getParameter(request, "from_dt");
//            String toDt		 	= JSPUtil.getParameter(request, "to_dt");
//            String rcvOfcCd		= JSPUtil.getParameter(request, "rcv_ofc_cd");
//            String srNo			= JSPUtil.getParameter(request, "sr_no");
//            
//            event.setRcvOfcCd(rcvOfcCd);
//            event.setSrMtchStsCd(srMtchStsCd);
//            event.setFromDt(fromDt);
//            event.setToDt(toDt);
//            event.setSrNo(srNo);
//            event.setSearchSRReceivingListVO((SearchSRReceivingListVO)getVO(request, SearchSRReceivingListVO .class));
//            event.setSearchSREmlReceivingListVO((SearchSREmlReceivingListVO)getVO(request, SearchSREmlReceivingListVO .class));
//		}else 
		// ESM_BKG_0488 의 메일탭만 가져옴.
		if(command.isCommand(FormCommand.SEARCH)  ) {
			event.setSearchBkgSrProcHisListVO((SearchBkgSrProcHisListVO)getVO(request, SearchBkgSrProcHisListVO .class));
		} 
//		else if(command.isCommand(FormCommand.MULTI03)) {
//			event.setSearchSREmlReceivingListVOs((SearchSREmlReceivingListVO[])getVOs(request, SearchSREmlReceivingListVO .class));
//		}
//		else if(command.isCommand(FormCommand.MULTI)) {
//			event.setBkgSrFaxVOS((BkgSrFaxVO[])getVOs(request, BkgSrFaxVO .class,"sheet1_"));
//		}else if(command.isCommand(FormCommand.MULTI02)) {
//			event.setBkgSrFaxVOS((BkgSrFaxVO[])getVOs(request, BkgSrFaxVO .class,"sheet2_"));	
//		}else if(command.isCommand(FormCommand.MULTI03)) {
//			event.setBkgSrFaxVOS((BkgSrFaxVO[])getVOs(request, BkgSrFaxVO .class,"sheet2_"));		
//		}else if(command.isCommand(FormCommand.MODIFY)) {
//			
//			String srKndCd 		= JSPUtil.getParameter(request, "sr_knd_cd");
//            String srNo 		= JSPUtil.getParameter(request, "sr_no");
//            String rcvRmk	 	= JSPUtil.getParameter(request, "rcv_rmk");
//            
//            event.setSrKndCd(srKndCd);
//            event.setSrNo(srNo);
//            event.setRcvRmk(rcvRmk);
//		}

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