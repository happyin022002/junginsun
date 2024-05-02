/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BookingARCreationBC.java
 *@FileTitle : Invoice Update by User ID
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.01
 *@LastModifier : 한동훈
 *@LastVersion : 1.0
 * 2009.06.01 한동훈
 * 1.0 Creation
 * -------------------------------------------------------- 
 * History
 * 2010.11.24 최도순 [CHM-201006704] 한국지역 WHF DEC CANCEL 정보 유관 시스템 I/F 기능 추가
 * 2011.04.06 최도순 [CHM-201109030-01] Intra - Europe Business 관련 VAT 기능 개발
 * 2011.10.26 권   민 [CHM-201114097] (Spain) Invoice Download for EDI
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic;

import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCreditInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCreditVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARInvoiceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ActInvCustVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ArOfficeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CancelInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ChinaVATInvoiceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CustInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CutOffLaneVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ERPIfReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExRateCountVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvNewCustVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.OtherRevReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.SysClearVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.VvdLanePortVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceSplitVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.MarkingReverseChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssueVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceIssueSndToErpVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * ALPS-Accountreceivableinvoicecreation Business Logic Command Interface<br>
 * - ALPS-Accountreceivableinvoicecreation에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Han Dong Hoon
 * @see Fns_inv_0026EventResponse 참조
 * @since J2EE 1.6
 */

public interface BookingARCreationBC {
	/**
	 * 멀티 이벤트 처리<br>
	 * InterfaceNo 에 해당되는 UserId 변경합니다.<br>
	 * 
	 * @param String ifNo
	 * @param String userID
	 * @exception EventException
	 */
	public void modifyInvoiceUserID(String ifNo, String userID) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * Invoice 금액합이 0인 매출채권 정보들을 System Clear 처리한다.<br>
	 * 
	 * @author JungJin Park
	 * @param SysClearVO sysClearVo
	 * @return int
	 * @exception EventException
	 */
	public int modifySysClearList(SysClearVO sysClearVo) throws EventException;
	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Invoice 금액합이 0인 매출채권 정보들을 System Clear 처리한다.<br>
	 * 
	 * @author JungJin Park
	 * @param SysClearVO sysClearVo
	 * @return int
	 * @exception EventException
	 */
	public int modifySysClearListByIfNo(SysClearVO sysClearVo) throws EventException ;
		
	/**
	 * 멀티 이벤트 처리<br>
	 * Invoice 금액합이 0인 매출채권 정보들을 System Clear 처리한다.<br>
	 * 
	 * @author JungJin Park
	 * @param List<SysClearVO> sysClearVos
	 * @return int
	 * @exception EventException
	 */
	public int modifySysClearListBatch(List<SysClearVO> sysClearVos) throws EventException ;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Bookingarcreation 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @param String userId
	 * @return InvArMnVO
	 * @exception EventException
	 */
	public InvArMnVO createMiscellaneousARInvoice(ARInvoiceCreationVO invCreVo, String userId) throws EventException;

	/**
	 * No Good 매출채권 또는 Good 매출채권이면서 Actual 및 Invoice Customer 이외 항목 변경한 경우 업데이트<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String modifyARInvoice(ARInvoiceCreationVO invCreVo, String userId) throws EventException;

	/**
	 * No Good 매출채권 또는 Good 매출채권이면서 Actual 및 Invoice Customer 이외 항목 변경한 경우 Cancel 항목 생성<br>
	 * 
	 * @param CancelInvoiceVO cancelInvoiceVO
	 * @return String
	 * @exception EventException
	 */
	public String createARCancelInvoice(CancelInvoiceVO cancelInvoiceVO) throws EventException;

	/**
	 * Good 매출채권이면서 Actual 및 Invoice Customer 를 변경한 경우 새로운 IF 생성<br>
	 * 
	 * @param InvNewCustVO invNewCustVO
	 * @param String userId
	 * @return String 
	 * @exception EventException
	 */
	public String createNewCustomerARInvoice(InvNewCustVO invNewCustVO, String userId) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * 비해운 운임수입으로 발생한 매출채권 정보를 신규 생성한다.<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @return OtherRevReturnVO
	 * @exception EventException
	 */
	public OtherRevReturnVO createOtherRevenueARInvoice(ARInvoiceCreationVO invCreVo) throws EventException;

