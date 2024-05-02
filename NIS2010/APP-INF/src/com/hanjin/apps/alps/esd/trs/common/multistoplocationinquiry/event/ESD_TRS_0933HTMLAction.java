/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_933HTMLAction.java
*@FileTitle : Multi-stop Location Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-10
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-11-10 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.multistoplocationinquiry.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.syscommon.common.table.TrsTrspRqstOrdAddrVO;
import com.hanjin.syscommon.common.table.TrsTrspRqstOrdHdVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.common 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_933SC로 실행요청<br>
 * - ESD_TRS_933SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author juhyun
 * @see EsdTrs0933Event , ESD_TRS_933EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0933HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_933HTMLAction 객체를 생성
	 */
	public ESD_TRS_0933HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_933Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		int codeLength = 0;
		String [] ibflag = request.getParameterValues("ibflag");
		if (ibflag != null) codeLength = ibflag.length;	
		
	
//		TrsTrspRqstOrdAddrVO trs_trsp_rqst_ord_addr = TrsTrspRqstOrdAddrVO.fromRequest(request);
//		TrsTrspRqstOrdHdVO   trs_trsp_rqst_ord_hd   = TrsTrspRqstOrdHdVO.fromRequest(request);
        
		EsdTrs0933Event event = new EsdTrs0933Event();
		
		
		String bkgNumber = request.getParameter("bkgnumber");
		String blNumber = request.getParameter("blnumber");
		String cntrNumber = request.getParameter("cntrnumber");
		String tpSzNumber = request.getParameter("tpsznumber");
		String troSeq = request.getParameter("troseqnumber");
		event.setBkgNumber(bkgNumber);
		event.setBlNumber(blNumber);
		event.setCntrNumber(cntrNumber);
		event.setTpSzNumber(tpSzNumber);
		event.setTroSeq(troSeq);
		
		
        
		
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