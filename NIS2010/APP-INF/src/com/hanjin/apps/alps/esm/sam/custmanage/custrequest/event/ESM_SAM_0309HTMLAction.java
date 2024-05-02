/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : ESM_SAM_0309HTMLAction.java
*@FileTitle : customer
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.07
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custrequest.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.sam.commoncode 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 commoncodeSC로 실행요청<br>
 * - commoncodeSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see commoncodeEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SAM_0309HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SAM_0309HTMLAction 객체를 생성
	 */
	public ESM_SAM_0309HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 commoncodeEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSam0309Event event = new EsmSam0309Event();
		
		event.setIsNewYn(request.getParameter("is_new_yn"));

		if(command.isCommand(FormCommand.SEARCH)) {
			log.debug("getCustLglEngNm================================"+request.getParameter("rqst_no"));
			event.setRqstNo(request.getParameter("rqst_no"));
		}else if(command.isCommand(FormCommand.MULTI)) {
			log.debug("MULTI================================"+request.getParameter("cust_cnt_cd"));
			event.setCustomerVO((CustomerVO)getVO(request, CustomerVO.class));

			/** 추가 - B **/
			String custCntCd = JSPUtil.getParameter(request, "cust_cnt_cd");
			event.setCustCntCd(custCntCd);
			String custSeq = JSPUtil.getParameter(request, "cust_seq");
			event.setCustSeq(custSeq);
			String creflag = JSPUtil.getParameter(request, "creflag");
			event.setCreflag(creflag);
			String saveflag = JSPUtil.getParameter(request, "saveflag");
			event.setSaveflag(saveflag);
			
			// test
			log.debug("\n\n ESM_SAM_0309HTMLAction --------- "
					+ "\n custCntCd : " + JSPUtil.getNull(custCntCd)
					+ "\n custSeq : " + JSPUtil.getNull(custSeq)
					+ " \n\n");
		}else if(command.isCommand(FormCommand.MULTI01)) {
			String creflag = JSPUtil.getParameter(request, "creflag");
			event.setCreflag(creflag);
			event.setCustomerVO((CustomerVO)getVO(request, CustomerVO.class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setRqstNo(request.getParameter("rqst_no"));
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