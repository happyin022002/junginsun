package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.AcepChkDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.AcepChkGrpVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.AcepChkHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateINVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

public class EES_MNR_0061HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0061HTMLAction 객체를 생성
	 */
	public EES_MNR_0061HTMLAction() {}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EesMnr0061Event event = new EesMnr0061Event();
		AcepChkGrpVO acepChkGrpVO = new AcepChkGrpVO();
		//조회
		if(command.isCommand(FormCommand.SEARCH)) {
			acepChkGrpVO.setAcepChkHdrVO((AcepChkHdrVO)getVO(request, AcepChkHdrVO.class));
		} else if(command.isCommand(FormCommand.MULTI)) { 
			acepChkGrpVO.setAcepChkHdrVO((AcepChkHdrVO)getVO(request, AcepChkHdrVO .class));
			acepChkGrpVO.setArrAcepChkDtlVOs((AcepChkDtlVO[])getVOs(request,AcepChkDtlVO .class, "sheet1_" ));
		}
		event.setAcepChkGrpVO(acepChkGrpVO);

		return event;
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
