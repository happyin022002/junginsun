/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0915HTMLAction.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-08-29 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;


/**
 *  1. 기능 : HTTP Parser <p>
 *  2. 처리개요 : <p>
 *    - com.clt.apps.opus.esd.sce 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing <p>
 *    - Parsing 한 정보를 Event로 변환, request에 담아 COPManageSC로 실행요청 <p>
 *    - COPManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅 <p>
 * 3. 주의사항 : <p>
 * ===================================<br>
 * 4. 작성자/작성일 : Se-Hoon PARK/2006.07.03<br>
 * ===================================<br>
 * 5. 수정사항<p>
 * 5.1 요구사항 ID :<p>
 * - 수정자/수정일 :<p>
 * - 수정사유/내역 :<p>
 * ===================================<br>
 * <p/>
 *  @author Se-Hoon PARK
 *  @version v1.0.0
 *  @see EsdSce0915Event , EsdSce0915EventResponse 참조
 *  @since J2EE 1.4
 **/
public class ESD_SCE_0915HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

    /**
     * 1. 기능 : 객체 생성작업 <p>
     * 2. 처리개요 :  <p>
     *    - ESD_SCE_0915HTMLAction 객체를 생성 <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : Se-Hoon PARK/2006.07.03<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     **/
    public ESD_SCE_0915HTMLAction() {}

    /**
     * 1. 기능 : HTML DOM 객체의 Value를 자바 변수로 Parsing <p>
     * 2. 처리개요 :  <p>
     *    - HttpRequst의 정보를 EsdSce0915Event로 파싱하여 request에 셋팅 <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : Se-Hoon PARK/2006.07.03<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     *
     * @param request HttpServletRequest HttpRequest
     * @return Event - Event interface를 구현한 객체
     * @exception HTMLActionException
     **/
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	EsdSce0915Event event = new EsdSce0915Event();
		event.setCopInquiryVO((COPInquiryVO)getVO(request, COPInquiryVO .class));

        return  event;
    }

   /**
     * 1. 기능 : HttpRequest의 attribute에 업무시나리오 수행결과 값 저장 <p>
     * 2. 처리개요 :  <p>
     *    - ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅 <p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : Se-Hoon PARK/2006.07.03<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     *
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
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : Se-Hoon PARK/2006.07.03<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     *
     * @param request HttpServletRequest HttpRequest
     * @param event Event Event - interface를 구현한 객체
     **/
    public void doEnd(HttpServletRequest request, Event event) {
        request.setAttribute("Event", event);
    }

}