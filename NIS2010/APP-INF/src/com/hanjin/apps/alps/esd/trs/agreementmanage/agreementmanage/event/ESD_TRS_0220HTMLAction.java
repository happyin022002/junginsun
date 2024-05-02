/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : ESD_TRS_0220HTMLAction.java
 *@FileTitle : Agreement Header
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-03-26
 *@LastModifier : jong hyek choi
 *@LastVersion : 1.0 
 * 2010-03-26 jong hyek choi
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.SearchAgmtHdrVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TrsAgmtAplyVndrVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AgreementManageSC로 실행요청<br>
 * - AgreementManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author jong hyek choi
 * @see EsdTrs0220Event , ESD_TRS_0220EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0220HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_0220HTMLAction 객체를 생성
	 */
	public ESD_TRS_0220HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_002Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		SearchAgmtHdrVO searchAgmtHdrVO   = new SearchAgmtHdrVO();
		SearchAgmtHdrVO[] tcz = null;
		
		TrsAgmtAplyVndrVO trsAgmtAplyVndrVO   = new TrsAgmtAplyVndrVO();
		TrsAgmtAplyVndrVO[] tcz_dtl = null;
		
		EsdTrs0220Event event = new EsdTrs0220Event();
		if(command.isCommand(FormCommand.SEARCH03) 
				|| command.isCommand(FormCommand.SEARCH04)
				|| command.isCommand(FormCommand.MODIFY)
				) {
			tcz = searchAgmtHdrVO.fromRequestGrid(request);
		}else if(command.isCommand(FormCommand.MULTI)) {
			tcz_dtl = trsAgmtAplyVndrVO.fromRequestGrid(request);
		}

		String fm_agmtno          = request.getParameter("fm_agmtno")!=null?request.getParameter("fm_agmtno"):"";
		String fm_account_ofc_cd  = request.getParameter("fm_account_ofc_cd")!=null?request.getParameter("fm_account_ofc_cd"):"";
		String fm_account_usr_id  = request.getParameter("fm_account_usr_id")!=null?request.getParameter("fm_account_usr_id"):"";
		String fm_ctrt_ofc_cd  	  = request.getParameter("fm_ctrt_ofc_cd")!=null?request.getParameter("fm_ctrt_ofc_cd"):"";
		String fm_vndr_prmry_seq  = request.getParameter("fm_vndr_prmry_seq")!=null?request.getParameter("fm_vndr_prmry_seq"):"";
		
		event.setFm_agmtno        (fm_agmtno);
		event.setFm_account_ofc_cd(fm_account_ofc_cd);
		event.setFm_account_usr_id(fm_account_usr_id);
		event.setFmCtrtOfcCd	  (fm_ctrt_ofc_cd);
		event.setFm_vndr_prmry_seq(fm_vndr_prmry_seq);
		
		event.setSearchAgmtHdrVOs(tcz);
		event.setTrsAgmtAplyVndrVOs(tcz_dtl);
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