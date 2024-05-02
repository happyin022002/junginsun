/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0003_07HTMLAction.java
*@FileTitle : S/C Proposal Loading Agent Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.06.01 최성민
* 1.0 Creation
=========================================================
* History
* 2011.03.30 이행지 [CHM-201109659-01] OTI Bond / Tariff Title page / OTI License Attach / Signing POA 기능 개발(Customer section) 및 Loading Agent POA Attach(L/Agent section) 기능 개발요청
*                                    - File Upload Key를 담기 위한 로직 추가
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.hanjin.syscommon.common.table.PriSpScpLodgAgnVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCProposalSC로 실행요청<br>
 * - SCProposalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CHOI SUNG MIN
 * @see SCProposalEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_0003_07HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_0003_07HTMLAction 객체를 생성
	 */
	public ESM_PRI_0003_07HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCProposalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri000307Event event = new EsmPri000307Event();
		
		if(command.isCommand(FormCommand.MULTI01)) {
			event.setPriSpScpLodgAgnVOS((PriSpScpLodgAgnVO[])getVOs(request, PriSpScpLodgAgnVO .class,""));
		}
		else if(command.isCommand(FormCommand.MULTI02)) {	//accept all
			event.setPriSpScpLodgAgnVOS((PriSpScpLodgAgnVO[])getVOs(request, PriSpScpLodgAgnVO .class,""));
		}
		else if(command.isCommand(FormCommand.MULTI03)) {	//cancel
			event.setPriSpScpLodgAgnVOS((PriSpScpLodgAgnVO[])getVOs(request, PriSpScpLodgAgnVO .class,""));
		}
		else if(command.isCommand(FormCommand.MULTI04)) {	//accept
			event.setPriSpScpLodgAgnVOS((PriSpScpLodgAgnVO[])getVOs(request, PriSpScpLodgAgnVO .class,""));
		}
		else if(command.isCommand(FormCommand.MULTI05)) {	//accept cancel
			event.setPriSpScpLodgAgnVOS((PriSpScpLodgAgnVO[])getVOs(request, PriSpScpLodgAgnVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setPriSpScpLodgAgnVO((PriSpScpLodgAgnVO)getVO(request, PriSpScpLodgAgnVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setPriSpScpLodgAgnVO((PriSpScpLodgAgnVO)getVO(request, PriSpScpLodgAgnVO .class));
		}
		else {	//File Attach
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