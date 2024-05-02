/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1140HTMLAction.java
*@FileTitle : Correction Change 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.14
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.10.14 김태경
* 1.0 Creation
* 2011.10.18 조원주 [CHM-201113594] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 개발요구사항 송부
 * 2011.11.30 정선용 [CHM-201114554-01] DPCS-Correction 기능 보완 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BkgCorrCngDpcsUsrVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingReportSC로 실행요청<br>
 * - BookingReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Gyoung Sub
 * @see EsmBkg1140Event 참조
 * @since J2EE 1.5
 */

public class ESM_BKG_1140HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;
    /**
     * ESM_BKG_1140HTMLAction 객체를 생성
     */
    public ESM_BKG_1140HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsmBkg1140Event로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);

		EsmBkg1140Event event = new EsmBkg1140Event();
		
		if (command.isCommand(FormCommand.SEARCH)){
			event.setBkgCorrCngDpcsUsrVO((BkgCorrCngDpcsUsrVO) getVO(request, BkgCorrCngDpcsUsrVO.class));
		}else if (command.isCommand(FormCommand.MODIFY01)){
			event.setInfoVO((BkgCorrCngDpcsUsrVO) getVO(request, BkgCorrCngDpcsUsrVO.class));
			event.setDocQueueDetailListVO((DocQueueDetailListVO) getVO(request, DocQueueDetailListVO.class));
		}
		request.setAttribute("Event", event);

		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param eventResponse
	 *            EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param event
	 *            Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}