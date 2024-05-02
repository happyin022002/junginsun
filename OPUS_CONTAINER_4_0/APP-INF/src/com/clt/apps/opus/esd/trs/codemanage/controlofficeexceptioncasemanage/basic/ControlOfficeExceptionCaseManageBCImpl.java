/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ControlOfficeExceptionCaseManageBCImpl.java
 *@FileTitle : Control Office Exception Case Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.basic;

import java.sql.SQLException;

import com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.event.EsdTrs0079Event;
import com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.integration.ControlOfficeExceptionCaseManageDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
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
 * @see ESD_TRS_079EventResponse,ControlOfficeExceptionCaseManageBC
 * @since J2EE 1.4
 */
public class ControlOfficeExceptionCaseManageBCImpl extends BasicCommandSupport implements ControlOfficeExceptionCaseManageBC {

	private transient ControlOfficeExceptionCaseManageDBDAO dbDao = null;

	/**
	 * OtherSOManageBCImpl <br>
	 * OtherSOManageDBDAO<br>
	 */
	public ControlOfficeExceptionCaseManageBCImpl() {
		dbDao = new ControlOfficeExceptionCaseManageDBDAO();
	}

	/**
	 * Inquiry event process<br>
	 * ControlOfficeExceptionCaseManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchControlOfficeExceptionCaseManageList(Event e) throws EventException {
		EsdTrs0079Event event = (EsdTrs0079Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchControlOfficeExceptionCaseManageList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Multi-event processing<br>
	 * ESD_TRS_079 - Multi-event processing<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse multiControlOfficeExceptionCaseManage(Event e) throws EventException {
		EsdTrs0079Event event = (EsdTrs0079Event) e;

		try {
			dbDao.multiTRS_TRSP_OFC_EXPT_RULE(event);
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * SEARCH01 event processing<br>
	 * ESD_TRS_079 - SEARCH01 event processing<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchYardCodeManage(Event e) throws EventException {
		EsdTrs0079Event event = (EsdTrs0079Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StringBuilder comboText = new StringBuilder();
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchYardCode(event);
			while (rowSet.next()) {
				comboText.append(rowSet.getString("NOD")).append("|");
			}
			if (comboText.length() > 0) {
				eventResponse.setETCData("nod", comboText.substring(0, comboText.length() - 1));
			} else {
				eventResponse.setETCData("nod", comboText.toString());
			}
			eventResponse.setRsVo(rowSet);
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
	 * SEARCH01 event processing<br>
	 * ESD_TRS_079 - SEARCH01 event processing<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchYardCodeName(Event e) throws EventException {
		EsdTrs0079Event event = (EsdTrs0079Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchYardCodeName(event);
			if (rowSet.next()) {
				eventResponse.setETCData("yd_nm", rowSet.getString("yd_nm"));
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
	 * SEARCH02 event processing<br>
	 * ESD_TRS_079 - SEARCH02 event processing<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCountryCodeManage(Event e) throws EventException {
		EsdTrs0079Event event = (EsdTrs0079Event) e;
		DBRowSet rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FormCommand formcommand = e.getFormCommand();
		try {
			rowSet = dbDao.searchCountryCode(event);

			if (rowSet.next()) {
				if (formcommand.isCommand(FormCommand.SEARCH02)) {
					eventResponse.setETCData("CNT_CD", rowSet.getString("CNT_CD"));
				}
			}

			eventResponse.setRsVo(rowSet);
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
	 * SEARCH03 event processing<br>
	 * ESD_TRS_079 - SEARCH03 event processing<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchControlOfficeCodeManage(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0079Event event = (EsdTrs0079Event) e;
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchControlOfficeCode(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * SEARCH01 event processing<br>
	 * ESD_TRS_079 - SEARCH01 event processing<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEquipmentSZ(Event e) throws EventException {

		EsdTrs0079Event event = (EsdTrs0079Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null;
		StringBuilder comboText = new StringBuilder();
		try {
			rowSet = dbDao.searchEquipmentSZ(event);

			while (rowSet.next()) {
				comboText.append(rowSet.getString("CNTR_SZ_CD")).append("|");
			}
			if (comboText.length() > 0) {
				eventResponse.setETCData("TEXT", comboText.substring(0, comboText.length() - 1));
			} else {
				eventResponse.setETCData("TEXT", comboText.toString());
			}

			eventResponse.setRsVo(rowSet);
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
	 * SEARCH01 event processing<br>
	 * ESD_TRS_079 - SEARCH01 event processing<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEquipmentTP(Event e) throws EventException {

		EsdTrs0079Event event = (EsdTrs0079Event) e;
		DBRowSet rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FormCommand formcommand = e.getFormCommand(); // For ETC DATA
		try {
			rowSet = dbDao.searchEquipmentTP(event);
			String comboText = "";

			while (rowSet.next()) {
				if (formcommand.isCommand(FormCommand.SEARCH05)) {
					comboText = comboText + rowSet.getString("CNTR_TP_CD") + "|";
				}
			}
			if (comboText.length() > 0)
				comboText = comboText.substring(0, comboText.length() - 1);
			eventResponse.setETCData("TEXT", comboText);

			eventResponse.setRsVo(rowSet);
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
	 * SEARCH01 event processing<br>
	 * ESD_TRS_079 - SEARCH01 event processing<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyControlOfficeCD(Event e) throws EventException {

		EsdTrs0079Event event = (EsdTrs0079Event) e;
		DBRowSet rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet = dbDao.verifyControlOfficeCD(event);
			if (rowSet.next()) {
				eventResponse.setETCData("OFC_CD", rowSet.getString("OFC_CD"));
				eventResponse.setETCData("OFC_TP_CD", rowSet.getString("OFC_TP_CD"));
			}

			eventResponse.setRsVo(rowSet);
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
	 * Releasing the related implicit object when ControlOfficeExceptionCaseManage task is end.
	 */
	public void doEnd() {
		dbDao = null;
	}
}