	/**
	 * FNS_INV_0017 Invoice Customer Correction by Date, No Good 일때 Customer Code 변경
	 * 
	 * @param InvNewCustVO invNewCustVO
	 * @param String userId
	 * @return String
	 * @exception EventException
	 * 
	 */
	public String modifyCustomerCode(InvNewCustVO invNewCustVO, String userId) throws EventException;

	/**
	 * FNS_INV_0007,0008,0100,0101 BackEndJob 처리
	 * 
	 * @author Choi Do Soon
	 * @param ExchangeRateVO[] exchangeRateVOs
	 * @param String userId
	 * @return String
	 * @exception EventException
	 * 
	 */
	public String manageARInvoiceExRateList(ExchangeRateVO[] exchangeRateVOs, String userId) throws EventException;
	
	/**
	 * FNS_INV_0027 환율 Update BackEndJob 처리
	 * 
	 * @author Choi Do Soon
	 * @param List<ExrateInputVO> exrateInputVOs
	 * @param ExrateInputVO exrateInputVO
	 * @param String runOpt
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String modifyExchangeRateList(List<ExrateInputVO> exrateInputVOs,ExrateInputVO exrateInputVO, String runOpt ,String userId) throws EventException ;
	
	/**
	 * FNS_INV_0027 환율 Update 하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return List<ExRateCountVO>
	 * @exception EventException
	 */
	public List<ExRateCountVO> getBackEndJobResutModifyExchangeRateList(String key) throws EventException ;
	
	/**
	 * FNS_INV_0062 VLCSC의 EDI 다운로드 받은 해당 데이터에 대해서 EDI_SND_DT에 SYSDATE를 반영한다.
	 * 
	 * @author JungJin Park
	 * @param String ofcCd
	 * @param String issDate
	 * @exception EventException
	 */
	public void modifyEDISendDate(String ofcCd, String issDate) throws EventException;
	
	/**
	 * FNS_INV_0062 VLCSC의 EDI 다운로드 했던 데이터에 대해서 INV_AR_MN의 EDI_SND_DT 값을 Null 를 update 한다.
	 * 
	 * @author	Kwon Min
	 * @param	String fmInvNo
	 * @param	String toInvNo
	 * @exception EventException
	 */
	public void modifyEDISendDataRelease(String fmInvNo, String toInvNo) throws EventException;

	/**
	 * Invoice Issue (Main)의 event에 대한 Issue 이벤트 처리<br>
	 * 
	 * @author Jung Hwi Taek
	 * @param String invNo
	 * @param String issFlg
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyIssueFlag(String invNo, String issFlg, String userId) throws EventException;

	/**
	 * Invoice Issue (Main)의 event에 대한 Issue 이벤트 처리<br>
	 * 
	 * @author Jung Hwi Taek
	 * @param String ifNo
	 * @param String dueDt
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyDueDate(String ifNo, String dueDt, String userId) throws EventException;

	/**
	 * Invoice Issue (Main)의 event에 대한 Issue 이벤트 처리<br>
	 * 
	 * @author Jung Hwi Taek
	 * @param String ifNo
	 * @param String bkgNo
	 * @param String invRmk
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyTeuFeuInvRefNumber(String ifNo, String bkgNo, String invRmk, String userId) throws EventException;

	/**
	 * INVOICE ISSUE시 ISSUE FLAG , DUE DATE, TEU, FEU, REF NUMBER를 UPDATE 한다. <br>
	 * 
	 * @param InvIssueVO invIssueVO
	 * @param String otsSmryCd
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyInvoiceIssue(InvIssueVO invIssueVO, String otsSmryCd, String userId) throws EventException;

	/**
	 * INVOICE RE-ISSUE시 ISSUE FLAG, DUE DATE, TEU, FEU, REF NUMBER를 UPDATE 한다. <br>
	 * 
	 * @param String invNo
	 * @param String otsSmryCd
	 * @param String userId
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void modifyInvoiceReIssue(String invNo, String otsSmryCd, String userId, String ofcCd) throws EventException;


	/**
	 * FNS_INV_0027 Ex Rate Update by Date or VVD 환율이 미적용된 B/L 들에 대해 올바른 환율을 적용<br>
	 * 
	 * @author Choi Do Soon
	 * @param ExrateMainVO exrateMainVO
	 * @return String
	 * @exception EventException
	 */
	public String modifyInvoiceExrateMain(ExrateMainVO exrateMainVO) throws EventException;

