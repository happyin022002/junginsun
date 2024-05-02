/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : AccountReceivableReceiptBCImpl.java
 *@FileTitle : AccountReceivableReceiptBCImpl
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

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.basic.AccountReceivableCollectIFBC;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.basic.AccountReceivableCollectIFBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration.AccountReceivableReceiptDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.APCombinationSeqCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.APInterfaceStatusVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyDetailVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyHeaderVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyListCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.BankAcctCmbSeqVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.LedgerCmbCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.OTSDistributionVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.RCTViewAccountingListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.RctHdrSeqTmpVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.RcvApplSeqTmpVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptAccountCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptAccountVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptDistributionVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptForAPInterfaceVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByBankConditionVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByBankDateVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByBankVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByChequeCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByChequeVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByDetailCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByDetailVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptMainVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptUserListConditionVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptUserListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceivableApplVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.UnapplyReceiptCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.UnapplyReceiptListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration.AccountReceivableCommonDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARExrateVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.CurrencyCodeVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.PayGroupInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.VendorInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration.AccountReceivableOutstandingDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingCheckVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingChgVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingDtlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingHdrVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingHistVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSForApplyAdjustVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration.StatementCommonDBDAO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LookupInfoVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * AccountReceivableReceiptBCImpl Business Logic ServiceCommand 
 * - Handling AccountReceivableReceiptBCImpl Business transaction.
 * 
 * @author 
 * @see AccountReceivableReceiptDBDAO
 * @since J2EE 1.6
 */ 
public class AccountReceivableReceiptBCImpl extends BasicCommandSupport implements AccountReceivableReceiptBC {	

	// Database Access Object
    private transient AccountReceivableReceiptDBDAO dbDao = null;  
    
