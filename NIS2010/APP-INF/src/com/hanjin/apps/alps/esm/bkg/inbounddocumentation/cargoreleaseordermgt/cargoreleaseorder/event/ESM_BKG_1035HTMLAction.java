/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1035HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.06.25 안진응
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgDoVO;

/**
 * HTTP Parser<br>
 * - argo Release Order의 Office Default From Setup 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InboundBLMgtSC로 실행요청<br>
 * - InboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lim Jin Young
 * @see EsmBkg1035Event 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_1035HTMLAction extends HTMLActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = -3889119389133086344L;

    /**
     * ESM_BKG_1035HTMLAction 객체를 생성
     */
    public ESM_BKG_1035HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsmBkg1035Event로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

        FormCommand command = FormCommand.fromRequest(request);
        EsmBkg1035Event event = new EsmBkg1035Event();

        String bkg_no = request.getParameter("bkg_no");
		event.setBkgNo(bkg_no);

        if(command.isCommand(FormCommand.SEARCH)) {
            
			log.debug("=======================================");
            log.debug("    bkg_no  : "+ event.getBkgNo()       );
            log.debug("=======================================");
        
		} else if (command.isCommand(FormCommand.MULTI)) {
            
			log.debug("===================================");
            log.debug("    MULTI(INSERT, UPDATE)  EVENT   ");
            log.debug("===================================");
            
            BkgDoVO[] bkgDoVOs = (BkgDoVO[])getVOs(request, BkgDoVO.class,"sheet1_");
            
            if (bkgDoVOs != null && bkgDoVOs.length > 0){            
            	event.setBkgDoVo(bkgDoVOs[0]);
            }
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