	/**
	 * FNS_INV_0027 Ex Rate Update by Date or VVD 환율이 미적용된 B/L 들에 대해 올바른 환율을 Chg 테이블에 적용<br>
	 * 
	 * @author Choi Do Soon
	 * @param ExrateChgVO exrateChgVO
	 * @exception EventException
	 */
	public void modifyInvoiceExrateChg(ExrateChgVO exrateChgVO) throws EventException;

	/**
	 * INVOICE ISSUE시 ISSUE FLAG , DUE DATE, TEU, FEU, REF NUMBER를 UPDATE 한다. <br>
	 * 
	 * @param InvIssMainVO[] issMainVOs
	 * @param String ofcCd
	 * @param String issueGubn
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyInvoiceIssueEmail(InvIssMainVO[] issMainVOs, String ofcCd, String issueGubn, String userId) throws EventException;

	/**
	 * Split 시 사용할 사용가능한 IF NO 의 Max Seq 를 INV_AR_BKG_IF_NO 에 update 한다.<br>
	 * 
	 * @author Choi Do Soon
	 * @param String ofcCd
	 * @param String maxSeq
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyNewInterfaceNo(String ofcCd, String maxSeq, String userId) throws EventException;

	/**
	 * INV_AR_MN 테이블에 Update Master가 되는 대상 데이터에 Split ind를 'M'으로 update 함. <br>
	 * 
	 * @author Choi Do Soon
	 * @param String ifNo
	 * @param String splitCd
	 * @param String otsSmryCd
	 * @param String userId
	 * @exception EventException
	 */
	public void modifySplitCode(String ifNo, String splitCd, String otsSmryCd, String userId) throws EventException;
	
	/**
	 * INV_AR_MN 테이블에 InvNo 로 Update Master가 되는 대상을 찾아서 Split ind를 'M'으로 update 함. <br>
	 * 
	 * @author Choi Do Soon
	 * @param String invNo
	 * @param String ofcCd
	 * @param String splitCd
	 * @param String userId
	 * @exception EventException
	 */
	public void modifySplitCodebyInvNo(String invNo, String ofcCd, String splitCd, String userId) throws EventException;
	
	/**
	 * FNS012R001Document XMLparsing <br>
	 * 
	 * @param XmlObject xmlObject
	 * @return ERPIfReturnVO[]
	 * @exception EventException
	 */
	public ERPIfReturnVO[] fns012R001Receive(XmlObject xmlObject) throws EventException;

	/**
	 * FNS012-R001에서 Return받는 정보를 INV_AR_AMT에 update 함. <br>
	 * 
	 * @param ERPIfReturnVO[] erpIfReturnVOs
	 * @exception EventException
	 */
	public void modifyARInvoiceERPReturn(ERPIfReturnVO[] erpIfReturnVOs) throws EventException;

	/**
	 * FNS_INV_0018 invoice Split Before Invoice Issue Interface Data 에 대한 Cancel Interface data 를 생성한다.<br>
	 * 
	 * @param CancelInvoiceVO cancelInvoiceVO
	 * @return String
	 * @exception EventException
	 */
	public String createARCancelSplitInvoice(CancelInvoiceVO cancelInvoiceVO) throws EventException;
	
