/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CostAccrualSC.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.11.19 authorName
 * 1.0 Creation
 * --------------------------------------------------------
 * History
=========================================================*/
package com.clt.apps.opus.stm.sac.costaccrual.costaccrual;


import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * StatementCommon Business Logic ServiceCommand 
 * - Handling StatementCommon Business transaction.
 * 
 * @author 
 * @see StatementCommonDBDAO
 * @since J2EE 1.6
 */ 

public class CostAccrualSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;  

	/**
	 * Precede StatementCommon system <br>
	 *  Create Object when STM_SCO job call<br>
	 */
	public void doStart() {
		try {
			//Checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());

		}
	}

	/**
	 * Follow StatementCommon system<br>
	 * Release Object when STM_SCO job end<br>
	 */
	public void doEnd() {
		log.debug("StatementCommonSC END");
	}

	/**
	 * proceeding job each Even<br>
	 *  Handling every Event on  StatementCommon system<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		/*
		EventResponse eventResponse = null;
		
		return eventResponse;
		*/
		return null;
	}


}
