/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Invoice210EdiBC.java
*@FileTitle : Invoice 210 EDI
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :

=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoice210edi.basic;

import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.TrsTrspInvEdiVO;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * Invoice210Edi Business Logic Command Interface<br>
 * An interface to the business logic for Invoice210Edi<br>
 *
 * @author
 * @see ESD_TRS_965EventResponse
 * @since
 */
public interface Invoice210EdiBC  {

	/**
	 * retrieve event process<br>
	 * Invoice210Edi retrieve event process<br>
	 * 
	 * @param model
	 * @return
	 * @throws EventException
	 */
	public int searchInvCfmSO(TrsTrspInvEdiVO model) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * Invoice210Edi retrieve event process<br>
	 * 
	 * @param model
	 * @return
	 * @throws EventException
	 */
	public DBRowSet searchNotInvSO(TrsTrspInvEdiVO model) throws EventException;
	
	
	/**
	 * retrieve event process<br>
	 * Invoice210Edi retrieve event process<br>
	 * 
	 * @param model
	 * @return
	 * @throws EventException
	 */
	public DBRowSet searchInvoiceWO(TrsTrspInvEdiVO model) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * Invoice210Edi retrieve event process<br>
	 * 
	 * @param vndr_seq
	 * @return
	 * @throws EventException
	 */
	public String searchInvoiceVndr(String vndr_seq) throws EventException;

	/**
	 * save  event process<br>
	 * Invoice210Edi retrieve event process<br>
	 * 
	 * @param model
	 * @param rejectFlag
	 * @param invAmt
	 * @return
	 * @throws EventException
	 */
	public boolean saveInvoice210Edi(TrsTrspSvcOrdVO model, boolean rejectFlag, String invAmt) throws EventException;
	
	/**
	 * modify event process<br>
	 * Invoice210Edi  modify event process<br>
	 * 
	 * @param model
	 * @throws EventException
	 */
	public void modifyTrsTrspInvEdi(TrsTrspInvEdiVO model) throws EventException;
	
	/**
	 * Get CNTR with bkg_no <br>
	 * 
	 * @param inputRs
	 * @param EQ_NO
	 * @return
	 * @throws EventException
	 */
	public String searchInvoiceImportBkgBkgCntr(DBRowSet inputRs, String EQ_NO) throws EventException;


}