/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFANoteConversionProposalBC.java
*@FileTitle : Special Note Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.vo.RsltNoteConvVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.NotePropVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteCtntListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropCmdtVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropRtVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRfaNoteConvVO;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;
import com.clt.syscommon.common.table.PriRpScpNoteCtntVO;
import com.clt.syscommon.common.table.PriRpScpRtCnoteVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Scproposal<br>
 *
 * @author 
 * @see Esm_pri_0032EventResponse 
 * @since J2EE 1.6
 */

public interface RFANoteConversionProposalBC {

	/**
	 * Retrieving [Special Note Content].<br>
	 * 
	 * @param PriRpScpNoteCtntVO priSpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchNoteContentList(PriRpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException;
		
	/**
	 * Retrieving [Special Note Conversion].<br>
	 * 
	 * @param PriRfaNoteConvVO	priRfaNoteConvVO
	 * @return List<PriRfaNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionList(PriRfaNoteConvVO priRfaNoteConvVO) throws EventException;

	/**
	 * Copying [Special Note Conversion]<br>
	 * 
	 * @param NotePropVO notePropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversion(NotePropVO notePropVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Pasting [Special Note Conversion].<br>
	 * 
	 * @param PriRfaNoteConvVO	priRfaNoteConvVO
	 * @param SignOnUserAccount account
	 * @return List<PriRfaNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionListCopy(PriRfaNoteConvVO priRfaNoteConvVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Copying [Special Note Conversion].<br>
	 * 
	 * @param PriRfaNoteConvListVO[] priRfaNoteConvListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCopy(PriRfaNoteConvListVO[] priRfaNoteConvListVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving [Commodity Note Content].<br>
	 * 
	 * @param PriRpScpRtCnoteVO priRpScpRtCnoteVO
	 * @return List<PriRpScpRtCnoteVO>
	 * @exception EventException
	 */
	public List<PriRpScpRtCnoteVO> searchCommodityNoteContentList(PriRpScpRtCnoteVO priRpScpRtCnoteVO) throws EventException;
		
	/**
	 * Requesting Amend.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Modifying expire data of conversion when modifying expire data of Main Duration <br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionExpireDate(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException;

	/**
	 * Changing effective data of conversion when changing effective date of main duration<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionEffectiveDate(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException;	
	
    /**
     * Copying RFA Proposal Special Note Conversion information<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalRfaNoteConversion(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException;

    /**
     * Copying RFA Proposal Rate Route Note Conversion information<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalRoutNoteConversion(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException;

    /**
     * Copying RFA Proposal Rate Commodity Note Conversion information<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void copyProposalCmdtNoteConversion(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException;

    
	/**
	 *  Handling conversion information at same time when deleting Rate's Commodity &Note<br>
	 * 
	 * @param RfaRtPropCmdtVO rfaRtPropCmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCascadeCommodity(RfaRtPropCmdtVO rfaRtPropCmdtVO, SignOnUserAccount account) throws EventException;

	
	/**
	 * Handling conversion information at same time when modifying Rate's route note<br>
	 * 
	 * @param RfaRtPropRtVO rfaRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCascadeRoute(RfaRtPropRtVO rfaRtPropRtVO, SignOnUserAccount account) throws EventException;

	
	/**
	 * Deleting conversion when canceling proposal<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * Handling conversion information at same time when deleting Rate's Commodity &Note , manage(insert/delete/update) for Conversion<br>
	 * 2015.05.19 ADD
	 * 
	 * @param PriRpScpRtCnoteVO[] priRpScpRtCnoteVOS
	 * @param PriRfaNoteConvListVO[] priRfaNoteConvListVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCommonRateConversion(PriRpScpRtCnoteVO[] priRpScpRtCnoteVOS, PriRfaNoteConvListVO[] priRfaNoteConvListVOS, SignOnUserAccount account) throws EventException;

	
}