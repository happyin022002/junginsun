/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_1053HTMLAction.java
*@FileTitle : Stevedore Damage Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.06.08 이선영
* 1.0 Creation
* 
* 2010.10.15 이상민 [CHM-201007482-01] 1053 event에 COMMAND01 - checkTabSavable() Tab이동시 save 가능 여부 확인 로직 추가
* 2011.01.12 진마리아 [CHM-201108239-01] SDMS내 demage date및 삭제 권한 변경 요청 건
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCmpnVO;
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
import com.clt.syscommon.common.table.OpfStvDmgDtlVO;
import com.clt.syscommon.common.table.OpfStvDmgRprVO;
import com.clt.syscommon.common.table.OpfStvDmgStlVO;
import com.clt.syscommon.common.table.OpfStvDmgVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.vop.opf.stevedoredamagemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 StevedoreDamageMgtSC로 실행요청<br>
 * - StevedoreDamageMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Sunyoung
 * @see StevedoreDamageMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_OPF_1053HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_OPF_1053HTMLAction 객체를 생성
	 */
	public VOP_OPF_1053HTMLAction() {}

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
		VopOpf1053Event event = new VopOpf1053Event();
		
		//FILE UPLOAD하기
		if(request.getContentType()!=null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){
			
			try {
				FileUpload fileUpload = new FileUpload(request,"OPF", SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
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
		
		/*if(command.isCommand(FormCommand.MULTI)) {
			event.setOpfStvDmgVOs((OpfStvDmgVO[])getVOs(request, OpfStvDmgVO .class, "sheet1_"));
			event.setOpfStvDmgDtlVOs((OpfStvDmgDtlVO[])getVOs(request, OpfStvDmgDtlVO .class, "sheet2_"));
			event.setOpfStvDmgRprVOs((OpfStvDmgRprVO[])getVOs(request, OpfStvDmgRprVO .class, "sheet3_"));
			event.setOpfStvDmgCmpnVOs((OpfStvDmgCmpnVO[])getVOs(request, OpfStvDmgCmpnVO .class, "sheet4_"));
			event.setOpfStvDmgStlVOs((OpfStvDmgStlVO[])getVOs(request, OpfStvDmgStlVO .class, "sheet5_"));
		}
		else*/ 
		if(command.isCommand(FormCommand.MULTI01)){
			event.setOpfStvDmgVOs((OpfStvDmgVO[])getVOs(request, OpfStvDmgVO .class, "sheet1_"));
		}
		else if(command.isCommand(FormCommand.MULTI02)){
			event.setOpfStvDmgDtlVOs((OpfStvDmgDtlVO[])getVOs(request, OpfStvDmgDtlVO .class, "sheet2_"));

			event.setOpfStvDmgAtchFileVOS((OpfStvDmgAtchFileVO[])getVOs(request, OpfStvDmgAtchFileVO .class,"sheet7_"));
			event.addOpfStvDmgAtchFileVOS((OpfStvDmgAtchFileVO[])getVOs(request, OpfStvDmgAtchFileVO .class,"sheet8_"));
			event.addOpfStvDmgAtchFileVOS((OpfStvDmgAtchFileVO[])getVOs(request, OpfStvDmgAtchFileVO .class,"sheet9_"));
		}
		else if(command.isCommand(FormCommand.MULTI03)){
			event.setOpfStvDmgRprVOs((OpfStvDmgRprVO[])getVOs(request, OpfStvDmgRprVO .class, "sheet3_"));

			event.setOpfStvDmgAtchFileVOS((OpfStvDmgAtchFileVO[])getVOs(request, OpfStvDmgAtchFileVO .class,"sheet10_"));
			event.addOpfStvDmgAtchFileVOS((OpfStvDmgAtchFileVO[])getVOs(request, OpfStvDmgAtchFileVO .class,"sheet11_"));
			event.addOpfStvDmgAtchFileVOS((OpfStvDmgAtchFileVO[])getVOs(request, OpfStvDmgAtchFileVO .class,"sheet12_"));
			event.addOpfStvDmgAtchFileVOS((OpfStvDmgAtchFileVO[])getVOs(request, OpfStvDmgAtchFileVO .class,"sheet13_"));
		}
		else if(command.isCommand(FormCommand.MULTI04)){
			event.setOpfStvDmgCmpnVOs((OpfStvDmgCmpnVO[])getVOs(request, OpfStvDmgCmpnVO .class, "sheet4_"));
		}
		else if(command.isCommand(FormCommand.MULTI05)){
			event.setOpfStvDmgStlVOs((OpfStvDmgStlVO[])getVOs(request, OpfStvDmgStlVO .class, "sheet5_"));
			
			event.setOpfStvDmgAtchFileVOS((OpfStvDmgAtchFileVO[])getVOs(request, OpfStvDmgAtchFileVO .class,"sheet14_"));
			event.addOpfStvDmgAtchFileVOS((OpfStvDmgAtchFileVO[])getVOs(request, OpfStvDmgAtchFileVO .class,"sheet15_"));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setOpfStvDmgVO((OpfStvDmgVO)getVO(request, OpfStvDmgVO .class));
			event.setAttribute("ofc_cd", request.getParameter("office_cd"));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setOpfStvDmgVO((OpfStvDmgVO)getVO(request, OpfStvDmgVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setOpfStvDmgDtlVO((OpfStvDmgDtlVO)getVO(request, OpfStvDmgDtlVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setOpfStvDmgRprVO((OpfStvDmgRprVO)getVO(request, OpfStvDmgRprVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setOpfStvDmgCmpnVO((OpfStvDmgCmpnVO)getVO(request, OpfStvDmgCmpnVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setOpfStvDmgStlVO((OpfStvDmgStlVO)getVO(request, OpfStvDmgStlVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setAttribute("local_amt", request.getParameter("qttn_cost_locl_amt"));
			event.setAttribute("curr_cd", request.getParameter("qttn_locl_curr_cd"));
		}
		else if(command.isCommand(FormCommand.SEARCH08)) {
			event.setAttribute("local_amt", request.getParameter("cmpn_cost_locl_amt"));
			event.setAttribute("curr_cd", request.getParameter("cmpn_curr_cd"));
		}
		else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setOpfStvDmgAtchFileVO((OpfStvDmgAtchFileVO)getVO(request, OpfStvDmgAtchFileVO .class));
		}
		//2010.12.15 이상민 추가 - Tab이동시 save 가능 여부 확인 로직 추가
		else if(command.isCommand(FormCommand.COMMAND01)) {
			event.setAttribute("tab_name", request.getParameter("tab_name"));
			event.setAttribute("stv_dmg_no", request.getParameter("stv_dmg_no"));
		}
		else if(command.isCommand(FormCommand.REMOVE)) {
			event.setAttribute("del_stv_dmg_no", request.getParameter("del_stv_dmg_no"));
			event.setAttribute("tab_no", request.getParameter("tabNo"));
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