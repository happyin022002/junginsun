/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACommAgreementDBDAO.java
*@FileTitle : FAC Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.03 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmagreement.facommagreement.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.acm.acmagreement.facommagreement.vo.FACAgreementVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS FACommAgreementDBDAO <br>
 * - OPUS-ACMAgreement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Bong-Gyoon
 * @see FACommAgreementBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class FACommAgreementDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0024]
	 * FAC Agreement Creation 목록을 조회<br>
	 *
	 * @param FACAgreementVO facagreementVO
	 * @return List<FACAgreementVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FACAgreementVO> searchFACAgreement(FACAgreementVO facagreementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FACAgreementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (facagreementVO != null) {
				Map<String, String> mapVO= facagreementVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACommAgreementDBDAOSearchFACAgreementListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FACAgreementVO.class);
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
		 * [ESM_ACM_0024]
		 * FAC Agreement Creation 중복 조회<br>
		 *
		 * @param FACAgreementVO facagreementVO
		 * @return List<FACAgreementVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<FACAgreementVO> searchFACAgreementDup(FACAgreementVO facagreementVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<FACAgreementVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if (facagreementVO != null) {
					Map<String, String> mapVO= facagreementVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACommAgreementDBDAOSearchFACAgreementDupRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, FACAgreementVO.class);
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
	  * [ESM_ACM_0024]
	  * FAC Agreement Creation 목록을 신규 저장<br>
	  *
	  * @param FACAgreementVO facAgreementVO
	  * @throws DAOException
	  */
	public void addFACAgreement(FACAgreementVO facAgreementVO) throws DAOException {
		int insCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(facAgreementVO != null ){
				Map<String, String> mapVO = facAgreementVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new FACommAgreementDBDAOAddFACAgreementListCSQL(),param, velParam);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }

	/**
	 * [ESM_ACM_0024]
	 * FAC Agreement Creation 목록의 변경 저장<br>
	 *
	 * @param FACAgreementVO facAgreementVO
	 * @throws DAOException
	 */
	public void modifyFACAgreement(FACAgreementVO facAgreementVO) throws DAOException {
		int upsCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(facAgreementVO != null ){
				Map<String, String> mapVO = facAgreementVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			upsCnt = sqlExe.executeUpdate((ISQLTemplate) new FACommAgreementDBDAOModifyFACAgreementListUSQL(),param, velParam);
			if (upsCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }

	/**
	 * [ESM_ACM_0024]
	 * FAC Agreement Creation 목록의 변경 저장<br>
	 *
	 * @param List<FACAgreementVO> facAgreementVOList
	 * @throws DAOException
	 */
	public void modifyFACAgreement2(List<FACAgreementVO> facAgreementVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (facAgreementVOList.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new FACommAgreementDBDAOModifyFACAgreementList2USQL(), facAgreementVOList, null);
				for (int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * [ESM_ACM_0024]
	 * FAC Agreement Creation 목록 삭제<br>
	 *
	 * @param List<FACAgreementVO> facAgreementVOList
	 * @throws DAOException
	 */
	public void deleteFACAgreement(List<FACAgreementVO> facAgreementVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (facAgreementVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new FACommAgreementDBDAODeleteFACAgreementListDSQL(), facAgreementVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * [ESM_ACM_0024] Request<br>
	 * Request 버튼 클릭 이벤트 처리<br>
	 *
	 * @param List<FACAgreementVO> facAgreementVOList
	 * @throws DAOException
	 */
	public void requestFACAgreement(List<FACAgreementVO> facAgreementVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (facAgreementVOList.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new FACommAgreementDBDAORequestFACAgreementListUSQL(), facAgreementVOList, null);
				for (int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * [ESM_ACM_0024] Approve<br>
	 * Approve 버튼 클릭 이벤트 처리<br>
	 *
	 * @param List<FACAgreementVO> facAgreementVOList
	 * @throws DAOException
	 */
	public void approveFACAgreement(List<FACAgreementVO> facAgreementVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (facAgreementVOList.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new FACommAgreementDBDAOApprovalFACAgreementListUSQL(), facAgreementVOList, null);
				for (int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * [ESM_ACM_0024] Reject<br>
	 * Reject 버튼 클릭 이벤트 처리<br>
	 *
	 * @param List<FACAgreementVO> facAgreementVOList
	 * @throws DAOException
	 */
	public void rejectFACAgreement(List<FACAgreementVO> facAgreementVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (facAgreementVOList.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new FACommAgreementDBDAORejectFACAgreementListUSQL(), facAgreementVOList, null);
				for (int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * [ESM_ACM_0024] Stae<br>
	 * Stae 버튼 클릭 이벤트 처리<br>
	 *
	 * @param List<FACAgreementVO> facAgreementVOList
	 * @throws DAOException
	 */
	public void stateFACAgreement(List<FACAgreementVO> facAgreementVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (facAgreementVOList.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new FACommAgreementDBDAOStateFACAgreementListUSQL(), facAgreementVOList, null);
				for (int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * [ESM_ACM_0024]<br>
	 * Request 수행 후 메일을 보낼때 날짜 조회<br>
	 *
	 * @param String facOfcCd
	 * @return String
	 * @throws DAOException
	 */
	public String getTemplateMailLocalDate(String facOfcCd) throws DAOException {
		DBRowSet dbRowSet = null;
		String locDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("fac_ofc_cd", facOfcCd);
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new FACommAgreementDBDAOGetTemplateMailLocalDateInfoRSQL(), param, null);
			if(dbRowSet.next()){
				locDt = dbRowSet.getString("LOC_DT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return locDt;
	}
}