/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0009HTMLAction.java
*@FileTitle : COP Mode Change
*Open Issues :
*Change history :
*@LastModifyDate : 2006-07-03
*@LastModifier : Se-Hoon PARK
*@LastVersion : 1.0
* 2006-07-03 Se-Hoon PARK
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPReplanInfoVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 COPManageSC로 실행요청<br>
 * - COPManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * <p/>
 *  @author Se-Hoon PARK
 *  @version v1.0.0
 *  @see EsdSce0009Event , EsdSce0009EventResponse 참조
 *  @since J2EE 1.4
 **/
public class ESD_SCE_0009HTMLAction extends HTMLActionSupport {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2656292923060788955L;

	/**
     * ESD_SCE_0009HTMLAction 객체를 생성
     */
    public ESD_SCE_0009HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsdSce0009Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

    	//FormCommand command = FormCommand.fromRequest(request);
    	EsdSce0009Event event = new EsdSce0009Event();


    	if(!JSPUtil.getNull(request.getParameter("VVD_POP")).equals("Y")){
			String [] ibflag = request.getParameterValues("ibflag");

			event.setCOPReplanInfoVOs((COPReplanInfoVO[])getVOs(request, COPReplanInfoVO .class,""));  
			event.setCOPReplanInfoVO((COPReplanInfoVO)getVO(request, COPReplanInfoVO .class));	

			/*
			if(ibflag != null){
				COPReplanInfoVO[] vos = event.getCOPReplanInfoVOs(); 
				for(int i=0; i<ibflag.length; i++){
				//	log.debug("\n  seq:["+i+"]:"+vos[i].getCopNo()+"   bkgNo:"+vos[i].getBkgNo());
				}
			} else {
			} */
			
			if(ibflag == null) {
				COPReplanInfoVO vo = event.getCOPReplanInfoVO(); 
				log.debug("\n  "+vo.getCopNo());				
			}

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