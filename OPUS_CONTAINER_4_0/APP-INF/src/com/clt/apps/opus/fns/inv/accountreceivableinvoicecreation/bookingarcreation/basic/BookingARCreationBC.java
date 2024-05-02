/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BookingARCreationBC.java
 *@FileTitle : Invoice Update by User ID
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 =========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic;

import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCreditInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCreditVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARInvoiceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ActInvCustVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ArOfficeVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CancelInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CustInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CutOffLaneVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExRateCountVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvNewCustVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.OtherRevReturnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.SysClearVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.VvdLanePortVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceSplitVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssueVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgInvTaxIfVO;

/**
 * AccountReceivableInvoiceCreation Business Logic Basic Command implementation<br>
 * - AccountReceivableInvoiceCreation logic process.<br>
 * 
 * @author Han Dong Hoon
 * @see FNS_INV_0026EventResponse,BookingARCreationBC
 * @since J2EE 1.6
 */
public interface BookingARCreationBC {
	
	/**
	 * Multi event process<br>
	 * System clear is receivables information that Invoice sum is 0.<br>
	 * 
	 * @author JungJin Park
	 * @param SysClearVO sysClearVo
	 * @return int
	 * @exception EventException
	 */
	public int modifySysClearList(SysClearVO sysClearVo) throws EventException;
	
	/**
	 * Multi event process<br>
	 * System clear is receivables information that Invoice sum is 0.<br>
	 * 
	 * @author JungJin Park
	 * @param SysClearVO sysClearVo
	 * @return int
	 * @exception EventException
	 */
	public int modifySysClearListByIfNo(SysClearVO sysClearVo) throws EventException;
	
	/**
	 * Multi event process<br>
	 * System clear is receivables information that Invoice sum is 0.<br>
	 * 
	 * @author JungJin Park
	 * @param List<SysClearVO> sysClearVos
	 * @return int
	 * @exception EventException
	 */
	public int modifySysClearListBatch(List<SysClearVO> sysClearVos) throws EventException;

	/**
	 * Multi event process<br>
	 * In screen multi event process.<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @param String userId
	 * @return InvArMnVO
	 * @exception EventException
	 */
	public InvArMnVO createMiscellaneousARInvoice(ARInvoiceCreationVO invCreVo, String userId) throws EventException;

	/**
	 * No Good receivables or good receivables in case and change actual, invoice Customer other items in case update.<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String modifyARInvoice(ARInvoiceCreationVO invCreVo, String userId) throws EventException;

	/**
	 * No Good receivables or good receivables in case and change actual, invoice Customer other items in case cancel item creation.<br>
	 * 
	 * @param CancelInvoiceVO cancelInvoiceVO
	 * @return String
	 * @exception EventException
	 */
	public String createARCancelInvoice(CancelInvoiceVO cancelInvoiceVO) throws EventException;

	/**
	 * Good receivables in case and change actual, invoice customer in case new condition creation.<br>
	 * 
	 * @param InvNewCustVO invNewCustVO
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String createNewCustomerARInvoice(InvNewCustVO invNewCustVO, String userId) throws EventException;

	/**
	 * Multi event process<br>
	 * Receivables information creation.<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @return OtherRevReturnVO
	 * @exception EventException
	 */
	public OtherRevReturnVO createOtherRevenueARInvoice(ARInvoiceCreationVO invCreVo) throws EventException;

	/**
	 * FNS_INV_0017 Invoice Customer Correction by Date, No Good in case changing Customer Code.
	 * 
	 * @param InvNewCustVO invNewCustVO
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String modifyCustomerCode(InvNewCustVO invNewCustVO, String userId) throws EventException;

	/**
	 * FNS_INV_0007,0008,0100,0101 BackEndJob process
	 * 
	 * @author Choi Do Soon
	 * @param ExchangeRateVO[] exchangeRateVOs
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String manageARInvoiceExRateList(ExchangeRateVO[] exchangeRateVOs, String userId) throws EventException;
	
	/**
	 * FNS_INV_0027 rates Update BackEndJob process
	 * 
	 * @author Choi Do Soon
	 * @param List<ExrateInputVO> exrateInputVOs
	 * @param ExrateInputVO exrateInputVO
	 * @param String runOpt
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String modifyExchangeRateList(List<ExrateInputVO> exrateInputVOs,ExrateInputVO exrateInputVO, String runOpt ,String userId) throws EventException;
	
	/**
	 * FNS_INV_0027 rates update result retrieve.<br>
	 * 
	 * @param String key
	 * @return List<ExRateCountVO>
	 * @exception EventException
	 */
	public List<ExRateCountVO> getBackEndJobResutModifyExchangeRateList(String key) throws EventException;
	
