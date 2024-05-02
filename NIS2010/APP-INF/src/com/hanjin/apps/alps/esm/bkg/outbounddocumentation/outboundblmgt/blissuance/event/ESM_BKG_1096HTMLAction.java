/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1096HTMLAction.java
*@FileTitle : Email(Edit)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.26
*@LastModifier : Ilmin Lee
*@LastVersion : 1.0
* 2010.05.26 Ilmin Lee
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.framework.component.attachment.file.upload.FileUpload;
import com.hanjin.framework.component.attachment.file.upload.FileUploadException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.StringUtil;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.outboundblmgtsc 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OutboundBLMgtSCSC로 실행요청<br>
 * - OutboundBLMgtSCSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Ilmin Lee
 * @see OutboundBLMgtSCEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_1096HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1096HTMLAction 객체를 생성
	 */
	public ESM_BKG_1096HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 OutboundBLMgtSCEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1096Event event = new EsmBkg1096Event();
		String strFilekeys = ""; 
		log.debug("::CALL::> ESM_BKG_1096HTMLAction - " + command.getCommand());

		try {
			if(request.getContentType()!=null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){

				FileUpload fileUpload = new FileUpload();
				fileUpload.setModuleId("EML");
				fileUpload.setEncoding(SubSystemConfigFactory.get("COM.ENCODING.EUCKR"));
				fileUpload.setEvent(event);
				fileUpload.setInitRequest(request);
				fileUpload.setIsMail(true);
				fileUpload.doUpload();
				
				request = fileUpload.getRequest();
				List<String> fileKeys = (List<String>)request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS"));
				strFilekeys = StringUtil.attachStringWithDelimeter(fileKeys, ";");
			}
			
		} catch(FileUploadException ex) {
			this.log.error("[FileUploadException] : "+ex.getMessage());
			throw new HTMLActionException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			this.log.error("[Exception] : "+ex.getMessage());
			throw new HTMLActionException(new ErrorHandler(ex).getMessage());
		}
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setBkgEmlEdtVO((BkgEmlEdtVO)getVO(request, BkgEmlEdtVO.class));
		} else if(command.isCommand(FormCommand.DEFAULT) || command.isCommand(FormCommand.SEARCH01)){			
			event.setFileKey(strFilekeys);			

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
