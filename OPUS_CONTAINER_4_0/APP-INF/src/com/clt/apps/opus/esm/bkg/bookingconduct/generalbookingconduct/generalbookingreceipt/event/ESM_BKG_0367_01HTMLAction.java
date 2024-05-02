/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0367_01HTMLAction.java
*@FileTitle : esm_bkg_0367_01
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.09 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherNoBkgVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BkgRefDtlVO;
import com.clt.syscommon.common.table.BkgReferenceVO;
/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralBookingConductSC로 실행요청<br>
 * - GeneralBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Jin Seo
 * @see GeneralBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0367_01HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0367_01HTMLAction 객체를 생성
	 */
	public ESM_BKG_0367_01HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * [SEARCH01] Gride1: po number 눌렀을때 액션
	 * [SEARCH02] Button: Copy from C/M  눌렀을때  액션 (DB에서 가져올지/ 화면에서 가져올지 결정여부?)
	 * [MULTI] Button: save  눌렀을때  액션
	 * [SEARCH] 최초 화면 조회시 액션
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("============================>[[ ESM_BKG_0367_01HTMLAction  START ]]<============================");
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg036701Event event = new EsmBkg036701Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			//[SEARCH] 최초 팝업 화면 조회시 액션
			event.setPoOtherNoBkgVO((PoOtherNoBkgVO)getVO(request, PoOtherNoBkgVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			//[SEARCH01] Gride1: po number 눌렀을때 액션  sheet1_ --> sheet2_

			event.setPoOtherNoBkgVO((PoOtherNoBkgVO)getVO(request, PoOtherNoBkgVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			//[SEARCH02] 초기 container list combo

			event.setPoOtherNoBkgVO((PoOtherNoBkgVO)getVO(request, PoOtherNoBkgVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			//[MULTI] Button: save  눌렀을때  액션

			event.setPoOtherNoBkgVO((PoOtherNoBkgVO)getVO(request, PoOtherNoBkgVO .class));

			BkgReferenceVO[] poOtherCntrVOs 	= (BkgReferenceVO[])getVOs(request, BkgReferenceVO.class,"sheet1_");
			BkgRefDtlVO[] 	 poOtherCmVOs 		= (BkgRefDtlVO[])getVOs(request, BkgRefDtlVO.class,"sheet2_");
			BkgRefDtlVO[]    poOtherShipVOs 	= (BkgRefDtlVO[])getVOs(request, BkgRefDtlVO.class,"sheet3_");
			BkgRefDtlVO[]    poOtherMrnUcrVOs	= (BkgRefDtlVO[])getVOs(request, BkgRefDtlVO.class,"sheet4_");
			BkgReferenceVO[] poOtherBkgRefVOs 	= (BkgReferenceVO[])getVOs(request, BkgReferenceVO.class,"sheet5_");

			event.setPoOtherNoBkgVOs(poOtherBkgRefVOs);
			event.setPoOtherCntrVOs(poOtherCntrVOs);
			event.setPoOtherCmVOs(poOtherCmVOs);
			event.setPoOtherMrnUcrVOs(poOtherMrnUcrVOs);
			event.setPoOtherShipVOs(poOtherShipVOs);
		}
		request.setAttribute("Event", event);
		log.debug("============================>[[ ESM_BKG_0367_01HTMLAction  END ]]<============================");
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