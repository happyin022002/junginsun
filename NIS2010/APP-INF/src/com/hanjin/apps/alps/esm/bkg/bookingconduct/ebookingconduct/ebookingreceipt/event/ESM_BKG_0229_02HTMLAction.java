/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0229_02HTMLAction.java
 *@FileTitle : e-Booking & S/I Detail (Customer)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.08
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.06.08 전용진
 * 1.0 Creation
 * ------------------------------------------------------
 * HISTORY
 * 2013.02.06 이재위 [CHM-201322717-01] IKEA Booking Upload시 Key Data Check 로직 추가요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SearchXterPoMdtItmParmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct 화면을 통해 서버로 전송되는
 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EBookingConductSC로 실행요청<br>
 * - EBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Jun Yong Jin
 * @see EBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0229_02HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_BKG_0229_02HTMLAction 객체를 생성
	 */
	public ESM_BKG_0229_02HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg022902Event event = new EsmBkg022902Event();

		if (command.isCommand(FormCommand.DEFAULT)||command.isCommand(FormCommand.SEARCH)) {
			event.setXterRqstNoVO((XterRqstNoVO) getVO(request,XterRqstNoVO.class));
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
		}
		else if (command.isCommand(FormCommand.MULTI)) {
			// 여기를 수정하게 되면 반드시 ESM_BKG_0229HTMLAction.java 를 확인할 것
			event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO.class));
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
//			event.setBlDocCustVOs((BlDocCustVO[])getVOs(request, BlDocCustVO.class));
//			event.setCustEtcVOs((CustEtcVO[])getVOs(request, CustEtcVO.class));

			event.setCustEtcVO((CustEtcVO)getVO(request, CustEtcVO.class));
			event.setBlDocCustVO((BlDocCustVO)getVO(request, BlDocCustVO.class));
			
//			BlDocCustVO[] blDocCustVOs = new BlDocCustVO[1];
//			blDocCustVOs[0] = new BlDocCustVO();
//			blDocCustVOs[0].fromRequest(request);			
//			event.setBlDocCustVOs(blDocCustVOs);
//			
//			CustEtcVO[] custEtcVOs = new CustEtcVO[1];
//			custEtcVOs[0] = new CustEtcVO();
//			custEtcVOs[0].fromRequest(request);
//			event.setCustEtcVOs(custEtcVOs);
		} else if(command.isCommand(FormCommand.COMMAND04) || command.isCommand(FormCommand.COMMAND05) || command.isCommand(FormCommand.COMMAND09)) { // black customer check
			event.setBlDocCustVO((BlDocCustVO)getVO(request, BlDocCustVO.class));
		} else if(command.isCommand(FormCommand.COMMAND06)) { // EDI IKEA Customer Check
			event.setSearchXterPoMdtItmParmVO((SearchXterPoMdtItmParmVO)getVO(request, SearchXterPoMdtItmParmVO.class));
		} else if(command.isCommand(FormCommand.COMMAND07)) { // A/Customer Check
			event.setCustEtcVO((CustEtcVO)getVO(request, CustEtcVO.class));
			event.setBlDocCustVO((BlDocCustVO)getVO(request, BlDocCustVO.class));
		} else if(command.isCommand(FormCommand.COMMAND08)) { // Portal Customer Check
			event.setCustEtcVO((CustEtcVO)getVO(request, CustEtcVO.class));
			event.setXterRqstNoVO((XterRqstNoVO) getVO(request,XterRqstNoVO.class));
			event.setBlDocCustVO((BlDocCustVO)getVO(request, BlDocCustVO.class));
		}

		request.setAttribute("Event", event);

		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param eventResponse
	 *            EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param event
	 *            Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}