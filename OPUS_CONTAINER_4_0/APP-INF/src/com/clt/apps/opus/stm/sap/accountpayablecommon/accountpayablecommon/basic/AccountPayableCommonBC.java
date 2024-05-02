/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonBC.java
*@FileTitle : AccountPayableCommonBC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.14
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.basic;

import java.util.List;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.APBankAccountByOfficeCondVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.APBankAccountByOfficeVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.ApCSRNoListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.ApOfficeListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.ApPayBatchNameListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.ApSupplierRegisterListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankAccountInfoListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankAccountListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankAccountSupplierListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankBranchVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankNameListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.CardBrandListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.CenterListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.CreditCardListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.CreditCardMasterListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.FinanceOfficeListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.InterCompanyListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.InternalBankAcctVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.InvoiceTypeListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.MdmCurrencyVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PaymentMethodListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PopPayGroupListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PopPayInvoiceInfomationListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.RegionListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SourceListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SupplierBankAccountListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.TermsListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.UnsettledAccountListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PopSupplierListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PopAccountListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.CompanyListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.VVDListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.LocationListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.WorkPlacesListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.TaxCodeVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.APVendorInfoVO;

import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * AccountPayableCommon Business Logic implementation 
 * 
 * @author 
 * @see AccountPayableCommonSC
 * @since J2EE 1.6
 */ 

public interface AccountPayableCommonBC {
	

	/**
	 * COMMON : searchOfcCdByUserId<br>
	 * 
	 * @param String usr_id
	 * @param String ofc_cd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchOfcCdByUserId(String usr_id, String ofc_cd)  throws EventException;

	/**
	 * COMMON : searchLocalTime <br>
	 *
	 * @param String usr_id
	 * @param String ofc_cd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalTime(String usr_id, String ofc_cd) throws EventException;
	
	
	/**
	 * [STM_SAP_0010]
	 * searchExchangeRateCheck <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return List<SapCommonVO> 
	 * @exception EventException
	*/	 
	public List<SapCommonVO> searchExchangeRateCheck(SapCommonVO sapCommonVO) throws EventException;
	
	
	/**
	 * COMMON : searchGLDatePeriodCheck <br>
	 * 
	 * @param String gl_dt
	 * @param String ofc_cd 
	 * @return String
	 * @exception EventException
	*/
	public String searchGLDatePeriodCheck(String gl_dt, String ofc_cd) throws EventException;
	
	/**
	 * COMMON : searchInvoicesGLDatePeriodCheck <br>
	 * 
	 * @param String gl_dt
	 * @param String ofc_cd 
	 * @return String
	 * @exception EventException
	*/
	public String searchInvoicesGLDatePeriodCheck(String gl_dt, String ofc_cd) throws EventException;

	/**
	 * COMMON : searchGLDateAPPeriodCheck <br>
	 * 
	 * @param String gl_dt
	 * @return String
	 * @exception EventException
	*/
	public String searchGLDateAPPeriodCheck(String gl_dt) throws EventException;
	
	/**
	 * COMMON : searchFunctionalCurrencyCode<br>
	 *
	 * @return List<SapCommonVO>
	 * @exception EventException
	 */
    public List<SapCommonVO> searchFunctionalCurrencyCode() throws EventException;	
    
    /**
	 * COMMON : searchAPLineServiceLaneCheck<br>
	 *
	 * @param String vvd
	 * @return String
	 * @exception EventException
	 */
    public String searchAPLineServiceLaneCheck(String vvd) throws EventException;
    
	/**
	 * COMMON : searchCurrencyCode<br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return List<MdmCurrencyVO> 
	 * @exception EventException
	*/
	public List<MdmCurrencyVO> searchCurrencyCode(SapCommonVO sapCommonVO) throws EventException; 
	
	/**
	 *  [STM_SAP_0023] searchPopLocationList <br>
	 * 
	 * @param LocationListVO locationListVO
	 * @return List<LocationListVO> 
	 * @exception EventException
	*/
	public List<LocationListVO> searchPopLocationList(LocationListVO locationListVO) throws EventException; 	
 
	
	/**
	 *  [STM_SAP_0010] [STM_SAP_0240] searchTaxCodeList<br>
	 * 
	 * @param TaxCodeVO taxCodeVO
	 * @return List<TaxCodeVO> 
	 * @exception EventException
	*/
	public List<TaxCodeVO> searchTaxCodeList(TaxCodeVO taxCodeVO) throws EventException; 
	
