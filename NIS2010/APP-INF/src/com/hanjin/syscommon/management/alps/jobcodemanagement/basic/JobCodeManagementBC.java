/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JobCodeManagementBC.java
*@FileTitle : JobCodeManagementBC
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.17
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.04.17 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.AdjustmentVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.ApproverVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.JobCodeInquiryVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.JobCodeManagementVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.MenuListVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.OfficeMappingVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.RequestVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.UserInquiryVO;


/**
 * ALPS-JobCodeManagement Business Logic Command Interface<br>
 * - ALPS-JobCodeManagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author DukWoo Choi
 * @see 각 메소드의 EventResponse 참조
 * @since J2EE 1.6
 */
public interface JobCodeManagementBC {

	/**
	 * [ADM_SYS_0011]<br>
	 * JOB Code의 정보를 조회<br>
	 *
	 * @param JobCodeManagementVO jobCodeManagementVO
	 * @return List<JobCodeManagementVO>
	 * @exception EventException
	 */
	public List<JobCodeManagementVO> searchJobCodeManagement(JobCodeManagementVO jobCodeManagementVO) throws EventException;

	/**
	 * [ADM_SYS_0011]<br>
	 * JOB Code Count를 가져옴<br>
	 *
	 * @param String usrRoleCd
	 * @return String
	 * @exception EventException
	 */
	public String getJobCodeCount(String usrRoleCd) throws EventException;

	/**
	 * [ADM_SYS_0011]<br>
	 * JOB Code 리스트를 일괄적으로 저장<br>
	 *
	 * @param JobCodeManagementVO[] jobCodeManagementVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageJobCodeManagement(JobCodeManagementVO[] jobCodeManagementVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ADM_SYS_0012]<br>
	 * Job Office Mapping의 정보를 조회<br>
	 *
	 * @param OfficeMappingVO OfficeMappingVO
	 * @return List<OfficeMappingVO>
	 * @exception EventException
	 */
	public List<OfficeMappingVO> searchOfficeMapping(OfficeMappingVO officeMappingVO) throws EventException;

	/**
	 * [ADM_SYS_0012]<br>
	 * JOB Code Office Mapping 정보를 일괄적으로 저장<br>
	 *
	 * @param OfficeMappingVO[] officeMappingVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOfficeMapping(OfficeMappingVO[] officeMappingVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ADM_SYS_0013]<br>
	 * Menu List 정보를 조회<br>
	 *
	 * @param MenuListVO menuListVO
	 * @return List<MenuListVO>
	 * @exception EventException
	 */
	public List<MenuListVO> searchMenuList(MenuListVO menuListVO) throws EventException;

	/**
	 * [ADM_SYS_0013]<br>
	 * Program List 정보를 조회<br>
	 *
	 * @param MenuListVO menuListVO
	 * @return List<MenuListVO>
	 * @exception EventException
	 */
	public List<MenuListVO> searchProgramList(MenuListVO menuListVO) throws EventException;

	/**
	 * [ADM_SYS_0013]<br>
	 * Program Assign 정보를 일괄적으로 수정<br>
	 *
	 * @param MenuListVO[] menuListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProgramList(MenuListVO[] menuListVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ADM_SYS_0014]<br>
	 * Office List 정보를 조회<br>
	 *
	 * @param UserInquiryVO userInquiryVO
	 * @return List<UserInquiryVO>
	 * @exception EventException
	 */
	public List<UserInquiryVO> searchOfficeList(UserInquiryVO userInquiryVO) throws EventException;

	/**
	 * [ADM_SYS_0014]<br>
	 * User List 정보를 조회<br>
	 *
	 * @param UserInquiryVO userInquiryVO
	 * @return List<UserInquiryVO>
	 * @exception EventException
	 */
	public List<UserInquiryVO> searchUsrList(UserInquiryVO userInquiryVO) throws EventException;

	/**
	 * [ADM_SYS_0014]<br>
	 * User Inquiry 정보를 일괄적으로 수정<br>
	 *
	 * @param UserInquiryVO[] userInquiryVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageUsrList(UserInquiryVO[] userInquiryVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ADM_SYS_0015]<br>
	 * JOB Code Requst Count를 가져옴<br>
	 *
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String getRequestCount(String usrId) throws EventException;

	/**
	 * [ADM_SYS_0015]<br>
	 * JOB Code Adjust Requst 리스트를 조회<br>
	 *
	 * @param AdjustmentVO adjustmentVO
	 * @param SignOnUserAccount account
	 * @return List<AdjustmentVO>
	 * @exception EventException
	 */
	public List<AdjustmentVO> searchAdjustmentRequest(AdjustmentVO adjustmentVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ADM_SYS_0015]<br>
	 * JOB Code Adjust Requst 리스트를 일괄적으로 수정<br>
	 *
	 * @param AdjustmentVO[] adjustmentVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAdjustmentRequest(AdjustmentVO[] adjustmentVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ADM_SYS_0016]<br>
	 * 최근 Aproval User ID, Name을 가져옴<br>
	 *
	 * @param String usrId
	 * @return List<AdjustmentVO>
	 * @exception EventException
	 */
	public List<AdjustmentVO> getApprovalUserInfo(String usrId) throws EventException;

