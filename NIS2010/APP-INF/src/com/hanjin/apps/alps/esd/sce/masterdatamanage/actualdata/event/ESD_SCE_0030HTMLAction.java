/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0030HTMLAction.java
*@FileTitle : Actual Source Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : SeongMun_Kang
*@LastVersion : 1.0
* 2006-10-30 SeongMun_Kang
* 1.0 최초 생성
* --------------------------------------------------------
* History
* 2013.05.14 김상수 [CHM-201324115] Actual Data Receiving Status 보완요청
*                    - CNTR no 입력후 retrieve 시 다른 조회 조건은 필요하지 않도록 로직 수정
*                    - CNTR No.가 없는 건 (HJCU0000000) 대상에서 제외
*                    - EDI MSG ID, EDI 컬럼을 Service Provider 앞 위치로 이동시키고 그 위치에 VVD 컬럼 추가
*                    - On Time 정렬기능 추가
*                    - Activity 컬럼 앞에 Activity Code 컬럼 추가
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.vo.SearchActualDataInfoVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 COPManageSC로 실행요청<br>
 * - COPManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author SeongMun_Kang
 * @see EsdSce0030Event , EsdSce0030EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0030HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;	
    /**
     * ESD_SCE_0030HTMLAction 객체를 생성
     */
    public ESD_SCE_0030HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsdSce0030Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	EsdSce0030Event event = new EsdSce0030Event();
    	//HashMap map = null;
        FormCommand f_cmd = FormCommand.fromRequest(request);
        if (f_cmd.isCommand(FormCommand.SEARCHLIST)) {
        	event.setActualInfo((SearchActualDataInfoVO) getVO(request, SearchActualDataInfoVO.class));
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