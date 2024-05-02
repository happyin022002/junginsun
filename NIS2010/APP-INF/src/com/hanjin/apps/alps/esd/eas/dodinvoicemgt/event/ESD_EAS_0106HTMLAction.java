/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0106HTMLAction.java
*@FileTitle : (KOR) DOD Tariff Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2016-03-17
*@LastModifier : songji
*@LastVersion : 1.0
* 2016-03-17 songji
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODTariffVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * ESD_EAS_0106HTMLAction PDTO(Data Transfer Object including Parameters)<br>
 * @author songji
 * @see HTMLActionSupport 참조
 * @since J2EE 1.4
 */
public class ESD_EAS_0106HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
     * ESD_EAS_0106HTMLAction 객체를 생성
     */
    public ESD_EAS_0106HTMLAction() {
    }

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_EAS_0106Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	EsdEas0106Event event = new EsdEas0106Event();	
    	
    	if(command.isCommand(FormCommand.SEARCH)) {
    		//retrieve
    		event.setSessionOfcCd(JSPUtil.getParameter(request, "sel_ofc_cd", ""));
    		event.setSelPolContiCd(JSPUtil.getParameter(request, "sel_pol_conti_cd", ""));
    		event.setSelEffDt(JSPUtil.getParameter(request, "sel_eff_dt", ""));

    	}else if(command.isCommand(FormCommand.SEARCH01)){
    		//선택된  정보(conti, ofc_cd)로 Effect date List Search
    		event.setSessionOfcCd(JSPUtil.getParameter(request, "sel_ofc_cd", ""));
    		event.setSelPolContiCd(JSPUtil.getParameter(request, "sel_pol_conti_cd", ""));
    		
    	}else if(command.isCommand(FormCommand.SEARCH02)){
    		//verifyTpSz 입력된 tpsz_cd의 MDM내 존재여부 확인.
    		event.setSelCntrTpszCd(JSPUtil.getParameter(request, "sel_cntr_tpsz_cds", ""));
    		
    	}else if(command.isCommand(FormCommand.MULTI)){
    		
    		event.setDODTariffVOs((DODTariffVO[]) getVOs(request, DODTariffVO.class, ""));
    		
    	}else if(command.isCommand(FormCommand.SEARCH03)){
    		DODTariffVO dODTariffVO = new DODTariffVO();
    		dODTariffVO.setOfcCd(JSPUtil.getParameter(request, "c_ofc_cd", ""));
    		dODTariffVO.setPolContiCd(JSPUtil.getParameter(request, "c_pol_conti_cd", ""));
    		dODTariffVO.setPolCntCd(JSPUtil.getParameter(request, "c_pol_cnt_cd", ""));
    		dODTariffVO.setCntrTpszCd(JSPUtil.getParameter(request, "c_cntr_tpsz_cd", ""));
    		dODTariffVO.setEffDt(JSPUtil.getParameter(request, "c_eff_dt", ""));
    		dODTariffVO.setCurrCd(JSPUtil.getParameter(request, "c_curr_cd", ""));
    		event.setDODTariffVO(dODTariffVO);
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
