/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0037HTMLAction.java
*@FileTitle : (S.China)Invoice Issue (Email)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.09.24 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.PrintInvoiceVO;
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
 * - com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jung Hwi Taek
 * @see AccountReceivableInvoiceMgtEvent 참조
 * @since J2EE 1.6
 */

public class FNS_INV_0037HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0037HTMLAction 객체를 생성
	 */
	public FNS_INV_0037HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0037Event event = new FnsInv0037Event();
		
		// FILE UPLOAD하기
		if(request.getContentType() != null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){
			try {
				FileUpload fileUpload = new FileUpload(request,SubSystemConfigFactory.get("COM.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event, true);
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
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			
			event.setPrtInvoiceVo((PrintInvoiceVO)getVO(request, PrintInvoiceVO .class));		
		
	    } else if(command.isCommand(FormCommand.MULTI01) || command.isCommand(FormCommand.MULTI02)) {
			
			event.setSendFlag(request.getParameter("send_flag"));	
			event.setSendFlag2(request.getParameter("send_flag2"));	
			event.setIssueGubn(request.getParameter("issue_gubn"));
			event.setOfcCd(request.getParameter("iss_ofc_cd"));
			event.setRdName(request.getParameter("rd_name"));
			event.setNameFlag(request.getParameter("name_flag"));
			event.setTitleFlag(request.getParameter("title_flag"));
			event.setCopyCnt(request.getParameter("copy_cnt"));
			
			event.setIssMainVOs((InvIssMainVO[])getVOs(request, InvIssMainVO .class, "sheet1_"));
			
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