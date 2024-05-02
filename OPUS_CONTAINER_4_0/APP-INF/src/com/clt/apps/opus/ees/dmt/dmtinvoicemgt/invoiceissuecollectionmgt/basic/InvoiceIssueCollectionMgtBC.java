/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtBC.java
*@FileTitle : Invoice Creation & Issue
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.VVDNEtaVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARInterfaceParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARInterfaceStatusVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.CancelInvoiceParamVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ConfirmChargeListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtCommonReturnDataVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtFaxEmlSndHisParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtFaxEmlSndHisVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvMnVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtPayrInfoVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.EDIContainerVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.FAXEmailByPayerVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceGroupMgtVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceGroupParamVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARByDetailVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARBySummaryVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMasterPreviewVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMgtVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueRDParamVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceParamVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssueParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssueVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssuedListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceSummaryVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetial2VO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetial3VO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetialVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryBySummaryVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.PayerInfoParamVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.PayerInformationVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SearchIndiaGstRateVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionMasterSetVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionSearchOptionVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionTermTitleListUpVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetSetSearchOptionVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.VVDCheckDataVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * Invoicemgt Business Logic Command Interface<br>
 * 
 * @author
 * @see reference Ees_dmt_4001EventResponse 
 * @since J2EE 1.6
 */

public interface InvoiceIssueCollectionMgtBC {

    /**
     * Search Invoice Create & Issue. <br>
     * 
     * @param IssuedInvoiceParamVO  issuedInvoiceParamVO
     * @param SignOnUserAccount account
     * @return List<ConfirmChargeListVO>
     * @exception EventException
     */
    public List<ConfirmChargeListVO> searchChargeInvoiceList(IssuedInvoiceParamVO issuedInvoiceParamVO, SignOnUserAccount account) throws EventException;
    
    
    /**
     * Modify Invoice information by PartialPayment.<br>
     * 
     * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
     * @param SignOnUserAccount account
     * @return DmtResultVO
     * @exception EventException
     */
    public DmtResultVO modifyInvoiceByPartialPayment(ChargeCalculationContainerVO[] chargeCalculationContainerVOs
                                                        , SignOnUserAccount account) throws EventException;
    
    /**
     * Search Invoice Create & Issue. <br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @param SignOnUserAccount account
     * @return InvoiceIssueMgtVO
     * @exception EventException
     */
    public InvoiceIssueMgtVO searchChargeInvoice(IssuedInvoiceParamVO issuedInvoiceParamVO, SignOnUserAccount account) throws EventException;
    
    
    
    
    /**
    * SEARCH Outstanding Inquiry by Customer N Issue <br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OtsInquiryBySummaryVO>
    * @exception EventException
    */
    public List<OtsInquiryBySummaryVO> searchOTSInquiryBySummaryList ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
    
    
    
   /**
    * [TAB1:Search A/R Interface Status Inquiry By DMT]<br>
    * 
    * @param ARInterfaceParmVO arInterfaceParmVO
    * @return List<ARInterfaceStatusVO>
    * @exception EventException
    */
    public List<ARInterfaceStatusVO> searchARInterfaceStatusByDMT(ARInterfaceParmVO arInterfaceParmVO) throws EventException;

   /**
    * [TAB2:Search A/R Interface Status Inquiry By BKG].<br>
    * 
    * @param ARInterfaceParmVO arInterfaceParmVO
    * @return List<ARInterfaceStatusVO>
    * @exception EventException
    */
    public List<ARInterfaceStatusVO> searchARInterfaceStatusByBKG(ARInterfaceParmVO arInterfaceParmVO) throws EventException;
    
   /**
    * Search Invoice Interface to A/R.<br>
    * 
    * @param InvoiceInterfaceARParmVO  invoiceInterfaceARParmVO
    * @return List<InvoiceInterfaceARBySummaryVO>
    * @exception EventException
    */
    public List<InvoiceInterfaceARBySummaryVO> searchInvoiceInterfaceARBySummary(InvoiceInterfaceARParmVO  invoiceInterfaceARParmVO) throws EventException;

