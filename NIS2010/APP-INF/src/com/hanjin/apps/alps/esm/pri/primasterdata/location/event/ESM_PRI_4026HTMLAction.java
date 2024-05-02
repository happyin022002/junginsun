/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4026HTMLAction.java
*@FileTitle : Location Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.04.28 최성민
* 1.0 Creation
=========================================================
* History
* 2011-07-15 서미진 [CHM-201112248] continent code, sub continent code도 조회 할 수 있도록 변경
========================================================= */
package com.hanjin.apps.alps.esm.pri.primasterdata.location.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.continent.vo.ContinentVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltCntListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltGrpLocDtlListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltGrpLocListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltLocListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltRgnListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltSteListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.primasterdata 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PRIMasterDataSC로 실행요청<br>
 * - PRIMasterDataSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CHOI SUNG MIN
 * @see PRIMasterDataEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_4026HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_4026HTMLAction 객체를 생성
	 */
	public ESM_PRI_4026HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PRIMasterDataEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri4026Event event = new EsmPri4026Event();
		
		if(command.isCommand(FormCommand.SEARCH03)) { //State search
			event.setRsltSteListVO((RsltSteListVO)getVO(request, RsltSteListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH05)) { //Country search
			event.setRsltCntListVO((RsltCntListVO)getVO(request, RsltCntListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) { //Region search
			event.setRsltRgnListVO((RsltRgnListVO)getVO(request, RsltRgnListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) { //Location search	
			event.setRsltLocListVO((RsltLocListVO)getVO(request, RsltLocListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setRsltGrpLocDtlListVO((RsltGrpLocDtlListVO)getVO(request, RsltGrpLocDtlListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH07)) { //State - Country 콤보
			event.setRsltCobCntListVO((RsltCdListVO)getVO(request, RsltCdListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH08)) { //Region - Country 콤보
			event.setRsltCobCntListVO((RsltCdListVO)getVO(request, RsltCdListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH09)) { //Group Location - Location(S/C Proposal) 콤보
			event.setRsltGrpLocListVO((RsltGrpLocListVO)getVO(request, RsltGrpLocListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH10)) { //Group Location - Location(RFA Guideline) 콤보
			event.setRsltGrpLocListVO((RsltGrpLocListVO)getVO(request, RsltGrpLocListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH11)) { //Group Location - Location(S/C Guideline) 콤보
			event.setRsltGrpLocListVO((RsltGrpLocListVO)getVO(request, RsltGrpLocListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH12)) { //Group Location - Location(RFA Proposal) 콤보
			event.setRsltGrpLocListVO((RsltGrpLocListVO)getVO(request, RsltGrpLocListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH13)) { //Group Location - Location(Surcharge) 콤보
			event.setRsltGrpLocListVO((RsltGrpLocListVO)getVO(request, RsltGrpLocListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH14)) { //Group LOcation - Location(S/C Proposal) 조회
			event.setRsltGrpLocDtlListVO((RsltGrpLocDtlListVO)getVO(request, RsltGrpLocDtlListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH15)) { //Group LOcation - Location(RFA Guideline) 조회
			event.setRsltGrpLocDtlListVO((RsltGrpLocDtlListVO)getVO(request, RsltGrpLocDtlListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH16)) { //Group LOcation - Location(S/C Guideline) 조회
			event.setRsltGrpLocDtlListVO((RsltGrpLocDtlListVO)getVO(request, RsltGrpLocDtlListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH17)) { //Group LOcation - Location(RFA Proposal) 조회
			event.setRsltGrpLocDtlListVO((RsltGrpLocDtlListVO)getVO(request, RsltGrpLocDtlListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH18)) { //Group LOcation - Location(Surcharge) 조회 (미정)
			event.setRsltGrpLocDtlListVO((RsltGrpLocDtlListVO)getVO(request, RsltGrpLocDtlListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH19)) { //Group LOcation - Location(CMPB) 조회
			event.setRsltGrpLocListVO((RsltGrpLocListVO)getVO(request, RsltGrpLocListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH20)) { //Group LOcation - Location(CMPB) 조회
			event.setRsltGrpLocDtlListVO((RsltGrpLocDtlListVO)getVO(request, RsltGrpLocDtlListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST01)) { //Group LOcation - Location(SQ) 조회
			event.setRsltGrpLocListVO((RsltGrpLocListVO)getVO(request, RsltGrpLocListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST02)) { //Group LOcation - Location(SQ) 조회
			event.setRsltGrpLocDtlListVO((RsltGrpLocDtlListVO)getVO(request, RsltGrpLocDtlListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST03)) { //Group LOcation - Location(RQ) 조회
			event.setRsltGrpLocListVO((RsltGrpLocListVO)getVO(request, RsltGrpLocListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST04)) { //Group LOcation - Location(RQ) 조회
			event.setRsltGrpLocDtlListVO((RsltGrpLocDtlListVO)getVO(request, RsltGrpLocDtlListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST05)) { //Continent search	
			event.setContinentVO((ContinentVO)getVO(request, ContinentVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST06)) { //Sub continent search	
			event.setContinentVO((ContinentVO)getVO(request, ContinentVO .class));
		}
		else {
			event.setRsltGrpLocListVO((RsltGrpLocListVO)getVO(request, RsltGrpLocListVO .class));
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