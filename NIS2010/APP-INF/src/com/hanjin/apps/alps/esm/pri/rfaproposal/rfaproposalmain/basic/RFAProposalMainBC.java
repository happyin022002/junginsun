/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainBC.java
*@FileTitle : Proposal & Amendment Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.08 변영주
* 1.0 Creation
=========================================================
* History
* 2011.04.08 김민아 [CHM-201110030-01] Approve 상태에서 Save 시 Request Office 와 Sales Rep 을 비교하여 수정 사항이 존재할 경우 EDI 호출하도록 수정
* 2013.07.08 전윤주 [CHM-201324601] RFA Request 시 Port 운임에 속한 Route (Origin, Dest) 를 체크하여 call_port_flag가 'N' 인 경우 validation 처리 
* 2013.11.07 전윤주 [CHM-201327486] File 시 Revenue Audit System 수입심사 배치대상 추가 요청
* 2013.12.20 서미진 [선처리 CSR] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
* 2014.09.15 최성환  [CHM-201431899] Guideline RFA 생성 요청 
* 2014.12.10 최성환 [CHM-201432700] Retroactive RFA Minimization관련 시스템 개발요청
* 2015.04.22 전지예 [CHM-201535165] RFA match back 팝업화면 추가
* 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)
 * 2016.05.23.CHM-201641745_[RFA 효율화를 위한 요청 (1차)] APP 오류 발견(SHA16M0374 case) 및 Service Scope validation 미적용
* 2016.07.20 [CHM-201642287] Master RFA Cancel시 Basic RFA 점검 로직 개발 요청
* =========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PriEmailTargetListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstApprovalVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstRequestCheckVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstShHistVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstShRInqVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.DmtScExptVerVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.InPrsMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.MasterInfoFromBasicVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.PriEdiRfGenInfVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.PriRpRetroVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RequestCheckForCalculationVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RequestCheckForMatchBackVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropProgVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltAmdtHisMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltCheckMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriCrmSlLdVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriRpAmdHstMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriRpInqVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropAmdtSmryVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropCustInfoVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropInqListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropScpAmdtSmryVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltReturnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaAproRqstRefByOfcVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaAproRqstRefVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaMainStsVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPRSCMDataVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltStatusVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.SchSaleLeadRfaVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.PriRpScpRtCmdtRoutSetVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRoutHdrSmryListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriRpAproRqstRefUsrVO;
import com.hanjin.syscommon.common.table.PriRpAproRqstRefVO;
import com.hanjin.syscommon.common.table.PriRpHdrVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;


/**
 * NIS2010-RFA Proposal Business Logic Command Interface<br>
 * - NIS2010-RFA Proposal에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Byeon Young Joo 
 * @see Esm_pri_0003EventResponse 참조
 * @since J2EE 1.4
 */

