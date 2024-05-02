/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0430HTMLAction.java
*@FileTitle : CNTR History Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.05.08 우경민
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.07.21 나상보 [CHM-201111948] [CTM] TS화물 VL/VD 추가 Insert 예외처리
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EquipmentMovementMgtSC로 실행요청<br>
 * - EquipmentMovementMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KyungMin Woo
 * @see EquipmentMovementMgtEvent 참조
 * @since J2EE 1.4
 */
public class EES_CTM_0430HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CTM_0430HTMLAction 객체를 생성
	 */
	public EES_CTM_0430HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EquipmentMovementMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EesCtm0430Event event = new EesCtm0430Event();

		if (command.isCommand(FormCommand.MULTI)) {
			event.setCtmMovementVOS((MVMTBookingInfoVO[])getVOs(request, MVMTBookingInfoVO.class,""));
			event.setCusCtmMovementVOS((CusCtmMovementVO[])getVOs(request, CusCtmMovementVO.class,""));
		} else if (command.isCommand(FormCommand.SEARCH)) {
			event.setCtmMovementVO((MVMTBookingInfoVO)getVO(request, MVMTBookingInfoVO.class));
			event.setMVMTHistoryListVO((MVMTHistoryListVO)getVO(request, MVMTHistoryListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH01)) {
			event.setMVMTHistoryListVO((MVMTHistoryListVO)getVO(request, MVMTHistoryListVO .class));
		} else if (command.isCommand(FormCommand.SEARCH02)) { 
			event.setBkgNo(request.getParameter("bkg_no"));
			event.setCntrId(request.getParameter("cntr_id"));
		} else if (command.isCommand(FormCommand.SEARCH03)) {
			event.setCtmMovementVO((MVMTBookingInfoVO)getVO(request, MVMTBookingInfoVO.class));
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