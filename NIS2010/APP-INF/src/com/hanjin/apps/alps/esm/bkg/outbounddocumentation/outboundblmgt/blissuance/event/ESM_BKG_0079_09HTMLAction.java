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
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchChgRateByLBPVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.outboundblmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OutboundBLMgtSC로 실행요청<br>
 * - OutboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Jin Seo
 * @see OutboundBLMgtEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0079_09HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0649HTMLAction 객체를 생성
	 */
	public ESM_BKG_0079_09HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 OutboundBLMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg007909Event event = new EsmBkg007909Event();
		
		String bkg_no 		= JSPUtil.getParameter(request, "bkg_no");
		String bl_no 		= JSPUtil.getParameter(request, "bl_no");
		if(bl_no.length() >12) bl_no = bl_no.substring(0,12);
		

		// 외부모듈 요청 추가 
		String setupfocoblflag = JSPUtil.getParameter(request, "setupfocoblflag");
		
		event.setSetupfocoblflag(setupfocoblflag);
		event.setBkg_no(bkg_no);
		event.setBl_no(bl_no);
		
		if(command.isCommand(FormCommand.MULTI)) {
			// 저장 변수 
			event.setBlIssInfoVOs((BlIssInfoVO[])getVOs(request, BlIssInfoVO.class,"t11sheet1_"));
			
		}else if(command.isCommand(FormCommand.MULTI01)) {
			
			// 버튼에 따른 db셋팅 변경 처리 
			String buttonType = JSPUtil.getParameter(request, "buttonType");
			String lbpFlg = JSPUtil.getParameter(request, "lbpFlg");
			event.setButtonType(buttonType);
			event.setLbpFlg(lbpFlg);
			
			event.setBlIssInfoVOs((BlIssInfoVO[])getVOs(request, BlIssInfoVO.class,"t11sheet1_"));
			event.setSearchChgRateByLBPVO((SearchChgRateByLBPVO)getVO(request, SearchChgRateByLBPVO .class,"lbpInfo_"));
			
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setSearchChgRateByLBPVO((SearchChgRateByLBPVO)getVO(request, SearchChgRateByLBPVO .class,"lbpInfo_"));
		}
		else if(command.isCommand(FormCommand.SEARCH10)) {
			String hrdCdgId		= JSPUtil.getParameter(request, "hrdCdgId");
			String attrCtnt1 	= JSPUtil.getParameter(request, "attrCtnt1");
			String attrCtnt2 	= JSPUtil.getParameter(request, "attrCtnt2");
			String attrCtnt3 	= JSPUtil.getParameter(request, "attrCtnt3");
			
			event.setHrdCdgId(hrdCdgId);
			event.setAttrCtnt1(attrCtnt1);
			event.setAttrCtnt2(attrCtnt2);
			event.setAttrCtnt3(attrCtnt3);
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