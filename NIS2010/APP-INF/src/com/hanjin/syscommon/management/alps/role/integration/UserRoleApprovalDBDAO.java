/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UserRoleApprovalDBDAO.java
*@FileTitle : Role Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.role.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ComAproRoleDtlVO;
import com.hanjin.syscommon.common.table.ComAproRoleRqstHdrVO;
import com.hanjin.syscommon.common.table.ComAproRoleRqstRoutVO;
import com.hanjin.syscommon.common.table.ComUsrRoleMtchVO;
import com.hanjin.syscommon.management.alps.role.basic.UserRoleApprovalBCImpl;
import com.hanjin.syscommon.management.alps.role.vo.AuthorityVO;
import com.hanjin.syscommon.management.alps.role.vo.ComUsrRoleConditionVO;
import com.hanjin.syscommon.management.alps.role.vo.MenuListVO;
import com.hanjin.syscommon.management.alps.role.vo.SearchModulePicVO;
import com.hanjin.syscommon.management.alps.role.vo.UserRoleAuthAproVO;
import com.hanjin.syscommon.management.alps.role.vo.UserRoleRqstEmlVO;


/**
 * ALPS UserRoleApprovalDBDAO <br>
 * - ALPS-UserRoleApproval system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see UserRoleApprovalBCImpl 참조
 * @since J2EE 1.6
 */
