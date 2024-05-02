/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0033HTMLAction.java
*@FileTitle : ContractCarriage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2009.11.04 박제성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.event;

import javax.servlet.http.HttpServletRequest;


import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmBlDtlVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCntrDtlVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCtrtVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * CPS_CNI_0010 ContractCarriage
 * HTTP Parser<br>
 * @author 박제성
 * @see CpsCni0010Event 참조
 * @since J2EE 1.4
 */

public class CPS_CNI_0010HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_CNI_0010HTMLAction 객체를 생성
	 */
	public CPS_CNI_0010HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CpsCni0010Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		
		//이벤트 객체 생성 
		CpsCni0010Event event = new CpsCni0010Event();
		
		// ----------------------------------------------------
		// 이벤트 처리 
		// ----------------------------------------------------		
		// [open , retrieve] Cargo Claim No가 존재하는경우 open시 retrive
		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			// Cargo Claim No
			String cgoClmNo = JSPUtil.getParameter(request, "cgo_clm_no","");
			
			event.setCgoClmNo(cgoClmNo);
			
		} else if(command.isCommand(FormCommand.SEARCHLIST02)) {
			
			
			String cgoClmNo = JSPUtil.getParameter(request, "cgo_clm_no","");
			String cgoClmRefBlNo = JSPUtil.getParameter(request, "cgo_clm_ref_bl_no","");	
			event.setCgoClmNo(cgoClmNo);
			event.setCgoClmRefBlNo(cgoClmRefBlNo);		
			
		} else	if(command.isCommand(FormCommand.SEARCHLIST03)) {
			// B/L No 취득
			String blNo = JSPUtil.getParameter(request, "cgo_clm_ref_bl_no","");
			event.setBlNo(blNo);		
		
		} else	if(command.isCommand(FormCommand.SEARCHLIST04)) {
			// B/L Get
			String cgoClmNo = JSPUtil.getParameter(request, "cgo_clm_no","");			
			event.setCgoClmNo(cgoClmNo);
			String blNo = JSPUtil.getParameter(request, "cgo_clm_ref_bl_no","");
			event.setBlNo(blNo);		
			
		} else if(command.isCommand(FormCommand.MULTI)) {	
			
			CniCgoClmCtrtVO cniCgoClmCtrtVO = (CniCgoClmCtrtVO) getVO(request, CniCgoClmCtrtVO.class);
			
			event.setCniCgoClmCtrtVO(cniCgoClmCtrtVO);			
			
			// contract point sheet
			CniCgoClmBlDtlVO[] cniCgoClmBlDtlVOs = (CniCgoClmBlDtlVO[]) getVOs(request, CniCgoClmBlDtlVO.class , "sheet1_");
			event.setCniCgoClmBlDtlVOs(cniCgoClmBlDtlVOs);
			
			CniCgoClmCntrDtlVO[] cniCgoClmCntrDtlVOs = (CniCgoClmCntrDtlVO[]) getVOs(request, CniCgoClmCntrDtlVO.class , "sheet2_");
			event.setCniCgoClmCntrDtlVOs(cniCgoClmCntrDtlVOs);
			
		} else if(command.isCommand(FormCommand.MULTI01)) {	
			
			String cgoClmNo = JSPUtil.getParameter(request, "cgo_clm_no","");
			
			event.setCgoClmNo(cgoClmNo);		
			
			// contract point sheet
			CniCgoClmBlDtlVO[] cniCgoClmBlDtlVOs = (CniCgoClmBlDtlVO[]) getVOs(request, CniCgoClmBlDtlVO.class , "sheet1_");
			event.setCniCgoClmBlDtlVOs(cniCgoClmBlDtlVOs);

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