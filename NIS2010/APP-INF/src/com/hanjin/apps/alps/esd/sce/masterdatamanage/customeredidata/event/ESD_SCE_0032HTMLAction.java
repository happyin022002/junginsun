/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0032HTMLAction.java
*@FileTitle : ESD_SCE_0032
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-13
*@LastModifier : 전병석
*@LastVersion : 1.5
* 2006-09-20 yongcheon_shin
* 1.0 최초 생성
* 2009-08-13 전병석
* 1.5 버전 수정
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.CustomerEdiDBDAOOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerDataVO;
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
public class ESD_SCE_0032HTMLAction  extends HTMLActionSupport{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Constructor
     * 
     */
    public ESD_SCE_0032HTMLAction(){
        
    }
    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 IbatchVisibilityEvent로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform (HttpServletRequest request) throws HTMLActionException {
		log.debug("Event 0032 생성");
    	FormCommand command = FormCommand.fromRequest(request);
		EsdSce0032Event event = new EsdSce0032Event();
		if (command.isCommand(FormCommand.SEARCH)) {
			event.setSchCust((SearchCustomerDataVO) getVO(request,SearchCustomerDataVO.class));
		}
		else if (command.isCommand(FormCommand.SEARCH01)) {
			//event.setSchCust((SearchCustomerDataVO) getVO(request,SearchCustomerDataVO.class));
			//조호용 VO 적용
			event.setCusEdiOpt((CustomerEdiDBDAOOptionsVO) getVO(request,CustomerEdiDBDAOOptionsVO.class));
		}
		else if (command.isCommand(FormCommand.SEARCH02)) {
			log.debug("Search2 를 위한 호출");
			event.setCusEdiOpt((CustomerEdiDBDAOOptionsVO) getVO(request,CustomerEdiDBDAOOptionsVO.class));
			//event.setSchEdit((SearchEdiStatusDataVO) getVO(request,SearchEdiStatusDataVO.class));
		}else if (command.isCommand(FormCommand.SEARCH03)) {
			log.debug("Search3 를 위한 호출");
			event.setCusEdiOpt((CustomerEdiDBDAOOptionsVO) getVO(request,CustomerEdiDBDAOOptionsVO.class));
			//event.setSchEdit((SearchEdiStatusDataVO) getVO(request,SearchEdiStatusDataVO.class));
		}
//		else if (command.isCommand(FormCommand.MULTI)) {
//		}

		request.setAttribute("Event", event);
		return  event;
    }
    
    /** request 내의 parameter의 값을 HashMap으로 반환한다.
     * @param request
     * @return hMap
     */
    /*
    public HashMap getParameterArray(HttpServletRequest request){
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
    }
    */
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