   /**
    * Search Invoice Interface to A/R. - Detail.<br>
    * 
    * @param InvoiceInterfaceARParmVO  invoiceInterfaceARParmVO
    * @param SignOnUserAccount account
    * @return List<InvoiceInterfaceARByDetailVO>
    * @exception EventException
    */
    public List<InvoiceInterfaceARByDetailVO> searchInvoiceInterfaceARByDetail(InvoiceInterfaceARParmVO  invoiceInterfaceARParmVO, SignOnUserAccount account) throws EventException;

    
    /**
    * Search Outstanding Inquiry by Customer N Issue - Detail .<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OtsInquiryByDetialVO>
    * @exception EventException
    */
    public List<OtsInquiryByDetialVO> searchOTSInquiryByDetailList ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
    
    /**
    * Search Outstanding Inquiry by Customer N Issue - Detail(s) .<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OtsInquiryByDetialVO2>
    * @exception EventException
    */
    public List<OtsInquiryByDetial2VO> searchOTSInquiryByDetailList2 ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
    
    /**
     * save Invoice Create & Issue .<br>
     * 
     * @param InvoiceIssueMgtVO invoiceIssueMgtVO
     * @param SignOnUserAccount account
     * @return DmtInvMnVO
     * @exception EventException
     */
    public DmtInvMnVO issueInvoice(InvoiceIssueMgtVO invoiceIssueMgtVO, SignOnUserAccount account) throws EventException;
    
    /**
    * Search Outstanding Inquiry by Customer N Issue - Detail(s)REMARK.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return String
    * @exception EventException
    */
    public String searchOTSInquiryByDetailListRemark ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
    
    /**
    * Search Outstanding Inquiry by Customer N Issue - Detail(s) REMARK .<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return String
    * @exception EventException
    */
    public String searchOTSInquiryByDetailListRemark2 ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
    
    /**
    * Search Outstanding Inquiry by Customer N Issue - Detail(s) REMARK .<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String updateOTSInquiryByDetailListRemark ( OtsInquiryParmVO otsInquiryParmVO , SignOnUserAccount account ) throws EventException;

    
    
    /**
     *  Search Invoice Create & Issue(after Invoice Issue).<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return InvoiceIssueMgtVO
     * @exception EventException
     */
    public InvoiceIssueMgtVO searchIssuedInvoice(IssuedInvoiceParamVO issuedInvoiceParamVO) throws EventException;
    
    /**
     * Modify Invoice Create & Issue.<br>
     * 
     * @param InvoiceIssueMgtVO invoiceIssueMgtVO
     * @param SignOnUserAccount account
     * @return DmtInvMnVO
     * @exception EventException
     */
    public DmtInvMnVO modifyInvoice(InvoiceIssueMgtVO invoiceIssueMgtVO, SignOnUserAccount account) throws EventException;
    
    
    /**
     * Search Exchange Rate.<br>
     * 
     * @param ChargeBookingInvoiceVO chargeBookingInvoiceVO
     * @return double
     * @exception EventException
     */
    public double searchExchangeRate(ChargeBookingInvoiceVO chargeBookingInvoiceVO) throws EventException;
    

    /**
    * Search Remark(s).<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return String
    * @exception EventException
    */
    public String searchInvoiceRemark ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
    
    /**
    * Search OTS Remark(s). <br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return String
    * @exception EventException
    */
    public String searchOTSRemark ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
    
    /**
    * update Remark(s).<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String modifyInvoiceRemark ( OtsInquiryParmVO otsInquiryParmVO , SignOnUserAccount account ) throws EventException;
    
    /**
    * update OTS Remark(s).<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String modifyOTSRemark ( OtsInquiryParmVO otsInquiryParmVO , SignOnUserAccount account ) throws EventException;
    
    /**
     *  Search Tax Ratio information by Office <br>
     * 
     * @param SheetOptionVO sheetOptionVO
     * @return String
     * @throws DAOException
     */
    public String searchEnvironmentByOffice ( SheetOptionVO sheetOptionVO) throws EventException;
    
    
    
