/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UI_BKG_1131HTMLAction.java
*@FileTitle : Import Restricted Commodities File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.16
*@LastModifier : 이인영
*@LastVersion : 1.0
* 2011.11.16 이인영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAtchFileVO;
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
 * - com.hanjin.apps.nis2010.esm.bkg.bookingmasterdata 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingMasterDataSC로 실행요청<br>
 * - BookingMasterDataSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee InYoung
 * @see BookingMasterDataEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_8101HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * UI_BKG_1131HTMLAction 객체를 생성
	 */
	public ESM_PRI_8101HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SpecialCargoBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("[START:: perform ESM_BKG_1131HTMLAction  ]==========");

		EsmPri8101Event event = new EsmPri8101Event();
		String[] keys =null;

		//FILE UPLOAD하기
		if(request.getContentType()!=null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){

			try {

				FileUpload fileUpload = new FileUpload(request,SubSystemConfigFactory.get("PRI.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
				request = fileUpload.getRequest();
				List keyList = (List<String>)request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS"));
				keys = (String[])keyList.toArray(new String[keyList.size()]);

			} catch(FileUploadException ex) {
				this.log.error("[FileUploadException] : "+ex.getMessage());
				if(ex.getMessage().indexOf("Posted content length") > -1){
					// File Size 가 5M 이상이면, SC를 호출하여 Error Message 를 표시한다.
					event.setFileSizeChkFlg("Y"); 
				} else {
					throw new HTMLActionException(new ErrorHandler(ex).getMessage());
				}
			} catch(Exception ex) {
				this.log.error("[Exception] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			}
        }

		
		FormCommand command = FormCommand.fromRequest(request);
		if(command.isCommand(FormCommand.SEARCH)) {
			PriScqAtchFileVO priScqAtchFileVO 	= (PriScqAtchFileVO)getVO(request, PriScqAtchFileVO .class);
			event.setPriScqAtchFileVO(priScqAtchFileVO);
		}
		else if(command.isCommand(FormCommand.MULTI)) {

			PriScqAtchFileVO[] priScqAtchFileVOs = (PriScqAtchFileVO[])getVOs(request, PriScqAtchFileVO .class,"sheet1_");
			String[] saveIds = keys;
			//priScqAtchFileVOs.setKeys(keys);
			//priScqAtchFileVOs.setBkgImpImgStoVOs(bkgImpImgStoVOs);
			event.setPriScqAtchFileVOs(priScqAtchFileVOs);
			event.setSaveIds(saveIds);
		}

		request.setAttribute("Event", event);
		log.debug("[END:: perform ESM_BKG_1131HTMLAction  ]==========");
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