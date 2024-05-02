/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0112HTMLAction.java
*@FileTitle : Exception Office Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2008-08-06 Hun-Il Jung
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event;


import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMapgOfcList3VO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMapgOfcListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMasterOfcListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpmasterOfcInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchMultiExpOfcInfoVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

//import com.hanjin.syscommon.common.table.SCE_COP_EXPT_TP;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 UserManagerSC로 실행요청<br>
 * - MasterDataManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author 2007811
 * @see HTMLAction 참조
 * @since J2EE 1.4
 *
 */
public class ESD_SCE_0112HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
     * ESD_SCE_0112HTMLAction 객체를 생성
     */
    public ESD_SCE_0112HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsdSce0112Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
        
    	log.debug("Event 0112 생성!!");
        
    	EsdSce0112Event event = new EsdSce0112Event();
        FormCommand f_cmd = FormCommand.fromRequest(request);
        
        if (f_cmd.isCommand(FormCommand.SEARCHLIST)) {
        	log.debug("SEARCHLIST 를 위한 호출"); 
        	SearchExpmasterOfcInfoVO command = new SearchExpmasterOfcInfoVO();
        	command.setMstOfcCd(JSPUtil.getParameter(request, "mst_ofc_cd", ""));
        	log.debug("command.getMstPOfcCd == " + command.getMstOfcCd());
        	event.setExpMastOfc(command);
        	event.setExpMastOfcList((SearchExpMasterOfcListVO) getVO(request, SearchExpMasterOfcListVO.class));
        } else if (f_cmd.isCommand(FormCommand.SEARCH01)) {
        	log.debug("SEARCH01 를 위한 호출"); 
        	event.setExpMapgOfc((SearchExpMapgOfcListVO) getVO(request, SearchExpMapgOfcListVO.class));
        } else if (f_cmd.isCommand(FormCommand.SEARCH03)) {
        	log.debug("SEARCH03 를 위한 호출"); 
        	SearchExpmasterOfcInfoVO command = new SearchExpmasterOfcInfoVO();
        	command.setMstOfcCd(JSPUtil.getParameter(request, "f_ofc_cd", ""));
        	log.debug("command.getMstPOfcCd == " + command.getMstOfcCd());
        	event.setExpMastOfc(command);
        	event.setExpMapgOfc3((SearchExpMapgOfcList3VO) getVO(request, SearchExpMapgOfcList3VO.class));
        } else if (f_cmd.isCommand(FormCommand.MULTI01)) {
        	log.debug("MULTI01 를 위한 호출");
        	event.setMultiInfos((SearchMultiExpOfcInfoVO[]) getVOs(request, SearchMultiExpOfcInfoVO.class));
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