/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : CTMCOMMONHTMLAction.java
 * @FileTitle : CTM Common Util
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009.05.06
 * @LastModifier : 우경민
 * @LastVersion : 1.0
 * 2009.05.06 우경민 1.0 Creation.
 * 2016.03.05 김상현 [CHM-201639990] CTM 내 CNTR History Update 화면 및 Movement Correction Monitoring 메뉴 추가개발
 */
package com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.vo.CtmCommonVO;
import com.hanjin.framework.component.attachment.file.upload.FileUpload;
import com.hanjin.framework.component.attachment.file.upload.FileUploadException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.CommonWebKeys;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * HTTP Parser.
 * - com.hanjin.apps.alps.ees.ctm.ctmcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing.
 * - Parsing 한 정보를 Event로 변환, request에 담아 CTMCommonSC로 실행요청.
 * - CTMCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅.
 * @author KyungMin Woo
 * @see CTMCommonEvent 참조
 * @since J2EE 1.4
 */
public class CTM_COM_HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * CTMCOMMONHTMLAction 객체를 생성
	 */
	public CTM_COM_HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CTMCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		CtmComEvent event = new CtmComEvent();

//		if(command.isCommand(FormCommand.SEARCH10)) {
//			event.setCTMCommonVO((CtmCommonVO)getVO(request, CtmCommonVO.class));
//		} else if(command.isCommand(FormCommand.SEARCH11)) {
//			event.setCTMCommonVO((CtmCommonVO)getVO(request, CtmCommonVO.class));
//		} else if(command.isCommand(FormCommand.SEARCH12)) {
//			event.setCTMCommonVO((CtmCommonVO)getVO(request, CtmCommonVO.class));
//		} else if(command.isCommand(FormCommand.SEARCH13)) {
//			event.setCTMCommonVO((CtmCommonVO)getVO(request, CtmCommonVO.class));
//		} else if(command.isCommand(FormCommand.SEARCH14)) {
//			event.setCTMCommonVO((CtmCommonVO)getVO(request, CtmCommonVO.class));
//		} else if(command.isCommand(FormCommand.SEARCH15)) {
//			event.setCTMCommonVO((CtmCommonVO)getVO(request, CtmCommonVO.class));
//		} else if(command.isCommand(FormCommand.SEARCH16)) {
//			event.setCTMCommonVO((CtmCommonVO)getVO(request, CtmCommonVO.class));
//		} else if(command.isCommand(FormCommand.SEARCH17)) {
//			event.setCTMCommonVO((CtmCommonVO)getVO(request, CtmCommonVO.class));
//		} else if(command.isCommand(FormCommand.SEARCH18)) {
//			event.setCTMCommonVO((CtmCommonVO)getVO(request, CtmCommonVO .class));
//		} else if(command.isCommand(FormCommand.SEARCH19)) {
//			event.setCTMCommonVO((CtmCommonVO)getVO(request, CtmCommonVO .class));
//		}

		// FILE UPLOAD하기
		if (request.getContentType() != null && request.getContentType().toLowerCase().startsWith("multipart/form-data")) {
			try {
				FileUpload fileUpload = null;
				SignOnUserAccount account = (SignOnUserAccount)request.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
				// ACCESS SYSTEM (SPP, ALP)
				if (account.getAccess_system().equals("SPP")) {
					fileUpload = new FileUpload();
					fileUpload.setInitRequest(request);
					fileUpload.setModuleId("CTM");
					fileUpload.setEncoding("utf-8");
					fileUpload.setEvent(event);
					fileUpload.setIsMail(false);
					fileUpload.enableCheckVirus();
					fileUpload.doUpload();
				} else {
					fileUpload = new FileUpload(request, "CTM", "utf-8", event, false);
				}
				request = fileUpload.getRequest();	
			} catch(FileUploadException ex) {
				this.log.error("[FileUploadException] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			} catch(Exception ex) {
				this.log.error("[Exception] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			}

			event.setFilekeys((List<String>)request.getAttribute("KEYS"));
		}

    	FormCommand command = FormCommand.fromRequest(request);

		if (!command.isCommand(FormCommand.COMMAND06)) {
			event.setCTMCommonVO((CtmCommonVO)getVO(request, CtmCommonVO .class));
			request.setAttribute("Event", event);
		}

		return event;
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