/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0022HTMLAction.java
*@FileTitle : SPCL CGO APVL for Partner Lines (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.24 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstFileVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstVO;
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
 * - com.clt.apps.opus.vop.scg.cargoloadingapproval 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CargoLoadingApprovalSC로 실행요청<br>
 * - CargoLoadingApprovalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author HyunUk Kim
 * @see CargoLoadingApprovalEvent 참조
 * @since J2EE 1.6
 */

public class VOP_SCG_5001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_SCG_0022HTMLAction 객체를 생성
	 */
	public VOP_SCG_5001HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CargoLoadingApprovalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	
		VopScg5001Event event = new VopScg5001Event();
		
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

			event.setKeys((List<String>)request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS")));
        }
		
		FormCommand command = FormCommand.fromRequest(request);
		String[] prefixs = request.getParameterValues("IBPREFIX");
		
		if(command.isCommand(FormCommand.MULTI)) {
			ScgPrnrAproRqstVO[]     scgPrnrAproRqstVOs     = (ScgPrnrAproRqstVO[])getVOs(request, ScgPrnrAproRqstVO .class, prefixs[0]);
			ScgPrnrAproRqstCgoVO[]  scgPrnrAproRqstCgoVOs  = (ScgPrnrAproRqstCgoVO[])getVOs(request, ScgPrnrAproRqstCgoVO .class, prefixs[1]);
			ScgPrnrAproRqstFileVO[] scgPrnrAproRqstFileVOs = (ScgPrnrAproRqstFileVO[])getVOs(request, ScgPrnrAproRqstFileVO .class, prefixs[2]);
			
			PartnerApprovalRequestVO partnerApprovalRequestVO = (PartnerApprovalRequestVO)getVO(request, PartnerApprovalRequestVO .class);
			
			partnerApprovalRequestVO.setScgPrnrAproRqstVOs(scgPrnrAproRqstVOs);
			partnerApprovalRequestVO.setScgPrnrAproRqstCgoVOs(scgPrnrAproRqstCgoVOs);
			partnerApprovalRequestVO.setScgPrnrAproRqstFileVOs(scgPrnrAproRqstFileVOs);
			
			event.setPartnerApprovalRequestVO(partnerApprovalRequestVO);
		}
		else if(command.isCommand(FormCommand.SEARCH)) {			
			event.setPartnerApprovalRequestVO((PartnerApprovalRequestVO)getVO(request, PartnerApprovalRequestVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI01)) {			
			ScgPrnrAproRqstVO[]     scgPrnrAproRqstVOs     = (ScgPrnrAproRqstVO[])getVOs(request, ScgPrnrAproRqstVO .class, prefixs[0]);
			ScgPrnrAproRqstCgoVO[]  scgPrnrAproRqstCgoVOs  = (ScgPrnrAproRqstCgoVO[])getVOs(request, ScgPrnrAproRqstCgoVO .class, prefixs[1]);
			ScgPrnrAproRqstFileVO[] scgPrnrAproRqstFileVOs = (ScgPrnrAproRqstFileVO[])getVOs(request, ScgPrnrAproRqstFileVO .class, prefixs[2]);
			
			PartnerApprovalRequestVO partnerApprovalRequestVO = (PartnerApprovalRequestVO)getVO(request, PartnerApprovalRequestVO .class);
			
			partnerApprovalRequestVO.setScgPrnrAproRqstVOs(scgPrnrAproRqstVOs);
			partnerApprovalRequestVO.setScgPrnrAproRqstCgoVOs(scgPrnrAproRqstCgoVOs);
			partnerApprovalRequestVO.setScgPrnrAproRqstFileVOs(scgPrnrAproRqstFileVOs);
			
			event.setPartnerApprovalRequestVO(partnerApprovalRequestVO);
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