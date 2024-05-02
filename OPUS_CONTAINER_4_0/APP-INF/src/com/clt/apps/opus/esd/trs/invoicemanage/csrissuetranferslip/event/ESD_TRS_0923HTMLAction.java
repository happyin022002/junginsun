/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_038HTMLAction.java
*@FileTitle : Rail Invoice Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-11
*@LastModifier : Kildong_hong
*@LastVersion : 1.0
* 2006-12-11 Kildong_hong
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.syscommon.common.table.TrsTrspRailInvDtlVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.invoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_038SC로 실행요청<br>
 * - ESD_TRS_038SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Kildong_hong
 * @see EsdTrs0923Event , ESD_TRS_923EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0923HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_038HTMLAction 객체를 생성
	 */
	public ESD_TRS_0923HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_038Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
	
		EsdTrs0923Event event = new EsdTrs0923Event();
		
	    String[] seq     =  request.getParameterValues("seq" );
	    String[] cntr_no     =  request.getParameterValues("cntr_no" );
	    String[] result     =  request.getParameterValues("result" );
	    String[] wbl_no     =  request.getParameterValues("wbl_no" );
	    String[] wbl_dt     =  request.getParameterValues("wbl_dt" );
	    String[] inv_org_nod_nm     =  request.getParameterValues("inv_org_nod_nm" );
	    String[] inv_dest_nod_nm     =  request.getParameterValues("inv_dest_nod_nm" );
	    String[] inv_bzc_amt     =  request.getParameterValues("inv_bzc_amt" );
	    String[] inv_bil_amt	= request.getParameterValues("inv_bil_amt" );
	    
	    String railRoadCode = JSPUtil.getNull(request.getParameter("rail_road_code"));
	    String currency = JSPUtil.getNull(request.getParameter("currency"));
	    
	    event.setTrsTrspRailInvDtlVos((TrsTrspRailInvDtlVO[])getVOs(request, TrsTrspRailInvDtlVO.class, ""));
	    
		event.setCurrency(currency);
		event.setRailRoadCode(railRoadCode);
		
		event.setSeqArr(seq);
		event.setCntrNoArr(cntr_no);
		event.setWbl_noArr(wbl_no);
		event.setWbl_dtArr(wbl_dt);
		event.setInv_org_nod_nmArr(inv_org_nod_nm);
		event.setInv_dest_nod_nmArr(inv_dest_nod_nm);
		event.setInv_bzc_amtArr(inv_bzc_amt);
		event.setInv_bil_amtArr(inv_bil_amt);
		event.setResultArr(result);
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