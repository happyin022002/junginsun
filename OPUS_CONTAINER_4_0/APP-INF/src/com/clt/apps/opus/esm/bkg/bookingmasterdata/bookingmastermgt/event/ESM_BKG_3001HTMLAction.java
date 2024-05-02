/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_3001HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.04 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlPtyBlGrpVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlPtyVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgInetBlCtrlPtyVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingmasterdata 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingMasterDataSC로 실행요청<br>
 * - BookingMasterDataSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 김기종
 * @see BookingMasterDataEvent 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_3001HTMLAction  extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_3001HTMLAction 객체를 생성
	 */
	public ESM_BKG_3001HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmBkg3001Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg3001Event event = new EsmBkg3001Event();
		
		if(command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.SEARCH02)) {
			event.setBkgCtrlPtyVO((BkgCtrlPtyVO)getVO(request, BkgCtrlPtyVO.class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setBkgCtrlPtyVOs((BkgCtrlPtyVO[])getVOs(request, BkgCtrlPtyVO.class, "sheet1_"));
			event.setBkgInetBlCtrlPtyVOs((BkgInetBlCtrlPtyVO[])getVOs(request, BkgInetBlCtrlPtyVO.class, "sheet2_"));
			event.setBkgCtrlPtyBlGrpVOs((BkgCtrlPtyBlGrpVO[])getVOs(request, BkgCtrlPtyBlGrpVO.class, "sheet3_"));
		}else if(command.isCommand(FormCommand.REMOVE)) {
			event.setBkgCtrlPtyVOs((BkgCtrlPtyVO[])getVOs(request, BkgCtrlPtyVO.class, "sheet1_"));
		}else if(command.isCommand(FormCommand.REMOVE01)) {
			event.setBkgInetBlCtrlPtyVOs((BkgInetBlCtrlPtyVO[])getVOs(request, BkgInetBlCtrlPtyVO.class, "sheet1_"));
		}else if(command.isCommand(FormCommand.REMOVE02)) {
			event.setBkgCtrlPtyBlGrpVOs((BkgCtrlPtyBlGrpVO[])getVOs(request, BkgCtrlPtyBlGrpVO.class, "sheet1_"));
		}
		
//		else if(command.isCommand(FormCommand.SEARCH03)) {
//			//  BKG_CTRL_PTY_SEQ.NEXTVAL 호출
//		}


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
