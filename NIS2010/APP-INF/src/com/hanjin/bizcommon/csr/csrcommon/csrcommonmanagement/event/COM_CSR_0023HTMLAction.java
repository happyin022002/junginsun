/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : COM_CSR_0023HTMLAction.java
*@FileTitle : CSR Invoice Agreement Link
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.10
*@LastModifier : 9014787
*@LastVersion : 1.0
* 2014.07.10 9014787
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo.CSRComApFileUpldVO;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo.CSRInvAgmtLnkInVO;
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
 * - com.hanjin.bizcommon.csr.csrcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CSRCommonManagementSC로 실행요청<br>
 * - CSRCommonManagementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 9014787
 * @see CSRCommonManagementEvent 참조
 * @since J2EE 1.6
 */

public class COM_CSR_0023HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * COM_CSR_0023HTMLAction 객체를 생성
	 */
	public COM_CSR_0023HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CSRCommonManagementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		ComCsr0023Event event = new ComCsr0023Event();
		
		// event Set VO
		event.setComCsrRequestAgmtVO((ComCsrRequestAgmtVO)getVO(request, ComCsrRequestAgmtVO.class));

        
        log.debug("[START::  COM_CSR_0023HTMLAction  ]==========");

		String[] keys =null;

		//FILE UPLOAD하기
		if(request.getContentType()!=null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){

			try {

				//FileUpload fileUpload = new FileUpload(request,SubSystemConfigFactory.get("CSR.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
				FileUpload fileUpload = new FileUpload(request, "GCA", SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
				request = fileUpload.getRequest();
				List<String> keyList = (List<String>)request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS"));
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
		if(command.isCommand(FormCommand.SEARCH02)) {
			event.setCsrInvAgmtLnkInVO((CSRInvAgmtLnkInVO)getVO(request, CSRInvAgmtLnkInVO.class));

		}
		else if(command.isCommand(FormCommand.MULTI)) {

			CSRInvAgmtLnkInVO csrInvAgmtLnkInVO			= (CSRInvAgmtLnkInVO)getVO(request, CSRInvAgmtLnkInVO.class);
			CSRComApFileUpldVO[] csrComApFileUpldVOs	= (CSRComApFileUpldVO[])getVOs(request, CSRComApFileUpldVO.class, "sheet2_");
			csrInvAgmtLnkInVO.setKeys(keys);
			csrInvAgmtLnkInVO.setCsrComApFileUpldVOs(csrComApFileUpldVOs);
			event.setCsrInvAgmtLnkInVO(csrInvAgmtLnkInVO);
			
		}

		// request Set Event
		request.setAttribute("Event", event);
		log.debug("[END:: perform COM_CSR_0023HTMLAction  ]==========");

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