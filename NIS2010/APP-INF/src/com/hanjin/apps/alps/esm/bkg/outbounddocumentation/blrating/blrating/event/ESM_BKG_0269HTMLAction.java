/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0269HTMLAction.java
*@FileTitle : Freight & Charge_S/C Information
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

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
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

public class ESM_BKG_0269HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0269HTMLAction 객체를 생성
	 */
	public ESM_BKG_0269HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BlRatingEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0269Event event = new EsmBkg0269Event();

		if(command.isCommand(FormCommand.SEARCH)) {

			ScInformInVO scInformInVO = (ScInformInVO)getVO(request, ScInformInVO .class);
			String application_date = JSPUtil.getParameter(request, "application_date");
			scInformInVO.setStartDate(application_date+"000000");
			scInformInVO.setEndDate(application_date+"235959");
			String caflag = JSPUtil.getParameter(request, "ca_flg");
			event.setCaflag(caflag);
			event.setScInformInVO(scInformInVO);

		}else if(command.isCommand(FormCommand.SEARCH01)) {

			ScInformInVO scInformInVO = (ScInformInVO)getVO(request, ScInformInVO .class);
			String bkg_no = JSPUtil.getParameter(request, "bkg_no");
			String caflag = JSPUtil.getParameter(request, "ca_flg");
			String scpcd = JSPUtil.getParameter(request,  "frm_svc_scp_cd");
			String cmdtcd = JSPUtil.getParameter(request, "frm_cmdt_cd");
			String rtaplydt = JSPUtil.getParameter(request, "application_date");
			String rtAudTpCd = JSPUtil.getParameter(request, "rt_aud_tp_cd"); 
			String scNo = JSPUtil.getParameter(request, "sc_no");
			event.setBkg_no(bkg_no);
			event.setCaflag(caflag);
			event.setScpcd(scpcd);
			event.setCmdtcd(cmdtcd);
			event.setrtAplyDt(rtaplydt);
			event.setRtAudTpCd(rtAudTpCd);
			event.setscNo(scNo);
			event.setScInformInVO(scInformInVO);
			
		}else if(command.isCommand(FormCommand.MULTI)){ // Surcharge 부분을 위해서 Multi로 받아 임시테이블에 저장함 

			SearchScOftAutoratingListVO[] sc = (SearchScOftAutoratingListVO[])getVOs(request, SearchScOftAutoratingListVO .class,"");
			String bkg_no = JSPUtil.getParameter(request, "bkg_no");
			String caflag = JSPUtil.getParameter(request, "ca_flg");
			String scpcd = JSPUtil.getParameter(request,  "frm_svc_scp_cd");
			String cmdtcd = JSPUtil.getParameter(request, "frm_cmdt_cd");
			String ctrtTpCd = JSPUtil.getParameter(request, "ctrt_tp_cd");
			String rtaplydt = JSPUtil.getParameter(request, "application_date");
			String rtAudTpCd = JSPUtil.getParameter(request, "rt_aud_tp_cd"); 
			String scNo = JSPUtil.getParameter(request, "sc_no");
			String frtTermCd = JSPUtil.getParameter(request,"term_cd");
			event.setBkg_no(bkg_no);
			event.setCaflag(caflag);
			event.setScpcd(scpcd);
			event.setCmdtcd(cmdtcd);
			event.setctrtTpCd(ctrtTpCd);
			event.setrtAplyDt(rtaplydt);
			event.setRtAudTpCd(rtAudTpCd);
			event.setscNo(scNo);
			event.setfrtTermCd(frtTermCd);
			event.setSearchScOftAutoratingListVOS(sc);

		}
		else if (command.isCommand(FormCommand.SEARCH02)){
			
			//ScInformInVO scInformInVO = (ScInformInVO)getVO(request, ScInformInVO .class);
			String cmdtcd = JSPUtil.getParameter(request, "frm_cmdt_cd");

			event.setCmdtcd(cmdtcd);

		}
		// Close 버튼을 눌렀을 경우 Surcharge 조회 하여 적용 한다
		else if (command.isCommand(FormCommand.SEARCH03)){
			SearchScOftAutoratingListVO[] sc = (SearchScOftAutoratingListVO[])getVOs(request, SearchScOftAutoratingListVO .class,"");
			
			String bkg_no = JSPUtil.getParameter(request, "bkg_no");
			String caflag = JSPUtil.getParameter(request, "ca_flg");
			String scpcd = JSPUtil.getParameter(request,  "frm_svc_scp_cd");
			String cmdtcd = JSPUtil.getParameter(request, "frm_cmdt_cd");
			String ctrtTpCd = JSPUtil.getParameter(request, "ctrt_tp_cd");
			String rtaplydt = JSPUtil.getParameter(request, "application_date");
			String rtAudTpCd = JSPUtil.getParameter(request, "rt_aud_tp_cd"); 
			String frtTermCd = JSPUtil.getParameter(request,"frt_term_cd");
			String scNo = JSPUtil.getParameter(request, "sc_no");
			event.setBkg_no(bkg_no);
			event.setCaflag(caflag);
			event.setScpcd(scpcd);
			event.setCmdtcd(cmdtcd);
			event.setctrtTpCd(ctrtTpCd);
			event.setrtAplyDt(rtaplydt);
			event.setRtAudTpCd(rtAudTpCd);
			event.setfrtTermCd(frtTermCd);
			event.setscNo(scNo);
			event.setSearchScOftAutoratingListVOS(sc);
		}
		else if (command.isCommand(FormCommand.SEARCH04)){
			String bl_no = JSPUtil.getParameter(request, "bl_no");
			String caflag = JSPUtil.getParameter(request, "ca_flg");
			String scNo = JSPUtil.getParameter(request, "sc_no");
			String scpcd = JSPUtil.getParameter(request,  "frm_svc_scp_cd");
			event.setBl_no(bl_no);
			event.setCaflag(caflag);
			event.setscNo(scNo);
			event.setScpcd(scpcd);
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