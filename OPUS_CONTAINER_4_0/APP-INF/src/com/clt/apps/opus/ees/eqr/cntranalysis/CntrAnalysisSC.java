/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoPlanManageSC.java
*@FileTitle : Execution Plan
*Open Issues :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntranalysis;

import com.clt.apps.opus.ees.eqr.cntranalysis.cntrreporesult.basic.CntrRepoResultManageBC;
import com.clt.apps.opus.ees.eqr.cntranalysis.cntrreporesult.basic.CntrRepoResultManageBCImpl;
import com.clt.apps.opus.ees.eqr.cntranalysis.cntrreporesult.event.EesEqr1061Event;
import com.clt.apps.opus.ees.eqr.cntranalysis.cntrreporesult.vo.EmptyRepoResultOptionVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-RepoPlanManage Business Logic ServiceCommand - OPUS-RepoPlanManage 
 * @author 
 * @see CntrRepoExecutionPlanEstablishDBDAO
 * @since J2EE 1.6
 */

public class CntrAnalysisSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * RepoPlanManage system <br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * RepoPlanManage system <br>
	 */
	public void doEnd() {
		log.debug("RepoPlanManageSC ");
	}

	/**
	 * OPUS-RepoPlanManage system<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		
	    // Empty Repo Result (EES_EQR_1061) 
        if (e.getEventName().equalsIgnoreCase("EesEqr1061Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchEmptyRepoResult(e);
			}
		}

		return eventResponse;
	}


	/**
     * EES_EQR_1061Event<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse searchEmptyRepoResult(Event e) throws EventException {

		EesEqr1061Event event = (EesEqr1061Event) e; 	// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 		
		EmptyRepoResultOptionVO emptyRepoResultOptionVO = event.getEmptyRepoResultOptionVO();
		try {
			
			
			CntrRepoResultManageBC  command = new CntrRepoResultManageBCImpl();
			CommonRsVO commonRsVO = command.searchEmptyRepoResult(emptyRepoResultOptionVO);
			eventResponse.setRs(commonRsVO.getDbRowset());
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	

}