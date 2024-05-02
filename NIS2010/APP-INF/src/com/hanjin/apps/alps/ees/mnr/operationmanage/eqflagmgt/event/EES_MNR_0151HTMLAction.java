/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0151HTMLAction.java
*@FileTitle : Disposal Candidate Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.07.20 권영법
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqRngStsVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.DisposalCandidateFlagINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.EqListForDisposalVO;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
	
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mnr.generalmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AgreementManageSC로 실행요청<br>
 * - AgreementManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author HyungSeok Ham
 * @see EesMnr0109Event 참조
 * @since J2EE 1.6           
 */

public class EES_MNR_0151HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0109HTMLAction 객체를 생성
	 */	
	public EES_MNR_0151HTMLAction() {}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AgreementManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMnr0151Event event = new EesMnr0151Event();

		//조회 
		if(command.isCommand(FormCommand.SEARCH)) {  
			event.setDisposalCandidateFlagINVO((DisposalCandidateFlagINVO)getVO(request, DisposalCandidateFlagINVO .class));
		}     
		//Load Excel 후 해당 EQ 정보 조회
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setEqListForDisposalVOs((EqListForDisposalVO[])getVOs(request, EqListForDisposalVO .class, "sheet5_"));
			event.setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd".trim(), ""));
		}
		//저장
		else if(command.isCommand(FormCommand.MULTI)) {
			event.setDisposalCandidateFlagINVO((DisposalCandidateFlagINVO)getVO(request, DisposalCandidateFlagINVO .class));
			DisposalCandidateFlagINVO disposalCandidateFlagINVO=event.getDisposalCandidateFlagINVO();
			if(disposalCandidateFlagINVO.getSelectCd().equals("R"))
			{
				event.setCustomMnrEqRngStsVOs((CustomMnrEqRngStsVO[])getVOs(request, CustomMnrEqRngStsVO .class,"sheet4_"));
			}
			else
			{
				event.setCustomMnrEqRngStsVOs((CustomMnrEqRngStsVO[])getVOs(request, CustomMnrEqRngStsVO .class,"sheet1_"));
			}
			event.setCustomMnrEqStsVOs((CustomMnrEqStsVO[])getVOs(request, CustomMnrEqStsVO .class,"sheet2_"));

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