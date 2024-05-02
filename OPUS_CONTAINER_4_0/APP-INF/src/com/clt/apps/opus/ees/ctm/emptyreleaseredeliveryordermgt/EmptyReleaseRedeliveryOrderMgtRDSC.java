/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtSC.java
*@FileTitle : Territories Management
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt;

import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOrderMgtBC;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOrderMgtBCImpl;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.event.EesCtm0451RdEvent;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration.EmptyReleaseRedeliveryOrderMgtDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.layer.service.ServiceCommandSupport;


/**
 * OPUS-EmptyReleaseRedeliveryOrderMgt Business Logic ServiceCommand
 * handling business transaction for OPUS-EmptyReleaseRedeliveryOrderMgt
 *
 * Exception for login because of calling URL from RD Server with no account
 *
 * @author
 * @see EmptyReleaseRedeliveryOrderMgtDBDAO
 * @since J2EE 1.6
 */
public class EmptyReleaseRedeliveryOrderMgtRDSC extends ServiceCommandSupport {

	/**
	 * preceding business scenario job for EmptyReleaseRedeliveryOrderMgt RDMail
	 * creating Object when calling business scenario
	 */
	public void doStart() {
		log.debug("EmptyReleaseRedeliveryOrderMgtRDSC 시작");
	}

	/**
	 * closing EmptyReleaseRedeliveryOrderMgt RDMail business scenario
	 */
	public void doEnd() {
		log.debug("EmptyReleaseRedeliveryOrderMgtRDSC 종료");
	}

	/**
	 * processing business scenario
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = searchRDContentForRDSrv(e);
		return eventResponse;
	}

	/**
	 * EES_CTM_0451 : calling RD server(without Account)
	 * retrieving RD contents
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDContentForRDSrv(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0451RdEvent event = (EesCtm0451RdEvent)e;
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		try{
			String stringForRD = command.searchCimFaxSndInfo(event.getStkFaxSndNo());
			eventResponse.setCustomData("RD", stringForRD);
		}catch(EventException ex){
			log.error("\n\n[RDSC - searchRDContentForRDSrv] EventException :  " + ex.getMessage(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("\n\n[RDSC - searchRDContentForRDSrv] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

}