	/**
	 * Invoice Issue (Main) event Issue event process<br>
	 * 
	 * @author Jung Hwi Taek
	 * @param String invNo
	 * @param String issFlg
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyIssueFlag(String invNo, String issFlg, String userId) throws EventException;

	/**
	 * Invoice Issue (Main) event Issue event process<br>
	 * 
	 * @author Jung Hwi Taek
	 * @param String ifNo
	 * @param String dueDt
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyDueDate(String ifNo, String dueDt, String userId) throws EventException;

	/**
	 * Invoice Issue (Main) event issue event process<br>
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
	 * ISSUE FLAG , DUE DATE, TEU, FEU, REF NUMBER UPDATE.<br>
	 * 
	 * @param InvIssueVO invIssueVO
	 * @param String otsSmryCd
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyInvoiceIssue(InvIssueVO invIssueVO, String otsSmryCd, String userId) throws EventException;

	/**
	 * TEU, FEU, REF NUMBER UPDATE<br>
	 * 
	 * @param String invNo
	 * @param String otsSmryCd
	 * @param String userId
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void modifyInvoiceReIssue(String invNo, String otsSmryCd, String userId, String ofcCd) throws EventException;
	

	/**
	 * FNS_INV_0027 Valid rates apply.<br>
	 * 
	 * @param ExrateMainVO exrateMainVO
	 * @return String
	 * @exception EventException
	 */
	public String modifyInvoiceExrateMain(ExrateMainVO exrateMainVO) throws EventException;

	/**
	 * Valid rates chg table apply.<br>
	 * 
	 * @author Choi Do Soon
	 * @param ExrateChgVO exrateChgVO
	 * @exception EventException
	 * 
	 */
	public void modifyInvoiceExrateChg(ExrateChgVO exrateChgVO) throws EventException;

	/**
	 * TEU, FEU, REF NUMBER, INV RMK UPDATE.<br>
	 * 
	 * @param InvIssMainVO[] issMainVOs
	 * @param String ofcCd
	 * @param String issueGubn
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyInvoiceIssueEmail(InvIssMainVO[] issMainVOs, String ofcCd, String issueGubn, String userId) throws EventException;

	/**
	 * Max Seq INV_AR_BKG_IF_NO update.<br>
	 * 
	 * @author Choi Do Soon
	 * @param String ofcCd
	 * @param String maxSeq
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyNewInterfaceNo(String ofcCd, String maxSeq, String userId) throws EventException;

	/**
	 * INV_AR_MN table Update<br>
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
	 * INV_AR_MN table InvNo Update.<br>
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
	 * FNS_INV_0018 invoice Split Before Invoice Issue Interface Data Cancel Interface data creation.<br>
	 * 
	 * @param CancelInvoiceVO cancelInvoiceVO
	 * @return String
	 * @exception EventException
	 */
	public String createARCancelSplitInvoice(CancelInvoiceVO cancelInvoiceVO) throws EventException;
	
	/**
	 * Invoice Issue Interface Data Cancel Interface data creation.<br>
	 * 
	 * @param CancelInvoiceVO cancelInvoiceVO
	 * @return String
	 * @exception EventException
	 */
	public String createCancelIssueARInvoice(CancelInvoiceVO cancelInvoiceVO) throws EventException;
	
	/**
	 * Invoice Issue Interface Data New Interface data creation.<br>
	 * 
	 * @param CancelInvoiceVO cancelInvoiceVO
	 * @return String
	 * @exception EventException
	 */
	public String createNewIssueARInvoice(CancelInvoiceVO cancelInvoiceVO) throws EventException;
	
	/**
	 * Invoice Issue Interface Data New Interface data creation.<br>
	 * 
	 * @param CancelInvoiceVO cancelInvoiceVO
	 * @return String
	 * @exception EventException
	 */
	public String createNewMIssueARInvoice(CancelInvoiceVO cancelInvoiceVO) throws EventException;

	/**
	 * FNS_INV_0018 invoice Split Before Invoice Issue Invoice Split information creation.<br>
	 * 
	 * @param ARInvoiceSplitVO invSplitVo
	 * @return String
	 * @exception EventException
	 */
	public String createSplitInvoice(ARInvoiceSplitVO invSplitVo) throws EventException;
	
	/**
	 * Booking, Wharfage issue receivables information Interface BackEndJob call.<br>
	 * 
	 * @param ARBkgInterfaceCreationVO bkgIfVo
	 * @return String
	 * @exception EventException
	 */
	public String interfaceBKGARInvoiceToINV(ARBkgInterfaceCreationVO bkgIfVo) throws EventException;
	
	/**
	 * Kor Wharfage issue receivables information interface  <br>
	 * 
	 * @param String vvdCd
	 * @param String whfBndCd
	 * @param String portCd
	 * @param String userId
	 * @param String whfDeclCxlFlg
	 * @exception EventException
	 */
	public void interfaceWHFARInvoiceToINV( String vvdCd, String whfBndCd, String portCd, String userId , String whfDeclCxlFlg) throws EventException;
	