	/**
	 * searchOffValiInfo <br>
	 * 
	 * @param String ofc_cd
	 * @param String securityFlag
	 * @param SignOnUserAccount account
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchOffValiInfo(String ofc_cd, String securityFlag, SignOnUserAccount account) throws EventException;	
	
	/**
	 * searchInvoiceActivityPlaceCheck <br>
	 * 
	 * @param String activity_place
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchInvoiceActivityPlaceCheck(String activity_place) throws EventException;
	
	/**
	 * searchInvoiceServiceLaneCheck <br>
	 * 
	 * @param String service_lane_cd
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchInvoiceServiceLaneCheck(String service_lane_cd) throws EventException;
	
	/**
	 * searchSupplierInfo <br>
	 * 
	 * @param String vndr_seq
	 * @param String vndr_lgl_eng_nm
	 * @param String delt_flg
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchSupplierInfo(String vndr_seq, String vndr_lgl_eng_nm, String delt_flg) throws EventException;		
	
	/**
	 * searchBankAccountCheck <br>
	 *
     * @param String bank_acct_nm
     * @param String bank_acct_no
     * @param String ofc_cd
     * @return List<BankAccountInfoListVO>
     * @exception EventException
     */    
    public List<BankAccountInfoListVO> searchBankAccountCheck(String bank_acct_nm, String bank_acct_no, String ofc_cd) throws EventException; 
	
	/**
	 * [STM_SAP_0350]
	 * searchAPVendorInfoList <br>
	 *
     * @param String vndr_no
     * @param String vndr_nm
     * @return List<APVendorInfoVO>
     * @exception EventException
     */    
    public List<APVendorInfoVO> searchAPVendorInfoList(String vndr_no, String vndr_nm) throws EventException; 
    
	/**
	 * [STM_SAP_0350]
	 * manageAPVendorInfoList <br>
	 *
     * @param APVendorInfoVO[] APVendorInfoVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */    
    public void manageAPVendorInfoList(APVendorInfoVO[] APVendorInfoVOs, SignOnUserAccount account) throws EventException; 
	
	/**
	 * [STM_SAP_0100] Retrieve
	 * Bank Account Inquiry <br>
	 * 
	 * @param APBankAccountByOfficeCondVO apBankAccountByOfficeCondVO
	 * @return List<APBankAccountByOfficeVO>
	 * @exception EventException
	*/
	public List<APBankAccountByOfficeVO> searchBankAccountByOffice(APBankAccountByOfficeCondVO apBankAccountByOfficeCondVO) throws EventException; 	
   

	/**
	 * [STM_SAP_0032] Retrieve
	 * Supplier Bank Account Popup <br>
	 * 
	 * @param String vendorCode
	 * @param String invoiceCurrency
	 * @param String bankAcctTpNm 
	 * @param String callFlag 
	 * @param String vendorName
	 * @return List<SupplierBankAccountListVO>
	 * @exception EventException
	*/
	public List<SupplierBankAccountListVO> searchPopSupplierBankAccountList(String vendorCode, String invoiceCurrency, String bankAcctTpNm, String callFlag, String vendorName) throws EventException;
	
	/**
     * [STM_SAP_0310] Retrieve
     * Create Credit Card<br>
     * 
     * @param  String crdSeq
     * @param  String crdNo
     * @return List<CreditCardMasterListVO>
     * @exception EventException
     */    
    public List<CreditCardMasterListVO> searchCreditCardMasterList(String crdSeq, String crdNo) throws EventException;
	
    /**
     * [STM_SAP_0310]
     * Create Credit Card - Save <br>
     * 
     * @param  CreditCardMasterListVO creditCardMasterListVO
     * @param  String usrId
     * @return String
     * @exception EventException
     */   
 	public String manageCreditCardEntryInfo(CreditCardMasterListVO creditCardMasterListVO, String usrId) throws EventException;
	
	/**
     * [STM_SAP_0500] Retrieve
     * Finance Office Code Popup<br>
     * 
     * @param  String ofcTp
     * @param  String ofcCd
     * @return List<FinanceOfficeListVO>
     * @exception EventException
     */    
    public List<FinanceOfficeListVO> searchPopFinanceOfficeList(String ofcTp, String ofcCd) throws EventException;
    
