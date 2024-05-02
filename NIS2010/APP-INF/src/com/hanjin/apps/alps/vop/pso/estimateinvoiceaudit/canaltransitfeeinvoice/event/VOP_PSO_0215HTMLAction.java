/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0215HTMLAction.java
*@FileTitle : File Download
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.03.05 진마리아
* 1.0 Creation
* 
* History
* 2012.04.09 진마리아 CHM-201217036-01 SPP-Port SO/ Actual Invoice 화면 변경 및 기능, 로직 추가 - file download는 전도금이 아닌 invoice 화면으로 수정
* 2016.03.14 CHM-201640418 승인 단계에서 파일 첨부 기능 추가
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.event;
		
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.AtchFileVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffAtchFileVO;
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
import com.hanjin.syscommon.common.table.PsoCnlTzAtchFileVO;
import com.hanjin.syscommon.common.table.PsoTrfAtchFileVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EstimateInvoiceAuditSC로 실행요청<br>
 * - EstimateInvoiceAuditSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Jin Ihl
 * @see EstimateInvoiceAuditEvent 참조
 * @since J2EE 1.6
 */

public class VOP_PSO_0215HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_PSO_0215HTMLAction 객체를 생성
	 */
	public VOP_PSO_0215HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EstimateInvoiceAuditEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	
		VopPso0215Event event = new VopPso0215Event();
		String[] keys = null;
				
		//FILE UPLOAD하기
		if (request.getContentType() != null 
				&& request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())) {
			try {
				FileUpload fileUpload = new FileUpload(request, SubSystemConfigFactory.get("PSO.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
				request = fileUpload.getRequest();
				List keyList = (List<String>) request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS"));
				keys = (String[]) keyList.toArray(new String[keyList.size()]);
			} catch(FileUploadException ex) {
				this.log.error("[FileUploadException] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			} catch(Exception ex) {
				this.log.error("[Exception] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			}
        }
		
		FormCommand command = FormCommand.fromRequest(request);		
		// PsoCnlTzAtchFileVO[] psoCnlTzAtchFileVOs
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setAtchFileVO((AtchFileVO)getVO(request, AtchFileVO .class));//InvoiceNo생성용
		} else if(command.isCommand(FormCommand.MULTI)) {
			AtchFileVO atchFileVO = (AtchFileVO)getVO(request, AtchFileVO.class);
//			if(atchFileVO == null) log.debug("\n atchFileVO is null");
			PsoCnlTzAtchFileVO[] psoCnlTzAtchFileVOs = (PsoCnlTzAtchFileVO[])getVOs(request, PsoCnlTzAtchFileVO.class);
			atchFileVO.setKeys(keys);
			atchFileVO.setPsoCnlTzAtchFileVOs(psoCnlTzAtchFileVOs);
			event.setAtchFileVO(atchFileVO);
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