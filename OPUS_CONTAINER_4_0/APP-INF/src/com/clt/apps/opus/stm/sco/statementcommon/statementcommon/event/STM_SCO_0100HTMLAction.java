/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : STM_SCO_0100HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event;

import javax.servlet.http.HttpServletRequest;


import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.ApplicationComboVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupDetailVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupHeaderVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.OfficeInfoVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.OfficeComboListVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;




/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 StatementCommonSC로 실행요청<br>
 * - StatementCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSco0020Event 참조
 * @since J2EE 1.4
 */

public class STM_SCO_0100HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * STM_SCO_0020HTMLAction 객체를 생성
	 */
	public STM_SCO_0100HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 StmSco0100Event로 파싱하여 request에 셋팅<br>
	 * by HJPARK
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request); 
    	StmSco0100Event event = new StmSco0100Event();
		
		if(command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH02)) {
			String mdmOfcCd  = JSPUtil.getParameter(request, "mdm_ofc_cd" , "");
			String ofcEntrLvlCd  = JSPUtil.getParameter(request, "f_ofc_entr_lvl_cd" , "");
			event.setOfcCd(mdmOfcCd);
			event.setOfcEntrLvlCd(ofcEntrLvlCd);
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			OfficeComboListVO[] OfficeComboListVOs = (OfficeComboListVO[]) getVOs(request, OfficeComboListVO.class , "");						
			event.setOfficeComboListVOs(OfficeComboListVOs);
		}else if(command.isCommand(FormCommand.MULTI01)) {	
			OfficeInfoVO[] OfficeInfoVOs = (OfficeInfoVO[]) getVOs(request, OfficeInfoVO.class , "");	
			event.setOfficeInfoVOs(OfficeInfoVOs);	
		} 

		request.setAttribute("Event", event);

		return  event; 
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param EventResponse eventResponse
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param Event event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}