/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_EAS_0011HTMLAction.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2012-03-02
*@LastModifier : sungho park
*@LastVersion : 1.0
* 2012-03-02 sungho park
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.eas.transportmanage.vo.CommEasDrffChgTrfVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.EasDrffChgTrfHdrVO;

/**
 * ESD_EAS_011HTMLAction PDTO(Data Transfer Object including Parameters)<br>
 * @author sungho park
 * @see HTMLActionSupport 참조
 * @since J2EE 1.4
 */
public class ESD_EAS_0011HTMLAction extends HTMLActionSupport {

	   /**
     * ESD_EAS_011HTMLAction 객체를 생성
     */
    public ESD_EAS_0011HTMLAction() {
    }

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_EAS_011Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	EsdEas0011Event event = new EsdEas0011Event();	
    	
    	if(command.isCommand(FormCommand.SEARCH)) {
    		//searchEasDrffChgTrfHdrRSQL
    		String cnt_cd = JSPUtil.getParameter(request, "cnt_cd", "");
    		String rfa_no = JSPUtil.getParameter(request, "rfa_no", "");
    		
    		event.setCntCd(cnt_cd);
    		event.setRfaNo(rfa_no);
    	}else if(command.isCommand(FormCommand.SEARCH01)){
    		//searchEasDrffChgTrfSccDtlRSQL
    		String cnt_cd = JSPUtil.getParameter(request, "cnt_cd", "");
    		String drff_chg_trf_seq = JSPUtil.getParameter(request, "drff_chg_trf_seq", "");
    		String drff_chg_trf_ver_no = JSPUtil.getParameter(request, "drff_chg_trf_ver_no", "");
    		
    		event.setCntCd(cnt_cd);
    		event.setDrffChgTrfSeq(drff_chg_trf_seq);
    		event.setDrffChgTrfVerNo(drff_chg_trf_ver_no);
    	}else if(command.isCommand(FormCommand.SEARCH02)){
    		//searchEasDrffChgTrfDtlRSQL
    		String cnt_cd = JSPUtil.getParameter(request, "cnt_cd", "");
    		String drff_chg_trf_seq = JSPUtil.getParameter(request, "drff_chg_trf_seq", "");
    		String drff_chg_trf_ver_no = JSPUtil.getParameter(request, "drff_chg_trf_ver_no", "");
    		
    		event.setCntCd(cnt_cd);
    		event.setDrffChgTrfSeq(drff_chg_trf_seq);
    		event.setDrffChgTrfVerNo(drff_chg_trf_ver_no);
//    	}else if(command.isCommand(FormCommand.SEARCH03)){
//    		//searchCountryCombo
//    		String sel_cnt_cd = JSPUtil.getParameter(request, "cnt_cd", "");
//    		event.setSelCntCd(sel_cnt_cd);
//    	}else if(command.isCommand(FormCommand.SEARCH04)){
//    		//checkInputRfaNo
//    		String scc_cd = JSPUtil.getParameter(request, "scc_cd", "");
//    		event.setSccCd(scc_cd);
//    	}else if(command.isCommand(FormCommand.SEARCH05)){
//    		//verifyTpSz 입력된 tpsz_cd의 MDM내 존재여부 확인.
//    		String s_cntr_tp_cd = JSPUtil.getParameter(request, "s_cntr_tp_cd", "");
//    		event.setSCntrTpCd(s_cntr_tp_cd);
//    	}else if(command.isCommand(FormCommand.SEARCH06)){  
//    		//verifyCurr 입력된 curr_cd의 MDM내 존재여부 확인.
//    		String s_curr_cd = JSPUtil.getParameter(request, "s_curr_cd", "");
//    		event.setSCurrCd(s_curr_cd);
//
    	}else if(command.isCommand(FormCommand.SEARCH11)){
    		String sel_cnt_cd = JSPUtil.getParameter(request, "sel_cnt_cd", "");
    		String rfa_no = JSPUtil.getParameter(request, "rfa_no", "");
    		event.setSelCntCd(sel_cnt_cd);
    		event.setRfaNo(rfa_no);    		
    	}else if(command.isCommand(FormCommand.SEARCH12)){
    		String sccCd2 = JSPUtil.getParameter(request, "scc_cd2", "");
    		event.setSccCd2(sccCd2);
    	}else if(command.isCommand(FormCommand.SEARCH13)){
    		event.setCommEasDrffChgTrfVOs		(((CommEasDrffChgTrfVO[])	getVOs(request, CommEasDrffChgTrfVO .class, "")) );    		    		    		
    	}else if(command.isCommand(FormCommand.MULTI)){
    		String is_save = JSPUtil.getParameter(request, "is_save", "");  
    		String is_upload = JSPUtil.getParameter(request, "is_upload", "");    		
    		event.setIsSave(is_save);
    		event.setIsUpload(is_upload);
    		event.setEasDrffChgTrfHdrVO			((EasDrffChgTrfHdrVO)		getVO(request, EasDrffChgTrfHdrVO .class));
    		event.setCommEasDrffChgTrfVOs		(((CommEasDrffChgTrfVO[])	getVOs(request, CommEasDrffChgTrfVO .class, "")) );
    	}

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