	/**
	 * Booking, Wharfage issue receivables information Interface BackEndJob List call.<br>
	 * 
	 * @param List<ARBkgInterfaceCreationVO> bkgIfVos
	 * @return String
	 * @exception EventException
	 */
	public String interfaceBKGARInvoiceToINV(List<ARBkgInterfaceCreationVO> bkgIfVos) throws EventException;
	
	/**
	 * Booking, Wharfage issue receivables information interface, ERP AR attribute creation.<br>
	 * 
	 * @param ARBkgInterfaceCreationVO bkgIfVo
	 * @return List<InvArIfNoVO>
	 * @exception EventException
	 */
	public List<InvArIfNoVO> executeInterfaceBKGARInvoiceToINV(ARBkgInterfaceCreationVO bkgIfVo) throws EventException;
	
	/**
	 * Cancel Interface data creation.<br>
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
	 * Cancel Interface data creation.<br>
	 * 
	 * @param String maxIfNo
	 * @param String whfFlg
	 * @param String userId
	 * @param String vvdTrnsFlg
	 * @return String
	 * @exception EventException
	 */
	public String createMaxIFCancelForInv (String maxIfNo, String whfFlg, String userId, String vvdTrnsFlg) throws EventException;

	
	/**
	 * New I/F receivables data's VVD, Lane, Scope, Port, S/A Date, <br>
	 * Sailing Date, Revenue VVD, Revenue Lane information retrieve<br>
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
	 * A/R Office information retrieve.<br>
	 * 
	 * @param CutOffLaneVO cutOffLaneVO
	 * @return ArOfficeVO
	 * @exception EventException
	 */
	public ArOfficeVO searchAROfficeList(CutOffLaneVO cutOffLaneVO) throws EventException;
	
	/**
	 * Actual / Invoice Customer Code retrieve<br>
	 * 
	 * @param CustInputVO custInputVO 
	 * @return ActInvCustVO
	 * @exception EventException
	 */
	public ActInvCustVO searchCustomerCode(CustInputVO custInputVO) throws EventException;
	
	/**
	 * Actual Customer's Credit Flag, Credit Term, Due Date information retrieve.<br>
	 * 
	 * @param ARCreditInputVO arCrdtVo
	 * @return ARCreditVO
	 * @exception EventException
	 */
	public ARCreditVO searchARCredit(ARCreditInputVO arCrdtVo) throws EventException;
	
	/**
	 * Booking Interface data creation.<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String createBKGInvoice (ARInvoiceCreationVO invCreVo, String userId) throws EventException;

	/**
	 * Multi event process<br>
	 * In screen multi event process<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @param String arIfNo
	 * @param String userId
	 * @return InvArMnVO
	 * @exception EventException
	 */
	public InvArMnVO modifyMiscellaneousARInvoice(ARInvoiceCreationVO invCreVo, String arIfNo, String userId) throws EventException;
	
	/**
	 * Retrieve event process<br>
	 * Ex.Rate Update by Date or VVD data Main table Update<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param ExrateMainVO exrateMainVO
	 * @exception EventException
	 */
	public void modifyVIEInvoiceExrateMain(ExrateMainVO exrateMainVO) throws EventException;
	
	/**
	 * Retrieve data by BackEndJob LoadFile function<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobResultCreateBKGInvoice(String key) throws EventException;
	
	/**
	 * INV_AR_CHG table save<br>
	 * 
	 * @param List<InvArChgVO> invChges
	 * @exception EventException
	 */
	public void addOtherInvCharge(List<com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArChgVO> invChges ) throws EventException;
	
	/**
	 * INV_AR_MN table save <br>
	 * 
	 * @param InvArMnVO invMain
	 * @exception EventException
	 */
	public void addOtherInvMain(com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArMnVO invMain ) throws EventException;
	
	/**
	 * INV_AR_AMT table save <br>
	 * 
	 * @param String arIfNo
	 * @param String svrId
	 * @param InvArMnVO invArMnVo
	 * @param InvArAmtVO invArAmtVo
	 * @exception EventException
	 */
	public void addOtherInvAmount(String arIfNo, String svrId, com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArMnVO invArMnVo, com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArAmtVO invArAmtVo) throws EventException;
	
    /**
     * INV_AR_CNTR table save <br>
     * 
     * @param List<InvArCntrVO> invCntrs
     * @exception EventException
     */
    public void addOtherInvContainer(List<com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArCntrVO> invCntrs) throws EventException;
	
	/**
	 * MDM_CURRENCY table float point select<br>
	 * 
	 * @param String currCd
	 * @return int
	 * @exception EventException
	 */
	public int searchCurrencyPoint(String currCd) throws EventException;
	
