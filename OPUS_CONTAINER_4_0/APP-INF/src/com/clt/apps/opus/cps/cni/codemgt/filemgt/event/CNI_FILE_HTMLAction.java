/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CNI_FILE_HTMLAction.java
*@FileTitle : CNI File Attach HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.codemgt.filemgt.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.cps.cni.codemgt.filemgt.vo.CustomFileDwcInsuranceVO;
import com.clt.apps.opus.cps.cni.common.event.CniComEvent;
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
 * HTTP Parser<br>
 * - com.clt.apps.opus.cps.cni.drywetclaim 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CodeMgmtSC로 실행요청<br>
 * - DryWetClaimSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Yoon, Seyeong
 * @see CniComEvent 참조
 * @since J2EE 1.6
 */

public class CNI_FILE_HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;

    /**
     * CNI_FILE_HTMLAction 객체를 생성
     */
    public CNI_FILE_HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 BookingCommonEvent로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

        CniFileEvent event = new CniFileEvent();

        //FILE UPLOAD하기
		if(request.getContentType()!=null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){
			
			try {
				FileUpload fileUpload = new FileUpload(request,SubSystemConfigFactory.get("CNI.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
				request = fileUpload.getRequest();
				
			} catch(FileUploadException ex) {
				this.log.error("[FileUploadException] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler("CNI09008").getMessage(), ex);
			} catch(Exception ex) {
				this.log.error("[Exception] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler("CNI09008").getMessage(), ex);
			}
			
			event.setKeys((List<String>)request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS")));
        }

		FormCommand command = FormCommand.fromRequest(request);

        if(command.isCommand(FormCommand.SEARCH)) {
			event.setDwClmNo(request.getParameter("dw_clm_no"));
        } else if(command.isCommand(FormCommand.MULTI)) {
  			event.setCustomFileDwcInsuranceVOS((CustomFileDwcInsuranceVO[])getVOs(request, CustomFileDwcInsuranceVO .class,"file_"));
        }

        request.setAttribute("Event", event);

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