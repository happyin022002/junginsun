/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCDurationProposalBC.java
*@FileTitle : Duration
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.vo.CstAcceptDurVO;
import com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.vo.CstAuthorityVO;
import com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.vo.CstPriSpDurVO;
import com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.vo.CstPriSpScpDurCntVO;
import com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.vo.CstPriSpScpDurVO;
import com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.vo.GrpDurVO;
import com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.vo.RsltPriSpDurHisVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
//import com.clt.apps.opus.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpDurVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Scproposal<br>
 *
 * @author Byeon Young Joo
 * @see Esm_pri_0020EventResponse 
 * @since J2EE 1.4
 */

public interface SCDurationProposalBC {

	/**
	 *  Adding/modifying/deletingSC Duration information.<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(ScPropMnVO scPropMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 *  Deleting SC Duration information<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeDurationRemove(ScPropMnVO scPropMnVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Amending Main,Scope Duration.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;	
	
	
	/**
   * Retrieving  Main,Scope Duration datadata<br>
	 * 
	 * @param CstAuthorityVO cstAuthorityVO
	 * @return GrpDurVO
	 * @exception EventException
	 */
	public GrpDurVO searchProposalDurationList(CstAuthorityVO cstAuthorityVO) throws EventException;	

	/**
	 * Changing Main,Scope Duration's Request data to Accept<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalDuration(PriSpScpDurVO priSpScpDurVO,SignOnUserAccount account) throws EventException;
	/**
	 * Changing Scope's Request data to Accept  when accepting main.<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void autoAcceptProposalScopeDuration(PriSpScpDurVO priSpScpDurVO,SignOnUserAccount account) throws EventException;	
	/**
	 * Canceling an acceptance of Main,Scope Duration .<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalDuration(PriSpScpDurVO priSpScpDurVO,SignOnUserAccount account) throws EventException;
	
	/**
     * Managing Duration <br>
	 * 
	 * @param CstPriSpScpDurVO[] cstPriSpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalDuration(CstPriSpScpDurVO[] cstPriSpScpDurVO,SignOnUserAccount account) throws EventException;

    /**
     * Copying S/C Proposal Main Duration information.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalDuration(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * Copying S/C Proposal Scope Duration information<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeDuration(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;
    
	/**
   * Retrieving  Scope Duration when saving Main Duration<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @return List<CstPriSpDurVO>
	 * @exception EventException
	 */
	public List<CstPriSpDurVO> searchProposalScopeCheckList(PriSpScpDurVO priSpScpDurVO) throws EventException;    
	
	/**
	 * Deleting S/C Proposal Main Duration information<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;

    /**
	 *  Deleting  Scope Duration's data when canceling Init <br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScope(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;	
    
	/**
	 *changing accepted data of main duration to "init" at one time when canceling Request<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;  
	
	/**
	 * changing accepted data of scope duration to "init" at one time when canceling Request.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelScope(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException;  	
	/**
	 * Modifying effective data of duration in case filing date is before when Filing<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalTerms(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
   * Retrieving amend data of scope duration when canceling amendment of Main Duration<br>
	 * @param PriSpScpDurVO PriSpScpDurVO
	 * @return List<PriSpScpDurVO>
	 * @throws DAOException
	 */
	public List<PriSpScpDurVO> searchProposalDurationAmendCheckList(PriSpScpDurVO priSpScpDurVO) throws	EventException;
	
	
	/**
   * Retrieving whether main duration is before scope duration when saving main duration<br>
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @return List<CstPriSpScpDurCntVO> 
	 * @exception EventException
	 */
	public List<CstPriSpScpDurCntVO> searchProposalDurationScopeCount(PriSpScpDurVO priSpScpDurVO) throws EventException;  	
	
	/**
	 * Retrieving Scope.<br>
	 * 
	 * @param CstPriSpScpDurVO cstPriSpScpDurVO
	 * @return List<PriSpScpDurVO>
	 * @exception DAOException
	 */
	public List<PriSpScpDurVO> searchProposalScope(CstPriSpScpDurVO cstPriSpScpDurVO) throws EventException ;
	
	/**
	 * Retrieving Duration Amend History data<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @return List<RsltPriSpDurHisVO>
	 * @exception EventException
	 */
	public List<RsltPriSpDurHisVO> searchProposalDurationHistoryList(PriSpScpDurVO priSpScpDurVO) throws EventException;
	
	/**
	 *  Modifying Main,Scope Duration's Request data to Accept <br>
	 * 
	 * @param CstAcceptDurVO cstAcceptDurVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllProposalDuration(CstAcceptDurVO cstAcceptDurVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Canceling all acceptance of Main,Scope Duration data<br>
	 * 
	 * @param CstAcceptDurVO cstAcceptDurVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllProposalDuration(CstAcceptDurVO cstAcceptDurVO,SignOnUserAccount account) throws EventException;
	
    /**
     * Retrieving count of scope to check saving main and scope simutaneously when saving<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchDurScopeCount(PriSpMnVO priSpMnVO) throws EventException ;		
    
    /**
     * Checking modified scope duration is between main duration after main duration when saving<br>
     *
     * @param PriSpScpDurVO priSpScpDurVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchMainDuration(PriSpScpDurVO priSpScpDurVO) throws EventException ;	
    
    /**
     * Checking modified scope duration is between main duration after main duration when saving.<br>
     *
     * @param PriSpScpDurVO priSpScpDurVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchScopeDuration(PriSpScpDurVO priSpScpDurVO) throws EventException ;    
}