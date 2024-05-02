/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_SCE_0146HTMLAction.java
*@FileTitle : Microsoft Exception Management
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.01
*@LastModifier : 조풍연, 김민정
*@LastVersion : 1.0
* 2015.10.20 조풍연, 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchMSExptVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchMSExptSaveVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce.dwellnotification 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DwellNotificationSC로 실행요청<br>
 * - CopManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author eunju son
 * @see EsdSce0146Event 참조
 * @since J2EE 1.6
 */
public class ESD_SCE_0146HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESD_SCE_0146HTMLAction 객체를 생성
	 */
	public ESD_SCE_0146HTMLAction() {}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VisibilityManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsdSce0146Event event = new EsdSce0146Event();
		
		if(command.isCommand(FormCommand.SEARCH)){
			event.setSearchMSExptVO((SearchMSExptVO)getVO(request, SearchMSExptVO.class, ""));
		
		}else if(command.isCommand(FormCommand.MULTI01)){

        	log.debug("Event 0146 - MULTI01");
        	event.setSearchMSExptVO((SearchMSExptVO)getVO(request, SearchMSExptVO.class, ""));
        	event.setSearchMSExptSaveVOs((SearchMSExptSaveVO[])getVOs(request,SearchMSExptSaveVO.class,""));  
            int length = request.getParameterValues("ibflag").length;
        	log.debug(length  + " cell[s] are selected");
        			
        
	    }else if(command.isCommand(FormCommand.MULTI02)){
        	log.debug("Event 0146 - MULTI02");
        	event.setSearchMSExptVO((SearchMSExptVO)getVO(request, SearchMSExptVO.class, ""));  
        	event.setSearchMSExptSaveVOs((SearchMSExptSaveVO[])getVOs(request,SearchMSExptSaveVO.class,"")); 
        	List<Edi315SendVO> sendvos =  null;
        	int length = request.getParameterValues("ibflag").length;
        	log.debug(length  + " cell[s] are selected");
        	
        	if(length > 0){
        		
        		sendvos = new ArrayList<Edi315SendVO>();         
        		
//        		String[] params1  = (JSPUtil.getParameter(request, "pol_cd".trim(),length));         
//        		String[] params2  = (JSPUtil.getParameter(request, "pod_cd".trim(),length));         
        		String[] params3  = (JSPUtil.getParameter(request, "del_cd".trim(),length));         
//        		String[] params4  = (JSPUtil.getParameter(request, "edi_sts_cd".trim(),length));   
//        		String[] params5  = (JSPUtil.getParameter(request, "edi_sub_sts_cd".trim(),length));              
//        		String[] params6 = (JSPUtil.getParameter(request, "ibflag".trim(),length));     	       
//        		String[] params7 = (JSPUtil.getParameter(request, "vvd".trim(),length));             
        		String[] params8 = (JSPUtil.getParameter(request, "bkg_no".trim(),length));                   
        		String[] params9 = (JSPUtil.getParameter(request, "cntr_no".trim(),length));
        		String[] params10 = (JSPUtil.getParameter(request, "act_dt1".trim(),length));
        		String[] params11 = (JSPUtil.getParameter(request, "act_dt2".trim(),length));
        		
        		for(int i=0;i<length;i++){
        			Edi315SendVO sendvo = new Edi315SendVO();

        			/*기 정의된값 세팅*/
                    sendvo.setCreId("");
        			sendvo.setUpdId("");
        			sendvo.setCallFrom("MAN");
        			sendvo.setManFlg("Y");
                    sendvo.setEdiStatus ("SD");
                    sendvo.setCustStatus("SD");        			
        			
        			/*화면에서 받아온 값을 VO 에 정의함*/

                    sendvo.setEventDt   (params10[i] + params11[i]);
        			sendvo.setBkgNo     (params8[i]);
        			sendvo.setEventYard (params3[i]);
        			sendvo.setCntrNo    (params9[i]);
        			
        			sendvos.add(sendvo);
        		}//for       		
        			event.setEdi315SendVOs(sendvos);
        	}//if

        }else{
			event.setSearchMSExptVO((SearchMSExptVO)getVO(request, SearchMSExptVO.class, ""));
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
