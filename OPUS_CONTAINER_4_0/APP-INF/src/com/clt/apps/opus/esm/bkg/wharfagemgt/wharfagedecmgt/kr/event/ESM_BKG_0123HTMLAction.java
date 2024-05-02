/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0123HTMLAction.java
 *@FileTitle : ESM_BKG_0123HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.05.20 정재엽
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBlCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBkgInfoCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBkgKrWhfBlVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoCondVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BkgKrWhfCntrVO;
import com.clt.syscommon.common.table.BkgKrWhfCustVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.wharfage 화면을 통해 서버로 전송되는 HTML DOM 객체의 
 *   Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WharFageMgtSC로 실행요청<br>
 * - WharfageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author jae yoeb jeong
 * @see WharfageEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0123HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_BKG_0123HTMLAction 객체를 생성
	 */
	public ESM_BKG_0123HTMLAction() {}

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
		EsmBkg0123Event event = new EsmBkg0123Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			KrBlCondVO krBlCondVO = new KrBlCondVO();
			krBlCondVO.fromRequest(request, "frm_");
			event.setKrBlCondVO(krBlCondVO);  
		} else if(command.isCommand(FormCommand.MULTI)) {
			
			event.setKrWhfBkgInfoCondVO( (KrWhfBkgInfoCondVO)getVO(request, KrWhfBkgInfoCondVO.class) );  
			event.setKrWhfBkgKrWhfBlVOs((KrWhfBkgKrWhfBlVO[])getVOs(request, KrWhfBkgKrWhfBlVO.class, ""));
			event.setBkgKrWhfCntrVOs((BkgKrWhfCntrVO[])getVOs(request, BkgKrWhfCntrVO.class, "sheet1_"));
			event.setBkgKrWhfCustVOs((BkgKrWhfCustVO[])getVOs(request, BkgKrWhfCustVO.class, "sheet2_"));
			event.setKrWhfVslInfoCondVO( (KrWhfVslInfoCondVO)getVO(request, KrWhfVslInfoCondVO.class ) );
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