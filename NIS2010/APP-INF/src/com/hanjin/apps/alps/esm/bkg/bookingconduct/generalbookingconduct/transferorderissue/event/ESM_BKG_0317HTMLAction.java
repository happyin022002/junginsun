/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0907HTMLAction.java
*@FileTitle : TRO-Container Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.04.30 이남경
* 1.0 Creation
* 2012.06.25 전성진 [CHM-201217633] 구주 Hinterland Operation 개선 Project - T1&Revenue Guideline 적용
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.GlineRevInVO;
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
 * @author Lee Nam Kyung
 * @see GeneralBookingConductEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0317HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0317HTMLAction 객체를 생성
	 */
	public ESM_BKG_0317HTMLAction() {} 

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0317Event event = new EsmBkg0317Event();

		String bkgNo      		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "bkg_no".trim(),        		""));
		String t1DocFlg   		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "t1_doc_flg".trim(),    		""));
		String cstmsClrNo 		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "cstms_clr_no".trim(),  		""));
		String allInRtFlg 		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "all_in_rt_cd".trim(), 		""));
		String currCd     		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "curr_cd".trim(),       		""));
		String trnsRevAmt 		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "trns_rev_amt".trim(),  		""));
		String cxlFlg     		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "cxl_flg".trim(),       		""));
		String vatFlg     		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "vat_flg".trim(),       		""));
		String term       		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "term".trim(),         		""));
		String hlgTpCd    		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "hlg_tp_cd".trim(),     		""));
		String ioBndCd    		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "io_bnd_cd".trim(),     		""));
		String cfmFlg     		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "cfm_flg".trim(),       		""));
		String nonTrnsRevAmt	= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "non_trns_rev_amt".trim(),	""));
		String addRevAmt     	= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "add_rev_amt".trim(),			""));
		String addRevChgCd     	= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "add_rev_chg_cd".trim(),      ""));
		String addRevAmt2     	= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "add_rev_amt2".trim(),		""));
		String addRevChgCd2     = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "add_rev_chg_cd2".trim(),     ""));
		String addRevAmt3     	= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "add_rev_amt3".trim(),		""));
		String addRevChgCd3     = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "add_rev_chg_cd3".trim(),     ""));
		String addRevRmk     	= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "add_rev_rmk".trim(),			""));
		String arbCurrCd     	= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "arb_curr_cd".trim(),      	""));
		String arbRevAmt     	= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "arb_rev_amt".trim(),			""));
		String cntrTpszCd     	= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "cntr_tpsz_cd".trim(),       	""));
		String bsePortLocCd     = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "bse_port_loc_cd".trim(),     ""));
		String pntLocCd     	= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "pnt_loc_cd".trim(),       	""));
		String trspModeCd     	= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "trsp_mode_cd".trim(),       	""));
		String rfFlag     		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "rf_flag".trim(),       		""));
		String dgFlag     		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "dg_flag".trim(),       		""));
		String awkFlag     		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "awk_flag".trim(),       		""));
		String cfmDt     		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "cfm_dt".trim(),       		""));
		String optmStsCd     	= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "optm_sts_cd".trim(),       	""));
		String cntrNo     		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "cntr_no".trim(),       		""));
		String multiRev    		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "multi_rev".trim(),      		""));
		String cgoWgt    		= JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "cgo_wgt".trim(),      		""));
		
		event.setBkgNo     		(bkgNo);
		event.setT1DocFlg  		(t1DocFlg);
		event.setCstmsClrNo		(cstmsClrNo);
		event.setAllInRtFlg		(allInRtFlg);
		event.setCurrCd    		(currCd);
		event.setTrnsRevAmt		(trnsRevAmt);
		event.setVatFlg    		(vatFlg);
		event.setCxlFlg 		(cxlFlg);
		event.setTerm   		(term);
		event.setHlgTpCd   		(hlgTpCd);
		event.setIoBndCd   		(ioBndCd);
		event.setCfmFlg    		(cfmFlg);
		event.setNonTrnsRevAmt	(nonTrnsRevAmt);
		event.setAddRevAmt		(addRevAmt);
		event.setAddRevChgCd	(addRevChgCd);
		event.setAddRevAmt2		(addRevAmt2);
		event.setAddRevChgCd2	(addRevChgCd2);
		event.setAddRevAmt3		(addRevAmt3);
		event.setAddRevChgCd3	(addRevChgCd3);
		event.setAddRevRmk		(addRevRmk);
		event.setArbCurrCd		(arbCurrCd);
		event.setArbRevAmt		(arbRevAmt);
		event.setCntrTpszCd		(cntrTpszCd);
		event.setBsePortLocCd	(bsePortLocCd);
		event.setPntLocCd		(pntLocCd);
		event.setTrspModeCd		(trspModeCd);
		event.setRfFlag			(rfFlag);
		event.setDgFlag			(dgFlag);
		event.setAwkFlag		(awkFlag);
		event.setCfmDt			(cfmDt);
		event.setOptmStsCd		(optmStsCd);
		event.setCntrNo			(cntrNo);
		event.setMultiRev		(multiRev);
		event.setCgoWgt			(cgoWgt);
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setGlineRevInVO((GlineRevInVO)getVO(request, GlineRevInVO.class));	
		}
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setGlineRevInVO((GlineRevInVO)getVO(request, GlineRevInVO.class));	
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