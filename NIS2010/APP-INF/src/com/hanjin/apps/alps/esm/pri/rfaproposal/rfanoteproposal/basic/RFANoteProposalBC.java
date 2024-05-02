/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFANoteProposalBC.java
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

import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.NotePropVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.PriRpScpNoteListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpNoteCtntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;

/**
 * NIS2010-Scproposal Business Logic Command Interface<br>
 * - NIS2010-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Moon Dong Gyu
 * @see Esm_pri_0089EventResponse 참조
 * @since J2EE 1.4
 */

public interface RFANoteProposalBC {		
	/**
	 * SPECIAL NOTE의 TITLE를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteListVO priRpScpNoteListVO
	 * @return List<RsltNoteListVO>
	 * @exception EventException
	 */
	public List<RsltNoteListVO> searchNoteList(PriRpScpNoteListVO priRpScpNoteListVO) throws EventException;
	
	/**
	 * SPECIAL NOTE의 CONTENTS를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchSpecialNoteContentList(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws EventException;

	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;			
	/**
	 * SPECIAL NOTE를 저장합니다.<br>
	 * 
	 * @param NotePropVO notePropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNote(NotePropVO notePropVO, SignOnUserAccount account) throws EventException;
	/**
	 * SPECIAL NOTE CONTENTS를 ACCEPT합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO[] priRpScpNoteCtntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptNote(PriRpScpNoteCtntVO[] priRpScpNoteCtntVOs, SignOnUserAccount account) throws EventException;
	/**
	 * SPECIAL NOTE CONTENTS를 CANCEL합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO[] priRpScpNoteCtntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelNote(PriRpScpNoteCtntVO[] priRpScpNoteCtntVOs, SignOnUserAccount account) throws EventException;
	/**
	 * SPECIAL NOTE CONTENTS를 All ACCEPT합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllNote(PriRpScpNoteCtntVO priRpScpNoteCtntVO, SignOnUserAccount account) throws EventException;
	/**
	 * SPECIAL NOTE CONTENTS를 All CANCEL합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllNote(PriRpScpNoteCtntVO priRpScpNoteCtntVO, SignOnUserAccount account) throws EventException;

    /**
     * RFA Proposal Scope Special Note 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeNote(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException;


    /**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException;  	

	/**
	 * Master RFA에서 Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelMst(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Main Request 시 자동으로 Accept를 합니다.<br>
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void autoAcceptProposalNote(PriRpScpNoteCtntVO priRpScpNoteCtntVO,SignOnUserAccount account) throws EventException;	
	

	/**
	 * SPECIAL NOTE의 TITLE를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteListVO priRpScpNoteListVO
	 * @return List<RsltNoteListVO>
	 * @exception EventException
	 */
	public List<RsltNoteListVO> searchNoteHistoryList(PriRpScpNoteListVO priRpScpNoteListVO) throws EventException;
	
	/**
	 * SPECIAL NOTE의 CONTENTS를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchSpecialNoteContentHistoryList(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws EventException;

	
	/**
	 * SPECIAL NOTE의 TITLE를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteListVO priRpScpNoteListVO
	 * @return List<RsltNoteListVO>
	 * @exception EventException
	 */
	public List<RsltNoteListVO> searchNoteInquiryList(PriRpScpNoteListVO priRpScpNoteListVO) throws EventException;
	
	/**
	 * SPECIAL NOTE의 CONTENTS를 조회합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchSpecialNoteContentInquiryList(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws EventException;
	

    /**
     * 이전SEQ에 해당하는 NOTE의 MAX DP_SEQ를 조회한다. <br>
     * 
     * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
     * @return String
     * @exception EventException
     */
    public String searchNoteMaxDpSeq(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws EventException;

    /**
     * 이전SEQ에 해당하는 NOTE CONTENT의 MAX DP_SEQ를 조회한다. <br>
     * 
     * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
     * @return String
     * @exception EventException
     */
    public String searchNoteContentMaxDpSeq(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws EventException;

	/**
	 * Summary 팝업에서 승인 대상인 모든 Service Scope Special Notes 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchAllSpecialNoteContentList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;
}