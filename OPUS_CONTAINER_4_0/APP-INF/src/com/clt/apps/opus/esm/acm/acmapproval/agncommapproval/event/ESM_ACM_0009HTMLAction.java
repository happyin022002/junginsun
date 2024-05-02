/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0009HTMLAction.java
*@FileTitle : Commission Agreement Creation_Master
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.09 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommAsaNoVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommInfoPrintDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommInfoPrintMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommVendorVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.acm.acmapproval 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ACMApprovalSC로 실행요청<br>
 * - ACMApprovalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM YOUNG-OH
 * @see EsmAcm0009Event 참조
 * @since J2EE 1.6
 */

public class ESM_ACM_0009HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_ACM_0009HTMLAction 객체를 생성
	 */
	public ESM_ACM_0009HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ACMMasterEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmAcm0009Event event = new EsmAcm0009Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			event.setAgnCommApprovalMasterVO((AGNCommApprovalMasterVO)getVO(request, AGNCommApprovalMasterVO.class));
		} else if (command.isCommand(FormCommand.SEARCH01)) {
			event.setAgnCommApprovalDetailVO((AGNCommApprovalDetailVO)getVO(request, AGNCommApprovalDetailVO.class));
		} else if (command.isCommand(FormCommand.MULTI)) {
			event.setAgnCommApprovalVOs((AGNCommApprovalVO[])getVOs(request, AGNCommApprovalVO.class, ""));
		} else if (command.isCommand(FormCommand.MULTI01)) {
			event.setAgnCommApprovalMasterVO((AGNCommApprovalMasterVO)getVO(request, AGNCommApprovalMasterVO.class));
			event.setAgnCommApprovalMasterVOs((AGNCommApprovalMasterVO[])getVOs(request, AGNCommApprovalMasterVO.class, ""));
		} else if (command.isCommand(FormCommand.PRINT)) {
			event.setAgnCommInfoPrintMasterVO((AGNCommInfoPrintMasterVO)getVO(request, AGNCommInfoPrintMasterVO.class));
			event.setAgnCommInfoPrintDetailVO((AGNCommInfoPrintDetailVO)getVO(request, AGNCommInfoPrintDetailVO.class));
		} else if (command.isCommand(FormCommand.SEARCH16)) {
			event.setAgnCommAsaNoVO((AGNCommAsaNoVO)getVO(request, AGNCommAsaNoVO.class));
			event.setAgnCommVendorVO((AGNCommVendorVO)getVO(request, AGNCommVendorVO.class));
		} else if (command.isCommand(FormCommand.MULTI02)) {
			event.setAgnCommApprovalMasterVOs((AGNCommApprovalMasterVO[])getVOs(request, AGNCommApprovalMasterVO.class, ""));
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