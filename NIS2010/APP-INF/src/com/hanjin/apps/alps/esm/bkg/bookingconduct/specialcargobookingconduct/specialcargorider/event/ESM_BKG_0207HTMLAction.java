/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UI_BKG_0207HTMLAction.java
*@FileTitle : B/L Rider
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.16 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderInVO;
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
import com.hanjin.syscommon.common.table.BkgImgStoVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SpecialCargoBookingConductSC로 실행요청<br>
 * - SpecialCargoBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Jin Seo
 * @see SpecialCargoBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0207HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * UI_BKG_0207HTMLAction 객체를 생성
	 */
	public ESM_BKG_0207HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SpecialCargoBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("[START:: perform ESM_BKG_0207HTMLAction  ]==========");

		EsmBkg0207Event event = new EsmBkg0207Event();
		String[] keys =null;

		//FILE UPLOAD하기
		if(request.getContentType()!=null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){

			try {

				FileUpload fileUpload = new FileUpload(request,SubSystemConfigFactory.get("BKG.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
				request = fileUpload.getRequest();
				List keyList = (List<String>)request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS"));
				keys = (String[])keyList.toArray(new String[keyList.size()]);

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


			SpclRiderInVO spclRiderInVO = (SpclRiderInVO)getVO(request, SpclRiderInVO.class);
			event.setSpclRiderInVO(spclRiderInVO);

		}
		else if(command.isCommand(FormCommand.MULTI)) {

			SpclRiderInVO spclRiderInVO 	= (SpclRiderInVO)getVO(request, SpclRiderInVO.class);
			BkgImgStoVO[] bkgImgStoVOs 	= (BkgImgStoVO[])getVOs(request, BkgImgStoVO .class,"sheet1_");
			spclRiderInVO.setKeys(keys);
			spclRiderInVO.setBkgImgStoVOs(bkgImgStoVOs);
			event.setSpclRiderInVO(spclRiderInVO);

		}

		request.setAttribute("Event", event);
		log.debug("[END:: perform ESM_BKG_0207HTMLAction  ]==========");
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