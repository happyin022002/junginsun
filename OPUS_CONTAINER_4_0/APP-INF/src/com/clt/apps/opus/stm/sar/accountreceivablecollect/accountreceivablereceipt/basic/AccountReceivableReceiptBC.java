/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : AccountReceivableReceiptBC.java
 *@FileTitle : AccountReceivableReceiptBC
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
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.basic;

import java.util.List;

import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyDetailVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyHeaderVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyListCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.RCTViewAccountingListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptForAPInterfaceVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByBankConditionVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByBankDateVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByBankVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByChequeCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByChequeVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByDetailCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByDetailVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptMainVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptUserListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptUserListConditionVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.UnapplyReceiptCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.UnapplyReceiptListVO;
import com.clt.framework.core.layer.event.EventException;
	
/**
 * AccountReceivableReceiptBC Business Logic ServiceCommand 
 * - Handling AccountReceivableReceiptBC Business transaction.
 * 
 * @author 
 * @see AccountReceivableReceiptBCImpl
 * @since J2EE 1.6
 */ 
public interface AccountReceivableReceiptBC {
	
    /**
     * Unsettled Summary 에 존재하는 월별 미결 내역 조회<br>
     * 
     * @author 
     * @category STM_SAR_014
     * @category searchReceiptUserList
     * @param ReceiptUserListConditionVO condVO   
     * @return List<ReceiptUserListVO>
     * @throws EventException
     */    
    public List<ReceiptUserListVO> searchReceiptUserList( ReceiptUserListConditionVO condVO) throws EventException ;	
    
    /**
   	 * Search OTS Header for Apply<br> 
   	 * 
   	 * @param ApplyListCondVO applyListCondVO
   	 * @return List<ApplyHeaderVO>
   	 * @exception EventException
   	 */
   	public List<ApplyHeaderVO> searchOTSHeaderForApply(ApplyListCondVO applyListCondVO) throws EventException;
   	
   	/**
   	 * Search OTS Detail for Apply<br> 
   	 * 
   	 * @param ApplyListCondVO applyListCondVO
   	 * @return List<ApplyDetailVO>
   	 * @exception EventException
   	 */
   	public List<ApplyDetailVO> searchOTSChargeForApply(ApplyListCondVO applyListCondVO) throws EventException;
	
	/**
	 * Search Unapply Receipt List<br> 
	 * 
	 * @param UnapplyReceiptCondVO unapplyReceiptCondVO
	 * @return List<UnapplyReceiptListVO>
	 * @exception EventException
	 */
	public List<UnapplyReceiptListVO> searchUnapplyReceiptList(UnapplyReceiptCondVO unapplyReceiptCondVO) throws EventException;
	
	/**
	 * Search Receipt Main<br> 
	 * 
	 * @param String rctOfcCd
	 * @param String rctNo
	 * @return ReceiptMainVO
	 * @exception EventException
	 */
	public ReceiptMainVO searchReceiptMain(String rctOfcCd, String rctNo) throws EventException;
	
	/**
	 * Search Apply Header<br> 
	 * 
	 * @param String rctOfcCd
	 * @param String rctNo
	 * @return List<ApplyHeaderVO>
	 * @exception EventException
	 */
	public List<ApplyHeaderVO> searchApplyHeader(String rctOfcCd, String rctNo) throws EventException;
	
	/**
	 * Search Apply Detail<br> 
	 * 
	 * @param String rctOfcCd
	 * @param String rctNo
	 * @return List<ApplyDetailVO>
	 * @exception EventException
	 */
	public List<ApplyDetailVO> searchApplyDetail(String rctOfcCd, String rctNo) throws EventException;
	
	/**
	 * Create Receipt Info<br> 
	 * 
	 * @param ReceiptMainVO receiptMainVO
	 * @param ApplyHeaderVO[] applyHeaderVOs
	 * @param ApplyDetailVO[] applyDetailVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void createReceiptApply(ReceiptMainVO receiptMainVO, ApplyHeaderVO[] applyHeaderVOs, ApplyDetailVO[] applyDetailVOs, String userId) throws EventException;
		
	/**
	 * Reverse Apply Header<br> 
	 * 
	 * @param ReceiptMainVO receiptMainVO
	 * @param ApplyHeaderVO[] applyHeaderVOs
	 * @param ApplyDetailVO[] applyDetailVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyReverseApplyHeader(ReceiptMainVO receiptMainVO, ApplyHeaderVO[] applyHeaderVOs, ApplyDetailVO[] applyDetailVOs, String userId) throws EventException;
	
	/**
	 * Cancel Receipt<br> 
	 * 
	 * @param ReceiptMainVO receiptMainVO
	 * @param ApplyHeaderVO[] applyHeaderVOs
	 * @param ApplyDetailVO[] applyDetailVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyReceiptCancel(ReceiptMainVO receiptMainVO, ApplyHeaderVO[] applyHeaderVOs, ApplyDetailVO[] applyDetailVOs, String userId) throws EventException;

	/**
     * searchReceiptListByBankDate <br>
     * 
     * @author 		SHIN
     * @category 	STM_SAR_2004
     * @category 	searchReceiptListByBankDate
     * @param 		ReceiptListByBankConditionVO condVO 
     * @return		List<ReceiptListByBankDateVO>
     * @throws 		EventException
     */    
    public List<ReceiptListByBankDateVO> searchReceiptListByBankDate( ReceiptListByBankConditionVO condVO) throws EventException ;    

