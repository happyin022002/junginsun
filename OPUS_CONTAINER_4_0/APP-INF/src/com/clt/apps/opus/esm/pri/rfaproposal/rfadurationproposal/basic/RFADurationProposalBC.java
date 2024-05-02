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
package com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.CstAuthorityVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpDurVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpScpDurCntVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpScpDurVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.GrpDurVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.RsltPriRpDurHisVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
//import com.clt.apps.opus.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpDurVO;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpDurVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Scproposal<br>
 *
 * @author
 * @see Esm_pri_0020EventResponse 
 * @since J2EE 1.4
 */

public interface RFADurationProposalBC {

	/**
	 * Modifying RFA Duration information.<br>
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(RfaPropMnVO rfaPropMnVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Deleting RFA Scope Duration information<br>
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeDurationRemove(RfaPropMnVO rfaPropMnVO,SignOnUserAccount account) throws EventException;	
		
	
	/**
	 * Changing Accepted data of Main duration to "init" status when cancelling request<br>.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Changing Accepted data of Scope Duration to "init" status when cancelling request<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelScope(PriRpScpMnVO[] priRpScpMnVO,SignOnUserAccount account) throws EventException;  	
	
	/**
	 * Deleting data of Main duration when cancelling "Init" status.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Deleting Scope duration's datas when cancelling "Init"<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScope(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  Modifying request status of Main,Scope Duration to "Accept"<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalDuration(PriRpScpDurVO priRpScpDurVO,SignOnUserAccount account) throws EventException;
	
    /**
     *   Retrieving Main,Scope Duration data.<br>
     * 
     * @param CstAuthorityVO cstAuthorityVO
     * @return GrpDurVO
     * @exception EventException
     */
	public GrpDurVO searchProposalDurationList(CstAuthorityVO cstAuthorityVO) throws EventException;	

	/**
     * Adding/Modifying/Deleting Duration <br>
     * 
     * @param CstPriRpScpDurVO[] cstPriRpScpDurVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageProposalDuration(CstPriRpScpDurVO[] cstPriRpScpDurVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Cancelling Accepted Main,Scope Duration<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalDuration(PriRpScpDurVO priRpScpDurVO,SignOnUserAccount account) throws EventException;	
	
	
	/**
   * Retrieving scope duration when saving Main duration<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<CstPriRpDurVO>
	 * @exception EventException
	 */
	public List<CstPriRpDurVO> searchProposalScopeCheckList(PriRpScpDurVO priRpScpDurVO) throws EventException;
	
	/**
   * Retrieving whether amended data of scope duration exists or not when amending Main Duration<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<PriRpScpDurVO>
	 * @exception EventException
	 */
	public List<PriRpScpDurVO> searchProposalDurationAmendCheckList(PriRpScpDurVO priRpScpDurVO) throws	EventException;
	
	/**
  * Checking Main's duration is under scope duration when saving main duration<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<CstPriRpScpDurCntVO>
	 * @exception EventException
	 */
	public List<CstPriRpScpDurCntVO> searchProposalDurationScopeCount(PriRpScpDurVO priRpScpDurVO) throws EventException;  	
	
	/**
	 * Amending Main,Scope Duration.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving scope with same or previous expire data of main duration with expire date of scope when modifying main duration<br>
	 * 
	 * @param CstPriRpScpDurVO cstPriRpScpDurVO
	 * @return List<PriRpScpDurVO>
	 * @exception DAOException
	 */
	public List<PriRpScpDurVO> searchProposalScope(CstPriRpScpDurVO cstPriRpScpDurVO) throws EventException ;	
	
	/**
	 * Retrieving Duration Amend History.<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<RsltPriRpDurHisVO>
	 * @exception EventException
	 */
	public List<RsltPriRpDurHisVO> searchProposalDurationHistoryList(PriRpScpDurVO priRpScpDurVO) throws EventException;	

    /**
     * Coping RFA Proposal Main Duration information.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalDuration(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * Copying RFA Proposal Scope Duration information.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeDuration(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException;
    
	/**
	 * Retrieving scope with same expire data with main's when accepting Main Duration<br>
	 * 
	 * @param PriRpDurVO priRpDurVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalDurationAcceptCount(PriRpDurVO priRpDurVO) throws EventException;
	
	/**
	 * Chaning requested data of scope to "Accept" when accepting Main<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAutoProposalScopeDuration(PriRpScpDurVO priRpScpDurVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Retrieving scope with same Expire date with main when accepting Main duration<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalDurationAcceptList(PriRpScpDurVO priRpScpDurVO) throws EventException;    
    
}