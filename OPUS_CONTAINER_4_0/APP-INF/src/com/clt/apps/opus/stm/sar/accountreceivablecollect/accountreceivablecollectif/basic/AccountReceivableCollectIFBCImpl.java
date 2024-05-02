/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : AccountReceivableCollectIFBCImpl.java
 *@FileTitle : AccountReceivableCollectIFBCImpl
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
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.intergration.AccountReceivableCollectIFDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.vo.SaKuraIFVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * AccountReceivableCollectIFBCImpl Business Logic BusinessCommand 
 * - Handling AccountReceivableCollectIFBCImpl Business transaction.
 * 
 * @author 
 * @see AccountReceivableCollectIFDBDAO
 * @since J2EE 1.6
 */ 
public class AccountReceivableCollectIFBCImpl extends BasicCommandSupport implements AccountReceivableCollectIFBC {	

	// Database Access Object
    private transient AccountReceivableCollectIFDBDAO dbDao = null;  
    
    /**
	 * AccountReceivableReceiptBCImpl object creation.<br>
	 * AccountReceivableReceiptDBDAO creation.<br>
	 */
    public AccountReceivableCollectIFBCImpl()
    {
        dbDao = new AccountReceivableCollectIFDBDAO();    
    }
    
    /**
   	 * Create SAKURA INTERFACEDATA<br> 
   	 * SAR_AR_IF 참조
   	 * @param String rctNo
   	 * @param String Status
   	 * @exception EventException
   	 */
   	public void createReceiptSakuraIFdata(String rctNo,String Status) {
   		List<SaKuraIFVO> sarIFlist = new ArrayList<SaKuraIFVO>();
   		List<SaKuraIFVO> otsDtrblist = new ArrayList<SaKuraIFVO>();
   		HashMap<String, String> ifSeqMap = new HashMap<String, String>();
   		try {
			sarIFlist = dbDao.searchIFSakuraReceiptList(rctNo,Status,"Y");
			otsDtrblist = dbDao.searchIFSakuraReceiptList(rctNo,Status,"N");
			String  orgIfSeqNo = "";
			String  ifSeqNo = "";
			String  rvsFlg = "";
			
   			for (int i = 0; i < sarIFlist.size(); i++) {
				sarIFlist.get(i).setArIfSeq(dbDao.searchSakuraIFSeq());
				sarIFlist.get(i).setArIfStsCd("Y");
				if(orgIfSeqNo.equals("") || !orgIfSeqNo.equals(sarIFlist.get(i).getIfSeqNo()) ||
						rvsFlg.equals("") || !rvsFlg.equals(sarIFlist.get(i).getRvsFlg())
						){
					ifSeqNo = dbDao.searchSakuraArIFToSeq();
					ifSeqMap.put(sarIFlist.get(i).getRvsFlg() + ":" + sarIFlist.get(i).getIfSeqNo(), ifSeqNo);
				}
				orgIfSeqNo = sarIFlist.get(i).getIfSeqNo();
				rvsFlg = sarIFlist.get(i).getRvsFlg();
				sarIFlist.get(i).setIfSeqNo(ifSeqNo);
			}
   				
   			for (int i = 0; i < otsDtrblist.size(); i++) {
   				otsDtrblist.get(i).setArIfSeq(ifSeqMap.get(otsDtrblist.get(i).getRvsFlg() + ":" + otsDtrblist.get(i).getIfSeqNo()));
   				otsDtrblist.get(i).setArIfStsCd("Y");
			}
   		} catch (DAOException ex) { 
   			log.error(rctNo + " createReceiptSakuraIFdata search");
   			log.error("err " + ex.toString(), ex);
   		} 
   		
   		try {
			if(sarIFlist.size() > 0){ 
				//throw new Exception("Test Error");
				dbDao.addSarIFData(sarIFlist);
				dbDao.modifyDtrbStatus(otsDtrblist);
				
				Iterator iter = ifSeqMap.entrySet().iterator();
				while (iter.hasNext()) {
					Map.Entry mEntry = (Map.Entry) iter.next();
					String ifSeqNo =  mEntry.getValue().toString(); 
					//update status 'H' 
					dbDao.modifyHoldingStatus(ifSeqNo);
					//verify status 'H'
					dbDao.modifyReCheckHoldingStatus(ifSeqNo);
				}
			} 
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			try {	
				String arIfErrDesc = ex.getMessage();
				for (int i = 0; i < otsDtrblist.size(); i++) {
					otsDtrblist.get(i).setArIfStsCd("E");
					otsDtrblist.get(i).setArIfErrDesc(arIfErrDesc);
				} 
				dbDao.modifyDtrbStatus(otsDtrblist);
				
				for (int i = 0; i < sarIFlist.size(); i++) {
					sarIFlist.get(i).setIfFlg("E");
					sarIFlist.get(i).setErpIfErrFlg("E");					
					sarIFlist.get(i).setArIfErrDesc(arIfErrDesc);
				} 
				modifySakuraIFErrRsn(sarIFlist);				
				
			} catch (Exception e) {
				log.error(rctNo + " modifyDtrbStatus");
				log.error("err " + e.toString(), e);
			}	
		}
   	}
   	
