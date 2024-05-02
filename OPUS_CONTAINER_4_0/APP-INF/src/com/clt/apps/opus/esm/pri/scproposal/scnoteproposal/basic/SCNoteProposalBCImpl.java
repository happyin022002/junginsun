/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteProposalBCImpl.java
*@FileTitle : Guideline Clause & Standard Wording List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.integration.SCNoteProposalDBDAO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.NotePropVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteCtntListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltCtrtCluzListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteCtntListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteHeaderVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpNoteCtntVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCProposal<br>
 *
 * @author
 * @see ESM_PRI_0089EventResponse,SCNoteProposalBC - Refer to each DAO class
 * @since J2EE 1.4
 */
public class SCNoteProposalBCImpl extends BasicCommandSupport implements SCNoteProposalBC {

	// Database Access Object
	private transient SCNoteProposalDBDAO dbDao = null;

	/**
	 * Creating SCNoteProposalBCImpl object<br>
	 * Creating SCNoteProposalDBDAO<br>
	 */
	public SCNoteProposalBCImpl() {
		dbDao = new SCNoteProposalDBDAO();
	}
	/**
	 * Retrieving Contract Clause Master Detail <br>
	 * 
	 * @param RsltCtrtCluzListVO rsltCtrtCluzListVO
	 * @return List<RsltCtrtCluzListVO>
	 * @exception EventException
	 */
	public List<RsltCtrtCluzListVO> searchContractClauseMasterDetailList(RsltCtrtCluzListVO rsltCtrtCluzListVO) throws EventException {
		try {
			return dbDao.searchContractClauseMasterDetailList(rsltCtrtCluzListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
		
	/**
	 * Copying Guideline Standard Note<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @param SignOnUserAccount account
	 * @return Integer
	 * @exception EventException
	 */
	public int copyGuidelineNote(PriSpScpNoteListVO priSpScpNoteListVO, SignOnUserAccount account) throws EventException{		
		try {
			int result = 0;
			priSpScpNoteListVO.setCreUsrId(account.getUsr_id());
			priSpScpNoteListVO.setUpdUsrId(account.getUsr_id());
						
			if ( priSpScpNoteListVO != null ) {
				List<RsltNoteCtntListVO> list = new ArrayList<RsltNoteCtntListVO>();
				list = dbDao.searchNoteContentExist(priSpScpNoteListVO);
				if(list.size() > 0) {
					result = dbDao.addProposalNoteGlineCopy (priSpScpNoteListVO);
					dbDao.addProposalNoteContentGlineCopy (priSpScpNoteListVO);
					//dbDao.modifyProposalNoteHeaderSequence (priSpScpNoteListVO);
				}
			}
			return result;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Retrieving S/C Standard Note Header<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO  
	 * @return RsltNoteHeaderVO
	 * @exception EventException
	 */
	public List<RsltNoteHeaderVO> searchNoteHeader(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException {
		try {
			return dbDao.searchNoteHeader(priSpScpNoteListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving S/C Standard Note Title<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltNoteListVO> searchNoteList(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException {
		try {
			return dbDao.searchNoteList(priSpScpNoteListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving S/C Standard Note Content<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO  
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchNoteContentList(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException {
		try {
			return dbDao.searchNoteContentList(priSpScpNoteCtntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving S/C Special Note Content<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO  
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchSpecialNoteContentList(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException {
		try {
			return dbDao.searchSpecialNoteContentList(priSpScpNoteCtntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Requesting Amend<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {

			List<PriSpMnVO> insertVoList = new ArrayList<PriSpMnVO>();
			
			priSpMnVO.setCreUsrId(account.getUsr_id());
			priSpMnVO.setUpdUsrId(account.getUsr_id());					
			insertVoList.add(priSpMnVO);
// pri_sp_scp_note) creation
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
	 * Saving S/C Standard Note<br>
	 * 
	 * @param NotePropVO notePropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNote(NotePropVO notePropVO, SignOnUserAccount account) throws EventException{
		try {
			PriSpScpNoteListVO[] vo = notePropVO.getPriSpScpNoteListVOs();
			PriSpScpNoteCtntListVO[] dtlvo = notePropVO.getPriSpScpNoteCtntListVOs();
			String masterDelChk = notePropVO.getMasterDelChk();
			PriSpScpNoteListVO priSpScpNoteListVO = notePropVO.getPriSpScpNoteListVO();
			
			List<PriSpScpNoteListVO> insertVoList = new ArrayList<PriSpScpNoteListVO>();
			List<PriSpScpNoteListVO> updateVoList = new ArrayList<PriSpScpNoteListVO>();
			List<PriSpScpNoteListVO> deleteVoList = new ArrayList<PriSpScpNoteListVO>();
			List<PriSpScpNoteCtntListVO> insertDtlVoList = new ArrayList<PriSpScpNoteCtntListVO>();
			List<PriSpScpNoteCtntListVO> updateDtlVoList = new ArrayList<PriSpScpNoteCtntListVO>();
			List<PriSpScpNoteCtntListVO> deleteDtlVoList = new ArrayList<PriSpScpNoteCtntListVO>();			
			
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("I")){
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());					
					insertVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
					
					vo[i].setEffDt(priSpScpNoteListVO.getEffDt());
					vo[i].setExpDt(priSpScpNoteListVO.getExpDt());
					
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
					PriSpScpNoteListVO vos = null;
					for(int i=0; i<updateVoList.size(); i++){
						vos = new PriSpScpNoteListVO();
						ObjectCloner.build(updateVoList.get(i), vos);

						//DP_SEQ modification
						if("NW".equals(updateVoList.get(i).getSrcInfoCd())) {
							dbDao.modifyNote(vos);
						}
						
						if("AD".equals(updateVoList.get(i).getSrcInfoCd())) {
							//Prohibiting from modifying because of deleting
							//dbDao.modifyNote(updateVoList);
							//Deleting contents to be added to current seq
							dbDao.removeGroupNoteContent(vos);
							//deleting amended data except amended,deleted data
							
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
			
			//WHEN DEM/DET was deleted, history
			if ( deleteVoList.size() > 0 ) {
				List<PriSpScpNoteListVO> insNoteVo = new ArrayList<PriSpScpNoteListVO>();
				//history(DEM/DET) PRI_SP_SCP_NOTE_MIG_HIS ------------
				for(int i = 0; i < deleteVoList.size(); i++){
					PriSpScpNoteListVO noteVo = deleteVoList.get(i);
					if(noteVo.getNoteClssCd().equals("D")){
						insNoteVo.add(noteVo);
					}
					
				}
				if(insNoteVo.size() > 0){
					dbDao.addNoteHistory(insNoteVo);
				}
				
				//history(DEM/DET) PRI_SP_SCP_NOTE_CTNT_MIG_HIS ------------
				if(insNoteVo.size() > 0){
					List<PriSpScpNoteCtntListVO> insNoteCtntVo = new ArrayList<PriSpScpNoteCtntListVO>();
					for(int i = 0; i < insNoteVo.size(); i++){
						PriSpScpNoteListVO insNote = insNoteVo.get(i);
						
						PriSpScpNoteCtntListVO noteCtntVo = new PriSpScpNoteCtntListVO();
						noteCtntVo.setPropNo(insNote.getPropNo());
						noteCtntVo.setAmdtSeq(insNote.getAmdtSeq());
						noteCtntVo.setSvcScpCd(insNote.getSvcScpCd());
						noteCtntVo.setNoteTpCd(insNote.getNoteTpCd());
						noteCtntVo.setNoteSeq(insNote.getNoteSeq());
						
						insNoteCtntVo.add(noteCtntVo);
					}
					if ( insNoteCtntVo.size() > 0 ) {
						//history
						dbDao.addNoteContentHistory(insNoteCtntVo);
					}
					
				}
				//----------------------------
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
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Accepting S/C Standard Note Content<br>
	 * 
	 * @param PriSpScpNoteCtntVO[] priSpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptNote(PriSpScpNoteCtntVO[] priSpScpNoteCtntVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpNoteCtntVO> updateVoList = new ArrayList<PriSpScpNoteCtntVO>();
			for ( int i=0; i<priSpScpNoteCtntVO .length; i++ ) {
				//log.debug("note========================ibflag"+priSpScpNoteCtntVO[i].getIbflag());
				if ( priSpScpNoteCtntVO[i].getIbflag().equals("U")){
					priSpScpNoteCtntVO[i].setUpdUsrId(account.getUsr_id());			
					priSpScpNoteCtntVO[i].setAcptOfcCd(account.getOfc_cd());
					priSpScpNoteCtntVO[i].setAcptUsrId(account.getUsr_id());	
					priSpScpNoteCtntVO[i].setAcptDt("1"); //'1' : SYSDATE , '0': null	
										
					updateVoList.add(priSpScpNoteCtntVO[i]);
				}
			}
						
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAcceptNote(updateVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Cancelling a acceptance of S/C Standard Note Content<br>
	 * 
	 * @param PriSpScpNoteCtntVO[] priSpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelNote(PriSpScpNoteCtntVO[] priSpScpNoteCtntVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpNoteCtntVO> updateVoList = new ArrayList<PriSpScpNoteCtntVO>();
			for ( int i=0; i<priSpScpNoteCtntVO .length; i++ ) {
				if ( priSpScpNoteCtntVO[i].getIbflag().equals("U")){
					priSpScpNoteCtntVO[i].setUpdUsrId(account.getUsr_id());
					
					priSpScpNoteCtntVO[i].setAcptOfcCd(null);
					priSpScpNoteCtntVO[i].setAcptUsrId(null);	
					priSpScpNoteCtntVO[i].setAcptDt("0"); // '1': SYSDATE ,'0' : NULL
					
					updateVoList.add(priSpScpNoteCtntVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAcceptNote(updateVoList);
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Accepting S/C Standard Note Content <br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllNote(PriSpScpNoteCtntVO priSpScpNoteCtntVO, SignOnUserAccount account) throws EventException{
		try {
			List<RsltNoteCtntListVO> list = new ArrayList<RsltNoteCtntListVO>();
			
			priSpScpNoteCtntVO.setUpdUsrId(account.getUsr_id());			
			priSpScpNoteCtntVO.setAcptOfcCd(account.getOfc_cd());
			priSpScpNoteCtntVO.setAcptUsrId(account.getUsr_id());	
			priSpScpNoteCtntVO.setAcptDt("1"); //'1': SYSDATE, '0': null	
			priSpScpNoteCtntVO.setPrcProgStsCd("A"); // A: ALL ACCEPT, I: ALL ACCEPT CANCEL
			
			list = dbDao.searchAllAcceptDataList(priSpScpNoteCtntVO);
			
			if(list.size()> 0){
				dbDao.modifyAcceptAllNote(priSpScpNoteCtntVO);
			}
			
			return list.size();
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Cancellation a acceptance of S/C Standard Note Content<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllNote(PriSpScpNoteCtntVO priSpScpNoteCtntVO, SignOnUserAccount account) throws EventException{
		try {
			List<RsltNoteCtntListVO> list = new ArrayList<RsltNoteCtntListVO>();
			
			priSpScpNoteCtntVO.setUpdUsrId(account.getUsr_id());				
			priSpScpNoteCtntVO.setAcptOfcCd(null);
			priSpScpNoteCtntVO.setAcptUsrId(null);	
			priSpScpNoteCtntVO.setAcptDt("0"); // '1': SYSDATE , '0': NULL
			priSpScpNoteCtntVO.setPrcProgStsCd("I"); // A: ALL ACCEPT ,I: ALL ACCEPT CANCEL
			
			list = dbDao.searchAllAcceptDataList(priSpScpNoteCtntVO);
		
			if(list.size()> 0){
				dbDao.modifyAcceptAllNote(priSpScpNoteCtntVO);
			}
			
			return list.size();
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	
    /**
     * Copying Proposal Scope Special Note <br>
     * 
     * @param RsltPropCopyVO vo
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeNote(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_SCP_NOTE COPY
            dbDao.addCopyProposalScopeNote(vo);
            // PRI_SP_SCP_NOTE_CTNT COPY
            dbDao.addCopyProposalScopeNoteCtnt(vo);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * Deleting all datas with scope<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalContent(priSpScpMnVO);
			dbDao.removeProposal(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * add History DemDet for Note<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addProposalDemDetForNote(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.addProposalScpNoteHistoryForDemDet(priSpScpMnVO);
			dbDao.addProposalScpNoteContentHistoryForDemDet(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

    /**
     * Retrieving NOTE_HDR_SEQ of Guideline Standard Note to be copied<br>
     * 
     * @param SpScpGlineCopyVO vo  
     * @return String
     * @exception EventException
     */
    public String searchGuidelineCopyNoteHdrSeq(SpScpGlineCopyVO vo) throws EventException {
        try {
            return dbDao.searchGuidelineCopyNoteHdrSeq(vo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Copying Guideline Standard Note to Proposal.<br>
     * 
     * @param SpScpGlineCopyVO vo
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineStndNote(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
//            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_SCP_NOTE COPY
            dbDao.addCopyScopeGuidelineStndNote(vo);
            // PRI_SP_SCP_NOTE_CTNT COPY
            dbDao.addCopyScopeGuidelineStndNoteCtnt(vo);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * Changing accepted datas to "init" at one time when cancelling request<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalRequestCancel(priSpScpMnVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}		
	
	/**
	 * Changing accepted datas to "init" at one time when cancelling request.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelStandardNote(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalRequestCancelStandardNote(priSpScpMnVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Accepting automatically when requesting S/C Proposal<br>
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void autoAcceptProposalNote(PriSpScpNoteCtntVO priSpScpNoteCtntVO, SignOnUserAccount account) throws EventException{
		try {		
			if (priSpScpNoteCtntVO != null){
				priSpScpNoteCtntVO.setUpdUsrId(account.getUsr_id());	
				priSpScpNoteCtntVO.setAcptUsrId(account.getUsr_id());
				dbDao.modifyAutoAcceptProposalNote (priSpScpNoteCtntVO);
			}
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Deleting all datas of STANDARD NOTE<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @exception EventException
	 */
	public void manageStandardNote(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException {
		try {
			dbDao.removeStandardNoteContent(priSpScpNoteListVO);
			dbDao.removeStandardNote(priSpScpNoteListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Amending all datas of STANDARD NOTE<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyStandardNote(PriSpScpNoteListVO priSpScpNoteListVO, SignOnUserAccount account) throws EventException {
		try {
			if(priSpScpNoteListVO != null) {
				priSpScpNoteListVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyStandardNoteContent(priSpScpNoteListVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Amending all datas of STANDARD NOTE as cancellation<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelStandardNote(PriSpScpNoteListVO priSpScpNoteListVO, SignOnUserAccount account) throws EventException {
		try {
			if(priSpScpNoteListVO != null) {
				priSpScpNoteListVO.setUpdUsrId(account.getUsr_id());
				dbDao.removeStandardNoteContent (priSpScpNoteListVO);		
				dbDao.addStandardNoteContentList(priSpScpNoteListVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving S/C Special Note Title History <br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltNoteListVO> searchNoteHistoryList(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException {
		try {
			return dbDao.searchNoteHistoryList(priSpScpNoteListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving S/C Special Note Content History <br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO  
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchNoteContentHistoryList(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException {
		try {
			return dbDao.searchNoteContentHistoryList(priSpScpNoteListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Retrieving S/C Standard Note Title<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltNoteListVO> searchNoteInquiryList(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException {
		try {
			return dbDao.searchNoteInquiryList(priSpScpNoteListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving S/C Standard Note Content<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO  
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchNoteContentInquiryList(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException {
		try {
			return dbDao.searchNoteContentInquiryList(priSpScpNoteListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Modifying charge type code of note when saving conversion<br>
	 * 
	 * @param PriSpScpNoteCtntListVO priSpScpNoteCtntListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteContentChargeType(PriSpScpNoteCtntListVO priSpScpNoteCtntListVO, SignOnUserAccount account) throws EventException{
		try {
			priSpScpNoteCtntListVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyNoteContentChargeType(priSpScpNoteCtntListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

    /**
     * Retrieving MAX_DP_SEQ of related note for previous seq <br>
     * 
     * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
     * @return String
     * @exception EventException
     */
    public String searchNoteMaxDpSeq(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException{
		try {	
			return dbDao.searchNoteMaxDpSeq(priSpScpNoteCtntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
    

    /**
     * Retrieving MAX_DP_SEQ of related note contents for previous seq <br>
     * 
     * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
     * @return String
     * @exception EventException
     */
    public String searchNoteContentMaxDpSeq(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException{
		try {	
			return dbDao.searchNoteContentMaxDpSeq(priSpScpNoteCtntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
     * Modifying note type of next amend seq based on amend seq when updating Conversion<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void manageConversionUpdate (PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			priSpMnVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyConversionNote(priSpMnVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}       
    
	
	/**
	 *  Retrieving SCNoteProposal<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @return List<PriSpScpGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchSpecialNoteAcceptedList (PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException {
		try {
			List<String> txtArr = new ArrayList<String>();
			
			String sNoteSeq = priSpScpNoteCtntVO.getNoteSeq();
			String[] rNoteSeq = sNoteSeq.split(",");
			
			for(int i=0; i<rNoteSeq.length; i++){
				txtArr.add(rNoteSeq[i]);
			}
			
			return dbDao.searchSpecialNoteAcceptedList (priSpScpNoteCtntVO, txtArr);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}	
	
	
    
    
	
}