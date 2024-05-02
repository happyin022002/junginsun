/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : AccountReceivableCommonBC.java
 *@FileTitle : AccountReceivableCommonBC
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

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PopSupplierListVO;
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
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterByEmailFaxVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * AccountReceivableCommonBC Business Logic 
 * - Handling AccountReceivableCommonBC Business transaction.
 * 
 * @author 
 * @see AccountReceivableCommonBCImpl
 * @since J2EE 1.6
 */ 	
public interface AccountReceivableCommonBC {
	
	/**
	 * Search VVD exchange rate<br> 
	 * 
	 * @param ARExrateVO arExrateVO
	 * @return String
	 * @exception EventException
	 */
	public String searchVVDExrate(ARExrateVO arExrateVO) throws EventException;
	
	/**
	 * Search Individual exchange rate<br> 
	 * 
	 * @param ARExrateVO arExrateVO
	 * @return String
	 * @exception EventException
	 */
	public String searchIndExrate(ARExrateVO arExrateVO) throws EventException;
	
	/**
	 * Search Daily exchange rate<br> 
	 * 
	 * @param ARExrateVO arExrateVO
	 * @return String
	 * @exception EventException
	 */
	public String searchDailyExrate(ARExrateVO arExrateVO) throws EventException;
	
	/**
	 * Search Account exchange rate<br> 
	 * 
	 * @param ARExrateVO arExrateVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAccountExrate(ARExrateVO arExrateVO) throws EventException;
	
	/**
	 * Search Effective Date<br> 
	 * 
	 * @param String effDt
	 * @param String ofcCd
	 * @param String sysDivCd
	 * @return String
	 * @exception EventException
	 */
	public String searchEffectiveDate(String effDt, String ofcCd, String sysDivCd) throws EventException;
	
	
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
	public String searchEffectiveDate(String effDt, String ofcCd, String sysDivCd, String arApDivCd) throws EventException;	
	
	/**
	 * Search Min Effective Date<br> 
	 * @author jinyoonoh 2014. 4. 30.
	 * @param String ofcCd
	 * @param String sysDivCd
	 * @param String arApDivCd
	 * @return String
	 * @exception EventException
	 */
	public String searchMinEffectiveDate(String ofcCd, String sysDivCd, String arApDivCd) throws EventException;
	
	/**
	 * Search Office in RHQ List<br> 
	 * 
	 * @param String usrRhqCd
	 * @return List<ARRhqOfficeListVO>
	 * @exception EventException
	 */
	public List<ARRhqOfficeListVO> searchARRhqOfficeList(String usrRhqCd) throws EventException;
	
	/**
	 * Search AR RHQ List<br> 
	 * 
	 * @param String usrRhqCd
	 * @return List<ARRhqListVO>
	 * @exception EventException
	 */
	public List<ARRhqListVO> searchARRhqList(String usrRhqCd) throws EventException;
	
	/**
	 * Search AR Account List<br> 
	 * 
	 * @param String usrAcctCd
	 * @return List<ARAcctListVO>
	 * @exception EventException
	 */
	public List<ARAcctListVO> searchARAcctList(String usrAcctCd) throws EventException;
	
	/**
	 * Search AR Office List<br> 
	 * 
	 * @param String usrOfcCd
	 * @return List<AROfficeListVO>
	 * @exception EventException
	 */
	public List<AROfficeListVO> searchAROfficeList(String usrOfcCd) throws EventException;
	
	/**
	 * Search MDM Office & SCO Office	 
	 * @author jinyoonoh 2014. 7. 1.
	 * @param String ofcCd
	 * @return StmOfcInfoVO
	 * @throws EventException
	 */
	public StmOfcInfoVO searchStmOfcInfo(String ofcCd) throws EventException;		

	/**
	 * Search AR Office List<br> 
	 * @author jinyoonoh 2014. 4. 8. 
	 * @param String usrOfcCd
	 * @param String ofcLvlTp
	 * @return List<AROfficeListVO>
	 * @throws EventException
	 */
	public List<AROfficeListVO> searchAROfficeList(String usrOfcCd, String ofcLvlTp) throws EventException;	
	
