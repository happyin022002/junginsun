/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0079_05HTMLAction.java
*@FileTitle : Customer Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.07.31 김병규
* 1.0 Creation
* -----------------------------------------------------------
* History
* 2010.11.23 최도순 [CHM-201007206] Actual customer column 보완 및 M&D 화면에 자동 DISPLAY 요청
* 2011.05.11 이일민 [CHM-201110114] BKG Charge Screen 상 운임회수 점소 pre-paid office was auto-changed as booking office again
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO;
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
 * @author KimByungKyu
 * @see GeneralBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0079_05HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0079_05HTMLAction 객체를 생성
	 */
	public ESM_BKG_0079_05HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg007905Event event = new EsmBkg007905Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
		}else if(command.isCommand(FormCommand.SEARCHLIST11) || command.isCommand(FormCommand.SEARCH03)){
			event.setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd"));					
			event.setCustSeq(JSPUtil.getParameter(request, "cust_seq"));
		}else if(command.isCommand(FormCommand.COMMAND03)){
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));		
		}else if(command.isCommand(FormCommand.MULTI)){
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));		
			event.setBlDocCustVO((BlDocCustVO)getVO(request, BlDocCustVO.class));
			event.setCustEtcVO((CustEtcVO)getVO(request, CustEtcVO.class));
			
			event.setOldActCustCd(JSPUtil.getParameter(request, "old_act_cust_cd"));	
			
			String agmtActCntCd = JSPUtil.getParameter(request, "agmt_act_cnt_cd");
			String agmtActCustSeq = JSPUtil.getParameter(request, "agmt_act_cust_seq").equals("")?"":JSPUtil.getLPAD(JSPUtil.getParameter(request, "agmt_act_cust_seq"), 6, "0");			
			
			event.setNewActCustCd(agmtActCntCd+agmtActCustSeq);
		}else if(command.isCommand(FormCommand.COMMAND04) || command.isCommand(FormCommand.COMMAND05) || command.isCommand(FormCommand.COMMAND09)){
			event.setBlDocCustVO((BlDocCustVO)getVO(request, BlDocCustVO.class));
		} else if (command.isCommand(FormCommand.SEARCH02) || command.isCommand(FormCommand.MODIFY07) || command.isCommand(FormCommand.SEARCH04) || command.isCommand(FormCommand.SEARCH05)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
		}

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