    /**
    * Search Sheet Option.<br>
    * 
    * @param SheetOptionSearchOptionVO sheetOptionSearchOptionVO
    * @param SheetOptionMasterSetVO sheetOptionMasterSetVO
    * @return SheetOptionMasterSetVO
    * @exception EventException
    */
    public SheetOptionMasterSetVO searchSheetOption ( SheetOptionSearchOptionVO sheetOptionSearchOptionVO , SheetOptionMasterSetVO sheetOptionMasterSetVO ) throws EventException;
    
    /**
    * Sheet Option. [DELETE/INSERT] .<br>
    * 
    * @param SheetOptionSearchOptionVO sheetOptionSearchOptionVO
    * @param SheetOptionTermTitleListUpVO[] sheetOptionTermTitleListUpVOs
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String manageSheetOption ( SheetOptionSearchOptionVO sheetOptionSearchOptionVO , SheetOptionTermTitleListUpVO[] sheetOptionTermTitleListUpVOs , SignOnUserAccount account ) throws EventException;
    
    /**
    * Search Sheet Setting Screen target.<br>
    * 
    * @param SheetSetSearchOptionVO sheetSetSearchOptionVO
    * @return String
    * @exception EventException
    */
    public String searchSheetSet ( SheetSetSearchOptionVO sheetSetSearchOptionVO ) throws EventException;
    
    /**
    * [Sheet Setting Screen] [DELETE/INSERT] .<br>
    * 
    * @param SheetSetSearchOptionVO sheetSetSearchOptionVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String saveSheetSet ( SheetSetSearchOptionVO sheetSetSearchOptionVO , SignOnUserAccount account ) throws EventException;
    
    /**
    * [Sheet Setting Screen] [DELETE] .<br>
    * 
    * @param SheetSetSearchOptionVO sheetSetSearchOptionVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String removeSheetSet ( SheetSetSearchOptionVO sheetSetSearchOptionVO , SignOnUserAccount account ) throws EventException;
    
    /**
     * Create Group Invoice .
     * @param InvoiceGroupParamVO invoiceGroupParamVO
     * @param ConfirmChargeListVO[] confirmChargeListVOs
     * @param SignOnUserAccount account
     * @return InvoiceGroupMgtVO
     * @throws EventException
     */
    public InvoiceGroupMgtVO issueInvoiceByGroup(InvoiceGroupParamVO invoiceGroupParamVO, ConfirmChargeListVO[] confirmChargeListVOs, SignOnUserAccount account) throws EventException;
    
    
    
    /**
    * SEARCH Manual Invoice Report by Office.<br>
    * 
    * @param ManualInvoiceIssueParmVO manualInvoiceIssueParmVO
    * @return List<ManualInvoiceSummaryVO>
    * @exception EventException
    */
    public List<ManualInvoiceSummaryVO> searchManualInvoiceBySummaryList ( ManualInvoiceIssueParmVO manualInvoiceIssueParmVO ) throws EventException;
    
    /**
    * SEARCH Manual Invoice Report by Office - Detail(s).<br>
    * 
    * @param ManualInvoiceIssueParmVO manualInvoiceIssueParmVO
    * @return List<ManualInvoiceIssuedListVO>
    * @exception EventException
    */
    public List<ManualInvoiceIssuedListVO> searchManualInvoiceByDetailList ( ManualInvoiceIssueParmVO manualInvoiceIssueParmVO ) throws EventException;
    
    /**
    * SEARCH Outstanding Inquiry by Customer N Issue - Detail(s) <br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OtsInquiryByDetialVO3>
    * @exception EventException
    */
    public List<OtsInquiryByDetial3VO> searchOTSInquiryByDetailList3 ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
    
    
    
