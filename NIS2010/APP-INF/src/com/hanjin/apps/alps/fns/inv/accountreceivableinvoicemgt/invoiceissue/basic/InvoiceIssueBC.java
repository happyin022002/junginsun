/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueBC.java
*@FileTitle : (Korea) Terminal GIRO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.04.27 정휘택
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.01.24 최도순 [CHM-201108418] 베트남지역 ALPS INVOICE 변경 요청
* 2011.08.04 오요한 [CHM-201111930] Invoice Issue 프로그램 개선
* 2012.02.01 권   민 [CHM-201215781-01] [INV] ALPS INV 중복 발행 시 알림창 pop up
* 2014.08.26 최도순 [CHM-201431413] 미주지역 Inv Issue 프로그램 개발 요청
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic;

import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceListByIFDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CHNIssuedInvoiceListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CHNReissuedInvoiceListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRIDListInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArEmlCustRgstVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArGiroVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArSplitIssChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArSplitIssVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvEmlVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceFaxEmailListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceIssueSndToErpVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceNumberVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueEachTargetVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueOptionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueTargetVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.KORGiroInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.KORGiroListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.KORInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.NYCEmlVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.NYCInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.PrintInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.TemplateItemVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.TemplateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEActInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIECombineInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEDailyExrateReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEDailyExrateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEInvoiceTargetVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.InvArIssVO;

/**
 * ALPS-Accountreceivableinvoicemgt Business Logic Command Interface<br>
 * - ALPS-Accountreceivableinvoicemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jung Hwi Taek
 * @see Fns_inv_0064EventResponse 참조
 * @since J2EE 1.4
 */

public interface InvoiceIssueBC {
	/**
	 * Terminal Invoice 의 GIRO 정보를 다수 조회한다. <br>
	 * 
	 * @param KORGiroInputVO giroInputVo
	 * @return List<KORGiroListVO>
	 * @exception EventException
	 */
	public List<KORGiroListVO> searchKORGIROList(KORGiroInputVO giroInputVo) throws EventException;
	
	/**
	 * Invoice Remark(s)의 event에 대한 조회 이벤트 처리<br>
	 * @author Jung Hwi Taek
	 * @param InvArIssVO invArIssVO
	 * @return List<InvArIssVO>
	 * @exception EventException
	 */
	public List<InvArIssVO> searchInvoiceRemark(InvArIssVO invArIssVO) throws EventException;
	
	/**
	 * Invoice 발행시 Copy 본수를 조회한다. <br>
	 * 
	 * @param String ofcCd
	 * @return int
	 * @exception EventException
	 */
	public int searchInvoiceCopyCnt(String ofcCd) throws EventException;
	
	/**
	 * Invoice No를 입력받은 후 유효한 Invoice No를 Return 해주며 INV_AR_ISS에 Re-issue 이력을 저장해 준다. <br>
	 * 
	 * @param PrintInvoiceVO prtInvoiceVo
	 * @return List<InvArIssVO>
	 * @exception EventException
	 */
	public List<InvIssMainVO> searchPrintInvoice(PrintInvoiceVO prtInvoiceVo) throws EventException;
	
	/**
	 * Fax / E-mail 발송 또는 Print 하려는 대상 Invoice 정보를 조회한다. <br>
	 * 
	 * @param PrintInvoiceVO prtInvoiceVo
	 * @return List<InvoiceFaxEmailListVO>
	 * @exception EventException
	 */
	public List<InvoiceFaxEmailListVO> searchIssuedGeneralInvoiceList(PrintInvoiceVO prtInvoiceVo) throws EventException;
	
	/**
	 * Invoice 발행 정보를 생성한다. <br>
	 * 
	 * @param InvIssMainVO[] issMainVOs
	 * @param IssueOptionVO issOptionVO
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
    public String createIssueMain(InvIssMainVO[] issMainVOs, IssueOptionVO issOptionVO, String userId) throws EventException;
    
    /**
	 * 입력한 B/L 에 대한 북중국지역의 Invoice 발행대상을 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param String blNo
	 * @param String ofcCd
	 * @param String curCd
	 * @param String userId
	 * @return List<CHNIssuedInvoiceListVO>
	 * @exception EventException
	 */		
	public List<CHNIssuedInvoiceListVO> searchCHNInvoiceForIssue(String blNo, String ofcCd, String curCd, String userId) throws EventException;
	
