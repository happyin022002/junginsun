/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountReceivableOutstandingBC.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion : 1.0
 * 2014.03.03 authorName
 * 1.0 Creation
 * --------------------------------------------------------
 * History
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic;

import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROustandingbySADateVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingChgVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingHistVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.ApplyOutstandingCondVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.ApplyOutstandingListVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSAgingBaseVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSAgingListVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSViewAccountingListVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingDtlByBlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingHdrByBlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingHisByDateVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingInterfaceVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingSumByBlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterByEmailFaxVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterHisVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterSumVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.SarOtsRctTmpVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * AccountReceivableOutstandingBC Business Logic ServiceCommand - Handling
 * AccountReceivableOutstandingBC Business transaction.
 * 
 * @author
 * @see AccountReceivableOutstandingBCImpl
 * @since J2EE 1.6
 */
public interface AccountReceivableOutstandingBC {

	/**
	 * Create AR Information to Outstanding<br>
	 * 
	 * @param List<InvArIfNoVO> ifNos
	 * @exception EventException
	 */
	public void createOutstandingInfo(List<InvArIfNoVO> ifNos) throws EventException;

	/**
	 * Search OTS for Apply List<br>
	 * 
	 * @param ApplyOutstandingCondVO applyOutstandingCondVO
	 * @param SarOtsRctTmpVO[] sarOtsRctTmpVOs
	 * @param String usrId
	 * @return List<ApplyOutstandingListVO>
	 * @exception EventException
	 */
	public List<ApplyOutstandingListVO> searchApplyOutstandingList(ApplyOutstandingCondVO applyOutstandingCondVO, SarOtsRctTmpVO[] sarOtsRctTmpVOs, String usrId) throws EventException;

	/**
	 * Outstanding Inquiry<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_1002
	 * @category searchOustandingByDate
	 * @param AROustandingbySADateVO aROustandingbySADateVO
	 * @return List<AROustandingbySADateVO>
	 * @throws EventException
	 */
	public List<AROustandingbySADateVO> searchOustandingByDate(AROustandingbySADateVO aROustandingbySADateVO) throws EventException;

	/**
	 * Payment Request Letter<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_1005
	 * @category searchPaymentRequestLetter
	 * @param PaymentRequestLetterVO paymentRequestLetterVO
	 * @return List<PaymentRequestLetterVO>
	 * @throws EventException
	 */
	public List<PaymentRequestLetterVO> searchPaymentRequestLetter(PaymentRequestLetterVO paymentRequestLetterVO) throws EventException;

	/**
	 * Payment Request Letter Sum<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_1005
	 * @category searchPaymentRequestLetter
	 * @param PaymentRequestLetterVO paymentRequestLetterVO
	 * @return List<PaymentRequestLetterSumVO>
	 * @throws EventException
	 */
	public List<PaymentRequestLetterSumVO> searchPaymentRequestLetterSum(PaymentRequestLetterVO paymentRequestLetterVO) throws EventException;

	/**
	 * Payment Request Letter email seq<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_1005
	 * @category searchEmailSeq
	 * @param PaymentRequestLetterVO paymentRequestLetterVO
	 * @return String
	 * @throws EventException
	 */
	public String searchEmailSeq(PaymentRequestLetterVO paymentRequestLetterVO) throws EventException;

	/**
	 * Payment Request Letter customer email fax<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_1005
	 * @category searchEmailFax
	 * @param PaymentRequestLetterVO paymentRequestLetterVO
	 * @return List<PaymentRequestLetterVO>
	 * @throws EventException
	 */
	public List<PaymentRequestLetterVO> searchEmailFax(PaymentRequestLetterVO paymentRequestLetterVO) throws EventException;

	/**
	 * Payment Request Letter<br>
	 * 
	 * @author YJLEE
	 * @category STM_SAR_1005
	 * @category managePaymentRequestLetter
	 * @param PaymentRequestLetterVO[] PaymentRequestLetterVOS
	 * @param SignOnUserAccount account
	 * @return List<PaymentRequestLetterVO>
	 * @throws EventException
	 */
	public List<PaymentRequestLetterVO> managePaymentRequestLetterBasic(PaymentRequestLetterVO[] PaymentRequestLetterVOS, SignOnUserAccount account) throws EventException;

