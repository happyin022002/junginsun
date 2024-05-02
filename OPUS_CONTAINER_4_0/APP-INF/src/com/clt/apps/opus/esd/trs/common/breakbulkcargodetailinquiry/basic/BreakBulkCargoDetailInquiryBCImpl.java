/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BreakBulkCargoDetailInquiryBCImpl.java
*@FileTitle : BKG CGO SPE Detail Popup - BB
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.common.breakbulkcargodetailinquiry.basic;

import com.clt.apps.opus.esd.trs.common.breakbulkcargodetailinquiry.event.EsdTrs0937Event;
import com.clt.apps.opus.esd.trs.common.breakbulkcargodetailinquiry.integration.BreakBulkCargoDetailInquiryDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

 
/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS business logic handling.<br>
 * 
 * @author juhyun
 * @see ,BreakBulkCargoDetailInquiryBC each DAO class reference
 * @since J2EE 1.4
 */
public class BreakBulkCargoDetailInquiryBCImpl   extends BasicCommandSupport implements BreakBulkCargoDetailInquiryBC {

	// Database Access Object
	private transient BreakBulkCargoDetailInquiryDBDAO dbDao=null;

	/**
	 * BreakBulkCargoDetailInquiryBCImpl object creation<br>
	 * BreakBulkCargoDetailInquiryDBDAO creation<br>
	 */
	public BreakBulkCargoDetailInquiryBCImpl(){
		dbDao = new BreakBulkCargoDetailInquiryDBDAO();
	}


	/**
	 * retrieve event handling<br>
	 * BreakBulkCargoDetailInquiry screen views for event handling<br>
	 * 
	 * @param e
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchBreakBulkCargoDetailInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0937Event event=(EsdTrs0937Event)e;		
		// The result of user requests (DB Result Set, object, value, etc.) containing the object
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchBreakBulkCargoDetailInquiry(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * TRS business scenarios and finishing<br>
	 * At the end of business-related internal objects BreakBulkCargoDetailInquiry release scenarios<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}