	/**
	 * Invoice Issue Interface Data 에 대한 Cancel Interface data 를 생성한다.<br>
	 * 
	 * @param CancelInvoiceVO cancelInvoiceVO
	 * @return String
	 * @exception EventException
	 */
	public String createCancelIssueARInvoice(CancelInvoiceVO cancelInvoiceVO) throws EventException;
	
	/**
	 * Invoice Issue Interface Data  에 대한 New Interface data 를 생성한다.<br>
	 * 
	 * @param CancelInvoiceVO cancelInvoiceVO
	 * @return String
	 * @exception EventException
	 */
	public String createNewIssueARInvoice(CancelInvoiceVO cancelInvoiceVO) throws EventException;
	
	/**
	 * Invoice Issue Interface Data  에 대한 New Interface data 를 생성한다.<br>
	 * 
	 * @param CancelInvoiceVO cancelInvoiceVO
	 * @return String
	 * @exception EventException
	 */
	public String createNewMIssueARInvoice(CancelInvoiceVO cancelInvoiceVO) throws EventException;
	
	/**
	 * FNS_INV_0018 invoice Split Before Invoice Issue Invoice 의 Split 정보를 생성한다.<br>
	 * 
	 * @param ARInvoiceSplitVO invSplitVo
	 * @return String
	 * @exception EventException
	 */
	public String createSplitInvoice(ARInvoiceSplitVO invSplitVo) throws EventException;
	
	/**
	 * Booking 및 Wharfage에서 발생한 매출채권 정보를 Interface 하는 BackEndJob 호출<br>
	 * 
	 * @param ARBkgInterfaceCreationVO bkgIfVo
	 * @return String
	 * @exception EventException
	 */
	public String interfaceBKGARInvoiceToINV(ARBkgInterfaceCreationVO bkgIfVo) throws EventException;
	
	/**
	 * Kor Wharfage에서 발생한 매출채권 정보를 Interface  <br>
	 * 
	 * @param String vvdCd
	 * @param String whfBndCd
	 * @param String portCd
	 * @param String userId
	 * @param String whfDeclCxlFlg
	 * @exception EventException
	 */
	public void interfaceWHFARInvoiceToINV( String vvdCd, String whfBndCd, String portCd, String userId, String whfDeclCxlFlg) throws EventException;
	
	/**
	 * Booking 및 Wharfage에서 발생한 매출채권 정보를 Interface 하는 BackEndJob List 호출 <br>
	 * 
	 * @param List<ARBkgInterfaceCreationVO> bkgIfVos
	 * @return String
	 * @exception EventException
	 */
	public String interfaceBKGARInvoiceToINV(List<ARBkgInterfaceCreationVO> bkgIfVos) throws EventException;
	
	/**
	 * Booking 및 Wharfage에서 발생한 매출채권 정보를 Interface 받고, ERP AR 에 필요한 속성들을 생성한다.<br>
	 * B/L 의 매출채권 정보를 Bound 별로 각각의 AR Office 에 따라 History 방식으로 생성하고<br>
	 * ERP AR 에서 필요한 COA 등의 정보를 생성한다. <br>
	 * 
	 * @param ARBkgInterfaceCreationVO bkgIfVo
	 * @return List<InvArIfNoVO>
	 * @exception EventException
	 */
	public List<InvArIfNoVO> executeInterfaceBKGARInvoiceToINV(ARBkgInterfaceCreationVO bkgIfVo) throws EventException;
	
	/**
	 * 특정 Interface Data 에 대한 Cancel Interface data 를 생성한다.<br>
	 * 
	 * @param String maxIfNo
	 * @param String whfFlg
	 * @param String userId
	 * @param String vvdTrnsFlg
	 * @return String
	 * @exception EventException
	 */
	public String createMaxIFCancel (String maxIfNo, String whfFlg, String userId, String vvdTrnsFlg) throws EventException;
	
	/**
	 * 신규 I/F 매출채권 data 의 VVD, Lane, Scope, Port, S/A Date, <br>
	 * Sailing Date, Revenue VVD, Revenue Lane 등의 정보를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String ioBndCd
	 * @param String ofcCd
	 * @return VvdLanePortVO
	 * @exception EventException
	 */
	public VvdLanePortVO searchVVDForNewInterface(String bkgNo, String bkgSeq, String ioBndCd, String ofcCd) throws EventException;
	
