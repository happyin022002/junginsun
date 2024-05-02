/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : AccountReceivableCreateAccountingBC.java
 *@FileTitle : AccountReceivableCreateAccountingBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.03.03 authorName
 * 1.0 Creation
 * --------------------------------------------------------
 * History
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecreateaccounting.accountreceivablecreateaccounting.basic;

import java.util.List;

import com.clt.apps.opus.stm.sar.accountreceivablecreateaccounting.accountreceivablecreateaccounting.vo.CreateOtsLedgerListVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * AccountReceivableCreateAccountingBC Business Logic ServiceCommand 
 * - Handling AccountReceivableCreateAccountingBC Business transaction.
 * 
 * @author 
 * @see AccountReceivableCreateAccountingBCImpl
 * @since J2EE 1.6
 */ 	
public interface AccountReceivableCreateAccountingBC {

	/**
	 * @param String params
	 * @return String
	 * @throws EventException ...
	 */
	public String manageCreateOtsLedgerInfo(String params) throws EventException;
	
	/**
	 * Ledger OTS Creation<br>
     * 
     * @author YJLEE
     * @category STM_SAR_4003
     * @category searchCreateOtsLedgerList
     * @param CreateOtsLedgerListVO createOtsLedgerListVO       
     * @return List<CreateOtsLedgerListVO>
     * @throws EventException
     */    
	public List<CreateOtsLedgerListVO> searchCreateOtsLedgerList(CreateOtsLedgerListVO createOtsLedgerListVO) throws EventException;

	/**
	 * Ledger OTS Creation function currency<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_4003
	 * @category searchLedgerFunctionCurrency
	 * @param CreateOtsLedgerListVO createOtsLedgerListVO       
	 * @return String
	 * @throws EventException
	 */    
     public String searchLedgerFunctionCurrency(CreateOtsLedgerListVO createOtsLedgerListVO) throws EventException;
}
