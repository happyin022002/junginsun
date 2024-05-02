/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0052HTMLAction.java
*@FileTitle : Damage Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.05.18 이선영
* 1.0 Creation
* * 2010.10.12 이석준 [CSR전 사전 작업] VVD,VSL,Lane,Port 유효성 검사 로직 추가
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ChangeOfDestinationMgtConditionVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCreateVO;
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
import com.clt.syscommon.common.table.OpfStvDmgAtchFileVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.vop.opf.stevedoredamagemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 StevedoreDamageMgtSC로 실행요청<br>
 * - StevedoreDamageMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Sunyoung
 * @see StevedoreDamageMgtEvent 참조
 * @since J2EE 1.4
 */
public class VOP_OPF_0052HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_OPF_0052HTMLAction 객체를 생성
	 */
	public VOP_OPF_0052HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 StevedoreDamageMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	//FormCommand command = FormCommand.fromRequest(request);
		VopOpf0052Event event = new VopOpf0052Event();
		
		//FILE UPLOAD하기
		if(request.getContentType()!=null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){
			
			try {
				FileUpload fileUpload = new FileUpload(request,"OPF", SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event, false, true);
//				FileUpload fileUpload = new FileUpload(request,"OPF", SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
				//FileUpload fileUpload = new FileUpload(request,SubSystemConfigFactory.get("FMS.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
				request = fileUpload.getRequest();
				
			} catch(FileUploadException ex) {
				this.log.error("[FileUploadException] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			} catch(Exception ex) {
				this.log.error("[Exception] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			}
			
			//event.setKeys((List<String>)request.getAttribute(SubSystemConfigFactory.get("COM.FILE.UPLOAD.KEYS")));
			event.setKeys((List<String>)request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS")));
        }
		
		FormCommand command = FormCommand.fromRequest(request);
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setOpfStvDmgCreateVOS		((OpfStvDmgCreateVO[])getVOs(request, OpfStvDmgCreateVO .class		,"sheet1_"));
			event.setOpfStvDmgAtchFileVOS	((OpfStvDmgAtchFileVO[])getVOs(request, OpfStvDmgAtchFileVO .class	,"sheet2_"));
			event.addOpfStvDmgAtchFileVOS	((OpfStvDmgAtchFileVO[])getVOs(request, OpfStvDmgAtchFileVO .class	,"sheet3_"));
			event.addOpfStvDmgAtchFileVOS	((OpfStvDmgAtchFileVO[])getVOs(request, OpfStvDmgAtchFileVO .class	,"sheet4_"));
		}
		else if(command.isCommand(FormCommand.MODIFY01)){
			event.setOpfStvDmgCreateVO((OpfStvDmgCreateVO)getVO(request, OpfStvDmgCreateVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH)
				|| command.isCommand(FormCommand.SEARCH01)
				|| command.isCommand(FormCommand.SEARCH02)
				|| command.isCommand(FormCommand.SEARCH03)
				|| command.isCommand(FormCommand.SEARCH04)
				|| command.isCommand(FormCommand.SEARCH06)
				|| command.isCommand(FormCommand.COMMAND02)) {
			event.setOpfStvDmgCreateVO((OpfStvDmgCreateVO)getVO(request, OpfStvDmgCreateVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setOpfStvDmgAtchFileVO((OpfStvDmgAtchFileVO)getVO(request, OpfStvDmgAtchFileVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setAttribute("ofc_cd", request.getParameter("ofc_cd"));
		}
		else if(command.isCommand(FormCommand.SEARCH08)) {
			event.setAttribute("ofc_cd", request.getParameter("ofc_cd"));
		}		
		else if(command.isCommand(FormCommand.SEARCH09)) {
			//event.setOpfStvDmgCreateVOS((OpfStvDmgCreateVO[])getVOs(request, OpfStvDmgCreateVO .class,"sheet1_"));
			event.setOpfStvDmgCreateVO((OpfStvDmgCreateVO)getVO(request, OpfStvDmgCreateVO .class));
		}
		else if(command.isCommand(FormCommand.REMOVE)) {
			event.setAttribute("del_stv_dmg_no", request.getParameter("del_stv_dmg_no"));
		}
		else if(command.isCommand(FormCommand.COMMAND01)){
			event.setVskVslPortSkdVO((VskVslPortSkdVO)getVO(request, VskVslPortSkdVO .class));
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