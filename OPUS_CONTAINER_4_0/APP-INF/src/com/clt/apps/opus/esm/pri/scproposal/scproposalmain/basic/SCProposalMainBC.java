/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainBC.java
*@FileTitle : Proposal & Amendment Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.RsltReturnVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.ChkScNoVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.CstPriSpHdrVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.CstPriSpMnFileDtVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.CstPriSpMnFileVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.CstRequestCheckVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.CstShHistVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.CstShInqVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.PriEdiScGenInfVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RequestCheckForCalculationVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltAmdtHisMnVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltExpChkVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltMainStsVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPriSgGrpCmdtVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPriSpAmdHstMnVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPriSpInqVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropAmdtListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropAmdtSmryVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCustInfoVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropInqListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropMnScpListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropScpAmdtSmryVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltStatusVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.ScPropProgVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SchCustVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgGrpCmdtVO;
import com.clt.syscommon.common.table.PriSpAmdtSmryVO;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;
import com.clt.syscommon.common.table.PriSpHdrVO;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpProgVO;
import com.clt.syscommon.common.table.PriSpScpAmdtSmryVO;
import com.clt.syscommon.common.table.PriSpScpDurVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpProgVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Scproposal<br>
 *
 * @author 
 * @see Esm_pri_0003EventResponse 
 * @since J2EE 1.4
 */

public interface SCProposalMainBC {
    /**
     * Retrieving S/C Proposal Master Creation's data.<br>
     *
     * @param PriSpHdrVO priSpHdrVO
     * @param SignOnUserAccount account
     * @return RsltPropListVO
     * @exception EventException
     */
    public RsltPropListVO searchProposalMain(PriSpHdrVO priSpHdrVO, SignOnUserAccount account) throws EventException;

    /**
     * Saving S/C Proposal Master Creation's data.<br>
     *
     * @param ScPropMnVO scPropMnVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String manageProposal(ScPropMnVO scPropMnVO,SignOnUserAccount account) throws EventException;

    /**
     * Retrieving Amend Request information.<br>
     *
     * @param PriSpHdrVO priSpHdrVO
     * @return List<RsltPropAmdtListVO>
     * @exception EventException
     */
    public List<RsltPropAmdtListVO> searchProposalAmendList(PriSpHdrVO priSpHdrVO) throws EventException;

	/**
	 * Requesting Amend Request<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;

    /**
	 * Retrieving TPW Group Commodity Guideline Effective Date <br>
     *
     * @param rsltPriSgGrpCmdtVO   RsltPriSgGrpCmdtVO
     * @return PriSpScpMnVO
     * @exception EventException
     */
//  public PriSpScpMnVO searchGRIGroupCommodityEffectiveDt (RsltPriSgGrpCmdtVO rsltPriSgGrpCmdtVO) throws EventException;

    /**
	 * Retrieving TPW Group Commodity Guideline List <br>
     *
     * @param RsltPriSgGrpCmdtVO rsltPriSgGrpCmdtVO
     * @return List<PriSgGrpCmdtVO>
     * @exception EventException
     */
    public List<PriSgGrpCmdtVO> searchGRIGroupCommodityList (RsltPriSgGrpCmdtVO rsltPriSgGrpCmdtVO) throws EventException;
    
