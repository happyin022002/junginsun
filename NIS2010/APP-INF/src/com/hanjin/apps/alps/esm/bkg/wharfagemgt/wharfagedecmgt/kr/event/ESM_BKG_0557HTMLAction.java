/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0557HTMLAction.java
 *@FileTitle : ESM_BKG_0557HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.05.20 정재엽
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecExptVolVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfPortRtVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVvdDtlVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgKrWhfVolVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.wharfage 화면을 통해 서버로 전송되는 HTML DOM 객체의 
 *   Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WharFageMgtSC로 실행요청<br>
 * - WharfageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author jae yoeb jeong
 * @see WharfageEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0557HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_BKG_0557HTMLAction 객체를 생성
	 */
	public ESM_BKG_0557HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 WharfageEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request 
	 *            HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */ 
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0557Event event = new EsmBkg0557Event();

		if (command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.COMMAND04)) {
			event.setKrWhfDecCondVO ( (KrWhfDecCondVO)getVO( request, KrWhfDecCondVO.class ) );
		} else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setKrWhfDecCondVO( (KrWhfDecCondVO)getVO( request, KrWhfDecCondVO.class ) ); 
		} else if(command.isCommand(FormCommand.MULTI)) {
			
			event.setKrWhfDecCondVO ( (KrWhfDecCondVO)getVO( request, KrWhfDecCondVO.class ) );
			event.setBkgKrWhfVolVO  ( (BkgKrWhfVolVO)getVO( request, BkgKrWhfVolVO.class ) );
			event.setKrWhfDecVO  ( (KrWhfDecVO)getVO( request, KrWhfDecVO.class ) );
			event.setKrWhfPortRtVO  ( (KrWhfPortRtVO)getVO( request, KrWhfPortRtVO.class ) );
			event.setKrWhfVvdDtlVOs( (KrWhfVvdDtlVO[])getVOs(request, KrWhfVvdDtlVO.class, "sheet1_" ) );
			event.setKrWhfDecExptVolVOs( (KrWhfDecExptVolVO[])getVOs(request, KrWhfDecExptVolVO.class, "sheet2_" ) );
		} else if(command.isCommand(FormCommand.COMMAND01)) {
			
			event.setKrWhfDecCondVO ( (KrWhfDecCondVO)getVO( request, KrWhfDecCondVO.class ) );
			event.setBkgKrWhfVolVO  ( (BkgKrWhfVolVO)getVO( request, BkgKrWhfVolVO.class ) );
			event.setKrWhfDecVO  ( (KrWhfDecVO)getVO( request, KrWhfDecVO.class ) );
			event.setKrWhfPortRtVO  ( (KrWhfPortRtVO)getVO( request, KrWhfPortRtVO.class ) );
			event.setKrWhfVvdDtlVOs( (KrWhfVvdDtlVO[])getVOs(request, KrWhfVvdDtlVO.class, "sheet1_" ) );
			event.setKrWhfDecExptVolVOs( (KrWhfDecExptVolVO[])getVOs(request, KrWhfDecExptVolVO.class, "sheet2_" ) );
		} else if(command.isCommand(FormCommand.COMMAND02)) {
			
			event.setKrWhfDecCondVO ( (KrWhfDecCondVO)getVO( request, KrWhfDecCondVO.class ) );
			event.setBkgKrWhfVolVO  ( (BkgKrWhfVolVO)getVO( request, BkgKrWhfVolVO.class ) );
			event.setKrWhfDecVO  ( (KrWhfDecVO)getVO( request, KrWhfDecVO.class ) );
			event.setKrWhfPortRtVO  ( (KrWhfPortRtVO)getVO( request, KrWhfPortRtVO.class ) );
			event.setKrWhfVvdDtlVOs( (KrWhfVvdDtlVO[])getVOs(request, KrWhfVvdDtlVO.class, "sheet1_" ) );
			event.setKrWhfDecExptVolVOs( (KrWhfDecExptVolVO[])getVOs(request, KrWhfDecExptVolVO.class, "sheet2_" ) );
		} else if(command.isCommand(FormCommand.COMMAND03)) {
			
			event.setKrWhfDecCondVO ( (KrWhfDecCondVO)getVO( request, KrWhfDecCondVO.class ) );
			event.setBkgKrWhfVolVO  ( (BkgKrWhfVolVO)getVO( request, BkgKrWhfVolVO.class ) );
			event.setKrWhfDecVO  ( (KrWhfDecVO)getVO( request, KrWhfDecVO.class ) );
			event.setKrWhfPortRtVO  ( (KrWhfPortRtVO)getVO( request, KrWhfPortRtVO.class ) );
			event.setKrWhfVvdDtlVOs( (KrWhfVvdDtlVO[])getVOs(request, KrWhfVvdDtlVO.class, "sheet1_" ) );
			event.setKrWhfDecExptVolVOs( (KrWhfDecExptVolVO[])getVOs(request, KrWhfDecExptVolVO.class, "sheet2_" ) );
		}  else if(command.isCommand(FormCommand.COMMAND05)) {			
			event.setKrWhfDecCondVO ( (KrWhfDecCondVO)getVO( request, KrWhfDecCondVO.class ) );
			event.setHisSeq(request.getParameter("his_seq"));
			event.setReturnValues(request.getParameter("return_values"));
		} 
		
		request.setAttribute("Event", event);
		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param eventResponse
	 *            EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param event
	 *            Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}