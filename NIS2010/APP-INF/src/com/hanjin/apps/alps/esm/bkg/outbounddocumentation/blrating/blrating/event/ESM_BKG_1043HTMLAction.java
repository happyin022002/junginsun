/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1043HTMLAction.java
 *@FileTitle : Container Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.04
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.09.04 김영출
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BlRatingSC로 실행요청<br>
 * - BlRatingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Kim Youngchul
 * @see BlRatingEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_1043HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;

    /**
     * ESM_BKG_1043HTMLAction 객체를 생성
     */
    public ESM_BKG_1043HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 BlRatingEvent로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

        FormCommand command = FormCommand.fromRequest(request);
        EsmBkg1043Event event = new EsmBkg1043Event();
        log.debug("***** ESM_BKG_1043HTMLAction : " + command.getCommand());

        event.setBkgNo(JSPUtil.getParameter(request, "bkg_no"));
        event.setBlNo(JSPUtil.getParameter(request, "bl_no"));
        if(command.isCommand(FormCommand.MULTI)) {
            
            //CntrRtBkgInfoVO cntrRtBkgInfoVO = (CntrRtBkgInfoVO) getVO(request, CntrRtBkgInfoVO.class);
            CntrRtVO[] cntrRtVOs = (CntrRtVO[])getVOs(request, CntrRtVO.class, "");
            
            CntrRtOutVO cntrRtOutVO = new CntrRtOutVO();
            //cntrRtOutVO.setCntrRtBkgInfoVO(cntrRtBkgInfoVO);
            cntrRtOutVO.setCntrRtVOs(getCntrRtList(cntrRtVOs));
            
            
            event.setCntrRtOutVO(cntrRtOutVO);
        }

        return event;
    }

    /**
     * @param cntrRtVOs
     * @return
     */
    private List<CntrRtVO> getCntrRtList(CntrRtVO[] cntrRtVOs) {
        List<CntrRtVO> list = new ArrayList<CntrRtVO>();
        int len = cntrRtVOs == null ? 0 : cntrRtVOs.length;
        for(int i=0;i<len;i++){
            list.add(cntrRtVOs[i]);
        }
        return list;
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