/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeSC.java
*@FileTitle : Common code inquiry sample
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : Seungyol Lee
*@LastVersion : 1.0
* 2009.05.25 Seungyol Lee
* 1.0 최초 생성
=========================================================*/
package com.clt.sample.code;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.sample.code.basic.CodeBC;
import com.clt.sample.code.basic.CodeBCImpl;
import com.clt.sample.code.vo.CustomVO;

/**
 * Common code inquiry sample class
 * Inquiry common code list
 *
 * @author Seungyol Lee
 * @see 
 * @since J2EE 1.4
 */
public class CodeSC extends ServiceCommandSupport {

	/**
	 * 
	 * perform
	 * @author Seungyol Lee
	 * @param ev
	 * @return
	 * @throws EventException EventResponse
	 */
	public EventResponse perform(Event ev) throws EventException {
	
		FormCommand fcmd = ev.getFormCommand();
		if(fcmd.equals(FormCommand.SEARCH)){
			//Process business inquiry
			return new GeneralEventResponse();
		}else if(fcmd.equals(FormCommand.MULTI)){
			//Process business save
			return new GeneralEventResponse();
		}else{
			//Process code inquiry
			return searchCodes();	
		}
		
	}
	
	/**
	 * 
	 * searchCodes
	 * @author Seungyol Lee
	 * @return EventResponse
	 */
	private EventResponse searchCodes(){
		CodeBC bc = new CodeBCImpl();
		CustomVO vo = bc.searchCodes();
		GeneralEventResponse response = new GeneralEventResponse();
		response.setCustomData("CustomVO",vo);
		
		return response;
	}
}