    /**
    *  SEARCH Manual Invoice Report by Office.<br>
    * 
    * @return String
    * @exception EventException
    */
    public String searchManualInvoiceReasonList() throws EventException;
    
    /**
     * Search Issued Invoice Inquiry.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return List<IssuedInvoiceListVO>
     * @exception EventException
     */
    public List<IssuedInvoiceListVO> searchIssuedInvoiceList ( IssuedInvoiceParamVO issuedInvoiceParamVO ) throws EventException;
    
    /**
     * Search Invoice Create & Issue .<br>
     * 
     * @param String invoiceNo
     * @return InvoiceIssueVO
     * @exception EventException
     */
     public InvoiceIssueMgtVO searchManualInvoiceByBooking(String invoiceNo) throws EventException;        
     
     /**
      *  Search Invoice Create & Issue.<br>
      * 
      * @param String bookingNo
      * @param String officeCode
      * @param String tariffType
      * @param String cntrDtlFlg
      * @return InvoiceIssueMgtVO
      * @exception EventException
      */
      public InvoiceIssueMgtVO searchManualKeyByBooking(String bookingNo, String officeCode, String tariffType, String cntrDtlFlg) throws EventException;       
     
      /**
       * check validation CNTR No..<br>
       * 
       * @param cntrNo String
       * @return String
       * @exception EventException
       */
      public String checkContainerNo(String cntrNo) throws EventException; 
       
      /**
       * Search VVD CD. Calling Port .<br>
       * 
       * @param invoiceVO ChargeBookingInvoiceVO
       * @return boolean
       * @exception EventException
       */
      public boolean checkCallingPort(ChargeBookingInvoiceVO invoiceVO) throws EventException; 
      
      /**
       * check existing VVD CD.<br>
       * 
       * @param invoiceVO ChargeBookingInvoiceVO
       * @return boolean
       * @exception EventException
       */
      public boolean checkVVD(ChargeBookingInvoiceVO invoiceVO) throws EventException; 
      
      /**
       * Save Manual Invoice Creation & Issue [after Invoice Issue] .<br>
       * 
       * @param manualInvoiceIssueVO ManualInvoiceIssueVO
       * @param SignOnUserAccount account
       * @exception EventException
       */
      public void modifyInvoiceByManual(ManualInvoiceIssueVO manualInvoiceIssueVO, SignOnUserAccount account) throws EventException; 
      
      /**
       * Save Manual Invoice Creation & Issue [before Invoice Issue] .<br>
       * 
       * @param ManualInvoiceIssueVO manualInvoiceIssueVO
       * @param SignOnUserAccount account
       * @return String
       * @exception EventException
       */
      public String issueInvoiceByManual(ManualInvoiceIssueVO manualInvoiceIssueVO, SignOnUserAccount account) throws EventException; 
      
     /**
      * Search Invoice Cancel reason .<br>
      * 
      * @return List<DmtCommonReturnDataVO>
      * @throws DAOException
      */
     public List<DmtCommonReturnDataVO> searchCancelReason() throws EventException;
     
    /**
    * [Hold Reason Entry][SEARCH] .<br>
    * 
    * @param String invoiceNo
    * @return String
    * @exception EventException
    */
    public String searchHoldReason(String invoiceNo) throws EventException;
    
    /**
     * [Hold Reason Entry][SEARCH] .<br>
     * 
     * @return List<DmtCommonReturnDataVO>
     * @exception EventException
     */
    public List<DmtCommonReturnDataVO> searchHoldReasonCdList () throws EventException;
    
    
    
    
    /**
    * [Hold Reason Entry][UPDATE] .<br>
    * 
    * @param String invoiceNo
    * @param String holdReasn
    * @param String holdRemrk
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String modifyInvoiceByHold ( String invoiceNo , String holdReasn , String holdRemrk , SignOnUserAccount account ) throws EventException;
    
    /**
     * [Invoice] [Cancel] .<br>
     * 
     * @param CancelInvoiceParamVO cancelInvoiceParamVO
     * @param SignOnUserAccount account
     * @return ChargeArgumentVO
     * @throws DAOException
     */
    public List<ChargeArgumentVO> cancelInvoice(CancelInvoiceParamVO cancelInvoiceParamVO, SignOnUserAccount account) throws EventException;
    