	/**
	 * Booking Office 에 해당하는 A/R Office 정보를 조회한다.<br>
	 * 
	 * @param CutOffLaneVO cutOffLaneVO
	 * @return ArOfficeVO
	 * @exception EventException
	 */
	public ArOfficeVO searchAROfficeList(CutOffLaneVO cutOffLaneVO) throws EventException;
	
	/**
	 * Actual / Invoice Customer Code 를 조회한다<br>
	 * 
	 * @param CustInputVO custInputVO 
	 * @return ActInvCustVO
	 * @exception EventException
	 */
	public ActInvCustVO searchCustomerCode(CustInputVO custInputVO) throws EventException;
	
	/**
	 * Actual Customer 의 Credit Flag, Credit Term, Due Date 정보를 조회한다.<br>
	 * 
	 * @param ARCreditInputVO arCrdtVo
	 * @return ARCreditVO
	 * @exception EventException
	 */
	public ARCreditVO searchARCredit(ARCreditInputVO arCrdtVo) throws EventException;
	
	/**
	 * 특정 Interface Data 에 대한 Booking Interface data 를 생성한다.<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @param String eurFlg
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String createBKGInvoice (ARInvoiceCreationVO invCreVo, String eurFlg, String userId) throws EventException;
	
	/**
	 * INV 에서 발생한 매출채권 정보를 EAI를 통해(FNS012-0001) ERP AR로 전송다.
	 * 한 Session에서 다수 I/F NO발생시 를 배열로 받아 한번에 처리해야 함.<br>
	 * 
	 * @param List<InvArIfNoVO> ifNos
	 * @param String flag
	 * @exception EventException
	 */
	public void interfaceARInvoiceToERPAR(List<InvArIfNoVO> ifNos, String flag) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Bookingarcreation 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @param String arIfNo
	 * @param String userId
	 * @return InvArMnVO
	 * @exception EventException
	 */
	public InvArMnVO modifyMiscellaneousARInvoice(ARInvoiceCreationVO invCreVo, String arIfNo, String userId) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Ex.Rate Update by Date or VVD의 환율적용대상 data 를 Main 테이블 Update<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param ExrateMainVO exrateMainVO
	 * @exception EventException
	 */
	public void modifyVIEInvoiceExrateMain(ExrateMainVO exrateMainVO) throws EventException;
	
	/**
	 * 특정 Interface Data 에 대한 Booking Interface data 를 생성하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobResultCreateBKGInvoice(String key) throws EventException ;
	
	/**
	 * INV_AR_CHG table 저장<br>
	 * 
	 * @param List<InvArChgVO> invChges
	 * @exception DAOException
	 */
	public void addOtherInvCharge(List<com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArChgVO> invChges ) throws EventException;
	
	/**
	 * INV_AR_MN table 에 저장 <br>
	 * 
	 * @param InvArMnVO invMain
	 * @exception DAOException
	 */
	public void addOtherInvMain(com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArMnVO invMain ) throws EventException;
	
	/**
	 * INV_AR_AMT table 저장 <br>
	 * 
	 * @param String arIfNo
	 * @param String svrId
	 * @param InvArMnVO invArMnVo
	 * @param InvArAmtVO invArAmtVo
	 * @exception DAOException
	 */
	public void addOtherInvAmount(String arIfNo, String svrId, com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArMnVO invArMnVo, com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArAmtVO invArAmtVo) throws EventException;
	
    /**
     * INV_AR_CNTR table 에 저장 <br>
     * 
     * @param List<InvArCntrVO> invCntrs
     * @exception DAOException
     */
    public void addOtherInvContainer(List<com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArCntrVO> invCntrs) throws EventException;
	
	/**
	 * MDM_CURRENCY 테이블에서 소숫점 자리수 select<br>
	 * 
	 * @param String currCd
	 * @return int
	 * @exception EventException
	 */
	public int searchCurrencyPoint(String currCd) throws EventException;
	