    /**
   	 * Create SAKURA INTERFACEDATA<br> 
   	 * SAR_AR_IF 참조
   	 * @param String arOffstNo
   	 * @param String Status
   	 * @exception EventException
   	 */
   	public void createOffsetSakuraIFdata(String arOffstNo,String Status) {
   		List<SaKuraIFVO> sarIFlist = new ArrayList<SaKuraIFVO>();
   		List<SaKuraIFVO> otsDtrblist = new ArrayList<SaKuraIFVO>();
   		HashMap<String, String> ifSeqMap = new HashMap<String, String>();
   		try {
   			sarIFlist = dbDao.searchIFSakuraOffsetList(arOffstNo,Status,"Y");
   			otsDtrblist = dbDao.searchIFSakuraOffsetList(arOffstNo,Status,"N");
   			String  ifSeqNo = "";
   			String currCd = "";
   			String  rvsFlg = "";
			
   			for (int i = 0; i < sarIFlist.size(); i++) {
				sarIFlist.get(i).setArIfSeq(dbDao.searchSakuraIFSeq());
				sarIFlist.get(i).setArIfStsCd("Y");
				
				if(currCd.equals("") || !currCd.equals(sarIFlist.get(i).getCurrCd()) ||
						rvsFlg.equals("") || !rvsFlg.equals(sarIFlist.get(i).getRvsFlg())
						){
					ifSeqNo = dbDao.searchSakuraArIFToSeq();
					ifSeqMap.put(sarIFlist.get(i).getRvsFlg() + ":" + sarIFlist.get(i).getCurrCd(), ifSeqNo);
				}
				currCd = sarIFlist.get(i).getCurrCd();
				rvsFlg = sarIFlist.get(i).getRvsFlg();
				sarIFlist.get(i).setIfSeqNo(ifSeqNo);
			}
   			
   			for (int i = 0; i < otsDtrblist.size(); i++) {
   				otsDtrblist.get(i).setArIfSeq(ifSeqMap.get(otsDtrblist.get(i).getRvsFlg() + ":" + otsDtrblist.get(i).getCurrCd()));
   				otsDtrblist.get(i).setArIfStsCd("Y");
			}
   		} catch (DAOException ex) {
   			log.error(arOffstNo + " createOffsetSakuraIFdata search");
   			log.error("err " + ex.toString(), ex);
   		} 
   		
   		try {
			if(sarIFlist.size() > 0){
				dbDao.addSarIFData(sarIFlist);
				dbDao.modifyDtrbStatus(otsDtrblist);
				
				Iterator iter = ifSeqMap.entrySet().iterator();
				while (iter.hasNext()) {
					Map.Entry mEntry = (Map.Entry) iter.next();
					String ifSeqNo =  mEntry.getValue().toString(); 
					//update status 'H' 
					dbDao.modifyHoldingStatus(ifSeqNo);
					//verify status 'H'
					dbDao.modifyReCheckHoldingStatus(ifSeqNo);
				}
			} 
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			try {	
				String arIfErrDesc = ex.getMessage();
				for (int i = 0; i < otsDtrblist.size(); i++) {
					otsDtrblist.get(i).setArIfStsCd("E");
					otsDtrblist.get(i).setArIfErrDesc(arIfErrDesc);
				} 
				dbDao.modifyDtrbStatus(otsDtrblist);
				
				for (int i = 0; i < sarIFlist.size(); i++) {
					sarIFlist.get(i).setIfFlg("E");
					sarIFlist.get(i).setErpIfErrFlg("E");					
					sarIFlist.get(i).setArIfErrDesc(arIfErrDesc);
				} 
				modifySakuraIFErrRsn(sarIFlist);				
				
			} catch (Exception e) {
				log.error(arOffstNo + " modifyDtrbStatus");
				log.error("err " + e.toString(), e);
			}	
		}
   	}
   	