	/**
	 * Search AR Office List<br>
	 * @author jinyoonoh 2014. 5. 9.
	 * @param String usrOfcCd
	 * @param String ofcLvlTp
	 * @param String ofcBrncAgnTpCd
	 * @return List<AROfficeListVO>
	 * @throws EventException
	 */
	public List<AROfficeListVO> searchAROfficeList(String usrOfcCd, String ofcLvlTp, String ofcBrncAgnTpCd) throws EventException;	
	/**
	 * Search Agent Office List<br> 
	 * 
	 * @param AROfficeListVO arOfficeListVO
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchAgentOffice(AROfficeListVO arOfficeListVO) throws EventException;
	
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
	public List<AcctTypeVO> searchAccountType(String acctCtnt, String acctCtnt2, String acctCtnt3, String acctCtnt4, String ofcCd) throws EventException;
	
	/**
	 * Search AR Customer List<br> 
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String custUseFlg
	 * @return ARCustomerVO
	 * @exception EventException
	 */
	public ARCustomerVO searchARCustomer(String custCntCd, String custSeq, String custUseFlg) throws EventException;
	
	/**
	 * Search Local Time<br> 
	 * 
	 * @param String lOfcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalTime(String lOfcCd) throws EventException;
	
	
	/**
	 * Search Local Time<br> 
	 * 
	 * @param String lOfcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalTimeYMDHMS(String lOfcCd) throws EventException;
	
	
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
    public List<ApOfficeListVO> searchPopAPOfficeList(String ofcCd) throws EventException;
    
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
    public List<PopSupplierListVO> searchPopSupplierList(String vendorName, String vendorCode, String enableFlag) throws EventException;
    
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
	public List<BankListVO> searchBankList(String rctTpCd, String rctOfcCd, String bankCtrlCd, String bankAcctNm, String localCurrCd) throws EventException;
	
	/**
	 * Search Receipt Bank List<br>
	 * 
	 * @param ReceiptBankListCondVO receiptBankListCondVO
	 * @return List<BankListVO>
	 * @exception EventException
	 */
	public List<BankListVO> searchReceiptBankList(ReceiptBankListCondVO receiptBankListCondVO) throws EventException;
	
	/**
	 * Search Currency Code List<br>
	 * 
	 * @param String currCd
	 * @return List<CurrencyCodeVO>
	 * @exception EventException
	 */
	public List<CurrencyCodeVO> searchCurrencyCode(String currCd) throws EventException;
	
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
	public String searchAdjustReceiptNo(String ajTjTpCd, String ofcCd, String usrId, String lOfcCd) throws EventException;
	
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
	public String searchAdjustReceiptNoLocalChargeOffice(String ajTjTpCd, String ofcCd, String usrId, String lOfcCd) throws EventException;	
	
	/**
     * Retrieve Outstanding Source To Exclude<br>
     * 
     * @return List<OtsSourceExcludeListVO>
     * @throws EventException
     */    
    public List<OtsSourceExcludeListVO> searchOtsSourceExcludeList() throws EventException;
	
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
    public List<RevAcctMatrixInfoVO> searchRevAcctMatrixInfo( RevAcctMatrixInfoCondVO revAcctMatrixInfoCondVO) throws EventException ;	
    
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
	public void manageRevAcctMatrixInfo(RevAcctMatrixInfoVO[] revAcctMatrixInfoVO, SignOnUserAccount account) throws EventException;  	
    
    /**
	 * Account Type Code - Retrieve<br>
     * 
     * @param RevAcctMatrixInfoCondVO revAcctMatrixInfoCondVO 
     * @return List<RevAcctMatrixInfoVO>
     * @throws EventException
     */ 
    public List<RevAcctMatrixInfoVO> searchPopAccountTypeList(RevAcctMatrixInfoCondVO revAcctMatrixInfoCondVO) throws EventException ;
        
