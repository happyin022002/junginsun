/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1053HTMLAction.java
*@FileTitle : CIM Batch Job Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.06.29 문중철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByFromToVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
* HTTP Parser<br>
* - com.clt.apps.opus.es.cim.cntroperationperformancemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
* - Parsing 한 정보를 Event로 변환, request에 담아 CNTROperatioNPerformanceMgtSC로 실행요청<br>
* - CNTROperatioNPerformanceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
* @author MUN JUNG CHEOL
* @see CNTROperatioNPerformanceMgtEvent 참조
* @since J2EE 1.4
*/
public class EES_CIM_1053HTMLAction extends HTMLActionSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 CNTROperatioNPerformanceMgtEvent로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    @Override
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	log.debug("#################  EES_CIM_1053HTMLAction 시작");
        FormCommand command = FormCommand.fromRequest(request);
        String froms = JSPUtil.getParameter( request , "froms".trim() , "" );
        String tos   = JSPUtil.getParameter( request , "tos"  .trim() , "" );
        String fromz = JSPUtil.getParameter( request , "fromz".trim() , "" );
        String toz   = JSPUtil.getParameter( request , "toz"  .trim() , "" );
        EesCim1053Event event = new EesCim1053Event();
        log.debug("####### EES_CIM_1053HTMLAction froms : [" + froms + "]");
        log.debug("####### EES_CIM_1053HTMLAction tos   : [" + tos   + "]");
        log.debug("####### EES_CIM_1053HTMLAction fromz : [" + fromz + "]");
        log.debug("####### EES_CIM_1053HTMLAction toz   : [" + toz   + "]");
        event.setAttribute( "froms" , froms );
        event.setAttribute( "tos"   , tos   );
        event.setAttribute( "fromz" , fromz );
        event.setAttribute( "toz"   , toz   );
        event.setFroms( froms );
        event.setTos  ( tos   );
        event.setFromz( fromz );
        event.setToz  ( toz   );
        if(command.isCommand(FormCommand.SEARCH)) {
            event.setSearchOptionByFromToVO((SearchOptionByFromToVO)getVO(request, SearchOptionByFromToVO .class));
        }else if(command.isCommand(FormCommand.SEARCH01)) {
            event.setSearchOptionByFromToVO((SearchOptionByFromToVO)getVO(request, SearchOptionByFromToVO .class));
        } 
        request.setAttribute("Event", event);
        log.debug("#################  EES_CIM_1053HTMLAction 끝");
        return  event;
    }
}