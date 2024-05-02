/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtBC.java
*@FileTitle : Invoice Creation & Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.05 김태균
* 1.0 Creation
* 2010.11.26 김태균 [] [EES-DMT] A/R I/F시 INVOICE CURRECY 없을 경우 에러 처리함
* 2011.05.20 김태균[CHM-201110830-01] [DMT] Issued Invoice Inquiry 화면 보완 요청
* 2011.11.14 권   민[CHM-201114143] [DMT] Manual Invoice with no detail 조건의 Print Preview 개발 
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AftBkgCxlInvCondVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.VVDNEtaVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARInterfaceCreationCondVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARInterfaceParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARInterfaceStatusVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.CancelInvoiceParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ConfirmChargeListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtCommonReturnDataVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtFaxEmlSndHisParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtFaxEmlSndHisVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvMnVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtPayrInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.EDIContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.FAXEmailByPayerVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IdaGstRtoCondVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IdaGstRtoVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceGroupMgtVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceGroupParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARByDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARBySummaryVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMasterPreviewVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMgtVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueRDParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceNoGenCondVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceNoGenVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceSumByPayerVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssueParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssueVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssuedListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceSummaryVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OTSCleanDetailExcelListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OTSCleanListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OTSCleanOfficeListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetial2VO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetial3VO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetialVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryBySummaryVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryParm2VO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsPayRcvVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.PayerInfoListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.PayerInfoParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.PayerInformationVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SearchIndiaGstRateVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionMasterSetVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionSearchOptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionTermTitleListUpVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetSetSearchOptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.VVDCheckDataVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Invoicemgt Business Logic Command Interface<br>
 * - ALPS-Invoicemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Tae Kyun
 * @see Ees_dmt_4001EventResponse 참조
 * @since J2EE 1.6
 */

public interface InvoiceIssueCollectionMgtBC {

    /**
     * [Invoice Create & Issue]을 [조회] 합니다.<br>
     * 
     * @param IssuedInvoiceParamVO  issuedInvoiceParamVO
     * @param SignOnUserAccount account
     * @return List<ConfirmChargeListVO>
     * @exception EventException
     */
    public List<ConfirmChargeListVO> searchChargeInvoiceList(IssuedInvoiceParamVO issuedInvoiceParamVO, SignOnUserAccount account) throws EventException;
    
    
    /**
     * PartialPayment의 의한 Invoice 정보를 수정합니다.<br>
     * 
     * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
     * @param SignOnUserAccount account
     * @return DmtResultVO
     * @exception EventException
     */
    public DmtResultVO modifyInvoiceByPartialPayment(ChargeCalculationContainerVO[] chargeCalculationContainerVOs
                                                        , SignOnUserAccount account) throws EventException;
    
    /**
     * [Invoice Create & Issue]을 [조회] 합니다.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @param SignOnUserAccount account
     * @return InvoiceIssueMgtVO
     * @exception EventException
     */
    public InvoiceIssueMgtVO searchChargeInvoice(IssuedInvoiceParamVO issuedInvoiceParamVO, SignOnUserAccount account) throws EventException;
    
    
    
    
    /**
    * [Outstanding Inquiry by Customer N Issue 대상]을 [SEARCH] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OtsInquiryBySummaryVO>
    * @exception EventException
    */
    public List<OtsInquiryBySummaryVO> searchOTSInquiryBySummaryList ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
    
    
    /**
     * [Outstanding Inquiry by Customer N Issue for Sales Rep]을 [SEARCH] 합니다.<br>
     * 
     * @param OtsInquiryParm2VO otsInquiryParm2VO
     * @return List<OtsInquiryBySummaryVO>
     * @exception EventException
     */
    public List<OtsInquiryBySummaryVO> searchOTSInquiryBySummaryList2 ( OtsInquiryParm2VO otsInquiryParm2VO ) throws EventException;    
    
    
   /**
    * [TAB1:A/R Interface Status Inquiry By DMT]을 [조회]합니다.<br>
    * 
    * @param ARInterfaceParmVO arInterfaceParmVO
    * @return List<ARInterfaceStatusVO>
    * @exception EventException
    */
    public List<ARInterfaceStatusVO> searchARInterfaceStatusByDMT(ARInterfaceParmVO arInterfaceParmVO) throws EventException;

   /**
    * [TAB2:A/R Interface Status Inquiry By BKG]을 [조회]합니다.<br>
    * 
    * @param ARInterfaceParmVO arInterfaceParmVO
    * @return List<ARInterfaceStatusVO>
    * @exception EventException
    */
    public List<ARInterfaceStatusVO> searchARInterfaceStatusByBKG(ARInterfaceParmVO arInterfaceParmVO) throws EventException;
    
   /**
    * [Invoice Interface to A/R]을 [조회]합니다.<br>
    * 
    * @param InvoiceInterfaceARParmVO  invoiceInterfaceARParmVO
    * @return List<InvoiceInterfaceARBySummaryVO>
    * @exception EventException
    */
    public List<InvoiceInterfaceARBySummaryVO> searchInvoiceInterfaceARBySummary(InvoiceInterfaceARParmVO  invoiceInterfaceARParmVO) throws EventException;

