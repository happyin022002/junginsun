/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFANoteConversionProposalBC.java
*@FileTitle : Special Note Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.03 최성민
* 1.0 Creation
=========================================================
 * History
 * 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)
 * 2016.07.20 [CHM-201642287] Master RFA Cancel시 Basic RFA 점검 로직 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.RsltNoteConvVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.NotePropVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropCmdtVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropRtVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRoutHdrSmryListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRfaNoteConvVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpNoteCtntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCnoteVO;

/**
 * ALPS-Scproposal Business Logic Command Interface<br>
 * - ALPS-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI SUNG MIN
 * @see Esm_pri_0032EventResponse 참조
 * @since J2EE 1.6
 */

public interface RFANoteConversionProposalBC {

	/**
	 * [Special Note Content]을 [조회] 합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priSpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchNoteContentList(PriRpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException;
		
	/**
	 * [Special Note Conversion]을 [조회] 합니다.<br>
	 * 
	 * @param PriRfaNoteConvVO	priRfaNoteConvVO
	 * @return List<PriRfaNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionList(PriRfaNoteConvVO priRfaNoteConvVO) throws EventException;

	/**
	 * SPECIAL NOTE저장시 CONVERSION 데이터를 저장합니다.<br>
	 * 
	 * @param NotePropVO notePropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversion(NotePropVO notePropVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [복사된 Special Note Conversion]을 [조회] 합니다.<br>
	 * 
	 * @param PriRfaNoteConvVO	priRfaNoteConvVO
	 * @param SignOnUserAccount account
	 * @return List<PriRfaNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionListCopy(PriRfaNoteConvVO priRfaNoteConvVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [Special Note Conversion]을 [복사] 합니다.<br>
	 * 
	 * @param PriRfaNoteConvListVO[] priRfaNoteConvListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCopy(PriRfaNoteConvListVO[] priRfaNoteConvListVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [Commodity Note Content]을 [조회] 합니다.<br>
	 * 
	 * @param PriRpScpRtCnoteVO priRpScpRtCnoteVO
	 * @return List<PriRpScpRtCnoteVO>
	 * @exception EventException
	 */
	public List<PriRpScpRtCnoteVO> searchCommodityNoteContentList(PriRpScpRtCnoteVO priRpScpRtCnoteVO) throws EventException;
		
	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;	

	/**
	 * Master RFA의 Amend Request를 처리합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposalMst(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Master RFA의 Amend Request를 처리합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO 
	 * @param RsltRoutHdrSmryListVO rsltRoutHdrSmryListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposalBasic(PriRpMnVO priRpMnVO, RsltRoutHdrSmryListVO rsltRoutHdrSmryListVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Main Duration Expire Date변경시 Conversion 의 Expire Date를 변경한다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionExpireDate(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException;

	/**
	 * Main Duration Effective Date변경시 Conversion 의 Effective Date를 변경한다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionEffectiveDate(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException;	
	
    /**
     * RFA Proposal Special Note Conversion 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalRfaNoteConversion(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException;

    /**
     * RFA Proposal Rate Route Note Conversion 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalRoutNoteConversion(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException;

    /**
     * Master RFA Proposal Rate Route Note Conversion 정보를 Copy 합니다.<br>
     * 
	 * @param RsltRfaPropCopyVO vo
	 * @param RsltRoutHdrSmryListVO[] rsltRoutHdrSmryListVOs
	 * @param SignOnUserAccount account
	 * @param PriRpMnVO priRpMnVO
     * @exception EventException
     */
    public void copyProposalRoutNoteConversionMst(RsltRfaPropCopyVO vo, RsltRoutHdrSmryListVO[] rsltRoutHdrSmryListVOs, SignOnUserAccount account, PriRpMnVO priRpMnVO) throws EventException;

    /**
     * RFA Proposal Rate Commodity Note Conversion 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void copyProposalCmdtNoteConversion(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException;

    
	/**
	 * Rate의 Commodity Note수정시 Conversion정보를 같이 처리한다.<br>
	 * 
	 * @param RfaRtPropCmdtVO rfaRtPropCmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCascadeCommodity(RfaRtPropCmdtVO rfaRtPropCmdtVO, SignOnUserAccount account) throws EventException;

	
	/**
	 * Rate의 Route Note수정시 Conversion정보를 같이 처리한다.<br>
	 * 
	 * @param RfaRtPropRtVO rfaRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCascadeRoute(RfaRtPropRtVO rfaRtPropRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Master RFA의 Conversion정보 처리<br>
	 * 
	 * @param RfaRtPropRtVO rfaRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCascadeRouteMst(RfaRtPropRtVO rfaRtPropRtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Proposal Cancel시 Conversion을 삭제한다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Master RFA의 APP Note Conversion을 처리한다.<br>
	 * 
	 * @param RsltRoutHdrSmryListVO appInfo
	 * @param String noteConvMapgId
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAppNoteConversion(RsltRoutHdrSmryListVO appInfo, String noteConvMapgId, SignOnUserAccount account) throws EventException;
	
}