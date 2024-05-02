/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteProposalBC.java
*@FileTitle : Guideline Clause & Standard Wording List
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.NotePropVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteCtntListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltCtrtCluzListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteCtntListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteHeaderVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpNoteCtntVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Scproposal<br>
 *
 * @author 
 * @see Esm_pri_0089EventResponse 
 * @since J2EE 1.4
 */

public interface SCNoteProposalBC {
	/**
	 * Retrieving Contract Clause Master Detail information.<br>
	 * 
	 * @param RsltCtrtCluzListVO rsltCtrtCluzListVO
	 * @return List<RsltCtrtCluzListVO>
	 * @exception EventException
	 */
	public List<RsltCtrtCluzListVO> searchContractClauseMasterDetailList(RsltCtrtCluzListVO rsltCtrtCluzListVO) throws EventException;

	/**
	 * Retrieving S/C Standard Note Header information.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteHeaderVO>
	 * @exception EventException
	 */
	public  List<RsltNoteHeaderVO> searchNoteHeader(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException;
	
	/**
	 * Retrieving S/C Standard Note Title information.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteListVO>
	 * @exception EventException
	 */
	public List<RsltNoteListVO> searchNoteList(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException;
	
	/**
	 * Retrieving S/C Special Note Content information.<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchSpecialNoteContentList(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException;
	/**
	 * Retrieving S/C Standard Note Content information.<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchNoteContentList(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException;

	/**
	 * Copying Guideline Standard Note information.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int copyGuidelineNote(PriSpScpNoteListVO priSpScpNoteListVO, SignOnUserAccount account) throws EventException;
	/**
	 * Requesting Amend Request.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;			
	/**
	 * Saving S/C Standard Note information.<br>
	 * 
	 * @param NotePropVO notePropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNote(NotePropVO notePropVO, SignOnUserAccount account) throws EventException;
	/**
	 * Accepting S/C Standard Note Content information.<br>
	 * 
	 * @param PriSpScpNoteCtntVO[] priSpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptNote(PriSpScpNoteCtntVO[] priSpScpNoteCtntVO, SignOnUserAccount account) throws EventException;
	/**
	 * Cancelling a acceptance of S/C Standard Note Content<br>
	 * 
	 * @param PriSpScpNoteCtntVO[] priSpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelNote(PriSpScpNoteCtntVO[] priSpScpNoteCtntVO, SignOnUserAccount account) throws EventException;

	/**
	 * Accepting S/C Standard Note Content <br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllNote(PriSpScpNoteCtntVO priSpScpNoteCtntVO, SignOnUserAccount account) throws EventException;
	/**
	 * Cancellation a acceptance of S/C Standard Note Content<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllNote(PriSpScpNoteCtntVO priSpScpNoteCtntVO, SignOnUserAccount account) throws EventException;

	
    /**
     * Copying Proposal Scope Note information<br>
     * 
     * @param RsltPropCopyVO vo
	   * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeNote(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;


    /**
     * Retrieving NOTE_HDR_SEQ of Guideline Standard Note to be copied<br>
     * 
     * @param SpScpGlineCopyVO vo  
     * @return String
     * @exception EventException
     */
    public String searchGuidelineCopyNoteHdrSeq(SpScpGlineCopyVO vo) throws EventException;

    /**
     * Copying Guideline Standard Note to Proposal.<br>
     * 
     * @param SpScpGlineCopyVO vo
	   * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineStndNote(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;

 /**
	 * Deleting all datas with scope<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * add History DemDet for Note<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addProposalDemDetForNote(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;


	/**
	 * Changing accepted datas to "init" at one time when cancelling request<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException;  
	
	/**
	 * Changing accepted datas to "init" at one time when cancelling request.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelStandardNote(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException; 	
	
	/**
	 * Accepting automatically when requesting S/C Proposal<br>
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void autoAcceptProposalNote(PriSpScpNoteCtntVO priSpScpNoteCtntVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Deleting all datas of STANDARD NOTE<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @exception EventException
	 */
	public void manageStandardNote(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException;  
	
	/**
	 * Amending all datas of STANDARD NOTE<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyStandardNote(PriSpScpNoteListVO priSpScpNoteListVO, SignOnUserAccount account) throws EventException;  
	
	/**
	 * Amending all datas of STANDARD NOTE as cancellation<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelStandardNote(PriSpScpNoteListVO priSpScpNoteListVO, SignOnUserAccount account) throws EventException;  
		
	/**
	 * Retrieving S/C Special Note Title History <br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteListVO>
	 * @exception EventException
	 */
	public List<RsltNoteListVO> searchNoteHistoryList(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException;
	
	/**
	 * Retrieving S/C Special Note Content History <br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchNoteContentHistoryList(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException;

		
	/**
	 * Retrieving S/C Standard Note Title information.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteListVO>
	 * @exception EventException
	 */
	public List<RsltNoteListVO> searchNoteInquiryList(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException;
	
	/**
	 * Retrieving S/C Standard Note Content information<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchNoteContentInquiryList(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException;
	
	/**
	 * Modifying charge type code of note when saving conversion<br>
	 * 
	 * @param PriSpScpNoteCtntListVO priSpScpNoteCtntListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteContentChargeType(PriSpScpNoteCtntListVO priSpScpNoteCtntListVO, SignOnUserAccount account) throws EventException;


    /**
     * Retrieving MAX_DP_SEQ of related note for previous seq <br>
     * 
     * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
     * @return String
     * @exception EventException
     */
    public String searchNoteMaxDpSeq(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException;

    /**
     * Retrieving MAX_DP_SEQ of related note contents for previous seq <br>
     * 
     * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
     * @return String
     * @exception EventException
     */
    public String searchNoteContentMaxDpSeq(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException;
    
    /**
     * Modifying note type of next amend seq based on amend seq when updating Conversion<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void manageConversionUpdate (PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException ;     
    
	/**
	 * Retrieving SCNote Proposal<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
    public List<RsltNoteCtntListVO> searchSpecialNoteAcceptedList (PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException ;

}