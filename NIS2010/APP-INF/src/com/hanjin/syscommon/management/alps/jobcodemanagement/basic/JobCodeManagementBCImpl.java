/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JobCodeManagementBCImpl.java
*@FileTitle : JobCodeManagementBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.17
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.04.17 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.management.alps.jobcodemanagement.integration.JobCodeManagementDBDAO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.AdjustmentVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.ApproverVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.JobCodeInquiryVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.JobCodeManagementVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.MenuListVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.OfficeMappingVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.RequestVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.UserInquiryVO;


/**
 * ALPS-JobCodeManagement Business Logic Basic Command implementation<br>
 * - ALPS-JobCodeManagement에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author DukWoo Choi
 * @see EventResponse, JobCodeManagementBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class JobCodeManagementBCImpl extends BasicCommandSupport implements JobCodeManagementBC {

	// Database Access Object
	private transient JobCodeManagementDBDAO dbDao = null;

	/**
	 * JobCodeManagementBCImpl 객체 생성<br>
	 * JobCodeManagementDBDAO 생성한다.<br>
	 */
	public JobCodeManagementBCImpl() {
		dbDao = new JobCodeManagementDBDAO();
	}

	/**
	 * [ADM_SYS_0011]<br>
	 * JOB Code의 정보를 조회<br>
	 *
	 * @param JobCodeManagementVO jobCodeManagementVO
	 * @return List<JobCodeManagementVO>
	 * @exception EventException
	 */
	public List<JobCodeManagementVO> searchJobCodeManagement(JobCodeManagementVO jobCodeManagementVO) throws EventException {
		try {
			return dbDao.searchJobCodeManagement(jobCodeManagementVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ADM_SYS_0011]<br>
	 * JOB Code Count를 가져옴<br>
	 *
	 * @param String usrRoleCd
	 * @return String
	 * @exception EventException
	 */
	public String getJobCodeCount(String usrRoleCd) throws EventException {
		try {
			return dbDao.getJobCodeCount(usrRoleCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ADM_SYS_0011]<br>
	 * JOB Code 리스트를 일괄적으로 수정<br>
	 *
	 * @param JobCodeManagementVO[] jobCodeManagementVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageJobCodeManagement(JobCodeManagementVO[] jobCodeManagementVOs, SignOnUserAccount account) throws EventException{
		try {
			List<JobCodeManagementVO> insertVoList = new ArrayList<JobCodeManagementVO>();
			List<JobCodeManagementVO> updateVoList = new ArrayList<JobCodeManagementVO>();
			List<JobCodeManagementVO> deleteVoList = new ArrayList<JobCodeManagementVO>();

			for (int i=0; i<jobCodeManagementVOs.length; i++ ) {
				jobCodeManagementVOs[i].setUpdUsrId(account.getUsr_id());
				if (jobCodeManagementVOs[i].getIbflag().equals("I")){
					insertVoList.add(jobCodeManagementVOs[i]);
				} else if (jobCodeManagementVOs[i].getIbflag().equals("U")){
					updateVoList.add(jobCodeManagementVOs[i]);
				} else if (jobCodeManagementVOs[i].getIbflag().equals("D")){
					deleteVoList.add(jobCodeManagementVOs[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addJobCodeManagement(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyJobCodeManagement(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeJobCodeManagement(deleteVoList);	//COM_USR_ROLE 테이블 데이터 삭제
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ADM_SYS_0012]<br>
	 * Job Code에 Office Mapping을 위한 LIST 조회<br>
	 *
	 * @param OfficeMappingVO OfficeMappingVO
	 * @return List<OfficeMappingVO>
	 * @exception EventException
	 */
	public List<OfficeMappingVO> searchOfficeMapping(OfficeMappingVO officeMappingVO) throws EventException {
		try {
			return dbDao.searchOfficeMapping(officeMappingVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * [ADM_SYS_0012]<br>
	 * JOB Code Office Mapping 정보를 일괄적으로 수정<br>
	 *
	 * @param OfficeMappingVO[] officeMappingVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOfficeMapping(OfficeMappingVO[] officeMappingVOs, SignOnUserAccount account) throws EventException{
		try {
			List<OfficeMappingVO> insertVoList = new ArrayList<OfficeMappingVO>();
			List<OfficeMappingVO> deleteVoList = new ArrayList<OfficeMappingVO>();

			for (int i=0; i<officeMappingVOs.length; i++ ) {
				officeMappingVOs[i].setCreUsrId(account.getUsr_id());
				officeMappingVOs[i].setUpdUsrId(account.getUsr_id());
				officeMappingVOs[i].setUsrRoleCd(officeMappingVOs[0].getUsrRoleCd());

				if (officeMappingVOs[i].getIbflag().equals("U")){
					if(officeMappingVOs[i].getCheckVal().equals("1")){
						insertVoList.add(officeMappingVOs[i]);
					} else {
						deleteVoList.add(officeMappingVOs[i]);
					}
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addOfficeMapping(insertVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeOfficeMapping(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ADM_SYS_0013]<br>
	 * Program List 정보를 조회<br>
	 *
	 * @param MenuListVO menuListVO
	 * @return List<MenuListVO>
	 * @exception EventException
	 */
	public List<MenuListVO> searchProgramList(MenuListVO menuListVO) throws EventException {
		try {
			return dbDao.searchProgramList(menuListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * [ADM_SYS_0013]<br>
	 * Menu List 정보를 조회<br>
	 *
	 * @param MenuListVO menuListVO
	 * @return List<MenuListVO>
	 * @exception EventException
	 */
	public List<MenuListVO> searchMenuList(MenuListVO menuListVO) throws EventException {
		try {
			return dbDao.searchMenuList(menuListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * [ADM_SYS_0013]<br>
	 * Program Assign 정보를 일괄적으로 수정<br>
	 *
	 * @param MenuListVO[] menuListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProgramList(MenuListVO[] menuListVOs, SignOnUserAccount account) throws EventException{
		try {
			List<MenuListVO> insertVoList = new ArrayList<MenuListVO>();
			List<MenuListVO> deleteVoList = new ArrayList<MenuListVO>();

			for (int i=0; i<menuListVOs.length; i++ ) {
				menuListVOs[i].setCreUsrId(account.getUsr_id());
				menuListVOs[i].setUpdUsrId(account.getUsr_id());
				menuListVOs[i].setUsrRoleCd(menuListVOs[0].getUsrRoleCd());

				if (menuListVOs[i].getIbflag().equals("U")){
					if(menuListVOs[i].getCheckVal().equals("1")){
						insertVoList.add(menuListVOs[i]);
					} else {
						deleteVoList.add(menuListVOs[i]);
					}
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addProgramList(insertVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeProgramList(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ADM_SYS_0014]<br>
	 * Office List 정보를 조회<br>
	 *
	 * @param UserInquiryVO userInquiryVO
	 * @return List<UserInquiryVO>
	 * @exception EventException
	 */
	public List<UserInquiryVO> searchOfficeList(UserInquiryVO userInquiryVO) throws EventException {
		try {
			return dbDao.searchOfficeList(userInquiryVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * [ADM_SYS_0014]<br>
	 * User List 정보를 조회<br>
	 *
	 * @param UserInquiryVO userInquiryVO
	 * @return List<UserInquiryVO>
	 * @exception EventException
	 */
	public List<UserInquiryVO> searchUsrList(UserInquiryVO userInquiryVO) throws EventException {
		try {
			return dbDao.searchUsrList(userInquiryVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * [ADM_SYS_0014]<br>
	 * User Inquiry 정보를 일괄적으로 수정<br>
	 *
	 * @param UserInquiryVO[] userInquiryVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageUsrList(UserInquiryVO[] userInquiryVOs, SignOnUserAccount account) throws EventException{
		try {
			List<UserInquiryVO> insertVoList = new ArrayList<UserInquiryVO>();
			List<UserInquiryVO> deleteVoList = new ArrayList<UserInquiryVO>();

			for (int i=0; i<userInquiryVOs.length; i++ ) {
				userInquiryVOs[i].setCreUsrId(account.getUsr_id());
				userInquiryVOs[i].setUpdUsrId(account.getUsr_id());
				userInquiryVOs[i].setUsrRoleCd(userInquiryVOs[0].getUsrRoleCd());

				if (userInquiryVOs[i].getIbflag().equals("U")){
					if(userInquiryVOs[i].getCheckVal().equals("1")){
						insertVoList.add(userInquiryVOs[i]);
					} else {
						deleteVoList.add(userInquiryVOs[i]);
					}
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addUsrList(insertVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeUsrList(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ADM_SYS_0015]<br>
	 * JOB Code Requst Count를 가져옴<br>
	 *
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String getRequestCount(String usrId) throws EventException {
		try {
			return dbDao.getRequestCount(usrId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ADM_SYS_0015]<br>
	 * JOB Code Adjust Requst 리스트를 조회<br>
	 *
	 * @param AdjustmentVO adjustmentVO
	 * @param SignOnUserAccount account
	 * @return List<AdjustmentVO>
	 * @exception EventException
	 */
	public List<AdjustmentVO> searchAdjustmentRequest(AdjustmentVO adjustmentVO, SignOnUserAccount account) throws EventException {
		try {
			adjustmentVO.setRqstUsrId(account.getUsr_id());
			return dbDao.searchAdjustmentRequest(adjustmentVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ADM_SYS_0015]<br>
	 * JOB Code Adjust Requst 리스트를 일괄적으로 수정<br>
	 *
	 * @param AdjustmentVO[] adjustmentVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAdjustmentRequest(AdjustmentVO[] adjustmentVOs, SignOnUserAccount account) throws EventException{
		try {
			List<AdjustmentVO> updateVoList = new ArrayList<AdjustmentVO>();
			for (int i=0; i<adjustmentVOs.length; i++ ) {
				adjustmentVOs[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(adjustmentVOs[i]);
			}

			if ( updateVoList.size() > 0 ) {
				//COM_APRO_ROLE_RQST_HDR 테이블의 상태를 'A'(취소)로 변경
				dbDao.modifyAdjustmentRequest(updateVoList);
				//COM_APRO_ROLE_RQST_ROUT 테이블의 상태를 'A'(취소)로 변경
				dbDao.modifyAdjustmentRequestRout(updateVoList);
				//COM_APRO_ROLE_DTL 테이블의 상태를 'A'(취소)로 변경
				dbDao.modifyAdjustmentDtl(updateVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ADM_SYS_0016]<br>
	 * 최근 Aproval User ID, Name을 가져옴<br>
	 *
	 * @param String usrId
	 * @return List<AdjustmentVO>
	 * @exception EventException
	 */
	public List<AdjustmentVO> getApprovalUserInfo(String usrId) throws EventException {
		try {
			return dbDao.getApprovalUserInfo(usrId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ADM_SYS_0016]<br>
	 * Job 신청 LIST를 조회<br>
	 *
	 * @param RequestVO requestVO
	 * @return List<RequestVO>
	 * @exception EventException
	 */
	public List<RequestVO> searchJobCodeRequest(RequestVO requestVO) throws EventException {
		try {
			return dbDao.searchJobCodeRequest(requestVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ADM_SYS_0016]<br>
	 * Job 신청 LIST 정보를 일괄적으로 수정<br>
	 *
	 * @param AdjustmentVO adjustmentVO
	 * @param RequestVO[] requestVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageJobCodeRequest(AdjustmentVO adjustmentVO, RequestVO[] requestVOs, SignOnUserAccount account) throws EventException{
		try {
			String aproRqstNo = dbDao.getNewAproRqstNo();
			//COM_APRO_ROLE_RQST_HDR, COM_APRO_ROLE_RQST_ROUT 테이블 저장
			List<AdjustmentVO> insRqstVOList = new ArrayList<AdjustmentVO>();
			adjustmentVO.setAproRqstNo(aproRqstNo);
			adjustmentVO.setRqstUsrNm(account.getUsr_nm());
			adjustmentVO.setRqstOfcNm(account.getOfc_eng_nm());
			adjustmentVO.setCreUsrId(account.getUsr_id());
			adjustmentVO.setUpdUsrId(account.getUsr_id());
			insRqstVOList.add(adjustmentVO);
			//COM_APRO_ROLE_RQST_HDR
			dbDao.addJobCodeRqstHdr(insRqstVOList);
			//COM_APRO_ROLE_RQST_ROUT
			dbDao.addJobCodeRqstRout(insRqstVOList);

			//COM_APRO_ROLE_DTL 저장
			List<RequestVO> insertVoList = new ArrayList<RequestVO>();
			//COM_APRO_ROLE_DTL 테이블 저장
			for (int i=0; i<requestVOs.length; i++ ) {
				requestVOs[i].setCreUsrId(account.getUsr_id());
				requestVOs[i].setUpdUsrId(account.getUsr_id());
				requestVOs[i].setAproRqstNo(aproRqstNo);
				if (requestVOs[i].getIbflag().equals("U")){
					if(requestVOs[i].getCheckVal().equals("1")){
						requestVOs[i].setUsrRoleRqstTpCd("I");
						insertVoList.add(requestVOs[i]);
					} else {
						requestVOs[i].setUsrRoleRqstTpCd("D");
						insertVoList.add(requestVOs[i]);
					}
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addJobCodeRqstDtl(insertVoList);	//COM_APRO_ROLE_DTL 테이블에 저장
			}
//			if (deleteVoList.size() > 0) {
//				dbDao.removeJobCodeRqstDtl(deleteVoList);
//			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ADM_SYS_0017]<br>
	 * Approver의 Office Code를 가져옴<br>
	 *
	 * @param String aproUsrId
	 * @return String
	 * @exception EventException
	 */
	public String getApproverOfcInfo(String aproUsrId) throws EventException {
		try {
			return dbDao.getApproverOfcInfo(aproUsrId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ADM_SYS_0018]<br>
	 * Job Code 요청 목록을 조회<br>
	 *
	 * @param AdjustmentVO adjustmentVO
	 * @param SignOnUserAccount account
	 * @return List<AdjustmentVO>
	 * @exception EventException
	 */
	public List<AdjustmentVO> searchAdjustmentApproval(AdjustmentVO adjustmentVO, SignOnUserAccount account) throws EventException {
		try {
			adjustmentVO.setRqstUsrId(account.getUsr_id());
			return dbDao.searchAdjustmentApproval(adjustmentVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ADM_SYS_0019], [ADM_SYS_0022]<br>
	 * Job 신청내역 상세 LIST를 조회<br>
	 *
	 * @param RequestVO requestVO
	 * @return List<RequestVO>
	 * @exception EventException
	 */
	public List<RequestVO> searchRequestDetail(RequestVO requestVO) throws EventException {
		try {
			return dbDao.searchRequestDetail(requestVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ADM_SYS_0019]<br>
	 * 신청된 Job에 대한 Approval/Reject 정보를 저장<br>
	 *
	 * @param AdjustmentVO adjustmentVO
	 * @param RequestVO[] requestVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageApproval(AdjustmentVO adjustmentVO, RequestVO[] requestVOs, SignOnUserAccount account) throws EventException{
		try {
			adjustmentVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyApprovalHdr(adjustmentVO);
			dbDao.modifyApprovalRout(adjustmentVO);

			List<RequestVO> insertVoList = new ArrayList<RequestVO>();
			List<RequestVO> deleteVoList = new ArrayList<RequestVO>();
			for (int i=0; i<requestVOs.length; i++ ) {
				requestVOs[i].setRqstUsrId(adjustmentVO.getRqstUsrId());  // RQST_USR_ID
				if (requestVOs[i].getUsrRoleRqstTpCd().equals("I")) {    // Add
					requestVOs[i].setCreUsrId(account.getUsr_id());
					requestVOs[i].setUpdUsrId(account.getUsr_id());
					requestVOs[i].setApstsCd(adjustmentVO.getApstsCd());
					insertVoList.add(requestVOs[i]);
				} else if (requestVOs[i].getUsrRoleRqstTpCd().equals("D")) {    // Del
					deleteVoList.add(requestVOs[i]);
				}
			}

			if ("C".equals(adjustmentVO.getApstsCd())) {    // Approval
				if (insertVoList.size() > 0) {
					dbDao.modifyApprovalDtl(insertVoList);
					dbDao.addJobCodeRoleMtch(insertVoList);
				}
				if (deleteVoList.size() > 0) {
					dbDao.removeJobCodeRoleMtch(deleteVoList);
				}

			} else if ("R".equals(adjustmentVO.getApstsCd())) {    // Reject
				if (insertVoList.size() > 0) {
					dbDao.modifyApprovalDtl(insertVoList);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ADM_SYS_0020]<br>
	 * 사용자가 Job Code 정보를 조회<br>
	 *
	 * @param JobCodeInquiryVO jobCodeInquiryVO
	 * @return List<JobCodeInquiryVO>
	 * @exception EventException
	 */
	public List<JobCodeInquiryVO> searchJobCodeInquiry(JobCodeInquiryVO jobCodeInquiryVO) throws EventException {
		try {
			return dbDao.searchJobCodeInquiry(jobCodeInquiryVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ADM_SYS_0021]<br>
	 * Job Code 신청/승인 현황을 조회<br>
	 *
	 * @param AdjustmentVO adjustmentVO
	 * @return List<AdjustmentVO>
	 * @exception EventException
	 */
	public List<AdjustmentVO> searchJobCodeManagementMonitoring(AdjustmentVO adjustmentVO) throws EventException {
		try {
			return dbDao.searchJobCodeManagementMonitoring(adjustmentVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ADM_SYS_0023]<br>
	 * Program Job Code Mapping 정보를 조회<br>
	 *
	 * @param JobCodeManagementVO jobCodeManagementVO
	 * @return List<JobCodeManagementVO>
	 * @exception EventException
	 */
	public List<JobCodeManagementVO> searchProgramCodeMappingList(JobCodeManagementVO jobCodeManagementVO) throws EventException {
		try {
			return dbDao.searchProgramCodeMappingList(jobCodeManagementVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ADM_SYS_0024]<br>
	 * Approver List를 조회하는 화면<br>
	 *
	 * @param ApproverVO approverVO
	 * @return List<ApproverVO>
	 * @exception EventException
	 */
	public List<ApproverVO> searchApproverManagement(ApproverVO approverVO) throws EventException {
		try {
			return dbDao.searchApproverManagement(approverVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ADM_SYS_0024]<br>
	 * Approver List를 일괄적으로 삭제<br>
	 *
	 * @param ApproverVO[] approverVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageApproverManagement(ApproverVO[] approverVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ApproverVO> deleteVoList = new ArrayList<ApproverVO>();

			for (int i=0; i<approverVOs.length; i++ ) {
				approverVOs[i].setUpdUsrId(account.getUsr_id());
				if (approverVOs[i].getIbflag().equals("D")){
					deleteVoList.add(approverVOs[i]);
				}
			}
			
			if (deleteVoList.size() > 0) {
				dbDao.removeApproverManagement(deleteVoList);	
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ADM_SYS_0020], [ADM_SYS_0025]<br>
	 * Approver ID가 이미 존재하는지 확인<br>
	 *
	 * @param String aproUsrId
	 * @return List<ApproverVO>
	 * @exception EventException
	 */
	public List<ApproverVO> getApproverUsrId(String aproUsrId) throws EventException {
		try {
			return dbDao.getApproverUsrId(aproUsrId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ADM_SYS_0025]<br>
	 * Approver User Id 저장<br>
	 *
	 * @param ApproverVO[] approverVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageApproverUsrId(ApproverVO[] approverVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ApproverVO> insertVoList = new ArrayList<ApproverVO>();

			for (int i=0; i<approverVOs.length; i++ ) {
				approverVOs[i].setUpdUsrId(account.getUsr_id());
				if (approverVOs[i].getIbflag().equals("U")){
					insertVoList.add(approverVOs[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addApproverUsrId(insertVoList);
			}		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}