/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : invoiceauditBCImpl.java
 *@FileTitle : invoice Audit Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.basic;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0033Event;
import com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0040Event;
import com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration.InvoiceAuditDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * ESD-invoicemanage Business Logic Basic Command implementation<br>
 * - ESD-invoicemanage handling business logic.<br>
 * 
 * @author
 * @see ESD_TRS_910EventResponse,InvoiceAuditBC refer to each DAO classes
 * @since
 */
public class InvoiceAuditBCImpl extends BasicCommandSupport implements InvoiceAuditBC {
	private transient InvoiceAuditDBDAO dbDao = null;

	/**
	 * InvoiceAuditBCImpl objects creation<br>
	 * Generate InvoiceAuditDBDAO.<br>
	 */
	public InvoiceAuditBCImpl() {
		dbDao = new InvoiceAuditDBDAO();
	}

	/**
	 * bkg_no and EQ container that has been the mappin<br>
	 * retrieve event process<br>
	 * 
	 * @param inputRs
	 * @param model
	 * @return String
	 * @exception EventException
	 */
	public String searchInvoiceImportBkgBkgCntr(DBRowSet inputRs, TrsTrspSvcOrdVO model) throws EventException {
		try {
			return dbDao.searchInvoiceImportBkgBkgCntr(inputRs, model);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * bkg_no and EQ container that has been the mapping<br>
	 * retrieve event process<br>
	 * 
	 * @param svcModel
	 * @param model
	 * @return String
	 * @exception EventException
	 */
	public String searchInvoiceImportBkgBkgCntr2(TrsTrspSvcOrdVO svcModel, TrsTrspSvcOrdVO model) throws EventException {
		try {
			return dbDao.searchInvoiceImportBkgBkgCntr2(svcModel, model);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Reject Invoice<br>
	 * Reject event process<br>
	 * 
	 * @param eqNo
	 * @return
	 * @exception EventException
	 */
	public DBRowSet verifyEqNo(String eqNo) throws EventException {
		try {
			return dbDao.verifyEqNo(eqNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve Invoice<br>
	 * retrieve event process<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	public EventResponse searchTruckInvoiceFileImport(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		try {
			eventResponse.setRsVoList(dbDao.searchTruckInvoiceFileImport(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve Invoice<br>
	 * retrieve event process<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList searchInvoiceImportSO(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		try {
			return dbDao.searchInvoiceImportSO(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve Invoice<br>
	 * retrieve event process<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList searchInvoiceImportWO(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		try {
			return dbDao.searchInvoiceImportWO(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve Invoice<br>
	 * retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList searchInvoiceImportEmptyWO(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		try {
			return dbDao.searchInvoiceImportEmptyWO(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Reject Invoice<br>
	 * Reject event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse rejectInvoice(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		try {
			dbDao.rejectInvoice(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve Invoice<br>
	 * retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMdmOrganization(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet = null;

		try {
			rowSet = dbDao.searchMdmOrganization(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			while (rowSet.next()) {
				if (formcommand.isCommand(FormCommand.SEARCH12)) {
					eventResponse.setETCData("bil_curr_cd", rowSet.getString("BIL_CURR_CD"));

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
	 * retrieve event process<br>
	 * Invoice File Import의 verify<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvOfcCd(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchInvOfcCd(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			StringBuffer returnStr = new StringBuffer();
			int cnt = 0;
			if (formcommand.isCommand(FormCommand.SEARCH10)) {
				while (rowSet != null && rowSet.next()) {
					if (cnt == 0) {
						returnStr.append(rowSet.getString("OFC_CD"));
						cnt++;
					} else {
						returnStr.append("|");
						returnStr.append(rowSet.getString("OFC_CD"));
						cnt++;
					}
				}

				eventResponse.setETCData("ofc_cd", returnStr.toString());
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
	 * invoiceaudit save event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public List<TrsTrspSvcOrdVO> saveInvoiceAudit(Event e) throws EventException {
		try {
			return dbDao.saveInvoiceAudit((EsdTrs0033Event) e);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * invoice list retrieve<br>
	 * invoice audit Confirm process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmInvoiceAudit(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.confirmInvoiceAudit(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * invoice list retrieve<br>
	 * invoiceaudit retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_0033EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceAuditList(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchInvoiceAuditList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * invoice list retrieve<br>
	 * invoiceaudit retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceAuditListByInvoiceNo(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchInvoiceAuditListByInvoiceNo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			String[] colValue = null;
			if (rowSet != null) {
				colValue = new String[rowSet.getMetaData().getColumnCount()];
				for (int k = 1; k < rowSet.getMetaData().getColumnCount() + 1; k++) {
					colValue[k - 1] = rowSet.getMetaData().getColumnName(k);
				}

				Map<String, String[]> colOrders = new HashMap<String, String[]>();
				colOrders.put("COLORDER", colValue);
				eventResponse.setColOrders(colOrders);
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
	 * invoiceaudit retrieve event process<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchDupChkInvoice(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchDupChkInvoice(event);
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
	 * invoiceaudit retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPaymentSP(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchPaymentSP(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			while (rowSet.next()) {
				if (formcommand.isCommand(FormCommand.SEARCH02)) {
					eventResponse.setETCData("prnt_vndr_seq", rowSet.getString("PRNT_VNDR_SEQ"));
					eventResponse.setETCData("prnt_vndr_nm", rowSet.getString("PRNT_VNDR_NM"));
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
	 * multi event process<br>
	 * invoice refund multi event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse multiInvoiceAuditRefund(Event e) throws EventException {
		EsdTrs0040Event event = (EsdTrs0040Event) e;
		try {
			dbDao.multiTRS_TRSP_RFND_INV(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * invoice refund retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPaymentVendor(Event e) throws EventException {
		EsdTrs0040Event event = (EsdTrs0040Event) e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchPaymentVendor(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			while (rowSet.next()) {
				if (formcommand.isCommand(FormCommand.SEARCH02)) {
					eventResponse.setETCData("inv_vndr_seq", rowSet.getString("INV_VNDR_SEQ"));
					eventResponse.setETCData("inv_vndr_nm", rowSet.getString("INV_VNDR_NM"));
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
	 * retrieve event process<br>
	 * invoice refund retrieve event process<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceNo(Event e) throws EventException {
		EsdTrs0040Event event = (EsdTrs0040Event) e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchInvoiceNo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if (formcommand.isCommand(FormCommand.SEARCH02)) {
				eventResponse.setETCData("inv_flag", String.valueOf(rowSet.getRowCount()));
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
	 * retrieve event process<br>
	 * invoice refund retrieve event process<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRefundList(Event e) throws EventException {
		EsdTrs0040Event event = (EsdTrs0040Event) e;
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchRefundList(event);
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
	 * Invoice File Import verify<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyEqNo(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		DBRowSet[] rowSets = null;
		try {
			rowSets = dbDao.verifyEqNo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSets);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * Invoice File EXCHAGE RATE calculate<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse calculateExchangeRate(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.calculateExchangeRate(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			while (rowSet.next()) {
				if (formcommand.isCommand(FormCommand.SEARCH13)) {
					eventResponse.setETCData("inv_bzc_amt", rowSet.getString("INV_BZC_AMT"));
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
	 * searchPaymentChildVnder<br>
	 * select event process<br>
	 * 
	 * @param vndrSeq
	 * @return ArrayList
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList searchPaymentChildVendor(String vndrSeq) throws EventException {
		try {
			return dbDao.searchPaymentChildVendor(vndrSeq);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * searchInvoiceImportDuplicateCheckByDate<br>
	 * due to data redundancy check +/- 2일 <br>
	 * 
	 * @param model TrsTrspSvcOrdVO
	 * @return ArrayList
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList searchInvoiceImportDuplicateCheckByDate(TrsTrspSvcOrdVO model) throws EventException {
		try {
			return dbDao.searchInvoiceImportDuplicateCheckByDate(model);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * S/O Creation date based on whether or not duplicate Invoice Inquiry<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchInvoiceImportDuplicateCheckByDate2(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(dbDao.searchInvoiceImportDuplicateCheckByDate2(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * S/O of the Suchargy .<br>
	 * 
	 * @param event
	 * 
	 * @return ArrayList
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList searchWoSurcharge(EsdTrs0033Event event) throws EventException {
		try {
			return dbDao.searchWoSurcharge(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * WO issue, Invoice Processing check if no data.<br>
	 * 
	 * @param event
	 * @throws EventException
	 */
	public void checkConfirmInvoice(EsdTrs0033Event event) throws EventException {
		try {
			dbDao.checkConfirmInvoice(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Invoice confirm Create and modify <br>
	 * 
	 * @param event
	 * 
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse confirmInvoiceAuditForMain(EsdTrs0033Event event) throws EventException {
		try {
			dbDao.confirmInvoiceAuditForMain(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Invoice Confirm process.<br>
	 * 
	 * @param event
	 * @param row
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse confirmInvoiceAuditForSvcOrd(EsdTrs0033Event event, int row) throws EventException {
		try {
			dbDao.confirmInvoiceAuditForSvcOrd(event, row);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Invoice information set in ApPayInvVO.<br>
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
	 * Invoice Detail information is stored in ApPayInvDtlVOs .<br>
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
	 * Save Invoice as the state Rollback .<br>
	 * 
	 * @param event
	 * @throws EventException
	 */
	public void rollbackInvoiceAuditForMain(EsdTrs0033Event event) throws EventException {
		try {
			dbDao.rollbackInvoiceAuditForMain(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * invoicemanage biz scenario closing<br>
	 * invoiceaudit clearing related objects<br>
	 */
	public void doEnd() {
		dbDao = null;
	}

	/**
	 * updateRgstNoInvWrk<br>
	 * 
	 * @param apPayInvVO
	 * @exception EventException
	 */
	public void updateRgstNoInvWrk(ApPayInvVO apPayInvVO) throws EventException {
		try {
			dbDao.updateRgstNoInvWrk(apPayInvVO.getInvNo(), apPayInvVO.getInvOfcCd(), apPayInvVO.getInvRgstNo());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Brings existing 3rd party billing currency is stored .<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchN3ptyCurrCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		try {
			dbDao.searchN3ptyCurrCd(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * PARENTS SP that brings in WO SP <br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendor(Event e) throws EventException {
		EsdTrs0040Event event = (EsdTrs0040Event) e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchVendor(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			while (rowSet.next()) {
				if (formcommand.isCommand(FormCommand.SEARCH03)) {
					eventResponse.setETCData("vndr_no", rowSet.getString("VNDR_NO"));
					eventResponse.setETCData("vndr_nm_eng", rowSet.getString("VNDR_NM_ENG"));
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
	 * Invoice Audit for Refund Main information is stored in ApPayInvVO. ESD_TRS_0040<br>
	 * 
	 * @param invNo
	 * @param ofcCd
	 * @return apPayInvVO ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO searchApPayInvRfndMain(String invNo, String ofcCd) throws EventException {
		ApPayInvVO apPayInvVO = new ApPayInvVO();

		try {
			List<ApPayInvVO> list = dbDao.searchApPayInvRfndMain(invNo, ofcCd);
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
	 * Invoice Audit for Refund Detail information is stored in ApPayInvDtlVOs. ESD_TRS_0040<br>
	 * 
	 * @param invNo
	 * @return apPayInvVOs ApPayInvDtlVO[]
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] searchApPayInvRfndDetail(String invNo) throws EventException {
		ApPayInvDtlVO[] apPayInvDtlVOs = null;

		try {
			List<ApPayInvDtlVO> list = dbDao.searchApPayInvRfndDetail(invNo);

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
	 * Reject Invoice<br>
	 * Reject event process<br>
	 * 
	 * @param invVndrSeq
	 * @param refInvNo
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet verifyRefInvNo(String invVndrSeq, String refInvNo) throws EventException {
		try {
			return dbDao.verifyRefInvNo(invVndrSeq, refInvNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * retrieve event process<br>
	 * Refund Invoice & Detail List retrieve event process<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRefundInvAndDetailList(Event e) throws EventException{
		EsdTrs0040Event event = (EsdTrs0040Event) e;
		DBRowSet rowSet1 = null;
		DBRowSet rowSet2 = null;
		try {
			rowSet1 = dbDao.searchRefundInvoice(event);
			rowSet2 = dbDao.searchRefundList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			if (rowSet1 != null) {
				while (rowSet1.next()) {
					for (int k = 1; k < rowSet1.getMetaData().getColumnCount() + 1; k++) {
						eventResponse.setETCData(rowSet1.getMetaData().getColumnName(k).toLowerCase(), JSPUtil.getNull(rowSet1.getString(rowSet1.getMetaData().getColumnName(k))));
					}
				}
			}
			eventResponse.setRsVo(rowSet2);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (SQLException e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(e1.getMessage());
		} catch (Exception e1) {
			log.error("err " + e1.toString(), e1);
			throw new EventException(e1.getMessage());
		} 
	}

}