/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RevenueDebitNoteBCImpl.java
*@FileTitle : RDN Issuance by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration.RDNIssueMailSendEAIDAO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration.RevenueDebitNoteDBDAO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.CstmBkgRevDrNoteVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RevDrNoteVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrAmtVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNoteVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNotesPerformanceVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNotesStatusVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltSearchRDNIssueMailingListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.AutoRdnInfoVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchBLVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgRevDrAmtVO;
import com.clt.syscommon.common.table.BkgRevDrNoteProgVO;


/**
 * OPUS-RevenueAudit Business Logic Basic Command implementation<br>
 * - OPUS-Process Business Logic for RevenueAudit.<br>
 *
 * @author Seung Jun Lee
 * @see ESM_BKG_0426EventResponse,RevenueDebitNoteBC each DAO class  reference
 * @since J2EE 1.4
 */
public class RevenueDebitNoteBCImpl extends BasicCommandSupport implements RevenueDebitNoteBC {

	// Database Access Object
	private transient RevenueDebitNoteDBDAO dbDao = null;
	private transient RDNIssueMailSendEAIDAO rdnIssueMailSendEaiDao = null;
	
	
    /**
     * FullReleaseOrderBCImpl Object Creation<br>
     * FullReleaseOrderDBDAO create.<br>
     */
    public RevenueDebitNoteBCImpl() {
        dbDao = new RevenueDebitNoteDBDAO();
        rdnIssueMailSendEaiDao = new RDNIssueMailSendEAIDAO();
        
    }
    
	
	/**
	 *  Retrieve processing for RDN Issuance by Regional Group <br>
	 * 
	 * @param RevDrNoteVO revDrNote
	 * @return RevDrNoteVO
	 * @exception EventException
	 */
	public RevDrNoteVO searchRDNList(RevDrNoteVO revDrNote) throws EventException {
		try {
			//container vo
			RevDrNoteVO revDrNoteVO = new RevDrNoteVO();
			//search division
			String searchGubun = revDrNote.getSearchGubun();
			
			//note head,title, body
			List<RsltBkgRevDrNoteVO> rsltBkgRevDrNoteVOList 	= new ArrayList<RsltBkgRevDrNoteVO>();
			List<RsltBkgRevDrAmtVO> rsltbkgRevDrAmtVOList 		= new ArrayList<RsltBkgRevDrAmtVO>();
			
			
			//Take each list and put container vo
			if("1".equals(searchGubun)) {		
				rsltBkgRevDrNoteVOList 		= dbDao.searchBkgRevDrNoteList(revDrNote.getBkgRevDrNoteVO());
				revDrNoteVO.setRsltBkgRevDrNoteVOList(rsltBkgRevDrNoteVOList);
			}	
			else if("2".equals(searchGubun)) {
				rsltbkgRevDrAmtVOList 		= dbDao.searchBkgRevDrAmtList(revDrNote.getBkgRevDrNoteVO());
				revDrNoteVO.setRsltBkgRevDrAmtVOList(rsltbkgRevDrAmtVOList);
			}	
			else if("3".equals(searchGubun)) {
				//retrieve latest remark of Reciver
				String regionalRmk = "";
				String receiptRmk = "";
				regionalRmk = dbDao.searchBkgRevDrNoteProgMaxRmk(revDrNote.getBkgRevDrNoteVO());
				receiptRmk  = dbDao.searchBkgRevDrNoteProgReceiptMaxRmk(revDrNote.getBkgRevDrNoteVO());
				revDrNoteVO.setRegionalRmk(regionalRmk);
				revDrNoteVO.setReceiptRmk(receiptRmk);
				
			}
			//Receipt retrieve
			else if("4".equals(searchGubun)) {		
				rsltBkgRevDrNoteVOList 		= dbDao.searchBkgRevDrNoteReceiptList(revDrNote.getBkgRevDrNoteVO());
				revDrNoteVO.setRsltBkgRevDrNoteVOList(rsltBkgRevDrNoteVOList);
			}
			
			//retrieve bkg relation data by BLNO
			else if("5".equals(searchGubun)) {		
				rsltBkgRevDrNoteVOList 		= dbDao.searchBlno(revDrNote.getBkgRevDrNoteVO());
				revDrNoteVO.setRsltBkgRevDrNoteVOList(rsltBkgRevDrNoteVOList);
			}
			//cano retrieve
			else if("6".equals(searchGubun)) {
				int cntCano = 0;
				cntCano = dbDao.searchCheckCaNo(revDrNote.getBkgRevDrNoteVO());
				revDrNoteVO.setCntCano(String.valueOf(cntCano));
				
			}
			
			return revDrNoteVO;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		}
	}
	
	
	
