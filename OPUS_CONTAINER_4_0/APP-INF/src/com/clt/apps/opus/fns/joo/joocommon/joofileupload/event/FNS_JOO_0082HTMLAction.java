/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0082HTMLAction.java
*@FileTitle : File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.08
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.11.08 이준범
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofileupload.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.joo.joocommon.joofileupload.vo.FileUploadListVO;
import com.clt.framework.component.attachment.file.upload.FileUpload;
import com.clt.framework.component.attachment.file.upload.FileUploadException;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SiteConfigFactory;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * FNS_JOO_0082  File Upload
 * HTTP Parser<br>
 * @author 이준범
 * @see FnsJoo0082Event 참조
 * @since J2EE 1.4
 */

public class FNS_JOO_0082HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * FNS_JOO_0082HTMLAction 객체를 생성
	 */
	public FNS_JOO_0082HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 FnsJoo0082Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		//이벤트 객체 생성 
		FnsJoo0082Event event = new FnsJoo0082Event();		
		List<String> saveIdList = null;
	
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
		FileUploadListVO fileUploadListVO = (FileUploadListVO)getVO(request, FileUploadListVO.class);
		event.setFileUploadListVO(fileUploadListVO);		
		// ----------------------------------------------------
		// 이벤트 처리 
		// ----------------------------------------------------		
		// [save] 
		if(command.isCommand(FormCommand.SEARCH18)) {
			event.setJoCrrCd(request.getParameter("jo_crr_cd"));
			event.setCrrCntcSeq(request.getParameter("crr_cntc_seq"));			
		} else if(command.isCommand(FormCommand.MULTI)) {
			
			FileUploadListVO[] fileUploadListVOs = (FileUploadListVO[]) getVOs(request, FileUploadListVO.class);
			
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

				event.setFileUploadListVOs(fileUploadListVOs);
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