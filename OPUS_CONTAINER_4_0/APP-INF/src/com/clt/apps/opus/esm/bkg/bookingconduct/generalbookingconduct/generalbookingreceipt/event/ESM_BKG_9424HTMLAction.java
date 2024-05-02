/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_9424HTMLAction.java
*@FileTitle : Empty Repo BKG Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.18 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoCntrVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralBookingConductSC로 실행요청<br>
 * - GeneralBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KimByungKyu
 * @see GeneralBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_9424HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_9424HTMLAction 객체를 생성
	 */
	public ESM_BKG_9424HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg9424Event event = new EsmBkg9424Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setMvmtOption(JSPUtil.getParameter(request, "mvmt_option"));	
			event.setBkgMvmtCd(JSPUtil.getParameter(request, "bkg_mvmt_cd"));
		}else if(command.isCommand(FormCommand.SEARCHLIST11)){
			event.setCntrNo(JSPUtil.getParameter(request, "cntr_no"));				
		}else if(command.isCommand(FormCommand.SEARCHLIST12)){
			event.setRepoBkgVO((RepoBkgVO)getVO(request, RepoBkgVO.class));
			event.setMvmtOption(JSPUtil.getParameter(request, "mvmt_option"));
			event.setBkgMvmtCd(JSPUtil.getParameter(request, "bkg_mvmt_cd"));	
		}else if(command.isCommand(FormCommand.MULTI01)){
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));			
			event.setRepoBkgVO((RepoBkgVO)getVO(request, RepoBkgVO.class));
			event.setRepoCntrVOs((RepoCntrVO[])getVOs(request, RepoCntrVO.class,"sheet1_"));
			event.setTrunkVvd(JSPUtil.getParameter(request, "bkg_trunk_vvd"));
			event.setBkgMvmtCd(JSPUtil.getParameter(request, "bkg_mvmt_cd"));
		}else if(command.isCommand(FormCommand.MULTI02)){
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));	
			event.setBkgMvmtCd(JSPUtil.getParameter(request, "bkg_mvmt_cd"));
		}else if(command.isCommand(FormCommand.MULTI03) || command.isCommand(FormCommand.MULTI04)){
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));			
			event.setRepoCntrVOs((RepoCntrVO[])getVOs(request, RepoCntrVO.class,""));
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