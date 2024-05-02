/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0097HTMLAction.java
*@FileTitle : File Upload Information
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.30
*@LastModifier : 김현주
*@LastVersion : 1.0
* 2015.05.30 김현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.vo.FileUploadInfoVO;
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
 * FNS_JOO_0097  File Upload
 * HTTP Parser<br>
 * @author 김현주
 * @see FnsJoo0097Event 참조
 * @since J2EE 1.4
 */

public class FNS_JOO_0097HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * FNS_JOO_0097HTMLAction 객체를 생성
	 */
	public FNS_JOO_0097HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 FnsJoo0097Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		//이벤트 객체 생성 
		FnsJoo0097Event event = new FnsJoo0097Event();		
		List<String> saveIdList = null;
		FileUploadInfoVO[] fileUploadInfoVOs = null;
		
		//FILE UPLOAD하기
		if(request.getContentType()!=null && 
				request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){			
			try {				
				FileUpload fileUpload = new FileUpload(request,SubSystemConfigFactory.get("JOO.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);				
				request = fileUpload.getRequest();				
			} catch(FileUploadException ex) {
				this.log.error("[FileUploadException] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			} catch(Exception ex) {
				this.log.error("[Exception] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			}
			
			saveIdList = (List<String>) request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS"));
			
       }			
		
		FormCommand command = FormCommand.fromRequest(request);
	
		// ----------------------------------------------------
		// 공통화면 정보 설정 
		// ----------------------------------------------------
		FileUploadInfoVO fileUploadInfoVO = (FileUploadInfoVO)getVO(request, FileUploadInfoVO.class);
		event.setFileUploadInfoVO(fileUploadInfoVO);			
		// ----------------------------------------------------
		// 이벤트 처리 
		// ----------------------------------------------------		
		// [save] 
		if(command.isCommand(FormCommand.MULTI)) {
			
			fileUploadInfoVOs = (FileUploadInfoVO[]) getVOs(request, FileUploadInfoVO.class);
			
			//파일 업로드일때  "I" 신규 인경우 saveID설정 
			if (saveIdList != null && fileUploadInfoVOs != null) {
				//save ID 저장 역배열로 저장되어 있음..				 
				int lastIdx =  saveIdList.size()-1;
				for (int i = 0; i < fileUploadInfoVOs.length; i++) {
					FileUploadInfoVO vo = fileUploadInfoVOs[i];
					String ibflag = vo.getIbflag();
					if ("I".equals(ibflag)) {
						//save id 설정
						String fileSavId = saveIdList.get(lastIdx--);
						vo.setFileSaveId(fileSavId);
					}					
				}
				event.setFileUploadInfoVOs(fileUploadInfoVOs);				
			}
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