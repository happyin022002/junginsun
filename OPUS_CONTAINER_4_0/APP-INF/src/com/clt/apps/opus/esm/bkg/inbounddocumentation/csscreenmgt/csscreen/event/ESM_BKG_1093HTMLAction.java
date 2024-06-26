/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1093HTMLAction.java
*@FileTitle : Inbound C/S USA_Instruction Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoSaveVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsCustSvcInstrsVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.csscreenmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CsScreenMgtSC로 실행요청<br>
 * - CsScreenMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author
 * @see CsScreenMgtEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_1093HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1093HTMLAction 객체를 생성
	 */
	public ESM_BKG_1093HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CsScreenMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1093Event event = new EsmBkg1093Event();
		
		if(command.isCommand(FormCommand.DEFAULT) ||
				command.isCommand(FormCommand.SEARCH)) {
			event.setBkgNo(JSPUtil.getParameter(request, "bkg_no"));
	    }else if(command.isCommand(FormCommand.MODIFY)) {
	
	        log.debug("===================================");
	        log.debug("    MODIFY EVENT                   ");
	        log.debug("===================================");

	        String bkgNo = request.getParameter("bkg_no");
            String instrRmk = request.getParameter("instr_rmk");

	        log.debug("===================================");
	        log.debug("    MODIFY EVENT                   ");
	        log.debug("    BkgNo : " + bkgNo );
	        log.debug("    instrRmk : " +instrRmk );
	        log.debug("===================================");
            
            UsCustSvcInstrsVO usCustSvcInstrs = new UsCustSvcInstrsVO();
	        usCustSvcInstrs.setBkgNo(bkgNo);
	        usCustSvcInstrs.setInstrRmk(instrRmk);

            event.setUsCustSvcInstrs(usCustSvcInstrs);
	    }else if(command.isCommand(FormCommand.REMOVE)) {

	        String bkgNo = request.getParameter("bkg_no");
            String instrRmkSeq = request.getParameter("instr_rmk_seq");

	        log.debug("===================================");
	        log.debug("    REMOVE EVENT                   ");
	        log.debug("    BkgNo : " + bkgNo );
	        log.debug("    instrRmkSeq : " +instrRmkSeq );
	        log.debug("===================================");
            
            UsCustSvcInstrsVO usCustSvcInstrs = new UsCustSvcInstrsVO();
	        usCustSvcInstrs.setBkgNo(bkgNo);
	        usCustSvcInstrs.setInstrRmkSeq(instrRmkSeq);

            event.setUsCustSvcInstrs(usCustSvcInstrs);
            
            
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