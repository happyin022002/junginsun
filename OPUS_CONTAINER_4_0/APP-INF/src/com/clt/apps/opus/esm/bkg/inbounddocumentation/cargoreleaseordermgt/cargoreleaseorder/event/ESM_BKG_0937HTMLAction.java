/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0937HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BkgDoCntrVO;
import com.clt.syscommon.common.table.BkgDoVO;

/**
 * HTTP Parser<br>
 * - argo Release Order의 Office Default From Setup 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InboundBLMgtSC로 실행요청<br>
 * - InboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author
 * @see EsmBkg0937Event 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0937HTMLAction extends HTMLActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = -3889119389133086344L;

    /**
     * ESM_BKG_0937HTMLAction 객체를 생성
     */
    public ESM_BKG_0937HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsmBkg0937Event로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

        FormCommand command = FormCommand.fromRequest(request);
        EsmBkg0937Event event = new EsmBkg0937Event();

        String doNo      = "";

        if(command.isCommand(FormCommand.SEARCH)) {
            
            doNo = request.getParameter("do_no");

            if (doNo.length() > 0 ) {
				if (doNo.length() > 10) {
					event.setDoNoSplit(doNo.substring(10));
					event.setDoNo(doNo.substring(0, 10));
				} else {
					event.setDoNo(doNo);
					event.setDoNoSplit("00");
				}
			}
            log.debug("=======================================");
            log.debug("    doNo  : "+ event.getDoNo()          );
            log.debug("    doNoSplit  : "+ event.getDoNoSplit() );
            log.debug("=======================================");
        } else if (command.isCommand(FormCommand.SEARCH01)) {
            doNo = request.getParameter("do_no");

            if (doNo.length() > 0 ) {
				if (doNo.length() > 10) {
					event.setDoNoSplit(doNo.substring(10));
					event.setDoNo(doNo.substring(0, 10));
				} else {
					event.setDoNo(doNo);
					event.setDoNoSplit("00");
				}
            }

            log.debug("=======================================");
            log.debug("    doNo  : "+ event.getDoNo()          );
            log.debug("    doNoSplit  : "+ event.getDoNoSplit() );
            log.debug("=======================================");
        	
        } else if (command.isCommand(FormCommand.MULTI)) {
            log.debug("===================================");
            log.debug("    setupEuDoRcvrInfo  EVENT       ");
            log.debug("===================================");
            
            event.setBkgDoVOs((BkgDoVO[])getVOs(request, BkgDoVO.class,"sheet2_"));
        } else if (command.isCommand(FormCommand.MULTI01)) {
            log.debug("===================================");
            log.debug("    MAIL SEND  EVENT               ");
            log.debug("===================================");
            
            event.setBkgDoVOs((BkgDoVO[])getVOs(request, BkgDoVO.class,"sheet2_"));

            
            log.debug("=======================================");
            log.debug("    doNo  : "+ event.getBkgDoVOs()[0].getDoNo()           );
            log.debug("    doNoSplit  : "+ event.getBkgDoVOs()[0].getDoNoSplit() );
            log.debug("=======================================");
            
        } else if (command.isCommand(FormCommand.MULTI02)) {
            log.debug("===================================");
            log.debug("    FAX SEND  EVENT               ");
            log.debug("===================================");
            
            event.setBkgDoVOs((BkgDoVO[])getVOs(request, BkgDoVO.class,"sheet2_"));
            
        } else if (command.isCommand(FormCommand.MULTI03)) {
            log.debug("===================================");
            log.debug("    setupEuDoTruckerInfo  EVENT    ");
            log.debug("===================================");
            
            event.setBkgDoCntrVOs((BkgDoCntrVO[])getVOs(request, BkgDoCntrVO.class,"sheet3_"));
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