/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0115HTMLAction.java
*@FileTitle : Manual Container Mapping
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2008-09 Hun-Il Jung
* 1.0 최초 생성
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.BkgCopManageVO;
import com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.vo.ManualReplanInfoVO;
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
 * @author Hun-Il Jung
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0115HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
     * ESD_SCE_0115HTMLAction 객체를 생성
     */
    public ESD_SCE_0115HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsdSce0115Event로 파싱하여 request에 셋팅<br>
     *
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

    	//RequestDataSetBC dataSet = RequestDataSetBC.getInstance(request) ;
    	FormCommand command = FormCommand.fromRequest(request);
        EsdSce0115Event event = new EsdSce0115Event();

		if (command.isCommand(FormCommand.SEARCHLIST)) {
//			String[] bkgNos = request.getParameterValues("bkg_no");
			
			event.setManualReplanInfoVOs((ManualReplanInfoVO[])getVOs(request, ManualReplanInfoVO .class,""));
		
		}else if (command.isCommand(FormCommand.MULTI01)) {
			
			event.setBkgCopManageVOs((BkgCopManageVO[])getVOs(request, BkgCopManageVO .class,""));
 			
		} else {
	        String selection = request.getParameter("selection");
	        if(selection != null && "cntr_no".equals(selection)){
	        	ManualReplanInfoVO vo = new ManualReplanInfoVO();
		        String cntrNo = request.getParameter("cntr_no_txt");	 
		        vo.setCntrNo(cntrNo);
	        	event.setManualReplanInfoVO(vo);
	        }else{
		        event.setManualReplanInfoVO((ManualReplanInfoVO)getVO(request, ManualReplanInfoVO .class));	        	
	        }

		}
        //request.setAttribute("Event", event);

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