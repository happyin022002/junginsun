/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1144HTMLAction.java
*@FileTitle : SNP/Broker Nomination
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.26
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.03.26 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.ClearanceTypeDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondManifestDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.OrgPartyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UserAuthListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UserAuthListModiVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 manifestlistdownloadSC로 실행요청<br>
 * - manifestlistdownloadSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Subin
 * @see manifestlistdownloadEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_1144HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;
    /**
     * ESM_BKG_1144HTMLAction 객체를 생성
     */
    public ESM_BKG_1144HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 manifestlistdownloadEvent로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);

		EsmBkg1144Event event = new EsmBkg1144Event();

		if (command.isCommand(FormCommand.SEARCH))
		{
			event.setOrgPartyVO((OrgPartyVO) getVO(request, OrgPartyVO.class));
		}else if (command.isCommand(FormCommand.SEARCH01))
		{
            event.setStrCustCntCd(request.getParameter("strCustCntCd"));
		    event.setStrCustSeq(request.getParameter("strCustSeq"));
 		}else if (command.isCommand(FormCommand.SEARCH02))
		{
            event.setStrLocCd(request.getParameter("strLocCd"));
		}else if (command.isCommand(FormCommand.MULTI))
		{
			event.setOrgPartyVOs((OrgPartyVO[]) getVOs(request, OrgPartyVO.class));
		}
		request.setAttribute("Event", event);

		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param eventResponse
	 *            EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param event
	 *            Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}