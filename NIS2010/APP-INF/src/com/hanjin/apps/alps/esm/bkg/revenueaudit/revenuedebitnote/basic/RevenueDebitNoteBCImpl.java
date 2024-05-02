/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RevenueDebitNoteBCImpl.java
*@FileTitle : RDN Issuance by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.19 이승준
* 1.0 Creation
* 2013.02.12 김진주 [CHM-201322816] [BKG/DOC - Revenue Audit System] RDN Status 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration.RDNIssueMailSendEAIDAO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration.RevenueDebitNoteDBDAO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.AttachmentVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.CstmBkgRevDrNoteVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RevDrNoteVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrAmtVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNoteVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNotesPerformanceVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNotesStatusVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNotesStatusSummaryVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltSearchRDNIssueMailingListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.UnStlRdnReportVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.AutoRdnInfoVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchBLVO;
import com.hanjin.framework.component.attachment.file.support.UpdateFileMetaInfo;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgRevDrAmtVO;
import com.hanjin.syscommon.common.table.BkgRevDrNoteProgVO;


/**
 * NIS2010-RevenueAudit Business Logic Basic Command implementation<br>
 * - NIS2010-RevenueAudit에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Seung Jun Lee
 * @see ESM_BKG_0426EventResponse,RevenueDebitNoteBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class RevenueDebitNoteBCImpl extends BasicCommandSupport implements RevenueDebitNoteBC {

	// Database Access Object
	private transient RevenueDebitNoteDBDAO dbDao = null;
	private transient RDNIssueMailSendEAIDAO rdnIssueMailSendEaiDao = null;
	
	
    /**
     * FullReleaseOrderBCImpl 객체 생성<br>
     * FullReleaseOrderDBDAO를 생성한다.<br>
     */
    public RevenueDebitNoteBCImpl() {
        dbDao = new RevenueDebitNoteDBDAO();
        rdnIssueMailSendEaiDao = new RDNIssueMailSendEAIDAO();
        
    }
    
	
	/**
	 *  RDN Issuance by Regional Group 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNote
	 * @return RevDrNoteVO
	 * @exception EventException
	 */
	public RevDrNoteVO searchRDNList(RevDrNoteVO revDrNote) throws EventException {
		try {
			//컨테이너 vo
			RevDrNoteVO revDrNoteVO = new RevDrNoteVO();
			//조회구분
			String searchGubun = revDrNote.getSearchGubun();
			
			//노트 헤드,타이틀, 바디
			List<RsltBkgRevDrNoteVO> rsltBkgRevDrNoteVOList 	= new ArrayList<RsltBkgRevDrNoteVO>();
			List<RsltBkgRevDrAmtVO> rsltbkgRevDrAmtVOList 		= new ArrayList<RsltBkgRevDrAmtVO>();
			
			
			//각 리스트를 받아서 컨테이너 vo에 담는다
			if("1".equals(searchGubun)) {		
				rsltBkgRevDrNoteVOList 		= dbDao.searchBkgRevDrNoteList(revDrNote.getBkgRevDrNoteVO());
				revDrNoteVO.setRsltBkgRevDrNoteVOList(rsltBkgRevDrNoteVOList);
			}	
			else if("2".equals(searchGubun)) {
				rsltbkgRevDrAmtVOList 		= dbDao.searchBkgRevDrAmtList(revDrNote.getBkgRevDrNoteVO());
				revDrNoteVO.setRsltBkgRevDrAmtVOList(rsltbkgRevDrAmtVOList);
			}	
			else if("3".equals(searchGubun)) {
				//Reciver의 최근 remark 조회
				String regionalRmk = "";
				String receiptRmk = "";
				regionalRmk = dbDao.searchBkgRevDrNoteProgMaxRmk(revDrNote.getBkgRevDrNoteVO());
				receiptRmk  = dbDao.searchBkgRevDrNoteProgReceiptMaxRmk(revDrNote.getBkgRevDrNoteVO());
				revDrNoteVO.setRegionalRmk(regionalRmk);
				revDrNoteVO.setReceiptRmk(receiptRmk);
				
			}
			//Receipt 조회
			else if("4".equals(searchGubun)) {		
				rsltBkgRevDrNoteVOList 		= dbDao.searchBkgRevDrNoteReceiptList(revDrNote.getBkgRevDrNoteVO());
				revDrNoteVO.setRsltBkgRevDrNoteVOList(rsltBkgRevDrNoteVOList);
			}
			
			//BLNO 로  bkg 관련 데이터 조회
			else if("5".equals(searchGubun)) {		
				rsltBkgRevDrNoteVOList 		= dbDao.searchBlno(revDrNote.getBkgRevDrNoteVO());
				revDrNoteVO.setRsltBkgRevDrNoteVOList(rsltBkgRevDrNoteVOList);
			}
			//cano 조회
			else if("6".equals(searchGubun)) {
				int cntCano = 0;
				cntCano = dbDao.searchCheckCaNo(revDrNote.getBkgRevDrNoteVO());
				revDrNoteVO.setCntCano(String.valueOf(cntCano));
				
			}
			//tpb no 조회
			else if("7".equals(searchGubun)) {
				int cntTpbno = 0;
				cntTpbno = dbDao.searchCheckTpbNo(revDrNote.getBkgRevDrNoteVO());
				revDrNoteVO.setCntTpbno(String.valueOf(cntTpbno));
				
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
	 *  RDN Status 화면에 대한 조회 이벤트 처리<br>
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
	 *  RDN Status 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RsltBkgRevDrNotesStatusVO rsltBkgRevDrNotesStatusVO
	 * @return List<RsltBkgRevDrNotesStatusSummaryVO>
	 * @exception EventException
	 */
	public List<RsltBkgRevDrNotesStatusSummaryVO> searchRDNStatusSummaryList(RsltBkgRevDrNotesStatusVO rsltBkgRevDrNotesStatusVO) throws EventException {
		try {			
			return dbDao.searchBkgRevDrNoteStatusSummaryList(rsltBkgRevDrNotesStatusVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		}
	}
	
	
	/**
	 *  RDN Performance Report 화면에 대한 조회 이벤트 처리<br>
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
	 * 진행중인 RDN No 를 조회한다.<br>
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

			// 기존에 진행되고 있는 RDN 이 있는지 Check 한다.
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
	 * RDN Issuance by Regional Group 화면에 대한 등록(issue) 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String createRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {
		
			//vo
			CstmBkgRevDrNoteVO   bkgRevDrNoteVO = null;
			BkgRevDrAmtVO[]   	 bkgRevDrAmtVOs = null;
			BkgRevDrNoteProgVO 	 bkgRevDrNoteProgVO = null;
			
			//컨테이너 vo에서  RDN,AMT,PROG를 뺀다
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
			bkgRevDrAmtVOs 		= revDrNoteVO.getBkgRevDrAmtVOs();
			bkgRevDrNoteProgVO  = revDrNoteVO.getBkgRevDrNoteProgVO();
			
			//AMT
			List<BkgRevDrAmtVO> insertVoList = new ArrayList<BkgRevDrAmtVO>();
			
			
			////////////////////////////RDN 저장/////////////////////////////////////////////
			
			//RDN 시퀀스
			String rdnNo = "";
			int rvisSeq = 1;
			
			//헤더
			if(bkgRevDrNoteVO != null) {
				//입력이면 max seq를 조회한 후 등록
				rdnNo = dbDao.searchBkgRevDrNoteMaxSeq(bkgRevDrNoteVO);
				
				bkgRevDrNoteVO.setRdnNo(rdnNo);
				bkgRevDrNoteVO.setRvisSeq(String.valueOf(rvisSeq));
				
				bkgRevDrNoteVO.setRdnStsCd("IS");
				
				bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addBkgRevDrNote(bkgRevDrNoteVO);
			}
			
			////////////////////////////RDN 저장/////////////////////////////////////////////
			
			
			////////////////////////////PROG 저장/////////////////////////////////////////////
			
			//PROG 시퀀스
			int progSeq = 1;
			
			if(bkgRevDrNoteVO != null) {
				//입력이면 max seq를 조회한 후 등록
				if(bkgRevDrNoteProgVO.getRdnNo() == null || "".equals(bkgRevDrNoteProgVO.getRdnNo()) ) {
					if(!"".equals(revDrNoteVO.getUmchRmk()) &&  revDrNoteVO.getUmchRmk() != null ){ //Batch 대상일 경우 RMK 항목에 추가
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
		
			////////////////////////////PROG 저장/////////////////////////////////////////////
			
			
			
			
			////////////////////////////AMT 저장/////////////////////////////////////	
		
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
	 * RDN Issuance by Regional Group 화면에 대한 수정 처리<br>
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
			
			//컨테이너 vo에서  RDN,AMT,PROG를 뺀다
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
			
			////////////////////////////RDN 저장/////////////////////////////////////////////
			
			
			//헤더
			//if(bkgRevDrNoteVO != null) {
				
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyBkgRevDrNote(bkgRevDrNoteVO);
				
			//}
			
			////////////////////////////RDN 저장/////////////////////////////////////////////
			
			
			////////////////////////////PROG 저장/////////////////////////////////////////////
			
			
			//if(bkgRevDrNoteVO != null) {
				
				bkgRevDrNoteProgVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyBkgRevDrNoteProg(bkgRevDrNoteProgVO);
				
			//}
		
			////////////////////////////PROG 저장/////////////////////////////////////////////
			
			
			
			
			////////////////////////////AMT 저장/////////////////////////////////////	
			// SETTEL 과 CANCEL 일때는 AMT 를 저장하지 않는다.

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
	 * RDN Receipt by Office 화면에 대한 수정 처리<br>
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
			
			//컨테이너 vo에서  RDN,AMT,PROG를 뺀다
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
			bkgRevDrNoteProgVO  = revDrNoteVO.getBkgRevDrNoteProgVO();
			
			
			
			////////////////////////////PROG 저장/////////////////////////////////////////////
			
			
			if(bkgRevDrNoteVO != null) {
				//receiver rmk
				bkgRevDrNoteProgVO.setRdnRmk(bkgRevDrNoteVO.getReceiverRmk());
				bkgRevDrNoteProgVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyBkgRevDrNoteProg(bkgRevDrNoteProgVO);
				
			}
		
			////////////////////////////PROG 저장/////////////////////////////////////////////
			
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	
	/**
	 * RDN Issuance by Regional Group issue 처리(사용안함 --> createRDNbyIssueOffice로 대체)<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void issueRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {

			//vo
			CstmBkgRevDrNoteVO    	 bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
			
			//컨테이너 vo에서  RDN,PROG를 뺀다
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
			
			
			String rdnNo = "";
			////////////////////////////RDN 저장  이슈 날짜, 상태코드 update/////////////////////////////////////////////

			if(bkgRevDrNoteVO != null) {
				//처음 저장시 바로 이슈할 경우 키값이 없을 수 있음
				if(bkgRevDrNoteVO.getRdnNo() == null || "".equals(bkgRevDrNoteVO.getRdnNo()) ) {
					//바로 전 키값
					rdnNo = dbDao.searchBkgRevDrNoteMaxSeqMinusOne(bkgRevDrNoteVO);
					
					bkgRevDrNoteVO.setRdnNo(rdnNo);
					//저장 후 ISSUE이므로 1
					bkgRevDrNoteVO.setRvisSeq("1");
				}	
				
				//상태코드
				bkgRevDrNoteVO.setRdnStsCd("IS");
				//이슈데이트
				bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				//상태코드 수정
				dbDao.modifyBkgRevDrNoteStatus(bkgRevDrNoteVO);
				
			
				////////////////////////////RDN 저장/////////////////////////////////////////////
				
				
				////////////////////////////상태 플래그가 바뀌므로 신규로 PROG 등록 /////////////////////////////////////////////
				
				//처음 저장시 바로 이슈할 경우 키값이 없을 수 있음
				if(bkgRevDrNoteVO.getRdnNo() == null || "".equals(bkgRevDrNoteVO.getRdnNo()) ) {
					bkgRevDrNoteVO.setRdnNo(rdnNo);
					bkgRevDrNoteVO.setRvisSeq("1");
				}	
				if(!"".equals(revDrNoteVO.getUmchRmk()) &&  revDrNoteVO.getUmchRmk() != null ){ //Batch 대상일 경우 RMK 항목에 추가
					bkgRevDrNoteVO.setRdnRmk("RDN ISSUED BY SYSTEM");
				}
				bkgRevDrNoteVO.setRdnStsCd("IS");
				//CRE_OFFICE_CD
				bkgRevDrNoteVO.setIssOfcCd(account.getOfc_cd());
				dbDao.addSearchBkgRevDrNoteProgOffice(bkgRevDrNoteVO);
				
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
	 * RDN Issuance by Regional Group revise 처리
	 * rvis_seq를 신규로 따서 등록후 각 디테일의 최근 값을 복사하여 신규로 등록한다.<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void reviseRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {

			//vo
			CstmBkgRevDrNoteVO   bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
			BkgRevDrAmtVO[]   	 bkgRevDrAmtVOs = null;
			BkgRevDrNoteProgVO 	 bkgRevDrNoteProgVO = null;
			
			//컨테이너 vo에서  RDN,AMT,PROG를 뺀다
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
			bkgRevDrAmtVOs 		= revDrNoteVO.getBkgRevDrAmtVOs();
			bkgRevDrNoteProgVO  = revDrNoteVO.getBkgRevDrNoteProgVO();
			
			//AMT
			List<BkgRevDrAmtVO> insertVoList = new ArrayList<BkgRevDrAmtVO>();
			
	
			////////////////////////////RDN 저장/////////////////////////////////////////////
			
			//RDN 시퀀스
			String rdnNo = "";
			int rvisSeq = 1;
			
			//헤더
			if(bkgRevDrNoteVO != null) {
				//입력이면 max seq를 조회한 후 등록
				//if(bkgRevDrNoteVO.getRdnNo() == null || "".equals(bkgRevDrNoteVO.getRdnNo()) ) {
					
					rdnNo = bkgRevDrNoteVO.getRdnNo();
				
					//rvis seq를 1 증가
					rvisSeq  = Integer.parseInt(bkgRevDrNoteVO.getRvisSeq())+1;
					bkgRevDrNoteVO.setRvisSeq(String.valueOf(rvisSeq));
					
					bkgRevDrNoteVO.setRdnStsCd("RV");
					
					bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
					bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
					
					dbDao.addBkgRevDrNote(bkgRevDrNoteVO);
				//}
			
				////////////////////////////RDN 저장/////////////////////////////////////////////
				
				
				////////////////////////////PROG 저장/////////////////////////////////////////////
				
				//PROG 시퀀스
				int progSeq = 1;
				
				bkgRevDrNoteProgVO.setRdnNo(rdnNo);
				bkgRevDrNoteProgVO.setRvisSeq(String.valueOf(rvisSeq));
				bkgRevDrNoteProgVO.setProgSeq(String.valueOf(progSeq));
				
				bkgRevDrNoteProgVO.setRdnStsCd("RV");
				//cre_ofc_cd
				bkgRevDrNoteProgVO.setCreOfcCd(bkgRevDrNoteVO.getIssOfcCd());
					
				bkgRevDrNoteProgVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteProgVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addBkgRevDrNoteProg(bkgRevDrNoteProgVO);
			
				////////////////////////////PROG 저장/////////////////////////////////////////////
				
				
				
				
				////////////////////////////AMT 저장/////////////////////////////////////	
	
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
	 * RDN Issuance by Regional Group reissue 처리
	 * rvis_seq를 신규로 따서 등록후 각 디테일의 최근 값을 복사하여 신규로 등록한다.<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void reissueRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {
		
			//vo
			CstmBkgRevDrNoteVO    	 bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
			
			//컨테이너 vo에서  RDN,PROG를 뺀다
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
			
			////////////////////////////RDN 저장  이슈 날짜, 상태코드 update/////////////////////////////////////////////

			if(bkgRevDrNoteVO != null) {
				
				//상태코드
				bkgRevDrNoteVO.setRdnStsCd("IS");
				//이슈데이트
				//bkgRevDrNoteVO.setRdnIssDt("SYSDATE");
				bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				//상태코드 수정
				dbDao.modifyBkgRevDrNoteStatus(bkgRevDrNoteVO);
				
			
				////////////////////////////RDN 저장/////////////////////////////////////////////
				
				
				////////////////////////////상태 플래그가 바뀌므로 신규로 PROG 등록 /////////////////////////////////////////////
				
				bkgRevDrNoteVO.setRdnStsCd("IS");
				//CRE_OFFICE_CD
				bkgRevDrNoteVO.setIssOfcCd(account.getOfc_cd());
				dbDao.addSearchBkgRevDrNoteProgOffice(bkgRevDrNoteVO);
		
				////////////////////////////PROG 등록/////////////////////////////////////////////
			
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
	 * RDN Issuance by Regional Group cancel 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {

			//vo
			CstmBkgRevDrNoteVO    	 bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
			
			//컨테이너 vo에서  RDN,PROG를 뺀다
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
			
			
			////////////////////////////RDN 저장  이슈 날짜, 상태코드 update/////////////////////////////////////////////

			if(bkgRevDrNoteVO != null) {
				//상태코드
				bkgRevDrNoteVO.setRdnStsCd("CL");
				//이슈데이트
				//bkgRevDrNoteVO.setRdnIssDt("SYSDATE");
				bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				//상태코드 수정
				dbDao.modifyBkgRevDrNoteStatus(bkgRevDrNoteVO);
				
			
				////////////////////////////RDN 저장/////////////////////////////////////////////
				
				
				////////////////////////////상태 플래그가 바뀌므로 신규로 PROG 등록 /////////////////////////////////////////////
				bkgRevDrNoteVO.setRdnStsCd("CL");
				bkgRevDrNoteVO.setIssOfcCd(account.getOfc_cd());
				
				dbDao.addSearchBkgRevDrNoteProgOffice(bkgRevDrNoteVO);
				
				////////////////////////////PROG 등록/////////////////////////////////////////////

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
	 * RDN Issuance by Regional Group cancel 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void validCancelRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {

			//vo
			CstmBkgRevDrNoteVO    	 bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
			
			//컨테이너 vo에서  RDN,PROG를 뺀다
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
			
			
			
			////////////////////////////RDN 저장  이슈 날짜, 상태코드 update/////////////////////////////////////////////

			if(bkgRevDrNoteVO != null) {
				//상태코드
				bkgRevDrNoteVO.setRdnStsCd("CV");
				//이슈데이트
				bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				//상태코드 수정
				dbDao.modifyBkgRevDrNoteStatus(bkgRevDrNoteVO);
				
			
				////////////////////////////RDN 저장/////////////////////////////////////////////
				
				
				////////////////////////////상태 플래그가 바뀌므로 신규로 PROG 등록 /////////////////////////////////////////////
				bkgRevDrNoteVO.setRdnStsCd("CV");
				bkgRevDrNoteVO.setIssOfcCd(account.getOfc_cd());
				
				dbDao.addSearchBkgRevDrNoteProgOffice(bkgRevDrNoteVO);
				
				////////////////////////////PROG 등록/////////////////////////////////////////////
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
	 * RDN Issuance by Regional Group settle 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void settleRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {

			//vo
			CstmBkgRevDrNoteVO   bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();			
			
			//컨테이너 vo에서  RDN,PROG를 뺀다
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
			
			
			
			////////////////////////////RDN 저장  이슈 날짜, 상태코드 update/////////////////////////////////////////////

			if(bkgRevDrNoteVO != null) {
				
				//Other(CTY)는 Settle시 금액이 확정된다.
				if(bkgRevDrNoteVO.getUmchTpCd().equals("T")) {
					BkgRevDrAmtVO[]   	 bkgRevDrAmtVOs = null;
					bkgRevDrAmtVOs 		= revDrNoteVO.getBkgRevDrAmtVOs();

					//AMT
					List<BkgRevDrAmtVO> insertVoList = new ArrayList<BkgRevDrAmtVO>();
					List<BkgRevDrAmtVO> updateVoList = new ArrayList<BkgRevDrAmtVO>();
					List<BkgRevDrAmtVO> deleteVoList = new ArrayList<BkgRevDrAmtVO>();
					
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
				
				
				//상태코드
				bkgRevDrNoteVO.setRdnStsCd("ST");
				//이슈데이트
				bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				//상태코드 수정
				dbDao.modifyBkgRevDrNoteStatus(bkgRevDrNoteVO);
				
			
				////////////////////////////RDN 저장/////////////////////////////////////////////
				
				
				////////////////////////////상태 플래그가 바뀌므로 신규로 PROG 등록 /////////////////////////////////////////////
				bkgRevDrNoteVO.setRdnStsCd("ST");
				bkgRevDrNoteVO.setIssOfcCd(account.getOfc_cd());
				
				dbDao.addSearchBkgRevDrNoteProgOffice(bkgRevDrNoteVO);

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
	 * RDN Receipt by Office Accept 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void acceptRDNbyReceiptOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {

			//vo
			CstmBkgRevDrNoteVO    	 bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
			
			//컨테이너 vo에서  RDN,PROG를 뺀다
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
			
			
			////////////////////////////RDN 저장  이슈 날짜, 상태코드 update/////////////////////////////////////////////

			if(bkgRevDrNoteVO != null) {
				//상태코드
				bkgRevDrNoteVO.setRdnStsCd("AC");
				//이슈데이트
				bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				//상태코드 수정
				dbDao.modifyBkgRevDrNoteStatus(bkgRevDrNoteVO);
				
			
				////////////////////////////RDN 저장/////////////////////////////////////////////
				
				
				////////////////////////////상태 플래그가 바뀌므로 신규로 PROG 등록 /////////////////////////////////////////////
				bkgRevDrNoteVO.setRdnStsCd("AC");
				bkgRevDrNoteVO.setIssOfcCd(account.getOfc_cd());
				
				dbDao.addSearchBkgRevDrNoteProgReciver(bkgRevDrNoteVO);

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
	 * RDN Receipt by Office Revise Request 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void reviseRequestRDNbyReceiptOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {

			//vo
			CstmBkgRevDrNoteVO    	 bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
			
			//컨테이너 vo에서  RDN,PROG를 뺀다
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();
			
			
			////////////////////////////RDN 저장  이슈 날짜, 상태코드 update/////////////////////////////////////////////

			if(bkgRevDrNoteVO != null) {
				//상태코드
				bkgRevDrNoteVO.setRdnStsCd("RR");
				//이슈데이트
				bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				//상태코드 수정
				dbDao.modifyBkgRevDrNoteStatus(bkgRevDrNoteVO);
				
			
				////////////////////////////RDN 저장/////////////////////////////////////////////
				
				
				////////////////////////////상태 플래그가 바뀌므로 신규로 PROG 등록 /////////////////////////////////////////////
				bkgRevDrNoteVO.setRdnStsCd("RR");
				bkgRevDrNoteVO.setIssOfcCd(account.getOfc_cd());
				
				dbDao.addSearchBkgRevDrNoteProgReciver(bkgRevDrNoteVO);
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
	 * RDN Receipt by Office Cancel Request 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelRequestRDNbyReceiptOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException{
		try {

			//vo
			CstmBkgRevDrNoteVO    	 bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
			
			//컨테이너 vo에서  RDN,PROG를 뺀다
			bkgRevDrNoteVO 		= revDrNoteVO.getBkgRevDrNoteVO();	
			
			////////////////////////////RDN 저장  이슈 날짜, 상태코드 update/////////////////////////////////////////////

			if(bkgRevDrNoteVO != null) {
				//상태코드
				bkgRevDrNoteVO.setRdnStsCd("CR");
				//이슈데이트
				bkgRevDrNoteVO.setCreUsrId(account.getUsr_id());
				bkgRevDrNoteVO.setUpdUsrId(account.getUsr_id());
				//상태코드 수정
				dbDao.modifyBkgRevDrNoteStatus(bkgRevDrNoteVO);
				
			
				////////////////////////////RDN 저장/////////////////////////////////////////////
				
				
				////////////////////////////상태 플래그가 바뀌므로 신규로 PROG 등록 /////////////////////////////////////////////
				bkgRevDrNoteVO.setRdnStsCd("CR");
				bkgRevDrNoteVO.setIssOfcCd(account.getOfc_cd());
				
				dbDao.addSearchBkgRevDrNoteProgReciver(bkgRevDrNoteVO);
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
	 *  RDN Issuance by Auditor Issue 발생시 메일 대상자를 조회한다.<br>
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
	 * RDN Issuance by Auditor 메일대상자에게 메일을 일괄 발송한다. <br>
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
	 * Non-Charged B/L에 대한 RDN 자동발행
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
			
			//auto RDN의 경우 Remark 항목 추가
			revDrNoteVO.setUmchRmk("RDN ISSUED BY SYSTEM");
			// 등록
			this.createRDNbyIssueOffice(revDrNoteVO, account);
			// Issue
			this.issueRDNbyIssueOffice(revDrNoteVO, account);
			// RDN NO 조회
			String rdnNo = dbDao.searchExistRevDrNote(revDrNoteVO.getBkgRevDrNoteVO());
			
			// 메일 일괄 발송
			RsltSearchRDNIssueMailingListVO vo = new RsltSearchRDNIssueMailingListVO();
			vo.setMailTitle("[RDN Notice] " + autoRdnInfoVO.getRctOfcCd() + " / " + autoRdnInfoVO.getRdnIssDt()
					+ " / WK " + autoRdnInfoVO.getRdnIssDtWk() + " / " + autoRdnInfoVO.getBlNo());
			vo.setRdnIssDtWk("");
			vo.setRctOfcCd(autoRdnInfoVO.getRctOfcCd());
			vo.setContFm("SELADG_Rev Audit");
			vo.setRdnNo(rdnNo);
			vo.setRdnAmount("");
			vo.setRdnIssDt(autoRdnInfoVO.getRdnIssDt());
			vo.setBlNo(autoRdnInfoVO.getBlNo());
			vo.setScRfaNo(autoRdnInfoVO.getScRfaNo());
			vo.setErrorKind("Non-Charged B/L / / Rating Approval Delay\n");
			vo.setRdnRmk("");
			vo.setIbflag("AUTO");
	
			// 대상자조회
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
	
	
	/**
	 * Re-issue 기능을 사용 가능한 ID인지 체크한다.
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String checkReissueAvailableUser(SignOnUserAccount account) throws EventException {
		try {
			return dbDao.checkReissueAvailableUser(account);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00098",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00098",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 *  Attachment File 목록 조회<br>
	 * 
	 * @param AttachmentVO vo
	 * @return List<AttachmentVO>
	 * @exception EventException
	 */
	public List<AttachmentVO> searchAttachmentList(AttachmentVO vo) throws EventException {
		try {			
			return dbDao.searchAttachmentList(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		}
	}

	/**
	 * ESM_BKG_0207 멀티 이벤트 처리<br>
	 * ESM_BKG_0207 화면에 대한 멀티 이벤트 처리<br>
	 * //1.UPDATE 상태를 확인한다.
	 * //1-1 delete List 추가
	 * //1-1-1 UpdateFileMetaInfo
	 * file_meta 정보 삭제 (FILE_SAVE_ID)
	 * //1-2 insert List 추가
	 * //2. DELETE 상태를 확인
	 * //2-1 delete List 추가
	 * //2-1-1 UpdateFileMetaInfo file_meta 정보 삭제
	 * (FILE_SAVE_ID)
	 * //3. INSERT 상태를 확인
	 * //3-1 insert List 추가
	 * //4. 삭제먼저 수행하고 추가를수행한다.
	 * //5. 맨마지막에 일괄 com_upload 테이블과 동기화 쿼리
	 * @author Lee Jin Seo
	 * @param AttachmentVO[] vos
	 * @param String[] fileSavId
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAttachment(AttachmentVO[] vos, String[] fileSavId, SignOnUserAccount account) throws EventException {
		log.debug("[START:: SpecialCargoRiderBCImpl == manageSpclRider  ]==========");

		try {
			List<AttachmentVO> insertVoList = new ArrayList<AttachmentVO>();
			List<AttachmentVO> deleteVoList = new ArrayList<AttachmentVO>();
			int saveIdCnt = 0;
			String atchFileLnkId = "";
			
			if(vos.length > 0){
				atchFileLnkId = dbDao.searchAttachFileLinkId(vos[0]);
			}				
					
					
			for (int i = 0; i < vos.length; i++) {
				if (vos[i].getIbflag().equals("U")) {
					log.debug("[START:: SpecialCargoRiderBCImpl]updateVoList=====" + vos[i].getFileSavId());
					deleteVoList.add(vos[i]);
					vos[i].setIbflag("I");
				}

				if (vos[i].getIbflag().equals("D")) {
					log.debug("[START:: SpecialCargoRiderBCImpl]deleteVoList=====" + vos[i].getFileSavId());
					deleteVoList.add(vos[i]);
					UpdateFileMetaInfo.delete(vos[i].getFileSavId());

				} else if (vos[i].getIbflag().equals("I")) {
					log.debug("[START:: SpecialCargoRiderBCImpl]insertVoList=====" + vos[i].getFileSavId());

					if (vos[i].getFileSavId() == null || vos[i].getFileSavId().length() == 0) {
						vos[i].setFileSavId(fileSavId[saveIdCnt]);
						saveIdCnt  = saveIdCnt + 1;
					}

					vos[i].setAtchFileLnkId(atchFileLnkId);
					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(vos[i]);
				}
			}
			if (deleteVoList.size() > 0) {

				dbDao.removeAttachments(deleteVoList);
			}
			if (insertVoList.size() > 0) {
				dbDao.addAttachments(insertVoList);				
			}
			
			//BKG_REV_DR_NOTE에 File Link ID 업데이트
			dbDao.modifyAttachFileLinkId(vos[0]);	 

		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}
		log.debug("[END::]==========");
	}
	
	 /**
	  * unsettled rdn aging list를 조회한다.
	 * @param UnStlRdnReportVO vo
	 * @return List<UnStlRdnReportVO>
	 * @throws EventException
	 */
	public List<UnStlRdnReportVO> searchUnSettledRdnAgingList(UnStlRdnReportVO vo) throws EventException {
		try {			
			return dbDao.searchUnSettledRdnAgingList(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		}
	}
}