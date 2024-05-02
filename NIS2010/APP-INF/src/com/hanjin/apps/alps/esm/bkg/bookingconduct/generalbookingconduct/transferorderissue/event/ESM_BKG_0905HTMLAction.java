/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0905HTMLAction.java
*@FileTitle : TRO-Container Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.04.30 이남경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroActCustVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgTroActCustVO;
import com.hanjin.syscommon.common.table.BkgTroActRepVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralBookingConductSC로 실행요청<br>
 * - GeneralBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Nam Kyung
 * @see GeneralBookingConductEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0905HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0905HTMLAction 객체를 생성
	 */
	public ESM_BKG_0905HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0905Event event = new EsmBkg0905Event();

		/* param */
    	String contiCd      = JSPUtil.getParameter(request, "conti_cd",        "");
    	String cntCd        = JSPUtil.getParameter(request, "cnt_cd",          "");
    	String bkgNo        = JSPUtil.getParameter(request, "bkg_no",          "");
    	String dorLocCd     = JSPUtil.getParameter(request, "dor_loc_cd",      "");
    	String actShprCntCd = JSPUtil.getParameter(request, "act_shpr_cnt_cd", "");
    	String actShprSeq   = JSPUtil.getParameter(request, "act_shpr_seq",    "");
    	String actShprNm    = JSPUtil.getParameter(request, "act_shpr_nm",     "");

		try {
			actShprNm = URLDecoder.decode(actShprNm, "MS949");
		} catch (UnsupportedEncodingException e) {
			throw new HTMLActionException(new ErrorHandler("COM12240").getMessage(), e);
		}
    	
    	event.setContiCd(contiCd);
    	event.setCntCd(cntCd);
    	event.setBkgNo(bkgNo);
    	event.setDorLocCd(dorLocCd);
    	event.setActShprCntCd(actShprCntCd);
    	event.setActShprSeq(actShprSeq);
    	event.setActShprNm(actShprNm);
    	
		//containerVO--------------------------------------->
		TroActCustVO troActCustVO = new TroActCustVO();
		event.setTroActCustVO(troActCustVO);
		//<--------------------------------------------------

		if(command.isCommand(FormCommand.SEARCH)) {
			String custCntCd = JSPUtil.getParameter(request, "cust_cnt_cd",     ""); 
			String custSeq   = JSPUtil.getParameter(request, "cust_seq",        "");  
			String custNm    = JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""); 
			event.setCustCntCd(custCntCd);
			event.setCustSeq  (custSeq);
			event.setCustNm   (custNm);	
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			String fCntCd   = request.getParameter("f_cnt_cd");
			String fCustSeq = request.getParameter("f_cust_seq");
			String fOfcCd   = request.getParameter("f_ofc_cd");
			event.setCntCd(fCntCd);
			event.setOfcCd(fOfcCd);
			event.setCustSeq(fCustSeq);
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			String ofcCd  = JSPUtil.getParameter(request, "ofc_cd",         ""); 
			String custNm = JSPUtil.getParameter(request, "tro_act_rep_nm", ""); 
			event.setOfcCd (ofcCd);
			event.setCustNm(custNm);
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			String fOfcCd        = request.getParameter("f_ofc_cd");
			String fTroActRepSeq = request.getParameter("tro_act_rep_seq");
			event.setOfcCd(fOfcCd);
			event.setTroActRepSeq(fTroActRepSeq);
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			String vndrSeq = request.getParameter("vndr_seq");
			event.setCntCd  (cntCd);
			event.setVndrSeq(vndrSeq);
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			String fBkgNo       = JSPUtil.getNullNoTrim(request.getParameter("bkg_no"));
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(fBkgNo);
			event.setBkgBlNoVO(bkgBlNoVO);

			String fDorLocCd = JSPUtil.getNullNoTrim(request.getParameter("dor_loc_cd"));
			event.setDorLocCd(fDorLocCd);
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			event.getTroActCustVO().setBkgTroActCustVOs((BkgTroActCustVO[])getVOs(request, BkgTroActCustVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			//다중처리 : containerVO 사용.------------------------>
			event.getTroActCustVO().setBkgTroActRepVOs ((BkgTroActRepVO[])getVOs (request, BkgTroActRepVO.class,  "t2sheet1_"));
			event.getTroActCustVO().setBkgTroActCustVOs((BkgTroActCustVO[])getVOs(request, BkgTroActCustVO.class, "t2sheet2_"));
			//<--------------------------------------------------
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