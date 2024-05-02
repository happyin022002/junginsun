/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_TRS_0086HTMLAction.java
*@FileTitle : CNT(Customer Nominated Trucker) Registration.
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.11
*@LastModifier : JEON JEE YE
*@LastVersion : 1.0
* 2014.06.11 JEON JEE YE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.cnt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.codemanage.cnt.vo.SearchCntRgstVO;
import com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.event.EsdTrs0085Event;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.codemanage.cnt.basic.CustomerNominatedTruckerRgstBC 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CodeManageSC로 실행요청<br>
 * - CodeManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Jeon Jee Ye
 * @see EsdTrs0086Event , ESD_TRS_086EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0086HTMLAction extends HTMLActionSupport {
	/**
	 * ESD_TRS_0086HTMLAction 객체를 생성
	 */
	public ESD_TRS_0086HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_086Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0086Event event = new EsdTrs0086Event(); // table value object
		
		SearchCntRgstVO searchCntRgstVO = new SearchCntRgstVO();
		SearchCntRgstVO[] searchCntRgstVOs = null;
		
		if(command.isCommand(FormCommand.SEARCH02) || command.isCommand(FormCommand.SEARCH03) || command.isCommand(FormCommand.SEARCH04)
				 || command.isCommand(FormCommand.SEARCH05) || command.isCommand(FormCommand.SEARCH06) || command.isCommand(FormCommand.SEARCH07)) {
			String sDtDivCd= JSPUtil.getParameter(request, "s_dt_div_cd ", "");
			String sFmDt= JSPUtil.getParameter(request, "s_fm_dt ", "");
			String sToDt= JSPUtil.getParameter(request, "s_to_dt ", "");
			String sEffDt= JSPUtil.getParameter(request, "s_eff_dt ", "");
			String sCtrtNo= JSPUtil.getParameter(request, "s_ctrt_no ", "");
			String sDispStsCd= JSPUtil.getParameter(request, "s_disp_sts_cd ", "");
			String sCustSeq= JSPUtil.getParameter(request, "s_cust_seq ", "");
			String sVndrSeq= JSPUtil.getParameter(request, "s_vndr_seq ", "");
			String sDestNodCd= JSPUtil.getParameter(request, "s_dest_nod_cd ", "");
			
			// Grid 조회
			// Contract 
			String prcCtrtNo = JSPUtil.getParameter(request, "prc_ctrt_no ", "");
			String prcCtrtTpCd = JSPUtil.getParameter(request, "prc_ctrt_tp_cd ", "");
			// Name of Preferred Trucker Code
			String vndrSeq = JSPUtil.getParameter(request, "vndr_seq", "");
			// Route
			String ioBndCd  = JSPUtil.getParameter(request, "io_bnd_cd", "");
			String orgNodCd = JSPUtil.getParameter(request, "org_nod_cd", "");
			String orgNodYard = JSPUtil.getParameter(request, "org_nod_yard", "");
			String destNodCd = JSPUtil.getParameter(request, "dest_nod_cd", "");
			String destNodYard = JSPUtil.getParameter(request, "dest_nod_yard", "");
			// CNTR Type
			String cntrTpszCd = JSPUtil.getParameter(request, "cntr_tpsz_cd", "");
			// CNT Rate
			String custNomiTrkrBzcAmt = JSPUtil.getParameter(request, "cust_nomi_trkr_fuel_amt", "");
			String custNomiTrkrFuelAmt = JSPUtil.getParameter(request, "cust_nomi_trkr_fuel_amt", "");
			// Comments
			String costDesc = JSPUtil.getParameter(request, "cost_desc", "");
			// Empty Pick Up / Return
			String mtyPkupRtnYdCd = JSPUtil.getParameter(request, "mty_pkup_rtn_yd_cd", "");
			
			event.setsDtDivCd(sDtDivCd);
			event.setsFmDt(sFmDt);
			event.setsToDt(sToDt);
			event.setsEffDt(sEffDt);
			event.setsCtrtNo(sCtrtNo);
			event.setsDispStsCd(sDispStsCd);
			event.setsCustSeq(sCustSeq);
			event.setsVndrSeq(sVndrSeq);
			event.setsDestNodCd(sDestNodCd);
			
			// Contract 
			event.setPrcCtrtNo(prcCtrtNo);
			event.setPrcCtrtTpCd(prcCtrtTpCd);
			event.setVndrSeq(vndrSeq);
			// Route
			event.setIoBndCd(ioBndCd);
			event.setOrgNodCd(orgNodCd);
			event.setOrgNodYard(orgNodYard);
			event.setDestNodCd(destNodCd);
			event.setDestNodYard(destNodYard);
			// CNTR
			event.setCntrTpszCd(cntrTpszCd);
			event.setCustNomiTrkrBzcAmt(custNomiTrkrBzcAmt);
			event.setCustNomiTrkrFuelAmt(custNomiTrkrFuelAmt);
			
			event.setCostDesc(costDesc);
			event.setMtyPkupRtnYdCd(mtyPkupRtnYdCd);
			
		} else if(command.isCommand(FormCommand.MULTI01) || command.isCommand(FormCommand.REMOVE01) || command.isCommand(FormCommand.MODIFY01))  {
			
			searchCntRgstVO.fromRequest(request);
			searchCntRgstVOs = searchCntRgstVO.fromRequestGrid(request);
			event.setSearchCntRgstVOs(searchCntRgstVOs);
		} else if(command.isCommand(FormCommand.SEARCH08))  {
			String usaEdiCd= JSPUtil.getParameter(request, "usa_edi_cd ", "");
			event.setUsaEdiCd(usaEdiCd);
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

