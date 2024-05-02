/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_BIS_0567HTMLAction.java
*@FileTitle : C/A Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2010.01.20 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.BkgBlNoVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bis.blinformationmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BLInformationMgtSC로 실행요청<br>
 * - BLInformationMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author kang dong yun
 * @see BLInformationMgtEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BIS_0567HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BIS_0567HTMLAction 객체를 생성
	 */
	public ESM_BIS_0567HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BLInformationMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBis0567Event event = new EsmBis0567Event();
		

		event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
		event.setPopFlg(JSPUtil.getNullNoTrim(request.getParameter("popFlg")));
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setOldBkgNo(JSPUtil.getNullNoTrim(request.getParameter("oldBkgNo")));
		} else if(command.isCommand(FormCommand.SEARCH01)) {
			String bkgNoMst     = JSPUtil.getNullNoTrim(request.getParameter("bkg_no_mst"));
			String caNoMst      = JSPUtil.getNullNoTrim(request.getParameter("ca_no_mst"));
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkgNoMst);
			bkgBlNoVO.setCaNo (caNoMst);
			event.setBkgBlNoVO(bkgBlNoVO);	
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