/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_076HTMLAction.java
*@FileTitle : usalastcitymanage
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-13
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-13 juhyun
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usalastcitymanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.event.EsdTrs0046Event;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.TrsDmstLstCtyVO;



/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.invoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InvoiceManageSC로 실행요청<br>
 * - InvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author chkong
 * @see EsdTrs0046Event , ESD_TRS_030EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0076HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

    /**
     * 1. 기능 : 객체 생성작업 <p>
     * 2. 처리개요 :  <p>
     *    - ESD_TRS_076HTMLAction 객체를 생성 <p>
     **/
    public ESD_TRS_0076HTMLAction() {}

    /**
     * 1. 기능 : HTML DOM 객체의 Value를 자바 변수로 Parsing <p>
     * 2. 처리개요 :  <p>
     *    - HttpRequst의 정보를 ESD_TRS_076Event로 파싱하여 request에 셋팅 <p>
     * @param request HttpServletRequest HttpRequest
     * @return Event - Event interface를 구현한 객체
     * @exception HTMLActionException
     **/
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	
    	  FormCommand command = FormCommand.fromRequest(request);
  	  	  EsdTrs0076Event event = new EsdTrs0076Event();
  	  	  
  	  	  String searchStr = JSPUtil.getParameter(request, "searchStr", "");
  	  	  String userId1 = JSPUtil.getParameter(request, "userid1", "");
  	  	  String today1 = JSPUtil.getParameter(request, "today1", "");
  	  	  String userId2 = JSPUtil.getParameter(request, "userid2", "");
  	  	  String today2 = JSPUtil.getParameter(request, "today2", "");
  	  	  String stsVal = JSPUtil.getParameter(request, "stsval", "");  	  	
  	  	  event.setSearchStr(searchStr);
  	  	  event.setUserId1(userId1);
  	  	  event.setToday1(today1);
  	  	  event.setUserId2(userId2);
  	  	  event.setToday2(today2);
  	  	  event.setStsVal(stsVal);
  	  	  
  	  	  String trspCostCtlModCd = JSPUtil.getParameter(request, "trsp_cost_dtl_mod_cd", "");
  	  	  String orgLocCd = JSPUtil.getParameter(request, "org_loc_cd", "");
  	  	  String destLocCd = JSPUtil.getParameter(request, "dest_loc_cd", "");
  	  	  
    	  if(command.isCommand(FormCommand.SEARCH)){
    		  event.setTrsDmstLstCtyVO((TrsDmstLstCtyVO)getVO(request, TrsDmstLstCtyVO.class));
    	  }else if(command.isCommand(FormCommand.SEARCH01)){
    		  event.setTrsDmstLstCtyVO((TrsDmstLstCtyVO)getVO(request, TrsDmstLstCtyVO.class));
    	  }else if(command.isCommand(FormCommand.SEARCH02)){
    		  event.setTrspCostDtlModCd(trspCostCtlModCd);
    		  event.setOrgLocCd(orgLocCd);
    		  event.setDestLocCd(destLocCd);
    	  }else if(command.isCommand(FormCommand.MULTI)){
    		  event.setTrsDmstLstCtyVos((TrsDmstLstCtyVO[])getVOs(request, TrsDmstLstCtyVO.class, ""));
    	  }
    	  
    	  request.setAttribute("Event", event);
    	  return  event;
    	 }    
    
    
   /**
     * 1. 기능 : HttpRequest의 attribute에 업무시나리오 수행결과 값 저장 <p>
     * 2. 처리개요 :  <p>
     *    - ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅 <p>
     * @param request HttpServletRequest HttpRequest
     * @param eventResponse EventResponse interface를 구현한 객체
     **/
    public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
        request.setAttribute("EventResponse", eventResponse);
    }

   /**
     * 1. 기능 : HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장 <p>
     * 2. 처리개요 :  <p>
     *    - HttpRequest 파싱 수행결과 값 request에 셋팅 <p>
     * @param request HttpServletRequest HttpRequest
     * @param event Event Event - interface를 구현한 객체
     **/
    public void doEnd(HttpServletRequest request, Event event) {
        request.setAttribute("Event", event);
    }

}