/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0154HTMLAction.java
*@FileTitle : Client Default for Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.04 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BkgUsrDfltSetVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingmasterdata 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingMasterDataSC로 실행요청<br>
 * - BookingMasterDataSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Ki Jong
 * @see BookingMasterDataEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0154HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0154HTMLAction 객체를 생성
	 */
	public ESM_BKG_0154HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BookingMasterDataEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0154Event event = new EsmBkg0154Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setBkgUsrDfltSetVO((BkgUsrDfltSetVO)getVO(request, BkgUsrDfltSetVO .class));
	        event.getBkgUsrDfltSetVO().setFwrdFlg(JSPUtil.getParameter(request,"fwrd_flg","N"));
	        event.getBkgUsrDfltSetVO().setRtnCctDpFlg(JSPUtil.getParameter(request,"rtn_cct_dp_flg","N"));
	        event.getBkgUsrDfltSetVO().setTmlCctDpFlg(JSPUtil.getParameter(request,"tml_cct_dp_flg","N"));
	        event.getBkgUsrDfltSetVO().setDocCctDpFlg(JSPUtil.getParameter(request,"doc_cct_dp_flg","N"));
	        event.getBkgUsrDfltSetVO().setXptCstmsCctDpFlg(JSPUtil.getParameter(request,"xpt_cstms_cct_dp_flg","N"));
	        event.getBkgUsrDfltSetVO().setRailCctDpFlg(JSPUtil.getParameter(request,"rail_cct_dp_flg","N"));
	        event.getBkgUsrDfltSetVO().setAnPrnRtFlg(JSPUtil.getParameter(request,"an_prn_rt_flg","N"));
	        event.getBkgUsrDfltSetVO().setDotPrnFlg(JSPUtil.getParameter(request,"dot_prn_flg","N"));
	        event.getBkgUsrDfltSetVO().setDrftBlXchRtDpFlg(JSPUtil.getParameter(request,"drft_bl_xch_rt_dp_flg","N"));
	        event.getBkgUsrDfltSetVO().setDrftBlCallSgnDpFlg(JSPUtil.getParameter(request,"drft_bl_call_sgn_dp_flg","N"));
	        event.getBkgUsrDfltSetVO().setDrftBlMrnNoDpFlg(JSPUtil.getParameter(request,"drft_bl_mrn_no_dp_flg","N"));
	        
	        event.getBkgUsrDfltSetVO().setBkgRctNtcRcvFlg(JSPUtil.getParameter(request,"bkg_rct_ntc_rcv_flg","N"));
	        event.getBkgUsrDfltSetVO().setMtyRlseOrdRcvFlg(JSPUtil.getParameter(request,"mty_rlse_ord_rcv_flg","N"));
	        event.getBkgUsrDfltSetVO().setTroNtcRcvFlg(JSPUtil.getParameter(request,"tro_ntc_rcv_flg","N"));
	        event.getBkgUsrDfltSetVO().setDrftWblRcvFlg(JSPUtil.getParameter(request,"drft_wbl_rcv_flg","N"));
	        event.getBkgUsrDfltSetVO().setSrndNtcRcvFlg(JSPUtil.getParameter(request,"srnd_ntc_rcv_flg","N"));
	        event.getBkgUsrDfltSetVO().setAnRcvFlg(JSPUtil.getParameter(request,"an_rcv_flg","N"));
	        
	        event.getBkgUsrDfltSetVO().setEurCgorFlg(JSPUtil.getParameter(request,"eur_cgor_flg","N"));
	        event.getBkgUsrDfltSetVO().setFcntrRlseFlg(JSPUtil.getParameter(request,"fcntr_rlse_flg","N"));
	        event.getBkgUsrDfltSetVO().setBlPrnChgTpCd(JSPUtil.getParameter(request,"bl_prn_chg_tp_cd",""));
	        
	        
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setBkgUsrDfltSetVO((BkgUsrDfltSetVO)getVO(request, BkgUsrDfltSetVO .class));
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