/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupLocationProposalBC.java
*@FileTitle : S/C Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgrouplocationproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.scproposal.scgrouplocationproposal.vo.GrpLocPropVO;
import com.clt.apps.opus.esm.pri.scproposal.scgrouplocationproposal.vo.RsltGrpLocDtlListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgrouplocationproposal.vo.RsltGrpLocListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
//import com.clt.apps.opus.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpGrpLocDtlVO;
import com.clt.syscommon.common.table.PriSpScpGrpLocVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Scproposal<br>
 *
 * @author
 * @see Esm_pri_0003_02EventResponse 
 * @since J2EE 1.4
 */

public interface SCGroupLocationProposalBC {
	/**
	 * Retrieving Location Group Detail information.<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailList (PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO) throws EventException;
	
	/**
	 * Retrieving Location Group information.<br>
	 * 
	 * @param PriSpScpGrpLocVO priSpScpGrpLocVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationList (PriSpScpGrpLocVO priSpScpGrpLocVO) throws EventException;

	/**
	 * Handling multi event for UI_PRI_0003_02<br>
	 * Handling saving event<br>
	 * 
	 * @param GrpLocPropVO grpLocPropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupLocation(GrpLocPropVO grpLocPropVO,SignOnUserAccount account) throws EventException;

	/**
	 * Handling multi event for  UI_PRI_0003_02<br>
	 * Handling multi event for Accept All<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String acceptAllGroupLocation(PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * Handling multi event for UI_PRI_0003_02<br>
	 * Handling multi event for Cancel All<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String cancelAllGroupLocation(PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Handling multi event for UI_PRI_0003_02<br>
	 * Handling multi event for Accept<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO[] priSpScpGrpLocDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptGroupLocation(PriSpScpGrpLocDtlVO[] priSpScpGrpLocDtlVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Handling multi event for UI_PRI_0003_02<br>
	 * Handling multi event for cancel<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO[] priSpScpGrpLocDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGroupLocation(PriSpScpGrpLocDtlVO[] priSpScpGrpLocDtlVOs,SignOnUserAccount account) throws EventException;

	/**
	 * Handling multi event for UI_PRI_0003_02<br>
	 * Handling multi event for G/L Copy<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineGroupLocation(PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO,SignOnUserAccount account) throws EventException;
	/**
	 * Requesting amendment<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;		

    /**
     * Copying Proposal Scope Group Location information<br>
     * 
     * @param RsltPropCopyVO vo
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeLocation(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;
    
	/**
	 * Handling retrieving event
	 * Handling retrieving event for SCGroupLocationProposal screen<br>
	 * 
	 * @param PriSpScpGrpLocVO[] priSpScpGrpLocVOs
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationRateApplyList (PriSpScpGrpLocVO[] priSpScpGrpLocVOs) throws EventException;

	/**
	 * Handling retrieving event
	 * Handling retrieving event for  SCGroupLocationProposal screen<br>
	 * 
	 * @param PriSpScpGrpLocVO[] priSpScpGrpLocVOs
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationRateAcceptedList (PriSpScpGrpLocVO[] priSpScpGrpLocVOs) throws EventException;
	
    /**
     * Copying Guideline Location Group to Proposal<br>
     * 
     * @param SpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineGrpLoc(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;


    /**
	 * handling deletion event for SCOPE <br>
	 * Deleting all data by scope<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;	

	/**
	 * Modifying accepted data to "init" when canceling Request<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;  
	
	/**
	 * Retrieving Location Group History Detail information.<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailHistoryList (PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO) throws EventException;
	
	/**
	 * Retrieving Location Group History information.<br>
	 * 
	 * @param PriSpScpGrpLocVO priSpScpGrpLocVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationHistoryList (PriSpScpGrpLocVO priSpScpGrpLocVO) throws EventException;

	/**
	 * Retrieving Location Group History Detail information.<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailInquiryList (PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO) throws EventException;
	
	/**
	 * Retrieving Location Group History information.<br>
	 * 
	 * @param PriSpScpGrpLocVO priSpScpGrpLocVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationInquiryList (PriSpScpGrpLocVO priSpScpGrpLocVO) throws EventException;
	
}