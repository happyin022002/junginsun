/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0221HTMLAction.java
*@FileTitle : Awakward Cargo Application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.10 이병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SpecialCargoBookingConductSC로 실행요청<br>
 * - SpecialCargoBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Byung Kyu
 * @see SpecialCargoBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0221HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0221HTMLAction 객체를 생성
	 */
	public ESM_BKG_0221HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SpecialCargoBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0221Event event = new EsmBkg0221Event();
        log.debug("::CALL::> ESM_BKG_0221_HTMLAction - " + command.getCommand());

        if(command.isCommand(FormCommand.DEFAULT)) {
            // search Init
            String bkgNo      = JSPUtil.getParameter(request, "bkg_no");
            
            event.setBkg_no(bkgNo);
                     
        } else if(command.isCommand(FormCommand.SEARCH01)) {
            
            String bkgNo = JSPUtil.getParameter(request, "bkg_no");
            
			String mfFlag = JSPUtil.getParameter(request, "mfFlag");
			String rdFormId = JSPUtil.getParameter(request, "rdFormId");
			
			event.setMfFlag(mfFlag);
			event.setRdFormId(rdFormId);
			event.setDblwblvos((DblWblVO[])getVOs(request, DblWblVO .class, ""));
			
			int len = event.getDblwblvos() != null ? event.getDblwblvos().length : 0;
			
			log.debug("##############################################################");
			log.debug("");
			log.debug("event.getDblwblvos() : [" + event.getDblwblvos() + "]");
			log.debug("len : [" + len + "]");
			
			for(int i=0; i < len; i++) {
				//
				log.debug("mrd : [" + event.getDblwblvos()[i].getTmplmrd() + "]");
				log.debug("mrdP : [" + event.getDblwblvos()[i].getTmplparam() + "]");
				log.debug("mrdPdf : [" + event.getDblwblvos()[i].getTmplmrdpdf() + "]");
			}
			log.debug("");
			log.debug("##############################################################");
			
                                                
            event.setBkg_no(bkgNo);                                    
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