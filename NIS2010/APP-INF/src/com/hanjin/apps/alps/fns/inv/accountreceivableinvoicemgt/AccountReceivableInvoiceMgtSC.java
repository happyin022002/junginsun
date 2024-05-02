/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableInvoiceMgtSC.java
 *@FileTitle : (Korea) Terminal GIRO Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.27
 *@LastModifier : 정휘택
 *@LastVersion : 1.0
 * 2009.04.27 정휘택
 * 1.0 Creation
-------------------------------------------------------------
 * History
 * 2011.11.25 이석준 CHM-201006884 MQ Receive function 추가
 * 2010.12.22 최도순 [CHM-201006644] 최도순 NIKE, Invoice EDI 신규 개발 요청
 * 2010.12.28 최도순 [CHM-201007700] ALPS AR INV ''Transaction Data Comparison Report'' 기능 개발 요청(신규) 
 * 2011.01.24 최도순 [CHM-201108418] 베트남지역 ALPS INVOICE 변경 요청
 * 2011.02.14 최도순 [CHM-201006644] NIKE, Invoice EDI 신규 개발 요청
 * 2011.04.18 최도순 [CHM-201109030-01] Intra - Europe Business 관련 VAT 기능 개발
 * 2011.08.04 오요한 [CHM-201111930] Invoice Issue 프로그램 개선
 * 2011.10.26 권   민 [CHM-201114097] (Spain) Invoice Download for EDI
 * 2012.02.01 권   민 [CHM-201215781-01] [INV] ALPS INV 중복 발행 시 알림창 pop up
 * 2012.04.27 김상현 [CHM-201216976] DHL EDI 개발 요청
 * 2012.05.21 김상현 [CHM-201216580] Honey Well EDI 작업
 * 2012.06.20 김상현 [CHM-201218417] 삼성전자 EDI TIME OUT 방지 logic 보완 요청
 * 2012.11.21 오요한 [] Item Correction 시 최신 I/F 여부 check 로직에서 MRI Type 제외
 * 2012.12.04 오요한 [CHM-201221542] AR INV > PHILIPS EDI 개발 요청
* 2013.09.23 임옥영 [] Customer Inquiry by B/L No 개발
* 2014.08.26 최도순 [CHM-201431413] 미주지역 Inv Issue 프로그램 개발 요청
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCreditVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CancelInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExRateCountVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArAmtVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvNewCustVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.SysClearVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.basic.ManualARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.basic.ManualARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.basic.ARInvoiceExRateMgtBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.basic.ARInvoiceExRateMgtBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0008Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedireceive.basic.AccountReceivableEDIReceiveBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedireceive.basic.AccountReceivableEDIReceiveBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedireceive.event.UbizhjsAlpsinvCommonEvent;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedireceive.event.UbizhjsAlpsinvGlovisEvent;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.basic.AccountReceivableEDISendBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.basic.AccountReceivableEDISendBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event.FnsInv0045Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event.FnsInv0111Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event.FnsInv0112Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event.FnsInv0113Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event.FnsInv0124Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event.FnsInv0125Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event.FnsInv0132Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event.FnsInv0144Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event.FnsInv0145Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.GlovisInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HNWLInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HPInvoiceEDIVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.MGBInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.NikeInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungEDIBLChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungInvoiceEDIVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungMSGVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic.ARInvoiceCorrectionBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic.ARInvoiceCorrectionBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0016Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0017Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0018Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0026Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0027Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0028Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0029Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0033Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0043Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0079Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv009401Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv009402Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0097Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0098Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0119Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0122Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0130Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCorrectionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceListByVesselMultiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceListByVesselVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceSplitVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BkgNoCaNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DirectBillingInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArEuCntVatVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvIssAtchVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.MDMCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.MarkingReverseChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.UnmatchRevenueVesselVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.basic.ARInvoiceInquiryBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.basic.ARInvoiceInquiryBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0009Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0011Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0031Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0032Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0053Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0054Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0055Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0056Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0057Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0058Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0059Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0062Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0066Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0067Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0068Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0069Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0083Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0084Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0085Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0106Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0109Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0110Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0115Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0116Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0120Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0131Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0137Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0138Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0141Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0146Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0147Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceByBLNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeByBLNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceIssueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceListByIFDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceNoGoodNotIssueListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.BKGForTaxByDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.BKGForTaxByVesselVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CustomerListByBLVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.DXBInvoiceListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ErpErrorVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.FaxEmailSentResultVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.GCFSAFChargeListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.GSTChargeListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceDetailListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceDetailVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueTVAListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceSummaryListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceTermAnalysisVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotIssuedAgingVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotIssuedListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NYCInvoiceIssueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.PCFRevExpnAmountVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.PCFStatusInfoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ReportForReverseChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.SpainInvoiceEDIListCountVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.SpainInvoiceEDIListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TransDataComparisonReportVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceAKLBAVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic.InvoiceIssueBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic.InvoiceIssueBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv003401Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv003402Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0035Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0036Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0037Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0038Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0039Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0050Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0052Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0064Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0065Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0087Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0088Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0096Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0103Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0104Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0129Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0139Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration.InvoiceIssueDBDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CHNIssuedInvoiceListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CHNReissuedInvoiceListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArEmlCustRgstVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArGiroVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArSplitIssChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArSplitIssVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvEmlVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceFaxEmailListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceIssueSndToErpVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueEachTargetVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueOptionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.KORGiroListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.KORInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.NYCEmlVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.NYCInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.PrintInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.TemplateItemVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.TemplateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIECombineInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEDailyExrateReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEDailyExrateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEInvoiceTargetVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.basic.INVCommonUtil;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.AROfficeListVO;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.log4j.StringUtils;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComBakEndJbVO;
import com.hanjin.syscommon.common.table.InvArIssVO;
import com.hanjin.syscommon.common.table.MdmChargeVO;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;
import com.hanjin.syscommon.common.table.PriRatUtVO;
import com.hanjin.syscommon.common.util.ScheduleUtil;
 
/**
 * ALPS-AccountReceivableInvoiceMgt Business Logic ServiceCommand - ALPS-AccountReceivableInvoiceMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Jung Hwi Taek
 * @see InvoiceIssueDBDAO
 * @since J2EE 1.4
 */

public class AccountReceivableInvoiceMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * AccountReceivableInvoiceMgt system 업무 시나리오 선행작업<br>
	 * FNS_INV_0064업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());

		}
	}

	/**
	 * AccountReceivableInvoiceMgt system 업무 시나리오 마감작업<br>
	 * FNS_INV_0064 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("AccountReceivableInvoiceMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-AccountReceivableInvoiceMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("FnsInv0064Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKORGIROList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchARInvoiceListByGoodDate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNoGoodNotIssueList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceByInvoiceNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0054Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceListByIssueDate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0055Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceTvaListByDate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0026Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchARInvoiceListByVVD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyInvoiceUserID(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOfficeScopeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0087Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceRemark(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0083Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVIEBookingListByDate(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				//eventResponse = otherIFExecute(e);
				eventResponse = otherIFAddMain(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchARInvoiceByBLNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAROffice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0084Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchThaiBookingListByVVD(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0085Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIndiaBookingListByVVD(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchARInvoiceByIFNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv003401Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceCopyCnt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = issueGeneralInvoiceBackEndJobStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = issueGeneralInvoiceBackEndJobFile(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchErrorBLNumberList(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchAlreadyIssuedList(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = search3rdCheckList(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = issueGeneralInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = issueGeneralInvoiceBackEndJobKey(e);			
			}	
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOTSSummary(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchARInvoiceByBL(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyARInvoiceByBL(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDueDate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0035Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceCopyCnt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPrintInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPrintSplitInvoice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0097Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceWording(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyInvoiceWording(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeInvoiceWording(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv003402Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchIssuedGeneralInvoiceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAttachFileKey(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createIssueMain(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0059Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFaxEmailSentResultListBySendDate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0062Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSpainInvoiceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOfficeLocalTime(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyEDISendDate(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = modifyEDISendDataRelease(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0058Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceIssueTermByDate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0098Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContainerNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0067Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDetailInvoiceListByDate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOfficeChgCodeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0057Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNotIssueListByCustomer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0056Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNotIssueAgingByCustomer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0038Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCHNInvoiceForIssue(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = issueCHNInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAROfficePrinterName(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0066Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSummaryInvoiceListByDate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOfficeChgCodeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0106Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopInvoiceListByIssueDate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPopSplitInvoiceListByIssueDate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0096Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCHNInvoiceForReissue(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = reissueCHNInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAROfficePrinterName(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchARInvoiceListByDate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchARCustomerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyARInvoiceListByDate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv009401Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChangeCustomerInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createCustomerChangeInvoice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv009402Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChangeCustomerInvoiceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRepCustomer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createCustomerChangeInvoiceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createCustomerChangeInvoiceListBackEndJobKey(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = createCustomerChangeInvoiceListBackEndJobStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = createCustomerChangeInvoiceListBackEndJobFile(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifySysClearList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifySysClearListByIfNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = modifyExchangeRateListBackEndJobKey(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = modifyExchangeRateListBackEndJobStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = modifyExchangeRateListBackEndJobFile(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0103Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCPRTHistoryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCPRTIDList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0043Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDirectBilling(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0069Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchGSTListByDate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchARRHQOfficeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0068Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchGCFSAFListByData(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGCFSAFRHQOfficeList(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0039Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKORInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchKORIssueTargetByBL(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = printKORInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAROfficePrinterName(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSplitARInvoiceByIFNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = splitARInvoiceByIFNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSplitARInvoiceByInvoiceNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = splitARInvoiceByInvoiceNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0050Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCPRTInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTemplateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTemplateItemList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchBlNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = issueCPRTInvoice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0052Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKORGIRO(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageKORGIRO(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = removeKORGIRO(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAROfficePrinterName(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchIssuedGeneralInvoiceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAttachFileKey(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createIssueMain(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createManualInterface(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManualInterface(e);
			}/*else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = createBKGInvoiceBackEndJobStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = createBKGInvoiceBackEndJobFile(e);
			}*/
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0079Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUnmatchRevenueVVDListByDate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = createUnmatchRevenueVVDListByDateBatchJobID(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = createUnmatchRevenueVVDListByDateBatchJobStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createNewRevenueVVD(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSamsungEDIMSGNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSamsungAREDIList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createSamsungAREDIList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = removeSamsungAREDIList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = sendSamsungAREDIList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSamsungEDIByBL(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0065Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSWAIssuedInvoiceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createVIEActualInvoiceNumber(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0109Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopSGNBBInvoiceListByIssueDate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = issueVIESingleInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVIEDailyExRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = issueVIESingleInvoicePreview(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVIEVATCharge(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0088Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVIECombineBLNoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = issueVIECombinedInvoice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0110Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDXBInvoiceList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0111Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHPInvoiceEDIList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = sendHPEDIList(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("UbizhjsAlpsinvGlovisEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				receiveEdiFromGlovis(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("FnsInv0113Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEdiGlovisList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = sendEdiGlovisList(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0112Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEdiNikeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = sendEdiNikeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0124Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // Get EDI list to DHL.
				eventResponse = searchEdiDHLList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // Set EDI to DHL.
				eventResponse = addEdiDHL(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0125Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchEdiHNWLList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = addEdiHNWL(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0115Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchARRhqList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAROfficeListByRhq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchErpErrorList(e);
			} 
			
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0116Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransactionDataComparisonReportList(e);
			} 			
		} else if (e.getEventName().equalsIgnoreCase("UbizhjsAlpsinvCommonEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				receiveCommonEdi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				receiveEdiFromEurEmailServer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0119Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVatRatioEntryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEuroCountryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVatRatioEntry(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0120Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReportForReverseChargeList(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0122Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMarkingReverseChargeByIfNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMarkingReverseChargeByIfNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0129Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchEmlCustRgst(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
                eventResponse = manageEmlCustRgst(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
                eventResponse = searchOfcOpt(e);
			}
        } else if(e.getEventName().equalsIgnoreCase("FnsInv0130Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
                eventResponse = searchSplitARInvoiceByBL(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
                eventResponse = splitARInvoiceByBL(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
                eventResponse = searchIssuedGeneralInvoiceList(e);	
            }
        }  else if(e.getEventName().equalsIgnoreCase("FnsInv0131Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOtherSplitInvoicesForBL(e);
			}
		}  else if(e.getEventName().equalsIgnoreCase("FnsInv0132Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchEdiPHILSList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
                eventResponse = addEdiPHILS(e);
            }
		}  else if(e.getEventName().equalsIgnoreCase("FnsInv0137Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCustomerListByBL(e);
			}
		}  	else if (e.getEventName().equalsIgnoreCase("FnsInv0138Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceDetailForAKLBA(e);
			}
		}	else if (e.getEventName().equalsIgnoreCase("FnsInv0139Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceCopyCnt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchNYCIssueTarget(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchErrorBLNumberList(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchAlreadyIssuedList(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = sendNYCInvoiceByFaxEmail(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0141Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNYCInvoiceListByIssueDate(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("FnsInv0144Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEdiMGBList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = sendEdiMGBList(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("FnsInv0145Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchEdiADIDASList(e); 
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = addEdiADIDAS(e);
			} 
		}  else if (e.getEventName().equalsIgnoreCase("FnsInv0146Event")) {		//2018.06.21 Revenue & Expense Creation/Inquiry 신규 개발
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPCFRevExpnAmount(e); 
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePCFRevExpnAmount(e);
			} 
		}  else if (e.getEventName().equalsIgnoreCase("FnsInv0147Event")) {		//2018.06.21 PCF Status Report 신규 개발
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPCFStatusInfo(e); 
			}
		}
		
		return eventResponse;
	}
	

	/**
	 * FNS_INV_0064 : Retrieve <br>
	 * Terminal Invoice 의 GIRO 정보를 다수 조회한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKORGIROList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0064Event event = (FnsInv0064Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			
//			log.info("\n########## event.getKORGiroInputVO().getArOfcCd()1 : "+event.getKORGiroInputVO().getArOfcCd());
//			log.info("\n########## event.getKORGiroInputVO().getArOfcCd()2 : "+event.getKORGiroInputVO().getArOfcCd2());
			
			List<KORGiroListVO> list = command.searchKORGIROList(event.getKORGiroInputVO());
			
			if (list != null && list.size() > 0) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0031 : Retrieve<br>
	 * 매출채권 및 Invoice 정보를 Interface Date 로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARInvoiceListByGoodDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0031Event event = (FnsInv0031Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ARInvoiceListByIFDateVO> list = command.searchARInvoiceListByGoodDate(event.getInvByGoodVO());
			if (list != null && list.size() > 0) {
				eventResponse.setRsVoList(list);
				
				eventResponse.setETCData("bl_count", list.get(0).getInvoiceSumVO().getBlCount());
				eventResponse.setETCData("usd_total", list.get(0).getInvoiceSumVO().getGrandUsdTotal());
				eventResponse.setETCData("lcl_total", list.get(0).getInvoiceSumVO().getGrandLclTotal());

				eventResponse.setETCData("dp_prcs_knt", list.get(0).getDpPrcsKnt());
				eventResponse.setETCData("dp_prcs_knt_local", list.get(0).getDpPrcsKntLcl());
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());

				eventResponse.setETCData("bl_count", "0");
				eventResponse.setETCData("usd_total", "0");
				eventResponse.setETCData("lcl_total", "0");

				eventResponse.setETCData("dp_prcs_knt", "0");
				eventResponse.setETCData("dp_prcs_knt_local", "0");
			}
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0032 : Retrieve<br>
	 * office별 Invoice 정보를 데이터 다운로드를 위한 데이터 구성한다. <br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoGoodNotIssueList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0032Event event = (FnsInv0032Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ARInvoiceNoGoodNotIssueListVO> list = command.searchNoGoodNotIssueList(event.getNoGoodNoIssueVO());
			if (list != null && list.size() > 0) {
				eventResponse.setRsVoList(list);
			}
			else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0053 : Retrieve<br>
	 * Invoice 발행 정보를 Invoice No 별로 조회한다. <br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceByInvoiceNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0053Event event = (FnsInv0053Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		ARInvoiceByBLNoVO aRInvoiceByBLNoVO = new ARInvoiceByBLNoVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			aRInvoiceByBLNoVO = command.searchInvoiceByInvoiceNo(event.getInvNo(), event.getOfc());

			if (aRInvoiceByBLNoVO != null) {
				eventResponse.setRsVo(aRInvoiceByBLNoVO);
				//eventResponse.setRsVoList(aRInvoiceByBLNoVO.getListInvoiceChargeSumVO());
				eventResponse.setRsVoList(aRInvoiceByBLNoVO.getListInvoiceChargeByBLNoVO());

				if (aRInvoiceByBLNoVO.getListInvoiceChargeByBLNoVO() != null && aRInvoiceByBLNoVO.getListInvoiceChargeByBLNoVO().size() > 0) {
					eventResponse.setETCData("dp_prcs_knt", aRInvoiceByBLNoVO.getListInvoiceChargeByBLNoVO().get(0).getDpPrcsKnt());
					eventResponse.setETCData("dp_prcs_knt_local", aRInvoiceByBLNoVO.getListInvoiceChargeByBLNoVO().get(0).getDpPrcsKntLocal());
				} else {
					eventResponse.setETCData("dp_prcs_knt", "0");
					eventResponse.setETCData("dp_prcs_knt_local", "0");
				}
			} else {
				aRInvoiceByBLNoVO = new ARInvoiceByBLNoVO();

				eventResponse.setRsVo(aRInvoiceByBLNoVO);
				//eventResponse.setRsVoList(aRInvoiceByBLNoVO.getListInvoiceChargeSumVO());
				eventResponse.setRsVoList(aRInvoiceByBLNoVO.getListInvoiceChargeByBLNoVO());

				eventResponse.setETCData("dp_prcs_knt", "0");
				eventResponse.setETCData("dp_prcs_knt_local", "0");

				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0054 : Retrieve<br>
	 * Invoice 정보를 발행일자 기준으로 조회한다. <br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceListByIssueDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		FnsInv0054Event event = (FnsInv0054Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<ARInvoiceIssueDateVO> list = command.searchInvoiceListByIssueDate(event.getInvoiceIssueDateVO());
			String ttl_locl_amt = command.searchInvoiceListByIssueDateSum(event.getInvoiceIssueDateVO());

			if (list != null && list.size() > 0) {
				eventResponse.setRsVoList(list);

				eventResponse.setETCData("dp_prcs_knt", list.get(0).getDpPrcsKnt());
				eventResponse.setETCData("dp_prcs_knt_local", list.get(0).getDpPrcsKntLocal());
				eventResponse.setETCData("ttl_locl_amt", ttl_locl_amt);
			} else {
				eventResponse.setETCData("dp_prcs_knt", "0");
				eventResponse.setETCData("dp_prcs_knt_local", "0");
				eventResponse.setETCData("ttl_locl_amt", "");

				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0055 : Retrieve<br>
	 * 구주지역 TVA 관련 발행된 Invoice date를 조회하여 Excel파일로 저장한다. <br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceTvaListByDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0055Event event = (FnsInv0055Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<InvoiceIssueTVAListVO> list = command.searchInvoiceTvaListByDate(event.getInvoiceIssueListInputVO());
			if (list != null && list.size() > 0) {
				eventResponse.setRsVoList(list);
			}
			else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0026 : Retrieve<br>
	 * VVD 별로 Invoice 의 Item 들을 조회한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARInvoiceListByVVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0026Event event = (FnsInv0026Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		ARInvoiceListByVesselMultiVO aRInvoiceListByVesselMultiVO = new ARInvoiceListByVesselMultiVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			aRInvoiceListByVesselMultiVO = command.searchARInvoiceListByVVD(event.getInvByVVDVo());

			// List<ARInvoiceListByVesselVO> list = command.searchARInvoiceListByVVD(event.getInvByVVDVo());

			eventResponse.setRsVoList(aRInvoiceListByVesselMultiVO.getListARInvoiceListByVesselVO());
			eventResponse.setETCData("sa_date", aRInvoiceListByVesselMultiVO.getSaDate());
			eventResponse.setETCData("inv_xch_rt", aRInvoiceListByVesselMultiVO.getInvXchRt());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0026 : Open<br>
	 * 화면 로딩시 office code 와 scope code를 조회한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeScopeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0026Event event = (FnsInv0026Event) e;
		INVCommonUtil command = new INVCommonUtil();
		List<String> list = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			//ofc_cd
			list = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			String ar_ofc_info = "";
			StringBuffer arOfcInfoBuff = new StringBuffer();
			for (int i = 0; i < list.size(); i++) {
				arOfcInfoBuff.append("|" + list.get(i));
				//ar_ofc_info = ar_ofc_info + "|" + list.get(i);
			}
			ar_ofc_info = arOfcInfoBuff.toString();
			//scope cd
			List<String> list2 = command.searchServiceScopeList();

			String svcCd = "ALL";
			StringBuffer svcCdBuff = new StringBuffer();
			for (int i = 0; i < list2.size(); i++) {
				svcCdBuff.append("|" + list2.get(i));
				//svcCd = svcCd + "|" + list2.get(i);
			}
			svcCd = svcCdBuff.toString();
			svcCd = svcCd + "|" + "OTH";			
			
			eventResponse.setETCData("ar_ofc_cd", ar_ofc_info);
			eventResponse.setETCData("svc_scp_cd1", svcCd);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0026 : Save<br>
	 * Invoice 의 User ID 를 Update 한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyInvoiceUserID(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0026Event event = (FnsInv0026Event) e;
		BookingARCreationBC command = new BookingARCreationBCImpl();
		try {
			begin();
			ARInvoiceListByVesselVO[] aRInvoiceListByVesselVO = event.getARInvoiceListByVesselVOS();
			for (int i = 0; i < aRInvoiceListByVesselVO.length; i++) {
				String arIfNo = aRInvoiceListByVesselVO[i].getArIfNo();
				command.modifyInvoiceUserID(arIfNo, account.getUsr_id());
			}
			// 에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			// eventResponse.setUserMessage("OK");
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Invoice Remark(s)의 event에 대한 조회 이벤트 처리<br>
	 * 
	 * @author Jung Hwi Taek
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceRemark(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0087Event event = (FnsInv0087Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<InvArIssVO> list = command.searchInvoiceRemark(event.getInvArIssVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0083 : Retrieve <br>
	 * 베트남(SGNSC) OFFICE의 Date 기준으로 Booking 의 각종 정보들을 구한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVIEBookingListByDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0083Event event = (FnsInv0083Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<BKGForTaxByDateVO> list = command.searchVIEBookingListByDate(event.getSaDt1(), event.getSaDt2(), event.getPol());

			if (list != null && list.size() > 0) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0009 : Retrieve<br>
	 * 매출채권 및 Invoice 정보를 B/L No 로 상세 정보 및 Histroy를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARInvoiceByBLNo(Event e) throws EventException {
		FnsInv0009Event event = (FnsInv0009Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();

		ARInvoiceByBLNoVO aRInvoiceByBLNoVO = new ARInvoiceByBLNoVO();

		try {
			aRInvoiceByBLNoVO = command.searchARInvoiceByBLNo(event.getARInvoiceInputByBLNoVO());

			if (aRInvoiceByBLNoVO != null && aRInvoiceByBLNoVO.getBlSrcNo() != null) {
				if (aRInvoiceByBLNoVO.getListInvoiceChargeSumVO() != null && aRInvoiceByBLNoVO.getListInvoiceChargeSumVO().size() > 0) {
					eventResponse.setETCData("dp_prcs_knt", aRInvoiceByBLNoVO.getListInvoiceChargeSumVO().get(0).getDpPrcsKnt());
					eventResponse.setETCData("dp_prcs_knt_local", aRInvoiceByBLNoVO.getListInvoiceChargeSumVO().get(0).getDpPrcsKntLocal());
				} else {
					eventResponse.setETCData("dp_prcs_knt", "0");
					eventResponse.setETCData("dp_prcs_knt_local", "0");
				}
				
				eventResponse.setRsVo(aRInvoiceByBLNoVO);
				eventResponse.setRsVoList(aRInvoiceByBLNoVO.getListInvoiceChargeSumVO());
				eventResponse.setRsVoList(aRInvoiceByBLNoVO.getListInvoiceChargeByBLNoVO());
				eventResponse.setRsVoList(aRInvoiceByBLNoVO.getListInvoiceHistoryByBLNoVO());
				eventResponse.setRsVoList(aRInvoiceByBLNoVO.getListInvoiceContainerVO());
				
				//오피스 추가작업 - 2009-12-04
				List<String> list = aRInvoiceByBLNoVO.getListArOfcCd();

				String arOfcInfo = "";
				StringBuffer arOfcInfoBuff = new StringBuffer();
				if (list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						arOfcInfoBuff.append("|" + list.get(i));
						//arOfcInfo = arOfcInfo + "|" + list.get(i);
					}
					arOfcInfo = arOfcInfoBuff.toString();
					eventResponse.setETCData("ar_ofc_cd", arOfcInfo);
				}				
			} else {
				eventResponse.setETCData("dp_prcs_knt", "0");
				eventResponse.setETCData("dp_prcs_knt_local", "0");

				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage());
		}
	}

	/**
	 * FNS_INV_0084 : Retrieve <br>
	 * VVD 기준으로 BKKBA Office의 Booking 의 Rating 정보들을 구한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchThaiBookingListByVVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0084Event event = (FnsInv0084Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<BKGForTaxByVesselVO> list = command.searchThaiBookingListByVVD(event.getVvd());
			if (list != null && list.size() > 0) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0085 : Retrieve <br>
	 * VVD, Bound, Port 기준으로 BOMSC, BOMBA Office의 Booking 의 컨테이너 및 Rating 정보들을 구한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIndiaBookingListByVVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0085Event event = (FnsInv0085Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<BKGForTaxByVesselVO> list = command.searchIndiaBookingListByVVD(event.getIndBkgVO());
			if (list != null && list.size() > 0) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0011 : Retrieve<br>
	 * 매출채권 및 Invoice 정보를 Interface No 로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARInvoiceByIFNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0011Event event = (FnsInv0011Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		ARInvoiceCorrectionVO invoiceCorrectionVO = new ARInvoiceCorrectionVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			invoiceCorrectionVO = command.searchARInvoiceByIFNo(event.getIfNo(), account.getOfc_cd());

			eventResponse.setRsVo(invoiceCorrectionVO);
			eventResponse.setRsVoList(invoiceCorrectionVO.getListInvoiceChargeSumVO());
			eventResponse.setRsVoList(invoiceCorrectionVO.getListInvoiceChargeCorrectionVO());
			eventResponse.setRsVoList(invoiceCorrectionVO.getListInvoiceContainerVO());

			if (invoiceCorrectionVO.getBlSrcNo() == null) {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			} else {
				if (invoiceCorrectionVO.getListInvoiceChargeSumVO() != null && invoiceCorrectionVO.getListInvoiceChargeSumVO().size() > 0) {
					eventResponse.setETCData("dp_prcs_knt", invoiceCorrectionVO.getListInvoiceChargeSumVO().get(0).getDpPrcsKnt());
					eventResponse.setETCData("dp_prcs_knt_local", invoiceCorrectionVO.getListInvoiceChargeSumVO().get(0).getDpPrcsKntLocal());
				} else {
					eventResponse.setETCData("dp_prcs_knt", "0");
					eventResponse.setETCData("dp_prcs_knt_local", "0");
				}
			}

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0034_01 : Open, Office@CHANGE <br>
	 * Invoice 발행시 Copy 본수를 조회한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceCopyCnt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		String ofcCd = "";
		String pageType = "";
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if (e.getEventName().equals("FnsInv003401Event")) {
				FnsInv003401Event event = (FnsInv003401Event) e;
				ofcCd = event.getOfcCd();
				pageType = event.getPageType();

			} else if (e.getEventName().equals("FnsInv0035Event")) {
				FnsInv0035Event event = (FnsInv0035Event) e;
				ofcCd = event.getOfcCd();
				pageType = event.getPageType();
			} else if (e.getEventName().equals("FnsInv0139Event")) {
				FnsInv0139Event event = (FnsInv0139Event) e;
				ofcCd = event.getOfcCd();
				pageType = event.getPageType();
			}

			INVCommonUtil command = new INVCommonUtil();
			InvoiceIssueBC command2 = new InvoiceIssueBCImpl();
			List<String> list = null;
			int copyCnt = 0;

			if (ofcCd != null && !ofcCd.equals("")) {
				copyCnt = command2.searchInvoiceCopyCnt(ofcCd);
				eventResponse.setETCData("copy_cnt", String.valueOf(copyCnt));
			} else {
				list = command.searchAROfficeList(account.getOfc_cd(), pageType);
				
				String ar_ofc_info = "";
				StringBuffer arOfcInfoBuff = new StringBuffer();
				for (int i = 0; i < list.size(); i++) {
					arOfcInfoBuff.append("|" + list.get(i));
					//ar_ofc_info = ar_ofc_info + "|" + list.get(i);
				}
				ar_ofc_info = arOfcInfoBuff.toString();
				eventResponse.setETCData("ar_ofc_cd", ar_ofc_info);

				String ar_ofc_info_1 = list.get(0);
				String[] result = StringUtils.delimitedListToStringArray(ar_ofc_info_1, "^");
				String arOfcCd = result[1];

				copyCnt = command2.searchInvoiceCopyCnt(arOfcCd);

				eventResponse.setETCData("copy_cnt", String.valueOf(copyCnt));
			}
			
			String printName = command.searchARPrinterName(account.getOfc_cd(), account.getUsr_id());
			eventResponse.setETCData("inv_prn_dvc_nm", printName);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0016 : 조회<BR>
	 * Office 기준정보에서 OTS Summary 코드를 조회, office code 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse searchOTSSummary(Event e) throws EventException {
		FnsInv0016Event event = (FnsInv0016Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			String otsSmryCd = command.searchOTSSummary(event.getOfcCd());
			eventResponse.setETCData("ots_smry_cd", otsSmryCd);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0016 : 조회<br>
	 * B/L 별로 Invoice 의 Item 들을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse searchARInvoiceByBL(Event e) throws EventException {
		FnsInv0016Event event = (FnsInv0016Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ARInvoiceCorrectionVO aRInvoiceCorrectionVO = command
					.searchARInvoiceByBL(event.getOfcCd(), event.getBlNo(), event.getInvNo(), event.getOtsSmryCd());

			eventResponse.setRsVo(aRInvoiceCorrectionVO);
			eventResponse.setRsVoList(aRInvoiceCorrectionVO.getListInvoiceChargeSumVO());
			eventResponse.setRsVoList(aRInvoiceCorrectionVO.getListInvoiceChargeCorrectionVO());
			eventResponse.setRsVoList(aRInvoiceCorrectionVO.getInvArCntrVO());
			eventResponse.setRsVoList(aRInvoiceCorrectionVO.getInvArMnVO());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0016 : 조회<br>
	 * 신용정보및 Due date 를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse searchDueDate(Event e) throws EventException {
		FnsInv0016Event event = (FnsInv0016Event) e;
		BookingARCreationBC command = new BookingARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ARCreditVO aRCreditVO = command.searchARCredit(event.getARCreditInputVO());

			if(aRCreditVO!=null){
				eventResponse.setETCData(aRCreditVO.getColumnValues());
			}else{
				eventResponse.setETCData("cr_flg","N");
				eventResponse.setETCData("cr_term","0");
				eventResponse.setETCData("due_dt","");
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * B/L NO와 Ofc CD로 CHG의 합을 구한다<br>
	 * AccountReceivableInvoiceMgt의 event에 대한 특정 등록 이벤트 처리<br>
	 * @param String blNo
	 * @param String arOfcCd
	 * @return boolean
	 */
	private boolean checkChgAmount(String blNo, String arOfcCd) throws EventException {
		boolean amtIsZero = false;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		amtIsZero = command.checkChgAmount(blNo, arOfcCd);
		
		return amtIsZero;
	}
	
	/**
	 * FNS_INV_0016 : 입력,수정,삭제<br>
	 * B/L 별로 Invoice 의 Item 들을 Correction 하여 ERP 로 Interface 처리한다.<br>
	 * AccountReceivableInvoiceMgt의 event에 대한 특정 등록 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse modifyARInvoiceByBL(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0016Event event = (FnsInv0016Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		BookingARCreationBC bcommand = new BookingARCreationBCImpl();
		INVCommonUtil utilCmd = new INVCommonUtil();
		
		List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
		List<InvArIfNoVO> maxIfNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO invArIfNoVO = new InvArIfNoVO();
		InvArIfNoVO maxArIfNoVO = new InvArIfNoVO();
		//String newIfNo="";
		
		try {
			begin();

			// Item Correction 시 최신 I/F 여부 check 로직에서 MRI Type 제외
			String revTpcd = event.getIfNo().substring(3,4);
			if (!"M".equals(revTpcd)) {
				String maxInterfaceNo = command.searchMaxInterfaceNoByBL(event.getBlSrcNo(), event.getArOfcCd());
	
				if (!maxInterfaceNo.trim().equals(event.getIfNo().trim())) {
					eventResponse.setUserMessage(new ErrorHandler("INV00158", new String[] {}).getUserMessage());
					return eventResponse;
				}
			}

			//사전 체크로직 - Customer 를 변경시, 기 i/f 금액이 balance 가 zero 인 경우 customer code 변경이 불가토록 변경
			HashMap<String, Object> eventParams = event.getEventParams();
			String changedCustCd = (String)eventParams.get("changed_cust_cd");
			if ("custCdIsChanged".equals(changedCustCd)) {
				if (checkChgAmount(event.getBlSrcNo(), event.getArOfcCd())){
					eventResponse.setUserMessage(new ErrorHandler("INV00143", new String[] {}).getUserMessage());
					return eventResponse;
				}
			}
			
			//2017.07.20 인도 GST 세법 변경 관련 보완
			if(("Y").equals(event.getActInvFlag())){
				if(("BOMSC").equals(event.getArOfcCd())){
					int taxCnt = command.checkTaxInvoice(event.getArOfcCd(), event.getBlSrcNo());
					
					if(taxCnt > 0){
						eventResponse.setUserMessage(new ErrorHandler("INV00172", new String[] {}).getUserMessage());
						return eventResponse;
					}
				}
			}
			
			// Ots Summary CD가 INV일 때 2010-01-28 CLR도 추가 
			if (event.getOtsSmryCd().equals("INV")||event.getOtsSmryCd().equals("CLR")) {

				// Inv Cust,Act Cust,Pol,Pod,Vvd 가 변경되었을 때
				if (event.getModFlag().equals("Y")) {

					InvArMnVO[] invArMnVOs = event.getInvArMnVOs();

					//log.info("invArMnVOs.length=========>" + invArMnVOs.length);
					//XCXCXC -> XXXCCC 로 변경 2009-11-04 이상희K 요청 Cancel 
					if (invArMnVOs !=null && invArMnVOs.length > 0) {
						//Cancel 하는 For
						for (int i = 0; i < invArMnVOs.length; i++) {
							String vvd = invArMnVOs[i].getVslCd() + invArMnVOs[i].getSkdVoyNo() + invArMnVOs[i].getSkdDirCd();			
							
							ARCorrectionCkVO aRCorrectionCkVO = new ARCorrectionCkVO();

							aRCorrectionCkVO.setBkgNo(invArMnVOs[i].getBkgNo());
							aRCorrectionCkVO.setIoBndCd(invArMnVOs[i].getIoBndCd().substring(0,1));
							aRCorrectionCkVO.setInvCustFlg(event.getInvCustFlg());
							aRCorrectionCkVO.setOfcCd(invArMnVOs[i].getArOfcCd());
							aRCorrectionCkVO.setSailingDt(invArMnVOs[i].getSailDt());
							aRCorrectionCkVO.setVvdCd(vvd);
							aRCorrectionCkVO.setPod(invArMnVOs[i].getPodCd());
							aRCorrectionCkVO.setPol(invArMnVOs[i].getPolCd());

							// Rev Type, Effective Dt, Zone Ioc 조회
							ARCorrectionCkReturnVO arCorctCkReturnVO = command.checkARCorrection(aRCorrectionCkVO);

							// Good일 때
							if (!invArMnVOs[i].getBlInvCfmDt().equals("")) {								
								
								// Cancel Data 세팅
																
								CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();

								cancelInvoiceVO.setIfNo(invArMnVOs[i].getArIfNo());
								cancelInvoiceVO.setEffDt(arCorctCkReturnVO.getEffectiveDt());
								//2010-01-20 RevTpCd,RevSrcCd Create시 구하는 걸로 변경
								//cancelInvoiceVO.setRevTpCd(arCorctCkReturnVO.getRevTpCd());
								//cancelInvoiceVO.setRevSrcCd(arCorctCkReturnVO.getRevSrcCd());
								cancelInvoiceVO.setInvCustFlg(event.getInvCustFlg());
								if(event.getInvCustFlg().equals("Y")){
									cancelInvoiceVO.setInvCustCntCd(invArMnVOs[i].getInvCustCntCd());
									cancelInvoiceVO.setInvCustSeq(invArMnVOs[i].getInvCustSeq());
								}
								cancelInvoiceVO.setOtsSmryCd(event.getOtsSmryCd());
								cancelInvoiceVO.setUserId(account.getUsr_id());

								// Cancel Data 생성
								String cancelIfNo = bcommand.createARCancelInvoice(cancelInvoiceVO);
								
								if(!cancelIfNo.equals("")){
									//SYS CLEAR가 된 대상 IFNO도 ERP전송대상에 추가 2009.12.29
									if(event.getOtsSmryCd().equals("INV")){
										maxArIfNoVO = new InvArIfNoVO();
										maxArIfNoVO.setIfNo(invArMnVOs[i].getArIfNo());
										maxIfNos.add(maxArIfNoVO);
									}
									invArIfNoVO = new InvArIfNoVO();
									invArIfNoVO.setIfNo(cancelIfNo);
									ifNos.add(invArIfNoVO);
									
									log.debug("erp_cancelIfNo1 = " + cancelIfNo);
								}
							} 
						}
					}
					
					// MAX IF Cancel
					ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.checkARCorrection(event.getArCorrectionCkVO());

					if (arCorrectionCkReturnVO.getZoneIoc() != null) {
						event.getArInvoiceCreationVO().getInvArMnVO().setZnIocCd(arCorrectionCkReturnVO.getZoneIoc());
					}
					event.getArInvoiceCreationVO().getInvArMnVO().setGlEffDt(arCorrectionCkReturnVO.getEffectiveDt());

					// Good Data=============//
					if (!event.getArInvoiceCreationVO().getInvArMnVO().getBlInvCfmDt().equals("")) {
						// Cancel Data 세팅
						CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();
						cancelInvoiceVO.setEffDt(arCorrectionCkReturnVO.getEffectiveDt());
						cancelInvoiceVO.setIfNo(event.getIfNo());
						cancelInvoiceVO.setOtsSmryCd(event.getOtsSmryCd());
						cancelInvoiceVO.setUserId(account.getUsr_id());
						//2010-01-20 RevTpCd,RevSrcCd Create시 구하는 걸로 변경
						cancelInvoiceVO.setInvCustFlg(event.getInvCustFlg());
						//cancelInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
						//cancelInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
						if(event.getInvCustFlg().equals("Y")){
							cancelInvoiceVO.setInvCustCntCd(event.getArInvoiceCreationVO().getInvArMnVO().getInvCustCntCd());
							cancelInvoiceVO.setInvCustSeq(event.getArInvoiceCreationVO().getInvArMnVO().getInvCustSeq());
						}

						String cancelIfNo = bcommand.createARCancelInvoice(cancelInvoiceVO);
						
						if(!cancelIfNo.equals("")){
							
							//SYS CLEAR가 된 대상 IFNO도 ERP전송대상에 추가 2009.12.29
							if(event.getOtsSmryCd().equals("INV")){
								maxArIfNoVO = new InvArIfNoVO();
								maxArIfNoVO.setIfNo(event.getIfNo());
								maxIfNos.add(maxArIfNoVO);
							}
							
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(cancelIfNo);
							ifNos.add(invArIfNoVO);
							
							log.debug("erp_cancelIfNo2 = " + cancelIfNo);
						}
					}
					
					
					//XCXCXC -> XXXCCC 로 변경 2009-11-04 이상희K 요청 create 
					if (invArMnVOs !=null && invArMnVOs.length > 0) {
						//Create 하는 For
						for (int i = 0; i < invArMnVOs.length; i++) {
							String vvd = invArMnVOs[i].getVslCd() + invArMnVOs[i].getSkdVoyNo() + invArMnVOs[i].getSkdDirCd();
							String port = invArMnVOs[i].getIoBndCd().equals("O")?invArMnVOs[i].getPolCd():invArMnVOs[i].getPodCd();								
							
							String sailArrDt = utilCmd.searchSADate(vvd, port, invArMnVOs[i].getIoBndCd());
							
							//Due Dt 구하는 로직 BC에서 직접 구하는 방식으로 변경 2009-11-30
							/*
							DueDateInputVO dueDateInputVO = new DueDateInputVO();

							dueDateInputVO.setBnd(invArMnVOs[i].getIoBndCd());
							dueDateInputVO.setCustCntCd(invArMnVOs[i].getActCustCntCd());
							dueDateInputVO.setCustSeq(invArMnVOs[i].getActCustSeq());
							dueDateInputVO.setSaDt(!sailArrDt.equals("")?sailArrDt.replace("-", ""):sailArrDt);
							dueDateInputVO.setOfcCd(invArMnVOs[i].getArOfcCd());
							// Due Date 조회
							List<DueDateVO> list = command.searchDueDate(dueDateInputVO);
							*/
							
							ARCorrectionCkVO aRCorrectionCkVO = new ARCorrectionCkVO();

							aRCorrectionCkVO.setBkgNo(invArMnVOs[i].getBkgNo());
							aRCorrectionCkVO.setInvCustFlg(event.getInvCustFlg());
							aRCorrectionCkVO.setOfcCd(invArMnVOs[i].getArOfcCd());
							aRCorrectionCkVO.setSailingDt(invArMnVOs[i].getSailDt());
							aRCorrectionCkVO.setVvdCd(vvd);
							aRCorrectionCkVO.setPod(invArMnVOs[i].getPodCd());
							aRCorrectionCkVO.setPol(invArMnVOs[i].getPolCd());
							aRCorrectionCkVO.setIoBndCd(invArMnVOs[i].getIoBndCd().substring(0,1));

							// Rev Type, Effective Dt, Zone Ioc 조회
							ARCorrectionCkReturnVO arCorctCkReturnVO = command.checkARCorrection(aRCorrectionCkVO);

							// Good일 때
							if (!invArMnVOs[i].getBlInvCfmDt().equals("")) {
								
								// New Data 세팅
								InvNewCustVO invNewCustVO = new InvNewCustVO();

								invNewCustVO.setActCustCntCd(invArMnVOs[i].getActCustCntCd());
								invNewCustVO.setActCustSeq(invArMnVOs[i].getActCustSeq());
								invNewCustVO.setInvCustCntCd(invArMnVOs[i].getInvCustCntCd());
								invNewCustVO.setInvCustSeq(invArMnVOs[i].getInvCustSeq());
								invNewCustVO.setVslCd(invArMnVOs[i].getVslCd());
								invNewCustVO.setSkdVoyNo(invArMnVOs[i].getSkdVoyNo());
								invNewCustVO.setSkdDirCd(invArMnVOs[i].getSkdDirCd());
								invNewCustVO.setPolCd(invArMnVOs[i].getPolCd());
								invNewCustVO.setPodCd(invArMnVOs[i].getPodCd());
								/*
								if (list.size() > 0) {
									// Due Date 세팅
									invNewCustVO.setDueDt(list.get(0).getDueDate());
									invNewCustVO.setCustCrFlg(list.get(0).getCrFlg());
									invNewCustVO.setCrTermDys(list.get(0).getCrTermDys());
								}
								*/
								invNewCustVO.setArIfNo(invArMnVOs[i].getArIfNo());
								invNewCustVO.setBlInvCfmDt(invArMnVOs[i].getBlInvCfmDt());
								invNewCustVO.setOtsSmryCd(event.getOtsSmryCd());
								invNewCustVO.setGlEffDt(arCorctCkReturnVO.getEffectiveDt());
								//2010-01-20 RevTpCd,RevSrcCd Create시 구하는 걸로 변경
								invNewCustVO.setInvCustFlg(event.getInvCustFlg());
								//invNewCustVO.setRevTpCd(arCorctCkReturnVO.getRevTpCd());
								//invNewCustVO.setRevSrcCd(arCorctCkReturnVO.getRevSrcCd());
								invNewCustVO.setZnIocCd(arCorctCkReturnVO.getZoneIoc());
								invNewCustVO.setSailArrDt(!sailArrDt.equals("")?sailArrDt.replace("-", ""):sailArrDt);
								invNewCustVO.setUiType("F");
								invNewCustVO.setSplitFlag(event.getActInvFlag().equals("Y") ? "C" : "");

								// New Data 생성
								String newIfNo = bcommand.createNewCustomerARInvoice(invNewCustVO, account.getUsr_id());
								
								if(!newIfNo.equals("")){
									invArIfNoVO = new InvArIfNoVO();
									invArIfNoVO.setIfNo(newIfNo);
									ifNos.add(invArIfNoVO);
									
									log.debug("erp_newIfNo1 = " + newIfNo);
								}
								
								// No Goood 일때
							} else {
								// New Data 세팅
								InvNewCustVO invNewCustVO = new InvNewCustVO();

								invNewCustVO.setActCustCntCd(invArMnVOs[i].getActCustCntCd());
								invNewCustVO.setActCustSeq(invArMnVOs[i].getActCustSeq());
								invNewCustVO.setInvCustCntCd(invArMnVOs[i].getInvCustCntCd());
								invNewCustVO.setInvCustSeq(invArMnVOs[i].getInvCustSeq());
								invNewCustVO.setVslCd(invArMnVOs[i].getVslCd());
								invNewCustVO.setSkdVoyNo(invArMnVOs[i].getSkdVoyNo());
								invNewCustVO.setSkdDirCd(invArMnVOs[i].getSkdDirCd());
								invNewCustVO.setPolCd(invArMnVOs[i].getPolCd());
								invNewCustVO.setPodCd(invArMnVOs[i].getPodCd());
								/*
								if (list.size() > 0) {
									// Due Date 세팅
									invNewCustVO.setDueDt(list.get(0).getDueDate());
									invNewCustVO.setCustCrFlg(list.get(0).getCrFlg());
									invNewCustVO.setCrTermDys(list.get(0).getCrTermDys());
								}
								*/
								invNewCustVO.setSailArrDt(!sailArrDt.equals("")?sailArrDt.replace("-", ""):sailArrDt);
								invNewCustVO.setArIfNo(invArMnVOs[i].getArIfNo());
								invNewCustVO.setBlInvCfmDt(invArMnVOs[i].getBlInvCfmDt());
								invNewCustVO.setUiType("F");
								//2010-03-23 No Good 일때는 Split Flag Null로 세팅 이상희 과장 2010-04-28 BKGIF 이행데이터 오류때문데 다시 넣어줌
								invNewCustVO.setSplitFlag(event.getActInvFlag().equals("Y") ? "C" : "");
								//invNewCustVO.setSplitFlag("");
								invNewCustVO.setOtsSmryCd(event.getOtsSmryCd());
								invNewCustVO.setGlEffDt(arCorctCkReturnVO.getEffectiveDt());
								//2010-01-20 RevTpCd,RevSrcCd Create시 구하는 걸로 변경
								invNewCustVO.setInvCustFlg(event.getInvCustFlg());
								//invNewCustVO.setRevTpCd(arCorctCkReturnVO.getRevTpCd());
								//invNewCustVO.setRevSrcCd(arCorctCkReturnVO.getRevSrcCd());
								invNewCustVO.setZnIocCd(arCorctCkReturnVO.getZoneIoc());

								// New Data 생성
								String newIfNo = bcommand.createNewCustomerARInvoice(invNewCustVO, account.getUsr_id());
								
								if(!newIfNo.equals("")){
									invArIfNoVO = new InvArIfNoVO();
									invArIfNoVO.setIfNo(newIfNo);
									ifNos.add(invArIfNoVO);
								}
								log.debug("erp_newIfNo2 = " + newIfNo);
							}
						}
					}

					// MAX IF Create					
					// Good Data=============//
					if (!event.getArInvoiceCreationVO().getInvArMnVO().getBlInvCfmDt().equals("")) {
						
						event.getInvNewCustVO().setGlEffDt(arCorrectionCkReturnVO.getEffectiveDt());
						event.getInvNewCustVO().setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
						event.getInvNewCustVO().setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
						event.getInvNewCustVO().setBlInvCfmDt(event.getArInvoiceCreationVO().getInvArMnVO().getBlInvCfmDt());
						event.getInvNewCustVO().setSplitFlag(event.getActInvFlag().equals("Y") ? "C" : "");

						String newIfNo = bcommand.createNewCustomerARInvoice(event.getInvNewCustVO(), account.getUsr_id());
						
						if(!newIfNo.equals("")){
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(newIfNo);
							ifNos.add(invArIfNoVO);
							
							log.debug("erp_newIfNo3 = " + newIfNo);
						}
						
						// ==== Actual Cust or Inv Cust Change and No Good =============//
					} else {
						event.getInvNewCustVO().setGlEffDt(arCorrectionCkReturnVO.getEffectiveDt());
						//2010-01-20 RevTpCd,RevSrcCd Create시 구하는 걸로 변경
						event.getInvNewCustVO().setInvCustFlg(event.getInvCustFlg());
						//event.getInvNewCustVO().setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
						//event.getInvNewCustVO().setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
						event.getInvNewCustVO().setBlInvCfmDt(event.getArInvoiceCreationVO().getInvArMnVO().getBlInvCfmDt());
						//2010-03-23 No Good 일때는 Split Flag Null로 세팅 이상희 과장  2010-04-28 BKGIF 이행데이터 오류때문데 다시 넣어줌
						event.getInvNewCustVO().setSplitFlag(event.getActInvFlag().equals("Y") ? "C" : "");
						//event.getInvNewCustVO().setSplitFlag("");

						String newIfNo = bcommand.createNewCustomerARInvoice(event.getInvNewCustVO(), account.getUsr_id());
						
						if(!newIfNo.equals("")){
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(newIfNo);
							ifNos.add(invArIfNoVO);
							
							log.debug("erp_newIfNo4 = " + newIfNo);
						}
					}
					
					

					// Inv Cust,Act Cust,Pol,Pod,Vvd 가 변경되지 않았을때
				} else {
					
					String newIfNo = bcommand.modifyARInvoice(event.getArInvoiceCreationVO(), account.getUsr_id());
					if(!newIfNo.equals("")){
						invArIfNoVO = new InvArIfNoVO();
						invArIfNoVO.setIfNo(newIfNo);
						ifNos.add(invArIfNoVO);
						
						log.debug("erp_newIfNo5 = " + newIfNo);
					}
				}

				// Ots Summary CD가 INV가 아닐때, Max If No 만 기존대로 처리
			} else {
				ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.checkARCorrection(event.getArCorrectionCkVO());

				if (arCorrectionCkReturnVO.getZoneIoc() != null) {
					event.getArInvoiceCreationVO().getInvArMnVO().setZnIocCd(arCorrectionCkReturnVO.getZoneIoc());
				}
				event.getArInvoiceCreationVO().getInvArMnVO().setGlEffDt(arCorrectionCkReturnVO.getEffectiveDt());

				// ==== Actual Cust or Inv Cust No Change and other Value Change =============//
				if (event.getActInvFlag().equals("N")) {
					String modIfNo = bcommand.modifyARInvoice(event.getArInvoiceCreationVO(), account.getUsr_id());
					
					if(!modIfNo.equals("")){
						invArIfNoVO = new InvArIfNoVO();
						invArIfNoVO.setIfNo(modIfNo);
						ifNos.add(invArIfNoVO);
						
						log.debug("erp_modIfNo1 = " + modIfNo);
					}
					
				} else {
					// ==== Actual Cust or Inv Cust Change and Good =============//
					if (!event.getArInvoiceCreationVO().getInvArMnVO().getBlInvCfmDt().equals("")) {
						// Cancel Data 세팅
						CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();
						cancelInvoiceVO.setEffDt(arCorrectionCkReturnVO.getEffectiveDt());
						cancelInvoiceVO.setIfNo(event.getIfNo());
						cancelInvoiceVO.setOtsSmryCd(event.getOtsSmryCd());
						cancelInvoiceVO.setUserId(account.getUsr_id());
						//2010-01-20 RevTpCd,RevSrcCd Create시 구하는 걸로 변경
						cancelInvoiceVO.setInvCustFlg(event.getInvCustFlg());
						//cancelInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
						//cancelInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
						if(event.getInvCustFlg().equals("Y")){
							cancelInvoiceVO.setInvCustCntCd(event.getArInvoiceCreationVO().getInvArMnVO().getInvCustCntCd());
							cancelInvoiceVO.setInvCustSeq(event.getArInvoiceCreationVO().getInvArMnVO().getInvCustSeq());
						}

						String cancelIfNo = bcommand.createARCancelInvoice(cancelInvoiceVO);
						
						if(!cancelIfNo.equals("")){
							
							//SYS CLEAR가 된 대상 IFNO도 ERP전송대상에 추가 2009.12.29
							if(event.getOtsSmryCd().equals("INV")){
								maxArIfNoVO = new InvArIfNoVO();
								maxArIfNoVO.setIfNo(event.getIfNo());
								maxIfNos.add(maxArIfNoVO);
							}
							
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(cancelIfNo);
							ifNos.add(invArIfNoVO);
							
							log.debug("erp_cancelIfNo3 = " + cancelIfNo);
						}
						
						event.getInvNewCustVO().setGlEffDt(arCorrectionCkReturnVO.getEffectiveDt());
						//2010-01-20 RevTpCd,RevSrcCd Create시 구하는 걸로 변경
						event.getInvNewCustVO().setInvCustFlg(event.getInvCustFlg());
						//event.getInvNewCustVO().setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
						//event.getInvNewCustVO().setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
						event.getInvNewCustVO().setBlInvCfmDt(event.getArInvoiceCreationVO().getInvArMnVO().getBlInvCfmDt());

						String newIfNo = bcommand.createNewCustomerARInvoice(event.getInvNewCustVO(), account.getUsr_id());
						
						if(!newIfNo.equals("")){
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(newIfNo);
							ifNos.add(invArIfNoVO);
							
							log.debug("erp_newIfNo6 = " + newIfNo);
						}
						
						// ==== Actual Cust or Inv Cust Change and No Good =============//
					} else {
						String modIfNo = bcommand.modifyARInvoice(event.getArInvoiceCreationVO(), account.getUsr_id());
						if(!modIfNo.equals("")){
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(modIfNo);
							ifNos.add(invArIfNoVO);
							
							log.debug("erp_modIfNo2 = " + modIfNo);
						}
					}
				}
			}
			
			commit();
			
			begin();
			//Sys Clear 된 대상 IfNo 가 Good Data인 IfNo 모아서 ERP전송
			if(maxIfNos!= null && maxIfNos.size()>0){
				bcommand.interfaceARInvoiceToERPAR(maxIfNos, "U");
			}
			
			//Good Data인 IfNo 모아서 ERP전송
			if(ifNos!= null && ifNos.size()>0){
				bcommand.interfaceARInvoiceToERPAR(ifNos, "C");
			}

			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0035 : Paper Re-issue <br>
	 * Re-issue 할 Invoice 대상List 및 Re-issue 이력을 저장한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPrintInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0035Event event = (FnsInv0035Event) e;
		PrintInvoiceVO prtInvoiceVo = null;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		List<InvIssMainVO> list = null;
		String rInvNos = "";
		String cmbFlg = "";
		StringBuffer rInvNosBuff = new StringBuffer();
		StringBuffer cmbFlgBuff = new StringBuffer();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			prtInvoiceVo = event.getPrtInvoiceVo();
			prtInvoiceVo.setUserOfc(event.getPrtInvoiceVo().getUserOfc());
			prtInvoiceVo.setIssOfcCd(event.getPrtInvoiceVo().getIssOfcCd());
			prtInvoiceVo.setOtsSmryCd(event.getPrtInvoiceVo().getOtsSmryCd());
			prtInvoiceVo.setUserId(event.getPrtInvoiceVo().getUserId());
			prtInvoiceVo.setPrevFlg(event.getPrtInvoiceVo().getPrevFlg());
			prtInvoiceVo.setGotoFlg(event.getPrtInvoiceVo().getGotoFlg());
			
			log.info("\n########## prtInvoiceVo.getUserOfc() : "+prtInvoiceVo.getUserOfc());
			log.info("\n########## prtInvoiceVo.getIssOfcCd() : "+prtInvoiceVo.getIssOfcCd());
			
			begin();

			list = command.searchPrintInvoice(prtInvoiceVo);

			for (int i = 0; i < list.size(); i++) {
				rInvNosBuff.append(list.get(i).getInvNo() + "|");
				cmbFlgBuff.append(list.get(i).getInvIssCmbFlg() + "|");
				//rInvNos = rInvNos + list.get(i).getInvNo() + "|";
				//cmbFlg = cmbFlg + list.get(i).getInvIssCmbFlg() + "|";
				
				if (!prtInvoiceVo.getPrevFlg().equals("Y")) {
					command2.modifyInvoiceReIssue(list.get(i).getInvNo(), prtInvoiceVo.getOtsSmryCd(), prtInvoiceVo.getUserId(), prtInvoiceVo.getIssOfcCd());
				}		
			}
			rInvNos = rInvNosBuff.toString();
			cmbFlg = cmbFlgBuff.toString();

			eventResponse.setETCData("r_inv_nos", rInvNos);
			eventResponse.setETCData("cmb_flg", cmbFlg);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0034_01 : Paper Issue, Go to Send <br>
	 * 구주지역, 서남아 일부지역, 북중국지역의 Invoice 를 발행함. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*
	private EventResponse issueGeneralInvoiceOld(Event e) throws EventException {		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv003401Event event = (FnsInv003401Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		List<IssueTargetVO> list2 = new ArrayList<IssueTargetVO>();
		try {
			begin();

			// Issue 대상을 조회한다
			List<IssueTargetVO> list = command.searchTargetBLForIssue(event.getGenInvVo());

			if (list.size() < 1) {
				eventResponse.setUserMessage(new ErrorHandler("INV00095", new String[] {}).getUserMessage());
			}

			String invNos = "";
			InvIssueVO invIssueVO = null;

			// 조회된 Issue 대상만큼 Looping 
			for (int i = 0; i < list.size(); i++) {
				list2 = command.issueGeneralInvoice(list.get(i), event.getGenInvVo(), account.getUsr_id());
				invNos = invNos + list2.get(0).getInvNo() + "|";

				// 반환된 업데이트 대상만큼 Looping
				for (int j = 0; j < list2.size(); j++) {

					invIssueVO = new InvIssueVO();
					invIssueVO.setInvno(list2.get(j).getInvNo());
					invIssueVO.setIssflg("Y");
					invIssueVO.setIfno(list2.get(j).getArIfNo());
					invIssueVO.setDuedt(list2.get(j).getDueDt());
					invIssueVO.setBkgno(list2.get(j).getBkgNo());
					invIssueVO.setInvrmk(list2.get(j).getInvRmk());

					command2.modifyInvoiceIssue(invIssueVO, event.getGenInvVo().getOtsSmryCd(), account.getUsr_id());
				}
			}
			commit();

			eventResponse.setETCData("inv_nos", invNos);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;
	}
	*/
	/**
	 * FNS_INV_0034_01 : Paper Issue, Go to Send <br>
	 * 구주지역, 서남아 일부지역, 북중국지역의 Invoice 를 발행함.(BackEndJob) <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse issueGeneralInvoice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv003401Event event = (FnsInv003401Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		try {
			begin();
			
			String backEndJobKey = command.issueGeneralInvoiceBackEndJobKey(event.getGenInvVo(), account.getUsr_id());
			
				eventResponse.setETCData("BackEndJobKey", backEndJobKey); 
			commit();
			
		} catch (EventException ex) {
			rollback();
			log.error("errSc1=============>> " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("errSc2=============>> " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;
	}		
	
	/**
	 * FNS_INV_0097 : Retrieve<br>
	 * Invoice 발송시에 첨부되는 Wording 정보를 조회한다.<br>
	 * VVD/port, customer 별
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceWording(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0097Event event = (FnsInv0097Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		InvIssAtchVO invIssAtchVO = new InvIssAtchVO();
		try {
			invIssAtchVO = command.searchInvoiceWording(event.getInvissAtchInput());

			eventResponse.setRsVo(invIssAtchVO);

			if (invIssAtchVO != null) {
				// eventResponse.setETCData(invIssAtchVO.getColumnValues());
				eventResponse.setETCData("vvd", invIssAtchVO.getVvd());
				eventResponse.setETCData("port_cd", invIssAtchVO.getPortCd());
				eventResponse.setETCData("cust_cnt_cd", invIssAtchVO.getCustCntCd());
				eventResponse.setETCData("cust_seq", invIssAtchVO.getCustSeq());
				eventResponse.setETCData("ar_ofc_cd", invIssAtchVO.getArOfcCd());
				eventResponse.setETCData("subject", invIssAtchVO.getSubject());
				eventResponse.setETCData("text1", invIssAtchVO.getText1());
				eventResponse.setETCData("text2", invIssAtchVO.getText2());
				eventResponse.setETCData("text3", invIssAtchVO.getText3());
				eventResponse.setETCData("text4", invIssAtchVO.getText4());
				eventResponse.setETCData("high_light1", invIssAtchVO.getHighLight1());
				eventResponse.setETCData("high_light2", invIssAtchVO.getHighLight2());
				eventResponse.setETCData("high_light3", invIssAtchVO.getHighLight3());
				eventResponse.setETCData("high_light4", invIssAtchVO.getHighLight4());
			} else {
				eventResponse.setETCData("vvd", "");
				eventResponse.setETCData("port_cd", "");
				eventResponse.setETCData("cust_cnt_cd", "");
				eventResponse.setETCData("cust_seq", "");
				eventResponse.setETCData("ar_ofc_cd", "");
				eventResponse.setETCData("subject", "");
				eventResponse.setETCData("text1", "");
				eventResponse.setETCData("text2", "");
				eventResponse.setETCData("text3", "");
				eventResponse.setETCData("text4", "");
				eventResponse.setETCData("high_light1", "");
				eventResponse.setETCData("high_light2", "");
				eventResponse.setETCData("high_light3", "");
				eventResponse.setETCData("high_light4", "");

				eventResponse.setUserMessage(new ErrorHandler("INV00095", new String[] {}).getUserMessage());
			}

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0097 : Save<br>
	 * Invoice 발송시에 첨부되는 Wording 정보를 갱신한다.<br>
	 * VVD/port, customer 별
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyInvoiceWording(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0097Event event = (FnsInv0097Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		try {
			begin();

			command.modifyInvoiceWording(event.getInvIssAtchVO(), account.getUsr_id(), event.getSearchOption());

			// 에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0097 : Delete<br>
	 * Invoice 발송시에 첨부되는 Wording 정보를 삭제한다.<br>
	 * VVD/port, customer 별
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeInvoiceWording(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0097Event event = (FnsInv0097Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		try {
			begin();
			
			log.debug("event.getSearchOption()  = "+event.getSearchOption());
			command.removeInvoiceWording(event.getInvIssAtchVO(), event.getSearchOption());

			// 에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
			eventResponse.setUserMessage(new ErrorHandler("INV00057", new String[] {}).getUserMessage());

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0034_02, FNS_INV_0037 : Open <br>
	 * Fax / E-mail 발송 또는 Print 하려는 대상 Invoice 정보를 조회한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIssuedGeneralInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// FnsInv003402Event event = (FnsInv003402Event)e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		INVCommonUtil commonUtil = new INVCommonUtil();
		List<InvoiceFaxEmailListVO> list = null;
		String printName = "";
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {

			if (e.getEventName().equalsIgnoreCase("FnsInv003402Event")) {
				FnsInv003402Event event = (FnsInv003402Event) e;
				log.info("\n########## IssueGubn : " + event.getPrtInvoiceVo().getIssueGubn());
				list = command.searchIssuedGeneralInvoiceList(event.getPrtInvoiceVo());
			} else if (e.getEventName().equalsIgnoreCase("FnsInv0037Event")) {
				FnsInv0037Event event = (FnsInv0037Event) e;
				log.info("\n########## IssueGubn : " + event.getPrtInvoiceVo().getIssueGubn());
				list = command.searchIssuedGeneralInvoiceList(event.getPrtInvoiceVo());
			}

			if (list != null && list.size()>0) {
				eventResponse.setRsVoList(list);
			}
			
			printName = commonUtil.searchARPrinterName(account.getOfc_cd(), account.getUsr_id());
			log.info("\n########## printName : " + printName);
			eventResponse.setETCData("inv_prn_dvc_nm", printName);

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0059 : Retrieve Invoice 의 Fax 및 E-mail 발송 결과와 현황을 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFaxEmailSentResultListBySendDate(Event e) throws EventException {
		FnsInv0059Event event = (FnsInv0059Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		try {
			List<FaxEmailSentResultVO> list = command.searchFaxEmailSentResultListBySendDate(event.getFaxEmailSentDateVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0034_02, FNS_INV_0037 : Send <br>
	 * Invoice 정보 생성 및 수정후 Fax / E-mail 발송 또는 Print 한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createIssueMain(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)

		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		String issueCnt = "0";

		try {
			InvIssMainVO[] issMainVOs = null;
			IssueOptionVO issOptionVO = null;
			String sendFlag = "";
			String sendFlag2 = "";
			String issueGubn = "";
			String issOfcCd = "";
			String rdName = "";
			String nameFlag = "";
			String titleFlag = "";
			String sendType = "";
			String issueType = "";
			String copyCnt = "";
			String issLehbb = "";
			String logoGb = "";

			if (e.getEventName().equalsIgnoreCase("FnsInv003402Event")) {
				FnsInv003402Event event = (FnsInv003402Event) e;
				issMainVOs = event.getIssMainVOs();
				issOptionVO = new IssueOptionVO();
				sendFlag = event.getSendFlag();
				sendFlag2 = event.getSendFlag2();
				issueGubn = event.getIssueGubn();
				issOfcCd = event.getOfcCd();
				rdName = event.getRdName();
				nameFlag = "";
				titleFlag = "";
				sendType = event.getSendType();
				issueType = event.getIssueType();
				copyCnt = event.getCopyCnt();
				issLehbb = event.getIssLehbb();
				logoGb = event.getLogoGb();
			} else if (e.getEventName().equalsIgnoreCase("FnsInv0037Event")) {
				FnsInv0037Event event = (FnsInv0037Event) e;
				issMainVOs = event.getIssMainVOs();
				issOptionVO = new IssueOptionVO();
				sendFlag = event.getSendFlag();
				sendFlag2 = event.getSendFlag2();
				issueGubn = event.getIssueGubn();
				issOfcCd = event.getOfcCd();
				rdName = event.getRdName();
				nameFlag = event.getNameFlag();
				titleFlag = event.getTitleFlag();
				copyCnt = event.getCopyCnt();
				issLehbb = "";
				logoGb = "";
			}

			log.info("\n########## issueGubn : "+issueGubn);
			 if (issOptionVO != null){
				issOptionVO.setSendFlag(sendFlag);
				issOptionVO.setSendFlag2(sendFlag2);
				issOptionVO.setIssueGubn(issueGubn);
				issOptionVO.setIssOfcCd(issOfcCd);
				issOptionVO.setRdName(rdName);
				issOptionVO.setNameFlag(nameFlag);
				issOptionVO.setTitleFlag(titleFlag);
				issOptionVO.setSendType(sendType);
				issOptionVO.setIssueType(issueType);
				issOptionVO.setCopyCnt(copyCnt);
				issOptionVO.setIssLehbb(issLehbb);
				issOptionVO.setLogoGb(logoGb);
			 }

			begin();

			 if (issMainVOs != null && issOptionVO != null){
				 issueCnt = command.createIssueMain(issMainVOs, issOptionVO, account.getUsr_id());
			 }
			 
			 if (issMainVOs != null){
				 command2.modifyInvoiceIssueEmail(issMainVOs, issOfcCd, issueGubn, account.getUsr_id());
			 }
			 
			if (sendFlag.equals("E") || sendFlag.equals("F")) {
				log.info("########## sendFlag2 : "+sendFlag);
				
				 if (issMainVOs != null && issOptionVO != null){
					 command.sendGeneralInvoiceByFaxEmail(issMainVOs, issOptionVO, account);
				 }
			}

			commit();
			
			eventResponse.setETCData("issueCnt", issueCnt);
			return eventResponse;

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00066").getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0034_02, FNS_INV_0037 : Add <br>
	 * E-Mail에 첨부할 파일 Key를 가져온다 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAttachFileKey(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("FnsInv003402Event")) {
				FnsInv003402Event event = (FnsInv003402Event) e;
				eventResponse.setETCData("fileKey", event.getKeys().get(0));
			} else if (e.getEventName().equalsIgnoreCase("FnsInv0037Event")) {
				FnsInv0037Event event = (FnsInv0037Event) e;
				eventResponse.setETCData("fileKey", event.getKeys().get(0));
			}
			commit();

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00066").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_ : Retrieve<br>
	 * Spain(VLCSC) Invoice 정보를 데이터 다운로드를 위한 조회하여 구성한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpainInvoiceList(Event e) throws EventException {
		FnsInv0062Event event = (FnsInv0062Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			
			SpainInvoiceEDIListCountVO spainInvoiceEDIListCountVO = command.searchSpainInvoiceListCount(event.getOfcCd(), event.getIssDt());
			
			List<SpainInvoiceEDIListVO> invoiceEDIListVO = command.searchSpainInvoiceList(event.getOfcCd(), event.getIssDt());
			
			// FNS_INV_0062 VLCSC의 EDI 다운로드 받은 해당 데이터에 대해서 EDI_SND_DT에 입력된 EDI DATE를 반영한다.
			if (invoiceEDIListVO.size() < 1) {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			} else {
				eventResponse.setRsVoList(invoiceEDIListVO);
				eventResponse.setETCData("row_cnt", spainInvoiceEDIListCountVO.getRowCnt());
				eventResponse.setETCData("inv_cnt", spainInvoiceEDIListCountVO.getInvCnt());
				eventResponse.setETCData("locl_tot_sum", spainInvoiceEDIListCountVO.getLoclTotSum());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0062 : modify<br>
	 * Spain(VLCSC) Invoice 정보를 데이터 다운로드를 위한 조회하여 구성한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyEDISendDate(Event e) throws EventException {
		FnsInv0062Event event = (FnsInv0062Event) e;
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();

			command2.modifyEDISendDate(event.getOfcCd(), event.getIssDt());

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0062 : modify<br>
	 * Spain(VLCSC) 의 EDI 다운로드 했던 데이터에 대해서 INV_AR_MN의 EDI_SND_DT 값을 Null 를 update 한다.<br>
	 * 
	 * @author	Kwon Min
	 * @param	Event e
	 * @return	EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyEDISendDataRelease(Event e) throws EventException {
		FnsInv0062Event event = (FnsInv0062Event) e;
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();

			command2.modifyEDISendDataRelease(event.getFmInvNo(), event.getToInvNo());

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0058 : Retrieve<br>
	 * 매출채권 발생과 Invoice 발행사이의 Averate Term 을 date 별로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceIssueTermByDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0058Event event = (FnsInv0058Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<InvoiceTermAnalysisVO> list = command.searchInvoiceIssueTermByDate(event.getInvoiceTermAnalysisInputVO());
			List<InvoiceTermAnalysisVO> returnList = new ArrayList<InvoiceTermAnalysisVO>();
			if (list != null && list.size() > 0) {
				int j = 0;
				InvoiceTermAnalysisVO invoiceTermAnalysisVO = new InvoiceTermAnalysisVO();
				for(int i=0; i<list.size(); i++) {
					invoiceTermAnalysisVO = list.get(i);
					
					if(!invoiceTermAnalysisVO.getMonth().equals("")) {
						returnList.add(j, invoiceTermAnalysisVO);
						
						j++;
					}
				}
				
				eventResponse.setRsVoList(returnList);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0098 : CNTR No@FOCUS OUT <br>
	 * Container no의 type size를 조회해 온다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerNo(Event e) throws EventException {

		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		FnsInv0098Event event = (FnsInv0098Event) e;
		String cntrTpszCd = "";
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			cntrTpszCd = command.searchContainerNo(event.getCntrNo());
			eventResponse.setETCData("cntr_tpsz_cd", cntrTpszCd);

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0067 : Open<br>
	 * Invoice Detail Inquiry by Date & Charge 의 ofc cd,chg cd 코드조회 이벤트 처리<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeChgCodeList(Event e) throws EventException {

		INVCommonUtil command = new INVCommonUtil();
		ARInvoiceInquiryBC command2 = new ARInvoiceInquiryBCImpl();
		List<String> ofcList = null;
		List<String> loclChgOfcList = null;
		List<MdmChargeVO> chgCodeList = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("FnsInv0066Event")) {
				FnsInv0066Event event = (FnsInv0066Event) e;
				// log.info("########## event.getPageType() : "+event.getPageType());
				ofcList = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			} else if (e.getEventName().equalsIgnoreCase("FnsInv0067Event")) {
				FnsInv0067Event event = (FnsInv0067Event) e;
				// log.info("########## event.getPageType() : "+event.getPageType());
				ofcList = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			}

			chgCodeList = command.searchChargeCodeList();
			loclChgOfcList = command2.searchLoclChgOfc();

			String arOfcInfo = "";
			StringBuffer arOfcInfoBuff = new StringBuffer();
			
			if (ofcList != null && ofcList.size()>0) {
				for (int i = 0; i < ofcList.size(); i++) {
					arOfcInfoBuff.append("|" + ofcList.get(i));
					//arOfcInfo = arOfcInfo + "|" + ofcList.get(i);
				}
			}
			arOfcInfo = arOfcInfoBuff.toString();
			
			String chgCodeInfo = "";
			
			if (chgCodeList != null && chgCodeList.size()>0) {
				for (int i = 0; i < chgCodeList.size(); i++) {
					if (!chgCodeList.get(i).getChgCd().trim().equals("")) {
						chgCodeInfo = chgCodeInfo + "|" + chgCodeList.get(i).getChgCd();
					}
				}
			}
			
			String loclChgOfc = "";
			StringBuffer loclChgOfcBuff = new StringBuffer();
			
			if (loclChgOfcList != null && loclChgOfcList.size()>0) {
				for (int i = 0; i < loclChgOfcList.size(); i++) {
					loclChgOfcBuff.append("|" + loclChgOfcList.get(i));
					//loclChgOfc = loclChgOfc + "|" + loclChgOfcList.get(i);
				}
			}
			
			loclChgOfc = loclChgOfcBuff.toString();

			eventResponse.setETCData("ar_ofc_cd", arOfcInfo);
			eventResponse.setETCData("chg_cd", chgCodeInfo);
			eventResponse.setETCData("locl_chg_ofc", loclChgOfc);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0067 : Retrieve<br>
	 * Invoice Detail Inquiry by Date & Charge 의 event에 대한 조회 이벤트 처리<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDetailInvoiceListByDate(Event e) throws EventException {
		FnsInv0067Event event = (FnsInv0067Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		InvoiceDetailVO invoiceDetailVO = new InvoiceDetailVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			invoiceDetailVO = command.searchDetailInvoiceListByDate(event.getARInvoiceInquiryInPutVO());

			List<InvoiceDetailListVO> invoiceDetailListVO = invoiceDetailVO.getInvoiceDetailListVO();
			if (invoiceDetailListVO != null && invoiceDetailListVO.size() > 0) {
				eventResponse.setETCData("dp_prcs_knt", invoiceDetailListVO.get(0).getDpPrcsKnt());
				eventResponse.setRsVoList(invoiceDetailListVO);
			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0057 : Retrieve<br>
	 * Customer 별로 미발행 Invoice 현황을 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNotIssueListByCustomer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0057Event event = (FnsInv0057Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<NotIssuedListVO> list = command.searchNotIssueListByCustomer(event.getNotissuedInputVO());
			
			if (list != null && list.size() > 0) {
				eventResponse.setRsVoList(list);
				
				eventResponse.setETCData("dp_prcs_knt", list.get(0).getDpPrcsKnt());
				eventResponse.setETCData("cr_amt", list.get(0).getCrAmt());
				eventResponse.setETCData("ib_cr_term_dys", list.get(0).getIbCrTermDys());
				eventResponse.setETCData("ob_cr_term_dys", list.get(0).getObCrTermDys());
			} else {
				eventResponse.setETCData("dp_prcs_knt", "0");
				eventResponse.setETCData("cr_amt", "");
				eventResponse.setETCData("ib_cr_term_dys", "");
				eventResponse.setETCData("ob_cr_term_dys", "");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0056 : Retrieve<br>
	 * Customer 별로 미발행 Invoice 의 전체 건수를 입력한 기준일자 기준으로 due date 초과한 기간별로 보여준다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNotIssueAgingByCustomer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0056Event event = (FnsInv0056Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<NotIssuedAgingVO> list = command.searchNotIssueAgingByCustomer(event.getNotIssAgingVo());
			List<NotIssuedAgingVO> outList = new ArrayList<NotIssuedAgingVO>();

			if (list != null && list.size() > 0) {
				eventResponse.setETCData("dp_prcs_knt", list.get(0).getDpPrcsKnt());
				eventResponse.setETCData("day1", list.get(0).getDay1());
				eventResponse.setETCData("day2", list.get(0).getDay2());
				eventResponse.setETCData("day3", list.get(0).getDay3());
				eventResponse.setETCData("day4", list.get(0).getDay4());
				eventResponse.setETCData("day5", list.get(0).getDay5());

				eventResponse.setETCData("cr_clt_ofc_cd", list.get(0).getCrCltOfcCd());
				eventResponse.setETCData("cr_amt", list.get(0).getCrAmt());
				eventResponse.setETCData("ib_cr_term_dys", list.get(0).getIbCrTermDys());
				eventResponse.setETCData("ob_cr_term_dys", list.get(0).getObCrTermDys());

				boolean i_flag = false;
				boolean o_flag = false;
				boolean chgArOfcCdYn = false;
				String arOfcCd = "";

				for (int i = 0; i < list.size(); i++) {
					NotIssuedAgingVO notIssuedAgingVO = list.get(i);
					
					if (!arOfcCd.equals(notIssuedAgingVO.getArOfcCd())) {
						chgArOfcCdYn = true;
						arOfcCd = notIssuedAgingVO.getArOfcCd();
						i_flag = false;
						o_flag = false;
					}
					else {
						chgArOfcCdYn = false;
					}
					
					if (notIssuedAgingVO.getIoBndCd().equals("I/B")) {
						i_flag = true;
					}
					if (notIssuedAgingVO.getIoBndCd().equals("O/B")) {
						o_flag = true;
					}
					
					// 빈 O/B 추가
					if (chgArOfcCdYn && !o_flag) {
						NotIssuedAgingVO notIssuedAgingVOOut = new NotIssuedAgingVO();
						
						notIssuedAgingVOOut.setArOfcCd(notIssuedAgingVO.getArOfcCd());
						notIssuedAgingVOOut.setIoBndCd("O/B");
						notIssuedAgingVOOut.setTtlAmt("0");
						notIssuedAgingVOOut.setTtlLtAmt("0");
						notIssuedAgingVOOut.setTtlWiTermAmt("0");
						notIssuedAgingVOOut.setBelowDay1Amt("0");
						notIssuedAgingVOOut.setBelowDay2Amt("0");
						notIssuedAgingVOOut.setBelowDay3Amt("0");
						notIssuedAgingVOOut.setBelowDay4Amt("0");
						notIssuedAgingVOOut.setBelowDay5Amt("0");
						notIssuedAgingVOOut.setNotArrivedAmt("0");
						notIssuedAgingVOOut.setOverDay5Amt("0");
						notIssuedAgingVOOut.setWiTermAmt("0");

						outList.add(notIssuedAgingVOOut);
					}

					outList.add(notIssuedAgingVO);
					
					if (list.size() > 1) {
						// 빈 I/B 추가
						if (i!=0 && chgArOfcCdYn && !i_flag) {
							NotIssuedAgingVO notIssuedAgingVOIn = new NotIssuedAgingVO();
							
							notIssuedAgingVOIn.setArOfcCd(notIssuedAgingVO.getArOfcCd());
							notIssuedAgingVOIn.setIoBndCd("I/B");
							notIssuedAgingVOIn.setTtlAmt("0");
							notIssuedAgingVOIn.setTtlLtAmt("0");
							notIssuedAgingVOIn.setTtlWiTermAmt("0");
							notIssuedAgingVOIn.setBelowDay1Amt("0");
							notIssuedAgingVOIn.setBelowDay2Amt("0");
							notIssuedAgingVOIn.setBelowDay3Amt("0");
							notIssuedAgingVOIn.setBelowDay4Amt("0");
							notIssuedAgingVOIn.setBelowDay5Amt("0");
							notIssuedAgingVOIn.setNotArrivedAmt("0");
							notIssuedAgingVOIn.setOverDay5Amt("0");
							notIssuedAgingVOIn.setWiTermAmt("0");
	
							outList.add(notIssuedAgingVOIn);
						}
					}
					else {
						// 빈 I/B 추가
						if (chgArOfcCdYn && !i_flag) {
							NotIssuedAgingVO notIssuedAgingVOIn = new NotIssuedAgingVO();
							
							notIssuedAgingVOIn.setArOfcCd(notIssuedAgingVO.getArOfcCd());
							notIssuedAgingVOIn.setIoBndCd("I/B");
							notIssuedAgingVOIn.setTtlAmt("0");
							notIssuedAgingVOIn.setTtlLtAmt("0");
							notIssuedAgingVOIn.setTtlWiTermAmt("0");
							notIssuedAgingVOIn.setBelowDay1Amt("0");
							notIssuedAgingVOIn.setBelowDay2Amt("0");
							notIssuedAgingVOIn.setBelowDay3Amt("0");
							notIssuedAgingVOIn.setBelowDay4Amt("0");
							notIssuedAgingVOIn.setBelowDay5Amt("0");
							notIssuedAgingVOIn.setNotArrivedAmt("0");
							notIssuedAgingVOIn.setOverDay5Amt("0");
							notIssuedAgingVOIn.setWiTermAmt("0");
	
							outList.add(notIssuedAgingVOIn);
						}
					}
					log.debug("#### outList.size() = "+outList.size());
				}
			} else {
				eventResponse.setETCData("dp_prcs_knt", "0");
				eventResponse.setETCData("day1", event.getNotIssAgingVo().getDay1());
				eventResponse.setETCData("day2", event.getNotIssAgingVo().getDay2());
				eventResponse.setETCData("day3", event.getNotIssAgingVo().getDay3());
				eventResponse.setETCData("day4", event.getNotIssAgingVo().getDay4());
				eventResponse.setETCData("day5", event.getNotIssAgingVo().getDay5());

				eventResponse.setETCData("cr_clt_ofc_cd", "");
				eventResponse.setETCData("cr_amt", "");
				eventResponse.setETCData("ib_cr_term_dys", "");
				eventResponse.setETCData("ob_cr_term_dys", "");
				
				eventResponse.setUserMessage(new ErrorHandler("INV00095", new String[] {}).getUserMessage());
			}

			eventResponse.setRsVoList(outList);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0038 : Retrieve<br>
	 * 입력한 B/L 에 대한 북중국지역의 Invoice 발행대상을 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHNInvoiceForIssue(Event e) throws EventException {
		FnsInv0038Event event = (FnsInv0038Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<CHNIssuedInvoiceListVO> list = command.searchCHNInvoiceForIssue(event.getBlNo(), event.getOfcCd(), event.getCurCd(), account.getUsr_id());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0038 : Paper Issue<br>
	 * 북중국지역의 Invoice 를 발행함<br>
	 * author Dong Hoon Han
	 * 
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse issueCHNInvoice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0038Event event = (FnsInv0038Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		String invNo = "";
		StringBuffer invNoBuff = new StringBuffer();
		try {
			begin();
			List<String> list = command.issueCHNInvoice(event.getCHNIssuedInvoiceListVOS(), event.getOfcCd(), event.getCurCd(), account.getUsr_id());

			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					command2.modifyIssueFlag(list.get(i), "Y", account.getUsr_id());
					invNoBuff.append(list.get(i) + "|");
					//invNo = invNo + list.get(i) + "|";
				}
			}
			invNo = invNoBuff.toString();
			eventResponse.setETCData("invNo", invNo);

			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0066 : Retrieve<br>
	 * 매출채권 및 Invoice 의 Summary 현황을 Date 기준으로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSummaryInvoiceListByDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0066Event event = (FnsInv0066Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<InvoiceSummaryListVO> list = command.searchSummaryInvoiceListByDate(event.getInvoiceInquiryInPutVO());
			eventResponse.setRsVoList(list);
			if (list.size() > 0) {
				eventResponse.setETCData("dp_prcs_knt", list.get(0).getDpPrcsKnt());
			} else {
				eventResponse.setETCData("dp_prcs_knt", "0");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0106 : Retrieve <br>
	 * POP_UP 화면에서 Invoice 발행일자 기준으로 조회한다.(Re-Issue 화면에서 사용). <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopInvoiceListByIssueDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		FnsInv0106Event event = (FnsInv0106Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<ARInvoiceIssueDateVO> list = command.searchPopInvoiceListByIssueDate(event.getInvoiceIssueDateVO());

			if (list.size() > 0) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0096 : Retrieve<br>
	 * 입력한 B/L 에 대한 북중국지역의 Invoice 재발행대상을 조회한다.
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHNInvoiceForReissue(Event e) throws EventException {
		FnsInv0096Event event = (FnsInv0096Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<CHNReissuedInvoiceListVO> list = command.searchCHNInvoiceForReissue(event.getBlNo(), event.getOfcCd(), event.getCurCd());
			if (list.size() > 0) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0096 : Save<br>
	 * N.China Invoice Re-Issue Paper Re-issue 에 대해 저장한다.<br>
	 * author Dong Hoon Han
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reissueCHNInvoice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0096Event event = (FnsInv0096Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		try {
			begin();
			// command.reissueCHNInvoice(event.getChnInv(), event.getOfcCd(), account.getUsr_id());
			command.reissueCHNInvoice(event.getCHNReissuedInvoiceListVOS(), account.getUsr_id());

			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0017 : 조회<br>
	 * Interface Date 로 Customer Code 변경대상 Invoice 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse searchARInvoiceListByDate(Event e) throws EventException {
		FnsInv0017Event event = (FnsInv0017Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try {
			List<ARInvoiceCustomerVO> list = command.searchARInvoiceListByDate(event.getARInvoiceCustomerInputVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0017 : 조회<br>
	 * Customer Name 로 Customer List를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse searchARCustomerList(Event e) throws EventException {
		FnsInv0017Event event = (FnsInv0017Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<MDMCustomerVO> list = command.searchARCustomerList(event.getOfcCd(), event.getCustNm(), event.getShprCustCntCd(), event.getShprCustSeq(), event.getFwdrCustCntCd(), event.getFwdrCustSeq());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0017 : 입력,수정<br>
	 * B/L 별로 Invoice 의 Item 들을 Correction 하여 ERP 로 Interface 처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse modifyARInvoiceListByDate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0017Event event = (FnsInv0017Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		BookingARCreationBC bcommand = new BookingARCreationBCImpl();

		InvArMnVO[] invArMnVOs = event.getInvArMnVOs();
		List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO invArIfNoVO = new InvArIfNoVO();
		List<InvArIfNoVO> maxIfNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO maxArIfNoVO = new InvArIfNoVO();
		//String newIfNo="";		
		String otsSmryCd = "";
		boolean checkChgAmt = false;
		
		
		try {
			begin();
			
			if (invArMnVOs != null) {
				for (int i = 0; i < invArMnVOs.length; i++) {
					
					
					//사전 체크로직 - Customer 를 변경시, 기 i/f 금액이 balance 가 zero 인 경우 customer code 변경이 불가토록 변경
					HashMap<String, Object> eventParams = event.getEventParams();
					String changedCustCd = (String)eventParams.get("changed_cust_cd");
					
					// UI에서 Customer가 변경되었다면
					if ("custCdIsChanged".equals(changedCustCd)) {
						// CHG의 합이 0인지 체크
						if (checkChgAmount(invArMnVOs[i].getBlSrcNo(), invArMnVOs[i].getArOfcCd())){
							// CHG의 합이 0이면 UI에 알려준다.
							checkChgAmt = true;
							// 이하의 로직은 하지 않고 다음 BL을 체크한다.
							continue;
						}
					}
					
					// OTSSummary 조회
					otsSmryCd = command.searchOTSSummary(invArMnVOs[i].getArOfcCd());
					
					//Max If NO인지 저장전 체크 
					int chkCnt = command.checkMaxIfNo ( invArMnVOs[i].getArOfcCd(), invArMnVOs[i].getBlSrcNo(), invArMnVOs[i].getArIfNo() );
					
					if(chkCnt==1){
					
						// 해당 BLNo로 수정할 List 조회					
						List<InvArMnVO> invArMnList = command.searchARInvoiceMainList(invArMnVOs[i].getArOfcCd(), invArMnVOs[i].getBlSrcNo(), invArMnVOs[i].getArIfNo());
	
						
						// Ots Summary CD가 INV일 때 2010-01-28 CLR도 추가 
						if (otsSmryCd.equals("INV")||otsSmryCd.equals("CLR")) {					
					
							if (invArMnList != null) {
								for (int j = 0; j < invArMnList.size(); j++) {							
																		
									ARCorrectionCkVO aRCorrectionCkVO = new ARCorrectionCkVO();
		
									aRCorrectionCkVO.setBkgNo(invArMnList.get(j).getBkgNo());
									aRCorrectionCkVO.setInvCustFlg("Y");
									aRCorrectionCkVO.setOfcCd(invArMnList.get(j).getArOfcCd());
									aRCorrectionCkVO.setSailingDt(invArMnList.get(j).getSailDt());
									aRCorrectionCkVO.setBlInvCfmDt(invArMnList.get(j).getBlInvCfmDt());
									// Rev Type, Effective Dt 조회
									ARCorrectionCkReturnVO arCrctCkRtVO = command.checkARCorrection(aRCorrectionCkVO);
		
									// Cancel Data 세팅
									CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();
		
									cancelInvoiceVO.setEffDt(arCrctCkRtVO.getEffectiveDt());
									cancelInvoiceVO.setIfNo(invArMnList.get(j).getArIfNo());
									cancelInvoiceVO.setOtsSmryCd(otsSmryCd);
									cancelInvoiceVO.setUserId(account.getUsr_id());
									//2010-01-20 RevTpCd,RevSrcCd Create시 구하는 걸로 변경
									cancelInvoiceVO.setInvCustFlg("Y");
									//cancelInvoiceVO.setRevTpCd(arCrctCkRtVO.getRevTpCd());
									//cancelInvoiceVO.setRevSrcCd(arCrctCkRtVO.getRevSrcCd());
									cancelInvoiceVO.setInvCustCntCd(invArMnVOs[i].getActCustCntCd());
									cancelInvoiceVO.setInvCustSeq(invArMnVOs[i].getActCustSeq());
									
									// Good Data : Cancel->New
									if (!invArMnList.get(j).getBlInvCfmDt().equals("")) {
										String cancelIfNo = bcommand.createARCancelInvoice(cancelInvoiceVO);	
		
										if(!cancelIfNo.equals("")){
											//SYS CLEAR가 된 대상 IFNO도 ERP전송대상에 추가 2009.12.29
											if(otsSmryCd.equals("INV")){
												maxArIfNoVO = new InvArIfNoVO();
												maxArIfNoVO.setIfNo(invArMnList.get(j).getArIfNo());
												maxIfNos.add(maxArIfNoVO);
											}
											
											invArIfNoVO = new InvArIfNoVO();
											invArIfNoVO.setIfNo(cancelIfNo);
											ifNos.add(invArIfNoVO);
										}								
									} 
								}		
							}
						
						}
						
						ARCorrectionCkVO aRCorCkVO = new ARCorrectionCkVO();
	
						aRCorCkVO.setBkgNo(invArMnVOs[i].getBkgNo());
						aRCorCkVO.setInvCustFlg("Y");
						aRCorCkVO.setOfcCd(invArMnVOs[i].getArOfcCd());
						aRCorCkVO.setSailingDt(invArMnVOs[i].getSailDt());
						aRCorCkVO.setBlInvCfmDt(invArMnVOs[i].getBlInvCfmDt());
						// Rev Type, Effective Dt 조회
						ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.checkARCorrection(aRCorCkVO);
	
						// Cancel Data 세팅
						CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();
	
						cancelInvoiceVO.setEffDt(arCorrectionCkReturnVO.getEffectiveDt());
						cancelInvoiceVO.setIfNo(invArMnVOs[i].getArIfNo());
						cancelInvoiceVO.setOtsSmryCd(otsSmryCd);
						cancelInvoiceVO.setUserId(account.getUsr_id());
						//2010-01-20 RevTpCd,RevSrcCd Create시 구하는 걸로 변경
						cancelInvoiceVO.setInvCustFlg("Y");
						//cancelInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
						//cancelInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
						cancelInvoiceVO.setInvCustCntCd(invArMnVOs[i].getActCustCntCd());
						cancelInvoiceVO.setInvCustSeq(invArMnVOs[i].getActCustSeq());
						
						if (!invArMnVOs[i].getBlInvCfmDt().equals("")) {
							String cancelIfNo = bcommand.createARCancelInvoice(cancelInvoiceVO);
							if(!cancelIfNo.equals("")){
								
								//SYS CLEAR가 된 대상 IFNO도 ERP전송대상에 추가 2009.12.29
								if(otsSmryCd.equals("INV")){
									maxArIfNoVO = new InvArIfNoVO();
									maxArIfNoVO.setIfNo(invArMnVOs[i].getArIfNo());
									maxIfNos.add(maxArIfNoVO);
								}
								
								invArIfNoVO = new InvArIfNoVO();
								invArIfNoVO.setIfNo(cancelIfNo);
								ifNos.add(invArIfNoVO);
							}
						}
						
						// Ots Summary CD가 INV일 때 2010-01-28 CLR도 추가 
						if (otsSmryCd.equals("INV")||otsSmryCd.equals("CLR")) {
						
							if (invArMnList != null) {						
								for (int j = 0; j < invArMnList.size(); j++) {
									
									//Due Dt 구하는 로직 BC에서 직접 구하는 방식으로 변경 2009-11-30
									/*
									DueDateInputVO dueDateInputVO = new DueDateInputVO();
		
									dueDateInputVO.setBnd(invArMnList.get(j).getIoBndCd());
									dueDateInputVO.setCustCntCd(invArMnVOs[i].getActCustCntCd());
									dueDateInputVO.setSaDt(invArMnList.get(j).getSailArrDt());
									dueDateInputVO.setCustSeq(invArMnVOs[i].getActCustSeq());
									dueDateInputVO.setOfcCd(invArMnList.get(j).getArOfcCd());
									// Due Date 조회
									List<DueDateVO> dueDtList = command.searchDueDate(dueDateInputVO);
									*/
									ARCorrectionCkVO aRCorrectionCkVO = new ARCorrectionCkVO();
		
									aRCorrectionCkVO.setBkgNo(invArMnList.get(j).getBkgNo());
									aRCorrectionCkVO.setInvCustFlg("Y");
									aRCorrectionCkVO.setOfcCd(invArMnList.get(j).getArOfcCd());
									aRCorrectionCkVO.setSailingDt(invArMnList.get(j).getSailDt());
									aRCorrectionCkVO.setBlInvCfmDt(invArMnList.get(j).getBlInvCfmDt());
									// Rev Type, Effective Dt 조회
									ARCorrectionCkReturnVO arCrctCkRtVO = command.checkARCorrection(aRCorrectionCkVO);
									
									// New Data 세팅
									InvNewCustVO invNewCustVO = new InvNewCustVO();
		
									invNewCustVO.setActCustCntCd(invArMnVOs[i].getActCustCntCd());
									invNewCustVO.setActCustSeq(invArMnVOs[i].getActCustSeq());
									invNewCustVO.setInvCustCntCd(invArMnVOs[i].getActCustCntCd());
									invNewCustVO.setInvCustSeq(invArMnVOs[i].getActCustSeq());
									/*
									if (dueDtList.size() > 0) {
										// Due Date 세팅
										invNewCustVO.setDueDt(dueDtList.get(0).getDueDate());
										invNewCustVO.setCustCrFlg(dueDtList.get(0).getCrFlg());
										invNewCustVO.setCrTermDys(dueDtList.get(0).getCrTermDys());
									}
									*/
									
									invNewCustVO.setArIfNo(invArMnList.get(j).getArIfNo());
									invNewCustVO.setInvRmk(invArMnList.get(j).getInvRmk());
									invNewCustVO.setUiType("C");
									
									invNewCustVO.setOtsSmryCd(otsSmryCd);
									invNewCustVO.setGlEffDt(arCrctCkRtVO.getEffectiveDt());
									//2010-01-20 RevTpCd,RevSrcCd Create시 구하는 걸로 변경
									invNewCustVO.setInvCustFlg("Y");
									//invNewCustVO.setRevTpCd(arCrctCkRtVO.getRevTpCd());
									//invNewCustVO.setRevSrcCd(arCrctCkRtVO.getRevSrcCd());
									invNewCustVO.setBlInvCfmDt(invArMnList.get(j).getBlInvCfmDt());
									
									// Good Data : Cancel->New
									if (!invArMnList.get(j).getBlInvCfmDt().equals("")) {
										invNewCustVO.setSplitFlag("C");	
										String newIfNo = bcommand.createNewCustomerARInvoice(invNewCustVO, account.getUsr_id());
										
										if(!newIfNo.equals("")){
											invArIfNoVO = new InvArIfNoVO();
											invArIfNoVO.setIfNo(newIfNo);
											ifNos.add(invArIfNoVO);
										}
										// No Good Data : createNewCustomerARInvoice 에서 No Good은 Del Code Update
									} else {
										//2010-03-23 No Good 일때는 Split Flag Null로 세팅 이상희 과장  2010-04-28 BKGIF 이행데이터 오류때문데 다시 넣어줌
										invNewCustVO.setSplitFlag("C");								
										String newIfNo = bcommand.createNewCustomerARInvoice(invNewCustVO, account.getUsr_id());
										if(!newIfNo.equals("")){
											invArIfNoVO = new InvArIfNoVO();
											invArIfNoVO.setIfNo(newIfNo);
											ifNos.add(invArIfNoVO);
										}
									}
									
								}
							}
						
						}
						
						//Due Dt 구하는 로직 BC에서 직접 구하는 방식으로 변경 2009-11-30
						/*
						DueDateInputVO dueDateInputVO = new DueDateInputVO();
	
						dueDateInputVO.setBnd(invArMnVOs[i].getIoBndCd());
						dueDateInputVO.setCustCntCd(invArMnVOs[i].getActCustCntCd());
						dueDateInputVO.setSaDt(invArMnVOs[i].getSailArrDt());
						dueDateInputVO.setCustSeq(invArMnVOs[i].getActCustSeq());
						dueDateInputVO.setOfcCd(invArMnVOs[i].getArOfcCd());
						// Due Date 조회
						List<DueDateVO> list = command.searchDueDate(dueDateInputVO);
	
						*/					
	
						// New Data 세팅
						InvNewCustVO invNewCustVO = new InvNewCustVO();
	
						invNewCustVO.setActCustCntCd(invArMnVOs[i].getActCustCntCd());
						invNewCustVO.setActCustSeq(invArMnVOs[i].getActCustSeq());
						invNewCustVO.setInvCustCntCd(invArMnVOs[i].getActCustCntCd());
						invNewCustVO.setInvCustSeq(invArMnVOs[i].getActCustSeq());
						/*
						if (list.size() > 0) {
							// Due Date 세팅
							invNewCustVO.setDueDt(list.get(0).getDueDate());
							invNewCustVO.setCustCrFlg(list.get(0).getCrFlg());
							invNewCustVO.setCrTermDys(list.get(0).getCrTermDys());
						}
						*/
						invNewCustVO.setArIfNo(invArMnVOs[i].getArIfNo());
						invNewCustVO.setInvRmk(invArMnVOs[i].getInvRmk());
						invNewCustVO.setUiType("C");
						invNewCustVO.setOtsSmryCd(otsSmryCd);
						invNewCustVO.setGlEffDt(arCorrectionCkReturnVO.getEffectiveDt());
						//2010-01-20 RevTpCd,RevSrcCd Create시 구하는 걸로 변경
						invNewCustVO.setInvCustFlg("Y");
						//invNewCustVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
						//invNewCustVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
						invNewCustVO.setBlInvCfmDt(invArMnVOs[i].getBlInvCfmDt());
						// Good Data : Cancel->New
						if (!invArMnVOs[i].getBlInvCfmDt().equals("")) {						
							invNewCustVO.setSplitFlag("C");
							
							String newIfNo = bcommand.createNewCustomerARInvoice(invNewCustVO, account.getUsr_id());
							if(!newIfNo.equals("")){
								invArIfNoVO = new InvArIfNoVO();
								invArIfNoVO.setIfNo(newIfNo);
								ifNos.add(invArIfNoVO);
							}
							// No Good Data : createNewCustomerARInvoice 에서 No Good은 Del Code Update
						} else {
							//2010-03-23 No Good 일때는 Split Flag Null로 세팅 이상희 과장  2010-04-28 BKGIF 이행데이터 오류때문데 다시 넣어줌
							invNewCustVO.setSplitFlag("C");
							
							String newIfNo = bcommand.createNewCustomerARInvoice(invNewCustVO, account.getUsr_id());
							if(!newIfNo.equals("")){
								invArIfNoVO = new InvArIfNoVO();
								invArIfNoVO.setIfNo(newIfNo);
								ifNos.add(invArIfNoVO);
							}
						}
					}
				
				}
			}
			
			commit();
			
			begin();
			//Sys Clear 된 대상 IfNo 가 Good Data인 IfNo 모아서 ERP전송
			if(maxIfNos!= null && maxIfNos.size()>0){
				bcommand.interfaceARInvoiceToERPAR(maxIfNos, "U");
			}
			
			//Good Data인 IfNo 모아서 ERP전송
			if(ifNos!= null && ifNos.size()>0){
				bcommand.interfaceARInvoiceToERPAR(ifNos, "C");
			}
			if (!checkChgAmt) {
				eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00143", new String[] {}).getUserMessage());
			}
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;

	}

	/**
	 * FNS_INV_0094_01 :조회 <br>
	 * Invoice Customer Change (Single)조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChangeCustomerInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv009401Event event = (FnsInv009401Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		InvoiceCustomerChangeVO invoiceCustomerChangeVO = new InvoiceCustomerChangeVO();
		String revType = "";

		try { 
			 
			revType = command.searchDODCount(event.getOfcCd(), event.getInvNo());
			
			if(null != revType){
				if ( !revType.equals("MDF")) {
					invoiceCustomerChangeVO = command.searchChangeCustomerInvoice(event.getOfcCd(), event.getInvNo());
					
					
				} else {
//					eventResponse.setUserMessage("DOD 모듈에서 넘어온 DATA는  INVOICE 모듈에서 CUSTOMER 변경을 할 수 없습니다. \n  DOD 모듈에서 CUSTOMER 정보를 변경하시기 바랍니다.");
					eventResponse.setUserMessage(new ErrorHandler("INV00164", new String[] {}).getUserMessage());
				}
			}else{
				invoiceCustomerChangeVO = command.searchChangeCustomerInvoice(event.getOfcCd(), event.getInvNo());
			}
			
//			invoiceCustomerChangeVO = command.searchChangeCustomerInvoice(event.getOfcCd(), event.getInvNo());
			
			eventResponse.setRsVo(invoiceCustomerChangeVO);
			eventResponse.setRsVoList(invoiceCustomerChangeVO.getInvoiceCustomerChangeChargeVOs());


		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0094_01 : 입력,수정<br>
	 * Invoice Customer Change (Single) Cancel Data , New Data 생성<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCustomerChangeInvoice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv009401Event event = (FnsInv009401Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		BookingARCreationBC bcommand = new BookingARCreationBCImpl();

		//DueDateInputVO[] dueDateInputVOs = event.getDueDateInputVOs();
		List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO invArIfNoVO = new InvArIfNoVO();	
		String newIfNo="";		
		
		try {
			begin();

			int repCustCnt = 0;

			repCustCnt = command.checkRepCustomer(event.getActCustCntCd(), event.getActCustSeq());

			if (repCustCnt > 0) {
				eventResponse.setUserMessage(new ErrorHandler("INV00123", new String[] {}).getUserMessage());
			}

			int invRepCustCnt = 0;

			invRepCustCnt = command.checkRepCustomer(event.getInvCustCntCd(), event.getInvCustSeq());

			if (invRepCustCnt > 0) {
				eventResponse.setUserMessage(new ErrorHandler("INV00123", new String[] {}).getUserMessage());
			}

			
			//if (dueDateInputVOs != null) {
					// Cancel Data 생성

				ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.searchRevTypeSrc(event.getBkgNo(), "C");

				CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();

				cancelInvoiceVO.setIfNo(event.getArIfNo());
				cancelInvoiceVO.setOtsSmryCd("");
				cancelInvoiceVO.setUserId(account.getUsr_id());
				cancelInvoiceVO.setInvNo(event.getInvNo());
				cancelInvoiceVO.setRevTpCd(event.getRevTpCd().equals("M")?event.getRevTpCd():arCorrectionCkReturnVO.getRevTpCd());
				cancelInvoiceVO.setRevSrcCd(event.getRevTpCd().equals("M")?event.getRevSrcCd():arCorrectionCkReturnVO.getRevSrcCd());
				cancelInvoiceVO.setUiType("C");
				
				newIfNo = bcommand.createCancelIssueARInvoice(cancelInvoiceVO);
				
				if(!newIfNo.equals("")){
					invArIfNoVO = new InvArIfNoVO();
					invArIfNoVO.setIfNo(newIfNo);
					ifNos.add(invArIfNoVO);
				}

				CancelInvoiceVO newInvoiceVO = new CancelInvoiceVO();

				newInvoiceVO.setActCustCntCd(event.getActCustCntCd());
				newInvoiceVO.setActCustSeq(event.getActCustSeq());
				newInvoiceVO.setInvCustCntCd(event.getInvCustCntCd());
				newInvoiceVO.setInvCustSeq(event.getInvCustSeq());
				newInvoiceVO.setIfNo(event.getArIfNo());
				newInvoiceVO.setInvNo(event.getInvNo());
				newInvoiceVO.setRevTpCd(event.getRevTpCd().equals("M")?event.getRevTpCd():arCorrectionCkReturnVO.getRevTpCd());
				newInvoiceVO.setRevSrcCd(event.getRevTpCd().equals("M")?event.getRevSrcCd():arCorrectionCkReturnVO.getRevSrcCd());
				newInvoiceVO.setUiType("C");
				newInvoiceVO.setUserId(account.getUsr_id());

				// New Data 생성
				//if(event.getRevTpCd().equals("M")&&event.getBkgNo().equals("")){
				//2010-05-14	
				if(event.getRevTpCd().equals("M")){
					newIfNo = bcommand.createNewMIssueARInvoice(newInvoiceVO);
				}else{
					newIfNo = bcommand.createNewIssueARInvoice(newInvoiceVO);
				}
				
				if(!newIfNo.equals("")){
					invArIfNoVO = new InvArIfNoVO();
					invArIfNoVO.setIfNo(newIfNo);
					ifNos.add(invArIfNoVO);
				}
				
				//2009-12-02  REV_TP_CD ='M' 포함 하면서 수정
				bcommand.modifySplitCodebyInvNo(event.getInvNo(), event.getOfcCd(),"M", account.getUsr_id());
				
				/*
				for (int i = 0; i < dueDateInputVOs.length; i++) {
					// Invoice Split Code 를 Update 한다.
					bcommand.modifySplitCode(dueDateInputVOs[i].getArIfNo(), "M", "", account.getUsr_id());
				}*/
				
			//}
			
			commit();
			
			begin();
			//Good Data인 IfNo 모아서 ERP전송
			if(ifNos!= null && ifNos.size()>0){
				bcommand.interfaceARInvoiceToERPAR(ifNos, "C");
			}
			commit();
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}
	

	/**
	 * FNS_INV_0094_02: 조회<br>
	 * Invoice Customer Change (Multi)조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChangeCustomerInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv009402Event event = (FnsInv009402Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		InvoiceCustomerChangeVO invoiceCustomerChangeVO = new InvoiceCustomerChangeVO();

		try {
			invoiceCustomerChangeVO = command.searchChangeCustomerInvoiceList(event.getChangeCustomerInputVO());

			eventResponse.setRsVoList(invoiceCustomerChangeVO.getInvoiceCustomerChangeListVOs());
			eventResponse.setRsVoList(invoiceCustomerChangeVO.getDueDateInputVOs());

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0094_02: 조회<br>
	 * 변경대상 Customer 가 대표 Customer 인지 체크합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRepCustomer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv009402Event event = (FnsInv009402Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			int repCustCnt = 0;

			repCustCnt = command.checkRepCustomer(event.getActCustCntCd(), event.getActCustSeq());
			
			eventResponse.setETCData("rep_cust_cnt", Integer.toString(repCustCnt));

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	
	/**
	 * FNS_INV_0094_02 : 입력,수정<br>
	 * Invoice Customer Change (Multi) Cancel Data , New Data 생성하기 위한 BackEndJob의 Key를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCustomerChangeInvoiceListBackEndJobKey(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv009402Event event = (FnsInv009402Event) e;
		BookingARCreationBC command = new BookingARCreationBCImpl();

		try {
			begin();
			
			InvoiceCustomerChangeVO invoiceCustomerChangeVO = new InvoiceCustomerChangeVO();
			
			invoiceCustomerChangeVO.setActCustCntCd(event.getActCustCntCd());
			invoiceCustomerChangeVO.setActCustSeq(event.getActCustSeq());
			invoiceCustomerChangeVO.setInvCustCntCd(event.getInvCustCntCd());
			invoiceCustomerChangeVO.setInvCustSeq(event.getInvCustSeq());
			
	        String backEndJobKey = command.createCustomerChangeInvoiceList(event.getDueDateInputVOs(), invoiceCustomerChangeVO, account.getUsr_id());
	        eventResponse.setETCData("BackEndJobKey", backEndJobKey);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0094_02 : 입력,수정<br>
	 * Invoice Customer Change (Multi) Cancel Data , New Data 생성하기 위한 BackEndJob의 작업상태를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse createCustomerChangeInvoiceListBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv009402Event event = (FnsInv009402Event) e;

    	try {    		
	    	if(event.getBackEndJobKey() != null && !event.getBackEndJobKey().equals("")) {
    			// Backend job 완료여부를 검사한다.
		    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(event.getBackEndJobKey());

		    	DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
		    	
		    	ComBakEndJbVO jobVo = null;
		    	if (dbRowSetlist.size() == 0) {
		    		// Background job framework가 정상적으로 동작하지 않을 경우 발생하는 오류를 회피하기 위함
		    		jobVo = new ComBakEndJbVO();
		    		jobVo.setJbStsFlg("0");
		    	} else {
		    		jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);	
		    	}
		    	eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
	    	}
    	} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}

    	return eventResponse;
    }
	
	/**
	 * FNS_INV_0094_02 : 입력,수정<br>
	 * Invoice Customer Change (Multi) Cancel Data , New Data 생성하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
     * 
     * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCustomerChangeInvoiceListBackEndJobFile(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv009402Event event = (FnsInv009402Event) e;
		BookingARCreationBC command = new BookingARCreationBCImpl();

		try {
			command.getBackEndJobResutModifyExchangeRateList(event.getBackEndJobKey());			
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

        return eventResponse;
	}
	
	/**
	 * FNS_INV_0094_02 : 입력,수정<br>
	 * Invoice Customer Change (Multi) Cancel Data , New Data 생성합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCustomerChangeInvoiceList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv009402Event event = (FnsInv009402Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		BookingARCreationBC bcommand = new BookingARCreationBCImpl();

		DueDateInputVO[] dueDateInputVOs = event.getDueDateInputVOs();
		List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO invArIfNoVO = new InvArIfNoVO();	
		String newIfNo="";		
		
		try {
			begin();

			int repCustCnt = 0;

			repCustCnt = command.checkRepCustomer(event.getActCustCntCd(), event.getActCustSeq());

			if (repCustCnt > 0) {
				eventResponse.setUserMessage(new ErrorHandler("INV00123", new String[] {}).getUserMessage());
			}

			if (dueDateInputVOs != null) {

				for (int i = 0; i < dueDateInputVOs.length; i++) {
						
					ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.searchRevTypeSrc(dueDateInputVOs[i].getBkgNo(), "C");

					CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();

					cancelInvoiceVO.setIfNo(dueDateInputVOs[i].getArIfNo());
					cancelInvoiceVO.setOtsSmryCd("");
					cancelInvoiceVO.setUserId(account.getUsr_id());
					cancelInvoiceVO.setInvNo(dueDateInputVOs[i].getInvNo());
					cancelInvoiceVO.setRevTpCd(dueDateInputVOs[i].getRevTpCd().equals("M")?dueDateInputVOs[i].getRevTpCd():arCorrectionCkReturnVO.getRevTpCd());
					cancelInvoiceVO.setRevSrcCd(dueDateInputVOs[i].getRevTpCd().equals("M")?dueDateInputVOs[i].getRevSrcCd():arCorrectionCkReturnVO.getRevSrcCd());
					cancelInvoiceVO.setUiType("C");
					
					newIfNo = bcommand.createCancelIssueARInvoice(cancelInvoiceVO);
					
					if(!newIfNo.equals("")){
						invArIfNoVO = new InvArIfNoVO();
						invArIfNoVO.setIfNo(newIfNo);
						ifNos.add(invArIfNoVO);
					}

					CancelInvoiceVO newInvoiceVO = new CancelInvoiceVO();

					newInvoiceVO.setActCustCntCd(event.getActCustCntCd());
					newInvoiceVO.setActCustSeq(event.getActCustSeq());
					newInvoiceVO.setIfNo(dueDateInputVOs[i].getArIfNo());
					newInvoiceVO.setInvNo(dueDateInputVOs[i].getInvNo());
					newInvoiceVO.setRevTpCd(dueDateInputVOs[i].getRevTpCd().equals("M")?dueDateInputVOs[i].getRevTpCd():arCorrectionCkReturnVO.getRevTpCd());
					newInvoiceVO.setRevSrcCd(dueDateInputVOs[i].getRevTpCd().equals("M")?dueDateInputVOs[i].getRevSrcCd():arCorrectionCkReturnVO.getRevSrcCd());
					newInvoiceVO.setUiType("C");
					newInvoiceVO.setUserId(account.getUsr_id());
					
					
					// New Data 생성
					//if(dueDateInputVOs[i].getRevTpCd().equals("M")&&dueDateInputVOs[i].getBkgNo().equals("")){
					if(dueDateInputVOs[i].getRevTpCd().equals("M")){
						newIfNo = bcommand.createNewMIssueARInvoice(newInvoiceVO);
					}else{
						newIfNo = bcommand.createNewIssueARInvoice(newInvoiceVO);
					}
					
					
					if(!newIfNo.equals("")){
						invArIfNoVO = new InvArIfNoVO();
						invArIfNoVO.setIfNo(newIfNo);
						ifNos.add(invArIfNoVO);
					}
					
					//2009-12-02 REV_TP_CD ='M' 포함 하면서 수정
					bcommand.modifySplitCodebyInvNo(dueDateInputVOs[i].getInvNo(), dueDateInputVOs[i].getOfcCd(),"M", account.getUsr_id());
					

				// Invoice Split Code 를 Update 한다.
				//bcommand.modifySplitCode(dueDateInputVOs[i].getArIfNo(), "M", "", account.getUsr_id());
				}
				
			}
			commit();
			
			begin();
			//Good Data인 IfNo 모아서 ERP전송
			if(ifNos!= null && ifNos.size()>0){
				bcommand.interfaceARInvoiceToERPAR(ifNos, "C");
			}
			commit();
			
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0029 : Execute<br>
	 * Invoice 금액합이 0(zero) 인 B/L data 들에 대해 일괄 Sys Clear 처리한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySysClearList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0029Event event = (FnsInv0029Event) e;
		BookingARCreationBC command = new BookingARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		int result = 0;
		try {
			begin();

			SysClearVO sysClearVo = event.getSysClearVo();

			sysClearVo.setUserId(account.getUsr_id());

			result = command.modifySysClearList(sysClearVo);

			eventResponse.setETCData("result_cnt", String.valueOf(result));

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0029 : Execute<br>
	 * Invoice 금액합이 0(zero) 인 I/F No. 들에 대해 일괄 Sys Clear 처리한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySysClearListByIfNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0029Event event = (FnsInv0029Event) e;
		BookingARCreationBC command = new BookingARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		int result = 0;
		try {
			begin();

			SysClearVO sysClearVo = event.getSysClearVo();

			sysClearVo.setUserId(account.getUsr_id());

			result = command.modifySysClearListByIfNo(sysClearVo);

			eventResponse.setETCData("result_cnt", String.valueOf(result));

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0027: 수정 <br> 
	 *  경리환율, VVD 환율 등 환율 정보과 없는 경우 해당 테이블의 환율을 읽어 일괄 Update 하기 위한 BackEndJob의 Key를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyExchangeRateListBackEndJobKey(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0027Event event = (FnsInv0027Event) e;
		BookingARCreationBC command = new BookingARCreationBCImpl();

		try {
			begin();
	        String backEndJobKey = command. modifyExchangeRateList(event.getExrateInputVOs(),event.getExrateInputVO(),event.getRunOpt(),account.getUsr_id());
	        eventResponse.setETCData("BackEndJobKey", backEndJobKey);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0027: 수정 <br> 
	 * 경리환율, VVD 환율 등 환율 정보과 없는 경우 해당 테이블의 환율을 읽어 일괄 Update 하기 위한 BackEndJob의 작업상태를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse modifyExchangeRateListBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0027Event event = (FnsInv0027Event) e;

    	try {    		
	    	if(event.getBackEndJobKey() != null && !event.getBackEndJobKey().equals("")) {
    			// Backend job 완료여부를 검사한다.
		    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(event.getBackEndJobKey());

		    	DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
		    	
		    	ComBakEndJbVO jobVo = null;
		    	if (dbRowSetlist.size() == 0) {
		    		// Background job framework가 정상적으로 동작하지 않을 경우 발생하는 오류를 회피하기 위함
		    		jobVo = new ComBakEndJbVO();
		    		jobVo.setJbStsFlg("0");
		    	} else {
		    		jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);	
		    	}
		    	eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
	    	}
    	} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}

    	return eventResponse;
    }
	
	/**
	 * FNS_INV_0027: 수정 <br> 
	 * 경리환율, VVD 환율 등 환율 정보과 없는 경우 해당 테이블의 환율을 읽어 일괄 Update 하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
     * 
     * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyExchangeRateListBackEndJobFile(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0027Event event = (FnsInv0027Event) e;
		BookingARCreationBC command = new BookingARCreationBCImpl();

		try {
			List<ExRateCountVO> exRateCountVOs = command.getBackEndJobResutModifyExchangeRateList(event.getBackEndJobKey());
			
			if(exRateCountVOs.size()>0){				
				eventResponse.setRsVoList(exRateCountVOs);				
				eventResponse.setETCData("tot_cnt", exRateCountVOs.get(0).getCount1());
				eventResponse.setETCData("good_cnt", exRateCountVOs.get(0).getCount2());
				eventResponse.setETCData("no_good_cnt", exRateCountVOs.get(0).getCount3());
			}else{
				eventResponse.setETCData("tot_cnt", "0");
				eventResponse.setETCData("good_cnt", "0");
				eventResponse.setETCData("no_good_cnt", "0");
			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

        return eventResponse;
	}

	/**
	 * FNS_INV_0103 : Retrieve<br>
	 * Customer Preferable Report Report ID 로 History로 저장된 내용을 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCPRTHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		FnsInv0103Event event = (FnsInv0103Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			event.getCPRTListVO().setCustRptId(event.getCustRptId());
			List<CPRTMainVO> list = command.searchCPRTHistoryList(event.getCPRTListVO());

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0104 : Retrieve<br>
	 * Customer Preferable Report Report ID 를 생성 기간 및 생성 user, Office등의 조건으로 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCPRTIDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		FnsInv0104Event event = (FnsInv0104Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<CPRTListVO> list = command.searchCPRTIDList(event.getCPRIDListInputVO());

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0043 : 조회<br>
	 * Invoice 기 발행 건에 대하여 Report산출을 위해 Invoice 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDirectBilling(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0043Event event = (FnsInv0043Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<DirectBillingInvoiceVO> list = command.searchDirectBilling(event.getBillInputVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0069 : Open<br>
	 * A/R HEAD QUARTER OFFICE CODE를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARRHQOfficeList(Event e) throws EventException {
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<String> list = command.searchARRHQOfficeList();
			String arHdQtrOfcInfo = "";
			StringBuffer arHdQtrOfcInfoBuff = new StringBuffer();
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					arHdQtrOfcInfoBuff.append("|" + list.get(i));
					//arHdQtrOfcInfo = arHdQtrOfcInfo + "|" + list.get(i);
				}
				arHdQtrOfcInfo = arHdQtrOfcInfoBuff.toString();
				eventResponse.setETCData("ar_hd_qtr_ofc_cd", arHdQtrOfcInfo);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
			return eventResponse;
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0068 : Retrieve<br>
	 * BOMSC 지역이외 Office 에서 GST Charge 가 Rating 된 현황을 Date 별로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGSTListByDate(Event e) throws EventException {
		FnsInv0069Event event = (FnsInv0069Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<GSTChargeListVO> list = command.searchGSTListByDate(event.getDateOption(), event.getFromDate(), event.getToDate(), event.getRhq());
			if (list.size() > 0) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0039 : Retrieve<br>
	 * 한국지역 Invoice 정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKORInvoice(Event e) throws EventException {
		FnsInv0039Event event = (FnsInv0039Event) e;
		InvoiceIssueBCImpl command = new InvoiceIssueBCImpl();
		KORInvoiceVO korInvoiceVO = new KORInvoiceVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			korInvoiceVO = command.searchKORInvoice(event.getInvNo(), event.getArOfcCd());

			if (korInvoiceVO != null) {
				eventResponse.setRsVo(korInvoiceVO);
				eventResponse.setRsVoList(korInvoiceVO.getKorInvoiceBLListVO());
				eventResponse.setRsVoList(korInvoiceVO.getInvArKrIssChgVO());
				eventResponse.setRsVoList(korInvoiceVO.getInvArKrIssChgVO());
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0039 : B/L No@CHANGE<br>
	 * B/L No 에 대한 VVD 정보와 Charge 정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKORIssueTargetByBL(Event e) throws EventException {
		FnsInv0039Event event = (FnsInv0039Event) e;
		InvoiceIssueBCImpl command = new InvoiceIssueBCImpl();
		KORInvoiceVO korInvoiceVO = new KORInvoiceVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			korInvoiceVO = command.searchKORIssueTargetByBL(event.getBlSrcNo(), event.getArOfcCd());

			if (korInvoiceVO != null) {
				eventResponse.setRsVo(korInvoiceVO);
				eventResponse.setRsVoList(korInvoiceVO.getKorInvoiceBLListVO());
				eventResponse.setRsVoList(korInvoiceVO.getInvArKrIssChgVO());
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0018 : 조회 <br>
	 * Split 하거나 Customer 를 변경하려는 대상 매출채권 정보 또는 Invoice 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse searchSplitARInvoiceByIFNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0018Event event = (FnsInv0018Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		BookingARCreationBC bcommand = new BookingARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			ARInvoiceSplitVO aRInvoiceSplitVO = command.searchSplitARInvoiceByIFNo(event.getIfNo(), event.getSplitCnt(), event.getOfcCd());

			bcommand.modifyNewInterfaceNo(event.getOfcCd(), aRInvoiceSplitVO.getMaxSeq(), account.getUsr_id());
			commit();
			
			eventResponse.setRsVo(aRInvoiceSplitVO.getARInvoiceCorrectionVO());
			eventResponse.setRsVoList(aRInvoiceSplitVO.getListInvoiceChargeCorrectionVO());
			eventResponse.setRsVoList(aRInvoiceSplitVO.getInvArCntrVOs());
			// eventResponse.setRsVo(aRInvoiceSplitVO);
			eventResponse.setRsVo(aRInvoiceSplitVO.getARInvoiceCustomerVO());

			eventResponse.setETCData("max_seq", aRInvoiceSplitVO.getMaxSeq());
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0018 : 입력,수정<br>
	 * 대상 매출채권 정보 또는 invoice 정보를 2인 이상의 Customer 로<BR>
	 * Split 하거나 단순히 다른 Customer 로 변경처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse splitARInvoiceByIFNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0018Event event = (FnsInv0018Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		BookingARCreationBC bcommand = new BookingARCreationBCImpl();

		InvArMnVO[] invArMnVOs = event.getInvArMnVOs();
		InvArChgVO[] invArChgVOs = event.getInvArChgVOs();
		InvArAmtVO[] invArAmtVOs = event.getInvArAmtVOs();
		InvArCntrVO[] invArCntrVOs = event.getInvArCntrVOs();
		
		List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO invArIfNoVO = new InvArIfNoVO();
		List<InvArIfNoVO> maxIfNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO maxArIfNoVO = new InvArIfNoVO();
		
		String newIfNo="";
		
		String otsSmryCd = "";
		int repCustCnt = 0;

		try {
			begin();
			
			//저장시 Split가능한 IF NO인지 다시한번 체크
			String chkSplitIfNo = command.checkSplitARInvoiceByIFNo(event.getIfNo(), event.getOfcCd());
			
			if (!chkSplitIfNo.equals("X")){
				eventResponse.setUserMessage(new ErrorHandler("INV00080", new String[] {}).getUserMessage());
				return eventResponse;
			}
			
			// A/R Office 기준정보에서 OTS Summary 기준 정보를 구한다.
			otsSmryCd = command.searchOTSSummary(event.getOfcCd());

			// Invoice Correction 정보를 Save 하기전 validation check 및 Effective date 를 구한다.
			// Good Data변경으로 신규데이터 생성시 적용될 revenue type , revenue source를 결정함.
			ARCorrectionCkVO aRCorrectionCkVO = new ARCorrectionCkVO();

			aRCorrectionCkVO.setBkgNo(event.getBkgNo());
			aRCorrectionCkVO.setInvCustFlg("");
			aRCorrectionCkVO.setOfcCd(event.getOfcCd());
			aRCorrectionCkVO.setSailingDt(event.getSailDt());
			aRCorrectionCkVO.setBlInvCfmDt(event.getSailDt());

			ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.checkARCorrection(aRCorrectionCkVO);
			// Invoice Split Code 를 Update 한다.
			bcommand.modifySplitCode(event.getIfNo(), "M", otsSmryCd, account.getUsr_id());

			CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();

			cancelInvoiceVO.setIfNo(event.getIfNo());
			cancelInvoiceVO.setNewIfNo(event.getCancelIfNo());
			cancelInvoiceVO.setEffDt(arCorrectionCkReturnVO.getEffectiveDt());
			cancelInvoiceVO.setOtsSmryCd(otsSmryCd);
			cancelInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
			cancelInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
			cancelInvoiceVO.setUserId(account.getUsr_id());

			// Cancel Data 생성
			newIfNo = bcommand.createARCancelSplitInvoice(cancelInvoiceVO);
			
			if(!newIfNo.equals("")){
				//SYS CLEAR가 된 대상 IFNO도 ERP전송대상에 추가 2009.12.29
				if(otsSmryCd.equals("INV")){
					maxArIfNoVO = new InvArIfNoVO();
					maxArIfNoVO.setIfNo(event.getIfNo());
					maxIfNos.add(maxArIfNoVO);
				}
				
				invArIfNoVO = new InvArIfNoVO();
				invArIfNoVO.setIfNo(newIfNo);
				ifNos.add(invArIfNoVO);
			}

			if (invArMnVOs != null) {

				for (int i = 0; i < invArMnVOs.length; i++) {

					repCustCnt = command.checkRepCustomer(invArMnVOs[i].getActCustCntCd(), invArMnVOs[i].getActCustSeq());

					if (repCustCnt > 0) {
						eventResponse.setUserMessage(new ErrorHandler("INV00036", new String[] {}).getUserMessage());
						return eventResponse;
					}
					
					//Due Dt 구하는 로직 BC에서 직접 구하는 방식으로 변경 2009-11-30
					/*
					DueDateInputVO dueDateInputVO = new DueDateInputVO();

					dueDateInputVO.setOfcCd(event.getOfcCd());
					dueDateInputVO.setBnd(invArMnVOs[i].getIoBndCd());
					dueDateInputVO.setSaDt(invArMnVOs[i].getSailArrDt());
					dueDateInputVO.setCustCntCd(invArMnVOs[i].getActCustCntCd());
					dueDateInputVO.setCustSeq(invArMnVOs[i].getActCustSeq());

					// due date 검색
					List<DueDateVO> list = command.searchDueDate(dueDateInputVO);
					*/
					ARInvoiceSplitVO invSplitVo = new ARInvoiceSplitVO();
					InvArMnVO invArMnVO = new InvArMnVO();

					invArMnVO.setActCustCntCd(invArMnVOs[i].getActCustCntCd());
					invArMnVO.setActCustSeq(invArMnVOs[i].getActCustSeq());
					/*
					if (list.size() > 0) {
						invArMnVO.setDueDt(list.get(0).getDueDate());
						invArMnVO.setCustCrFlg(list.get(0).getCrFlg());
						invArMnVO.setCrTermDys(list.get(0).getCrTermDys());
					}
					*/

					invArMnVO.setArIfNo(invArMnVOs[i].getArIfNo());
					invArMnVO.setBkgTeuQty(invArMnVOs[i].getBkgTeuQty());
					invArMnVO.setBkgFeuQty(invArMnVOs[i].getBkgFeuQty());
					invArMnVO.setInvRefNo(invArMnVOs[i].getInvRefNo());
					invArMnVO.setHjsStfCtnt(invArMnVOs[i].getHjsStfCtnt());
					invArMnVO.setInvRmk(invArMnVOs[i].getInvRmk());
					invArMnVO.setGlEffDt(arCorrectionCkReturnVO.getEffectiveDt());
					invArMnVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
					invArMnVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
					invSplitVo.setOtsSmryCd(otsSmryCd);
					invSplitVo.setUserId(account.getUsr_id());

					List<InvArChgVO> invArChgVs = new ArrayList<InvArChgVO>();
					if (invArChgVOs != null) {
						for (int j = 0; j < invArChgVOs.length; j++) {
							if (invArChgVOs[j].getArIfNo().equals(invArMnVOs[i].getArIfNo())) {
								invArChgVs.add(invArChgVOs[j]);
							}
						}
					}

					List<InvArAmtVO> invArAmtVs = new ArrayList<InvArAmtVO>();
					if (invArAmtVOs != null) {
						for (int k = 0; k < invArAmtVOs.length; k++) {
							if (invArAmtVOs[k].getArIfNo().equals(invArMnVOs[i].getArIfNo())) {
								invArAmtVs.add(invArAmtVOs[k]);
							}
						}
					}

					List<InvArCntrVO> invArCntrVs = new ArrayList<InvArCntrVO>();
					if (invArCntrVOs != null) {
						for (int l = 0; l < invArCntrVOs.length; l++) {
							if (invArCntrVOs[l].getArIfNo().equals(invArMnVOs[i].getArIfNo())) {
								invArCntrVs.add(invArCntrVOs[l]);
							}
						}
					}
					invSplitVo.setIfNo(event.getIfNo());
					invSplitVo.setInvArMnVO(invArMnVO);
					invSplitVo.setInvArChgVOs(invArChgVs);
					invSplitVo.setInvArAmtVOs(invArAmtVs);
					invSplitVo.setInvArCntrVOs(invArCntrVs);

					// New Data 생성
					newIfNo = bcommand.createSplitInvoice(invSplitVo);
					
					if(!newIfNo.equals("")){
						invArIfNoVO = new InvArIfNoVO();
						invArIfNoVO.setIfNo(newIfNo);
						ifNos.add(invArIfNoVO);
					}
				}
			}
			commit();
			
			begin();
			//Sys Clear 된 대상 IfNo 가 Good Data인 IfNo 모아서 ERP전송
			log.debug("maxIfNos.size() = "+maxIfNos.size());
			if(maxIfNos!= null && maxIfNos.size()>0){
				bcommand.interfaceARInvoiceToERPAR(maxIfNos, "U");
			}
			
			//Good Data인 IfNo 모아서 ERP전송
			log.debug("ifNos.size() = "+ifNos.size());
			if(ifNos!= null && ifNos.size()>0){
				bcommand.interfaceARInvoiceToERPAR(ifNos, "C");
			}
			commit();
			
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;

	}

	/**
	 * FNS_INV_0033 : 조회<br>
	 * Split 하거나 Customer 를 변경하려는 대상 매출채권 정보 또는 Invoice 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSplitARInvoiceByInvoiceNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0033Event event = (FnsInv0033Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		BookingARCreationBC bcommand = new BookingARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			ARInvoiceSplitVO aRInvoiceSplitVO = command.searchSplitARInvoiceByInvoiceNo(event.getInvNo(), event.getSplitCnt(), event.getOfcCd());

			bcommand.modifyNewInterfaceNo(event.getOfcCd(), aRInvoiceSplitVO.getMaxSeq(), account.getUsr_id());
			commit();
			eventResponse.setRsVo(aRInvoiceSplitVO.getARInvoiceCorrectionVO());
			eventResponse.setRsVoList(aRInvoiceSplitVO.getListInvoiceChargeCorrectionVO());
			eventResponse.setRsVoList(aRInvoiceSplitVO.getInvArCntrVOs());
			eventResponse.setRsVoList(aRInvoiceSplitVO.getInvArIfNoVOs());
			eventResponse.setRsVo(aRInvoiceSplitVO.getARInvoiceCustomerVO());

			eventResponse.setETCData("max_seq", aRInvoiceSplitVO.getMaxSeq());

		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00080", new String[] {}).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0033 : 입력,수정 <br>
	 * 대상 매출채권 정보 또는 invoice 정보를 2인 이상의 Customer 로<BR>
	 * Split 하거나 단순히 다른 Customer 로 변경처리한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse splitARInvoiceByInvoiceNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0033Event event = (FnsInv0033Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		BookingARCreationBC bcommand = new BookingARCreationBCImpl();

		InvArMnVO[] invArMnVOs = event.getInvArMnVOs();
		InvArChgVO[] invArChgVOs = event.getInvArChgVOs();
		InvArAmtVO[] invArAmtVOs = event.getInvArAmtVOs();
		InvArCntrVO[] invArCntrVOs = event.getInvArCntrVOs();
		InvArIfNoVO[] invArIfNoVOs = event.getInvArIfNoVOs();
		
		List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO invArIfNoVO = new InvArIfNoVO();	
		String newIfNo="";
		String maxIfNo="";
		String otsSmryCd = "";
		int repCustCnt = 0;

		try {
			begin();

			// A/R Office 기준정보에서 OTS Summary 기준 정보를 구한다.
			// otsSmryCd = command.searchOTSSummary(event.getOfcCd());

			// Invoice Correction 정보를 Save 하기전 validation check 및 Effective date 를 구한다.
			// Good Data변경으로 신규데이터 생성시 적용될 revenue type , revenue source를 결정함.
			
			maxIfNo = invArIfNoVOs[0].getMaxIfNo().equals("")?invArIfNoVOs[0].getMIfNo():invArIfNoVOs[0].getMaxIfNo();
			
			ARCorrectionCkVO aRCorrectionCkVO = new ARCorrectionCkVO();

			aRCorrectionCkVO.setBkgNo(event.getBkgNo());
			aRCorrectionCkVO.setInvCustFlg("");
			aRCorrectionCkVO.setOfcCd(event.getOfcCd());
			aRCorrectionCkVO.setSailingDt(event.getSailDt());
			aRCorrectionCkVO.setBlInvCfmDt(event.getSailDt());

			ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.checkARCorrection(aRCorrectionCkVO);
			
			//ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.searchRevTypeSrc(event.getBkgNo(), "");	
			
			CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();

			cancelInvoiceVO.setIfNo(maxIfNo);
			cancelInvoiceVO.setInvNo(event.getInvNo());
			cancelInvoiceVO.setNewIfNo(event.getCancelIfNo());
			cancelInvoiceVO.setArOfcCd(event.getOfcCd());
			cancelInvoiceVO.setOtsSmryCd("");
			cancelInvoiceVO.setRevTpCd(!invArIfNoVOs[0].getMaxIfNo().equals("")?arCorrectionCkReturnVO.getRevTpCd():"M");
			cancelInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
			cancelInvoiceVO.setUserId(account.getUsr_id());
			cancelInvoiceVO.setUiType("S");
			// Cancel Data 생성
			newIfNo = bcommand.createCancelIssueARInvoice(cancelInvoiceVO);
			
			if(!newIfNo.equals("")){
				invArIfNoVO = new InvArIfNoVO();
				invArIfNoVO.setIfNo(newIfNo);
				ifNos.add(invArIfNoVO);
			}
			
			if (invArIfNoVOs != null) {
				for (int i = 0; i < invArIfNoVOs.length; i++) {

					// Invoice Split Code 를 Update 한다.
					bcommand.modifySplitCode(invArIfNoVOs[i].getIfNo(), "M", otsSmryCd, account.getUsr_id());					
				}
			}

			if (invArMnVOs != null) {

				for (int i = 0; i < invArMnVOs.length; i++) {

					repCustCnt = command.checkRepCustomer(invArMnVOs[i].getActCustCntCd(), invArMnVOs[i].getActCustSeq());

					if (repCustCnt > 0) {
						eventResponse.setUserMessage(new ErrorHandler("INV00036", new String[] {}).getUserMessage());
						return eventResponse;
					}
					
					//Due Dt 구하는 로직 BC에서 직접 구하는 방식으로 변경 2009-11-30
					/*
					DueDateInputVO dueDateInputVO = new DueDateInputVO();

					dueDateInputVO.setOfcCd(event.getOfcCd());
					dueDateInputVO.setBnd(invArMnVOs[i].getIoBndCd());
					dueDateInputVO.setSaDt(invArMnVOs[i].getSailArrDt());
					dueDateInputVO.setCustCntCd(invArMnVOs[i].getActCustCntCd());
					dueDateInputVO.setCustSeq(invArMnVOs[i].getActCustSeq());

					// due date 검색
					List<DueDateVO> list = command.searchDueDate(dueDateInputVO);
					*/
					ARInvoiceSplitVO invSplitVo = new ARInvoiceSplitVO();
					InvArMnVO invArMnVO = new InvArMnVO();

					invArMnVO.setActCustCntCd(invArMnVOs[i].getActCustCntCd());
					invArMnVO.setActCustSeq(invArMnVOs[i].getActCustSeq());
					/*
					if (list.size() > 0) {
						invArMnVO.setDueDt(list.get(0).getDueDate());
						invArMnVO.setCustCrFlg(list.get(0).getCrFlg());
						invArMnVO.setCrTermDys(list.get(0).getCrTermDys());
					}
					*/
					invArMnVO.setArIfNo(invArMnVOs[i].getArIfNo());
					invArMnVO.setBkgTeuQty(invArMnVOs[i].getBkgTeuQty());
					invArMnVO.setBkgFeuQty(invArMnVOs[i].getBkgFeuQty());
					invArMnVO.setInvRefNo(invArMnVOs[i].getInvRefNo());
					invArMnVO.setHjsStfCtnt(invArMnVOs[i].getHjsStfCtnt());
					invArMnVO.setInvRmk(invArMnVOs[i].getInvRmk());
					invArMnVO.setGlEffDt(arCorrectionCkReturnVO.getEffectiveDt());
					invArMnVO.setRevTpCd(!invArIfNoVOs[0].getMaxIfNo().equals("")?arCorrectionCkReturnVO.getRevTpCd():"M");
					invArMnVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
					invSplitVo.setOtsSmryCd(otsSmryCd);
					invSplitVo.setUserId(account.getUsr_id());

					List<InvArChgVO> invArChgVs = new ArrayList<InvArChgVO>();
					if (invArChgVOs != null) {
						for (int j = 0; j < invArChgVOs.length; j++) {
							if (invArChgVOs[j].getArIfNo().equals(invArMnVOs[i].getArIfNo())) {
								invArChgVs.add(invArChgVOs[j]);
							}
						}
					}

					List<InvArAmtVO> invArAmtVs = new ArrayList<InvArAmtVO>();
					if (invArAmtVOs != null) {
						for (int k = 0; k < invArAmtVOs.length; k++) {
							if (invArAmtVOs[k].getArIfNo().equals(invArMnVOs[i].getArIfNo())) {
								invArAmtVs.add(invArAmtVOs[k]);
							}
						}
					}

					List<InvArCntrVO> invArCntrVs = new ArrayList<InvArCntrVO>();
					if (invArCntrVOs != null) {
						for (int l = 0; l < invArCntrVOs.length; l++) {
							if (invArCntrVOs[l].getArIfNo().equals(invArMnVOs[i].getArIfNo())) {
								invArCntrVs.add(invArCntrVOs[l]);
							}
						}
					}
					invSplitVo.setIfNo(event.getIfNo());
					invSplitVo.setInvArMnVO(invArMnVO);
					invSplitVo.setInvArChgVOs(invArChgVs);
					invSplitVo.setInvArAmtVOs(invArAmtVs);
					invSplitVo.setInvArCntrVOs(invArCntrVs);

					// New Data 생성
					newIfNo = bcommand.createSplitInvoice(invSplitVo);
					
					if(!newIfNo.equals("")){
						invArIfNoVO = new InvArIfNoVO();
						invArIfNoVO.setIfNo(newIfNo);
						ifNos.add(invArIfNoVO);
					}
				}
			}
			commit();
			
			begin();
			//Good Data인 IfNo 모아서 ERP전송
			if(ifNos!= null && ifNos.size()>0){
				bcommand.interfaceARInvoiceToERPAR(ifNos, "C");
			}
			commit();
			
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0050 : Open<br>
	 * CPRT에서 user가 사용 가능한 Template을 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTemplateList(Event e) throws EventException {
		// FnsInv0050Event event = (FnsInv0050Event)e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String tmplt = "";
		StringBuffer tmpltBuff = new StringBuffer();
		try {
			List<TemplateVO> list = command.searchTemplateList(account.getUsr_id(), account.getOfc_cd());

			for (int i = 0; i < list.size(); i++) {
				tmpltBuff.append(list.get(i).getRptTmpltNm() + "|");
				//tmplt = tmplt + list.get(i).getRptTmpltNm() + "|";				
			}
			tmplt = tmpltBuff.toString();
			eventResponse.setETCData("tmplt", tmplt);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0050 : TemplateName CHANGE<br>
	 * CPRT에서 Report 생성시 선택한 Template의 item를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTemplateItemList(Event e) throws EventException {
		FnsInv0050Event event = (FnsInv0050Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			event.getCPRTInputVO().setArOfcCd(event.getOfcCd());
			List<TemplateItemVO> list = command.searchTemplateItemList(event.getRptTmpltNm(), event.getCPRTInputVO());
			if (list.size() > 0) {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0050 : bkg no 조회<br>
	 * CPR 에서 bl preview 조회시 bkg_no가 없을 경우, 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlNo(Event e) throws EventException {
		FnsInv0050Event event = (FnsInv0050Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			String bkgNo = command.searchBlNo(event.getBlNo());
			eventResponse.setETCData("bkgNo", bkgNo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0050 : Retrieve<br>
	 * Customer Preferable Report 대상 정보를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCPRTInvoice(Event e) throws EventException {
		FnsInv0050Event event = (FnsInv0050Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			//event.getCPRTInputVO().setArOfcCd(account.getOfc_cd());
			event.getCPRTInputVO().setArOfcCd(event.getOfcCd());
			event.getCPRTInputVO().setRptTmpltNm(event.getRptTmpltNm());
			List<CPRTInvoiceVO> list = command.searchCPRTInvoice(event.getCPRTInputVO(), event.getRptItmId());
			if (list.size() > 0) {
				eventResponse.setRsVoList(list);
			}
//			TemplateVO templateVO = command.searchCPRTInvoice(event.getCPRTInputVO(), event.getRptItmId());
//			log.debug("SC=================================");
//			log.debug(templateVO.getListTemplateItemVO());
//			log.debug("SC==================end============");
////		if (templateVO.size() > 0) {
//				eventResponse.setRsVoList(templateVO.getListTemplateItemVO());
//				eventResponse.setRsVoList(templateVO.getListCPRTInvoiceVO());
////			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0050 : Save<br>
	 * Customer Preferable Report . 조회조건에 해당 하는 데이터를 Save시 Report ID를 생성한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse issueCPRTInvoice(Event e) throws EventException {
		FnsInv0050Event event = (FnsInv0050Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String reportId = "";
		try {
			event.getCPRTInputVO().setCreUsrId(account.getUsr_id());
			event.getCPRTInputVO().setArOfcCd(account.getOfc_cd());
			reportId = command.issueCPRTInvoice(event.getRptTmpltNm(), event.getCPRTInputVO());

			eventResponse.setETCData("reportId", reportId);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * FNS_INV_0052 : Retrieve<br>
	 * Terminal Invoice 의 GIRO 정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKORGIRO(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0052Event event = (FnsInv0052Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			KORGiroListVO korRGiroListVO = command.searchKORGIRO(event.getBlNo(), event.getOfcCd());

			if (korRGiroListVO != null) {
				eventResponse.setRsVo(korRGiroListVO);
				eventResponse.setRsVoList(korRGiroListVO.getInvArGiroVO());
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0052 : Save<br>
	 * 한국지역 GIRO 정보를 생성, 갱신, 삭제한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageKORGIRO(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0052Event event = (FnsInv0052Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();

			KORGiroListVO korGiroListVO = event.getKorGiroListVO();
			List<InvArGiroVO> invArGiroVO = korGiroListVO.getInvArGiroVO();
			for (int i = 0; i < invArGiroVO.size(); i++) {
				invArGiroVO.get(i).setCreUsrId(account.getUsr_id());
				invArGiroVO.get(i).setUpdUsrId(account.getUsr_id());
			}
			log.debug("invArGiroVO.size()  =" + invArGiroVO.size());
			command.manageKORGIRO(invArGiroVO);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0052 : Delete<br>
	 * 한국지역 GIRO 정보를 삭제한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeKORGIRO(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0052Event event = (FnsInv0052Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();

			KORGiroListVO korGiroListVO = event.getKorGiroListVO();
			List<InvArGiroVO> invArGiroVO = korGiroListVO.getInvArGiroVO();
			for (int i = 0; i < invArGiroVO.size(); i++) {
				invArGiroVO.get(i).setUpdUsrId(account.getUsr_id());
			}

			command.removeKORGIRO(invArGiroVO);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0028 : 조회<br>
	 * Invoice Data Manual Interface<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManualInterface(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0028Event event = (FnsInv0028Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		try {
			begin();

			List<BkgNoCaNoVO> bkgNoCaNoVOs = command.searchManualInterface(event.getManualInputVO());

			if (bkgNoCaNoVOs.size() > 0) {
				eventResponse.setRsVoList(bkgNoCaNoVOs);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * FNS_INV_0028 : 입력,수정<br>
	 * Invoice Data Manual Interface<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createManualInterface(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0028Event event = (FnsInv0028Event) e;
		BookingARCreationBC bcommand = new BookingARCreationBCImpl();
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		try {
			
			//String backEndJobKey = "";
	        
			if(event.getManDivInd().equals("M")){
				if(!event.getBkgNo().equals("")){
					begin();
					
					ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();
					bkgIfVO.setBkgNo(event.getBkgNo());
					bkgIfVO.setBkgSeq("");
					bkgIfVO.setManDivInd("M");
					bkgIfVO.setUserId(account.getUsr_id());					
					
					//List<InvArIfNoVO> ifNos = bcommand.executeInterfaceBKGARInvoiceToINV(bkgIfVO);
					bcommand.executeInterfaceBKGARInvoiceToINV(bkgIfVO);
					
					commit();
					/*
					begin();
					if(ifNos!= null && ifNos.size()>0){
						log.error("ifNos.size() = "+ifNos.size());
						
						bcommand.interfaceARInvoiceToERPAR(ifNos, "C");
					}
					commit();
					*/
				}else{
					begin();
					if(!event.getVvd().equals("")){
						List<ARBkgInterfaceCreationVO> aRBkgIfCreationVOs = command.searchBkgNoByVvd(event.getVvd(),event.getPol(),event.getPod());
						if(aRBkgIfCreationVOs != null) {
							for(int i=0; i<aRBkgIfCreationVOs.size(); i++) {
								aRBkgIfCreationVOs.get(i).setManDivInd("M");
								aRBkgIfCreationVOs.get(i).setUserId(account.getUsr_id());
							}
				
							if (aRBkgIfCreationVOs.size() > 0) {
								bcommand.interfaceBKGARInvoiceToINV(aRBkgIfCreationVOs);
							}
						}
						
					}
					commit();
				}
				
			}else if(event.getManDivInd().equals("I")){			
				begin();
				
				BkgNoCaNoVO[] bkgNoCaNoVOs = event.getBkgNoCaNoVOs();
				//List<ARBkgInterfaceCreationVO> bkgIfVOs =  new ArrayList<ARBkgInterfaceCreationVO>();;
				
				//List<InvArIfNoVO> allIfNos = new ArrayList<InvArIfNoVO>();
				
				for (int i = 0; i < bkgNoCaNoVOs.length; i++) {
					ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();
					bkgIfVO.setBkgNo(bkgNoCaNoVOs[i].getBkgNo());
					bkgIfVO.setBkgSeq("");
					//bkgIfVO.setBkgSeq(bkgNoCaNoVOs[i].getBkgSeq());
					//bkgIfVO.setManDivInd("I");
					bkgIfVO.setManDivInd("M");
					bkgIfVO.setUserId(account.getUsr_id());
					//List<InvArIfNoVO> ifNos = bcommand.executeInterfaceBKGARInvoiceToINV(bkgIfVO);
					bcommand.executeInterfaceBKGARInvoiceToINV(bkgIfVO);
					//bkgIfVOs.add(bkgIfVO);
					/*
					if(ifNos!=null && ifNos.size()>0){
						log.error("ifNos.size() = "+ifNos.size());
						allIfNos.addAll(ifNos);
					}
					*/
				}
				
				commit();
				
				/*
				begin();
				if(allIfNos!= null && allIfNos.size()>0){
					log.error("allIfNos.size() = "+allIfNos.size());
					bcommand.interfaceARInvoiceToERPAR(allIfNos, "C");
				}
				
				commit();
				*/
				//bcommand.interfaceBKGARInvoiceToINV(bkgIfVOs);
			}else if(event.getManDivInd().equals("T")){
				
				begin();
				List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
				InvArIfNoVO invArIfNoVO = new InvArIfNoVO();				
				invArIfNoVO.setIfNo(event.getArIfNo());
				ifNos.add(invArIfNoVO);
				
				bcommand.interfaceARInvoiceToERPAR(ifNos, "C");
				
				commit();
			}else if(event.getManDivInd().equals("U")){
				begin();
				List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
				InvArIfNoVO invArIfNoVO = new InvArIfNoVO();				
				invArIfNoVO.setIfNo(event.getArIfNo());
				ifNos.add(invArIfNoVO);
				
				bcommand.interfaceARInvoiceToERPAR(ifNos, "U");
				commit();
			}else{
				begin();
				String newIfNo = bcommand.createMaxIFCancel(event.getArIfNo(), "", account.getUsr_id(), "");
				
				List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
				if(!newIfNo.equals("")){
					InvArIfNoVO invArIfNoVO = new InvArIfNoVO();				
					invArIfNoVO.setIfNo(newIfNo);
					ifNos.add(invArIfNoVO);
				}
				//bcommand.interfaceARInvoiceToERPAR(ifNos, "C");
				commit();
				
			}
			
			//eventResponse.setETCData("BackEndJobKey", backEndJobKey);
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * FNS_INV_0028: 수정 <br> 
	 * Invoice Data Manual Interface BackEndJob의 작업상태를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*
	@SuppressWarnings("unchecked")
	
	private EventResponse createBKGInvoiceBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0028Event event = (FnsInv0028Event) e;

    	try {    		
	    	if(event.getBackEndJobKey() != null && !event.getBackEndJobKey().equals("")) {
    			// Backend job 완료여부를 검사한다.
		    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(event.getBackEndJobKey());

		    	DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
		    	
		    	ComBakEndJbVO jobVo = null;
		    	if (dbRowSetlist.size() == 0) {
		    		// Background job framework가 정상적으로 동작하지 않을 경우 발생하는 오류를 회피하기 위함
		    		jobVo = new ComBakEndJbVO();
		    		jobVo.setJbStsFlg("0");
		    	} else {
		    		jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);	
		    	}
		    	eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
	    	}
    	} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}

    	return eventResponse;
    }
	*/
	/**
	 * FNS_INV_0028: 수정 <br> 
	 * Invoice Data Manual Interface BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
     * 
     * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*
	private EventResponse createBKGInvoiceBackEndJobFile(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0028Event event = (FnsInv0028Event) e;
		BookingARCreationBC command = new BookingARCreationBCImpl();

		try {
			String result = command.getBackEndJobResultCreateBKGInvoice(event.getBackEndJobKey());
			
			eventResponse.setETCData("RESULT", result);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

        return eventResponse;
	}
	*/
	/**
	 * FNS_INV_0079<br>
	 * Unmatched Revenue VVD 대상으로 생성된 B/L의 History(INV_REV_VVD_UMCH) 데이타를 조회한다<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnmatchRevenueVVDListByDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0079Event event = (FnsInv0079Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();

		try {
			List<UnmatchRevenueVesselVO> unmatchRevenueVesselVO = command.searchUnmatchRevenueVVDListByDate(event.getFromDt(), event.getToDt(), event
					.getBkgIfFlg());
			eventResponse.setRsVoList(unmatchRevenueVesselVO);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0079<br>
	 * Booking 과 비교하여 Revenue VVD 정보가 Unmatch 된 B/L 정보들을 생성하기 위한 BatchJob의 ID를 조회한다.<br>
	 * Unmatched Revenue VVD 대상으로 생성된 B/L의 History(INV_REV_VVD_UMCH) 데이타를 저장한다<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createUnmatchRevenueVVDListByDateBatchJobID(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0079Event event = (FnsInv0079Event) e;
		//ScheduleUtil su = new ScheduleUtil();
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		try {
			//begin();
			String fromDt = event.getFromDt().replaceAll("-", "");
			String toDt = event.getToDt().replaceAll("-", "");
			//String param = fromDt + "#" + toDt + "#" + account.getUsr_id();
			//String jobID = su.directExecuteJob("FNS_INV_B002", param);
			command.createUnmatchRevenueVVDListByDate(fromDt,toDt,account.getUsr_id());
			//eventResponse.setETCData("jobID", jobID);
			//commit();
		} catch (EventException ex) {
			//rollback();
			throw ex;
		} catch (Exception ex) {
			//rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0079<br>
	 * Booking 과 비교하여 Revenue VVD 정보가 Unmatch 된 B/L 정보들을 생성하기 위한 BatchJob의 작업상태를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createUnmatchRevenueVVDListByDateBatchJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0079Event event = (FnsInv0079Event)e;
		ScheduleUtil su = new ScheduleUtil();
		int jobStatus = 1;
		
    	try {    		
	    	if(event.getBatchJobID() != null && !event.getBatchJobID().equals("")) {
	    		jobStatus = su.getJobStatus(event.getBatchJobID(), "FNS_INV_B002");
		    	eventResponse.setETCData("jb_sts_flg", String.valueOf(jobStatus));
	    	}
    	} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}

    	return eventResponse;
    }

	/**
	 * FNS_INV_0045 : Retrieve[Msg no미선택했을때]<br>
	 * 입력한 VVD 및 삼성업체명에 대해 기 EDI 정보로 생성된 문서번호를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSamsungEDIMSGNo(Event e) throws EventException {
		FnsInv0045Event event = (FnsInv0045Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();

		try {
			SamsungInvoiceEDIVO samsungInvoiceEDIVO = command.searchSamsungEDIMSGNo(event.getSamsungInPutVO());
			String revisedAmount = event.getSamsungInPutVO().getRevisedAmount();

			if (samsungInvoiceEDIVO != null) {
				List<SamsungMSGVO> list = samsungInvoiceEDIVO.getSamsungMSGList();

				if (list != null && list.size() > 0) {
					String msgNo = "";
					StringBuffer msgNoBuff = new StringBuffer();
					for (int i = 0; i < list.size(); i++) {
						msgNoBuff.append("|" + list.get(i).getMsgNo());
						//msgNo = msgNo + "|" + list.get(i).getMsgNo();
					}
					msgNo = msgNoBuff.toString();
					
					if (revisedAmount.equals("Y")) {
						eventResponse.setETCData(samsungInvoiceEDIVO.getSamsungInvoiceEDIHeader().getColumnValues());
						eventResponse.setRsVoList(samsungInvoiceEDIVO.getSamsungEDIBLChargeList());
					}
					eventResponse.setETCData("msg_no", msgNo);
				} else {
					if (samsungInvoiceEDIVO.getSamsungInvoiceEDIHeader() != null) {
						eventResponse.setETCData(samsungInvoiceEDIVO.getSamsungInvoiceEDIHeader().getColumnValues());
						eventResponse.setRsVoList(samsungInvoiceEDIVO.getSamsungEDIBLChargeList());
					} else {
						eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
					}
				}
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0045 : Retrieve[Msg no선택했을때]<br>
	 * 입력한 VVD 및 삼성업체명에 대해 기 EDI 정보로 생성된 문서번호를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSamsungAREDIList(Event e) throws EventException {
		FnsInv0045Event event = (FnsInv0045Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();
		try {
			SamsungInvoiceEDIVO samsungInvoiceEDIVO = command.searchSamsungAREDIList(event.getMsgId(), event.getMsgNo());

			if (samsungInvoiceEDIVO != null) {
				eventResponse.setETCData(samsungInvoiceEDIVO.getSamsungInvoiceEDIHeader().getColumnValues());
				eventResponse.setRsVoList(samsungInvoiceEDIVO.getSamsungEDIBLChargeList());
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0045 : Save<br>
	 * 삼성전자의 EDI 전송할 Account Receivable 정보를 생성한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createSamsungAREDIList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0045Event event = (FnsInv0045Event) e;
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();

		try {
			begin();
			SamsungInvoiceEDIVO samsungInvoiceEDIVO = event.getSamsungInvoiceEDIVO();
			samsungInvoiceEDIVO.setCreUsrId(account.getUsr_id());
			samsungInvoiceEDIVO.setUpdUsrId(account.getUsr_id());

			String msgNo = command.createSamsungAREDIList(samsungInvoiceEDIVO);

			eventResponse.setETCData("msg_no", msgNo);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0045 : Delete<br>
	 * 삼성전자의 EDI 전송할 Account Receivable 정보를 생성한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeSamsungAREDIList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0045Event event = (FnsInv0045Event) e;
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();

		try {
			begin();
			command.removeSamsungAREDIList(event.getMsgId(), event.getMsgNo(), account.getUsr_id());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0045 : Send<br>
	 * 삼성전자의 Account Receivable 정보를 EDI 로 전송한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendSamsungAREDIList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0045Event event = (FnsInv0045Event) e;
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();

		try {
			begin();
			command.sendSamsungAREDIList(Arrays.asList(event.getSamsungEDISendVOs()), event.getSendStartIdx());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0045 : BLNO@CHANGE<br>
	 * 삼성전자의 EDI 전송할 Account Receivable 정보에 추가로 입력할 내용으로 입력된 BL NO에 대한 정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSamsungEDIByBL(Event e) throws EventException {
		FnsInv0045Event event = (FnsInv0045Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();

		try {
			SamsungEDIBLChargeVO samsungEDIBLChargeVO = command.searchSamsungEDIByBL(event.getSamsungInPutVO(), event.getBlSrcNo());
			if (samsungEDIBLChargeVO != null) {
				eventResponse.setETCData(samsungEDIBLChargeVO.getColumnValues());
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00088").getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * FNS_INV_0065 : Retrieve<br>
	 * 베트남지역 기 발행된 Invoice 정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSWAIssuedInvoiceList(Event e) throws EventException {
		FnsInv0065Event event = (FnsInv0065Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		try {
			List<ARInvoiceListByIFDateVO> invoiceListByIFDateVO = command.searchSWAIssuedInvoiceList(event.getInvoiceIssueDateVO());

			if (invoiceListByIFDateVO != null) {
				eventResponse.setRsVoList(invoiceListByIFDateVO);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0109 : Retrieve <br>
	 * POP_UP 화면에서 Invoice 발행일자 기준으로 조회한다.(Re-Issue 화면에서 사용). <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopSGNBBInvoiceListByIssueDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		FnsInv0109Event event = (FnsInv0109Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<ARInvoiceListByIFDateVO> list = command.searchPopSGNBBInvoiceListByIssueDate(event.getInvoiceIssueDateVO());

			if (list != null && list.size() > 0) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * FNS_INV_0065 : Save Actual INV No.<br>
	 * 베트남 지역에서 실제 사용하는 Actual Invoice Number 를 Invoice 정보에 반영한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createVIEActualInvoiceNumber(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0065Event event = (FnsInv0065Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		try {
			begin();
			
			command.createVIEActualInvoiceNumber(Arrays.asList(event.getVieActInvoiceVOs()));

			// 에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
			eventResponse.setUserMessage(new ErrorHandler("INV00057", new String[] {}).getUserMessage());

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0036<br>
	 * (Single)베트남 지역 매출채권 정보를 Invoice 발행한다.<br>
	 * Single인 경우 B/L No 1개당 Invoice를 발행<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse issueVIESingleInvoice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0036Event event = (FnsInv0036Event) e;
		InvoiceIssueBC invoiceIssueBC = new InvoiceIssueBCImpl();
		BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();
		VIEDailyExrateVO vIEDailyExrateVO = null;
		int invNoCnt = 0;
		String invNoList = "";
		InvEmlVO invEmlSendNoVO = new InvEmlVO();
		try {
			begin();
			event.getGeneralInvoiceVO().setFromDt(event.getGeneralInvoiceVO().getFromDt().replaceAll("-", ""));
			event.getGeneralInvoiceVO().setToDt(event.getGeneralInvoiceVO().getToDt().replaceAll("-", ""));
			event.getGeneralInvoiceVO().setXchRtDt(event.getGeneralInvoiceVO().getXchRtDt().replaceAll("-", ""));
			event.getGeneralInvoiceVO().setXchRt(event.getGeneralInvoiceVO().getXchRt().replaceAll(",", ""));
			event.getGeneralInvoiceVO().setUserId(account.getUsr_id());
			log.error("issueVIESingleInvoice.SC======================>>>>>>>>>>>>start");
			log.error("bl_src_no======================>>>>>>>>>>>>"+event.getGeneralInvoiceVO().getBlNo());
			log.error("bl_src_nos======================>>>>>>>>>>>>"+event.getGeneralInvoiceVO().getBlNos());
			List<VIEInvoiceTargetVO> vIEInvoiceTargetVO = invoiceIssueBC.searchVIEIssueTargetBLNoList(event.getGeneralInvoiceVO());
			
			
			if(!event.getGeneralInvoiceVO().getInvType().equals("DHF")) {
				if(event.getGeneralInvoiceVO().getXchRt().equals("")||event.getGeneralInvoiceVO().getXchRt().equals("0")){
					rollback();
					eventResponse.setUserMessage(new ErrorHandler("INV00098").getUserMessage());
					eventResponse.setETCData("invNoCnt", "-2");
					return eventResponse;
				}
			}
			
			
			if(vIEInvoiceTargetVO.size() == 0) {
				rollback();
				eventResponse.setETCData("invNoCnt", "-1");
				return eventResponse;
			} else {
				for(int i = 0; i < vIEInvoiceTargetVO.size(); i++) {
					event.getGeneralInvoiceVO().setBlNo(vIEInvoiceTargetVO.get(i).getBlNo());
					event.getGeneralInvoiceVO().setArOfcCd(event.getGeneralInvoiceVO().getArOfcCd());
					log.error("======================>>>>>>>>>>>>0");
					List<IssueEachTargetVO> issueEachTargetVO = invoiceIssueBC.issueVIESingleInvoice(event.getGeneralInvoiceVO());
					log.error("======================>>>>>>>>>>>>1");
					String invNo = issueEachTargetVO.get(0).getInvNo();
					log.error("invNo======================>>>>>>>>>>>>"+invNo);
					invNoCnt++;
					if(invNoCnt == 1) {
						invNoList = invNo;
					} else {
						invNoList = invNoList + "|" + invNo;
					}
					log.error("invNoList======================>>>>>>>>>>>>"+invNoList);
					for(int j = 0; j < issueEachTargetVO.size(); j++) {
						invoiceIssueBC.createVIEInvoice(issueEachTargetVO.get(j), account.getUsr_id());
					}
					log.error("======================>>>>>>>>>>>>2");
					vIEDailyExrateVO = new VIEDailyExrateVO();
					vIEDailyExrateVO.setIoBndCd(event.getGeneralInvoiceVO().getIoBndCd());
					// Invoice Type이 DHF는 Daily환율 사용 안함
					if(!event.getGeneralInvoiceVO().getInvType().equals("DHF")) {
						vIEDailyExrateVO.setXchRtDt(event.getGeneralInvoiceVO().getXchRtDt());
						vIEDailyExrateVO.setXchRt(event.getGeneralInvoiceVO().getXchRt());
					} else {
						vIEDailyExrateVO.setXchRtDt("");
						vIEDailyExrateVO.setXchRt("");
					}
					vIEDailyExrateVO.setOfcCd(account.getOfc_cd());
					//invoiceIssueBC.createVIEIssueMain(invNo, "N", vIEDailyExrateVO, account.getUsr_id());          
					invoiceIssueBC.createVIEIssueMain(invNo, "N", vIEDailyExrateVO, account.getUsr_id(),event.getGeneralInvoiceVO().getVnInvPayMzdCd());          
					log.error("======================>>>>>>>>>>>>3");
					bookingARCreationBC.modifyIssueFlag(invNo, "Y", account.getUsr_id());
					log.error("======================>>>>>>>>>>>>4");
					//INV_AR_ISS_SND INSERT
					invEmlSendNoVO.setCustEml("");
					invEmlSendNoVO.setOfcCd(event.getGeneralInvoiceVO().getArOfcCd());
					invEmlSendNoVO.setEmlSndNo("");
					invoiceIssueBC.createSendNo(invNo, "P", invEmlSendNoVO, account.getUsr_id());

					log.error("issueVIESingleInvoice.SC======================>>>>>>>>>>>>end");
				}
			}

			eventResponse.setETCData("invNoCnt", String.valueOf(invNoCnt));
			eventResponse.setETCData("invNoList", invNoList);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

		 

	
	/**
	 * FNS_INV_0036<br>
	 * (Single)베트남 지역 매출채권 정보를 Invoice 발행한다.<br>
	 * Single인 경우 B/L No 1개당 Invoice를 발행<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse issueVIESingleInvoicePreview(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0036Event event = (FnsInv0036Event) e;
		InvoiceIssueBC invoiceIssueBC = new InvoiceIssueBCImpl();
		//BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();
		//VIEDailyExrateVO vIEDailyExrateVO = null;
		//int invNoCnt = 0;
		String blList = "";
		StringBuffer blListBuff = new StringBuffer();
		
		try {
			event.getGeneralInvoiceVO().setFromDt(event.getGeneralInvoiceVO().getFromDt().replaceAll("-", ""));
			event.getGeneralInvoiceVO().setToDt(event.getGeneralInvoiceVO().getToDt().replaceAll("-", ""));
			event.getGeneralInvoiceVO().setXchRtDt(event.getGeneralInvoiceVO().getXchRtDt().replaceAll("-", ""));
			event.getGeneralInvoiceVO().setXchRt(event.getGeneralInvoiceVO().getXchRt().replaceAll(",", ""));
			event.getGeneralInvoiceVO().setUserId(account.getUsr_id());
			
			List<VIEInvoiceTargetVO> vIEInvoiceTargetVO = invoiceIssueBC.searchVIEIssueTargetBLNoList(event.getGeneralInvoiceVO());
			
			String chgCd = invoiceIssueBC.searchVIEIssueTargetCheckCharge(event.getGeneralInvoiceVO());
			
			String blSrcNo = "";
			if(vIEInvoiceTargetVO.size() == 0) {
				eventResponse.setETCData("blList", "-1");
				return eventResponse;
			} else if(!chgCd.equals("")) {
				eventResponse.setETCData("blList", "-2");
				eventResponse.setETCData("chgCd", chgCd);
				return eventResponse;
			} else {
				for(int i = 0; i < vIEInvoiceTargetVO.size(); i++) {
					blSrcNo = vIEInvoiceTargetVO.get(i).getBlNo();
					blListBuff.append("|" + blSrcNo);
					//blList = blList + "|" + blSrcNo;
				}	
				blList = blListBuff.toString();
				eventResponse.setETCData("blList", blList);
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0088<br>
	 * 베트남 지역의 Combine Invoice 발행대상 B/L 및 금액정보를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVIECombineBLNoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0088Event event = (FnsInv0088Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		List<VIECombineInvoiceVO> vIECombineInvoiceVO = null;

		try {
			event.getGeneralInvoiceVO().setFromDt(event.getGeneralInvoiceVO().getFromDt().replaceAll("-", ""));
			event.getGeneralInvoiceVO().setToDt(event.getGeneralInvoiceVO().getToDt().replaceAll("-", ""));
			event.getGeneralInvoiceVO().setXchRtDt(event.getGeneralInvoiceVO().getXchRtDt().replaceAll("-", ""));
			vIECombineInvoiceVO = command.searchVIECombineBLNoList(event.getGeneralInvoiceVO());
			eventResponse.setRsVoList(vIECombineInvoiceVO);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0088<br>
	 * (Combine)베트남 지역 매출채권 정보를 Invoice 발행한다.<br>
	 * Combine인 경우 B/L No를 20개씩 묶어서 Invoice를 발행<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse issueVIECombinedInvoice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0088Event event = (FnsInv0088Event) e;
		InvoiceIssueBC invoiceIssueBC = new InvoiceIssueBCImpl();
		BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();
		VIECombineInvoiceVO vIECombineInvoiceVO = new VIECombineInvoiceVO();
		VIEDailyExrateVO vIEDailyExrateVO = null;
		int invNoCnt = 0;
		int rowCnt = 0;
		String invNo = "";
		String invNoList = "";
		String invoiceType = "";
		InvEmlVO invEmlSendNoVO = new InvEmlVO();
		try {
			begin();
			VIECombineInvoiceVO[] vIECombineInvoiceVOs = event.getVIECombineInvoiceVOS();
			
			if(!vIECombineInvoiceVOs[0].getInvType().equals("DHF")) {
				if(event.getGeneralInvoiceVO().getXchRt().replaceAll(",", "").equals("")||event.getGeneralInvoiceVO().getXchRt().replaceAll(",", "").equals("0")){
					rollback();
					eventResponse.setUserMessage(new ErrorHandler("INV00098").getUserMessage());
					eventResponse.setETCData("invNoCnt", "-2");
					return eventResponse;
				}
			}
			
			if(vIECombineInvoiceVOs == null) {
				rollback();
				eventResponse.setETCData("invNoCnt", "-1");
				return eventResponse;
			} else {
				invoiceType = vIECombineInvoiceVOs[0].getInvType();
				for(int i=0; i<vIECombineInvoiceVOs.length; i++ ) {
					if(vIECombineInvoiceVOs[i].getIbflag().equals("I")) {
						if(rowCnt%20 == 0) {
							invNo = invoiceIssueBC.searchVIEInvoiceNumber(event.getGeneralInvoiceVO().getInvType(), event.getGeneralInvoiceVO().getArOfcCd(), account.getUsr_id());
							if(rowCnt == 0) {
								invNoList = invNo;
							} else {
								invNoList = invNoList + "|" + invNo;
							}
							invNoCnt++;
						}
 
						vIECombineInvoiceVO.setBlNo(vIECombineInvoiceVOs[i].getBlNo());
						vIECombineInvoiceVO.setInvType(invoiceType);
						vIECombineInvoiceVO.setInvNo(invNo);
						vIECombineInvoiceVO.setArOfcCd(event.getGeneralInvoiceVO().getArOfcCd());
						List<IssueEachTargetVO> issueEachTargetVO = invoiceIssueBC.issueVIECombinedInvoice(vIECombineInvoiceVO);
						for(int j = 0; j < issueEachTargetVO.size(); j++) {
							invoiceIssueBC.createVIEInvoice(issueEachTargetVO.get(j), account.getUsr_id());
						}
						
						if(rowCnt%20 == 0) {
							vIEDailyExrateVO = new VIEDailyExrateVO();
							vIEDailyExrateVO.setIoBndCd(event.getGeneralInvoiceVO().getIoBndCd());
							// Invoice Type이 DHF는 Daily환율 사용 안함
							if(!invoiceType.equals("DHF")) {
								vIEDailyExrateVO.setXchRtDt(event.getGeneralInvoiceVO().getXchRtDt().replaceAll("-", ""));
								vIEDailyExrateVO.setXchRt(event.getGeneralInvoiceVO().getXchRt().replaceAll(",", ""));
							} else {
								vIEDailyExrateVO.setXchRtDt("");
								vIEDailyExrateVO.setXchRt("");
							}
							vIEDailyExrateVO.setOfcCd(account.getOfc_cd());
							invoiceIssueBC.createVIEIssueMain(invNo, "Y", vIEDailyExrateVO, account.getUsr_id(),event.getGeneralInvoiceVO().getVnInvPayMzdCd());
						}
						
						bookingARCreationBC.modifyIssueFlag(invNo, "Y", account.getUsr_id());
						
						//INV_AR_ISS_SND INSERT
						invEmlSendNoVO.setCustEml("");
						invEmlSendNoVO.setOfcCd(event.getGeneralInvoiceVO().getArOfcCd());
						invEmlSendNoVO.setEmlSndNo("");
						invoiceIssueBC.createSendNo(invNo, "P", invEmlSendNoVO, account.getUsr_id());
						
						rowCnt++;
					}
				}
			}
			
			eventResponse.setETCData("invNoCnt", String.valueOf(invNoCnt));
			eventResponse.setETCData("invNoList", invNoList);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0034_01 : Paper Issue, Go to Send <br>
	 * 구주지역, 서남아 일부지역, 북중국지역의 Invoice 를 발행함.(BackEndJob) <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse issueGeneralInvoiceBackEndJobKey(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv003401Event event = (FnsInv003401Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
//		BookingARCreationBC command2 = new BookingARCreationBCImpl();
//		List<IssueTargetVO> list2 = new ArrayList<IssueTargetVO>();

		try {
//			begin();
//
//			// Issue 대상을 조회한다
//			List<IssueTargetVO> list = command.searchTargetBLForIssue(event.getGenInvVo());
//
//			if (list.size() < 1) {
//				eventResponse.setUserMessage(new ErrorHandler("INV00095", new String[] {}).getUserMessage());
//			}
//
//			String invNos = "";
//			InvIssueVO invIssueVO = null;
//
//			// 조회된 Issue 대상만큼 Looping 
//			for (int i = 0; i < list.size(); i++) {
//				list2 = command.issueGeneralInvoice(list.get(i), event.getGenInvVo(), account.getUsr_id());
//				invNos = invNos + list2.get(0).getInvNo() + "|";
//
//				// 반환된 업데이트 대상만큼 Looping
//				for (int j = 0; j < list2.size(); j++) {
//
//					invIssueVO = new InvIssueVO();
//					invIssueVO.setInvno(list2.get(j).getInvNo());
//					invIssueVO.setIssflg("Y");
//					invIssueVO.setIfno(list2.get(j).getArIfNo());
//					invIssueVO.setDuedt(list2.get(j).getDueDt());
//					invIssueVO.setBkgno(list2.get(j).getBkgNo());
//					invIssueVO.setInvrmk(list2.get(j).getInvRmk());
//
//					command2.modifyInvoiceIssue(invIssueVO, event.getGenInvVo().getOtsSmryCd(), account.getUsr_id());
//				}
//			}
//			commit();
//
//			eventResponse.setETCData("inv_nos", invNos);
			
			begin();
		        String backEndJobKey = command.issueGeneralInvoiceBackEndJobKey(event.getGenInvVo(), account.getUsr_id());
		        eventResponse.setETCData("BackEndJobKey", backEndJobKey);
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;
	}			
	
	/**
	 * FNS_INV_0034_01<br>
	 * Invoice 를 발행하기 위한 BackEndJob의 작업상태를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse issueGeneralInvoiceBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv003401Event event = (FnsInv003401Event)e;

    	try {    		
	    	if(event.getBackEndJobKey() != null && !event.getBackEndJobKey().equals("")) {
    			// Backend job 완료여부를 검사한다.
		    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(event.getBackEndJobKey());

		    	DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
		    	
		    	ComBakEndJbVO jobVo = null;
		    	if (dbRowSetlist.size() == 0) {
		    		// Background job framework가 정상적으로 동작하지 않을 경우 발생하는 오류를 회피하기 위함
		    		jobVo = new ComBakEndJbVO();
		    		jobVo.setJbStsFlg("0");
		    	} else {
		    		jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);	
		    	}
		    	eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
		    	
		    	// 2012.11.15 ERP누락 데이타 확인을 위한 log 추가 
		    	if ("3".equals(jobVo.getJbStsFlg())) {
		    		log.error("jobVo.getJbStsFlg()=3, BackEndJobKey="+event.getBackEndJobKey());
		    	}
		    	
	    	}
    	} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}

    	return eventResponse;
    }
	
	/**
	 * FNS_INV_0034_01<br>
     * Invoice 를 발행하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
     * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse issueGeneralInvoiceBackEndJobFile(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv003401Event event = (FnsInv003401Event)e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		InvoiceIssueSndToErpVO vo = new InvoiceIssueSndToErpVO();
		
		// 2012.11.15 ERP누락 데이타 확인을 위한 log 추가
		log.error("issueGeneralInvoiceBackEndJobFile  BackEndJobKey ="+event.getBackEndJobKey());
		
		try {
			vo = command.getBackEndJobResutIssueGeneralInvoice(event.getBackEndJobKey());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),	ex);
		}
		String invNos = "";
		StringBuffer invNosBuff = new StringBuffer();

		if (vo != null) {
			
			List<String> list = vo.getInvnos();
			List<String> ifNoNList = vo.getIfnolist();
			
			for (int i = 0; i < list.size(); i++) {
				invNosBuff.append(list.get(i) + "|");
				//invNos = invNos + list.get(i) + "|";
			}
			invNos = invNosBuff.toString();
			
			// 2012.11.15 ERP누락 데이타 확인을 위한 log 추가
			log.error("interfaceARInvoiceToERPAR INV NOs>>>>>"+invNos);
			
			List<String> tmpList = new ArrayList<String>();
			
			try {
				for (int i = 0; i < ifNoNList.size(); i++) {
					tmpList.add(ifNoNList.get(i));
	
					InvoiceIssueSndToErpVO tmpVo = new InvoiceIssueSndToErpVO();
					tmpVo.setIfnolist(tmpList);
					tmpVo.setOfccd(vo.getOfccd());
					tmpVo.setOtssmrycd(vo.getOtssmrycd());
					begin();
					command.interfaceARInvoiceToERPAR(tmpVo);
					tmpList.clear();
					commit();
				}
				eventResponse.setETCData("inv_nos", invNos);
			} catch (EventException ex) {
				rollback();
				log.error("ERP SEND ERROR : "+ex);
				throw ex;
			} catch (Exception ex) {
				rollback();
				log.error("ERP SEND ERROR : "+ex);
				throw new EventException(new ErrorHandler("COM12240").getMessage(),	ex);
			}
		}

        return eventResponse;
	}
	
	/**
	 * FNS_INV_0079<br>
	 * Booking 의 최신 Revenue VVD 정보를 생성한다.<BR>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createNewRevenueVVD(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0079Event event = (FnsInv0079Event) e;
		BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();
		List<ARBkgInterfaceCreationVO> targetList = new ArrayList<ARBkgInterfaceCreationVO>();
		ARBkgInterfaceCreationVO[] aRBkgInterfaceCreationVOs = null;
		//String backEndJobKey = "";
		String bkgNo = "";
		
		try {
			begin();
			aRBkgInterfaceCreationVOs = event.getARBkgInterfaceCreationVOS();
			if(aRBkgInterfaceCreationVOs != null) {
				for(int i=0; i<aRBkgInterfaceCreationVOs.length; i++) {
					if(aRBkgInterfaceCreationVOs[i].getIbflag().equals("U")) {
						if(!bkgNo.equals(aRBkgInterfaceCreationVOs[i].getBkgNo())) {
							bkgNo = aRBkgInterfaceCreationVOs[i].getBkgNo();
							ARBkgInterfaceCreationVO aRBkgInterfaceCreationVO = new ARBkgInterfaceCreationVO();
							aRBkgInterfaceCreationVO.setBkgNo(aRBkgInterfaceCreationVOs[i].getBkgNo());
							aRBkgInterfaceCreationVO.setManDivInd("M");
							aRBkgInterfaceCreationVO.setBkgDiv("U");
							aRBkgInterfaceCreationVO.setUserId(account.getUsr_id());
							targetList.add(aRBkgInterfaceCreationVO);
						}
					}
				}
	
				if (targetList.size() > 0) {
					//backEndJobKey = 
					bookingARCreationBC.interfaceBKGARInvoiceToINV(targetList);
				}
			}
			//eventResponse.setETCData("backEndJobKey", backEndJobKey);			
			commit();
			
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0034_01 : Paper Issue, Go to Send <br>
	 * Invoice 비발행 대상 Data를 조회한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchErrorBLNumberList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv003401Event event = (FnsInv003401Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
        String blNos = "";
        StringBuffer blNosBuff = new StringBuffer();
		try {
			begin();

			// Issue 비발행 대상을 조회한다
			List<String> list = command.searchErrorBLNumberList(event.getGenInvVo());
			for (int i = 0; i < list.size(); i++) {
				blNosBuff.append(list.get(i) + (i == list.size() -1 ? "" : ", "));
				//blNos = blNos + list.get(i) + (i == list.size() -1 ? "" : ", ");
			}
			blNos = blNosBuff.toString();
			commit();

			eventResponse.setETCData("bl_nos", blNos);
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * FNS_INV_0034_01 : Paper Issue, Go to Send <br>
	 * Invoice 기발행된 Data를 조회한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchAlreadyIssuedList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv003401Event event = (FnsInv003401Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
        String blNos = "";
        StringBuffer blNosBuff = new StringBuffer();
        
		try {
			begin();

			// Issue 기발행 bl_no를 조회한다
			HashMap<String, Object> result = command.searchAlreadyIssuedList(event.getGenInvVo());
			
			List<String> list	= (ArrayList)result.get("blNoList");
			String	dupYN		= (String)result.get("dupYN");
			
			int size			= 0;
			
			if(list != null){
				size	= list.size();
			}
			
			for (int i = 0; i < size; i++) {
				blNosBuff.append(list.get(i) + (i == size -1 ? "" : ", "));
				//blNos = blNos + list.get(i) + (i == size -1 ? "" : ", ");
			}
			blNos = blNosBuff.toString();
			commit();

			eventResponse.setETCData("bl_nos", blNos);
			eventResponse.setETCData("dupYN", dupYN);
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;
	}
	

	
	/**
	 * FNS_INV_0036<br>
	 * 1.베트남 Invoic 발행시 입력받은 환율기준일자의 USD: LCL 환율을 구한다. <br>
	 * 2.Office 정보를 가져온다.<br>
	 * 3.프린트 정보를 가져온다.<br>
	 * 4.Local Time을 가져온다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVIEDailyExRate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0036Event event = (FnsInv0036Event) e;
		InvoiceIssueBC invoiceIssueBC = new InvoiceIssueBCImpl();
		INVCommonUtil iNVCommonUtil = new INVCommonUtil();
		VIEDailyExrateReturnVO vIEDailyExrateReturnVO = null;

		try {
			
			String effDt = "";
			String arOfcCd = "";
			if(event.getEventType().equals("open")) {
				List<String> list = iNVCommonUtil.searchAROfficeList(account.getOfc_cd(), event.getPageType());
				
				// Office 정보를 가져온다.
				String arOfcInfo = "";		
				StringBuffer arOfcInfoBuff = new StringBuffer();
				if (list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						arOfcInfoBuff.append("|" + list.get(i));
						//arOfcInfo = arOfcInfo + "|" + list.get(i);
					}
					arOfcInfo = arOfcInfoBuff.toString();
					eventResponse.setETCData("ar_ofc_cd", arOfcInfo);
				} else {
					eventResponse.setUserMessage(new ErrorHandler("INV00075").getUserMessage());
				}
				
				// 프린터 정보를 가져온다.
				String invPrnDvcNm = iNVCommonUtil.searchARPrinterName(account.getOfc_cd(), account.getUsr_id());
				eventResponse.setETCData("inv_prn_dvc_nm", invPrnDvcNm);
			}
			// Local Time을 가져온다.
			arOfcCd = event.getVIEDailyExrateVO().getArOfcCd();
			if(arOfcCd.equals("")){
				arOfcCd = account.getOfc_cd();
			}
			effDt = iNVCommonUtil.searchLocalTime(arOfcCd);
			eventResponse.setETCData("lcl_time", effDt);			
			
			// 환율일자를 가져온다.
			event.getVIEDailyExrateVO().setXchRtDt(event.getVIEDailyExrateVO().getXchRtDt().replace("-", ""));
			if(event.getEventOfc().equals("ofc")){
				event.getVIEDailyExrateVO().setXchRtDt(effDt.replace("-", ""));
			}
			if(event.getVIEDailyExrateVO().getXchRtDt().equals("")){
				event.getVIEDailyExrateVO().setXchRtDt(effDt.replace("-", ""));
			}
			if(event.getVIEDailyExrateVO().getArOfcCd().trim().equals("")){
				event.getVIEDailyExrateVO().setArOfcCd(account.getOfc_cd());
			}
			vIEDailyExrateReturnVO = invoiceIssueBC.searchVIEDailyExrate(event.getVIEDailyExrateVO());
			if(vIEDailyExrateReturnVO == null) {
				eventResponse.setETCData("xchRt", "0");
			} else {
				eventResponse.setETCData("xchRt", vIEDailyExrateReturnVO.getXchRt());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0083 : <br>
	 * Other Interface Add Main <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse otherIFAddMain(Event e) throws EventException {
		FnsInv0083Event event = (FnsInv0083Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralARInvoiceCreationBC command = new GeneralARInvoiceCreationBCImpl();	
		String arIfNos = "";
		
		List<com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO> genIfVOs = new ArrayList<com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO>();
		com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO genIfVO = new com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO();
		InvArIfMnVO invArIfMnVO = null;
		List<InvArIfChgVO> invArIfChgVOs = null;
		List<InvArIfCntrVO> invArIfCntrVOs = null;
		
		try {
			
			begin();
			
			    invArIfMnVO = command.searchInvArIfMain(event.getSrcIfDt(), event.getSrcIfSeq());
			    invArIfChgVOs = command.searchInvArIfChg(event.getSrcIfDt(), event.getSrcIfSeq());
			    invArIfCntrVOs = command.searchInvArIfCntr(event.getSrcIfDt(), event.getSrcIfSeq());
			
				genIfVO.setInvArIfMnVO(invArIfMnVO);
				genIfVO.setInvArIfChgVOs(invArIfChgVOs);
				genIfVO.setInvArIfCntrVOs(invArIfCntrVOs);				
				genIfVOs.add(genIfVO);
				/*
				command.removeArIfMain(invArIfMnVO.getArIfNo());
				command.removeArIfAmt(invArIfMnVO.getArIfNo());
				command.removeArIfChg(invArIfMnVO.getArIfNo());
				command.removeArIfCntr(invArIfMnVO.getArIfNo());	
				*/
				
				if(invArIfMnVO.getArIfNo()!=null&&invArIfMnVO.getArIfNo().equals("")){
					arIfNos = command.interfaceGeneralARInvoiceToINV(genIfVOs);
				}
				log.info("\n########## arIfNos : " + arIfNos);
				eventResponse.setETCData("ar_if_no", arIfNos);
				
			commit();
		
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0039 : Print, FAX Send, E-mail Send<br>
	 * 한국지역 Invoice 를 발행한다.
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse printKORInvoice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0039Event event = (FnsInv0039Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();

		KORInvoiceVO korInvoiceVO = null;
		int sendNum = 0;
		String sendNo = "";
		try {
			begin();

			KORInvoiceVO korInvVo = event.getKORInvoiceVO();
			korInvVo.setCreUsrId(account.getUsr_id());
			korInvVo.setUpdUsrId(account.getUsr_id());
			log.error("printKORInvoice=======================>>>>>>>>>>>>>>>START");
			korInvoiceVO = command.printKORInvoice(korInvVo);

			commit();
			
			if (korInvVo.getSendFlg().equals("E") || korInvVo.getSendFlg().equals("F")) {
				begin();
	
				sendNo = command.sendKORInvoiceByFaxEmail(korInvoiceVO, account);
				
				if (sendNo != null && !sendNo.equals("")) {
					sendNum = 1;
				}
	
				commit();
			}
			log.error("printKORInvoice=======================>>>>>>>>>>>>>>>START");
			eventResponse.setETCData("inv_no", korInvoiceVO.getInvNo());
			eventResponse.setETCData("snd_num", String.valueOf(sendNum));
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * AR Office 조회 이벤트 처리<br>
	 * User ID 소속의 A/R Office 관련 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAROffice(Event e) throws EventException {
		FnsInv0009Event event = (FnsInv0009Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			AROfficeListVO arOfficeListVO = command.searchAROffice(event.getARInvoiceInputByBLNoVO().getLoginOfcCd());

			String arOfcInfo = "";
			if (arOfficeListVO != null) {
				arOfcInfo = arOfficeListVO.getArOfcCd() + "^" + arOfficeListVO.getInvDupFlg();
				eventResponse.setETCData("ar_ofc_cd", arOfcInfo);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00075").getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * a/r office 정보와 printer name 조회 이벤트 처리<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAROfficePrinterName (Event e) throws EventException {

		INVCommonUtil command = new INVCommonUtil();
		List<String> ofcList = null;
		String printName = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("FnsInv0039Event")) {
				FnsInv0039Event event = (FnsInv0039Event) e;
				ofcList = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			} else if (e.getEventName().equalsIgnoreCase("FnsInv0052Event")) {
				FnsInv0052Event event = (FnsInv0052Event) e;
				ofcList = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			} else if (e.getEventName().equalsIgnoreCase("FnsInv0038Event")) {
				FnsInv0038Event event = (FnsInv0038Event) e;
				ofcList = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			} else if (e.getEventName().equalsIgnoreCase("FnsInv0096Event")) {
				FnsInv0096Event event = (FnsInv0096Event) e;
				ofcList = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			}

			printName = command.searchARPrinterName(account.getOfc_cd(), account.getUsr_id());

			String arOfcInfo = "";
			StringBuffer arOfcInfoBuff = new StringBuffer();
			
			if(ofcList != null){
				for (int i = 0; i < ofcList.size(); i++) {
					arOfcInfoBuff.append("|" + ofcList.get(i));
					//arOfcInfo = arOfcInfo + "|" + ofcList.get(i);
				}
			}
			arOfcInfo = arOfcInfoBuff.toString();

			eventResponse.setETCData("ar_ofc_cd", arOfcInfo);
			eventResponse.setETCData("inv_prn_dvc_nm", printName);
			
			if (e.getEventName().equalsIgnoreCase("FnsInv0039Event")) {
				//chg_cd
				List<MdmChargeVO> chgCodeList = null;
				chgCodeList = command.searchChargeCodeList();
				String chgCodeInfo = "";
				for (int i = 0; i < chgCodeList.size(); i++) {
					if (!chgCodeList.get(i).getChgCd().trim().equals("")) {
						chgCodeInfo = chgCodeInfo + "|" + chgCodeList.get(i).getChgCd();
					}
				}
				
				//curr_cd
				List<MdmCurrencyVO> currList = command.searchCurrencyCodeList();
				String currInfo = "";
				StringBuffer currInfoBuff = new StringBuffer();
				for (int i = 0; i < currList.size(); i++) {
					currInfoBuff.append("|" + currList.get(i).getCurrCd());
					//currInfo = currInfo + "|" + currList.get(i).getCurrCd();
				}
				currInfo = currInfoBuff.toString();
				
				List<PriRatUtVO> perList = command.searchPerTpCdList();
				String perInfo = "";
				StringBuffer perInfoBuff = new StringBuffer();
				for (int i = 0; i < perList.size(); i++) {
					perInfoBuff.append("|" + perList.get(i).getRatUtCd());
					//perInfo = perInfo + "|" + perList.get(i).getRatUtCd();
				}	
				perInfo = perInfoBuff.toString();
				
				eventResponse.setETCData("chg_cd", chgCodeInfo);
				eventResponse.setETCData("perInfo", perInfo);
				eventResponse.setETCData("currInfo", currInfo);
								
			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0110<br>
	 * Issue 대상 (DXBBB)INV B/L을 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDXBInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0110Event event = (FnsInv0110Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();

		try {
			List<DXBInvoiceListVO> list = command.searchDXBInvoiceList(event.getGeneralInvoiceVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * a/r office 정보와 local time 조회 이벤트 처리<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeLocalTime (Event e) throws EventException {

		INVCommonUtil command = new INVCommonUtil();
		List<String> ofcList = null;
		String localTime = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("FnsInv0062Event")) {
				FnsInv0062Event event = (FnsInv0062Event) e;
				ofcList = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			}

			localTime = command.searchLocalTime(account.getOfc_cd());

			String arOfcInfo = "";
			StringBuffer arOfcInfoBuff = new StringBuffer();
			
			if (ofcList != null && ofcList.size()>0) {
				for (int i = 0; i < ofcList.size(); i++) {
					arOfcInfoBuff.append("|" + ofcList.get(i));
					//arOfcInfo = arOfcInfo + "|" + ofcList.get(i);
				}
			}
			
			arOfcInfo = arOfcInfoBuff.toString();

			eventResponse.setETCData("ar_ofc_cd", arOfcInfo);
			eventResponse.setETCData("local_time", localTime);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0111<br>
	 * HP EDI 전송대상 데이터를 조회한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchHPInvoiceEDIList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0111Event event = (FnsInv0111Event) e;
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();

		try {
			List<HPInvoiceEDIVO> list = command.searchHPInvoiceEDIList(event.getHpInputVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0111 : Send<br>
	 * HP EDI 정보를 전송한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendHPEDIList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0111Event event = (FnsInv0111Event) e;
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();

		try {
			begin();
			command.sendHPEDIList(Arrays.asList(event.getHpInvoiceEDIVOs()), account.getUsr_id());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * UBIZHJS_ALPSINV_INVOIC : Receive <br>
	 * Glovis Data를 e-SVC센터로 부터 MQ를 통해 INTERFACE 받아서 데이터를 저장한다 <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private void receiveEdiFromGlovis(Event e) throws EventException {
		AccountReceivableEDIReceiveBC command = new AccountReceivableEDIReceiveBCImpl();
		try {
			
			begin();
			UbizhjsAlpsinvGlovisEvent event = (UbizhjsAlpsinvGlovisEvent) e;
			command.receiveEdiFromGlovis(event.getFlatFile(), "", event.getIntegrationId());
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0113<br>
	 * Glovis EDI 전송대상 데이터를 조회한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchEdiGlovisList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0113Event event = (FnsInv0113Event) e;
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();

		try {
			List<GlovisInvoiceEdiVO> list = command.searchEdiGlovisList(event.getGlovisInputVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * FNS_INV_0113 <br>
	 * Glovis EDI를 전송한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendEdiGlovisList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0113Event event = (FnsInv0113Event) e;
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();

		try {
			begin();
			command.sendEdiGlovisList(Arrays.asList(event.getGlovisInvoiceEdiVOs()), account.getUsr_id(),event.getBtnflag());
			eventResponse.setUserMessage("OK");
			commit();
		} catch (EventException ex) {
			rollback();
			eventResponse.setUserMessage("FAIL");
			throw ex;
		} catch (Exception ex) {
			rollback();
			eventResponse.setUserMessage("FAIL");
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	/**
	 * FNS_INV_0112<br>
	 * NIKE EDI 전송대상 데이터를 조회한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchEdiNikeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0112Event event = (FnsInv0112Event) e;
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();

		try {
			List<NikeInvoiceEdiVO> list = command.searchEdiNikeList(event.getNikeInputVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0112 : Send<br>
	 * NIKE EDI 정보를 전송한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendEdiNikeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0112Event event = (FnsInv0112Event) e;
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();

		try {
			begin();
			command.sendEdiNikeList(Arrays.asList(event.getNikeInvoiceEdiVOs()), account.getUsr_id());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0115 : Open<br>
	 * USER ID 소속 A/R HEAD QUARTER OFFICE CODE를 조회한다.<br>
	 * @author KIM HYUN HWA
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARRhqList(Event e) throws EventException {
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<String> list = command.searchARRhqList(account.getOfc_cd());
			String arHdQtrOfcInfo = "";
			StringBuffer arHdQtrOfcInfoBuff = new StringBuffer();
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					arHdQtrOfcInfoBuff.append("|" + list.get(i));
					//arHdQtrOfcInfo = arHdQtrOfcInfo + "|" + list.get(i);
				}
				arHdQtrOfcInfo = arHdQtrOfcInfoBuff.toString();
				eventResponse.setETCData("ar_hd_qtr_ofc_cd", arHdQtrOfcInfo);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00075").getUserMessage());
			}
			return eventResponse;
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0115 : Open<br>
	 * A/R HEAD QUARTER OFFICE 소속 A/R OFFICE CODE를 조회한다.<br>
	 * @author KIM HYUN HWA
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAROfficeListByRhq(Event e) throws EventException {
		FnsInv0115Event event = (FnsInv0115Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			String rhq = event.getErpErrorInputVO().getArHdQtrOfcCd();
			List<String> list = command.searchAROfficeListByRhq(rhq, account.getOfc_cd());
			String arOfcInfo = "";
			StringBuffer arOfcInfoBuff = new StringBuffer();
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					arOfcInfoBuff.append("|" + list.get(i));
					//arOfcInfo = arOfcInfo + "|" + list.get(i);
				}
				arOfcInfo = arOfcInfoBuff.toString();
				eventResponse.setETCData("ar_ofc_cd", arOfcInfo);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00075").getUserMessage());
			}
			return eventResponse;
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0115 : Retrieve<br>
	 * ERP I/F ERROR 내역을 조회한다.<br>
	 * 
	 * @author KIM HYUN HWA
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchErpErrorList(Event e) throws EventException {
		FnsInv0115Event event = (FnsInv0115Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<ErpErrorVO> list = command.searchErpErrorList(event.getErpErrorInputVO());
			if (list.size() > 0) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	
	
	/**
	 * FNS_INV_0116 : Retrieve<br>
	 * AR Invoice에서 ERP로 I/F한  Transaction을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransactionDataComparisonReportList(Event e) throws EventException {
		FnsInv0116Event event = (FnsInv0116Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<TransDataComparisonReportVO> list = command.searchTransactionDataComparisonReportList(event.getTransDataComparisonReportInputVO());
			if (list.size() > 0) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	
	
	/**
	 * UBIZHJS_ALPSINV_INVOIC : Receive <br>
	 * EDI데이터를 e-SVC센터로 부터 MQ를 통해 INTERFACE 받아서 데이터를 저장한다 <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private void receiveCommonEdi(Event e) throws EventException {
		AccountReceivableEDIReceiveBC command = new AccountReceivableEDIReceiveBCImpl();
		try {
			
			begin();
			UbizhjsAlpsinvCommonEvent event = (UbizhjsAlpsinvCommonEvent) e;
			command.receiveCommonEdi(event.getFlatFile(), "", event.getIntegrationId());
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0119 : 조회<br>
	 * 국가별 VAT 요율 List를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse searchVatRatioEntryList(Event e) throws EventException {
		
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<InvArEuCntVatVO> list = command.searchVatRatioEntryList();
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0119 : Save<br>
	 * 국가별 VAT 요율 생성, 갱신, 삭제한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVatRatioEntry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0119Event event = (FnsInv0119Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			command.manageVatRatioEntry(event.getInvArEuCntVatVOs(), account.getUsr_id());
			commit();
			
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0119 : 조회<br>
	 * Euro 국가 List를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEuroCountryList(Event e) throws EventException {
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<String> list = command.searchEuroCountryList();

			String cntCd = "";
			StringBuffer cntCdBuff = new StringBuffer();
			
			for (int i = 0; i < list.size(); i++) {
				cntCdBuff.append("|" + list.get(i));
				//cntCd = cntCd + "|" + list.get(i);
			}
			cntCd = cntCdBuff.toString();
			eventResponse.setETCData("cnt_cd", cntCd);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0120 : 조회<br>
	 * AR에서 발생된 "Reverse Charge" Data 산출기능<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse searchReportForReverseChargeList(Event e) throws EventException {
		FnsInv0120Event event = (FnsInv0120Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<ReportForReverseChargeVO> list = command.searchReportForReverseChargeList(event.getArOfcCd(), event.getFmDt(), event.getToDt());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0122 : 조회<br>
	 * I/F No 에 의거 “Reverse Charge” Mark 를 수정할 수 있는 기능<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse searchMarkingReverseChargeByIfNo(Event e) throws EventException {
		FnsInv0122Event event = (FnsInv0122Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<MarkingReverseChargeVO> list = command.searchMarkingReverseChargeByIfNo(event.getBlSrcNo(), event.getArOfcCd());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0122 : 저장<br>
	 * I/F No 에 의거 “Reverse Charge” Mark 를 수정<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMarkingReverseChargeByIfNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0122Event event = (FnsInv0122Event) e;
		BookingARCreationBC command = new BookingARCreationBCImpl();

		try {
			begin();
			command.modifyMarkingReverseChargeByIfNo(Arrays.asList(event.getMarkingReverseChargeVOs()), account.getUsr_id());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0036<br>
	 * 1.베트남 Invoic 발행시 입력받은 BL넘버의 VAT유무를 체크한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVIEVATCharge (Event e) throws EventException {
	
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0036Event event = (FnsInv0036Event) e;
		InvoiceIssueBC invoiceIssueBC = new InvoiceIssueBCImpl();

		String inv_no = (String)event.getEventParams().get("inv_no_list");
		List<String> list = new ArrayList<String>();
		String vatexist = "";
		String vatexist2 = "";
		String chg_cd = "";
		String chgCd = "";
		String inv_type = "";
		try {
			boolean vat_exist = true;
			StringBuffer sb = new StringBuffer();

			if (inv_no != null && !inv_no.equals("")){
				String invList[] = inv_no.replace("[", "").split("]");
				inv_type = event.getGeneralInvoiceVO().getInvType();
				
				for (int i = 0; i < invList.length; i++) {
					if (invList[i] != null && !invList[i].equals("")) {
						event.getGeneralInvoiceVO().setBlNo(invList[i]);
						event.getGeneralInvoiceVO().setArOfcCd(event.getGeneralInvoiceVO().getArOfcCd());
						list = invoiceIssueBC.searchVIEVATCharge(event.getGeneralInvoiceVO());
						vatexist = list.get(0);
						chgCd = list.get(1);
						vatexist2 = "";
						if(inv_type.equals("ETC") && !vatexist.equals("Y")){
							if(list.size() > 3){
								vatexist2 = list.get(3);
								if(vatexist2.equals("N")){
									chg_cd = "VETTVA";
								}
							}else{
								if(chgCd.equals("VET")){
									if(chg_cd.equals("TVA")){
										chg_cd = "VETTVA";
									}else if(chg_cd.equals("")){
										chg_cd = "VET";
									}
								}else if(chgCd.equals("TVA")){
									if(chg_cd.equals("VET")){
										chg_cd = "VETTVA";
									}else if(chg_cd.equals("")){
										chg_cd = "TVA";
									}								
								}
							}
						}
						if (!vatexist.equals("Y") && !vatexist.equals("Y")) {
							vat_exist = false;
							sb.append("(");
							sb.append(invList[i]);
							sb.append(")");
						}
					}
				}
				
				if (vat_exist) {
					eventResponse.setETCData("vatExist", "vat_exist");
					eventResponse.setETCData("chg_cd", chg_cd);
				} else {
					String blString = sb.toString().replace(")(",",");
					eventResponse.setETCData("vatExist", "-1");
					eventResponse.setETCData("vatNoExistBlNo", blString);
					eventResponse.setETCData("chg_cd", chg_cd);
				}
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * UBIZHJS_ALPSINV_INVOIC : Receive <br>
	 * 구주 E-mail Server Data를 e-SVC센터로 부터 MQ를 통해 INTERFACE 받아서 데이터를 저장한다 <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private void receiveEdiFromEurEmailServer (Event e) throws EventException {
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		try {
			
			begin();
			UbizhjsAlpsinvCommonEvent event = (UbizhjsAlpsinvCommonEvent) e;
			command.receiveEdiFromEurEmailServer(event.getFlatFile(), "EUR_EMAIL_ACK", event.getIntegrationId());
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve DHL EDI list.
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEdiDHLList(Event e) throws EventException {
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();
		FnsInv0124Event event = (FnsInv0124Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<DHLInvoiceEdiVO> list = command.searchEdiDHLList(event.getDhlInputVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * Add DHL EDI.
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse addEdiDHL(Event e) throws EventException {
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();
		FnsInv0124Event event = (FnsInv0124Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			command.sendEdiDHL(event.getDhlInvoiceEdiVOs());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * Retrieve Honey Well list.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchEdiHNWLList(Event e) throws EventException {
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();
		FnsInv0125Event event = (FnsInv0125Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<HNWLInvoiceEdiVO> list = command.searchEdiHNWLList(event.getInputVo());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * Add Honey Well EDI.
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse addEdiHNWL(Event e) throws EventException {
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();
		FnsInv0125Event event = (FnsInv0125Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			log.debug("==>" + event.getInputVo().getActCustCntCd());
			command.sendEdiHNWL(event.getInvoiceEdiVos(), event.getInputVo());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}
	
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchEmlCustRgst(Event e) throws EventException {
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		FnsInv0129Event event = (FnsInv0129Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<InvArEmlCustRgstVO> list = command.searchEmlCustRgst(event.getInvArEmlCustRgstVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException((new ErrorHandler("COM12240")).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse manageEmlCustRgst(Event e) throws EventException {
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		FnsInv0129Event event = (FnsInv0129Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<InvArEmlCustRgstVO> list = new ArrayList<InvArEmlCustRgstVO>();
			InvArEmlCustRgstVO vos[] = event.getInvArEmlCustRgstVOs();
			String arOfcCd = event.getArOfcCd();
			if (vos != null && vos.length > 0) {
				for (int i = 0; i < vos.length; i++) {
					InvArEmlCustRgstVO vo = vos[i];
					vo.setCreUsrId(account.getUsr_id());
					vo.setUpdUsrId(account.getUsr_id());
					vo.setArOfcCd(arOfcCd);
					list.add(vo);
				}

			}
			if (list.size() > 0)
				command.manageEmlCustRgst(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(
					(new ErrorHandler("COM12240")).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOfcOpt(Event e) throws EventException {
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		FnsInv0129Event event = (FnsInv0129Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			String arOfcCd = event.getArOfcCd();
			String ofcOpt = command.searchOfcOpt(arOfcCd);
			eventResponse.setETCData("ofc_opt", ofcOpt);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(
					(new ErrorHandler("COM12240")).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSplitARInvoiceByBL(Event e)
			throws EventException {
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		FnsInv0130Event event = (FnsInv0130Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			String blSrcNo = event.getBlSrcNo();
			String bkgNo = event.getBkgNo();
			ARInvoiceSplitVO aRInvoiceSplitVO = command
					.searchSplitARInvoiceByBL(blSrcNo, bkgNo,
							event.getSplitCnt(), event.getOfcCd());
			commit();
			eventResponse.setRsVo(aRInvoiceSplitVO.getARInvoiceCorrectionVO());
			eventResponse.setRsVoList(aRInvoiceSplitVO
					.getListInvoiceChargeCorrectionVO());
			eventResponse.setRsVoList(aRInvoiceSplitVO.getInvArCntrVOs());
			eventResponse.setRsVo(aRInvoiceSplitVO.getARInvoiceCustomerVO());
			eventResponse.setETCData("chg_size", Integer
					.toString(aRInvoiceSplitVO
							.getListInvoiceChargeCorrectionVO().size()));
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(
					(new ErrorHandler("COM12240")).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse splitARInvoiceByBL(Event e) throws EventException {
		FnsInv0130Event event = (FnsInv0130Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		InvArSplitIssVO invArSplitIssVOs[] = event.getInvArSplitIssVOs();
		InvArSplitIssChgVO invArSplitIssChgVOs[] = event.getInvArSplitIssChgVOs();
		String ifNo = event.getIfNo();
		String invNos = "'";
		String dueDt = event.getDueDt();
		String saDt = event.getSaDt();
		
		try {
			begin();
			if (invArSplitIssVOs != null) {
				InvArSplitIssVO invArSplitIssVOForGetMaxWorkNo = new InvArSplitIssVO();
				invArSplitIssVOForGetMaxWorkNo.setArOfcCd(event.getOfcCd());
				invArSplitIssVOForGetMaxWorkNo.setBkgNo(event.getBkgNo());
				invArSplitIssVOForGetMaxWorkNo.setBlSrcNo(event.getBlSrcNo());
				String invSplitIssWrkNo = command.searchMaxSplitInvWorkNumber(invArSplitIssVOForGetMaxWorkNo);
				for (int i = 0; i < invArSplitIssVOs.length; i++) {
					InvArSplitIssVO invArSplitIssVO = new InvArSplitIssVO();
					invArSplitIssVO.setActCustCntCd(invArSplitIssVOs[i].getActCustCntCd());
					invArSplitIssVO.setActCustSeq(invArSplitIssVOs[i].getActCustSeq());
					invArSplitIssVO.setArIfNo(invArSplitIssVOs[i].getArIfNo());
					invArSplitIssVO.setInvRefNo(invArSplitIssVOs[i].getInvRefNo());
					invArSplitIssVO.setHjsStfCtnt(invArSplitIssVOs[i].getHjsStfCtnt());
					invArSplitIssVO.setInvRmk(invArSplitIssVOs[i].getInvRmk());
					invArSplitIssVO.setBankAcctPrnOptCd(invArSplitIssVOs[i].getBankAcctPrnOptCd());
					invArSplitIssVO.setBkgNo(event.getBkgNo());
					invArSplitIssVO.setBlSrcNo(event.getBlSrcNo());
					invArSplitIssVO.setArIfNo(ifNo);
					invArSplitIssVO.setDueDt(dueDt);
					invArSplitIssVO.setSailArrDt(saDt);
					invArSplitIssVO.setInvSplitIssWrkNo(invSplitIssWrkNo);					
					List<InvArSplitIssChgVO> invArSplitIssChgVO = new ArrayList<InvArSplitIssChgVO>();
					
					if (invArSplitIssChgVOs != null) {
						for (int j = 0; j < invArSplitIssChgVOs.length; j++)
							if (invArSplitIssChgVOs[j].getArIfNo().equals(
									invArSplitIssVOs[i].getArIfNo()))
								invArSplitIssChgVO.add(invArSplitIssChgVOs[j]);

					}
					invNos = (new StringBuilder(String.valueOf(invNos)))
							.append(command.splitARInvoiceByBL(invArSplitIssVO,
									invArSplitIssChgVO, event.getOfcCd(),
									account.getUsr_id(), account.getOfc_cd())).toString();
					if (i != invArSplitIssVOs.length - 1)
						invNos = (new StringBuilder(String.valueOf(invNos)))
								.append("','").toString();
					else
						invNos = (new StringBuilder(String.valueOf(invNos)))
								.append("'").toString();
				}
				
				// 2018.05.16 인도지역 Split Invoice Issue 기능 보완
				if(("BOMSC").equals(event.getOfcCd())){		
					command.modifyIDASplitFlg(event.getOfcCd(), event.getBlSrcNo());
				}

			}
			eventResponse.setETCData("inv_nos", invNos);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(
					(new ErrorHandler("COM12240")).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * FNS_INV_0131 : Retrieve<br>
	 * Invoice 발행 정보를 Invoice No 별로 조회한다. <br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOtherSplitInvoicesForBL(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0131Event event = (FnsInv0131Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		List<ARInvoiceChargeByBLNoVO> list = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			list = command.searchOtherSplitInvoicesForBL(event.getBlNo(), event.getOfc());
			
			if (list != null && list.size()>0) {
				
				eventResponse.setRsVoList(list);
				eventResponse.setETCData("dp_prcs_knt", list.get(0).getDpPrcsKnt());
				eventResponse.setETCData("dp_prcs_knt_local", list.get(0).getDpPrcsKntLocal());
				
			} else {

				eventResponse.setETCData("dp_prcs_knt", "0");
				eventResponse.setETCData("dp_prcs_knt_local", "0");

				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
			
			if (list != null){
				eventResponse.setRsVoList(list);
			}
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0132 : Retrieve<br>
	 * Philips Edi 정보를 조회한다. <br>
	 * 
	 * @author 9011620
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEdiPHILSList(Event e) throws EventException {
		
		FnsInv0132Event event = (FnsInv0132Event) e;
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();
		List<PHILSInvoiceEdiVO> philsInvoiceEdiVOs = new ArrayList<PHILSInvoiceEdiVO>();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			philsInvoiceEdiVOs = command.searchEdiPHILSList(event.getInputVo());
			eventResponse.setRsVoList(philsInvoiceEdiVOs);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	 
	/**
	 * Add PHILIPS EDI.
	 * 
	 * @author 9011620
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse addEdiPHILS(Event e) throws EventException {
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();
		FnsInv0132Event event = (FnsInv0132Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			
			PHILSInvoiceEdiVO[] vos = event.getPhilipsVo();
			for (PHILSInvoiceEdiVO vo : vos){
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
			}
			command.sendEdiPHILS(vos, event.getInputVo());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * FNS_INV_0106 : Retrieve <br>
	 * POP_UP 화면에서 Invoice 발행일자 기준으로 조회한다.(Re-Issue 화면에서 사용). SAOSC <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopSplitInvoiceListByIssueDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		FnsInv0106Event event = (FnsInv0106Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<ARInvoiceIssueDateVO> list = command.searchPopSplitInvoiceListByIssueDate(event.getInvoiceIssueDateVO());

			if (list.size() > 0) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * FNS_INV_0035 : Paper Re-issue - SAOSC<br>
	 * Re-issue 할 Invoice 대상List 및 Re-issue 이력을 저장한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPrintSplitInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0035Event event = (FnsInv0035Event) e;
		PrintInvoiceVO prtInvoiceVo = null;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		List<InvIssMainVO> list = null;
		String rInvNos = "";
		String cmbFlg = "";
		String rIfNos = "";
		StringBuffer rInvNosBuff = new StringBuffer();
		StringBuffer cmbFlgBuff = new StringBuffer();
		StringBuffer rIfNosBuff = new StringBuffer();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			prtInvoiceVo = event.getPrtInvoiceVo();
			prtInvoiceVo.setUserOfc(event.getPrtInvoiceVo().getUserOfc());
			prtInvoiceVo.setIssOfcCd(event.getPrtInvoiceVo().getIssOfcCd());
			prtInvoiceVo.setOtsSmryCd(event.getPrtInvoiceVo().getOtsSmryCd());
			prtInvoiceVo.setUserId(event.getPrtInvoiceVo().getUserId());
			prtInvoiceVo.setPrevFlg(event.getPrtInvoiceVo().getPrevFlg());
			prtInvoiceVo.setGotoFlg(event.getPrtInvoiceVo().getGotoFlg());
			
			log.info("\n########## prtInvoiceVo.getUserOfc() : "+prtInvoiceVo.getUserOfc());
			log.info("\n########## prtInvoiceVo.getIssOfcCd() : "+prtInvoiceVo.getIssOfcCd());
			
			begin();

			list = command.searchPrintSplitInvoice(prtInvoiceVo);
			
			for (int i = 0; i < list.size(); i++) {
				rInvNosBuff.append(list.get(i).getInvNo() + "|");
				cmbFlgBuff.append(list.get(i).getInvIssCmbFlg() + "|");
				rIfNosBuff.append(list.get(i).getIfNo() + "|");
				//rInvNos = rInvNos + list.get(i).getInvNo() + "|";
				//cmbFlg = cmbFlg + list.get(i).getInvIssCmbFlg() + "|";
				//rIfNos = rIfNos + list.get(i).getIfNo() + "|";
				
				if (!prtInvoiceVo.getPrevFlg().equals("Y")) {
					command2.modifyInvoiceReIssue(list.get(i).getInvNo(), prtInvoiceVo.getOtsSmryCd(), prtInvoiceVo.getUserId(), prtInvoiceVo.getIssOfcCd());
				}		
			}
			rInvNos = rInvNosBuff.toString();
			cmbFlg = cmbFlgBuff.toString();
			rIfNos = rIfNosBuff.toString();
			
			eventResponse.setETCData("r_inv_nos", rInvNos);
			eventResponse.setETCData("cmb_flg", cmbFlg);
			eventResponse.setETCData("r_if_nos", rIfNos);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0137 : Customer Inquiry by B/L No<br>
	 * 사용자가 Execl Upload한 B/L의 Customer정보를 조회한다.  <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerListByBL(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0137Event event = (FnsInv0137Event)e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();

		try{
			List<CustomerListByBLVO> list = command.searchCustomerListByBL(event.getBlNos());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0138 : 조회<br>
	 * AKLBA의 Invoice Deatil 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceDetailForAKLBA(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0138Event event = (FnsInv0138Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<InvoiceAKLBAVO> list = command.searchInvoiceDetailForAKLBA(event.getBillInputVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0139 : 조회<br>
	 * Issue 대상 Bkg No, Sail Arr Dt, Due Dt 를 가져온다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNYCIssueTarget(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0139Event event = (FnsInv0139Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<NYCInvoiceVO> list = command.searchNYCIssueTarget(event.getGenInvVo());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0139 : Print, FAX Send, E-mail Send<br>
	 * 미주지역 Invoice 를 발행한다.
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendNYCInvoiceByFaxEmail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0139Event event = (FnsInv0139Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();

		List<NYCInvoiceVO> nycInvoiceList = new ArrayList<NYCInvoiceVO>();
		
		NYCEmlVO nycEmlVo = new NYCEmlVO();
		
		int sendNum = 0;
		try {
			log.error("sendNYCInvoiceByFaxEmail=======================>>>>>>>>>>>>>>>START");
			
			nycInvoiceList = event.getNYCInvoiceVOs();
			nycEmlVo = event.getNYCEmlVO();
			
			
			log.debug("arOfcCd=======================>>>>>>>>>>>>>>>"+nycEmlVo.getArOfcCd());
			log.debug("sendFlag=======================>>>>>>>>>>>>>>>"+nycEmlVo.getSendFlag());
			log.debug("emailType=======================>>>>>>>>>>>>>>>"+nycEmlVo.getMailType());
			log.debug("stampType=======================>>>>>>>>>>>>>>>"+nycEmlVo.getStampType());
			log.debug("bkgNos=======================>>>>>>>>>>>>>>>"+nycEmlVo.getBkgNos());
			
			if (nycEmlVo.getSendFlag().equals("E") ||nycEmlVo.getSendFlag().equals("F")||nycEmlVo.getSendFlag().equals("P")) {
				begin();
	
				sendNum = command.sendNYCInvoiceByFaxEmail(nycInvoiceList, nycEmlVo , account);
				
				commit();
			}
			
			log.error("sendNYCInvoiceByFaxEmail=======================>>>>>>>>>>>>>>>END");
			eventResponse.setETCData("snd_num", String.valueOf(sendNum));
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0141 : Retrieve<br>
	 * NYC Invoice 정보를 발행일자 기준으로 조회한다. <br>
	 * 
	 * @author Dosoon Choi
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNYCInvoiceListByIssueDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		FnsInv0141Event event = (FnsInv0141Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<NYCInvoiceIssueDateVO> list = command.searchNYCInvoiceListByIssueDate(event.getInvoiceIssueDateVO());

			if (list != null && list.size() > 0) {
				eventResponse.setRsVoList(list);
			} 
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	
	/**
	 * FNS_INV_0068 : Retrieve<br>
	 * RHQ를 조건으로 Office 의 채권 데이터중 Option에 따라서 I/F date or S/A date, I/F confirm date를 비교하여  "GCF,SAF"CHarge 가 있는 대상을 조회하여 USD, INR Currnecy로 환산하여 보여줌.
	 * 
	 * @author Seungil Baek
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGCFSAFListByData(Event e) throws EventException {
		FnsInv0068Event event = (FnsInv0068Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<GCFSAFChargeListVO> list = command.searchGCFSAFListByData(event.getDateOption(), event.getFromDate(), event.getToDate(), event.getRhq(), event.getChgCd(), event.getScNo());
			if (list.size() > 0) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0068 : Open<br>
	 * A/R HEAD QUARTER OFFICE CODE를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGCFSAFRHQOfficeList(Event e) throws EventException {
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<String> list = command.searchGCFSAFRHQOfficeList();
			String arHdQtrOfcInfo = "";
			StringBuffer arHdQtrOfcInfoBuff = new StringBuffer();
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					arHdQtrOfcInfoBuff.append("|" + list.get(i));
					//arHdQtrOfcInfo = arHdQtrOfcInfo + "|" + list.get(i);
				}
				arHdQtrOfcInfo = arHdQtrOfcInfoBuff.toString();
				eventResponse.setETCData("ar_hd_qtr_ofc_cd", arHdQtrOfcInfo);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
			return eventResponse;
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0034_01 : Paper Issue, Go to Send <br>
	 * SINSC 의 3RD VVD 여부를 조회한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse search3rdCheckList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv003401Event event = (FnsInv003401Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
        String blNos = "";
        StringBuffer blNoBuff = new StringBuffer();
        
		try {
			begin();

			// Issue 기발행 bl_no를 조회한다
			HashMap<String, Object> result = command.search3rdCheckList(event.getGenInvVo());
			
			List<String> list	= (ArrayList)result.get("BL_NOS");
			
			int size			= 0;
			
			if(list != null){
				size	= list.size();
			}
			
			for (int i = 0; i < size; i++) {
				blNoBuff.append(list.get(i) + (i == size -1 ? "" : ", "));
			}
			blNos = blNoBuff.toString();
			commit();
 
			eventResponse.setETCData("blNos", blNos);
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * FNS_INV_0144<br>
	 * MGB EDI 전송대상 데이터를 조회한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchEdiMGBList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0144Event event = (FnsInv0144Event) e;
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();
		List<MGBInvoiceEdiVO> list = null;
		String cnt = "0";
		try {
			
			if(("B").equals(event.getMGBInputVO().getRetrOpt())){ 
				cnt = command.searchEdiMGBofficeYN(event.getMGBInputVO());
			
				if (!cnt.equals("0")) {
					list = command.searchEdiMGBList(event.getMGBInputVO());
				} else {
					eventResponse.setUserMessage(new ErrorHandler("INV00165").getUserMessage());
				}
			}else{
				list = command.searchEdiMGBList(event.getMGBInputVO());
			}
			
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0144 : Send<br>
	 * MGB EDI 정보를 전송한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendEdiMGBList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0144Event event = (FnsInv0144Event) e;
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();

		try {
			begin();
			command.sendEdiMGBList(Arrays.asList(event.getMGBInvoiceEdiVOs()), account.getUsr_id());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * FNS_INV_0145<br>
	 * ADIDAS EDI 전송대상 데이터를 조회한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchEdiADIDASList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0145Event event = (FnsInv0145Event) e;
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();

		try {
			List<ADIDASInvoiceEdiVO> list = command.searchEdiADIDASList(event.getADIDASInputVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0145 : Send<br>
	 * ADIDAS EDI 정보를 전송한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	public EventResponse addEdiADIDAS(Event e) throws EventException {
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();
		FnsInv0145Event event = (FnsInv0145Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			
			command.sendEdiADIDAS(event.getADIDASInvoiceEdiVOs(),account.getOfc_cd(), account.getUsr_id());
			
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}
	 
	/**
	 * FNS_INV_0146<br>
	 * Port 를 체크한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse checkPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0146Event event = (FnsInv0146Event) e;
		ManualARCreationBC command = new ManualARCreationBCImpl();

		try {
			command.checkPort(event.getLocCd());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0146<br>
	 * PCF Revenue, Expense 요율을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchPCFRevExpnAmount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0146Event event = (FnsInv0146Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();

		try {
			List<PCFRevExpnAmountVO> list = command.searchPCFRevExpnAmount(event.getLocCd(), event.getReExCd());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * PCF 요율을 입력,수정,삭제합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePCFRevExpnAmount(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0146Event event = (FnsInv0146Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		
		try {
			begin();
			command.managePCFRevExpnAmount(event.getPCFRevExpnAmountVOS(), account.getUsr_id());

			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0147<br>
	 * PCF status를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchPCFStatusInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0147Event event = (FnsInv0147Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();

		try {
			List<PCFStatusInfoVO> list = command.searchPCFStatusInfo(event.getPCFStatusInfoInputVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
}
