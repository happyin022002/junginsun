/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0109HTMLAction.java
*@FileTitle : Hanger Rack/Bar Installation/Uninstallation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.07.20 함형석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.vo.HangerInventoryListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListINVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.mnr.generalmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AgreementManageSC로 실행요청<br>
 * - AgreementManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author HyungSeok Ham
 * @see EesMnr0109Event 참조
 * @since J2EE 1.6
 */

public class EES_MNR_0109HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0109HTMLAction 객체를 생성
	 */
	public EES_MNR_0109HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AgreementManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EesMnr0109Event event = new EesMnr0109Event();

		HangerInventoryListGRPVO hangerInventoryListGRPVO = new HangerInventoryListGRPVO();

		//조회
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setEQFlagListINVO((EQFlagListINVO)getVO(request, EQFlagListINVO .class));
		}
		//저장
		else if(command.isCommand(FormCommand.MULTI)) {
			EQFlagListINVO eQFlagListINVO = (EQFlagListINVO)getVO(request, EQFlagListINVO .class);
			hangerInventoryListGRPVO.setEQFlagListINVO(eQFlagListINVO);
			hangerInventoryListGRPVO.setArrCustomMnrEqStsVOS((CustomMnrEqStsVO[])getVOs(request, CustomMnrEqStsVO.class,"sheet1_"));
			event.setHangerInventoryListGRPVO(hangerInventoryListGRPVO);
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