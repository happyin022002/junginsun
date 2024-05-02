/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_OPF_0072HTMLAction.java
*@FileTitle : VNOR Supporting Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.27
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.syscommon.common.table.OpfAtchFileVO;
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
 * - com.clt.apps.opus.aon.bkk.datatransfer 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DataTransferSC로 실행요청<br>
 * - DataTransferSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see DataTransferEvent 참조 
 * @since J2EE 1.6
 */
public class VOP_OPF_0072HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * UserHTMLAction 객체를 생성
	 */
	public VOP_OPF_0072HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 UserManagementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		/**
         ibSheet 사용시 fromRequestGrid를 사용하는데
         prefix는 주로 멀티 Sheet 처리시에 사용하게 된다. (  sheet ID 형태의 prefix 구분자 )
         String prefix = "" ;
         COM_USER com_user = COM_USER.fromRequestGrid(request, prefix);
        */
		VopOpf0072Event event = new VopOpf0072Event();
		List<String> saveIdList = null;
		
		//FILE UPLOAD
		if(request.getContentType()!=null && 
				request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){
			try {
				FileUpload fileUpload = new FileUpload(request,SubSystemConfigFactory.get("OPF.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
				request = fileUpload.getRequest();
			} catch(FileUploadException ex) {
				this.log.error("[FileUploadException] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			} catch(Exception ex) {
				this.log.error("[Exception] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			}
			
			saveIdList = (List<String>) request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS"));
       }	
    	
		FormCommand command = FormCommand.fromRequest(request);
		
		if (command.isCommand(FormCommand.MULTI)) {
			OpfAtchFileVO[] opfAtchFileVOs = (OpfAtchFileVO[]) getVOs(request, OpfAtchFileVO.class);
			//파일 업로드일때  "I" 신규 인경우 saveID설정 
			if (saveIdList != null && opfAtchFileVOs != null) {
				//save ID 저장 역배열로 저장되어 있음..				 
				int lastIdx =  saveIdList.size()-1;
				for (int i = 0; i < opfAtchFileVOs.length; i++) {
					OpfAtchFileVO vo = opfAtchFileVOs[i];
					String ibflag = vo.getIbflag();
					if ("I".equals(ibflag)) {
						//save id 설정
						String fileSavId = saveIdList.get(lastIdx--);
						vo.setFileSavId(fileSavId);
					}					
				}
			}
			event.setOpfAtchFileVOs(opfAtchFileVOs);
			event.setVslCd((String) request.getParameter("vsl_cd"));
			event.setVnorSeq((String) request.getParameter("vnor_seq"));
			event.setVnorItmSeq((String) request.getParameter("vnor_itm_seq"));
			event.setAtchFileLnkId((String) request.getParameter("atch_file_lnk_id"));
			
		} else if (command.isCommand(FormCommand.SEARCH)) {
			event.setOpfAtchFileVO((OpfAtchFileVO)getVO(request, OpfAtchFileVO.class));
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