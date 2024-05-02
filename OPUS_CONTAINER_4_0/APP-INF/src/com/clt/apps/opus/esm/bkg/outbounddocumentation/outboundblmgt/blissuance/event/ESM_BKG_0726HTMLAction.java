/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0726HTMLAction.java
 *@FileTitle : Group Update for B/L Issue And Onboard Date
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.15
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.07.15 김영출
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OutboundBLMgtSC로 실행요청<br>
 * - OutboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Kim Youngchul
 * @see OutboundBLMgtEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0726HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;

    /**
     * ESM_BKG_0726HTMLAction 객체를 생성
     */
    public ESM_BKG_0726HTMLAction() {}

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
        EsmBkg0726Event event = new EsmBkg0726Event();
        log.debug("***** ESM_BKG_0726HTMLAction : " + command.getCommand());

        if(command.isCommand(FormCommand.DEFAULT)) {
            event.setTVvd(JSPUtil.getParameter(request, "t_vvd", ""));
            event.setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
        } else if(command.isCommand(FormCommand.SEARCH)) {
            GrpBlDtVO grpBlDtVO = new GrpBlDtVO();
            GrpBlDtInVO grpBlEtcVO = (GrpBlDtInVO) getVO(request, GrpBlDtInVO.class);
            
            grpBlDtVO.setGrpBlDtInVO(grpBlEtcVO);
            
            event.setGrpBlDtVO(grpBlDtVO);
        } else if(command.isCommand(FormCommand.MULTI)) {
            GrpBlDtVO grpBlDtVO = new GrpBlDtVO();
            GrpBlDtInVO grpBlEtcVO = (GrpBlDtInVO) getVO(request, GrpBlDtInVO.class);
            GrpBlDtListVO[] grpBlDtListVOs = (GrpBlDtListVO[]) getVOs(request, GrpBlDtListVO.class, "sheet1_");
            
            grpBlDtVO.setGrpBlDtInVO(grpBlEtcVO);
            grpBlDtVO.setGrpBlDtListVOs(getGrpBlDtListVOList(grpBlDtListVOs));
            
            event.setGrpBlDtVO(grpBlDtVO);
        } else if(command.isCommand(FormCommand.SEARCH01)) {
        	event.setKey(request.getParameter("backendjob_key"));
        } else if(command.isCommand(FormCommand.SEARCH02)) {
        	event.setKey(request.getParameter("backendjob_key"));
        }

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
    
    
    /**
     * getGrpBlDtListVOList
     * 
     * @param vos
     * @return
     */
    private List<GrpBlDtListVO> getGrpBlDtListVOList(GrpBlDtListVO[] vos){
        List<GrpBlDtListVO> list = new ArrayList<GrpBlDtListVO>();
        int len = (vos == null) ? 0 : vos.length;
        for(int i=0;i<len; i++){
            list.add(vos[i]);
        }
        return list;
    }    
    
}