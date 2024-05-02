/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : EES_CIM_0063HTMLAction.java
*@FileTitle : Uncollected Cargo Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.23
*@LastModifier : 김현주
*@LastVersion : 1.0
* 2014.06.23 김현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.UncollectedCargoVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.CommonWebKeys;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 LongstayingUnclaimEQMgtSC로 실행요청<br>
 * - LongstayingUnclaimEQMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author kim jong jun
 * @see LongstayingUnclaimEQMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_CIM_0063HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CIM_0063HTMLAction 객체를 생성
	 */
	public EES_CIM_0063HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 LongstayingUnclaimEQMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EesCim0063Event event = new EesCim0063Event();
				
		if(command.isCommand(FormCommand.MULTI)) {
			event.setUncollectedCargoVO((UncollectedCargoVO)getVO(request, UncollectedCargoVO.class));		// 신규생성
		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			event.setUncollectedCargoVO((UncollectedCargoVO)getVO(request, UncollectedCargoVO.class));		// Update	
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.setUncollectedCargoVO((UncollectedCargoVO)getVO(request, UncollectedCargoVO.class));		// Add Sequence
		}
		else if(command.isCommand(FormCommand.MULTI03)) {
			event.setUncollectedCargoVO((UncollectedCargoVO)getVO(request, UncollectedCargoVO.class));		// 3개 Item만 저장
		}
		else if(command.isCommand(FormCommand.MULTI04)) {
			event.setUncollectedCargoVO((UncollectedCargoVO)getVO(request, UncollectedCargoVO.class));		// Reopen만 저장
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setUncollectedCargoVO((UncollectedCargoVO)getVO(request, UncollectedCargoVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			// DISPOSAL OPTION CODE   : CD03294
			// OBL HOLDER CODE        : CD03296
			// REASON CODE            : CD03293
			// STATUS CODE            : CD03292
			event.setIntgCdId(request.getParameter("intg_cd"));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setUncollectedCargoVO((UncollectedCargoVO)getVO(request, UncollectedCargoVO.class));
			String hndlBrncCd = request.getParameter("hndl_brnc_cd");			
			event.setAttribute("hndlBrncCd", hndlBrncCd);
			String uc_date = request.getParameter("cnee_uc_dt");
			event.setAttribute("ucDate", uc_date);
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setIntgCdId(request.getParameter("intg_cd"));		// bl_no
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setIntgCdId(request.getParameter("intg_cd"));		// Branch/Agent
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setIntgCdId(request.getParameter("intg_cd"));		// RHQ
		}
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setIntgCdId(request.getParameter("intg_cd"));		// Handler
		}
		else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setIntgCdId(request.getParameter("intg_cd"));
		}
		else if(command.isCommand(FormCommand.SEARCH08)) {
			event.setIntgCdId(request.getParameter("intg_cd"));		// bl_no
		}
		else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setUncollectedCargoVO((UncollectedCargoVO)getVO(request, UncollectedCargoVO.class));
			event.setIntgCdId(request.getParameter("intg_cd"));		// Handling : "H", Counter": "C"		
		}
		else if(command.isCommand(FormCommand.SEARCH10)) {
			event.setUncollectedCargoVO((UncollectedCargoVO)getVO(request, UncollectedCargoVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH11)) {
		    event.setUncollectedCargoVO((UncollectedCargoVO)getVO(request, UncollectedCargoVO.class));
		}
		else if(command.isCommand(FormCommand.DEFAULT)) { 
			SignOnUserAccount account = (SignOnUserAccount)request.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			event.setIntgCdId(account.getUsr_id());					// Login user
		}
		else if(command.isCommand(FormCommand.MULTI05)) {
			event.setUncollectedCargoVO((UncollectedCargoVO)getVO(request, UncollectedCargoVO.class));		// Reopen만 저장
			String manager_memo = request.getParameter("manager_memo");
			String isAuthority = request.getParameter("isauthority");
			String ucCsNo = request.getParameter("uc_cs_no");
			String blNo = request.getParameter("bl_no");
			event.setAttribute("managerMemo", manager_memo);
			event.setAttribute("isAuthority", isAuthority);
			event.setAttribute("ucCsNo", ucCsNo);
			event.setAttribute("blNo", blNo);
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