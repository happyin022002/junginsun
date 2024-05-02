/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0354HTMLAction.java
*@FileTitle : Location of goods Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
* 2012.09.04 변종건 [CHM-201219976-01] Split 01-Canada A/N 수정 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;
import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgcustomscanadagrouplocationVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.bookingmasterdata.bookingmastermgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingMasterDataSC로 실행요청<br>
 * - BookingMasterDataSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Gyoung Sub
 * @see EsmBkg0354Event 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0354HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;
    /**
     * ESM_BKG_0354HTMLAction 객체를 생성
     */
    public ESM_BKG_0354HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 bookingmastermgtEvent로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);

		EsmBkg0354Event event = new EsmBkg0354Event();

		if (command.isCommand(FormCommand.SEARCH))
		{
			// Location of goods Setup 정보 조회
			event.setInfoVO((BkgcustomscanadagrouplocationVO) getVO(request, BkgcustomscanadagrouplocationVO.class));
		}
		else if (command.isCommand(FormCommand.SEARCH01))
		{
			// Location of goods Setup 기 존재여부  조회
			event.setInfoVO((BkgcustomscanadagrouplocationVO) getVO(request, BkgcustomscanadagrouplocationVO.class));
		}
		else if (command.isCommand(FormCommand.SEARCH02))
		{
			// Yard Description 조회
			event.setInfoVO((BkgcustomscanadagrouplocationVO) getVO(request, BkgcustomscanadagrouplocationVO.class));
		}
		else if (command.isCommand(FormCommand.SEARCH03))
		{
			// Yard Description 조회
			event.setInfoVO((BkgcustomscanadagrouplocationVO) getVO(request, BkgcustomscanadagrouplocationVO.class));
		}
		else if (command.isCommand(FormCommand.MULTI))
		{
			// Location of goods Setup정보 수정
			event.setInfoVOs((BkgcustomscanadagrouplocationVO[]) getVOs(request, BkgcustomscanadagrouplocationVO.class, ""));
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