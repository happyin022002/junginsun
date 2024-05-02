/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAuditDBDAO.java
*@FileTitle : AGNCommAuditDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.02 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.basic.AGNCommAuditBCImpl;
import com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.vo.AGNCommAuditConfirmVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.vo.AGNCommAuditVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS AGNCommAuditDBDAO <br>
 * - ALPS-ACMRequest system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Sang-Soo
 * @see AGNCommAuditBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class AGNCommAuditDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0008]
	 * Agent Commission Audit 목록을 조회<br>
	 *
	 * @param AGNCommAuditVO agnCommAuditVO
	 * @return List<AGNCommAuditVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AGNCommAuditVO> searchAGNCommAudit(AGNCommAuditVO agnCommAuditVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommAuditVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agnCommAuditVO != null) {
				Map<String, String> mapVO= agnCommAuditVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAuditDBDAOSearchAGNCommAuditListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommAuditVO.class);
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
	 * [ESM_ACM_0107]
	 * Audit Confirm 팝업 화면 Audit No를 조회<br>
	 *
	 * @param AGNCommAuditConfirmVO agnCommAuditConfirmVO
	 * @return List<AGNCommAuditConfirmVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<AGNCommAuditConfirmVO> searchAGNCommAuditConfirmNo(AGNCommAuditConfirmVO agnCommAuditConfirmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommAuditConfirmVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agnCommAuditConfirmVO != null) {
				Map<String, String> mapVO= agnCommAuditConfirmVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAuditDBDAOSearchAGNCommAuditConfirmNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommAuditConfirmVO.class);
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
	 * [ESM_ACM_0107]
	 * Audit Confirm 팝업 화면 Audit No List를 조회<br>
	 *
	 * @param AGNCommAuditVO agnCommAuditVO
	 * @return List<AGNCommAuditVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<AGNCommAuditVO> searchAGNCommAuditConfirmList(AGNCommAuditVO agnCommAuditVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommAuditVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agnCommAuditVO != null) {
				Map<String, String> mapVO= agnCommAuditVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAuditDBDAOSearchAGNCommAuditConfirmNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommAuditVO.class);
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
	 * [ESM_ACM_0008]
	 * Other Commission Audit 화면 Aud No 존재하는지 체크<br>
	 *
	 * @param String audNo
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkAudNoExists(String audNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("aud_no", audNo );
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAuditDBDAOCheckAudNoExistsRSQL(), param, null);
			if (dbRowset.next()) {
				return true;
			} else {
				return false;
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	/**
	 * [ESM_ACM_0008]
	 * New Aud No.를 얻는다.<br>
	 *
	 * @param String audNo
	 * @return String audNo
	 * @exception DAOException
	 */
	public String getNewAudNo(String audNo) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("aud_no", audNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAuditDBDAOGetNewAudNoInfoRSQL(), param, null);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("AUD_NO");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * [ESM_ACM_0008] Retrive<br>
	 * Agent Commission Audit 저장 Audit 버튼<br>
	 *
	 * @param List<AGNCommAuditVO> agnCommAuditVO
	 * @throws DAOException
	 */
	public void modifyAGNCommAudit(List<AGNCommAuditVO> agnCommAuditVO) throws DAOException {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (agnCommAuditVO != null) {
				Map<String, String> mapVO= agnCommAuditVO.get(0).getColumnValues();

				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(agnCommAuditVO != null){
				if (agnCommAuditVO.size() > 0) {
					updCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAuditDBDAOModifyAGNCommAuditConfirmUSQL(), agnCommAuditVO, velParam);
					for (int i=0; i<updCnt.length; i++) {
						if (updCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to Update No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0008] Reject
	 * Agent Commission Audit 화면의 Reject 저장
	 * @param agnCommAuditVOs
	 * @param acTpCd
	 * @throws DAOException
	 */
	public void rejectAGNCommAudit(List<AGNCommAuditVO> agnCommAuditVOs, String acTpCd) throws DAOException {
		int updCnt[] = null;
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			velParam.put("ac_tp_cd", acTpCd);

			SQLExecuter sqlExe = new SQLExecuter("");
			if (agnCommAuditVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAuditDBDAORejectAGNCommAuditUSQL(), agnCommAuditVOs, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0008] Audit Cancel<br>
	 * Agent Commission Audit 화면의 Audit Cancel  <br>
	 *
	 * @param List<AGNCommAuditVO> agnCommAuditVOs
	 * @throws DAOException
	 */
	public void auditCancelAGNCommAudit(List<AGNCommAuditVO> agnCommAuditVOs) throws DAOException {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agnCommAuditVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAuditDBDAOAuditCancelAGNCommAuditUSQL(), agnCommAuditVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}