	/**
     * INV_AR_CHG 테이블 UPDATE 저장한다. <br>
     * 
     * @author Dong Hoon Han
     * @param InvIssVO invIssVO
     * @exception EventException
     */
    public void modifyInvoiceCharge(InvIssVO invIssVO) throws EventException;
    
    /**
     * INV_AR_MN 테이블 UPDATE 저장한다. <br>
     * 
     * @author Dong Hoon Han
     * @param InvIssVO invIssVO
     * @exception EventException
     */
    public void modifyInvoiceMain(InvIssVO invIssVO) throws EventException;
    
    /**
     * INV_AR_MN, INV_AR_CHG에 Invoice 발행여부를 반영한다.하고  ERP 전송함.
     * 
     * @param invNo
     * @param ifNo
     * @param userId
     * @throws EventException
     */
    public void modifyOtherRevIssueFlag (String invNo, String ifNo, String userId) throws EventException;
    
    /**
	 * IINV_AR_MN 테이블에 AP_AR_OFFST_NO Update<br>
	 * 
	 * @param String arIfNo
	 * @param String apArOffstNo
	 * @exception DAOException
	 */
    public void modifyArOffstNo(String arIfNo, String apArOffstNo) throws EventException; 
    
    /**
	 * FNS_INV_0094 Invoice Customer Change BackEndJob 처리
	 * 
	 * @author Choi Do Soon
	 * @param DueDateInputVO[] dueDateInputVOs
	 * @param InvoiceCustomerChangeVO invoiceCustomerChangeVO
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String createCustomerChangeInvoiceList(DueDateInputVO[] dueDateInputVOs,InvoiceCustomerChangeVO invoiceCustomerChangeVO,String userId) throws EventException ;
	
	/**
	 * FNS_INV_0094 Invoice Customer Change BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return List<ExRateCountVO>
	 * @exception EventException
	 */
	public List<ExRateCountVO> getBackEndJobResutCreateCustomerChangeInvoiceList(String key) throws EventException ;
	
	/**
     *  I/F No 에 의거 “Reverse Charge” Mark 를 수정
     * 
     * @param List<MarkingReverseChargeVO> markingReverseChargeVOs
     * @param userId
     * @throws EventException
     */
    public void modifyMarkingReverseChargeByIfNo (List<MarkingReverseChargeVO> markingReverseChargeVOs, String userId) throws EventException;
       
    
	/**
	 * Validation 이벤트 처리<br>
	 * Credit, GL, 환율등 필수정보 조회<br>
	 * 
	 * @param ChinaVATInvoiceCreationVO[] chinaVATInvCreVOs
	 * @return List<ChinaVATInvoiceCreationVO>
	 * @exception EventException
	 */ 

    public List<ChinaVATInvoiceCreationVO> searchChinaVATMiscellaneousARInvoiceData(ChinaVATInvoiceCreationVO[] chinaVATInvCreVOs) throws EventException;
    
	/**
	 * 멀티 이벤트 처리<br>
	 * In화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param ChinaVATInvoiceCreationVO[] chinaVATInvCreVOs
	 * @return List<InvArIfNoVO>
	 * @exception EventException
	 */
  	public List<InvArIfNoVO> createChinaVATMiscellaneousARInvoice(ChinaVATInvoiceCreationVO[] chinaVATInvCreVOs) throws EventException;
  	
	/**
	 * Batch(FNS_INV_B003)에서 호출<br>
	 * WHF 금액 INV와 BKG 비교<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
  	public String searchWhfDiffCheck(String bkgNo) throws EventException;
    
  	/**
     * No INDIA 지역 Taxable charge 정보 update 한다. <br>
     * 
     * @param InvoiceIssueSndToErpVO invoiceIssueSndToErpVO
     * @param InvIssVO invIssVO
     * @exception EventException
     */
    public void modifyNoINDTaxableChg(InvoiceIssueSndToErpVO invoiceIssueSndToErpVO, InvIssVO invIssVO) throws EventException;
}