/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0025HTMLAction.java
*@FileTitle : Main Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.10.05 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.CniCntcPntVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.CniPartyVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.PartyCntVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * CPS_GEM_0025  Main Code Creation
 * HTTP Parser<br>
 * @author 진윤오
 * @see CpsCni0025Event 참조
 * @since J2EE 1.4
 */

public class CPS_CNI_0025HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_GNI_0025HTMLAction 객체를 생성
	 */
	public CPS_CNI_0025HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CpsCni0025Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		
		//이벤트 객체 생성 
		CpsCni0025Event event = new CpsCni0025Event();
		
		// ----------------------------------------------------
		// 공통화면 정보 설정 
		// ----------------------------------------------------
		
		
		// ----------------------------------------------------
		// 이벤트 처리 
		// ----------------------------------------------------		
		// [open , retrive] claim party number가 존재하는경우 open시 retrive
		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			// CLAIM PARTY NUMBER 취득
			String clmPtyNo = JSPUtil.getParameter(request, "clm_pty_no","");
			event.setClmPtyNo(clmPtyNo);			
		// [save]  party 정보 저장
		} else if(command.isCommand(FormCommand.MULTI)) {
			// party container
			PartyCntVO  partyCntVO = new PartyCntVO();
			// party form
			CniPartyVO cniPartyVO = (CniPartyVO) getVO(request, CniPartyVO.class);
			partyCntVO.setCniPartyVO(cniPartyVO);

			// contract point sheet
			CniCntcPntVO[] cniCntcPntVOs = (CniCntcPntVO[]) getVOs(request, CniCntcPntVO.class , "sheet1_");
			partyCntVO.setCniCntcPntVO(cniCntcPntVOs);
			
			event.setPartyCntVO(partyCntVO);
			
  	    // [delete]  party 정보 삭제
		} else if(command.isCommand(FormCommand.REMOVE)) {
			// CLAIM PARTY NUMBER 취득
			String clmPtyNo = JSPUtil.getParameter(request, "clm_pty_no","");
			event.setClmPtyNo(clmPtyNo);
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