/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0028HTMLAction.java
*@FileTitle : Misc Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2009.10.14 박제성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.CniMiscCodeVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * CPS_CNI_0028  Misc Code Creation
 * HTTP Parser<br>
 * @author 박제성
 * @see CpsCni0028Event 참조
 * @since J2EE 1.6
 */ 

public class CPS_CNI_0028HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_GNI_0028HTMLAction 객체를 생성
	 */
	public CPS_CNI_0028HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CpsCni0028Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		
		//이벤트 객체 생성 
		CpsCni0028Event event = new CpsCni0028Event();
		
		// ----------------------------------------------------
		// 공통화면 정보 설정 
		// ----------------------------------------------------
		
		
		// ----------------------------------------------------
		// 이벤트 처리 
		// ----------------------------------------------------		
		// [open , retrive] 
		if(command.isCommand(FormCommand.SEARCHLIST01) ||
				command.isCommand(FormCommand.PRINT)) {
			
			String clssClmMiscCd = JSPUtil.getParameter(request, "clss_clm_misc_cd","");
			event.setClssClmMiscCd(clssClmMiscCd);
		
		// [save]  
		} else if(command.isCommand(FormCommand.MULTI)) {			
			
			event.setCniMiscCodeVOs((CniMiscCodeVO[])getVOs(request, CniMiscCodeVO.class,""));
			  	   
		} else if (command.isCommand(FormCommand.SEARCHLIST02)) {//MISCELLANEOUS  코드를 조회
			event.setComCdId(request.getParameter("cd_id"));
			event.setComCode(request.getParameter("com_code"));
			event.setComText(request.getParameter("com_text"));
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