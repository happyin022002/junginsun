/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SurchargeInputInquiryBCImpl.java
 *@FileTitle : surcharge, enter / edit / delete screen
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.basic;

import java.sql.SQLException;

import com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.event.EsdTrs0918Event;
import com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.integration.SurchargeInputInquiryDBDAO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.searchWorkOrderIssueListVO;
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
 * - ESD-TRS business logic handling.<br>
 * 
 * @author poong_yeon
 * @see ESD_TRS_918EventResponse,SurchargeInputInquiryBC each DAO class reference
 * @since J2EE 1.4
 */
public class SurchargeInputInquiryBCImpl extends BasicCommandSupport implements SurchargeInputInquiryBC {

	// Database Access Object
	private transient SurchargeInputInquiryDBDAO dbDao = null;

	/**
	 * SurchargeInputInquiryBCImpl object creation<br>
	 * SurchargeInputInquiryDBDAO creation<br>
	 */
	public SurchargeInputInquiryBCImpl() {
		dbDao = new SurchargeInputInquiryDBDAO();
	}

	/**
	 * retrieve event handling<br>
	 * SurchargeInputInquiry screen views for event handling<br>
	 * 
	 * @param e
	 * @param singleVO
	 * @return response ESD_TRS_918EventResponse
	 * @exception EventException 2014.12.11 Modified by Hyungwook Choi
	 */
	public EventResponse searchSurchargeInputInquiryList(Event e, searchWorkOrderIssueListVO singleVO) throws EventException {
		DBRowSet rowSet = null; // The result of user requests (DB Result Set, object, value, etc.) containing the object
		EsdTrs0918Event event = (EsdTrs0918Event) e;
		try {
			rowSet = dbDao.searchSurchargeInputInquiryList(event, singleVO);
			// return new EsdTrs0918EventResponse(rowSet, "SUCCESS");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event handling<br>
	 * SurchargeInputInquiry screen views for event handling<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_918EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTPBIfFlag(Event e) throws EventException {
		DBRowSet rowSet = null; // The result of user requests (DB Result Set, object, value, etc.) containing the object
		EsdTrs0918Event event = (EsdTrs0918Event) e;
		try {
			rowSet = dbDao.searchTPBIfFlag(event);
			// return new EsdTrs0918EventResponse(rowSet, "SUCCESS");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if (rowSet.next()) {
				eventResponse.setETCData("if_so_ofc", rowSet.getString("IF_SO_OFC"));
				eventResponse.setETCData("if_so_seq", rowSet.getString("IF_SO_SEQ"));
				eventResponse.setETCData("if_flg", rowSet.getString("IF_FLG"));
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
	 * retrieve event handling<br>
	 * SurchargeInputInquiry screen views for event handling<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_918EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSurchargeCodeNameList(Event e) throws EventException {
		DBRowSet rowSet = null; // The result of user requests (DB Result Set, object, value, etc.) containing the object
		EsdTrs0918Event event = (EsdTrs0918Event) e;
		try {
			rowSet = dbDao.searchSurchargeCodeNameList(event);
			// return new EsdTrs0918EventResponse(rowSet,"SUCCESS");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * insert processing<br>
	 * Surcharge Temp Table에 insert processing<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_918EventResponse
	 * @exception EventException
	 */
	public EventResponse addTempSurchargeList(Event e) throws EventException {
		EsdTrs0918Event event = (EsdTrs0918Event) e;
		FormCommand formcommand = e.getFormCommand();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (formcommand.isCommand(FormCommand.ADD)) {
				eventResponse.setETCData("scg_grp_seq", dbDao.addTempSurchargeList(event));
			}
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
	 * TRS business scenarios and finishing<br>
	 * TRS-related internal objects off at the end of business scenarios<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}