	/**
	 * Outstanding Inquiry by B/L(Invoice) Header
	 * 
	 * @author jinyoonoh 2014. 4. 22.
	 * @param OutstandingHdrByBlVO outstandingHdrByBlVO
	 * @return List<OutstandingHdrByBlVO>
	 * @throws EventException
	 */
	public List<OutstandingHdrByBlVO> searchOutstandingHdrByBl(OutstandingHdrByBlVO outstandingHdrByBlVO) throws EventException;

	/**
	 * Outstanding Inquiry by B/L(Invoice) Detail
	 * 
	 * @author jinyoonoh 2014. 4. 22.
	 * @param OutstandingDtlByBlVO outstandingDtlByBlVO
	 * @return List<OutstandingDtlByBlVO>
	 * @throws EventException
	 */
	public List<OutstandingDtlByBlVO> searchOutstandingDtlByBl(OutstandingDtlByBlVO outstandingDtlByBlVO) throws EventException;

	/**
	 * Outstanding Inquiry by B/L(Invoice) Summary
	 * 
	 * @author jinyoonoh 2014. 4. 22.
	 * @param OutstandingSumByBlVO outstandingSumByBlVO
	 * @return List<OutstandingSumByBlVO>
	 * @throws EventException
	 */
	public List<OutstandingSumByBlVO> searchOutstandingSumByBl(OutstandingSumByBlVO outstandingSumByBlVO) throws EventException;

	/**
	 * Outstanding Inquiry by B/L(Invoice) History
	 * 
	 * @author jinyoonoh 2014. 4. 22.
	 * @param OutstandingHisByDateVO outstandingHisByDateVO
	 * @return List<OutstandingHisByDateVO>
	 * @throws EventException
	 */
	public List<OutstandingHisByDateVO> searchOutstandingHisByDate(OutstandingHisByDateVO outstandingHisByDateVO) throws EventException;

	/**
	 * Search outstanding aging inquiry
	 * 
	 * @author jinyoonoh 2014. 5. 21.
	 * @param OTSAgingBaseVO paramVO
	 * @return List<OTSAgingListVO>
	 * @throws EventException
	 */
	public List<OTSAgingListVO> searchOTSAgingList(OTSAgingBaseVO paramVO) throws EventException;

	/**
	 * Add to OTS interface<br>
	 * 
	 * @param List<OutstandingInterfaceVO> outstandingInterfaceVOs
	 * @exception EventException
	 */
	public void addOutstandingInterface(List<OutstandingInterfaceVO> outstandingInterfaceVOs) throws EventException;

	/**
	 * Create Outstanding from interface info<br>
	 * 
	 * @param String ifNo
	 * @exception EventException
	 */
	public void createOutstandingByInterface(String ifNo) throws EventException;

	/**
	 * Create Outstanding Account distribution Info<br>
	 * 
	 * @param List<AROutstandingHistVO> arOutstandingHistVOs
	 * @param List<AROutstandingChgVO> arOutstandingChgVOs
	 * @exception EventException
	 */
	public void createOutstandingAccount(List<AROutstandingHistVO> arOutstandingHistVOs, List<AROutstandingChgVO> arOutstandingChgVOs) throws EventException;

	/**
	 * update Outstanding item collection
	 * 
	 * @author jinyoonoh 2014. 7. 4.
	 * @param OutstandingHdrByBlVO paramVO
	 * @throws EventException
	 */
	public void manageItemCollection(OutstandingHdrByBlVO paramVO) throws EventException;

	/**
	 * Search Outstanding view accounting
	 * 
	 * @author jinyoonoh 2014. 7. 16.
	 * @param OTSViewAccountingListVO vo
	 * @return List<OTSViewAccountingListVO>
	 * @throws EventException
	 */
	public List<OTSViewAccountingListVO> searchOTSViewAccountingList(OTSViewAccountingListVO vo) throws EventException;

	/**
	 * Retrieve Payment Request Letter Email fax event
	 * 
	 * @author JBLEE
	 * @param PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO
	 * @return String
	 * @throws EventException
	 */
	public String sendPaymentRequestLetterByFaxEmail(PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO) throws EventException;

	/**
	 * addPaymentRequestLetterHistory
	 * 
	 * @author myoung sin park
	 * @param PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO
	 * @return String
	 * @throws EventException
	 */
	public String addPaymentRequestLetterHisHdr(PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO) throws EventException;