    /**
     * searchReceiptListByBank <br>
     * 
     * @author 		SHIN
     * @category 	STM_SAR_2004
     * @category 	searchReceiptListByBank
     * @param 		ReceiptListByBankConditionVO condVO   
     * @return		List<ReceiptListByBankVO>
     * @throws 		EventException
     */    
    public List<ReceiptListByBankVO> searchReceiptListByBank( ReceiptListByBankConditionVO condVO) throws EventException ;

    /**
     * searchReceiptListByCheque <br>
     * 
     * @author 		SHIN
     * @category 	STM_SAR_2003
     * @category 	searchReceiptListByCheque
     * @param 		ReceiptListByChequeCondVO condVO   
     * @return		List<ReceiptListByChequeVO>
     * @throws 		EventException
     */    
    public List<ReceiptListByChequeVO> searchReceiptListByCheque( ReceiptListByChequeCondVO condVO) throws EventException ;
        
    
    /**
     * searchReceiptListByDetail <br>
     * 
     * @author 		yhha
     * @category 	STM_SAR_2002
     * @category	searchReceiptListByDetail
     * @param 		ReceiptListByDetailCondVO receiptListByDetailCondVO     
     * @return		List<ReceiptListByDetailVO>
     * @throws 		EventException
     */  
    public List<ReceiptListByDetailVO> searchReceiptListByDetail( ReceiptListByDetailCondVO receiptListByDetailCondVO) throws EventException;   
    
    /**
	 * Search refund info for AP interface<br> 
	 * 
	 * @param ReceiptMainVO receiptMainVO
	 * @param ApplyHeaderVO[] applyHeaderVOs
	 * @param String usrId
	 * @return List<ReceiptForAPInterfaceVO>
	 * @exception EventException
	 */
	public List<ReceiptForAPInterfaceVO> searchReceiptForAPInterface(ReceiptMainVO receiptMainVO, ApplyHeaderVO[] applyHeaderVOs, String usrId) throws EventException;
	
	/**
	 * Update AP interface status to Apply Detail info<br> 
	 * 
	 * @param List<ReceiptForAPInterfaceVO> receiptForAPInterfaceVOs
	 * @param String saveKindCd
	 * @param String usrId
	 * @exception EventException
	 */
	public void modifyAPInterfaceStatus(List<ReceiptForAPInterfaceVO> receiptForAPInterfaceVOs, String saveKindCd, String usrId) throws EventException;
	
	/**
	 * Search open ASA list<br> 
	 * 
	 * @param String agnCd
	 * @param String rctNo
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchOpenASAList(String agnCd, String rctNo) throws EventException;
	
	
    /**
     * Search Receipts view accounting
     * @author jinyoonoh 2014. 7. 16.
     * @param RCTViewAccountingListVO vo
     * @return List<RCTViewAccountingListVO>
     * @throws EventException
     */
    public List<RCTViewAccountingListVO> searchRCTViewAccountingList(RCTViewAccountingListVO vo) throws EventException;	
    
    /**
	 * Search OTS Header from Temp<br> 
	 * 
	 * @param String otsRctTmpSeq
	 * @return List<ApplyHeaderVO>
	 * @exception EventException
	 */
	public List<ApplyHeaderVO> searchOutstandingReceiptHdrTemp(String otsRctTmpSeq) throws EventException;
	
	/**
	 * Search OTS Detail from Temp<br> 
	 * 
	 * @param String otsRctTmpSeq
	 * @return List<ApplyDetailVO>
	 * @exception EventException
	 */
	public List<ApplyDetailVO> searchOutstandingReceiptDtlTemp(String otsRctTmpSeq) throws EventException;
	
	/**
	 * Search Apply Total Amount from Temp<br> 
	 * 
	 * @param String otsRctTmpSeq
	 * @return String
	 * @exception EventException
	 */
	public String searchOTSTempTotalAmount(String otsRctTmpSeq) throws EventException;
	
	/**
	 * manageReceipt process
	 * 
	 * @author SYPARK
	 * @param ReceiptMainVO receiptMainVO
	 * @param ApplyHeaderVO[] applyHeaderVOs
	 * @param ApplyDetailVO[] applyDetailVOs
	 * @param String lginUsrId
	 * @param String lginOfcCd
	 * @return String
	 * @exception EventException
	 */
	public String manageReceipt(ReceiptMainVO receiptMainVO, ApplyHeaderVO[] applyHeaderVOs, ApplyDetailVO[] applyDetailVOs, String lginUsrId, String lginOfcCd) throws EventException;
	
	/**
	 * Rct_no 를 조회하기 위한 BackEndJob의 결과<br>
	 * 
	 * @param String backendjobKey
	 * @return String
	 * @exception EventException
	 */
	public String searchReceiptBackEndJobFile(String backendjobKey) throws EventException;
	
	/**
	 * Search Apply Total Amount<br> 
	 * 
	 * @param String rctOfcCd
	 * @param String rctNo
	 * @return String
	 * @exception EventException
	 */
	public String searchApplyTotalAmount(String rctOfcCd, String rctNo) throws EventException;
}
