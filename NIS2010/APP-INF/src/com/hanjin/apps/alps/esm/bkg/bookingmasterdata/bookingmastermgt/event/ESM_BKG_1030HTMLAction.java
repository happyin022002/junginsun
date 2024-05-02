/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1030HTMLAction.java
*@FileTitle : booking master
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.19 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.MandatoryItemSetupListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMdtItmVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingmasterdata 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingMasterDataSC로 실행요청<br>
 * - BookingMasterDataSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author kang dong yun
 * @see BookingMasterDataEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_1030HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1030HTMLAction 객체를 생성
	 */
	public ESM_BKG_1030HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BookingMasterDataEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1030Event event = new EsmBkg1030Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setMandatoryItemSetupListVOS((MandatoryItemSetupListVO[])getVOs(request, MandatoryItemSetupListVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setBkgMdtItmVO((BkgMdtItmVO)getVO(request, BkgMdtItmVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setCustCd(JSPUtil.getParameter(request, "chk_cust_cd"));
			event.setCustSeq(JSPUtil.getParameter(request, "chk_cust_seq"));
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