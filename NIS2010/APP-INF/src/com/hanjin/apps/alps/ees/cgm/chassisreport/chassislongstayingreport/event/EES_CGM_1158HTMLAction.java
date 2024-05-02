/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName 		: EES_CGM_1158HTMLAction.java
*@FileTitle 	: Chassis Long Staying Report
*Open Issues 	: 
 *Change history :
 *@LastModifyDate : 2015.04.07
 *@LastModifier : 이율규
 *@LastVersion : 1.0
 * 2015.04.07 이율규
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.vo.ChassisLongStayingVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * @author 이율규  
 */
@SuppressWarnings("serial")
public class EES_CGM_1158HTMLAction extends HTMLActionSupport {

	/**
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);

		EesCgm1158Event event = new EesCgm1158Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setChassisLongStayingVO((ChassisLongStayingVO)getVO(request, ChassisLongStayingVO.class));
			event.setChassisLongStayingVOS((ChassisLongStayingVO[])getVOs(request, ChassisLongStayingVO.class));
		}
		
		
		return event;
	}

}