	/**
	 *  retrieve event processing for RDN Status <br>
	 * 
	 * @param RsltBkgRevDrNotesStatusVO rsltBkgRevDrNotesStatusVO
	 * @return List<RsltBkgRevDrNotesStatusVO>
	 * @exception EventException
	 */
	public List<RsltBkgRevDrNotesStatusVO> searchRDNStatusList(RsltBkgRevDrNotesStatusVO rsltBkgRevDrNotesStatusVO) throws EventException {
		try {			
			return dbDao.searchBkgRevDrNoteStatusList(rsltBkgRevDrNotesStatusVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		}
	}	
	
	
	/**
	 *  retrieve event processing for RDN Performance Report<br>
	 * 
	 * @param RsltBkgRevDrNotesPerformanceVO rsltBkgRevDrNotesPerformanceVO
	 * @return List<RsltBkgRevDrNotesPerformanceVO>
	 * @exception EventException
	 */
	public List<RsltBkgRevDrNotesPerformanceVO> searchRDNPerformanceList(RsltBkgRevDrNotesPerformanceVO rsltBkgRevDrNotesPerformanceVO) throws EventException {
		try {			
			return dbDao.searchRDNPerformanceList(rsltBkgRevDrNotesPerformanceVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		}
	}	
	

	/**
	 * retrieve afoot RDN No.<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @return String
	 * @exception EventException
	 */
	public String searchExistRevDrNote(RevDrNoteVO revDrNoteVO) throws EventException{
		try {
			CstmBkgRevDrNoteVO   bkgRevDrNoteVO = null;
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();

			String rdnNo = "";

			// check afoot RDN
			rdnNo = dbDao.searchExistRevDrNote(bkgRevDrNoteVO);

			return rdnNo;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}

	/**
	 * Add(issue) processing for RDN Issuance by Regional Group<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {
		
			//vo
			CstmBkgRevDrNoteVO   bkgRevDrNoteVO = null;
			BkgRevDrAmtVO[]   	 bkgRevDrAmtVOs = null;
			BkgRevDrNoteProgVO 	 bkgRevDrNoteProgVO = null;
			
			//remove RDN,AMT,PROG in container vo.
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
			bkgRevDrAmtVOs 		= revDrNoteVO.getBkgRevDrAmtVOs();
			bkgRevDrNoteProgVO  = revDrNoteVO.getBkgRevDrNoteProgVO();
			
			//AMT
			List<BkgRevDrAmtVO> insertVoList = new ArrayList<BkgRevDrAmtVO>();
			
			
			////////////////////////////RDN save/////////////////////////////////////////////
			
			//RDN sequence
			String rdnNo = "";
			int rvisSeq = 1;
			
			//header
			if(bkgRevDrNoteVO != null) {
				//retrieve max_seq and add in case of add
				rdnNo = dbDao.searchBkgRevDrNoteMaxSeq(bkgRevDrNoteVO);
				
				bkgRevDrNoteVO.setRdnNo(rdnNo);
				bkgRevDrNoteVO.setRvisSeq(String.valueOf(rvisSeq));
				
				bkgRevDrNoteVO.setRdnStsCd("IS");
				
				bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addBkgRevDrNote(bkgRevDrNoteVO);
			}
			
			////////////////////////////RDN save/////////////////////////////////////////////
			
			
			////////////////////////////PROG save/////////////////////////////////////////////
			
			//PROG sequence
			int progSeq = 1;
			
			if(bkgRevDrNoteVO != null) {
				//retrieve max_seq and add in case of add
				if(bkgRevDrNoteProgVO.getRdnNo() == null || "".equals(bkgRevDrNoteProgVO.getRdnNo()) ) {
					if(!"".equals(revDrNoteVO.getUmchRmk()) &&  revDrNoteVO.getUmchRmk() != null ){ //add RMK in case of Batch target 
						bkgRevDrNoteProgVO.setRdnRmk("RDN ISSUED BY SYSTEM");
					}
					bkgRevDrNoteProgVO.setRdnNo(rdnNo);
					bkgRevDrNoteProgVO.setRvisSeq(String.valueOf(rvisSeq));
					bkgRevDrNoteProgVO.setProgSeq(String.valueOf(progSeq));
					
					bkgRevDrNoteProgVO.setRdnStsCd("IS");
					//cre_ofc_cd
					bkgRevDrNoteProgVO.setCreOfcCd(bkgRevDrNoteVO.getIssOfcCd());
						
					bkgRevDrNoteProgVO.setCreUsrId(account.getUsr_id());
					bkgRevDrNoteProgVO.setUpdUsrId(account.getUsr_id());
					
					dbDao.addBkgRevDrNoteProg(bkgRevDrNoteProgVO);
				}
			}
		
			////////////////////////////PROG save/////////////////////////////////////////////
			
			
			
			
			////////////////////////////AMT save/////////////////////////////////////	
		
			for (int i = 0; bkgRevDrAmtVOs != null && i < bkgRevDrAmtVOs.length; i++) {
				
				if ( bkgRevDrAmtVOs[i].getIbflag().equals("I")){
					
					bkgRevDrAmtVOs[i].setRdnNo(rdnNo);
					bkgRevDrAmtVOs[i].setRvisSeq(String.valueOf(rvisSeq));
					
					bkgRevDrAmtVOs[i].setCreUsrId(account.getUsr_id());
					bkgRevDrAmtVOs[i].setUpdUsrId(account.getUsr_id());
					
					insertVoList.add(bkgRevDrAmtVOs[i]);
					
				} 
				
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addBkgRevDrAmtS(insertVoList);
			}
			
			
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	
	
	/**
	 * modify processing for RDN Issuance by Regional Group<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {
		
			//vo
			CstmBkgRevDrNoteVO   bkgRevDrNoteVO = null;
			BkgRevDrAmtVO[]   	 bkgRevDrAmtVOs = null;
			BkgRevDrNoteProgVO 	 bkgRevDrNoteProgVO = null;
			
			//remove RDN,AMT,PROG in container vo 
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
			bkgRevDrAmtVOs 		= revDrNoteVO.getBkgRevDrAmtVOs();
			bkgRevDrNoteProgVO  = revDrNoteVO.getBkgRevDrNoteProgVO();
			
			//AMT
			List<BkgRevDrAmtVO> insertVoList = new ArrayList<BkgRevDrAmtVO>();
			List<BkgRevDrAmtVO> updateVoList = new ArrayList<BkgRevDrAmtVO>();
			List<BkgRevDrAmtVO> deleteVoList = new ArrayList<BkgRevDrAmtVO>();
			log.debug("================================================");
			log.debug("=============bkgRevDrNoteVO=================================== : " +bkgRevDrNoteVO);
			log.debug("================================================");
			
			////////////////////////////RDN save/////////////////////////////////////////////
			
			
			//header
			//if(bkgRevDrNoteVO != null) {
				
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyBkgRevDrNote(bkgRevDrNoteVO);
				
			//}
			
			////////////////////////////RDN save/////////////////////////////////////////////
			
			
			////////////////////////////PROG save/////////////////////////////////////////////
			
			
			//if(bkgRevDrNoteVO != null) {
				
				bkgRevDrNoteProgVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyBkgRevDrNoteProg(bkgRevDrNoteProgVO);
				
			//}
		
			////////////////////////////PROG save/////////////////////////////////////////////
			
			
			
			
			////////////////////////////AMT save/////////////////////////////////////	
			//AMT don't save in case of SETTEL and CANCEL 

			if(!bkgRevDrNoteVO.getRdnStsCd().equals("ST") && !bkgRevDrNoteVO.getRdnStsCd().equals("CL")) {
				for (int i = 0; bkgRevDrAmtVOs != null && i < bkgRevDrAmtVOs.length; i++) {
					
					if ( bkgRevDrAmtVOs[i].getIbflag().equals("I")){
			
						bkgRevDrAmtVOs[i].setCreUsrId(account.getUsr_id());
						bkgRevDrAmtVOs[i].setUpdUsrId(account.getUsr_id());
						
						insertVoList.add(bkgRevDrAmtVOs[i]);
						
					} else if ( bkgRevDrAmtVOs[i].getIbflag().equals("U")){
						bkgRevDrAmtVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(bkgRevDrAmtVOs[i]);
						
					} else if ( bkgRevDrAmtVOs[i].getIbflag().equals("D")){
						deleteVoList.add(bkgRevDrAmtVOs[i]);
					}
					
				}
				
				if (insertVoList.size() > 0) {
					dbDao.addBkgRevDrAmtS(insertVoList);
				}
				
				if (updateVoList.size() > 0) {
					dbDao.modifyBkgRevDrAmtS(updateVoList);
				}
				
				if (deleteVoList.size() > 0) {
					dbDao.removeBkgRevDrAmtS(deleteVoList);
				}
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	
	
	/**
	 * modify processing for RDN Receipt by Office<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyRDNbyReceiptOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {
		
			//vo
			CstmBkgRevDrNoteVO   bkgRevDrNoteVO = null;
			BkgRevDrNoteProgVO 	 bkgRevDrNoteProgVO = null;
			
			//remove RDN,AMT,PROG in container vo
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
			bkgRevDrNoteProgVO  = revDrNoteVO.getBkgRevDrNoteProgVO();
			
			
			
			////////////////////////////PROG save/////////////////////////////////////////////
			
			
			if(bkgRevDrNoteVO != null) {
				//receiver rmk
				bkgRevDrNoteProgVO.setRdnRmk(bkgRevDrNoteVO.getReceiverRmk());
				bkgRevDrNoteProgVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyBkgRevDrNoteProg(bkgRevDrNoteProgVO);
				
			}
		
			////////////////////////////PROG save/////////////////////////////////////////////
			
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	
	/**
	 * RDN Issuance by Regional Group issue process(not use -->substitute by createRDNbyIssueOffice)<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void issueRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {

			//vo
			CstmBkgRevDrNoteVO    	 bkgRevDrNoteVO = null;
//			BkgRevDrNoteProgVO 	 bkgRevDrNoteProgVO = null;
//			BkgRevDrAmtVO[]   	 bkgRevDrAmtVOs = null;
			
			//remove RDN,PROG in container vo
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
//			bkgRevDrNoteProgVO  = revDrNoteVO.getBkgRevDrNoteProgVO();
//			bkgRevDrAmtVOs 		= revDrNoteVO.getBkgRevDrAmtVOs();
			
			//AMT
//			List<BkgRevDrAmtVO> insertVoList = new ArrayList<BkgRevDrAmtVO>();
//			List<BkgRevDrAmtVO> updateVoList = new ArrayList<BkgRevDrAmtVO>();
//			List<BkgRevDrAmtVO> deleteVoList = new ArrayList<BkgRevDrAmtVO>();
			
			
			String rdnNo = "";
			////////////////////////////RDN save  issue date, status code update/////////////////////////////////////////////

			if(bkgRevDrNoteVO != null) {
				//when first save, key value may not exist in case of IMMEDIATELY issue
				if(bkgRevDrNoteVO.getRdnNo() == null || "".equals(bkgRevDrNoteVO.getRdnNo()) ) {
					//latest key value
					rdnNo = dbDao.searchBkgRevDrNoteMaxSeqMinusOne(bkgRevDrNoteVO);
					
					bkgRevDrNoteVO.setRdnNo(rdnNo);
					//After saving is ISSUE 1
					bkgRevDrNoteVO.setRvisSeq("1");
				}	
				
				//status code
				bkgRevDrNoteVO.setRdnStsCd("IS");
				//issue date
				//bkgRevDrNoteVO.setRdnIssDt("SYSDATE");
				bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				//status code modify
				dbDao.modifyBkgRevDrNoteStatus(bkgRevDrNoteVO);
				
			
			
			////////////////////////////RDN save/////////////////////////////////////////////
			
			
			////////////////////////////status flag change therefore new register PROG /////////////////////////////////////////////
			
			//when first save, key value may not exist in case of IMMEDIATELY issue
			if(bkgRevDrNoteVO.getRdnNo() == null || "".equals(bkgRevDrNoteVO.getRdnNo()) ) {
				bkgRevDrNoteVO.setRdnNo(rdnNo);
				bkgRevDrNoteVO.setRvisSeq("1");
			}	
			if(!"".equals(revDrNoteVO.getUmchRmk()) &&  revDrNoteVO.getUmchRmk() != null ){ //add RMK in case of Batch target 
				bkgRevDrNoteVO.setRdnRmk("RDN ISSUED BY SYSTEM");
			}
			bkgRevDrNoteVO.setRdnStsCd("IS");
			//CRE_OFFICE_CD
			bkgRevDrNoteVO.setIssOfcCd(account.getOfc_cd());
			dbDao.addSearchBkgRevDrNoteProgOffice(bkgRevDrNoteVO);
			
			} //Null Referencing 
			
			/*//PROG sequence
			int progSeq = 1;
			
			if(bkgRevDrNoteProgVO != null) {
				
				progSeq = dbDao.searchRDNProgMaxSeq(bkgRevDrNoteVO);
					
				bkgRevDrNoteProgVO.setProgSeq(String.valueOf(progSeq));	
				//status code
				bkgRevDrNoteVO.setRdnStsCd("S");
				
				bkgRevDrNoteProgVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteProgVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addBkgRevDrNoteProg(bkgRevDrNoteProgVO);
				
			}*/
		
			////////////////////////////PROG register/////////////////////////////////////////////
			
			
			////////////////////////////AMT save/////////////////////////////////////	
			
//			for (int i = 0; bkgRevDrAmtVOs != null && i < bkgRevDrAmtVOs.length; i++) {
//				
//				if ( bkgRevDrAmtVOs[i].getIbflag().equals("I")){
//		
//					bkgRevDrAmtVOs[i].setCreUsrId(account.getUsr_id());
//					bkgRevDrAmtVOs[i].setUpdUsrId(account.getUsr_id());
//					
//					insertVoList.add(bkgRevDrAmtVOs[i]);
//					
//				} else if ( bkgRevDrAmtVOs[i].getIbflag().equals("U")){
//					bkgRevDrAmtVOs[i].setUpdUsrId(account.getUsr_id());
//					updateVoList.add(bkgRevDrAmtVOs[i]);
//					
//				} else if ( bkgRevDrAmtVOs[i].getIbflag().equals("D")){
//					deleteVoList.add(bkgRevDrAmtVOs[i]);
//				}
//				
//			}
//			
//			if (insertVoList.size() > 0) {
//				dbDao.addBkgRevDrAmtS(insertVoList);
//			}
//			
//			if (updateVoList.size() > 0) {
//				dbDao.modifyBkgRevDrAmtS(updateVoList);
//			}
//			
//			if (deleteVoList.size() > 0) {
//				dbDao.removeBkgRevDrAmtS(deleteVoList);
//			}
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	
	/**
	 * RDN Issuance by Regional Group revise processing
	 * retrieve new rvis_seq and regiter and copy latest value each detail and new register.<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void reviseRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {

			//vo
			CstmBkgRevDrNoteVO   bkgRevDrNoteVO = null;
			BkgRevDrAmtVO[]   	 bkgRevDrAmtVOs = null;
			BkgRevDrNoteProgVO 	 bkgRevDrNoteProgVO = null;
			
			//remove RDN,AMT,PROG in container vo
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
			bkgRevDrAmtVOs 		= revDrNoteVO.getBkgRevDrAmtVOs();
			bkgRevDrNoteProgVO  = revDrNoteVO.getBkgRevDrNoteProgVO();
			
			//AMT
			List<BkgRevDrAmtVO> insertVoList = new ArrayList<BkgRevDrAmtVO>();
			
	
			////////////////////////////RDN save/////////////////////////////////////////////
			
			//RDN sequence
			String rdnNo = "";
			int rvisSeq = 1;
			
			//Null Referencing
			String creOfcCd = "";
			
			//header
			if(bkgRevDrNoteVO != null) {
				//register after retrieve max seq in case if input
				//if(bkgRevDrNoteVO.getRdnNo() == null || "".equals(bkgRevDrNoteVO.getRdnNo()) ) {
					
					rdnNo = bkgRevDrNoteVO.getRdnNo();
				
					//1 increase at rvis seq 
					rvisSeq  = Integer.parseInt(bkgRevDrNoteVO.getRvisSeq())+1;
					bkgRevDrNoteVO.setRvisSeq(String.valueOf(rvisSeq));
					
					bkgRevDrNoteVO.setRdnStsCd("RV");
					
					bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
					bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
					
					dbDao.addBkgRevDrNote(bkgRevDrNoteVO);
					creOfcCd = bkgRevDrNoteVO.getIssOfcCd();
				//}
			}
			
			////////////////////////////RDN save/////////////////////////////////////////////
			
			
			////////////////////////////PROG save/////////////////////////////////////////////
			
			//PROG sequence
			int progSeq = 1;
			
			//if(bkgRevDrNoteVO != null) {
				//register after retrieve max seq in case if input
				//if(bkgRevDrNoteProgVO.getRdnNo() == null || "".equals(bkgRevDrNoteProgVO.getRdnNo()) ) {
					
					bkgRevDrNoteProgVO.setRdnNo(rdnNo);
					bkgRevDrNoteProgVO.setRvisSeq(String.valueOf(rvisSeq));
					bkgRevDrNoteProgVO.setProgSeq(String.valueOf(progSeq));
					
					bkgRevDrNoteProgVO.setRdnStsCd("RV");
					//cre_ofc_cd
					bkgRevDrNoteProgVO.setCreOfcCd(creOfcCd);
						
					bkgRevDrNoteProgVO.setCreUsrId(account.getUsr_id());
					bkgRevDrNoteProgVO.setUpdUsrId(account.getUsr_id());
					
					dbDao.addBkgRevDrNoteProg(bkgRevDrNoteProgVO);
				//}
			//}
		
			////////////////////////////PROG save/////////////////////////////////////////////
			
			
			
			
			////////////////////////////AMT save/////////////////////////////////////	

			for (int i = 0; bkgRevDrAmtVOs != null && i < bkgRevDrAmtVOs.length; i++) {
				
				if (!bkgRevDrAmtVOs[i].getIbflag().equals("D")){
					
					bkgRevDrAmtVOs[i].setRdnNo(rdnNo);
					bkgRevDrAmtVOs[i].setRvisSeq(String.valueOf(rvisSeq));
					
					bkgRevDrAmtVOs[i].setCreUsrId(account.getUsr_id());
					bkgRevDrAmtVOs[i].setUpdUsrId(account.getUsr_id());
					
					insertVoList.add(bkgRevDrAmtVOs[i]);
					
				}

			}

			if (insertVoList.size() > 0) {
				dbDao.addBkgRevDrAmtS(insertVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	
	
	/**
	 * RDN Issuance by Regional Group reissue processing
	 * retrieve new rvis_seq and regiter and copy latest value each detail and new register.<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void reissueRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {
		
			//vo
			CstmBkgRevDrNoteVO    	 bkgRevDrNoteVO = null;
			
			//remove RDN,PROG in container vo
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
			
			////////////////////////////RDN save  issue date, status code update/////////////////////////////////////////////

			if(bkgRevDrNoteVO != null) {
				
				//status code
				bkgRevDrNoteVO.setRdnStsCd("IS");
				//issue date
				//bkgRevDrNoteVO.setRdnIssDt("SYSDATE");
				bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				//status code modify
				dbDao.modifyBkgRevDrNoteStatus(bkgRevDrNoteVO);
				
			
			
			////////////////////////////RDN save/////////////////////////////////////////////
			
			
			////////////////////////////status flag change therefore new register PROG /////////////////////////////////////////////
			
			bkgRevDrNoteVO.setRdnStsCd("IS");
			//CRE_OFFICE_CD
			bkgRevDrNoteVO.setIssOfcCd(account.getOfc_cd());
			dbDao.addSearchBkgRevDrNoteProgOffice(bkgRevDrNoteVO);
	
			////////////////////////////PROG register/////////////////////////////////////////////
			
			}//Null Referencing
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	
	/**
	 * RDN Issuance by Regional Group cancel processing<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {

			//vo
			CstmBkgRevDrNoteVO    	 bkgRevDrNoteVO = null;
//			BkgRevDrNoteProgVO 	 bkgRevDrNoteProgVO = null;
			//BkgRevDrAmtVO[]   	 bkgRevDrAmtVOs = null;
			
			//remove RDN,PROG in container vo
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
//			bkgRevDrNoteProgVO  = revDrNoteVO.getBkgRevDrNoteProgVO();
			//bkgRevDrAmtVOs 		= revDrNoteVO.getBkgRevDrAmtVOs();
			
			
			
			////////////////////////////RDN save  issue date, status code update/////////////////////////////////////////////

			if(bkgRevDrNoteVO != null) {
				//status code
				bkgRevDrNoteVO.setRdnStsCd("CL");
				//issue date
				//bkgRevDrNoteVO.setRdnIssDt("SYSDATE");
				bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				//status code modify
				dbDao.modifyBkgRevDrNoteStatus(bkgRevDrNoteVO);
				
			
			
			////////////////////////////RDN save/////////////////////////////////////////////
			
			
			////////////////////////////status flag change therefore new register PROG /////////////////////////////////////////////
			bkgRevDrNoteVO.setRdnStsCd("CL");
			bkgRevDrNoteVO.setIssOfcCd(account.getOfc_cd());
			
			dbDao.addSearchBkgRevDrNoteProgOffice(bkgRevDrNoteVO);
			
			////////////////////////////PROG register/////////////////////////////////////////////
			}//Null Referencing
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	
	/**
	 * RDN Issuance by Regional Group settle processing<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void settleRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {

			//vo
			CstmBkgRevDrNoteVO    	 bkgRevDrNoteVO = null;
//			BkgRevDrNoteProgVO 	 bkgRevDrNoteProgVO = null;
			//BkgRevDrAmtVO[]   	 bkgRevDrAmtVOs = null;
			
			//remove RDN,PROG in container vo
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
//			bkgRevDrNoteProgVO  = revDrNoteVO.getBkgRevDrNoteProgVO();
			//bkgRevDrAmtVOs 		= revDrNoteVO.getBkgRevDrAmtVOs();
			
			//AMT
//			List<BkgRevDrAmtVO> insertVoList = new ArrayList<BkgRevDrAmtVO>();
//			List<BkgRevDrAmtVO> updateVoList = new ArrayList<BkgRevDrAmtVO>();
//			List<BkgRevDrAmtVO> deleteVoList = new ArrayList<BkgRevDrAmtVO>();
			
			
			////////////////////////////RDN save  issue date, status code update/////////////////////////////////////////////

			if(bkgRevDrNoteVO != null) {
				//status code
				bkgRevDrNoteVO.setRdnStsCd("ST");
				//issue date
				//bkgRevDrNoteVO.setRdnIssDt("SYSDATE");
				bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				//status code modify
				dbDao.modifyBkgRevDrNoteStatus(bkgRevDrNoteVO);
				
			
			
			////////////////////////////RDN save/////////////////////////////////////////////
			
			
			////////////////////////////status flag change therefore new register PROG /////////////////////////////////////////////
			bkgRevDrNoteVO.setRdnStsCd("ST");
			bkgRevDrNoteVO.setIssOfcCd(account.getOfc_cd());
			
			dbDao.addSearchBkgRevDrNoteProgOffice(bkgRevDrNoteVO);
			
			}//Null Referencing
			/*//PROG sequence
			int progSeq = 1;
			
			if(bkgRevDrNoteProgVO != null) {
				
				progSeq = dbDao.searchRDNProgMaxSeq(bkgRevDrNoteVO);
					
				bkgRevDrNoteProgVO.setProgSeq(String.valueOf(progSeq));	
				//status code
				bkgRevDrNoteVO.setRdnStsCd("S");
				
				bkgRevDrNoteProgVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteProgVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addBkgRevDrNoteProg(bkgRevDrNoteProgVO);
				
			}*/
		
			////////////////////////////PROG regieter/////////////////////////////////////////////
			
			
			////////////////////////////AMT save/////////////////////////////////////	
			
//			for (int i = 0; bkgRevDrAmtVOs != null && i < bkgRevDrAmtVOs.length; i++) {
//				
//				if ( bkgRevDrAmtVOs[i].getIbflag().equals("I")){
//		
//					bkgRevDrAmtVOs[i].setCreUsrId(account.getUsr_id());
//					bkgRevDrAmtVOs[i].setUpdUsrId(account.getUsr_id());
//					
//					insertVoList.add(bkgRevDrAmtVOs[i]);
//					
//				} else if ( bkgRevDrAmtVOs[i].getIbflag().equals("U")){
//					bkgRevDrAmtVOs[i].setUpdUsrId(account.getUsr_id());
//					updateVoList.add(bkgRevDrAmtVOs[i]);
//					
//				} else if ( bkgRevDrAmtVOs[i].getIbflag().equals("D")){
//					deleteVoList.add(bkgRevDrAmtVOs[i]);
//				}
//				
//			}
//			
//			if (insertVoList.size() > 0) {
//				dbDao.addBkgRevDrAmtS(insertVoList);
//			}
//			
//			if (updateVoList.size() > 0) {
//				dbDao.modifyBkgRevDrAmtS(updateVoList);
//			}
//			
//			if (deleteVoList.size() > 0) {
//				dbDao.removeBkgRevDrAmtS(deleteVoList);
//			}
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	
	/**
	 * RDN Receipt by Office Accept processing<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void acceptRDNbyReceiptOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {

			//vo
			CstmBkgRevDrNoteVO    	 bkgRevDrNoteVO = null;
//			BkgRevDrNoteProgVO 	 bkgRevDrNoteProgVO = null;
			//BkgRevDrAmtVO[]   	 bkgRevDrAmtVOs = null;
			
			//remove RDN,PROG in container vo
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
//			bkgRevDrNoteProgVO  = revDrNoteVO.getBkgRevDrNoteProgVO();
			//bkgRevDrAmtVOs 		= revDrNoteVO.getBkgRevDrAmtVOs();
			
			//AMT
//			List<BkgRevDrAmtVO> insertVoList = new ArrayList<BkgRevDrAmtVO>();
//			List<BkgRevDrAmtVO> updateVoList = new ArrayList<BkgRevDrAmtVO>();
//			List<BkgRevDrAmtVO> deleteVoList = new ArrayList<BkgRevDrAmtVO>();
			
			
			////////////////////////////RDN save  issue date, status code update/////////////////////////////////////////////

			if(bkgRevDrNoteVO != null) {
				//status code
				bkgRevDrNoteVO.setRdnStsCd("AC");
				//issue date
				//bkgRevDrNoteVO.setRdnIssDt("SYSDATE");
				bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				//status code modify
				dbDao.modifyBkgRevDrNoteStatus(bkgRevDrNoteVO);
				
			
			
			////////////////////////////RDN save/////////////////////////////////////////////
			
			
			////////////////////////////status flag change therefore new register PROG /////////////////////////////////////////////
			bkgRevDrNoteVO.setRdnStsCd("AC");
			bkgRevDrNoteVO.setIssOfcCd(account.getOfc_cd());
			
			dbDao.addSearchBkgRevDrNoteProgReciver(bkgRevDrNoteVO);
			
			}//Null Referencing
			/*//PROG sequence
			int progSeq = 1;
			
			if(bkgRevDrNoteProgVO != null) {
				
				progSeq = dbDao.searchRDNProgMaxSeq(bkgRevDrNoteVO);
					
				bkgRevDrNoteProgVO.setProgSeq(String.valueOf(progSeq));	
				//status code
				bkgRevDrNoteVO.setRdnStsCd("S");
				
				bkgRevDrNoteProgVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteProgVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addBkgRevDrNoteProg(bkgRevDrNoteProgVO);
				
			}*/
		
			////////////////////////////PROG register/////////////////////////////////////////////
			
			
			////////////////////////////AMT save/////////////////////////////////////	
			
//			for (int i = 0; bkgRevDrAmtVOs != null && i < bkgRevDrAmtVOs.length; i++) {
//				
//				if ( bkgRevDrAmtVOs[i].getIbflag().equals("I")){
//		
//					bkgRevDrAmtVOs[i].setCreUsrId(account.getUsr_id());
//					bkgRevDrAmtVOs[i].setUpdUsrId(account.getUsr_id());
//					
//					insertVoList.add(bkgRevDrAmtVOs[i]);
//					
//				} else if ( bkgRevDrAmtVOs[i].getIbflag().equals("U")){
//					bkgRevDrAmtVOs[i].setUpdUsrId(account.getUsr_id());
//					updateVoList.add(bkgRevDrAmtVOs[i]);
//					
//				} else if ( bkgRevDrAmtVOs[i].getIbflag().equals("D")){
//					deleteVoList.add(bkgRevDrAmtVOs[i]);
//				}
//				
//			}
//			
//			if (insertVoList.size() > 0) {
//				dbDao.addBkgRevDrAmtS(insertVoList);
//			}
//			
//			if (updateVoList.size() > 0) {
//				dbDao.modifyBkgRevDrAmtS(updateVoList);
//			}
//			
//			if (deleteVoList.size() > 0) {
//				dbDao.removeBkgRevDrAmtS(deleteVoList);
//			}
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	
	/**
	 * RDN Receipt by Office Revise Request processing<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void reviseRequestRDNbyReceiptOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {

			//vo
			CstmBkgRevDrNoteVO    	 bkgRevDrNoteVO = null;
//			BkgRevDrNoteProgVO 	 bkgRevDrNoteProgVO = null;
			//BkgRevDrAmtVO[]   	 bkgRevDrAmtVOs = null;
			
			//remove RDN,PROG in container vo
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
//			bkgRevDrNoteProgVO  = revDrNoteVO.getBkgRevDrNoteProgVO();
			//bkgRevDrAmtVOs 		= revDrNoteVO.getBkgRevDrAmtVOs();
			
			//AMT
//			List<BkgRevDrAmtVO> insertVoList = new ArrayList<BkgRevDrAmtVO>();
//			List<BkgRevDrAmtVO> updateVoList = new ArrayList<BkgRevDrAmtVO>();
//			List<BkgRevDrAmtVO> deleteVoList = new ArrayList<BkgRevDrAmtVO>();
			
			
			////////////////////////////RDN save  issue date, status code update/////////////////////////////////////////////

			if(bkgRevDrNoteVO != null) {
				//status code
				bkgRevDrNoteVO.setRdnStsCd("RR");
				//issue date
				//bkgRevDrNoteVO.setRdnIssDt("SYSDATE");
				bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				//status code modify
				dbDao.modifyBkgRevDrNoteStatus(bkgRevDrNoteVO);
				
			
			
			////////////////////////////RDN save/////////////////////////////////////////////
			
			
			////////////////////////////status flag change therefore new register PROG /////////////////////////////////////////////
			bkgRevDrNoteVO.setRdnStsCd("RR");
			bkgRevDrNoteVO.setIssOfcCd(account.getOfc_cd());
			
			dbDao.addSearchBkgRevDrNoteProgReciver(bkgRevDrNoteVO);
			
			}//Null Referencing
			/*//PROG sequence
			int progSeq = 1;
			
			if(bkgRevDrNoteProgVO != null) {
				
				progSeq = dbDao.searchRDNProgMaxSeq(bkgRevDrNoteVO);
					
				bkgRevDrNoteProgVO.setProgSeq(String.valueOf(progSeq));	
				//status code
				bkgRevDrNoteVO.setRdnStsCd("S");
				
				bkgRevDrNoteProgVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteProgVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addBkgRevDrNoteProg(bkgRevDrNoteProgVO);
				
			}*/
		
			////////////////////////////PROG register/////////////////////////////////////////////
			
			
			////////////////////////////AMT save/////////////////////////////////////	
			
//			for (int i = 0; bkgRevDrAmtVOs != null && i < bkgRevDrAmtVOs.length; i++) {
//				
//				if ( bkgRevDrAmtVOs[i].getIbflag().equals("I")){
//		
//					bkgRevDrAmtVOs[i].setCreUsrId(account.getUsr_id());
//					bkgRevDrAmtVOs[i].setUpdUsrId(account.getUsr_id());
//					
//					insertVoList.add(bkgRevDrAmtVOs[i]);
//					
//				} else if ( bkgRevDrAmtVOs[i].getIbflag().equals("U")){
//					bkgRevDrAmtVOs[i].setUpdUsrId(account.getUsr_id());
//					updateVoList.add(bkgRevDrAmtVOs[i]);
//					
//				} else if ( bkgRevDrAmtVOs[i].getIbflag().equals("D")){
//					deleteVoList.add(bkgRevDrAmtVOs[i]);
//				}
//				
//			}
//			
//			if (insertVoList.size() > 0) {
//				dbDao.addBkgRevDrAmtS(insertVoList);
//			}
//			
//			if (updateVoList.size() > 0) {
//				dbDao.modifyBkgRevDrAmtS(updateVoList);
//			}
//			
//			if (deleteVoList.size() > 0) {
//				dbDao.removeBkgRevDrAmtS(deleteVoList);
//			}
			
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	
	/**
	 * RDN Receipt by Office Cancel Request processing<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelRequestRDNbyReceiptOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {

			//vo
			CstmBkgRevDrNoteVO    	 bkgRevDrNoteVO = null;
//			BkgRevDrNoteProgVO 	 bkgRevDrNoteProgVO = null;
			//BkgRevDrAmtVO[]   	 bkgRevDrAmtVOs = null;
			
			//remove RDN,PROG in container vo
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
//			bkgRevDrNoteProgVO  = revDrNoteVO.getBkgRevDrNoteProgVO();
			//bkgRevDrAmtVOs 		= revDrNoteVO.getBkgRevDrAmtVOs();
			
			//AMT
//			List<BkgRevDrAmtVO> insertVoList = new ArrayList<BkgRevDrAmtVO>();
//			List<BkgRevDrAmtVO> updateVoList = new ArrayList<BkgRevDrAmtVO>();
//			List<BkgRevDrAmtVO> deleteVoList = new ArrayList<BkgRevDrAmtVO>();
			
			
			////////////////////////////RDN save  issue date, status code update/////////////////////////////////////////////

			if(bkgRevDrNoteVO != null) {
				//status code
				bkgRevDrNoteVO.setRdnStsCd("CR");
				//issue date
				//bkgRevDrNoteVO.setRdnIssDt("SYSDATE");
				bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				//status code modify
				dbDao.modifyBkgRevDrNoteStatus(bkgRevDrNoteVO);
				
			
			
			////////////////////////////RDN save/////////////////////////////////////////////
			
			
			////////////////////////////status flag change therefore new register PROG /////////////////////////////////////////////
			bkgRevDrNoteVO.setRdnStsCd("CR");
			bkgRevDrNoteVO.setIssOfcCd(account.getOfc_cd());
			
			dbDao.addSearchBkgRevDrNoteProgReciver(bkgRevDrNoteVO);
			
			}//Null Referencing
			/*//PROG sequence
			int progSeq = 1;
			
			if(bkgRevDrNoteProgVO != null) {
				
				progSeq = dbDao.searchRDNProgMaxSeq(bkgRevDrNoteVO);
					
				bkgRevDrNoteProgVO.setProgSeq(String.valueOf(progSeq));	
				//status code
				bkgRevDrNoteVO.setRdnStsCd("S");
				
				bkgRevDrNoteProgVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteProgVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addBkgRevDrNoteProg(bkgRevDrNoteProgVO);
				
			}*/
		
			////////////////////////////PROG register/////////////////////////////////////////////
			
			
			////////////////////////////AMT save/////////////////////////////////////	
			
//			for (int i = 0; bkgRevDrAmtVOs != null && i < bkgRevDrAmtVOs.length; i++) {
//				
//				if ( bkgRevDrAmtVOs[i].getIbflag().equals("I")){
//		
//					bkgRevDrAmtVOs[i].setCreUsrId(account.getUsr_id());
//					bkgRevDrAmtVOs[i].setUpdUsrId(account.getUsr_id());
//					
//					insertVoList.add(bkgRevDrAmtVOs[i]);
//					
//				} else if ( bkgRevDrAmtVOs[i].getIbflag().equals("U")){
//					bkgRevDrAmtVOs[i].setUpdUsrId(account.getUsr_id());
//					updateVoList.add(bkgRevDrAmtVOs[i]);
//					
//				} else if ( bkgRevDrAmtVOs[i].getIbflag().equals("D")){
//					deleteVoList.add(bkgRevDrAmtVOs[i]);
//				}
//				
//			}
//			
//			if (insertVoList.size() > 0) {
//				dbDao.addBkgRevDrAmtS(insertVoList);
//			}
//			
//			if (updateVoList.size() > 0) {
//				dbDao.modifyBkgRevDrAmtS(updateVoList);
//			}
//			
//			if (deleteVoList.size() > 0) {
//				dbDao.removeBkgRevDrAmtS(deleteVoList);
//			}
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	
//	/**
//	 * remove only seq in RDN NO<br>
//	 * EX) 'RDN090001' -> 1
//	 * @param revDrNote RevDrNoteVO
//	 * @param account SignOnUserAccount
//	 * @exception EventException
//	 */
//	private String unFormatRdnNo(RevDrNoteVO revDrNoteVO) throws EventException{
//		try {
//
//			//vo
//			CstmBkgRevDrNoteVO   bkgRevDrNoteVO = null;
//			BkgRevDrNoteProgVO 	 bkgRevDrNoteProgVO = null;
//			BkgRevDrAmtVO[]   	 bkgRevDrAmtVOs = null;
//			
//			//remove RDN,PROG in container vo
//			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
//			bkgRevDrNoteProgVO  = revDrNoteVO.getBkgRevDrNoteProgVO();
//			bkgRevDrAmtVOs 		= revDrNoteVO.getBkgRevDrAmtVOs();
//			
//			String unFormatRdnNo = "";
//			
//			////////////////////////////RDN note/////////////////////////////////////////////
//
//			if(bkgRevDrNoteVO != null) {
//				unFormatRdnNo = bkgRevDrNoteVO.getRdnNo();
//				
//				if()
//				
//			}
//			
//			////////////////////////////RDN save/////////////////////////////////////////////
//			
//			
//			////////////////////////////status flag change therefore new register PROG /////////////////////////////////////////////
//			bkgRevDrNoteVO.setRdnStsCd("CR");
//			bkgRevDrNoteVO.setIssOfcCd(account.getOfc_cd());
//			
//			dbDao.addSearchBkgRevDrNoteProg2(bkgRevDrNoteVO);
//			
//			/*//PROG sequence
//			int progSeq = 1;
//			
//			if(bkgRevDrNoteProgVO != null) {
//				
//				progSeq = dbDao.searchRDNProgMaxSeq(bkgRevDrNoteVO);
//					
//				bkgRevDrNoteProgVO.setProgSeq(String.valueOf(progSeq));	
//				//status code
//				bkgRevDrNoteVO.setRdnStsCd("S");
//				
//				bkgRevDrNoteProgVO.setCreUsrId(account.getUsr_id());
//				bkgRevDrNoteProgVO.setUpdUsrId(account.getUsr_id());
//				
//				dbDao.addBkgRevDrNoteProg(bkgRevDrNoteProgVO);
//				
//			}*/
//		
//			////////////////////////////PROG register/////////////////////////////////////////////
//			
//			
//			////////////////////////////AMT save/////////////////////////////////////	
//			
////			for (int i = 0; bkgRevDrAmtVOs != null && i < bkgRevDrAmtVOs.length; i++) {
////				
////				if ( bkgRevDrAmtVOs[i].getIbflag().equals("I")){
////		
////					bkgRevDrAmtVOs[i].setCreUsrId(account.getUsr_id());
////					bkgRevDrAmtVOs[i].setUpdUsrId(account.getUsr_id());
////					
////					insertVoList.add(bkgRevDrAmtVOs[i]);
////					
////				} else if ( bkgRevDrAmtVOs[i].getIbflag().equals("U")){
////					bkgRevDrAmtVOs[i].setUpdUsrId(account.getUsr_id());
////					updateVoList.add(bkgRevDrAmtVOs[i]);
////					
////				} else if ( bkgRevDrAmtVOs[i].getIbflag().equals("D")){
////					deleteVoList.add(bkgRevDrAmtVOs[i]);
////				}
////				
////			}
////			
////			if (insertVoList.size() > 0) {
////				dbDao.addBkgRevDrAmtS(insertVoList);
////			}
////			
////			if (updateVoList.size() > 0) {
////				dbDao.modifyBkgRevDrAmtS(updateVoList);
////			}
////			
////			if (deleteVoList.size() > 0) {
////				dbDao.removeBkgRevDrAmtS(deleteVoList);
////			}
//			
//			
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		} catch (Exception de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}

	/**
	 * retrieve mail receiver when RDN Issuance by Auditor Issue happen .<br>
	 * 
	 * @param RsltSearchRDNIssueMailingListVO rsltSearchRDNIssueMailingListVO
	 * @param SignOnUserAccount account
	 * @return List<RsltSearchRDNIssueMailingListVO>
	 * @exception EventException
	 */
	public List<RsltSearchRDNIssueMailingListVO> searchRDNIssueMailingList(RsltSearchRDNIssueMailingListVO rsltSearchRDNIssueMailingListVO, SignOnUserAccount account) throws EventException {
		try {			
			rsltSearchRDNIssueMailingListVO.setUsrId(account.getUsr_id());
			return dbDao.searchRDNIssueMailingList(rsltSearchRDNIssueMailingListVO);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception de) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), de);
		}
	}	
	
	/**
	 * RDN Issuance by Auditor Mail send in a lump to mail receiver. <br>
	 * 
	 * @param RsltSearchRDNIssueMailingListVO[] pVOS
	 * @param RsltSearchRDNIssueMailingListVO vo
	 * @exception EventException
	 */
	public void doMailRDNIssue(RsltSearchRDNIssueMailingListVO[] pVOS, RsltSearchRDNIssueMailingListVO vo) throws EventException {
		try {
			rdnIssueMailSendEaiDao.doMailRDNIssue(pVOS, vo);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00098").getMessage(), ex);
	    }catch (Exception de) {
	        throw new EventException(new ErrorHandler("BKG00098").getMessage(), de);
		}
	}

	/**
	 *  RDN auto issue for Non-Charged B/L
	 * @param autoRdnInfoVO AutoRdnInfoVO
	 * @param modParamVo UnmatchBLVO
	 * @param account SignOnUserAccount
	 * @throws Exception
	 */
	public void autoMailRDNIssue(AutoRdnInfoVO autoRdnInfoVO, UnmatchBLVO modParamVo, SignOnUserAccount account) throws EventException {
		try {
			RevDrNoteVO revDrNoteVO = new RevDrNoteVO();
	
			// BKG_REV_DR_NOTE
			CstmBkgRevDrNoteVO cstmBkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
			ObjectCloner.build(autoRdnInfoVO, cstmBkgRevDrNoteVO);
			revDrNoteVO.setBkgRevDrNoteVO(cstmBkgRevDrNoteVO);
	
			// BKG_REV_DR_NOTE_PROG
			BkgRevDrNoteProgVO bkgRevDrNoteProgVO = new BkgRevDrNoteProgVO();
			ObjectCloner.build(autoRdnInfoVO, bkgRevDrNoteProgVO);
			revDrNoteVO.setBkgRevDrNoteProgVO(bkgRevDrNoteProgVO);
			
			//add remark in case of auto RDN
			revDrNoteVO.setUmchRmk("RDN ISSUED BY SYSTEM");
			// register
			this.createRDNbyIssueOffice(revDrNoteVO, account);
			// Issue
			this.issueRDNbyIssueOffice(revDrNoteVO, account);
			// RDN NO retrieve
			String rdnNo = dbDao.searchExistRevDrNote(revDrNoteVO.getBkgRevDrNoteVO());
			
			//send mail in a lump
			RsltSearchRDNIssueMailingListVO vo = new RsltSearchRDNIssueMailingListVO();
			vo.setMailTitle("[RDN Notice] " + autoRdnInfoVO.getRctOfcCd() + " / " + autoRdnInfoVO.getRdnIssDt()
					+ " / WK " + autoRdnInfoVO.getRdnIssDtWk() + " / " + autoRdnInfoVO.getBlNo());
			vo.setRdnIssDtWk("");
			vo.setRctOfcCd(autoRdnInfoVO.getRctOfcCd());
			vo.setContFm("PKGSCD_Rev Audit");
			vo.setRdnNo(rdnNo);
			vo.setRdnAmount("");
			vo.setRdnIssDt(autoRdnInfoVO.getRdnIssDt());
			vo.setBlNo(autoRdnInfoVO.getBlNo());
			vo.setScRfaNo(autoRdnInfoVO.getScRfaNo());
			vo.setErrorKind("Non-Charged B/L / / Rating Approval Delay\n");
			vo.setRdnRmk("");
			vo.setIbflag("AUTO");
	
			// receiver list retrieve
			List<RsltSearchRDNIssueMailingListVO> mailList = dbDao.searchRDNIssueMailingAutoList(autoRdnInfoVO.getBkgNo());
			RsltSearchRDNIssueMailingListVO[] arrMail = new RsltSearchRDNIssueMailingListVO[mailList.size()];
			for (int i=0; i<mailList.size(); i++) {
				arrMail[i] = new RsltSearchRDNIssueMailingListVO();
				ObjectCloner.build(mailList.get(i), arrMail[i]);
			}
			rdnIssueMailSendEaiDao.doMailRDNIssue(arrMail, vo);
		} catch (EventException ex) {
	        throw ex;
	    } catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00098").getMessage(), ex);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("BKG00098").getMessage(), de);
		}
	}
}