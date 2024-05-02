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
package com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.vo.GrpLocPropVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.vo.RsltGrpLocDtlListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.vo.RsltGrpLocListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpGrpLocDtlVO;
import com.clt.syscommon.common.table.PriRpScpGrpLocVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Scproposal<br>
 *
 * @author 
 * @see Esm_pri_2003_02EventResponse
 * @since J2EE 1.4
 */

public interface RFAGroupLocationProposalBC {
	/**
	 * Retrieving LOCATION GROUP DETAIL<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailList (PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO) throws EventException;
	
	/**
	 * Retrieving LOCATION GROUP MASTER<br>
	 * 
	 * @param PriRpScpGrpLocVO priRpScpGrpLocVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationList (PriRpScpGrpLocVO priRpScpGrpLocVO) throws EventException;

	/**
	 * Saving LOCATION GROUP<br>
	 * 
	 * @param GrpLocPropVO grpLocPropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupLocation(GrpLocPropVO grpLocPropVO,SignOnUserAccount account) throws EventException;

	/**
	 * Accepting LOCATION GROUP all<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String acceptAllGroupLocation(PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO,SignOnUserAccount account) throws EventException;

	/**
	 * Canceling LOCATION GROUP all <br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String cancelAllGroupLocation(PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Accepting LOCATION GROUP<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO[] priRpScpGrpLocDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptGroupLocation(PriRpScpGrpLocDtlVO[] priRpScpGrpLocDtlVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Cancelling LOCATION GROUP<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO[] priRpScpGrpLocDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGroupLocation(PriRpScpGrpLocDtlVO[] priRpScpGrpLocDtlVOs,SignOnUserAccount account) throws EventException;

	/**
	 * Copying GUIDELINE LOCATION GROUP<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @param SignOnUserAccount account
	 * @return Integer
	 * @exception EventException
	 */
	public int copyGuidelineGroupLocation(PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO,SignOnUserAccount account) throws EventException;
	/**
	 * Ameding LOCATION GROUP.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;		

	/**
	 * Copying RFA Proposal Scope Group Location <br>
	 * 
	 * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void copyProposalScopeLocation(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * Retrieving whether use in <br>
	 * 
	 * @param PriRpScpGrpLocVO[] priRpScpGrpLocVOs
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationRateApplyList (PriRpScpGrpLocVO[] priRpScpGrpLocVOs) throws EventException;

	/**
	 * Copying GUIDELINE LOCATION GROUP to PROPOSAL<br>
	 * 
	 * @param RpScpGlineCopyVO rpScpGlineCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void copyScopeGuidelineGrpLoc(RpScpGlineCopyVO rpScpGlineCopyVO, SignOnUserAccount account) throws EventException;


    /**
	 * Deleting all data of scope<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;	


	/**
	 * Changing Main's duration's Accepted data to "init" at once when cancelling Request<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Retrieving LOCATION GROUP DETAIL<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailHistoryList (PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO) throws EventException;
	
	/**
	 *  Retrieving LOCATION GROUP MASTER<br>
	 * 
	 * @param PriRpScpGrpLocVO priRpScpGrpLocVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationHistoryList (PriRpScpGrpLocVO priRpScpGrpLocVO) throws EventException;

	/**
	 * Checking whether common code exists or not<br>
	 * 
	 * @param RsltGrpLocDtlListVO[]   rsltGrpLocDtlListVOs
	 * @return String[]
	 * @exception EventException
	 */
	public String[] checkGroupLocationCode(RsltGrpLocDtlListVO[] rsltGrpLocDtlListVOs) throws EventException;
	
	/**
	 * Retrieving LOCATION GROUP DETAIL<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailInquiryList (PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO) throws EventException;
	
	/**
	 * Retrieving LOCATION GROUP MASTER<br>
	 * 
	 * @param PriRpScpGrpLocVO priRpScpGrpLocVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationInquiryList (PriRpScpGrpLocVO priRpScpGrpLocVO) throws EventException;
	
}