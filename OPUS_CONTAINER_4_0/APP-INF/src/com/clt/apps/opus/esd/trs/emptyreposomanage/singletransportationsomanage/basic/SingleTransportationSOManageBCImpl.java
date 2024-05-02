/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : SingleTransportationSOManageBCImpl.java
 *@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.basic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.event.EsdTrs0012Event;
import com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.integration.SingleTransportationSOManageDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS handling business logic.<br>
 * 
 * @author
 * @see ESD_TRS_012EventResponse,SingleTransportationSOManageBC refer to each DAO classes
 * @since
 */
public class SingleTransportationSOManageBCImpl extends BasicCommandSupport implements SingleTransportationSOManageBC {

	// Database Access Object
	private transient SingleTransportationSOManageDBDAO dbDao = null;

	/**
	 * SingleTransportationSOManageBCImpl objects creation<br>
	 * Generate SingleTransportationSOManageDBDAO.<br>
	 */
	public SingleTransportationSOManageBCImpl() {
		dbDao = new SingleTransportationSOManageDBDAO();
	}

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param e EsdTrs0012Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search04SingleTransportationSOManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.search04SingleTransportationSOManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param soffice_cd
	 * @param e EsdTrs0012Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search05SingleTransportationSOManage(String soffice_cd, Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0012Event event = (EsdTrs0012Event) e;

		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.search05SingleTransportationSOManage(soffice_cd, event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param e EsdTrs0012Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search03SingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0012Event event = (EsdTrs0012Event) e;

		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.search03SingleTransportationSOManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param e ESD_TRS_012Event
	 * @return EventResponse ESD_TRS_012EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event = (EsdTrs0012Event) e;

		DBRowSet rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			rowSet = dbDao.searchSingleTransportationSOManage(event);

			eventResponse.setRsVo(rowSet);

			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param e ESD_TRS_012Event
	 * @return EventResponse ESD_TRS_012EventResponse
	 * @exception EventException
	 */
	public EventResponse search01SingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event = (EsdTrs0012Event) e;

		DBRowSet rowSet = null;

		try {
			rowSet = dbDao.search01SingleTransportationSOManage(event);
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
	 * SingleTransportationSOManage retrieve event process<br>
	 * 
	 * @param e ESD_TRS_012Event
	 * @return EventResponse ESD_TRS_012EventResponse
	 * @exception EventException
	 */
	public EventResponse search02SingleTransportationSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		DBRowSet rowSet = null;

		try {
			rowSet = dbDao.search02SingleTransportationSOManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * modify event process<br>
	 * ESD_TRS_0012 event process<br>
	 * 
	 * @param soffice_cd
	 * @param e EsdTrs0012Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse modifySingleTransportationSOManage(String soffice_cd, Event e) throws EventException {
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		try {
			dbDao.emptyModifySingleTrs(soffice_cd, event);
			return new GeneralEventResponse();
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * modify event process<br>
	 * ESD_TRS_012 event process<br>
	 * 
	 * @param e EsdTrs0012Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse modify01SingleTransportationSOManage(Event e) throws EventException {
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.emptyModify01SingleTrs(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * modify event process<br>
	 * ESD_TRS_0012 event process<br>
	 * 
	 * @param soffice_cd
	 * @param e EsdTrs0012Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse modify02SingleTransportationSOManage(String soffice_cd, Event e) throws EventException {
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		try {
			dbDao.emptyModify02SingleTrs(soffice_cd, event);
			return new GeneralEventResponse();
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * delete event process<br>
	 * ESD_TRS_012 event process<br>
	 * 
	 * @param soffice_cd
	 * @param e EsdTrs0012Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse removeSingleTransportationSOManage(String soffice_cd, Event e) throws EventException {
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.emptyRemoveSingleTrs(soffice_cd, event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * multi event process<br>
	 * ESD_TRS_012 multi event process<br>
	 * 
	 * @param e ESD_TRS_012Event
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchMultiSingleTransportationSo(Event e) throws EventException {
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		try {
			return dbDao.searchMultiSingleTransportationSo(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * multi event process<br>
	 * ESD_TRS_012 multi event process<br>
	 * 
	 * @param e ESD_TRS_012Event
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap<String, String> searchEmptyRepoCombineSeq(Event e) throws EventException {
		EsdTrs0012Event event = (EsdTrs0012Event) e;
		try {
			return dbDao.searchEmptyRepoCombineSeq(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * multi event process<br>
	 * ESD_TRS_012 multi event process<br>
	 * 
	 * @param chk_param Map<String, Object>
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchVerifyECC(Map<String, Object> chk_param) throws EventException {
		try {
			return dbDao.searchVerifyECC(chk_param);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage get the EmptyRepoSeq <br>
	 * ESD_TRS_012 multi event process<br>
	 * 
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchEmptyRepoSeq() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		try {
			return dbDao.searchEmptyRepoSeq();
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * multi event process<br>
	 * ESD_TRS_012 multi event process<br>
	 * 
	 * @param insModels Collection<SingleTransportationVO>
	 * @param param Map<String, Object>
	 * @return
	 * @exception EventException
	 */
	public EventResponse multiSingleTransportationSOManage5(Collection<SingleTransportationVO> insModels, Map<String, Object> param) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRsVoList(dbDao.multiSingleTransportationSOManage5(insModels, param));
			return eventResponse;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * TRS biz scenario closing<br>
	 * SingleTransportationSOManage clearing related objects<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}