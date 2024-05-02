/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VOP_FCM_0003HTMLAction.java
*@FileTitle : Departure Report PK Error Cleansing
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.18
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslFcmDepRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.SearchVslPortSkdVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRptInqVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.FcmDepRptClsHisVO;
import com.hanjin.syscommon.common.table.FcmDepRptErrVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.vop.fcm.vesselreport 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 VesselReportSC로 실행요청<br>
 * - VesselReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author 
 * @see VesselReportEvent 참조
 * @since J2EE 1.4
 */
public class VOP_FCM_0003HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_FCM_0003HTMLAction 객체를 생성
	 */
	public VOP_FCM_0003HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VSKCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		VopFcm0003Event event = new VopFcm0003Event();	

		if (command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCHLIST)){
			event.setVslRptInqVO((VslRptInqVO)getVO(request, VslRptInqVO.class));
			event.setSearchVslPortSkdVO((SearchVslPortSkdVO)getVO(request, SearchVslPortSkdVO.class));
			
		} else if (command.isCommand(FormCommand.MULTI)) {//FCM_DEP_RPT_ERR, FCM_DEP_RPT_CLS_HIS
			event.setFcmDepRptErrVO((FcmDepRptErrVO)getVO(request, FcmDepRptErrVO.class));
			event.setFcmDepRptClsHisVO((FcmDepRptClsHisVO)getVO(request, FcmDepRptClsHisVO.class));
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