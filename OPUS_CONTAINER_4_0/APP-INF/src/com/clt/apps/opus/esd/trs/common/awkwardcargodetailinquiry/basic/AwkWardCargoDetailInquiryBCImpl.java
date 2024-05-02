/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AwkWardCargoDetailInquiryBCImpl.java
*@FileTitle : BKG CGO SPE Detail Popup - AK
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : 
*@LastVersion : 1.0


=========================================================*/
package com.clt.apps.opus.esd.trs.common.awkwardcargodetailinquiry.basic;

import com.clt.apps.opus.esd.trs.common.awkwardcargodetailinquiry.event.EsdTrs0936Event;
import com.clt.apps.opus.esd.trs.common.awkwardcargodetailinquiry.integration.AwkWardCargoDetailInquiryDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

 
/**
 * ESD-AwkWardCargoDetailInquiry Business Logic Basic Command implementation<br>
 * - ESD-AwkWardCargoDetailInquiry handling business logic.<br>
 * 
 * @author 
 * @see AwkWardCargoDetailInquiryBC refer to each DAO classes
 * @since J2EE 1.4
 */
public class AwkWardCargoDetailInquiryBCImpl   extends BasicCommandSupport implements AwkWardCargoDetailInquiryBC {

	// Database Access Object
	private transient AwkWardCargoDetailInquiryDBDAO dbDao=null;

	/**
	 * AwkWardCargoDetailInquiryBCImpl objects creation<br>
	 * Generate AwkWardCargoDetailInquiryDBDAO.<br>
	 */
	public AwkWardCargoDetailInquiryBCImpl(){
		dbDao = new AwkWardCargoDetailInquiryDBDAO();
	}

	/**
	 * event process event process<br>
	 * AwkWardCargoDetailInquiry event process<br>
	 * 
	 * @param e EsdTrs0936Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchAwkWardCargoDetailInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0936Event event=(EsdTrs0936Event)e;
		
		// For transferring data to DB ResultSet object
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchAwkWardCargoDetailInquiry(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * TRS biz scenario closing<br>
	 * AwkWardCargoDetailInquiry clearing related objects<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}