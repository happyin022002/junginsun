/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ChassisGensetSOManageBCImpl.java
 *@FileTitle : Service Order - Chassis or Genset
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.basic;

import java.sql.SQLException;
import java.util.ArrayList;

import com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.event.EsdTrs0014Event;
import com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration.ChassisGensetSOManageDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * 
 * @author
 * @see ESD_TRS_014EventResponse,ChassisGensetSOManageBC
 * @since J2EE 1.4
 */
public class ChassisGensetSOManageBCImpl extends BasicCommandSupport implements ChassisGensetSOManageBC {
	private transient ChassisGensetSOManageDBDAO dbDao = null;

	/**
	 * ChassisGensetSOManageBCImpl <br>
	 * ChassisGensetSOManageDBDAO<br>
	 */
	public ChassisGensetSOManageBCImpl() {
		dbDao = new ChassisGensetSOManageDBDAO();
	}

	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param v
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTrspSvcOrdList(ArrayList<String> v) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRsVo(dbDao.searchTrspSvcOrdList(v));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse removeChassisGensetList(Event e) throws EventException {
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		try {
			dbDao.removeChassisGensetList(event);
			return new GeneralEventResponse();
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendorList(Event e) throws EventException {
		DBRowSet rowSet = null;
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		try {
			rowSet = dbDao.searchVendorList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			StringBuffer vndrNoText = new StringBuffer();
			StringBuffer vndrNmText = new StringBuffer();

			if (rowSet != null && rowSet.getRowCount() > 0) {
				int i = 1;
				while (rowSet.next()) {
					vndrNoText.append((i == 1 ? "" : "|"));
					vndrNoText.append(rowSet.getString("vndr_no"));

					vndrNmText.append((i++ == 1 ? "" : "|"));
					vndrNmText.append(rowSet.getString("vndr_nm_eng"));
				}

				eventResponse.setETCData("vndr_no", vndrNoText.toString());
				eventResponse.setETCData("vndr_nm_eng", vndrNmText.toString());
			}
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendor(Event e) throws EventException {
		DBRowSet rowSet = null;
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		FormCommand formcommand = e.getFormCommand();

		try {
			rowSet = dbDao.searchVendor(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			if (formcommand.isCommand(FormCommand.SEARCH11)) {
				if (rowSet.next()) {
					eventResponse.setETCData("vndr_no", rowSet.getString("vndr_no"));
					eventResponse.setETCData("vndr_nm_eng", rowSet.getString("vndr_nm_eng"));
					eventResponse.setETCData("vndr_cnt_curr_cd", rowSet.getString("vndr_cnt_curr_cd"));
					eventResponse.setETCData("wo_edi_use_flg", rowSet.getString("wo_edi_use_flg"));
				}
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
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendorChld(Event e) throws EventException {
		DBRowSet rowSet = null;
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		FormCommand formcommand = e.getFormCommand();

		try {
			rowSet = dbDao.searchVendorChld(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			if (formcommand.isCommand(FormCommand.SEARCH15)) {
				if (rowSet.next()) {
					eventResponse.setETCData("vndr_no", rowSet.getString("vndr_no"));
					eventResponse.setETCData("vndr_nm_eng", rowSet.getString("vndr_nm_eng"));
					eventResponse.setETCData("vndr_cnt_curr_cd", rowSet.getString("vndr_cnt_curr_cd"));
				}
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
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendorPrnt(Event e) throws EventException {
		DBRowSet rowSet = null;
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		FormCommand formcommand = e.getFormCommand();

		try {
			rowSet = dbDao.searchVendorPrnt(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			if (formcommand.isCommand(FormCommand.SEARCH16)) {
				if (rowSet.next()) {
					eventResponse.setETCData("vndr_no", rowSet.getString("vndr_no"));
					eventResponse.setETCData("vndr_nm_eng", rowSet.getString("vndr_nm_eng"));
					eventResponse.setETCData("vndr_cnt_curr_cd", rowSet.getString("vndr_cnt_curr_cd"));
				}
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
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChassisCorrectionList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null;
		EsdTrs0014Event event = (EsdTrs0014Event) e;

		try {
			rowSet = dbDao.searchChassisCorrectionList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGensetCorrectionList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null;
		EsdTrs0014Event event = (EsdTrs0014Event) e;

		try {
			rowSet = dbDao.searchGensetCorrectionList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchImportedChassis(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null;
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		try {
			rowSet = dbDao.searchImportedChassis(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchImportedGenset(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		try {
			dbDao.searchImportedGenset(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyEqNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null;
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		try {
			rowSet = dbDao.verifyEqNo(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return ArrayList
	 * @exception EventException
	 */
	public ArrayList<String> addTRS_TRSP_SVC_ORD(Event e) throws EventException {
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		try {
			return dbDao.addTRS_TRSP_SVC_ORD(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyChassisGensetSOManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null;
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		FormCommand formcommand = e.getFormCommand();
		try {
			rowSet = dbDao.verifyChassisGensetSOManage(event);
			eventResponse.setRsVo(rowSet);
			if (formcommand.isCommand(FormCommand.SEARCH03)) {
				while (rowSet != null && rowSet.next()) {
					eventResponse.setETCData(JSPUtil.getNull(rowSet.getString("eq_no")), JSPUtil.getNull(rowSet.getString("cre_dt")));
				}
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
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChassisGensetSOManageList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null;
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		try {
			rowSet = dbDao.searchChassisGensetSOManageList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChassisSOManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null;
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		try {
			rowSet = dbDao.searchChassisSOManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} 
	}

	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGensetSOManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null;
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		FormCommand formcommand = e.getFormCommand();
		try {
			rowSet = dbDao.searchGensetSOManage(event);
			eventResponse.setRsVo(rowSet);
			if (formcommand.isCommand(FormCommand.SEARCH02)) {
				eventResponse.setETCData("ROW", event.getRow());
			}
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Modification event process<br>
	 * ESD_TRS_014<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyChassisGensetSOManage(Event e) throws EventException {
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		try {
			dbDao.modifyChassisGensetSOManage(event);
			return new GeneralEventResponse();
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerTpSzCdList(Event e) throws EventException {
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		DBRowSet rowSet = null;
		FormCommand formcommand = e.getFormCommand();
		try {
			rowSet = dbDao.searchContainerTpSzCdList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			if (formcommand.isCommand(FormCommand.SEARCH14)) {
				while (rowSet.next()) {
					eventResponse.setETCData("eq_tpsz_cd", rowSet.getString("eq_tpsz_cd"));
				}
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
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChassisTpSzCdList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null;
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		FormCommand formcommand = e.getFormCommand();
		try {
			rowSet = dbDao.searchChassisTpSzCdList(event);
			eventResponse.setRsVo(rowSet);
			if (formcommand.isCommand(FormCommand.SEARCH12)) {
				while (rowSet.next()) {
					eventResponse.setETCData("eq_tpsz_cd", rowSet.getString("eq_tpsz_cd"));
				}
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
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGensetTpSzCdList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null;
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		FormCommand formcommand = e.getFormCommand();
		try {
			rowSet = dbDao.searchGensetTpSzCdList(event);
			eventResponse.setRsVo(rowSet);
			if (formcommand.isCommand(FormCommand.SEARCH13)) {
				while (rowSet.next()) {
					eventResponse.setETCData("eq_tpsz_cd", rowSet.getString("eq_tpsz_cd"));
				}
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
	 * End process of TRS task scenario<br>
	 * Releasing the related implicit object when ChassisGensetSOManage task is end.<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}