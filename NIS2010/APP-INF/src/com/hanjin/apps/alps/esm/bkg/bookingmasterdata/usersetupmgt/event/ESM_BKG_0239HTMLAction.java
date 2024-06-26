/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0239HTMLAction.java
*@FileTitle : Evidence
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.16 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.CustChkPntAttachVO;
import com.hanjin.framework.component.attachment.file.upload.FileUpload;
import com.hanjin.framework.component.attachment.file.upload.FileUploadException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SpecialCargoBookingConductSC로 실행요청<br>
 * - SpecialCargoBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Jin Seo
 * @see SpecialCargoBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0239HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0239HTMLAction 객체를 생성
	 */
	public ESM_BKG_0239HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SpecialCargoBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("[START::  ESM_BKG_0239HTMLAction  ]==========");

		EsmBkg0239Event event = new EsmBkg0239Event();
		String[] keys =null;

		//FILE UPLOAD하기
		if(request.getContentType()!=null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){

			try {

				FileUpload fileUpload = new FileUpload(request,SubSystemConfigFactory.get("BKG.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
				request = fileUpload.getRequest();
				List keyList = (List<String>)request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS"));
				keys = (String[])keyList.toArray(new String[keyList.size()]);

			} catch(FileUploadException ex) {
				this.log.error("[FileUploadException] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			} catch(Exception ex) {
				this.log.error("[Exception] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			}
        }

		FormCommand command = FormCommand.fromRequest(request);
		if(command.isCommand(FormCommand.SEARCH)) {

			CustChkPntAttachVO attachmentVO = (CustChkPntAttachVO)getVO(request, CustChkPntAttachVO.class);
			event.setCustChkPntAttachVO(attachmentVO);

		}
		else if(command.isCommand(FormCommand.MULTI)) {

			CustChkPntAttachVO[] attachmentVOs 	= (CustChkPntAttachVO[])getVOs(request, CustChkPntAttachVO .class,"sheet1_");
			event.setCustChkPntAttachVOS(attachmentVOs);
			event.setKeys(keys);

		}

		request.setAttribute("Event", event);
		log.debug("[END:: perform ESM_BKG_0239HTMLAction  ]==========");
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