    /**
    * [ Fax/E-mail Sending History ] [ SEARCH ] .<br>
    * 
    * @param DmtFaxEmlSndHisParmVO dmtFaxEmlSndHisParmVO
    * @return List<DmtFaxEmlSndHisVO>
    * @exception EventException
    */
    public List<DmtFaxEmlSndHisVO> searchFaxEmailHistory ( DmtFaxEmlSndHisParmVO dmtFaxEmlSndHisParmVO ) throws EventException;
    
    /**
     * Search Payerinformation
     * 
     * @param PayerInfoParamVO payerInfoParamVO
     * @return PayerInformationVO
     * @throws EventException
     */
    public PayerInformationVO searchPayerInformation ( PayerInfoParamVO payerInfoParamVO) throws EventException;
    
	/**
	 *  Search Payer Name information.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws EventException
	 */
    public List<DmtPayrInfoVO> searchPayerName(PayerInfoParamVO payerInfoParamVO) throws EventException;
    
	/**
	 *  Search Payer Address information.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws EventException
	 */
    public List<DmtPayrInfoVO> searchPayerAddress(PayerInfoParamVO payerInfoParamVO) throws EventException;
    
	/**
	 *  Search Payer Contact Point information. <br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws EventException
	 */
    public List<DmtPayrInfoVO> searchPayerContactPointName(PayerInfoParamVO payerInfoParamVO) throws EventException;
    
	/**
	 * Search Payer Phone No information.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws EventException
	 */
	public List<DmtPayrInfoVO> searchPayerPhoneNo(PayerInfoParamVO payerInfoParamVO) throws EventException;
	
	/**
	 * Search Payer Fax No information. <br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws EventException
	 */
	public List<DmtPayrInfoVO> searchPayerFaxNo(PayerInfoParamVO payerInfoParamVO) throws EventException;
    
	/**
	 * Search Payer Email information.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws EventException
	 */
	public List<DmtPayrInfoVO> searchPayerEmail(PayerInfoParamVO payerInfoParamVO) throws EventException;
	
	
	/**
	 *  save Payer Info information. <br>
	 * 
	 * @param PayerInformationVO payerInformationVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void managePayerInformation(PayerInformationVO payerInformationVO, SignOnUserAccount account) throws EventException;
	
	
	/**
     *  Search calculated Charge information by Finished Booking,  Tariff Type,, "SZPBB".
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @param SignOnUserAccount account
     * @return InvoiceIssueMgtVO
     * @exception EventException
     */
    public InvoiceIssueMgtVO searchChargeInvoiceBySZPBB(IssuedInvoiceParamVO issuedInvoiceParamVO, SignOnUserAccount account)
    		throws EventException;
    
    
    /**
     * Confirmed Charge Invoice Issue
     * 
     * @param InvoiceIssueMgtVO invoiceIssueMgtVO
     * @param SignOnUserAccount account
     * @return DmtInvMnVO
     * @exception EventException
     */
    public DmtInvMnVO issueInvoiceBySZPBB(InvoiceIssueMgtVO invoiceIssueMgtVO, SignOnUserAccount account) throws EventException;
    
    
    /**
     * Search Manual Invoice Data by Office, Booking no
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return InvoiceIssueMgtVO
     * @exception EventException
     */
    public InvoiceIssueMgtVO searchIssuedInvoiceBySZPBB(IssuedInvoiceParamVO issuedInvoiceParamVO) throws EventException;
    
