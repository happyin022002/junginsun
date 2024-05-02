/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceInquiryBC.java
*@FileTitle : Invoice Inquiry by I/F No - General
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCorrectionVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceByBLNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceInputByBLNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceInquiryInPutVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceIssueDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceListByIFDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRIDListInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRTInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRTInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRTListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRTMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CprtItemVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.DXBInvoiceListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ErpErrorInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ErpErrorVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.FaxEmailSentDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.FaxEmailSentResultVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvCprtTmpltChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotIssuedListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotissuedInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TemplateItemVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TemplateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TransDataComparisonReportInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TransDataComparisonReportVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.AROfficeListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;

/**
 * AccountReceivableInvoiceMgt Business Logic Basic Command implementation<br>
 * - AccountReceivableInvoiceMgt logic process.<br>
 *
 * @author saeil kim
 * @see FNS_INV_0011_01EventResponse,ARInvoiceInquiryBC
 * @since J2EE 1.4
 */
public interface ARInvoiceInquiryBC {

	/**
	 * Retrieve event process<br>
	 * Good Date / IF Date invoice information retrieve.<br>
	 * Showing BL count and USD total amount, local total amount<br>
	 * max period one office : 1 month, All : 10 days
	 * 
	 * @author JungJin Park
	 * @param  ARInvoiceInquiryInPutVO    invByGoodVO
	 * @return List<ARInvoiceListByIFDateVO>
	 * @exception EventException
	 */
	public List<ARInvoiceListByIFDateVO> searchARInvoiceListByGoodDate(ARInvoiceInquiryInPutVO invByGoodVO) throws EventException;
	
	/**
	 * Retrieve event process<br>
	 * Invoice publication information Invoice No retrieve<br>
	 * 
	 * @author JungJin Park
	 * @param String invNo
	 * @param String ofc
	 * @return ARInvoiceByBLNoVO
	 * @exception EventException
	 */
	public ARInvoiceByBLNoVO searchInvoiceByInvoiceNo(String invNo, String ofc) throws EventException;

	/**
	 * Retrieve event process<br>
	 * Invoice information retrieve.<br>
	 * 
	 * @author JungJin Park
	 * @param  InvoiceIssueDateVO issueDateVo
	 * @return String
	 * @exception EventException
	 */
	public String searchInvoiceListByIssueDateSum(InvoiceIssueDateVO issueDateVo) throws EventException;
	
	/**
	 * Retrieve event process<br>
	 * Receivables and Invoice information B/L No retrieve.<br>
	 * 
	 * @author JungJin Park
	 * @param ARInvoiceInputByBLNoVO invInput
	 * @return ARInvoiceByBLNoVO
	 * @exception EventException
	 */
	public ARInvoiceByBLNoVO searchARInvoiceByBLNo(ARInvoiceInputByBLNoVO invInput) throws EventException;

	
	/**
	 * Retrieve event process<br>
	 * Receivables and Invoice information Interface No retrieve.<br>
	 * 
	 * @author JungJin Park
	 * @param String ifNo
	 * @param String ofc
	 * @return ARInvoiceCorrectionVO
	 * @exception EventException
	 */
	public ARInvoiceCorrectionVO searchARInvoiceByIFNo (String ifNo ,String ofc ) throws EventException;
	
	/**
	 * Retrieve event process<br>
	 * Invoice's Fax and E-mail retrieve.<br>
	 * 
	 * @author JungJin Park
	 * @param  FaxEmailSentDateVO sendDateVo
	 * @return List<FaxEmailSentResultVO>
	 * @exception EventException
	 */
	public List<FaxEmailSentResultVO> searchFaxEmailSentResultListBySendDate (FaxEmailSentDateVO sendDateVo) throws EventException;
	
	
	/**
	 * Retrieve event process<br>
	 * Invoice status retrieve.<br>
	 * 
	 * @author JungJin Park
	 * @param NotissuedInputVO notIssVo
	 * @return List<NotIssuedListVO>
	 * @exception EventException
	 */
	public List<NotIssuedListVO> searchNotIssueListByCustomer (NotissuedInputVO notIssVo) throws EventException;

	
	/**
	 * POP-UP screen Invoice information retrieve. <br>
	 * 
	 * @param InvoiceIssueDateVO issueDateVo
	 * @return List<ARInvoiceIssueDateVO>
	 * @exception EventException
	 */
	public List<ARInvoiceIssueDateVO> searchPopInvoiceListByIssueDate(InvoiceIssueDateVO issueDateVo) throws EventException;
	
	/**
	 * Retrieve event process<br>
	 * A/R HEAD QUARTER OFFICE CODE retrieve.<br>
	 * 
	 * @author JungJin Park
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchARRHQOfficeList() throws EventException;
	
	
	
	/**
	 * Retrieve event process<br>
	 * Sales Office's A/R OFFICE CODE's (INV_AR_STUP_OFC- INV_DUP_FLG) retrieve. <br>
	 * 
	 * @author JungJin Park
	 * @param String saleOfc
	 * @return AROfficeListVO
	 * @exception EventException
	 */
	public AROfficeListVO searchAROffice (String saleOfc) throws EventException;
	