    /**
     * Modifying S/C Proposal Master Creation's status<br>
     *
     * @param ScPropProgVO scPropProgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void counterofferProposal(ScPropProgVO scPropProgVO,SignOnUserAccount account) throws EventException;
    
    /**
     * Changing S/C Proposal Master Creation's status to Approve.<br>
     *
     * @param ScPropProgVO scPropProgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void approveProposal(ScPropProgVO scPropProgVO,SignOnUserAccount account) throws EventException;
    
    /**
     * Changing S/C Proposal Master Creation's status to previous status.<br>
     *
     * @param ScPropProgVO scPropProgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelProposal(ScPropProgVO scPropProgVO,SignOnUserAccount account) throws EventException;
    
    /**
     * Modifying terms summary information by scope when modifying terms data<br>
     *
     * @param PriSpScpAmdtSmryVO priSpScpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalScopeAmendmentSummary(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO,SignOnUserAccount account) throws EventException;
    
    /**
     * Modifying terms summary information by scope when modifying terms status<br>
     *
     * @param PriSpScpAmdtSmryVO priSpScpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageScopeAmendmentSummary(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO,SignOnUserAccount account) throws EventException;    
    
    /**
     * Modifying summary information about auto-accepted items when requesting S/C Proposal Request.<br>
     *
     * @param PriSpScpAmdtSmryVO priSpScpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalScopeAutoAcceptAmendmentSummary(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO,SignOnUserAccount account) throws EventException;
    
    /**
     *Rollback auto-accepted items to previous status when canceling Request(Scope)<br>
     *
     * @param PriSpScpAmdtSmryVO priSpScpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalScopeRequestCancelAmendmentSummary(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO,SignOnUserAccount account) throws EventException;
    
    /**
     *  Rollback auto-accepted items to previous status when canceling Request(Scope)<br>
     *
     * @param PriSpScpAmdtSmryVO priSpScpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalAutoScopeRequestCancelAmendmentSummary(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO,SignOnUserAccount account) throws EventException;    
    
    /**
     *  Modifying terms summary information when modifying Terms status<br>
     *
     * @param PriSpAmdtSmryVO priSpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalAmendmentSummary(PriSpAmdtSmryVO priSpAmdtSmryVO,SignOnUserAccount account) throws EventException;
   
    /**
     * Modifying terms summary information when modifying Terms status<.<br> 
     * Modifying main's status to "request" inf all terms is accepted in case main's status is "returned"<br>
     *
     * @param PriSpAmdtSmryVO priSpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageAmendmentSummary(PriSpAmdtSmryVO priSpAmdtSmryVO,SignOnUserAccount account) throws EventException;    
    
 
    /**
     *Rollbacking auto-accepted items to "init" status when canceling Request<br>

     * @param PriSpAmdtSmryVO priSpAmdtSmryVO
     * @param List<String> termList
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalAutoRequestCancelAmendmentSummary(PriSpAmdtSmryVO priSpAmdtSmryVO,List<String> termList,SignOnUserAccount account) throws EventException;    
    
    /**
     *  Modifying accept status when cancelling Request<br>
     * @param PriSpAmdtSmryVO priSpAmdtSmryVO
     * @param List<String> termList
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyProposalAutoAcceptAmendmentSummary(PriSpAmdtSmryVO priSpAmdtSmryVO,List<String> termList, SignOnUserAccount account) throws EventException;

    /**
     * Retrieving S/C Proposal Boiler Plate/Affiliate's Copied information.<br>
     *
     * @param RsltPropCopyVO rsltPropCopyVO
     * @return List<RsltPropCopyVO>
     * @exception EventException
     */
    public List<RsltPropCopyVO> searchProposalCopyBlplAfilList (RsltPropCopyVO rsltPropCopyVO) throws EventException;

    /**
     * Retrieving S/C Proposal Main/Scope's Copy information .<br>
     *
     * @param RsltPropCopyVO rsltPropCopyVO
     * @return List<RsltPropCopyVO>
     * @exception EventException
     */
    public List<RsltPropCopyVO> searchProposalCopyList (RsltPropCopyVO rsltPropCopyVO) throws EventException;

    /**
	 *  Retrieving S/C Proposal Customer information.<br>
     *
     * @param SchCustVO schCustVO
     * @return List<RsltPropCustInfoVO>
     * @exception EventException
     */
    public List<RsltPropCustInfoVO> searchProposalCustomerInfo(SchCustVO schCustVO) throws EventException;

    /**
     * Copying Proposal Main data.<br>
     *
     * @param RsltPropCopyVO rsltPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalMain(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException;

    /**
     * Amending Proposal Main Amendment Summary .<br>
     *
     * @param PriSpAmdtSmryVO priSpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalAmendmentSummaryAll(PriSpAmdtSmryVO priSpAmdtSmryVO, SignOnUserAccount account) throws EventException;

    /**
     * Retrieving new proposal number when copying S/C Proposal<br>
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String searchMaxPropNo(SignOnUserAccount account) throws EventException;

    /**
     * Retrieving Terms's Summary information<br>
     *
     * @param PriSpAmdtSmryVO priSpAmdtSmryVO
     * @return List<RsltPropAmdtSmryVO>
     * @exception EventException
     */
    public List<RsltPropAmdtSmryVO> searchProposalAmendmentSummary(PriSpAmdtSmryVO priSpAmdtSmryVO) throws EventException;

