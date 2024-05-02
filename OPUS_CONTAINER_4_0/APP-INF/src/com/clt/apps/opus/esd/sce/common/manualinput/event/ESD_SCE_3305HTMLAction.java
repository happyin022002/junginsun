/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TMP_STD_0001HTMLAction.java
*@FileTitle : Customs Error Code
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.04.09 이영헌
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.sce.common.manualinput.vo.SceCopCntrRepoRuleVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author YoungHeon Lee
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.6
 */
public class ESD_SCE_3305HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_2003HTMLAction 객체를 생성
	 */
	public ESD_SCE_3305HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsdSce3305Event event = new EsdSce3305Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setSceCopCntrRepoRuleVO((SceCopCntrRepoRuleVO)getVO(request, SceCopCntrRepoRuleVO .class));
		} else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setFmCntrTpszCd(JSPUtil.getParameter(request, "fm_cntr_tpsz_cd"));
			event.setFmCntCd(JSPUtil.getParameter(request, "fm_cnt_cd"));
			event.setFmLocCd(JSPUtil.getParameter(request, "fm_loc_cd"));
			event.setFmRgnCd(JSPUtil.getParameter(request, "fm_rgn_cd"));
			event.setFmYdCd(JSPUtil.getParameter(request, "fm_yd_cd"));
		} else if(command.isCommand(FormCommand.MULTI)) {
			event.setSceCopCntrRepoRuleVOs((SceCopCntrRepoRuleVO[])getVOs(request, SceCopCntrRepoRuleVO .class));
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