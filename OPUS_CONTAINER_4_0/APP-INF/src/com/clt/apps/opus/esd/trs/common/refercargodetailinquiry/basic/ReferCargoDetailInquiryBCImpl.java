/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ReferCargoDetailInquiryBCImpl.java
*@FileTitle : BKG CGO SPE Detail Popup - RF
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.common.refercargodetailinquiry.basic;

import com.clt.apps.opus.esd.trs.common.refercargodetailinquiry.event.EsdTrs0935Event;
import com.clt.apps.opus.esd.trs.common.refercargodetailinquiry.integration.ReferCargoDetailInquiryDBDAO;
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
 * @see ReferCargoDetailInquiryBC
 * @since J2EE 1.4
 */
public class ReferCargoDetailInquiryBCImpl   extends BasicCommandSupport implements ReferCargoDetailInquiryBC {

	// Database Access Object
	private transient ReferCargoDetailInquiryDBDAO dbDao=null;

	/**
	 * ReferCargoDetailInquiryBCImpl <br>
	 * ReferCargoDetailInquiryDBDAO<br>
	 */
	public ReferCargoDetailInquiryBCImpl(){
		dbDao = new ReferCargoDetailInquiryDBDAO();
	}


	/**
	 * Inquiry event process<br>
	 * ReferCargoDetailInquiry - Inquiry event process<br>
	 * 
	 * @param e EsdTrs0935Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchReferCargoDetailInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0935Event event=(EsdTrs0935Event)e; 
		
		// DB ResultSet for sending data
		DBRowSet rowSet=null;
		try {
			rowSet=dbDao.searchReferCargoDetailInquiry(event);
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
	 * Releasing the related implicit object when ReferCargoDetailInquiry task is end.<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}