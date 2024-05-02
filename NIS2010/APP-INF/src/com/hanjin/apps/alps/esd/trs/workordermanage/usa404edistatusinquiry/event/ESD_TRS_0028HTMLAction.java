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
package com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0028Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.vo.Multi01USA404EDIStatusInquiryVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TrsTrspEdiRailOrdVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.workordermanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WorkOrderManageSC로 실행요청<br>
 * - WorkOrderManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author kim_sang_geun
 * @see EsdTrs0028Event 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0028HTMLAction extends HTMLActionSupport {

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
		String radDate 			= JSPUtil.getParameter(request, "hid_rad_date", "");
		String frmDate 			= JSPUtil.getParameter(request, "hid_frmdate", "");
		String toDate 			= JSPUtil.getParameter(request, "hid_todate", "");
		String frmNode  		= JSPUtil.getParameter(request, "frm_node") + JSPUtil.getParameter(request, "frm_yard", "");
		String toNode   		= JSPUtil.getParameter(request, "to_node") +JSPUtil.getParameter(request, "to_yard", "");
		String radVendor		= JSPUtil.getParameter(request, "hid_rad_vendor", "");
		String svcProvid		= JSPUtil.getParameter(request, "combo_svc_provider", "");
		String trunkVvd 		= JSPUtil.getParameter(request, "trunk_vvd", "");
		String bkgNo    		= JSPUtil.getParameter(request, "bkg_no", "");
		String billNo   		= JSPUtil.getParameter(request, "bill_no", "");
		String cntrNo   		= JSPUtil.getParameter(request, "cntr_no", "");
		String status   		= JSPUtil.getParameter(request, "sel_status", "");
		String edKind   		= JSPUtil.getParameter(request, "sel_edi_kind", "");
		String fuEmpy   		= JSPUtil.getParameter(request, "sel_full_empty", "");
		String bound     		= JSPUtil.getParameter(request, "sel_bnd", "");
		String liminq    		= JSPUtil.getParameter(request, "sel_Limit_inq", "");
		String through   		= JSPUtil.getParameter(request, "rad_through", "");
		String ctrlOfcCd 		= JSPUtil.getParameter(request, "ctrl_ofc_cd", ""); 
//		ctrlOfcCd				= "NYCNOG".equals(ctrlOfcCd) ? "PHXSC" : ctrlOfcCd;
		ctrlOfcCd				= "NYCRAO".equals(ctrlOfcCd) ? "PHXSA" : ctrlOfcCd;
		String incHistory 		= JSPUtil.getParameter(request, "edi_history", "");
		String railRoad 		= JSPUtil.getParameter(request, "sel_railroad", "");
		String bkgAtch 			= JSPUtil.getParameter(request, "sel_Bkgatch", "");
		String userId			= "";
		if(command.isCommand(FormCommand.MULTI04) || command.isCommand(FormCommand.MULTI01)){
			userId 			= JSPUtil.getParameter(request, "ctrl_user_id", "");			
		}else{			
			userId 			= JSPUtil.getParameter(request, "user_id", "");
		}
		
		event.setRadDate(radDate);
  	    event.setFrmDate(frmDate);
  	    event.setToDate(toDate);
  	    event.setFrmNode(frmNode);
  	    event.setToNode(toNode);
  	    event.setRadVendor(radVendor);
  	    event.setSvcProvid(svcProvid);
  	    event.setTrunkVvd(trunkVvd);
	    event.setBkgNo(bkgNo);
	    event.setBillNo(billNo);
	    event.setCntrNo(cntrNo);
	    event.setStatus(status);
	    event.setEdKind(edKind);	    
	    event.setFuEmpy(fuEmpy);
  	    event.setBound(bound);
  	    event.setLiminq(liminq);
  	    event.setThrough(through);
  	    event.setCtrlOfcCd(ctrlOfcCd);
  	    event.setIncHistory(incHistory);
  	    event.setRailRoad(railRoad);
	    event.setBkgAtch(bkgAtch);
	    event.setUserId(userId);
	    
	    event.setTrsTrspEdiRailOrdVos((TrsTrspEdiRailOrdVO[])getVOs(request, TrsTrspEdiRailOrdVO.class, ""));
	    
	    //20090902 Confirmation MSG Send Retrieve
	    String sTrspSoOfcCtyCd = JSPUtil.getNull(request.getParameter("f_trsp_so_ofc_cty_cd"));
	    String sTrspSoSeq      = JSPUtil.getNull(request.getParameter("f_trsp_so_seq"));
	    if (command.isCommand(FormCommand.SEARCH02)) {
	    	event.setFTrspSoOfcCtyCd(sTrspSoOfcCtyCd);
	    	event.setFTrspSoSeq(sTrspSoSeq);
	    }else if (command.isCommand(FormCommand.MULTI01)) {
	    	//20090908 Confirmation MSG Send Save
	    	event.setConfirmationMsgSendVos((Multi01USA404EDIStatusInquiryVO[])getVOs(request, Multi01USA404EDIStatusInquiryVO.class));
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