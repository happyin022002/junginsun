/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1182HTMLAction.java
*@FileTitle : Booking Attachment
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.05 
* 1.0 Creation
* 
* 2015.02.05 [CHM-201432844] 제안제도 : BKG Creation 화면에 Attachment 기능 추가
*            (ESM_BKG_0369 그대로 옮겨 옴)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.EstimatedCMPBVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderInVO;
import com.hanjin.framework.component.attachment.file.upload.FileUpload;
import com.hanjin.framework.component.attachment.file.upload.FileUploadException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgImgStoVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SpecialCargoBookingConductSC로 실행요청<br>
 * - SpecialCargoBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Jin Seo
 * @see SpecialCargoBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_1183HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1183HTMLAction 객체를 생성
	 */
	public ESM_BKG_1183HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("[START::  ESM_BKG_1183HTMLAction  ]==========");

		EsmBkg1183Event event = new EsmBkg1183Event();

		FormCommand command = FormCommand.fromRequest(request);
//		if(command.isCommand(FormCommand.SEARCH)) {
//
//			BlRiderInVO blRiderInVO = (BlRiderInVO)getVO(request, BlRiderInVO.class);
//			event.setBlRiderInVO(blRiderInVO);
//
//		}
//		else if(command.isCommand(FormCommand.MULTI)) {
//
//			BlRiderInVO blRiderInVO 	= (BlRiderInVO)getVO(request, BlRiderInVO.class);
//			BkgImgStoVO[] bkgImgStoVOs 	= (BkgImgStoVO[])getVOs(request, BkgImgStoVO .class,"sheet1_");
//			blRiderInVO.setKeys(keys);
//			blRiderInVO.setBkgImgStoVOs(bkgImgStoVOs);
//			event.setBlRiderInVO(blRiderInVO);
//
//		}
		event.setBkgNo(request.getParameter("bkg_no"));
		log.debug("[END:: perform ESM_BKG_1182HTMLAction  ]==========");
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