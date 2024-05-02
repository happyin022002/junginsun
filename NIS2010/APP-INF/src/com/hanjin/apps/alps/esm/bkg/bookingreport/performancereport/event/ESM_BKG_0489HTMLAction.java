/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0489HTMLAction.java
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.15 강동윤
* 1.0 Creation
* 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueBkgHistListVO;
import com.hanjin.framework.component.attachment.file.upload.ByTimestampFileRenamePolicy;
import com.hanjin.framework.component.attachment.file.upload.FileUpload;
import com.hanjin.framework.component.attachment.file.upload.FileUploadException;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.MultipartRequest;
import com.hanjin.framework.component.util.file.FileMetaDataManager;
import com.hanjin.framework.component.util.file.ModuleMetaData;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.fileupload.event.FileUploadEvent;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.bookingreport 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingReportSC로 실행요청<br>
 * - BookingReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author kang dong yun
 * @see BookingReportEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0489HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0489HTMLAction 객체를 생성
	 */
	public ESM_BKG_0489HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BookingReportEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0489Event event = new EsmBkg0489Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			String bkgSrKndCd 	= JSPUtil.getParameter(request, "sr_knd_cd");
			String srNo  		= JSPUtil.getParameter(request, "sr_no");
			String faxLogRefNo  = JSPUtil.getParameter(request, "fax_log_ref_no");
			String rcvDt		= JSPUtil.getParameter(request, "rcv_dt");
			String downloadLocation		= JSPUtil.getParameter(request, "downloadLocation");
			
			event.setRcvDt(rcvDt.replaceAll("-", "").replaceAll(":", "").replaceAll(" ", ""));
			event.setBkgSrKndCd(bkgSrKndCd);
			event.setSrNo(srNo);
			event.setFaxLogRefNo(faxLogRefNo);
			event.setDownloadLocation(downloadLocation);
			
		}else if(command.isCommand(FormCommand.SEARCH01)){

			String bkgSrKndCd 	= JSPUtil.getParameter(request, "sr_knd_cd");
			String srNo  		= JSPUtil.getParameter(request, "sr_no");
			String faxLogRefNo  = JSPUtil.getParameter(request, "fax_log_ref_no");
			String rcvDt		= JSPUtil.getParameter(request, "rcv_dt");
			
			event.setRcvDt(rcvDt.replaceAll("-", "").replaceAll(":", "").replaceAll(" ", ""));
			event.setBkgSrKndCd(bkgSrKndCd);
			event.setSrNo(srNo);
			event.setFaxLogRefNo(faxLogRefNo);
		}else if(command.isCommand(FormCommand.SEARCH02)){
			
			String bkgNo = JSPUtil.getParameter(request, "bkg_no");
			String srNo  = JSPUtil.getParameter(request, "sr_no");
			String faxLogRefNo  = JSPUtil.getParameter(request, "fax_log_ref_no");
			
			event.setBkgNo(bkgNo);
			event.setSrNo(srNo);
			event.setFaxLogRefNo(faxLogRefNo);
		}else if(command.isCommand(FormCommand.MODIFY01)){
			
			String bkgSrKndCd 	= JSPUtil.getParameter(request, "sr_knd_cd");
			String srNo  		= JSPUtil.getParameter(request, "sr_no");
			String faxLogRefNo  = JSPUtil.getParameter(request, "fax_log_ref_no");
			
			event.setBkgSrKndCd(bkgSrKndCd);
			event.setSrNo(srNo);
			event.setFaxLogRefNo(faxLogRefNo);
			event.setDocQueueBkgHistListVO((DocQueueBkgHistListVO)getVO(request, DocQueueBkgHistListVO .class));
		}else if(command.isCommand(FormCommand.REMOVE)){
			String srNo  		= JSPUtil.getParameter(request, "sr_no");
			String faxLogRefNo  = JSPUtil.getParameter(request, "fax_log_ref_no");
			event.setSrNo(srNo);	
			event.setFaxLogRefNo(faxLogRefNo);
			event.setDocQueueBkgHistListVO((DocQueueBkgHistListVO)getVO(request, DocQueueBkgHistListVO .class));
		}else if(command.isCommand(FormCommand.ADD)){
			
			event.setDocQueueBkgHistListVO((DocQueueBkgHistListVO)getVO(request, DocQueueBkgHistListVO .class));
		/*}else if(command.isCommand(FormCommand.MODIFY02)){
			
			event.setDocQueueBkgHistListVO((DocQueueBkgHistListVO)getVO(request, DocQueueBkgHistListVO .class));*/
		}else if(command.isCommand(FormCommand.MULTI) || command.isCommand(FormCommand.MULTI01)){
			event.setDocQueueBkgHistListVOS((DocQueueBkgHistListVO[])getVOs(request, DocQueueBkgHistListVO .class,""));
			event.setDocQueueBkgHistListVO((DocQueueBkgHistListVO)getVO(request, DocQueueBkgHistListVO .class));
			
			String srNo  		= JSPUtil.getParameter(request, "sr_no");
			String faxLogRefNo  = JSPUtil.getParameter(request, "fax_log_ref_no");
			event.setSrNo(srNo);	
			event.setFaxLogRefNo(faxLogRefNo);
			
			
			String bkgSrKndCd 	= JSPUtil.getParameter(request, "sr_knd_cd");
			String bkgNo  		= JSPUtil.getParameter(request, "bkg_no");
			
			event.setBkgSrKndCd(bkgSrKndCd);
			event.setBkgNo(bkgNo);
			
			//로컬 테스트를 위한 구현 ------------------------------------------------------------------
//			FileUploadEvent fileUploadEvent = new FileUploadEvent();
//			FileUpload fileUpload;
//			MultipartRequest multiReq = null; // 화일업로드 처리객체
//			// HttpServletRequest 객체를 받아서 업로드를 처리 ( request, 저장경로, 제한용량, 파일명 );	
//			ModuleMetaData fmd = FileMetaDataManager.getInstance().getFileMetaData(context, "TPB");
////			String filePath = fmd.getWork_dir();
//			String filePath = "D:\\Temp\\TPB";
//			try {
//				multiReq = new MultipartRequest(request, filePath, Integer.parseInt(fmd.getMax_size()), new ByTimestampFileRenamePolicy()); 
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} 
//
//			fileUpload = new FileUpload();
//			fileUpload.setInitRequest(multiReq);
//			fileUpload.setModuleId(SubSystemConfigFactory.get("TMP.MODULE.ID"));
//			fileUpload.setEncoding(SubSystemConfigFactory.get("COM.ENCODING.EUCKR"));
//			fileUpload.setEvent(fileUploadEvent);
//			fileUpload.setIsMail(false);
//			try {
//				fileUpload.doUpload();
//			} catch (FileUploadException e) {
//				this.log.error("[FileUploadException]"+e.getMessage());
//				throw new HTMLActionException("[FileUploadException]"+e.getMessage());
//
//			}
//			HttpServletRequest multipartRequest = fileUpload.getRequest();
//			fileUploadEvent.setModuleId(multipartRequest.getParameter("subSysCd"));
//			fileUploadEvent.setKeys((List<String>)multipartRequest.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS")));
//			event.setAttribute("fileUploadEvent", fileUploadEvent);
			//-------------------------------------------------------------------------------
		}else if(command.isCommand(FormCommand.MODIFY04)){
			String bkgSrKndCd 	= JSPUtil.getParameter(request, "sr_knd_cd");
			String srNo  		= JSPUtil.getParameter(request, "sr_no");
			String faxLogRefNo  = JSPUtil.getParameter(request, "fax_log_ref_no");
			
			event.setBkgSrKndCd(bkgSrKndCd);
			event.setSrNo(srNo);	
			event.setFaxLogRefNo(faxLogRefNo);
			event.setDocQueueBkgHistListVO((DocQueueBkgHistListVO)getVO(request, DocQueueBkgHistListVO .class));
		}else if(command.isCommand(FormCommand.MODIFY05)){
			String bkgSrKndCd 	= JSPUtil.getParameter(request, "sr_knd_cd");
			String srNo  		= JSPUtil.getParameter(request, "sr_no");
			String faxLogRefNo  = JSPUtil.getParameter(request, "fax_log_ref_no");
			String bkgNo  		= JSPUtil.getParameter(request, "bkg_no");
			
			event.setBkgSrKndCd(bkgSrKndCd);
			event.setSrNo(srNo);
			event.setFaxLogRefNo(faxLogRefNo);
			event.setBkgNo(bkgNo);
			event.setDocQueueBkgHistListVO((DocQueueBkgHistListVO)getVO(request, DocQueueBkgHistListVO .class));
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