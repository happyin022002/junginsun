/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0649HTMLAction.java
*@FileTitle : Cancel Issue Release
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.07.20 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgDocIssHisVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgDocIssRdemVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.outboundblmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OutboundBLMgtSC로 실행요청<br>
 * - OutboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Jin Seo
 * @see OutboundBLMgtEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0649HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0649HTMLAction 객체를 생성
	 */
	public ESM_BKG_0649HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 OutboundBLMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command 	= FormCommand.fromRequest(request);
		EsmBkg0649Event event 	= new EsmBkg0649Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			String bkg_no 		= JSPUtil.getParameter(request, "bkg_no");
			String bl_no 		= JSPUtil.getParameter(request, "bl_no");
			event.setBkg_no(bkg_no);
			event.setBl_no(bl_no);
			
		}else if(command.isCommand(FormCommand.MULTI)) {
			String his_seq 		= JSPUtil.getParameter(request, "frm_sheet2_his_seq");
			String bkg_no 		= JSPUtil.getParameter(request, "bkg_no");
			String bl_no 		= JSPUtil.getParameter(request, "bl_no");
			event.setHis_seq(his_seq);
			event.setBl_no(bl_no);
			event.setBkg_no(bkg_no);
			event.setBkgDocIssHisVOs((BkgDocIssHisVO[])getVOs(request, BkgDocIssHisVO.class,"sheet2_"));
			event.setBkgDocIssRdemVOs((BkgDocIssRdemVO[])getVOs(request, BkgDocIssRdemVO.class,"sheet3_"));	
			
		}else if(command.isCommand(FormCommand.MULTI01)) {
			String his_seq 		= JSPUtil.getParameter(request, "frm_sheet2_his_seq");
			String released 	= JSPUtil.getParameter(request, "frm_sheet1_obl_released_flg");
			String issued 		= JSPUtil.getParameter(request, "frm_sheet1_obl_iss_flg");
			String bkg_no 		= JSPUtil.getParameter(request, "bkg_no");
			String bl_no	 	= JSPUtil.getParameter(request, "bl_no");
			String setupfocoblflag	 	= JSPUtil.getParameter(request, "setupfocoblflag");
			
			event.setHis_seq(his_seq);
			event.setReleased(released);
			event.setIssued(issued);
			event.setBl_no(bl_no);
			event.setBkg_no(bkg_no);
			event.setSetupfocoblflag(setupfocoblflag);
			event.setBkgDocIssHisVOs((BkgDocIssHisVO[])getVOs(request, BkgDocIssHisVO.class,"sheet2_"));
			event.setBkgDocIssRdemVOs((BkgDocIssRdemVO[])getVOs(request, BkgDocIssRdemVO.class,"sheet3_"));	
			
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