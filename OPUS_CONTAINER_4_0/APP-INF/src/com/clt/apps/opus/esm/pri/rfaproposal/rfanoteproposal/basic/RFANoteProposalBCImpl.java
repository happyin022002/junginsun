/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFANoteProposalBCImpl.java
*@FileTitle : Guideline Clause & Standard Wording List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.integration.RFANoteProposalDBDAO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.NotePropVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.PriRpScpNoteCtntListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.PriRpScpNoteListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteCtntListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;
import com.clt.syscommon.common.table.PriRpScpNoteCtntVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCProposal<br>
 *
 * @author 
 * @see ESM_PRI_0089EventResponse,RFANoteProposalBC refer to each DAO class
 * @since J2EE 1.4
 */
public class RFANoteProposalBCImpl extends BasicCommandSupport implements RFANoteProposalBC {

	// Database Access Object
	private transient RFANoteProposalDBDAO dbDao = null;

	/**
	 * Creating RFANoteProposalBCImpl Object <br>
	 * Creating RFANoteProposalDBDAO.<br>
	 */
	public RFANoteProposalBCImpl() {
		dbDao = new RFANoteProposalDBDAO();
	}

	/**
	 * Retrieving SPECIAL NOTE's TITLE<br>
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
	 * Retrieving  SPECIAL NOTE's CONTENTS<br>
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
	 * Handling Amend Request<br>
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
// pri_sp_scp_note creation
// pri_sp_scp_note_ctnt creation
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
	 * Saving SPECIAL NOTE.<br>
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
						
						//DP_SEQ modification
						if("NW".equals(updateVoList.get(i).getSrcInfoCd())) {
							dbDao.modifyNote(vos);
						}
						
						if("AD".equals(updateVoList.get(i).getSrcInfoCd())) {
							
							//dbDao.modifyNote(updateVoList);
							//deleting added content data to current seq현재 SEQ에 추가된 CONTENT 데이터를 삭제한다.
							dbDao.removeGroupNoteContent(vos);
							//handling AMEND DELETE except AMEND, DELETE data
							
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
	 *Accepting SPECIAL NOTE CONTENTS<br>
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
	 *Cancelling SPECIAL NOTE CONTENTS<br>
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
	 * Accepting SPECIAL NOTE CONTENTS allbr>
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
			priRpScpNoteCtntVO.setAcptDt("1"); //'1': SYSDATE '0': null	
			priRpScpNoteCtntVO.setPrcProgStsCd("A"); // A: ALL ACCEPT I: ALL ACCEPT CANCEL
			
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
	 * Accepting SPECIAL NOTE CONTENTSall<br>
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
			priRpScpNoteCtntVO.setAcptDt("0"); // '1': SYSDATE '0': NULL
			priRpScpNoteCtntVO.setPrcProgStsCd("I"); // A: ALL ACCEPT I: ALL ACCEPT CANCEL
			
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
     * Copying RFA Proposal Scope Special Note information<br>
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
	 **Deleting all data of Amend Seq NO. when deleting Main's Init status<br>
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
	 * Modifying Accepted data to "Init" at once when cancelling request<br>
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
	 * Accepting automatically when requesting Main<br>
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
	 * Retrieving SPECIAL NOTE's TITLE<br>
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
	 *  Retrieving SPECIAL NOTE's CONTENTS<br>
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
	 * Retrieving SPECIAL NOTE's TITLE<br>
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
	 * Retrieving SPECIAL NOTE's TITLE<br>
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
     * Retrieving previous SEQ note's MAX_DP_SEQ <br>
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
     * Retrieving previous SEQ  NOTE CONTENT's MAX_DP_SEQ<br>
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
}