    /**
     * Save sentting information of AR Interface.
     * @param SignOnUserAccount account
     * @param String arIfNo
     * @param String invoiceNo
     * @param String creOfcCd
     * @throws EventException
     */
    public void modifyARInterface(SignOnUserAccount account, String arIfNo, String invoiceNo, String creOfcCd) throws EventException;
    
    
    /**
     * Search sending information of AR Interface.
     * @param SignOnUserAccount account
     * @param String invoiceNo
     * @param String CreateNoteYn
     * @param String creOfcCd
     * @return ARInterfaceCreationVO
     * @throws EventException
     */
    public ARInterfaceCreationVO searchARInterfaceInvoice(SignOnUserAccount account, String invoiceNo, String CreateNoteYn, String creOfcCd) throws EventException;
    
    /**
     * After Create group invoice, save charge information
     * @param InvoiceGroupMgtVO invoiceGroupMgtVO
     * @return List<InvoiceIssueVO>
     * @throws EventException
     */
    public List<InvoiceIssueVO> searchChargeBookingGroupInvoiceDetail(InvoiceGroupMgtVO invoiceGroupMgtVO) throws EventException;
    
    
    /**
     * Search cntr count by Bkg <br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return int
     * @throws DAOException
     */
    public int searchBookingContainerCount(IssuedInvoiceParamVO issuedInvoiceParamVO) throws EventException;
    
    /**
     * Search VVD data.
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return VVDCheckDataVO
     * @throws EventException
     */
    public VVDCheckDataVO searchVVDCheckData(IssuedInvoiceParamVO issuedInvoiceParamVO) throws EventException;
    
    
    /**
     * Search fax and email information by Payer
     * @param FAXEmailByPayerVO fAXEmailByPayerVO
     * @return FAXEmailByPayerVO
     * @throws EventException
     */
    public FAXEmailByPayerVO searchFAXEmailByPayer(FAXEmailByPayerVO fAXEmailByPayerVO) throws EventException;
    
    /**
     * Search manual invoice MASTER  data of INVOICE RD <br>
     * @param InvoiceIssueRDParamVO invoiceIssueRDParamVO
     * @return InvoiceIssueMasterPreviewVO
     * @throws EventException
     */
    public InvoiceIssueMasterPreviewVO searchInvoiceIssueMasterPreview(InvoiceIssueRDParamVO invoiceIssueRDParamVO) throws EventException;
    
    /**
     *  Search invoice DETAIL data of INVOICE RD.<br>
     * @param InvoiceIssueRDParamVO invoiceIssueRDParamVO
     * @return String
     * @throws EventException
     */
    public String searchInvoiceIssueRD(InvoiceIssueRDParamVO invoiceIssueRDParamVO) throws EventException;
    
    /**
     * Search data for sending EDI, After AR-IF.<br>
     * @param String invoiceNo
     * @param String creOfcCd
     * @return List<EDIContainerVO>
     * @throws EventException
     */
    public List<EDIContainerVO> searchEDIContainerInfoByInvoice(String invoiceNo, String creOfcCd) throws EventException;
    
    /**
 	 * check SZPBB INVOICE Creation
 	 * 
 	 * @param String invoiceNo
 	 * @return String
 	 * @throws DAOException
 	 */
    public String checkSZPBBInvoice(String invoiceNo) throws EventException;
    
    
    /**
 	 * run Back End Job
 	 * 
 	 * @param InvoiceGroupParamVO invoiceGroupParamVO
 	 * @param ConfirmChargeListVO[] confirmChargeListVOs
 	 * @param SignOnUserAccount account
 	 * @return String
 	 * @throws EventException
 	 */
    public String doBackEndJob(InvoiceGroupParamVO invoiceGroupParamVO, ConfirmChargeListVO[] confirmChargeListVOs, SignOnUserAccount account) throws EventException;
    
