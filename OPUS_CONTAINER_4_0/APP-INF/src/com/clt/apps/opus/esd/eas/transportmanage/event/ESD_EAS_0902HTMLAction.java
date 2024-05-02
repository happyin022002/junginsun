/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_EAS_0902HTMLAction.java
*@FileTitle : Remark Detail 조회/추가/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2008-05-22
*@LastModifier : JeongHo_Lee
*@LastVersion : 1.0
* 2008-05-22 JeongHo_Lee
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.event;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.eas.common.util.RequestDataSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;

/**
 * ESD_EAS_0903HTMLAction ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class ESD_EAS_0902HTMLAction extends HTMLActionSupport {

	   /**
     * ESD_EAS_0903HTMLAction 객체를 생성
     */
    public ESD_EAS_0902HTMLAction() {
    }

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_EAS_0903Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	RequestDataSet dataSet = RequestDataSet.getInstance(request);

 		Enumeration em = (Enumeration) request.getParameterNames();
		while( em.hasMoreElements() ) {
			String keyName = (String) em.nextElement();

			dataSet.add(keyName, JSPUtil.getParameter(request, keyName, "") );
		}
		    	
    	EsdEas0902Event event   = new EsdEas0902Event(dataSet);
    	
		request.setAttribute("Event", event);
		
		event.getDataSet();

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