	/**
     * INV_AR_CHG table UPDATE. <br>
     * 
     * @author Dong Hoon Han
     * @param InvIssVO invIssVO
     * @exception EventException
     */
    public void modifyInvoiceCharge(InvIssVO invIssVO) throws EventException;
    
    /**
     * INV_AR_MN table UPDATE. <br>
     * 
     * @author Dong Hoon Han
     * @param InvIssVO invIssVO
     * @exception EventException
     */
    public void modifyInvoiceMain(InvIssVO invIssVO) throws EventException;
    
    /**
     * INV_AR_MN, INV_AR_CHG Invoice update
     * 
     * @param String invNo
     * @param String ifNo
     * @param String userId
     * @throws EventException
     */
    public void modifyOtherRevIssueFlag (String invNo, String ifNo, String userId) throws EventException;
    
    /**
	 * IINV_AR_MN table AP_AR_OFFST_NO Update<br>
	 * 
	 * @param String arIfNo
	 * @param String apArOffstNo
	 * @exception DAOException
	 */
    public void modifyArOffstNo(String arIfNo, String apArOffstNo) throws EventException;
    
    /**
	 * FNS_INV_0094 Invoice Customer Change BackEndJob process
	 * 
	 * @author Choi Do Soon
	 * @param DueDateInputVO[] dueDateInputVOs
	 * @param InvoiceCustomerChangeVO invoiceCustomerChangeVO
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String createCustomerChangeInvoiceList(DueDateInputVO[] dueDateInputVOs,InvoiceCustomerChangeVO invoiceCustomerChangeVO ,String userId) throws EventException;
	
	/**
	 * FNS_INV_0094 Invoice Customer Change BackEndJob LoadFile<br>
	 * 
	 * @param String key
	 * @return List<ExRateCountVO>
	 * @exception EventException
	 */
	public List<ExRateCountVO> getBackEndJobResutCreateCustomerChangeInvoiceList(String key) throws EventException;
	
	/**
	 * Sys clear Update<br>
	 * 
	 * @param String ifNo
	 * @param String userId
	 * @exception EventException
	 */
	public void modifySysClear(String ifNo, String userId) throws EventException;
	
	/**
	 * Modify BL Exchange Rate<br>
	 * 
	 * @param ExchangeRateVO[] exRateVOs
	 * @param String userId
	 * @return List<BkgInvTaxIfVO>
	 * @exception EventException
	 * 
	 */
	public List<BkgInvTaxIfVO> modifyBLExchangeRate(ExchangeRateVO[] exRateVOs, String userId) throws EventException;
	
	
	/**
	 * Search Exchange Rate Temp <br>
	 * 
	 * @param String tmpSeq
	 * @return List<ExchangeRateVO>
	 * @exception EventException
	 */
	public List<ExchangeRateVO> searchExchangeRateTempList(String tmpSeq) throws EventException;	
	
	/**
	 * Remove Exchange Rate Temp<br>
	 * 
	 * @param String tmpSeq
	 * @exception EventException
	 */
	public void removeExchangeRateTempSeq(String tmpSeq) throws EventException;	
	
	
	/**
	 * FNS_INV_0027 createScoBatHisByExRate process
	 * 
	 * @author KIMOKRYE
	 * @param List<ExrateInputVO> exrateInputVOs
	 * @param ExrateInputVO exrateInputVO
	 * @param String runOpt
	 * @param String ofcCd
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String createScoBatHisByExRate(List<ExrateInputVO> exrateInputVOs,ExrateInputVO exrateInputVO, String runOpt , String ofcCd, String userId) throws EventException;
	
	/**
	 * FNS_INV_0027 callModifyExchangeRateListBat process
	 * 
	 * @author KIMOKRYE
	 * @param String batSeq
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String callModifyExchangeRateListBat(String batSeq, String userId) throws EventException;	
	
	/**
	 * FNS_INV_0027 readyModifyExchangeRateListByBatSeq process
	 * 
	 * @author KIMOKRYE
	 * @param String batSeq
	 * @return String
	 * @exception EventException
	 */
	public String readyModifyExchangeRateListByBatSeq(String batSeq) throws EventException;	
	
    
	/**
	 * FNS_INV_0027
	 * 
	 * check batch status
	 * R: Running
	 * S: Start
	 * 
	 * @param pgmNo
	 * @return
	 * @throws EventException
	 */
	public String searchExchangeRateBatStsCd(String pgmNo) throws EventException;	

	/**
	 * FNS_INV_0027
	 * batch 가 running 중일 때, E 로 update
	 * 
	 * @param batSeq
	 * @param account
	 * @throws EventException
	 */
	public void manageCancelExchangeRateBat(String batSeq, SignOnUserAccount account) throws EventException;	
	
}