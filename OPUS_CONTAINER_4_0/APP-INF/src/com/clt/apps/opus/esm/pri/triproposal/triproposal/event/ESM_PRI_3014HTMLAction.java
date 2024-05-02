/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_3014HTMLAction.java
 *@FileTitle : ESM_PRI_3014HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.30
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.11.30 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.triproposal.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropSendMailVO;
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
import com.clt.syscommon.common.table.PriTriRtVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.scguideline 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCGuidelineSC로 실행요청<br>
 * - SCGuidelineSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Sungsoo, Park
 * @see SCGuidelineEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_3014HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_PRI_3014HTMLAction 객체를 생성
	 */
	public ESM_PRI_3014HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCGuidelineEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
    public Event perform(HttpServletRequest request) throws HTMLActionException {
		EsmPri3014Event event = new EsmPri3014Event();
        String[] keys =null;

        //FILE UPLOAD하기
        if(request.getContentType()!=null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){

            try {
                FileUpload fileUpload = new FileUpload(request,SubSystemConfigFactory.get("PRI.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
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

        if(command.isCommand(FormCommand.MULTI)) {
            TriPropSendMailVO triPropSendMailVO = new TriPropSendMailVO();
            if (keys != null) {
                triPropSendMailVO.setFileKey(keys[0]);
            }

            event.setTriPropSendMailVO(triPropSendMailVO);
            event.setPriTriRtVOs((PriTriRtVO[])getVOs(request, PriTriRtVO.class, ""));
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