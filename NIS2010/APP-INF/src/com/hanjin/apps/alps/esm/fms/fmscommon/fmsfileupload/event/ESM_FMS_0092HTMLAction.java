/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0092HTMLAction.java
*@FileTitle : File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.08
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.11.08 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.vo.FileUploadListVO;
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
 * ESM_FMS_0092  File Upload
 * HTTP Parser<br>
 * @author 민정호
 * @see EsmFms0092Event 참조
 * @since J2EE 1.4 
 */

public class ESM_FMS_0092HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_FMS_0092HTMLAction 객체를 생성
	 */
	public ESM_FMS_0092HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmFms0092Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		//이벤트 객체 생성 
		EsmFms0092Event event = new EsmFms0092Event();		
		List<String> saveIdList = null;
		FileUploadListVO[] fileUploadListVOs = null;
	
		//FILE UPLOAD하기
		if(request.getContentType()!=null && 
				request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){			
			try {				
				FileUpload fileUpload = new FileUpload(request,"FMS",SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);				
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
		FileUploadListVO fileUploadListVO = (FileUploadListVO)getVO(request, FileUploadListVO.class);
		event.setFileUploadListVO(fileUploadListVO);		
		// ----------------------------------------------------
		// 이벤트 처리 
		// ----------------------------------------------------		
		//  
		
		if(command.isCommand(FormCommand.SEARCH18)) {
			event.setVslCd(request.getParameter("vsl_cd"));
			event.setVnorSeq(request.getParameter("vnor_seq"));
			event.setVnorItmSeq(request.getParameter("vnor_itm_seq"));
			
			event.setCsrNo(request.getParameter("csr_no"));
			
		} else if(command.isCommand(FormCommand.MULTI)) {
			event.setVslCd(request.getParameter("vsl_cd"));
			event.setVnorSeq(request.getParameter("vnor_seq"));
			event.setVnorItmSeq(request.getParameter("vnor_itm_seq"));			
			
			event.setCsrNo(request.getParameter("csr_no"));
			
			fileUploadListVOs = (FileUploadListVO[]) getVOs(request, FileUploadListVO.class);
			
			//파일 업로드일때  "I" 신규 인경우 saveID설정 
			if (saveIdList != null && fileUploadListVOs != null) {
				//save ID 저장 역배열로 저장되어 있음..				 
				int lastIdx =  saveIdList.size()-1;
				for (int i = 0; i < fileUploadListVOs.length; i++) {
					FileUploadListVO vo = fileUploadListVOs[i];
					String ibflag = vo.getIbflag();
					if ("I".equals(ibflag)) {
						//save id 설정
						String fileSavId = saveIdList.get(lastIdx--);
						vo.setFileSavId(fileSavId);		
					}					
				}				
			}			
			event.setFileUploadListVOs(fileUploadListVOs);			
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