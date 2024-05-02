/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCMQCProposalBC.java
*@FileTitle : MQC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.CstAcceptMqcVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.CstMqcVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.GrpMqcVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpMqcHisVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpScpMqcVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpSubMqcHisVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpSubMqcVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.SchPriSpScpMqcVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
//import com.clt.apps.opus.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpMqcVO;
import com.clt.syscommon.common.table.PriSpSubMqcVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Scproposal<br>
 *
 * @author
 * @see Esm_pri_0020EventResponse 
 * @since J2EE 1.4
 */

public interface SCMQCProposalBC {

	/**
	 * Saving MQC from Proposal Main.<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(ScPropMnVO scPropMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Deleting MQC from Proposal Main<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeMqcRemove(ScPropMnVO scPropMnVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Requesting Amendment<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;	
	
	
	
	/**
	 * Retrieving Main MQC,Scope MQC data.<br>
	 * 
	 * @param CstMqcVO cstMqcVO
	 * @return GrpMqcVO
	 * @exception EventException 
	 */
	public GrpMqcVO searchProposalMQCList(CstMqcVO cstMqcVO) throws EventException;	

	/**
	 * Accepting Main,Scope MQC<br>
	 * 
	 * @param SchPriSpScpMqcVO schPriSpScpMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalMQC(SchPriSpScpMqcVO schPriSpScpMqcVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Canceling an acceptance of Main,Scope MQC.<br>
	 * 
	 * @param SchPriSpScpMqcVO schPriSpScpMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalMQC(SchPriSpScpMqcVO schPriSpScpMqcVO,SignOnUserAccount account) throws EventException;	
	
	
	/**
	 * Modifying and deleting MQC from MQC screen<br>
	 * 
	 * @param SchPriSpScpMqcVO[] schPriSpScpMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalMQC(SchPriSpScpMqcVO[] schPriSpScpMqcVO,SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * Retrieving Sub MQC<br>
	 * 
	 * @param PriSpSubMqcVO priSpSubMqcVO
	 * @return List<RsltPriSpSubMqcVO>
	 * @exception EventException
	 */
	public List<RsltPriSpSubMqcVO> searchProposalSubMQCList(PriSpSubMqcVO priSpSubMqcVO) throws EventException;	
	
	/**
	 * Accepting Sub MQC<br>
	 * 
	 * @param PriSpSubMqcVO priSpSubMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalSubMQC(PriSpSubMqcVO priSpSubMqcVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Canceling an acceptance of Sub MQC.<br>
	 * 
	 * @param PriSpSubMqcVO priSpSubMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalSubMQC(PriSpSubMqcVO priSpSubMqcVO,SignOnUserAccount account) throws EventException;	
	
	
	/**
	 * Saving Sub MQC<br>
	 * 
	 * @param PriSpSubMqcVO[] priSpSubMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalSubMQC(PriSpSubMqcVO[] priSpSubMqcVO,SignOnUserAccount account) throws EventException;
	
	/**
	 *  Retrieving MQC sum of scope except selected scope
	 * 
	 * @param PriSpScpMqcVO priSpScpMqcVO
	 * @return List<RsltPriSpScpMqcVO>
	 * @exception EventException
	 */
	public List<RsltPriSpScpMqcVO> searchSumScopeMqc(PriSpScpMqcVO priSpScpMqcVO) throws EventException;

	
	/**
	 * Retrieving MQC sum of all scope <br>
	 * 
	 * @param PriSpScpMqcVO priSpScpMqcVO
	 * @return List<RsltPriSpScpMqcVO>
	 * @exception EventException
	 */
	public List<RsltPriSpScpMqcVO> searchSumScopeAllMqc(PriSpScpMqcVO priSpScpMqcVO) throws EventException;	

	/**
     * Copying Proposal MQC information<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalMqc(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * Copying Proposal Scope MQC information.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeMqc(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;
    

	/**
	 * Deleting S/C MQC Main information.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;
	/**
	 * Deleting S/C MQC Scope information<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScope(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;	

	/**
	 * Modifying accepted data of main duration to "init" at one time when canceling request<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;
	/**
	 * Modifying accepted data of scope duration to "init" at one time when canceling request.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelScope(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException;	

	/**
	 * Accepting automatically when requesting S/C Proposal<br>
	 * @param PriSpScpMqcVO priSpScpMqcVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void autoAcceptProposalScpMqc(PriSpScpMqcVO priSpScpMqcVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving MQC(Main,Scope) Amend History <br>
	 * 
	 * @param PriSpScpMqcVO priSpScpMqcVO 
	 * @return List<RsltPriSpMqcHisVO>
	 * @exception EventException
	 */
	public List<RsltPriSpMqcHisVO> searchProposalMQCHistoryList(PriSpScpMqcVO priSpScpMqcVO) throws EventException;
	
	/**
	 * Retrieving Sub MQC Amend History <br>
	 * 
	 * @param PriSpScpMqcVO priSpScpMqcVO 
	 * @return List<RsltPriSpSubMqcHisVO>
	 * @exception EventException
	 */
	public List<RsltPriSpSubMqcHisVO> searchProposalSubMQCHistoryList(PriSpScpMqcVO priSpScpMqcVO) throws EventException;	
	
	/**
	 * Changing Main,Scope MQC 's Request data to "accept"<br>
	 * 
	 * @param CstAcceptMqcVO cstAcceptMqcVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllProposalMqc(CstAcceptMqcVO cstAcceptMqcVO,SignOnUserAccount account) throws EventException;
	
	/**
	 *  Canceling all acceptance of Main,Scope MQC<br>
	 * 
	 * @param CstAcceptMqcVO cstAcceptMqcVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllProposalMqc(CstAcceptMqcVO cstAcceptMqcVO,SignOnUserAccount account) throws EventException;	
	
	
	/**
	 * Accepting Sub MQC automatically<br>
	 * 
	 * @param PriSpSubMqcVO priSpSubMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void autoAcceptProposalSubMQC(PriSpSubMqcVO priSpSubMqcVO, SignOnUserAccount account) throws EventException;
	
    /**
     * retrieving count of scope to check silutaneous saving for main and scope on saving time<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchScopeCount(PriSpMnVO priSpMnVO) throws EventException ;	
	
}