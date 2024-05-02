/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFANoteProposalBCImpl.java
*@FileTitle : Guideline Clause & Standard Wording List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.18 문동규
* 1.0 Creation
=========================================================
 * History
 * 2015.10.28 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
 * 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.integration.RFANoteProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.NotePropVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.PriRpScpNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.PriRpScpNoteListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpNoteCtntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;

/**
 * NIS2010-SCProposal Business Logic Basic Command implementation<br>
 * - NIS2010-SCProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_0089EventResponse,RFANoteProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class RFANoteProposalBCImpl extends BasicCommandSupport implements RFANoteProposalBC {

	// Database Access Object
	private transient RFANoteProposalDBDAO dbDao = null;

	/**
	 * RFANoteProposalBCImpl 객체 생성<br>
	 * RFANoteProposalDBDAO를 생성한다.<br>
	 */
	public RFANoteProposalBCImpl() {
		dbDao = new RFANoteProposalDBDAO();
	}

	/**
	 * SPECIAL NOTE의 TITLE를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteListVO priRpScpNoteListVO  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltNoteListVO> searchNoteList(PriRpScpNoteListVO priRpScpNoteListVO) throws EventException {
		try {
			return dbDao.searchNoteList(priRpScpNoteListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
		
	/**
	 * SPECIAL NOTE의 CONTENTS를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO  
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchSpecialNoteContentList(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws EventException {
		try {
			return dbDao.searchSpecialNoteContentList(priRpScpNoteCtntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {

			List<PriRpMnVO> insertVoList = new ArrayList<PriRpMnVO>();
			
			priRpMnVO.setCreUsrId(account.getUsr_id());
			priRpMnVO.setUpdUsrId(account.getUsr_id());					
			insertVoList.add(priRpMnVO);
// pri_sp_scp_note) 신규 생성
// pri_sp_scp_note_ctnt 신규 생성			
			dbDao.addProposalNoteAmend (insertVoList);
			dbDao.addProposalNoteContentAmend (insertVoList);
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	
	/**
	 * SPECIAL NOTE를 저장합니다.<br>
	 * 
	 * @param NotePropVO notePropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNote(NotePropVO notePropVO, SignOnUserAccount account) throws EventException{
		try {
			PriRpScpNoteListVO[] vo = notePropVO.getPriRpScpNoteListVOs();
			PriRpScpNoteCtntListVO[] dtlvo = notePropVO.getPriRpScpNoteCtntListVOs();
			String masterDelChk = notePropVO.getMasterDelChk();
			
			List<PriRpScpNoteListVO> insertVoList = new ArrayList<PriRpScpNoteListVO>();
			List<PriRpScpNoteListVO> updateVoList = new ArrayList<PriRpScpNoteListVO>();
			List<PriRpScpNoteListVO> deleteVoList = new ArrayList<PriRpScpNoteListVO>();
			List<PriRpScpNoteCtntListVO> insertDtlVoList = new ArrayList<PriRpScpNoteCtntListVO>();
			List<PriRpScpNoteCtntListVO> updateDtlVoList = new ArrayList<PriRpScpNoteCtntListVO>();
			List<PriRpScpNoteCtntListVO> deleteDtlVoList = new ArrayList<PriRpScpNoteCtntListVO>();		
			
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("I")){
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());					
					insertVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("D")){
					deleteVoList.add(vo[i]);
				}
			}
			
			for ( int i = 0; dtlvo != null && i < dtlvo.length; i++ ) {
				if ( dtlvo[i].getIbflag().equals("I")){
					dtlvo[i].setCreUsrId(account.getUsr_id());
					dtlvo[i].setUpdUsrId(account.getUsr_id());					
					insertDtlVoList.add(dtlvo[i]);
				} else if ( dtlvo[i].getIbflag().equals("U")){
					dtlvo[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(dtlvo[i]);
				} else if ( dtlvo[i].getIbflag().equals("D")){
					deleteDtlVoList.add(dtlvo[i]);
				}
			}	
			if ( insertVoList.size() > 0 ) {
				dbDao.addNote(insertVoList);
			}
						
			if ( updateVoList.size() > 0 ) {
				
				if("Y".equals(masterDelChk)) {
					PriRpScpNoteListVO vos = null;
					for(int i=0; i<updateVoList.size(); i++){
						vos = new PriRpScpNoteListVO();
						ObjectCloner.build(updateVoList.get(i), vos);
						
						//DP_SEQ수정
						if("NW".equals(updateVoList.get(i).getSrcInfoCd())) {
							dbDao.modifyNote(vos);
						}
						
						if("AD".equals(updateVoList.get(i).getSrcInfoCd())) {
							//DELETE처리기 때문에 수정처리는 하지 않는다.
							//dbDao.modifyNote(updateVoList);
							//현재 SEQ에 추가된 CONTENT 데이터를 삭제한다.
							dbDao.removeGroupNoteContent(vos);
							//AMEND, DELETE된 데이터를 제외한 데이터를 AMEND DELETE처리한다.
							
							vos.setN1stCmncAmdtSeq(vos.getAmdtSeq());
							vos.setDpSeq(null);
							vos.setSrcInfoCd("AD");
							vos.setPrcProgStsCd("I");
							dbDao.modifyGroupNoteContent(vos);
						}
					}
				} else {
					dbDao.modifyNote(updateVoList);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeGroupNoteContent(deleteVoList);
				dbDao.removeNote(deleteVoList);
			}
			if ( insertDtlVoList.size() > 0 ) {
				dbDao.addNoteContent(insertDtlVoList);
			}
			
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyNoteContent(updateDtlVoList);
			}
			
			if ( deleteDtlVoList.size() > 0 ) {
				dbDao.removeNoteContent(deleteDtlVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * SPECIAL NOTE CONTENTS를 ACCEPT합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO[] priRpScpNoteCtntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptNote(PriRpScpNoteCtntVO[] priRpScpNoteCtntVOs, SignOnUserAccount account) throws EventException{
		try {
			List<PriRpScpNoteCtntVO> updateVoList = new ArrayList<PriRpScpNoteCtntVO>();
			for ( int i=0; i<priRpScpNoteCtntVOs.length; i++ ) {
				if ( priRpScpNoteCtntVOs[i].getIbflag().equals("U")){
					priRpScpNoteCtntVOs[i].setUpdUsrId(account.getUsr_id());			
					priRpScpNoteCtntVOs[i].setAcptOfcCd(account.getOfc_cd());
					priRpScpNoteCtntVOs[i].setAcptUsrId(account.getUsr_id());	
					priRpScpNoteCtntVOs[i].setAcptDt("1"); //'1'이면 SYSDATE '0'이면 null	
										
					updateVoList.add(priRpScpNoteCtntVOs[i]);
				}
			}
						
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAcceptNote(updateVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * SPECIAL NOTE CONTENTS를 CANCEL합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO[] priRpScpNoteCtntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelNote(PriRpScpNoteCtntVO[] priRpScpNoteCtntVOs, SignOnUserAccount account) throws EventException{
		try {
			List<PriRpScpNoteCtntVO> updateVoList = new ArrayList<PriRpScpNoteCtntVO>();
			for ( int i=0; i<priRpScpNoteCtntVOs.length; i++ ) {
				if ( priRpScpNoteCtntVOs[i].getIbflag().equals("U")){
					priRpScpNoteCtntVOs[i].setUpdUsrId(account.getUsr_id());
					
					priRpScpNoteCtntVOs[i].setAcptOfcCd(null);
					priRpScpNoteCtntVOs[i].setAcptUsrId(null);	
					priRpScpNoteCtntVOs[i].setAcptDt("0"); // '1'이면 SYSDATE '0'이면 NULL
					
					updateVoList.add(priRpScpNoteCtntVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAcceptNote(updateVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * SPECIAL NOTE CONTENTS를 All ACCEPT합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @return Integer
	 * @exception EventException
	 */
	public int acceptAllNote(PriRpScpNoteCtntVO priRpScpNoteCtntVO, SignOnUserAccount account) throws EventException{
		try {
			List<RsltNoteCtntListVO> list = new ArrayList<RsltNoteCtntListVO>();
			
			priRpScpNoteCtntVO.setUpdUsrId(account.getUsr_id());			
			priRpScpNoteCtntVO.setAcptOfcCd(account.getOfc_cd());
			priRpScpNoteCtntVO.setAcptUsrId(account.getUsr_id());	
			priRpScpNoteCtntVO.setAcptDt("1"); //'1'이면 SYSDATE '0'이면 null	
			priRpScpNoteCtntVO.setPrcProgStsCd("A"); // A이면 ALL ACCEPT I이면 ALL ACCEPT CANCEL
			
			list = dbDao.searchAllAcceptDataList(priRpScpNoteCtntVO);
			
			if(list.size()> 0){
				dbDao.modifyAcceptAllNote(priRpScpNoteCtntVO);
			}
			
			return list.size();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * SPECIAL NOTE CONTENTS를 All CANCEL합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @return Integer
	 * @exception EventException
	 */
	public int cancelAllNote(PriRpScpNoteCtntVO priRpScpNoteCtntVO, SignOnUserAccount account) throws EventException{
		try {
			List<RsltNoteCtntListVO> list = new ArrayList<RsltNoteCtntListVO>();
			
			priRpScpNoteCtntVO.setUpdUsrId(account.getUsr_id());				
			priRpScpNoteCtntVO.setAcptOfcCd(null);
			priRpScpNoteCtntVO.setAcptUsrId(null);	
			priRpScpNoteCtntVO.setAcptDt("0"); // '1'이면 SYSDATE '0'이면 NULL
			priRpScpNoteCtntVO.setPrcProgStsCd("I"); // A이면 ALL ACCEPT I이면 ALL ACCEPT CANCEL
			
			list = dbDao.searchAllAcceptDataList(priRpScpNoteCtntVO);
		
			if(list.size()> 0){
				dbDao.modifyAcceptAllNote(priRpScpNoteCtntVO);
			}
			
			return list.size();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}


    /**
     * RFA Proposal Scope Special Note 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeNote(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltRfaPropCopyVO.setCreUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setUpdUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setOfcCd(account.getOfc_cd());
            // PRI_RP_SCP_NOTE COPY
            dbDao.addCopyProposalScopeNote(rsltRfaPropCopyVO);
            // PRI_RP_SCP_NOTE_CTNT COPY
            dbDao.addCopyProposalScopeNoteCtnt(rsltRfaPropCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalContent(priRpScpMnVO);
			dbDao.removeProposal(priRpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
 

	/**

	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException{
		try {
			List<PriRpScpMnVO> updateVoList = new ArrayList<PriRpScpMnVO>();
			
			for ( int i = 0; priRpScpMnVOs != null && i < priRpScpMnVOs.length; i++ ) {
				priRpScpMnVOs[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(priRpScpMnVOs[i]);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalRequestCancel(updateVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}		
	
	/**
	 * Master RFA에서 Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelMst(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException{
		try {
			List<PriRpScpMnVO> updateVoList = new ArrayList<PriRpScpMnVO>();
			
			for ( int i = 0; priRpScpMnVOs != null && i < priRpScpMnVOs.length; i++ ) {
				priRpScpMnVOs[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(priRpScpMnVOs[i]);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalRequestCancel(updateVoList);
				// Note Conversion
				dbDao.modifyProposalConvRequestCancel(updateVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Main Request 시 자동으로 Accept를 합니다.<br>
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void autoAcceptProposalNote(PriRpScpNoteCtntVO priRpScpNoteCtntVO, SignOnUserAccount account) throws EventException{
		try {		
			if (priRpScpNoteCtntVO != null){
				priRpScpNoteCtntVO.setUpdUsrId(account.getUsr_id());	
				priRpScpNoteCtntVO.setAcptUsrId(account.getUsr_id());
				dbDao.modifyAutoAcceptProposalNote (priRpScpNoteCtntVO);
			}
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * SPECIAL NOTE의 TITLE를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteListVO priRpScpNoteListVO  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltNoteListVO> searchNoteHistoryList(PriRpScpNoteListVO priRpScpNoteListVO) throws EventException {
		try {
			return dbDao.searchNoteHistoryList(priRpScpNoteListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
		
	/**
	 * SPECIAL NOTE의 CONTENTS를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO  
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchSpecialNoteContentHistoryList(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws EventException {
		try {
			return dbDao.searchSpecialNoteContentHistoryList(priRpScpNoteCtntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * SPECIAL NOTE의 TITLE를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteListVO priRpScpNoteListVO  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltNoteListVO> searchNoteInquiryList(PriRpScpNoteListVO priRpScpNoteListVO) throws EventException {
		try {
			return dbDao.searchNoteInquiryList(priRpScpNoteListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
		
	/**
	 * SPECIAL NOTE의 CONTENTS를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO  
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchSpecialNoteContentInquiryList(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws EventException {
		try {
			return dbDao.searchSpecialNoteContentInquiryList(priRpScpNoteCtntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	

    /**
     * 이전SEQ에 해당하는 NOTE의 MAX DP_SEQ를 조회한다. <br>
     * 
     * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
     * @return String
     * @exception EventException
     */
    public String searchNoteMaxDpSeq(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws EventException{
		try {	
			return dbDao.searchNoteMaxDpSeq(priRpScpNoteCtntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
    

    /**
     * 이전SEQ에 해당하는 NOTE CONTENT의 MAX DP_SEQ를 조회한다. <br>
     * 
     * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
     * @return String
     * @exception EventException
     */
    public String searchNoteContentMaxDpSeq(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws EventException{
		try {	
			return dbDao.searchNoteContentMaxDpSeq(priRpScpNoteCtntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}


	/**
	 * Summary 팝업에서 승인 대상인 모든 Service Scope Special Notes 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchAllSpecialNoteContentList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {	
			return dbDao.searchAllSpecialNoteContentList(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
}