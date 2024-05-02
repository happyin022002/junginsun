/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_7009HTMLAction.java
*@FileTitle : Exception Cost by Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.03
*@LastModifier : Kim Hyun Hwa
*@LastVersion : 1.0
* 2012.08.03 Kim Hyun Hwa
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.event;

import javax.servlet.http.HttpServletRequest;


import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.DmtYdExptCostParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.DmtYdExptCostVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArLoclChgVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.apls.ees.dmt.dmtexceptionmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DMTExceptionMgtSC로 실행요청<br>
 * - DMTInvoiceMgtSC 에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Hyun Hwa
 * @see DMTExceptionMgtEvent 참조
 * @since J2EE 1.4
 */

public class EES_DMT_7009HTMLAction extends HTMLActionSupport {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 InvoiceMgtEvent로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
        
        FormCommand command = FormCommand.fromRequest(request);
        EesDmt7009Event event = new EesDmt7009Event();
        

        if(command.isCommand(FormCommand.SEARCH)) {
            event.setDmtYdExptCostParmVO((DmtYdExptCostParmVO)getVO(request, DmtYdExptCostParmVO .class));
        } else if(command.isCommand(FormCommand.SEARCH01)) {
        	 String yd_cd =  JSPUtil.getParameter(request, "yd_cd".trim(), "");
        	 String eff_dt =  JSPUtil.getParameter(request, "eff_dt".trim(), "");
        	 String exp_dt =  JSPUtil.getParameter(request, "exp_dt".trim(), "");
	         event.setAttribute("yd_cd",  yd_cd);
	         event.setAttribute("eff_dt", eff_dt);
	         event.setAttribute("exp_dt", exp_dt);
	         
		} else if(command.isCommand(FormCommand.COMMAND01)) {
			event.setDmtYdExptCostVOs((DmtYdExptCostVO[])getVOs(request, DmtYdExptCostVO .class, "sheet1_"));

		} else if(command.isCommand(FormCommand.COMMAND02)) {
			event.setDmtYdExptCostVOs((DmtYdExptCostVO[])getVOs(request, DmtYdExptCostVO .class, "sheet1_"));
			String cfmCancel =  JSPUtil.getParameter(request, "cfm_cancel".trim(), "");
			event.setAttribute("cfm_cancel",  cfmCancel);
		}
       //request.setAttribute("Event", event);
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
