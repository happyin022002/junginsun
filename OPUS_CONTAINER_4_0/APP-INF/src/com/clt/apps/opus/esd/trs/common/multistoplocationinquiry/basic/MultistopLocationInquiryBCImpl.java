/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MultistopLocationInquiryBCImpl.java
*@FileTitle : Multi-stop Location Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-10
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.common.multistoplocationinquiry.basic;

import com.clt.apps.opus.esd.trs.common.multistoplocationinquiry.event.EsdTrs0933Event;
import com.clt.apps.opus.esd.trs.common.multistoplocationinquiry.integration.MultistopLocationInquiryDBDAO;
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
 * @see ESD_TRS_933EventResponse,MultistopLocationInquiryBC
 * @since J2EE 1.4
 */
public class MultistopLocationInquiryBCImpl   extends BasicCommandSupport implements MultistopLocationInquiryBC {

	// Database Access Object
	private transient MultistopLocationInquiryDBDAO dbDao=null;

	/**
	 * MultistopLocationInquiryBCImpl <br>
	 * MultistopLocationInquiryDBDAO<br>
	 */
	public MultistopLocationInquiryBCImpl(){
		dbDao = new MultistopLocationInquiryDBDAO();
	}

	/**
	 * Inquiry event process<br>
	 * MultistopLocationInquiry - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_933EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMultistopLocationInquiryList(Event e) throws EventException {
		EsdTrs0933Event event=(EsdTrs0933Event)e;
		DBRowSet rowSet=null; // DB ResultSet for sending data
		try {
			rowSet=dbDao.searchMultistopLocationInquiryList(event);
//			return new EsdTrs0933EventResponse(rowSet,"SUCCESS");
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
	 * Releasing the related implicit object when MultistopLocationInquiry task is end.<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}