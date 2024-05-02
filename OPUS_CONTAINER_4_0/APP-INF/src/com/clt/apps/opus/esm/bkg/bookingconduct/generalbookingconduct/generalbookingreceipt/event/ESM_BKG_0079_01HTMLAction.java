/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0079_01HTMLAction.java
*@FileTitle : BKG Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.14 KimByungKyu
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BkgQtyDtlVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.PriRpHdrVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralBookingConductSC로 실행요청<br>
 * - GeneralBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KimByungKyu
 * @see GeneralBookingConductEvent 참조 
 * @since J2EE 1.4
 */

public class ESM_BKG_0079_01HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_BKG_0079_01HTMLAction 객체를 생성
	 */
	public ESM_BKG_0079_01HTMLAction() {} 

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException 
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg007901Event event = new EsmBkg007901Event();
	
		if(command.isCommand(FormCommand.SEARCH)){
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
		}else if(command.isCommand(FormCommand.SEARCHLIST11)){//cmdt 조회
			event.setCmdtCd   (JSPUtil.getParameter(request, "cmdt_cd"));			
		}else if(command.isCommand(FormCommand.SEARCHLIST14)){//customer name 조회
			event.setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd"));
			event.setCustSeq  (JSPUtil.getParameter(request, "cust_seq"));
		}else if(command.isCommand(FormCommand.SEARCH01)){	// container no 조회 for TRS
			event.setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		}else if(command.isCommand(FormCommand.MULTI01)){//save - Create Without Route
			event.setBkgBlNoVO			((BkgBlNoVO)		getVO (request, BkgBlNoVO.class));
			event.setBkgBookingInfoVO	((BkgBookingInfoVO)	getVO (request, BkgBookingInfoVO.class));
			event.setVslSkdVOs			((VslSkdVO[])		getVOs(request, VslSkdVO.class,			"t1sheet2_"));
			event.setBlCustomerInfoVO	((BlCustomerInfoVO)	getVO (request, BlCustomerInfoVO.class));
			event.setBkgQuantityVOs		((BkgQuantityVO[])	getVOs(request, BkgQuantityVO.class,	"t1sheet1_"));
			event.setBkgQtyDtlVOs		((BkgQtyDtlVO[])	getVOs(request, BkgQtyDtlVO.class,		"t1sheet4_"));
			event.setPctlNo  (JSPUtil.getParameter(request, "pctl_no"));	
			event.setCaRsnCd (JSPUtil.getParameter(request, "ca_rsn_cd"));
			event.setCaRemark(JSPUtil.getParameter(request, "ca_remark"));
			event.setBookingSaveValidationVO((BookingSaveValidationVO)getVO(request, BookingSaveValidationVO.class));
		}else if(command.isCommand(FormCommand.MULTI02)){//save - Create With Route
			event.setBkgBlNoVO			((BkgBlNoVO)		getVO (request, BkgBlNoVO.class));
			event.setBkgBookingInfoVO	((BkgBookingInfoVO)	getVO (request, BkgBookingInfoVO.class));
			event.setVslSkdVOs			((VslSkdVO[])		getVOs(request, VslSkdVO.class,			"t1sheet2_"));
			event.setBlCustomerInfoVO	((BlCustomerInfoVO)	getVO (request, BlCustomerInfoVO.class));
			event.setBkgQuantityVOs		((BkgQuantityVO[])	getVOs(request, BkgQuantityVO.class,	"t1sheet1_"));
			event.setBkgQtyDtlVOs		((BkgQtyDtlVO[])	getVOs(request, BkgQtyDtlVO.class,		"t1sheet4_"));
			event.setPctlNo  (JSPUtil.getParameter(request, "pctl_no"));	
			event.setCaRsnCd (JSPUtil.getParameter(request, "ca_rsn_cd"));
			event.setCaRemark(JSPUtil.getParameter(request, "ca_remark"));
			event.setBookingSaveValidationVO((BookingSaveValidationVO)getVO(request, BookingSaveValidationVO.class));
		}else if(command.isCommand(FormCommand.MULTI03)){//save - Modify Without Route
			event.setBkgBlNoVO			((BkgBlNoVO)		getVO (request, BkgBlNoVO.class));
			event.setBkgBookingInfoVO	((BkgBookingInfoVO)	getVO (request, BkgBookingInfoVO.class));
			event.setVslSkdVOs			((VslSkdVO[])		getVOs(request, VslSkdVO.class,			"t1sheet2_"));
			event.setBlCustomerInfoVO	((BlCustomerInfoVO)	getVO (request, BlCustomerInfoVO.class));
			event.setBkgQuantityVOs		((BkgQuantityVO[])	getVOs(request, BkgQuantityVO.class,	"t1sheet1_"));
			event.setBkgQtyDtlVOs		((BkgQtyDtlVO[])	getVOs(request, BkgQtyDtlVO.class,		"t1sheet4_"));
			event.setPctlNo(JSPUtil.getParameter(request, "pctl_no"));
			event.setBookingSaveValidationVO((BookingSaveValidationVO)getVO(request, BookingSaveValidationVO.class));
		}else if(command.isCommand(FormCommand.MULTI04)){//save - Modify With Route
			event.setBkgBlNoVO			((BkgBlNoVO)		getVO (request, BkgBlNoVO.class));
			event.setBkgBookingInfoVO	((BkgBookingInfoVO)	getVO (request, BkgBookingInfoVO.class));
			event.setVslSkdVOs			((VslSkdVO[])		getVOs(request, VslSkdVO.class,			"t1sheet2_"));
			event.setBlCustomerInfoVO	((BlCustomerInfoVO)	getVO (request, BlCustomerInfoVO.class));
			event.setBkgQuantityVOs		((BkgQuantityVO[])	getVOs(request, BkgQuantityVO.class,	"t1sheet1_"));
			event.setBkgQtyDtlVOs		((BkgQtyDtlVO[])	getVOs(request, BkgQtyDtlVO.class,		"t1sheet4_"));
			event.setPctlNo(JSPUtil.getParameter(request, "pctl_no"));
			event.setBookingSaveValidationVO((BookingSaveValidationVO)getVO(request, BookingSaveValidationVO.class));
		}else if(command.isCommand(FormCommand.COMMAND03)){//split list 조회
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
		}else if(command.isCommand(FormCommand.MODIFY04)){//Waiting -> Firm
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setNewStsCd(JSPUtil.getParameter(request, "newStsCd"));		
		}else if(command.isCommand(FormCommand.MODIFY05)){//Firm -> Waiting
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setNewStsCd(JSPUtil.getParameter(request, "newStsCd"));		
		}else if(command.isCommand(FormCommand.MODIFY06)){ //cancel
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));			
			event.setBookingSaveValidationVO((BookingSaveValidationVO)getVO(request, BookingSaveValidationVO.class));
		}else if(command.isCommand(FormCommand.COMMAND04)){// save - check Black Customer
			event.setBlCustomerInfoVO	((BlCustomerInfoVO)	getVO (request, BlCustomerInfoVO.class));
		}else if(command.isCommand(FormCommand.SEARCH02)){// SC, RFA, TAA no -> CNPT 정보 조회
			event.setPriRpHdrVO((PriRpHdrVO)getVO(request, PriRpHdrVO.class));
		}else if(command.isCommand(FormCommand.SEARCH04)){ /* 도요타 B/L No 체크 */
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
		}else if(command.isCommand(FormCommand.MODIFY07)){ //Cust Remark Save
			event.setBkgBookingInfoVO((BkgBookingInfoVO)getVO(request, BkgBookingInfoVO.class));
		}
		
		/* Booking Creation Save QtyDtl Data null */
		try{
			if((event.getBkgQtyDtlVOs() == null || event.getBkgQtyDtlVOs().length == 0) && 
					(command.isCommand(FormCommand.MULTI01)||command.isCommand(FormCommand.MULTI02)||
							command.isCommand(FormCommand.MULTI03)||command.isCommand(FormCommand.MULTI04))){
				log.error("===== Booking Creation Save QtyDtl Data =====");
				String[] tmp = request.getParameterValues("t1sheet4_ibflag");
				if(tmp == null) log.error("t1sheet4_ibflag : " + tmp);
				else log.error("t1sheet4_ibflag : " + tmp.length);
				log.error("User-Agent : " + request.getHeader("User-Agent"));
			}
		}catch(Exception e){log.error(e);}
		
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