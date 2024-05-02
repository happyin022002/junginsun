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
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurPayerVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroCfmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroListForCfmVO;
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

public class ESM_BKG_0906HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0906HTMLAction 객체를 생성
	 */
	public ESM_BKG_0906HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0906Event event = new EsmBkg0906Event();

		String bkgNo   = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "bkg_no".trim(),       ""));
		String ioBndCd = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "io_bnd_cd".trim(),    ""));
		event.setBkgNo  (bkgNo);
		event.setIoBndCd(ioBndCd);

		if(command.isCommand(FormCommand.SEARCH)) {
	    	event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
	    	event.setIoBndCd(JSPUtil.getNullNoTrim(request.getParameter("io_bnd_cd")));
		}
	    else if(command.isCommand(FormCommand.MULTI)) {
	    	TroCfmVO troCfmVO = new TroCfmVO();
			event.setTroCfmVO(troCfmVO);
						
//			String boundCd = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "io_bnd_cd".trim(),    ""));			
			//if ("I".equals(boundCd)) { //by 신자영  2010.02.18 I/O통합 
				EurPayerVO eurPayerVO = new EurPayerVO();
				String cctOfcCd    = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "cct_ofc_cd".trim(),   ""));
				String payerCntCd  = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "payer_cnt_cd".trim(), ""));
				String payerSeq    = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "payer_seq".trim(),    ""));
				String fBkgNo      = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "bkg_no".trim(),       ""));
				eurPayerVO.setCctOfcCd   (cctOfcCd);
				eurPayerVO.setPayerCntCd (payerCntCd);
				eurPayerVO.setPayerSeq   (payerSeq);
				eurPayerVO.setBkgNo      (fBkgNo);
				eurPayerVO.setIoBndCd(ioBndCd);//by 신자영  2010.02.18 I/O통합 
				event.getTroCfmVO().setEurPayerVO(eurPayerVO);
			//}

			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.getTroCfmVO().setArrTroListForCfmVO((TroListForCfmVO[])getVOs(request, TroListForCfmVO.class, "sheet1_"));    	
	    }
	    else if(command.isCommand(FormCommand.COMMAND01)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
		}
	    else if(command.isCommand(FormCommand.MULTI01)) {
	    	TroCfmVO troCfmVO = new TroCfmVO();
			event.setTroCfmVO(troCfmVO);
						
			String boundCd = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "io_bnd_cd".trim(),    ""));			
			if ("I".equals(boundCd)) {
				EurPayerVO eurPayerVO = new EurPayerVO();
				String cctOfcCd    = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "cct_ofc_cd".trim(),   ""));
				String payerCntCd  = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "payer_cnt_cd".trim(), ""));
				String payerSeq    = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "payer_seq".trim(),    ""));
				String fBkgNo      = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "bkg_no".trim(),       ""));
				eurPayerVO.setCctOfcCd   (cctOfcCd);
				eurPayerVO.setPayerCntCd (payerCntCd);
				eurPayerVO.setPayerSeq   (payerSeq);
				eurPayerVO.setBkgNo      (fBkgNo);
				event.getTroCfmVO().setEurPayerVO(eurPayerVO);
				event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			}
			
			event.getTroCfmVO().setArrTroListForCfmVO((TroListForCfmVO[])getVOs(request, TroListForCfmVO.class, "sheet1_"));    	
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