/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UserDAO.java
*@FileTitle : User Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.02.19
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2009.02.19 김경범
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.user.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
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
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.management.alps.user.basic.UserBCImpl;
import com.hanjin.syscommon.management.alps.user.vo.ComUserInfoVO;
import com.hanjin.syscommon.management.alps.user.vo.ComUserVO;
import com.hanjin.syscommon.management.alps.user.vo.ComUsrPgmMtchVO;


/**
 * NIS2010 UserDAO <br>
 * - NIS2010-UserManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author KyungBum Kim
 * @see UserBCImpl 참조
 * @since J2EE 1.4
 */
public class UserDAO extends DBDAOSupport {

	/**
	 * UserDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ComUserVO comuservo 데이타 모델
	 * @param SignOnUserAccount account
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchComUserVO(ComUserVO comuservo, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comuservo != null){
				String rHQ = searchUserHeadQuarterInfo(account.getUsr_id());
				Map<String, String> mapVO = comuservo .getColumnValues();
			
				param.putAll(mapVO);
				param.put("s_usr_id", account.getUsr_id());
				param.put("id_div", comuservo.getCreUsrId());
				param.put("RHQ", rHQ);
				velParam.putAll(mapVO);
				velParam.put("id_div", comuservo.getCreUsrId());
				velParam.put("auth_cd", account.getUsr_auth_tp_cd());
				velParam.put("RHQ", rHQ);

				dbRowset = new SQLExecuter("SysComDB").executeQuery((ISQLTemplate)new UserDAOComUserVORSQL(), param, velParam);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	/**
	 * UserDAO의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param ComUsrPgmMtchVO[] comUsrPgmMtchVOs
	 * @param SignOnUserAccount account
	 * @see UserDAOEvent
	 * @throws DAOException
	 */
	public void multiComUsrPgmMtch(ComUsrPgmMtchVO[] comUsrPgmMtchVOs, SignOnUserAccount account) throws DAOException,Exception {
		Collection<ComUsrPgmMtchVO> insModels =new ArrayList<ComUsrPgmMtchVO>();
		Collection<ComUsrPgmMtchVO> delModels =new ArrayList<ComUsrPgmMtchVO>();

		try {
			ComUsrPgmMtchVO model = null;
			int cnt = comUsrPgmMtchVOs.length;
			for(int i=0;i<cnt;i++){
				model = (ComUsrPgmMtchVO)comUsrPgmMtchVOs[i];
				// 세션 정보 설정
				model.setCreUsrId(account.getUsr_id());
				model.setUpdUsrId(account.getUsr_id());
				if (model.getIbflag().length() > 0) {
					if (model.getIbflag().equals("I")) {
						insModels.add(model);
					}else{
						delModels.add(model);
					}
				}
			}
			int[] insCnt = null;
			int[] delCnt = null;
			
			SQLExecuter sqlExe = new SQLExecuter("SysComDB");
			
			if(insModels.size()>0){
				insCnt = sqlExe.executeBatch(new UserDAOComUsrPgmMtchCSQL(), insModels,null);
				for(int i=0;i<insCnt.length;i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}

			if(delModels.size()>0){
				for(int i=0;i<delModels.size();i++){
					if(comUsrPgmMtchVOs[i] != null){
						log.error("========== Delete usr_id : " + account.getUsr_id() + ", Delete Pgm NO : " + comUsrPgmMtchVOs[i].getPgmNo() + ", Delete User ID : " + comUsrPgmMtchVOs[i].getUsrId() + " ==========");
					}else{
						log.error("========== Delete usr_id : " + account.getUsr_id() + ", Delete Pgm NO : " + "model Object is null" + ", Delete User Role : " + "model Object is null" + " ==========");
					}
				}
				delCnt = sqlExe.executeBatch(new UserDAOComUsrPgmMtchDSQL(), delModels,null);
				for(int i=0;i<delCnt.length;i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * 
	 * @param flg
	 * @param usrId
	 * @param account
	 * @throws SQLException
	 * @throws DAOException
	 */
	public void multiComAppBaseMenuViewFlg(String flg, String usrId, SignOnUserAccount account) throws SQLException, DAOException{
		SQLExecuter sqlExe = new SQLExecuter("SysComDB");
		Map<String, String> param = new HashMap<String, String>();
		param.put("usr_id", usrId);
		param.put("view_flg", flg);
		param.put("cre_usr_id", account.getUsr_id());
		sqlExe.executeUpdate((ISQLTemplate)new UserDAOComAppBaseMenuViewUSQL(), param, null);
	}
	
	/**
	 * 
	 * main 화면에 대한 update 이벤트 처리<br>
	 * 
	 * @param ComUserVO comuservo
	 * @param SignOnUserAccount account
	 * @exception DAOException,Exception
	 */
	public void updateComUsrMain(ComUserVO comuservo, SignOnUserAccount account) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("SysComDB");
			comuservo.setUsrId(account.getUsr_id());
			comuservo.setUpdUsrId(account.getUsr_id());
			sqlExe.executeUpdate((ISQLTemplate)new UserDAOComUsrMainUSQL(), comuservo.getColumnValues(), null);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * user 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param ComUserVO[] comuservo
	 * @param SignOnUserAccount account
	 * @exception DAOException, Exception
	 */
	public void multiComUserVO(ComUserVO[] comuservo, SignOnUserAccount account) throws DAOException,Exception {
		
		ArrayList<ComUserVO> insModels = new ArrayList<ComUserVO>();
		ArrayList<ComUserVO> updModels = new ArrayList<ComUserVO>();
		ArrayList<ComUserVO> delModels = new ArrayList<ComUserVO>();

		try {
			ComUserVO model = null;
			for (int i = 0; i < comuservo .length; i++) {
				model = comuservo[i];
				// 세션 정보 설정
				model.setCreUsrId(account.getUsr_id());
				model.setUpdUsrId(account.getUsr_id());
				if (model.getIbflag().length() > 0) {
					if (model.getIbflag().equals("I")) {
						insModels.add(model);
					} else if (model.getIbflag().equals("U")) {
						updModels.add(model);
					} else if (model.getIbflag().equals("D")) {
						delModels.add(model);
					}
				}
			}
			int[] insCnt = null;
			int[] updCnt = null;
			int[] delCnt = null;

			SQLExecuter sqlExe = new SQLExecuter("SysComDB");
			
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new UserDAOComUserVOUSQL(), updModels,null);
				for(int i=0;i<updCnt.length;i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new UserDAOComUserVODSQL(), delModels,null);
				for(int i=0;i<delCnt.length;i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
			
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new UserDAOComUserVOCSQL(), insModels,null);
				for(int i=0;i<insCnt.length;i++){
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
	 * Office 리스트 조회 <br>
	 * 
	 * @param SignOnUserAccount account
	 * @param String rhq
	 * @param String arOfcCd
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchMdmOrganization(SignOnUserAccount account, String rhq, String arOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("ofc_cd",account.getOfc_cd());
			param.put("usr_auth_tp_cd", account.getUsr_auth_tp_cd());
			param.put("rhq", rhq);
			param.put("ar_ofc_cd", arOfcCd);
			
			//Dynamic query 테스트하기 위해 일부러 column list를 동적으로 생성함.
			List<String> cols  = new ArrayList<String>();
			cols.add("level");
			cols.add("ofc_cd");
			cols.add("ofc_eng_nm");
			cols.add("ofc_krn_nm");
			cols.add("prnt_ofc_cd");
			
			param.put("allcols", cols);
			
			dbRowset = new SQLExecuter("SysComDB").executeQuery((ISQLTemplate)new UserDAOMdmOrganizationRSQL(), param, param);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * User Program 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param String usrId
	 * @param String ofcCd
	 * @param String pgmNo
	 * @param String loginUsrId
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchUserProgramMapping(String usrId, String ofcCd, String pgmNo, String loginUsrId) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("usr_id",usrId);
			param.put("pgm_no",pgmNo);
			param.put("ofc_cd", ofcCd);
			param.put("login_usr_id", loginUsrId);
			
			dbRowset = new SQLExecuter("SysComDB").executeQuery((ISQLTemplate)new UserDAOComUsrPgmMtchRSQL(), param, param);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * 유저의 조직정보 중 지역본부코드를 가져온다.<br>
	 * 
	 * @param String usrId
	 * @return String headQuarterCd
	 * @exception DAOException
	 */
	public String searchUserHeadQuarterInfo(String usrId) throws DAOException {
		String headQuarterCd = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("usr_id", usrId);
		try {
			DBRowSet dbRowset = new SQLExecuter("SysComDB").executeQuery((ISQLTemplate)new MdmOrganizationDAOGetHeadQuarterCodeRSQL(), param, null);
			if ( dbRowset.next() ) headQuarterCd = dbRowset.getString("RHQ");
		} catch (SQLException e) {
			log.error(e.getMessage(),e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return headQuarterCd;
	}
	
	/**
	 * User Info의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String usrId
	 * @return List<ComUserInfoVO>
	 * @throws DAOException
	 */
	public List<ComUserInfoVO> getComUsrInfo(String userId) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComUserInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("usr_id", userId);
			dbRowset = new SQLExecuter("SysComDB").executeQuery((ISQLTemplate)new UserDBDAOInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComUserInfoVO.class);
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
	 * 유저의 조직정보 중 지역본부코드를 가져온다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchUserHeadQuarterInfoByOfcCd(String ofcCd) throws DAOException {
		String headQuarterCd = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ofc_cd", ofcCd);
		try {
			DBRowSet dbRowset = new SQLExecuter("SysComDB").executeQuery((ISQLTemplate)new MdmOrganizationDAOHeadQuarterCodeByOfcCdRSQL(), param, null);
			if ( dbRowset.next() ) headQuarterCd = dbRowset.getString("RHQ");
		} catch (SQLException e) {
			log.error(e.getMessage(),e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return headQuarterCd;
	}
	
	/**
	 * 유저의 조직정보 중 지역본부코드를 가져온다.<br>
	 * 
	 * @param String usrId
	 * @return String headQuarterCd
	 * @exception DAOException
	 */
	public String searchUserParentOffice(String usrId) throws DAOException {
		String headQuarterCd = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("usr_id", usrId);
		try {
			DBRowSet dbRowset = new SQLExecuter("SysComDB").executeQuery((ISQLTemplate)new UserDAOParentOfficeRSQL(), param, null);
			if ( dbRowset.next() ) headQuarterCd = dbRowset.getString("PRNT_OFC_CD");
		} catch (SQLException e) {
			log.error(e.getMessage(),e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return headQuarterCd;
	}
	
	/**
	 * DFLT_EML 업데이트<br>
	 * 업무 모듈에서 호출(BKG/DMT)<br>
	 * 
	 * @param String usrId
	 * @param String dfltEml
	 * @throws DAOException
	 */
	public void modifyDfltEml(String usrId, String dfltEml) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SysComDB");
			param.put("usr_id", usrId);
			param.put("dflt_eml", dfltEml);
			sqlExe.executeUpdate((ISQLTemplate)new UserDAOComUsrDfltEmlUSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * 업데이트<br>
	 * Adjusement Request 정보를 수신 한다.
	 * 
	 * @param ComUserVO comUsrVo
	 * @throws DAOException
	 */
	public void manageComUsrMbl(ComUserVO comUsrVo) throws DAOException {
		//query parameter
		//Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SysComDB");
			sqlExe.executeUpdate((ISQLTemplate)new UserDAOComUsrMblCdUSQL(), comUsrVo.getColumnValues(), null);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * 업데이트<br>
	 * HANSAP 전체 메뉴에 대한 접근 권한지정을 수신한다.
	 * 
	 * @param ComUserVO comUsrVo
	 * @throws DAOException
	 */
	public void manageComUsrMblSpr(ComUserVO comUsrVo) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("SysComDB");
			sqlExe.executeUpdate((ISQLTemplate)new UserDAOComUsrMblSprUSQL(), comUsrVo.getColumnValues(), null);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
}