    /**
     * [STM_SAP_0510] Retrieve
     * Internal Bank Account Popup<br>
     * 
     * @param  String ofc_cd
     * @param  String ofc_type
     * @param  String inactive_type
     * @param  String bank_acct_no
     * @return List<InternalBankAcctVO>
     * @exception EventException
     */    
    public List<InternalBankAcctVO> searchPopInternalBankAcctList(String ofc_cd, String ofc_type, String inactive_type, String bank_acct_no) throws EventException;
	
	
	/**
     * Card Brand Popup 내역 조회<br>
     * 
     * @param  String lu_cd   
     * @return List<CardBrandListVO>
     * @exception EventException
     */    
    public List<CardBrandListVO> searchPopCardBrandList(String lu_cd) throws EventException;
    

    
    /**
     * [STM_SAP_0003]
     * Invoice Number 조회<br>
     * 
     * @param ApCSRNoListVO apCSRNoListVO
     * @return List<ApCSRNoListVO>
     * @exception EventException
     */    
    public List<ApCSRNoListVO> searchPopCSRNoList(ApCSRNoListVO apCSRNoListVO) throws EventException;
    
    /**
     * Unsettled Summary 에 존재하는 월별 미결 내역 조회<br>
     * 
     * @param  String vendorName 
     * @return List<PopSupplierListVO>
     * @exception EventException
     */    
    public List<PopSupplierListVO> searchPopSupplierList(String vendorName) throws EventException;
    
    /**
     * 조건을 기준으로 Lookup에 등록된 Source 정보 조회<br>
     * 
     * @param String source      
     * @return List<SourceListVO>
     * @exception EventException
     */    
    public List<SourceListVO> searchPopSourceList(String source) throws EventException;
    
    /**
     * 조건을 기준으로 Lookup에 등록된 발행거래처 정보 조회<br>
     * 
     * @param String registerNo    
     * @return List<ApSupplierRegisterListVO>
     * @exception EventException
     */    
    public List<ApSupplierRegisterListVO> searchPopSupplierRegisterList(String registerNo) throws EventException;

    /**
     * [STM_SAP_0009]
     * Invoice Type 조회<br>
     * 
     * @param InvoiceTypeListVO invoiceTypeListVO
     * @return List<InvoiceTypeListVO>
     * @exception EventException
     */    
    public List<InvoiceTypeListVO> searchPopInvoiceTypeList(InvoiceTypeListVO invoiceTypeListVO) throws EventException;

    /**
     * [STM_SAP_0033]
     * Terms List 조회<br>
     * 
     * @param TermsListVO termsListVO
     * @return List<TermsListVO>
     * @exception EventException
     */    
    public List<TermsListVO> searchPopTermsListVO(TermsListVO termsListVO) throws EventException; 
    
    /**
     * [STM_SAP_0440]
     * Cenetr List Popup<br>
     * 
     * @param CenterListVO centerListVO
     * @return List<CenterListVO>
     * @exception EventException
     */    
    public List<CenterListVO> searchPopCenterListVO(CenterListVO centerListVO) throws EventException ;

    /**
     * [STM_SAP_0460]
     * Inter Company List Popup<br>
     * 
     * @param InterCompanyListVO interCompanyListVO  
     * @return List<InterCompanyListVO>
     * @exception EventException
     */    
    public List<InterCompanyListVO> searchPopInterCompanyListVO(InterCompanyListVO interCompanyListVO) throws EventException ;    

    /**
     *  AP Office Code Popup <br>
     * 
     * @param String ofcCd
     * @param String security_flag
     * @param SignOnUserAccount account
     * @return List<ApOfficeListVO>
     * @exception EventException
     */    
    public List<ApOfficeListVO> searchPopAPOfficeList(String ofcCd, String security_flag, SignOnUserAccount account) throws EventException;
    
    /**
     *  AR Office Code Popup <br>
     * 
     * @param String ofcCd
     * @param String security_flag
     * @param SignOnUserAccount account   
     * @return List<ApOfficeListVO>
     * @exception EventException
     */    
    public List<ApOfficeListVO> searchPopAROfficeList(String ofcCd, String security_flag, SignOnUserAccount account) throws EventException;


    /**
     * [STM_SAP_0007] Payment Method Popup<br>
     * 
     * @param String luCd
     * @return List<PaymentMethodListVO>
     * @exception EventException
     */    
    public List<PaymentMethodListVO> searchPopPaymentMethodList(String luCd) throws EventException;

