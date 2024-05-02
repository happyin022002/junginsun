/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WorkOrderRemarkBCImpl.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderremark.basic;

import com.clt.apps.opus.esd.trs.workordermanage.workorderremark.event.EsdTrs0078Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderremark.integration.WorkOrderRemarkDBDAO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ESD-WorkOrderManage Business Logic Basic Command implementation<br>
 * 
 * @author
 * @see ESD_TRS_078EventResponse,WorkOrderRemarkBC
 * @since J2EE 1.4
 */
public class WorkOrderRemarkBCImpl extends BasicCommandSupport implements WorkOrderRemarkBC {
	private transient WorkOrderRemarkDBDAO dbDao = null;

	/**
	 * WorkOrderRemarkBCImpl <br>
	 * WorkOrderRemarkDBDAO<br>
	 */
	public WorkOrderRemarkBCImpl() {
		dbDao = new WorkOrderRemarkDBDAO();
	}

	/**
	 * Delete event processing<br>
	 * ESD_TRS_078<br>
	 * 
	 * @param e ESD_TRS_078Event
	 * @return EventResponse ESD_TRS_078EventResponse
	 * @exception EventException
	 */
	public EventResponse removeWorkOrderRemark(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0078Event event = (EsdTrs0078Event) e;
		try {
			dbDao.removeWorkOrderRemark(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Multi-event processing<br>
	 * ESD_TRS_078 - Multi-event processing<br>
	 * 
	 * @param e ESD_TRS_078Event
	 * @return EventResponse ESD_TRS_078EventResponse
	 * @exception EventException
	 */
	public EventResponse multiWorkOrderRemark(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0078Event event = (EsdTrs0078Event) e;
		try {
			dbDao.multiWorkOrderRemark(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage(), de);
		}
	}

	/**
	 * Inquiry event process<br>
	 * WorkOrderRemark - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_078EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderRemarkList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0078Event event = (EsdTrs0078Event) e;
		try {
			eventResponse.setRsVo(dbDao.searchWorkOrderRemarkList(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * End process of WorkOrderManage task scenario<br>
	 * Releasing the related implicit object when WorkOrderRemark task is end.<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}