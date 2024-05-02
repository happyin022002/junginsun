/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Invoice210EdiBCImpl.java
*@FileTitle : Invoice 210 EDI
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoice210edi.basic;

import com.clt.apps.opus.esd.trs.invoicemanage.invoice210edi.integration.Invoice210EdiDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.TrsTrspInvEdiVO;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;


/**
 * ENIS-Invoice210Edi Business Logic Basic Command implementation<br>
 * - ENIS-Invoice210Edi handling business logic.<br>
 * 
 * @author 
 * @see ESD_TRS_965EventResponse,Invoice210EdiBC refer to each DAO classes
 * @since
 */
public class Invoice210EdiBCImpl   extends BasicCommandSupport implements Invoice210EdiBC {

	private transient Invoice210EdiDBDAO dbDao=null;

	/**
	 * Invoice210EdiBCImpl objects creation<br>
	 * Generate Invoice210EdiDBDAO.<br>
	 */
	public Invoice210EdiBCImpl(){
		dbDao = new Invoice210EdiDBDAO();
	}

	/**
	 * retrieve event process<br>
	 * Invoice210Edi retrieve event process<br>
	 * 
	 * @param model
	 * @return int
	 * @exception EventException
	 */
	public int searchInvCfmSO(TrsTrspInvEdiVO model) throws EventException{
		try {
			return dbDao.searchInvCfmSO(model);  

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
	}

	/**
	 * retrieve event process<br>
	 * Invoice210Edi retrieve event process<br>
	 * 
	 * @param model
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchNotInvSO(TrsTrspInvEdiVO model) throws EventException{
		try {
			return dbDao.searchNotInvSO(model);  

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
	}
	
	/**
	 * retrieve event process<br>
	 * Invoice210Edi retrieve event process<br>
	 * 
	 * @param model
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchInvoiceWO(TrsTrspInvEdiVO model) throws EventException{
		try {
			return dbDao.searchInvoiceWO(model);  

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
	}
	
	/**
	 * retrieve event process<br>
	 * Invoice210Edi retrieve event process<br>
	 * 
	 * @param vndr_seq
	 * @return String
	 * @exception EventException
	 */
	public String searchInvoiceVndr(String vndr_seq) throws EventException{
		try {
			return dbDao.searchInvoiceVndr(vndr_seq);  

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * save event process<br>
	 * Invoice210Edi save event process<br>
	 * 
	 * @param model 
	 * @param rejectFlag
	 * @param invAmt
	 * @return  boolean
	 * @exception EventException
	 */
	public boolean saveInvoice210Edi(TrsTrspSvcOrdVO model, boolean rejectFlag, String invAmt) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		try {
			return dbDao.saveInvoice210Edi(model, rejectFlag, invAmt);  

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * modify event process<br>
	 * Invoice210Edi  modify event process<br>
	 * 
	 * @param model TrsTrspInvEdiVO
	 * @exception EventException
	 */
	public void modifyTrsTrspInvEdi(TrsTrspInvEdiVO model) throws EventException {
		// PDTO(Data Transfer Object including Parameters)

		try {
			dbDao.modifyTrsTrspInvEdi(model);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 *Getting to bkg_no CNTR <br>
	 * 
	 * @param inputRs
	 * @param EQ_NO
	 * @return String
	 * @throws EventException
	 */
	public String searchInvoiceImportBkgBkgCntr(DBRowSet inputRs, String EQ_NO) throws EventException {
		try {
			return dbDao.searchInvoiceImportBkgBkgCntr(inputRs, EQ_NO);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	
	}


	/**
	 * Invoice210Edi biz scenario closing<br>
	 * Invoice210Edi clearing related objects<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}