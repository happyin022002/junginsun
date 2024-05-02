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
* -------------------------------------------------------
* HISTORY
* 2011.05.11 이일민 [CHM-201110114] BKG Charge Screen 상 운임회수 점소 pre-paid office was auto-changed as booking office again
* 2011.08.02 김봉균 [CHM-201112282-01] 중국 Solid Waste 관련 bkg commodity validation 추가
* 2014.08.29 문동선 [CHM-201431517] Pre-Caution 반영 Alert 메세지 생성 로직 삽입 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgQtyDtlVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
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
		}else if(command.isCommand(FormCommand.COMMAND04) || command.isCommand(FormCommand.COMMAND09)){// save - check Black Customer
			event.setBlCustomerInfoVO	((BlCustomerInfoVO)	getVO (request, BlCustomerInfoVO.class));
			event.setBkgBookingInfoVO	((BkgBookingInfoVO)	getVO (request, BkgBookingInfoVO.class));
		} else if (command.isCommand(FormCommand.SEARCH02) || command.isCommand(FormCommand.MODIFY07)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
		}else if(command.isCommand(FormCommand.COMMAND05) || command.isCommand(FormCommand.COMMAND07)){ //2011.08.02 중국 Solid Waste 관련 bkg commodity validation 추가
			event.setCmdtCd   (JSPUtil.getParameter(request, "cmdt_cd"));
		}else if(command.isCommand(FormCommand.COMMAND06)){
			event.setBkgBlNoVO((BkgBlNoVO)getVO (request, BkgBlNoVO.class));
			event.setVslSkdVOs((VslSkdVO[])getVOs(request, VslSkdVO.class, "t1sheet2_"));
		}else if(command.isCommand(FormCommand.COMMAND08)){
			event.setBkgBookingInfoVO	((BkgBookingInfoVO)	getVO (request, BkgBookingInfoVO.class));
		}else if(command.isCommand(FormCommand.COMMAND10)){
			event.setBkgBlNoVO			((BkgBlNoVO)		getVO (request, BkgBlNoVO.class));
			event.setBkgBookingInfoVO	((BkgBookingInfoVO)	getVO (request, BkgBookingInfoVO.class));
			event.setBlCustomerInfoVO	((BlCustomerInfoVO)	getVO (request, BlCustomerInfoVO.class));
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