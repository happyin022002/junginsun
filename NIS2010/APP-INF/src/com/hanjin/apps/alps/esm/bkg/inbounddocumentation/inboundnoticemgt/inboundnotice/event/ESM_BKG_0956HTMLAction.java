/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0956HTMLAction.java
*@FileTitle : Integrated Customer Data Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.05.21 박성호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgArrNtcCntrVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.inbounddocumentation.inboundnoticemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InboundBLMgtSC로 실행요청<br>
 * - InboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Park Changjune
 * @see EsmBkg0956Event 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0956HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0956HTMLAction 객체를 생성
	 */
	public ESM_BKG_0956HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InboundNoticeMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0956Event event = new EsmBkg0956Event();
		
		
		//저장
		if(command.isCommand(FormCommand.MULTI01)) {
			BkgArrNtcCntrVO[] listVOS = (BkgArrNtcCntrVO[]) getVOs(request, BkgArrNtcCntrVO.class,"sheet1_");
			
			//event.setListVOS(listVOS);
			event.setListVOS(listVOS);
			
			//event.setMrnRtnYdVO((MrnRtnYdVO) getVO(request, MrnRtnYdVO.class));
			//검색조건
			//event.setIntgCustSearchVO((IntgCustSearchVO)getVO(request,IntgCustSearchVO.class));
			//저장실행
			//event.setBkgIbCustCntcVOs((IbCustCntcVO[])getVOs(request, IbCustCntcVO.class,"t1sheet_"));
		
		// 조회
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			//log.debug("--------------- an_fom_cd" + request.getParameter("an_fom_cd"));
			Enumeration e = request.getParameterNames();
			while(e.hasMoreElements()){
				log.debug("---------------- " + e.nextElement());
			}
			log.debug("---------------- bkg_no "+request.getParameter("bkg_no"));
			event.setBkgNo(request.getParameter("bkg_no"));
			event.setSearchVO((BkgArrNtcCntrVO) getVO(request, BkgArrNtcCntrVO.class));
			//event.setMdmCustomerVO((MdmCustomerVO) getVO(request, MdmCustomerVO.class));
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