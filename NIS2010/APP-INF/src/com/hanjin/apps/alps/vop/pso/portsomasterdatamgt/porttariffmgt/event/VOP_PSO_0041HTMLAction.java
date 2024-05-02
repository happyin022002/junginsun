package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.hanjin.syscommon.common.table.PsoTrfAtchFileVO;

public class VOP_PSO_0041HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		VopPso0041Event event = new VopPso0041Event();
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
		if(command.isCommand(FormCommand.SEARCH)) {
			TariffAtchFileVO tariffUploadFileVO = (TariffAtchFileVO)getVO(request, TariffAtchFileVO.class);
			event.setTariffAtchFileVO(tariffUploadFileVO);
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			TariffAtchFileVO tariffAtchFileVO = (TariffAtchFileVO)getVO(request, TariffAtchFileVO.class);
			PsoTrfAtchFileVO[] psoTrfAtchFileVOs = (PsoTrfAtchFileVO[])getVOs(request, PsoTrfAtchFileVO.class, "sheet1_");
			tariffAtchFileVO.setKeys(keys);
			tariffAtchFileVO.setPsoTrfAtchFileVOs(psoTrfAtchFileVOs);
			event.setTariffAtchFileVO(tariffAtchFileVO);
		}

		request.setAttribute("Event", event);
		
		return event;
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
