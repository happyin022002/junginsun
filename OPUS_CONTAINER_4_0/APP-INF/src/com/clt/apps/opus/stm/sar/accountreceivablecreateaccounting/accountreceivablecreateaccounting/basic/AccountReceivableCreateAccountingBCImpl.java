/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : AccountReceivableCreateAccountingBCImpl.java
 *@FileTitle : AccountReceivableCreateAccountingBCImpl
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

import java.io.IOException;
import java.util.List;

import com.clt.apps.opus.stm.sar.accountreceivablecreateaccounting.accountreceivablecreateaccounting.vo.CreateOtsLedgerListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecreateaccounting.accountreceivablecreateaccounting.integration.AccountReceivableCreateAccountingDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 * AccountReceivableCreateAccountingBC Business Logic ServiceCommand 
 * - Handling AccountReceivableCreateAccountingBC Business transaction.
 * 
 * @author 
 * @see AccountReceivableCreateAccountingDBDAO
 * @since J2EE 1.6
 */ 	
public class AccountReceivableCreateAccountingBCImpl extends BasicCommandSupport implements AccountReceivableCreateAccountingBC {	

	AccountReceivableCreateAccountingDBDAO dbDao = null;

	/**
	 * AccountReceivableCreateAccountingBCImpl <br>
	 * AccountReceivableCreateAccountingDBDAO <br>
	 */
	public AccountReceivableCreateAccountingBCImpl() {
		dbDao = new AccountReceivableCreateAccountingDBDAO();
	}
	
	/**
	 * @param String params
	 * @return String
	 * @throws EventException ...
	 */
	public String manageCreateOtsLedgerInfo(String params) throws EventException {
		log.info(">>>> STM_SAR_B4003 : " + params);  
		ScheduleUtil su = new ScheduleUtil();
		try{
			su.directExecuteJob("STM_SAR_B4003", params); 
		} catch (IOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Ledger OTS Creation"}).getMessage(),e);
		} catch (InterruptedException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Ledger OTS Creation"}).getMessage(),e);
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Ledger OTS Creation"}).getMessage(),e);
		} catch (Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Ledger OTS Creation"}).getMessage(),e);
		}
		return "R";
	}
	
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
    public List<CreateOtsLedgerListVO> searchCreateOtsLedgerList(CreateOtsLedgerListVO createOtsLedgerListVO) throws EventException {
    	try {
    		 List<CreateOtsLedgerListVO> returnList = dbDao.searchCreateOtsLedgerList(createOtsLedgerListVO);
   		
    		 return returnList;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
    }    
    
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
    public String searchLedgerFunctionCurrency(CreateOtsLedgerListVO createOtsLedgerListVO) throws EventException {
    	try {
    		String sfunc = dbDao.searchLedgerFunctionCurrency();
   		
    		 return sfunc;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
    }
}