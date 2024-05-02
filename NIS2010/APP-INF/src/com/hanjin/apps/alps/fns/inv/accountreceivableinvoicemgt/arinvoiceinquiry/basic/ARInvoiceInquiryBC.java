/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceInquiryBC.java
*@FileTitle : Invoice Inquiry by I/F No - General
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.12.28 최도순 [CHM-201007700] ALPS AR INV ''Transaction Data Comparison Report'' 기능 개발 요청(신규)
 * 2011.04.18 최도순 [CHM-201109030-01] Intra - Europe Business 관련 VAT 기능 개발
 * 2013.09.23 임옥영 [] Customer Inquiry by B/L No 개발
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.basic;

import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCorrectionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BillInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceByBLNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeByBLNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceInputByBLNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceInquiryInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceIssueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceListByIFDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceNoGoodInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceNoGoodNotIssueListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.BKGForTaxByDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.BKGForTaxByVesselVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.DXBInvoiceListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ErpErrorInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ErpErrorVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.FaxEmailSentDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.FaxEmailSentResultVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.GCFSAFChargeListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.GSTChargeListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceAKLBAVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceDetailVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueListInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueTVAListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceSummaryListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceTermAnalysisInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceTermAnalysisVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NYCInvoiceIssueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotIssuedAgingInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotIssuedAgingVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotIssuedListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotissuedInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.PCFRevExpnAmountVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.PCFStatusInfoInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.PCFStatusInfoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ReportForReverseChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.SpainInvoiceEDIListCountVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.SpainInvoiceEDIListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TransDataComparisonReportInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TransDataComparisonReportVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CustomerListByBLVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.AROfficeListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Accountreceivableinvoicemgt Business Logic Command Interface<br>
 * - ALPS-Accountreceivableinvoicemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author saeil kim
 * @see Fns_inv_0011_01EventResponse 참조
 * @since J2EE 1.4
 */