	/**
	 * 북중국지역의 Invoice 를 발행함<br>
	 * @author Dong Hoon Han
	 * @param CHNIssuedInvoiceListVO[] chnInv
	 * @param String ofcCd
	 * @param String curCd
	 * @param String userId
	 * @return List<CHNIssuedInvoiceListVO>
	 * @exception EventException
	 */		
	public List<String> issueCHNInvoice(CHNIssuedInvoiceListVO[] chnInv, String ofcCd, String curCd, String userId) throws EventException;

	/**
	 * 입력한 B/L 에 대한 북중국지역의 Invoice 재발행대상을 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param String blNo
	 * @param String ofcCd
	 * @param String curCd
	 * @return List<CHNReissuedInvoiceListVO>
	 * @exception EventException
	 */		
	public List<CHNReissuedInvoiceListVO> searchCHNInvoiceForReissue (String blNo , String ofcCd, String curCd) throws EventException;
	
	/**
	 * 입력한 B/L 에 대한 북중국지역의 Invoice 재발행대상을 저장한다.<br>
	 * @author Dong Hoon Han
	 * @param CHNReissuedInvoiceListVO[] chnInv
	 * @param String userId
	 * @exception EventException
	 */		
	public void reissueCHNInvoice(CHNReissuedInvoiceListVO[] chnInv, String userId) throws EventException;
	
	/**
	 * Invoice 발행할 대상 Data를 조회한다. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<IssueTargetVO>
	 * @exception EventException
	 */	
	public List<IssueTargetVO> searchTargetBLForIssue(GeneralInvoiceVO genInvVo) throws EventException;
	
	/**
	 * 구주지역, 서남아 일부지역, 남중국지역의 Invoice 를 발행함. <br>
	 * 
	 * @param IssueTargetVO issTgtVo
	 * @param GeneralInvoiceVO genInvVo
	 * @param String userId
	 * @return List<IssueTargetVO>
	 * @exception EventException
	 */		
	public List<IssueTargetVO> issueGeneralInvoice(IssueTargetVO issTgtVo, GeneralInvoiceVO genInvVo, String userId) throws EventException;
	
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

	/**
	 * e-mail, FAX를 전송한다. <br>
	 * 
	 * @param InvIssMainVO[] issMainVOs
	 * @param IssueOptionVO issOptionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
    public void sendGeneralInvoiceByFaxEmail(InvIssMainVO[] issMainVOs, IssueOptionVO issOptionVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * 조회 이벤트 처리<br>
	 * 한국지역 Invoice 정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String invNo
	 * @param String ofcCd
	 * @return KORInvoiceVO
	 * @exception EventException
	 */
	public KORInvoiceVO searchKORInvoice (String invNo, String ofcCd) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * 입력한 B/L 에 대한 정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String blNo
	 * @param String ofcCd
	 * @return KORInvoiceVO
	 * @exception EventException
	 */
	public KORInvoiceVO searchKORIssueTargetByBL (String blNo, String ofcCd) throws EventException;
	
	/**
	 * Bank 의 계좌번호를 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param String ofcCd
	 * @param String currCd
	 * @return List<String>
	 * @exception EventException
	 */		
	public List<String> searchBankAccount(String ofcCd, String currCd) throws EventException;
	
	/**
	 * Issue 이벤트 처리<br>
	 * 한국지역 Invoice 를 발행한다.<br>
	 * 
	 * @author JungJin Park
	 * @param KORInvoiceVO korInvVo
	 * @return String
	 * @exception EventException
	 */
	public String issueKORInvoice (KORInvoiceVO korInvVo) throws EventException;
	
	/**
	 * ReIssue 이벤트 처리<br>
	 * 한국지역 Invoice 를 재발행한다.<br>
	 * 
	 * @author JungJin Park
	 * @param KORInvoiceVO korInvVo
	 * @return String
	 * @exception EventException
	 */
	public String reissueKORInvoice (KORInvoiceVO korInvVo) throws EventException;
	
