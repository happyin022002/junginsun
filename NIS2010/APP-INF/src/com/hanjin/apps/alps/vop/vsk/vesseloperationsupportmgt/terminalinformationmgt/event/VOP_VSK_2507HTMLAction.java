/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VOP_VSK_2507HTMLAction.java
*@FileTitle : File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.20
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2013.03.20 정상기
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.TerminalHandlingInfoAttachFileVO;
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
 * - com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 VesselOperationSupportMgtSC로 실행요청<br>
 * - VesselOperationSupportMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jeong Sang-Ki
 * @see VesselOperationSupportMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_VSK_2507HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_OPF_9036HTMLAction 객체를 생성
	 */
	public VOP_VSK_2507HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VesselOperationSupportMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		VopVsk2507Event event 		= new VopVsk2507Event();
		List<String> 	saveIdList 	= null;
		
		//FILE UPLOAD하기
		if(request.getContentType() != null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim()))
		{			
			try {				
				FileUpload fileUpload 	= new FileUpload(request,SubSystemConfigFactory.get("VSK.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);				
				request 				= fileUpload.getRequest();				
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
		
		if(command.isCommand(FormCommand.MULTI)) 
		{
			TerminalHandlingInfoAttachFileVO[] terminalHandlingInfoAttachFileVOs = (TerminalHandlingInfoAttachFileVO[]) getVOs(request, TerminalHandlingInfoAttachFileVO.class);
			
			//파일 업로드일때  "I" 신규 인경우 saveID설정 
			if (saveIdList != null && terminalHandlingInfoAttachFileVOs != null) {
				//save ID 저장 역배열로 저장되어 있음..				 
				int lastIdx =  saveIdList.size()-1;
				for (int i=0; i < terminalHandlingInfoAttachFileVOs.length; i++) {
					TerminalHandlingInfoAttachFileVO 	vo 		= terminalHandlingInfoAttachFileVOs[i];
					String 								ibflag 	= vo.getIbflag();
					if ("I".equals(ibflag)) {
						//save id 설정
						String fileSavId = saveIdList.get(lastIdx--);
						vo.setFileSavId(fileSavId);		
					}					
				}
			}
			
			event.setTerminalHandlingInfoAttachFileVOS(terminalHandlingInfoAttachFileVOs);
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setTerminalHandlingInfoAttachFileVO((TerminalHandlingInfoAttachFileVO)getVO(request, TerminalHandlingInfoAttachFileVO .class));
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