/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RfaProposalDEMDETBC.java
*@FileTitle : RFA Proposal Creation [Amend] (DEM&DET)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.vo.RsltDmdtExptHisListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.vo.RsltDmdtExptListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpDmdtVO;
import com.clt.syscommon.common.table.PriRpMnVO;

/**
 * Rfaproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Rfaproposal<br>
 *
 * @author 
 * @see Esm_pri_2058EventResponse 
 * @since J2EE 1.6
 */

public interface RFAProposalDEMDETBC {

	/**
	 * Retrieving DEM&DET<br>
	 * 
	 * @param PriRpDmdtVO priRpDmdtVO
	 * @return List<RsltDmdtExptListVO>
	 * @exception EventException
	 */
	public List<RsltDmdtExptListVO> searchDEMDETExceptionList(PriRpDmdtVO priRpDmdtVO) throws EventException;
	
	/**
	 * Modifying DEM&DET<br>
	 * 
	 * @param PriRpDmdtVO[] priRpDmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDEMDETException(PriRpDmdtVO[] priRpDmdtVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Accepting DEM&DET<br>
	 * 
	 * @param PriRpDmdtVO[] priRpDmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptDEMDETException(PriRpDmdtVO[] priRpDmdtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Cancelling an acceptance of DEM&DET<br>
	 * 
	 * @param PriRpDmdtVO[] priRpDmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelDEMDETException(PriRpDmdtVO[] priRpDmdtVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Adding/Modifying DEM&DET<br>
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(RfaPropMnVO rfaPropMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Checking accepted data to "init" at one tome when cancelling request<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Deleting all datas of related amend seq no when cancelling init status of main<br>
	 * 
	 * @param PriRpMnVO priRpMnVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Accepting automatically when requesting Main<br>
	 * 
	 * @param PriRpDmdtVO priRpDmdtVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalDEMDETException(PriRpDmdtVO priRpDmdtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Requesting amendment<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving DEM&DET Amendment History <br>
	 * 
	 * @param PriRpDmdtVO priRpDmdtVO
	 * @return List<RsltDmdtExptHisListVO>
	 * @exception EventException
	 */
	public List<RsltDmdtExptHisListVO> searchDEMDETExceptionHistoryList(PriRpDmdtVO priRpDmdtVO) throws EventException;

    /**
     * Copying RFA Proposal DEM/DET<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalDemDet(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException;
    
    /**
     * Creating RFA Proposal DEM/DET after copying PRS information.<br>
     * 
     * @param RsltCopyToProposalVO vo 
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    //public void copyToProposalRqDmdt(RsltCopyToProposalVO vo, SignOnUserAccount account) throws EventException;
    
}