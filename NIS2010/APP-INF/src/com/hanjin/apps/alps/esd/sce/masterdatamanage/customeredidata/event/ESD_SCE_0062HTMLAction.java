/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0035HTMLAction.java
*@FileTitle : EsdSce0035
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-26
*@LastModifier : yongcheon_shin
*@LastVersion : 1.0
* 2006-09-20 yongcheon_shin
* 1.0 최초 생성
* history
* 2012-04-27 채창호 [CHM-201217464-01]:SCEM(Customer EDI) upgrade project 관련 화면 수정 요청(1)
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.CustomerInqChoiceVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerCntVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInqueryVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 UserManagerSC로 실행요청<br>
 * - UserManagerSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author yong_cheon_shin
 * @see ReserveSendManagerEvent , PNSendManagerEventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0062HTMLAction  extends HTMLActionSupport{
	
	private static final long serialVersionUID = 1L;
    /** Constructor
     * 
     */
    public ESD_SCE_0062HTMLAction(){
        
    }
    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 IbatchVisibilityEvent로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	log.debug("Event 0062 생성!!");
        EsdSce0062Event event = new EsdSce0062Event();
        FormCommand f_cmd = FormCommand.fromRequest(request);
        
        if (f_cmd.isCommand(FormCommand.SEARCH01) ) {
        	log.debug("Search01 를 위한 호출"); 
        	CustomerInqChoiceVO condition = new CustomerInqChoiceVO();
			condition.setCsCd(JSPUtil.getParameter(request, "cs_cd", ""));
			condition.setScNo(JSPUtil.getParameter(request, "sc_no", ""));
			condition.setTpId(JSPUtil.getParameter(request, "tp_id", ""));
			condition.setCsNm(JSPUtil.getParameter(request, "cs_nm", ""));
			condition.setHjTpId(JSPUtil.getParameter(request, "hj_tp_id", ""));
			event.setCustChoice(condition);
			log.debug("cs_cd==" + request.getParameter("cs_cd"));
			log.debug("sc_no==" + request.getParameter("sc_no"));
			log.debug("tp_id==" + request.getParameter("tp_id"));
			log.debug("cs_nm==" + request.getParameter("cs_nm"));
	    	event.setCustInq((SearchCustomerInqueryVO) getVO(request,SearchCustomerInqueryVO.class));
        } else if ( f_cmd.isCommand(FormCommand.SEARCH02) ) {
        	log.debug("Search02를 위한 호출"); 
        	CustomerInqChoiceVO condition = new CustomerInqChoiceVO();
        	condition.setUserId(JSPUtil.getParameter(request, "user_id", ""));
			condition.setEdiGrpCd(JSPUtil.getParameter(request, "temp_edi_grp", ""));
			condition.setCustTrdPrnrId(JSPUtil.getParameter(request, "temp_edi_id", ""));
			condition.setEdiGrpDesc(JSPUtil.getParameter(request, "temp_edi_nm", ""));
			condition.setHjTpId(JSPUtil.getParameter(request, "hj_tp_id", ""));
			event.setCustChoice(condition);
			log.debug("user_id==" + request.getParameter("user_id"));
			log.debug("edi_grp==" + request.getParameter("temp_edi_grp"));
			log.debug("edi_id==" + request.getParameter("temp_edi_id"));
			log.debug("edi_nm==" + request.getParameter("temp_edi_nm"));
    		event.setCustInqCnt((SearchCustomerCntVO) getVO(request,SearchCustomerCntVO.class));
    	}
        
        request.setAttribute("Event", event);
        return event;
    }
    /** request 내의 parameter의 값을 HashMap으로 반환한다.
     * @param request
     * @return hMap
     */
    /*public HashMap getParameterArray(HttpServletRequest request){
        String keyName = "";
        String keyValue = "";
        HashMap hMap = new HashMap();
        
        for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ){
            try{
	            keyName = (String)en.nextElement();
	            keyValue = JSPUtil.getParameter(request, keyName.trim(), "");
            }catch(Exception ex){
            	log.error("err " + ex.toString(), ex);
                keyValue = "";
            }
            hMap.put(keyName, keyValue);
        }
        return hMap;
    }*/
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
    /** HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
     * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @param event Event interface를 구현한 객체
     */
    public void doEnd(HttpServletRequest request, Event event) {
        request.setAttribute("Event", event);
    }
}
