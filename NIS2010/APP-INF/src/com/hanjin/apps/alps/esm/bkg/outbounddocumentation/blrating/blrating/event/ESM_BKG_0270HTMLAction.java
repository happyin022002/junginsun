/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0270HTMLAction.java
*@FileTitle : Freight & Charge_S/C Note
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.26 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScNoteInVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BlRatingSC로 실행요청<br>
 * - BlRatingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Jin Seo
 * @see BlRatingEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0270HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0270HTMLAction 객체를 생성
	 */
	public ESM_BKG_0270HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BlRatingEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0270Event event = new EsmBkg0270Event();


		if(command.isCommand(FormCommand.SEARCH)) {
			ScNoteInVO scNoteInVO = (ScNoteInVO)getVO(request, ScNoteInVO .class);
			String bkg_no = JSPUtil.getParameter(request, "bkg_no");
			String sc_no = JSPUtil.getParameter(request,"sc_no");
			String svc_scp_cd = JSPUtil.getParameter(request,"svc_scp_cd");
			String prop_no = JSPUtil.getParameter(request,"prop_no");
			String amdt_seq = JSPUtil.getParameter(request,"amdt_seq");
			String gen_spcl_rt_tp_cd = JSPUtil.getParameter(request,"gen_spcl_rt_tp_cd");
			String cmdt_hdr_seq = JSPUtil.getParameter(request,"cmdt_hdr_seq");
			String rout_seq = JSPUtil.getParameter(request,"rout_seq");
			String application_date = JSPUtil.getParameter(request, "application_date");
			scNoteInVO.setStartApplicationdate(application_date+"000000");
			scNoteInVO.setEndApplicationdate(application_date+"235959");
			scNoteInVO.setBkgNo(bkg_no);
			scNoteInVO.setScNo(sc_no);
			scNoteInVO.setSvcScpCd(svc_scp_cd);
			scNoteInVO.setPropNo(prop_no);
			scNoteInVO.setAmdtSeq(amdt_seq);
			scNoteInVO.setGenSpclRtTpCd(gen_spcl_rt_tp_cd);
			scNoteInVO.setCmdtHdrSeq(cmdt_hdr_seq);
			scNoteInVO.setRoutSeq(rout_seq);
			event.setScNoteInVO(scNoteInVO);
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