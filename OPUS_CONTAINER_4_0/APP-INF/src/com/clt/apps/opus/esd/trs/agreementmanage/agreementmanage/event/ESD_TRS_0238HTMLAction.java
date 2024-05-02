/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName       : ESD_TRS_0238HTMLAction.java
*@FileTitle      : Agreement Attach File Popup
*Open Issues     : 
*Change history  : 
*@LastModifyDate : 2015-09-25
*@LastModifier   : ChanWoo Park
*@LastVersion    : 1.0
* 2015-09-25 ChanWoo Park
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.AgmtAttachFileListVO;
import com.clt.framework.component.attachment.file.upload.FileUpload;
import com.clt.framework.component.attachment.file.upload.FileUploadException;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.config.SiteConfigFactory;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.agreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing
 * @author Hyungwook Choi
 * @see EsdTrs0237Event , ESD_TRS_0237EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0238HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
     * ESD_TRS_0220HTMLAction 객체를 생성
     */
    public ESD_TRS_0238HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 ESD_TRS_002Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    @SuppressWarnings("unchecked")
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	log.debug("[START:: perform ESD_TRS_0238HTMLAction  ]==========");
    	
        EsdTrs0238Event event = new EsdTrs0238Event();
        String[] keys =null;

		//FILE UPLOAD하기
		if(request.getContentType()!=null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){
			try {
				FileUpload fileUpload = new FileUpload(request, SubSystemConfigFactory.get("TRS.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
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
        if(command.isCommand(FormCommand.SEARCH)) {
        	event.setAgmtNo(JSPUtil.getParameter(request, "agmt_no"));
        } else if(command.isCommand(FormCommand.MULTI)) {
        	event.setAgmtNo(JSPUtil.getParameter(request, "agmt_no"));
        	event.setOfcCd(JSPUtil.getParameter(request, "rgst_ofc_cd"));
        	event.setUsrId(JSPUtil.getParameter(request, "cre_usr_id"));
        	event.setAgmtAttachFileListVOs((AgmtAttachFileListVO[])getVOs(request, AgmtAttachFileListVO.class));
        	event.setKeys(keys);
        } 

        request.setAttribute("Event", event);
        log.debug("[END:: perform ESD_TRS_0238HTMLAction  ]==========");
        return event;
    }

    /**
     * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
     * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @param eventResponse EventResponse interface를 구현한 객체
     */
    public void doEnd(HttpServletRequest request, EventResponse eventResponse)
    {
        request.setAttribute("EventResponse", eventResponse);
    }

    /**
     * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
     * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @param event Event interface를 구현한 객체
     */
    public void doEnd(HttpServletRequest request, Event event)
    {
        request.setAttribute("Event", event);
    }

}