    /**
     * Retrieving Scope Terms's Summary information<br>
     *
     * @param PriSpScpAmdtSmryVO priSpScpAmdtSmryVO
     * @return List<RsltPropScpAmdtSmryVO>
     * @exception EventException
     */
    public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummary(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO) throws EventException;

    /**
     * Copying S/C Proposal Scope information<br>
     *
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeMain(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * Saving Proposal Scope Amendment Summary data<br>
     *
     * @param RsltPropCopyVO[] vos
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeAmdtSmry(RsltPropCopyVO[] vos, SignOnUserAccount account) throws EventException;

    /**
     * Retrieving informations to be copied for guideline<br>
     *
     * @param SpScpGlineCopyVO spScpGlineCopyVO
     * @return List<SpScpGlineCopyVO>
     * @exception EventException
     */
    public List<SpScpGlineCopyVO> searchGuidelineCopyCheck(SpScpGlineCopyVO spScpGlineCopyVO) throws EventException;

    /**
     * Request gline_seq of guideline to be copied<br>
     *
     * @param SpScpGlineCopyVO spScpGlineCopyVO
     * @return String
     * @exception EventException
     */
    public String searchCopyGlineSeq(SpScpGlineCopyVO spScpGlineCopyVO) throws EventException;

    /**
     * Updating Proposal Scope Main's note_hdr_seq column.<br>
     *
     * @param SpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyScpMnNoteHdrSeqGlineCopy (SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * Updating Proposal Scope Amendment Summary <br>
     *
     * @param SpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineScopeAmdtSmry(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * Checking whether terms is accepted or not to modify Main's status to Approve<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<PriSpMnVO> 
     * @exception EventException
     */
    public List<PriSpMnVO> searchProposalAcceptCheck(PriSpMnVO priSpMnVO) throws EventException;


    /**
     * Retrieving Main's status.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltMainStsVO> 
     * @exception EventException
     */
    public List<RsltMainStsVO> searchProposalMainStatus(PriSpMnVO priSpMnVO) throws EventException;
    
    /**
     * modifying Scope status by Scope<br>
     *
     * @param PriSpScpMnVO[] priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyScopeStatus(PriSpScpMnVO[] priSpScpMnVO,SignOnUserAccount account) throws EventException;

    /**
     *Modifying Scope status.<br>
     *
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyAllScopeStatus(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * Updating Proposal Main's  Status column.<br>
     *
     * @param PriSpMnVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyMainStatus (PriSpMnVO vo, SignOnUserAccount account) throws EventException ;

    /**
     * Checking whether all terms is accepted or not <br>
     *
     * @param PriSpScpMnVO  priSpScpMn
     * @return int
     * @exception EventException
     */
    public int searchProposalScopeAcceptCheck(PriSpScpMnVO  priSpScpMn) throws EventException;

    /**
     * Retrieving Scope's status.<br><br>
     *
     * @param PriSpScpMnVO  priSpScpMn
     * @return List<PriSpScpMnVO>
     * @exception EventException
     */
    public List<PriSpScpMnVO> searchProposalScopeStatusCheck(PriSpScpMnVO  priSpScpMn) throws EventException;

    /**
     * Deleting all related data when related amend seq when deleting Scope<br>
     *
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void removeProposalScopeAmdtSmry(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;
    /**
     * Deleteing all data with related amend seq when canceling init<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void removeProposalAmdtSmry(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;

    /**
     * Deleteing all data with related amend seq when deleting scope <br>
     *
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void removeProposalScopeProgress(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;
    /**
     * Deleteing all data with related amend seq when canceling init <br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void removeProposalProgress(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;
    /**
     *  Deleteing all data with related amend seq when canceling init <br>
     *
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void removeProposalScopeMain(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;

    /**
     * Retrieving current filed data and previous filed date<br>
     *
     * @param CstPriSpMnFileDtVO cstPriSpMnFileDtVO
     * @param SignOnUserAccount account
     * @return List<CstPriSpMnFileDtVO>
     * @exception EventException
     */
    public List<CstPriSpMnFileDtVO> searchProposalFilingList(CstPriSpMnFileDtVO cstPriSpMnFileDtVO, SignOnUserAccount account) throws EventException;