public class UserRoleApprovalDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param MenuListVO menuListVO
	 * @return List<MenuListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MenuListVO> selectMenuList(MenuListVO menuListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MenuListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(menuListVO != null){
				Map<String, String> mapVO = menuListVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserRoleApprovalDBDAOMenuListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MenuListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * [처리대상] 모듈별로 role을 가져온다.<br>
	 * 
	 * @param String subSysCd
	 * @param String usr_id
	 * @return List<ComUsrRoleConditionVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ComUsrRoleConditionVO> selectModuleRole(String subSysCd, String usr_id) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComUsrRoleConditionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(subSysCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("sub_sys_cd", subSysCd);
				mapVO.put("usr_id", usr_id);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserRoleApprovalDBDAOModuleRoleRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComUsrRoleConditionVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * [COM_SEC_0002]<br>
	 * 새로운 APRO_RQST_NO를 가져오기<br>
	 *
	 * @return String
	 * @exception DAOException
	 */
	public String getNewAproRqstNo() throws DAOException {
		DBRowSet dbRowset = null;
		String aproRqstNo = "";

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserRoleApprovalDBDAOGetNewAproRqstNoRSQLRSQL(), null, null);
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
	 * [COM_SEC_0002]<br>
	 * User Role 신청 LIST 정보를 COM_APRO_ROLE_RQST_HDR 테이블에 일괄적으로 추가<br>
	 *
	 * @param List<ComAproRoleRqstHdrVO> models
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addUserRoleRpst(List<ComAproRoleRqstHdrVO> models) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(models.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new UserRoleApprovalDBDAOAddAproRoleRqstHdrCSQL(), models, null);
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
	 * [COM_SEC_0002]<br>
	 * User Role 신청 LIST 정보를 COM_APRO_ROLE_RQST_ROUT 테이블에 일괄적으로 추가<br>
	 *
	 * @param List<ComAproRoleRqstRoutVO> models
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addUserRoleRqstRout(List<ComAproRoleRqstRoutVO> models) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(models.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new UserRoleApprovalDBDAOAddAproRoleRqstRoutCSQL(), models, null);
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
	 * [COM_SEC_0002]<br>
	 * User Role 신청 LIST 정보를 COM_APRO_ROLE_DTL 테이블에 일괄적으로 추가(신규추가/삭제)<br>
	 *
	 * @param List<ComAproRoleDtlVO> requestVOList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addUserRoleRqstDtl(List<ComAproRoleDtlVO> requestVOList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(requestVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new UserRoleApprovalDBDAOAddAproRoleDtlCSQL(), requestVOList, null);
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
	 * user role 신청 조회<br>
	 * 
	 * @param String usr_id
	 * @param String usr_auth_tp_cd
	 * @return List<UserRoleAuthAproVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<UserRoleAuthAproVO> selectUserRoleAuthAproList(String usr_id, String usr_auth_tp_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<UserRoleAuthAproVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();


		try{
			if(usr_id != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("usr_id", usr_id);
				mapVO.put("usr_auth_tp_cd", usr_auth_tp_cd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserRoleApprovalDBDAOSearchRoleAuthAproRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UserRoleAuthAproVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * User Role Approval 정보를 갱신합니다.<br>
	 * 
	 * @param List<ComAproRoleRqstRoutVO> updateVoList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyUserRoleAuthApro(List<ComAproRoleRqstRoutVO> updateVoList) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(updateVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new UserRoleApprovalDBDAOModifyAproRoleRqstRoutUSQL(), updateVoList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * User Role Approval DTL 정보를 갱신합니다.<br>
	 * 
	 * @param List<ComAproRoleDtlVO> updateVoList
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyUserRoleRqstDtl(List<ComAproRoleDtlVO> updateVoList) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(updateVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new UserRoleApprovalDBDAOModifyAproRoleDtlUSQL(), updateVoList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * User Role Match 정보를 Add합니다.<br>
	 * 
	 * @param List<ComUsrRoleMtchVO> models
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addUserRoleMatch(List<ComUsrRoleMtchVO> models) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("usr_role_adm_mtch", "N");
			
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SysComDB");
			int insCnt[] = null;
			if(models.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new UserMappingDAOComUsrRoleMtchCSQL(), models, velParam);
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
	 * User Role Match 정보를 삭제합니다.<br>
	 * 
	 * @param List<ComUsrRoleMtchVO> models
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeUserRoleMatch(List<ComUsrRoleMtchVO> models) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("usr_role_adm_mtch", "N");
			
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SysComDB");
			int insCnt[] = null;
			if(models.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new UserMappingDAOComUsrRoleMtchDSQL(), models, velParam);
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
	 * superUser Role Module 조회<br>
	 * 
	 * @param String usr_id
	 * @return List<UserRoleAuthAproVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<UserRoleAuthAproVO> selectSuperUserRoleModule(String usr_id) throws DAOException {
		DBRowSet dbRowset = null;
		List<UserRoleAuthAproVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(usr_id != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("usr_id", usr_id);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserRoleApprovalDBDAOSuperUserRoleModRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UserRoleAuthAproVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
 	/**
	 * [COM_SEC_0004]<br>
	 * ALPS Role Authority Approval Monitoring<br>
	 *
	 * @param HashMap<String, String> param
	 * @return List<AuthorityVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<AuthorityVO> getApprovalList(HashMap<String, String> param) throws DAOException {
			DBRowSet dbRowset = null;
			List<AuthorityVO> list = null;

			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserRoleApprovalDBDAOSearchRoleAuthorityApprovalMonitoringRSQL(), param, param);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AuthorityVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
	 	 
	/**
	 * [COM_SEC_0003]<br>
	 * ALPS Role Validation Check<br>
	 * 
	 * @param String rqstRoleCd
	 * @param String rqstUsrId
	 * @return String
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public String selectRqstRoleCd(String rqstRoleCd, String rqstUsrId) throws DAOException {
		DBRowSet dbRowset = null;
		String returnVal = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rqst_usr_id", rqstUsrId);
			mapVO.put("rqst_role_cd", rqstRoleCd);

			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UserRoleApprovalDBDAOSearchRqstRoleCdRSQL(), param, null);

			if (dbRowset.next()) {
				returnVal = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVal;
	}
		 

 	/**
	 * [COM_SEC_0001]<br>
	 * ALPS Role Rqst Search List<br>
	 *
	 * @param List<String> rqstList
	 * @return List<UserRoleAuthAproVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UserRoleAuthAproVO> selectRqstRoleList(List<String> rqstList) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<UserRoleAuthAproVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rqstList != null && rqstList.size() > 0){
				param.put("apro_rqst_no", (String) rqstList.get(0));
				velParam.put("apro_rqst_no", rqstList);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserRoleApprovalDBDAOSearchRoleAuthAproRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UserRoleAuthAproVO .class);
			
			
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**'
	 * [COM_SEC_0001]<br>
	 * Role Request 후 Approval 담당자에게 메일을 발송합니다<br>
	 * 
	 * @param UserRoleRqstEmlVO emlVo
	 * @return String
	 * @exception EAIException 
	 */	
	public String sendRoleRqstMail(UserRoleRqstEmlVO emlVo) throws Exception, MailerAppException {	
		String emlSndNo = "";
		
		try {
			
				log.debug("############################ Mail Send Start #########################");
				Mail mail = new Mail();
				mail.setFrom(emlVo.getSendUsrEmail());
				
				mail.setSubject(emlVo.getSubject());
				mail.setRecipient(emlVo.getReceiptUsrEmail());
				log.debug("Receipt Mail :::: " + emlVo.getReceiptUsrEmail());
				//mail.setRecipient("kkh25@cyberlogitec.com");
				mail.setHtmlContent(emlVo.getContent());
				
				//발송
				emlSndNo = mail.send();
				log.debug("############################ Mail Send End #########################");
			
		} catch (MailerAppException mae) {
			throw new Exception(mae.getMessage(), mae);
		} catch (Exception e){
			throw new Exception(e.getMessage(), e);
		}
		
		return emlSndNo;
	}
	
 	/**
	 * [COM_SEC_0001]<br>
	 * ALPS Role Super User Email List<br>
	 *
	 * @param String roleModule
	 * @return List<SearchModulePicVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchModulePicVO> selectModulePicList(String roleModule) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<SearchModulePicVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(roleModule != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("role_module", roleModule);

				param.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserRoleApprovalDBDAOSearchModulePicRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchModulePicVO.class);
			
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
}