	/**
	 * Fax, Email 이벤트 처리<br>
	 * 한국지역 Invoice 를 Fax/Email 로 전송한다.<br>
	 * 
	 * @author JungJin Park
	 * @param KORInvoiceVO korInvVo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String sendKORInvoiceByFaxEmail(KORInvoiceVO korInvVo, SignOnUserAccount account) throws EventException;
	
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
	public List<TemplateItemVO> searchTemplateItemList(String tmplate, CPRTInputVO cprInputVo) throws EventException;
	
	/**
	 * CPRT(Customer Preferable Report) 생성 대상 내용을 BKG 정보에서 조회해 온다.<br>
	 * @author Dong Hoon Han
	 * @param CPRTInputVO cprInputVo
	 * @param String rptItmId
	 * @return List<CPRTInvoiceVO>
	 * @exception EventException
	 */		
	public List<CPRTInvoiceVO> searchCPRTInvoice(CPRTInputVO cprInputVo, String rptItmId) throws EventException;
//	public TemplateVO searchCPRTInvoice(CPRTInputVO cprInputVo, String rptItmId) throws EventException;
	
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
	 * CPRT(Customer Preferable Report) Report ID를 생성한다.<br>
	 * @author Dong Hoon Han
	 * @param String custNm
	 * @param String usrId
	 * @param String ofc_cd
	 * @param CPRTInvoiceVO[] cprVos
	 * @return String
	 * @exception EventException
	 */		
	/*
	public String issueCPRTInvoice(String custNm, String usrId, String ofc_cd, CPRTInvoiceVO[] cprVos) throws EventException;
	*/
	
	/**
	 * 조회 이벤트 처리<br>
	 * Terminal Invoice 의 GIRO 정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String blNo
	 * @param String ofcCd
	 * @return KORGiroListVO
	 * @exception EventException
	 */
	public KORGiroListVO searchKORGIRO (String blNo, String ofcCd) throws EventException;
	
	/**
	 * Terminal Invoice 의 생성된 GIRO 정보를 생성, 갱신, 삭제한다.<br>
	 * 
	 * @author JungJin Park
	 * @param List<InvArGiroVO> invArGiros
	 * @exception EventException
	 */		
	public void manageKORGIRO (List<InvArGiroVO> invArGiros) throws EventException;

	/**
	 * Terminal Invoice 의 생성된 GIRO 정보를 삭제한다.<br>
	 * 
	 * @author JungJin Park
	 * @param List<InvArGiroVO> invArGiros
	 * @exception EventException
	 */		
	public void removeKORGIRO (List<InvArGiroVO> invArGiros) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * 베트남지역 기 발행된 Invoice 정보를 조회한다.<br>
	 * 
	 * @param InvoiceIssueDateVO vieInvVo
	 * @return List<ARInvoiceListByIFDateVO>
	 * @exception EventException
	 */
	public List<ARInvoiceListByIFDateVO> searchSWAIssuedInvoiceList (InvoiceIssueDateVO vieInvVo) throws EventException;
	
	/**
	 * FNS_INV_0036<br>
	 * 베트남 지역의 Single Invoice 발행대상 B/L 정보를 조회한다.(Max I/F NO 정보를 가져옴)<br>
	 * INV Type별 Charge 조건에 맞는 내요이 chg_amt <> 0 인 대상임<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param GeneralInvoiceVO sinInvVo
	 * @return List<VIEInvoiceTargetVO>
	 * @exception EventException
	 */
	public List<VIEInvoiceTargetVO> searchVIEIssueTargetBLNoList(GeneralInvoiceVO sinInvVo) throws EventException;
	
	/**
	 * FNS_INV_0036<br>
	 * 베트남 지역의 Single Invoice 발행대상 B/L 정보를 조회한다.(Max I/F NO 정보를 가져옴)<br>
	 * INV Type별 Charge 조건에 맞는 내요이 chg_amt <> 0 인 대상임<br>
	 * 
	 * @param GeneralInvoiceVO sinInvVo
	 * @return String
	 * @exception EventException
	 */
	public String searchVIEIssueTargetCheckCharge(GeneralInvoiceVO sinInvVo) throws EventException;
		
	/**
	 * FNS_INV_0036<br>
	 * 베트남 지역 매출채권 정보를 Invoice 발행한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param GeneralInvoiceVO sinInvVo
	 * @return List<IssueEachTargetVO>
	 * @exception EventException
	 */
	public List<IssueEachTargetVO> issueVIESingleInvoice(GeneralInvoiceVO sinInvVo) throws EventException;

	/**
	 * FNS_INV_0036<br>
	 * 베트남 지역에서 Issue시 Issue Table에 정보를 반영한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param IssueEachTargetVO issEachTargetVO
	 * @param String userId
	 * @exception EventException
	 */
	public void createVIEInvoice(IssueEachTargetVO issEachTargetVO, String userId) throws EventException;
	
