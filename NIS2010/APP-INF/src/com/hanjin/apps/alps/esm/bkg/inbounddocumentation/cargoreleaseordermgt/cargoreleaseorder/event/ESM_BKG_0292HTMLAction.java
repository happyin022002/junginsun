/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0292HTMLAction.java
*@FileTitle : eDO Issue Application Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.06.25 안진응
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - eDO Issue Application Inquiry 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InboundBLMgtSC로 실행요청<br>
 * - InboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lim Jin Young
 * @see EsmBkg0682Event 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0292HTMLAction extends HTMLActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = -3889119389133086344L;

    /**
     * ESM_BKG_0682HTMLAction 객체를 생성
     */
    public ESM_BKG_0292HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsmBkg0292Event로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

        FormCommand command = FormCommand.fromRequest(request);
        EsmBkg0292Event event = new EsmBkg0292Event();

        String bkgNo    = "";
        String blNo     = "";
        String cntrNo   = "";
        String poNo     = "";
        
        String strTemp  = ""; 
        
        log.debug("===================================");
        log.debug("    ESM_BKG_0292HTMLAction Start   ");
        log.debug("===================================");

        bkgNo = request.getParameter("bkg_no");
        blNo  = request.getParameter("bl_no");
        
        
        if(command.isCommand(FormCommand.SEARCH)) {
            if (blNo.isEmpty() == false) {
    	        strTemp = blNo.substring(blNo.length()-1);
    	        log.debug("strTemp   ===> " + strTemp);
    	        
    	        if (strTemp.equals("W") || strTemp.equals("S")) {
    	        	
    	        	blNo = blNo.substring(0, blNo.length()-1);
    	        }
            }

            
            event.setBkgNo(bkgNo);
            event.setBlNo(blNo);

            log.debug("=======================================");
            log.debug("    bkgNo  : "+ bkgNo                   );
            log.debug("    blNo   : "+ blNo                    );
            log.debug("=======================================");

            log.debug("===================================");
            log.debug("    SEARCH EVENT                   ");
            log.debug("===================================");

        }else if(command.isCommand(FormCommand.SEARCH03)) {
            if (blNo.isEmpty() == false) {
    	        strTemp = blNo.substring(blNo.length()-1);
    	        log.debug("strTemp   ===> " + strTemp);
    	        
    	        if (strTemp.equals("W") || strTemp.equals("S")) {
    	        	log.debug(strTemp + "존재함 ===> " + blNo.substring(0, blNo.length()-1));
    	        	blNo = blNo.substring(0, blNo.length()-1);
    	        }
            }
            
            event.setBkgNo(bkgNo);
            event.setBlNo(blNo);

            log.debug("=======================================");
            log.debug("    bkgNo  : "+ bkgNo                   );
            log.debug("    blNo   : "+ blNo                    );
            log.debug("=======================================");

            log.debug("===================================");
            log.debug("    SEARCH03 EVENT                 ");
            log.debug("===================================");
        	
        }else if(command.isCommand(FormCommand.SEARCH05)) {
            if (blNo.isEmpty() == false) {
    	        strTemp = blNo.substring(blNo.length()-1);
    	        log.debug("strTemp   ===> " + strTemp);
    	        
    	        if (strTemp.equals("W") || strTemp.equals("S")) {
    	        	
    	        	blNo = blNo.substring(0, blNo.length()-1);
    	        }
            }
            
            event.setBkgNo(bkgNo);
            event.setBlNo(blNo);

            log.debug("=======================================");
            log.debug("    bkgNo  : "+ bkgNo                   );
            log.debug("    blNo   : "+ blNo                    );
            log.debug("=======================================");

            log.debug("===================================");
            log.debug("    SEARCH05 EVENT                 ");
            log.debug("===================================");
            
            
        }else if(command.isCommand(FormCommand.SEARCH01)) {
        	log.debug("cntr_no  ===> " + request.getParameter("cntr_no"));
        	
        	cntrNo  = request.getParameter("cntr_no");

        	event.setCntrNo(cntrNo);

            log.debug("===================================");
            log.debug("    SEARCH01 EVENT                 ");
            log.debug("    cntrNo : "+ cntrNo              );
            log.debug("===================================");
        	
        }else if(command.isCommand(FormCommand.SEARCH02)) {
        	log.debug("po_no  ===> " + request.getParameter("po_no"));
        	
            poNo  = request.getParameter("po_no");

            event.setPoNo(poNo);

            log.debug("===================================");
            log.debug("    SEARCH02 EVENT                 ");
            log.debug("    poNo   : "+ poNo                );
            log.debug("===================================");
        	
        } else {
        	log.debug("cntr_no  ===> " + request.getParameter("cntr_no") + "   " + command.getCommand());        	
        }
        request.setAttribute("Event", event);
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