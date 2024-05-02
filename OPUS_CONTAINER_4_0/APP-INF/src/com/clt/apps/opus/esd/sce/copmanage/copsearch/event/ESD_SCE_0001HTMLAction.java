/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0001HTMLAction.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : SeongMun_Kang
*@LastVersion : 1.0
* 2006-08-29 SeongMun_Kang
* 1.0 최초 생성
* 2009.02.26 - 안정선 - CSR NO. N200902030014 COP Inquiry 화면과 COP Summary 화면을 하나의 화면으로 통합
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchCOPMainListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.CommonWebKeys;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.sce 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 COPManageSC로 실행요청<br>
 * - COPManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author SeongMun_Kang
 * @see EsdSce0001Event , EsdSce0001EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0001HTMLAction extends HTMLActionSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6881743938070803623L;

	/**
     * EsdSce0001HTMLAction 객체를 생성
     */
    public ESD_SCE_0001HTMLAction() {
    }

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdSce0001Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
		//int codeLength = 0;

		SignOnUserAccount account = (SignOnUserAccount) request.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		String userId = account.getUsr_id();        
    	FormCommand command = FormCommand.fromRequest(request);
    	EsdSce0001Event event = new EsdSce0001Event();
		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setConditionVO((COPInquiryVO)getVO(request, COPInquiryVO .class));
		}else if(command.isCommand(FormCommand.MODIFY)) {
			//String [] ibflag = request.getParameterValues("ibflag");
			event.setMainListVOs((SearchCOPMainListVO[])getVOs(request, SearchCOPMainListVO .class,""), userId);
		
		}else{
			event.setConditionVO((COPInquiryVO)getVO(request, COPInquiryVO .class));			
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