/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0200HTMLAction.java
*@FileTitle : Awakward Cargo Application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.10 이병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclReqInVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SpecialCargoBookingConductSC로 실행요청<br>
 * - SpecialCargoBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Byung Kyu
 * @see SpecialCargoBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0200HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0200HTMLAction 객체를 생성
	 */
	public ESM_BKG_0200HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SpecialCargoBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0200Event event = new EsmBkg0200Event();
        log.debug("::CALL::> ESM_BKG_0200_HTMLAction - " + command.getCommand());

        if(command.isCommand(FormCommand.DEFAULT)) {
            // search Init
            String bkgNo      = JSPUtil.getParameter(request, "bkg_no");
            String blNo       = JSPUtil.getParameter(request, "bl_no");
            

            event.setBkgNo(bkgNo);
            event.setBlNo(blNo);
            
            
           
        } else if(command.isCommand(FormCommand.SEARCH)) {
            
            String bkgNo = JSPUtil.getParameter(request, "bkg_no");
            String blNo       = JSPUtil.getParameter(request, "bl_no");
                                    
            event.setBkgNo(bkgNo);
            event.setBlNo(blNo);
                        
        }  else if(command.isCommand(FormCommand.MULTI)) {			
        	
        	DgCgoListVO[] dgCgoListVOs 	= (DgCgoListVO[])getVOs(request, DgCgoListVO .class,"sheet3_");
        	
        	
        	String bkgNo = JSPUtil.getParameter(request, "bkg_no");
        	String dcgoSeq = JSPUtil.getParameter(request, "dcgo_seq");
        	String button = JSPUtil.getParameter(request, "button");
        	String dgChkFlg = JSPUtil.getParameter(request, "dg_chk_flg");
        	String saveButton = JSPUtil.getParameter(request, "save_button");
			
        	event.setBkgNo(bkgNo);
        	event.setDcgoSeq(dcgoSeq);
        	event.setButton(button);
			event.setDgCgoListVOs(dgCgoListVOs);		
			event.setDgChkFlg(dgChkFlg);
			event.setSaveButton(saveButton);
        	
		}  else if(command.isCommand(FormCommand.COMMAND01)) {			
        	
        	SpclReqInVO[] spclReqInVOs 	= (SpclReqInVO[])getVOs(request, SpclReqInVO .class,"sheet3_");
        	        	
        	String bkgNo = JSPUtil.getParameter(request, "bkg_no"); 
        	String button = JSPUtil.getParameter(request, "button");
        	
        	event.setBkgNo(bkgNo); 
        	event.setButton(button);
			event.setSpclReqInVOs(spclReqInVOs);			
        	log.debug("spclReqInVOs=========>"+spclReqInVOs);
        } else if(command.isCommand(FormCommand.SEARCH01)) {
            
        	String bkgNo = JSPUtil.getParameter(request, "bkg_no");
        	String dcgoSeq = JSPUtil.getParameter(request, "dcgo_seq");
                                    
        	event.setBkgNo(bkgNo);
        	event.setDcgoSeq(dcgoSeq);
		} 
        request.setAttribute("Event", event);

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