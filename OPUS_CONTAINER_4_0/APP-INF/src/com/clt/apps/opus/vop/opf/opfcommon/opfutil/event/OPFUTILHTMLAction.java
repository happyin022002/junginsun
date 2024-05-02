/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OPFUTILHTMLAction.java
*@FileTitle : OpfUtil Common
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.05.26 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.opfcommon.opfutil.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.OpfComboVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.OpfUtilSearchOptVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskCarrierVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.vop.opf.opfcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OpfCommonSC로 실행요청<br>
 * - OpfCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jang Suk Hyun
 * @see OpfCommonEvent 참조
 * @since J2EE 1.4
 */

public class OPFUTILHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * OPFUTILHTMLAction 객체를 생성
	 */
	public OPFUTILHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 OpfCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		OpfutilEvent event = new OpfutilEvent();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setMdmLocationVO((MdmLocationVO)getVO(request, MdmLocationVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.SEARCH10)) {
			event.setOpfComboVO((OpfComboVO)getVO(request, OpfComboVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setOpfComboVO((OpfComboVO)getVO(request, OpfComboVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setMdmVslSvcLaneVO((MdmVslSvcLaneVO)getVO(request, MdmVslSvcLaneVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH04) || command.isCommand(FormCommand.SEARCH15)) {
			event.setVskCarrierVO((VskCarrierVO)getVO(request, VskCarrierVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setVskVslPortSkd((VskVslPortSkdVO)getVO(request, VskVslPortSkdVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setVskVslSkdVO((VskVslSkdVO)getVO(request, VskVslSkdVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH07) || command.isCommand(FormCommand.SEARCH08) || command.isCommand(FormCommand.SEARCH13)) {
			event.setTerminalDepartureReportCondVO((TerminalDepartureReportCondVO)getVO(request, TerminalDepartureReportCondVO.class));
        }
        else if( command.isCommand(FormCommand.SEARCH11)  ) {//Search VVD PORT
            event.setOpfUtilSearchOptVO( (OpfUtilSearchOptVO)getVO(request, OpfUtilSearchOptVO.class));
        }
        else if( command.isCommand(FormCommand.SEARCH12)  ) {//Search  PORT INFO
            event.setOpfUtilSearchOptVO( (OpfUtilSearchOptVO)getVO(request, OpfUtilSearchOptVO.class));
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