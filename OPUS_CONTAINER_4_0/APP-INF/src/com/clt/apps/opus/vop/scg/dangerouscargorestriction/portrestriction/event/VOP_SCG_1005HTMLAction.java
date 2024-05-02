/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_1005HTMLAction.java
*@FileTitle : SAVE DG Restriction by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.03 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictionVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.ScgImdgPortRstrVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.vop.scg.dangerouscargorestriction 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DangerousCargoRestrictionSC로 실행요청<br>
 * - DangerousCargoRestrictionSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author jang kang cheol
 * @see DangerousCargoRestrictionEvent 참조
 * @since J2EE 1.6
 */

public class VOP_SCG_1005HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_SCG_1005HTMLAction 객체를 생성
	 */
	public VOP_SCG_1005HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DangerousCargoRestrictionEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopScg1005Event event = new VopScg1005Event();
		
		if(command.isCommand(FormCommand.MULTI01)) {
		 
			PortRestrictionVO cond = (PortRestrictionVO)getVO(request, PortRestrictionVO .class );
			cond.setSavTypeClassLabel( request.getParameter("strOpt") );
			event.setCondition(  cond  );
 
			
			event.setSearchScgImdgPortRstrVOs((PortRestrictionVO[])getVOs(request, PortRestrictionVO .class, request.getParameter("IBPREFIX")  ));
		} 
	    /***********************.do로 접속시, <> GS.do *************************/
		if(command.isCommand(FormCommand.DEFAULT)) {
			event.setAttribute("port_cd"          , JSPUtil.getParameter(request, "port_cd"          , "" ));
			event.setAttribute("port_cd_nm"       , JSPUtil.getParameter(request, "port_cd_nm"       , "" ));
			event.setAttribute("imdg_clss_cd"     , JSPUtil.getParameter(request, "imdg_clss_cd"     , "" ));
			event.setAttribute("imdg_clss_cd_desc", JSPUtil.getParameter(request, "imdg_clss_cd_desc", "" ));
			event.setAttribute("imdg_un_no"       , JSPUtil.getParameter(request, "imdg_un_no"       , "" ));
			event.setAttribute("imdg_un_no_seq"   , JSPUtil.getParameter(request, "imdg_un_no_seq"   , "" ));			
			event.setAttribute("optClass"         , JSPUtil.getParameter(request, "optClass"         , "" ));			
			
			event.setAttribute("imdg_port_rstr_seq", JSPUtil.getParameter(request, "imdg_port_rstr_seq", "" ));				
			
			event.setCondition(  (PortRestrictionVO)getVO(request, PortRestrictionVO .class   ));
			
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