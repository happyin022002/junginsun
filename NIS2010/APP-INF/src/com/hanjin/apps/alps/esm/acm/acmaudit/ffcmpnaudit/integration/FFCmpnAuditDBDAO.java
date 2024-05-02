/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnAuditDBDAO.java
*@FileTitle : FFCmpnAuditDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.15
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.15 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.basic.FFCmpnAuditBCImpl;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnAuditVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnDetailBasicbyBlVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnDetailChargebyBlVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnDetailHistorybyBlVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnRateInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS FFCmpnAuditDBDAO <br>
 * - ALPS-ACMRequest system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Young-Oh
 * @see FFCmpnAuditBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class FFCmpnAuditDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0027]
	 * FF Compensation Audit 목록을 조회<br>
	 *
	 * @param FFCmpnAuditVO ffcmpnAuditVO
	 * @return List<FFCmpnAuditVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FFCmpnAuditVO> searchFFCmpnAudit(FFCmpnAuditVO ffcmpnAuditVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFCmpnAuditVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffcmpnAuditVO != null) {
				Map<String, String> mapVO= ffcmpnAuditVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnAuditDBDAOFFCmpnAuditRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFCmpnAuditVO.class);
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
	 * [ESM_ACM_0027] Save<br>
	 * FF Compensation Audit 화면저장 전 VNDR_CNT_CD, VNDR_SEQ 조회<br>
	 *
	 * @param String vndr_seq
	 * @return vndrSeq
	 * @throws DAOException
	 */
	public String searchVndrSeqCheck(String vndr_seq) throws DAOException {
		DBRowSet dbRowset = null;
		String vndrSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (vndr_seq != null) {
				param.put("vndr_seq", vndr_seq);
				velParam.put("vndr_seq", vndr_seq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnAuditDBDAOSearchVndrSeqCheckRSQL(), param, velParam);
			if (dbRowset.next()) {
				vndrSeq = dbRowset.getString("VENDOR");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vndrSeq;
	}

	/**
	 * [ESM_ACM_0027] Save<br>
	 * FF Compensation Audit 화면 저장 (ff_cmpn_rmk 가 Calculation Success! 인 경우)<br>
	 *
	 * @param List<FFCmpnAuditVO> ffcmpnAuditVOs
	 * @throws DAOException
	 */
	public void modifyFFCmpnAuditCalSuccess(List<FFCmpnAuditVO> ffcmpnAuditVOs) throws DAOException {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (ffcmpnAuditVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new FFCmpnAuditDBDAOModifyFFCmpnAuditCalSuccessUSQL(), ffcmpnAuditVOs, null);
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
	 * [ESM_ACM_0027] Save<br>
	 * FF Compensation Audit 화면 저장 (ff_cmpn_rmk 가 Calculation Success! 아닌 경우)<br>
	 *
	 * @param List<FFCmpnAuditVO> ffcmpnAuditVOs
	 * @throws DAOException
	 */
	public void modifyFFCmpnAuditCalFail(List<FFCmpnAuditVO> ffcmpnAuditVOs) throws DAOException {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (ffcmpnAuditVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new FFCmpnAuditDBDAOModifyFFCmpnAuditCalFailUSQL(), ffcmpnAuditVOs, null);
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
	 * [ESM_ACM_0027] Save<br>
	 * FF Compensation Audit 화면 저장 (FF_CMPN_STS_CD 가 CE가 아닌 경우)<br>
	 *
	 * @param List<FFCmpnAuditVO> ffcmpnAuditVOs
	 * @throws DAOException
	 */
	public void modifyFFCmpnAuditStsCe(List<FFCmpnAuditVO> ffcmpnAuditVOs) throws DAOException {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (ffcmpnAuditVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new FFCmpnAuditDBDAOModifyFFCmpnAuditStsCeUSQL(), ffcmpnAuditVOs, null);
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
	 * [ESM_ACM_0027] Save<br>
	 * FF Compensation Audit 화면 저장 (ff_cmpn_rmk 가 Calculation Success! 인 경우)<br>
	 *
	 * @param List<FFCmpnAuditVO> ffcmpnAuditVOs
	 * @throws DAOException
	 */
	public void modifyFFCmpnAuditBkgInfo(List<FFCmpnAuditVO> ffcmpnAuditVOs) throws DAOException {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (ffcmpnAuditVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new FFCmpnAuditDBDAOModifyFFCmpnAuditBkgInfoUSQL(), ffcmpnAuditVOs, null);
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
	 * [ESM_ACM_0117]-02
	 * FF Compensation Details &amp; History for B/L 기본 목록을 조회<br>
	 *
	 * @param FFCmpnDetailBasicbyBlVO ffCmpnDetailBasicbyBlVO
	 * @return List<FFCmpnDetailBasicbyBlVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FFCmpnDetailBasicbyBlVO> searchFFCmpnDetailBasicbyBlList(FFCmpnDetailBasicbyBlVO ffCmpnDetailBasicbyBlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFCmpnDetailBasicbyBlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnDetailBasicbyBlVO != null) {
				Map<String, String> mapVO= ffCmpnDetailBasicbyBlVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnAuditDBDAOSearchFFCmpnDetailBasicbyBlListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFCmpnDetailBasicbyBlVO.class);
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
	 * [ESM_ACM_0117]-04
	 * FF Compensation Details &amp; History for B/L 목록을 조회<br>
	 *
	 * @param FFCmpnDetailBasicbyBlVO ffCmpnDetailBasicbyBlVO
	 * @return List<FFCmpnDetailHistorybyBlVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FFCmpnDetailHistorybyBlVO> searchFFCmpnDetailHistorybyBlList(FFCmpnDetailBasicbyBlVO ffCmpnDetailBasicbyBlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFCmpnDetailHistorybyBlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnDetailBasicbyBlVO != null) {
				Map<String, String> mapVO= ffCmpnDetailBasicbyBlVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnAuditDBDAOSearchFFCmpnDetailHistorybyBlListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFCmpnDetailHistorybyBlVO.class);
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
	 * [ESM_ACM_0117]-03
	 * FF Compensation Details &amp; History for B/L 기본 목록을 조회<br>
	 *
	 * @param FFCmpnDetailBasicbyBlVO ffCmpnDetailBasicbyBlVO
	 * @return List<FFCmpnDetailChargebyBlVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FFCmpnDetailChargebyBlVO> searchFFCmpnDetailChargebyBlList(FFCmpnDetailBasicbyBlVO ffCmpnDetailBasicbyBlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFCmpnDetailChargebyBlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnDetailBasicbyBlVO != null) {
				Map<String, String> mapVO= ffCmpnDetailBasicbyBlVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnAuditDBDAOSearchFFCmpnDetailChargebyBlListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFCmpnDetailChargebyBlVO.class);
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
	 * [ESM_ACM_0117]-01
	 * FF Compensation Details &amp; History for B/L 기본 목록을 조회<br>
	 *
	 * @param FFCmpnDetailHistorybyBlVO ffCmpnDetailHistorybyBlVO
	 * @return List<FFCmpnRateInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FFCmpnRateInfoVO> searchFFCmpnRateInfoList(FFCmpnDetailHistorybyBlVO ffCmpnDetailHistorybyBlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFCmpnRateInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffCmpnDetailHistorybyBlVO != null) {
				Map<String, String> mapVO= ffCmpnDetailHistorybyBlVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnAuditDBDAOSearchFFCmpnRateInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFCmpnRateInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

}