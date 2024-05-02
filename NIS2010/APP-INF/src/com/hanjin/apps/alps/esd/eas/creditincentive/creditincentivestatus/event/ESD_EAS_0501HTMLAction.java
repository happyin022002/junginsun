/*============================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESD_EAS_0501HTMLAction.java
*@FileTitle : 
*@LastModifyDate : 2016.04.26.
*@LastModifier : 
*@LastVersion : 
* 2016.04.26. SHIN DONG IL
*============================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.event.EventSupport;

import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.TesStatusIncntVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.TrsStatusIncntVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.VslStatusIncntVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.MnrStatusCrIssVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.MnrStatusCrUsdVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.BnfStatusMlgVO;

/**
 * ESD_EAS_0501HTMLAction PDTO(Data Transfer Object including Parameters)<br>
 * @author SHIN DONG IL
 * @see EventSupport 참조
 * @since J2EE 1.6
 */
public class ESD_EAS_0501HTMLAction extends HTMLActionSupport{
	/**
	 * ESD_EAS_0501HTMLAction 객체를 생성 
	 */
	public ESD_EAS_0501HTMLAction() {
	}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdEas0501Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsdEas0501Event event = new EsdEas0501Event();
		
		if(command.isCommand(FormCommand.SEARCHLIST01)|| command.isCommand(FormCommand.SEARCHLIST02)||command.isCommand(FormCommand.SEARCHLIST03)){
			event.setStrRhqCd(JSPUtil.getParameter(request, "s_rhq_ofc_cd", ""));
			event.setStrInvOfcCd(JSPUtil.getParameter(request, "s_inv_ofc_cd", ""));
			event.setStrBseYr(JSPUtil.getParameter(request, "s_bse_yr", ""));
			event.setStrInvVndrSeq(JSPUtil.getParameter(request, "s_inv_vndr_seq", ""));
		}else if(command.isCommand(FormCommand.SEARCHLIST04)||command.isCommand(FormCommand.SEARCHLIST07)){ 
			event.setStrFmDt(JSPUtil.getParameter(request, "s_fm_dt", "").replaceAll("-", ""));
			event.setStrToDt(JSPUtil.getParameter(request, "s_to_dt", "").replaceAll("-", ""));
			event.setStrMkrCd(JSPUtil.getParameter(request, "s_mkr_cd", ""));
			event.setStrCrUsdOfcCd(JSPUtil.getParameter(request, "s_cr_usd_ofc_cd", ""));
		}else if(command.isCommand(FormCommand.SEARCHLIST05)){ 
			event.setStrCrIssNo(JSPUtil.getParameter(request, "str_cr_iss_no", ""));	
		}else if(command.isCommand(FormCommand.SEARCHLIST06)){
			event.setStrFmDt(JSPUtil.getParameter(request, "s_fm_dt", "").replaceAll("-", ""));
			event.setStrToDt(JSPUtil.getParameter(request, "s_to_dt", "").replaceAll("-", ""));
		}else if(command.isCommand(FormCommand.SEARCH01)){
			event.setRhqOfcCd(JSPUtil.getParameter(request, "rhq_ofc_cd", ""));
		}else if(command.isCommand(FormCommand.SEARCH02)){
			event.setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		}else if(command.isCommand(FormCommand.SEARCH03)){
			event.setPortCd(JSPUtil.getParameter(request, "port_cd", ""));	
		}else if(command.isCommand(FormCommand.SEARCH04)){
			event.setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		}else if(command.isCommand(FormCommand.SEARCH05)||command.isCommand(FormCommand.SEARCH06)){
			event.setLgsCostCd(JSPUtil.getParameter(request, "lgs_cost_cd", ""));		
		}else if(command.isCommand(FormCommand.MULTI01)||command.isCommand(FormCommand.REMOVE01)){ 
			event.setTesStatusIncntVOs((TesStatusIncntVO[])getVOs(request, TesStatusIncntVO.class,""));
		}else if(command.isCommand(FormCommand.MULTI02)||command.isCommand(FormCommand.REMOVE02)){ 
			event.setTrsStatusIncntVOs((TrsStatusIncntVO[])getVOs(request, TrsStatusIncntVO.class,""));	
		}else if(command.isCommand(FormCommand.MULTI03)||command.isCommand(FormCommand.REMOVE03)){ 
			event.setVslStatusIncntVOs((VslStatusIncntVO[])getVOs(request, VslStatusIncntVO.class,""));
		}else if(command.isCommand(FormCommand.MULTI04)||command.isCommand(FormCommand.REMOVE04)){ 
			event.setMnrStatusCrIssVOs((MnrStatusCrIssVO[])getVOs(request, MnrStatusCrIssVO.class,""));
		}else if(command.isCommand(FormCommand.MULTI05)||command.isCommand(FormCommand.REMOVE05)){ 
			event.setMnrStatusCrUsdVOs((MnrStatusCrUsdVO[])getVOs(request, MnrStatusCrUsdVO.class,""));
		}else if(command.isCommand(FormCommand.MULTI06)||command.isCommand(FormCommand.REMOVE06)){
			event.setBnfStatusMlgVOs((BnfStatusMlgVO[])getVOs(request, BnfStatusMlgVO.class,""));
		}else if(command.isCommand(FormCommand.MODIFY01)||command.isCommand(FormCommand.MODIFY02)||command.isCommand(FormCommand.MODIFY03)||command.isCommand(FormCommand.MODIFY05)
				||command.isCommand(FormCommand.MODIFY06)||command.isCommand(FormCommand.MODIFY07)||command.isCommand(FormCommand.MODIFY08)||command.isCommand(FormCommand.MODIFY10)
				){	
			event.setStrBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
			event.setStrIncntNo(JSPUtil.getParameter(request, "incnt_no", ""));
			event.setStrAtchFileLnkId(JSPUtil.getParameter(request, "atch_file_lnk_id", ""));
		}else if(command.isCommand(FormCommand.MODIFY04)){	
			event.setStrCrIssNo(JSPUtil.getParameter(request, "cr_iss_no", ""));
			event.setStrAtchFileLnkId(JSPUtil.getParameter(request, "atch_file_lnk_id", ""));
		}else if(command.isCommand(FormCommand.MODIFY09)){	
			event.setStrCrIssNo(JSPUtil.getParameter(request, "cr_iss_no", ""));
			event.setStrCrUsdSeq(JSPUtil.getParameter(request, "cr_usd_seq", ""));
			event.setStrAtchFileLnkId(JSPUtil.getParameter(request, "atch_file_lnk_id", ""));	
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