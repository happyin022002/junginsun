/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0072HTMLAction.java
*@FileTitle : EsdSce0072
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-09
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2006-05-10 sanghyun-kim
* 1.0 최초 생성
* 2009-09-09
* 1.4 버전 커밋
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEDIPerformanceOptionsVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 UserManagerSC로 실행요청<br>
 * - UserManagerSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author sang_hyun_kim
 * @see ReserveSendManagerEvent , PNSendManagerEventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0072HTMLAction extends HTMLActionSupport{

	private static final long serialVersionUID = 1L;

	public ESD_SCE_0072HTMLAction(){}
	
	/**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 IbatchVisibilityEvent로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("Event 0072 생성");
    	FormCommand command = FormCommand.fromRequest(request);
		EsdSce0072Event event = new EsdSce0072Event();
		if (command.isCommand(FormCommand.SEARCH01)) {
			//event.setSchCust((SearchCustomerDataVO) getVO(request,SearchCustomerDataVO.class));
			//searchEDIPerformance
			event.setSchEpOpts((SearchEDIPerformanceOptionsVO) getVO(request,SearchEDIPerformanceOptionsVO.class));
		}
		else if (command.isCommand(FormCommand.SEARCH02)) {
			log.debug("#####EsdSce0072 - Event Called for SEARCH02");
			event.setSchEpOpts((SearchEDIPerformanceOptionsVO) getVO(request,SearchEDIPerformanceOptionsVO.class));
		}
		else if (command.isCommand(FormCommand.SEARCH03)) {
			log.debug("#####EsdSce0072 - Event Called for seach03");
			event.setSchEpOpts((SearchEDIPerformanceOptionsVO) getVO(request,SearchEDIPerformanceOptionsVO.class));
		}else if (command.isCommand(FormCommand.SEARCH04)) {
			log.debug("Search4 를 위한 호출");
			event.setSchEpOpts((SearchEDIPerformanceOptionsVO) getVO(request,SearchEDIPerformanceOptionsVO.class));
		}else if (command.isCommand(FormCommand.SEARCHLIST01)) {
			//eventResponse = searchPerCsInfo(e);
			log.debug("#####EsdSce0072 - Event Called for SEARCHLIST01");
			event.setSchEpOpts((SearchEDIPerformanceOptionsVO) getVO(request,SearchEDIPerformanceOptionsVO.class));
		}else if (command.isCommand(FormCommand.SEARCHLIST02)){
			log.debug("#####EsdSce0072 - Event Called for SEARCHLIST01");
			event.setSchEpOpts((SearchEDIPerformanceOptionsVO) getVO(request,SearchEDIPerformanceOptionsVO.class));
			log.debug("#####EsdSce0072 - Event Called for SEARCHLIST01");
	    }else if (command.isCommand(FormCommand.SEARCH05)){//콤보박스를 위한 호출
	    	event.setSchEpOpts((SearchEDIPerformanceOptionsVO) getVO(request,SearchEDIPerformanceOptionsVO.class));
	    }

		request.setAttribute("Event", event);
		return  event;
    }
	/** request 내의 parameter의 값을 HashMap으로 반환한다.
     * @param request
     * @return hMap
     */
	@SuppressWarnings("rawtypes")
	public HashMap<String, String> getParameterArray(HttpServletRequest request){
		String keyName = "";
        String keyValue = "";
        HashMap<String, String> hMap = new HashMap<String, String>();
        
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