/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSOCommonSC.java
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.vop.pso.psocommon;

import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.integration.PSOCodeFinderDBDAO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * Handling business transaction about ALPS-PSOCommon Business Logic ServiceCommand - ALPS-PSOCommon 
 * 
 * @author
 * @see PSOCodeFinderDBDAO
 * @since J2EE 1.4
 */

public class PSOCommonSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * PSOCommon system preceding process for biz scenario<br>
	 * PSO_COMrelated objects creation<br>
	 */
	public void doStart() {
		log.debug("PSOCommonSC 시작");
		try {

			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * PSOCommon system biz scenario closing<br>
	 * PSO_COM clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("PSOCommonSC 종료");
	}

	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("PsoComEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAccountList(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchFileExistence(e);
			}			
		}

		return eventResponse;
	}
	

	
	/**
	 * VOP_PSO_0013 : Retrieve<br>
	 * 모든 Account Code 정보를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccountList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		
		return eventResponse;
	}	
	
	/**
	 * 파일존재유무판단  
	 * file_id 번호로 file_path_url 확인후 파일존재확인 함수 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFileExistence(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
				
		return eventResponse;
	}
	
}