	/**
	 * Return status of Back End Job.
	 *
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
    public String[] checkBackEndJob(String key) throws EventException;
    
 	/**
 	 * before do AR-IF, Check done AR-IF 
 	 * @param String[] invoiceNos
 	 * @param String creOfcCd
 	 * @param String flg
 	 * @return List<String> 
 	 * @throws DAOException
 	 */
    public List<String> searchARIFCount(String[] invoiceNos, String creOfcCd, String flg) throws EventException;
    
	/**
	 * Search Detail information of Group Invoice.
	 *
	 * @param InvoiceGroupParamVO invoiceGroupParamVO
	 * @param ConfirmChargeListVO[] confirmChargeListVOs
	 * @return List<VVDCheckDataVO>
	 * @exception EventException
	 */
    public List<VVDCheckDataVO> searchChargeBookingGroupInvoiceVVDDetail(InvoiceGroupParamVO invoiceGroupParamVO, ConfirmChargeListVO[] confirmChargeListVOs) throws EventException;
    
    
	/**
	 * search VVDNEta information on using CalculationUtil.
	 *
	 * @param VVDCheckDataVO vVDCheckDataVO
	 * @return VVDNEtaVO
	 * @exception EventException
	 */
    public VVDNEtaVO searchIssueInvoiceVVD(VVDCheckDataVO vVDCheckDataVO) throws EventException;
    
    
	/**
	 * search new VVDNEta information on using CalculationUtil.
	 *
	 * @param InvoiceGroupParamVO invoiceGroupParamVO
	 * @param ConfirmChargeListVO[] confirmChargeListVOs
	 * @return ConfirmChargeListVO[]
	 * @exception EventException
	 */
    public ConfirmChargeListVO[] searchIssueInvoiceByGroupVVD(InvoiceGroupParamVO invoiceGroupParamVO, ConfirmChargeListVO[] confirmChargeListVOs) throws EventException;
    
    
	/**
	 * Search Office Code of Invoice Creation user.
	 *
	 * @param String invoiceNo
	 * @return String
	 * @exception EventException
	 */
    public String searchInvoiceCreteOfficeCode(String invoiceNo) throws EventException;    
    
	/**
	 * Search Rate Currency by BKG No., Tariff  <br>
	 *
	 * @param String bkgNo
	 * @param String trfCd
	 * @return String
	 * @exception EventException
	 */
    public String searchRateCurrency(String bkgNo, String trfCd) throws EventException;     
    
	/**
     * Search VVD list.
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @param SignOnUserAccount account
     * @return List<VVDCheckDataVO>
     * @throws EventException
	 */
    public List<VVDCheckDataVO> searchVVDCheckDataList(IssuedInvoiceParamVO issuedInvoiceParamVO, SignOnUserAccount account) throws EventException;
    
    
    /**
     * Update Invoice information.  after calculating  on After Booking.<br>
     * 
     * @param String darNo
     * @throws EventException
     */
	public void modifyInvoiceAdjustAmount(String darNo) throws EventException;
	
 	/**
 	 * Search DMDT_INV_STS_CD of DMT_INV_MN.
 	 * @param String invoiceNo
 	 * @param String creOfcCd
 	 * @return String
 	 * @throws DAOException
 	 */
	public String searchInvoiceStatus(String invoiceNo, String creOfcCd) throws EventException;
	
    /**
     * Search After Invoice Adjustment Amt of Invoice.<br>
     * 
     * @param String invoiceNo
     * @param String creOfcCd
     * @param SignOnUserAccount account
     * @return ChargeBookingInvoiceVO
     * @throws DAOException
     */
    public ChargeBookingInvoiceVO checkAftInvAdjAmtByInvoiceNo(String invoiceNo, String creOfcCd, SignOnUserAccount account) throws EventException;

    /**
     * Search India GST Tax rate.<br>
     * @param  String iss_dt
     * @return SearchIndiaGstRateVO
     * @exception EventException 
     */
    public SearchIndiaGstRateVO searchIndiaGstRate(String iss_dt) throws EventException;
}
