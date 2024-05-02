/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SOInquirySC.java
 *@FileTitle : CPending List Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.soinquiry;

import com.clt.apps.opus.esd.trs.soinquiry.soinquiry.basic.SOInquiryBC;
import com.clt.apps.opus.esd.trs.soinquiry.soinquiry.basic.SOInquiryBCImpl;
import com.clt.apps.opus.esd.trs.soinquiry.soinquiry.event.EsdTrs0019Event;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * business transaction handling about cargoreleaseordermgt Business Logic ServiceCommand - cargoreleaseordermgt.<br>
 * 
 * @author juhyun
 * @see ESD_TRS_001EventResponse,PendingListDBDAO
 * @since J2EE 1.4
 */
public class SOInquirySC extends ServiceCommandSupport {
	private SignOnUserAccount account = null;
	private String sofficeCd = "";

	/**
	 * Pre-Operation of CargoReleaseOrderMgt business scenario<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
			sofficeCd = account.getOfc_cd();
		} catch (Exception e) {
			log.error("ESD_TRS_0001SC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * End-Operation of CargoReleaseOrderMgt business scenario<br>
	 */
	public void doEnd() {
		log.debug("ESD_TRS_0001SC 종료");
	}

	/**
	 * Action of business scenario that each event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsdTrs0019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSOInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = search_office(e);
			}
		}
		return eventResponse;

	}

	/**
	 * retrieve event handling<br>
	 * Display List of SOInquiry event processing for a particular event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSOInquiry(Event e) throws EventException {
		EsdTrs0019Event event = (EsdTrs0019Event) e;
		EventResponse eventResponse = null;
		try {
			SOInquiryBC command = new SOInquiryBCImpl();
			eventResponse = command.searchSOInquiry(event, sofficeCd);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * search office체크 이벤트 처리<br>
	 * PendingList screen views for event handling<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search_office(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			SOInquiryBC command = new SOInquiryBCImpl();
			eventResponse = command.search_office(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}
