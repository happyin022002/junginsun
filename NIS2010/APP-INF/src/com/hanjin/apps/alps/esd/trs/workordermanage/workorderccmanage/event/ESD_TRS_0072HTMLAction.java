/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0072HTMLAction.java
*@FileTitle : Service Provider로부터 W/O실행 이후 비용 지불을 위한 Invoice를 일괄 Confirm하거나, Confirmed or Interfaced Invoice를 취소하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.14
*@LastModifier : 정상기
*@LastVersion : 1.1
* 2007.04.05 정상기
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2010.12.14  최 선	1.1 [CHM-201007747] W/O CC 상 오류 수정요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderccmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderccmanage.vo.TrsTrspWrkOrdCcEmlVO;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderccmanage.vo.TrsTrspWrkOrdCcFaxVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.workordermanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 workorderccmanageSC로 실행요청<br>
 * - workorderccmanageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author CheongSangKi
 * @see EsdTrs0072Event , ESD_TRS_072EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0072HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_072HTMLAction 객체를 생성
	 */
	public ESD_TRS_0072HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_072Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0072Event event = new EsdTrs0072Event();

		event.setLoginUserOfcCd(JSPUtil.getParameter(request, "LOGIN_USER_OFC_CD", ""));
 		event.setLoginUserId(JSPUtil.getParameter(request, "LOGIN_USER_ID", ""));
		event.setComboSvcProvider(JSPUtil.getParameter(request, "combo_svc_provider", ""));
		event.setControlOfficeCd(JSPUtil.getParameter(request, "control_office_cd", ""));
		event.setLocationCd(JSPUtil.getParameter(request, "location_cd", ""));
		event.setFaxEmailIndicator(JSPUtil.getParameter(request, "FAX_EMAIL_INDICATOR", ""));
		event.setSelectedVndrSeq(JSPUtil.getParameter(request, "SELECTED_VNDR_SEQ", ""));
		event.setSelectedCtrlOfcCd(JSPUtil.getParameter(request, "SELECTED_CTRL_OFC_CD", ""));
		event.setSelectedLocCd(JSPUtil.getParameter(request, "SELECTED_LOC_CD", ""));

// 		if(command.isCommand(FormCommand.SEARCH)){
// 		}
// 		else if(command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.SEARCH02)){
// 		}
//		else 
		if(command.isCommand(FormCommand.MULTI)){
		    event.setTrsTrspWrkOrdCcFaxs((TrsTrspWrkOrdCcFaxVO[])getVOs(request, TrsTrspWrkOrdCcFaxVO.class, ""));
		    event.setTrsTrspWrkOrdCcEmls((TrsTrspWrkOrdCcEmlVO[])getVOs(request, TrsTrspWrkOrdCcEmlVO.class, ""));
		}
		else;
		
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