    /**
     * Filing Proposal<br>
     *
     * @param CstPriSpMnFileVO cstPriSpMnFileVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalFiling(CstPriSpMnFileVO cstPriSpMnFileVO, SignOnUserAccount account) throws EventException;

    /**
     *  Retrieving Proposal Scope List<br>
     *
     * @param PriSpHdrVO priSpHdrVO
     * @param SignOnUserAccount account
     * @return List<RsltPropMnScpListVO>
     * @exception EventException
     */
    public List<RsltPropMnScpListVO> searchProposalMainScpList(PriSpHdrVO priSpHdrVO, SignOnUserAccount account) throws EventException ;

    /**
     * Checking whether terms with "init" exists or not to put in action C/offer<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltStatusVO>
     * @exception EventException
     */
    public List<RsltStatusVO> searchCountOfferStatus(PriSpMnVO priSpMnVO) throws EventException;

    /**
     *Checking whether terms data exists or not when deleting Scope<br>
     *
     * @param PriSpScpMnVO  priSpScpMn
     * @return int
     * @exception EventException
     */
    public int searchProposalScopeDeleteCheck(PriSpScpMnVO  priSpScpMn) throws EventException;

    /**
     * Saving S/C Number<br>
     * @param PriSpHdrVO priSpHdrVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void createaProposalSCNumber (PriSpHdrVO priSpHdrVO,SignOnUserAccount account) throws EventException;

    /**
     * Checking duplication before saving S/C Number <br>
     *
     * @param PriSpHdrVO priSpHdrVO
     * @return List<PriSpHdrVO>
     * @throws DAOException
     */
    public List<PriSpHdrVO> checkProposalSCNumber (PriSpHdrVO priSpHdrVO) throws EventException;
    
    /**
     * Retrieving whether S/C Number PreFix is valid or not. <br>
     *
     * @param CstPriSpHdrVO cstPriSpHdrVO
     * @return List<CstPriSpHdrVO>
     * @throws DAOException
     */
    public List<CstPriSpHdrVO> checkProposalPreFixNumber (CstPriSpHdrVO cstPriSpHdrVO) throws EventException;

    /**
     * Retrieving mandatory data on Reqeust time<br>
     * @param PriSpMnVO priSpMnVO
     * @return List<CstRequestCheckVO>
     * @exception EventException
     */
    public List<CstRequestCheckVO> searchRequestTermsCheck(PriSpMnVO priSpMnVO) throws EventException;

    
	
	/**
     * Retrieving scopes without canclucation when Reqeusting<br>
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @return List<RequestCheckForCalculationVO>
	 * @exception EventException
	 */
	public List<RequestCheckForCalculationVO> searchRequestCheckCalculate(PriSpScpMnVO priSpScpMnVO) throws EventException ;
	
	/**
	 * Deleting all data when canceling init<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalforContract(PriSpHdrVO priSpHdrVO, PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;
	
    /**
     * Deleting all data when canceling init<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void removeProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;

    /**
     * Modifying expire date in case filing date is later when proposaling and filing.<br>
     *
     * @param PriSpScpDurVO priSpScpDurVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalTerms(PriSpScpDurVO priSpScpDurVO,SignOnUserAccount account) throws EventException;

    /**
     *  Modifying exp_dt with previous amend sequence when filing<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyProposalPreTerms(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * Modifying MAIN's Expire Date.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalMainExpiry(PriSpMnVO priSpMnVO,SignOnUserAccount account)  throws EventException;

    /**
     * Modifying  Scope MAIN's Expire Date when modifying duration<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalScopeMainExpiry(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * Retrieving S/C No to be added.<br>
     * @param CstPriSpHdrVO cstPriSpHdrVO
     * @return List<CstPriSpHdrVO>
     * @exception EventException
     */
    public List<CstPriSpHdrVO> searchProposalSCNumberMain(CstPriSpHdrVO cstPriSpHdrVO) throws EventException;

