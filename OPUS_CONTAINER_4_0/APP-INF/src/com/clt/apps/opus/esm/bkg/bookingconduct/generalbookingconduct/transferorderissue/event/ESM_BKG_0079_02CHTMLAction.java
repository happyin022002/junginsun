/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0079_02CHTMLAction.java
*@FileTitle : TRO(Transportation Request Order) for Inland Haulage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.04.30 이남경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BkgEurTroDgSeqVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralBookingConductSC로 실행요청<br>
 * - GeneralBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Nam Kyung
 * @see GeneralBookingConductEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0079_02CHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0079_02CHTMLAction 객체를 생성
	 */
	public ESM_BKG_0079_02CHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg007902cEvent event = new EsmBkg007902cEvent();

		String bkgNo   = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "bkg_no".trim(),    ""));
		String boundCd = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "io_bnd_cd".trim(), ""));
		event.setBkgNo  (bkgNo);
		event.setBoundCd(boundCd);

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));

			//2) 화면고정용 Key Value : (io_bnd_cd)
			event.setBoundCd(request.getParameter("io_bnd_cd"));  
			//CurrSeq 초기화
			event.setCurrTroSeq   (JSPUtil.getNullNoTrim(request.getParameter("curr_tro_seq")));
			event.setCurrTroSubSeq(JSPUtil.getNullNoTrim(request.getParameter("curr_tro_sub_seq")));
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			//다중처리 : containerVO 사용.------------------------>
			EurTroVO eurTroVO = new EurTroVO();
			event.setEurTroVO(eurTroVO);
			event.getEurTroVO().setArrEurTroMstVO     ((EurTroMstVO[])     getVOs(request, EurTroMstVO.class,      "t2asheet2_"));
			event.getEurTroVO().setArrEurTroDtlVO     ((EurTroDtlVO[])     getVOs(request, EurTroDtlVO.class,      "t2asheet3_"));
			event.getEurTroVO().setArrBkgEurTroDgSeqVO((BkgEurTroDgSeqVO[])getVOs(request, BkgEurTroDgSeqVO.class, "t2asheet4_"));
			//<--------------------------------------------------

			//-------------------------------------------------->
			// 기타 From관련 param 변환 
			//1) BkgBlNoVO setting
			String oldBkgNo     = request.getParameter("oldBkgNo");
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(oldBkgNo);
			event.setBkgBlNoVO(bkgBlNoVO);

			//2) 화면고정용 Key Value : (io_bnd_cd)
			String ioBndCd   = request.getParameter("io_bnd_cd");
			String delFlg    = request.getParameter("f_del_flg");
			event.setBoundCd(ioBndCd); 
			event.setDelFlg   (delFlg); 
			
			//CurrSeq 초기화
			event.setCurrTroSeq   (JSPUtil.getNullNoTrim(request.getParameter("curr_tro_seq")));
			event.setCurrTroSubSeq(JSPUtil.getNullNoTrim(request.getParameter("curr_tro_sub_seq")));
			//<--------------------------------------------------

			event.getEurTroVO().setBkgNo  (oldBkgNo);
			event.getEurTroVO().setIoBndCd(ioBndCd);
		} else if(command.isCommand(FormCommand.COMMAND02)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));	
			event.setBoundCd  (JSPUtil.getNullNoTrim(request.getParameter("io_bnd_cd")));
			event.setFaxNo    (JSPUtil.getNullNoTrim(request.getParameter("fax_no")));
			event.setEml      (JSPUtil.getNullNoTrim(request.getParameter("eml")));
		} else if(command.isCommand(FormCommand.COMMAND03)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));	
		} else if(command.isCommand(FormCommand.COMMAND04)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));	
			event.setCntrNo(JSPUtil.getNullNoTrim(request.getParameter("cntr_no")));
		} else if(command.isCommand(FormCommand.SEARCH02)) {
			//Location validation check
			event.setLocCd(request.getParameter("loc_cd"));  
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