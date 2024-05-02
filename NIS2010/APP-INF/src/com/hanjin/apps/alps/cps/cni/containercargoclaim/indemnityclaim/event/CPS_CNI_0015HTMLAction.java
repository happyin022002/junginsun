/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0015HTMLAction.java
*@FileTitle : IndemnityClaim
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2009.10.22 박제성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.vo.LiablePartyVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.vo.CniLiablePartyVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * CPS_CNI_0015  Indemnity Claim
 * HTTP Parser<br>
 * @author 박제성
 * @see CpsCni0015Event 참조
 * @since J2EE 1.4
 */

public class CPS_CNI_0015HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_CNI_0015HTMLAction 객체를 생성
	 */
	public CPS_CNI_0015HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CpsCni0015Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		
		//이벤트 객체 생성 
		CpsCni0015Event event = new CpsCni0015Event();
		
		// ----------------------------------------------------
		// 공통화면 정보 설정 
		// ----------------------------------------------------
		
		
		// ----------------------------------------------------
		// 이벤트 처리 
		// ----------------------------------------------------		
		// [open , retrive] 
		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			// cgo_clm_no 취득
			String cgoClmNo = JSPUtil.getParameter(request, "cgo_clm_no","");
			event.setCgoClmNo(cgoClmNo);
		// [retrive] 
		} else	if(command.isCommand(FormCommand.SEARCHLIST02)) {
				// B/L No 취득
				String blNo = JSPUtil.getParameter(request, "cgo_clm_ref_bl_no","");
				event.setBlNo(blNo);		
			
		// [save]  
		} else if(command.isCommand(FormCommand.MULTI)) {
			
			CniLiablePartyVO cniLiablePartyVO = (CniLiablePartyVO) getVO(request, CniLiablePartyVO.class);
			event.setCniLiablePartyVO(cniLiablePartyVO);
			
			String miscCd = JSPUtil.getParameter(request, "clm_misc_cd","");			
			event.setMiscCd(miscCd);
			
			String cgoClmStlUsdAmt = JSPUtil.getParameter(request, "cgo_clm_stl_usd_amt","");			
			event.setCgoClmStlUsdAmt(cgoClmStlUsdAmt);	
			
			// [cancel]  
		} else if(command.isCommand(FormCommand.MULTI01)) {
			
			CniLiablePartyVO cniLiablePartyVO = (CniLiablePartyVO) getVO(request, CniLiablePartyVO.class);
			event.setCniLiablePartyVO(cniLiablePartyVO);
			
			String miscCd = JSPUtil.getParameter(request, "clm_misc_cd","");			
			event.setMiscCd(miscCd);	

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