    /**
   	 * Create SAKURA INTERFACEDATA<br> 
   	 * SAR_AR_IF 참조
   	 * @param String adjNo
   	 * @param String Status
   	 * @exception EventException
   	 */
   	public void createAdjustSakuraIFdata(String adjNo,String Status) {
   		List<SaKuraIFVO> sarIFlist = new ArrayList<SaKuraIFVO>();
   		List<SaKuraIFVO> otsDtrblist = new ArrayList<SaKuraIFVO>();
   		HashMap<String, String> ifSeqMap = new HashMap<String, String>();
   		
   		try {
			sarIFlist = dbDao.searchIFSakuraAdjustList(adjNo,Status,"Y");
			otsDtrblist = dbDao.searchIFSakuraAdjustList(adjNo,Status,"N");
			String  ifSeqNo = "";
			String currCd = "";
			String rvsFlg = "";
			
   			for (int i = 0; i < sarIFlist.size(); i++) {
				sarIFlist.get(i).setArIfSeq(dbDao.searchSakuraIFSeq());
				sarIFlist.get(i).setArIfStsCd("Y");
				
				if(currCd.equals("") || !currCd.equals(sarIFlist.get(i).getCurrCd()) ||
						rvsFlg.equals("") || !rvsFlg.equals(sarIFlist.get(i).getRvsFlg())
						){
					ifSeqNo = dbDao.searchSakuraArIFToSeq();
					ifSeqMap.put(sarIFlist.get(i).getRvsFlg() + ":" + sarIFlist.get(i).getCurrCd(), ifSeqNo);
				}
				currCd = sarIFlist.get(i).getCurrCd();
				rvsFlg = sarIFlist.get(i).getRvsFlg();
				sarIFlist.get(i).setIfSeqNo(ifSeqNo);
			}
   			
   			for (int i = 0; i < otsDtrblist.size(); i++) {
   				otsDtrblist.get(i).setArIfSeq(ifSeqMap.get(otsDtrblist.get(i).getRvsFlg() + ":" + otsDtrblist.get(i).getCurrCd()));
   				otsDtrblist.get(i).setArIfStsCd("Y");
			}
   		} catch (DAOException ex) {
   			log.error(adjNo + " createAdjustSakuraIFdata search");
   			log.error("err " + ex.toString(), ex);
   		}  
   		
   		
   		try {
			if(sarIFlist.size() > 0){
				dbDao.addSarIFData(sarIFlist);
				dbDao.modifyDtrbStatus(otsDtrblist);
				
				Iterator iter = ifSeqMap.entrySet().iterator();
				while (iter.hasNext()) {
					Map.Entry mEntry = (Map.Entry) iter.next();
					String ifSeqNo =  mEntry.getValue().toString(); 
					//update status 'H' 
					dbDao.modifyHoldingStatus(ifSeqNo);
					//verify status 'H'
					dbDao.modifyReCheckHoldingStatus(ifSeqNo);
				}
			} 
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			try {	
				String arIfErrDesc = ex.getMessage();
				for (int i = 0; i < otsDtrblist.size(); i++) {
					otsDtrblist.get(i).setArIfStsCd("E");
					otsDtrblist.get(i).setArIfErrDesc(arIfErrDesc);
				} 
				dbDao.modifyDtrbStatus(otsDtrblist);
				
				for (int i = 0; i < sarIFlist.size(); i++) {
					sarIFlist.get(i).setIfFlg("E");
					sarIFlist.get(i).setErpIfErrFlg("E");					
					sarIFlist.get(i).setArIfErrDesc(arIfErrDesc);
				} 
				modifySakuraIFErrRsn(sarIFlist);				
				
			} catch (Exception e) {
				log.error(adjNo + " modifyDtrbStatus");
				log.error("err " + e.toString(), e);
			}	
		}
   	}
   	
