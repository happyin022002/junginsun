/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RailInvoiceauditBCImpl.java
 *@FileTitle : USA Rail Invoice Agree and Confirm
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0038Event;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0923Event;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0925Event;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0929Event;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration.RailInvoiceauditDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.TrsTrspRailInvDtlVO;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS business logic handling.<br>
 * 
 * @author
 * @see ESD_TRS_038EventResponse,railInvoiceauditBC each DAO class reference
 * @since J2EE 1.4
 */
public class RailInvoiceauditBCImpl extends BasicCommandSupport implements RailInvoiceauditBC {
	// Database Access Object
	private transient RailInvoiceauditDBDAO dbDao = null;

	/**
	 * RailInvoiceauditBCImpl object creation<br>
	 * RailInvoiceauditDBDAO creation<br>
	 */
	public RailInvoiceauditBCImpl() {
		dbDao = new RailInvoiceauditDBDAO();
	}

	/**
	 * Payment VNDR Info Event Handling<br>
	 * railInvoiceaudit screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_038Event
	 * @return EventResponse ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPaymentVndrList(Event e) throws EventException {
		EsdTrs0038Event event = (EsdTrs0038Event) e;
		DBRowSet rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet = dbDao.searchPaymentVndrList(event, "");
			if (rowSet.getRowCount() > 0) {
				if (rowSet.next()) {
					eventResponse.setETCData("payment_vndr_code", rowSet.getString("VNDR_SEQ"));
					eventResponse.setETCData("payment_vndr_name", rowSet.getString("VNDR_LGL_ENG_NM"));
					eventResponse.setETCData("flag", rowSet.getString("FLAG"));
				}
			} else {
				rowSet = dbDao.searchPaymentVndrList(event, "P");
				if (rowSet.next()) {
					eventResponse.setETCData("payment_vndr_code", "");
					eventResponse.setETCData("payment_vndr_name", "");
					eventResponse.setETCData("flag", "0");
				}
			}
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event handling<br>
	 * Railinvoiceaudit screen views for event handling<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailinvoiceauditList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0038Event event = (EsdTrs0038Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		DBRowSet rowSet = null; // The result of user requests (DB Result Set, object, value, etc.) containing the object
		DBRowSet rowSet1 = null; // The result of user requests (DB Result Set, object, value, etc.) containing the object
		DBRowSet rowSet2 = null; // The result of user requests (DB Result Set, object, value, etc.) containing the object
		// DBRowSet rowSet3 = null; // The result of user requests (DB Result Set, object, value, etc.) containing the object

		try {
			rowSet = dbDao.searchRailinvoiceaudit(event);
			rowSet1 = dbDao.searchRailinvoiceauditList(event, "C");
			rowSet2 = dbDao.searchRailinvoiceauditList(event, "D");
			// rowSet3 = dbDao.searchRailinvoiceauditList(event , "I" );

			while (rowSet.next()) {
				eventResponse.setETCData("trsp_inv_aud_sts_cd", rowSet.getString("TRSP_INV_AUD_STS_CD"));
				eventResponse.setETCData("payment_vndr_code", rowSet.getString("WO_VNDR_SEQ"));
				eventResponse.setETCData("payment_vndr_name", rowSet.getString("WO_VNDR_NM"));
				eventResponse.setETCData("rail_road_code", rowSet.getString("INV_VNDR_SEQ"));
				eventResponse.setETCData("rail_road_name", rowSet.getString("INV_VNDR_NM"));
				eventResponse.setETCData("receive_dt", rowSet.getString("INV_RCV_DT"));
				eventResponse.setETCData("issue_dt", rowSet.getString("INV_ISS_DT"));
				eventResponse.setETCData("currency", rowSet.getString("INV_CURR_CD"));
				eventResponse.setETCData("invoice_amt", rowSet.getString("INV_BZC_AMT"));
				eventResponse.setETCData("vat_amt", rowSet.getString("INV_VAT_AMT"));
			}

			eventResponse.setRsVo(rowSet1);
			eventResponse.setRsVo(rowSet2);
			// eventResponse.setRsVo(rowSet3);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event handling<br>
	 * Container History Inquiry event handling on the screen<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPaymentHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0929Event event = (EsdTrs0929Event) e;
		DBRowSet rowSet = null; // The result of user requests (DB Result Set, object, value, etc.) containing the object
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet = dbDao.searchPaymentHistoryList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Modified event handling<br>
	 * On-screen multi-event processing ESD_TRS_038<br>
	 * 
	 * @param e ESD_TRS_038Event
	 * @return EventResponse ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyRailinvoiceaudit(Event e) throws EventException {
		EsdTrs0038Event event = (EsdTrs0038Event) e;
		try {
			dbDao.modifyTRS_TRSP_RAIL_INV_DTL(event);
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event handling<br>
	 * Invoice information is stored in ApPayInvVO.<br>
	 * 
	 * @param invNo
	 * @param ofcCd
	 * @return apPayInvVO ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO searchApPayInvMain(String invNo, String ofcCd) throws EventException {
		ApPayInvVO apPayInvVO = new ApPayInvVO();

		try {
			List<ApPayInvVO> list = dbDao.searchApPayInvMain(invNo, ofcCd);
			// Input received and read the value from the DB is set to ApPayInvVO.
			apPayInvVO = (ApPayInvVO) list.get(0);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}

		return apPayInvVO;
	}

	/**
	 * retrieve event handling<br>
	 * Invoice Detail information is stored in ApPayInvDtlVOs.<br>
	 * 
	 * @param invNo
	 * @return apPayInvVOs ApPayInvDtlVO[]
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] searchApPayInvDetail(String invNo) throws EventException {
		ApPayInvDtlVO[] apPayInvDtlVOs = null;

		try {
			List<ApPayInvDtlVO> list = dbDao.searchApPayInvDetail(invNo);

			if (list != null) {
				apPayInvDtlVOs = new ApPayInvDtlVO[list.size()];

				for (int i = 0; i < list.size(); i++) {
					ApPayInvDtlVO apPayInvDtlVO = new ApPayInvDtlVO();
					apPayInvDtlVO = (ApPayInvDtlVO) list.get(i);
					apPayInvDtlVOs[i] = apPayInvDtlVO;
				}
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}

		return apPayInvDtlVOs;
	}

	/**
	 * updateRgstNoInvWrk<br>
	 * 
	 * @param apPayInvVO
	 * @exception EventException
	 */
	public void updateRgstNoRailInvWrk(ApPayInvVO apPayInvVO) throws EventException {
		try {
			dbDao.updateRgstNoRailInvWrk(apPayInvVO.getInvNo(), apPayInvVO.getInvOfcCd(), apPayInvVO.getInvRgstNo());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event handling<br>
	 * Viewed on-screen event handling for CLM History<br>
	 * 
	 * @param e
	 * @exception EventException
	 */
	public void searchReAuditVerify(Event e) throws EventException {
		EsdTrs0038Event event = (EsdTrs0038Event) e;
		try {
			dbDao.searchReAuditVerify(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event handling<br>
	 * Viewed on-screen event handling for CLM History<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public EventResponse searchReAuditInfoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0925Event event = (EsdTrs0925Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSetSxml1 = null; // The result of user requests (DB Result Set, object, value, etc.) containing the object
		DBRowSet rowSetSxml2 = null; // The result of user requests (DB Result Set, object, value, etc.) containing the object
		DBRowSet rowSetSxml3 = null; // The result of user requests (DB Result Set, object, value, etc.) containing the object

		try {
			rowSetSxml1 = dbDao.searchCLMHistory(event);
			rowSetSxml2 = dbDao.searchInvoiceList(event);
			rowSetSxml3 = dbDao.searchBillingList(event);

			eventResponse.setRsVo(rowSetSxml1);
			eventResponse.setRsVo(rowSetSxml2);
			eventResponse.setRsVo(rowSetSxml3);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event handling<br>
	 * Re Audit viewed on-screen event handling<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0038Event event = (EsdTrs0038Event) e;
		DBRowSet rowSet = null; // The result of user requests (DB Result Set, object, value, etc.) containing the object
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet = dbDao.searchContainerInfo(event);
			eventResponse.setRsVo(rowSet);

			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Verify Cntr No event handling<br>
	 * railInvoiceaudit screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_923Event
	 * @return EventResponse ESD_TRS_923EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList verifyInvoiceFileImportEqNo(Event e) throws EventException {
		EsdTrs0923Event event = (EsdTrs0923Event) e;
		try {
			return dbDao.verifyInvoiceFileImportEqNo(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Verify Cntr No event handling<br>
	 * railInvoiceaudit screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_923Event
	 * @return EventResponse ESD_TRS_923EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList verifyInvoiceFileImportInvNo(Event e) throws EventException {
		EsdTrs0923Event event = (EsdTrs0923Event) e;
		try {
			return dbDao.verifyInvoiceFileImportInvNo(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Verify Cntr No event handling<br>
	 * railInvoiceaudit screen views for event handling<br>
	 * 
	 * @param TrsTrspRailInvDtlVO trsTrspRailInvDtlVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet verifyInvoiceFileImportVndrSetList(TrsTrspRailInvDtlVO trsTrspRailInvDtlVO) throws EventException {
		try {
			return dbDao.verifyInvoiceFileImportVndrSetList(trsTrspRailInvDtlVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Verify Cntr No event handling<br>
	 * 
	 * @param trsTrspRailInvDtlVO
	 * @return
	 * @throws EventException
	 */
	public String verifyInvoiceFileImportVndrSetListForMultiSo(TrsTrspRailInvDtlVO trsTrspRailInvDtlVO) throws EventException {
		try {
			return dbDao.verifyInvoiceFileImportVndrSetListForMultiSo(trsTrspRailInvDtlVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * TRS business scenarios and finishing<br>
	 * At the end of business-related internal objects railInvoiceaudit release scenarios<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}