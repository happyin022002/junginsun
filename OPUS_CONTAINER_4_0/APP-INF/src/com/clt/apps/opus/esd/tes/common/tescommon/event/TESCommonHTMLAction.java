/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESCommonHTMLAction.java
*@FileTitle : TES Common 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-31 byungheeyoo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tescommon.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.MdmYardVO;
import com.clt.syscommon.common.table.TesJbExePerfLogVO;
import com.clt.syscommon.common.table.TesLgsCostVO;
import com.clt.syscommon.common.table.TesTmlAgmtCostVO;
import com.clt.syscommon.common.table.TesTmlSoCostVO;
import com.clt.syscommon.common.table.TesTmlSoCrrVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tes.common 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TESCommonSC로 실행요청<br>
 * - TESCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author byungheeyoo
 * @see TESCommonEvent , TESCommonEventResponse 참조
 * @since J2EE 1.4
 */
public class TESCommonHTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * TESCommonHTMLAction 객체를 생성
	 */
	public TESCommonHTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TESCommonEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request 
	 * @return Event 
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		log.debug("\n\n  TESCommonHTMLAction  \n\n");
		
    	FormCommand			command	= FormCommand.fromRequest(request);
		TESCommonEvent		event	= new TESCommonEvent();
		
		event.setMdmYardVO			((MdmYardVO)getVO(request, MdmYardVO .class));
		event.setVskVslPortSkdVO	((VskVslPortSkdVO)getVO(request, VskVslPortSkdVO .class));
		
		event.setTesCommonVO		((TesCommonVO)getVO(request, TesCommonVO .class));
		event.setTesLgsCostVO		((TesLgsCostVO)getVO(request, TesLgsCostVO .class));
		event.setTesTmlSoHdrVO		((TesTmlSoHdrVO)getVO(request, TesTmlSoHdrVO .class));
		event.setTesTmlSoCostVO		((TesTmlSoCostVO)getVO(request, TesTmlSoCostVO .class));
		event.setTesTmlSoCrrVO		((TesTmlSoCrrVO)getVO(request, TesTmlSoCrrVO .class));
		event.setTesTmlAgmtCostVO	((TesTmlAgmtCostVO)getVO(request, TesTmlAgmtCostVO .class));
		event.setTesJbExePerfLogVO	((TesJbExePerfLogVO)getVO(request, TesJbExePerfLogVO .class));

		/*
		 * <중> (SEARCH01 -> EDI invoice 원본 조회용) 이외는  ETC_KEY_NAME값이 반드시 필요
		 */
		if(!command.isCommand(FormCommand.SEARCH01) && !command.isCommand(FormCommand.SEARCHLIST08)) {
			
			if (event.getTesCommonVO().getCoid()==null || "".equals( event.getTesCommonVO().getCoid().trim() ) ) {
				throw new HTMLActionException(">>> comboId / ETC_KEY_NAME 누락!!! <<<");
			}
		}

		request.setAttribute("Event", event);

		return  event;
	}

	/**	
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request 
	 * @param eventResponse 
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request 
	 * @param event 
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}