   /**
    * [Invoice Interface to A/R - Detail]을 [조회]합니다.<br>
    * 
    * @param InvoiceInterfaceARParmVO  invoiceInterfaceARParmVO
    * @param SignOnUserAccount account
    * @return List<InvoiceInterfaceARByDetailVO>
    * @exception EventException
    */
    public List<InvoiceInterfaceARByDetailVO> searchInvoiceInterfaceARByDetail(InvoiceInterfaceARParmVO  invoiceInterfaceARParmVO, SignOnUserAccount account) throws EventException;

    
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상]을 [SEARCH] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OtsInquiryByDetialVO>
    * @exception EventException
    */
    public List<OtsInquiryByDetialVO> searchOTSInquiryByDetailList ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
    
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상]을 [SEARCH] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OtsInquiryByDetialVO2>
    * @exception EventException
    */
    public List<OtsInquiryByDetial2VO> searchOTSInquiryByDetailList2 ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
    
    /**
     * [Invoice Create & Issue]을 [저장] 합니다.<br>
     * 
     * @param InvoiceIssueMgtVO invoiceIssueMgtVO
     * @param SignOnUserAccount account
     * @return DmtInvMnVO
     * @exception EventException
     */
    public DmtInvMnVO issueInvoice(InvoiceIssueMgtVO invoiceIssueMgtVO, SignOnUserAccount account) throws EventException;
    
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상]을 [SEARCH] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return String
    * @exception EventException
    */
    public String searchOTSInquiryByDetailListRemark ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
    
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상]을 [SEARCH] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return String
    * @exception EventException
    */
    public String searchOTSInquiryByDetailListRemark2 ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
    
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s) REMARK]을 [UPDATE] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String updateOTSInquiryByDetailListRemark ( OtsInquiryParmVO otsInquiryParmVO , SignOnUserAccount account ) throws EventException;

    
    
    /**
     * [Invoice Create & Issue]을 [조회] 합니다.[Invoice Issue 후]<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return InvoiceIssueMgtVO
     * @exception EventException
     */
    public InvoiceIssueMgtVO searchIssuedInvoice(IssuedInvoiceParamVO issuedInvoiceParamVO) throws EventException;
    
    /**
     * [Invoice Create & Issue]을 [수정] 합니다.<br>
     * 
     * @param InvoiceIssueMgtVO invoiceIssueMgtVO
     * @param SignOnUserAccount account
     * @return DmtInvMnVO
     * @exception EventException
     */
    public DmtInvMnVO modifyInvoice(InvoiceIssueMgtVO invoiceIssueMgtVO, SignOnUserAccount account) throws EventException;
    
    
    /**
     * [Exchange Rate]을 [조회] 합니다.<br>
     * 
     * @param ChargeBookingInvoiceVO chargeBookingInvoiceVO
     * @return double
     * @exception EventException
     */
    public double searchExchangeRate(ChargeBookingInvoiceVO chargeBookingInvoiceVO) throws EventException;
    

    /**
    * [Remark(s) 대상]을 [SEARCH] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return String
    * @exception EventException
    */
    public String searchInvoiceRemark ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
    
    /**
    * [Remark(s) 대상]을 [SEARCH] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return String
    * @exception EventException
    */
    public String searchOTSRemark ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
    
    /**
    * [Remark(s) REMARK]을 [UPDATE] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String modifyInvoiceRemark ( OtsInquiryParmVO otsInquiryParmVO , SignOnUserAccount account ) throws EventException;
    
    /**
    * [Remark(s) REMARK]을 [UPDATE] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String modifyOTSRemark ( OtsInquiryParmVO otsInquiryParmVO , SignOnUserAccount account ) throws EventException;
    
    /**
     * Office별 Tax Ratio 정보를 조회 합니다.<br>
     * 
     * @param SheetOptionVO sheetOptionVO
     * @return String
     * @throws DAOException
     */
    public String searchEnvironmentByOffice ( SheetOptionVO sheetOptionVO) throws EventException;
    
    
    
    /**
    * [Sheet Option]을 [SEARCH] 합니다.<br>
    * 
    * @param SheetOptionSearchOptionVO sheetOptionSearchOptionVO
    * @param SheetOptionMasterSetVO sheetOptionMasterSetVO
    * @return SheetOptionMasterSetVO
    * @exception EventException
    */
    public SheetOptionMasterSetVO searchSheetOption ( SheetOptionSearchOptionVO sheetOptionSearchOptionVO , SheetOptionMasterSetVO sheetOptionMasterSetVO ) throws EventException;
    
    /**
    * [Sheet Option]을 [DELETE/INSERT] 합니다.<br>
    * 
    * @param SheetOptionSearchOptionVO sheetOptionSearchOptionVO
    * @param SheetOptionTermTitleListUpVO[] sheetOptionTermTitleListUpVOs
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String manageSheetOption ( SheetOptionSearchOptionVO sheetOptionSearchOptionVO , SheetOptionTermTitleListUpVO[] sheetOptionTermTitleListUpVOs , SignOnUserAccount account ) throws EventException;
    
    /**
    * [Sheet Setting Screen 대상]을 [SEARCH] 합니다.<br>
    * 
    * @param SheetSetSearchOptionVO sheetSetSearchOptionVO
    * @return String
    * @exception EventException
    */
    public String searchSheetSet ( SheetSetSearchOptionVO sheetSetSearchOptionVO ) throws EventException;
    
    /**
    * [Sheet Setting Screen]을 [DELETE/INSERT] 합니다.<br>
    * 
    * @param SheetSetSearchOptionVO sheetSetSearchOptionVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String saveSheetSet ( SheetSetSearchOptionVO sheetSetSearchOptionVO , SignOnUserAccount account ) throws EventException;
    
    /**
    * [Sheet Setting Screen]을 [DELETE] 합니다.<br>
    * 
    * @param SheetSetSearchOptionVO sheetSetSearchOptionVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String removeSheetSet ( SheetSetSearchOptionVO sheetSetSearchOptionVO , SignOnUserAccount account ) throws EventException;
    
    /**
     * Group Invoice 를 Create 한다.
     * @param InvoiceGroupParamVO invoiceGroupParamVO
     * @param ConfirmChargeListVO[] confirmChargeListVOs
     * @param SignOnUserAccount account
     * @return InvoiceGroupMgtVO
     * @throws EventException
     */
    public InvoiceGroupMgtVO issueInvoiceByGroup(InvoiceGroupParamVO invoiceGroupParamVO, ConfirmChargeListVO[] confirmChargeListVOs, SignOnUserAccount account) throws EventException;
    
    
    
    /**
    * [Manual Invoice Report by Office 대상]을 [SEARCH] 합니다.<br>
    * 
    * @param ManualInvoiceIssueParmVO manualInvoiceIssueParmVO
    * @return List<ManualInvoiceSummaryVO>
    * @exception EventException
    */
    public List<ManualInvoiceSummaryVO> searchManualInvoiceBySummaryList ( ManualInvoiceIssueParmVO manualInvoiceIssueParmVO ) throws EventException;
    
    /**
    * [Manual Invoice Report by Office - Detail(s)]을 [SEARCH] 합니다.<br>
    * 
    * @param ManualInvoiceIssueParmVO manualInvoiceIssueParmVO
    * @return List<ManualInvoiceIssuedListVO>
    * @exception EventException
    */
    public List<ManualInvoiceIssuedListVO> searchManualInvoiceByDetailList ( ManualInvoiceIssueParmVO manualInvoiceIssueParmVO ) throws EventException;
    
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상]을 [SEARCH] c.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OtsInquiryByDetialVO3>
    * @exception EventException
    */
    public List<OtsInquiryByDetial3VO> searchOTSInquiryByDetailList3 ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
    
    
    
    /**
    * [Manual Invoice Report by Office]을 [SEARCH] 합니다.<br>
    * 
    * @return String
    * @exception EventException
    */
    public String searchManualInvoiceReasonList() throws EventException;
    
    /**
     * [Issued Invoice Inquiry]을 [조회] 합니다.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return List<IssuedInvoiceListVO>
     * @exception EventException
     */
    public List<IssuedInvoiceListVO> searchIssuedInvoiceList ( IssuedInvoiceParamVO issuedInvoiceParamVO ) throws EventException;
    
    /**
     * [Invoice Create & Issue]을 [Retrieve] 합니다.<br>
     * 
     * @param String invoiceNo
     * @return InvoiceIssueVO
     * @exception EventException
     */
     public InvoiceIssueMgtVO searchManualInvoiceByBooking(String invoiceNo) throws EventException;        
     
     /**
      * [Invoice Create & Issue]을 [Retrieve] 합니다.<br>
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
       * [CNTR No. 정확성]을 [Retrieve] 합니다.<br>
       * 
       * @param cntrNo String
       * @return String
       * @exception EventException
       */
      public String checkContainerNo(String cntrNo) throws EventException; 
       
      /**
       * [VVD CD. Calling Port]을 [조회] 합니다.<br>
       * 
       * @param invoiceVO ChargeBookingInvoiceVO
       * @return boolean
       * @exception EventException
       */
      public boolean checkCallingPort(ChargeBookingInvoiceVO invoiceVO) throws EventException; 
      
      /**
       * [VVD CD. 가 존재하는지]를 [조회] 합니다.<br>
       * 
       * @param invoiceVO ChargeBookingInvoiceVO
       * @return boolean
       * @exception EventException
       */
      public boolean checkVVD(ChargeBookingInvoiceVO invoiceVO) throws EventException; 
      
      /**
       * [Manual Invoice Creation & Issue [Invoice Issue 후]]을 [Save] 합니다.<br>
       * 
       * @param manualInvoiceIssueVO ManualInvoiceIssueVO
       * @param SignOnUserAccount account
       * @exception EventException
       */
      public void modifyInvoiceByManual(ManualInvoiceIssueVO manualInvoiceIssueVO, SignOnUserAccount account) throws EventException; 
      
      /**
       * [Manual Invoice Creation & Issue [Invoice Issue 전]]을 [Save] 합니다.<br>
       * 
       * @param ManualInvoiceIssueVO manualInvoiceIssueVO
       * @param SignOnUserAccount account
       * @return DmtInvMnVO
       * @exception EventException
       */
      public DmtInvMnVO issueInvoiceByManual(ManualInvoiceIssueVO manualInvoiceIssueVO, SignOnUserAccount account) throws EventException; 
      
     /**
      * [Invoice Cancel Reason]을 [조회] 합니다.<br>
      * 
      * @return List<DmtCommonReturnDataVO>
      * @throws DAOException
      */
     public List<DmtCommonReturnDataVO> searchCancelReason() throws EventException;
     
    /**
    * [Hold Reason Entry]을 [SEARCH] 합니다.<br>
    * 
    * @param String invoiceNo
    * @return String
    * @exception EventException
    */
    public String searchHoldReason(String invoiceNo) throws EventException;
    
    /**
     * [Hold Reason Entry]을 [SEARCH] 합니다.<br>
     * 
     * @return List<DmtCommonReturnDataVO>
     * @exception EventException
     */
    public List<DmtCommonReturnDataVO> searchHoldReasonCdList () throws EventException;
    
    
    
    
    /**
    * [Hold Reason Entry]을 [UPDATE] 합니다.<br>
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
     * [Invoice]을 [Cancel] 합니다.<br>
     * 
     * @param CancelInvoiceParamVO cancelInvoiceParamVO
     * @param SignOnUserAccount account
     * @return ChargeArgumentVO
     * @throws DAOException
     */
    public List<ChargeArgumentVO> cancelInvoice(CancelInvoiceParamVO cancelInvoiceParamVO, SignOnUserAccount account) throws EventException;
    
    /**
    * [ Fax/E-mail Sending History ]을 [ SEARCH ] 합니다.<br>
    * 
    * @param DmtFaxEmlSndHisParmVO dmtFaxEmlSndHisParmVO
    * @return List<DmtFaxEmlSndHisVO>
    * @exception EventException
    */
    public List<DmtFaxEmlSndHisVO> searchFaxEmailHistory ( DmtFaxEmlSndHisParmVO dmtFaxEmlSndHisParmVO ) throws EventException;
    
    /**
     * Payer정보를 조회한다.
     * 
     * @param PayerInfoParamVO payerInfoParamVO
     * @return PayerInformationVO
     * @throws EventException
     */
    public PayerInformationVO searchPayerInformation ( PayerInfoParamVO payerInfoParamVO) throws EventException;
    
	/**
	 * Payer Name 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws EventException
	 */
    public List<DmtPayrInfoVO> searchPayerName(PayerInfoParamVO payerInfoParamVO) throws EventException;
    
	/**
	 * Payer Address 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws EventException
	 */
    public List<DmtPayrInfoVO> searchPayerAddress(PayerInfoParamVO payerInfoParamVO) throws EventException;
    
	/**
	 * Payer Contact Point 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws EventException
	 */
    public List<DmtPayrInfoVO> searchPayerContactPointName(PayerInfoParamVO payerInfoParamVO) throws EventException;
    
	/**
	 * Payer Phone No 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws EventException
	 */
	public List<DmtPayrInfoVO> searchPayerPhoneNo(PayerInfoParamVO payerInfoParamVO) throws EventException;
	
	/**
	 * Payer Fax No 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws EventException
	 */
	public List<DmtPayrInfoVO> searchPayerFaxNo(PayerInfoParamVO payerInfoParamVO) throws EventException;
    
	/**
	 * Payer Email 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws EventException
	 */
	public List<DmtPayrInfoVO> searchPayerEmail(PayerInfoParamVO payerInfoParamVO) throws EventException;
	
	
	/**
	 * Payer Info 정보를 저장한다.<br>
	 * 
	 * @param PayerInformationVO payerInformationVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void managePayerInformation(PayerInformationVO payerInformationVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Payer Info 기본 정보 목록을 조회한다.<br>
	 * 
	 * @param payerInfoListVO
	 * @return List<PayerInfoListVO>
	 * @throws EventException
	 */
	public List<PayerInfoListVO> searchPayerInfoList(PayerInfoListVO payerInfoListVO) throws EventException;
	
	
	/**
     * Finished된 Booking별  Tariff Type별, "SZPBB"별 Charge 계산된 정보를 조회한다.
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @param SignOnUserAccount account
     * @return InvoiceIssueMgtVO
     * @exception EventException
     */
    public InvoiceIssueMgtVO searchChargeInvoiceBySZPBB(IssuedInvoiceParamVO issuedInvoiceParamVO, SignOnUserAccount account)
    		throws EventException;
    
    
    /**
     * Confirm된 Charge를 Invoice Issue한다.(Invoice Issue 전)
     * 
     * @param InvoiceIssueMgtVO invoiceIssueMgtVO
     * @param SignOnUserAccount account
     * @return DmtInvMnVO
     * @exception EventException
     */
    public DmtInvMnVO issueInvoiceBySZPBB(InvoiceIssueMgtVO invoiceIssueMgtVO, SignOnUserAccount account) throws EventException;
    
    
    /**
     * Office별 Booking별 Manual Invoice한 Data를 조회한다.
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return InvoiceIssueMgtVO
     * @exception EventException
     */
    public InvoiceIssueMgtVO searchIssuedInvoiceBySZPBB(IssuedInvoiceParamVO issuedInvoiceParamVO) throws EventException;
    
    /**
     * [AR Interface no]에 전달할 내용을 [저장]한다.
     * @param SignOnUserAccount account
     * @param String arIfNo
     * @param String invoiceNo
     * @param String creOfcCd
     * @throws EventException
     */
    public void modifyARInterface(SignOnUserAccount account, String arIfNo, String invoiceNo, String creOfcCd) throws EventException;
    
    
    /**
     * [AR Interface]에 전달할 내용을 [조회]한다.
     * @param ARInterfaceCreationCondVO condVO
     * @return ARInterfaceCreationVO
     * @throws EventException
     */
    public ARInterfaceCreationVO searchARInterfaceInvoice(ARInterfaceCreationCondVO condVO) throws EventException;
    
    /**
     * [group invoice를 생성 후 charge]에 정보를 [저장]한다.
     * @param InvoiceGroupMgtVO invoiceGroupMgtVO
     * @return List<InvoiceIssueVO>
     * @throws EventException
     */
    public List<InvoiceIssueVO> searchChargeBookingGroupInvoiceDetail(InvoiceGroupMgtVO invoiceGroupMgtVO) throws EventException;
    
    
    /**
     * Bkg별 cntr 갯수를 조회 합니다.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return int
     * @throws DAOException
     */
    public int searchBookingContainerCount(IssuedInvoiceParamVO issuedInvoiceParamVO) throws EventException;
    
    /**
     * VVD 데이터를 조회한다.
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return VVDCheckDataVO
     * @throws EventException
     */
    public VVDCheckDataVO searchVVDCheckData(IssuedInvoiceParamVO issuedInvoiceParamVO) throws EventException;
    
    
    /**
     * Payer별 fax번호,email정보를 조회 합니다.
     * @param FAXEmailByPayerVO fAXEmailByPayerVO
     * @return FAXEmailByPayerVO
     * @throws EventException
     */
    public FAXEmailByPayerVO searchFAXEmailByPayer(FAXEmailByPayerVO fAXEmailByPayerVO) throws EventException;
    
    /**
     * INVOICE RD의 manual invoice MASTER 데이터를 조회한다.<br>
     * @param InvoiceIssueRDParamVO invoiceIssueRDParamVO
     * @return InvoiceIssueMasterPreviewVO
     * @throws EventException
     */
    public InvoiceIssueMasterPreviewVO searchInvoiceIssueMasterPreview(InvoiceIssueRDParamVO invoiceIssueRDParamVO) throws EventException;
    
    /**
     * INVOICE RD의 incCntlDtail 값이 No 인 manual invoice MASTER 데이터를 조회한다.<br>
     * @param InvoiceIssueRDParamVO invoiceIssueRDParamVO
     * @return InvoiceIssueMasterPreviewVO
     * @throws EventException
     */
    public InvoiceIssueMasterPreviewVO searchInvoiceIssueMasterPreviewNo(InvoiceIssueRDParamVO invoiceIssueRDParamVO) throws EventException;
    
    /**
     * INVOICE RD의 invoice DETAIL 데이터를 조회한다.<br>
     * @param InvoiceIssueRDParamVO invoiceIssueRDParamVO
     * @return String
     * @throws EventException
     */
    public String searchInvoiceIssueRD(InvoiceIssueRDParamVO invoiceIssueRDParamVO) throws EventException;
    
    /**
     * AR-IF 후 EDI로 전송할 데이터를 조회한다.<br>
     * @param String invoiceNo
     * @param String creOfcCd
     * @return List<EDIContainerVO>
     * @throws EventException
     */
    public List<EDIContainerVO> searchEDIContainerInfoByInvoice(String invoiceNo, String creOfcCd) throws EventException;
    
    /**
 	 * SZPBB를 통해 INVOICE 생성 여부 확인
 	 * 
 	 * @param String invoiceNo
 	 * @return String
 	 * @throws DAOException
 	 */
    public String checkSZPBBInvoice(String invoiceNo) throws EventException;
    
    
    /**
 	 * 해당 Back End Job을 실행시킨다.
 	 * 
 	 * @param InvoiceGroupParamVO invoiceGroupParamVO
 	 * @param ConfirmChargeListVO[] confirmChargeListVOs
 	 * @param SignOnUserAccount account
 	 * @return String
 	 * @throws EventException
 	 */
    public String doBackEndJob(InvoiceGroupParamVO invoiceGroupParamVO, ConfirmChargeListVO[] confirmChargeListVOs, SignOnUserAccount account) throws EventException;
    
	/**
	 * 해당 Back End Job의 상태를 리턴한다.
	 *
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
    public String[] checkBackEndJob(String key) throws EventException;
    
 	/**
 	 * AR-IF 직전 INVOICE에 대한 AR-IF 실행 여부 체크
 	 * @param String[] invoiceNos
 	 * @param String creOfcCd
 	 * @param String flg
 	 * @return List<String> 
 	 * @throws DAOException
 	 */
    public List<String> searchARIFCount(String[] invoiceNos, String creOfcCd, String flg) throws EventException;
    
	/**
	 * Group Invoice의 Detail 정보를 조회한다.
	 *
	 * @param InvoiceGroupParamVO invoiceGroupParamVO
	 * @param ConfirmChargeListVO[] confirmChargeListVOs
	 * @return List<VVDCheckDataVO>
	 * @exception EventException
	 */
    public List<VVDCheckDataVO> searchChargeBookingGroupInvoiceVVDDetail(InvoiceGroupParamVO invoiceGroupParamVO, ConfirmChargeListVO[] confirmChargeListVOs) throws EventException;
    
    
	/**
	 * CalculationUtil의 searchVVDNEta 정보를 조회한다.
	 *
	 * @param VVDCheckDataVO vVDCheckDataVO
	 * @return VVDNEtaVO
	 * @exception EventException
	 */
    public VVDNEtaVO searchIssueInvoiceVVD(VVDCheckDataVO vVDCheckDataVO) throws EventException;
    
    
	/**
	 * CalculationUtil의 searchVVDNEta 정보를 조회하여 새로운 VVD값을 셋팅하여 넘겨준다.
	 *
	 * @param InvoiceGroupParamVO invoiceGroupParamVO
	 * @param ConfirmChargeListVO[] confirmChargeListVOs
	 * @return ConfirmChargeListVO[]
	 * @exception EventException
	 */
    public ConfirmChargeListVO[] searchIssueInvoiceByGroupVVD(InvoiceGroupParamVO invoiceGroupParamVO, ConfirmChargeListVO[] confirmChargeListVOs) throws EventException;
    
    
	/**
	 * Invoice 생성자의 Office Code 를 조회 합니다.
	 *
	 * @param String invoiceNo
	 * @return String
	 * @exception EventException
	 */
    public String searchInvoiceCreteOfficeCode(String invoiceNo) throws EventException;    
    
	/**
	 * BKG No., Tariff 에 해당되는 Rate Currency 를 조회 합니다. <br>
	 *
	 * @param String bkgNo
	 * @param String trfCd
	 * @return String
	 * @exception EventException
	 */
    public String searchRateCurrency(String bkgNo, String trfCd) throws EventException;     
    
	/**
     * VVD 데이터 list를 조회한다.
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @param SignOnUserAccount account
     * @return List<VVDCheckDataVO>
     * @throws EventException
	 */
    public List<VVDCheckDataVO> searchVVDCheckDataList(IssuedInvoiceParamVO issuedInvoiceParamVO, SignOnUserAccount account) throws EventException;
    
    
    /**
     * After Booking 승인시 계산을 수행한 후 Invoice 정보를 갱신한다.<br>
     * 
     * @param String darNo
     * @throws EventException
     */
	public void modifyInvoiceAdjustAmount(String darNo) throws EventException;
	
 	/**
 	 * DMT_INV_MN의 DMDT_INV_STS_CD를 조회한다.
 	 * @param String invoiceNo
 	 * @param String creOfcCd
 	 * @return String
 	 * @throws DAOException
 	 */
	public String searchInvoiceStatus(String invoiceNo, String creOfcCd) throws EventException;
	
    /**
     * Invoice에 대한 After Invoice Adjustment Amt를 조회 합니다.<br>
     * 
     * @param String invoiceNo
     * @param String creOfcCd
     * @param String lgnOfcCd
     * @return ChargeBookingInvoiceVO
     * @throws DAOException
     */
    public ChargeBookingInvoiceVO checkAftInvAdjAmtByInvoiceNo(String invoiceNo, String creOfcCd, String lgnOfcCd) throws EventException;
	
    /**
     * Issued Invoice(Payer별 Currency에 대한 합계금액) 를 조회 한다.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return List<IssuedInvoiceSumByPayerVO>
     * @exception EventException
     */
    public List<IssuedInvoiceSumByPayerVO> searchIssuedInvoiceSumByPayer ( IssuedInvoiceParamVO issuedInvoiceParamVO ) throws EventException;

     /**
      * 인도 GST 관련 Tax rate 조회.<br>
      * @param  String iss_dt 
      * @return SearchIndiaGstRateVO
      * @exception EventException
      */
    public SearchIndiaGstRateVO searchIndiaGstRate(String iss_dt) throws EventException;
   

    
    /**
    * [Outstanding Inquiry by Customer N Issue 대상]을 [SEARCH] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OTSCleanListVO>
    * @exception EventException
    */
    public List<OTSCleanListVO> searchOTSCleanList ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
    

    /**
    * [Outstanding Inquiry by Customer N Issue 대상]을 [SEARCH] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OtsInquiryBySummaryVO>
    * @exception EventException
    */
    public List<OTSCleanOfficeListVO> searchOTSCleanOfficeList ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;

    /**
    * EES_DMT_4017 : [Detailed down Excel 버튼]<br>
    * OTS Clean Detail Excel 다운로드<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OTSCleanDetailExcelListVO>
    * @exception EventException
    */
    public List<OTSCleanDetailExcelListVO> searchOTSCleanDetailExcelList ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;

    /**
     * Sales Team, Sales Rep. 저장 <br>
     * 
     * @param OTSCleanDetailExcelListVO[] oTSCleanDetailExcelListVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
	public void updateOTSCleanDetailListSales(OTSCleanDetailExcelListVO[] oTSCleanDetailExcelListVOs, SignOnUserAccount account ) throws EventException;

    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상]을 [SEARCH] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OTSCleanDetailExcelListVO>
    * @exception EventException
    */
    public List<OTSCleanDetailExcelListVO> searchOTSCleanByDetailList2 ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
    

    /**
 	 * 해당 OTS Back End Job을 실행시킨다.
 	 * 
 	 * @param OtsInquiryParmVO otsInquiryParmVO
     * @param SignOnUserAccount account
 	 * @return String
 	 * @throws EventException
 	 */
    public String dobackEndJobOTS(OtsInquiryParmVO otsInquiryParmVO, SignOnUserAccount account) throws EventException;
    
    /**
 	 * 가상 Invoice 의 상태를 수정한다.
 	 * 
 	 * @param String dmdtInvNo
 	 * @param String dmdtVtInvStsCd
 	 * @param String creOfcCd
 	 * @throws EventException
 	 */
    public void modifyVirtualInvoiceStatus(String dmdtInvNo, String dmdtVtInvStsCd, String creOfcCd) throws EventException;
    
    /**
 	 * BKG No., Tariff Type 에 해당되는 Virtual Invoice 가 존재하는지 조회한다.
 	 * 
 	 * @param String bkgNo
 	 * @param String dmdtTrfCd
 	 * @return String
 	 * @throws EventException
 	 */
    public String searchExistsVirtualInvoice(String bkgNo, String dmdtTrfCd) throws EventException;  
    
    /**
 	 * BKG No., Tariff Type 에 해당되는 Virtual Invoice 를 Cancel 한다.
 	 * 
 	 * @param String bkgNo
 	 * @param String dmdtTrfCd
 	 * @throws EventException
 	 */    
    public void cancelVirtualInvoice(String bkgNo, String dmdtTrfCd) throws EventException;  

    /**
     * [Invoice Create & Issue]을 [조회] 합니다.<br>
     * 
     * @param IssuedInvoiceParamVO  issuedInvoiceParamVO
     * @param SignOnUserAccount account
     * @return List<DmtInvMnVO>
     * @exception EventException
     */
    public List<DmtInvMnVO> searchChargeInvoiceGrpBkgNo(IssuedInvoiceParamVO issuedInvoiceParamVO, SignOnUserAccount account) throws EventException;
    
    /**
     * [INV. 를 생성한 Office 가 자동 A/R I/F 대상인지 여부]를 [조회] 합니다.<br>
     * 
     * @param String dmtOfcCd
     * @return String
     * @exception EventException
     */
    public String searchAutoARInfYnByOffice(String dmtOfcCd) throws EventException;    
    
    /**
     * [ERP 으로부터 수신한 OTS 미수금 수신정보]를 [저장] 합니다.<br>
     * 
     * @param OtsPayRcvVO otsPayRcvVO
     * @exception EventException
     */
    public void addOtsInfo(OtsPayRcvVO otsPayRcvVO) throws EventException;    
    
    /**
     * [ERP 으로부터 수신한 OTS 미수금 납부한 금액이 청구한 금액과 동일한지 여부]를 [조회] 합니다.<br>
     * 
     * @param OtsPayRcvVO otsPayRcvVO
     * @return boolean
     * @exception EventException
     */
    public boolean isOtsCollected(OtsPayRcvVO otsPayRcvVO) throws EventException; 
    
    /**
     * [ERP 으로부터 수신한 OTS 미수금이 완납된 경우 미수금 완납 FLAG]를 [수정] 합니다.<br>
     * 
     * @param OtsPayRcvVO otsPayRcvVO
     * @exception EventException
     */
    public void modifyOtsCollected(OtsPayRcvVO otsPayRcvVO) throws EventException;  
    
    /**
     * [TAB3:A/R Interface Status Inquiry By ERP]을 [조회]합니다.<br>
     * 
     * @param ARInterfaceParmVO arInterfaceParmVO
     * @return List<ARInterfaceStatusVO>
     * @exception EventException
     */
     public List<ARInterfaceStatusVO> searchARInterfaceStatusByERP(ARInterfaceParmVO arInterfaceParmVO) throws EventException;
     
     /**
      * Invoice 발행시 DMT_PAYR_INFO 테이블에 해당 Payer가 등록되어있는지 확인 후 존재하지 않는다면 해당 Payer 정보를 저장한다.
      * 
      * @param String custCd
      * @param SignOnUserAccount account
      * @return boolean
      * @exception EventException
      */
     public boolean checkPayerAndSave(String custCd, SignOnUserAccount account) throws EventException;     

     /**
     * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상]을 [SEARCH] 합니다.<br>
     * 
     * @param OtsInquiryParmVO otsInquiryParmVO
     * @return String
     * @exception EventException
     */
     public String searchOTSInquiryByDetailListInternalRemark ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException;
     
     /**
     * [ 변경된 인도 Tax 적용시점 ( A : After, B : Before ) ]을 [SEARCH] 합니다.<br>
     * 
     * @param String invNo
     * @return String
     * @exception EventException
     */     
     public String searchIdaTaxApplTm(String invNo) throws EventException;
     
     /**
     * [인도OFC 에서 발행된 INVOICE 의 은행계좌정보]를 [SEARCH] 합니다.<br>
     * 
     * @return IdaGstRtoVO
     * @exception EventException
     */     
     public IdaGstRtoVO searchIdaBankInfo() throws EventException;
     
     /**
     * [ 변경된 인도 Tax Ratio ]을 [SEARCH] 합니다.<br>
     * 
     * @param IdaGstRtoCondVO condVO
     * @return IdaGstRtoVO
     * @exception EventException
     */     
     public IdaGstRtoVO searchIdaTaxRto(IdaGstRtoCondVO condVO) throws EventException; 
     
     
     /**
      * [인도 Tax 관련정보]를 [SEARCH] 합니다.<br>
      * 
      * @param ChargeBookingInvoiceVO chgBkgInvVO
      * @param String usrCntCd
      * @exception EventException
      */
      public void setIdaTaxInfo(ChargeBookingInvoiceVO chgBkgInvVO, String usrCntCd) throws EventException;     
      
      /**
       * [인도 invoice 발행시 사용되는 Payer 정보]을 [SEARCH] 합니다.<br>
       * 
       * @param IdaGstRtoCondVO condVO
       * @return IdaGstRtoVO
       * @exception EventException
       */       
       public IdaGstRtoVO searchIdaGstInfo(IdaGstRtoCondVO condVO) throws EventException;
       
       /**
        * [인도 invoice 발행시 사용되는 SM상선 인도 Office 정보]을 [SEARCH] 합니다.<br>
        * 
        * @param IdaGstRtoCondVO condVO
        * @return IdaGstRtoVO
        * @exception EventException
        */       
        public IdaGstRtoVO searchIdaGstInfoByOffice(IdaGstRtoCondVO condVO) throws EventException;
        
      /**
       * [ Invoice No. ]를 [ Generate ] 합니다.<br>
       * 
       * @param InvoiceNoGenVO condVO
       * @return InvoiceNoGenVO
       * @exception EventException
       */  
      public InvoiceNoGenVO generateInvoiceNo(InvoiceNoGenCondVO condVO) throws EventException; 
      
      /**
       * [ Invoice 의 종류 ]를 [ 판별 ] 합니다.<br>
       * 
       * @param String invoiceNo
       * @return String
       * @exception EventException
       */  
      public String searchInvoiceType(String invoiceNo) throws EventException; 
      
      /**
       * [ 인도세법 변경이 시스템에 반영된 날짜 ]을 [ 조회 ] 합니다.<br>
       * 
       * @return String
       * @exception EventException
       */  
      public String searchIdaTaxApplDt() throws EventException;
      
      
      /**
       * [ Invoice ]을(를) [ 발행 ] 합니다.<br>
       * 
       * @param InvoiceGroupMgtVO invoiceGroupMgtVO
       * @param SignOnUserAccount account
       * @return DmtInvMnVO
       * @exception EventException
       */
      public DmtInvMnVO issueInvoice(InvoiceGroupMgtVO invoiceGroupMgtVO, SignOnUserAccount account) throws EventException;
      
      /**
       * [ Invoice ]을(를) [ 전송 ] 합니다.<br>
       * 
       * @param DmtInvMnVO dmdtInvMnVO
       * @param SignOnUserAccount account
       * @return boolean
       * @exception EventException
       */
      public boolean sendInvoiceToAr(DmtInvMnVO dmdtInvMnVO, SignOnUserAccount account) throws EventException;
      
      /**
       * [ Vessel 정보 ]을(를) [ 갱신(수정) ] 합니다.<br>
       * 
       * @param InvoiceIssueMgtVO invoiceIssueMgtVO
       * @exception EventException
       */
      public void modifyVslOfChgBkgCntr(InvoiceIssueMgtVO invoiceIssueMgtVO) throws EventException;

      /**
       * [ Booking 에 속한 Charge 목록 ]을(를) [ 조회 ] 합니다.<br>
       * 
       * @param IssuedInvoiceParamVO issuedInvoiceParamVO
       * @return List<InvoiceIssueVO>
       * @exception EventException
       */
      public List<InvoiceIssueVO> searchChargeBookingInvoiceDetail(IssuedInvoiceParamVO issuedInvoiceParamVO) throws EventException;
      
      /**
       *[  Invoice 를 AR 로 전송 후 반환된 IF No. ]를 [ 수정 ] 합니다.
       * @param String arIfNo
       * @param String invNo
       * @throws EventException
       */
      public void modifyARInterfaceByManual(String arIfNo, String invNo) throws EventException; 
      
      /**
       *[  AR 로 전송하기 위해서 필요한 Dummy Invoice No. ]를 [ 조회 ] 합니다.
       * @param String invNo
       * @return String
       * @throws EventException
       */
      public String searchDummyInvSrcNo(String invNo) throws EventException;
      
  	/**
  	 * [ AFT BKG 승인으로 인해 발행되었던 관련 Invoice 건 ]을 [ 취소 ] 합니다. <br>
  	 * 
  	 * @param AftBkgCxlInvCondVO aftBkgCxlInvCondVO
  	 * @param SignOnUserAccount account
  	 * @return List<CancelInvoiceParamVO>
  	 * @exception EventException
  	 */	
  	public List<CancelInvoiceParamVO> cancelInvoiceByAftBkg(AftBkgCxlInvCondVO aftBkgCxlInvCondVO, SignOnUserAccount account) throws EventException;  
    
  	/**
  	 * [ Cancel 된 Invoice 를 Virtual 상태 ]로 [ 수정 ] 합니다. <br>
  	 * 
  	 * @param List<CancelInvoiceParamVO> cxlInvList
  	 * @exception EventException
  	 */	  	
  	public void modifyInvStsToVtByAftBkg(List<CancelInvoiceParamVO> cxlInvList) throws EventException;
  	
}