    /**
     * [STM_SAP_0230] Bank Name Popup<br>
     * 
     * @param String bankNm
     * @return List<BankNameListVO>
     * @exception EventException
     */
    public List<BankNameListVO> searchPopBankNameList(String bankNm) throws EventException;    

    /**
     * [STM_SAP_0341] Unsettled Account Popup<br>
     * 
     * @param String luCd
     * @return List<UnsettledAccountListVO>
     * @exception EventException
     */
    public List<UnsettledAccountListVO> searchPopUnsettledAccountList(String luCd) throws EventException;

    /**
     * [STM_SAP_0311]
     * Credit Card Search list<br>
     * 
     * @param CreditCardListVO creditCardListVO
     * @return List<CreditCardListVO> 
     * @exception EventException
     */    
    public List<CreditCardListVO> searchCreditCardList(CreditCardListVO creditCardListVO) throws EventException; 


	 /**
     * [STM_SAP_0004] Pay Group Popup - Retrieve <br>	
     * 	
     * @param String luCd
     * @param String attr_ctnt1
     * @return List<PopPayGroupListVO>
     * @exception EventException	
     */    	
    public List<PopPayGroupListVO> searchPopPayGroupList(String luCd, String attr_ctnt1) throws EventException;	
    	
	 /**
     * [STM_SAP_0034] WorkPlaces Popup - Retrieve <br>	
     * 	
     * @param String luCd
     * @return List<WorkPlacesListVO>	
     * @exception EventException	
     */    	
    public List<WorkPlacesListVO> searchPopWorkPlacesList(String luCd) throws EventException;	
    
    /**
     * [STM_SAP_0430] Region Popup - Retrieve <br>	
     * 	
     * @param String luCd
     * @return List<RegionListVO>	
     * @exception EventException	
     */    	
    public List<RegionListVO> searchPopRegionList(String luCd) throws EventException;	
    
    /**
     * [STM_SAP_0211]
     * Payment Batch Name List 조회<br>
     * 
     * @param String payBatNm
     * @param String payFromDate
     * @param String payToDate
     * @return List<ApPayBatchNameListVO>
     * @exception EventException
     */    
    public List<ApPayBatchNameListVO> searchPopPayBatchNameList(String payBatNm, String payFromDate, String payToDate) throws EventException; 

       
    /**
     * [STM_SAP_0002] Supplier Code Popup<br>
     * 
     * @param String vendorName
     * @param String vendorCode
     * @param String enableFlag  
     * @return List<PopSupplierListVO>
     * @exception EventException
     */    
    public List<PopSupplierListVO> searchPopSupplierList(String vendorName, String vendorCode, String enableFlag) throws EventException;
    
    /**
     * [STM_SAP_0420] Company Popup<br>
     * 
     * @param String companyCode
     * @return List<CompanyListVO>
     * @exception EventException
     */   
    public List<CompanyListVO> searchPopCompanyList(String companyCode) throws EventException;
    
    /**
     * [STM_SAP_0450] Account Popup<br>
     * 
     * @param String accountCode
     * @param String accountType
     * @param String unsettledFlag
     * @param String lineType
     * @param String acctNm
     * @return List<PopAccountListVO>
     * @exception EventException
     */    
    public List<PopAccountListVO> searchPopAccountList(String accountCode, String accountType, String unsettledFlag, String lineType, String acctNm) throws EventException;    

    /**
     * [STM_SAP_0470]
     * VVD List 조회<br>
     * 
     * @param String vvd_cd 
     * @param String vvd_type  
     * @param String acct_cd
     * @return List<VVDListVO>
     * @exception EventException
     */    
    public List<VVDListVO> searchPopVVDList(String vvd_cd, String vvd_type, String acct_cd) throws EventException; 
    
    /**
     * [STM_SAP_0063]
     * Bank Account Information List 조회<br>
     * 
     * @param String bank_acct_nm
     * @param String bank_acct_no
     * @param String ofc_cd
     * @param String bank_acct_tp_nm
     * @param String acct_tp_cd
     * @return List<BankAccountInfoListVO>
     * @exception EventException
     */    
    public List<BankAccountInfoListVO> searchPopBankAccountInfoList(String bank_acct_nm, String bank_acct_no, String ofc_cd, String bank_acct_tp_nm, String acct_tp_cd) throws EventException; 
    
    
    /**
     * [STM_SAP_0080]
     * Bank Branch 등록<br>
     * 
     * @param BankBranchVO bankBranchVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */  
	public String manageBankBranchEntry(BankBranchVO bankBranchVO, SignOnUserAccount account) throws EventException;    
    
