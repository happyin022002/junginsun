/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0036HTMLAction.java
*@FileTitle : Transfer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2009.10.05 양정란
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.TransferCondVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.TransferVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * CPS_CNI_0036  Transfer
 * HTTP Parser<br>
 * @author 양정란
 * @see CpsCni0036Event 참조
 * @since J2EE 1.4
 */

public class CPS_CNI_0036HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_CNI_0036HTMLAction 객체를 생성
	 */
	public CPS_CNI_0036HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CpsCni0036Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		
		//이벤트 객체 생성 
		CpsCni0036Event event = new CpsCni0036Event();
		
		// ----------------------------------------------------
		// 공통화면 정보 설정 
		// ----------------------------------------------------
		
		
		// ----------------------------------------------------
		// 이벤트 처리 
		// ----------------------------------------------------		
		// [open , retrive] office cd  존재하는경우 open시 retrive
		if(command.isCommand(FormCommand.SEARCHLIST01)||command.isCommand(FormCommand.PRINT)) {
			// 조회조건
			TransferCondVO dto = (TransferCondVO)getVO(request, TransferCondVO.class);
			event.setTransferCondVO(dto);
			// [save]  
		} else if(command.isCommand(FormCommand.MULTI)) {			
			
			event.setTransferVOs((TransferVO[])getVOs(request, TransferVO.class,""));
			
		} else if(command.isCommand(FormCommand.SEARCHLIST02)) {
			String trnsToOfcCd = JSPUtil.getParameter(request, "trns_to_ofc_cd","");
			event.setTrnsToOfcCd(trnsToOfcCd);
			
		} else if(command.isCommand(FormCommand.SEARCHLIST03)) {
			String trnsToOfcCd = JSPUtil.getParameter(request, "trns_to_ofc_cd","");
			String trnsToUsrId = JSPUtil.getParameter(request, "trns_to_usr_id","");
			
			event.setTrnsToOfcCd(trnsToOfcCd);
			event.setTrnsToUsrId(trnsToUsrId);
			
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