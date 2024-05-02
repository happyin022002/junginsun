/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : AccountReceivableCommonBCImpl.java
 *@FileTitle : AccountReceivableCommonBCImpl
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
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.basic;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PopSupplierListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration.AccountReceivableCommonDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.APPeriodVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARAcctListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARCustomerVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARExrateVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.AROfficeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARRhqListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARRhqOfficeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.AcctTypeVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ApOfficeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.BankListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.CreditCustomerVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.CurrencyCodeVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.MiscLimitCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.OfficeAddInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.OtsSourceExcludeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.PaymentLetterMDMInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.PaymentLetterTitVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.PopCustomerListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ReceiptBankListCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.RevAcctMatrixInfoCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.RevAcctMatrixInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.StmOfcInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROustandingbySADateVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterByEmailFaxVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration.StatementCommonDBDAO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.OfficeInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 * AccountReceivableCommonBCImpl Business Logic 
 * - Handling AccountReceivableCommonBCImpl Business transaction.
 * 
 * @author 
 * @see AccountReceivableCommonDBDAO
 * @since J2EE 1.6
 */ 	
public class AccountReceivableCommonBCImpl extends BasicCommandSupport implements AccountReceivableCommonBC {	

	// Database Access Object 
	private transient AccountReceivableCommonDBDAO dbDao = null;
	
	/**
	 * AccountReceivableCommonBCImpl object creation.<br>
	 * AccountReceivableCommonDBDAO creation.<br>
	 */
	public AccountReceivableCommonBCImpl() {
		
		dbDao = new AccountReceivableCommonDBDAO(); 
	}
	
