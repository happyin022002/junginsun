/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UI_MNR_0273HTMLAction.java
*@FileTitle : On-site Inspecion Result Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 이율규
*@LastVersion : 1.0
* 2015.07.21 이율규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.vo.FQAResultMgtINVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.vo.MnrFieldQualityAuditResultVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.vo.MnrOnSiteVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrFileAtchVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mnr.generalmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralManageSC로 실행요청<br>
 * - GeneralManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author LEE YUL KYU
 * @see GeneralManageEvent 참조
 * @since J2EE 1.4
 */

public class EES_MNR_0273HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * UI_MNR_0273HTMLAction 객체를 생성
	 */
	public EES_MNR_0273HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		EesMnr0273Event event = new EesMnr0273Event();
		FormCommand command = FormCommand.fromRequest(request);
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setMnrOnSiteVO((MnrOnSiteVO)getVO(request, MnrOnSiteVO.class));
			event.setMnrOnSiteVOs((MnrOnSiteVO[])getVOs(request, MnrOnSiteVO.class));
			event.setCustomMnrFileAtchVOs((CustomMnrFileAtchVO[])getVOs(request, CustomMnrFileAtchVO.class, "sheet2_"));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setMnrOnSiteVO((MnrOnSiteVO)getVO(request, MnrOnSiteVO.class));
		}
		else if(command.isCommand(FormCommand.REMOVE)) {
			event.setMnrOnSiteVO((MnrOnSiteVO)getVO(request, MnrOnSiteVO.class));
			event.setMnrOnSiteVOs((MnrOnSiteVO[])getVOs(request, MnrOnSiteVO.class));
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