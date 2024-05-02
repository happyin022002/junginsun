/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0515HTMLAction.java
*@FileTitle : Optimized Distance Table
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.12
*@LastModifier : 정운
*@LastVersion : 1.0
* 2014.02.12 정운
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.vo.PassagePlanDtVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.vo.OptimizedDistanceVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselInformationMgtConditionVO;
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
 * - com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 VesselOperationSupportMgtSC로 실행요청<br>
 * - VesselOperationSupportMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jeong Un
 * @see VOP_VSK_0515Event 참조
 * @since J2EE 1.6
 */

public class VOP_VSK_0515HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0515HTMLAction 객체를 생성
	 */
	public VOP_VSK_0515HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br> 
	 * HttpRequst의 정보를 VOP_VSK_0515Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		VopVsk0515Event event = new VopVsk0515Event();

		//FILE UPLOAD하기
		if(request.getContentType()!=null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){
			
			try {
				FileUpload fileUpload = new FileUpload(request,"VSK", SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
				request = fileUpload.getRequest();
				
			} catch(FileUploadException ex) {
				this.log.error("[FileUploadException] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			} catch(Exception ex) {
				this.log.error("[Exception] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			}

			event.setKeys((List<String>)request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS")));
        }
		
    	FormCommand command = FormCommand.fromRequest(request);

		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setOptimizedDistanceVO((OptimizedDistanceVO)getVO(request, OptimizedDistanceVO .class));
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setOptimizedDistanceVO((OptimizedDistanceVO)getVO(request, OptimizedDistanceVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setOptimizedDistanceVO((OptimizedDistanceVO)getVO(request, OptimizedDistanceVO .class));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setOptimizedDistanceVO((OptimizedDistanceVO)getVO(request, OptimizedDistanceVO .class));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setOptimizedDistanceVO((OptimizedDistanceVO)getVO(request, OptimizedDistanceVO .class));
		}else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setOptimizedDistanceVO((OptimizedDistanceVO)getVO(request, OptimizedDistanceVO .class));
		}else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setOptimizedDistanceVO((OptimizedDistanceVO)getVO(request, OptimizedDistanceVO .class));
		}else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setOptimizedDistanceVO((OptimizedDistanceVO)getVO(request, OptimizedDistanceVO .class));
		}else if(command.isCommand(FormCommand.SEARCH08)) {
			event.setOptimizedDistanceVO((OptimizedDistanceVO)getVO(request, OptimizedDistanceVO .class));
		}else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setVesselInformationMgtConditionVO((VesselInformationMgtConditionVO)getVO(request, VesselInformationMgtConditionVO.class));
		}else if(command.isCommand(FormCommand.SEARCH10)) {
			event.setOptimizedDistanceVO((OptimizedDistanceVO)getVO(request, OptimizedDistanceVO .class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setOptimizedDistanceVOs((OptimizedDistanceVO[])getVOs(request, OptimizedDistanceVO .class));
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