	/**
	 * FNS_INV_0036<br>
	 * 베트남 지역의 Invoice 발행시 적용 환율을 구한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param VIEDailyExrateVO vieDailyExrateVO
	 * @return VIEDailyExrateReturnVO
	 * @exception EventException
	 */
	public VIEDailyExrateReturnVO searchVIEDailyExrate(VIEDailyExrateVO vieDailyExrateVO) throws EventException;
	
	/**
	 * 베트남 지역에서 실제 사용하는 Actual Invoice Number 를 Invoice 정보에 반영한다.<br>
	 * 
	 * @author JungJin Park
	 * @param List<VIEActInvoiceVO> vieActInvoiceVOs
	 * @exception EventException
	 */		
	public void createVIEActualInvoiceNumber (List<VIEActInvoiceVO> vieActInvoiceVOs ) throws EventException;
	
	/**
	 * FNS_INV_0088<br>
	 * 베트남 지역의 Combine Invoice 발행대상 B/L 및 금액정보를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param GeneralInvoiceVO sinInvVo
	 * @return List<VIECombineInvoiceVO>
	 * @exception EventException
	 */
	public List<VIECombineInvoiceVO> searchVIECombineBLNoList(GeneralInvoiceVO sinInvVo) throws EventException;
	
	/**
	 * BackEndJob 으로 Invoice 를 발행한다. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */	
	public String issueGeneralInvoiceBackEndJobKey(GeneralInvoiceVO genInvVo, String userId) throws EventException;
	
	/**
	 * Invoice 를 발행하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return InvoiceIssueSndToErpVO
	 * @exception EventException
	 */
	public InvoiceIssueSndToErpVO getBackEndJobResutIssueGeneralInvoice(String key) throws EventException;

	/**
	 * FNS_INV_0036<br>
	 * 베트남 지역의 Invoice 발행시 INV NO를 구한다.<br>
	 *
	 * @author Choi Woo-Seok
	 * @param String invType
	 * @param String ofcCd
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String searchVIEInvoiceNumber(String invType, String ofcCd, String userId) throws EventException;
	
	/**
	 * FNS_INV_0088<br>
	 * 베트남 지역 매출채권 정보를 Combine 하여 한 Invoice 로 발행한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param VIECombineInvoiceVO vIECombineInvoiceVO
	 * @return List<IssueEachTargetVO>
	 * @exception EventException
	 */
	public List<IssueEachTargetVO> issueVIECombinedInvoice(VIECombineInvoiceVO vIECombineInvoiceVO) throws EventException;
	
	/**
	 * FNS_INV_0036<br>
	 * 베트남 지역에서 Issue시 Issue Table에 정보를 반영한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String invNo
	 * @param String singleFlg
	 * @param VIEDailyExrateVO vIEDailyExrateVO
	 * @param String userId
	 * @exception EventException
	 */
	public void createVIEIssueMain(String invNo, String singleFlg, VIEDailyExrateVO vIEDailyExrateVO, String userId) throws EventException;
	
	/**
	 * FNS_INV_0036<br>
	 * 베트남 지역에서 Issue시 Issue Table에 정보를 반영한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String invNo
	 * @param String singleFlg
	 * @param VIEDailyExrateVO vIEDailyExrateVO
	 * @param String userId
	 * @param String vnInvPayMzdCd
	 * @exception EventException
	 */
	public void createVIEIssueMain(String invNo, String singleFlg, VIEDailyExrateVO vIEDailyExrateVO, String userId, String vnInvPayMzdCd) throws EventException;

	/**
	 * Invoice 비발행 대상 Data를 조회한다. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<String>
	 * @exception EventException
	 */	
	public List<String> searchErrorBLNumberList(GeneralInvoiceVO genInvVo) throws EventException;
	
	/**
	 * Invoice 기발행 Data를 조회한다. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @return HashMap<String, Object>
	 * @exception EventException
	 */	
	public HashMap<String, Object> searchAlreadyIssuedList(GeneralInvoiceVO genInvVo) throws EventException;
	
	/**
	 * FNS_INV_0088<br>
	 * B/L 대상 Select<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param VIECombineInvoiceVO[] vIECombineInvoiceVOs
	 * @return List<VIECombineInvoiceVO>
	 * @exception EventException
	 */
	public List<VIECombineInvoiceVO> searchVIECombineTargetBLNoList(VIECombineInvoiceVO[] vIECombineInvoiceVOs) throws EventException;
	