    /**
     * [STM_SAP_0080]
     * Bank Branch 조회<br>
     * 
     * @param BankBranchVO bankBranchVO
     * @return List<BankBranchVO>
     * @exception EventException
     */    
    public List<BankBranchVO> searchBankBranchList(BankBranchVO bankBranchVO) throws EventException; 
    
    /**
     * [STM_SAP_0081]
     * Bank Branch Code list 조회<br>
     * 
     * @param BankBranchVO bankBranchVO
     * @return List<BankBranchVO>
     * @exception EventException
     */    
    public List<BankBranchVO> searchBankBranchCodeList(BankBranchVO bankBranchVO) throws EventException; 
    
    
    /**
     * [STM_SAP_0064]
     * Pay Invoice Information list 조회<br>
     * 
     * @param PopPayInvoiceInfomationListVO popPayInvoiceInfomationListVO
     * @return List<PopPayInvoiceInfomationListVO>
     * @exception EventException
     */    
    public List<PopPayInvoiceInfomationListVO> searchPopPayInvoiceInfomationList(PopPayInvoiceInfomationListVO popPayInvoiceInfomationListVO) throws EventException; 
    
    /**
     * [STM_SAP_0090]
     * Bank Account 등록<br>
     * 
     * @param BankAccountListVO bankAccountListVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */  
	public String manageBankAccountEntry(BankAccountListVO bankAccountListVO, SignOnUserAccount account) throws EventException;  
	
    /**
     * [STM_SAP_0090]
     * Bank Account 조회<br>
     * 
     * @param BankAccountListVO bankAccountListVO
     * @return List<BankAccountListVO>
     * @exception EventException
     */    
    public List<BankAccountListVO> searchBankAccountList(BankAccountListVO bankAccountListVO) throws EventException; 

    /**
     * [STM_SAP_0090]
     * Bank Account Leger 조회<br>
     * 
     * @param BankAccountListVO bankAccountListVO
     * @return List<BankAccountListVO>
     * @exception EventException
     */    
    public List<BankAccountListVO> searchBankAccountLegerList(BankAccountListVO bankAccountListVO) throws EventException; 
    
	/**
	 * COMMON : searchLegerInfo (SEARCH08) <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return List<SapCommonVO> 
	 * @exception EventException
	*/
	public List<SapCommonVO> searchCOAInfo(SapCommonVO sapCommonVO) throws EventException;

	/**
	 * [STM_SAP_0110]
	 * Bank Account Creation ( Supplier Bank ) - retrieve <br> 
	 * 
	 * @param String bankAcctNo
	 * @return List<BankAccountSupplierListVO>
	 * @exception EventException
   */
	public List<BankAccountSupplierListVO> searchBankAccountSupplierList(String bankAcctNo) throws EventException;
	
   /**
	 * [STM_SAP_0110]
	 * Bank Account Creation ( Supplier Bank ) - save<br> 
	 * 
	 * @param BankAccountSupplierListVO bankAccountSupplierListVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
   */
	public String manageBankAccountSupplierInfo(BankAccountSupplierListVO bankAccountSupplierListVO, String usrId) throws EventException;
	
   /**
	 * SAKURA I/F for PAYMENT  
	 * searchBankAccountSequenceInfo <br> 
	 * 
	 * @return String
	 * @exception EventException
   */ 
	public String searchBankAccountSequenceInfo() throws EventException;	
	
    /**
     * [SAKURA I/F for Payment]
     * Bank Account 등록<br>
     * 
     * @param BankAccountListVO bankAccountListVO
     * @return String
     * @exception EventException
     */  
	public String addBankAccountEntry(BankAccountListVO bankAccountListVO) throws EventException;

	/**
	 * [STM_SAP_0090] BANK_ACCT_NO DUP CHECK <br>
	 *
	 * @param String bank_acct_no
	 * @param String bank_acct_tp_nm
	 * @return String
	 * @exception EventException
	 */
	public String searchBankAcctNoDupCheck(String bank_acct_no, String bank_acct_tp_nm) throws EventException;
	
	/**
	 * searchInvoiceHeaderInfo <br>
	 *
	 * @param String inv_no
	 * @return String
	 * @exception EventException
	 */
	public String searchGLDateAPPeriodCheckByInvNo(String inv_no) throws EventException;	
	
}