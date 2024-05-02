/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteProposalBC.java
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

import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.NotePropVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltCtrtCluzListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltNoteHeaderVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltNoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpNoteCtntVO;

/**
 * NIS2010-Scproposal Business Logic Command Interface<br>
 * - NIS2010-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Moon Dong Gyu
 * @see Esm_pri_0089EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCNoteProposalBC {
	/**
	 * Contract Clause Master Detail 정보를 조회합니다.<br>
	 * 
	 * @param RsltCtrtCluzListVO rsltCtrtCluzListVO
	 * @return List<RsltCtrtCluzListVO>
	 * @exception EventException
	 */
	public List<RsltCtrtCluzListVO> searchContractClauseMasterDetailList(RsltCtrtCluzListVO rsltCtrtCluzListVO) throws EventException;

	/**
	 * S/C Standard Note Header 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteHeaderVO>
	 * @exception EventException
	 */
	public  List<RsltNoteHeaderVO> searchNoteHeader(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException;
	
	/**
	 * S/C Standard Note Title 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteListVO>
	 * @exception EventException
	 */
	public List<RsltNoteListVO> searchNoteList(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException;
	
	/**
	 * S/C Special Note Content 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchSpecialNoteContentList(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException;
	/**
	 * S/C Standard Note Content 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchNoteContentList(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException;

	/**
	 * Guideline Standard Note 정보를 COPY한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int copyGuidelineNote(PriSpScpNoteListVO priSpScpNoteListVO, SignOnUserAccount account) throws EventException;
	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;			
	/**
	 * S/C Standard Note 정보를 저장한다.<br>
	 * 
	 * @param NotePropVO notePropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNote(NotePropVO notePropVO, SignOnUserAccount account) throws EventException;
	/**
	 * S/C Standard Note Content 정보를 ACCEPT 한다.<br>
	 * 
	 * @param PriSpScpNoteCtntVO[] priSpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptNote(PriSpScpNoteCtntVO[] priSpScpNoteCtntVO, SignOnUserAccount account) throws EventException;
	/**
	 * S/C Standard Note Content 정보를 ACCEPT CANCEL 한다.<br>
	 * 
	 * @param PriSpScpNoteCtntVO[] priSpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelNote(PriSpScpNoteCtntVO[] priSpScpNoteCtntVO, SignOnUserAccount account) throws EventException;

	/**
	 * S/C Standard Note Content 정보를 All ACCEPT 한다.<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllNote(PriSpScpNoteCtntVO priSpScpNoteCtntVO, SignOnUserAccount account) throws EventException;
	/**
	 * S/C Standard Note Content 정보를 All ACCEPT CANCEL 한다.<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllNote(PriSpScpNoteCtntVO priSpScpNoteCtntVO, SignOnUserAccount account) throws EventException;

	
    /**
     * Proposal Scope Note 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeNote(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;


    /**
     * Copy 할 Guideline Standard Note 정보의 NOTE_HDR_SEQ를 조회합니다.<br>
     * 
     * @param SpScpGlineCopyVO vo  
     * @return String
     * @exception EventException
     */
    public String searchGuidelineCopyNoteHdrSeq(SpScpGlineCopyVO vo) throws EventException;

    /**
     * Guideline Standard Note 를 Proposal 에 Copy 합니다.<br>
     * 
     * @param SpScpGlineCopyVO vo
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineStndNote(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
	 * SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;


	/**
	 * Request Cancel시 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException;  
	
	/**
	 * Request Cancel시 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelStandardNote(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException; 	
	
	/**
	 * S/C Proposal을 Request 할때 자동으로 Accept를 한다.<br>
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void autoAcceptProposalNote(PriSpScpNoteCtntVO priSpScpNoteCtntVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * STANDARD NOTE의 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @exception EventException
	 */
	public void manageStandardNote(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException;  
	
	/**
	 * STANDARD NOTE의 모든 데이터를 AMEND DELETE처리한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyStandardNote(PriSpScpNoteListVO priSpScpNoteListVO, SignOnUserAccount account) throws EventException;  
	
	/**
	 * STANDARD NOTE의 모든 데이터를 DELETE CANCEL 처리한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelStandardNote(PriSpScpNoteListVO priSpScpNoteListVO, SignOnUserAccount account) throws EventException;  
		
	/**
	 * S/C Standard Note Title History 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteListVO>
	 * @exception EventException
	 */
	public List<RsltNoteListVO> searchNoteHistoryList(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException;
	
	/**
	 * S/C Special Note Content History 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchNoteContentHistoryList(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException;

		
	/**
	 * S/C Standard Note Title 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteListVO>
	 * @exception EventException
	 */
	public List<RsltNoteListVO> searchNoteInquiryList(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException;
	
	/**
	 * S/C Standard Note Content 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchNoteContentInquiryList(PriSpScpNoteListVO priSpScpNoteListVO) throws EventException;
	
	/**
	 * CONVERSION 에서 데이터 저장시 NOTE의 CHARGE TYPE CODE를 수정한다.<br>
	 * 
	 * @param PriSpScpNoteCtntListVO priSpScpNoteCtntListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteContentChargeType(PriSpScpNoteCtntListVO priSpScpNoteCtntListVO, SignOnUserAccount account) throws EventException;


    /**
     * 이전SEQ에 해당하는 NOTE의 MAX DP_SEQ를 조회한다. <br>
     * 
     * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
     * @return String
     * @exception EventException
     */
    public String searchNoteMaxDpSeq(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException;

    /**
     * 이전SEQ에 해당하는 NOTE CONTENT의 MAX DP_SEQ를 조회한다. <br>
     * 
     * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
     * @return String
     * @exception EventException
     */
    public String searchNoteContentMaxDpSeq(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException;
    
    /**
     * Conversion Update 시 Amend Seq.를 기준으로 다음 Amend Seq의 Note 유형을 수정한다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void manageConversionUpdate (PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException ;     
    
	/**
	 * 조회 이벤트 처리<br>
	 * ScNoteproposal화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
    public List<RsltNoteCtntListVO> searchSpecialNoteAcceptedList (PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException ;

}