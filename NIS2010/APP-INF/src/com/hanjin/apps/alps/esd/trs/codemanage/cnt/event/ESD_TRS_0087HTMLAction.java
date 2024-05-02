/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : ESD_TRS_0087HTMLAction.java
 *@FileTitle : CNT(Customer Nominated Trucker) Approval
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014-06-17
 *@LastModifier : 김도현
 *@LastVersion : 1.1
 * 1.0 최초 생성
 * 
=========================================================*/

package com.hanjin.apps.alps.esd.trs.codemanage.cnt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.codemanage.cnt.vo.SearchCntApprovalVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.codemanage.cnt.basic.CustomerNominatedTruckerRgstBC 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CodeManageSC로 실행요청<br>
 * - CodeManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 김도현
 * @see EsdTrs0087Event , ESD_TRS_087EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0087HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_087Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0087Event event = new EsdTrs0087Event();
		
		if(command.isCommand(FormCommand.MODIFY01) || command.isCommand(FormCommand.MODIFY02) || command.isCommand(FormCommand.MODIFY03) || command.isCommand(FormCommand.MODIFY04) || command.isCommand(FormCommand.MULTI)|| command.isCommand(FormCommand.MODIFY05) ) {
			SearchCntApprovalVO searchCntApprovalVO   = new SearchCntApprovalVO();
			SearchCntApprovalVO[] tcz = null; 
			tcz = searchCntApprovalVO.fromRequestGrid(request);
			event.setSearchCntApprovalVOs(tcz);
		} else if(command.isCommand(FormCommand.SEARCH03))  {
			// 조회조건
			String sDtDivCd              = JSPUtil.getParameter(request, "s_dt_div_cd", "");
			String sFmDt                 = JSPUtil.getParameter(request, "s_fm_dt", "");
			String sToDt                 = JSPUtil.getParameter(request, "s_to_dt", "");
			String sEffDt                = JSPUtil.getParameter(request, "s_eff_dt", "");
			String sCtrtNo               = JSPUtil.getParameter(request, "s_ctrt_no", "");
			String sDispDtsCd            = JSPUtil.getParameter(request, "s_disp_sts_cd", "");
			String SVndrSeq              = JSPUtil.getParameter(request, "s_vndr_seq", "");
			String sCustSeq              = JSPUtil.getParameter(request, "s_cust_seq", "");
			String sCntTpCd              = JSPUtil.getParameter(request, "s_cnt_tp_cd", "");
			String sDorNodCd             = JSPUtil.getParameter(request, "s_dor_nod_cd", "");
			
			String fm_nod_cd			= JSPUtil.getParameter(request, "fm_nod_cd", "");
			String fm_nod_yard		 	= JSPUtil.getParameter(request, "fm_nod_yard", "");
			String dor_nod_cd		 	= JSPUtil.getParameter(request, "dor_nod_cd", "");
			String dor_nod_yard		 	= JSPUtil.getParameter(request, "dor_nod_yard", "");
			String to_nod_cd		 	= JSPUtil.getParameter(request, "to_nod_cd", "");
			String to_nod_yard		 	= JSPUtil.getParameter(request, "to_nod_yard", "");
			
			
			
			event.setsDtDivCd(sDtDivCd);
			event.setsFmDt(sFmDt);
			event.setsToDt(sToDt);
			event.setsEffDt(sEffDt);
			event.setsCtrtNo(sCtrtNo);
			event.setsDispDtsCd(sDispDtsCd);
			event.setS_vndr_seq(SVndrSeq);
			event.setsCustSeq(sCustSeq);
			event.setsCntTpCd(sCntTpCd);
			event.setsDorNodCd(sDorNodCd);
			
			event.setFm_nod_cd(fm_nod_cd);
			event.setFm_nod_yard(fm_nod_yard);
			event.setDor_nod_cd(dor_nod_cd);
			event.setDor_nod_yard(dor_nod_yard);
			event.setTo_nod_cd(to_nod_cd);
			event.setTo_nod_yard(to_nod_yard);
		} else if(command.isCommand(FormCommand.SEARCH04))  {
			// 조회조건
			String fm_nod_cd			= JSPUtil.getParameter(request, "fm_nod_cd", "");
			String fm_nod_yard		 	= JSPUtil.getParameter(request, "fm_nod_yard", "");
			String dor_nod_cd		 	= JSPUtil.getParameter(request, "dor_nod_cd", "");
			String dor_nod_yard		 	= JSPUtil.getParameter(request, "dor_nod_yard", "");
			String to_nod_cd		 	= JSPUtil.getParameter(request, "to_nod_cd", "");
			String to_nod_yard		 	= JSPUtil.getParameter(request, "to_nod_yard", "");

			event.setFm_nod_cd(fm_nod_cd);
			event.setFm_nod_yard(fm_nod_yard);
			event.setDor_nod_cd(dor_nod_cd);
			event.setDor_nod_yard(dor_nod_yard);
			event.setTo_nod_cd(to_nod_cd);
			event.setTo_nod_yard(to_nod_yard);
			
		} else if(command.isCommand(FormCommand.SEARCH05))  {
			// 조회조건
			String vndr_seq		 		= JSPUtil.getParameter(request, "vndr_seq", "");
			String io_bnd_cd		 	= JSPUtil.getParameter(request, "io_bnd_cd", "");
			String fm_nod_cd			= JSPUtil.getParameter(request, "fm_nod_cd", "");
			String fm_nod_yard		 	= JSPUtil.getParameter(request, "fm_nod_yard", "");
			String dor_nod_cd		 	= JSPUtil.getParameter(request, "dor_nod_cd", "");
			String dor_nod_yard		 	= JSPUtil.getParameter(request, "dor_nod_yard", "");
			String to_nod_cd		 	= JSPUtil.getParameter(request, "to_nod_cd", "");
			String to_nod_yard		 	= JSPUtil.getParameter(request, "to_nod_yard", "");

			event.setVndr_seq(vndr_seq);
			event.setIo_bnd_cd(io_bnd_cd);
			event.setFm_nod_cd(fm_nod_cd);
			event.setFm_nod_yard(fm_nod_yard);
			event.setDor_nod_cd(dor_nod_cd);
			event.setDor_nod_yard(dor_nod_yard);
			event.setTo_nod_cd(to_nod_cd);
			event.setTo_nod_yard(to_nod_yard);
		} else if(command.isCommand(FormCommand.SEARCH06))  {	
			// 조회조건
			String vndr_seq		 		= JSPUtil.getParameter(request, "vndr_seq", "");
			event.setVndr_seq(vndr_seq);
		} else if(command.isCommand(FormCommand.SEARCH07))  {	
			// 조회조건
			String dor_nod_cd		 		= JSPUtil.getParameter(request, "dor_nod_cd", "");
			event.setDor_nod_cd(dor_nod_cd);	
		} else if(command.isCommand(FormCommand.SEARCH08))  {	
			// 조회조건
			String dor_nod_cd		 		= JSPUtil.getParameter(request, "dor_nod_cd", "");
			event.setDor_nod_cd(dor_nod_cd);	
		}		
		return event;
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

