/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_075HTMLAction.java
*@FileTitle : Commodity Group Code Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.commoditygroupcodemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TrsCmdtGrpCzVO;
import com.hanjin.syscommon.common.table.TrsTrspCmdtGrpVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.codemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_075SC로 실행요청<br>
 * - ESD_TRS_075SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author kimjin
 * @see EsdTrs0075Event , ESD_TRS_075EventResponse 참조
 * @since J2EE 1.6
 */
public class ESD_TRS_0075HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_075HTMLAction 객체를 생성
	 */
	public ESD_TRS_0075HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_075Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		
		TrsTrspCmdtGrpVO trsTrspCmdtGrpVO 	= new TrsTrspCmdtGrpVO();
		TrsCmdtGrpCzVO trsCmdtGrpCzVO 		= new TrsCmdtGrpCzVO();
		TrsCmdtGrpCzVO[] tcz 				= null; 

		if(command.isCommand(FormCommand.MULTI) || command.isCommand(FormCommand.MULTI01) || command.isCommand(FormCommand.MULTI02)) {
			trsTrspCmdtGrpVO.fromRequest(request);
			trsCmdtGrpCzVO.fromRequest(request);
			tcz = trsCmdtGrpCzVO.fromRequestGrid(request);
		}

		EsdTrs0075Event event = new EsdTrs0075Event(
                trsTrspCmdtGrpVO
                ,trsCmdtGrpCzVO
                );        
        
		event.setVndrCd				(JSPUtil.getParameter(request, "vndr_cd", ""));
		event.setVndrCommoodityCd	(JSPUtil.getParameter(request, "vndr_commoodity_cd", ""));
		event.setVndrCommoodityNm	(JSPUtil.getParameter(request, "vndr_commoodity_nm", ""));
		event.setVndrNm				(JSPUtil.getParameter(request, "vndr_nm", ""));
		event.setVndrSeq			(JSPUtil.getParameter(request, "vndr_seq", ""));
		event.setRepCmdtCd			(JSPUtil.getParameter(request, "rep_cmdt_cd", ""));
		event.setCmdtCd				(JSPUtil.getParameter(request, "cmdt_cd", ""));
		event.setTrspGrpCmdtCd		(JSPUtil.getParameter(request, "trsp_grp_cmdt_cd", ""));
		event.setCreUsrId			(JSPUtil.getParameter(request, "cre_usr_id", ""));
		event.setCreDt				(JSPUtil.getParameter(request, "cre_dt", ""));
		event.setUpdUsrId			(JSPUtil.getParameter(request, "upd_usr_id", ""));
		event.setUpdDt				(JSPUtil.getParameter(request, "upd_dt", ""));
		event.setDeltFlag			(JSPUtil.getParameter(request, "insert_val", ""));
		
		if(command.isCommand(FormCommand.MULTI)  || command.isCommand(FormCommand.MULTI01) || command.isCommand(FormCommand.MULTI02)) 
			event.setTrsCmdtGrpCzVOS(tcz);

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