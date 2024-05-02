/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualARCreationBC.java
*@FileTitle : Other Revenue Invoice Entry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.basic;

import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARInvoiceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.MRIInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingARVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.RevenueAcctVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ARCustomerVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;

/**
 * AccountReceivableInvoiceCreation Business Logic Basic Command implementation<br>
 * - AccountReceivableInvoiceCreation logic process<br>
 *
 * @author saeil kim
 * @see FNS_INV_0022EventResponse,ManualARCreationBC
 * @since J2EE 1.4
 */
public interface ManualARCreationBC {

	/**
	 * Miscellaneous Revenue Invoice Entry Rev. Type screen retrieve event process<br>
	 * 
	 * @param String svrId
	 * @param String rhqCd
	 * @param String ofcCd
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchOfficeRevenueSourceList(String svrId, String rhqCd, String ofcCd) throws EventException;

	/**
	 * Miscellaneous Revenue Invoice Entry Rev. Type screen retrieve event process<br>
	 * 
	 * @param String svrId
	 * @param String ofcCd
	 * @param String blNo
	 * @param String locCd
	 * @return List<BKGInvoiceVO>
	 * @exception EventException
	 */
	public List<BKGInvoiceVO> searchBKGMaxInterface(String svrId, String ofcCd, String blNo, String locCd) throws EventException;
	
	/**
	 * Miscellaneous Revenue Invoice Entry Rev. Type screen retrieve event process<br>
	 * 
	 * @param MRIInputVO mirInputVo
	 * @return List<BKGInvoiceVO>
	 * @exception EventException
	 */
	public List<BKGInvoiceVO> searchBKGNewInvoice(MRIInputVO mirInputVo) throws EventException;	

	/**
	 * ManualARCreation screen retrieve event process<br>
	 * 
	 * @param String vsl
	 * @param String voy
	 * @param String dep
	 * @param String port
	 * @param String scp
	 * @exception EventException
	 */
	public void checkMiscellaneousAR(String vsl, String voy, String dep, String port, String scp) throws EventException;
	
	/**
	 * Retrieve event process<br>
	 *  Revenue Account code information's list retrieve<br>
	 * 
	 * @param  String glEffDt
	 * @return List<RevenueAcctVO>
	 * @exception EventException
	 */
	public List<RevenueAcctVO> searchRevenueAcctCdList(String glEffDt) throws EventException;
	
	
	/**
	 * Retrieve event process<br>
	 *  Revenue Account code information's list retrieve<br>
	 * 
	 * @param  String glEffDt
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchRevenueAcctMaxEndDate(String glEffDt) throws EventException;	
	
	/**
	 * Retrieve event process<br>
	 * searchDefaultDRRevAcct<br>
	 * 
	 * @param  String glEffDt
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchDefaultDRRevAcct(String glEffDt) throws EventException;	
	
	
	/**
	 * Closing's check<br>
	 * 
	 * @param String ofc
	 * @param String effDt
	 * @param String pgmGubn
	 * @return String
	 * @exception DAOException
	 */
	public String searchClosingStatus (String ofc, String effDt, String pgmGubn) throws EventException;
	

	/**
	 * B/L No increment.<br>
	 * 
	 * @param String ofcCd
	 * @param String userId
	 * @return String
	 * @exception DAOException
	 */
	public String searchAutoBLNo (String ofcCd, String userId) throws EventException;	
	
	/**
	 * Retrieve event process<br>
	 * Receivables information retrieve<br>
	 * 
	 * @param NonShippingInputVO mthVo
	 * @return List<NonShippingListVO>
	 * @exception EventException
	 */	
	public List<NonShippingListVO> searchNonShippingARList (NonShippingInputVO mthVo ) throws EventException;
	
	
	/**
	 * Document number retrieve<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchSlipNo (String ofcCd) throws EventException;
	
	/**
	 * Input I/F No's receivables information retrieve.<br>
	 * 
	 * @author JungJin Park
	 * @param String ifNo
	 * @return NonShippingARVO
	 * @exception DAOException
	 */
	public NonShippingARVO searchNonShippingARByIFNo (String ifNo) throws EventException;
	 
	/**
	 * Retrieve event process<br>
	 * Customer information retrieve<br>
	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @return List<ARCustomerVO>
	 * @exception EventException
	 */
	public List<ARCustomerVO> searchBLCustomer (String ofcCd, String blNo) throws EventException;
	
	/**
	 * Interface retrieve event process<br>
	 * FnsInv0071Event event list retrieve event process<br>
	 * 
	 * @param String arIfNo
	 * @return ARInvoiceCreationVO
	 * @exception EventException
	 */	
	public ARInvoiceCreationVO searchMiscellaneousARByIFNo (String arIfNo) throws EventException;
	
	/**
	 * INV_AR_MRI_IF_NO table MRI_MAX_SEQ retrieve. <br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchMRIInterfaceNo(String ofcCd) throws EventException;
	
	/**
	 * INV_AR_MRI_IF_NO table MRI_MAX_SEQ insert <br>
	 * 
	 * @param String ofcCd
	 * @param String userId
	 * @exception DAOException
	 */
	public void addMRIInterfaceNo(String ofcCd, String userId) throws EventException;
	
	/**
	 * INV_AR_MRI_IF_NO table MRI_MAX_SEQ update <br>
	 * 
	 * @param String ofcCd
	 * @param String mriMaxSeq
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyMRIInterfaceNo(String ofcCd, String mriMaxSeq, String userId) throws EventException;
	
	/**
	 * Local Time retrieve<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalTime(String ofcCd) throws EventException;	
	
	/**
	 * office block charge retrieve<br>
	 * 
	 * @param String chgCd
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchBlckChg(String chgCd, String ofcCd) throws EventException;	
	
	/**
	 * Retrieve event process<br>
	 * Checking port<br>
	 * 
	 * @param String port
	 * @exception EventException
	 */
	public void checkPort(String port) throws EventException;
	
	/**
	 * VLCBB MIC in case get IVA rate by input IFNo<br>
	 * 
	 * @param String mstIfNo
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchIvaRateMstIFNo(String mstIfNo, String ofcCd) throws EventException;
	
	/**
	 * [FNS_INV_0071-01] 입력된 B/L No.이 Invoice Main 과 Booking Main 테이블에 존재하는지 체크한다.<br>
	 * 
	 * @param String bkgNo
	 * @return String (Y/N, Y:존재, N:존재하지않음)
	 * @exception EventException
	 */
	public String searchBlNoCntForMOS (String bkgNo) throws EventException;
	/**
	 * [FNS_INV_0071-01] 입력된 Master Invoice No.가 Invoice Main 의 Original Invoice No.에 존재하는지 체크한다.<br>
	 * 
	 * @param String mstInvNo
	 * @param String arOfcCd
	 * @return String (Y/N, Y:존재, N:존재하지않음)
	 * @exception EventException
	 */
	public String searchMasterInvNo (String mstInvNo, String arOfcCd) throws EventException;
}
