/*=========================================================
 *Copyright(c) 2010 CyberLogitec 
 *@FileName : EES_CIM_0064HTMLAction.java
 *@FileTitle : UC Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.07.04
 *@LastModifier : DO-HYUN KIM
 *@LastVersion : 1.0
 * 2014.07.04  
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.SearchUncollectedInquiryListVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.agreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * @author jong hyek choi
 * @see EesCim0064Event , EES_CIM_0064EventResponse 참조
 * @since J2EE 1.4
 */
public class EES_CIM_0064HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EES_CIM_0064Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);

		SearchUncollectedInquiryListVO searchApprovalMgmtVO   = new SearchUncollectedInquiryListVO();
		SearchUncollectedInquiryListVO[] tcz = null; 
		if(command.isCommand(FormCommand.MULTI01) || command.isCommand(FormCommand.REMOVE) ) {
			tcz = searchApprovalMgmtVO.fromRequestGrid(request);
		}
		EesCim0064Event event = new EesCim0064Event();
		
		event.setSearchUncollectedInquiryListVOs(tcz);
		
		String sRetrieveGb   = JSPUtil.getParameter(request, "s_retrieve_gb", "");
		String sUcCsNo       = JSPUtil.getParameter(request, "s_uc_cs_no", "");
		String sBlNo         = JSPUtil.getParameter(request, "s_bl_no", "");
		String sCntrNo       = JSPUtil.getParameter(request, "s_cntr_no", "");
		String sCneeUcDtGb   = JSPUtil.getParameter(request, "s_cnee_uc_dt_gb", "");
		String sCneeUcDtFr   = JSPUtil.getParameter(request, "s_cnee_uc_dt_fr", "");
		String sCneeUcDtTo   = JSPUtil.getParameter(request, "s_cnee_uc_dt_to", "");
		String sUcDysGb      = JSPUtil.getParameter(request, "s_uc_dys_gb", "");
		String sUcDysFr      = JSPUtil.getParameter(request, "s_uc_dys_fr", "");
		String sUcDysTo      = JSPUtil.getParameter(request, "s_uc_dys_to", "");
		String sUcStsCd      = JSPUtil.getParameter(request, "uc_sts_cd", "");
		String sUcRsnCd      = JSPUtil.getParameter(request, "uc_rsn_cd", "");
		String sHndlRhqCd    = JSPUtil.getParameter(request, "s_hndl_rhq_cd", "");
		String sKntrRhqCd    = JSPUtil.getParameter(request, "s_kntr_rhq_cd", "");
		String sUcDispOptCd  = JSPUtil.getParameter(request, "uc_disp_opt_cd", "");
		String sPolCd        = JSPUtil.getParameter(request, "s_pol_cd", "");
		String sHndlBrncCd   = JSPUtil.getParameter(request, "s_hndl_brnc_cd", "");
		String sKntrBrncCd   = JSPUtil.getParameter(request, "s_kntr_brnc_cd", "");
		String sPodCd        = JSPUtil.getParameter(request, "s_pod_cd", "");
		String sCaseBy       = JSPUtil.getParameter(request, "s_case_gb", "");
		
		if("A".equals(sRetrieveGb)){		//조회조건:1
			sCneeUcDtGb   = "";
			sCneeUcDtFr   = "";
			sCneeUcDtTo   = "";
			sUcDysGb      = "";
			sUcDysFr      = "";
			sUcDysTo      = "";
			sUcStsCd      = "";
			sUcRsnCd      = "";
			sHndlRhqCd    = "";
			sKntrRhqCd    = "";
			sUcDispOptCd  = "";
			sPolCd        = "";
			sHndlBrncCd   = "";
			sKntrBrncCd   = "";
			sPodCd        = "";
		}else if("B".equals(sRetrieveGb)){	//조회조건:2
			sUcCsNo       = "";
			sBlNo         = "";
			sCntrNo       = "";
		}

		event.setsByCase(sCaseBy);     
		event.setsRetrieveGb(sRetrieveGb);     
		event.setsUcCsNo(sUcCsNo);     
		event.setsBlNo(sBlNo);       
		event.setsCntrNo(sCntrNo);     
		event.setsCneeUcDtGb(sCneeUcDtGb); 
		event.setsCneeUcDtFr(sCneeUcDtFr); 
		event.setsCneeUcDtTo(sCneeUcDtTo); 
		event.setsUcDysGb(sUcDysGb);    
		event.setsUcDysFr(sUcDysFr);    
		event.setsUcDysTo(sUcDysTo);    
		event.setsUcStsCd(sUcStsCd);    
		event.setsUcRsnCd(sUcRsnCd);    
		event.setsHndlRhqCd(sHndlRhqCd);  
		event.setsKntrRhqCd(sKntrRhqCd);  
		event.setsUcDispOptCd(sUcDispOptCd);
		event.setsPolCd(sPolCd);      
		event.setsHndlBrncCd(sHndlBrncCd); 
		event.setsKntrBrncCd(sKntrBrncCd); 
		event.setsPodCd(sPodCd);      
		
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
