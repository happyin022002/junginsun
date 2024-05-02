/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCLoadingAgentProposalBC.java
*@FileTitle : S/C Proposal Loading Agent Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.16
*@LastModifier : SHKIM
*@LastVersion : 1.0
* 2012.04.16 SHKIM
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scloadingagentproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.scproposal.scloadingagentproposal.vo.RsltLodgAgnListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpLodgAgnVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * -Handling a biz logic about  Scproposal<br>
 *
 * @author 
 * @see Esm_pri_0003_07EventResponse
 * @since J2EE 1.6
 */
public interface SCLoadingAgentProposalBC {
	/**
	 * Retrieving S/C Proposal Loading Agent information<br>
	 * 
	 * @param PriSpScpLodgAgnVO priSpScpLodgAgnVO
	 * @return List<RsltLodgAgnListVO>
	 * @exception EventException
	 */
	public List<RsltLodgAgnListVO> searchLoadingAgentList(PriSpScpLodgAgnVO priSpScpLodgAgnVO) throws EventException;

	/**
	 * Deleting all data of SCOPE<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;
	/**
	 * Saving S/C Proposal Loading Agent information<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO,SignOnUserAccount account) throws EventException;
	/**
	 * Accepting all acceptance of S/C Proposal Loading Agent information.<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO,SignOnUserAccount account) throws EventException;
	/**
	 * Canceling acceptance of S/C Proposal Loading Agent information<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO,SignOnUserAccount account) throws EventException;
	/**
	 * Accepting S/C Proposal Loading Agent information<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO,SignOnUserAccount account) throws EventException;
	/**
	 * Canceling all acceptance of S/C Proposal Loading Agent information<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO,SignOnUserAccount account) throws EventException;

	/**
	 * Requesting Amend<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;			

    /**
     * Copying Proposal Scope Loading Agent information<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeLoading(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * Getting count of Terms data<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMn
     * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeDeleteCheck(PriSpScpMnVO  priSpScpMn) throws EventException;		
	/**
	 * Changing accepted data to "init" at once when canceling Request<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;  
	
	/**
	 * Retrieving S/C Proposal Loading Agent History information<br>
	 * 
	 * @param PriSpScpLodgAgnVO priSpScpLodgAgnVO
	 * @return List<RsltLodgAgnListVO>
	 * @exception EventException
	 */
	public List<RsltLodgAgnListVO> searchLoadingAgentHistoryList(PriSpScpLodgAgnVO priSpScpLodgAgnVO) throws EventException;
	
	/**
	 * Retrieving S/C Proposal Loading Agent History information<br>
	 * 
	 * @param PriSpScpLodgAgnVO priSpScpLodgAgnVO
	 * @return List<RsltLodgAgnListVO>
	 * @exception EventException
	 */
	public List<RsltLodgAgnListVO> searchLoadingAgentInquiryList(PriSpScpLodgAgnVO priSpScpLodgAgnVO) throws EventException;
}