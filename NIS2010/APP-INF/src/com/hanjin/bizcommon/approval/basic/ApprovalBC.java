/*========================================================= 
*Copyright(c) 2006 CyberLogitec
*@FileName : StaffBC.java
*@FileTitle : VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-31 Hyung Choon_Roh
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2013.09.05 조인영 [CHM-201326202] ETS연동에 따른 TRS CSR삭제로직 추가 요청
* 2014.11.19 김영신 [CHM-201432872] 10만불 이상 G/W연동 관련 로직 추가
* 2015.04.14 심성윤 [CHM-201534125] 결재라인 체크 로직 추가
* 2015.07.20 심성윤 [CHM-201536387] [Develop]ALPS Auth 사후 결재 기능 탭 로직 추가(0U1,0U2,0V1)
=========================================================*/
package com.hanjin.bizcommon.approval.basic;

import java.util.List;

import com.hanjin.bizcommon.approval.vo.ApprovalCsrVO;
import com.hanjin.bizcommon.approval.vo.ApprovalDeptVO;
import com.hanjin.bizcommon.approval.vo.ApprovalInqueryCondtionVO;
import com.hanjin.bizcommon.approval.vo.ApprovalInqueryVO;
import com.hanjin.bizcommon.approval.vo.ApprovalRouteVO;
import com.hanjin.bizcommon.approval.vo.ApprovalStaffVO;
import com.hanjin.bizcommon.approval.vo.ApprovalStepVO;
import com.hanjin.bizcommon.approval.vo.SearchApprovalVO;
import com.hanjin.bizcommon.approval.vo.UnApprovalCsrVO;
import com.hanjin.bizcommon.authorization.vo.AuthAproStaffVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationAproVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationInquiryVO;
import com.hanjin.bizcommon.authorization.vo.SearchAuthAproVO;
import com.hanjin.bizcommon.state.event.ComEns0T1EventResponse;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;

/**
 * eNIS-BIZCOMMON Business Logic Command Interface<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Hyung Choon_Roh
 * @see ComEns0T1EventResponse 참조
 * @since J2EE 1.4
 */
public interface ApprovalBC  {
	
