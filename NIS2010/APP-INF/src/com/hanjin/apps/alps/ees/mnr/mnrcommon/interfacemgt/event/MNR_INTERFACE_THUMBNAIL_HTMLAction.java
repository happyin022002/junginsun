/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MNR_INTERFACE_THUMBNAIL_HTMLAction.java
*@FileTitle : MNR_INTERFACE_THUMBNAIL_HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 이율규
*@LastVersion : 1.0 
* 2015.10.28 이율규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.event;
 
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrFileAtchVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.hanjin.framework.component.attachment.file.upload.FileUploadException;
import com.hanjin.framework.component.attachment.file.upload.FileUploadThumbnail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
 
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mnr.mnrcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MNRCommonSC로 실행요청<br>
 * - MNRCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author park myoung sin
 * @see MnrInterfaceEvent 참조
 * @since J2EE 1.4
 */

public class MNR_INTERFACE_THUMBNAIL_HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * MNR_COM_HTMLAction 객체를 생성
	 */  
	public MNR_INTERFACE_THUMBNAIL_HTMLAction() {}	
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 MNRCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		MnrInterfaceEvent event = new MnrInterfaceEvent();		
		List<String> keys = new ArrayList<String>();	
		//FILE UPLOAD하기	
		if(request.getContentType()!=null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("MNR.CONTENTS.TYPE.MULTIPART").trim())){
			try {
				FileUploadThumbnail fileUpload = null;
				//ACCESS SYSTEM (SPP ,ALP)			

				fileUpload = new FileUploadThumbnail();
				fileUpload.setInitRequest(request);
				fileUpload.setModuleId(SubSystemConfigFactory.get("MNR.MODULE.ID"));
				fileUpload.setEncoding(SubSystemConfigFactory.get("MNR.FILE.UPLOAD.ENCODING"));
				fileUpload.setEvent(event);
				fileUpload.setIsMail(false);
				fileUpload.enableCheckVirus();
				
				//Zip 파일이면 true, 아니면 false
                fileUpload.setZip(false);

                //Thumbnail size
                fileUpload.setThumbnailHeight(100);
                fileUpload.setThumbnailWidth(100);
				
				fileUpload.doThumbnailUpload();
		
				request = fileUpload.getRequest();	
			} catch(FileUploadException ex) {
				this.log.error("[FileThumbnailUploadException] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			} catch(Exception ex) {
				this.log.error("[Exception] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			}
				
			event.setFileCnt(request.getParameter("file_cnt"));	
			event.setFileStat(request.getParameter("file_stat"));		
			event.setFilekeys((List<String>)request.getAttribute(SubSystemConfigFactory.get("MNR.FILE.UPLOAD.KEYS")));
			keys = (List<String>)request.getAttribute(SubSystemConfigFactory.get("MNR.FILE.UPLOAD.KEYS"));
		}		
		
		FormCommand command = FormCommand.fromRequest(request);		
		
		InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			
		if(command.isCommand(FormCommand.COMMAND01)) {
			interfaceGRPVO.setCustomMnrFileAtchVOs((CustomMnrFileAtchVO[])getVOs(request, CustomMnrFileAtchVO .class,""));
			interfaceGRPVO.getCustomMnrFileAtchVOs()[0].setFilePathNm(keys.get(0));
			
			String[] filePathNm = new String[keys.size()];
			
			// input filePathNames of images in a zipfile.
			for(int i = 0; i < keys.size(); i++){
				filePathNm[i] = keys.get(i); 
			}
			
			event.setAttribute("filePathNm", filePathNm);
			
		} else if(command.isCommand(FormCommand.REMOVE)) {
			interfaceGRPVO.setCustomMnrFileAtchVOs((CustomMnrFileAtchVO[])getVOs(request, CustomMnrFileAtchVO .class,""));	
		} else if(command.isCommand(FormCommand.SEARCH)) { 
			interfaceGRPVO.setFileSeq(request.getParameter("file_seq"));       
		}	
			
		event.setInterfaceGRPVO(interfaceGRPVO);
		request.setAttribute("Event", event);
		event.setAttribute("thumbnail", "Y"); // 썸네일 저장이 필요할 때만 관련 함수 실행이 가능하도록 플래그를 생성한다.

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