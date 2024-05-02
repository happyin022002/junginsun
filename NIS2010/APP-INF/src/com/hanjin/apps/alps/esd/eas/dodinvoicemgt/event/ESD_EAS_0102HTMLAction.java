/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESD_EAS_0102HTMLAction.java
*@FileTitle : DOD Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.09.12 이혜민
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceListVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.SearchDODInvoiceListInputVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * @author Hyemin Lee
 * @see EsdEas0102Event , ESD_EAS_0102EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_EAS_0102HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
     * ESD_EAS_0102HTMLAction 객체를 생성
     */
    public ESD_EAS_0102HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_EAS_0102Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsdEas0102Event event = new EsdEas0102Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchDODInvoiceListInputVO((SearchDODInvoiceListInputVO)getVO(request, SearchDODInvoiceListInputVO .class));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setDODInvoiceListVOs ((DODInvoiceListVO[]) getVOs(request, DODInvoiceListVO .class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setDODInvoiceListVOs ((DODInvoiceListVO[]) getVOs(request, DODInvoiceListVO .class));
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