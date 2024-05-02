/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName       : DailyforecastmanageDBDAO.java
 *@FileTitle      : Dailyforecastmanage
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : 2009.08.21
 *@LastModifier   : 한상훈
 *@LastVersion    : 1.0
 * 2009.08.21
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.bcm.ccd.commoncode.asset.integration.AssetDBDAOAddContainerVesselIfCSQL;
import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.basic.DailyForecastManageBCImpl;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastHistoryOfcListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastHistorySrepAcctListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastManageListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastSrepAccountManageListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDlyFctSplListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SpcOfcLvlVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SpcDlyFcastCustVO;
//import com.clt.syscommon.common.table.SpcSlsRepCustMapgVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.DlyFctInpListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SpcSlsRepCustMapgNewVO;

/**
 * DailyforecastmanageDBDAO <br>
 * - DailyForecast system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Han Sang Hoon
 * @see DailyForecastManageBCImpl 참조  
 * @since J2EE 1.6
 */
public class DailyForecastManageDBDAO extends DBDAOSupport { 

	/**
	 * [ESM_SPC_0104] 정보를 [행위] 합니다.<br>
	 * 
	 * @param dailyforecastmanageConditionVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchDailyForecastHistoryOfcListVO> searchDailyForecastHistoryOfcList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDailyForecastHistoryOfcListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (dailyforecastmanageConditionVO != null) {
				Map<String, String> mapVO = dailyforecastmanageConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchDailyForecastHistoryOfcListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchDailyForecastHistoryOfcListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_SPC_0104] 정보를 [행위] 합니다.<br>
	 * 
	 * @param dailyforecastmanageConditionVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchDailyForecastHistorySrepAcctListVO> searchDailyForecastHistorySrepAcctList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDailyForecastHistorySrepAcctListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (dailyforecastmanageConditionVO != null) {
				Map<String, String> mapVO = dailyforecastmanageConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchDailyForecastHistorySrepAcctListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchDailyForecastHistorySrepAcctListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_SPC_0103] 정보를 [행위] 합니다.<br>
	 * 
	 * @param dailyforecastmanageConditionVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchDailyForecastSrepAccountManageListVO> searchDailyForecastSrepAccountManageList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDailyForecastSrepAccountManageListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (dailyforecastmanageConditionVO != null) {
				Map<String, String> mapVO = dailyforecastmanageConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchDailyForecastSrepAccountManageListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchDailyForecastSrepAccountManageListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_SPC_0103] 정보를 [행위] 합니다.<br>
	 * 
	 * @param spcSlsRepCustMapgVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiDailyForecastSrepAccountManageS(List<SpcSlsRepCustMapgNewVO> spcSlsRepCustMapgVO) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (spcSlsRepCustMapgVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new DailyForecastManageDBDAOSpcSlsRepCustMapgCSQL(), spcSlsRepCustMapgVO, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * [ESM_SPC_0103] 정보를 [행위] 합니다.<br>
	 * 
	 * @param spcSlsRepCustMapgVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiDailyForecastSrepAccountManageS(List<SpcSlsRepCustMapgNewVO> spcSlsRepCustMapgVO) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (spcSlsRepCustMapgVO.size() > 0) {				
				updCnt = sqlExe.executeBatch((ISQLTemplate) new DailyForecastManageDBDAOSpcSlsRepCustMapgUSQL(), spcSlsRepCustMapgVO, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * [ESM_SPC_0103] 정보를 [행위] 합니다.<br>
	 * 
	 * @param spcSlsRepCustMapgVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiDailyForecastSrepAccountManageS(List<SpcSlsRepCustMapgNewVO> spcSlsRepCustMapgVO) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (spcSlsRepCustMapgVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new DailyForecastManageDBDAOSpcSlsRepCustMapgDSQL(), spcSlsRepCustMapgVO, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

	/**
	 * [ESM_SPC_0102] 정보를 [조회] 합니다.<br>
	 * 
	 * @param conditionVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchDailyForecastManageListVO> searchDailyForecastManage2List(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDailyForecastManageListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (conditionVO != null) {
				Map<String, String> mapVO = conditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchDailyForecastManageListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchDailyForecastManageListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_SPC_9010] 정보를 [조회] 합니다.<br>
	 * 
	 * @param spcDlyFcastCustVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchTradeCheck(SpcDlyFcastCustVO spcDlyFcastCustVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDailyForecastManageListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String retval = "";

		try {
			if (spcDlyFcastCustVO != null) {
				Map<String, String> mapVO = spcDlyFcastCustVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchTradeCheckRSQL(), param, velParam);

			if (dbRowset.next()) {
				retval = dbRowset.getString("TRADE_YN");
			}

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchDailyForecastManageListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}

	/**
	 * [ESM_SPC_9010] 정보를 [조회] 합니다.<br>
	 * 
	 * @param spcDlyFcastCustVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchSubTradeCheck(SpcDlyFcastCustVO spcDlyFcastCustVO) throws DAOException {
		DBRowSet dbRowset = null;
		//List<SearchDailyForecastManageListVO> list = null;  //소스 품질 수정 요청건
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String retval = "";

		try {
			if (spcDlyFcastCustVO != null) {
				Map<String, String> mapVO = spcDlyFcastCustVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchSubTradeCheckRSQL(), param, velParam);

			if (dbRowset.next()) {
				retval = dbRowset.getString("SUB_TRADE_YN");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}

	/**
	 * [ESM_SPC_9010] 정보를 [조회] 합니다.<br>
	 * 
	 * @param spcDlyFcastCustVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchRlaneCheck(SpcDlyFcastCustVO spcDlyFcastCustVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String retval = "";

		try {
			if (spcDlyFcastCustVO != null) {
				Map<String, String> mapVO = spcDlyFcastCustVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchRlaneCheckRSQL(), param, velParam);

			if (dbRowset.next()) {
				retval = dbRowset.getString("RLANE_YN");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}

	/**
	 * [ESM_SPC_9010] 정보를 [조회] 합니다.<br>
	 * 
	 * @param dlyFctInpListVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchOfficeMapgCheck(DlyFctInpListVO dlyFctInpListVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String retval = "";

		try {
			if (dlyFctInpListVO != null) {
				Map<String, String> mapVO = dlyFctInpListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchOfficeMapgCheckRSQL(), param, velParam);

			if (dbRowset.next()) {
				retval = dbRowset.getString("SLS_OFC_CD_YN");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}
	
	/**
	 * [ESM_SPC_9010] 정보를 [조회] 합니다.<br>
	 * 
	 * @param dlyFctInpListVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchOfficeLvlCheck(DlyFctInpListVO dlyFctInpListVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String retval = "";

		try {
			if (dlyFctInpListVO != null) {
				Map<String, String> mapVO = dlyFctInpListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchOfficeLvlCheckRSQL(), param, velParam);

			if (dbRowset.next()) {
				retval = dbRowset.getString("OFC_LVL_YN");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}

	/**
	 * [ESM_SPC_9010] 정보를 [저장] 합니다.<br>
	 * 
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSpcSlsRepCustMapg(List<DlyFctInpListVO> insModels) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new DailyForecastManageDBDAOSpcSlsRepCustMapgWithFcastCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * [ESM_SPC_0102] 정보를 [행위] 합니다.<br>
	 * 
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSpcDlyFcastCustS(List<SpcDlyFcastCustVO> insModels) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new DailyForecastManageDBDAOSpcDlyFcastCustCSQL(), insModels, null);				
				
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * [ESM_SPC_9010] 정보를 [행위] 합니다.<br>
	 * 
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addmultiDlyFctInpListS(List<DlyFctInpListVO> insModels) throws DAOException, Exception {
		int insCnt = 0;
		
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
		
			if(insModels.size() > 0){
				for (int i = 0; i < insModels.size(); i++) {
					Map<String, String> mapVO = insModels.get(i).getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new DailyForecastManageDBDAOSpcDlyFcastCustCSQL(), param, velParam);
					if(insCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert SQL");		
					}
					insCnt++;
				}
			}	
					
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * [ESM_SPC_0102] 정보를 [행위] 합니다.<br>
	 * 
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSpcDlyFcastCustS(List<SpcDlyFcastCustVO> updModels) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new DailyForecastManageDBDAOSpcDlyFcastCustUSQL(), updModels, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * [ESM_SPC_0102] 정보를 [행위] 합니다.<br>
	 * 
	 * @param delModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiSpcDlyFcastCustS(List<SpcDlyFcastCustVO> delModels) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new DailyForecastManageDBDAOSpcDlyFcastCustDSQL(), delModels, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

	/**
	 * [ESM_SPC_0102] 정보를 [행위] 합니다.<br>
	 * 
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSpcDlyFcastCust2(List<SpcDlyFcastCustVO> updModels) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new DailyForecastManageDBDAOSpcDlyFcastCust2USQL(), updModels, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * searchOfcLvlList
	 * 
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SpcOfcLvlVO> searchOfcLvlList() throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<SpcOfcLvlVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchOfcLvlListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SpcOfcLvlVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * removeMultiOfficeLevelManage
	 * 
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeMultiOfficeLevelManage() throws DAOException, Exception {
		try {
			return new SQLExecuter("").executeUpdate(new DailyForecastManageDBDAORemoveMultiOfficeLevelManageDSQL(), null, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * addMultiOfficeLevelManage
	 * 
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addMultiOfficeLevelManage() throws DAOException, Exception {
		try {
			return new SQLExecuter("").executeUpdate(new DailyForecastManageDBDAOAddMultiOfficeLevelManageCSQL(), null, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_SPC_9010] 정보를 [조회] 합니다.<br>
	 * 
	 * @param conditionVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchDlyFctSplListVO> searchDailyForecastManage3List(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDlyFctSplListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (conditionVO != null) {
				Map<String, String> mapVO = conditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchDlyFctSplListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchDlyFctSplListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [ESM_SPC_9010] 정보를 [조회] 합니다.<br>
	 * 
	 * @param conditionVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchDlyFctSplListVO> searchDailyForecastTemplateList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDlyFctSplListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (conditionVO != null) {
				Map<String, String> mapVO = conditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchDailyForecastTemplateListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchDlyFctSplListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [ESM_SPC_9010] Year Week 정보를 [조회] 합니다.<br>
	 * 
	 * @param dlyFctInpListVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DlyFctInpListVO> searchYrWKCheck(DlyFctInpListVO dlyFctInpListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DlyFctInpListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (dlyFctInpListVO != null) {
				Map<String, String> mapVO = dlyFctInpListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchYrWkCheckRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DlyFctInpListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_SPC_9010] 정보를 [조회] 합니다.<br>
	 * 
	 * @param dlyFctInpListVO
	 * @param searchGbn
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchCsCstCdCheck(DlyFctInpListVO dlyFctInpListVO, String searchGbn) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String retval = "";

		try {
			if (dlyFctInpListVO != null) {
				Map<String, String> mapVO = dlyFctInpListVO.getColumnValues();
				//20160203.ADD
				if(searchGbn.equals("G2")) {
					mapVO.put("cust_cnt_cd", dlyFctInpListVO.getCtrtCustCntCd());
					mapVO.put("cust_seq", dlyFctInpListVO.getCtrtCustSeq());
				} 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchCsCstCdCheckRSQL(), param, velParam);

			if (dbRowset.next()) {
				retval = dbRowset.getString("CUST_CNT_CD_YN");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}

	/**
	 * [ESM_SPC_9010] 정보를 [조회] 합니다.<br>
	 * 
	 * @param dlyFctInpListVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchPolPodCdCheck(DlyFctInpListVO dlyFctInpListVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String retval = "";

		try {
			if (dlyFctInpListVO != null) {
				Map<String, String> mapVO = dlyFctInpListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchPolPodCdCheckRSQL(), param, velParam);

			if (dbRowset.next()) {
				retval = dbRowset.getString("POL_POD_YN");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}

	/**
	 * [ESM_SPC_9010] 정보를 [조회] 합니다.<br>
	 * 
	 * @param dlyFctInpListVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchVvdCdCheck(DlyFctInpListVO dlyFctInpListVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String retval = "";

		try {
			if (dlyFctInpListVO != null) {
				Map<String, String> mapVO = dlyFctInpListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchVvdCdCheckRSQL(), param, velParam);

			if (dbRowset.next()) {
				retval = dbRowset.getString("VVD_YN");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}

	/**
	 * [ESM_SPC_9010] 정보를 [조회] 합니다.<br>
	 * 
	 * @param dlyFctInpListVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchPolCdCheck(DlyFctInpListVO dlyFctInpListVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String retval = "";

		try {
			if (dlyFctInpListVO != null) {
				Map<String, String> mapVO = dlyFctInpListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchPolCdCheckRSQL(), param, velParam);

			if (dbRowset.next()) {
				retval = dbRowset.getString("POL_YN");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}

	/**
	 * [ESM_SPC_9010] 정보를 [조회] 합니다.<br>
	 * 
	 * @param dlyFctInpListVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchPolYdCdCheck(DlyFctInpListVO dlyFctInpListVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String retval = "";

		try {
			if (dlyFctInpListVO != null) {
				Map<String, String> mapVO = dlyFctInpListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchPolYdCdCheckRSQL(), param, velParam);

			if (dbRowset.next()) {
				retval = dbRowset.getString("POL_YD_CD_YN");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}

	/**
	 * [ESM_SPC_9010] 정보를 [조회] 합니다.<br>
	 * 
	 * @param dlyFctInpListVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchPolDblCheck(DlyFctInpListVO dlyFctInpListVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String retval = "";

		try {
			if (dlyFctInpListVO != null) {
				Map<String, String> mapVO = dlyFctInpListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchPolDblCheckRSQL(), param, velParam);

			if (dbRowset.next()) {
				retval = dbRowset.getString("POL_DBL_YN");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}

	/**
	 * [ESM_SPC_9010] 정보를 [조회] 합니다.<br>
	 * 
	 * @param dlyFctInpListVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchPodCdCheck(DlyFctInpListVO dlyFctInpListVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String retval = "";

		try {
			if (dlyFctInpListVO != null) {
				Map<String, String> mapVO = dlyFctInpListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchPodCdCheckRSQL(), param, velParam);

			if (dbRowset.next()) {
				retval = dbRowset.getString("POD_CD_YN");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}

	/**
	 * [ESM_SPC_9010] 정보를 [조회] 합니다.<br>
	 * 
	 * @param dlyFctInpListVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchPodYDCdCheck(DlyFctInpListVO dlyFctInpListVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String retval = "";

		try {
			if (dlyFctInpListVO != null) {
				Map<String, String> mapVO = dlyFctInpListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchPodYdCdCheckRSQL(), param, velParam);

			if (dbRowset.next()) {
				retval = dbRowset.getString("POD_YD_CD_YN");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}

	/**
	 * [ESM_SPC_9010] 정보를 [조회] 합니다.<br>
	 * 
	 * @param dlyFctInpListVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchPolYDDblCheck(DlyFctInpListVO dlyFctInpListVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String retval = "";

		try {
			if (dlyFctInpListVO != null) {
				Map<String, String> mapVO = dlyFctInpListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOSearchPolYDDblCheckRSQL(), param, velParam);

			if (dbRowset.next()) {
				retval = dbRowset.getString("POL_YD_DBL_YN");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}

	/**
	 * [ESM_SPC_9010] 정보를 [조회] 합니다.<br>
	 * 
	 * @param dlyFctInpListVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchPolPodCntiCheck(DlyFctInpListVO dlyFctInpListVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String retval = "";

		try {
			if (dlyFctInpListVO != null) {
				Map<String, String> mapVO = dlyFctInpListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DailyForecastManageDBDAOsearchPolPodCntiCheckRSQL(), param, velParam);

			if (dbRowset.next()) {
				retval = dbRowset.getString("POL_POD_CNTI_YN");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}
	
	/**
	 * [ESM_SPC_9010] 정보를 [행위] 합니다.<br>
	 * 
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int multiSpcFileImptDlyFct(List<DlyFctInpListVO> insModels) throws DAOException, Exception {
		int insCnt = 0;
		
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
		
			if(insModels.size() > 0){
				for (int i = 0; i < insModels.size(); i++) {
					Map<String, String> mapVO = insModels.get(i).getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new DailyForecastManageDBDAOSpcFileImptCustCSQL(), param, velParam);
					if(insCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert SQL");		
					}
					insCnt++;
				}
			}	
					
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 *  [ESM_SPC_9010] 정보를 [저장] 합니다.<br>
	 *  
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] multiSpcFileImptCustMapg(List<DlyFctInpListVO> insModels) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new DailyForecastManageDBDAOSpcFileImptCustMapgCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}	
}