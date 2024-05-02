/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_OPF_0071HTMLAction.java
*@FileTitle : Vessel Not Operationally Ready Report
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.27
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 1.0 Creation
* 
* History
* 2015.05.22 이병훈 [CHM-201535464] VNOR Report Summary Inquiry 개발
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.ComComboVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.OpfVnorItmVO;
import com.hanjin.syscommon.common.table.OpfVnorVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FmsVnorItmVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FmsVnorVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.aon.bkk.datatransfer 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DataTransferSC로 실행요청<br>
 * - DataTransferSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see DataTransferEvent 참조 
 * @since J2EE 1.6
 */
public class VOP_OPF_0071HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * UserHTMLAction 객체를 생성
	 */
	public VOP_OPF_0071HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 UserManagementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		/**
         ibSheet 사용시 fromRequestGrid를 사용하는데
         prefix는 주로 멀티 Sheet 처리시에 사용하게 된다. (  sheet ID 형태의 prefix 구분자 )
         String prefix = "" ;
         COM_USER com_user = COM_USER.fromRequestGrid(request, prefix);
        */
    	FormCommand command = FormCommand.fromRequest(request);

    	VopOpf0071Event event = new VopOpf0071Event();
    	if (command.isCommand(FormCommand.SEARCHLIST01)) {
    		event.setComComboVO((ComComboVO)getVO(request, ComComboVO.class));
    	} else if (command.isCommand(FormCommand.SEARCHLIST02)) {
    		event.setComComboVO((ComComboVO)getVO(request, ComComboVO.class));
    	} else if (command.isCommand(FormCommand.SEARCHLIST03)) {
    		event.setComComboVO((ComComboVO)getVO(request, ComComboVO.class));
    	} else if (command.isCommand(FormCommand.SEARCHLIST04)) {
    		event.setComComboVO((ComComboVO)getVO(request, ComComboVO.class));
    	} else if (command.isCommand(FormCommand.SEARCHLIST05)) {
    		event.setComComboVO((ComComboVO)getVO(request, ComComboVO.class));
    	} else if (command.isCommand(FormCommand.SEARCHLIST06)) {
    		event.setOpfVnorVO((OpfVnorVO)getVO(request, OpfVnorVO.class));
    	} else if (command.isCommand(FormCommand.SEARCHLIST07)) {
    		event.setOpfVnorVO((OpfVnorVO)getVO(request, OpfVnorVO.class));
    	} else if (command.isCommand(FormCommand.SEARCHLIST08)) {
    		event.setOpfVnorVO((OpfVnorVO)getVO(request, OpfVnorVO.class));
    	} else if (command.isCommand(FormCommand.SEARCH01)) {
			event.setOpfVnorVO((OpfVnorVO)getVO(request, OpfVnorVO.class));
    	} else if (command.isCommand(FormCommand.SEARCH02)) {
			event.setOpfVnorVO((OpfVnorVO)getVO(request, OpfVnorVO.class));
    	} else if (command.isCommand(FormCommand.SEARCH03)) {
			event.setOpfVnorVO((OpfVnorVO)getVO(request, OpfVnorVO.class));
    	} else if (command.isCommand(FormCommand.SEARCH04)) {
			event.setOpfVnorVO((OpfVnorVO)getVO(request, OpfVnorVO.class));
    	} else if (command.isCommand(FormCommand.SEARCH05)) {
    		event.setOfcCd((String) request.getParameter("office_cd"));
		} else if (command.isCommand(FormCommand.SEARCH)) {
			event.setOpfVnorVO((OpfVnorVO)getVO(request, OpfVnorVO.class));
		} else if (command.isCommand(FormCommand.COMMAND01)) {
			event.setOpfVnorVO((OpfVnorVO)getVO(request, OpfVnorVO.class));
			event.setOpfVnorItmVOs((OpfVnorItmVO[])getVOs(request, OpfVnorItmVO.class, ""));
		} else if (command.isCommand(FormCommand.COMMAND02)) {
			event.setOpfVnorVO((OpfVnorVO)getVO(request, OpfVnorVO.class));
			event.setFmsVnorVO((FmsVnorVO)getVO(request, FmsVnorVO.class));
			event.setOpfVnorItmVOs((OpfVnorItmVO[])getVOs(request, OpfVnorItmVO.class, ""));
			event.setFmsVnorItmVOs((FmsVnorItmVO[])getVOs(request, FmsVnorItmVO.class, ""));
		} else if (command.isCommand(FormCommand.COMMAND03)) {
			event.setOpfVnorVO((OpfVnorVO)getVO(request, OpfVnorVO.class));
		}

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