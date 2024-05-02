/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0100HTMLAction.java
*@FileTitle : EAS DOD Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2013.09.11 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event;
    
import javax.servlet.http.HttpServletRequest;


import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.EasAttentionVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.SearchBKGCntrListVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceMainVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceDetailVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd. 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ChangeOfDestinationMgtSC로 실행요청<br>
 * - InlandCostManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Jong Ock
 * @see InlandCostManageEvent 참조
 * @since J2EE 1.6
 */
public class ESD_EAS_0100HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_EAS_0100HTMLAction 객체를 생성
	 */
	public ESD_EAS_0100HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CostManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsdEas0100Event event = new EsdEas0100Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			log.debug("\n ==============[HTMLACTION] session_ofc_cd:"+JSPUtil.getParameter(request, "session_ofc_cd", ""));
			event.setInBlNo(JSPUtil.getParameter(request, "in_bl_no", "") );
			event.setSessionOfcCd(JSPUtil.getParameter(request, "session_ofc_cd", "") );
			event.setTrfOfc(JSPUtil.getParameter(request, "trf_ofc", "") );
			log.debug("\n ==============[HTMLACTION] getSessionOfcCd():"+event.getSessionOfcCd());
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setEasAttentionVO((EasAttentionVO)getVO(request, EasAttentionVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setInPayerCd(JSPUtil.getParameter(request, "payer_cd", "") );
			event.setInCustRgstNo(JSPUtil.getParameter(request, "cust_rgst_no", "") );  
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setDodInvoiceMainVO((DODInvoiceMainVO)getVO(request, DODInvoiceMainVO .class));
			event.setDodInvoiceDetailVOs((DODInvoiceDetailVO[])getVOs(request, DODInvoiceDetailVO .class,""));
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