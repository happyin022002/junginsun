/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0375HTMLAction.java
*@FileTitle : Arrival Notice Form Setting General, Door, CY, CFS Cargo, Special Cargo, Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcWdVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BkgArrNtcWdDtlVO;
import com.clt.syscommon.common.table.BkgArrNtcWdVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InboundBLMgtSC로 실행요청<br>
 * - InboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author
 * @see EsmBkg0375Event 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0375HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0375HTMLAction 객체를 생성
	 */
	public ESM_BKG_0375HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InboundNoticeMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0375Event event = new EsmBkg0375Event();
		
		ArrNtcWdVO arrNtcWd = new ArrNtcWdVO();
		if(command.isCommand(FormCommand.MULTI)) {			
			/* set bkg_arr_ntc_wd */
			BkgArrNtcWdVO bkgArrNtcWdVO =(BkgArrNtcWdVO)getVO(request, BkgArrNtcWdVO .class);
			BkgArrNtcWdDtlVO[] bkgArrNtcWdDtlVOs = (BkgArrNtcWdDtlVO[])getVOs(request, BkgArrNtcWdDtlVO .class,"sheet1_");
			
			arrNtcWd.setBkgArrNtcWdVO(bkgArrNtcWdVO);
			arrNtcWd.setBkgArrNtcWdDtlVOs(bkgArrNtcWdDtlVOs);
			
			event.setArrNtcWdVO(arrNtcWd);
			
		}
		else if(command.isCommand(FormCommand.REMOVE01)) {
			/* set bkg_arr_ntc_wd */
			BkgArrNtcWdVO bkgArrNtcWdVO =(BkgArrNtcWdVO)getVO(request, BkgArrNtcWdVO .class);
			arrNtcWd.setBkgArrNtcWdVO(bkgArrNtcWdVO);
			event.setArrNtcWdVO(arrNtcWd);
			
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			BkgArrNtcWdVO bkgArrNtcWdVO =(BkgArrNtcWdVO)getVO(request, BkgArrNtcWdVO .class);
			arrNtcWd.setBkgArrNtcWdVO(bkgArrNtcWdVO);
			event.setArrNtcWdVO(arrNtcWd);
		}else if(command.isCommand(FormCommand.SEARCH01)) {//pod_cd
			BkgArrNtcWdVO bkgArrNtcWdVO =(BkgArrNtcWdVO)getVO(request, BkgArrNtcWdVO .class);
			arrNtcWd.setBkgArrNtcWdVO(bkgArrNtcWdVO);
			event.setArrNtcWdVO(arrNtcWd);
		}else if(command.isCommand(FormCommand.SEARCH02)) {//chn_agn_cd
			BkgArrNtcWdVO bkgArrNtcWdVO =(BkgArrNtcWdVO)getVO(request, BkgArrNtcWdVO .class);
			arrNtcWd.setBkgArrNtcWdVO(bkgArrNtcWdVO);
			event.setArrNtcWdVO(arrNtcWd);
		} else {
			BkgArrNtcWdVO bkgArrNtcWdVO =(BkgArrNtcWdVO)getVO(request, BkgArrNtcWdVO .class);
			arrNtcWd.setBkgArrNtcWdVO(bkgArrNtcWdVO);
			event.setArrNtcWdVO(arrNtcWd);
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