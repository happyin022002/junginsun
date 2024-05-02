/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0422HTMLAction.java
*@FileTitle : Queue Detail List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailListVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingreport.performancereport 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingReportSC로 실행요청<br>
 * - BookingReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Gyoung Sub
 * @see EsmBkg0422Event 참조
 * @since J2EE 1.5
 */

public class ESM_BKG_0422HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;
    /**
     * ESM_BKG_0421HTMLAction 객체를 생성
     */
    public ESM_BKG_0422HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsmBkg0422Event로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);

		EsmBkg0422Event event = new EsmBkg0422Event();
		
		if (command.isCommand(FormCommand.SEARCH)){ // Queue History 조회
			event.setInfoVO((DocQueueDetailListVO) getVO(request, DocQueueDetailListVO.class));
		//}else if (command.isCommand(FormCommand.SEARCH01)){//User Group Id Search
		}else if (command.isCommand(FormCommand.MODIFY01)){//User Group Id Search
			event.setInfoVO((DocQueueDetailListVO) getVO(request, DocQueueDetailListVO.class));
		}else if (command.isCommand(FormCommand.MODIFY02)){//User Group Id Search
			event.setInfoVO((DocQueueDetailListVO) getVO(request, DocQueueDetailListVO.class));
		}else if (command.isCommand(FormCommand.SEARCH02)){// 상위 메타정보 조회
			event.setBkgNo(JSPUtil.getParameter(request, "bkg_no"));
			event.setUserPartCd(JSPUtil.getParameter(request, "user_part_cd"));
			event.setSrNo(JSPUtil.getParameter(request, "sr_no"));
			event.setSrKind(JSPUtil.getParameter(request, "sr_kind"));
			event.setSrKndCd(JSPUtil.getParameter(request, "src_cd"));
		}else if (command.isCommand(FormCommand.SEARCH03)){// complete flg 조회
			event.setBkgNo(JSPUtil.getParameter(request, "bkg_no"));
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