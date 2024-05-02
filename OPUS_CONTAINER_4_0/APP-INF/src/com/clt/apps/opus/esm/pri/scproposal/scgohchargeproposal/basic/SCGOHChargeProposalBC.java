/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGOHChargeProposalBC.java
*@FileTitle : S/C Proposal 및 Amendment시  GOH 생성/수정하는 화면
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgohchargeproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.scproposal.scgohchargeproposal.vo.CstPriSpScpGohChgVO;
import com.clt.apps.opus.esm.pri.scproposal.scgohchargeproposal.vo.RsltGohChgListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpGohChgVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Scproposal<br>
 *
 * @author 
 * @see Esm_pri_0003_06EventResponse 
 * @since J2EE 1.6
 */

public interface SCGOHChargeProposalBC {
	
	/**
	 * Retrieving S/C Proposal Creation - GOH List. <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @return List<RsltGohChgListVO>
	 * @exception EventException
	 */
	public List<RsltGohChgListVO> searchGOHChargeList(PriSpScpGohChgVO priSpScpGohChgVO) throws EventException;
	
	/**
	 * Modifying S/C Proposal Creation - GOH List. <br>
	 * 
	 * @param PriSpScpGohChgVO[] priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Accepting S/C Proposal Creation - GOH <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Canceling an acceptance of S/C Proposal Creation - GOH<br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO,SignOnUserAccount account) throws EventException;
	
	/**
	 *Accepting all of S/C Proposal Creation - GOH <br>
	 * 
	 * @param PriSpScpGohChgVO[] priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO,SignOnUserAccount account) throws EventException;
	
	/**
	 *  Canceling all acceptance of S/C Proposal Creation - GOH = <br>
	 * 
	 * @param PriSpScpGohChgVO[] priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Copying S/C Proposal Creation - GOH Cuideline<br>
	 * 
	 * @param CstPriSpScpGohChgVO cstPriSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineGOHCharge(CstPriSpScpGohChgVO cstPriSpScpGohChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Handling Proposal Main Amend. <br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;			

    /**
     * Copying S/C Proposal GOH Charge information.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeGohChg(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * Copying Guideline GOH Charge to Proposal .<br>
     * 
     * @param SpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineGohChg(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;
    
	
	/**
     * Checking whether copiable Guideline exists or not.<br>
     * 
     * @param CstPriSpScpGohChgVO cstPriSpScpGohChgVO
     * @return boolean
     * @exception EventException
     */
	public boolean checkGuidelineGOHChargeExist(CstPriSpScpGohChgVO cstPriSpScpGohChgVO) throws EventException;
  
	/**
	 * Modifying accepted data to "inot" when canceling request<br>
	 * all data by sequence is target<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException;  	
	
	/**
	 * deleting all data by SCOPE<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving SC GOH Amend History List. <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @return List<RsltGohChgListVO>
	 * @exception EventException
	 */
	public List<RsltGohChgListVO> searchGOHChargeHistoryList(PriSpScpGohChgVO priSpScpGohChgVO) throws EventException;
	
	/**
	 * Retrieving SC GOH Inquiry List. <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @return List<RsltGohChgListVO>
	 * @exception EventException
	 */
	public List<RsltGohChgListVO> searchGOHChargeInquiryList(PriSpScpGohChgVO priSpScpGohChgVO) throws EventException;
}