/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCG_COM_HTMLAction.java
*@FileTitle : 공통유틸
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.17
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.15 이도형
* 1.0 Creation
*  
* History
* 2012.12.17 진마리아 [CHM-201221863-01] [VOP-SCG] Application Detail for Own BKG 에 combine, split 정보 추가
=========================================================*/
package com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo.SearchPortVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.ScgImdgCompGrpVO;
import com.hanjin.syscommon.common.table.MdmCarrierVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.scg.scgcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCGCommonSC로 실행요청<br>
 * - SCGCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Dohyoung Lee
 * @see SCGCommonEvent 참조
 * @since J2EE 1.4
 */

public class SCG_COM_EXTERNALHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * SCG_COM_HTMLAction 객체를 생성
	 */
	public SCG_COM_EXTERNALHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCGCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		ScgComExternalEvent event = new ScgComExternalEvent();
		

		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setMdmCarrierVO((MdmCarrierVO)getVO(request, MdmCarrierVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setMdmVslSvcLaneVO((MdmVslSvcLaneVO)getVO(request, MdmVslSvcLaneVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setBkgBookingVO((BkgBookingVO)getVO(request, BkgBookingVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setBkgBookingVO((BkgBookingVO)getVO(request, BkgBookingVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setVskVslSkdVO((VskVslSkdVO)getVO(request, VskVslSkdVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setMdmCntrTpSzVO((MdmCntrTpSzVO)getVO(request, MdmCntrTpSzVO .class));
		}else if(command.isCommand(FormCommand.SEARCH08)) {
			event.setScgImdgCompGrpVO((ScgImdgCompGrpVO)getVO(request, ScgImdgCompGrpVO .class));
		}else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setAttribute("port_cd", request.getParameter("port_cd") );
		}else if(command.isCommand(FormCommand.SEARCH10)) {
			event.setSearchPortVO((SearchPortVO)getVO(request, SearchPortVO .class));
        }else if(command.isCommand(FormCommand.SEARCH11)) {
            event.setPolSlanCd( JSPUtil.getParameter(request, "pol_port_cd" , "") );
            event.setPodSlanCd( JSPUtil.getParameter(request, "pod_port_cd" , "") );
		}else if(command.isCommand(FormCommand.SEARCH19)) {
			CodeInfo cdinfo = new CodeInfo();
			cdinfo.setCode(    JSPUtil.getParameter(request, "code" , "") );
			cdinfo.setSortKey( JSPUtil.getParameter(request, "sortkey" , "") );			
			event.setCodeInfo( cdinfo);
		}else if(command.isCommand(FormCommand.SEARCH14)) {
            event.setPgmNo( JSPUtil.getParameter(request, "pgmNo" , "") );
		}else if(command.isCommand(FormCommand.SEARCH15)) {
			event.setBkgNo( JSPUtil.getParameter(request, "bkgNo" , "") );
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