/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DangerCargoDetailInquiryBCImpl.java
*@FileTitle : BKG CGO SPE Detail Popup - DG
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.common.dangercargodetailinquiry.basic;

import com.clt.apps.opus.esd.trs.common.dangercargodetailinquiry.event.EsdTrs0938Event;
import com.clt.apps.opus.esd.trs.common.dangercargodetailinquiry.integration.DangerCargoDetailInquiryDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

 
/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * 
 * @author 
 * @see DangerCargoDetailInquiryBC
 * @since J2EE 1.4
 */
public class DangerCargoDetailInquiryBCImpl   extends BasicCommandSupport implements DangerCargoDetailInquiryBC {

	// Database Access Object
	private transient DangerCargoDetailInquiryDBDAO dbDao=null;

	/**
	 * DangerCargoDetailInquiryBCImpl <br>
	 * DangerCargoDetailInquiryDBDAO<br>
	 */
	public DangerCargoDetailInquiryBCImpl(){
		dbDao = new DangerCargoDetailInquiryDBDAO();
	}


	/**
	 * Inquiry event process<br>
	 * DangerCargoDetailInquiry - Inquiry event process<br>
	 * 
	 * @param e EsdTrs0938Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchDangerCargoDetailInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0938Event event=(EsdTrs0938Event)e;
		
		// DB ResultSet for sending data
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchDangerCargoDetailInquiry(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * End process of TRS task scenario<br>
	 * Releasing the related implicit object when DangerCargoDetailInquiry task is end.<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}