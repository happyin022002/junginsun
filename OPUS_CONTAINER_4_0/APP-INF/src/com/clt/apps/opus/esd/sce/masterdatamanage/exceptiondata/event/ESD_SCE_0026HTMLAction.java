/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0026HTMLAction.java
*@FileTitle : Exception Type Registration 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-12
*@LastModifier : Se-Hoon PARK
*@LastVersion : 1.0
* 2006-09-12 Se-Hoon PARK
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event;


import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeDetailListForMultiVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeDetailListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeListForMultiVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailList3VO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailQueryStr2VO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailQueryStrVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

//import com.clt.syscommon.common.table.SCE_COP_EXPT_TP;

/**
 * HTTP Parser<br>
 * - com.clt.apps 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 UserManagerSC로 실행요청<br>
 * - UserManagerSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Se-Hoon PARK
 * @see EsdSce024Event , EsdSce024EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0026HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
    /**
     * ESD_SCE_024HTMLAction 객체를 생성
     */
    public ESD_SCE_0026HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsdSce024Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
        
    	log.debug("Event 0026 생성!!");
        EsdSce0026Event event = new EsdSce0026Event();
        FormCommand f_cmd = FormCommand.fromRequest(request);
        if (f_cmd.isCommand(FormCommand.SEARCHLIST)) {
        	log.debug("SEARCHLIST 를 위한 호출"); 
        	event.setExpType((SearchExpTypeListVO) getVO(request,SearchExpTypeListVO.class));
        } else if (f_cmd.isCommand(FormCommand.SEARCH01)) {
        	log.debug("SEARCH01 를 위한 호출"); 
        	event.setExpTypeDetail((SearchExpTypeDetailListVO) getVO(request,SearchExpTypeDetailListVO.class));
        } else if (f_cmd.isCommand(FormCommand.SEARCH03)) {
        	log.debug("SEARCH03 를 위한 호출"); 
        	SearchExpInfoVO condition = new SearchExpInfoVO();
        	condition.setFExptTp(JSPUtil.getParameter(request, "f_expt_tp", ""));
        	event.setFExpTp(condition);
        	event.setExpDetail3((SearchExptDetailList3VO) getVO(request,SearchExptDetailList3VO.class));
        } else if (f_cmd.isCommand(FormCommand.MULTI)) {
        	log.debug("MULTI 를 위한 호출");
        	event.setExpTypes((SearchExpTypeListForMultiVO[]) getVOs(request,SearchExpTypeListForMultiVO.class));
        } else if (f_cmd.isCommand(FormCommand.MULTI01)) {
        	log.debug("MULTI01 를 위한 호출");
        	event.setExpTypeDetails((SearchExpTypeDetailListForMultiVO[]) getVOs(request,SearchExpTypeDetailListForMultiVO.class));        	
        } else if (f_cmd.isCommand(FormCommand.SEARCH)) {
        	log.debug("SEARCH 를 위한 호출");
        	SearchExpTypeDetailListForMultiVO command = new SearchExpTypeDetailListForMultiVO();
        	command.setFCopExptTpDtlNm(JSPUtil.getParameter(request, "fm_expt_tp_dtl_nm", ""));
        	command.setFCopExptTpCd(JSPUtil.getParameter(request, "fm_expt_tp_cd", ""));
        	event.setExpTypeDetailSep(command);
        	event.setExpDetailQuery((SearchExptDetailQueryStrVO) getVO(request,SearchExptDetailQueryStrVO.class));
        	event.setExpDetailQuery2((SearchExptDetailQueryStr2VO) getVO(request,SearchExptDetailQueryStr2VO.class));
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