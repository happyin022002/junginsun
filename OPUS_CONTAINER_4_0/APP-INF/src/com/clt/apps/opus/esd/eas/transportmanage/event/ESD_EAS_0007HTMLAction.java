/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_005HTMLAction.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-29
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.eas.transportmanage.vo.DofChgTrfListVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * ESD_EAS_007HTMLAction PDTO(Data Transfer Object including Parameters)<br>
 * @author yujin
 * @see HTMLActionSupport 참조
 * @since J2EE 1.4
 */
public class ESD_EAS_0007HTMLAction extends HTMLActionSupport {

	   /**
     * ESD_EAS_007HTMLAction 객체를 생성
     */
    public ESD_EAS_0007HTMLAction() {
    }

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_EAS_007Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	EsdEas0007Event event = new EsdEas0007Event();	
    	
    	if(command.isCommand(FormCommand.SEARCH)) {
    		//retrieve
    		String sel_cnt_cd = JSPUtil.getParameter(request, "sel_cnt_cd", "");
    		String cust_cnt_seq = JSPUtil.getParameter(request, "cust_cnt_seq", "");
    		String s_type = JSPUtil.getParameter(request, "s_type", "");
    		
    		event.setSelCntCd(sel_cnt_cd);
    		event.setCustCntSeq(cust_cnt_seq);
    		event.setSType(s_type);
    	}else if(command.isCommand(FormCommand.SEARCH02)){
    		//searchDofChgDupCnt 중복 갯수 조회 기능
    		String s_loc_cd = JSPUtil.getParameter(request, "s_loc_cd", "");
    		String s_cust_info = JSPUtil.getParameter(request, "s_cust_info", "");
    		String s_type = JSPUtil.getParameter(request, "s_type", "");
    		String s_conti_cd = JSPUtil.getParameter(request, "s_conti_cd", "");
    		String s_cntr_tp_cd = JSPUtil.getParameter(request, "s_cntr_tp_cd", "");
    		
    		event.setSLocCd(s_loc_cd);
    		event.setSCustInfo(s_cust_info);
    		event.setSType(s_type);
    		event.setSContiCd(s_conti_cd);
    		event.setSCntrTpCd(s_cntr_tp_cd);
    	}else if(command.isCommand(FormCommand.SEARCH03)){
    		//verifyLocCd 입력된 loc_cd의 MDM내 존재여부 확인
    		String s_loc_cd = JSPUtil.getParameter(request, "s_loc_cd", "");
    		event.setSLocCd(s_loc_cd);
    	}else if(command.isCommand(FormCommand.SEARCH04)){  
    		//verifyCustCd 입력된 cust_cd의 MDM내 존재여부 확인.
    		String s_cust_info = JSPUtil.getParameter(request, "s_cust_info", "");
    		event.setSCustInfo(s_cust_info);
    	}else if(command.isCommand(FormCommand.SEARCH05)){
    		//verifyTpSz 입력된 tpsz_cd의 MDM내 존재여부 확인.
    		String s_cntr_tp_cd = JSPUtil.getParameter(request, "s_cntr_tp_cd", "");
    		event.setSCntrTpCd(s_cntr_tp_cd);
    	}else if(command.isCommand(FormCommand.SEARCH06)){  
    		//verifyCurr 입력된 curr_cd의 MDM내 존재여부 확인.
    		String s_curr_cd = JSPUtil.getParameter(request, "s_curr_cd", "");
    		event.setSCurrCd(s_curr_cd);
    		
    	}else if(command.isCommand(FormCommand.SEARCH11)){     
    		//선택된 Customer 정보로 Effect date List Search
    		String sel_cnt_cd = JSPUtil.getParameter(request, "sel_cnt_cd", "");
    		String cust_cnt_seq = JSPUtil.getParameter(request, "cust_cnt_seq", "");
    		event.setSelCntCd(sel_cnt_cd);
    		event.setCustCntSeq(cust_cnt_seq);
    	}else if(command.isCommand(FormCommand.MULTI)){
    		// Drop Off Charge Tariff 등록/수정/삭제시 IBLSheet에서 발생한 Event를 받아 작업
    		String newEffDate = JSPUtil.getParameter(request, "newEffDate", "");
    		String s_type = JSPUtil.getParameter(request, "s_type", "");
    		String ctrl_user_id = JSPUtil.getParameter(request, "ctrl_user_id", "");
    		String ctrl_ofc_cd = JSPUtil.getParameter(request, "ctrl_ofc_cd", "");
    		
    		DofChgTrfListVO dofChgTrfListVO   = new DofChgTrfListVO();
    		DofChgTrfListVO[] vo = null;   
    		vo = dofChgTrfListVO.fromRequestGrid(request);
    		
    		event.setNewEffDate(newEffDate);
    		event.setSType(s_type);
    		event.setCtrlUserId(ctrl_user_id);
    		event.setCtrlOfcCd(ctrl_ofc_cd);
    		event.setDofChgTrfListVOs(vo);	
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
