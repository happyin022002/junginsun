/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0095HTMLAction.java
*@FileTitle : Main Code Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.08
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.12.08 이준범
* 1.0 Creation
* ------------------------------------------------------------
* History
* 2010.12.10 이준범 [CHM-201007236-01]
* 1.제목 : CNI Main Code Creation Logic 보완 및 Popup 화면 추가 요청
* 2.처리내역
*  2.1 Main code creation시 Code 생성 규칙에 따른 중복 유사 Code를 검색하여 
*      그 결과를 Popup display하며 User의 선택에  따라 생성 또는 Detail 
*      information을 확인할 수 있는 Main Code View 화면으로 이동하도록 보완 
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.CniCntcPntVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.CniPartyVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.PartyCntVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * CPS_GEM_0095  Main Code Creation
 * HTTP Parser<br>
 * @author 이준범
 * @see CpsCni0095Event 참조
 * @since J2EE 1.4
 */

public class CPS_CNI_0095HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_GNI_0095HTMLAction 객체를 생성
	 */
	public CPS_CNI_0095HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CpsCni0095Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		
		//이벤트 객체 생성 
		CpsCni0095Event event = new CpsCni0095Event();
		
		// ----------------------------------------------------
		// 공통화면 정보 설정 
		// ----------------------------------------------------
		
		
		// ----------------------------------------------------
		// 이벤트 처리 
		// ----------------------------------------------------		
		// [open , retrive] claim party number가 존재하는경우 open시 retrive
		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			// CLAIM PARTY NUMBER 취득
			event.setClmPtyAbbrNm(request.getParameter("clm_pty_abbr_nm"));
			event.setPtyNm(request.getParameter("pty_nm"));
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