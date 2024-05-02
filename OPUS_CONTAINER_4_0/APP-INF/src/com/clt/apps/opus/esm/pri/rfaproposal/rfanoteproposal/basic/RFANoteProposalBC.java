/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFANoteProposalBC.java
*@FileTitle : Guideline Clause & Standard Wording List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.NotePropVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.PriRpScpNoteListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteCtntListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;
import com.clt.syscommon.common.table.PriRpScpNoteCtntVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Scproposal<br>
 *
 * @author 
 * @see Esm_pri_0089EventResponse 
 * @since J2EE 1.4
 */

public interface RFANoteProposalBC {		
	/**
	 * Retrieving SPECIAL NOTE's TITLE<br>
	 * 
	 * @param PriRpScpNoteListVO priRpScpNoteListVO
	 * @return List<RsltNoteListVO>
	 * @exception EventException
	 */
	public List<RsltNoteListVO> searchNoteList(PriRpScpNoteListVO priRpScpNoteListVO) throws EventException;
	
	/**
	 * Retrieving SPECIAL NOTE's CONTENTS<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchSpecialNoteContentList(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws EventException;

	/**
	 * Handling Amend Request<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;			
	/**
	 * Saving SPECIAL NOTE.<br>
	 * 
	 * @param NotePropVO notePropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNote(NotePropVO notePropVO, SignOnUserAccount account) throws EventException;
	/**
	 * Accepting SPECIAL NOTE CONTENTS<br>
	 * 
	 * @param PriRpScpNoteCtntVO[] priRpScpNoteCtntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptNote(PriRpScpNoteCtntVO[] priRpScpNoteCtntVOs, SignOnUserAccount account) throws EventException;
	/**
	 * Cancelling SPECIAL NOTE CONTENTS<br>
	 * 
	 * @param PriRpScpNoteCtntVO[] priRpScpNoteCtntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelNote(PriRpScpNoteCtntVO[] priRpScpNoteCtntVOs, SignOnUserAccount account) throws EventException;
	/**
	 * Accepting SPECIAL NOTE CONTENTS allbr>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllNote(PriRpScpNoteCtntVO priRpScpNoteCtntVO, SignOnUserAccount account) throws EventException;
	/**
	 * Accepting SPECIAL NOTE CONTENTSall<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllNote(PriRpScpNoteCtntVO priRpScpNoteCtntVO, SignOnUserAccount account) throws EventException;

    /**
     * Copying RFA Proposal Scope Special Note information<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
	   * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeNote(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException;


 /**
	 *Deleting all data of Amend Seq NO. when deleting Main's Init status<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Modifying Accepted data to "Init" at once when cancelling request<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException;  	
	
	/**
	 * Accepting automatically when requesting Main<br>
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void autoAcceptProposalNote(PriRpScpNoteCtntVO priRpScpNoteCtntVO,SignOnUserAccount account) throws EventException;	
	

	/**
	 * Retrieving SPECIAL NOTE's TITLE<br>
	 * 
	 * @param PriRpScpNoteListVO priRpScpNoteListVO
	 * @return List<RsltNoteListVO>
	 * @exception EventException
	 */
	public List<RsltNoteListVO> searchNoteHistoryList(PriRpScpNoteListVO priRpScpNoteListVO) throws EventException;
	
	/**
	 * Retrieving SPECIAL NOTE's CONTENTS<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchSpecialNoteContentHistoryList(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws EventException;

	
	/**
	 * Retrieving SPECIAL NOTE's TITLE<br>
	 * 
	 * @param PriRpScpNoteListVO priRpScpNoteListVO
	 * @return List<RsltNoteListVO>
	 * @exception EventException
	 */
	public List<RsltNoteListVO> searchNoteInquiryList(PriRpScpNoteListVO priRpScpNoteListVO) throws EventException;
	
	/**
	 * Retrieving SPECIAL NOTE's CONTENTS<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchSpecialNoteContentInquiryList(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws EventException;
	

    /**
     * Retrieving previous SEQ note's MAX_DP_SEQ <br>
     * 
     * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
     * @return String
     * @exception EventException
     */
    public String searchNoteMaxDpSeq(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws EventException;

    /**
     * Retrieving previous SEQ  NOTE CONTENT's MAX_DP_SEQ<br>
     * 
     * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
     * @return String
     * @exception EventException
     */
    public String searchNoteContentMaxDpSeq(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws EventException;
}