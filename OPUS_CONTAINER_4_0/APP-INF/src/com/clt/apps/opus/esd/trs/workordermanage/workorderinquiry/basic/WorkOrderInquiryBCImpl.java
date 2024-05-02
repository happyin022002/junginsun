/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WorkOrderInquiryBCImpl.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderinquiry.basic;

import com.clt.apps.opus.esd.trs.workordermanage.workorderinquiry.event.EsdTrs0025Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderinquiry.integration.WorkOrderInquiryDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ESD-workordermanage Business Logic Basic Command implementation<br>
 * - ESD-workordermanage handling business logic .<br>
 * 
 * @author
 * @see ESD_TRS_025EventResponse,WorkOrderInquiryBC refer to Each DAO classes
 * @since
 */
public class WorkOrderInquiryBCImpl extends BasicCommandSupport implements WorkOrderInquiryBC {
	private transient WorkOrderInquiryDBDAO dbDao = null;

	/**
	 * WorkOrderInquiryBCImpl object creation <br>
	 * Generate WorkOrderInquiryDBDAO.<br>
	 */
	public WorkOrderInquiryBCImpl() {
		dbDao = new WorkOrderInquiryDBDAO();
	}

	/**
	 * retrieve event process<br>
	 * WorkOrderInquiry retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_025EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderList(Event e) throws EventException {
		EsdTrs0025Event event = (EsdTrs0025Event) e;
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(dbDao.searchWorkOrderList(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * WorkOrderInquiry retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_025EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderInquiryList(Event e) throws EventException {
		EsdTrs0025Event event = (EsdTrs0025Event) e;
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchWorkOrderInquiryList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * WorkOrderInquiry retrieve event process<br>
	 * 
	 * @param e ESD_TRS_025Event
	 * @return EventResponse ESD_TRS_025EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderInquiry(Event e) throws EventException {
		EsdTrs0025Event event = (EsdTrs0025Event) e;
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchWorkOrderInquiry(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * workordermanage biz scenario closing<br>
	 * WorkOrderInquiry clearing related objects<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}