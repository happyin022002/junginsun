/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMT_COM_FAXEMAIL_HTMLAction.java
*@FileTitle : DMT_COM_FAXEMAIL_HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : MUN JUNG CHEOL
*@LastVersion : 1.0
* 2009.11.18 MUN JUNG CHEOL
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComFaxSndInfoVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComRDFaxEmailSendInfoVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.FAXEmailByPayerVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryParmVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.eeo.dmt.dmtcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DMTCommonSC로 실행요청<br>
 * - DMTCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author MUN JUNG CHEOL
 * @see DmtComFaxEmailEvent 참조
 * @since J2EE 1.4
 */

public class DMT_COM_FAXEMAIL_HTMLAction extends HTMLActionSupport {
    private static final long serialVersionUID = 1L;
    /**
     * FAX_SENDHTMLAction 객체를 생성
     */
    public DMT_COM_FAXEMAIL_HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 FaxEvent로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
        
        FormCommand command = FormCommand.fromRequest(request);
        DmtComFaxEmailEvent event = new DmtComFaxEmailEvent();
        

        if         ( command.isCommand( FormCommand.SEARCH05 ) ) {
            
            event.setDmtComFaxSndInfoVO((DmtComFaxSndInfoVO)getVO(request, DmtComFaxSndInfoVO .class));
            event.setDmtComRDFaxEmailSendInfoVO((DmtComRDFaxEmailSendInfoVO)getVO(request, DmtComRDFaxEmailSendInfoVO .class));
            
        } else if ( command.isCommand( FormCommand.SEARCH06 ) ) {
            
            event.setDmtComFaxSndInfoVO((DmtComFaxSndInfoVO)getVO(request, DmtComFaxSndInfoVO .class));
            event.setDmtComRDFaxEmailSendInfoVO((DmtComRDFaxEmailSendInfoVO)getVO(request, DmtComRDFaxEmailSendInfoVO .class));
            
        } else if ( command.isCommand( FormCommand.SEARCH07 ) ) {
            
            event.setDmtComFaxSndInfoVO((DmtComFaxSndInfoVO)getVO(request, DmtComFaxSndInfoVO .class));
            event.setDmtComRDFaxEmailSendInfoVO((DmtComRDFaxEmailSendInfoVO)getVO(request, DmtComRDFaxEmailSendInfoVO .class));
            
        } else if ( command.isCommand( FormCommand.SEARCH08 ) ) {
            
            event.setDmtComFaxSndInfoVO((DmtComFaxSndInfoVO)getVO(request, DmtComFaxSndInfoVO .class));
            event.setDmtComRDFaxEmailSendInfoVO((DmtComRDFaxEmailSendInfoVO)getVO(request, DmtComRDFaxEmailSendInfoVO .class));
            event.setOtsInquiryParmVO((OtsInquiryParmVO)getVO(request, OtsInquiryParmVO .class));
            event.setFAXEmailByPayerVO((FAXEmailByPayerVO)getVO(request, FAXEmailByPayerVO .class));
            String paycMail =  JSPUtil.getParameter(request, "paycMail".trim(), "");
            event.setAttribute("paycMail", paycMail);
            String paynMail =  JSPUtil.getParameter(request, "paynMail".trim(), "");
            event.setAttribute("paynMail", paynMail);
            String tarfMail =  JSPUtil.getParameter(request, "tarfMail".trim(), "");
            event.setAttribute("tarfMail", tarfMail);
            
        } else if ( command.isCommand( FormCommand.SEARCH09 ) ) {
            
            event.setDmtComFaxSndInfoVO((DmtComFaxSndInfoVO)getVO(request, DmtComFaxSndInfoVO .class));
            event.setDmtComRDFaxEmailSendInfoVO((DmtComRDFaxEmailSendInfoVO)getVO(request, DmtComRDFaxEmailSendInfoVO .class));
            event.setOtsInquiryParmVO((OtsInquiryParmVO)getVO(request, OtsInquiryParmVO .class));
            event.setFAXEmailByPayerVO((FAXEmailByPayerVO)getVO(request, FAXEmailByPayerVO .class));
            String paycMail =  JSPUtil.getParameter(request, "paycMail".trim(), "");
            event.setAttribute("paycMail", paycMail);
            String paynMail =  JSPUtil.getParameter(request, "paynMail".trim(), "");
            event.setAttribute("paynMail", paynMail);
            String tarfMail =  JSPUtil.getParameter(request, "tarfMail".trim(), "");
            event.setAttribute("tarfMail", tarfMail);
            
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
