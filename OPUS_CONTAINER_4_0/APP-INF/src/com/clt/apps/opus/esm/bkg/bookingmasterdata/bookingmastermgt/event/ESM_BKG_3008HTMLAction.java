/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1060HTMLAction.java
*@FileTitle : Manual Booking Number Create
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.09.18 민동진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ChnMnlBkgNoGenCondVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BkgChnBkgNoGenVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingmasterdata 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingMasterDataSC로 실행요청<br>
 * - BookingMasterDataSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Min, DongJin
 * @see BookingMasterDataEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_3008HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1060HTMLAction 객체를 생성
	 */
	public ESM_BKG_3008HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BookingMasterDataEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg3008Event event = new EsmBkg3008Event();

		ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO = new ChnMnlBkgNoGenCondVO();
		chnMnlBkgNoGenCondVO.fromRequest(request);
		if(command.isCommand(FormCommand.MULTI)) {
			
			event.setChnMnlBkgNoGenCondVO(chnMnlBkgNoGenCondVO);
			event.setBkgChnBkgNoGenVOs((BkgChnBkgNoGenVO[])getVOs(request, BkgChnBkgNoGenVO.class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setChnMnlBkgNoGenCondVO(chnMnlBkgNoGenCondVO);
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