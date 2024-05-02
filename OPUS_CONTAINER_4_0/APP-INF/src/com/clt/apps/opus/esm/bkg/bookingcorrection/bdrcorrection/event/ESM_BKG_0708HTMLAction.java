/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0708HTMLAction.java
*@FileTitle : C/A Issue Reason Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.31 이남경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
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
 * @author Lee Nam Kyung
 * @see GeneralBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0708HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0708HTMLAction 객체를 생성
	 */
	public ESM_BKG_0708HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0708Event event = new EsmBkg0708Event();
		
		event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
		event.setModeCd   (JSPUtil.getNullNoTrim(request.getParameter("mode_cd")));
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));	
		} 
		else if(command.isCommand(FormCommand.MULTI)) {  //startCA
			event.setBkgBlNoVO   ((BkgBlNoVO)getVO(request, BkgBlNoVO.class));	
			event.setModeCd      (JSPUtil.getNullNoTrim(request.getParameter("mode_cd")));
			event.setCaRsnCD     (JSPUtil.getNullNoTrim(request.getParameter("ca_rsn_cd")));
			event.setBkgCorrRmk  (JSPUtil.getNullNoTrim(request.getParameter("bkg_corr_rmk")));
			event.setRdnNo      (JSPUtil.getNullNoTrim(request.getParameter("rdn_no")));
			event.setRvisSeq    (JSPUtil.getNullNoTrim(request.getParameter("rvis_seq")));
			event.setRdnAcptFlg(JSPUtil.getNullNoTrim(request.getParameter("rdn_acpt_flg")));
		}
		else if(command.isCommand(FormCommand.MULTI01)) { //modifyCaReason
			event.setBkgBlNoVO   ((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setCaRsnCD     (JSPUtil.getNullNoTrim(request.getParameter("ca_rsn_cd")));
			event.setBkgCorrRmk  (JSPUtil.getNullNoTrim(request.getParameter("bkg_corr_rmk")));
			event.setRdnNo      (JSPUtil.getNullNoTrim(request.getParameter("rdn_no")));
			event.setRvisSeq    (JSPUtil.getNullNoTrim(request.getParameter("rvis_seq")));
			event.setRdnAcptFlg(JSPUtil.getNullNoTrim(request.getParameter("rdn_acpt_flg")));
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