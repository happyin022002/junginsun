/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0589HTMLAction.java
*@FileTitle : User Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.08
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2011.11.08 정선용
* 1.0 Creation
* 2011.11.29 정선용 [CHM-201113753-01] Split 01-Korea CLL 전송 후 변동사항 발생 시 SMS 자동 발송 기능 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.bookingmasterdata 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingMasterDataSC로 실행요청<br>
 * - BookingMasterDataSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Ki Jong
 * @see BookingMasterDataEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0589HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0589HTMLAction 객체를 생성
	 */
	public ESM_BKG_0589HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BookingMasterDataEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0589Event event = new EsmBkg0589Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			log.debug(request.getParameter("ibflag"));
			event.setBkgUserSmsListVOs((BkgUserSmsListVO[])getVOs(request, BkgUserSmsListVO .class,""));
		} else if(command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH02)) {
//			String usr_id = JSPUtil.getParameter(request, "usr_id");
//			String dpcs_wrk_grp_cd = JSPUtil.getParameter(request, "dpcs_wrk_grp_cd");
//			event.setUsrId(usr_id);
//			event.setDpcsWrkGrpCd(dpcs_wrk_grp_cd);
			event.setBkgUserSmsInputVO((BkgUserSmsInputVO)getVO(request, BkgUserSmsInputVO .class));
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