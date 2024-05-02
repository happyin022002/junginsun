/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_ESD_SCE_0028HTMLAction.java
*@FileTitle : Exception Alert/통지 대상 등록 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-31
*@LastModifier : yongcheon_shin
*@LastVersion : 1.0
* 2006-08-31 yongcheon_shin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event;


import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptNotSubInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptSubReqInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptSubReqListVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.sce 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ScemSetupSC로 실행요청<br>
 * - ScemSetupSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author yongcheon_shin
 * @see EsdSce0028Event , UI_EsdSce0028EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0028HTMLAction extends HTMLActionSupport {
	
	private static final long serialVersionUID = 1L;
    /**
     * UI_ESD_SCE_0028HTMLAction 객체를 생성
     */
    public ESD_SCE_0028HTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 UI_EsdSce0028Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	log.debug("Event 0028 생성!!");
        
    	EsdSce0028Event event = new EsdSce0028Event();
        FormCommand f_cmd = FormCommand.fromRequest(request);
        
        if (f_cmd.isCommand(FormCommand.SEARCHLIST)) {
        	log.debug("SEARCHLIST 를 위한 호출"); 
        	SearchExptSubReqInfoVO command = new SearchExptSubReqInfoVO();
        	command.setCopExptSubscGrpCd(JSPUtil.getParameter(request, "SubscriberGroup", ""));
        	command.setNtfdOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
        	event.setReqInfo(command);
        	event.setReqList((SearchExptSubReqListVO) getVO(request, SearchExptSubReqListVO.class));
        } else if (f_cmd.isCommand(FormCommand.MULTI)) {
        	log.debug("MULTI 를 위한 호출"); 
        	event.setExptNotSubs((SearchExptNotSubInfoVO[]) getVOs(request, SearchExptNotSubInfoVO.class));
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