	/**
	 * Issue 이벤트 처리<br>
	 * 한국지역 Invoice 를 발행한다.<br>
	 * 
	 * @author JungJin Park
	 * @param KORInvoiceVO korInvVo
	 * @return KORInvoiceVO
	 * @exception EventException
	 */
	public KORInvoiceVO printKORInvoice (KORInvoiceVO korInvVo) throws EventException;
	
	/**
	 * Invoice Number를 채번한다. <br>
	 * 
	 * @param String ofcCd
	 * @param String bnd
	 * @param String userId
	 * @return InvoiceNumberVO
	 * @exception DAOException
	 */
	public InvoiceNumberVO searchInvoiceNumber(String ofcCd, String bnd, String userId) throws EventException;
	
	/**
	 * Invoice Number채번 Table의 max_seq 값을 변경한다. <br>
	 * 
	 * @param String invPfxCd
	 * @param String invMaxSeq
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyInvoiceNumber(String invPfxCd, String invMaxSeq, String userId) throws EventException;

	/**
	 * 동일 INVOICE NO를 반영할 대상 INTERFACE NO를 구한다. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @param IssueTargetVO issTgtVo
	 * @return List<IssueTargetVO>
	 * @exception DAOException
	 */
	public List<IssueTargetVO> searchInterfaceNumberList(GeneralInvoiceVO genInvVo, IssueTargetVO issTgtVo) throws EventException;
	
	/**
	 * Invoice Detail Table 에 저장할 대상 Data를 조회한다. <br>
	 * 
	 * @param String arIfNo
	 * @return List<IssueEachTargetVO>
	 * @exception DAOException
	 */
	public List<IssueEachTargetVO> searchEachTargetForIssue(String arIfNo) throws EventException;
	
	/**
	 * Invoice Detail 정보를 생성한다. <br>
	 * 
	 * @param String invNo
	 * @param IssueEachTargetVO issEachTgtVo
	 * @param String userId
	 * @exception DAOException
	 */
	public void createInvoiceMapping(String invNo, IssueEachTargetVO issEachTgtVo, String userId) throws EventException;
	
	/**
	 * Invoice issue 실행한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param GeneralInvoiceVO genInvVo
	 * @return InvIssVO
	 * @exception DAOException
	 */
	public InvIssVO manageIssueTargetMgt(GeneralInvoiceVO genInvVo) throws EventException;
	
	/**
	 * INV_AR_ISS_DTL 테이블 INSERT 한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @exception DAOException
	 */
	public void addInvoiceIssueDetail(InvIssVO invIssVO) throws EventException;
	
	/**
	 * ISSUE TEMP 테이블 DELETE 한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> removeInvoiceIssueFilter(InvIssVO invIssVO) throws EventException;

	/**
	 * Other Revenue 에서 입력한 내용의  Invoice 를 발행한다. <br>
	 * 
	 * @param InvIssMainVO invCreVo
	 * @param List<IssueEachTargetVO> issEachTgtVOs
	 * @param String ofcCd
	 * @param String userId
	 * @return String
	 * @throws EventException
	 */
	public String issueOtherRevInvoice (InvIssMainVO invCreVo, List<IssueEachTargetVO> issEachTgtVOs, String ofcCd, String userId) throws EventException;
	
	/**
	 * CPR 에서 bl preview 조회시 bkg_no가 없을 경우, 조회한다. <br>
	 * @author Dong Hoon Han
	 * @param String blNo
	 * @return String
	 * @throws EventException
	 */
	public String searchBlNo(String blNo) throws EventException;
	
	/**
	 * INV_AR_ISS_SND insert한다. <br>
	 * @author Dong Hoon Han
	 * @param String invNo
	 * @param String sndTp
	 * @param InvEmlVO invEmlSendNoVO
	 * @param String usrId
	 * @throws EventException
	 */
	public void createSendNo(String invNo, String sndTp, InvEmlVO invEmlSendNoVO, String usrId) throws EventException;
	
	/**
	 * VAT Charge를 검색한다. <br>
	 * @param GeneralInvoiceVO vo
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> searchVIEVATCharge(GeneralInvoiceVO vo) throws EventException; 
	
	/**
	 * 구주 EmailServer로부터 들어온 EDI Message 수신
	 * 
	 * @param String rcvMsg
	 * @param String userId
	 * @param String integrationId
	 * @exception EventException
	 */
	public void receiveEdiFromEurEmailServer(String rcvMsg, String userId, String integrationId) throws EventException;