    /**
   	 * Create SAKURA INTERFACEDATA<br> 
   	 * SAR_AR_IF 참조
   	 * @param String asaNo
   	 * @param String Status
   	 * @exception EventException
   	 */
   	public void createASASakuraIFdata(String asaNo,String Status) {
   		List<SaKuraIFVO> sarIFlist = new ArrayList<SaKuraIFVO>();
   		List<SaKuraIFVO> otsDtrblist = new ArrayList<SaKuraIFVO>();
   		HashMap<String, String> ifSeqMap = new HashMap<String, String>();
   		
   		try {
			sarIFlist = dbDao.searchIFSakuraASAList(asaNo,Status,"Y"); 
			otsDtrblist = dbDao.searchIFSakuraASAList(asaNo,Status,"N");
			
			String  ifSeqNo = "";
			String  rvsFlg = "";
			
   			for (int i = 0; i < sarIFlist.size(); i++) {
				sarIFlist.get(i).setArIfSeq(dbDao.searchSakuraIFSeq());
				sarIFlist.get(i).setArIfStsCd("Y");
				
				if(rvsFlg.equals("") || !rvsFlg.equals(sarIFlist.get(i).getRvsFlg())){
					ifSeqNo = dbDao.searchSakuraArIFToSeq();
					ifSeqMap.put(sarIFlist.get(i).getRvsFlg(), ifSeqNo);
				}
				rvsFlg = sarIFlist.get(i).getRvsFlg();
				sarIFlist.get(i).setIfSeqNo(ifSeqNo);
			}
   			
   			for (int i = 0; i < otsDtrblist.size(); i++) {
   				otsDtrblist.get(i).setArIfSeq(ifSeqMap.get(otsDtrblist.get(i).getRvsFlg()));
   				otsDtrblist.get(i).setArIfStsCd("Y");
			}
   		} catch (DAOException ex) {
   			log.error(asaNo + " createASASakuraIFdata search");
   			log.error("err " + ex.toString(), ex);
   		} 
   		
   		try {
			if(sarIFlist.size() > 0){
				//throw new Exception("Test Error");
				dbDao.addSarIFData(sarIFlist);
				dbDao.modifyDtrbStatus(otsDtrblist);
				
				Iterator iter = ifSeqMap.entrySet().iterator();
				while (iter.hasNext()) {
					Map.Entry mEntry = (Map.Entry) iter.next();
					String ifSeqNo =  mEntry.getValue().toString(); 
					//update status 'H' 
					dbDao.modifyHoldingStatus(ifSeqNo);
					//verify status 'H'
					dbDao.modifyReCheckHoldingStatus(ifSeqNo);
				}
			} 
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			try {	
				String arIfErrDesc = ex.getMessage();
				for (int i = 0; i < otsDtrblist.size(); i++) {
					otsDtrblist.get(i).setArIfStsCd("E");
					otsDtrblist.get(i).setArIfErrDesc(arIfErrDesc);
				} 
				dbDao.modifyDtrbStatus(otsDtrblist);	//sar_clt_dtrb
				
				for (int i = 0; i < sarIFlist.size(); i++) {
					sarIFlist.get(i).setIfFlg("E");
					sarIFlist.get(i).setErpIfErrFlg("E");					
					sarIFlist.get(i).setArIfErrDesc(arIfErrDesc);
				} 
				modifySakuraIFErrRsn(sarIFlist);				
				
			} catch (Exception e) {
				log.error(asaNo + " modifyDtrbStatus");
				log.error("err " + e.toString(), e);
			}	
		}
   	}
   	
   	
   	
   	/**
	 * Search Sakura REC BatchList<br> 
	 * 
	 * @return List<SaKuraIFVO>
	 * @exception EventException
	 */
	public List<SaKuraIFVO> searchSakuraRECBatchList() throws EventException{
		List<SaKuraIFVO> list = new ArrayList<SaKuraIFVO>();
		try {
			list = dbDao.searchIFSakuraReceiptList("","T","N");
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
	 * Search Sakura OFF BatchList<br> 
	 * 
	 * @return List<SaKuraIFVO>
	 * @exception EventException
	 */
	public List<SaKuraIFVO> searchSakuraOFFBatchList() throws EventException{
		List<SaKuraIFVO> list = new ArrayList<SaKuraIFVO>();
		try {
			list = dbDao.searchIFSakuraOffsetList("","T","N");
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
	 * Search Sakura ADJ BatchList<br> 
	 * 
	 * @return List<SaKuraIFVO>
	 * @exception EventException
	 */
	public List<SaKuraIFVO> searchSakuraADJBatchList() throws EventException{
		List<SaKuraIFVO> list = new ArrayList<SaKuraIFVO>();
		try {
			list = dbDao.searchIFSakuraAdjustList("","T","N");
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
	 * Search Sakura ASA BatchList<br> 
	 * 
	 * @return List<SaKuraIFVO>
	 * @exception EventException
	 */
	public List<SaKuraIFVO> searchSakuraASABatchList() throws EventException{
		List<SaKuraIFVO> list = new ArrayList<SaKuraIFVO>();
		try {
			list = dbDao.searchIFSakuraASAList("","T","N");
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
	 * Update Sakura Error Reason, Flag

	 * @param List<SaKuraIFVO> sarIFVOs
	 * @exception EventException
	 */
	public void modifySakuraIFErrRsn(List<SaKuraIFVO> sarIFVOs) throws EventException {
		try {
			dbDao.modifySakuraIFErrRsn(sarIFVOs); 			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}

	/**
	 * insert sakura interface data
	 * 
	 * @param List<SaKuraIFVO> sarIFVOs
	 * @exception EventException
	 */
	public void addSarIFData(List<SaKuraIFVO> sarIFVOs) throws EventException {
		try {
			dbDao.addSarIFData(sarIFVOs); 			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * Update Holding Status<br>
	 * 
	 * @param String ifSeqNo
	 * @throws EventException
	 */
	public void modifyHoldingStatus(String ifSeqNo) throws EventException {
		try {
			dbDao.modifyHoldingStatus(ifSeqNo); 			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Update Holding Status<br>
	 * 
	 * @param String ifSeqNo
	 * @throws EventException
	 */
	public void modifyReCheckHoldingStatus(String ifSeqNo) throws EventException {
		try {
			dbDao.modifyReCheckHoldingStatus(ifSeqNo); 			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}