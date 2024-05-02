/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0026HTMLAction.java
*@FileTitle : Exception Type Registration 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-12
*@LastModifier : 
*@LastVersion : 1.0
* 2006-09-12 
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.receiveeai.edi322receive.event;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.clt.apps.opus.esd.sce.receiveeai.clmreceiveeai.event.EsdSce0151Event;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 UserManagerSC로 실행요청<br>
 * - UserManagerSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author - 
 * @see EsdSce0151Event 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0000HTMLAction extends HTMLActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -634042331343539622L;
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * Constructor 
	 */
	public ESD_SCE_0000HTMLAction(){
		log.debug("Starting NoUI Program TEST:ID ");
	}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsdSce0150Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException - 
     */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("Event EDISetupEvent just created");
    	log.debug("Request Signal: " + request.getParameter("f_cmd"));
    	
		FormCommand command = FormCommand.fromRequest(request);
		EsdSce0000Event event = new EsdSce0000Event();
		
        if (command.isCommand(FormCommand.SEARCH)) {
			log.debug("COMMAND05 is just called");
			
			//String xmlObject = "";
			//event.setXmlObject(xmlObject);
			//event.setCtopt((CargoTrackingOptionsVO) getVO(request,CargoTrackingOptionsVO.class));
			
			event.setEventName("EsdSce0000Event");
			command.setCommand(FormCommand.SEARCH);
			//event.setFormCommand(command);			
			event.setString(request.getParameter("mq_text"));
		}//if
        
		request.setAttribute("Event", event);
		return  event;
	}
}
