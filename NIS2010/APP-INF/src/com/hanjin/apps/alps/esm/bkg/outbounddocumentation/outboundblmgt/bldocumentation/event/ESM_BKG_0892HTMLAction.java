/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UI_BKG_0892HTMLAction.java
 *@FileTitle : Container No Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.24
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.24 김영출
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의
 * Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OutboundBLMgtSC로 실행요청<br>
 * - OutboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Kim Youngchul
 * @see OutboundBLMgtEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0892HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;

    /**
     * UI_BKG_0892HTMLAction 객체를 생성
     */
    public ESM_BKG_0892HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 OutboundBLMgtEvent로 파싱하여 request에 셋팅<br>
     *
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

        FormCommand command = FormCommand.fromRequest(request);
        EsmBkg0892Event event = new EsmBkg0892Event();
        log.debug("##### CALL:UI_BKG_0892HTMLAction - " + command.getCommand());

        String bkgVvd    = JSPUtil.getParameter(request, "bkg_vvd", "");
        String bkgOfcCd  = JSPUtil.getParameter(request, "bkg_ofc_cd", "");
        String bkgPol    = JSPUtil.getParameter(request, "bkg_pol", "");
        String bkgPod    = JSPUtil.getParameter(request, "bkg_pod", "");
        String cfmFlg    = JSPUtil.getParameter(request, "cfm_flg", "");

        event.setBkgVvd(bkgVvd);
        event.setBkgOfcCd(bkgOfcCd);
        event.setBkgPol(bkgPol);
        event.setBkgPod(bkgPod);
        event.setCfmFlg(cfmFlg);

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