    /**
	 * Search Functional Currency<br>
	 * 
	 * @param String luTpCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchFunctionalCurrency(String luTpCd) throws EventException;
	
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
	public String getGlDate(String glDate, String ofcCd, String sysDivCd, String arApDivCd, String clzStsCd) throws EventException;	
	
	/**
	 * Search MDM Charge List<br> 
	 * 
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchMDMChargeList() throws EventException;
	
	/**
	 * Check MI/ML Limit Amount<br> 
	 * 
	 * @author sungyong park 2014.08.25
	 * @param MiscLimitCondVO miscLimitCondVO
	 * @return String
	 * @exception EventException
	 */
	public String checkMiscLimitAmount(MiscLimitCondVO miscLimitCondVO) throws EventException;
	
	/**
	 * Search MDM for payment request Letter<br> 
	 * 
	 * @param PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO 
	 * @return PaymentLetterMDMInfoVO
	 * @exception EventException
	 */
	public PaymentLetterMDMInfoVO searchMDMinfo(PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO) throws EventException;
	
	/**
	 * Search SCO_OFC_INFO for payment request Letter<br> 
	 * 
	 * @param PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO 
	 * @return PaymentLetterTitVO
	 * @exception EventException
	 */
	public PaymentLetterTitVO searchPaymentLetterTit(PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO) throws EventException;
	
	/**
	 * Search Ctrl Office List<br>
	 * @param String usrOfcCd
	 * @param String ofcLvlTp
	 * @param String ofcBrncAgnTpCd
	 * @return List<AROfficeListVO>
	 * @throws EventException
	 */
	public List<AROfficeListVO> searchCtrlOfficeList(String usrOfcCd, String ofcLvlTp, String ofcBrncAgnTpCd) throws EventException;
	
	/**
	 * Search Control OfficeList By RepOtsOfcCd<br>
	 * @param String arOfcCd
	 * @param String otsCd
	 * @param String ctrlOfcCd
	 * @return List<AROfficeListVO>
	 * @throws EventException
	 */
	public List<AROfficeListVO> searchControlOfficeListByRep(String arOfcCd,String otsCd,String ctrlOfcCd) throws EventException;
	
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
	public CreditCustomerVO searchCreditCustomer(String country, String cust, String regNo) throws EventException;
	
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
	public List<PopCustomerListVO> searchPopCustomerList(String cntry, String custNm, String zipNo, String chkNm, String custRgstNo) throws EventException;
	
	/**
	 * Search AR Office List<br>
	 * @author jinyoonoh 2014. 5. 9.
	 * @param String usrOfcCd
	 * @param String ofcLvlTp
	 * @param String ofcBrncAgnTpCd
	 * @return List<AROfficeListVO>
	 * @throws EventException
	 */
	public List<AROfficeListVO> searchAROfficePlusRepList(String usrOfcCd, String ofcLvlTp, String ofcBrncAgnTpCd) throws EventException;
	
	/**
     * Pgm Run<br>
     * @author myoungsin park
     * @category STM_SAR_9999
     * @category Pgm Run
     * @param String ym       
     * @return String
     * @throws EventException
     */    
    public String createExchangeRate(String ym) throws EventException;
    
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
    public String createZeroBalance(String rhqOfcCd,String ofcCd) throws EventException;
    
    /**
  	 * Search addtional Office info<br> 
  	 * 
  	 * @param String ofcCd
  	 * @return OfficeAddInfoVO
  	 * @exception EventException
  	 */
  	public OfficeAddInfoVO searchIsHiddenInoice(String ofcCd) throws EventException;
  	
    /**
  	 * Search Login User's Office Type Code<br> 
  	 * 
  	 * @param String ofcCd
  	 * @return String
  	 * @exception EventException
  	 */
	public String searchLoginUserOfcType(String ofcCd) throws EventException;  	
	
	/**
	 * Search Login User's E-mail address<br> 
	 * 
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String searchLoginUserEml(String usrId) throws EventException;
  	
}