	/**
	 * @param invIssVO
	 * @return
	 * @throws EventException
	 */
	public InvoiceIssueSndToErpVO manageArMainForInvoiceIssue(InvIssVO invIssVO) throws EventException;
	
	/**
	 * @param InvoiceIssueSndToErpVO invIssGRPVO
	 * @throws EventException
	 */
	public void interfaceARInvoiceToERPAR(InvoiceIssueSndToErpVO invIssGRPVO)throws EventException;
	
	/**
     * @param vo
     * @return
     * @throws EventException
     */
    public List<InvArEmlCustRgstVO> searchEmlCustRgst(InvArEmlCustRgstVO vo)throws EventException;


    /**
     * @param vos
     * @throws EventException
     */
    public void manageEmlCustRgst(List<InvArEmlCustRgstVO> vos)throws EventException;

    
    /**
     * @param ofcCd
     * @return
     * @throws EventException
     */
    public String searchOfcOpt(String ofcCd)throws EventException;

    
    /**
     * @param invArSplitIssVO
     * @param invArSplitIssChgVOs
     * @param ofcCd
     * @param usrId
     * @param loginOfcCd
     * @return
     * @throws EventException
     */
    public String splitARInvoiceByBL(InvArSplitIssVO invArSplitIssVO, List<InvArSplitIssChgVO> invArSplitIssChgVOs, String ofcCd, String usrId, String loginOfcCd)throws EventException;

    
    /**
     * @param invArSplitIssVO
     * @return
     * @throws EventException
     */
    public String searchMaxSplitInvWorkNumber(InvArSplitIssVO invArSplitIssVO)throws EventException;
    
	/**
	 * Invoice No를 입력받은 후 유효한 Invoice No를 Return 해주며 INV_AR_ISS에 Re-issue 이력을 저장해 준다. <br>
	 * 
	 * @param PrintInvoiceVO prtInvoiceVo
	 * @return List<InvArIssVO>
	 * @exception EventException
	 */
	public List<InvIssMainVO> searchPrintSplitInvoice(PrintInvoiceVO prtInvoiceVo) throws EventException;
	
	
	/**
	 * Issue 대상 Bkg No, Sail Arr Dt, Due Dt 를 가져온다 <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<NYCInvoiceVO>
	 * @exception EventException
	 */
	public List<NYCInvoiceVO> searchNYCIssueTarget(GeneralInvoiceVO genInvVo) throws EventException ;
	
	
	/**
	 * Fax, Email 이벤트 처리<br>
	 * 미주지역 Invoice 를 Fax/Email 로 전송한다.<br>
	 * 
	 * @author JungJin Park
	 * @param List<NYCInvoiceVO> nYCInvoiceVOs
	 * @param NYCEmlVO nycEmlVo
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int sendNYCInvoiceByFaxEmail(List<NYCInvoiceVO> nYCInvoiceVOs, NYCEmlVO nycEmlVo, SignOnUserAccount account) throws EventException ;
	
	/**
     * Office Code로 Server ID 조회<br>
	 * @author JungJin Park
     * @param ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchSeverId(String ofcCd) throws EventException ;
	
	/**
     * VLCSC  MIV 존재여부 Check 
     * VLCSC의 경우 Auto Invoice Issue는 MIV가 존재하는 BL만 대상으로함<br>
	 * @author JungJin Park
     * @param arOfcCd
     * @param blSrcNo
	 * @return String
	 * @exception EventException
	 */
	public String searchChkAutoInv(String arOfcCd, String blSrcNo) throws EventException ;
	
	/**
     *  Auto Invoice 전송을 위해 AR_IF_NO로 Customer Email 조회<br>
	 * @author JungJin Park
     * @param arIfNo
	 * @return String
	 * @exception EventException
	 */
	public String searchAutoInvEmail(String arIfNo) throws EventException ;
	
	/**
	 * Invoice 3rd vvd Data를 조회한다. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @return HashMap<String, Object>
	 * @exception EventException
	 */	
	public HashMap<String, Object> search3rdCheckList(GeneralInvoiceVO genInvVo) throws EventException;

	/**
	 * 인도지역 Split Flag를 update 한다. <br>
	 * 
	 * @param String arOfcCd
	 * @param String blSrcNo
	 * @exception DAOException
	 */
	public void modifyIDASplitFlg(String arOfcCd, String blSrcNo) throws EventException;
	
}