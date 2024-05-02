/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315Send_HTMLAction.java
*@FileTitle :Edi315Send_HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-08
*@LastModifier : 전병석
*@LastVersion : 1.2
* 2009-10-01 전병석 
* 1.0 Creation
* 2009-10-08 전병석
* 1.2 버전 커밋
=========================================================*/
package com.clt.apps.opus.esd.sce.edi324send;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.clt.apps.opus.esd.sce.edi315send.basic.Edi315SendBCImpl;
import com.clt.apps.opus.esd.sce.edi315send.event.Edi315SendEvent;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315PrefixMainVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315SendOptionsVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315SendVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;




/**
 * ENIS-SCE Business Logic ServiceCommand<br>
 * - ENIS-SCE에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author YJLEE
 * @see Edi315SendBCImpl 참조
 * @since J2EE 1.4
 */
public class Edi324Send_HTMLAction extends HTMLActionSupport{
	private static final long serialVersionUID = 1175601635347647907L;
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	public Edi324Send_HTMLAction(){
		log.debug("Starting NoUI Program TEST:ID - Edi315Send" );
	}
	/**
	 * 패키지 대한 테스트 화면을 위한 서비스 분기 함수
	 * @param  request HttpServletRequest 
	 * @return Event
	 * @throws 
	 */	
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("Edi315SendEvent just created");
    	log.debug("Request Signal: " + request.getParameter("f_cmd"));
		FormCommand command = FormCommand.fromRequest(request);
		Edi315SendEvent event = new Edi315SendEvent("Edi315SendEvent");
		
        if (command.isCommand(FormCommand.COMMAND01)) {
			log.debug("COMMAND01 is just called");
			event.setEdi315SMain((Edi315PrefixMainVO) getVO(request,Edi315PrefixMainVO.class));
			event.setEdi315SOpts((Edi315SendOptionsVO) getVO(request,Edi315SendOptionsVO.class));
			log.debug("Edi315SendOptionsVO is spawn.");
        }else if (command.isCommand(FormCommand.COMMAND02)) {
			log.debug("COMMAND02 is just called");
			event.setEdi315Send((Edi315SendVO) getVO(request,Edi315SendVO.class));
			log.debug("Edi315SendVO is spawn.");
        }//if        
		request.setAttribute("Event", event);
		return  event;
	}
	
	/** request 내의 parameter의 값을 HashMap으로 반환한다.
     * @param request
     * @return hMap
     */
	@SuppressWarnings({ "rawtypes", "unchecked" })
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