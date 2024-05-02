/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_MANUALHTMLAction.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : SeongMun_Kang
*@LastVersion : 1.0
* 2006-08-29 SeongMun_Kang
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.event;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.sce.common.util.basic.RequestDataSetBC;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.sce 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 COPManageSC로 실행요청<br>
 * - COPManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author SeongMun_Kang
 * @see EsdSceMANUALEvent, EsdSceMANUALEventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_MANUALHTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

    /**
     * ESD_SCE_MANUALHTMLAction 객체를 생성
     */
    public ESD_SCE_MANUALHTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsdSceMANUALEvent로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    @SuppressWarnings("rawtypes")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
        RequestDataSetBC dataSet = RequestDataSetBC.getInstance(request) ;       
    	FormCommand f_cmd  = FormCommand.fromRequest(request);
        log.debug("\n MANUAL START");      
        ArrayList models = getFromRequest(request); 
        EsdSceMANUALEvent event = new EsdSceMANUALEvent(dataSet,models); // form tag name           
        event.setCommandClassName("COPManageSC");
        event.setFormCommand(f_cmd);
        request.setAttribute("Event", event);
        log.debug("\n MANUAL END");

        return  event;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList getFromRequest(HttpServletRequest request) {
    	ArrayList models = new ArrayList();
    	String [] isStart = request.getParameterValues("trsp_so_seq");
    	if(isStart == null){
    		return models;
    	}
    	int reqLength = request.getParameterValues("trsp_so_seq").length;
    	HashMap requestMap = new HashMap();
    	log.debug("\n request start ");

		String[] chks            =  (JSPUtil.getParameter(request, "chk                   ".trim(), reqLength));
        String[] trsp_so_ofc_cty_cds            =  (JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd                   ".trim(), reqLength));
        String[] trsp_so_seqs         =  (JSPUtil.getParameter(request, "trsp_so_seq                ".trim(), reqLength));
        String[] so_rcv_dts            =  (JSPUtil.getParameter(request, "so_rcv_dt                   ".trim(), reqLength));
        String[] so_rcv_nos         =  (JSPUtil.getParameter(request, "so_rcv_no                ".trim(), reqLength));
        
    	for(int i = 0 ; i < reqLength ; i ++){
    		requestMap = new HashMap();

    		if(chks[i].equals("1")){
        		log.debug("\n chks[" + i + "]" + chks[i]);
        		log.debug("\n trsp_so_ofc_cty_cd[" + i + "]" + trsp_so_ofc_cty_cds[i]);
        		log.debug("\n trsp_so_seq[" + i + "]" + trsp_so_seqs[i]);
    			requestMap.put("trsp_so_ofc_cty_cd", trsp_so_ofc_cty_cds[i]);
    			requestMap.put("trsp_so_seq", trsp_so_seqs[i]);
    			requestMap.put("so_rcv_dt", so_rcv_dts[i]);
    			requestMap.put("so_rcv_no", so_rcv_nos[i]);
    			models.add(requestMap);
    		}        		
    	}    
        return models;
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