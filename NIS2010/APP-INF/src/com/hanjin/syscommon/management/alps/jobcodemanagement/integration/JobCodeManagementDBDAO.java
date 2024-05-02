/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JobCodeManagementDBDAO.java
*@FileTitle : JobCodeManagementDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.17
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.04.17 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.management.alps.jobcodemanagement.basic.JobCodeManagementBCImpl;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.AdjustmentVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.ApproverVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.JobCodeInquiryVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.JobCodeManagementVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.MenuListVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.OfficeMappingVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.RequestVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.UserInquiryVO;


/**
 * ALPS JobCodeManagementDBDAO <br>
 * - ALPS-GeneralManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author DukWoo Choi
 * @see JobCodeManagementBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class JobCodeManagementDBDAO extends DBDAOSupport {

	/**
	 * [ADM_SYS_0011]<br>
	 * JOB Code의 정보를 조회<br>
	 *
	 * @param JobCodeManagementVO jobCodeManagementVO
	 * @return List<JobCodeManagementVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<JobCodeManagementVO> searchJobCodeManagement(JobCodeManagementVO jobCodeManagementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JobCodeManagementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (jobCodeManagementVO != null) {
				Map<String, String> mapVO = jobCodeManagementVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOSearchJobCodeManagementRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JobCodeManagementVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ADM_SYS_0011]<br>
	 * JOB Code Count를 가져옴<br>
	 *
	 * @param String usrRoleCd
	 * @return String
	 * @exception DAOException
	 */
	public String getJobCodeCount(String usrRoleCd) throws DAOException {
		DBRowSet dbRowset = null;
		String jobCodeKnt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (usrRoleCd != null && !"".equals(usrRoleCd)) {
				param.put("usr_role_cd", usrRoleCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOGetJobCodeCountRSQL(), param, null);
			if(dbRowset.next()) {
				jobCodeKnt = dbRowset.getString("JOB_CODE_KNT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return jobCodeKnt;
	}

	/**
	 * [ADM_SYS_0011]<br>
	 * JOB Code 리스트를 일괄적으로 추가<br>
	 *
	 * @param List<JobCodeManagementVO> jobCodeManagementVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addJobCodeManagement(List<JobCodeManagementVO> jobCodeManagementVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(jobCodeManagementVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAOAddJobCodeManagementCSQL(), jobCodeManagementVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0011]<br>
	 * JOB Code 리스트를 일괄적으로 수정<br>
	 *
	 * @param List<JobCodeManagementVO> jobCodeManagementVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyJobCodeManagement(List<JobCodeManagementVO> jobCodeManagementVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(jobCodeManagementVOList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAOModifyJobCodeManagementUSQL(), jobCodeManagementVOList, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0011]<br>
	 * JOB Code 리스트를 일괄적으로 삭제<br>
	 *
	 * @param List<JobCodeManagementVO> jobCodeManagementVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeJobCodeManagement(List<JobCodeManagementVO> jobCodeManagementVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(jobCodeManagementVOList.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAORemoveJobCodeManagementDSQL(), jobCodeManagementVOList, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0012]<br>
	 * Job Code에 Office Mapping을 위한 LIST 조회<br>
	 *
	 * @param OfficeMappingVO officeMappingVO
	 * @return List<OfficeMappingVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OfficeMappingVO> searchOfficeMapping(OfficeMappingVO officeMappingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfficeMappingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (officeMappingVO != null) {
				Map<String, String> mapVO = officeMappingVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOSearchOfficeMappingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeMappingVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ADM_SYS_0012]<br>
	 * JOB Code Office Mapping 정보를 일괄적으로 추가<br>
	 *
	 * @param List<OfficeMappingVO> officeMappingVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addOfficeMapping(List<OfficeMappingVO> officeMappingVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(officeMappingVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAOAddOfficeMappingCSQL(), officeMappingVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0012]<br>
	 * JOB Code Office Mapping 정보를 일괄적으로 삭제<br>
	 *
	 * @param List<OfficeMappingVO> officeMappingVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeOfficeMapping(List<OfficeMappingVO> officeMappingVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(officeMappingVOList.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAORemoveOfficeMappingDSQL(), officeMappingVOList, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0013]<br>
	 * Menu List 정보를 조회<br>
	 *
	 * @param MenuListVO menuListVO
	 * @return List<MenuListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MenuListVO> searchMenuList(MenuListVO menuListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MenuListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (menuListVO != null) {
				Map<String, String> mapVO = menuListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOSearchMenuListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MenuListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ADM_SYS_0013]<br>
	 * Program List 정보를 조회<br>
	 *
	 * @param MenuListVO menuListVO
	 * @return List<MenuListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MenuListVO> searchProgramList(MenuListVO menuListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MenuListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (menuListVO != null) {
				Map<String, String> mapVO = menuListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOSearchProgramListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MenuListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ADM_SYS_0013]<br>
	 * Program Assign 정보를 일괄적으로 추가<br>
	 *
	 * @param List<MenuListVO> menuListVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addProgramList(List<MenuListVO> menuListVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(menuListVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAOAddProgramListCSQL(), menuListVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0013]<br>
	 * Program Assign 정보를 일괄적으로 삭제<br>
	 *
	 * @param List<MenuListVO> menuListVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeProgramList(List<MenuListVO> menuListVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(menuListVOList.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAORemoveProgramListDSQL(), menuListVOList, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0014]<br>
	 * Office List 정보를 조회<br>
	 *
	 * @param UserInquiryVO userInquiryVO
	 * @return List<UserInquiryVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<UserInquiryVO> searchOfficeList(UserInquiryVO userInquiryVO) throws  DAOException {
		DBRowSet dbRowset = null;
		List<UserInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (userInquiryVO != null) {
				Map<String, String> mapVO = userInquiryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOSearchOfficeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UserInquiryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ADM_SYS_0014]<br>
	 * User List 정보를 조회<br>
	 *
	 * @param UserInquiryVO userInquiryVO
	 * @return List<UserInquiryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<UserInquiryVO> searchUsrList(UserInquiryVO userInquiryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UserInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (userInquiryVO != null) {
				Map<String, String> mapVO = userInquiryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOSearchUsrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UserInquiryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ADM_SYS_0014]<br>
	 * User Inquiry 정보를 일괄적으로 추가<br>
	 *
	 * @param List<UserInquiryVO> userInquiryVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addUsrList(List<UserInquiryVO> userInquiryVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(userInquiryVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAOAddUsrListCSQL(), userInquiryVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0014]<br>
	 * User Inquiry 정보를 일괄적으로 삭제<br>
	 *
	 * @param List<UserInquiryVO> userInquiryVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeUsrList(List<UserInquiryVO> userInquiryVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(userInquiryVOList.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAORemoveUsrListDSQL(), userInquiryVOList, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0015]<br>
	 * JOB Code Requst Count를 가져옴<br>
	 *
	 * @param String usrId
	 * @return String
	 * @exception DAOException
	 */
	public String getRequestCount(String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		String rqstKnt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (usrId != null && !"".equals(usrId)) {
				param.put("rqst_usr_id", usrId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOGetRequestCountRSQL(), param, null);
			if(dbRowset.next()) {
				rqstKnt = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rqstKnt;
	}

	/**
	 * [ADM_SYS_0015]<br>
	 * JOB Code Adjust Requst 리스트를 조회<br>
	 *
	 * @param AdjustmentVO adjustmentVO
	 * @return List<AdjustmentVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AdjustmentVO> searchAdjustmentRequest(AdjustmentVO adjustmentVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AdjustmentVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (adjustmentVO != null) {
				Map<String, String> mapVO = adjustmentVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOSearchAdjustmentRequestRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AdjustmentVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ADM_SYS_0015]<br>
	 * JOB Code Adjust Requst 리스트를 일괄적으로 수정<br>
	 *
	 * @param List<AdjustmentVO> adjustmentVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyAdjustmentRequest(List<AdjustmentVO> adjustmentVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(adjustmentVOList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAOModifyAdjustmentRequestUSQL(), adjustmentVOList, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0015]<br>
	 * JOB Code Adjust Requst 리스트를 일괄적으로 수정(COM_APRO_ROLE_RQST_ROUT 테이블의 상태값을 "A"로 변경)<br>
	 *
	 * @param List<AdjustmentVO> adjustmentVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyAdjustmentRequestRout(List<AdjustmentVO> adjustmentVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(adjustmentVOList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAOModifyAdjustmentRequestRoutUSQL(), adjustmentVOList, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ADM_SYS_0015]<br>
	 * JOB Code Adjust Requst 리스트를 일괄적으로 수정(COM_APRO_ROLE_DTL 테이블의 상태값을 "A"로 변경)<br>
	 *
	 * @param List<AdjustmentVO> adjustmentVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyAdjustmentDtl(List<AdjustmentVO> adjustmentVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(adjustmentVOList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAOModifyAdjustmentDtlUSQL(), adjustmentVOList, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0016]<br>
	 * 최근 Aproval User ID, Name을 가져옴<br>
	 *
	 * @param String usrId
	 * @return List<AdjustmentVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AdjustmentVO> getApprovalUserInfo(String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		List<AdjustmentVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (usrId != null && !"".equals(usrId)) {
				param.put("rqst_usr_id", usrId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOGetApprovalUserInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AdjustmentVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ADM_SYS_0016]<br>
	 * Job 신청 LIST를 조회<br>
	 *
	 * @param RequestVO requestVO
	 * @return List<RequestVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RequestVO> searchJobCodeRequest(RequestVO requestVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RequestVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (requestVO != null) {
				Map<String, String> mapVO = requestVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOSearchJobCodeRequestRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RequestVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ADM_SYS_0016]<br>
	 * 새로운 APRO_RQST_NO를 가져오기<br>
	 *
	 * @return String
	 * @exception DAOException
	 */
	public String getNewAproRqstNo() throws DAOException {
		DBRowSet dbRowset = null;
		String aproRqstNo = "";

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOGetNewAproRqstNoRSQL(), null, null);
			if(dbRowset.next()) {
				aproRqstNo = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return aproRqstNo;
	}

	/**
	 * [ADM_SYS_0016]<br>
	 * Job 신청 LIST 정보를 COM_APRO_ROLE_RQST_HDR 테이블에 일괄적으로 추가<br>
	 *
	 * @param List<AdjustmentVO> adjustmentVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addJobCodeRqstHdr(List<AdjustmentVO> adjustmentVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(adjustmentVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAOAddJobCodeRqstHdrCSQL(), adjustmentVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0016]<br>
	 * Job 신청 LIST 정보를 COM_APRO_ROLE_RQST_ROUT 테이블에 일괄적으로 추가<br>
	 *
	 * @param List<AdjustmentVO> adjustmentVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addJobCodeRqstRout(List<AdjustmentVO> adjustmentVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(adjustmentVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAOAddJobCodeRqstRoutCSQL(), adjustmentVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0016]<br>
	 * Job 신청 LIST 정보를 COM_APRO_ROLE_DTL 테이블에 일괄적으로 추가(신규추가/삭제)<br>
	 *
	 * @param List<RequestVO> requestVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addJobCodeRqstDtl(List<RequestVO> requestVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(requestVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAOAddJobCodeRqstDtlCSQL(), requestVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0017]<br>
	 * Approver의 Office Code를 가져옴<br>
	 *
	 * @param String aproUsrId
	 * @return String
	 * @exception DAOException
	 */
	public String getApproverOfcInfo(String aproUsrId) throws DAOException {
		DBRowSet dbRowset = null;
		String aproOfcCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (aproUsrId != null && !"".equals(aproUsrId)) {
				param.put("apro_usr_id", aproUsrId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOGetApproverOfcInfoRSQL(), param, null);
			if(dbRowset.next()) {
				aproOfcCd = dbRowset.getString("APRO_OFC_CD");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return aproOfcCd;
	}

	/**
	 * [ADM_SYS_0018]<br>
	 * Job Code 요청 목록을 조회<br>
	 *
	 * @param AdjustmentVO adjustmentVO
	 * @return List<AdjustmentVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AdjustmentVO> searchAdjustmentApproval(AdjustmentVO adjustmentVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AdjustmentVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (adjustmentVO != null) {
				Map<String, String> mapVO = adjustmentVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOSearchAdjustmentApprovalRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AdjustmentVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ADM_SYS_0019], [ADM_SYS_0022]<br>
	 * Job 신청 상세 LIST를 조회<br>
	 *
	 * @param RequestVO requestVO
	 * @return List<RequestVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RequestVO> searchRequestDetail(RequestVO requestVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RequestVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (requestVO != null) {
				Map<String, String> mapVO = requestVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOSearchRequestDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RequestVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ADM_SYS_0019]<br>
	 * 신청된 Job에 대한 Approval/Reject 정보를 COM_APRO_ROLE_RQST_ROUT에 저장<br>
	 *
	 * @param AdjustmentVO adjustmentVO
	 * @exception DAOException
	 */
	public void modifyApprovalRout(AdjustmentVO adjustmentVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (adjustmentVO != null) {
				Map<String, String> mapVO= adjustmentVO.getColumnValues();

				param.putAll(mapVO);
			}
			int uptCnt = sqlExe.executeUpdate((ISQLTemplate) new JobCodeManagementDBDAOModifyApprovalRoutUSQL(), param, null);
			if (uptCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0019]<br>
	 * 신청된 Job에 대한 Approval/Reject 정보를 COM_APRO_ROLE_RQST_HDR에 저장<br>
	 *
	 * @param AdjustmentVO adjustmentVO
	 * @exception DAOException
	 */
	public void modifyApprovalHdr(AdjustmentVO adjustmentVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (adjustmentVO != null) {
				Map<String, String> mapVO= adjustmentVO.getColumnValues();

				param.putAll(mapVO);
			}
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new JobCodeManagementDBDAOModifyApprovalHdrUSQL(), param, null);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0019]<br>
	 * 신청된 Job에 대한 Approval/Reject 정보를 COM_APRO_ROLE_RQST_DTL에 저장<br>
	 *
	 * @param List<RequestVO> requestVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyApprovalDtl(List<RequestVO> requestVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(requestVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAOModifyApprovalDtlUSQL(), requestVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0019]<br>
	 * Approval된 Job Code목록중 사용목록을 COM_USR_ROLE_MTCH에 저장<br>
	 *
	 * @param List<RequestVO> requestVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addJobCodeRoleMtch(List<RequestVO> requestVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(requestVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAOAddJobCodeRoleMtchCSQL(), requestVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0019]<br>
	 * Approval된 Job Code목록중 삭제목록을 COM_USR_ROLE_MTCH에서 삭제<br>
	 *
	 * @param List<RequestVO> requestVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeJobCodeRoleMtch(List<RequestVO> requestVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(requestVOList.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAORemoveJobCodeRoleMtchDSQL(), requestVOList, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ADM_SYS_0020]<br>
	 * 사용자가 Job Code 정보를 조회<br>
	 *
	 * @param JobCodeInquiryVO jobCodeInquiryVO
	 * @return List<JobCodeInquiryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<JobCodeInquiryVO> searchJobCodeInquiry(JobCodeInquiryVO jobCodeInquiryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JobCodeInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (jobCodeInquiryVO != null) {
				Map<String, String> mapVO = jobCodeInquiryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOSearchJobCodeInquiryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JobCodeInquiryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ADM_SYS_0021]<br>
	 * Job Code 신청/승인 현황을 조회<br>
	 *
	 * @param AdjustmentVO adjustmentVO
	 * @return List<AdjustmentVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AdjustmentVO> searchJobCodeManagementMonitoring(AdjustmentVO adjustmentVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AdjustmentVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (adjustmentVO != null) {
				Map<String, String> mapVO = adjustmentVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOSearchJobCodeManagementMonitoringRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AdjustmentVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ADM_SYS_0023]<br>
	 * Program Job Code Mapping 정보를 조회<br>
	 *
	 * @param JobCodeManagementVO jobCodeManagementVO
	 * @return List<JobCodeManagementVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<JobCodeManagementVO> searchProgramCodeMappingList(JobCodeManagementVO jobCodeManagementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JobCodeManagementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (jobCodeManagementVO != null) {
				Map<String, String> mapVO = jobCodeManagementVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOSearchProgramCodeMappingListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JobCodeManagementVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	 * [ADM_SYS_0024]<br>
	 * Approver List를 조회하는 화면<br>
	 *
	 * @param ApproverVO ApproverVO
	 * @return List<ApproverVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ApproverVO> searchApproverManagement(ApproverVO approverVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApproverVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (approverVO != null) {
				Map<String, String> mapVO = approverVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOSearchApproverManagementRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApproverVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	 * [ADM_SYS_0024]<br>
	 * Approver List를 일괄적으로 삭제<br>
	 *
	 * @param List<ApproverVO> approverVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeApproverManagement(List<ApproverVO> approverVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(approverVOList.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAORemoveApproverManagementDSQL(), approverVOList, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	 /**
	  * [ADM_SYS_0020], [ADM_SYS_0025]<br>
	  * Approver ID가 이미 존재하는지 확인<br>
	  *
	  * @param String aproUsrId
	 * @return List<ApproverVO>
	  * @exception DAOException
	  */
	  @SuppressWarnings("unchecked")
	 public List<ApproverVO> getApproverUsrId(String aproUsrId) throws DAOException {
	 	DBRowSet dbRowset = null;
	 	List<ApproverVO> list = null;
	 	//query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();

	 	try{
	 		if (aproUsrId != null && !"".equals(aproUsrId)) {
	 			param.put("apro_usr_id", aproUsrId);
	 		}
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JobCodeManagementDBDAOGetApproverUsrIdRSQL(), param, null);
	 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApproverVO .class);
	 		
	 	} catch(SQLException se) {
	 		log.error(se.getMessage(), se);
	 		throw new DAOException(new ErrorHandler(se).getMessage());
	 	} catch(Exception ex) {
	 		log.error(ex.getMessage(), ex);
	 		throw new DAOException(new ErrorHandler(ex).getMessage());
	 	}
	 	return list;
	 }
	  
	 /**
	 * [ADM_SYS_0025]<br>
	 * Approver User Id 저장<br>
	 *
	 * @param List<ApproverVO> approverVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addApproverUsrId(List<ApproverVO> approverVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(approverVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JobCodeManagementDBDAOAddApproverUsrIdCSQL(), approverVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

}
