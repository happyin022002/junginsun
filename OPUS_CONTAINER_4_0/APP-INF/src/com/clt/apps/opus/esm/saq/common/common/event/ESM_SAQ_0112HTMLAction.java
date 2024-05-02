/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_SAQ_0112HTMLAction.java
*@FileTitle      : remark
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.saq.common.common.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.SaqMonQtaLodTgtRmkVO;
import com.clt.syscommon.common.table.SaqMonQtaRhqRmkVO;
import com.clt.syscommon.common.table.SaqMonQtaTrdRmkVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.saq.common 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CommonSC로 실행요청<br>
 * - CommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 최민철
 * @see ESM_SAQ_0112Event , ESM_SAQ_0112EventResponse 참조
 * @since J2EE 1.4
 */

@SuppressWarnings("serial")
public class ESM_SAQ_0112HTMLAction extends HTMLActionSupport {

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESM_SAQ_0112Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSaq0112Event event = new EsmSaq0112Event();
		

		event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO .class));

		if(command.isCommand(FormCommand.MODIFY01)) {
			event.setSaqMonQtaTrdRmkVO((SaqMonQtaTrdRmkVO)getVO(request, SaqMonQtaTrdRmkVO .class));
		}
		else if(command.isCommand(FormCommand.MODIFY02)) {
			event.setSaqMonQtaRhqRmkVO((SaqMonQtaRhqRmkVO)getVO(request, SaqMonQtaRhqRmkVO .class));
		}
		else if(command.isCommand(FormCommand.MODIFY03)) {
			event.setSaqMonQtaLodTgtRmkVO((SaqMonQtaLodTgtRmkVO)getVO(request, SaqMonQtaLodTgtRmkVO .class));
		}

		return  event;
		
		/*SaqMonQtaTrdRmkVO saq_mon_qta_trd_rmk = new SaqMonQtaTrdRmkVO();
		saq_mon_qta_trd_rmk.fromRequest(request);
		SaqMonQtaRhqRmkVO saq_mon_qta_rhq_rmk = new SaqMonQtaRhqRmkVO();
		saq_mon_qta_rhq_rmk.fromRequest(request);
		SaqMonQtaLodTgtRmkVO saq_mon_qta_lod_tgt_rmk = new SaqMonQtaLodTgtRmkVO();
		saq_mon_qta_lod_tgt_rmk.fromRequest(request);		
		FormCommand f_cmd = FormCommand.fromRequest(request);
		EsmSaq0112Event event = new EsmSaq0112Event();
		
		String gline_ver_no = JSPUtil.getParameter(request, "gline_ver_no".trim(), "");

		String mqta_step_cd = JSPUtil.getParameter(request, "mqta_step_cd".trim(), "");
		String bse_yr       = JSPUtil.getParameter(request, "bse_yr".trim(), "");
		String bse_qtr_cd   = JSPUtil.getParameter(request, "bse_qtr_cd".trim(), "");
		String trd_cd       = JSPUtil.getParameter(request, "trd_cd".trim(), "");
		String dir_cd       = JSPUtil.getParameter(request, "dir_cd".trim(), "");
		String mqta_ver_no  = JSPUtil.getParameter(request, "mqta_ver_no".trim(), "");
		String rlane_cd     = JSPUtil.getParameter(request, "rlane_cd".trim(), "");
		String sprt_grp_cd  = JSPUtil.getParameter(request, "sprt_grp_cd".trim(), "");
		String bsa_grp_cd   = JSPUtil.getParameter(request, "bsa_grp_cd".trim(), "");
		String rhq_cd       = JSPUtil.getParameter(request, "rhq_cd".trim(), "");
		String bse_mon      = JSPUtil.getParameter(request, "bse_mon".trim(), "");
		
		String rgn_ofc_cd   = JSPUtil.getParameter(request, "rgn_ofc_cd".trim(), "");
		String pol_cd       = JSPUtil.getParameter(request, "pol_cd".trim(), "");
		String pod_cd       = JSPUtil.getParameter(request, "pod_cd".trim(), "");

		String cre_ofc_cd   = JSPUtil.getParameter(request, "cre_ofc_cd".trim(), "");

		
		String subj_ctnt    = JSPUtil.getParameter(request, "subj_ctnt   ".trim(), "");
		String cmt_ctnt     = JSPUtil.getParameter(request, "cmt_ctnt    ".trim(), "");
		String rmk_cre_gdt  = JSPUtil.getParameter(request, "rmk_cre_gdt ".trim(), "");
		String saq_sts_cd   = JSPUtil.getParameter(request, "saq_sts_cd  ".trim(), "");
				

		event.setGline_ver_no(gline_ver_no);
		
		event.setMqta_step_cd(mqta_step_cd);
		event.setBse_yr(bse_yr);
		event.setBse_qtr_cd(bse_qtr_cd);
		event.setTrd_cd(trd_cd);
		event.setDir_cd(dir_cd);
		event.setMqta_ver_no(mqta_ver_no);
		event.setRlane_cd(rlane_cd);
		event.setSprt_grp_cd(sprt_grp_cd);
		event.setBsa_grp_cd(bsa_grp_cd);
		event.setRhq_cd(rhq_cd);
		event.setBse_mon(bse_mon);
		
		event.setRgn_ofc_cd(rgn_ofc_cd);
		event.setPol_cd(pol_cd);
		event.setPod_cd(pod_cd);
		event.setCre_ofc_cd(cre_ofc_cd);
		
		event.setSaq_mon_qta_trd_rmk(saq_mon_qta_trd_rmk);
		event.setSaq_mon_qta_rhq_rmk(saq_mon_qta_rhq_rmk);
		event.setSaq_mon_qta_lod_tgt_rmk(saq_mon_qta_lod_tgt_rmk);		
		
		event.setCommandClassName("CommonSC");
		event.setFormCommand(f_cmd);
		request.setAttribute("Event", event);
		return event;*/
		
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