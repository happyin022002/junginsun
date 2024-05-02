/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainBC.java
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
* 2011.05.03 김민아 [CHM-201110615-01] S/C Proposal에서 Filed 상태의 Sales rep 수정시 EDI WEB 과의 데이터 불일치 발생에 따른 수정
* 2011.08.09 김민아 [CHM-201112688-01] Contract별 Inquiry 화면을 요청 : 특정 S/C 한건에 대한 조회  View Popup 신규 개발
* 2011.10.05 서미진 [CHM-201113544] S/C 화면에서 복수의 Real customer 입력 가능토록 시스템 보완
* 2012.04.18 이석준 [CHM-201217045-01] S/C Filed Cancel 기능및 조회 기능 추가
* 2013.01.15 이은섭 [CHM-201322418-01] SC fling cancel 기능 관련 변경 요청 
* 2013.10.21 전윤주 [CHM-201327107] S/C Note 하 Chassis 항목 추가
* 2013.11.07 전윤주 [CHM-201327486] File 시 Revenue Audit System 수입심사 배치대상 추가 요청
* 2014.04.17 전윤주 [CHM-201429927] 미주 지역 4개 ECC 폐쇄 관련 S/C 해당 운임 Block 기능 개발
* 2014.06.02 전윤주 [CHM-201430580] s/c 자동 filing 기능 추가
* 2014.09.17 송호진 [CHM-201430558] FMC Auto-filing 개발 요청
* 2015.05.15 최성환 [CHM-201535632] Affiliate 내 Type 란 생성 및 Type 간 혼재 불가 로직
* 2015.06.15 최성환 [CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한) 
* 2015.09.25 최성환 [CHM-201537788] SC 다운로드 보안 강화_2차 개발
* 2015.09.25 현성길 [CHM-201537788] SC 다운로드 보안 강화_2차 개발
* 2016.01.15 [CHM-201539511] S/C Copy 시 note conversion data의 Effective Date 관련 건 
* =========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PriEmailTargetListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.RsltReturnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ChkScNoVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpHdrVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpMnFileDtVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpMnFileVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstRequestCheckVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstShHistVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstShInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.InPrsMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriEdiScGenInfVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpDlRecVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpFiledCancelSearchVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpInqRecListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpInqRecSearchVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RequestCheckForCalculationVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltAmdtHisMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltCheckMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltExpChkVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltMainStsVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPRSCMDataVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriCrmSlLdVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriSgGrpCmdtVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriSpAmdHstMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPriSpInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropAmdtEFFListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropAmdtListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropAmdtSmryVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCustInfoVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropInqListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropMnDlRecVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropMnScpListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropScpAmdtSmryVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltStatusVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScPropProgVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SchCustVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SchSaleLeadVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.vo.PriSpRealCustVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriSpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;
import com.hanjin.syscommon.common.table.PriSpFileCxlHisVO;
import com.hanjin.syscommon.common.table.PriSpHdrVO;
import com.hanjin.syscommon.common.table.PriSpInqRecVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpProgVO;
import com.hanjin.syscommon.common.table.PriSpScpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriSpScpDurVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;

/**
 * NIS2010-Scproposal Business Logic Command Interface<br>
 * - NIS2010-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Byeon Young Joo
 * @see Esm_pri_0003EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCProposalMainBC {
    /**
     * S/C Proposal Master Creation의 데이터를 조회합니다.<br>
     *
     * @param PriSpHdrVO priSpHdrVO
     * @param SignOnUserAccount account
     * @return RsltPropListVO
     * @exception EventException
     */
    public RsltPropListVO searchProposalMain(PriSpHdrVO priSpHdrVO, SignOnUserAccount account) throws EventException;

    /**
     * S/C Proposal Master Creation의 데이터를 조회합니다.의 RD Print 파일 오픈 권한 정보 조회를 한다. <br>
	 * 사용대상 : RD Print 파일 오픈시 권한 정보 조회를 한다 <br>
     *
     * @param PriSpHdrVO priSpHdrVO
     * @param SignOnUserAccount account
     * @return RsltPropListVO
     * @exception EventException
     */
    public RsltPropListVO searchProposalMainPrintAuthInfo(PriSpHdrVO priSpHdrVO, SignOnUserAccount account) throws EventException;

    /** 
     * S/C Proposal Master Creation의 데이터를 저장합니다.<br>
     *
     * @param ScPropMnVO scPropMnVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String manageProposal(ScPropMnVO scPropMnVO,SignOnUserAccount account) throws EventException;

    /**
     * Amend Request 정보를 조회 합니다.<br>
     *
     * @param PriSpHdrVO priSpHdrVO
     * @return List<RsltPropAmdtListVO>
     * @exception EventException
     */
    public List<RsltPropAmdtListVO> searchProposalAmendList(PriSpHdrVO priSpHdrVO) throws EventException;
    
    /**
     * Amend 시 해당 Proposal 의 MAX seq.가 filed 상태가 아니면 amend 할 수 없다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchAmendCheckProposalStatus(PriSpMnVO priSpMnVO) throws EventException ;

	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * TPW Group Commodity Guideline Effective Date 조회 이벤트 처리<br>
     *
     * @param rsltPriSgGrpCmdtVO   RsltPriSgGrpCmdtVO
     * @return PriSpScpMnVO
     * @exception EventException
     */
