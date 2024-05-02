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
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgTroSpclCgoSeqVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralBookingConductSC로 실행요청<br>
 * - GeneralBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Nam Kyung
 * @see GeneralBookingConductEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0079_02BHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0079_02CHTMLAction 객체를 생성
	 */
	public ESM_BKG_0079_02BHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg007902bEvent event = new EsmBkg007902bEvent();

		String bkgNo = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "bkg_no".trim(), ""));
		event.setBkgNo(bkgNo);
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));

			//2) 화면고정용 Key Value : (io_bnd_cd, rtn_tro_seq)
			event.setBoundCd      (request.getParameter("io_bnd_cd"));    //'O'
			event.setRtnTroFlg    (request.getParameter("rtn_tro_flg"));  //'N' : BC에서 분기(2번째, "Y" call)
			event.setCurrRtnTroFlg(JSPUtil.getNullNoTrim(request.getParameter("curr_rtn_tro_flg")));
			event.setCurrTroSeq   (JSPUtil.getNullNoTrim(request.getParameter("curr_tro_seq")));
        } 
		else if(command.isCommand(FormCommand.SEARCH01)) {
            event.setCntrNo(JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "cntr_no".trim(), "")));
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			//다중처리 : containerVO 사용.------------------------>
			TroVO troVO = new TroVO();
			event.setTroVO(troVO);
			//event.getTroVO().setArrBkgTroVO          ((BkgTroVO[])          getVOs(request, BkgTroVO.class,           "t2bsheet2_"));
			event.getTroVO().setArrTroMstVO          ((TroMstVO[])          getVOs(request, TroMstVO.class,           "t2bsheet2_"));
			event.getTroVO().setArrTroDtlVO          ((TroDtlVO[])          getVOs(request, TroDtlVO.class,           "t2bsheet3_"));
			event.getTroVO().setArrBkgTroSpclCgoSeqVO((BkgTroSpclCgoSeqVO[])getVOs(request, BkgTroSpclCgoSeqVO.class, "t2bsheet4_"));
			//event.getTroVO().setArrBkgTroVOrtn       ((BkgTroVO[])          getVOs(request, BkgTroVO.class,           "t2bsheet2_b_"));
			event.getTroVO().setArrTroMstVOrtn       ((TroMstVO[])          getVOs(request, TroMstVO.class,           "t2bsheet2_b_"));
			event.getTroVO().setArrTroDtlVOrtn       ((TroDtlVO[])          getVOs(request, TroDtlVO.class,           "t2bsheet3_b_"));
			//<--------------------------------------------------

			//-------------------------------------------------->
			// 기타 From관련 param 변환
			//1) BkgBlNoVO setting
			String oldBkgNo     = request.getParameter("oldBkgNo");
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(oldBkgNo);
			event.setBkgBlNoVO(bkgBlNoVO);

			//2) 화면고정용 Key Value : (io_bnd_cd, rtn_tro_seq)
			String ioBndCd   = request.getParameter("io_bnd_cd");
			String rtnTroFlg = request.getParameter("rtn_tro_flg");
			String delFlg    = request.getParameter("f_del_flg");
			event.setBoundCd  (ioBndCd);    //'O'
			event.setRtnTroFlg(rtnTroFlg);  //'N'
			event.setDelFlg   (delFlg); 
			
			event.setCurrRtnTroFlg(JSPUtil.getNullNoTrim(request.getParameter("curr_rtn_tro_flg")));
			event.setCurrTroSeq   (JSPUtil.getNullNoTrim(request.getParameter("curr_tro_seq")));
			//<--------------------------------------------------

			event.getTroVO().setBkgNo    (oldBkgNo);
			event.getTroVO().setIoBndCd  (ioBndCd);
			event.getTroVO().setRtnTroFlg(rtnTroFlg);
		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			//Request 처리
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			
			//2) 화면고정용 Key Value
			event.setRtnTroFlg(request.getParameter("curr_rtn_tro_flg"));
			event.setTroSeq   (request.getParameter("curr_tro_seq"));
			event.setModCd    (request.getParameter("curr_mode_cd"));
			event.setCurrRtnTroFlg(JSPUtil.getNullNoTrim(request.getParameter("curr_rtn_tro_flg")));
			event.setCurrTroSeq   (JSPUtil.getNullNoTrim(request.getParameter("curr_tro_seq")));
			event.setOwnrTrkFlg( Boolean.parseBoolean(request.getParameter("t2_ownr_trk_flg")) ? "Y" : "N");

		} else if(command.isCommand(FormCommand.COMMAND03)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));	
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