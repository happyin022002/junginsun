/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteProposalBCImpl.java
*@FileTitle : Guideline Clause & Standard Wording List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.18 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.integration.SCNoteProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.NotePropVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltCtrtCluzListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltNoteHeaderVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltNoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpNoteCtntVO;

/**
 * NIS2010-SCProposal Business Logic Basic Command implementation<br>
 * - NIS2010-SCProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_0089EventResponse,SCNoteProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class SCNoteProposalBCImpl extends BasicCommandSupport implements SCNoteProposalBC {

	// Database Access Object
	private transient SCNoteProposalDBDAO dbDao = null;

	/**
	 * SCNoteProposalBCImpl 객체 생성<br>
	 * SCNoteProposalDBDAO를 생성한다.<br>
	 */
	public SCNoteProposalBCImpl() {
		dbDao = new SCNoteProposalDBDAO();
	}
	/**
	 * Contract Clause Master Detail 정보를 조회합니다.<br>
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
	 * Guideline Standard Note 정보를 COPY한다.<br>
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
	 * S/C Standard Note Header 정보를 조회한다.<br>
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
	 * S/C Standard Note Title 정보를 조회한다.<br>
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
	 * S/C Standard Note Content 정보를 조회한다.<br>
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
	 * S/C Special Note Content 정보를 조회한다.<br>
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
	 * Amend Request를 처리합니다.<br>
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
	 * S/C Standard Note 정보를 저장한다.<br>
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
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * S/C Standard Note Content 정보를 ACCEPT 한다.<br>
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
					priSpScpNoteCtntVO[i].setAcptDt("1"); //'1'이면 SYSDATE '0'이면 null	
										
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
	 * S/C Standard Note Content 정보를 ACCEPT CANCEL 한다.<br>
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
					priSpScpNoteCtntVO[i].setAcptDt("0"); // '1'이면 SYSDATE '0'이면 NULL
					
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
	 * S/C Standard Note Content 정보를 ACCEPT 한다.<br>
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
			priSpScpNoteCtntVO.setAcptDt("1"); //'1'이면 SYSDATE '0'이면 null	
			priSpScpNoteCtntVO.setPrcProgStsCd("A"); // A이면 ALL ACCEPT I이면 ALL ACCEPT CANCEL
			
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
	 * S/C Standard Note Content 정보를 ACCEPT CANCEL 한다.<br>
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
			priSpScpNoteCtntVO.setAcptDt("0"); // '1'이면 SYSDATE '0'이면 NULL
			priSpScpNoteCtntVO.setPrcProgStsCd("I"); // A이면 ALL ACCEPT I이면 ALL ACCEPT CANCEL
			
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
     * Proposal Scope Special Note 정보를 Copy 합니다.<br>
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
	 * SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
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
     * Copy 할 Guideline Standard Note 정보의 NOTE_HDR_SEQ를 조회합니다.<br>
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
     * Guideline Standard Note 를 Proposal 에 Copy 합니다.<br>
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
	 * Request Cancel시  Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());					
			}
			dbDao.modifyProposalRequestCancel(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}		
	
	/**
	 * Request Cancel시  Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelStandardNote(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());					
			}
			dbDao.modifyProposalRequestCancelStandardNote(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * S/C Proposal을 Request 할때 자동으로 Accept를 한다.<br>
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
	 * STANDARD NOTE의 모든 데이터를 삭제처리한다.<br>
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
	 * STANDARD NOTE의 모든 데이터를 DELETE AMEND처리한다.<br>
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
	 * STANDARD NOTE의 모든 데이터를 AMEND CANCEL처리한다.<br>
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
	 * S/C Special Note Title History 정보를 조회한다.<br>
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
	 * S/C Special Note Content History 정보를 조회한다.<br>
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
	 * S/C Standard Note Title 정보를 조회한다.<br>
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
	 * S/C Standard Note Content 정보를 조회한다.<br>
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
	 * CONVERSION 에서 데이터 저장시 NOTE의 CHARGE TYPE CODE를 수정한다.<br>
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
     * 이전SEQ에 해당하는 NOTE의 MAX DP_SEQ를 조회한다. <br>
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
     * 이전SEQ에 해당하는 NOTE CONTENT의 MAX DP_SEQ를 조회한다. <br>
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
     * Conversion Update 시 Amend Seq.를 기준으로 다음 Amend Seq의 Note 유형을 수정한다.<br>
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
	 * 조회 이벤트 처리
	 *  SCNoteProposal화면에 대한 조회 이벤트 처리<br>
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