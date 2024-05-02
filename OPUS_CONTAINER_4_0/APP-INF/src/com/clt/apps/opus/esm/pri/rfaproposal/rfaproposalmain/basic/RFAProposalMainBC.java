/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainBC.java
*@FileTitle : Proposal & Amendment Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.CstApprovalVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.CstRequestCheckVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.CstShHistVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.CstShRInqVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.DmtScExptVerVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RequestCheckForCalculationVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropProgVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltAmdtHisMnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriRpAmdHstMnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriRpInqVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropAmdtSmryVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropCustInfoVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropInqListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropScpAmdtSmryVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltReturnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaAproRqstRefVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaMainStsVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltStatusVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpAmdtSmryVO;
import com.clt.syscommon.common.table.PriRpAproRqstRefUsrVO;
import com.clt.syscommon.common.table.PriRpAproRqstRefVO;
import com.clt.syscommon.common.table.PriRpHdrVO;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpAmdtSmryVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;


/**
 * RFA Proposal Business Logic Command Interface<br>
 * - interface about RFA Proposal biz logic<br>
 *
 * @author 
 * @see Esm_pri_0003EventResponse 
 * @since J2EE 1.4
 */

public interface RFAProposalMainBC {
	/**
	 *  Retrieving RFA Proposal<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @param SignOnUserAccount account
	 * @return RsltPropListVO
	 * @exception EventException
	 */
	public RsltPropListVO searchProposalMain(PriRpHdrVO priRpHdrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  Retrieving Customer information <br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPropCustInfoVO> 
	 * @exception EventException
	 */
	public List<RsltPropCustInfoVO> searchProposalCustomerInfo(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException;
	
	/**
	 * saving RFA Main<br>
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageProposal(RfaPropMnVO rfaPropMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * changing RFA state<br>
	 * 
	 * @param RfaPropProgVO rfaPropProgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void counterofferProposal(RfaPropProgVO rfaPropProgVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * updating SUMMARY when automatic accept
	 * @param PriRpAmdtSmryVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyProposalAutoAcceptAmendmentSummary(PriRpAmdtSmryVO vo,SignOnUserAccount account) throws EventException;
	
	/**
	 * updating SUMMARY when automatic accept
	 * 
	 * @param PriRpScpAmdtSmryVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeAutoAcceptAmendmentSummary(PriRpScpAmdtSmryVO vo,SignOnUserAccount account) throws EventException;
	
	/**
	 * deleting all selected Amend seq. data when deleting scope<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScopeAmdtSmry(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  deleting all selected Amend seq. data when deleting scope<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScopeProgress(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * Retrieving Terms's Summary<br>
	 * @param PriRpAmdtSmryVO priRpAmdtSmryVO
	 * @return List<RsltPropAmdtSmryVO>
	 * @exception EventException
	 */
	public List<RsltPropAmdtSmryVO> searchProposalAmendmentSummary(PriRpAmdtSmryVO priRpAmdtSmryVO) throws EventException;
	
	/**
	 * Retrieving Scope Summary<br>
	 * 
	 * @param PriRpScpAmdtSmryVO priRpScpAmdtSmryVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception EventException
	 */
	public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummary(PriRpScpAmdtSmryVO priRpScpAmdtSmryVO) throws EventException;
	
	/**
	 * retrieving Terms for checking Accept <br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<PriRpMnVO>
	 * @exception EventException
	 */
	public List<PriRpMnVO> searchProposalAcceptCheck(PriRpMnVO priRpMnVO) throws EventException;	
	
	/**
	 * when C/OFFER , checking existence of init data in Terms<br>
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltStatusVO>
	 * @exception EventException
	 */	
	public List<RsltStatusVO> searchCountOfferStatus(PriRpMnVO priRpMnVO) throws EventException;
	
	/**
	 * when Request, retrieving mandatory data <br>
	 * @param PriRpMnVO priRpMnVO
	 * @return List<CstRequestCheckVO>
	 * @exception EventException
	 */
	public List<CstRequestCheckVO> searchRequestTermsCheck(PriRpMnVO priRpMnVO) throws EventException;
	
	
	/**
     * when Request, retrieving scope not Calculate<br>
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return List<RequestCheckForCalculationVO>
	 * @exception EventException
	 */
	public List<RequestCheckForCalculationVO> searchRequestCheckCalculate(PriRpScpMnVO priRpScpMnVO) throws EventException ;
	
	
	/**
	 * retrieving Scope's state<br>
	 * 
	 * @param PriRpScpMnVO  priRpScpMn
     * @return List<PriRpScpMnVO>
	 * @exception EventException
	 */
	public List<PriRpScpMnVO> searchProposalScopeStatusCheck(PriRpScpMnVO  priRpScpMn) throws EventException;	

   
	/**
	 * when deleting Scope, checking existence of Terms data<br>
	 * 
	 * @param PriRpScpMnVO  priRpScpMn
     * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeDeleteCheck(PriRpScpMnVO  priRpScpMn) throws EventException;	   
	
	/**
	 * Approving RFA main <br>
	 * 
	 * @param RfaPropProgVO rfaPropProgVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String approveProposal(RfaPropProgVO rfaPropProgVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * setting RFA Main state with previous state<br>
	 * 
	 * @param RfaPropProgVO rfaPropProgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposal(RfaPropProgVO rfaPropProgVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * when automatic accept canceling, updating (Main)
	 * @param PriRpAmdtSmryVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelAmendmentSummary(PriRpAmdtSmryVO vo,SignOnUserAccount account) throws EventException;
	
	/**
	 * when automatic accept canceling, updating (Scope)
	 * @param PriRpScpAmdtSmryVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeRequestCancelAmendmentSummary(PriRpScpAmdtSmryVO vo,SignOnUserAccount account) throws EventException;	

	/**
	 * setting all Scope state with INIT<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAllScopeStatus(PriRpScpMnVO priRpScpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * in case of Proposal's state = Init and canceling Initial state, modifying Main Expire Date <br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalMainExpiryCancel(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * when Init Canceling, all data deleting<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * when Init Canceling, all data deleting<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalforContract(PriRpHdrVO priRpHdrVO, PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * when Init Canceling, deleting data about this Amend seq <br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalProgress(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * when Init canceling, deleting data about this Amend seq <br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalAmdtSmry(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * when Init canceling, deleting data about this Amend seq<br>
	 * 
	 * @param priRpScpMnVO PriRpScpMnVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeProposalScopeMain(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * in case of Proposal's state = Init and canceling Initial state, modifying Main Expire Date <br>
	 * 
	 * @param priRpScpMnVO PriRpScpMnVO
     * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageProposalScopeMainExpiryCancel(PriRpScpMnVO priRpScpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
     * Proposal Main Amendment Summary modifying <br>
	 * 
	 * @param PriRpAmdtSmryVO vo
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalAmendmentSummary(PriRpAmdtSmryVO vo,SignOnUserAccount account) throws EventException;	
	
	/**
     * when changing Terms's state, modifying Terms Summary by scope <br>
	 * 
	 * @param PriRpScpAmdtSmryVO vo
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeAmendmentSummary(PriRpScpAmdtSmryVO vo,SignOnUserAccount account) throws EventException;			
	
	/**
	 * checking all TERMS ACCEPT <br>
	 * 
	 * @param PriRpScpMnVO  priRpScpMn
	 * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeAcceptCheck(PriRpScpMnVO  priRpScpMn) throws EventException;		
	
	/**
     * modifying scope state by scope<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyScopeStatus(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException;		
	
	/**
	 * in case of Returned in terms, setting Scope's state = Returned<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeAutoScopeReturnStatus(PriRpScpMnVO priRpScpMnVO,SignOnUserAccount account) throws EventException;	
	
    /**
     * Proposal  Main's Status updating<br>
     * 
     * @param PriRpMnVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyMainStatus (PriRpMnVO vo, SignOnUserAccount account) throws EventException ;
    
	/**
     * MAIN's  Expire Date modifying<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalMainExpiry(PriRpMnVO priRpMnVO,SignOnUserAccount account)	 throws EventException;	
	
	/**
     * Scope MAIN's  Expire Date modifying<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeMainExpiry(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * when changing DURATION, SCOPE MAIN  Expire Date modifying<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeProposalScopeMainExpiry(PriRpScpMnVO priRpScpMnVO,SignOnUserAccount account) throws EventException;	
	
	/**
     * creating Amend Data in RFA Main <br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * in case of c/offer in terms, retrieving returned data<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltReturnVO>
	 * @exception EventException
	 */
	public List<RsltReturnVO> searchProposalReturnedList(PriRpMnVO priRpMnVO) throws EventException;
	
    /**
     * updating Proposal  Main's Status from Returned to Request <br>
     * 
     * @param PriRpMnVO vo
     * @param SignOnUserAccount account
     * @return int
     * @exception EventException
     */
    public int changeAutoRequestMainStatus (PriRpMnVO vo, SignOnUserAccount account) throws EventException ;
    
	/**
	 * when Amending, automatically modifying duration's amenddentSummary<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalAmendmentSummaryDuration(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * when Approve Canceling, setting Main,Scope Expire Date to previous Approve value<br>
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalApproveCancel(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;
		
	/**
	 * when Request, getting DEM/DET Exception's Status for validation<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<DmtScExptVerVO>
	 * @exception EventException
	 */
	public List<DmtScExptVerVO> searchCheckDmdtList(PriRpMnVO priRpMnVO) throws EventException;	
	
	/**
	 * retrieving Duration(Main,Scope) and Dem/Det change<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCheckDurationList(PriRpMnVO priRpMnVO) throws EventException;			
	
	
	/**
	 * retrieving Amend History Main <br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @return List<RsltPriRpAmdHstMnVO>
	 * @exception EventException
	 */
	public List<RsltPriRpAmdHstMnVO> searchAmendmentHistoryMain(PriRpHdrVO priRpHdrVO) throws EventException;	
	
	/**
	 * retrieving Amend History Scope List <br>
	 * 
	 * @param CstShHistVO CstShHistVO
	 * @return List<RsltAmdtHisMnVO>
	 * @exception EventException
	 */
	public List<RsltAmdtHisMnVO> searchAmendmentHistoryList(CstShHistVO cstShHistVO) throws EventException;
	
	/**
	 * retrieving Amended Terms
	 * @param PriRpMnVO priRpMnVO
	 * @return List<PriSpScpGrpLocDtlVO>
	 * @exception EventException
	 */	
	public List<RsltPropScpAmdtSmryVO> searchHistoryAmendTermList(PriRpMnVO priRpMnVO) throws EventException ;
	
	/**
     * retrieving modified data in Terms <br>
	 * 
	 * @param CstShHistVO cstShHistVO
	 * @return List<RsltPropScpAmdtSmryVO> 
	 * @exception EventException
	 */
	public List<RsltPropScpAmdtSmryVO> searchAmendmentHistorySummary(CstShHistVO cstShHistVO) throws EventException;	
	
	/**
	 * retrieving all scope by Proposal No.
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */	
	public List<RsltCdListVO> searchHistoryScopeList(PriRpMnVO priRpMnVO) throws EventException ;	

    /**
     * retrieving RFA Proposal Affiliate's Copy<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @return List<RsltRfaPropCopyVO>
     * @exception EventException
     */
    public List<RsltRfaPropCopyVO> searchProposalCopyAfilList (RsltRfaPropCopyVO rsltRfaPropCopyVO) throws EventException;

    /**
     * retrieving RFA Proposal Main / Scope's Copy <br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @return List<RsltRfaPropCopyVO>
     * @exception EventException
     */
    public List<RsltRfaPropCopyVO> searchProposalCopyList (RsltRfaPropCopyVO rsltRfaPropCopyVO) throws EventException;

    /**
     * when RFA Proposal Copy, retrieving new Proposal Number<br>
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String searchMaxPropNo (SignOnUserAccount account) throws EventException;

    /**
     * RFA Proposal Main Copy <br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalMain(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException;

    /**
     * RFA Proposal Main Amendment Summary modifying<br>
     * 
     * @param PriRpAmdtSmryVO priRpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalAmendmentSummaryAll(PriRpAmdtSmryVO priRpAmdtSmryVO, SignOnUserAccount account) throws EventException;

    /**
     * RFA Proposal Scope Copy <br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeMain(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * RFA Proposal Scope Amendment Summary modifying<br>
     * 
     * @param RsltRfaPropCopyVO[] vos
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeAmdtSmry(RsltRfaPropCopyVO[] vos, SignOnUserAccount account) throws EventException;

    /**
     * Proposal Request saving <br>
     * 
     * @param PriRpAproRqstRefUsrVO[] priRpAproRqstRefUsrVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalRequestMessage(PriRpAproRqstRefUsrVO[] priRpAproRqstRefUsrVOs, SignOnUserAccount account) throws EventException;

    /**
     * Proposal Request state modifying<br>
     * 
     * @param PriRpAproRqstRefVO priRpAproRqstRefVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyProposalRequestStatus(PriRpAproRqstRefVO priRpAproRqstRefVO, SignOnUserAccount account) throws EventException;

    /**
     * retrieving Proposal Request for RFA approve<br>
     * 
     * @param RsltRfaAproRqstRefVO rsltRfaAproRqstRefVO
     * @return List<RsltRfaAproRqstRefVO>
     * @exception EventException
     */
    public List<RsltRfaAproRqstRefVO> searchProposalRequestList (RsltRfaAproRqstRefVO rsltRfaAproRqstRefVO) throws EventException;
    
    /**
     * Proposal & Amendment Search List retrieving<br>
     *
     * @param CstShRInqVO cstShRInqVO
     * @return List<RsltPriRpInqVO>
     * @exception EventException
     */
    public List<RsltPriRpInqVO> searchProposalMainInquiryList(CstShRInqVO cstShRInqVO) throws EventException;

    /**
     * Proposal & Amendment retrieving<br>
     *
     * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
     * @return RsltPropInqListVO
     * @exception EventException
     */
    public RsltPropInqListVO searchProposalMainInquiry(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;

    /**
     * retrieving Customer <br>
     *
     * @param PriSpCtrtPtyVO prispCtrtPtyVO
     * @return List<RsltPropCustInfoVO>
     * @exception EventException
     */
    public List<RsltPropCustInfoVO> searchProposalCustomerInfoInquiry(PriSpCtrtPtyVO prispCtrtPtyVO) throws EventException;

    /**
     * retrieving Terms data<br>
     *
     * @param PriRpScpAmdtSmryVO priRpScpAmdtSmryVO
     * @return List<RsltPropScpAmdtSmryVO>
     * @exception EventException
     */
    public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummaryInquiry(PriRpScpAmdtSmryVO priRpScpAmdtSmryVO) throws EventException;    

	/**
	 * when Approval Cancel, retrieving RFA NO. using on BKG<br>
	 * @param CstApprovalVO cstApprovalVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchApprovalCancelCheck(CstApprovalVO cstApprovalVO) throws EventException;    

    /**
     * retrieving Guideline Copy target<br>
     *
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
     * @return List<RpScpGlineCopyVO>
     * @exception EventException
     */
    public List<RpScpGlineCopyVO> searchGuidelineCopyCheck(RpScpGlineCopyVO rpScpGlineCopyVO) throws EventException;

    /**
     * getting Guideline's gline_seq to Copy <br>
     *
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
     * @return String
     * @exception EventException
     */
    public String searchCopyGlineSeq(RpScpGlineCopyVO rpScpGlineCopyVO) throws EventException;

    /**
     * updating Proposal Scope Amendment Summary <br>
     * 
     * @param RpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineScopeAmdtSmry(RpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;
    
    /**
     * creating RFA Proposal Main based on copied PRS<br>
     * 
     * @param RsltCopyToProposalVO vo
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    //public void copyToProposalBase(RsltCopyToProposalVO vo, SignOnUserAccount account) throws EventException;

    
    /**
     * retrieving PRS CM Data <br>
     *
     * @param PriRpMnVO priRpMnVO
     * @return List<RsltRfaPRSCMDataVO>
     * @exception EventException
     */
//    public List<RsltRfaPRSCMDataVO> searchProposalMainPRSCMData(PriRpMnVO priRpMnVO) throws EventException ;  	 
    
    /**
     * retrieving Main's state<br>
     *
     * @param PriRpMnVO priRpMnVO
     * @return List<RsltRfaMainStsVO> 
     * @exception EventException
     */
    public List<RsltRfaMainStsVO> searchProposalMainStatus(PriRpMnVO priRpMnVO) throws EventException;
    
	/**
	 * deleting RFA Main <br>
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRemove(RfaPropMnVO rfaPropMnVO,SignOnUserAccount account) throws EventException;    
    
	
	/**
     * Proposal Main Amendment Summary modifying <br>
	 * 
	 * @param PriRpAmdtSmryVO vo
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAmendmentSummary(PriRpAmdtSmryVO vo,SignOnUserAccount account) throws EventException;	
	
	/**
     * when changing Terms's state, Terms Summary modifying by Scope  <br>
	 * 
	 * @param PriRpScpAmdtSmryVO vo
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageScopeAmendmentSummary(PriRpScpAmdtSmryVO vo,SignOnUserAccount account) throws EventException;		
	
	
    /**
     * retrieving Scope by Proposal No.,Amend Seq 
     * @param PriRpMnVO priRpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchScopeList(PriRpMnVO priRpMnVO) throws EventException ;		
    
    /**
     * when Rate Save, updating Scope table about Main's PRS Calc <br>
     * 
     * @param PriRpScpMnVO priRpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
//    public void updatePrsCalcFlgOnSaveRt(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * when C/Offer/Request Cancel, modifying Rate  CALCULATE  Flag <br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRateCalcFlag(PriRpScpMnVO priRpScpMnVO,SignOnUserAccount account) throws EventException;
	
    /**
     * when Reqeust Cancel, checking existence of Accept, Returned data<br>
     * @param PriRpMnVO priRpMnVO
     * @return List<CstRequestCheckVO>
     * @exception EventException
     */
    public List<CstRequestCheckVO> searchProposalRequestCancelCheck(PriRpMnVO priRpMnVO) throws EventException;	
    
    /**
     * check the RFA No. to exists<br>
     * @param PriRpHdrVO priRpHdrVo
     * @return String : Y/N
     * @exception EventException
     * @LastModifyDate : 2014.11.04
     */
    public String checkRFAno(PriRpHdrVO priRpHdrVo) throws EventException;
	
}