/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0229_06HTMLAction.java
*@FileTitle : e-Booking & SI Process Detail(TRO/O)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.22 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EBookingConductSC로 실행요청<br>
 * - EBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jun Yong Jin
 * @see EBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0229_06HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0229_06HTMLAction 객체를 생성
	 */
	public ESM_BKG_0229_06HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg022906Event event = new EsmBkg022906Event();


		if(command.isCommand(FormCommand.DEFAULT)) {
			event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO .class));
		} else if(command.isCommand(FormCommand.SEARCH)) {
			event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO .class));
		} else if(command.isCommand(FormCommand.MULTI)) {
/* 			
			TroVO troVO = new TroVO();
			event.setTroVO(troVO);
			event.getTroVO().setArrTroMstVO   ((TroMstVO[])   getVOs(request, TroMstVO.class,   "sheet3_"));
			event.getTroVO().setArrTroDtlVO   ((TroDtlVO[])   getVOs(request, TroDtlVO.class,   "sheet1_"));
*/ 
            
			//다중처리 : containerVO 사용.------------------------>
			TroVO troVO = new TroVO();
			event.setTroVO(troVO);
			event.getTroVO().setArrTroMstVO((TroMstVO[])getVOs(request, TroMstVO.class, "sheet3_"));
			event.getTroVO().setArrTroDtlVO((TroDtlVO[])getVOs(request, TroDtlVO.class, "sheet1_"));
			//<--------------------------------------------------

			//-------------------------------------------------->
			//BkgBlNoVO setting	
			//event.setSaveTroFlag(request.getParameter("save_tro_flag"));
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));

			//화면고정용 Key Value : (io_bnd_cd, rtn_tro_seq)
            event.setIsEurFlg  (request.getParameter("is_eur_flg"));
			
			String ioBndCd   = request.getParameter("io_bnd_cd");
			String rtnTroFlg = request.getParameter("rtn_tro_flg");
			String delFlg    = request.getParameter("f_del_flg");
			event.setBoundCd  (ioBndCd);    //'O'
			event.setRtnTroFlg(rtnTroFlg);  //'N'
			event.setDelFlg   (delFlg);     //'N'
			
			//CurrSeq 초기화
			event.setCurrTroSeq(JSPUtil.getNullNoTrim(request.getParameter("curr_tro_seq")));	
			//<--------------------------------------------------

			event.getTroVO().setEBkgFlg  ("Y");     //eBooking 여부 : 현재 사용되지않음. 
			event.getTroVO().setBkgNo    (event.getBkgBlNoVO().getBkgNo());
			event.getTroVO().setIoBndCd  (ioBndCd);
			event.getTroVO().setRtnTroFlg(rtnTroFlg);
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