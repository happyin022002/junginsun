/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : OFFICE_MANAGEMENTHTMLAction.java
*@FileTitle : Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.07.02 정인선
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.officemanagement.event;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.ComOfcPgmMtchVO;
import com.hanjin.syscommon.management.alps.officemanagement.vo.OfficListVO;
import javax.servlet.http.HttpServletRequest;

/**
 * HTTP Parser<br>
 * - com.hanjin.syscommon.nis2010.management.programmanagement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ProgramManagementSC로 실행요청<br>
 * - ProgramManagementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jung In Sun
 * @see ProgramManagementEvent 참조
 * @since J2EE 1.6
 */
public class OFFICE_MANAGEMENTHTMLAction extends HTMLActionSupport
{

	/**
	 * OFFICE_MANAGEMENTHTMLAction 객체를 생성
	 */
	 
    public OFFICE_MANAGEMENTHTMLAction()
    {
    }
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ProgramManagementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request)
        throws HTMLActionException
    {
        FormCommand command = FormCommand.fromRequest(request);
        OfficeManagementEvent event = new OfficeManagementEvent();
        if(command.isCommand(7))
        {
            ComOfcPgmMtchVO comOfcPgmMtchVOs[] = (ComOfcPgmMtchVO[])getVOs(request, ComOfcPgmMtchVO.class);
            for(int i = 0; i < comOfcPgmMtchVOs.length; i++)
                comOfcPgmMtchVOs[i].setPgmNo(request.getParameter("pgm_no"));

            event.setComOfcPgmMtchVOS(comOfcPgmMtchVOs);
        } else
        if(command.isCommand(2))
            event.setOfficListVO((OfficListVO)getVO(request, OfficListVO.class));
        event.setPgm_no(request.getParameter("pgm_no"));
        return event;
    }

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface를 구현한 객체
	 */
    public void doEnd(HttpServletRequest request, EventResponse eventResponse)
    {
        request.setAttribute("EventResponse", eventResponse);
    }

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
    public void doEnd(HttpServletRequest request, Event event)
    {
        request.setAttribute("Event", event);
    }

    private static final long serialVersionUID = 1L;
}
