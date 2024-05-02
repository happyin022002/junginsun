/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCAffiliateProposalBC.java
*@FileTitle : Proposal Affiliate Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scaffiliateproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.scproposal.scaffiliateproposal.vo.CstPriSpAfilVO;
import com.clt.apps.opus.esm.pri.scproposal.scaffiliateproposal.vo.RsltAfilListVO;
import com.clt.apps.opus.esm.pri.scproposal.scaffiliateproposal.vo.RsltPriSpAfilInqVO;
import com.clt.apps.opus.esm.pri.scproposal.scaffiliateproposal.vo.RsltPriSpAfilVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpAfilVO;
import com.clt.syscommon.common.table.PriSpMnVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Scproposal<br>
 *
 * @author
 * @see Esm_pri_0025EventResponse 
 * @since J2EE 1.6
 */

public interface SCAffiliateProposalBC {
	/**
	 * Retrieving Affiliate Company list<br>
	 * 
	 * @param PriSpAfilVO priSpAfilVO
	 * @return List<RsltPriSpAfilVO>
	 * @exception EventException
	 */
	public List<RsltPriSpAfilVO> searchAffiliateList(PriSpAfilVO priSpAfilVO) throws EventException;
	/**
	 * Retrieving Amendment History Inquiry - Affiliate Company list<br>
	 * 
	 * @param RsltAfilListVO pVo
	 * @return List<RsltAfilListVO>
	 * @exception EventException
	 */
	public List<RsltAfilListVO> searchAffiliateHistoryList(RsltAfilListVO pVo) throws EventException;
	
	/**
	 * Saving Affiliate Company  data.<br>
	 * 
	 * @param PriSpAfilVO[] priSpAfilVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAffiliate(PriSpAfilVO[] priSpAfilVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Accept Affiliate Company data<br>
	 * 
	 * @param PriSpAfilVO[] priSpAfilVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAffiliate(PriSpAfilVO[] priSpAfilVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Canceling an acceptance Affiliate Company data<br>
	 * 
	 * @param PriSpAfilVO[] priSpAfilVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAffiliate(PriSpAfilVO[] priSpAfilVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Accepting all data except already accepted data in Affiliate Company data<br>
	 * 
	 * @param CstPriSpAfilVO cstPriSpAfilVO
     * @param SignOnUserAccount account
     * @return int
	 * @exception EventException
	 */
	public int acceptAllAffiliate(CstPriSpAfilVO cstPriSpAfilVO,SignOnUserAccount account) throws EventException;	
		
	/**
	 * Canceling all acceptance of Affiliate Company  data<br>
	 * 
	 * @param CstPriSpAfilVO cstPriSpAfilVO
     * @param SignOnUserAccount account
     * @return int
	 * @exception EventException
	 */
	public int cancelAllAffiliate(CstPriSpAfilVO cstPriSpAfilVO,SignOnUserAccount account) throws EventException;
	
	/**
	 *Request Amendment<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * Copying Proposal Affiliate information<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalAffiliate (RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;
    

 /**
	 * Deleting all data with related amend seq no when cancelling init status of main<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;
	/**
	 * Changing an accepted data to "init" at one time when canceling request<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
   * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException; 
	
	/**
	 * Retrieving Inquiry - Affiliate Company list<br>
	 * 
	 * @param PriSpAfilVO priSpAfilVO
	 * @return List<RsltPriSpAfilInqVO>
	 * @exception EventException
	 */
	public List<RsltPriSpAfilInqVO> searchAffiliateInquiryList(PriSpAfilVO priSpAfilVO) throws EventException;		
}