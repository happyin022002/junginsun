/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_7010HTMLAction.java
*@FileTitle : DEM/DET User Role Match
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.16
*@LastModifier : Lim Chang Bin
*@LastVersion : 1.0
** 2013.07.16 Lim Chang Bin
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.syscommon.common.table.DmtUsrRoleMtchVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchUserRoleInfoListVO;
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
 * @author Lim Chang Bin
 * @see DMTExceptionMgtEvent 참조
 * @since J2EE 1.4
 */

public class EES_DMT_7010HTMLAction extends HTMLActionSupport {
    
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
        EesDmt7010Event event = new EesDmt7010Event();
        
        if(command.isCommand(FormCommand.SEARCH)) {
        	 String usr_id =  JSPUtil.getParameter(request, "usr_id".trim(), "");
        	 String usr_locl_nm =  JSPUtil.getParameter(request, "usr_locl_nm".trim(), "");
        	 String ofc_cd =  JSPUtil.getParameter(request, "ofc_cd".trim(), "");
        	 String usr_role_cd =  JSPUtil.getParameter(request, "usr_role_cd".trim(), "");
        	 
	         event.setAttribute("usr_id", usr_id);
	         event.setAttribute("usr_locl_nm", usr_locl_nm);
	         event.setAttribute("usr_role_cd", usr_role_cd);
	         event.setAttribute("ofc_cd", ofc_cd);
		} else if(command.isCommand(FormCommand.MULTI)) {
			event.setDmtUsrRoleMtchVOs((DmtUsrRoleMtchVO[])getVOs(request, DmtUsrRoleMtchVO .class, ""));
		} else if(command.isCommand(FormCommand.SEARCH22)) {
			String usr_id =  JSPUtil.getParameter(request, "chk_usr_id".trim(), "");
			event.setAttribute("usr_id", usr_id);
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