public interface ARInvoiceInquiryBC {
	/**
	 * 조회 이벤트 처리<br>
	 * Good Date / IF Date 로 invoice 정보를 조회한다.<br>
	 * BL count 및 USD total amount, local total amount 화면하단에 보여줌<br>
	 * max period one office : 1 month, All : 10 days
	 * 
	 * @author JungJin Park
	 * @param ARInvoiceInquiryInPutVO invByGoodVO
	 * @return List<ARInvoiceListByIFDateVO>
	 * @exception EventException
	 */
	public List<ARInvoiceListByIFDateVO> searchARInvoiceListByGoodDate(ARInvoiceInquiryInPutVO invByGoodVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * office별  Invoice 정보를 Office , SA Date or Sailing Date, Confirm Flag, <br>
	 * Issue Flag, Rep customer(해당 office대표Customer) flag, ExRate Flag 조건으로 조회하여 엑셀파일로 생성/저장한다. <br>
	 * 
	 * @author JungJin Park
	 * @param ARInvoiceNoGoodInPutVO noGoodNoIssueVO
	 * @return List<ARInvoiceNoGoodNotIssueListVO>
	 * @exception EventException
	 */
	public List<ARInvoiceNoGoodNotIssueListVO> searchNoGoodNotIssueList(ARInvoiceNoGoodInPutVO noGoodNoIssueVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Invoice 발행 정보를 Invoice No 별로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String invNo
	 * @param String ofc
	 * @return ARInvoiceByBLNoVO
	 * @exception EventException
	 */
	public ARInvoiceByBLNoVO searchInvoiceByInvoiceNo(String invNo, String ofc) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Invoice 정보를 발행일자 기준으로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param InvoiceIssueDateVO issueDateVo
	 * @return List<ARInvoiceIssueDateVO>
	 * @exception EventException
	 */
	public List<ARInvoiceIssueDateVO> searchInvoiceListByIssueDate(InvoiceIssueDateVO issueDateVo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Invoice 정보를 발행일자 기준으로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param  InvoiceIssueDateVO issueDateVo
	 * @return String
	 * @exception EventException
	 */
	public String searchInvoiceListByIssueDateSum(InvoiceIssueDateVO issueDateVo) throws EventException ;

	/**
	 * 조회 이벤트 처리<br>
	 * TVA 관련 charge 포함된 발행된 Invoice 정보를 발행일자로 조회하여 엑셀파일로 다운로드 하는 기능이다.<br>
	 * SGNSC, SYDSC 와 타 오피스 구분처리.
	 * 
	 * @author JungJin Park
	 * @param InvoiceIssueListInputVO invTvaVo
	 * @return List<InvoiceIssueTVAListVO>
	 * @exception EventException
	 */
	public List<InvoiceIssueTVAListVO> searchInvoiceTvaListByDate(InvoiceIssueListInputVO invTvaVo) throws EventException;

	/**
	 * 베트남(SGNSC) Office전용. Date 기준으로 Booking 의 각종 정보들을 구한다. <br>
	 * 
	 * @param String frDate
	 * @param String toDate
	 * @param String port
	 * @return List<BKGForTaxByDateVO>
	 * @exception EventException
	 */
	public List<BKGForTaxByDateVO> searchVIEBookingListByDate(String frDate, String toDate, String port) throws EventException;
		
	/**
	 * 조회 이벤트 처리<br>
	 * 매출채권 및 Invoice 정보를 B/L No 로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param ARInvoiceInputByBLNoVO invInput
	 * @return ARInvoiceByBLNoVO
	 * @exception EventException
	 */
	public ARInvoiceByBLNoVO searchARInvoiceByBLNo(ARInvoiceInputByBLNoVO invInput) throws EventException;
	
	/**
	 * VVD 기준으로 Booking 의 각종 정보들을 구한다. <br>
	 * 
	 * @param String vvd
	 * @return List<BKGForTaxByVesselVO>
	 * @exception EventException
	 */
	public List<BKGForTaxByVesselVO> searchThaiBookingListByVVD(String vvd) throws EventException;

	/**
	 * VVD or S/A date기준으로 India 지역 Office의 해당 국가 PORT관련 Booking rate 및 cntr 정보들을 구한다. <br>
	 * 
	 * @param ARInvoiceInquiryInPutVO indBkgVO 
	 * @return List<BKGForTaxByVesselVO>
	 * @exception EventException
	 */
	public List<BKGForTaxByVesselVO> searchIndiaBookingListByVVD(ARInvoiceInquiryInPutVO indBkgVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * 매출채권 및 Invoice 정보를 Interface No 로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String ifNo
	 * @param String ofc
	 * @return ARInvoiceCorrectionVO
	 * @exception EventException
	 */
	public ARInvoiceCorrectionVO searchARInvoiceByIFNo (String ifNo, String ofc) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Invoice 의 Fax 및 E-mail 발송 결과와 현황을 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param FaxEmailSentDateVO sendDateVo
	 * @return List<FaxEmailSentResultVO>
	 * @exception EventException
	 */
	public List<FaxEmailSentResultVO> searchFaxEmailSentResultListBySendDate (FaxEmailSentDateVO sendDateVo) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Spain(VLCSC)전용 Invoice 파일 다운로드기능.<br>
	 * Local System에 데이터  Upload하기 위해 요청된 format으로 엑셀파일 다운로드 하는 기능이다.<br>
	 * Invoice EDI for VLC인 경우는 issue date 를 기준으로 하며 Invoice Statusfor VLC를 조건으로 하는 경우는  
	 * Good date(BL_INV_CFM_DT)를 기준으로 조회조건에 해당하는 데이터를  조회하여 엑셀파일로 생성한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String ofcCd
	 * @param String issDate
	 * @return List<SpainInvoiceEDIListVO>
	 * @exception EventException
	 */
	public List<SpainInvoiceEDIListVO> searchSpainInvoiceList (String ofcCd, String issDate) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * 매출채권 발생과 Invoice 발행사이의 Average Term 을 date 별로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param InvoiceTermAnalysisInputVO invTermAnlsVo
	 * @return List<InvoiceTermAnalysisVO>
	 * @exception EventException
	 */
	public List<InvoiceTermAnalysisVO> searchInvoiceIssueTermByDate (InvoiceTermAnalysisInputVO invTermAnlsVo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Invoice Detail Inquiry by Date & Charge 의 데이타를 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param ARInvoiceInquiryInPutVO invDtlVO
	 * @return InvoiceDetailVO
	 * @exception EventException
	 */
	public InvoiceDetailVO searchDetailInvoiceListByDate (ARInvoiceInquiryInPutVO invDtlVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Customer 별로 미발행 Invoice 현황을 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param NotissuedInputVO notIssVo
	 * @return List<NotIssuedListVO>
	 * @exception EventException
	 */
	public List<NotIssuedListVO> searchNotIssueListByCustomer (NotissuedInputVO notIssVo) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Customer 별로 미발행 Invoice 의 전체 건수를 기간별로 보여준다.<br>
	 * 
	 * @author JungJin Park
	 * @param NotIssuedAgingInputVO notIssAgingVo
	 * @return List<NotIssuedAgingVO>
	 * @exception EventException
	 */
	public List<NotIssuedAgingVO> searchNotIssueAgingByCustomer (NotIssuedAgingInputVO notIssAgingVo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * 매출채권 및 Invoice 의 Summary(일자별 집계) 현황을 Date 기준으로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param ARInvoiceInquiryInPutVO invSumVo
	 * @return List<InvoiceSummaryListVO>
	 * @exception EventException
	 */
	public List<InvoiceSummaryListVO> searchSummaryInvoiceListByDate (ARInvoiceInquiryInPutVO invSumVo) throws EventException;

	/**
	 * POP-UP 화면에서 Invoice 정보를 발행일자 기준으로 조회한다.(Re-Issue 화면에서 사용). <br>
	 * 
	 * @param InvoiceIssueDateVO issueDateVo
	 * @return List<ARInvoiceIssueDateVO>
	 * @exception EventException
	 */
	public List<ARInvoiceIssueDateVO> searchPopInvoiceListByIssueDate(InvoiceIssueDateVO issueDateVo) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * A/R HEAD QUARTER OFFICE CODE를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchARRHQOfficeList() throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * BOMSC 지역이외 Office 에서 GST Charge 가 Rating 된 현황을 Date 별로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String dateOption
	 * @param String fromDate
	 * @param String toDate
	 * @param String rhq
	 * @return List<GSTChargeListVO>
	 * @exception EventException
	 */
	public List<GSTChargeListVO> searchGSTListByDate (String dateOption, String fromDate, String toDate, String rhq) throws EventException;

	/**
	 * POP-UP 화면에서 Invoice 정보를 발행일자 기준으로 조회한다.(Re-Issue 화면에서 사용). <br>
	 * 
	 * @param InvoiceIssueDateVO issueDateVo
	 * @return List<ARInvoiceListByIFDateVO>
	 * @exception EventException
	 */
	public List<ARInvoiceListByIFDateVO> searchPopSGNBBInvoiceListByIssueDate (InvoiceIssueDateVO issueDateVo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Sales Office의 A/R OFFICE CODE의 정보(INV_AR_STUP_OFC- INV_DUP_FLG)를 조회한다. <br>
	 * 
	 * @author JungJin Park
	 * @param String saleOfc
	 * @return AROfficeListVO
	 * @exception EventException
	 */
	public AROfficeListVO searchAROffice (String saleOfc) throws EventException;
	
	/**
	 * FNS_INV_0110<br>
	 * Issue 대상 (DXBSC)INV B/L을 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<DXBInvoiceListVO>
	 * @exception EventException
	 */
	public List<DXBInvoiceListVO> searchDXBInvoiceList(GeneralInvoiceVO genInvVo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * INV_AR_LOCL_CHG 있는 ar_ofc_cd를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchLoclChgOfc() throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Spain(VLCSC)전용 Invoice 파일 다운로드기능.<br>
	 * Local System에 데이터  Upload하기 위해 요청된 format으로 텍스트파일 다운로드 하는 기능이다.<br>
	 * Invoice EDI for VLC인 경우는 issue date(입력된 일자로부터 -6일간)를 기준으로 하며 
	 * EDI send date가 없는 해당하는 데이터를 조회하여 텍스트파일로 생성한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String issDate
	 * @return SpainInvoiceEDIListCountVO
	 * @exception EventException
	 */
	public SpainInvoiceEDIListCountVO searchSpainInvoiceListCount (String ofcCd, String issDate) throws EventException;
	
	
	/**
	 * FNS_INV_0115 조회 이벤트 처리<br>
	 * ERP I/F Error내역을 조회한다.<br>
	 * 
	 * @author KIM HYUN HWA
	 * @param ErpErrorInputVO erpErrorInputVO
	 * @return List<ErpErrorVO>
	 * @exception EventException
	 */
	public List<ErpErrorVO> searchErpErrorList(ErpErrorInputVO erpErrorInputVO) throws EventException;
	
	/**
	 * FNS_INV_0115 조회 이벤트 처리<br>
	 * RHQ Office list를 조회한다.<br>
	 * 
	 * @author KIM HYUN HWA
	 * @param String useOfc
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchARRhqList(String useOfc) throws EventException;
	
	/**
	 * FNS_INV_0115 조회 이벤트 처리<br>
	 * AR Office List를 조회한다.<br>
	 * 
	 * @author KIM HYUN HWA
	 * @param String rhq
	 * @param String usrOfc
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchAROfficeListByRhq(String rhq, String usrOfc ) throws EventException;
	
	/**
	 * AR Invoice에서 ERP로 I/F한  Transaction을 조회한다.
	 * 
	 * @param TransDataComparisonReportInputVO transDataComparisonReportInputVO
	 * @return  List<TransDataComparisonReportVO>
	 * @exception EventException
	 */
	public List<TransDataComparisonReportVO> searchTransactionDataComparisonReportList( TransDataComparisonReportInputVO transDataComparisonReportInputVO) throws EventException;
	
	/**
	 * AR에서 발생된 "Reverse Charge" Data 산출기능<br>
	 * 
	 * @param String arOfcCd
	 * @param String fmDt
	 * @param String toDt
	 * @return List<ReportForReverseChargeVO>
	 * @exception EventException
	 */
	public List<ReportForReverseChargeVO> searchReportForReverseChargeList(String arOfcCd, String fmDt, String toDt) throws EventException ;

	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Split된 Invoice 발행 정보를 Bl No 별로 조회한다.<br>
	 * 
	 * @param blNo
	 * @param ofc
	 * @return
	 * @throws EventException
	 */
	public List<ARInvoiceChargeByBLNoVO> searchOtherSplitInvoicesForBL(String blNo, String ofc) throws EventException;

	
	/**
	 * POP-UP 화면에서 Invoice 정보를 발행일자 기준으로 조회한다.(Re-Issue 화면에서 사용).-SAOBB <br>
	 * 
	 * @param InvoiceIssueDateVO issueDateVo
	 * @return List<ARInvoiceIssueDateVO>
	 * @exception EventException
	 */
	public List<ARInvoiceIssueDateVO> searchPopSplitInvoiceListByIssueDate(InvoiceIssueDateVO issueDateVo) throws EventException;

	/**BC
	 * 조회 이벤트 처리<br>
	 * 사용자가 EXCEL로 업로드한 Bl No의 Customer정보를 조회한다.<br>
	 * 
	 * @param blNos
	 * @return List<CustomerListByBLVO>
	 * @throws EventException
	 */
	public List<CustomerListByBLVO> searchCustomerListByBL(String blNos) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * AKLBA의 Invoice Deatil 정보를 조회한다.<br>
	 * 
	 * 
	 * @param BillInputVO billInputVO
	 * @return List<InvoiceAKLBAVO>
	 * @exception EventException
	 */
	public List<InvoiceAKLBAVO> searchInvoiceDetailForAKLBA(BillInputVO billInputVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Invoice 정보를 발행일자 기준으로 조회한다.<br>
	 * 
	 * @author Dosoon Choi
	 * @param  InvoiceIssueDateVO issueDateVo
	 * @return List<NYCInvoiceIssueDateVO>
	 * @exception EventException
	 */
	public List<NYCInvoiceIssueDateVO> searchNYCInvoiceListByIssueDate(InvoiceIssueDateVO issueDateVo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * RHQ를 조건으로 BOMSC Office 아닌 타 Office 의 채권 데이터중 Option에 따라서 I/F date or S/A date를 비교하여 "GST"CHarge 가 있는 대상을 조회하여 USD, INR Currnecy로 환산하여 보여줌.<br>
	 * USD, INR Currnecy환산금액은 채권데이터의 GL_EFF_DT기준 경리환율로 계산한다.<br>
	 * 
	 * @author Seungil Baek
	 * @param String dateOption
	 * @param String fromDate
	 * @param String toDate
	 * @param String rhq
	 * @param String chgCd
	 * @param String scNo
	 * @return List<GCFSAFChargeListVO>
	 * @exception EventException
	 */
	public List<GCFSAFChargeListVO> searchGCFSAFListByData (String dateOption, String fromDate, String toDate, String rhq, String chgCd, String scNo) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * A/R HEAD QUARTER OFFICE CODE를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchGCFSAFRHQOfficeList() throws EventException;
	
	/**
	 * PCF Revenue, Expense 요율을 조회한다.<br>
	 * 
	 * @author SungYong Park
	 * @param String portCd
	 * @param String reDivrCd
	 * @return List<PCFRevExpnAmountVO>
	 * @exception EventException
	 */
	public List<PCFRevExpnAmountVO> searchPCFRevExpnAmount(String portCd, String reDivrCd) throws EventException;
	
	/**
	 *  PCF 의 Revenue 및 Expense 요율을 등록/수정/삭제한다.<br>
	 * 
	 * @param PCFRevExpnAmountVO[] pcfRevExpnAmountVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void managePCFRevExpnAmount(PCFRevExpnAmountVO[] pcfRevExpnAmountVOs, String userId) throws EventException;
	
	/**
	 * PCF status 정보를 조회한다.<br>
	 * 
	 * @author SungYong Park
	 * @param PCFStatusInfoInputVO pcfStatusInfoInputVo
	 * @return List<PCFStatusInfoVO>
	 * @exception EventException
	 */
	public List<PCFStatusInfoVO> searchPCFStatusInfo(PCFStatusInfoInputVO pcfStatusInfoInputVo) throws EventException;
}
