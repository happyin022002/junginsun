/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_TRS_0028HTMLAction.java
 *@FileTitle : USA 404 EDI Status Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-28
 *@LastModifier : kim_sang_geun
 *@LastVersion : 1.0
 * 2006-11-28 kim_sang_geun
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0028Event;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.vo.Multi01USA404EDIStatusInquiryVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.TrsTrspEdiRailOrdVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.workordermanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WorkOrderManageSC로 실행요청<br>
 * - WorkOrderManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author kim_sang_geun
 * @see EsdTrs0028Event 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0028HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 5264037822605772821L;

	/**
	 * ESD_TRS_028HTMLAction 객체를 생성
	 */
	public ESD_TRS_0028HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_028Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0028Event event = new EsdTrs0028Event();
		String userId = "";
		if (command.isCommand(FormCommand.MULTI04) || command.isCommand(FormCommand.MULTI01)) {
			userId = JSPUtil.getParameter(request, "ctrl_user_id");
		} else {
			userId = JSPUtil.getParameter(request, "user_id");
		}
		event.setRadDate(JSPUtil.getParameter(request, "hid_rad_date", ""));
		event.setFrmDate(JSPUtil.getParameter(request, "hid_frmdate", ""));
		event.setToDate(JSPUtil.getParameter(request, "hid_todate", ""));
		event.setFrmNode(JSPUtil.getParameter(request, "frm_node") + JSPUtil.getParameter(request, "frm_yard", ""));
		event.setToNode(JSPUtil.getParameter(request, "to_node") + JSPUtil.getParameter(request, "to_yard", ""));
		event.setRadVendor(JSPUtil.getParameter(request, "hid_rad_vendor", ""));
		event.setSvcProvid(JSPUtil.getParameter(request, "combo_svc_provider", ""));
		event.setTrunkVvd(JSPUtil.getParameter(request, "trunk_vvd", ""));
		event.setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		event.setBillNo(JSPUtil.getParameter(request, "bill_no", ""));
		event.setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		event.setStatus(JSPUtil.getParameter(request, "sel_status", ""));
		event.setEdKind(JSPUtil.getParameter(request, "sel_edi_kind", ""));
		event.setFuEmpy(JSPUtil.getParameter(request, "sel_full_empty", ""));
		event.setBound(JSPUtil.getParameter(request, "sel_bnd", ""));
		event.setLiminq(JSPUtil.getParameter(request, "sel_Limit_inq", ""));
		event.setThrough(JSPUtil.getParameter(request, "rad_through", ""));
		event.setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		event.setIncHistory(JSPUtil.getParameter(request, "edi_history", ""));
		event.setRailRoad(JSPUtil.getParameter(request, "sel_railroad", ""));
		event.setBkgAtch(JSPUtil.getParameter(request, "sel_Bkgatch", ""));
		event.setUserId(userId);
		event.setUnplanned(JSPUtil.getParameter(request, "unplanned", ""));
		event.setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		event.setPodCd(JSPUtil.getParameter(request, "pod_cd"));
		event.setPodNodCd(JSPUtil.getParameter(request, "pod_nod_cd"));
		event.setTrsTrspEdiRailOrdVos((TrsTrspEdiRailOrdVO[]) getVOs(request, TrsTrspEdiRailOrdVO.class, ""));
		if (command.isCommand(FormCommand.SEARCH02)) {
			event.setFTrspSoOfcCtyCd(JSPUtil.getNull(request.getParameter("f_trsp_so_ofc_cty_cd")));
			event.setFTrspSoSeq(JSPUtil.getNull(request.getParameter("f_trsp_so_seq")));
		} else if (command.isCommand(FormCommand.MULTI01)) {
			event.setConfirmationMsgSendVos((Multi01USA404EDIStatusInquiryVO[]) getVOs(request, Multi01USA404EDIStatusInquiryVO.class));
		} else if (command.isCommand(FormCommand.SEARCH01)) {
			event.setVndrSeq(JSPUtil.getNull(request.getParameter("vndr_seq")));
		}
		request.setAttribute("Event", event);
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