	/**
	 * 조회 이벤트 처리<br>
	 * Staff화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param ApprovalStaffVO approvalStaffVO
     * @return List<ApprovalStaffVO
     * @throws EventException
	 */
	public List<ApprovalStaffVO> searchStaffList(ApprovalStaffVO approvalStaffVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Organization 화면에 대한 조회 이벤트 처리<br>
	 * 
     * @param ApprovalStaffVO approvalStaffVO
     * @param SignOnUserAccount account
	 * @return List<ApprovalDeptVO>
	 * @exception EventException
	 */
	public List<ApprovalDeptVO> searchDeptList(ApprovalStaffVO approvalStaffVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Route화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param ApprovalStaffVO approvalStaffVO
	 * @return List<ApprovalRouteVO>
	 * @exception EventException
	 */
	public List<ApprovalRouteVO> searchApprovalRouteList(ApprovalStaffVO approvalStaffVO) throws EventException;
	
	/**
	 * 저장 이벤트 처리<br>
	 * Approval Route 저장 이벤트 처리<br>
	 * 
	 * @param ApprovalStaffVO approvalStaffVO
	 * @param ApprovalRouteVO[] approvalRouteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void saveApprovalRoute(ApprovalStaffVO approvalStaffVO, ApprovalRouteVO[] approvalRouteVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * 저장 이벤트 처리<br>
	 * Authorization Approval Route 저장 이벤트 처리<br>
	 * 
	 * @param AuthAproStaffVO authAproStaffVO
	 * @param SearchAuthAproVO[] searchAuthAproVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void saveAuthApprovalRoute(AuthAproStaffVO authAproStaffVO,SearchAuthAproVO[] searchAuthAproVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * 저장 이벤트 처리<br>
	 * Approval Route Request 저장 이벤트 처리<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @param SignOnUserAccount account
     * @throws EventException
	 */
	public void saveApprovalRouteReq(ApprovalCsrVO approvalCsrVO, SignOnUserAccount account) throws EventException;

	/**
	 * 결재라인 체크 로직<br>
	 * CHM-201534125 심성윤(2015.04.14)<br>
	 * Approval Route 체크 이벤트 처리<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @param SignOnUserAccount account
	 * @return String
     * @throws EventException
	 */
	public String checkApprovalRouteReq(ApprovalCsrVO approvalCsrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 결재라인 체크 로직<br>
	 * CHM-201534125 심성윤(2015.04.14)<br>
	 * Approval Route 체크 이벤트 처리<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO 
	 * @param List<ComAproRqstRoutVO> comAproRqstRoutVOs
     * @return String
     * @throws EventException
	 */
	public String checkAproRouteReq(ApprovalCsrVO approvalCsrVO, List<ComAproRqstRoutVO> comAproRqstRoutVOs) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * 부서모듈 사용자별 기본결재라인(COM_APRO_ROUT_DFLT_DTL) 목록을 조회합니다.<br>
	 * 
	 * @param ApprovalStaffVO approvalStaffVO
	 * @return List<SearchApprovalVO>
	 * @exception EventException
	 */
	public List<SearchApprovalVO> searchApproval(ApprovalStaffVO approvalStaffVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * 부서모듈 사용자별 기본Auth결재라인(COM_AUTH_APRO_DFLT_ROUT_USR) 목록을 조회합니다.<br>
	 * 
	 * @param AuthAproStaffVO authAproStaffVO
	 * @return List<AuthAproStaffVO>
	 * @exception EventException
	 */
	public List<AuthAproStaffVO> searchAuthApproval(AuthAproStaffVO authAproStaffVO) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Csr화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param ApprovalStaffVO approvalStaffVO
	 * @param SignOnUserAccount account
     * @return List<ApprovalCsrVO>
     * @throws EventException
	 */
	public List<ApprovalCsrVO> searchApprovalCsrList(ApprovalStaffVO approvalStaffVO, SignOnUserAccount account) throws EventException;
	

	/**
	 * 조회 이벤트처리 <br>
     * COM_ENS_0U1 Authorization <br>
	 * 
	 * @param AuthorizationAproVO authorizationAproVO
	 * @param SignOnUserAccount account
     * @return List<AuthorizationAproVO>
     * @throws EventException
	 */
	public List<AuthorizationAproVO> searchAuthApprovalList(AuthorizationAproVO authorizationAproVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * OFC_CD로 OFFICE_TP_CD를 조회 합니다.<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchOfcTpCd(String ofcCd) throws EventException;
	
	/**
	 * Approval Inquery 화면에 RHQ OFFICE COMBO CODE LIST조회<br>
	 *
	 * @return String
	 * @throws EventException
	 */
	public String searchRhqOfcCdList() throws EventException;
	
	/**
	 * Approval Inquery 화면에 OFFICE COMBO CODE LIST조회<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchOfcCdList(String ofcCd) throws EventException;
	
	/**
	 * Approval Inquery 화면에서 RHQ콤보 변경시 OFFICE COMBO CODE LIST조회<br>
	 *
	 * @param String rhqOfcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchOfcCdListByRhq(String rhqOfcCd) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
     * Authorization Inquiry 화면에서 MODULE CODE LIST조회<br>
     * 
     * @param AuthorizationInquiryVO authorizationInquiryVO
	 * @return List<AuthorizationInquiryVO>
	 * @throws EventException
	 */
	public List<AuthorizationInquiryVO> searchAuthSubSysCdList(AuthorizationInquiryVO authorizationInquiryVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
     * Authorization Inquiry 화면에서 PROGRAM LIST조회<br>
     * 
     * @param AuthorizationInquiryVO authorizationInquiryVO
	 * @return List<AuthorizationInquiryVO>
	 * @throws EventException
	 */
	public List<AuthorizationInquiryVO> searchAuthPgmNmList(AuthorizationInquiryVO authorizationInquiryVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
     * Authorization Approval 조회<br>
     * 
     * @param AuthorizationInquiryVO authorizationInquiryVO
	 * @return List<AuthorizationInquiryVO
	 * @throws EventException
	 */
	public List<AuthorizationInquiryVO> searchAuthAproInquiry(AuthorizationInquiryVO authorizationInquiryVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Csr화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param ApprovalInqueryCondtionVO approvalInqueryCondtionVO
	 * @param SignOnUserAccount account
     * @return List<ApprovalInqueryVO>
     * @throws EventException
	 */
	public List<ApprovalInqueryVO> searchApprovalInqueryCsrList(ApprovalInqueryCondtionVO approvalInqueryCondtionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 *현 결재자 정보를 조회한다<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
     * @return ComAproRqstRoutVO
     * @throws EventException
	 */
	public ComAproRqstRoutVO searchApprovalCurCsrRoute(ApprovalCsrVO approvalCsrVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * 후결 처리 가능한 Approval Route 인지 검사 <br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
     * @return boolean
     * @throws EventException
	 */
	public boolean chkUrgPayFlgAproRout(ApprovalCsrVO approvalCsrVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * 최종 결재 여부를 체크한다 - 최종 결재시에만 CSR AP전송  <br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
     * @return boolean
     * @throws EventException
	 */
	public boolean searchLastApprovalRoute(ApprovalCsrVO approvalCsrVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * 기결재 완료 여부 파악 - 중복 결재 피하기 위함<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
     * @return boolean
     * @throws EventException
	 */
	public boolean searchApprovalCompletion(ApprovalCsrVO approvalCsrVO) throws EventException;
	
	/**
	 * 저장 이벤트 처리<br>
	 * Confirm Approval 저장 이벤트 처리<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @param SignOnUserAccount account
     * @throws EventException
	 */
	public void confirmApproval(ApprovalCsrVO approvalCsrVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 저장 이벤트 처리<br>
	 * GW 전송 Confirm Approval 저장 이벤트 처리<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
     * @throws EventException
	 */
	public void confirmApprovalGW(ApprovalCsrVO approvalCsrVO) throws EventException;
	
	/**
	 * 저장 이벤트 처리<br>
	 * Approval Route Reject 저장 이벤트 처리<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
     * @throws EventException
	 */
	public void rejectApproval(ApprovalCsrVO approvalCsrVO) throws EventException;	
	
	/**
	 * 저장 이벤트 처리<br>
	 * G/W Approval Route Reject 저장 이벤트 처리<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
     * @throws EventException
	 */
	public void rejectApprovalGW(ApprovalCsrVO approvalCsrVO) throws EventException;
	
	/**
     * COM_CSR_0008 View Approval Step 버튼 -> COM_ENS_0W1 팝업 조회 이벤트 처리<br>
     * Approval Step 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
     * @return List<ApprovalStepVO>
     * @throws EventException
	 */
	public List<ApprovalStepVO> searchApprovalStepList(ApprovalCsrVO approvalCsrVO) throws EventException;
		
	/**
     * BackEndJob의 수행결과를 조회한다.
     * @param String key
     * @return String
     * @throws EventException
     */
	public String searchBakEndJobStatus(String key) throws EventException;
	
	/**
	 * 저장 이벤트 처리<br>
	 * Confirm Approval Remark 수정 이벤트 처리<br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
	 * @exception EventException
	 */
	public void confirmApprovalRemark(ApprovalCsrVO approvalCsrVO) throws EventException;
	
	/**
	 * It is running a event that cancels a approval.
	 * 
	 * @param String csr_no
	 * @exception EventException
	 * 2008. 08. 29
	 */
	public void cancelApproval(String csr_no) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * A/R HEAD QUARTER OFFICE CODE를 조회한다.<br>
	 * 
	 * @author ds ham
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchARRHQOfficeList() throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * OFFICE CODE를 조회한다.<br>
	 * 
	 * @author ds ham
	 * @param UnApprovalCsrVO unApprovalCsrVO
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchSelOfficeList(UnApprovalCsrVO unApprovalCsrVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CSR의 결재권자가 미승인된 내역을 조회한다.<br>
	 * 
	 * @param UnApprovalCsrVO unApprovalCsrVO
     * @return List<UnApprovalCsrVO>
     * @throws EventException
	 */
	public List<UnApprovalCsrVO> searchUnApprovalCsrList(UnApprovalCsrVO unApprovalCsrVO) throws EventException;
	
	/**
	 * OFC_CD로 RHQ_OFC_CD를 조회 합니다.<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchRhqOfcCdByOfcCd(String ofcCd) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * 결재시에 Invoice 존재 여부 체크 <br>
	 * 
	 * @param ApprovalCsrVO approvalCsrVO
     * @return boolean
     * @throws EventException
	 */
	public boolean searchInvoice(ApprovalCsrVO approvalCsrVO) throws EventException;
	
	/**
     * Edit Approval Step시 Del버튼 Validation<br>
     * Approval 된 결제자는 삭제할 수 없다.<br>
	 *
	 * @param csr_no String
	 * @param apro_rqst_seq String
	 * @return String
	 * @throws EventException
	 */
	public String searchCheckApprovedStep(String csr_no, String apro_rqst_seq ) throws EventException;
	
	/**
     * Add버튼 클릭시 CSR Approved된 건은 결재라인 추가 못하도록 한다.<br>
     * COM_ENS_0T1
	 *
	 * @param csr_no String
	 * @return String
	 * @throws EventException
	 */
	public String searchCheckApprovedCsr(String csr_no ) throws EventException;
	
	/**
     * Approval시 결재자가 Approval Step에 존재유무 체크.<br>
     * COM_ENS_0U1
	 *
	 * @param sLoginUsrId String
	 * @return String
	 * @throws EventException
	 */
	public String searchAproUsrId(String sLoginUsrId ) throws EventException;
	
	/**
     * 조회 이벤트 처리 <br>
	 * Authorization  Approve / Confirm 버튼 클릭시 최종결재완료 여부 확인<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @return String
	 * @throws EventException
	 */
	public String checkAuthApproval(AuthorizationAproVO authorizationAproVO) throws EventException;
	
	
	/**
     * 저장 이벤트 처리 <br>
	 * Authorization  Disapprove 버튼 클릭시 Rout Update<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @throws EventException
	 */
	public void updateAuthDisaproRout(AuthorizationAproVO authorizationAproVO) throws EventException;
	
	/**
     * 저장 이벤트 처리 <br>
	 * Authorization  Disapprove 버튼 클릭시 Disapprove 실시<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @throws EventException
	 */
	public void disaproAuthApproval(AuthorizationAproVO authorizationAproVO) throws EventException;
	
	/**
     * 저장 이벤트 처리 <br>
	 * Authorization  RQST Rmk 저장 이벤트 처리<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @throws EventException
	 */
	public void saveAuthRqstRmk(AuthorizationAproVO authorizationAproVO) throws EventException;
	
	/**
     * 저장 이벤트 처리 <br>
	 * Authorization  Approve / Confirm 버튼 클릭시 Rout Update<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @throws EventException
	 */
	public void updateAuthAproRout(AuthorizationAproVO authorizationAproVO) throws EventException;
	
	
	/**
     * 저장 이벤트 처리 <br>
	 * Authorization  Approve / Confirm 버튼 클릭시 최종결재 실시<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @throws EventException
	 */
	public void confirmAuthAproFinal(AuthorizationAproVO authorizationAproVO) throws EventException;
	
	
	/**
     * 저장 이벤트 처리 <br>
	 * Authorization  Approve / Confirm 버튼 클릭시 중간결재 실시<br>
	 *
	 * @param AuthorizationAproVO authorizationAproVO
	 * @throws EventException
	 */
	public void confirmAuthAproProgress(AuthorizationAproVO authorizationAproVO) throws EventException;
	
	
    /**
     * COM_ENS_0T1화면 Loading시 User ID OR EP ID를 조회
     * Del버튼 클릭시 자기 자신의 결재라인을 지우지 못하게 한다.<br>
     * COM_ENS_0T1
     * @param usrId String
     * @return String
     * @exception EventException
     * @author SHIN DONG IL
     * @date 2014.08.12
     */
	public String searchCheckApprovalUserId(String usrId ) throws EventException;

	/**
	 * ASA 정보를 조회
	 * @param csrNo
	 * @throws EventException
	 */
	public void checkAsaNo(String csrNo) throws EventException;
}