    /**
	 * AccountReceivableReceiptBCImpl object creation.<br>
	 * AccountReceivableReceiptDBDAO creation.<br>
	 */
    public AccountReceivableReceiptBCImpl()
    {
        dbDao = new AccountReceivableReceiptDBDAO();    
    }

    
    /**
     * Unsettled Summary 에 존재하는 월별 미결 내역 조회<br>
     * 
     * @author JBLEE
     * @category STM_SAP_0340
     * @category searchUnsettledAccountList
     * @param ReceiptUserListConditionVO condVO      
     * @return List<ReceiptUserListVO>
     * @throws EventException
     */  
    public List<ReceiptUserListVO> searchReceiptUserList( ReceiptUserListConditionVO condVO) throws EventException {
    	try {
    		 List<ReceiptUserListVO> returnList = dbDao.searchReceiptUserList(condVO);
   		
    		 return returnList;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
    }    	

    /**
	 * Search OTS Header for Apply<br> 
	 * 
	 * @param ApplyListCondVO applyListCondVO
	 * @return List<ApplyHeaderVO>
	 * @exception EventException
	 */
	public List<ApplyHeaderVO> searchOTSHeaderForApply(ApplyListCondVO applyListCondVO) throws EventException{
		
		try {
			
			List<ApplyHeaderVO> applyHeaderVO = dbDao.searchOTSHeaderForApply(applyListCondVO);
			
			return applyHeaderVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search OTS Detail for Apply<br> 
	 * 
	 * @param ApplyListCondVO applyListCondVO
	 * @return List<ApplyDetailVO>
	 * @exception EventException
	 */
	public List<ApplyDetailVO> searchOTSChargeForApply(ApplyListCondVO applyListCondVO) throws EventException{
		
		try {
			
			List<ApplyDetailVO>	applyDetailVO = dbDao.searchOTSChargeForApply(applyListCondVO);
			
			return applyDetailVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Unapply Receipt List<br> 
	 * 
	 * @param UnapplyReceiptCondVO unapplyReceiptCondVO
	 * @return List<UnapplyReceiptListVO>
	 * @exception EventException
	 */
	public List<UnapplyReceiptListVO> searchUnapplyReceiptList(UnapplyReceiptCondVO unapplyReceiptCondVO) throws EventException{
		
		try {
			
			List<UnapplyReceiptListVO> list = dbDao.searchUnapplyReceiptList(unapplyReceiptCondVO);
			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Receipt Main<br> 
	 * 
	 * @param String rctOfcCd
	 * @param String rctNo
	 * @return ReceiptMainVO
	 * @exception EventException
	 */
	public ReceiptMainVO searchReceiptMain(String rctOfcCd, String rctNo) throws EventException{
		
		try {
			
			ReceiptMainVO receiptMainVO = dbDao.searchReceiptMain(rctOfcCd, rctNo);
			
			return receiptMainVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Apply Header<br> 
	 * 
	 * @param String rctOfcCd
	 * @param String rctNo
	 * @return List<ApplyHeaderVO>
	 * @exception EventException
	 */
	public List<ApplyHeaderVO> searchApplyHeader(String rctOfcCd, String rctNo) throws EventException{
		
		try {
			
			List<ApplyHeaderVO> applyHeaderVO = dbDao.searchApplyHeader(rctOfcCd, rctNo);
			
			return applyHeaderVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Apply Detail<br> 
	 * 
	 * @param String rctOfcCd
	 * @param String rctNo
	 * @return List<ApplyDetailVO>
	 * @exception EventException
	 */
	public List<ApplyDetailVO> searchApplyDetail(String rctOfcCd, String rctNo) throws EventException{
		
		try {
			
			List<ApplyDetailVO> applyDetailVO = dbDao.searchApplyDetail(rctOfcCd, rctNo);
			
			return applyDetailVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Create Receipt Info<br> 
	 * 
	 * @param ReceiptMainVO receiptMainVO
	 * @param ApplyHeaderVO[] applyHeaderVOs
	 * @param ApplyDetailVO[] applyDetailVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void createReceiptApply(ReceiptMainVO receiptMainVO, ApplyHeaderVO[] applyHeaderVOs, ApplyDetailVO[] applyDetailVOs, String userId) throws EventException{
		
		try {
			
			String rctDpsDt = "";
			String rctOfcCd = "";
			String rctGlDt = "";
			String rctSeq = "";
			String rctCxlDt = "";
			String custCntCd = "";
			String custSeq = "";
			String aplyFlg = "";
			String hdrSeq = "";
			String dtlSeq = "";
			String hdrKey = "";
			String dtlKey = "";
			String otsBalAmt = "";
			String modifyFlg = "";
			String balRctAmt = "";
			
			BigDecimal ttlAmt = null;
			BigDecimal rctAmt = null;
			BigDecimal balAmt = null;
			
			AccountReceivableCommonDBDAO comDao = new AccountReceivableCommonDBDAO();
			List<ApplyHeaderVO> addHeaderListVOs = new ArrayList<ApplyHeaderVO>();
			List<ApplyHeaderVO> modifyHeaderListVOs = new ArrayList<ApplyHeaderVO>();
			List<ApplyHeaderVO> headerListVOs = new ArrayList<ApplyHeaderVO>();
			List<ApplyDetailVO> detailListVOs = new ArrayList<ApplyDetailVO>();
			
			receiptMainVO.setRctDt(receiptMainVO.getRctDt().replace("-", ""));
			receiptMainVO.setRctDpsDt(receiptMainVO.getRctDpsDt().replace("-", ""));
			receiptMainVO.setRctAmt(receiptMainVO.getRctAmt().replace(",", ""));
			receiptMainVO.setBankChgAmt(receiptMainVO.getBankChgAmt().replace(",", ""));
			receiptMainVO.setCreUsrId(userId);
			receiptMainVO.setUpdUsrId(userId);
			
			balRctAmt = receiptMainVO.getBalRctAmt();
			
			//set balance receipt amount
			if(receiptMainVO.getTtlAmt().equals("")){
				ttlAmt = new BigDecimal(0);
			} else {
				ttlAmt = new BigDecimal(receiptMainVO.getTtlAmt().replace(",", ""));
			}
			
			rctAmt = new BigDecimal(receiptMainVO.getRctAmt());
			balAmt = rctAmt.subtract(ttlAmt);	
			receiptMainVO.setBalRctAmt(balAmt.toString());
			
			//set receipt status code
			rctCxlDt = receiptMainVO.getRctCxlDt();
			custCntCd = receiptMainVO.getRctCustCntCd();
			custSeq = receiptMainVO.getRctCustSeq();
			
			if(rctCxlDt.equals("")){
				if(custCntCd.equals("") && custSeq.equals("")){
					receiptMainVO.setRctStsCd("UNID");
				} else {
					if(balAmt.compareTo(new BigDecimal(0)) == 0){
						receiptMainVO.setRctStsCd("APP");
					} else {
						receiptMainVO.setRctStsCd("UNAPP");
					}
				}
			} else {
				receiptMainVO.setRctStsCd("CXL");
			}
			
			rctSeq = receiptMainVO.getRctSeq();
			
			if(rctSeq == null || rctSeq.equals("")){
				rctDpsDt = receiptMainVO.getRctDpsDt();
				rctOfcCd = receiptMainVO.getOtsOfcCd();
				
				//check GL Date
				rctGlDt = comDao.searchEffectiveDate(rctDpsDt, rctOfcCd, "26");
				
				if(rctGlDt == null || rctGlDt.equals("") || !rctGlDt.equals(rctDpsDt)){
					throw new EventException(new ErrorHandler("SAR00003",new String[]{"Deposit date"}).getMessage());
				}
				
				//search Receipt Sequence
				rctSeq = dbDao.searchReceiptSeq();
				receiptMainVO.setRctSeq(rctSeq);
				receiptMainVO.setNewRctFlg("Y");
				receiptMainVO.setBfrBalRctAmt(rctAmt.toString());
				
				dbDao.addReceiptMain(receiptMainVO);
			} else {
				receiptMainVO.setBfrBalRctAmt(balRctAmt);
				dbDao.modifyReceiptMain(receiptMainVO);
			}

			if(applyHeaderVOs != null){
				//create apply header
				for(int i = 0; i < applyHeaderVOs.length; i++){
					aplyFlg = applyHeaderVOs[i].getRctAplyFlg();
					hdrKey = applyHeaderVOs[i].getRctAplyHdrSeq();
					
					if(aplyFlg.equals("N")){
						hdrSeq = dbDao.searchHeaderSeq();	
					} else {
						hdrSeq = hdrKey;
					}
					
					BigDecimal hdrAplyAmt = new BigDecimal(0);
					modifyFlg = "N";
					
					//create apply detail
					for(int j = 0; j < applyDetailVOs.length; j++){
						if(applyDetailVOs[j].getRctAplyFlg().equals("N")){
							dtlKey = applyDetailVOs[j].getRctAplyHdrSeq();
							
							if(hdrKey.equals(dtlKey)){
								dtlSeq = dbDao.searchDetailSeq();
								
								applyDetailVOs[j].setRctSeq(rctSeq);
								applyDetailVOs[j].setRctAplyHdrSeq(hdrSeq);
								applyDetailVOs[j].setRctAplyDtlSeq(dtlSeq);
								applyDetailVOs[j].setCreUsrId(userId);
								applyDetailVOs[j].setUpdUsrId(userId);
								
								otsBalAmt = applyDetailVOs[j].getOtsBalAmt().replace(",", "");
								
								if(!otsBalAmt.equals("")){
									applyDetailVOs[j].setOtsBalAmt(new BigDecimal(otsBalAmt).toString());
								}
									
								applyDetailVOs[j].setOtsAplyAmt(new BigDecimal(applyDetailVOs[j].getOtsAplyAmt().replace(",", "")).toString());
								applyDetailVOs[j].setRctAplyAmt(new BigDecimal(applyDetailVOs[j].getRctAplyAmt().replace(",", "")).toString());
								
								detailListVOs.add(applyDetailVOs[j]);
								
								hdrAplyAmt = hdrAplyAmt.add(new BigDecimal(applyDetailVOs[j].getRctAplyAmt()));
								
								if(aplyFlg.equals("Y")) modifyFlg = "Y";
							}
						}
					}
					
					applyHeaderVOs[i].setRctSeq(rctSeq);
					applyHeaderVOs[i].setRctAplyHdrSeq(hdrSeq);
					applyHeaderVOs[i].setIoBndCd(applyHeaderVOs[i].getIoBndCd().equals("")?"":applyHeaderVOs[i].getIoBndCd().substring(0,1));
					applyHeaderVOs[i].setCreUsrId(userId);
					applyHeaderVOs[i].setUpdUsrId(userId);
					applyHeaderVOs[i].setRctAplyAmt(hdrAplyAmt.toString());
					
					if(aplyFlg.equals("N")){
						addHeaderListVOs.add(applyHeaderVOs[i]);
						headerListVOs.add(applyHeaderVOs[i]);
					} else {
						if(modifyFlg.equals("Y")){
							modifyHeaderListVOs.add(applyHeaderVOs[i]);
							headerListVOs.add(applyHeaderVOs[i]);
						}
					}	
				}
				
				if(addHeaderListVOs != null){
					dbDao.addApplyHeader(addHeaderListVOs);
				}
				
				if(modifyHeaderListVOs != null){
					dbDao.modifyApplyHeaderAmount(modifyHeaderListVOs);
				}
				
				if(detailListVOs != null){
					dbDao.addApplyDetail(detailListVOs);
				}
			}
			
			//Create receivable application info by receipt info
			if(receiptMainVO  != null && headerListVOs != null && detailListVOs != null){ 
				createReceivableApplication(receiptMainVO, headerListVOs, detailListVOs);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Reverse Apply Header<br> 
	 * 
	 * @param ReceiptMainVO receiptMainVO
	 * @param ApplyHeaderVO[] applyHeaderVOs
	 * @param ApplyDetailVO[] applyDetailVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyReverseApplyHeader(ReceiptMainVO receiptMainVO, ApplyHeaderVO[] applyHeaderVOs, ApplyDetailVO[] applyDetailVOs, String userId) throws EventException{
		
		try {
			
			BigDecimal applyAmt = new BigDecimal(0);
			BigDecimal balAmt = null;
			BigDecimal bankChgAmt = null;
			
			List<ApplyHeaderVO> headerListVOs = new ArrayList<ApplyHeaderVO>();
			List<ApplyDetailVO> detailListVOs = new ArrayList<ApplyDetailVO>();
			
			balAmt = new BigDecimal(receiptMainVO.getBalRctAmt());
			
			if(applyHeaderVOs != null){
				for(int i = 0; i < applyHeaderVOs.length; i++){
					//Sum reversed apply amount
					applyAmt = applyAmt.add(new BigDecimal(applyHeaderVOs[i].getRctAplyAmt()));
					applyHeaderVOs[i].setUpdUsrId(userId);
					headerListVOs.add(applyHeaderVOs[i]);
				}
			}
			
			if(applyDetailVOs != null){
				for(int i = 0; i < applyDetailVOs.length; i++){
					detailListVOs.add(applyDetailVOs[i]);
				}
			}
			
			//Add total reversed amount to receipt balance amount
			balAmt = balAmt.add(applyAmt);

			if(!receiptMainVO.getBankChgAmt().equals("")){
				bankChgAmt = new BigDecimal(receiptMainVO.getBankChgAmt().replace(",", ""));
				
				//Subtract bank charge amount from receipt balance amount in case of all B/L reversed
				if(receiptMainVO.getRvsAllFlg().equals("Y")){
					balAmt = balAmt.subtract(bankChgAmt);
					receiptMainVO.setBankChgAmt("");
				} else {
					receiptMainVO.setBankChgAmt(bankChgAmt.toString());
				}
			}
			
			receiptMainVO.setBalRctAmt(balAmt.toString());
			
			if(balAmt.compareTo(new BigDecimal(0)) == 0){
				receiptMainVO.setRctStsCd("APP");
			} else {
				receiptMainVO.setRctStsCd("UNAPP");
			}
			
			receiptMainVO.setUpdUsrId(userId);
			
			//Update reverse flag and receipt balance amount
			dbDao.modifyReverseApplyHeader(headerListVOs);
			dbDao.modifyReceiptMain(receiptMainVO);
			
			//Create receivable application info by receipt info
			createReceivableApplication(receiptMainVO, headerListVOs, detailListVOs);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Cancel Receipt<br> 
	 * 
	 * @param ReceiptMainVO receiptMainVO
	 * @param ApplyHeaderVO[] applyHeaderVOs
	 * @param ApplyDetailVO[] applyDetailVOs
	 * @param String userId
	 * @exception EventException
	 */
	public void modifyReceiptCancel(ReceiptMainVO receiptMainVO, ApplyHeaderVO[] applyHeaderVOs, ApplyDetailVO[] applyDetailVOs, String userId) throws EventException{
		
		try {
			
			String rctCxlDt = "";
			String rctOfcCd = "";
			String rctGlDt = "";
			
			AccountReceivableCommonDBDAO comDao = new AccountReceivableCommonDBDAO();
			List<ApplyHeaderVO> headerListVOs = new ArrayList<ApplyHeaderVO>();
			List<ApplyDetailVO> detailListVOs = new ArrayList<ApplyDetailVO>();
			
			rctCxlDt = receiptMainVO.getRctCxlDt();
			rctOfcCd = receiptMainVO.getOtsOfcCd();
			
			//check GL Date
			rctGlDt = comDao.searchEffectiveDate(rctCxlDt, rctOfcCd, "26");
			
			if(rctGlDt == null || rctGlDt.equals("") || !rctGlDt.equals(rctCxlDt)){
				throw new EventException(new ErrorHandler("SAR00003",new String[]{"Cancel date"}).getMessage());
			}
				
			if(applyHeaderVOs != null){
				for(int i = 0; i < applyHeaderVOs.length; i++){
					headerListVOs.add(applyHeaderVOs[i]);
				}
			}
			
			if(applyDetailVOs != null){
				for(int i = 0; i < applyDetailVOs.length; i++){
					detailListVOs.add(applyDetailVOs[i]);
				}
			}

			receiptMainVO.setUpdUsrId(userId);
			
			//Update cancel info
			dbDao.modifyReceiptCancelInfo(receiptMainVO);	
			
			//Create receivable application info by receipt info
			createReceivableApplication(receiptMainVO, headerListVOs, detailListVOs);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Create Receivable Application Info<br> 
	 * 
	 * @param ReceiptMainVO receiptMainVO
	 * @param List<ApplyHeaderVO> applyHeaderVOs
	 * @param List<ApplyDetailVO> applyDetailVOs
	 * @exception EventException
	 */
	private void createReceivableApplication(ReceiptMainVO receiptMainVO, List<ApplyHeaderVO> applyHeaderVOs, List<ApplyDetailVO> applyDetailVOs) throws EventException{
		
		try {
			
			String saveKindCd = "";
			String newRctFlg = "";
			String rctStsCd = "";
			String rctSeq = "";
			String lastRcvApplSts = "";			
			String rcvApplTpCd = "";
			String rcvApplStsCd = "";
			String rctAmt = "";
			String rctDpsDt = "";
			String rctDt = "";
			String rctCurrCd = "";
			String convXchRt = "";
			String creUsrId = "";
			String updUsrId = "";
			String funcCurrCd = "";
			String hdrSeq = "";
			String dtlSeq = "";
			String otsBalAmt = "";
			String rctOfcCd = "";
			String rctCurrScale = "";
			String aplyDtlSeq = "";
			String otsHisSeq = "";
			String chgTpCd = "";
			String srcCurrCd = "";
			String fncCurrScale = "";
			String acctXchRtDt = "";
			String appXchRt = "";
			String noAppXchRt = "";
			String aplyFmRcvApplSeq = "";
			String rcvApplSeq = "";
			String tmpRcvApplSeq = "";
			String rctTermDys = "";
			String sailArrDt = "";
			String glDt = "";
			String dpFlg = "";
			String otsToRctXchRt = "";
			String bankChgAmt = "";
			String addRcvFlg = "";
			String wrtfTpCd = "";
			String wrtfCd = "";
			String rctGlDt = "";
			String payAcctCd = "";
			String apGlDt = "";
			String tmpGlDt = "";
			// String apXchRt = "";
			String wrtfRmk = "";
			String dtlApRmk = "";
			String rcvApplRmk = "";
			String rcvApRmk = "";
			
			BigDecimal oldBalAmt = null;
			BigDecimal newBalAmt = null;
			BigDecimal otsAplyAmt = null;
			BigDecimal chgBalAmt = null;
			BigDecimal balAplyAmt = null;
			//BigDecimal dpsDt = null;
			BigDecimal otsGlDt = null;
			BigDecimal aplyXchRt = null;
			BigDecimal aplyAmt = null;
			BigDecimal aplyFmAmt = null;
			BigDecimal aplyFmAcctAmt = null;
			BigDecimal aplyToAcctAmt = null;
			BigDecimal rctCxlDt = null;
			BigDecimal appGlDt = null;
			
			Date date1 = null;
			Date date2 = null;
			
			long diff = 0l;
			
			AccountReceivableCommonDBDAO arComDao = new AccountReceivableCommonDBDAO();
			AccountReceivableOutstandingDBDAO arOtsDao = new AccountReceivableOutstandingDBDAO();
			StatementCommonDBDAO stmComDao = new StatementCommonDBDAO();
			List<ReceivableApplVO> receivableApplVOs = new ArrayList<ReceivableApplVO>();
			List<LookupInfoVO> lookupInfoVOs = new ArrayList<LookupInfoVO>();
			List<CurrencyCodeVO> currencyCodeVOs = new ArrayList<CurrencyCodeVO>();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			List<String> applSeqList = new ArrayList<String>();
			
			saveKindCd = receiptMainVO.getSaveKindCd();
			newRctFlg = receiptMainVO.getNewRctFlg();
			rctStsCd = receiptMainVO.getRctStsCd();
			rctSeq = receiptMainVO.getRctSeq();
			rctOfcCd = receiptMainVO.getOtsOfcCd();
			rctAmt = receiptMainVO.getRctAmt();
			bankChgAmt = receiptMainVO.getBankChgAmt();
			rctDpsDt = receiptMainVO.getRctDpsDt().replace("-", "");
			//dpsDt = new BigDecimal(rctDpsDt);
			rctDt = receiptMainVO.getRctDt().replace("-", "");
			rctCurrCd = receiptMainVO.getRctCurrCd();
			creUsrId = receiptMainVO.getCreUsrId();
			updUsrId = receiptMainVO.getUpdUsrId();
			
			//Search last application status code by receipt sequence
			lastRcvApplSts = dbDao.searchLastApplicationStatus(rctSeq);
			
			//Search functional currency code, precision of functional and receipt currency code
			lookupInfoVOs = stmComDao.searchLookupList("FUNCTIONAL CURRENCY");
			funcCurrCd = lookupInfoVOs.get(0).getLuCd();
			currencyCodeVOs = arComDao.searchCurrencyCode(funcCurrCd);
			fncCurrScale = currencyCodeVOs.get(0).getDpPrcsKnt();
			receiptMainVO.setFncCurrScale(fncCurrScale);
			rctCurrScale = receiptMainVO.getDpPrcsKnt();

			//Search G/L date by deposit date
			rctGlDt = arComDao.searchEffectiveDate(rctDpsDt, rctOfcCd, "26");
			
			if(rctGlDt == null || rctGlDt.equals("")){
				throw new EventException(new ErrorHandler("SAR00003",new String[]{"period status"}).getMessage());
			}
			
			//Search account exchange rate for functional currency
			if(funcCurrCd.equals(rctCurrCd)){
				noAppXchRt = "1";
			} else {
				ARExrateVO arExrateVO = new ARExrateVO();
				
				arExrateVO.setXchRtDt(rctDt);
				arExrateVO.setLclCurrCd(funcCurrCd);
				arExrateVO.setChgCurrCd(rctCurrCd);
				
				noAppXchRt = arComDao.searchAccountExrate(arExrateVO);
			}
			
			if(noAppXchRt == null || noAppXchRt.equals("")){
				throw new EventException(new ErrorHandler("SAR00025",new String[]{}).getMessage());
			}
			
			//Process case in saving receipt info
			if(saveKindCd.equals("S")){
				rcvApplTpCd = "RECEIPT";
				
				//Create CASH/UNAPP/UNID/WRTF application info
				for(int i = 0; i < 4; i++){
					addRcvFlg = "N";
					
					if(i == 0) {
						if(newRctFlg.equals("Y")){
							rcvApplStsCd = "CASH";
							addRcvFlg = "Y";
						} else {
							if(lastRcvApplSts.equals("UNAPP") && rctStsCd.equals("UNID")){
								rcvApplStsCd = "UNAPP";
								addRcvFlg = "Y";
							} else if(lastRcvApplSts.equals("UNID") && !rctStsCd.equals("UNID")){
								rcvApplStsCd = "UNID";
								addRcvFlg = "Y";
							}
						}
						aplyAmt = new BigDecimal(rctAmt).negate();
						aplyFmRcvApplSeq = "";
						dpFlg = "N";
						
					} else if(i == 1){
						if(newRctFlg.equals("Y")){
							if(rctStsCd.equals("UNID")){
								rcvApplStsCd = "UNID";
								addRcvFlg = "Y";
							} else {
								rcvApplStsCd = "UNAPP";
								addRcvFlg = "Y";
							}
						} else { 
							if(lastRcvApplSts.equals("UNAPP") && rctStsCd.equals("UNID")){
								rcvApplStsCd = "UNID";
								addRcvFlg = "Y";
							} else if(lastRcvApplSts.equals("UNID") && !rctStsCd.equals("UNID")){
								rcvApplStsCd = "UNAPP";
								addRcvFlg = "Y";
							}
						}
						aplyAmt = new BigDecimal(rctAmt);
						aplyFmRcvApplSeq = tmpRcvApplSeq;
						dpFlg = "N";
						
					} else if(i == 2){
						if(!dbDao.checkBankCharge(rctSeq) && !bankChgAmt.equals("")){
							rcvApplStsCd = "UNAPP";
							addRcvFlg = "Y";
							aplyAmt = new BigDecimal(bankChgAmt);
							aplyFmRcvApplSeq = "";
							dpFlg = "N";
						}
					} else {
						if(!dbDao.checkBankCharge(rctSeq) && !bankChgAmt.equals("")){
							rcvApplStsCd = "WRTF";
							addRcvFlg = "Y";
							aplyAmt = new BigDecimal(bankChgAmt).negate();
							aplyFmRcvApplSeq = tmpRcvApplSeq;
							dpFlg = "Y";
							wrtfTpCd = "BC";
						}
					}
					
					if(addRcvFlg.equals("Y")){
						ReceivableApplVO receivableApplVO = new ReceivableApplVO();
							
						rcvApplSeq = dbDao.searchReceivableApplSeq();
						tmpRcvApplSeq = rcvApplSeq;
						
						aplyFmAmt = aplyAmt;	
						glDt = rctGlDt;
						acctXchRtDt = rctDt;		
						convXchRt = noAppXchRt;
						aplyFmAcctAmt = aplyFmAmt.multiply(new BigDecimal(noAppXchRt)).setScale(Integer.parseInt(fncCurrScale), BigDecimal.ROUND_HALF_UP);
	
						receivableApplVO.setRcvApplSeq(rcvApplSeq);
						receivableApplVO.setRctSeq(rctSeq);
						receivableApplVO.setRcvApplTpCd(rcvApplTpCd);
						receivableApplVO.setRcvApplStsCd(rcvApplStsCd);
						receivableApplVO.setAplyAmt(aplyAmt.toString());
						receivableApplVO.setAplyFmAmt(aplyFmAmt.toString());
						receivableApplVO.setOtsToRctXchRt("1");
						receivableApplVO.setAplyFmRcvApplSeq(aplyFmRcvApplSeq);
						receivableApplVO.setGlDt(glDt);
						receivableApplVO.setRcvCdCmbSeq("-1");
						receivableApplVO.setDpFlg(dpFlg);
						receivableApplVO.setRctDt(rctDt);
						receivableApplVO.setRctDpsDt(rctDpsDt);
						receivableApplVO.setRctAplyDtlSeq("");
						receivableApplVO.setOtsHisSeq("");
						receivableApplVO.setChgTpCd("");
						receivableApplVO.setWrtfTpCd(wrtfTpCd);
						receivableApplVO.setGlTrnsSeq("-1");
						receivableApplVO.setGlTrnsDt("");
						receivableApplVO.setAcctXchRtLvl("1");
						receivableApplVO.setAcctXchRtDt(acctXchRtDt);
						receivableApplVO.setConvXchRt(convXchRt);
						receivableApplVO.setAplyFmAcctAmt(aplyFmAcctAmt.toString());
						receivableApplVO.setAplyToAcctAmt("");
						receivableApplVO.setRctCxlDt("");
						receivableApplVO.setRctTermDys("");
						receivableApplVO.setOrzSeq("-1");
						receivableApplVO.setLegrSeq("-1");
						receivableApplVO.setCreUsrId(creUsrId);
						receivableApplVO.setUpdUsrId(updUsrId);
						
						receivableApplVOs.add(receivableApplVO);
					}
				}
				
				//Process apply header/detail info
				if(!rctStsCd.equals("UNID") && applyHeaderVOs != null){
					for(int i = 0; i < applyHeaderVOs.size(); i++){
						hdrSeq = applyHeaderVOs.get(i).getRctAplyHdrSeq();
						sailArrDt = applyHeaderVOs.get(i).getSailArrDt();
						
						for(int j = 0; j < applyDetailVOs.size(); j++){
							dtlSeq = applyDetailVOs.get(j).getRctAplyHdrSeq();
							
							if(hdrSeq.equals(dtlSeq)){
								AROutstandingCheckVO arOutstandingCheckVO = new AROutstandingCheckVO();
								List<OTSForApplyAdjustVO> otsForApplyAdjustVOs = new ArrayList<OTSForApplyAdjustVO>();
								
								arOutstandingCheckVO.setOtsOfcCd(applyHeaderVOs.get(i).getOtsOfcCd());
								arOutstandingCheckVO.setBlNo(applyHeaderVOs.get(i).getBlNo());
								arOutstandingCheckVO.setInvNo(applyHeaderVOs.get(i).getInvNo());
								arOutstandingCheckVO.setBlCurrCd(applyDetailVOs.get(j).getRctAplySrcCurrCd());
								arOutstandingCheckVO.setChgTpCd(applyDetailVOs.get(j).getRctAplyChgCd());
								
								//Search target OTS charge amount for apply
								otsForApplyAdjustVOs = arOtsDao.searchOutstandingForApplyAdjust(arOutstandingCheckVO);
								
								//Search OTS balance amount to comparing difference
								otsBalAmt = arOtsDao.searchOutstandingBalance(arOutstandingCheckVO);
								
								if(!applyDetailVOs.get(j).getOtsBalAmt().equals("")){
									oldBalAmt = new BigDecimal(otsBalAmt);
									newBalAmt = new BigDecimal(applyDetailVOs.get(j).getOtsBalAmt());
									
									if(oldBalAmt.compareTo(newBalAmt) != 0){
										throw new EventException(new ErrorHandler("SAR00019",new String[]{}).getMessage());
									}
								}
								
								otsAplyAmt = new BigDecimal(applyDetailVOs.get(j).getOtsAplyAmt());
								aplyXchRt = new BigDecimal(applyDetailVOs.get(j).getRctAplyXchRt());
								aplyDtlSeq = applyDetailVOs.get(j).getRctAplyDtlSeq();
								wrtfCd = applyDetailVOs.get(j).getWrtfCd();
								apGlDt = applyDetailVOs.get(j).getApGlDt();
								payAcctCd = applyDetailVOs.get(j).getPayAcctCd();
								wrtfRmk = applyDetailVOs.get(j).getWrtfRmk();
								dtlApRmk = applyDetailVOs.get(j).getApRmk();
								
								for(int k = 0; k < otsForApplyAdjustVOs.size(); k++){	
									if(otsAplyAmt.compareTo(new BigDecimal(0)) != 0){
										otsGlDt = new BigDecimal(otsForApplyAdjustVOs.get(k).getGlDt());
										
										/* Change UNAPP/APP G/L Date to Deposit Date 2016.04.18 
										if(otsGlDt.compareTo(dpsDt) > 0){
											glDt = otsGlDt.toString();
										} else {
											glDt = dpsDt.toString();
										}

										//Search G/L date for OTS charge info
										glDt = arComDao.searchEffectiveDate(glDt, rctOfcCd, "26");
										
										if(glDt == null || glDt.equals("")){
											throw new EventException(new ErrorHandler("SAR00003",new String[]{"period status"}).getMessage());
										}
										*/
										
										glDt = rctGlDt;
										
										chgBalAmt = new BigDecimal(otsForApplyAdjustVOs.get(k).getChgBalAmt());
									
										//Compare apply amount with OTS balance amount
										if(otsAplyAmt.compareTo(chgBalAmt) <= 0){
											balAplyAmt = otsAplyAmt;
										} else {
											balAplyAmt = chgBalAmt;
										}
										
										otsAplyAmt = otsAplyAmt.subtract(balAplyAmt);
										
										if(k == otsForApplyAdjustVOs.size() - 1 && otsAplyAmt.compareTo(new BigDecimal(0)) != 0){
											balAplyAmt = balAplyAmt.add(otsAplyAmt);
											otsAplyAmt = new BigDecimal(0);
										}
										
										//Create UNAPP/APP application info
										if(balAplyAmt.compareTo(new BigDecimal(0)) != 0){
											for(int l = 0; l < 2; l++){
												ReceivableApplVO receivableApplVO = new ReceivableApplVO();
												
												rcvApplSeq = dbDao.searchReceivableApplSeq();
												srcCurrCd = otsForApplyAdjustVOs.get(k).getCurrCd();			
												
												if(l == 0){
													rcvApplStsCd = "UNAPP";
													aplyAmt = balAplyAmt.multiply(aplyXchRt).setScale(Integer.parseInt(rctCurrScale), BigDecimal.ROUND_HALF_UP).negate();
													aplyFmAmt = aplyAmt;
													otsToRctXchRt = "1";
													aplyFmRcvApplSeq = "";
													dpFlg = "N";
													otsHisSeq = "";
													chgTpCd = "";
													acctXchRtDt = rctDt;	
													convXchRt = noAppXchRt;
													aplyToAcctAmt = null;
													rctTermDys = "";
													tmpRcvApplSeq = rcvApplSeq;		
												} else {
													applSeqList.add(rcvApplSeq);
													rcvApplStsCd = "APP";
													aplyAmt = balAplyAmt;
													aplyFmAmt = balAplyAmt.multiply(aplyXchRt).setScale(Integer.parseInt(rctCurrScale), BigDecimal.ROUND_HALF_UP);
													otsToRctXchRt = aplyXchRt.toString();
													aplyFmRcvApplSeq = tmpRcvApplSeq;
													dpFlg = "Y";
													otsHisSeq = otsForApplyAdjustVOs.get(k).getOtsHisSeq();
													chgTpCd = otsForApplyAdjustVOs.get(k).getChgTpCd();
													acctXchRtDt = otsGlDt.toString();
													
													//Search account exchange rate for functional currency
													if(funcCurrCd.equals(srcCurrCd)){
														appXchRt = "1";
													} else {
														ARExrateVO xchCond = new ARExrateVO();
														
														xchCond.setXchRtDt(acctXchRtDt);
														xchCond.setLclCurrCd(funcCurrCd);
														xchCond.setChgCurrCd(srcCurrCd);
														
														appXchRt = arComDao.searchAccountExrate(xchCond);
													}
													
													if(appXchRt == null || appXchRt.equals("")){
														throw new EventException(new ErrorHandler("SAR00025",new String[]{}).getMessage());
													}
													
													convXchRt = appXchRt;
													aplyToAcctAmt = aplyAmt.multiply(new BigDecimal(appXchRt)).setScale(Integer.parseInt(fncCurrScale), BigDecimal.ROUND_HALF_UP);

													//Search receipt term days by receipt date and S/A date
													date1 = formatter.parse(rctDt);
													date2 = formatter.parse(sailArrDt);
													
													diff = date1.getTime() - date2.getTime();
													rctTermDys = Long.toString(diff / (24 * 60 * 60 * 1000));	
												}

												aplyFmAcctAmt = aplyFmAmt.multiply(new BigDecimal(noAppXchRt)).setScale(Integer.parseInt(fncCurrScale), BigDecimal.ROUND_HALF_UP);

												receivableApplVO.setRcvApplSeq(rcvApplSeq);
												receivableApplVO.setRctSeq(rctSeq);
												receivableApplVO.setRcvApplTpCd(rcvApplTpCd);
												receivableApplVO.setRcvApplStsCd(rcvApplStsCd);
												receivableApplVO.setAplyAmt(aplyAmt.toString());
												receivableApplVO.setAplyFmAmt(aplyFmAmt.toString());
												receivableApplVO.setOtsToRctXchRt(otsToRctXchRt);
												receivableApplVO.setAplyFmRcvApplSeq(aplyFmRcvApplSeq);
												receivableApplVO.setGlDt(glDt);
												receivableApplVO.setRcvCdCmbSeq("-1");
												receivableApplVO.setDpFlg(dpFlg);
												receivableApplVO.setRctDt(rctDt);
												receivableApplVO.setRctDpsDt(rctDpsDt);
												receivableApplVO.setRctAplyDtlSeq(aplyDtlSeq);
												receivableApplVO.setOtsHisSeq(otsHisSeq);
												receivableApplVO.setChgTpCd(chgTpCd);
												receivableApplVO.setWrtfTpCd("");
												receivableApplVO.setGlTrnsSeq("-1");
												receivableApplVO.setGlTrnsDt("");
												receivableApplVO.setAcctXchRtLvl("1");
												receivableApplVO.setAcctXchRtDt(acctXchRtDt);
												receivableApplVO.setConvXchRt(convXchRt);
												receivableApplVO.setAplyFmAcctAmt(aplyFmAcctAmt.toString());
												receivableApplVO.setAplyToAcctAmt(aplyToAcctAmt == null ? "" : aplyToAcctAmt.toString());
												receivableApplVO.setRctCxlDt("");
												receivableApplVO.setRctTermDys(rctTermDys);
												receivableApplVO.setOrzSeq("-1");
												receivableApplVO.setLegrSeq("-1");
												receivableApplVO.setCreUsrId(creUsrId);
												receivableApplVO.setUpdUsrId(updUsrId);
												
												receivableApplVOs.add(receivableApplVO);	
											}
										}
									}
								}
								
								//Process Write-off info
								//Create UNAPP/WRTF application info
								if(!wrtfCd.equals("")){
									for(int m = 0; m < 2; m++){
										ReceivableApplVO receivableApplVO = new ReceivableApplVO();
										
										rcvApplSeq = dbDao.searchReceivableApplSeq();
										
										if(m == 0){
											rcvApplStsCd = "UNAPP";
											aplyAmt = otsAplyAmt.negate();
											aplyFmRcvApplSeq = "";
											dpFlg = "N";
											wrtfTpCd = "";
											tmpRcvApplSeq = rcvApplSeq;
											rcvApplRmk = "";
											rcvApRmk = "";
										} else {
											rcvApplStsCd = "WRTF";
											aplyAmt = otsAplyAmt;
											aplyFmRcvApplSeq = tmpRcvApplSeq;
											dpFlg = "Y";
											wrtfTpCd = wrtfCd;
											rcvApplRmk = wrtfRmk;
											rcvApRmk = dtlApRmk;
										}
												
										aplyFmAmt = aplyAmt;
										
										//If Pay account exists, set G/L date and exchange rate date by AP G/L date
										if(!payAcctCd.equals("")){
											//Search G/L date by AP G/L date
											tmpGlDt = arComDao.searchEffectiveDate(apGlDt, rctOfcCd, "26");
											
											if(tmpGlDt == null || tmpGlDt.equals("") || !tmpGlDt.equals(apGlDt)){
												throw new EventException(new ErrorHandler("SAR00003",new String[]{"AP G/L date"}).getMessage());
											}
											
											//Search account exchange rate for functional currency by AP G/L date
											/*
											if(funcCurrCd.equals(rctCurrCd)){
												apXchRt = "1";
											} else {
												ARExrateVO apXchCond = new ARExrateVO();
												
												apXchCond.setXchRtDt(apGlDt);
												apXchCond.setLclCurrCd(funcCurrCd);
												apXchCond.setChgCurrCd(rctCurrCd);
												
												apXchRt = arComDao.searchAccountExrate(apXchCond);
											}
											
											if(apXchRt == null || apXchRt.equals("")){
												throw new EventException(new ErrorHandler("SAR00025",new String[]{}).getMessage());
											}
											*/
											
											glDt = apGlDt;
											//acctXchRtDt = apGlDt;
											//convXchRt = apXchRt;
											//aplyFmAcctAmt = aplyFmAmt.multiply(new BigDecimal(apXchRt)).setScale(Integer.parseInt(fncCurrScale), BigDecimal.ROUND_HALF_UP);
																						
										} else {
											glDt = rctGlDt;
											//acctXchRtDt = rctDt;
											//convXchRt = noAppXchRt;
											//aplyFmAcctAmt = aplyFmAmt.multiply(new BigDecimal(noAppXchRt)).setScale(Integer.parseInt(fncCurrScale), BigDecimal.ROUND_HALF_UP);
										}
										
										acctXchRtDt = rctDt;
										convXchRt = noAppXchRt;
										aplyFmAcctAmt = aplyFmAmt.multiply(new BigDecimal(noAppXchRt)).setScale(Integer.parseInt(fncCurrScale), BigDecimal.ROUND_HALF_UP);
										
										receivableApplVO.setRcvApplSeq(rcvApplSeq);
										receivableApplVO.setRctSeq(rctSeq);
										receivableApplVO.setRcvApplTpCd(rcvApplTpCd);
										receivableApplVO.setRcvApplStsCd(rcvApplStsCd);
										receivableApplVO.setAplyAmt(aplyAmt.toString());
										receivableApplVO.setAplyFmAmt(aplyFmAmt.toString());
										receivableApplVO.setOtsToRctXchRt("1");
										receivableApplVO.setAplyFmRcvApplSeq(aplyFmRcvApplSeq);
										receivableApplVO.setGlDt(glDt);
										receivableApplVO.setRcvCdCmbSeq("-1");
										receivableApplVO.setDpFlg(dpFlg);
										receivableApplVO.setRctDt(rctDt);
										receivableApplVO.setRctDpsDt(rctDpsDt);
										receivableApplVO.setRctAplyDtlSeq(aplyDtlSeq);
										receivableApplVO.setOtsHisSeq("");
										receivableApplVO.setChgTpCd("");
										receivableApplVO.setWrtfTpCd(wrtfTpCd);
										receivableApplVO.setGlTrnsSeq("-1");
										receivableApplVO.setGlTrnsDt("");
										receivableApplVO.setAcctXchRtLvl("1");
										receivableApplVO.setAcctXchRtDt(acctXchRtDt);
										receivableApplVO.setConvXchRt(convXchRt);
										receivableApplVO.setAplyFmAcctAmt(aplyFmAcctAmt.toString());
										receivableApplVO.setAplyToAcctAmt("");
										receivableApplVO.setRctCxlDt("");
										receivableApplVO.setRctTermDys("");
										receivableApplVO.setOrzSeq("-1");
										receivableApplVO.setLegrSeq("-1");
										receivableApplVO.setCreUsrId(creUsrId);
										receivableApplVO.setUpdUsrId(updUsrId);
										receivableApplVO.setRcvApplRmk(rcvApplRmk);
										receivableApplVO.setApRmk(rcvApRmk);
										
										receivableApplVOs.add(receivableApplVO);
									}
								}
							}
						}
					}
				}			
			//Process case in reversing receipt info
			} else if(saveKindCd.equals("R")){
				//Process case in all B/L reversed and existing bank charge amount
				if(receiptMainVO.getRvsAllFlg().equals("Y") && dbDao.checkBankCharge(rctSeq)){
					List<ReceivableApplVO> reverseList = new ArrayList<ReceivableApplVO>();
					reverseList = dbDao.searchReceivableApplForReverse(rctSeq, "", "Y");
					
					for(int i = 0; i < reverseList.size(); i++){
						//Search G/L date for reverse
						glDt = reverseList.get(i).getGlDt();
						glDt = arComDao.searchEffectiveDate(glDt, rctOfcCd, "26");
						
						if(glDt == null || glDt.equals("")){
							throw new EventException(new ErrorHandler("SAR00003",new String[]{"period status"}).getMessage());
						}
						
						reverseList.get(i).setGlDt(glDt);
						reverseList.get(i).setRvsGlDt(glDt);
						reverseList.get(i).setCreUsrId(updUsrId);
						reverseList.get(i).setUpdUsrId(updUsrId);
						
						receivableApplVOs.add(reverseList.get(i));
					}
				}
				
				//Process to reverse the selected B/L data
				for(int i = 0; i < applyHeaderVOs.size(); i++){
					hdrSeq = applyHeaderVOs.get(i).getRctAplyHdrSeq();
					
					for(int j = 0; j < applyDetailVOs.size(); j++){
						dtlSeq = applyDetailVOs.get(j).getRctAplyHdrSeq();
						aplyDtlSeq = applyDetailVOs.get(j).getRctAplyDtlSeq();
						
						if(hdrSeq.equals(dtlSeq)){
							List<ReceivableApplVO> reverseList = new ArrayList<ReceivableApplVO>();
							reverseList = dbDao.searchReceivableApplForReverse(rctSeq, aplyDtlSeq, "N");
							
							for(int k = 0; k < reverseList.size(); k++){
								//Search G/L date for reverse
								glDt = reverseList.get(k).getGlDt();
								glDt = arComDao.searchEffectiveDate(glDt, rctOfcCd, "26");
								
								if(glDt == null || glDt.equals("")){
									throw new EventException(new ErrorHandler("SAR00003",new String[]{"period status"}).getMessage());
								}
								
								reverseList.get(k).setGlDt(glDt);
								reverseList.get(k).setRvsGlDt(glDt);
								reverseList.get(k).setCreUsrId(updUsrId);
								reverseList.get(k).setUpdUsrId(updUsrId);
								
								receivableApplVOs.add(reverseList.get(k));
							}
						}
					}
				}
				
				dbDao.modifyReceivableApplType(receivableApplVOs);
				
				for(int i = 0; i < receivableApplVOs.size(); i++){
					receivableApplVOs.get(i).setTgtRcvApplSeq(receivableApplVOs.get(i).getRcvApplSeq());
					rcvApplSeq = dbDao.searchReceivableApplSeq();
					receivableApplVOs.get(i).setRcvApplSeq(rcvApplSeq);
					
					if(receivableApplVOs.get(i).getRcvApplStsCd().equals("UNAPP")){
						aplyFmRcvApplSeq = rcvApplSeq;
					} else {
						applSeqList.add(rcvApplSeq);
						receivableApplVOs.get(i).setAplyFmRcvApplSeq(aplyFmRcvApplSeq);
					}
				}
			//Process case in canceling receipt info
			} else if(saveKindCd.equals("C")){
				rctCxlDt = new BigDecimal(receiptMainVO.getRctCxlDt());
				
				List<ReceivableApplVO> cancelList = new ArrayList<ReceivableApplVO>();
				cancelList = dbDao.searchReceivableApplForCancel(rctSeq);
				
				for(int i = 0; i < cancelList.size(); i++){
					//Search G/L date for cancel by cancel date
					if(((i < cancelList.size() - 1) && cancelList.get(i).getRcvApplStsCd().equals("UNAPP") && cancelList.get(i+1).getRcvApplStsCd().equals("APP")) || 
					   cancelList.get(i).getRcvApplStsCd().equals("APP")){
						appGlDt = new BigDecimal(cancelList.get(i).getGlDt());
						
						if(appGlDt.compareTo(rctCxlDt) > 0){
							glDt = appGlDt.toString();
						} else {
							glDt = rctCxlDt.toString();
						}
					} else {
						glDt = rctCxlDt.toString();
					}
					
					glDt = arComDao.searchEffectiveDate(glDt, rctOfcCd, "26");
					
					if(glDt == null || glDt.equals("")){
						throw new EventException(new ErrorHandler("SAR00003",new String[]{"period status"}).getMessage());
					}
					
					cancelList.get(i).setGlDt(glDt);
					cancelList.get(i).setRctCxlDt(rctCxlDt.toString());
					cancelList.get(i).setCreUsrId(updUsrId);
					cancelList.get(i).setUpdUsrId(updUsrId);
					
					receivableApplVOs.add(cancelList.get(i));
				}
				
				dbDao.modifyReceivableApplType(receivableApplVOs);
				
				for(int i = 0; i < receivableApplVOs.size(); i++){
					receivableApplVOs.get(i).setTgtRcvApplSeq(receivableApplVOs.get(i).getRcvApplSeq());
					rcvApplSeq = dbDao.searchReceivableApplSeq();
					receivableApplVOs.get(i).setRcvApplSeq(rcvApplSeq);
					
					if(i % 2 == 0) aplyFmRcvApplSeq = rcvApplSeq;
					else receivableApplVOs.get(i).setAplyFmRcvApplSeq(aplyFmRcvApplSeq);
					
					if(receivableApplVOs.get(i).getRcvApplStsCd().equals("APP") || receivableApplVOs.get(i).getRcvApplStsCd().equals("WRTF")){
						applSeqList.add(rcvApplSeq);
					}
				}
			}
	
			//Create Receivable Application info
			dbDao.addReceivableApplication(receivableApplVOs);	
			
			//Create Receipt Distribution info
			createReceiptDistribution(receiptMainVO, receivableApplVOs);
			
			//Reflect the receipt info to OTS info
			if(applSeqList.size() > 0){
				List<AROutstandingHdrVO> arOutstandingHdrVOs = new ArrayList<AROutstandingHdrVO>();
				List<AROutstandingHistVO> arOutstandingHistVOs = new ArrayList<AROutstandingHistVO>();
				List<AROutstandingDtlVO> arOutstandingDtlVOs = new ArrayList<AROutstandingDtlVO>();
				List<AROutstandingChgVO> arOutstandingChgVOs = new ArrayList<AROutstandingChgVO>();
				
				List<RcvApplSeqTmpVO> rcvApplSeqTmpVOs = new ArrayList<RcvApplSeqTmpVO>(); 				
				
				for(int i = 0; i < applSeqList.size(); i++){
					
					RcvApplSeqTmpVO rcvApplSeqTmpVO = new RcvApplSeqTmpVO();
					rcvApplSeqTmpVO.setRcvApplSeq(applSeqList.get(i));
					rcvApplSeqTmpVOs.add(rcvApplSeqTmpVO);					
				}
				
				dbDao.addRcvApplSeqTmp(rcvApplSeqTmpVOs);
				
				arOutstandingHdrVOs = dbDao.searchReceivableForOTSHeader(applSeqList);
				arOutstandingHistVOs = dbDao.searchReceivableForOTSHistory(applSeqList);
				arOutstandingDtlVOs = dbDao.searchReceivableForOTSDetail(applSeqList);
				arOutstandingChgVOs = dbDao.searchReceivableForOTSCharge(applSeqList);
				
				//Update OTS charge amount
				arOtsDao.modifyOutstandingChargeAmt(arOutstandingChgVOs);
				
				for(int i = 0; i < arOutstandingHistVOs.size(); i++){
					arOutstandingHistVOs.get(i).setOtsHisSeq(arOtsDao.searchOutstandingHistSeq());
				}
				
				//Create OTS history info
				arOtsDao.addOutstandingHist(arOutstandingHistVOs);
				//Update OTS detail balance amount
				arOtsDao.modifyOutstandingDetail(arOutstandingDtlVOs);
				
				for(int i = 0; i < arOutstandingHdrVOs.size(); i++){
					//Update OTS settle flag
					arOtsDao.modifyOTSSettleFlag(arOutstandingHdrVOs.get(i));
					
					if(saveKindCd.equals("S")){
						//Update OTS collected office code
						arOtsDao.modifyCollectedOffice(arOutstandingHdrVOs.get(i));
					}
					
					//2015.04.01 modify BKG OTS
					arOtsDao.modifyBKGOutstanding(arOutstandingHdrVOs.get(i));
				}
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Create Receipt Distribution Info<br> 
	 * 
	 * @param ReceiptMainVO receiptMainVO
	 * @param List<ReceivableApplVO> receivableApplVOs
	 * @exception EventException
	 */
	private void createReceiptDistribution(ReceiptMainVO receiptMainVO, List<ReceivableApplVO> receivableApplVOs) throws EventException{
		
		try {
			
			String bankAcctSeq = "";
			String dtrbSrcSeq = "";
			String rcvApplStsCd = "";
			String otsHisSeq = "";
			String chgTpCd = "";
			String glDt = "";
			String wrtfTpCd = "";
			String dtrbCdCmbSeq = "";
			String inpDrAmt = "";
			String inpCrAmt = "";
			String acctDrAmt = "";
			String acctCrAmt = "";
			String acctMtxSeq = "";
			String dtrbSrcTpCd = "";
			String currCd = "";
			String custCntCd = "";
			String custSeq = "";
			String fmDtrbSrcSeq = "";
			String acctXchRtLvl = "";
			String acctXchRtDt = "";
			String aftRcvApplStsCd = "";
			String fncCurrScale = "";
			String creUsrId = "";
			String updUsrId = "";
			String saveKindCd = "";
			
			int unappCnt = 0;
			
			BigDecimal rctAmt = null;
			BigDecimal bfrBalRctAcctAmt = null;
			BigDecimal aftBalRctAcctAmt = new BigDecimal(0);
			BigDecimal balRctAmt = null;
			BigDecimal balOtsAmt = null;
			BigDecimal convXchRt = null;
			BigDecimal bfrConvXchRt = null;
			BigDecimal aftConvXchRt = null;
			BigDecimal aplyAmt = null;
			BigDecimal acctAmt = null;
			BigDecimal bfrAcctBalAmt = null;
			BigDecimal aftAcctBalAmt = null;
			BigDecimal orgAcctAmt = null;
			BigDecimal unappAcctAmt = null;
			BigDecimal rndAcctAmt = null;
			BigDecimal exhAcctAmt = null;
			
			BankAcctCmbSeqVO bankAcctCmbSeqVO = new BankAcctCmbSeqVO(); 
			
			bankAcctSeq = receiptMainVO.getBankAcctSeq();
			fncCurrScale = receiptMainVO.getFncCurrScale();
			saveKindCd = receiptMainVO.getSaveKindCd();
			if(saveKindCd.equals("S")) balRctAmt = new BigDecimal(receiptMainVO.getBfrBalRctAmt());
			rctAmt = new BigDecimal(receiptMainVO.getRctAmt().replace(",", ""));	
			bfrBalRctAcctAmt = new BigDecimal(dbDao.searchBalRctAcctAmt(receiptMainVO.getRctSeq()));
			
			//Search combination sequence from bank account info to account CASH/UNID/UNAPP/WRTF status
			bankAcctCmbSeqVO = dbDao.searchBankAcctCmbSeq(bankAcctSeq);
			
			//Process accounting by receivable application info
			for(int i = 0; i < receivableApplVOs.size(); i++){
				if(saveKindCd.equals("S")){			//Process accounting in case of saving receipt info
					dtrbSrcSeq = receivableApplVOs.get(i).getRcvApplSeq();
					rcvApplStsCd = receivableApplVOs.get(i).getRcvApplStsCd();
					otsHisSeq = receivableApplVOs.get(i).getOtsHisSeq();
					chgTpCd = receivableApplVOs.get(i).getChgTpCd();
					glDt = receivableApplVOs.get(i).getGlDt();
					wrtfTpCd = receivableApplVOs.get(i).getWrtfTpCd();
					fmDtrbSrcSeq = receivableApplVOs.get(i).getAplyFmRcvApplSeq();
					acctXchRtLvl = receivableApplVOs.get(i).getAcctXchRtLvl();
					acctXchRtDt = receivableApplVOs.get(i).getAcctXchRtDt();
					creUsrId = receivableApplVOs.get(i).getCreUsrId();
					updUsrId = receivableApplVOs.get(i).getUpdUsrId();
					aplyAmt = new BigDecimal(receivableApplVOs.get(i).getAplyAmt());
					convXchRt = new BigDecimal(receivableApplVOs.get(i).getConvXchRt());
					
					aftRcvApplStsCd = (i < receivableApplVOs.size() - 1) ? receivableApplVOs.get(i+1).getRcvApplStsCd() : "";
					aftConvXchRt = (i < receivableApplVOs.size() - 1) ? new BigDecimal(receivableApplVOs.get(i+1).getConvXchRt()) : null;
					bfrConvXchRt = (i > 0) ? new BigDecimal(receivableApplVOs.get(i-1).getConvXchRt()) : null;
					acctAmt = rcvApplStsCd.equals("APP") ? new BigDecimal(receivableApplVOs.get(i).getAplyToAcctAmt()).abs() : new BigDecimal(receivableApplVOs.get(i).getAplyFmAcctAmt()).abs();
					
					if(rcvApplStsCd.equals("APP")){			//Process APP status
						
						OTSDistributionVO otsDistributionVO = new OTSDistributionVO();
						
						//Search outstanding distribution info
						otsDistributionVO = dbDao.searchOTSDistribution(otsHisSeq, chgTpCd);
						
						dtrbSrcTpCd = "REC";
						acctMtxSeq = otsDistributionVO.getRecAcctMtxSeq();
						dtrbCdCmbSeq = otsDistributionVO.getOtsCdCmbSeq();
						currCd = otsDistributionVO.getCurrCd();
						custCntCd = otsDistributionVO.getBilToCustCntCd();
						custSeq = otsDistributionVO.getBilToCustSeq();
						balOtsAmt = new BigDecimal(otsDistributionVO.getBalAmt());
					} else {		
						dtrbSrcTpCd = rcvApplStsCd;
						currCd = receiptMainVO.getRctCurrCd();
						custCntCd = receiptMainVO.getRctCustCntCd();
						custSeq = receiptMainVO.getRctCustSeq();
						
						if(rcvApplStsCd.equals("UNID")){
							custCntCd = "";
							custSeq = "";
						} else if(rcvApplStsCd.equals("UNAPP") && "".equals(custCntCd) && "".equals(custSeq)){
							custCntCd = receiptMainVO.getBfrCustCntCd();
							custSeq = receiptMainVO.getBfrCustSeq();
						}
						
						if(rcvApplStsCd.equals("CASH")){		//Process CASH status
							dtrbCdCmbSeq = bankAcctCmbSeqVO.getAsetCdCmbSeq();
							acctMtxSeq = "-1";
						} else {		//Process UNID/UNAPP/WRTF status
							ReceiptAccountCondVO receiptAccountCondVO = new ReceiptAccountCondVO();
							ReceiptAccountVO receiptAccountVO = new ReceiptAccountVO();
							
							if(rcvApplStsCd.equals("WRTF")){
								receiptAccountCondVO.setAcctCtnt1("WRTF");
								receiptAccountCondVO.setAcctTpCd(wrtfTpCd);
							} else {
								receiptAccountCondVO.setAcctCtnt1("RCT");
								receiptAccountCondVO.setAcctCtnt2(rcvApplStsCd);
								receiptAccountCondVO.setAcctTpCd(bankAcctCmbSeqVO.getBankAcctNo());
							}			
							receiptAccountCondVO.setGlDt(glDt);
							
							//Search account matrix info by RCT/WRTF
							receiptAccountVO = dbDao.searchReceiptAccount(receiptAccountCondVO);
							
							if(wrtfTpCd.equals("BC") && (receiptAccountVO == null || receiptAccountVO.getArAcctCd().equals(""))){
								dtrbCdCmbSeq = bankAcctCmbSeqVO.getChgCdCmbSeq();
								acctMtxSeq = "-1";
								
							} else if(!wrtfTpCd.equals("BC") && receiptAccountVO == null){
								throw new EventException(new ErrorHandler("SAR00034",new String[]{}).getMessage());
							
							} else {
								acctMtxSeq = receiptAccountVO.getAcctMtxSeq();
								
								LedgerCmbCondVO ledgerCmbCondVO = new LedgerCmbCondVO();
								
								ledgerCmbCondVO.setAsetCdCmbSeq(bankAcctCmbSeqVO.getAsetCdCmbSeq());
								ledgerCmbCondVO.setAcctCtnt1(receiptAccountCondVO.getAcctCtnt1());
								ledgerCmbCondVO.setAcctCtnt3(receiptAccountVO.getAcctCtnt3());
								ledgerCmbCondVO.setArAcctCd(receiptAccountVO.getArAcctCd());
								ledgerCmbCondVO.setGlDt(glDt);
								
								//Search ledger code combination sequence (Chart of Account sequence)
								dtrbCdCmbSeq = dbDao.searchLedgerCombination(ledgerCmbCondVO);
								
								if(dtrbCdCmbSeq == null || dtrbCdCmbSeq.equals("")){
									dbDao.addLedgerCombinationForReceipt(ledgerCmbCondVO);
									dtrbCdCmbSeq = dbDao.searchLedgerCombination(ledgerCmbCondVO);
								}
							}
						}
					}
					
					if(dtrbCdCmbSeq == null || dtrbCdCmbSeq.equals("")){
						throw new EventException(new ErrorHandler("SAR00035",new String[]{}).getMessage());
					}
					
					rndAcctAmt = null;
					exhAcctAmt = null;
					
					//Calculate UNAPP/APP account amount by comparing previous balance amount and ending balance amount
					if(rcvApplStsCd.equals("UNAPP") && (aftRcvApplStsCd.equals("APP") || aftRcvApplStsCd.equals("WRTF"))){
						orgAcctAmt = acctAmt;
						
						if(unappCnt == 0){
							if(rctAmt.stripTrailingZeros().equals(balRctAmt.stripTrailingZeros())) bfrAcctBalAmt = balRctAmt.multiply(convXchRt).setScale(Integer.parseInt(fncCurrScale), BigDecimal.ROUND_HALF_UP);
							else bfrAcctBalAmt = bfrBalRctAcctAmt;
							
							aftBalRctAcctAmt = bfrAcctBalAmt;
						} else {
							bfrAcctBalAmt = balRctAmt.multiply(convXchRt).setScale(Integer.parseInt(fncCurrScale), BigDecimal.ROUND_HALF_UP);
						}
						
						aftAcctBalAmt = balRctAmt.add(aplyAmt).multiply(convXchRt).setScale(Integer.parseInt(fncCurrScale), BigDecimal.ROUND_HALF_UP);
						acctAmt = bfrAcctBalAmt.subtract(aftAcctBalAmt).abs();
						unappAcctAmt = acctAmt;
						
						if(aplyAmt.compareTo(new BigDecimal(0)) < 0) aftBalRctAcctAmt = aftBalRctAcctAmt.subtract(acctAmt);
						else aftBalRctAcctAmt = aftBalRctAcctAmt.add(acctAmt);
						
						//If UNAPP account exchange rate is equal to APP account exchange rate, calculate rounding account amount
						if(convXchRt.compareTo(aftConvXchRt) == 0) rndAcctAmt = acctAmt.subtract(orgAcctAmt);
						
						balRctAmt = balRctAmt.add(aplyAmt);
						
						unappCnt++;
						
					} else if(rcvApplStsCd.equals("APP")){
						orgAcctAmt = acctAmt;
						bfrAcctBalAmt = balOtsAmt.multiply(convXchRt).setScale(Integer.parseInt(fncCurrScale), BigDecimal.ROUND_HALF_UP);
						aftAcctBalAmt = balOtsAmt.subtract(aplyAmt).multiply(convXchRt).setScale(Integer.parseInt(fncCurrScale), BigDecimal.ROUND_HALF_UP);
						acctAmt = bfrAcctBalAmt.subtract(aftAcctBalAmt).abs();
						
						//If UNAPP account exchange rate is equal to APP account exchange rate, calculate rounding account amount
						//If UNAPP account exchange rate is not equal to APP account exchange rate, calculate exchange gain/loss account amount
						if(bfrConvXchRt != null){
							if(convXchRt.compareTo(bfrConvXchRt) == 0){
								rndAcctAmt = acctAmt.subtract(orgAcctAmt);
							} else {
								if(unappAcctAmt != null){
									exhAcctAmt = unappAcctAmt.subtract(acctAmt);
								}	
							}
						}
					}
					
					//Set debit/credit amount by apply amount's sign
					if(aplyAmt.compareTo(new BigDecimal(0)) > 0){
						inpDrAmt = "";
						inpCrAmt = aplyAmt.toString();
						acctDrAmt = "";
						acctCrAmt = acctAmt.toString();
					} else if(aplyAmt.compareTo(new BigDecimal(0)) < 0){
						inpDrAmt = aplyAmt.abs().toString();
						inpCrAmt = "";
						acctDrAmt = acctAmt.toString();
						acctCrAmt = "";
					} else {
						if(i == 0){
							inpDrAmt = aplyAmt.toString();
							inpCrAmt = "";
							acctDrAmt = acctAmt.toString();
							acctCrAmt = "";
						} else {
							inpDrAmt = "";
							inpCrAmt = aplyAmt.toString();
							acctDrAmt = "";
							acctCrAmt = acctAmt.toString();
						}	
					}
					
					ReceiptDistributionVO receiptDistributionVO = new ReceiptDistributionVO();
					
					receiptDistributionVO.setDtrbSrcSeq(dtrbSrcSeq);
					receiptDistributionVO.setDtrbSrcTblCd("RCT");
					receiptDistributionVO.setDtrbSrcTpCd(dtrbSrcTpCd);
					receiptDistributionVO.setDtrbCdCmbSeq(dtrbCdCmbSeq);
					receiptDistributionVO.setInpDrAmt(inpDrAmt);
					receiptDistributionVO.setInpCrAmt(inpCrAmt);
					receiptDistributionVO.setAcctDrAmt(acctDrAmt);
					receiptDistributionVO.setAcctCrAmt(acctCrAmt);
					receiptDistributionVO.setOrzSeq("-1");
					receiptDistributionVO.setFmDtrbSrcSeq(fmDtrbSrcSeq);
					receiptDistributionVO.setCurrCd(currCd);
					receiptDistributionVO.setConvXchRt(convXchRt.toString());
					receiptDistributionVO.setAcctXchRtLvl(acctXchRtLvl);
					receiptDistributionVO.setAcctXchRtDt(acctXchRtDt);
					receiptDistributionVO.setCustCntCd(custCntCd);
					receiptDistributionVO.setCustSeq(custSeq);
					receiptDistributionVO.setCreUsrId(creUsrId);
					receiptDistributionVO.setUpdUsrId(updUsrId);
	
					//Create receipt distribution info(CASH/UNID/UNAPP/REC/WRTF)
					dbDao.addReceiptDistribution(receiptDistributionVO);
					
					//Update combination sequence and account matrix sequence in receivable application info
					receivableApplVOs.get(i).setAcctMtxSeq(acctMtxSeq);
					receivableApplVOs.get(i).setRcvCdCmbSeq(dtrbCdCmbSeq);
					dbDao.modifyReceivableApplCmbSeq(receivableApplVOs.get(i));
					
					dtrbSrcTpCd = "";
					
					//If UNAPP/APP rounding account amount exists, set debit/credit rounding amount
					if(rndAcctAmt != null && rndAcctAmt.compareTo(new BigDecimal(0)) != 0){
						dtrbSrcTpCd = "HDR_RND";
						
						if((aplyAmt.compareTo(new BigDecimal(0)) < 0 && rndAcctAmt.compareTo(new BigDecimal(0)) > 0) ||
						   (aplyAmt.compareTo(new BigDecimal(0)) > 0 && rndAcctAmt.compareTo(new BigDecimal(0)) < 0)){
							inpDrAmt = "";
							inpCrAmt = "0";
							acctDrAmt = "";
							acctCrAmt = rndAcctAmt.abs().toString();
						} else {
							inpDrAmt = "0";
							inpCrAmt = "";
							acctDrAmt = rndAcctAmt.abs().toString();
							acctCrAmt = "";
						}
					}
			
					//If exchange gain/loss account amount exists, set debit/credit exchange gain/loss amount
					if(exhAcctAmt != null && exhAcctAmt.compareTo(new BigDecimal(0)) != 0){
						if((aplyAmt.compareTo(new BigDecimal(0)) < 0 && exhAcctAmt.compareTo(new BigDecimal(0)) > 0) ||
						   (aplyAmt.compareTo(new BigDecimal(0)) > 0 && exhAcctAmt.compareTo(new BigDecimal(0)) < 0)){
							dtrbSrcTpCd = "EXCH_LOSS";
							
							inpDrAmt = "0";
							inpCrAmt = "";
							acctDrAmt = exhAcctAmt.abs().toString();
							acctCrAmt = "";
						} else {
							dtrbSrcTpCd = "EXCH_GAIN";
							
							inpDrAmt = "";
							inpCrAmt = "0";
							acctDrAmt = "";
							acctCrAmt = exhAcctAmt.abs().toString();		
						}
					}
					
					if(!dtrbSrcTpCd.equals("")) {
						ReceiptAccountCondVO receiptAccountCondVO = new ReceiptAccountCondVO();
						ReceiptAccountVO receiptAccountVO = new ReceiptAccountVO();
						
						receiptAccountCondVO.setAcctCtnt1("SYS");
						receiptAccountCondVO.setAcctTpCd(dtrbSrcTpCd);
						receiptAccountCondVO.setGlDt(glDt);
						
						//Search account matrix info by SYS(round, exchange gain/loss)
						receiptAccountVO = dbDao.searchReceiptAccount(receiptAccountCondVO);
						
						if(receiptAccountVO == null){
							throw new EventException(new ErrorHandler("SAR00034",new String[]{}).getMessage());
						}
						
						LedgerCmbCondVO ledgerCmbCondVO = new LedgerCmbCondVO();
						
						ledgerCmbCondVO.setAsetCdCmbSeq(dtrbCdCmbSeq);
						ledgerCmbCondVO.setAcctCtnt1(receiptAccountCondVO.getAcctCtnt1());
						ledgerCmbCondVO.setAcctCtnt2(receiptAccountVO.getAcctCtnt2());
						ledgerCmbCondVO.setAcctCtnt3(receiptAccountVO.getAcctCtnt3());
						ledgerCmbCondVO.setArAcctCd(receiptAccountVO.getArAcctCd());
						ledgerCmbCondVO.setGlDt(glDt);
						
						//Search ledger code combination sequence (Chart of Account sequence)
						dtrbCdCmbSeq = dbDao.searchLedgerCombination(ledgerCmbCondVO);

						if(dtrbCdCmbSeq == null || dtrbCdCmbSeq.equals("")){
							//throw new EventException(new ErrorHandler("SAR00035",new String[]{}).getMessage());
							
							dbDao.addLedgerCombinationForReceipt(ledgerCmbCondVO);
							dtrbCdCmbSeq = dbDao.searchLedgerCombination(ledgerCmbCondVO);
						}
						
						ReceiptDistributionVO rndExchDtrbVO = new ReceiptDistributionVO();
						
						rndExchDtrbVO.setDtrbSrcSeq(dtrbSrcSeq);
						rndExchDtrbVO.setDtrbSrcTblCd("RCT");
						rndExchDtrbVO.setDtrbSrcTpCd(dtrbSrcTpCd);
						rndExchDtrbVO.setDtrbCdCmbSeq(dtrbCdCmbSeq);
						rndExchDtrbVO.setInpDrAmt(inpDrAmt);
						rndExchDtrbVO.setInpCrAmt(inpCrAmt);
						rndExchDtrbVO.setAcctDrAmt(acctDrAmt);
						rndExchDtrbVO.setAcctCrAmt(acctCrAmt);
						rndExchDtrbVO.setOrzSeq("-1");
						rndExchDtrbVO.setFmDtrbSrcSeq(fmDtrbSrcSeq);
						rndExchDtrbVO.setCurrCd(currCd);
						rndExchDtrbVO.setCustCntCd(custCntCd);
						rndExchDtrbVO.setCustSeq(custSeq);
						rndExchDtrbVO.setCreUsrId(creUsrId);
						rndExchDtrbVO.setUpdUsrId(updUsrId);
						
						//Create receipt distribution info(HDR_RND, EXCH_GAIN, EXCH_LOSS)
						dbDao.addReceiptDistribution(rndExchDtrbVO);
					}
					
				} else {		//Process accounting in case of reversing or canceling receipt info
					//Create reverse or cancel distribution info
					dbDao.addReverseCancelDistribution(receivableApplVOs.get(i));
					//Update combination sequence and account matrix sequence in receivable application info
					dbDao.modifyReceivableApplCmbSeq(receivableApplVOs.get(i));
					
					if(saveKindCd.equals("R") && receivableApplVOs.get(i).getRcvApplStsCd().equals("UNAPP")){
						aftBalRctAcctAmt = aftBalRctAcctAmt.add(new BigDecimal(dbDao.searchDtrbAcctAmt(receivableApplVOs.get(i))));
					}
					
					if(i == receivableApplVOs.size() - 1) aftBalRctAcctAmt = aftBalRctAcctAmt.add(bfrBalRctAcctAmt);
				}
			}
			
			if(receivableApplVOs.size() > 0) {
				dbDao.modifyBalRctAcctAmt(receiptMainVO.getRctSeq(), aftBalRctAcctAmt.toString());
			}
			
			//Sakura interface
			AccountReceivableCollectIFBC sakuraIFBC = new AccountReceivableCollectIFBCImpl();
			sakuraIFBC.createReceiptSakuraIFdata(receiptMainVO.getRctNo(),"P");
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Search refund info for AP interface<br> 
	 * 
	 * @param ReceiptMainVO receiptMainVO
	 * @param ApplyHeaderVO[] applyHeaderVOs
	 * @param String usrId
	 * @return List<ReceiptForAPInterfaceVO>
	 * @exception EventException
	 */
	public List<ReceiptForAPInterfaceVO> searchReceiptForAPInterface(ReceiptMainVO receiptMainVO, ApplyHeaderVO[] applyHeaderVOs, String usrId) throws EventException{
		
		try {
			
			String rctNo = "";
			String saveKindCd = "";
			String aplyHdrSeq = "";
			String ofcCd = "";
			String glDt = "";
			String vndrNo = "";
			String apHdrCmbSeq = "";
			String apLineCmbSeq = "";
			String clrAcctCd = "";
			String payAcctCd = "";
			String rcvCdCmbSeq = "";
			String acctCtnt3 = "";
			String interCoCd = "";
			String genPayTermCd = "";
			String payGrpLuCd = "";
			String apCtrCd = "";
			String apPayMzdLuCd = "";
			String attrCateNm = "";
			
			AccountReceivableCommonDBDAO arComDao = new AccountReceivableCommonDBDAO();
			List<ReceiptForAPInterfaceVO> receiptForAPInterfaceVOs = new ArrayList<ReceiptForAPInterfaceVO>();
			List<String> aplyHdrSeqList = new ArrayList<String>();
			
			rctNo = receiptMainVO.getRctNo();
			saveKindCd = receiptMainVO.getSaveKindCd();
			
			if(applyHeaderVOs != null){
				for(int i = 0; i < applyHeaderVOs.length; i++){
					aplyHdrSeq = applyHeaderVOs[i].getRctAplyHdrSeq();
					aplyHdrSeqList.add(aplyHdrSeq);
				}
			}
	
			List<RctHdrSeqTmpVO> rctHdrSeqTmpVOs = new ArrayList<RctHdrSeqTmpVO>(); 				
			
			for(int i = 0; i < aplyHdrSeqList.size(); i++){
				
				RctHdrSeqTmpVO rctHdrSeqTmpVO = new RctHdrSeqTmpVO();
				rctHdrSeqTmpVO.setRctAplyHdrSeq(aplyHdrSeqList.get(i));
				rctHdrSeqTmpVOs.add(rctHdrSeqTmpVO);					
			}
			
			dbDao.addRctHdrSeqTmp(rctHdrSeqTmpVOs);

			//Search receipt info for AP interface (refund process)
			receiptForAPInterfaceVOs = dbDao.searchReceiptForAPInterface(rctNo, aplyHdrSeqList, saveKindCd, usrId);
			
			if(receiptForAPInterfaceVOs != null){
				for(int i = 0; i < receiptForAPInterfaceVOs.size(); i++){
					VendorInfoVO vendorInfoVO = new VendorInfoVO(); 
					PayGroupInfoVO payGroupInfoVO = new PayGroupInfoVO();
					APCombinationSeqCondVO apCombinationSeqCondVO = new APCombinationSeqCondVO();
					
					ofcCd = receiptForAPInterfaceVOs.get(i).getOfcCd();
					glDt = receiptForAPInterfaceVOs.get(i).getGlDt();
					vndrNo = receiptForAPInterfaceVOs.get(i).getVndrNo();
					clrAcctCd = receiptForAPInterfaceVOs.get(i).getClrAcctCd();
					payAcctCd = receiptForAPInterfaceVOs.get(i).getPayAcctCd();
					rcvCdCmbSeq = receiptForAPInterfaceVOs.get(i).getRcvCdCmbSeq();
					acctCtnt3 = receiptForAPInterfaceVOs.get(i).getAcctCtnt3();
					
					//Check AP period status by AP G/L date
					if(!arComDao.checkAPPeriod(ofcCd, glDt)){
						throw new EventException(new ErrorHandler("SAR00003",new String[]{"AP period status"}).getMessage());
					}
					
					//Search vendor info by vendor number
					vendorInfoVO = arComDao.searchVendorInfo(vndrNo);
					
					if(vendorInfoVO == null){
						throw new EventException(new ErrorHandler("SAR00039",new String[]{}).getMessage());
					} else {	
						interCoCd = vendorInfoVO.getInterCoCd();
						genPayTermCd = vendorInfoVO.getGenPayTermCd();
						apPayMzdLuCd = vendorInfoVO.getApPayMzdLuCd();
						
						if(interCoCd.equals("") || genPayTermCd.equals("") || apPayMzdLuCd.equals("")){
							throw new EventException(new ErrorHandler("SAR00039",new String[]{}).getMessage());
						}
					}
					
					//Search pay group info by AP office code
					payGroupInfoVO = arComDao.searchPayGroupInfo(ofcCd);
					
					if(payGroupInfoVO == null){
						throw new EventException(new ErrorHandler("SAR00040",new String[]{}).getMessage());
					} else {	
						payGrpLuCd = payGroupInfoVO.getPayGrpLuCd();
						apCtrCd = payGroupInfoVO.getApCtrCd();
						attrCateNm = payGroupInfoVO.getAttrCateNm();
						
						if(payGrpLuCd.equals("")){
							throw new EventException(new ErrorHandler("SAR00043",new String[]{}).getMessage());
						} else if(apCtrCd.equals("")){
							throw new EventException(new ErrorHandler("SAR00044",new String[]{}).getMessage());
						}
					}
					
					apCombinationSeqCondVO.setApCtrCd(apCtrCd);
					apCombinationSeqCondVO.setApIfTblTpCd("HEADER");
					apCombinationSeqCondVO.setClrAcctCd(clrAcctCd);
					apCombinationSeqCondVO.setPayAcctCd(payAcctCd);
					apCombinationSeqCondVO.setInterCoCd(interCoCd);
					apCombinationSeqCondVO.setRcvCdCmbSeq(rcvCdCmbSeq);
					apCombinationSeqCondVO.setAcctCtnt3(acctCtnt3);
					
					//Search AP header combination sequence
					apHdrCmbSeq = dbDao.searchAPCombinationSeq(apCombinationSeqCondVO);
					
					if(apHdrCmbSeq == null || apHdrCmbSeq.equals("")){
						//throw new EventException(new ErrorHandler("SAR00035",new String[]{}).getMessage());
						
						dbDao.addLedgerCombinationForAPInterface(apCombinationSeqCondVO);
						apHdrCmbSeq = dbDao.searchAPCombinationSeq(apCombinationSeqCondVO);
					}
					
					apCombinationSeqCondVO.setApIfTblTpCd("LINE");
					
					//Search AP line combination sequence
					apLineCmbSeq = dbDao.searchAPCombinationSeq(apCombinationSeqCondVO);
					
					if(apLineCmbSeq == null || apLineCmbSeq.equals("")){
						//throw new EventException(new ErrorHandler("SAR00035",new String[]{}).getMessage());
						
						dbDao.addLedgerCombinationForAPInterface(apCombinationSeqCondVO);
						apLineCmbSeq = dbDao.searchAPCombinationSeq(apCombinationSeqCondVO);
					}
					
					receiptForAPInterfaceVOs.get(i).setInvTermNm(genPayTermCd);
					receiptForAPInterfaceVOs.get(i).setAttrCateNm(attrCateNm);
					receiptForAPInterfaceVOs.get(i).setApPayMzdLuCd(apPayMzdLuCd);
					receiptForAPInterfaceVOs.get(i).setPayGrpLuCd(payGrpLuCd);
					receiptForAPInterfaceVOs.get(i).setLiabCdCmbSeq(apHdrCmbSeq);
					receiptForAPInterfaceVOs.get(i).setDtrbCdCmbSeq(apLineCmbSeq);
				
				}
			}
				
			return receiptForAPInterfaceVOs;
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Update AP interface status to Apply Detail info<br> 
	 * 
	 * @param List<ReceiptForAPInterfaceVO> receiptForAPInterfaceVOs
	 * @param String saveKindCd
	 * @param String usrId
	 * @exception EventException
	 */
	public void modifyAPInterfaceStatus(List<ReceiptForAPInterfaceVO> receiptForAPInterfaceVOs, String saveKindCd, String usrId) throws EventException{
		
		try {
		
			String apIfCd = "";
			
			if(saveKindCd.equals("S")) apIfCd = "I";
			else apIfCd = "R";
			
			for(int i = 0; i < receiptForAPInterfaceVOs.size(); i++){
				APInterfaceStatusVO apInterfaceStatusVO = new APInterfaceStatusVO();
				
				apInterfaceStatusVO.setApIfCd(apIfCd);
				apInterfaceStatusVO.setRctAplyDtlSeq(receiptForAPInterfaceVOs.get(i).getRctAplyDtlSeq());
				apInterfaceStatusVO.setUpdUsrId(usrId);
				
				dbDao.modifyAPInterfaceStatus(apInterfaceStatusVO);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
     * searchReceiptListByBankDate <br>
     * 
     * @author 		SHIN
     * @category 	STM_SAR_2004
     * @category	searchReceiptListByBankDate
     * @param 		ReceiptListByBankConditionVO condVO       
     * @return		List<ReceiptListByBankDateVO>
     * @throws 		EventException
     */  
    public List<ReceiptListByBankDateVO> searchReceiptListByBankDate( ReceiptListByBankConditionVO condVO) throws EventException {
    	try {
    		 List<ReceiptListByBankDateVO> returnList = dbDao.searchReceiptListByBankDate(condVO); 
   		
    		 return returnList;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
    } 
    
    /**
     * searchReceiptListByBankDate <br>
     * 
     * @author 		SHIN
     * @category 	STM_SAR_2004
     * @category	searchReceiptListByBank
     * @param 		ReceiptListByBankConditionVO condVO       
     * @return		List<ReceiptListByBankVO>
     * @throws 		EventException
     */  
    public List<ReceiptListByBankVO> searchReceiptListByBank( ReceiptListByBankConditionVO condVO) throws EventException {
    	try {
    		 List<ReceiptListByBankVO> returnList = dbDao.searchReceiptListByBank(condVO); 
   		
    		 return returnList;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
    }    	   	

    /**
     * searchReceiptListByCheque <br>
     * 
     * @author 		SHIN
     * @category 	STM_SAR_2003
     * @category	searchReceiptListByCheque
     * @param 		ReceiptListByChequeCondVO condVO       
     * @return		List<ReceiptListByChequeVO> 
     * @throws 		EventException
     */  
    public List<ReceiptListByChequeVO> searchReceiptListByCheque( ReceiptListByChequeCondVO condVO) throws EventException {
    	try {
    		 List<ReceiptListByChequeVO> returnList = dbDao.searchReceiptListByCheque(condVO); 
   		
    		 return returnList;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
    }       
    
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
    public List<ReceiptListByDetailVO> searchReceiptListByDetail( ReceiptListByDetailCondVO receiptListByDetailCondVO) throws EventException {
    	try {
    		 List<ReceiptListByDetailVO> returnList = dbDao.searchReceiptListByDetail(receiptListByDetailCondVO); 
   		
    		 if(returnList != null && returnList.size() > 0) {
    			 returnList.get(0).setMaxRows(Integer.parseInt(returnList.get(0).getTotalCnt()));
    		 }
    		 return returnList;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
    }    	   	
    
    /**
	 * Search open ASA list<br> 
	 * 
	 * @param String agnCd
	 * @param String rctNo
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchOpenASAList(String agnCd, String rctNo) throws EventException{
		
		try {
			
			List<String> list = dbDao.searchOpenASAList(agnCd, rctNo);
			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
    /**
     * Search Receipts view accounting
     * @author jinyoonoh 2014. 7. 16.
     * @param RCTViewAccountingListVO vo
     * @return List<RCTViewAccountingListVO>
     * @throws EventException
     */
    public List<RCTViewAccountingListVO> searchRCTViewAccountingList(RCTViewAccountingListVO vo) throws EventException {
		try {
			
			List<RCTViewAccountingListVO> list = dbDao.searchRCTViewAccountingList(vo);
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
    }
    
    /**
	 * Search OTS Header from Temp<br> 
	 * 
	 * @param String otsRctTmpSeq
	 * @return List<ApplyHeaderVO>
	 * @exception EventException
	 */
	public List<ApplyHeaderVO> searchOutstandingReceiptHdrTemp(String otsRctTmpSeq) throws EventException{
		
		try {
			
			List<ApplyHeaderVO> applyHeaderVO = dbDao.searchOutstandingReceiptHdrTemp(otsRctTmpSeq);
			
			return applyHeaderVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search OTS Detail from Temp<br> 
	 * 
	 * @param String otsRctTmpSeq
	 * @return List<ApplyDetailVO>
	 * @exception EventException
	 */
	public List<ApplyDetailVO> searchOutstandingReceiptDtlTemp(String otsRctTmpSeq) throws EventException{
		
		try {
			
			List<ApplyDetailVO>	applyDetailVO = dbDao.searchOutstandingReceiptDtlTemp(otsRctTmpSeq);
			
			return applyDetailVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search Apply Total Amount from Temp<br> 
	 * 
	 * @param String otsRctTmpSeq
	 * @return String
	 * @exception EventException
	 */
	public String searchOTSTempTotalAmount(String otsRctTmpSeq) throws EventException{
		
		try {
			
			return dbDao.searchOTSTempTotalAmount(otsRctTmpSeq);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
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
	public String manageReceipt(ReceiptMainVO receiptMainVO, ApplyHeaderVO[] applyHeaderVOs, ApplyDetailVO[] applyDetailVOs, String lginUsrId, String lginOfcCd) throws EventException {
		try {
			
			AccountReceivableReceiptBackEndJob accountReceivableReceiptBackEndJob = new AccountReceivableReceiptBackEndJob();
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			
			accountReceivableReceiptBackEndJob.setReceiptMainVO(receiptMainVO);
			accountReceivableReceiptBackEndJob.setApplyHeaderVOs(applyHeaderVOs);
			accountReceivableReceiptBackEndJob.setApplyDetailVOs(applyDetailVOs);
			accountReceivableReceiptBackEndJob.setLginUsrId(lginUsrId);
			accountReceivableReceiptBackEndJob.setLginOfcCd(lginOfcCd);
			
			String backEndJobKey = backEndJobManager.execute(accountReceivableReceiptBackEndJob, lginUsrId, "manageReceipt");
			
			return backEndJobKey;
			
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Rct_no 를 조회하기 위한 BackEndJob의 결과<br>
	 * 
	 * @param String backendjobKey
	 * @return String
	 * @exception EventException
	 */
	public String searchReceiptBackEndJobFile(String backendjobKey) throws EventException {
		try {
			return dbDao.searchReceiptBackEndJobFile(backendjobKey);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}
	}
	
	/**
	 * Search Apply Total Amount<br> 
	 * 
	 * @param String rctOfcCd
	 * @param String rctNo
	 * @return String
	 * @exception EventException
	 */
	public String searchApplyTotalAmount(String rctOfcCd, String rctNo) throws EventException{
		
		try {
			
			return dbDao.searchApplyTotalAmount(rctOfcCd, rctNo);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
}