	/**
	 * FNS_INV_0110<br>
	 * Issue target (DXBBB)INV B/L retrieve.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<DXBInvoiceListVO>
	 * @exception EventException
	 */
	public List<DXBInvoiceListVO> searchDXBInvoiceList(GeneralInvoiceVO genInvVo) throws EventException;
	
	
	/**
	 * ERP I/f Error history retrieve.<br>
	 * @author KIM HYUN HWA 
	 * @param ErpErrorInputVO erpErrorInputVO
	 * @return List<ErpErrorVO>
	 * @exception EventException
	 */
	public List<ErpErrorVO> searchErpErrorList(ErpErrorInputVO erpErrorInputVO) throws EventException;

	/**
	 * Available Rhq retrieve.<br>
	 * 
	 * @param String useOfc
	 * @return List<String>
	 * @exception EventException
	 */ 
	public List<String> searchARRhqList(String useOfc) throws EventException;
		
	/**
	 * A/R Office list retrieve.<br>
	 * 
	 * @param String rhq
	 * @param String usrOfc
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchAROfficeListByRhq(String rhq, String usrOfc ) throws EventException;	
	
	
	/**
	 * AR Invoice ERP I/F  Transaction retrieve.
	 * 
	 * @param TransDataComparisonReportInputVO transDataComparisonReportInputVO
	 * @return  List<TransDataComparisonReportVO>
	 * @exception EventException
	 */
	public List<TransDataComparisonReportVO> searchTransactionDataComparisonReportList( TransDataComparisonReportInputVO transDataComparisonReportInputVO) throws EventException;
	
	/**
	 * CPR(Customer Preferable Report)에서 사용. user 가 사용가능한 Template List 를 가져온다.<br>
	 * @author Dong Hoon Han
	 * @param String userId
	 * @param String ofc
	 * @return List<TemplateVO>
	 * @exception EventException
	 */		
	public List<TemplateVO> searchTemplateList(String userId, String ofc) throws EventException;
	
	/**
	 * CPR(Customer Preferable Report)에서 사용.  조건 Template name 으로 저장된 Item들을 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param String tmplate
	 * @param CPRTInputVO cprInputVo
	 * @return List<TemplateItemVO>
	 * @exception EventException
	 */		
	public List<TemplateItemVO> searchTemplateItemList(String tmplate,CPRTInputVO cprInputVo) throws EventException;
	
	/**
	 * CPR 에서 bl preview 조회시 bkg_no가 없을 경우, 조회한다. <br>
	 * @author Dong Hoon Han
	 * @param String blNo
	 * @return String
	 * @throws EventException
	 */
	public String searchBlNo(String blNo) throws EventException;
	
	/**
	 * CPRT(Customer Preferable Report) 생성 대상 내용을 BKG 정보에서 조회해 온다.<br>
	 * @author Dong Hoon Han
	 * @param CPRTInputVO cprInputVo
	 * @param String rptItmId
	 * @return TemplateVO
	 * @exception EventException
	 */		
	public List<CPRTInvoiceVO> searchCPRTInvoice(CPRTInputVO cprInputVo, String rptItmId) throws EventException;
	
	/**
	 * CPRT(Customer Preferable Report) Report ID를 생성한다.<br>
	 * @author Dong Hoon Han
	 * @param String custNm
	 * @param CPRTInputVO cprInputVo
	 * @return String
	 * @exception EventException
	 */		
	public String issueCPRTInvoice(String custNm, CPRTInputVO cprInputVo) throws EventException;
	
	/**
	 * CPR(Customer Preferable Report)에서 사용. 선택가능한 모든 항목 List 와 를 가져온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String userId
	 * @param String ofc
	 * @return CPRT_ItemVO
	 * @exception EventException
	 */
	public CprtItemVO searchReportItemList(String userId, String ofc) throws EventException;

	/**
	 * CPR(Customer Preferable Report)에서 사용. Template으로 등록된 선택한 항목 List 를 가져온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String tmplate
	 * @param String arOfcCd
	 * @return TemplateVO
	 * @exception EventException
	 */
	public TemplateVO searchSelectedItemList(String tmplate, String arOfcCd) throws EventException;

	/**
	 * CPR(Customer Preferable Report)에서 사용. 신규입력한 Template 명이 이미 존재하는지를 check한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String tmplate
	 * @return String
	 * @exception EventException
	 */

	public String searchTemplateName(String tmplate) throws EventException;

	/**
	 * Template name으로 선택한 item을 등록,수정, 삭제한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param TemplateVO[] templateVOs
	 * @param InvCprtTmpltChgVO[] invCprtTmpltChgVOs 
	 * @param String userId
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void manageTemplateItem(TemplateVO[] templateVOs, InvCprtTmpltChgVO[] invCprtTmpltChgVOs, String userId, String ofcCd) throws EventException;

	/**
	 * CPR(Customer Preferable Report)에 사용하기 위해 등록한 Template을 삭제한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String tmplate
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void removeTemplate(String tmplate, String ofcCd) throws EventException;
	
	/**
	 * CPRT(Customer Preferable Report)에서  한개 이상의 Report ID 로 생성내역을 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param CPRTListVO cprIdVo
	 * @return List<CPRTMainVO>
	 * @exception EventException
	 */		
	public List<CPRTMainVO> searchCPRTHistoryList(CPRTListVO cprIdVo) throws EventException;
	
	/**
	 * CPRT(Customer Preferable Report) 조회조건에 해당하는  Report ID 를 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param CPRIDListInputVO cprsearchVo
	 * @return List<CPRTListVO>
	 * @exception EventException
	 */	
	public List<CPRTListVO> searchCPRTIDList(CPRIDListInputVO cprsearchVo) throws EventException;
	
}