public interface RFAProposalMainBC {
	/**
	 *  RFA Proposal 을 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @param SignOnUserAccount account
	 * @return RsltPropListVO
	 * @exception EventException
	 */
	public RsltPropListVO searchProposalMain(PriRpHdrVO priRpHdrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  RFA Proposal 을 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @param SignOnUserAccount account
	 * @return RsltPropListVO
	 * @exception EventException
	 */
	public RsltPropListVO searchProposalMainSpot(PriRpHdrVO priRpHdrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  Master RFA Proposal 을 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @param SignOnUserAccount account
	 * @return RsltPropListVO
	 * @exception EventException
	 */
	public RsltPropListVO searchProposalMainMst(PriRpHdrVO priRpHdrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  Customer 정보를 조회합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPropCustInfoVO> 
	 * @exception EventException
	 */
	public List<RsltPropCustInfoVO> searchProposalCustomerInfo(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException;
	
	/**
	 * RFA Main을 저장 합니다.<br>
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageProposal(RfaPropMnVO rfaPropMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * RFA의 상태를 변경 합니다.<br>
	 * 
	 * @param RfaPropProgVO rfaPropProgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void counterofferProposal(RfaPropProgVO rfaPropProgVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * 자동 accept 시 SUMMARY 를 update 합니다.
	 * @param PriRpAmdtSmryVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyProposalAutoAcceptAmendmentSummary(PriRpAmdtSmryVO vo,SignOnUserAccount account) throws EventException;
	
	/**
	 * 자동 accept 시 SUMMARY 를 update 합니다.
	 * 
	 * @param PriRpScpAmdtSmryVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeAutoAcceptAmendmentSummary(PriRpScpAmdtSmryVO vo,SignOnUserAccount account) throws EventException;
	
	/**
	 * Scope이 삭제될 때 해당 Amend seq에 해당하는 모든 데이터를 삭제처리 합니다. <br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScopeAmdtSmry(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Scope이 삭제될 때 해당 Amend seq에 해당하는 모든 데이터를 삭제처리 합니다. <br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScopeProgress(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * Proposal summary를 조회 합니다.<br>
	 * 확인 후 삭제
	 * @param PriRpAmdtSmryVO priRpAmdtSmryVO
	 * @return List<RsltPropAmdtSmryVO>
	 * @exception EventException
	 */
	public List<RsltPropAmdtSmryVO> searchProposalAmendmentSummary(PriRpAmdtSmryVO priRpAmdtSmryVO) throws EventException;
	
	/**
	 * Scope Summary를 조회 합니다.<br>
	 * 
	 * @param PriRpScpAmdtSmryVO priRpScpAmdtSmryVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception EventException
	 */
	public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummary(PriRpScpAmdtSmryVO priRpScpAmdtSmryVO) throws EventException;
	
	/**
	 * Accept 가 되었는지 Terms를 조회 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<PriRpMnVO>
	 * @exception EventException
	 */
	public List<PriRpMnVO> searchProposalAcceptCheck(PriRpMnVO priRpMnVO) throws EventException;	
	
	/**
	 * C/OFFER 시 TERMS에 INIT인 데이터가 있는지 조회 합니다.<br>
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltStatusVO>
	 * @exception EventException
	 */	
	public List<RsltStatusVO> searchCountOfferStatus(PriRpMnVO priRpMnVO) throws EventException;
	
	/**
	 * Reqeust 시 필수 입력 데이터를 조회 합니다<br>
	 * @param PriRpMnVO priRpMnVO
	 * @return List<CstRequestCheckVO>
	 * @exception EventException
	 */
	public List<CstRequestCheckVO> searchRequestTermsCheck(PriRpMnVO priRpMnVO) throws EventException;
	
	
	/**
     * Reqeust 시 Calcualte를 하지 않은 scope를 조회 합니다<br>
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return List<RequestCheckForCalculationVO>
	 * @exception EventException
	 */
	public List<RequestCheckForCalculationVO> searchRequestCheckCalculate(PriRpScpMnVO priRpScpMnVO) throws EventException ;
	

	/**
     * M/B 활성화 여부를 위해 calcutae 하지 않는 scope를 가져옵니다.<br>
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return List<RequestCheckForCalculationVO>
	 * @exception EventException
	 */
	public List<RequestCheckForCalculationVO> searchMatchBackCheckCalculate(PriRpScpMnVO priRpScpMnVO) throws EventException ;
	
	/**
	 * Request 시 Match Back 조회 하지 않은 Scope를 조회합니다<br>
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return List<RequestCheckForMatchBackVO>
	 * @exception EventException
	 */
	public List<RequestCheckForMatchBackVO> searchRequestCheckMatchBack(PriRpScpMnVO priRpScpMnVO) throws EventException ;
	
	
	/**
	 * Scope의 상태를 조회 합니다..<br>
	 * 
	 * @param PriRpScpMnVO  priRpScpMn
     * @return List<PriRpScpMnVO>
	 * @exception EventException
	 */
	public List<PriRpScpMnVO> searchProposalScopeStatusCheck(PriRpScpMnVO  priRpScpMn) throws EventException;	

    /**
     * Sales Lead Contract Info를 CRM으로 전송합니다.<br>
     * 
     * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void transferRfaSalesLeadContractInfo(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;
    
	/**
	 * Scope삭제시 Terms의 데이터가 있는지 확인 합니다.<br>
	 * 
	 * @param PriRpScpMnVO  priRpScpMn
     * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeDeleteCheck(PriRpScpMnVO  priRpScpMn) throws EventException;	   
	
	/**
	 * RFA main의 Approve를 진행 합니다.<br>
	 * 
	 * @param RfaPropProgVO rfaPropProgVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String approveProposal(RfaPropProgVO rfaPropProgVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * RFA main Spot 의 Approve 를 진행 합니다.<br>
	 * 
	 * @param RfaPropProgVO rfaPropProgVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String approveProposalSpot(RfaPropProgVO rfaPropProgVO,SignOnUserAccount account) throws EventException;		
	
	/**
	 * Master RFA main 의 Approve를 진행합니다.<br>
	 * 
	 * @param RfaPropProgVO rfaPropProgVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String approveProposalMst(RfaPropProgVO rfaPropProgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * RFA Main의 상태를 이전 상태로 변경 합니다.<br>
	 * 
	 * @param RfaPropProgVO rfaPropProgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposal(RfaPropProgVO rfaPropProgVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * 자동 accept cancel 시 update 합니다(Main).
	 * @param PriRpAmdtSmryVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelAmendmentSummary(PriRpAmdtSmryVO vo,SignOnUserAccount account) throws EventException;
	
	/**
	 * 자동 accept cancel 시 update 합니다(Scope).<br>
	 * @param PriRpScpAmdtSmryVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeRequestCancelAmendmentSummary(PriRpScpAmdtSmryVO vo,SignOnUserAccount account) throws EventException;	

	/**
	 * Scope상태를 모두 INIT으로 변경 합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAllScopeStatus(PriRpScpMnVO priRpScpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Proposal의 상태가 Init이고 Initial상태를 Cancel 할 경우 Main Expire Date를 수정 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalMainExpiryCancel(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Init Cancel시 모든 데이터를 삭제처리 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * Init Cancel시 Amend seq에 해당하는 모든 데이터를 삭제처리 합니다. <br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalProgress(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Init Cancel시 Amend seq에 해당하는 모든 데이터를 삭제처리 합니다. <br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalAmdtSmry(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Init Cancel시 Amend seq에 해당하는 모든 데이터를 삭제처리 합니다. <br>
	 * 
	 * @param priRpScpMnVO PriRpScpMnVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeProposalScopeMain(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * Proposal의 상태가 Init이고 Initial상태를 Cancel 할 경우 Scope Main Expire Date를 수정 합니다.<br>
	 * 
	 * @param priRpScpMnVO PriRpScpMnVO
     * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageProposalScopeMainExpiryCancel(PriRpScpMnVO priRpScpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
     * Proposal Main Amendment Summary 를 수정합니다.<br>
	 * 
	 * @param PriRpAmdtSmryVO vo
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalAmendmentSummary(PriRpAmdtSmryVO vo,SignOnUserAccount account) throws EventException;	
	
	/**
     * Terms의 상태 변경 시 Scope별  Terms Summary정보를 수정 합니다.<br>
	 * 
	 * @param PriRpScpAmdtSmryVO vo
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeAmendmentSummary(PriRpScpAmdtSmryVO vo,SignOnUserAccount account) throws EventException;			
	
	/**
	 * TERMS가  모두 ACCEPT되었는지 확인 합니다.<br>
	 * 
	 * @param PriRpScpMnVO  priRpScpMn
	 * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeAcceptCheck(PriRpScpMnVO  priRpScpMn) throws EventException;		
	
	/**
     * Scope상태를 Scope별로 변경 합니다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyScopeStatus(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException;		
	
	/**
	 * Terms중 하나라도 Returned 가 있다면 Scope의 상태를 Returned로 변경 합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeAutoScopeReturnStatus(PriRpScpMnVO priRpScpMnVO,SignOnUserAccount account) throws EventException;	
	
    /**
     * Proposal  Main 의 Status 컬럼을 업데이트 합니다.<br>
     * 
     * @param PriRpMnVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyMainStatus (PriRpMnVO vo, SignOnUserAccount account) throws EventException ;
    
	/**
     * MAIN의  Expire Date를 변경 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalMainExpiry(PriRpMnVO priRpMnVO,SignOnUserAccount account)	 throws EventException;	
	
	/**
     * Scope MAIN의  Expire Date를 변경 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeMainExpiry(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * DURATION 변경시  SCOPE MAIN  Expire Date를 수정 합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeProposalScopeMainExpiry(PriRpScpMnVO priRpScpMnVO,SignOnUserAccount account) throws EventException;	
	
	/**
     * RFA Main 에 Amend Data를 생성 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * c/offer 이 있는 terms 에서 returned 인 데이터를 조회 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltReturnVO>
	 * @exception EventException
	 */
	public List<RsltReturnVO> searchProposalReturnedList(PriRpMnVO priRpMnVO) throws EventException;
	
    /**
     * Proposal  Main 의 Status 컬럼을 Returned에서 Request로 업데이트 합니다.<br>
     * 
     * @param PriRpMnVO vo
     * @param SignOnUserAccount account
     * @return int
     * @exception EventException
     */
    public int changeAutoRequestMainStatus (PriRpMnVO vo, SignOnUserAccount account) throws EventException ;
    
	/**
	 * Amend시 duration의 amenddentSummary를 자동 수정 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalAmendmentSummaryDuration(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Approve Cancel시 Main,Scope Expire Date를 Approve 이전 값으로 수정 합니다.<br>
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalApproveCancel(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;
		
	/**
	 * Request 시 validation 을 하기 위해 DEM/DET Exception의 Status를 가져온다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<DmtScExptVerVO>
	 * @exception EventException
	 */
	public List<DmtScExptVerVO> searchCheckDmdtList(PriRpMnVO priRpMnVO) throws EventException;	
	
	/**
	 * Duration(Main,Scope)과 Dem/Det 데이터가 변경 되었는지 조회 한다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCheckDurationList(PriRpMnVO priRpMnVO) throws EventException;		
	
	/**
	 *Sale Lead 정보를 조회 합니다.<br>
	 * 
	 * @param SchSaleLeadRfaVO schSaleLeadRfaVO
	 * @return List<RsltPriCrmSlLdVO>
	 * @exception EventException
	 */
	public List<RsltPriCrmSlLdVO> searchProposalMainSaleLeadList(SchSaleLeadRfaVO schSaleLeadRfaVO) throws EventException;		
	
	
	
	/**
	 * Amend History Main정보를 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @return List<RsltPriRpAmdHstMnVO>
	 * @exception EventException
	 */
	public List<RsltPriRpAmdHstMnVO> searchAmendmentHistoryMain(PriRpHdrVO priRpHdrVO) throws EventException;	
	
	/**
	 * Amend History Main Spot 정보를 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @return List<RsltPriRpAmdHstMnVO>
	 * @exception EventException
	 */
	public List<RsltPriRpAmdHstMnVO> searchAmendmentHistoryMainSpot(PriRpHdrVO priRpHdrVO) throws EventException;	
	
	/**
	 * Amend History Scope List 정보를 조회합니다.<br>
	 * 
	 * @param CstShHistVO CstShHistVO
	 * @return List<RsltAmdtHisMnVO>
	 * @exception EventException
	 */
	public List<RsltAmdtHisMnVO> searchAmendmentHistoryList(CstShHistVO cstShHistVO) throws EventException;
	
	/**
	 * Amend 된 Terms를 조회 합니다.
	 * @param PriRpMnVO priRpMnVO
	 * @return List<PriSpScpGrpLocDtlVO>
	 * @exception EventException
	 */	
	public List<RsltPropScpAmdtSmryVO> searchHistoryAmendTermList(PriRpMnVO priRpMnVO) throws EventException ;
	
	/**
     * 각 Terms에 수정된 정보가 있는 지 조회 합니다.<br>
	 * 
	 * @param CstShHistVO cstShHistVO
	 * @return List<RsltPropScpAmdtSmryVO> 
	 * @exception EventException
	 */
	public List<RsltPropScpAmdtSmryVO> searchAmendmentHistorySummary(CstShHistVO cstShHistVO) throws EventException;	
	
	/**
	 * Proposal No.에 해당 하는 모든 Scope 을 조회 합니다.
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */	
	public List<RsltCdListVO> searchHistoryScopeList(PriRpMnVO priRpMnVO) throws EventException ;	

    /**
     * RFA Proposal Affiliate 의 Copy 정보를 조회합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @return List<RsltRfaPropCopyVO>
     * @exception EventException
     */
    public List<RsltRfaPropCopyVO> searchProposalCopyAfilList (RsltRfaPropCopyVO rsltRfaPropCopyVO) throws EventException;

    /**
     * RFA Proposal Main / Scope 의 Copy 정보를 조회합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @return List<RsltRfaPropCopyVO>
     * @exception EventException
     */
    public List<RsltRfaPropCopyVO> searchProposalCopyList (RsltRfaPropCopyVO rsltRfaPropCopyVO) throws EventException;

    /**
     * RFA Proposal Copy 시 새로운 Proposal Number 를 조회합니다.<br>
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String searchMaxPropNo (SignOnUserAccount account) throws EventException;

    /**
     * RFA Proposal Main 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalMain(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException;

    /**
     * Master RFA Proposal Main 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @param SignOnUserAccount account
	 * @param String rfaTypeCode
     * @exception EventException
     */
    public void copyProposalMainMst(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account, String rfaTypeCode) throws EventException;
    
    /**
     * RFA Proposal Main Amendment Summary 를 수정합니다.<br>
     * 
     * @param PriRpAmdtSmryVO priRpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalAmendmentSummaryAll(PriRpAmdtSmryVO priRpAmdtSmryVO, SignOnUserAccount account) throws EventException;

    /**
     * RFA Proposal Scope 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeMain(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * RFA Proposal Scope Amendment Summary 정보를 수정합니다.<br>
     * 
     * @param RsltRfaPropCopyVO[] vos
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeAmdtSmry(RsltRfaPropCopyVO[] vos, SignOnUserAccount account) throws EventException;

    /**
     * Proposal Request 정보를 저장합니다.<br>
     * 
     * @param PriRpAproRqstRefUsrVO[] priRpAproRqstRefUsrVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalRequestMessage(PriRpAproRqstRefUsrVO[] priRpAproRqstRefUsrVOs, SignOnUserAccount account) throws EventException;

    /**
     * Proposal Request 상태를 수정합니다.<br>
     * 
     * @param PriRpAproRqstRefVO priRpAproRqstRefVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyProposalRequestStatus(PriRpAproRqstRefVO priRpAproRqstRefVO, SignOnUserAccount account) throws EventException;

    /**
     * RFA 승인을 위해 신청하거나 접수한 Proposal Request 를 조회합니다.<br>
     * 
     * @param RsltRfaAproRqstRefVO rsltRfaAproRqstRefVO
     * @return List<RsltRfaAproRqstRefVO>
     * @exception EventException
     */
    public List<RsltRfaAproRqstRefVO> searchProposalRequestList (RsltRfaAproRqstRefVO rsltRfaAproRqstRefVO) throws EventException;
 
    /**
     * RFA 승인을 위해 신청하거나 접수한 Proposal Request 를 [Office 대상]으로 관리할 수 있도록 조회합니다.<br>
     * 
     * @param RsltRfaAproRqstRefByOfcVO rsltRfaAproRqstRefByOfcVO
     * @return List<RsltRfaAproRqstRefByOfcVO>
     * @exception EventException
     */
    public List<RsltRfaAproRqstRefByOfcVO> searchProposalRequestByOfficeList (RsltRfaAproRqstRefByOfcVO rsltRfaAproRqstRefByOfcVO) throws EventException;
  
    
    /**
     * Proposal & Amendment Search List 를 조회 합니다.<br>
     *
     * @param CstShRInqVO cstShRInqVO
     * @return List<RsltPriRpInqVO>
     * @exception EventException
     */
    public List<RsltPriRpInqVO> searchProposalMainInquiryList(CstShRInqVO cstShRInqVO) throws EventException;
    
    /**
     * Proposal & Amendment Search List 를 조회 합니다.<br>
     *
     * @param CstShRInqVO cstShRInqVO
     * @return List<RsltPriRpInqVO>
     * @exception EventException
     */
    public List<RsltPriRpInqVO> searchProposalMainSpotInquiryList(CstShRInqVO cstShRInqVO) throws EventException;    

    /**
     * Proposal & Amendment 를 조회 합니다.<br>
     *
     * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
     * @return RsltPropInqListVO
     * @exception EventException
     */
    public RsltPropInqListVO searchProposalMainInquiry(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;
    
    /**
     * Proposal & Amendment 를 조회 합니다.<br>
     *
     * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
     * @return RsltPropInqListVO
     * @exception EventException
     */
    public RsltPropInqListVO searchProposalMainSpotInquiry(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;    

    /**
     * Customer 정보를 조회 합니다.<br>
     *
     * @param PriSpCtrtPtyVO prispCtrtPtyVO
     * @return List<RsltPropCustInfoVO>
     * @exception EventException
     */
    public List<RsltPropCustInfoVO> searchProposalCustomerInfoInquiry(PriSpCtrtPtyVO prispCtrtPtyVO) throws EventException;

    /**
     * Terms의 데이터가 있는지 조회 합니다.<br>
     *
     * @param PriRpScpAmdtSmryVO priRpScpAmdtSmryVO
     * @return List<RsltPropScpAmdtSmryVO>
     * @exception EventException
     */
    public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummaryInquiry(PriRpScpAmdtSmryVO priRpScpAmdtSmryVO) throws EventException;    

	/**
	 * Approval Cancel 시 BKG에서 사용되는 RFA NO.가 있는지 조회 합니다. <br>
	 * 데이터가 있다면 Cancel 할 수 없습니다.<br>
	 * @param CstApprovalVO cstApprovalVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchApprovalCancelCheck(CstApprovalVO cstApprovalVO) throws EventException;    

    /**
     * Guideline Copy 대상 정보를 조회합니다.<br>
     *
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
     * @return List<RpScpGlineCopyVO>
     * @exception EventException
     */
    public List<RpScpGlineCopyVO> searchGuidelineCopyCheck(RpScpGlineCopyVO rpScpGlineCopyVO) throws EventException;

    /**
     * Copy 할 Guideline 의 gline_seq 를 가져온다. <br>
     *
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
     * @return String
     * @exception EventException
     */
    public String searchCopyGlineSeq(RpScpGlineCopyVO rpScpGlineCopyVO) throws EventException;

    /**
     * Proposal Scope Amendment Summary 를 업데이트 합니다.<br>
     * 
     * @param RpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineScopeAmdtSmry(RpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;
    
    /**
     * PRS 정보를 Copy 하여 RFA Proposal Main 관련 정보를 생성합니다.<br>
     * 
     * @param RsltCopyToProposalVO vo
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void copyToProposalBase(RsltCopyToProposalVO vo, SignOnUserAccount account) throws EventException;

    /**
     * RFA General Information 을 EDI 로 전송합니다.<br>
     * 
     * @param PriEdiRfGenInfVO priEdiRfGenInfVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void transferRfaGeneralInfo (PriEdiRfGenInfVO priEdiRfGenInfVO, SignOnUserAccount account) throws EventException;
    
    /**
     * PRS CM Data를 조회합니다.<br>
     *
     * @param PriRpMnVO priRpMnVO
     * @return List<RsltRfaPRSCMDataVO>
     * @exception EventException
     */
    public List<RsltRfaPRSCMDataVO> searchProposalMainPRSCMData(PriRpMnVO priRpMnVO) throws EventException ;  	 
    
    /**
     * Main의 상태를 조회한다.<br>
     *
     * @param PriRpMnVO priRpMnVO
     * @return List<RsltRfaMainStsVO> 
     * @exception EventException
     */
    public List<RsltRfaMainStsVO> searchProposalMainStatus(PriRpMnVO priRpMnVO) throws EventException;
    
	/**
	 * RFA Main을 삭제 합니다.<br>
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRemove(RfaPropMnVO rfaPropMnVO,SignOnUserAccount account) throws EventException;    
    
	
	/**
     * Proposal Main Amendment Summary 를 수정합니다.<br>
	 * 
	 * @param PriRpAmdtSmryVO vo
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAmendmentSummary(PriRpAmdtSmryVO vo,SignOnUserAccount account) throws EventException;	
	
	/**
     * Terms의 상태 변경 시 Scope별  Terms Summary정보를 수정 합니다.<br>
	 * 
	 * @param PriRpScpAmdtSmryVO vo
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageScopeAmendmentSummary(PriRpScpAmdtSmryVO vo,SignOnUserAccount account) throws EventException;		
	
	
    /**
     * Proposal No.,Amend Seq 에 해당 하는 Scope 을 조회 합니다.
     * @param PriRpMnVO priRpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchScopeList(PriRpMnVO priRpMnVO) throws EventException ;		
    
    /**
     * Rate Save시, Scope Main의 PRS Calc 관련 테이블을 업데이트한다.<br>
     * 
     * @param PriRpScpMnVO priRpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void updatePrsCalcFlgOnSaveRt(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;

    /**
     * Rate Save시, Scope Main의 PRS MB 관련 테이블을 업데이트한다.<br>
     * 
     * @param PriRpScpMnVO priRpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void updatePrsMBFlgOnSaveRt(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * C/Offer/Request Cancel 시 Rate  CALCULATE  Flag를 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRateCalcFlag(PriRpScpMnVO priRpScpMnVO,SignOnUserAccount account) throws EventException;
	
    /**
     * 작성자가 Reqeust Cancel 시 Accept, Returned 데이터가 있는지 조회한다.<br>
     * @param PriRpMnVO priRpMnVO
     * @return List<CstRequestCheckVO>
     * @exception EventException
     */
    public List<CstRequestCheckVO> searchProposalRequestCancelCheck(PriRpMnVO priRpMnVO) throws EventException;	
	/**
	 * CM/OP View 의 Load 값이 변한것에 맞춰 scope main의 summary 값을 갱신처리 합니다.<BR>
	 * 
	 * @param PriRpScpRtCmdtRoutSetVO priRpScpRtCmdtRoutSetVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyScopeMainSummary(PriRpScpRtCmdtRoutSetVO priRpScpRtCmdtRoutSetVO, SignOnUserAccount account)  throws EventException;
	
	
    /**
     * Target MVC estimate 를 저장하지 않은 내용이 있는지 check한다..<br>
     *
     * @param InPrsMQCEstimateVO inPrsMQCEstimateVO
     * @return List<RsltCheckMQCEstimateVO>
     * @exception EventException
     */
    public List<RsltCheckMQCEstimateVO> searchCheckMQCEstimateList(InPrsMQCEstimateVO inPrsMQCEstimateVO)  throws EventException;
    

    /**
     * Target MVC estimate Popup의 List를 조회한다..<br>
     *
     * @param InPrsMQCEstimateVO inPrsMQCEstimateVO
     * @return List<RsltMQCEstimateVO>
     * @exception EventException
     */
    public List<RsltMQCEstimateVO> searchMQCEstimateList(InPrsMQCEstimateVO inPrsMQCEstimateVO)  throws EventException ;    
    
	/**
	 *  Target MVC estimate 정보를 갱신합니다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMQCEstimateList(PriRpScpMnVO[] priRpScpMnVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 *  Request Office 또는 Sales Rep 정보가 변경된 경우 EAI I/F 를 위한 정보를 조회한다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return int
	 * @exception EventException
	 */
	public int searchCheckOfcSrepDiffList(PriRpMnVO priRpMnVO) throws EventException;
	
	/**
     * RFA_NO에 해당한 PROP_NO를 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @return PriRpHdrVO
	 * @exception EventException
     */
    public PriRpHdrVO searchProposalNoFromRfaNo(PriRpHdrVO priRpHdrVO) throws EventException;
    
	/**
	 * ESM_PRI_2003 : Request Check <br>
	 * Rquest 처리시 Rate(AEE/AEW)의 FIC_PROP_RT_AMT값이 O인 값이 존재하는지 체크<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return String
	 * @exception EventException
     */
    public String searchProposalRequestIhcRateCheck(PriRpMnVO priRpMnVO) throws EventException; 
    
    /**
	 * ESM_PRI_2003 : Request Check <br>
	 * Rquest 처리 시 Port CY 운임에 Port 가 아닌 Route가 존재하는지 체크<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
     */
    public List<RsltCdListVO> searchProposalRequestPortCyCheck(PriRpMnVO priRpMnVO) throws EventException; 
    
    /**
     * RFA APPROVE 시 유저에게 G/W 메일 발송<br>
     *
     * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
     * @return List<PriEmailTargetListVO>
     * @exception EventException
     */
    public List<PriEmailTargetListVO> sendEmail(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * ESM_PRI_2003 : Requsest <br>
	 * RFA Type이 Contract 일때 마지막으로 actual customer가 commodity 별로 같은지 check<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return String
	 * @exception EventException
     */
    public String checkRfaContractTpActCust(PriRpMnVO priRpMnVO) throws EventException; 
    
	/**
	 * ESM_PRI_2003 : Requsest <br>
	 * check Duration Basic Copy<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return String
	 * @exception EventException
     */
    public String checkExpDurationBasicRFACopy(PriRpMnVO priRpMnVO) throws EventException;     
    
	/**
	 * ESM_PRI_2003 : Approve Check <br>				
	 * Approve 이전에 Retroactive 대상이 존재하는지 체크<br>		
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
     */
    public String searchRetroactiveExistCheck(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;     
    
	/**
	 * ESM_PRI_2045 : onLoad시 조회 <br>				
	 *  Approve 이전에 Retroactive RFA 사유 코드 조회<br>	
	 * 
	 * @return List<PriRpRetroVO>
	 * @exception EventException
     */
    public List<PriRpRetroVO> searchRetroactiveRFANote() throws EventException;     
    
    /**
	 * ESM_PRI_2045 : Save <br>			
	 * Retroactive RFA 사유를 저장한다.<br>		
     * 
     * @param PriRpRetroVO priRpRetroVO
     * @param SignOnUserAccount account
     * @exception EventException
     */    
    public void manageRetroactiveRFANote(PriRpRetroVO priRpRetroVO, SignOnUserAccount account) throws EventException;

    /**				
	 * ESM_PRI_2244 : Retrieve <br>			
	 * RFA Proposal Creation [Copy]를 조회한다.<br>			
	 * 			
	 * @param RsltRoutHdrSmryListVO  rsltRoutHdrSmryListVO		
	 * @return  List<RsltRoutHdrSmryListVO> 			
	 * @exception EventException			
	 */	
	public List<RsltRoutHdrSmryListVO> rfaProposalCreationCopy(RsltRoutHdrSmryListVO  rsltRoutHdrSmryListVO) throws EventException;

	/**
	 * Master RFA에서 Copy 후 RFA Main의 Duration 정보를 적용합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @param String svcScpCd
	 * @return String
	 * @exception EventException
	 */ 
	public String manageProposalMst(PriRpMnVO priRpMnVO, SignOnUserAccount account, String svcScpCd) throws EventException;
	
	/**
	 * RFA main의 Approve를 진행 합니다.<br>
	 * 
	 * @param RfaPropProgVO rfaPropProgVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String approveProposalBasic(RfaPropProgVO rfaPropProgVO,SignOnUserAccount account) throws EventException;

	/**
	 * Master RFA에서 Accept 가 되었는지 Terms를 조회 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<PriRpMnVO>
	 * @exception EventException
	 */
	public List<PriRpMnVO> searchProposalAcceptCheckMst(PriRpMnVO priRpMnVO) throws EventException;

	/**
	 * Master RFA에서 Approval Cancel 시  자식 Basic이 있는지 여부 체크 합니다. <br>
	 * 데이터가 있다면 화면에서 경고 alert 발생합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchApprovalCancelCheckChildren(PriRpHdrVO priRpHdrVO) throws EventException;
	
	/**
	 * Approved Basic RFA 조회 시 Master RFA를 체크해서 Master의 AMD No.가 변경되었는지 체크한다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return String
	 * @exception EventException
	 */
	public String checkBasicAmendable(PriRpMnVO priRpMnVO) throws EventException;

	/**
	 * Basic RFA Amend 시 승인된 최종버전 Master RFA 정보를 조회한다.<br>
	 * 
	 * @param String
	 * @return List<PriRpScpMnVO>
	 * @exception EventException
	 */
	public List<PriRpScpMnVO> searchApprovedMstInfo(String mstRfaNo) throws EventException;
    /**
     * Basic RFA의 Proposal No로 Master RFA의 Propsal no를 조회한다.<br>
     * 
     * @param PriRpMnVO priRpMnVO
     * @return List<MasterInfoFromBasicVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<MasterInfoFromBasicVO> searchMasterInfoFromBasicRFA(PriRpMnVO priRpMnVO) throws EventException ;
}