	/**
	 * [ADM_SYS_0016]<br>
	 * Job 신청 LIST를 조회<br>
	 *
	 * @param RequestVO requestVO
	 * @return List<RequestVO>
	 * @exception EventException
	 */
	public List<RequestVO> searchJobCodeRequest(RequestVO requestVO) throws EventException;

	/**
	 * [ADM_SYS_0016]<br>
	 * Job 신청 LIST 정보를 일괄적으로 수정<br>
	 *
	 * @param AdjustmentVO adjustmentVO
	 * @param RequestVO[] requestVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageJobCodeRequest(AdjustmentVO adjustmentVO, RequestVO[] requestVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ADM_SYS_0017]<br>
	 * Approver의 Office Code를 가져옴<br>
	 *
	 * @param String aproUsrId
	 * @return String
	 * @exception EventException
	 */
	public String getApproverOfcInfo(String aproUsrId) throws EventException;

	/**
	 * [ADM_SYS_0018]<br>
	 * Job Code 요청 목록을 조회<br>
	 *
	 * @param AdjustmentVO adjustmentVO
	 * @param SignOnUserAccount account
	 * @return List<AdjustmentVO>
	 * @exception EventException
	 */
	public List<AdjustmentVO> searchAdjustmentApproval(AdjustmentVO adjustmentVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ADM_SYS_0019], [ADM_SYS_0022]<br>
	 * Job 신청내역 상세 LIST를 조회<br>
	 *
	 * @param RequestVO requestVO
	 * @return List<RequestVO>
	 * @exception EventException
	 */
	public List<RequestVO> searchRequestDetail(RequestVO requestVO) throws EventException;

	/**
	 * [ADM_SYS_0019]<br>
	 * 신청된 Job에 대한 Approval/Reject 정보를 저장<br>
	 *
	 * @param AdjustmentVO adjustmentVO
	 * @param RequestVO[] requestVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageApproval(AdjustmentVO adjustmentVO, RequestVO[] requestVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ADM_SYS_0020]<br>
	 * 사용자가 Job Code 정보를 조회<br>
	 *
	 * @param JobCodeInquiryVO jobCodeInquiryVO
	 * @return List<JobCodeInquiryVO>
	 * @exception EventException
	 */
	public List<JobCodeInquiryVO> searchJobCodeInquiry(JobCodeInquiryVO jobCodeInquiryVO) throws EventException;

	/**
	 * [ADM_SYS_0021]<br>
	 * Job Code 신청/승인 현황을 조회<br>
	 *
	 * @param AdjustmentVO adjustmentVO
	 * @return List<AdjustmentVO>
	 * @exception EventException
	 */
	public List<AdjustmentVO> searchJobCodeManagementMonitoring(AdjustmentVO adjustmentVO) throws EventException;

	/**
	 * [ADM_SYS_0023]<br>
	 * Program Job Code Mapping 정보를 조회<br>
	 *
	 * @param JobCodeManagementVO jobCodeManagementVO
	 * @return List<JobCodeManagementVO>
	 * @exception EventException
	 */
	public List<JobCodeManagementVO> searchProgramCodeMappingList(JobCodeManagementVO jobCodeManagementVO) throws EventException;
	
	/**
	 * [ADM_SYS_0024]<br>
	 * Approver List를 조회하는 화면<br>
	 *
	 * @param ApproverVO approverVO
	 * @return List<ApproverVO>
	 * @exception EventException
	 */
	public List<ApproverVO> searchApproverManagement(ApproverVO approverVO) throws EventException;
	
	/**
	 * [ADM_SYS_0024]<br>
	 * Approver List를 일괄적으로 삭제<br>
	 *
	 * @param ApproverVO[] approverVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageApproverManagement(ApproverVO[] approverVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [ADM_SYS_0020], [ADM_SYS_0025]<br>
	 * Approver ID가 이미 존재하는지 확인<br>
	 *
	 * @param String aproUsrId
	 * @return List<ApproverVO>
	 * @exception EventException
	 */
	public List<ApproverVO> getApproverUsrId(String aproUsrId) throws EventException;
	
	/**
	 * [ADM_SYS_0025]<br>
	 * Approver User Id 저장<br>
	 *
	 * @param ApproverVO[] approverVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageApproverUsrId(ApproverVO[] approverVOs, SignOnUserAccount account) throws EventException;


}