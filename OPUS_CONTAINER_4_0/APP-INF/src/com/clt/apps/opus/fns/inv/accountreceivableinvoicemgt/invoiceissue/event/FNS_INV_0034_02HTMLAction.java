/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0034_02HTMLAction.java
*@FileTitle : Invoice Issue (Email)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.07.06 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.PrintInvoiceVO;
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
 * - com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jung Hwi Taek
 * @see AccountReceivableInvoiceMgtEvent 참조
 * @since J2EE 1.6
 */

public class FNS_INV_0034_02HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0034_02HTMLAction 객체를 생성
	 */
	public FNS_INV_0034_02HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv003402Event event = new FnsInv003402Event();		
		
		// FILE UPLOAD하기
		if(request.getContentType() != null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){
			try {
				FileUpload fileUpload = new FileUpload(request,SubSystemConfigFactory.get("COM.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event, false);
				request = fileUpload.getRequest();
			} catch(FileUploadException ex) {
				this.log.error("[FileUploadException] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			} catch(Exception ex) {
				this.log.error("[Exception] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			}
			event.setKeys((List<String>)request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS")));
			event.setAttribute("FILE_SAV_ID", (List<String>)request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS")));
		}
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			
			event.setPrtInvoiceVo((PrintInvoiceVO)getVO(request, PrintInvoiceVO .class));		
		
	    } else if(command.isCommand(FormCommand.MULTI01) || command.isCommand(FormCommand.MULTI02)) {
			
			event.setSendFlag(request.getParameter("send_flag"));	
			event.setSendFlag2(request.getParameter("send_flag2"));	
			event.setIssueGubn(request.getParameter("issue_gubn"));
//			event.setOfcCd(request.getParameter("login_ofc_cd"));
			event.setOfcCd(request.getParameter("iss_ofc_cd"));
			event.setOfficeCntCd(request.getParameter("office_cnt_cd"));
			
			event.setRdName(request.getParameter("rd_name"));
			event.setSendType(request.getParameter("send_type"));
			event.setIssueType(request.getParameter("issue_type"));
			event.setCopyCnt(request.getParameter("copy_cnt"));
			event.setIssLehbb(request.getParameter("iss_lehbb"));
			event.setLogoGb(request.getParameter("logo_gb"));
			
			event.setIssMainVOs((InvIssMainVO[])getVOs(request, InvIssMainVO .class, "sheet1_"));
			
	    }
		
		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param EventResponse eventResponse
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param Event event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}