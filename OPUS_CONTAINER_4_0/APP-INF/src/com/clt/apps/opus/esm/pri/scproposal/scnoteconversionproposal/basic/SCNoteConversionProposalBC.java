/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteConversionProposalBC.java
*@FileTitle : Special Note Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteHdrCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.vo.PriScNoteConvListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.vo.RsltNoteConvVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.NotePropVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteCtntListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtCnoteListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ScRtPropCmdtVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ScRtPropRtVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriScNoteConvVO;
import com.clt.syscommon.common.table.PriSgStndNoteCtntVO;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpNoteCtntVO;
import com.clt.syscommon.common.table.PriSpScpRtCnoteVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * - interface about Scproposal biz logic<br>
 *
 * @author 
 * @see Esm_pri_0032EventResponse 
 * @since J2EE 1.6
 */

public interface SCNoteConversionProposalBC {

	/**
	 * Retrieving [Special Note DETAIL]<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchNoteContentList(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException;
		
	/**
	 * Retrieving [Special Note Conversion]<br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return List<PriScNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionList(PriScNoteConvVO priScNoteConvVO) throws EventException;
	
	/**
	 * Handling [Special Note Conversion] CUD transaction<br>
	 * 
	 * @param PriScNoteConvListVO[] priScNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversion(PriScNoteConvListVO[] priScNoteConvListVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving [copied Special Note Conversion]<br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @param SignOnUserAccount account
	 * @return List<RsltNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionListCopy(PriScNoteConvVO priScNoteConvVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Copying [Special Note Conversion]<br>
	 * 
	 * @param PriScNoteConvListVO[] priScNoteConvListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCopy(PriScNoteConvListVO[] priScNoteConvListVO,SignOnUserAccount account) throws EventException;

	/**
	 * Retrieving [Commodity Note DETAIL]<br>
	 * 
	 * @param PriSpScpRtCnoteVO priSpScpRtCnoteVO
	 * @return List<RsltRtCnoteListVO>
	 * @exception EventException
	 */
	public List<RsltRtCnoteListVO> searchCommodityNoteContentList(PriSpScpRtCnoteVO priSpScpRtCnoteVO) throws EventException;
	

	/**
	 * Retrieving [Commodity Note DETAIL]<br>
	 * 
	 * @param PriSpScpRtCnoteVO priSpScpRtCnoteVO
	 * @return List<RsltRtCnoteListVO>
	 * @exception EventException
	 */
	public List<RsltRtCnoteListVO> searchCommodityNoteContentInquiryList(PriSpScpRtCnoteVO priSpScpRtCnoteVO) throws EventException;
		
	/**
	 * Handling Amend Request <br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;		
	
	/**
	 * Changing Conversion's Expire Date when Changing Main Duration Expire Date<br>
	 * 
	 * @param PriSpScpMnVO[] priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionExpireDate(PriSpScpMnVO[] priSpScpMnVO,SignOnUserAccount account) throws EventException;

	/**
	 * Changing Conversion's Effective Date when Changing Duration Effective Date <br>
	 * 
	 * @param PriSpScpMnVO[] priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionEffectiveDate(PriSpScpMnVO[] priSpScpMnVO,SignOnUserAccount account) throws EventException;	
	
    /**
     * Copying S/C Proposal Special Note Conversion<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScNoteConversion(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException;

    /**
     * Copying S/C Proposal Rate Route Note Conversion <br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalRoutNoteConversion(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException;

    /**
     * Copying S/C Proposal Rate Commodity Note Conversion <br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void copyProposalCmdtNoteConversion(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException;

	/**
	 * Deleting all CONVERSION data selected SCOPE <br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Saving S/C Standard Note Conversion <br>
	 * 
	 * @param NotePropVO notePropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNote(NotePropVO notePropVO, SignOnUserAccount account) throws EventException;
	
	/**
     * Creating Conversion data when S/C Standard Note Copy <br>
     * 
     * @param RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScStndNoteConversion(RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO, SignOnUserAccount account) throws EventException;
    
    /**
     * Deleting CONVERSION when deleting CTNT of STANDARD NOTEbr>
     * 
     * @param PriSgStndNoteCtntVO priSgStndNoteCtntVO
     * @exception EventException
     */
    public void removeScStndNoteConversion(PriSgStndNoteCtntVO priSgStndNoteCtntVO) throws EventException;
    
    /**
     * Modifying Conversion's DURATION when updating S/C Standard Note DURATION  <br>
     * 
     * @param RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyDurationScStndNoteConversion(RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * Changing Conversion's Effective Date when filing <br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionEffectiveDateFiling(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;
    
	/**
	 * Handling Commodity Group CUD transaction<br>
	 * 
	 * @param ScRtPropCmdtVO scRtPropCmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCommodity(ScRtPropCmdtVO scRtPropCmdtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Handling [Route and Rate] CUD transaction<br>
	 * 
	 * @param ScRtPropRtVO scRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRate(ScRtPropRtVO scRtPropRtVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Retrieving header information for dividing transfer data <br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCreationTypeCode(PriScNoteConvVO priScNoteConvVO) throws EventException;

	/**
	 * Retrieving CONVERSION CONFIRM FLAG for inputting CONVERSION <br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return String
	 * @exception EventException
	 */
	public String searchConversionConfirmFlag(PriScNoteConvVO priScNoteConvVO) throws EventException;

    /**
     * Adding Conversion based on previous Amend Seq.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void manageConversionUpdate (PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException ; 	
	
	/**
	 * Retrieving current AMDT_SEQ EXP_DT's DURATION for EXP_DT when inputting CONVERSION HISTORY <br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return String
	 * @exception EventException
	 */
	public String searchDurationExpDate(PriScNoteConvVO priScNoteConvVO) throws EventException;
   
    
}