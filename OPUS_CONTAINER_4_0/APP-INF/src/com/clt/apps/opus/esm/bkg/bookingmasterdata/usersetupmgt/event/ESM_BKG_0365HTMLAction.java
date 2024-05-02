/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UI_BKG_0365HTMLAction.java
 *@FileTitle : Mark & Description Template
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.27
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.27 김영출
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BkgUsrTmpltVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingmaterdata 화면을 통해 서버로 전송되는 HTML DOM
 * 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingMaterDataSC로 실행요청<br>
 * - BookingMaterDataSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Kim Youngchul
 * @see BookingMaterDataEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0365HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;

    /**
     * UI_BKG_0365HTMLAction 객체를 생성
     */
    public ESM_BKG_0365HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 BookingMaterDataEvent로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

        FormCommand command = FormCommand.fromRequest(request);
        EsmBkg0365Event event = new EsmBkg0365Event();
        log.debug("##### CALL:UI_BKG_0365HTMLAction - " + command.getCommand());

        if(command.isCommand(FormCommand.DEFAULT)){
            event.setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
            event.setTmpltTpCd(JSPUtil.getParameter(request, "tmplt_tp_cd", ""));
            event.setReturnObject(JSPUtil.getParameter(request, "rtn", ""));
        } else if(command.isCommand(FormCommand.SEARCH)) {
            event.setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
            event.setTmpltTpCd(JSPUtil.getParameter(request, "tmplt_tp_cd", ""));
            //event.setReturnObject(JSPUtil.getParameter(request, "rtn", ""));
        } else if(command.isCommand(FormCommand.MULTI)) {
            event.setBkgUsrTmpltVOS((BkgUsrTmpltVO[]) getVOs(request, BkgUsrTmpltVO.class, ""));
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