    /**
	   * Modifying Scope Main Expire Date in case that Proposal's status is Init and  Initial status is canceled.<br>
     *
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalScopeMainExpiryCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException;

    /**
	   * Modifying main expire data when canceling inital status in case of init Proposal status.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalMainExpiryCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * Changing scope's status to "returned" in case there is "Returned" in Terms<br>
     *
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void changeAutoScopeReturnStatus(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException;

    /**
     *Applying S/C Proposal Master to Proposal<br>
     *
     * @param PriSpHdrVO priSpHdrVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void confirmMasterProposal(PriSpHdrVO priSpHdrVO, SignOnUserAccount account) throws EventException;

    /**
     * Modifying Proposal Main's Boiler Plate Header Seq<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalMainBoilerPlateSeq(PriSpMnVO priSpMnVO,SignOnUserAccount account)  throws EventException;

    /**
	   * Modifying  SCOPE MAIN  Expire Date when modifying DURATION.<br>
     *
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void changeProposalScopeMainExpiry(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * Checking duplication of S/C no when creating S/C Master<br>
     *
     * @param PriSpHdrVO priSpHdrVO
     * @return boolean
     * @exception EventException
     */
    public boolean checkScNumberDup(PriSpHdrVO priSpHdrVO) throws EventException;

    /**
     *  Checking  S/C Number Prefix compatibility when creating S/C Master<br>
     *
     * @param ChkScNoVO chkScNoVO
     * @return String
     * @exception EventException
     */
    public String checkScNumberPrefix(ChkScNoVO chkScNoVO) throws EventException;

    /**
     * Retrieving "Returned" data in terms with c/offer<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltReturnVO>
     * @exception EventException
     */
    public List<RsltReturnVO> searchProposalReturnedList(PriSpMnVO priSpMnVO) throws EventException;

    /**
     * Updating Proposal  Main's Status column from Returned to Request<br>
     *
     * @param PriSpMnVO vo
     * @param SignOnUserAccount account 
     * @return int
     * @exception EventException
     */
    public int changeAutoRequestMainStatus (PriSpMnVO vo, SignOnUserAccount account) throws EventException ;

    /**
     * Getting  DEM/DET Exception's Status to validate when approving<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchCheckDmdtList(PriSpMnVO priSpMnVO) throws EventException ;

    /**
     * Retrieving Amend History Main information<br>
     *
     * @param PriSpHdrVO priSpHdrVO
     * @return List<RsltPriSpAmdHstMnVO>
     * @exception EventException
     */
    public List<RsltPriSpAmdHstMnVO> searchAmendmentHistoryMain(PriSpHdrVO priSpHdrVO) throws EventException;

    /**
     * Retrieving Amend History Scope List information<br>
     *
     * @param CstShHistVO CstShHistVO
     * @return List<RsltAmdtHisMnVO>
     * @exception EventException
     */
    public List<RsltAmdtHisMnVO> searchAmendmentHistoryList(CstShHistVO cstShHistVO) throws EventException;

    /**
     *  Retrieving Amended Terms
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltPropScpAmdtSmryVO>
     * @exception EventException
     */
    public List<RsltPropScpAmdtSmryVO> searchHistoryAmendTermList(PriSpMnVO priSpMnVO) throws EventException ;
    
    /**
     *  Retrieving all scope by Proposal No.
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchHistoryScopeList(PriSpMnVO priSpMnVO) throws EventException ;

    /**
     * Retrieving whether modified information in each terms exists or not<br>
     *
     * @param CstShHistVO cstShHistVO
     * @return List<RsltPropScpAmdtSmryVO>
     * @exception EventException
     */
    public List<RsltPropScpAmdtSmryVO> searchAmendmentHistorySummary(CstShHistVO cstShHistVO) throws EventException;

    /**
     * retrieving scope with duration expire date before inputted file date to valiate main, scope when Filing<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltExpChkVO>
     * @exception EventException
     */
    public List<RsltExpChkVO> searchExpireDateCheck(PriSpMnVO priSpMnVO) throws EventException;

