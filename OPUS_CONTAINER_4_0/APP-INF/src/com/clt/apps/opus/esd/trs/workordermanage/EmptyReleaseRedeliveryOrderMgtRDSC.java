/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EmptyReleaseRedeliveryOrderMgtRDSC.java
 *@FileTitle : RELRED RD Logic SC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage;

import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOrderMgtBC;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOrderMgtBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.event.EsdTrs0451RdEvent;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.layer.service.ServiceCommandSupport;

/**
 * ESD-RELRED RD Logic ServiceCommand<br>
 * 
 * @author
 * @see ESD_TRS_0451EventResponse
 * @since J2EE 1.4
 */
public class EmptyReleaseRedeliveryOrderMgtRDSC extends ServiceCommandSupport {
	/**
	 * preceding business scenario job for EmptyReleaseRedeliveryOrderMgt RDMail creating Object when calling business scenario
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
		return searchRDContentForRDSrv(e);
	}

	/**
	 * ESD_TRS_0451 : calling RD server(without Account) retrieving RD contents
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDContentForRDSrv(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0451RdEvent event = (EsdTrs0451RdEvent) e;
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		try {
			eventResponse.setCustomData("RD", command.searchCimFaxSndInfo(event.getStkFaxSndNo()));
		} catch (EventException ex) {
			log.error("\n\n[RDSC - searchRDContentForRDSrv] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("\n\n[RDSC - searchRDContentForRDSrv] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
}
