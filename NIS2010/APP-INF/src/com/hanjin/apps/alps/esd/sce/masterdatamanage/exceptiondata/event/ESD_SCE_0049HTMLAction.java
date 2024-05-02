/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESD_SCE_0049HTMLAction.java
*@FileTitle : Exception Type & Subscriber Group Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-21
*@LastModifier : JeongSeon An
*@LastVersion : 1.0
* 2007-03-21 JeongSeon An
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event;


import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDTLTPListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptTPListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchMultiSubGrpMappingVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchSubscriberGroupMappingVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceInfoVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce.masterdatamanage. 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SC로 실행요청<br>
 * - SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author JeongSeon An
 * @see EsdSce0049Event , EsdSce0049EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0049HTMLAction extends HTMLActionSupport {
	
	private static final long serialVersionUID = 1L;
	/**
	 * ESD_SCE_0049HTMLAction 객체를 생성
	 */
	public ESD_SCE_0049HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdSce0049Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
        
		log.debug("Event 0049 생성!!");
        
    	EsdSce0049Event event = new EsdSce0049Event();
        FormCommand f_cmd = FormCommand.fromRequest(request);
        
        if (f_cmd.isCommand(FormCommand.SEARCHLIST)) {
        	log.debug("SEARCHLIST 를 위한 호출"); 
        	SearchToleranceInfoVO command = new SearchToleranceInfoVO();
        	command.setHExptTp(JSPUtil.getParameter(request, "h_expt_tp", ""));
        	command.setHExptTpDtl(JSPUtil.getParameter(request, "h_expt_tp_dtl", ""));
        	event.setTolInfo(command);
        	event.setSubGrpMap((SearchSubscriberGroupMappingVO) getVO(request, SearchSubscriberGroupMappingVO.class));
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
        	event.setMultiMaps((SearchMultiSubGrpMappingVO[]) getVOs(request, SearchMultiSubGrpMappingVO.class));
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