//  public PriSpScpMnVO searchGRIGroupCommodityEffectiveDt (RsltPriSgGrpCmdtVO rsltPriSgGrpCmdtVO) throws EventException;

    /**
     * TPW Group Commodity Guideline Select 화면의 데이터를 조회합니다.<br>
     *
     * @param RsltPriSgGrpCmdtVO rsltPriSgGrpCmdtVO
     * @return List<PriSgGrpCmdtVO>
     * @exception EventException
     */
    public List<PriSgGrpCmdtVO> searchGRIGroupCommodityList (RsltPriSgGrpCmdtVO rsltPriSgGrpCmdtVO) throws EventException;
    
    /**
     * S/C Proposal Master Creation의 상태를 변경합니다.<br>
     *
     * @param ScPropProgVO scPropProgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void counterofferProposal(ScPropProgVO scPropProgVO,SignOnUserAccount account) throws EventException;
    
    /**
     * S/C Proposal Master Creation의 상태를 Approve로 변경합니다.<br>
     *
     * @param ScPropProgVO scPropProgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void approveProposal(ScPropProgVO scPropProgVO,SignOnUserAccount account) throws EventException;
    
    /**
     * S/C Proposal Master Creation의 상태를 이전 상태로 변경합니다.<br>
     *
     * @param ScPropProgVO scPropProgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelProposal(ScPropProgVO scPropProgVO,SignOnUserAccount account) throws EventException;
    
    /**
     * Terms의  데이터 변경 시 Scope별  Terms Summary정보를 수정 합니다.<br>
     *
     * @param PriSpScpAmdtSmryVO priSpScpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalScopeAmendmentSummary(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO,SignOnUserAccount account) throws EventException;
    
    /**
     * Terms의 상태 변경 시 Scope별  Terms Summary정보를 수정 합니다.<br>
     *
     * @param PriSpScpAmdtSmryVO priSpScpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageScopeAmendmentSummary(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO,SignOnUserAccount account) throws EventException;    
    
    /**
     * S/C Proposal Request시 자동 Accept되는 항목에대한 Summary정보를 수정 합니다.<br>
     *
     * @param PriSpScpAmdtSmryVO priSpScpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalScopeAutoAcceptAmendmentSummary(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO,SignOnUserAccount account) throws EventException;
    
    /**
     * Request Cancel시 자동으로 Accept된 항목을 이전상태로 돌린다.(Scope)<br>
     *
     * @param PriSpScpAmdtSmryVO priSpScpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalScopeRequestCancelAmendmentSummary(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO,SignOnUserAccount account) throws EventException;
    
    /**
     * Request Cancel시 자동으로 Accept된 항목을 이전상태로 돌린다.(Scope)<br>
     *
     * @param PriSpScpAmdtSmryVO priSpScpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalAutoScopeRequestCancelAmendmentSummary(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO,SignOnUserAccount account) throws EventException;    
    
    /**
     * Terms의 상태 변경 시 Terms Summary정보를 수정 합니다.<br>
     *
     * @param PriSpAmdtSmryVO priSpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalAmendmentSummary(PriSpAmdtSmryVO priSpAmdtSmryVO,SignOnUserAccount account) throws EventException;
   
    /**
     * Terms의 상태 변경 시 Terms Summary정보를 수정 합니다.<br>
     *
     * @param PriSpAmdtSmryVO priSpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageAmendmentSummary(PriSpAmdtSmryVO priSpAmdtSmryVO,SignOnUserAccount account) throws EventException;    
    
 
    /**
     * Request Cancel시 자동으로 Accept된 항목을 이전상태로 돌린다.<br>
     * 자동 accept cancel 시 update 합니다.
     * @param PriSpAmdtSmryVO priSpAmdtSmryVO
     * @param List<String> termList
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalAutoRequestCancelAmendmentSummary(PriSpAmdtSmryVO priSpAmdtSmryVO,List<String> termList,SignOnUserAccount account) throws EventException;    
    
    /**
     * Request시 자동 Accept된 Terms의 Summary를 수정 합니다.<br>
     * @param PriSpAmdtSmryVO priSpAmdtSmryVO
     * @param List<String> termList
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyProposalAutoAcceptAmendmentSummary(PriSpAmdtSmryVO priSpAmdtSmryVO,List<String> termList, SignOnUserAccount account) throws EventException;

    /**
     * S/C Proposal Boiler Plate/Affiliate 의 Copy 정보를 조회합니다.<br>
     *
     * @param RsltPropCopyVO rsltPropCopyVO
     * @return List<RsltPropCopyVO>
     * @exception EventException
     */
    public List<RsltPropCopyVO> searchProposalCopyBlplAfilList (RsltPropCopyVO rsltPropCopyVO) throws EventException;

    /**
     * S/C Proposal Main/Scope 의 Copy 정보를 조회합니다.<br>
     *
     * @param RsltPropCopyVO rsltPropCopyVO
     * @return List<RsltPropCopyVO>
     * @exception EventException
     */
    public List<RsltPropCopyVO> searchProposalCopyList (RsltPropCopyVO rsltPropCopyVO) throws EventException;

    /**
	 *  S/C Proposal Customer 정보를 조회합니다.<br>
     *
     * @param SchCustVO schCustVO
     * @return List<RsltPropCustInfoVO>
     * @exception EventException
     */
    public List<RsltPropCustInfoVO> searchProposalCustomerInfo(SchCustVO schCustVO) throws EventException;

    /**
     * Proposal Main 데이터를 Copy 합니다.<br>
     *
     * @param RsltPropCopyVO rsltPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalMain(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException;

    /**
     * Proposal Main Amendment Summary 를 수정합니다.<br>
     *
     * @param PriSpAmdtSmryVO priSpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalAmendmentSummaryAll(PriSpAmdtSmryVO priSpAmdtSmryVO, SignOnUserAccount account) throws EventException;

    /**
     * S/C Copy  조회 이벤트 처리<br>
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String searchMaxPropNo(SignOnUserAccount account) throws EventException;

    /**
     * Terms의 Summary 정보를 조회 합니다.<br>
     *
     * @param PriSpAmdtSmryVO priSpAmdtSmryVO
     * @return List<RsltPropAmdtSmryVO>
     * @exception EventException
     */
    public List<RsltPropAmdtSmryVO> searchProposalAmendmentSummary(PriSpAmdtSmryVO priSpAmdtSmryVO) throws EventException;

    /**
     * Scope Terms의 Summary 정보를 조회 합니다.<br>
     *
     * @param PriSpScpAmdtSmryVO priSpScpAmdtSmryVO
     * @return List<RsltPropScpAmdtSmryVO>
     * @exception EventException
     */
    public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummary(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO) throws EventException;

    /**
     * Proposal Scope Main 정보를 Copy 합니다.<br>
     *
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeMain(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * Proposal Scope Amendment Summary 데이터를 저장합니다.<br>
     *
     * @param RsltPropCopyVO[] vos
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeAmdtSmry(RsltPropCopyVO[] vos, SignOnUserAccount account) throws EventException;

    /**
     * Guideline Copy 대상 정보를 조회합니다.<br>
     *
     * @param SpScpGlineCopyVO spScpGlineCopyVO
     * @return List<SpScpGlineCopyVO>
     * @exception EventException
     */
    public List<SpScpGlineCopyVO> searchGuidelineCopyCheck(SpScpGlineCopyVO spScpGlineCopyVO) throws EventException;

    /**
     * Copy 할 Guideline 의 gline_seq 를 가져온다. <br>
     *
     * @param SpScpGlineCopyVO spScpGlineCopyVO
     * @return String
     * @exception EventException
     */
    public String searchCopyGlineSeq(SpScpGlineCopyVO spScpGlineCopyVO) throws EventException;

    /**
     * Proposal Scope Main 의 note_hdr_seq 컬럼을 업데이트 합니다.<br>
     *
     * @param SpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyScpMnNoteHdrSeqGlineCopy (SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * Proposal Scope Amendment Summary 를 업데이트 합니다.<br>
     *
     * @param SpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineScopeAmdtSmry(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * Main의 상태를 Approve로 변경하기 위하여 Terms가 ACCEPT 되었는지 조회 합니다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<PriSpMnVO> 
     * @exception EventException
     */
    public List<PriSpMnVO> searchProposalAcceptCheck(PriSpMnVO priSpMnVO) throws EventException;


    /**
     * Main의 상태를 조회한다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltMainStsVO> 
     * @exception EventException
     */
    public List<RsltMainStsVO> searchProposalMainStatus(PriSpMnVO priSpMnVO) throws EventException;
    
    /**
     * Scope상태를 Scope별로 변경 합니다.<br>
     *
     * @param PriSpScpMnVO[] priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyScopeStatus(PriSpScpMnVO[] priSpScpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * Scope상태를 모두 변경 합니다.<br>
     *
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyAllScopeStatus(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * Proposal  Main 의 Status 컬럼을 업데이트 합니다.<br>
     *
     * @param PriSpMnVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyMainStatus (PriSpMnVO vo, SignOnUserAccount account) throws EventException ;

    /**
     * TERMS가  모두 ACCEPT되었는지 확인 합니다.<br>
     *
     * @param PriSpScpMnVO  priSpScpMn
     * @return int
     * @exception EventException
     */
    public int searchProposalScopeAcceptCheck(PriSpScpMnVO  priSpScpMn) throws EventException;

    /**
     * Terms의 데이터 Count를 가져온다.<br>
     *
     * @param PriSpScpMnVO  priSpScpMn
     * @return List<PriSpScpMnVO>
     * @exception EventException
     */
    public List<PriSpScpMnVO> searchProposalScopeStatusCheck(PriSpScpMnVO  priSpScpMn) throws EventException;

    /**
     * Scope이 삭제될 때 해당 Amend seq에 해당하는 모든 데이터를 삭제처리 합니다. <br>
     *
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void removeProposalScopeAmdtSmry(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;
    /**
     * Init Cancel시 Amend seq에 해당하는 모든 데이터를 삭제처리 합니다. <br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void removeProposalAmdtSmry(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;

    /**
     * Scope이 삭제될 때 해당 Amend seq에 해당하는 모든 데이터를 삭제처리 합니다. <br>
     *
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void removeProposalScopeProgress(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;
    /**
     * Init Cancel시 Amend seq에 해당하는 모든 데이터를 삭제처리 합니다. <br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void removeProposalProgress(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;
    /**
     * Init Cancel시 Amend seq에 해당하는 모든 데이터를 삭제처리 합니다. <br>
     *
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void removeProposalScopeMain(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;

    /**
     * 이전에 File된 File Date와 현재 File Date를 조회 합니다. <br>
     *
     * @param CstPriSpMnFileDtVO cstPriSpMnFileDtVO
     * @param SignOnUserAccount account
     * @return List<CstPriSpMnFileDtVO>
     * @exception EventException
     */
    public List<CstPriSpMnFileDtVO> searchProposalFilingList(CstPriSpMnFileDtVO cstPriSpMnFileDtVO, SignOnUserAccount account) throws EventException;

    /**
     * 해당 Proposal을 Filing 합니다.<br>
     *
     * @param CstPriSpMnFileVO cstPriSpMnFileVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalFiling(CstPriSpMnFileVO cstPriSpMnFileVO, SignOnUserAccount account) throws EventException;

    /**
     * Proposal Scope List를 조회 합니다.<br>
     *
     * @param PriSpHdrVO priSpHdrVO
     * @param SignOnUserAccount account
     * @return List<RsltPropMnScpListVO>
     * @exception EventException
     */
    public List<RsltPropMnScpListVO> searchProposalMainScpList(PriSpHdrVO priSpHdrVO, SignOnUserAccount account) throws EventException ;

    /**
     * c/offer를 실행 하기 위한 조건을 검사하는 조회를  합니다. <br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltStatusVO>
     * @exception EventException
     */
    public List<RsltStatusVO> searchCountOfferStatus(PriSpMnVO priSpMnVO) throws EventException;

    /**
     * Scope삭제시 Terms의 데이터가 있는지 확인 합니다.<br>
     *
     * @param PriSpScpMnVO  priSpScpMn
     * @return int
     * @exception EventException
     */
    public int searchProposalScopeDeleteCheck(PriSpScpMnVO  priSpScpMn) throws EventException;

    /**
     * S/C Number를 저장 합니다.<br>
     * @param PriSpHdrVO priSpHdrVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void createaProposalSCNumber (PriSpHdrVO priSpHdrVO,SignOnUserAccount account) throws EventException;

    /**
     * S/C Number를 저장하기 전에 중복 여부를 조회 합니다.  <br>
     *
     * @param PriSpHdrVO priSpHdrVO
     * @return List<PriSpHdrVO>
     * @throws DAOException
     */
    public List<PriSpHdrVO> checkProposalSCNumber (PriSpHdrVO priSpHdrVO) throws EventException;
    
    /**
     * 유효한 S/C Number PreFix인지 조회 합니다. <br>
     *
     * @param CstPriSpHdrVO cstPriSpHdrVO
     * @return List<CstPriSpHdrVO>
     * @throws DAOException
     */
    public List<CstPriSpHdrVO> checkProposalPreFixNumber (CstPriSpHdrVO cstPriSpHdrVO) throws EventException;

    /**
     * Reqeust 시 필수 입력 데이터를 조회 합니다<br>
     * @param PriSpMnVO priSpMnVO
     * @return List<CstRequestCheckVO>
     * @exception EventException
     */
    public List<CstRequestCheckVO> searchRequestTermsCheck(PriSpMnVO priSpMnVO) throws EventException;

    
	
	/**
     * Reqeust 시 Calcualte를 하지 않은 scope를 조회 합니다<br>
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @return List<RequestCheckForCalculationVO>
	 * @exception EventException
	 */
	public List<RequestCheckForCalculationVO> searchRequestCheckCalculate(PriSpScpMnVO priSpScpMnVO) throws EventException ;
	
    /**
     * Init Cancel시 모든 데이터를 삭제처리 합니다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void removeProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;

    /**
     * Proposal이거나 Filing시 filing Date가 더 늦을 경우 Expire Date를 변경 합니다.<br>
     *
     * @param PriSpScpDurVO priSpScpDurVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalTerms(PriSpScpDurVO priSpScpDurVO,SignOnUserAccount account) throws EventException;

    /**
     * filing 시 이전 amend 차수의 exp_dt를 변경 합니다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyProposalPreTerms(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * MAIN의  Expire Date를 변경 합니다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalMainExpiry(PriSpMnVO priSpMnVO,SignOnUserAccount account)  throws EventException;

    /**
     * Scope MAIN의  Expire Date를 변경 합니다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalScopeMainExpiry(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * 추가 할 S/C Number를 조회합니다.<br>
     * @param CstPriSpHdrVO cstPriSpHdrVO
     * @return List<CstPriSpHdrVO>
     * @exception EventException
     */
    public List<CstPriSpHdrVO> searchProposalSCNumberMain(CstPriSpHdrVO cstPriSpHdrVO) throws EventException;

    /**
	 * Proposal의 상태가 Init이고 Initial상태를 Cancel 할 경우 Scope Main Expire Date를 수정 합니다.<br>
     *
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalScopeMainExpiryCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException;

    /**
	 * Proposal의 상태가 Init이고 Initial상태를 Cancel 할 경우 Main Expire Date를 수정 합니다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalMainExpiryCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * Terms중 하나라도 Returned 가 있다면 Scope의 상태를 Returned로 변경 합니다.<br>
     *
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void changeAutoScopeReturnStatus(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * S/C Proposal Master 를 Proposal에 적용합니다.<br>
     *
     * @param PriSpHdrVO priSpHdrVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void confirmMasterProposal(PriSpHdrVO priSpHdrVO, SignOnUserAccount account) throws EventException;

    /**
     * Proposal Main의 Boiler Plate Header Seq를 변경 합니다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalMainBoilerPlateSeq(PriSpMnVO priSpMnVO,SignOnUserAccount account)  throws EventException;

    /**
	 * DURATION 변경시  SCOPE MAIN  Expire Date를 수정 합니다.<br>
     *
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void changeProposalScopeMainExpiry(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * S/C Master 생성 시 S/C Number의 중복여부를 체크합니다.<br>
     *
     * @param PriSpHdrVO priSpHdrVO
     * @return boolean
     * @exception EventException
     */
    public boolean checkScNumberDup(PriSpHdrVO priSpHdrVO) throws EventException;

    /**
     * S/C Master 생성 시 S/C Number Prefix의 정합성을 체크합니다.<br>
     *
     * @param ChkScNoVO chkScNoVO
     * @return String
     * @exception EventException
     */
    public String checkScNumberPrefix(ChkScNoVO chkScNoVO) throws EventException;

    /**
     * Sales Lead Contract Info를 CRM으로 전송합니다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void transferScSalesLeadContractInfo(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;


    /**
     * terms 에서 returned 인 데이터를 조회 합니다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltReturnVO>
     * @exception EventException
     */
    public List<RsltReturnVO> searchProposalReturnedList(PriSpMnVO priSpMnVO) throws EventException;

    /**
     * Proposal  Main 의 Status 컬럼을 Returned에서 Request로 업데이트 합니다.<br>
     *
     * @param PriSpMnVO vo
     * @param SignOnUserAccount account 
     * @return int
     * @exception EventException
     */
    public int changeAutoRequestMainStatus (PriSpMnVO vo, SignOnUserAccount account) throws EventException ;

    /**
     * Approve 시 validation 을 하기 위해 DEM/DET Exception의 Status를 가져온다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchCheckDmdtList(PriSpMnVO priSpMnVO) throws EventException ;
    
    /**
     * Approve 시 validation 을 하기 위해 CHSS Exception의 Status를 가져온다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchCheckChssList(PriSpMnVO priSpMnVO) throws EventException ;

    /**
     * Amend History Main정보를 조회합니다.<br>
     *
     * @param PriSpHdrVO priSpHdrVO
     * @return List<RsltPriSpAmdHstMnVO>
     * @exception EventException
     */
    public List<RsltPriSpAmdHstMnVO> searchAmendmentHistoryMain(PriSpHdrVO priSpHdrVO) throws EventException;

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
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltPropScpAmdtSmryVO>
     * @exception EventException
     */
    public List<RsltPropScpAmdtSmryVO> searchHistoryAmendTermList(PriSpMnVO priSpMnVO) throws EventException ;
    
    /**
     * Proposal No.에 해당 하는 모든 Scope 을 조회 합니다.
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchHistoryScopeList(PriSpMnVO priSpMnVO) throws EventException ;

    /**
     * 각 Terms에 수정된 정보가 있는 지 조회 합니다.<br>
     *
     * @param CstShHistVO cstShHistVO
     * @return List<RsltPropScpAmdtSmryVO>
     * @exception EventException
     */
    public List<RsltPropScpAmdtSmryVO> searchAmendmentHistorySummary(CstShHistVO cstShHistVO) throws EventException;

    /**
     * Filing시 main,scope에서 validation하기 위하여 입력한 file date 보다 <br>
	 * duration Expire Date가 작거나 같은 Scope을 조회한다. <br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltExpChkVO>
     * @exception EventException
     */
    public List<RsltExpChkVO> searchExpireDateCheck(PriSpMnVO priSpMnVO) throws EventException;
    
    /**
	 * Filing Save 버튼 컨트롤 시 FMC confirm date를 확인한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchFmcConfirmDateCheck(PriSpMnVO priSpMnVO) throws EventException    ;
	
	/**
	 * Filing C/T 버튼 활성화 시 FMC confirm date를 확인한다. (최종 filing 후 48시간 이내인지)<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCorrectionLimitCheck(PriSpMnVO priSpMnVO) throws EventException    ;

	/**
	 * S/C메인화면의 Filing C/T 버튼 가능한 시간을 조회 한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCorrectionLimitTime(PriSpMnVO priSpMnVO) throws EventException    ;
	
	
	/**
	 * Filing C/T 버튼 클릭 시 최초 FMC confirm date를 확인한다. (최초 filing 후 48시간 이내인지)<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchInitFileDtCheck(PriSpMnVO priSpMnVO) throws EventException    ;

    /**
     *Sale Lead 를 조회 합니다.<br>
     *
     * @param SchSaleLeadVO schSaleLeadVO
     * @return List<RsltPriCrmSlLdVO>
     * @exception EventException
     */
    public List<RsltPriCrmSlLdVO> searchProposalMainSaleLeadList(SchSaleLeadVO schSaleLeadVO) throws EventException;

    /**
     * Proposal & Amendment Search List 를 조회 합니다.<br>
     *
     * @param CstShInqVO cstShInqVO
     * @return List<RsltPriSpInqVO>
     * @exception EventException
     */
    public List<RsltPriSpInqVO> searchProposalMainInquiryList(CstShInqVO cstShInqVO) throws EventException;

    /**
     * Proposal & Amendment 를 조회 합니다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @return RsltPropInqListVO
     * @exception EventException
     */
    public RsltPropInqListVO searchProposalMainInquiry(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;

    /**
     * Customer 정보를 조회 합니다.<br>
     *
     * @param PriSpCtrtPtyVO priSpCtrtPtyVO
     * @return List<RsltPropCustInfoVO>
     * @exception EventException
     */
    public List<RsltPropCustInfoVO> searchProposalCustomerInfoInquiry(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException;

    /**
     * Terms의 데이터가 있는지 조회 합니다.<br>
     *
     * @param PriSpScpAmdtSmryVO priSpScpAmdtSmryVO
     * @return List<RsltPropScpAmdtSmryVO>
     * @exception EventException
     */
    public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummaryInquiry(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO) throws EventException;
    
    /**
     * Custmoer Type이 변경된 경우 Commodity Group,Rate,Standard Note의 데이터를 조회 합니다.<br>
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
	public void copyToProposalBase(RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) 
		throws EventException;
	

    /**
     * S/C General Information 을 EDI 로 전송합니다.<br>
     * 
     * @param PriEdiScGenInfVO priEdiScGenInfVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void transferScGeneralInfo (PriEdiScGenInfVO priEdiScGenInfVO, SignOnUserAccount account) throws EventException;
    
    /**
	 * Guideline Standard Note 정보 COPY시 HEADER SEQ정보를 수정 합니다.<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @param String isCopy
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyNoteHeaderSeq(PriSpScpNoteListVO priSpScpNoteListVO, String isCopy, SignOnUserAccount account) throws EventException;
	
	/**
	 * Performance를 조회하기 위해 BackEndJob을 실행한다.<br>
     *
	 * @param SignOnUserAccount account
	 * @param PriSpMnVO priSpMnVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSCPerformanceDoStart(SignOnUserAccount account, PriSpMnVO priSpMnVO) throws EventException;
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String object
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVOs(String object) throws EventException;	
	
    /**
     * PRS CM Data를 조회합니다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltPRSCMDataVO>
     * @exception EventException
     */
    public List<RsltPRSCMDataVO> searchProposalMainPRSCMData(PriSpMnVO priSpMnVO) throws EventException ;  	
	
    
    /**
     * Conversion Flag를 수정합니다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void changeConversionFlg (PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException ;   
    
	/**
	 * Init Cancel시 validation 을 하기 위해 DEM/DET 의 데이터를 조회한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalMainInitCancelCheck(PriSpMnVO priSpMnVO) throws EventException    ;
	
	/**
	 * Init Cancel시 validation 을 하기 위해 CHSS 의 데이터를 조회한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalMainInitCancelChssCheck(PriSpMnVO priSpMnVO) throws EventException    ;
	
	/**
	 * 1회차 이상의 Amend proposal init Cancel시 validation 을 하기 위해 CHSS 의 데이터를 조회한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalMainInitCancelChssEffDtCheck(PriSpMnVO priSpMnVO) throws EventException    ;
	
	/**
	 * Request 시 TPE Scope Destination에 Block하는 location이 있는지 체크한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalRouteCheck(PriSpMnVO priSpMnVO) throws EventException    ;
	
	/**
	 * Request 시 Affiliate type code 가 중복이 되는지 체크한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchAffiliateTypeDupCheck(PriSpMnVO priSpMnVO) throws EventException    ;
	
    /**
     * Proposal No.,Amend Seq 에 해당 하는 Scope 을 조회 합니다.
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchScopeList(PriSpMnVO priSpMnVO) throws EventException ;	
	
    /**
     * S/C Proposal Scope 의 데이터를 삭제합니다.<br>
     *
     * @param ScPropMnVO scPropMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalRemove(ScPropMnVO scPropMnVO,SignOnUserAccount account) throws EventException;    
    
	
	/**
	 * ETL Batch를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param String propNo
	 * @param String amdtNo
	 * @param String opCd
	 * @exception EventException
	 */
	public void receiveNISProposalInfo(String propNo, String amdtNo, String opCd) throws EventException ;    
	
    /**
     * Rate Save시, Scope Main의 PRS Calc 관련 테이블을 업데이트한다.<br>
     * 
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void updatePrsCalcFlgOnSaveRt(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;
    
    /**
     *  Reqeust Cancel 시 Accept, Returned 데이터가 있는지 조회한다.<br>
     * @param PriSpMnVO priSpMnVO
     * @return List<CstRequestCheckVO>
     * @exception EventException
     */
    public List<CstRequestCheckVO> searchProposalRequestCancelCheck(PriSpMnVO priSpMnVO) throws EventException;    
    
    /**
     * Request 시 Group Ware Main 을 PopUp 하기 위한 조건을 조회한다.<br>
     * Request Cancel을 한번이라도 했다면 다음번 Request 시 Group Ware Main을 PopUp하지 않는다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchProgRequestList(PriSpMnVO priSpMnVO) throws EventException ;    
    

    
    /**
     * MQC estimate 를 저장 하지 않는것이 있는지 확인한다.<br>
     *
     * @param InPrsMQCEstimateVO inPrsMQCEstimateVO
     * @return List<RsltCheckMQCEstimateVO>
     * @exception EventException
     */
    public List<RsltCheckMQCEstimateVO> searchCheckMQCEstimateList(InPrsMQCEstimateVO inPrsMQCEstimateVO)  throws EventException ;
    
    
    /**
     * MQC estimate Popup의 List를 조회한다..<br>
     *
     * @param InPrsMQCEstimateVO inPrsMQCEstimateVO
     * @return List<RsltMQCEstimateVO>
     * @exception EventException
     */
    public List<RsltMQCEstimateVO> searchMQCEstimateList(InPrsMQCEstimateVO inPrsMQCEstimateVO)  throws EventException ;    
    
	/**
	 *  MQC estimate 정보를 갱신합니다.<br>
	 * 
	 * @param PriSpScpMnVO[] priSpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMQCEstimateList(PriSpScpMnVO[] priSpScpMnVOs, SignOnUserAccount account) throws EventException;
 
	
    /**
     * 숨은 기능인 Superuser만 실행 시킬수 있는 Cancel Filing<br>
     *
     * @param ScPropProgVO scPropProgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelFilingForSuperuser(ScPropProgVO scPropProgVO,SignOnUserAccount account) throws EventException;
    
	/**
	 *  Sales Rep 정보의 변경 유무를 체크한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return int
	 * @exception EventException
	 */
	public int searchCheckOfcSrepDiffList(PriSpMnVO priSpMnVO) throws EventException;
	
    /**
     * S/C No로 Prop No 를 조회합니다.<br>
     *
     * @param PriSpHdrVO priSpHdrVO
     * @return PriSpHdrVO
     * @exception EventException
     */
    public PriSpHdrVO searchProposalNoFromScNo(PriSpHdrVO priSpHdrVO) throws EventException;
    
    /**
     * S/C Proposal Real Customer의 데이터를 수정합니다.<br>
     *
     * @param PriSpRealCustVO[] priSpRealCustVOs
     * @param String delFlag
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyProposalMainRealCustomer(PriSpRealCustVO[] priSpRealCustVOs,String delFlag, SignOnUserAccount account) throws EventException;
    
    /**
     * Filed S/C Cancel List를 조회합니다.<br>
     *
     * @param PriSpFiledCancelSearchVO priSpFiledCancelSearchVO
     * @return List<PriSpFiledCancelSearchVO>
     * @exception EventException
     */
    public List<PriSpFiledCancelSearchVO> searchFiledCancelHistoryList(PriSpFiledCancelSearchVO priSpFiledCancelSearchVO) throws EventException;
    
    /**
     * Filed 된 s/C를 Cancel 하는 기능<br>
     *
     * @param PriSpFileCxlHisVO priSpFileCxlHisVO
     * @param PriSpProgVO prSpProgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageFiledCancelProposal(PriSpFileCxlHisVO priSpFileCxlHisVO, PriSpProgVO prSpProgVO,SignOnUserAccount account) throws EventException;
    
    /**
     * Filed S/C Cancel List를 조회합니다.<br>
     *
     * @param PriSpFiledCancelSearchVO priSpFiledCancelSearchVO
     * @return List<PriSpFiledCancelSearchVO>
     * @exception EventException
     */
    public List<PriSpFiledCancelSearchVO> searchFiledCancelHistoryInquiryList(PriSpFiledCancelSearchVO priSpFiledCancelSearchVO) throws EventException;
    
    /**
     * S/C FILING 시 유저에게 G/W 메일 발송<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @return List<PriEmailTargetListVO>
     * @exception EventException
     */
    public List<PriEmailTargetListVO> sendEmail(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;
    	
	/**
	 * PRI_SP_FILE_PROG 의 신규 건을 생성하고 생성된 신규 File Progress Sequence 를 Return 합니다.<br>
	 * 
	 * @param CstPriSpMnFileDtVO vo
	 * @param account SignOnUserAccount
     * @return int
	 * @exception EventException
	 */
	public int createPriSpFileProg(CstPriSpMnFileDtVO vo, SignOnUserAccount account) throws EventException;
    
	/**
	 * FMC Return Message 를 사용하여 PRI_SP_FILE_PROG 을 Update 하고 PRI_SP_FILE_ERR 을 생성 한다.<br>
	 * 
	 * @param CstPriSpMnFileDtVO vo
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyPriSpFileProg(CstPriSpMnFileDtVO vo, SignOnUserAccount account) throws EventException;
	
    /**
     * S/C Filing 을 WebService 를 통해 FMC 에 송부 합니다. FILECONTRACT<br>
     * 
     * @param CstPriSpMnFileDtVO vo
     * @exception EventException
     */
    public void sendFmcFileContract (CstPriSpMnFileDtVO vo) throws EventException ;
    
    /**
     * S/C Filing 을 WebService 를 통해 FMC 에 송부 합니다. FILECORRECTEDCOPY<br>
     * 
     * @param CstPriSpMnFileDtVO vo
     * @exception EventException
     */
    public void sendFmcFileCorrectedCopy (CstPriSpMnFileDtVO vo) throws EventException ;
    
	/**
     * 해당 Proposal을 Filing 합니다.<br>
	 * 
	 * @param CstPriSpMnFileDtVO cstPriSpMnFileDtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalFmcFiling(CstPriSpMnFileDtVO cstPriSpMnFileDtVO, SignOnUserAccount account) throws EventException;

	/**
	 * S/C Filing 을 WebService FILECONTRACT 를 통해 FMC 에 송부를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param CstPriSpMnFileDtVO fileDtVo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String sendFmcFileContractDoStart(CstPriSpMnFileDtVO fileDtVo, SignOnUserAccount account) throws EventException ;


	/**
	 * S/C Filing 을 WebService FILECORRECTEDCOPY 를 통해 FMC 에 송부를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param CstPriSpMnFileDtVO fileDtVo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String sendFmcFileCorrectedCopyDoStart(CstPriSpMnFileDtVO fileDtVo, SignOnUserAccount account) throws EventException ;
	
	 /**
     * PRI_SP_DL_REC 의 신규 Screen Event Sequence 를 조회합니다.<br>
     *
     * @return String
     * @exception EventException
     */
    public String searchScreenEventSeq() throws EventException;	
	
	 /**
     * 사용자의 RD 리포트 사용 내역(파일오픈, 저장, 닫기등)을 관리합니다.<br>
     *
     * @param RsltPropMnDlRecVO rsltPropMnDlRecVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageDownloadRecord(RsltPropMnDlRecVO rsltPropMnDlRecVO,SignOnUserAccount account) throws EventException;
    
    
    

	/**
	 * S/C Pri Download Record 를 조회한다.<br>
	 * 
	 * @param PriSpDlRecVO PriSpDlRecVO
	 * @return List<PriSpDlRecVO> 
	 * @exception EventException
	 */
	public List<PriSpDlRecVO> searchPriDownloadRecord(PriSpDlRecVO PriSpDlRecVO) throws EventException ;
	
	/**
	 * PROPOSAL 필수 항목들이 입력되었는지의 여부 확인 (N: 복사 직후 아직 필수값이 입력되기 이전 Y: 복사 이후 필수값 입력됨).<br>
	 * 
     * @param PriSpMnVO priSpMnVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPropPrprFlg(PriSpMnVO priSpMnVO) throws EventException ;	
    
	
    /**
   *   Amend Effective Date 정보를 조회합니다.<br>
   * 
   * @param PriSpMnVO priSpMnVO
   * @return List<RsltPropAmdtEFFListVO>
   * @exception EventException
   */
  public List<RsltPropAmdtEFFListVO> searchProposalAmendEffList (PriSpMnVO priSpMnVO) throws EventException ;
  
  /**
   * 해당 Proposal의 Effective Date를 변경 합니다.<br>
   * 
   * @param  PriSpMnVO priSpMnVO
   * @param SignOnUserAccount account
   * @exception EventException
   */
  public void manageEffectiveDate(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;
  /**
   * 사용자의 S/C 조회 사용 내역을 관리합니다.<br>
   *
   * @param PriSpInqRecVO priSpInqRecVO
   * @param SignOnUserAccount account
   * @exception EventException
   */
  public void manageInquiryRecord(PriSpInqRecVO priSpInqRecVO,SignOnUserAccount account)  throws EventException ;
 
  
  /**
   * S/C Open Record 정보를 조회합니다.<br>
   * 
   * @param PriSpInqRecSearchVO priSpInqRecSearchVO
   * @return List<PriSpInqRecListVO>
   * @exception EventException
   */
  public List<PriSpInqRecListVO> searchPriOpenRecord(PriSpInqRecSearchVO priSpInqRecSearchVO) throws EventException;  
}