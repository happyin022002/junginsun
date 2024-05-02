/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0080HTMLAction.java
*@FileTitle : Distance Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-31 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.event;


import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.syscommon.common.table.TrsAgmtDistHisVO;
import com.hanjin.syscommon.common.table.TrsAgmtDistVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.codemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_080SC로 실행요청<br>
 * - ESD_TRS_0080SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author juhyun
 * @see EsdTrs0080Event 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0080HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_0080HTMLAction 객체를 생성
	 */
	public ESD_TRS_0080HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_080Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		int codeLength = 0;
		String [] ibflag = request.getParameterValues("ibflag");
		if (ibflag != null) codeLength = ibflag.length;	

		TrsAgmtDistVO [] trsAgmtDistVOs = (TrsAgmtDistVO[])getVOs(request, TrsAgmtDistVO.class, "");
		TrsAgmtDistHisVO [] trsAgmtDistHisVOs = (new TrsAgmtDistHisVO()).fromRequestGrid(request);
		EsdTrs0080Event event = new EsdTrs0080Event(); // table value object
		event.setTrsAgmtDistVOs(trsAgmtDistVOs);
		event.setTrsAgmtDistHisVOs(trsAgmtDistHisVOs);
		
	
		String hidFrmNode 		= request.getParameter("hid_frm_node");
		String hidToNode 		= request.getParameter("hid_to_node");
		String frmZip 			= request.getParameter("frm_zip");
		String toZip 			= request.getParameter("to_zip");
		String opnerFromNode	= request.getParameter("opner_from_node");
		String opnerToNode		= request.getParameter("opner_to_node");
		String opnerFromZipCode	= request.getParameter("opner_from_zip_code");
		String opnerToZipCode	= request.getParameter("opner_to_zip_code");
		String rowCount 		= request.getParameter("row_count");
		String ofcCd 			= request.getParameter("ofc_cd");
		String hidCreUsrId 		= request.getParameter("hid_cre_usr_id");
		String hidUpdUsrId 		= request.getParameter("hid_upd_usr_id");
		String hidCreDate 		= request.getParameter("hid_cre_date");
		String hidUpdDate 		= request.getParameter("hid_upd_date");
		String delGubun 		= request.getParameter("del_gubun");
		
		event.setHidFrmNode(hidFrmNode);
		event.setHidToNode(hidToNode);
		event.setFrmZip(frmZip);
		event.setToZip(toZip);
		event.setOpnerFromNode(opnerFromNode);
		event.setOpnerToNode(opnerToNode);
		event.setOpnerFromZipCode(opnerFromZipCode);
		event.setOpnerToZipCode(opnerToZipCode);
		event.setRowCount(rowCount);
		event.setOfcCd(ofcCd);
		event.setHidCreUsrId(hidCreUsrId);
		event.setHidUpdUsrId(hidUpdUsrId);
		event.setHidCreDate(hidCreDate);
		event.setHidUpdDate(hidUpdDate);
		event.setDelGubun(delGubun);

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