	/**
	 * modifyPaymentRequestLetterHistoryDtl
	 * 
	 * @author myoung sin park
	 * @param String arEmlHisSeq
	 * @param List<PaymentRequestLetterByEmailFaxVO> list
	 * @throws EventException
	 */
	public void modifyPaymentRequestLetterHistoryDtl(String arEmlHisSeq, List<PaymentRequestLetterByEmailFaxVO> list) throws EventException;

	/**
	 * modifyPaymentRequestLetterHistoryHdr
	 * 
	 * @author myoung sin park
	 * @param String arEmlHisSeq
	 * @throws EventException
	 */
	public void modifyPaymentRequestLetterHistoryHdr(String arEmlHisSeq) throws EventException;

	/**
	 * Payment Request Letter<br>
	 * 
	 * @author myoungsin park
	 * @category STM_SAR_1005
	 * @category managePaymentRequestLetterOFC
	 * @param String batSeq
	 * @return
	 * @throws EventException
	 */
	public String managePaymentRequestLetterOFC(String batSeq) throws EventException;

	/**
	 * searchPaymentRequestLetterCustomer<br>
	 * 
	 * @author myoungsin park
	 * @category STM_SAR_1005
	 * @param PaymentRequestLetterVO paymentRequestLetterVO
	 * @return
	 * @throws EventException
	 */
	public List<PaymentRequestLetterVO> searchPaymentRequestLetterCustomer(PaymentRequestLetterVO paymentRequestLetterVO) throws EventException;

	/**
	 * Payment Request Letter<br>
	 * 
	 * @author myoungsin park
	 * @category STM_SAR_1005
	 * @param List<PaymentRequestLetterVO> updateVoList
	 * @throws EventException
	 */
	public void managePaymentRequestLetterEmlSeq(List<PaymentRequestLetterVO> updateVoList) throws EventException;

	/**
	 * Payment Request Letter<br>
	 * 
	 * @author myoungsin park
	 * @category STM_SAR_1009
	 * @param PaymentRequestLetterHisVO paramVO
	 * @return List<PaymentRequestLetterHisVO>
	 * @exception EventException
	 */
	public List<PaymentRequestLetterHisVO> searchPaymentRequestLetterHistory(PaymentRequestLetterHisVO paramVO) throws EventException;

	/**
	 * SCO_BAT_HIS 테이블에 데이타를 생성한다.
	 * 
	 * @author myoungsin park
	 * @param PaymentRequestLetterVO paymentRequestLetterVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createPaymentRequestLetterBat(PaymentRequestLetterVO paymentRequestLetterVO, SignOnUserAccount account) throws EventException;

	/**
	 * Insert/Update SAR OUTSTANDING RECEIPT TEMP
	 * 
	 * @author sung yong park
	 * @param SarOtsRctTmpVO[] sarOtsRctTmpVOs
	 * @param String otsRctTmpSeq
	 * @param String usrId
	 * @throws EventException
	 */
	public void manageOutstandingReceiptTemp(SarOtsRctTmpVO[] sarOtsRctTmpVOs, String otsRctTmpSeq, String usrId) throws EventException;

	/**
	 * delete SAR OUTSTANDING RECEIPT TEMP<br>
	 * 
	 * @author sung yong park
	 * @param String otsRctTmpSeq
	 * @exception EventException
	 */
	public void removeOutstandingReceiptTemp(String otsRctTmpSeq) throws EventException;

	/**
	 * Search Outstanding Receipt Temp Sequence<br>
	 * 
	 * @author sung yong park
	 * @return String
	 * @exception EventException
	 */
	public String searchOutstandingReceiptTempSeq() throws EventException;
	
	/**
	 * copy for Approval<br> 
	 * 
	 * @param List<AROutstandingHistVO> arOutstandingHistVOs
	 * @exception EventException
	 */
	public void copyForASAApproval(List<AROutstandingHistVO> arOutstandingHistVOs) throws EventException;
	
	/**
	 * check batch status
	 * R: Running
	 * S: Start
	 * 
	 * @param pgmNo
	 * @return
	 * @throws EventException
	 */
	public String searchBatStsCdLetterOFC(String pgmNo) throws EventException;	

	/**
	 * batch 가 running 상태일 경우, E로 update
	 * 
	 * @param batSeq
	 * @param account
	 * @throws EventException
	 */
	public void manageCancelBatLetterOFC(String batSeq, SignOnUserAccount account) throws EventException;		
}
