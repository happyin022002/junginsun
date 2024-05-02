/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_001HTMLAction.java
*@FileTitle : Rehandling Expense & TPB Check
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-04
*@LastModifier : Jun Ho Kim
*@LastVersion : 1.0
* 2008-01-04 Jun Ho Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.terminalmanage.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.eas.terminalmanage.vo.EasOpfTdrAtchFileVO;
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
 * @author 9011620
 * @see EsdEas0912Event , ESD_EAS_001EventResponse 참조
 * @since J2EE 1.6
 */
public class ESD_EAS_0912HTMLAction extends HTMLActionSupport {

	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	
	/**
     * ESD_EAS_0912HTMLAction 객체를 생성
     */
    public ESD_EAS_0912HTMLAction() {
    }

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_EAS_001Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    @SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsdEas0912Event event = new EsdEas0912Event();
		List<String> saveIdList = null;
		
		//FILE UPLOAD하기
		
		if(request.getContentType()!=null && 
				request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){			
			try {				
				FileUpload fileUpload = new FileUpload(request,SubSystemConfigFactory.get("OPF.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);				
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
		
		if(command.isCommand(FormCommand.MULTI)) {
			EasOpfTdrAtchFileVO[] opfTdrAtchFileVOs = (EasOpfTdrAtchFileVO[]) getVOs(request, EasOpfTdrAtchFileVO.class);
			
			
			//파일 업로드일때  "I" 신규 인경우 saveID설정 
			if (saveIdList != null && opfTdrAtchFileVOs != null) {
				//save ID 저장 역배열로 저장되어 있음..				 
				int lastIdx =  saveIdList.size()-1;
				for (int i = 0; i < opfTdrAtchFileVOs.length; i++) {
					EasOpfTdrAtchFileVO vo = opfTdrAtchFileVOs[i];
					String ibflag = vo.getIbflag();
					if ("I".equals(ibflag)) {
						//save id 설정
						String fileSavId = saveIdList.get(lastIdx--);
						if (fileSavId != null ) {
							vo.setFileSavId(fileSavId);	
						}	
					}
				}
			}
			
			event.setOpfTdrAtchFileVOs(opfTdrAtchFileVOs);
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setOpfTdrAtchFileVO((EasOpfTdrAtchFileVO)getVO(request, EasOpfTdrAtchFileVO .class));
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