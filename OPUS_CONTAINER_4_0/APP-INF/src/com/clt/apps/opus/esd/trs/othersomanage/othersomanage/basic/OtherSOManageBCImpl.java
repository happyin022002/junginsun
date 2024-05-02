/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : OtherSOManageBCImpl.java
 *@FileTitle : Other SO create
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esd.trs.othersomanage.othersomanage.basic;

import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.esd.trs.othersomanage.othersomanage.event.EsdTrs0018Event;
import com.clt.apps.opus.esd.trs.othersomanage.othersomanage.integration.OtherSOManageDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ESD-OtherSOManage Business Logic Basic Command implementation<br>
 * - ESD-OtherSOManage handling business logic.<br>
 * 
 * @author
 * @see ESD_TRS_018EventResponse,OtherSOManageBC refer to each DAO classes
 * @since
 */
public class OtherSOManageBCImpl extends BasicCommandSupport implements OtherSOManageBC {

	// Database Access Object
	private transient OtherSOManageDBDAO dbDao = null;

	/**
	 * OtherSOManageBCImpl objects creation<br>
	 * Generate OtherSOManageDBDAO.<br>
	 */
	public OtherSOManageBCImpl() {
		dbDao = new OtherSOManageDBDAO();
	}

	/**
	 * retrieve event process<br>
	 * OtherSOManage retrieve event process<br>
	 * 
	 * @param v
	 * @return response ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTrspSvcOrdList(List<String> v) throws EventException {
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchTrspSvcOrdList(v);
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
	 * OtherSOManage retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOtherSOCorrectionList(Event e) throws EventException {
		DBRowSet rowSet = null;
		EsdTrs0018Event event = (EsdTrs0018Event) e;
		try {
			rowSet = dbDao.searchOtherSOCorrectionList(event);
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
	 * OtherSOManage retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerEqNo(Event e) throws EventException {
		DBRowSet rowSet = null;
		EsdTrs0018Event event = (EsdTrs0018Event) e;
		FormCommand formcommand = e.getFormCommand();
		try {
			rowSet = dbDao.searchContainerEqNo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);

			if (formcommand.isCommand(FormCommand.SEARCH01) || formcommand.isCommand(FormCommand.SEARCH02) || formcommand.isCommand(FormCommand.SEARCH03)) {
				while (rowSet.next()) {
					eventResponse.setETCData(rowSet.getString("eq_no"), rowSet.getString("eq_no"));
				}
			}

			if (formcommand.isCommand(FormCommand.SEARCH10) || formcommand.isCommand(FormCommand.SEARCH11) || formcommand.isCommand(FormCommand.SEARCH12))
				eventResponse.setETCData("ROW", event.getRow());

			return eventResponse;
		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * OtherSOManage retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChassisEqNo(Event e) throws EventException {
		DBRowSet rowSet = null;
		EsdTrs0018Event event = (EsdTrs0018Event) e;
		FormCommand formcommand = e.getFormCommand();
		try {
			rowSet = dbDao.searchChassisEqNo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);

			while (rowSet.next()) {
				if (formcommand.isCommand(FormCommand.SEARCH01) || formcommand.isCommand(FormCommand.SEARCH02) || formcommand.isCommand(FormCommand.SEARCH03))
					eventResponse.setETCData(rowSet.getString("eq_no"), rowSet.getString("eq_no"));
			}

			return eventResponse;
		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * OtherSOManage retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGensetEqNo(Event e) throws EventException {
		DBRowSet rowSet = null;
		EsdTrs0018Event event = (EsdTrs0018Event) e;
		FormCommand formcommand = e.getFormCommand();
		try {
			rowSet = dbDao.searchGensetEqNo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);

			while (rowSet.next()) {
				if (formcommand.isCommand(FormCommand.SEARCH01) || formcommand.isCommand(FormCommand.SEARCH02) || formcommand.isCommand(FormCommand.SEARCH03))
					eventResponse.setETCData(rowSet.getString("EQ_NO"), rowSet.getString("EQ_NO"));
			}

			return eventResponse;
		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * add event process<br>
	 * ESD_TRS_018 event process<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public List<String> addOtherSOManage(Event e) throws EventException {
		EsdTrs0018Event event = (EsdTrs0018Event) e;
		try {
			return dbDao.addTRS_TRSP_SVC_ORD(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Rate Apply process<br>
	 * ESD_TRS_018 event process<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRateApplyList(Event e) throws EventException {
		EsdTrs0018Event event = (EsdTrs0018Event) e;
		try {
			return dbDao.searchRateApplyList(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * modify event process<br>
	 * ESD_TRS_0018 event process<br>
	 * 
	 * @param e EsdTrs0018Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOtherSOManage(Event e) throws EventException {
		EsdTrs0018Event event = (EsdTrs0018Event) e;
		try {
			dbDao.modifyOtherSOManage(event);
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * delete event process<br>
	 * ESD_TRS_018 event process<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOtherSOManage(Event e) throws EventException {
		EsdTrs0018Event event = (EsdTrs0018Event) e;
		try {
			dbDao.removeOtherSOManage(event);
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	

	/**
	 * OtherSOManage biz scenario closing<br>
	 * OtherSOManage clearing related objects<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}