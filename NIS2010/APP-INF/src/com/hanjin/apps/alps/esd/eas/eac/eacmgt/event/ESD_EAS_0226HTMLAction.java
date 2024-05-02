/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0226HTMLAction.java
*@FileTitle : EAC 첨부 파일 내역 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.30
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.30 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.AutoAuditFileVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacSearchVO;
import com.hanjin.apps.alps.esd.eas.terminalmanage.vo.EasOpfTdrAtchFileVO;
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
 * - com.hanjin.apps.alps.esd.eas.eac 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EacSC로 실행요청<br>
 * - EacSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author HI
 * @see EacEvent 참조
 * @since J2EE 1.6
 */

public class ESD_EAS_0226HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_EAS_0226HTMLAction 객체를 생성
	 */
	public ESD_EAS_0226HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EacEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		EsdEas0226Event event = new EsdEas0226Event();

		List<String> keyList = null;

		//FILE UPLOAD하기
		if(request.getContentType()!=null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){
			try {
				FileUpload fileUpload = new FileUpload(request,SubSystemConfigFactory.get("EAS.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
				request = fileUpload.getRequest();
				keyList = (List<String>)request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS"));
			} catch(FileUploadException ex) {
				this.log.error("[FileUploadException] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			} catch(Exception ex) {
				this.log.error("[Exception] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			}
        }
		FormCommand command = FormCommand.fromRequest(request);

		if(command.isCommand(FormCommand.MULTI)) {
			AutoAuditFileVO[] autoAuditFileVOs = (AutoAuditFileVO[]) getVOs(request, AutoAuditFileVO.class);

			//파일 업로드일때  "I" 신규 인경우 saveID설정 
			if (keyList != null && autoAuditFileVOs != null) {
				//save ID 저장 역배열로 저장되어 있음..		
				int lastIdx =  keyList.size()-1;
				for (int i = 0; i < autoAuditFileVOs.length; i++) {
					AutoAuditFileVO vo = autoAuditFileVOs[i];
					String ibflag = vo.getIbflag();
					if ("I".equals(ibflag)) {
						//save id 설정
						String fileSavId = keyList.get(lastIdx--);
						if (fileSavId != null ) {
							vo.setFileSavId(fileSavId);	
						}	
					}
				}
			}
			event.setAutoAuditFileVOs(autoAuditFileVOs);	
		}else if (command.isCommand(FormCommand.SEARCH04)) {
			event.setEacSearchVO( (EacSearchVO) getVO(request, EacSearchVO.class));
		} else{
			event.setAutoAuditFileVO((AutoAuditFileVO)getVO(request, AutoAuditFileVO.class));
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