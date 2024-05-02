/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0013HTMLAction.java
*@FileTitle : SPCL CGO Irregular Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.05.29 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.CNTRInfoInputVO;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrrCntrVO;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrrFileListVO;
import com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrregularVO;
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
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.BkgContainerVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.vop.scg.vesseloperationirregularmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 VesselOperationIrregularMgtSC로 실행요청<br>
 * - VesselOperationIrregularMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author HyunUk Kim
 * @see VesselOperationIrregularMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_SCG_0013HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_SCG_0013HTMLAction 객체를 생성
	 */
	public VOP_SCG_0013HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VesselOperationIrregularMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	VopScg0013Event event = new VopScg0013Event();
		
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
		
		if(command.isCommand(FormCommand.MULTI)) {
			IrregularVO irregularVO = (IrregularVO)getVO(request, IrregularVO .class);
			IrrCntrVO[] irrCntrVOs = (IrrCntrVO[])getVOs(request, IrrCntrVO .class, "sheet1_");
			IrrFileListVO[] irrFileListVOs = (IrrFileListVO[])getVOs(request, IrrFileListVO .class, "sheet2_");
			
			irregularVO.setIrrCntrVOS(irrCntrVOs);
			irregularVO.setIrrFileListVOS(irrFileListVOs);
			
			event.setIrregularVO(irregularVO);
		}
		else if(command.isCommand(FormCommand.REMOVE)) {
			IrregularVO irregularVO = (IrregularVO)getVO(request, IrregularVO .class);
			IrrCntrVO[] irrCntrVOs = (IrrCntrVO[])getVOs(request, IrrCntrVO .class, "sheet1_");
			
			irregularVO.setIrrCntrVOS(irrCntrVOs);
			
			event.setIrregularVO(irregularVO);
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setIrregularVO((IrregularVO)getVO(request, IrregularVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setBkgBookingVO((BkgBookingVO)getVO(request, BkgBookingVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setBkgBookingVO((BkgBookingVO)getVO(request, BkgBookingVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setCNTRInfoInputVO((CNTRInfoInputVO)getVO(request, CNTRInfoInputVO .class));
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