
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_TOT_0021HTMLAction.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.08.03 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.JbSkdVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.fns.tot.tonnagetaxoutput 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TonnageTaxOutputSC로 실행요청<br>
 * - TonnageTaxOutputSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jang Chang Soo
 * @see TonnageTaxOutputEvent 참조
 * @since J2EE 1.4
 */

public class FNS_TOT_0021HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_TOT_0021HTMLAction 객체를 생성
	 */
	public FNS_TOT_0021HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TonnageTaxOutputEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsTot0021Event event = new FnsTot0021Event();
        log.debug("::CALL::> FNS_TOT_0021HTMLAction - " + command.getCommand());
        //log.debug("FormCommand.SEARCH - " + FormCommand.SEARCH);
        String param_start_dt =null;
        String param_end_dt =null;
        String runJob  =null;
        String stDate  =null;
        String batId  =null;
        
        if(command.isCommand(FormCommand.SEARCH)) {
        	
        	event.setJbSkdVO((JbSkdVO)getVO(request, JbSkdVO.class));
        }else if(command.isCommand(FormCommand.MULTI)) {
      	
        	param_start_dt = request.getParameter("param_start_dt");
        	param_end_dt = request.getParameter("param_end_dt");
			runJob = request.getParameter("run_job");
			stDate = request.getParameter("st_date");
			batId = request.getParameter("bat_id");
			param_start_dt = param_start_dt.substring(0, 4)+ param_start_dt.substring(5, 7);
			param_end_dt = param_end_dt.substring(0, 4)+ param_end_dt.substring(5, 7);
            
			stDate = stDate.substring(0, 4)+ stDate.substring(5, 7)+ stDate.substring(8, 10) + request.getParameter("st_date_hh")+request.getParameter("st_date_mm");

			log.debug("param_start_dt : " + param_start_dt);
			log.debug("param_end_dt : " + param_end_dt);
			log.debug("runJob : " + runJob);
			log.debug("stDate : " + stDate);
			log.debug("batId : " + batId);
			event.setParamStartDate(param_start_dt);
			event.setParamEndDate(param_end_dt);
			event.setRunJob(runJob);
			event.setStDate(stDate);
			event.setBatId(batId);
			event.setJbSkdVO((JbSkdVO)getVO(request, JbSkdVO.class));
		}else if(command.isCommand(FormCommand.REMOVE01)) {
			
			event.setJbSkdVOs((JbSkdVO[])getVOs(request, JbSkdVO.class,"sheet1_"));

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