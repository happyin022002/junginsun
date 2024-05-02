/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PRICommonHTMLAction.java
 *@FileTitle : PRICommon
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.16 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.CheckUpdateDateVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.ComOrganizationVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PriCommonVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCompensationChargeComboListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.MdmChargeVO;
import com.hanjin.syscommon.common.table.MdmSlsRepVO;
import com.hanjin.syscommon.common.table.PriAuthorizationVO;
import com.hanjin.syscommon.common.table.PriTariffVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.pricommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PRICommonSC로 실행요청<br>
 * - PRICommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Park Sungsoo
 * @see PRICommonEvent 참조
 * @since J2EE 1.4
 */

public class PRICommonHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * PRICommonHTMLAction 객체를 생성
	 */
	public PRICommonHTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PRICommonEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		PricommonEvent event = new PricommonEvent();

		if (command.isCommand(FormCommand.SEARCH)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH20)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH19)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH05)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH07)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH08)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH09)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH10)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH11)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH12)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH13)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH14)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH15)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH16)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH17)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND01)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND02)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND03)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND04)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND05)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND06)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND07)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND08)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND09)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND10)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND11)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND12)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND13)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND14)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND15)) {
			event.setPriAuthorizationVO((PriAuthorizationVO) getVO(request, PriAuthorizationVO.class));
		} else if (command.isCommand(FormCommand.COMMAND17)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND19)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND20)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND21)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND22)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND23)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND24)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND25)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND26)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND27)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND28)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND29)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND30)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND31)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND32)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND33)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND34)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND35)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND36)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND37)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND39)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.COMMAND40)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCHLIST04)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCHLIST06)) {
			event.setComOrganizationVO((ComOrganizationVO) getVO(request, ComOrganizationVO.class));
		} else if (command.isCommand(FormCommand.SEARCHLIST09)) {
			event.setMdmChargeVO((MdmChargeVO) getVO(request, MdmChargeVO.class));
		} else if (command.isCommand(FormCommand.SEARCHLIST11)) {
			event.setMdmSlsRepVO((MdmSlsRepVO) getVO(request, MdmSlsRepVO.class));
		} else if (command.isCommand(FormCommand.SEARCHLIST12)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCHLIST14)) {
			event.setPriTariffVO((PriTariffVO) getVO(request, PriTariffVO.class));
		} else if (command.isCommand(FormCommand.SEARCHLIST16)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCHLIST18)) {
			event.setKey(request.getParameter("key"));
		} else if (command.isCommand(FormCommand.SEARCHLIST20)) {
			event.setRsltCompensationChargeComboListVO((RsltCompensationChargeComboListVO) getVO(request, RsltCompensationChargeComboListVO.class));
		} else if (command.isCommand(FormCommand.SEARCHLIST08)) {
			event.setCheckUpdateDateVO((CheckUpdateDateVO) getVO(request, CheckUpdateDateVO.class));
		} else if (command.isCommand(FormCommand.SEARCH21)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH22)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH24)) {
			event.setPriCommonVO((PriCommonVO) getVO(request, PriCommonVO.class));
		} else if (command.isCommand(FormCommand.SEARCH29)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else if (command.isCommand(FormCommand.SEARCH33)) {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		} else {
			event.setRsltCdListVO((RsltCdListVO) getVO(request, RsltCdListVO.class));
		}

		request.setAttribute("Event", event);

		return event;
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