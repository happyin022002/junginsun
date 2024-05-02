/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteConversionProposalBC.java
*@FileTitle : Special Note Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.03 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteHdrCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.vo.PriScNoteConvListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.vo.PriSpMnConvAuthFlagVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.vo.RsltNoteConvVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.NotePropVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtCnoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.ScRtPropCmdtVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.ScRtPropRtVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriScNoteConvVO;
import com.hanjin.syscommon.common.table.PriSgStndNoteCtntVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpNoteCtntVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCnoteVO;

/**
 * ALPS-Scproposal Business Logic Command Interface<br>
 * - ALPS-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI SUNG MIN
 * @see Esm_pri_0032EventResponse 참조
 * @since J2EE 1.6
 */

public interface SCNoteConversionProposalBC {

	/**
	 * [Special Note Content]을 [조회] 합니다.<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchNoteContentList(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException;
		
	/**
	 * [Special Note Conversion]을 [조회] 합니다.<br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return List<PriScNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionList(PriScNoteConvVO priScNoteConvVO) throws EventException;
	
	/**
	 * [Special Note Conversion]을 [CRUD] 합니다.<br>
	 * 
	 * @param PriScNoteConvListVO[] priScNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversion(PriScNoteConvListVO[] priScNoteConvListVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * [복사된 Special Note Conversion]을 [조회] 합니다.<br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @param SignOnUserAccount account
	 * @return List<RsltNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionListCopy(PriScNoteConvVO priScNoteConvVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [Special Note Conversion]을 [복사] 합니다.<br>
	 * 
	 * @param PriScNoteConvListVO[] priScNoteConvListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCopy(PriScNoteConvListVO[] priScNoteConvListVO,SignOnUserAccount account) throws EventException;

	/**
	 * [Commodity Note Content]을 [조회] 합니다.<br>
	 * 
	 * @param PriSpScpRtCnoteVO priSpScpRtCnoteVO
	 * @return List<RsltRtCnoteListVO>
	 * @exception EventException
	 */
	public List<RsltRtCnoteListVO> searchCommodityNoteContentList(PriSpScpRtCnoteVO priSpScpRtCnoteVO) throws EventException;
	

	/**
	 * [Commodity Note Content]을 [조회] 합니다.<br>
	 * 
	 * @param PriSpScpRtCnoteVO priSpScpRtCnoteVO
	 * @return List<RsltRtCnoteListVO>
	 * @exception EventException
	 */
	public List<RsltRtCnoteListVO> searchCommodityNoteContentInquiryList(PriSpScpRtCnoteVO priSpScpRtCnoteVO) throws EventException;
		
	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;		
	
	/**
	 * Main Duration Expire Date 변경시 Conversion 의 Expire Date를 변경한다.<br>
	 * 
	 * @param PriSpScpMnVO[] priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionExpireDate(PriSpScpMnVO[] priSpScpMnVO,SignOnUserAccount account) throws EventException;

	/**
	 * Duration Effective Date 변경시 Conversion 의 Effective Date를 변경한다.<br>
	 * 
	 * @param PriSpScpMnVO[] priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionEffectiveDate(PriSpScpMnVO[] priSpScpMnVO,SignOnUserAccount account) throws EventException;	
	
    /**
     * S/C Proposal Special Note Conversion 데이터를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScNoteConversion(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException;

    /**
     * S/C Proposal Route Note Conversion 데이터를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalRoutNoteConversion(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException;

    /**
     * S/C Proposal Commodity Note Conversion 데이터를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void copyProposalCmdtNoteConversion(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException;

	/**
	 * SCOPE에 해당하는 모든 CONVERSION 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * S/C Standard Note Conversion 정보를 저장한다.<br>
	 * 
	 * @param NotePropVO notePropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNote(NotePropVO notePropVO, SignOnUserAccount account) throws EventException;
	
	/**
     * S/C Standard Note Copy 시 Conversion 데이터를 생성합니다.<br>
     * 
     * @param RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScStndNoteConversion(RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO, SignOnUserAccount account) throws EventException;
    
    /**
     * STANDARD NOTE에서 CTNT 삭제시 해당 CONVERSION 삭제한다.<br>
     * 
     * @param PriSgStndNoteCtntVO priSgStndNoteCtntVO
     * @exception EventException
     */
    public void removeScStndNoteConversion(PriSgStndNoteCtntVO priSgStndNoteCtntVO) throws EventException;
    
    /**
     * S/C Standard Note DURATION UPDATE 시 Conversion DURATION 를 수정합니다.<br>
     * 
     * @param RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyDurationScStndNoteConversion(RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * Filing시 Conversion 의 Effective Date를 변경한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionEffectiveDateFiling(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;
    
	/**
	 * Commodity Group 및 관련 정보의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param ScRtPropCmdtVO scRtPropCmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCommodity(ScRtPropCmdtVO scRtPropCmdtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Route 및 Rate 데이터의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param ScRtPropRtVO scRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRate(ScRtPropRtVO scRtPropRtVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 이행데이터를 구분하기 위해서 헤더정보를 조회한다.<br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCreationTypeCode(PriScNoteConvVO priScNoteConvVO) throws EventException;
	
	/**
	 * Legacy I/F Flag 정보를 조회한다.<br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return String
	 * @exception EventException
	 */
	public String searchLegacyIfFlag(PriScNoteConvVO priScNoteConvVO) throws EventException;

	/**
	 * CONVERSION 입력 가능한가를 확인하기 위해서 CONVERSION CONFIRM FLAG정보를 조회한다.<br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return String
	 * @exception EventException
	 */
	public String searchConversionConfirmFlag(PriScNoteConvVO priScNoteConvVO) throws EventException;

    /**
     * 이전 Amend Seq.를 기준으로 Conversion을 추가합니다..<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void manageConversionUpdate (PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException ; 	
	
	/**
	 * CONVERSION HISTORY 입력할때 EXP_DT를 입력하기 위해서 현재 AMDT_SEQ의 DURATION EXP_DT를 조회한다.<br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return String
	 * @exception EventException
	 */
	public String searchDurationExpDate(PriScNoteConvVO priScNoteConvVO) throws EventException;
   
    /**
     * CONVERSION 입력 가능한가를 확인하기 위해서 CONVERSION 권한 정보를 조회한다.<br>
     * 
     * @param PriScNoteConvVO priScNoteConvVO
     * @param SignOnUserAccount account
     * @return List<PriSpMnConvAuthFlagVO>
     * @exception EventException
     */
    public List<PriSpMnConvAuthFlagVO> searchConversionAuthFlag(PriScNoteConvVO priScNoteConvVO,SignOnUserAccount account) throws EventException ;
	
    
}