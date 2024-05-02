/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0076HTMLAction.java
*@FileTitle : Booking Combine
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.25 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForCombineVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineByBkgInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineByRouteInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineCommonInputVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralBookingConductSC로 실행요청<br>
 * - GeneralBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jun Yong Jin
 * @see GeneralBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0076HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0076HTMLAction 객체를 생성
	 */
	public ESM_BKG_0076HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0076Event event = new EsmBkg0076Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setCombineCommonInputVO((CombineCommonInputVO)getVO(request, CombineCommonInputVO .class));
			event.setCombineByRouteInputVO((CombineByRouteInputVO)getVO(request, CombineByRouteInputVO .class));
			event.setCombineByBkgInputVOs((CombineByBkgInputVO[])getVOs(request, CombineByBkgInputVO .class,"sheet1_"));
		}else if(command.isCommand(FormCommand.MODIFY01)){
			event.setMstBkgNo(JSPUtil.getParameter(request, "mst_bkg_no"));
			event.setHitchmentYn(JSPUtil.getParameter(request, "hitchment_yn"));
			event.setCaRsnCd(JSPUtil.getParameter(request, "ca_rsn_cd"));
			event.setCaRmk(JSPUtil.getParameter(request, "ca_remark"));
			event.setMessage(JSPUtil.getParameter(request, "message"));
			event.setBkgBlNoVOs((BkgBlNoVO[])getVOs(request, BkgBlNoVO .class,"sheet1_"));
			event.setBkgListForCombineVOs((BkgListForCombineVO[])getVOs(request,BkgListForCombineVO .class,"sheet1_"));
		}else if(command.isCommand(FormCommand.MODIFY02)){
			event.setBkgBlNoVOs((BkgBlNoVO[])getVOs(request, BkgBlNoVO .class,"sheet1_"));
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