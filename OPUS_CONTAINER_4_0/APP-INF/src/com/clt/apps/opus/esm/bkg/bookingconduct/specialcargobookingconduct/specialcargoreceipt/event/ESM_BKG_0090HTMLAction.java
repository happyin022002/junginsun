/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0090HTMLAction.java
*@FileTitle : Special Stowage Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.14 KimByungKyu
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclReqInVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BkgStwgCgoVO;
 
/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralBookingConductSC로 실행요청<br>
 * - GeneralBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KimByungKyu
 * @see GeneralBookingConductEvent 참조
 * @since J2EE 1.4 
 */

public class ESM_BKG_0090HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0090HTMLAction 객체를 생성
	 */
	public ESM_BKG_0090HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		EsmBkg0090Event event = new EsmBkg0090Event();
		String bkgNo = JSPUtil.getParameter(request, "bkg_no");
		String stwgCd = JSPUtil.getParameter(request, "stwg_cd");
		String stwgRmk = JSPUtil.getParameter(request, "stwg_rmk");
		String porCd = JSPUtil.getParameter(request, "por_cd");
		String delCd = JSPUtil.getParameter(request, "del_cd");
		String rcvTermCd = JSPUtil.getParameter(request, "rcv_term_cd");
		String deTermCd = JSPUtil.getParameter(request, "de_term_cd");
    	String button = JSPUtil.getParameter(request, "button");
		
		event.setBkgNo(bkgNo);
		event.setStwgCd(stwgCd);
		event.setStwgRmk(stwgRmk);
		event.setButton(button);
		
		FormCommand command = FormCommand.fromRequest(request);
//		if(command.isCommand(FormCommand.SEARCH01)) {
//			event.setSearchCntrInfoVO((SearchCntrInfoVO)getVO(request, SearchCntrInfoVO.class));
//			event.setSearchStwgInfoVO((SearchStwgInfoVO)getVO(request, SearchStwgInfoVO.class));
//		}else 
		if(command.isCommand(FormCommand.MULTI)) {

			BkgStwgCgoVO bkgStwgCgoVO = new BkgStwgCgoVO();
			
			bkgStwgCgoVO.setBkgNo(bkgNo);
			bkgStwgCgoVO.setStwgCd(stwgCd);
			bkgStwgCgoVO.setStwgRmk(stwgRmk);
			bkgStwgCgoVO.setStwgSeq("1");
			
			BkgStwgCgoVO[] bkgStwgCgoVOs = {bkgStwgCgoVO};
			event.setBkgStwgCgoVOs(bkgStwgCgoVOs);
			
		} else if(command.isCommand(FormCommand.COMMAND01)) {
			
			String rqstAproCd = JSPUtil.getParameter(request, "rqst_apro_cd");
			
			SpclReqInVO spclReqInVO = new SpclReqInVO();
			
			spclReqInVO.setBkgNo(bkgNo);
			spclReqInVO.setStwgCgoSeq("1");
			spclReqInVO.setAproCd(rqstAproCd);
			spclReqInVO.setPorCd(porCd);
			spclReqInVO.setDelCd(delCd);
			spclReqInVO.setRcvTermCd(rcvTermCd);
			spclReqInVO.setDeTermCd(deTermCd);
			
			SpclReqInVO[] spclReqInVOs 	= {spclReqInVO};
			event.setSpclReqInVOs(spclReqInVOs);
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