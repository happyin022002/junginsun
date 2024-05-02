/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EES_DOD_0015HTMLAction.java
*@FileTitle : DOD File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.04
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.01.04 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.vo.FileUploadListVO;
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
import com.hanjin.syscommon.common.fileupload.event.FileUploadEvent;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.dod.dodcommon.fileupload 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 FileUploadSC로 실행요청<br>
 * - FileUploadSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Son, Jin-Hwan
 * @see FileUploadEvent 참조
 * @since J2EE 1.6
 */

public class EES_DOD_0015HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_DOD_0015HTMLAction 객체를 생성
	 */
	public EES_DOD_0015HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 FileUploadEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EesDod0015Event event = new EesDod0015Event();
		List<String> saveIdList = null;
		FileUploadListVO[] fileUploadListVOs = null;
		
		//FILE UPLOAD하기
		if(request.getContentType()!=null && 
				request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){			
			try {				
				FileUpload fileUpload = new FileUpload(request,"DOD",SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);				
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
		
		FileUploadListVO fileUploadListVO = (FileUploadListVO)getVO(request, FileUploadListVO.class);
		event.setFileUploadListVO(fileUploadListVO);
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setBkgNo(request.getParameter("bkg_no"));
			event.setCntrNo(request.getParameter("cntr_no"));
			event.setDrpOffChgSeq(request.getParameter("drp_off_chg_seq"));
			event.setDrpOffChgTrfSeq(request.getParameter("drp_off_chg_trf_seq"));
			event.setCaller(request.getParameter("caller"));
			event.setAtchFileLnkId(request.getParameter("atch_file_lnk_id"));
			event.setTabGubun(request.getParameter("tab_gubun"));
			
			fileUploadListVOs = (FileUploadListVO[])getVOs(request, FileUploadListVO .class,"");
			
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
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setBkgNo(request.getParameter("bkg_no"));
			event.setCntrNo(request.getParameter("cntr_no"));
			event.setDrpOffChgSeq(request.getParameter("drp_off_chg_seq"));
			event.setDrpOffChgTrfSeq(request.getParameter("drp_off_chg_trf_seq"));
			event.setCaller(request.getParameter("caller"));
			event.setAtchFileLnkId(request.getParameter("atch_file_lnk_id"));
			event.setTabGubun(request.getParameter("tab_gubun"));
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