    /**
     * Retrieving Proposal & Amendment Search List .<br>
     *
     * @param CstShInqVO cstShInqVO
     * @return List<RsltPriSpInqVO>
     * @exception EventException
     */
    public List<RsltPriSpInqVO> searchProposalMainInquiryList(CstShInqVO cstShInqVO) throws EventException;

    /**
     * Retrieving Proposal & Amendment .<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @return RsltPropInqListVO
     * @exception EventException
     */
    public RsltPropInqListVO searchProposalMainInquiry(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;

    /**
     * Retrieving Customer information.<br>
     *
     * @param PriSpCtrtPtyVO priSpCtrtPtyVO
     * @return List<RsltPropCustInfoVO>
     * @exception EventException
     */
    public List<RsltPropCustInfoVO> searchProposalCustomerInfoInquiry(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException;

    /**
     * Checking whether terms's data in summary table is modified or not<br>
     *
     * @param PriSpScpAmdtSmryVO priSpScpAmdtSmryVO
     * @return List<RsltPropScpAmdtSmryVO>
     * @exception EventException
     */
    public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummaryInquiry(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO) throws EventException;
    
    /**
     * Retrieving Commodity Group,Rate,Standard Note의 data in case of modifying cutomer type<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchProposalMainCustTypeChkList(PriSpMnVO priSpMnVO) throws EventException ;    
    
    /**
	 * COPY TO PROPOSAL BASE<br>
	 * 
	 * @param RsltCopyToProposalVO rsltCopyToProposalVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	/*public void copyToProposalBase(RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) 
		throws EventException;
	*/

    /**
	 * Retrieving  HEADER SEQ information when copying Guideline Standard Note information<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @param String isCopy
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyNoteHeaderSeq(PriSpScpNoteListVO priSpScpNoteListVO, String isCopy, SignOnUserAccount account) throws EventException;
	
	/**
	 * Running BackEndJob to retrieve Performance.<br>
     *
	 * @param SignOnUserAccount account
	 * @param PriSpMnVO priSpMnVO
	 * @return String
	 * @exception EventException
	 */
//	public String searchSCPerformanceDoStart(SignOnUserAccount account, PriSpMnVO priSpMnVO) throws EventException;
	
	/**
	 * retrieving status value for BackEndJob result<br>
	 * 
	 * @param String object
	 * @return String
	 * @exception EventException
	 */
//	public String comBakEndJbVOs(String object) throws EventException;	
	    
    /**
     * Modifying Conversion Flag<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void changeConversionFlg (PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException ;   
    
	/**
	 * Retrieving DEM/DET data for validation when canceling "init"<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalMainInitCancelCheck(PriSpMnVO priSpMnVO) throws EventException    ;
	
    /**
     * Retrieving scope by Proposal No., Amend Seq <br>
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchScopeList(PriSpMnVO priSpMnVO) throws EventException ;	
	
    /**
     * Deleting S/C Scope Main information.<br>
     *
     * @param ScPropMnVO scPropMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalRemove(ScPropMnVO scPropMnVO,SignOnUserAccount account) throws EventException;    
    
    /**
     *  Checking whether accepted or returned data exists or not when canceling Reqeust<br>
     * @param PriSpMnVO priSpMnVO
     * @return List<CstRequestCheckVO>
     * @exception EventException
     */
    public List<CstRequestCheckVO> searchProposalRequestCancelCheck(PriSpMnVO priSpMnVO) throws EventException;    
    
    /**
     * Retrieving conditions to open G/W main popup when requesting<br>
     * Not opening G/W main popup when requesting next time if cancelling request once<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchProgRequestList(PriSpMnVO priSpMnVO) throws EventException ;    
    

    /**
     * Cancelling filed S/C as hidden function to be able to run by super user<br>
     *
     * @param ScPropProgVO scPropProgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelFilingForSuperuser(ScPropProgVO scPropProgVO,SignOnUserAccount account) throws EventException;
    
    
    /**
     * (REVERT) Cancelling filed S/C<br>
     *
     * @param PriSpProgVO[] priSpProgVOs
     * @param PriSpScpProgVO[] priSpScpProgVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyProposalMainRevertState(PriSpProgVO[] priSpProgVOs, PriSpScpProgVO[] priSpScpProgVOs, SignOnUserAccount account)  throws EventException;


}