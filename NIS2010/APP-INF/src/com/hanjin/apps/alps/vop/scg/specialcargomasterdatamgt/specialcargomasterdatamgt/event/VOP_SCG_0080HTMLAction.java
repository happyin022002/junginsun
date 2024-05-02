/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VOP_SCG_0080HTMLAction.java
*@FileTitle : Special Cargo Guidance
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.07
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.11.07 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgGuidanceFileVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgGuidanceVO;
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
 * - com.hanjin.apps.alps.vop.scg.cargoloadingapproval 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CargoLoadingApprovalSC로 실행요청<br>
 * - CargoLoadingApprovalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Young Oh
 * @see CargoLoadingApprovalEvent 참조
 * @since J2EE 1.6
 */

public class VOP_SCG_0080HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_SCG_0080HTMLAction 객체를 생성
	 */
	public VOP_SCG_0080HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CargoLoadingApprovalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		VopScg0080Event event = new VopScg0080Event();
		List			strKeyList	= null;
		String[]		strArrKeys	= null;
		
		//FILE UPLOAD하기
		if(request.getContentType()!=null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){
			try {
				FileUpload fileUpload = new FileUpload(request,"SCG", SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
				request = fileUpload.getRequest();
			} catch(FileUploadException ex) {
				this.log.error("[FileUploadException] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			} catch(Exception ex) {
				this.log.error("[Exception] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			}
			strKeyList	= (List<String>)request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS"));
			strArrKeys	= (String[])strKeyList.toArray(new String[strKeyList.size()]);
		}

    	FormCommand command = FormCommand.fromRequest(request);
		
		if (command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH01)) {
			event.setScgGuidanceVO((ScgGuidanceVO)getVO(request, ScgGuidanceVO.class));
		} else if (command.isCommand(FormCommand.MULTI)) {
			event.setScgGuidanceVOs((ScgGuidanceVO[])getVOs(request, ScgGuidanceVO.class, "sheet6_"));
		} else if (command.isCommand(FormCommand.MULTI01)) {
			event.setScgGuidanceVOs((ScgGuidanceVO[])getVOs(request, ScgGuidanceVO.class, "sheet7_"));
			event.setScgGuidanceFileVOs((ScgGuidanceFileVO[])getVOs(request, ScgGuidanceFileVO .class,"sheet8_"));
			event.setStrKeys(strArrKeys);
			event.setKeys(strKeyList);	//FILE_SAVE_ID 리턴값
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