	/**
	 * Search VVD exchange rate<br> 
	 * 
	 * @param ARExrateVO arExrateVO
	 * @return String
	 * @exception EventException
	 */
	public String searchVVDExrate(ARExrateVO arExrateVO) throws EventException{
	
		try {
			arExrateVO.setRvsFlg("N");
			String exrate = dbDao.searchVVDExrate(arExrateVO);
			
			if(exrate == null || exrate.equals("")){
				arExrateVO.setRvsFlg("Y");
				exrate = dbDao.searchVVDExrate(arExrateVO);
			}
			
			return exrate;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Individual exchange rate<br> 
	 * 
	 * @param ARExrateVO arExrateVO
	 * @return String
	 * @exception EventException
	 */
	public String searchIndExrate(ARExrateVO arExrateVO) throws EventException{
	
		try {
			arExrateVO.setRvsFlg("N");
			String exrate = dbDao.searchIndExrate(arExrateVO);
			
			if(exrate == null || exrate.equals("")){
				arExrateVO.setRvsFlg("Y");
				exrate = dbDao.searchIndExrate(arExrateVO);
			}
			
			return exrate;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Daily exchange rate<br> 
	 * 
	 * @param ARExrateVO arExrateVO
	 * @return String
	 * @exception EventException
	 */
	public String searchDailyExrate(ARExrateVO arExrateVO) throws EventException{
	
		try {
			arExrateVO.setRvsFlg("N");
			String exrate = dbDao.searchDailyExrate(arExrateVO);
			
			if(exrate == null || exrate.equals("")){
				arExrateVO.setRvsFlg("Y");
				exrate = dbDao.searchDailyExrate(arExrateVO);
			}
			
			return exrate;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Account exchange rate<br> 
	 * 
	 * @param ARExrateVO arExrateVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAccountExrate(ARExrateVO arExrateVO) throws EventException{
	
		try {
			arExrateVO.setRvsFlg("N");
			String exrate = dbDao.searchAccountExrate(arExrateVO);
			
			if(exrate == null || exrate.equals("")){
				arExrateVO.setRvsFlg("Y");
				exrate = dbDao.searchAccountExrate(arExrateVO);
			}
			
			return exrate;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Effective Date<br> 
	 * 
	 * @param String effDt
	 * @param String ofcCd
	 * @param String sysDivCd
	 * @return String
	 * @exception EventException
	 */
	public String searchEffectiveDate(String effDt, String ofcCd, String sysDivCd) throws EventException{
	
		try {
			return dbDao.searchEffectiveDate(effDt, ofcCd, sysDivCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Effective Date<br> 
	 * @author jinyoonoh 2014. 4. 30.
	 * @param String effDt
	 * @param String ofcCd
	 * @param String sysDivCd
	 * @param String arApDivCd
	 * @return String
	 * @throws EventException
	 */
	public String searchEffectiveDate(String effDt, String ofcCd, String sysDivCd, String arApDivCd) throws EventException {
	
		try {
			return dbDao.searchEffectiveDate(effDt, ofcCd, sysDivCd, arApDivCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}	
	

	
	/**
	 * Search Min Effective Date<br> 
	 * @author jinyoonoh 2014. 4. 30.
	 * @param String ofcCd
	 * @param String sysDivCd
	 * @param String arApDivCd
	 * @return String
	 * @exception EventException
	 */
	public String searchMinEffectiveDate(String ofcCd, String sysDivCd, String arApDivCd) throws EventException {
	
		try {
			return dbDao.searchMinEffectiveDate(ofcCd, sysDivCd, arApDivCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * Search Office in RHQ List<br> 
	 * 
	 * @param String usrRhqCd
	 * @return List<ARRhqOfficeListVO>
	 * @exception EventException
	 */
	public List<ARRhqOfficeListVO> searchARRhqOfficeList(String usrRhqCd) throws EventException{
		//ARRhqOfficeListVO arRhqOfficeListVO = null;
		List<ARRhqOfficeListVO> list = null;
		try {
			
			list = dbDao.searchARRhqOfficeList(usrRhqCd);			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search AR RHQ List<br> 
	 * 
	 * @param String usrRhqCd
	 * @return List<ARRhqListVO>
	 * @exception EventException
	 */
	public List<ARRhqListVO> searchARRhqList(String usrRhqCd) throws EventException{
		List<ARRhqListVO> list = null;
		try {
			
			list = dbDao.searchARRhqList(usrRhqCd);			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search AR Account List<br> 
	 * 
	 * @param String usrAcctCd
	 * @return List<ARAcctListVO>
	 * @exception EventException
	 */
	public List<ARAcctListVO> searchARAcctList(String usrAcctCd) throws EventException{
		List<ARAcctListVO> list = null;
		try {
			
			list = dbDao.searchARAcctList(usrAcctCd);			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search AR Office List<br> 
	 * 
	 * @param String usrOfcCd
	 * @return List<AROfficeListVO>
	 * @exception EventException
	 */
	public List<AROfficeListVO> searchAROfficeList(String usrOfcCd) throws EventException{
		return searchAROfficeList(usrOfcCd, "");
	}
	
	/**
	 * Search AR Office List<br> 
	 * @author jinyoonoh 2014. 4. 8. 
	 * @param String usrOfcCd
	 * @param String ofcLvlTp
	 * @return List<AROfficeListVO>
	 * @throws EventException
	 */
	public List<AROfficeListVO> searchAROfficeList(String usrOfcCd, String ofcLvlTp) throws EventException{
		return searchAROfficeList(usrOfcCd, ofcLvlTp, null);
	}	
	
	
	/**
	 * Search AR Office List<br>
	 * @author jinyoonoh 2014. 5. 9.
	 * @param String usrOfcCd
	 * @param String ofcLvlTp
	 * @param String ofcBrncAgnTpCd
	 * @return List<AROfficeListVO>
	 * @throws EventException
	 */
	public List<AROfficeListVO> searchAROfficeList(String usrOfcCd, String ofcLvlTp, String ofcBrncAgnTpCd) throws EventException{
		AROfficeListVO arOfficeListVO = null;
		List<AROfficeListVO> list = null;
		try { 
			arOfficeListVO = dbDao.searchOfficeInfo(usrOfcCd, ofcLvlTp);
			if (!StringUtils.isEmpty(ofcBrncAgnTpCd)) {
				arOfficeListVO.setOfcBrncAgnTpCd(ofcBrncAgnTpCd);
			}			
			list = dbDao.searchAROfficeList(arOfficeListVO);			
			return list; 
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Agent Office List<br> 
	 * 
	 * @param AROfficeListVO arOfficeListVO
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchAgentOffice(AROfficeListVO arOfficeListVO) throws EventException{
		
		try {
			List<String> list = dbDao.searchAgentOffice(arOfficeListVO);
			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	
	/**
	 * Search MDM Office & SCO Office	 
	 * @author jinyoonoh 2014. 7. 1.
	 * @param String ofcCd
	 * @return StmOfcInfoVO
	 * @throws EventException
	 */
	public StmOfcInfoVO searchStmOfcInfo(String ofcCd) throws EventException {		
		try {
			return dbDao.searchStmOfcInfo(ofcCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * Search Account Type List<br> 
	 * 
	 * @param String acctCtnt
	 * @param String acctCtnt2
	 * @param String acctCtnt3
	 * @param String acctCtnt4
	 * @param String ofcCd
	 * @return List<AcctTypeVO>
	 * @exception EventException
	 */
	public List<AcctTypeVO> searchAccountType(String acctCtnt, String acctCtnt2, String acctCtnt3, String acctCtnt4,String ofcCd) throws EventException{
		
		try {
			List<AcctTypeVO> list = dbDao.searchAccountType(acctCtnt, acctCtnt2, acctCtnt3, acctCtnt4,ofcCd);  //2014.08.19 add ofc_cd
			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search AR Customer List<br> 
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String custUseFlg
	 * @return ARCustomerVO
	 * @exception EventException
	 */
	public ARCustomerVO searchARCustomer(String custCntCd, String custSeq, String custUseFlg) throws EventException{
		
		try {
			ARCustomerVO arCustomerVO = dbDao.searchARCustomer(custCntCd, custSeq, custUseFlg);
			
			return arCustomerVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Local Time<br> 
	 * 
	 * @param String lOfcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalTime(String lOfcCd) throws EventException{
		
		try {
			String lclTime = dbDao.searchLocalTime(lOfcCd);
			
			return lclTime;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Local Time<br> 
	 * 
	 * @param String lOfcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalTimeYMDHMS(String lOfcCd) throws EventException{
		
		try {
			String lclTime = dbDao.searchLocalTimeYMDHMS(lOfcCd);
			
			return lclTime;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
     *  AP Office Code Popup <br>
     * 
     * @author SWJEON
     * @category STM_SAR_0001
     * @category searchPopAPOfficeList
     * @param String ofcCd   
     * @return List<ApOfficeListVO>
     * @throws EventException
     */     
    public List<ApOfficeListVO> searchPopAPOfficeList(String ofcCd) throws EventException {
    	try {
    		 List<ApOfficeListVO> returnList = dbDao.searchPopAPOfficeList(ofcCd);
   		
    		 return returnList;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
    }
    
    /**
     * Supplier Code Popup<br>
     * 
     * @author MCJung 2014.03.18
     * @category STM_SAR_0002
     * @category searchPopSupplierList
     * @param String vendorName       
     * @param String vendorCode       
     * @param String enableFlag       
     * @return List<PopSupplierListVO>
     * @throws EventException
     */
    public List<PopSupplierListVO> searchPopSupplierList(String vendorName, String vendorCode, String enableFlag) throws EventException {
    	try {
    		return dbDao.searchPopSupplierList(vendorName, vendorCode, enableFlag); 
   		    
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
    }
    
    /**
   	 * Search Bank List<br>
   	 * 
   	 * @param String rctTpCd
   	 * @param String rctOfcCd
   	 * @param String bankCtrlCd
   	 * @param String bankAcctNm
   	 * @param String localCurrCd
   	 * @return List<BankListVO>
   	 * @exception EventException
   	 */
	public List<BankListVO> searchBankList(String rctTpCd, String rctOfcCd, String bankCtrlCd, String bankAcctNm, String localCurrCd) throws EventException{
		
		try {
			List<BankListVO> list = dbDao.searchBankList(rctTpCd, rctOfcCd, bankCtrlCd, bankAcctNm, localCurrCd);
			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Receipt Bank List<br>
	 * 
	 * @param ReceiptBankListCondVO receiptBankListCondVO
	 * @return List<BankListVO>
	 * @exception EventException
	 */
	public List<BankListVO> searchReceiptBankList(ReceiptBankListCondVO receiptBankListCondVO) throws EventException{
		
		try {
			List<BankListVO> list = dbDao.searchReceiptBankList(receiptBankListCondVO);
			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Currency Code List<br>
	 * 
	 * @param String currCd
	 * @return List<CurrencyCodeVO>
	 * @exception EventException
	 */
	public List<CurrencyCodeVO> searchCurrencyCode(String currCd) throws EventException{
		
		try {
			List<CurrencyCodeVO> list = dbDao.searchCurrencyCode(currCd);
			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search New Adjust, Receipt No<br> 
	 * 
	 * @param String ajTjTpCd
	 * @param String ofcCd
	 * @param String usrId
	 * @param String lOfcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchAdjustReceiptNo(String ajTjTpCd, String ofcCd, String usrId, String lOfcCd) throws EventException{
		
		try {
			String lclTime = dbDao.searchLocalTime(lOfcCd);
			
			String adjustReceiptNo = dbDao.searchAdjustReceiptNo(ajTjTpCd, ofcCd, usrId, lOfcCd);
			
			if("".equals(adjustReceiptNo)){
				dbDao.addAdjustReceiptNo(ajTjTpCd, ofcCd, usrId, lOfcCd);
				
				adjustReceiptNo = ajTjTpCd + ofcCd + lclTime.substring(2, 8) + "00001";										
			}else{
				dbDao.modifyAdjustReceiptNo(ajTjTpCd, ofcCd, usrId, lOfcCd);				
			}
			return adjustReceiptNo;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search New Adjust, Receipt No<br> 
	 * 
	 * @param String ajTjTpCd
	 * @param String ofcCd
	 * @param String usrId
	 * @param String lOfcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchAdjustReceiptNoLocalChargeOffice(String ajTjTpCd, String ofcCd, String usrId, String lOfcCd) throws EventException{
		
		try {
			String adjustReceiptNo = dbDao.searchAdjustReceiptNoLocal(ajTjTpCd, ofcCd);
			log.debug("1. >>>>>>>>>> adjustReceiptNo : " + adjustReceiptNo);
			if("".equals(adjustReceiptNo)){
				dbDao.addAdjustReceiptNoLocal(ajTjTpCd, ofcCd, usrId, lOfcCd);
				adjustReceiptNo = dbDao.searchAdjustReceiptNoLocalNoLock(ajTjTpCd, ofcCd);
				log.debug("2. >>>>>>>>>> adjustReceiptNo : " + adjustReceiptNo); 
			}else{
				dbDao.modifyAdjustReceiptNoLocal(ajTjTpCd, ofcCd, usrId);				
			}
			
			return adjustReceiptNo;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
     * Retrieve Outstanding Source To Exclude<br>
     * 
     * @return List<OtsSourceExcludeListVO>
     * @throws EventException
     */    
    public List<OtsSourceExcludeListVO> searchOtsSourceExcludeList() throws EventException{
		List<OtsSourceExcludeListVO> list = null;
		try {
			list = dbDao.searchOtsSourceExcludeList();			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
    }
	
    /**
	 * Account Matrix<br>
     * 
     * @author hee jin Park
     * @category STM_SAR_4001
     * @category searchRevAcctMatrixInfo
     * @param RevAcctMatrixInfoCondVO revAcctMatrixInfoCondVO       
     * @return List<RevAcctMatrixInfoVO>
     * @throws EventException
     */ 
	 public List<RevAcctMatrixInfoVO> searchRevAcctMatrixInfo( RevAcctMatrixInfoCondVO revAcctMatrixInfoCondVO) throws EventException{
		
		try {
			
			List<RevAcctMatrixInfoVO> list = dbDao.searchRevAcctMatrixInfo(revAcctMatrixInfoCondVO);
			
			return list;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Account Matrix<br>
     * 
     * @author hee jin Park
     * @category STM_SAR_4001
     * @category manageRevAcctMatrixInfo
     * @param RevAcctMatrixInfoVO[] revAcctMatrixInfoVO       
     * @param SignOnUserAccount account       
     * @throws EventException
     */
  	 public void manageRevAcctMatrixInfo (RevAcctMatrixInfoVO[] revAcctMatrixInfoVO, SignOnUserAccount account)
            throws EventException { 
        try {
        	  
            for (int i = 0; i < revAcctMatrixInfoVO.length; i++) {
                if (revAcctMatrixInfoVO[i].getIbflag().equals("I")) {
                	revAcctMatrixInfoVO[i].setCreUsrId(account.getUsr_id()); 
                	revAcctMatrixInfoVO[i].setUpdUsrId(account.getUsr_id());
                	dbDao.insertRevAcctMatrixInfo(revAcctMatrixInfoVO[i]);
                } else if (revAcctMatrixInfoVO[i].getIbflag().equals("U")) {
                	revAcctMatrixInfoVO[i].setUpdUsrId(account.getUsr_id());
                    dbDao.modifyRevAcctMatrixInfo(revAcctMatrixInfoVO[i]);
                }
            }
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler(de).getMessage(), de);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler(de).getMessage(), de);
        }
    }
	 
	 
  	 /**
 	  * Account Type Code - Retrieve<br>
      * 
      * @param RevAcctMatrixInfoCondVO revAcctMatrixInfoCondVO 
      * @return List<RevAcctMatrixInfoVO>
      * @throws EventException
      */ 
     public List<RevAcctMatrixInfoVO> searchPopAccountTypeList(RevAcctMatrixInfoCondVO revAcctMatrixInfoCondVO) throws EventException{
		
		try {
			
			List<RevAcctMatrixInfoVO> list = dbDao.searchPopAccountTypeList(revAcctMatrixInfoCondVO);
			
			return list;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
    
    /**
 	 * Search Functional Currency<br>
 	 * 
 	 * @param String luTpCd
 	 * @return String
 	 * @exception DAOException
 	 */
 	public String searchFunctionalCurrency(String luTpCd) throws EventException{
 		try {
			return dbDao.searchFunctionalCurrency(luTpCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
 	}
 	
 	/**
	 * get G/L date 
	 * @author jinyoonoh 2014. 6. 12.
	 * @param String glDate
	 * @param String ofcCd
	 * @param String sysDivCd
	 * @param String arApDivCd
	 * @param String clzStsCd
	 * @return String
	 * @throws EventException
	 */
	public String getGlDate(String glDate, String ofcCd, String sysDivCd, String arApDivCd, String clzStsCd) throws EventException{
		try {
			
			if (glDate == null 
					|| StringUtils.isEmpty(ofcCd) 
					|| StringUtils.isEmpty(sysDivCd)
					|| StringUtils.isEmpty(arApDivCd)
					) {
				return null;
			}
					 
			// get max glDate			
			String effYrmon = glDate.substring(0,6);
						
			APPeriodVO vo = new APPeriodVO();
            vo.setSysDivCd(sysDivCd); 
			vo.setEffYrmon(effYrmon);
			vo.setOfcCd(ofcCd); 
			vo.setArApDivCd(arApDivCd);
			if (StringUtils.isEmpty(clzStsCd)) {
				vo.setClzStsCd("O"); //Open , Close
			} else {
				vo.setClzStsCd(clzStsCd); //Open , Close
			}
			
			List<APPeriodVO> list = dbDao.searchAPPreriod(vo);
			
			if (list == null || list.isEmpty()) {
				return null;
			}
			
			// opened min(g/l date)
			String yyyymm = list.get(0).getEffYrmon();
			// opened g/l date and same month
			if (yyyymm.equals(effYrmon)) {
				return glDate;
			}
			
			// opened min(g/l) date
			return yyyymm + "01";
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	} 	
	
	/**
	 * Search MDM Charge List<br> 
	 * 
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchMDMChargeList() throws EventException{
		
		try {
			List<String> list = dbDao.searchMDMChargeList();
			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Check MI/ML Limit Amount<br> 
	 * 
	 * @author sungyong park 2014.08.25
	 * @param MiscLimitCondVO miscLimitCondVO
	 * @return String
	 * @exception EventException
	 */
	public String checkMiscLimitAmount(MiscLimitCondVO miscLimitCondVO) throws EventException{
		
		StatementCommonDBDAO stmDao = new StatementCommonDBDAO();
		ARExrateVO arExrateVO = new ARExrateVO();
		String exrate = null;
		String chkMiscLmt = null;
		
		try {
			
			if("USD".equals(miscLimitCondVO.getMiscCurrCd())){
				exrate = "1";
			} else {
				arExrateVO.setXchRtDt(miscLimitCondVO.getMiscXchRtDt().replace("-", ""));
				arExrateVO.setChgCurrCd(miscLimitCondVO.getMiscCurrCd());
				arExrateVO.setLclCurrCd("USD");
			
				//Search Account Exchange Rate
				exrate = dbDao.searchAccountExrate(arExrateVO);
			}
			
			if(exrate == null || "".equals(exrate)){
				chkMiscLmt = "R";
			} else {
				//Search A/R Office Information
				List<OfficeInfoVO> ofcInfo = stmDao.searchOfficeInfo(miscLimitCondVO.getMiscOfcCd());
				
				if(("MI".equals(miscLimitCondVO.getMiscTpCd()) && "".equals(ofcInfo.get(0).getMiscIncmLmtAmt())) ||
				   ("ML".equals(miscLimitCondVO.getMiscTpCd()) && "".equals(ofcInfo.get(0).getMiscLssLmtAmt()))){
					chkMiscLmt = "X";
				} else {
					//Check MI/ML Limit Amount
					miscLimitCondVO.setMiscXchRt(exrate);
					chkMiscLmt = dbDao.checkMiscLimitAmount(miscLimitCondVO);
				}
			}
			
			return chkMiscLmt;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Search MDM for payment request Letter<br> 
	 * 
	 * @param PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO 
	 * @return PaymentLetterMDMInfoVO
	 * @exception EventException
	 */
	public PaymentLetterMDMInfoVO searchMDMinfo(PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO) throws EventException{
		
		try {
			PaymentLetterMDMInfoVO paymentLetterMDMInfoVO = dbDao.searchMDMinfo(paymentRequestLetterByEmailFaxVO);
			
			return paymentLetterMDMInfoVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search SCO_OFC_INFO for payment request Letter<br> 
	 * 
	 * @param PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO 
	 * @return PaymentLetterTitVO
	 * @exception EventException
	 */
	public PaymentLetterTitVO searchPaymentLetterTit(PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO) throws EventException{
		
		try {
			PaymentLetterTitVO paymentLetterTitVO = dbDao.searchPaymentLetterTit(paymentRequestLetterByEmailFaxVO);
			
			return paymentLetterTitVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Ctrl Office List<br>
	 * @param String usrOfcCd
	 * @param String ofcLvlTp
	 * @param String ofcBrncAgnTpCd
	 * @return List<AROfficeListVO>
	 * @throws EventException
	 */
	public List<AROfficeListVO> searchCtrlOfficeList(String usrOfcCd, String ofcLvlTp, String ofcBrncAgnTpCd) throws EventException{
		AROfficeListVO arOfficeListVO = null;
		List<AROfficeListVO> list = null;
		try { 
			arOfficeListVO = dbDao.searchOfficeInfo(usrOfcCd, ofcLvlTp);
			if (!StringUtils.isEmpty(ofcBrncAgnTpCd)) {
				arOfficeListVO.setOfcBrncAgnTpCd(ofcBrncAgnTpCd);
			}			
			list = dbDao.searchCtrlOfficeList(arOfficeListVO);			
			return list; 
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Control OfficeList By RepOtsOfcCd<br>
	 * @param String arOfcCd
	 * @param String otsCd
	 * @param String ctrlOfcCd
	 * @return List<AROfficeListVO>
	 * @throws EventException
	 */
	public List<AROfficeListVO> searchControlOfficeListByRep(String arOfcCd,String otsCd,String ctrlOfcCd) throws EventException{
		List<AROfficeListVO> list = null;
		try { 
			list = dbDao.searchControlOfficeListByRep(arOfcCd,otsCd,ctrlOfcCd);
			return list; 
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve event process<br>
	 * Basic information and credit information retrieve.<br>
	 * 
	 * @author Myoungsin park
	 * @param String country
	 * @param String cust
	 * @param String regNo
	 * @return CreditCustomerVO
	 * @exception EventException
	 */
	public CreditCustomerVO searchCreditCustomer(String country, String cust, String regNo) throws EventException {

		CreditCustomerVO creditCustomerVO = null;
		try {
			creditCustomerVO = dbDao.searchCreditCustomer(country, cust, regNo); 
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return creditCustomerVO;
	}
	
	/**
	 * Retrieve event process<br>
	 * Customer information retrieve.<br>
	 * 
	 * @author Myoungsin park
	 * @param String cntry
	 * @param String custNm
	 * @param String zipNo
	 * @param String chkNm
	 * @param String custRgstNo
	 * @return List<PopCustomerListVO>
	 * @exception EventException
	 */
	public List<PopCustomerListVO> searchPopCustomerList(String cntry, String custNm, String zipNo, String chkNm, String custRgstNo) throws EventException {
		int cnt = 0; 
		List<PopCustomerListVO> resultVOs = null;
		try {
			resultVOs = dbDao.searchPopCustomerList(cntry, custNm, zipNo, chkNm, custRgstNo);
			if (resultVOs.size() > 0) {
				resultVOs.get(0).setMaxRows(cnt);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return resultVOs;
	}
	
	/**
	 * Search AR Office List<br>
	 * @author jinyoonoh 2014. 5. 9.
	 * @param String usrOfcCd
	 * @param String ofcLvlTp
	 * @param String ofcBrncAgnTpCd
	 * @return List<AROfficeListVO>
	 * @throws EventException
	 */
	public List<AROfficeListVO> searchAROfficePlusRepList(String usrOfcCd, String ofcLvlTp, String ofcBrncAgnTpCd) throws EventException{
		AROfficeListVO arOfficeListVO = null;
		List<AROfficeListVO> list = null; 
		try { 
			arOfficeListVO = dbDao.searchOfficeInfo(usrOfcCd, ofcLvlTp);
			if (!StringUtils.isEmpty(ofcBrncAgnTpCd)) {
				arOfficeListVO.setOfcBrncAgnTpCd(ofcBrncAgnTpCd);
			}			
			list = dbDao.searchAROfficePlusRepList(arOfficeListVO); 		
			return list; 
		} catch (DAOException ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
     * Pgm Run<br>
     * @author myoungsin park
     * @category STM_SAR_9999
     * @category Pgm Run
     * @param String ym       
     * @return String
     * @throws EventException
     */   
    public String createExchangeRate(String ym) throws EventException {
    	String batResult = "";
    	try{  
    		  String ymd = dbDao.searchAcctXchRtDt(ym);	
    		  if(ymd == null || ymd.equals("")){ 
    			  throw new EventException(new ErrorHandler("COM12213", new String[]{"Not Exist If data"}).getMessage());
    		  } 
    		  batResult = ymd;
	          ScheduleUtil su = new ScheduleUtil(); 
	          su.directExecuteJob("STM_SCO_B001", ymd); 
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"STM_SCO_B001"}).getMessage(),e);
		} catch (Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"STM_SCO_B001"}).getMessage(),e);
		} 
		return batResult;
    }
    
    /**
     * Pgm Run<br>
     * @author myoungsin park
     * @category STM_SAR_9999
     * @category Pgm Run
     * @param String rhqOfcCd       
     * @param String ofcCd       
     * @return String
     * @throws EventException
     */   
    public String createZeroBalance(String rhqOfcCd,String ofcCd) throws EventException {
    	String param = "";
    	try{  
    		if(rhqOfcCd.isEmpty() && ofcCd.isEmpty()){
    			param = "ALL";
    		} else {
    			if(!ofcCd.isEmpty()){
    				param = "XXX" + "#" + ofcCd;
    			} else {
    				param = rhqOfcCd;
    			}
    		}
    		 
    		ScheduleUtil su = new ScheduleUtil(); 
    		log.debug(">>>>>>>>>>>>>> STM_SCO_B002 :" + param); 
    		su.directExecuteJob("STM_SCO_B002", param);  
    	} catch (DAOException e) {
    		log.error("err "+e.toString(),e);
    		throw new EventException(new ErrorHandler("COM12213", new String[]{"STM_SCO_B002"}).getMessage(),e);
    	} catch (Exception e){
    		log.error("err "+e.toString(),e);
    		throw new EventException(new ErrorHandler("COM12213", new String[]{"STM_SCO_B002"}).getMessage(),e);
    	} 
    	return param;
    }
    
    /**
  	 * Search addtional Office info<br> 
  	 * 
  	 * @param String ofcCd
  	 * @return OfficeAddInfoVO
  	 * @exception EventException
  	 */
	public OfficeAddInfoVO searchIsHiddenInoice(String ofcCd) throws EventException {		
		try {
			return dbDao.searchIsHiddenInoice(ofcCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
    /**
  	 * Search Login User's Office Type Code<br> 
  	 * 
  	 * @param String ofcCd
  	 * @return String
  	 * @exception EventException
  	 */
	public String searchLoginUserOfcType(String ofcCd) throws EventException {		
		try {
			return dbDao.searchLoginUserOfcType(ofcCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * Search Login User's E-mail address<br> 
	 * 
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String searchLoginUserEml(String usrId) throws EventException {		
		try {
			return dbDao.searchLoginUserEml(usrId);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}	
		
}
