/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3514HTMLAction.java
*@FileTitle : Inland Rates Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.21 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.inlandrates.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.pri.tariff.inlandrates.vo.PriTrfInlndListVO;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.vo.PriTrfInlndParamVO;
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
import com.clt.syscommon.common.table.PriTrfInlndRtVO;
import com.clt.syscommon.common.table.PriTrfInlndVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.tariff 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TariffSC로 실행요청<br>
 * - TariffSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CHOI SUNGMIN
 * @see TariffEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_3514HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_3514HTMLAction 객체를 생성
	 */
	public ESM_PRI_3514HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TariffEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri3514Event event = new EsmPri3514Event();
		
		if(request.getContentType()!=null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){
			
			try {
				FileUpload fileUpload = new FileUpload(request,SubSystemConfigFactory.get("PRI.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
				request = fileUpload.getRequest();
			} catch(FileUploadException ex) {
				this.log.error("[FileUploadException] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler("CNI09008").getMessage(), ex);
			} catch(Exception ex) {
				this.log.error("[Exception] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler("CNI09008").getMessage(), ex);
			}
			
			event.setKeys((List<String>)request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS")));
			//event.setPriTrfInlndVO((PriTrfInlndVO)getVO(request, PriTrfInlndVO .class));
			
			PriTrfInlndListVO vo = new PriTrfInlndListVO();		
			vo.setPriTrfInlndParamVO((PriTrfInlndParamVO)getVO(request, PriTrfInlndParamVO .class));		
			vo.setPriTrfInlndVOs((PriTrfInlndVO[])getVOs(request, PriTrfInlndVO .class,"sheet1_"));
			vo.setPriTrfInlndRtVOs((PriTrfInlndRtVO[])getVOs(request, PriTrfInlndRtVO .class,"sheet3_"));	
			vo.setKeys(event.getKeys());
			
			event.setPriTrfInlndListVO(vo);
        }

		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setPriTrfInlndVO((PriTrfInlndVO)getVO(request, PriTrfInlndVO .class));
		} else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setPriTrfInlndParamVO((PriTrfInlndParamVO)getVO(request, PriTrfInlndParamVO .class));
			event.setPriTrfInlndRtVO((PriTrfInlndRtVO)getVO(request, PriTrfInlndRtVO .class));
		} else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setPriTrfInlndRtVO((PriTrfInlndRtVO)getVO(request, PriTrfInlndRtVO .class));
		} else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setPriTrfInlndRtVOS((PriTrfInlndRtVO[])getVOs(request, PriTrfInlndRtVO .class));	
		} else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setPriTrfInlndVO((PriTrfInlndVO)getVO(request, PriTrfInlndVO .class));
		} else if(command.isCommand(FormCommand.MULTI01)) {
			PriTrfInlndListVO vo = new PriTrfInlndListVO();		
			vo.setPriTrfInlndParamVO((PriTrfInlndParamVO)getVO(request, PriTrfInlndParamVO .class));
			vo.setPriTrfInlndVOs((PriTrfInlndVO[])getVOs(request, PriTrfInlndVO .class,"sheet1_"));
			vo.setPriTrfInlndRtVOs((PriTrfInlndRtVO[])getVOs(request, PriTrfInlndRtVO .class,"sheet3_"));	
			vo.setKeys(event.getKeys());
			
			event.setPriTrfInlndListVO(vo);
		} else if(command.isCommand(FormCommand.MULTI02)) {
			event.setPriTrfInlndVO((PriTrfInlndVO)getVO(request, PriTrfInlndVO .class));
		} else if(command.isCommand(FormCommand.REMOVE01)) {
			event.setPriTrfInlndVO((PriTrfInlndVO)getVO(request, PriTrfInlndVO .class));
		} else if(command.isCommand(FormCommand.REMOVE02)) {
			event.setPriTrfInlndVO((PriTrfInlndVO)getVO(request, PriTrfInlndVO .class));
		} else if(command.isCommand(FormCommand.MODIFY02)) {
			event.setPriTrfInlndVO((PriTrfInlndVO)getVO(request, PriTrfInlndVO .class));
		} else if(command.isCommand(FormCommand.MODIFY03)) {
			event.setPriTrfInlndVO((PriTrfInlndVO)getVO(request, PriTrfInlndVO .class));
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