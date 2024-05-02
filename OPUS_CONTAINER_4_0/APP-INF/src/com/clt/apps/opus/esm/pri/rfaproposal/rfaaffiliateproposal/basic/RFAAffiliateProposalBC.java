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
package com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.vo.CstPriRpAfilVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.vo.PriRpAfilInqVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltAfilListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltPriRpAfilHdrVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltPriRpAfilVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpAfilVO;
import com.clt.syscommon.common.table.PriRpMnVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Scproposal<br>
 *
 * @author
 * @see Esm_pri_0025EventResponse 
 * @since J2EE 1.6
 */

public interface RFAAffiliateProposalBC {
	
	/**
	 * Retrieving Affiliate List를 조회한다. <br>
	 * 
	 * @param PriRpAfilVO priRpAfilVO 
	 * @return List<RsltPriRpAfilVO>
	 * @exception EventException
	 */
	public List<RsltPriRpAfilVO> searchAffiliateList(PriRpAfilVO priRpAfilVO) throws EventException;
	
	/**
	 * Modifying Affiliate List <br>
	 * 
	 * @param PriRpAfilVO[] priRpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAffiliate(PriRpAfilVO[] priRpAfilVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Accepting Affiliate<br>
	 * 
	 * @param PriRpAfilVO[] priRpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAffiliate(PriRpAfilVO[] priRpAfilVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Cancelling accepting Affiliate<br>
	 * 
	 * @param PriRpAfilVO[] priRpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAffiliate(PriRpAfilVO[] priRpAfilVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Accepting all acceptance of Affiliate<br>
	 * 
	 * @param CstPriRpAfilVO cstPriRpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllAffiliate(CstPriRpAfilVO cstPriRpAfilVO,SignOnUserAccount account) throws EventException;	
		
	/**
	 * Cancelling all acceptance of Affiliate<br>
	 * 
	 * @param CstPriRpAfilVO cstPriRpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllAffiliate(CstPriRpAfilVO cstPriRpAfilVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Requesting Amend <br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * Copying RFA Proposal Affiliate<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalAffiliate (RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException;
    
    /**
	 * Deleting all datas with related amend seq<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Modifying accepted datas of main duration to "Init" at one time when cancelling request<br>
	 * 
	 * @param PriRpMnVO priRpMnVO 
   * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;  	
	
	/**
	 * Retrieving affiliate Amend History<br>
	 * 
	 * @param PriRpAfilVO priRpAfilVO
   * @return List<RsltAfilListVO>
	 * @exception EventException
	 */
	public List<RsltAfilListVO> searchAffiliateHistoryList(PriRpAfilVO priRpAfilVO) throws EventException;
	
	/**
	 * Retrieving Affiliate Inquiry<br>
	 * 
	 * @param PriRpAfilVO priRpAfilVO 
	 * @return List<PriRpAfilInqVO>
	 * @exception EventException
	 */
	public List<PriRpAfilInqVO> searchAffiliateInquiryList(PriRpAfilVO priRpAfilVO) throws EventException;
	
	/**
	 * Retrieving basic Affiliate information by proposal no when calling from DEM/DET<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltPriRpAfilHdrVO>
	 * @exception EventException
	 */
	public List<RsltPriRpAfilHdrVO> searchAffiliateHeader(PriRpMnVO priRpMnVO) throws EventException;	
}