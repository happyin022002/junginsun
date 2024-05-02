/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : AccountReceivableOutstandingIFBCImpl.java
 *@FileTitle : AccountReceivableOutstandingIFBCImpl
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
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.basic.AccountReceivableCollectIFBC;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.basic.AccountReceivableCollectIFBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingHistVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.integration.AccountReceivableOutstandingIFDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.vo.CheckIFSakuraVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.vo.SaKuraIFVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 * AccountReceivableOutstandingIFBCImpl Business Logic ServiceCommand 
 * - Handling AccountReceivableOutstandingIFBCImpl Business transaction.
 * 
 * @author 
 * @see AccountReceivableOutstandingIFDBDAO
 * @since J2EE 1.6
 */ 
public class AccountReceivableOutstandingIFBCImpl extends BasicCommandSupport implements AccountReceivableOutstandingIFBC {	

	// Database Access Object
	private transient AccountReceivableOutstandingIFDBDAO dbDao = null;
	
	/**
	 * AccountReceivableOutstandingIFBCImpl object creation.<br>
	 * AccountReceivableOutstandingIFDBDAO creation.<br>
	 */
	public AccountReceivableOutstandingIFBCImpl() {
		dbDao = new AccountReceivableOutstandingIFDBDAO();
	}
	
	/**
   	 * Create SAKURA INTERFACEDATA<br> 
   	 * SAR_AR_IF 참조
   	 * @param String kindSakura
   	 * @return String
   	 * @exception EventException
   	 */
    public String createSakuraBatch(String kindSakura) throws EventException {
    	String batResult = "";
    	try{  
	          ScheduleUtil su = new ScheduleUtil();
	          batResult = su.directExecuteJob("STM_SAR_B9999",kindSakura);
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"createSakuraBatch"}).getMessage(),e);
		} catch (Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"createSakuraBatch"}).getMessage(),e);
		} 
		return batResult;
    } 
    
    
    /**
	 * Search Sakura OTS BatchList<br> 
	 * 
	 * @return List<SaKuraIFVO>
	 * @exception EventException
	 */
	public List<SaKuraIFVO> searchSakuraOTSBatchList() throws EventException{
		List<SaKuraIFVO> list1 = new ArrayList<SaKuraIFVO>();
		try {
			
			List<AROutstandingHistVO> reFindHistVOs = dbDao.searchReFindSakuraIfNoForBatch();
			for(int i = 0; i < reFindHistVOs.size(); i++){  
				SaKuraIFVO saKuraIFVO =  new SaKuraIFVO();
				saKuraIFVO.setRefDocNo(reFindHistVOs.get(i).getIfNo());
				list1.add(saKuraIFVO);
			}
			//list1 = dbDao.searchIFSakuraASAList("","T","N");
			//list2 = dbDao.searchIFSakuraJpList("","T","N");
			return list1;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
   	 * Create SAKURA INTERFACEDATA<br> 
   	 * SAR_AR_IF 참조 
   	 * @param String ifNo
   	 * @param String status
   	 */
	public void createSakuraOTSIFdata(String ifNo,String status) {
		List<SaKuraIFVO> sarIFlist = new ArrayList<SaKuraIFVO>();
		List<SaKuraIFVO> otsDtrblist = new ArrayList<SaKuraIFVO>();
		//List<SaKuraIFVO> nonCurrlist = new ArrayList<SaKuraIFVO>();
		String  ifSeqNo = "";
		//make if data
		CheckIFSakuraVO returnVO =  new CheckIFSakuraVO();
		
		AccountReceivableCollectIFBC command = new AccountReceivableCollectIFBCImpl();
		try {
			//case dont have invno (INV category)
			/*int noInvCnt = dbDao.checkIFSakuraNonInvNo(ifNo);
			if(noInvCnt > 0){
				log.info(">>>>>>> passed , cause dont have inv_no problem : " + ifNo);
				return; 
			}*/
			
			//nonCurrlist = dbDao.searchIFSakuraNonCurrencyList(ifNo);
			//if(nonCurrlist.size() == 0){
				returnVO = dbDao.checkIFSakura(ifNo);
				if(returnVO != null && !returnVO.getBrnAgtDiv().equals("") && !returnVO.getCntCd().equals("") && !returnVO.getInvAsaDiv().equals("")){
					if(returnVO.getBrnAgtDiv().equals("AGT") && returnVO.getInvAsaDiv().equals("ASA")){
						sarIFlist = dbDao.searchIFSakuraASAList(ifNo,status,"Y");
						otsDtrblist = dbDao.searchIFSakuraASAList(ifNo,status,"N");
					} else {
						if(returnVO.getCntCd().equals("JP")){
							sarIFlist = dbDao.searchIFSakuraJpList(ifNo,status,"Y");
							otsDtrblist = dbDao.searchIFSakuraJpList(ifNo,status,"N");
						} else {
							sarIFlist = dbDao.searchIFSakuraNonJpList(ifNo,status,"Y");
							otsDtrblist = dbDao.searchIFSakuraNonJpList(ifNo,status,"N");
						}
					}
					
					if(sarIFlist.size() > 0){
						ifSeqNo = dbDao.searchSakuraArIFToSeq();
					}
					
					for (int i = 0; i < sarIFlist.size(); i++) {
						sarIFlist.get(i).setArIfSeq(dbDao.searchSakuraIFSeq());
						sarIFlist.get(i).setArIfStsCd("Y");
						sarIFlist.get(i).setIfSeqNo(ifSeqNo);
					}
					for (int i = 0; i < otsDtrblist.size(); i++) {
						otsDtrblist.get(i).setArIfSeq(ifSeqNo);
						otsDtrblist.get(i).setArIfStsCd("Y");
					}
				} else {
					otsDtrblist = dbDao.searchIFSakuraErrorList(ifNo,status);
					
					for (int i = 0; i < otsDtrblist.size(); i++) {
						otsDtrblist.get(i).setArIfStsCd("E");
						otsDtrblist.get(i).setArIfErrDesc("Without region info. in MDA");
					}
					dbDao.modifyDtrbStatus(otsDtrblist);	//sar_ots_dtrb
					return;
				}
			//}
		} catch (Exception ex) {
			log.error(ifNo + " createSakuraOTSIFdata search");
			log.error("err " + ex.toString(), ex);
		}	
			
		try {
			/*if(nonCurrlist.size() > 0){
				for (int i = 0; i < nonCurrlist.size(); i++) {
					nonCurrlist.get(i).setArIfStsCd("E");
					nonCurrlist.get(i).setArIfErrDesc("Exist Without Rate Data");
				} 
				dbDao.modifyDtrbStatus(nonCurrlist);
			} else {*/
				if(sarIFlist.size() > 0){
					if(returnVO != null && !returnVO.getBrnAgtDiv().equals("") && !returnVO.getCntCd().equals("")){
						command.addSarIFData(sarIFlist);
						dbDao.modifyDtrbStatus(otsDtrblist);
						
						//update status 'H' 
						command.modifyHoldingStatus(ifSeqNo);
						//verify status 'H'
						command.modifyReCheckHoldingStatus(ifSeqNo);
					} else {
						dbDao.modifyDtrbStatus(otsDtrblist);  
					}
				}
			//}
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
				command.modifySakuraIFErrRsn(sarIFlist);
			} catch (Exception e) {
				log.error(ifNo + " modifyDtrbStatus");
				log.error("err " + e.toString(), e);
			}	
		}
	}
}