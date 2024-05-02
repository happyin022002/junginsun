/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMChinaOfficeInfoDBDAO.java
*@FileTitle : ACMChinaOfficeInfoDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.06
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.06 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.basic.ACMChinaOfficeInfoBCImpl;
import com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.vo.ChinaInfoForLaneVO;
import com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.vo.ChinaOfficeInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS ACMChinaOfficeInfoDBDAO <br>
 * - OPUS-ACMMaster system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Sang-Soo
 * @see ACMChinaOfficeInfoBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class ACMChinaOfficeInfoDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0007]
	 * O/B China Office Info 목록을 조회<br>
	 *
	 * @param ChinaOfficeInfoVO chinaOfficeInfoVO
	 * @return List<ChinaOfficeInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChinaOfficeInfoVO> searchOBChinaOfficeInfo(ChinaOfficeInfoVO chinaOfficeInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChinaOfficeInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (chinaOfficeInfoVO != null) {
				Map<String, String> mapVO = chinaOfficeInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMChinaOfficeInfoDBDAOSearchOBChinaOfficeInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaOfficeInfoVO.class);
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
	 * [ESM_ACM_0007]
	 * 타 Agent + Vendor Code의 조합이 있는지 체크<br>
	 *
	 * @param ChinaOfficeInfoVO chinaOfficeInfoVO
	 * @return List<ChinaOfficeInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChinaOfficeInfoVO> getOtherChinaAgentVendor(ChinaOfficeInfoVO chinaOfficeInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChinaOfficeInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (chinaOfficeInfoVO != null) {
				Map<String, String> mapVO = chinaOfficeInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMChinaOfficeInfoDBDAOGetOtherChinaAgentVendorInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaOfficeInfoVO.class);
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
	 * [ESM_ACM_0005]
	 * I/B China Agent info 목록을 조회<br>
	 *
	 * @param ChinaInfoForLaneVO chinaInfoForLaneVO
	 * @return List<ChinaInfoForLaneVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChinaInfoForLaneVO> searchIBChinaInfoForLane(ChinaInfoForLaneVO chinaInfoForLaneVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChinaInfoForLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (chinaInfoForLaneVO != null) {
				Map<String, String> mapVO = chinaInfoForLaneVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMChinaOfficeInfoDBDAOSearchIBChinaInfoForLaneListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaInfoForLaneVO.class);
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
	 * [ESM_ACM_0005]
	 * POD + Lane의 조합이 현재 입력하는 1건 이상 있는지 체크<br>
	 *
	 * @param ChinaInfoForLaneVO chinaInfoForLaneVO
	 * @return List<ChinaInfoForLaneVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChinaInfoForLaneVO> getPodLaneFromIBChinaInfoForLane(ChinaInfoForLaneVO chinaInfoForLaneVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChinaInfoForLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (chinaInfoForLaneVO != null) {
				Map<String, String> mapVO = chinaInfoForLaneVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMChinaOfficeInfoDBDAOGetPodLaneFromIBChinaInfoForLaneInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaInfoForLaneVO.class);
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
	 * [ESM_ACM_0005]
	 * ACM_AGN_SET_NRTH_CHN_LANE 테이블에서 AGN_CD와 VNDR_SEQ의 EXIST 체크<br>
	 *
	 * @param ChinaInfoForLaneVO chinaInfoForLaneVO
	 * @return List<ChinaInfoForLaneVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChinaInfoForLaneVO> getVendorFromIBChinaInfoForLane(ChinaInfoForLaneVO chinaInfoForLaneVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChinaInfoForLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (chinaInfoForLaneVO != null) {
				Map<String, String> mapVO = chinaInfoForLaneVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMChinaOfficeInfoDBDAOGetVendorFromIBChinaInfoForLaneInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaInfoForLaneVO.class);
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
	 * [ESM_ACM_0005]
	 * I/B China Agent info 목록을 일괄적으로 생성<br>
	 *
	 * @param List<ChinaInfoForLaneVO> chinaInfoForLaneVOs
	 * @throws DAOException
	 */
	public void addIBChinaInfoForLane(List<ChinaInfoForLaneVO> chinaInfoForLaneVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (chinaInfoForLaneVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMChinaOfficeInfoDBDAOAddIBChinaInfoForLaneListCSQL(), chinaInfoForLaneVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * [ESM_ACM_0005]
	 * I/B China Agent info 목록을 일괄적으로 수정<br>
	 *
	 * @param List<ChinaInfoForLaneVO> chinaInfoForLaneVOs
	 * @throws DAOException
	 */
	public void modifyIBChinaInfoForLane(List<ChinaInfoForLaneVO> chinaInfoForLaneVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (chinaInfoForLaneVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ACMChinaOfficeInfoDBDAOModifyIBChinaInfoForLaneListUSQL(), chinaInfoForLaneVOs, null);
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
	 * [ESM_ACM_0007]
	 * O/B China Agent info 목록을 수정<br>
	 *
	 * @param chinaOfficeInfoVOs
	 * @throws DAOException
	 */
	public void modifyOBChinaOfficeInfo(List<ChinaOfficeInfoVO> chinaOfficeInfoVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (chinaOfficeInfoVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ACMChinaOfficeInfoDBDAOModifyOBChinaOfficeInfoListUSQL(), chinaOfficeInfoVOs, null);
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

	
}