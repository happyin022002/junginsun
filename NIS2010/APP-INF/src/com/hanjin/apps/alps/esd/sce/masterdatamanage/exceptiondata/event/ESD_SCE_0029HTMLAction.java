/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_ESD_SCE_0029HTMLAction.java
*@FileTitle : Exception 식별 기준 등록 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-04
*@LastModifier : yongcheon_shin
*@LastVersion : 1.0
* 2006-09-04 yongcheon_shin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDTLTPListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptTPListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceMultiInfoVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ScemSetupSC로 실행요청<br>
 * - ScemSetupSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author yongcheon_shin
 * @see EsdSce0029Event , UI_EsdSce0029EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0029HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
    /**
     * UI_ESD_SCE_0029HTMLAction 객체를 생성
     */
    public ESD_SCE_0029HTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 UI_EsdSce0029Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

    	log.debug("Event 0029 생성!!");
        
    	EsdSce0029Event event = new EsdSce0029Event();
        FormCommand f_cmd = FormCommand.fromRequest(request);
        
        if (f_cmd.isCommand(FormCommand.SEARCHLIST)) {
        	log.debug("SEARCHLIST 를 위한 호출"); 
        	SearchToleranceInfoVO command = new SearchToleranceInfoVO();
        	command.setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
        	command.setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
        	command.setHExptTp(JSPUtil.getParameter(request, "h_expt_tp", ""));
        	command.setHExptTpDtl(JSPUtil.getParameter(request, "h_expt_tp_dtl", ""));
        	event.setTolInfo(command);
        	event.setTolList((SearchToleranceListVO) getVO(request, SearchToleranceListVO.class));
        } else if (f_cmd.isCommand(FormCommand.SEARCH12)) {
        	log.debug("SEARCH12 를 위한 호출"); 
        	event.setExptTpList((SearchExptTPListVO) getVO(request, SearchExptTPListVO.class));
        } else if (f_cmd.isCommand(FormCommand.SEARCH13)) {
        	log.debug("SEARCH13 를 위한 호출"); 
        	SearchExpInfoVO command = new SearchExpInfoVO();
        	command.setFExptTp(JSPUtil.getParameter(request, "expt_type", ""));
        	event.setExpInfo(command);
        	event.setExptDtlTpList((SearchExptDTLTPListVO) getVO(request, SearchExptDTLTPListVO.class));
        } else if (f_cmd.isCommand(FormCommand.MULTI)) {
        	log.debug("MULTI 를 위한 호출"); 
        	event.setMultiInfos((SearchToleranceMultiInfoVO[]) getVOs(request, SearchToleranceMultiInfoVO.class));
        }

		/*Enumeration em = (Enumeration) request.getParameterNames();
		while( em.hasMoreElements() ) {
			String keyName = (String) em.nextElement();
			param.put(keyName, JSPUtil.getParameter(request, keyName, ""));
		}
			
		event.setHashParam(param);*/
		
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