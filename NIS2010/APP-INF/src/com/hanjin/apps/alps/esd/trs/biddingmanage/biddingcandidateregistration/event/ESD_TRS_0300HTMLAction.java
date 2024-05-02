/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ESD_TRS_0300HTMLAction.java
 *@FileTitle :Bidding Candidate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.06.01
 *@LastModifier : SHIN DONG IL
 *@LastVersion : 1.0
 * 2015.06.01 SHIN DONG IL
 * 1.0 최초 생성
 *----------------------------------------------------------
 * History
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.vo.BiddingCandidateRegistrationVO;
import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.event.SurchargeVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * HTTP Parser<br>
 *  - Parsing 한 정보를 Event로 변환, request에 담아 CodeManageSC로 실행요청<br>
 *  
 * @author SHIN DONG IN 
 * @see EsdTrs0300Event ,ESD_TRS_940EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0300HTMLAction extends HTMLActionSupport {
	/**
	 * HTML Action 객체 생성
	 */
	public ESD_TRS_0300HTMLAction(){		
	}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_0300Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
//		FormCommand command = FormCommand.fromRequest(request);
		
		EsdTrs0300Event event = new EsdTrs0300Event();
		
//		if(command.isCommand(FormCommand.SEARCH01)){
//			
//		}
		
		String spotBidCnddtTermSeq	= request.getParameter("spot_bid_cnddt_term_seq");
		String vndrSeq				= request.getParameter("vndr_seq");
		String spotBidOfcCd			= request.getParameter("spot_bid_ofc_cd");
		String trspCrrModCd			= request.getParameter("trsp_crr_mod_cd");

		event.setSpotBidCnddtTermSeq(spotBidCnddtTermSeq);
		event.setVndrSeq(vndrSeq);
		event.setSpotBidOfcCd(spotBidOfcCd);
		event.setTrspCrrModCd(trspCrrModCd);
		
		event.setBiddingCandidateRegistrationVOs((BiddingCandidateRegistrationVO[])getVOs(request, BiddingCandidateRegistrationVO.class, ""));
		
		request.setAttribute("Event", event);
		return  event;
	}
}