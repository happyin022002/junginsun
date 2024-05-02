/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0098HTMLAction.java
*@FileTitle : Booking Receipt Notice (Fax/E-Mail)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.09 전용진
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.11.15 이일민 [CHM-201006562-01] Booking Receipt Notice Fax & Email Service 수정 (DOC CCT 추가 및 EDI 기능)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBkgReceiptInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralBookingConductSC로 실행요청<br>
 * - GeneralBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jun Yong Jin
 * @see GeneralBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0098HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0098HTMLAction 객체를 생성
	 */
	public ESM_BKG_0098HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0098Event event = new EsmBkg0098Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setBkgListForBkgReceiptInputVO((BkgListForBkgReceiptInputVO)getVO(request, BkgListForBkgReceiptInputVO .class));
		} else if(command.isCommand(FormCommand.MULTI01)){
			event.setBkgBlNoVOs((BkgBlNoVO[])getVOs(request, BkgBlNoVO.class,"sheet1_"));
			int length = request.getParameterValues("sheet1_ibflag").length;
			event.setFax(JSPUtil.getParameter(request, "sheet1_fax", length));
			event.setRemark(JSPUtil.getParameter(request, "sheet1_remark", length));
			event.setCct(JSPUtil.getParameter(request, "sheet1_cct", length));
			event.setDocCct(JSPUtil.getParameter(request, "sheet1_doc_cct", length));
			event.setMnlRailFromCct(JSPUtil.getParameter(request, "sheet1_mnl_rail_from_cct", length));
			event.setMnlRailToCct(JSPUtil.getParameter(request, "sheet1_mnl_rail_to_cct", length));
			event.setMnlVgmCct(JSPUtil.getParameter(request, "sheet1_mnl_vgm_cct", length));
			event.setMrdNm(JSPUtil.getParameter(request, "mrd"));
		} else if(command.isCommand(FormCommand.MULTI02)){
			event.setBkgBlNoVOs((BkgBlNoVO[])getVOs(request, BkgBlNoVO.class,"sheet1_"));
			int length = request.getParameterValues("sheet1_ibflag").length;
			event.setEml(JSPUtil.getParameter(request, "sheet1_eml", length));
			event.setRemark(JSPUtil.getParameter(request, "sheet1_remark", length));
			event.setCct(JSPUtil.getParameter(request, "sheet1_cct", length));
			event.setDocCct(JSPUtil.getParameter(request, "sheet1_doc_cct", length));
			event.setMnlRailFromCct(JSPUtil.getParameter(request, "sheet1_mnl_rail_from_cct", length));
			event.setMnlRailToCct(JSPUtil.getParameter(request, "sheet1_mnl_rail_to_cct", length));
			event.setMnlVgmCct(JSPUtil.getParameter(request, "sheet1_mnl_vgm_cct", length));
			event.setMrdNm(JSPUtil.getParameter(request, "mrd"));
		} else if(command.isCommand(FormCommand.MULTI03)){
			event.setBkgBlNoVOs((BkgBlNoVO[])getVOs(request, BkgBlNoVO.class,"sheet1_"));
			int length = request.getParameterValues("sheet1_ibflag").length;
			event.setFileKey(request.getParameter("com_fileKey"));
			event.setEml(JSPUtil.getParameter(request, "sheet1_eml", length));
			event.setRemark(JSPUtil.getParameter(request, "sheet1_remark", length));
			event.setCct(JSPUtil.getParameter(request, "sheet1_cct", length));
			event.setDocCct(JSPUtil.getParameter(request, "sheet1_doc_cct", length));
			event.setMnlRailFromCct(JSPUtil.getParameter(request, "sheet1_mnl_rail_from_cct", length));
			event.setMnlRailToCct(JSPUtil.getParameter(request, "sheet1_mnl_rail_to_cct", length));
			event.setMnlVgmCct(JSPUtil.getParameter(request, "sheet1_mnl_vgm_cct", length));
			event.setMrdNm(JSPUtil.getParameter(request, "mrd"));
			event.setBkgEmlEdtVO((BkgEmlEdtVO)getVO(request, BkgEmlEdtVO.class));
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