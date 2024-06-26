/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_918HTMLAction.java
*@FileTitle : surcharge 입력/수정/삭제화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-09
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-11-09 poong_yeon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.vo.SurchargeVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.invoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InvoiceManageSC로 실행요청<br>
 * - InvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author poong_yeon
 * @param <TrsTrspScgDtl>
 * @see EsdTrs0918Event , ESD_TRS_918EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0918HTMLAction<TrsTrspScgDtl> extends HTMLActionSupport {

	/**
	 * ESD_TRS_918HTMLAction 객체를 생성
	 */
	public ESD_TRS_0918HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_918Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
//		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0918Event event = new EsdTrs0918Event();

		String prefix = "surcharge_" ;
		int codeLength = 0;
		String [] ibflag = request.getParameterValues("ibflag");
		String [] scibflag = request.getParameterValues(prefix+"ibflag");
		
		if (ibflag != null) codeLength = ibflag.length;
//		Collection tableCollection = TrsTrspScgDtlVO.fromRequest(request, codeLength);
//		TrsTrspScgDtl tableSingle = TrsTrspScgDtlVO.fromRequest(request);
		
		String  trspSoOfcCtyCd = request.getParameter("ofc_cty_cd");
		String  trspSoSeq = request.getParameter("so_seq");
		String  formUsrOfcCd = request.getParameter("FORM_USR_OFC_CD");
		String  formCreUsrId = request.getParameter("FORM_CRE_USR_ID");
		
		event.setTrspSoOfcCtyCd(trspSoOfcCtyCd);
		event.setTrspSoSeq(trspSoSeq);
		event.setFormUsrOfcCd(formUsrOfcCd);
		event.setFormCreUsrId(formCreUsrId);
		
		if (scibflag != null) {
			event.setSurchargeVOs((SurchargeVO[])getVOs(request, SurchargeVO.class, prefix));
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