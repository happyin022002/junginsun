/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LSE_COM_HTMLAction.java
*@FileTitle : ghost
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 노정용
*@LastVersion : 1.0 
* 2009.09.21 노정용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.event;
 
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.attachment.file.upload.FileUpload;
import com.clt.framework.component.attachment.file.upload.FileUploadException;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
 
/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.LSE.mnrcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MNRCommonSC로 실행요청<br>
 * - MNRCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author park myoung sin
 * @see CgmFileUploadEvent 참조
 * @since J2EE 1.4
 */

public class CGM_FILEUPLOAD_HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * LSE_COM_HTMLAction 객체를 생성
	 */  
	public CGM_FILEUPLOAD_HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 MNRCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		CgmFileUploadEvent event = new CgmFileUploadEvent();		
		
		//FILE UPLOAD하기
		try {
			log.debug("[SubSystemConfig]   CGM.MODULE.ID        ====>>>> " + SubSystemConfigFactory.get("CGM.MODULE.ID"));
//			log.debug("[SiteConfigFactory] CGM.MODULE.ID        ====>>>> " + SiteConfigFactory.get("CGM.MODULE.ID"));
			log.debug("[SubSystemConfig]   CGM.FILE.UPLOAD.KEYS ====>>>> " + SubSystemConfigFactory.get("CGM.FILE.UPLOAD.KEYS"));
//			log.debug("[SiteConfigFactory] CGM.FILE.UPLOAD.KEYS ====>>>> " + SiteConfigFactory.get("CGM.FILE.UPLOAD.KEYS"));

			FileUpload fileUpload = new FileUpload(request, SubSystemConfigFactory.get("CGM.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
			HttpServletRequest multipartRequest = fileUpload.getRequest();
			//event.setFileCnt(multipartRequest.getParameter("file_cnt"));
			//event.setFileStat(multipartRequest.getParameter("file_stat"));
			//event.setFilekeys((List<String>)multipartRequest.getAttribute(SubSystemConfigFactory.get("LSE.FILE.UPLOAD.KEYS")));
			event.setAttribute("KEYS", (List<String>)multipartRequest.getAttribute(SubSystemConfigFactory.get("CGM.FILE.UPLOAD.KEYS")));
		} catch(FileUploadException ex) {
			this.log.error("[FileUploadException] : "+ex.getMessage());
			throw new HTMLActionException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			this.log.error("[Exception] : "+ex.getMessage());
			throw new HTMLActionException(new ErrorHandler(ex).getMessage());
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