/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OTRCommAuditDBDAO.java
*@FileTitle : OTRCommAuditDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.12 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.otrcommaudit.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.acm.acmaudit.otrcommaudit.basic.OTRCommAuditBCImpl;
import com.clt.apps.opus.esm.acm.acmaudit.otrcommaudit.vo.OTRCommAuditVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS OTRCommAuditDBDAO <br>
 * - OPUS-ACMRequest system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Young-Oh
 * @see OTRCommAuditBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class OTRCommAuditDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0015]
	 * Audit Confirm 팝업 화면 Audit No를 조회<br>
	 *
	 * @param OTRCommAuditVO otrCommAuditVO
	 * @return List<OTRCommAuditVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<OTRCommAuditVO> searchOTRCommAudit(OTRCommAuditVO otrCommAuditVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OTRCommAuditVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (otrCommAuditVO != null) {
				Map<String, String> mapVO= otrCommAuditVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OTRCommAuditDBDAOOTRCommAuditRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OTRCommAuditVO.class);
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
	 * [ESM_ACM_0015]
	 * Other Commission Audit 화면 업데이트전 Audit No 조회<br>
	 *
	 * @param OTRCommAuditVO otrCommAuditVO
	 * @return List<OTRCommAuditVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<OTRCommAuditVO> searchAGNCommAuditConfirmList(OTRCommAuditVO otrCommAuditVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OTRCommAuditVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (otrCommAuditVO != null) {
				Map<String, String> mapVO= otrCommAuditVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OTRCommAuditDBDAOSearchAGNCommAuditConfirmNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OTRCommAuditVO.class);
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
	 * [ESM_ACM_0015]
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OTRCommAuditDBDAOCheckAudNoExistsRSQL(), param, null);
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
	 * [ESM_ACM_0015]
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OTRCommAuditDBDAOGetNewAudNoInfoRSQL(), param, null);
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
	 * [ESM_ACM_0015] Retrive<br>
	 * Other Commission Audit 저장 Audit 버튼<br>
	 *
	 * @param List<OTRCommAuditVO> otrCommAuditVO
	 * @throws DAOException
	 */
	public void modifyAGNCommAudit(List<OTRCommAuditVO> otrCommAuditVO) throws DAOException {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (otrCommAuditVO.size() > 0) {
				Map<String, String> mapVO= otrCommAuditVO.get(0).getColumnValues();
				velParam.putAll(mapVO);
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OTRCommAuditDBDAOModifyOTRCommAuditUSQL(), otrCommAuditVO, velParam);
				for (int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
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
	 * [ESM_ACM_0015] Reject<br>
	 * Other Commission Audit 화면의 Reject 저장<br>
	 *
	 * @param List<OTRCommAuditVO> otrCommAuditVOs
	 * @throws DAOException
	 */
	public void rejectOtrAGNCommAudit(List<OTRCommAuditVO> otrCommAuditVOs) throws DAOException {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (otrCommAuditVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OTRCommAuditDBDAORejectOtrAGNCommAuditUSQL(), otrCommAuditVOs, null);
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
	 * [ESM_ACM_0015] Reject<br>
	 * Other Commission Audit 화면의 Audit Cancel <br>
	 *
	 * @param List<OTRCommAuditVO> otrCommAuditVOs
	 * @throws DAOException
	 */
	public void auditCancelOtrAGNCommAudit(List<OTRCommAuditVO> otrCommAuditVOs) throws DAOException {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (otrCommAuditVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OTRCommAuditDBDAOAuditCancelOtrAGNCommAuditUSQL(), otrCommAuditVOs, null);
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