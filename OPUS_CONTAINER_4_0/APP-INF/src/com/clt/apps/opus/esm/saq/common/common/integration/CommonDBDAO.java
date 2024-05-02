/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : CommonDBDAO.java
*@FileTitle      : Common
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.saq.common.common.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.SearchMonthlyQuotaAdjustmentVVD0116ListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.loggable.LoggableStateFactory;
import com.clt.framework.component.util.loggable.LoggableStatement;
import com.clt.framework.core.config.ResourceManager;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SaqMonQtaLodTgtRmkVO;
import com.clt.syscommon.common.table.SaqMonQtaRhqRmkVO;
import com.clt.syscommon.common.table.SaqMonQtaTrdRmkVO;
import com.clt.syscommon.common.table.SaqYryQtaCustGrpRmkVO;
import com.clt.syscommon.common.table.SaqYryQtaOfcRmkVO;

/**
 * Common에 대한 DB 처리를 담당<br>
 * - Common Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 김원섭
 * @see CommonBCImpl 참조
 * @since J2EE 1.4
 */

public class CommonDBDAO extends DBDAOSupport {

	/**
	 * Trade List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchTradeComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String del        = getParameterValue(params, "del");
		String isRepTrade = getParameterValue(params, "isRepTrade");

		try {
			param.put("del", del);
			velParam.put("isRepTrade", isRepTrade);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchTradeComboListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}



	/**
	 * Sub Trade List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSubTradeComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String del        = getParameterValue(params, "del");
		String isRepTrade = getParameterValue(params, "isRepTrade");
		String isAll      = getParameterValue(params, "isAll");
		String trdCd      = getParameterValue(params, "trdCd");
		
		log.debug("::::::::::::::::::::  searchSubTradeComboList  :::::::::::::::::::::::::::::"+trdCd+":::::::::::::::::::::::::::::::::::::::::::::::::");
		
		try {
			param.put("del", del);
			param.put("trdCd", trdCd);
			velParam.put("isRepTrade", isRepTrade);
			velParam.put("isAll", isAll);
			velParam.put("trdCd", trdCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSubTradeComboListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}

	/**
	 * Lane List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchRLaneComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String del = getParameterValue(params, "del");
		String ipc = getParameterValue(params, "ipc");
		String trade = getParameterValue(params, "trade");
		
		try {
			param.put("del", del);
			param.put("trade", trade);
			velParam.put("ipc", ipc);
			velParam.put("trade", trade);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchRLaneComboListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}
	
	/**
	 * Base Data Lane Adjust Lane Combo List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchBSRLaneComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String mqtaMdlVerNo = getParameterValue(params, "mqtaMdlVerNo");
		String year = getParameterValue(params, "year");
		String bseQtrCd = getParameterValue(params, "bseQtrCd");
		String trade = getParameterValue(params, "trade");
		String subTrde = getParameterValue(params, "subTrde");
		
		try {
			param.put("mqtaMdlVerNo", mqtaMdlVerNo);
			param.put("year", year);
			param.put("bseQtrCd", bseQtrCd);
			param.put("trade", trade);
			param.put("subTrde", subTrde);
			
			velParam.put("mqtaMdlVerNo", mqtaMdlVerNo);
			velParam.put("year", year);
			velParam.put("bseQtrCd", bseQtrCd);
			velParam.put("trade", trade);
			velParam.put("subTrde", subTrde);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchBSRLaneComboListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}

	/**
	 * Common Code List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchCommonCodeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String code_cd = getParameterValue(params, "codeNo");
		
		try {
			param.put("code_cd", code_cd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}

	/**
	 * HashMap에 있는 key값을 조회한다.<br>
	 * 
	 * @param 	 param 
	 * @param 	 key
	 * @param 	 idx
	 * @return  String
	 */
	private String getParameterValue(HashMap param, String key, int idx) {
		String[] strs = ((String[]) param.get(key));
		if (strs == null)
			return "";
		if (strs.length <= idx)
			return "";
		return strs[idx];
	}

	/**
	 * HashMap에 있는 key값을 조회한다.<br>
	 * 
	 * @param 	 param 
	 * @param 	 key
	 * @return String
	 */
	private String getParameterValue(HashMap param, String key) {
		return getParameterValue(param, key, 0);
	}

	/**
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchMonthlyQuotaModelVersionList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String year        = getParameterValue(params, "year");
		String bse_qtr_cd        = getParameterValue(params, "bse_qtr_cd");

		try {
			param.put("year", year);
			param.put("bse_qtr_cd", bse_qtr_cd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchMonthlyQuotaModelVersionListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}		
	
	/**
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSaqMonthlyQuotaReleaseVersionList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String year      = getParameterValue(params, "year");
		String quarter   = getParameterValue(params, "quarter");

		try {
			param.put("year", year);
			param.put("quarter", quarter);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonthlyQuotaReleaseVersionListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}			
	
	/**
	 * 월간 조회조건 중 Year/Month 초기값을 최근 Release 값으로 조회한다. 
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSaqMonthlyQuotaReleaseYearMonthList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonthlyQuotaReleaseYearMonthListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}		
	
	/**
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSaqMonthlyQuotaGuidelineVersionList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		
		try {
			param.put("year", getParameterValue(params, "year"));
			param.put("bse_qtr_cd", getParameterValue(params, "bse_qtr_cd"));
			param.put("targetGrp", getParameterValue(params, "targetGrp"));
			param.put("searchFlag", getParameterValue(params, "searchFlag"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonthlyQuotaGuidelineVersionListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}
	
	/**
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSaqMonthlyQuotaStepVersionList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("mQtaStepCd", getParameterValue(params, "mQtaStepCd"));
			param.put("year", 		getParameterValue(params, "year"));
			param.put("bse_qtr_cd", getParameterValue(params, "bse_qtr_cd"));
			param.put("trade", 		getParameterValue(params, "trade"));
			param.put("dirCd", 		getParameterValue(params, "dirCd"));
			param.put("ofcCd", 		getParameterValue(params, "ofcCd"));
			param.put("searchFlag", getParameterValue(params, "searchFlag"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonthlyQuotaStepVersionListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}	

	/**
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSaqTagetGroupTradeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("targetGrp", getParameterValue(params, "targetGrp"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqTagetGroupTradeListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}	

	/**
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSaqTagetGroupSubTradeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("targetGrp", 	getParameterValue(params, "targetGrp"));
			param.put("trade", 		getParameterValue(params, "trade"));
			param.put("dirCd", 		getParameterValue(params, "dirCd"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqTagetGroupSubTradeListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}

	/**
	 * RHQ List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchRHQComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String del = getParameterValue(params, "del");
		
		try {
			param.put("del", del);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchRHQComboListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}

	/**
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSaqMonthlyQuotaAreaDirectorList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String delFlag = getParameterValue(params, "delFlag");
		delFlag = (delFlag.equals("") ? "Y" : delFlag); // 삭제된 AQ 포함하여 조회 

		
		try {
			param.put("rhqCd", getParameterValue(params, "rhqCd"));
			param.put("delFlag", getParameterValue(params, "delFlag"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonthlyQuotaAreaDirectorListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}	

	/**
	 * 2008.01.25 Y.S.CHOI
	 * mqta_ver_no, bse_mon 에 해당하는 Sub Trade List 조회 
	 * SAQ_048, SAQ_085 에서 사용함..
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSaqMonQtaTrdSubtrdList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("mqta_step_cd", getParameterValue(params, "mqta_step_cd"));
			param.put("mqta_ver_no", getParameterValue(params, "mqta_ver_no"));
			param.put("bse_yr", getParameterValue(params, "bse_yr"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			param.put("bse_mon", getParameterValue(params, "bse_mon"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonQtaTrdSubtrdListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}
	
	/**
	 * 2008.01.25 Y.S.CHOI
	 * mqta_ver_no, bse_mon 에 해당하는 Lane List 조회 
	 * SAQ_048, SAQ_085 에서 사용함..
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSaqMonQtaTrdLaneList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("mqta_step_cd", getParameterValue(params, "mqta_step_cd"));
			param.put("bse_yr", getParameterValue(params, "bse_yr"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			param.put("mqta_ver_no", getParameterValue(params, "mqta_ver_no"));
			param.put("bse_mon", getParameterValue(params, "bse_mon"));
			param.put("sub_trd_cd", getParameterValue(params, "sub_trd_cd"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonQtaTrdLaneListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}
	
	
	/**
	 * 2008.01.25 Y.S.CHOI
	 * mqta_ver_no, bse_mon 에 해당하는 Sub Trade List 조회 
	 * SAQ_075, SAQ_087 에서 사용함..
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSaqMonQtaRhqSubtrdList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("mqta_step_cd", getParameterValue(params, "mqta_step_cd"));
			param.put("mqta_ver_no", getParameterValue(params, "mqta_ver_no"));
			param.put("bse_yr", getParameterValue(params, "bse_yr"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			param.put("bse_mon", getParameterValue(params, "bse_mon"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonQtaRhqSubtrdListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}	
	
	/**
	 * 2008.01.25 Y.S.CHOI
	 * mqta_ver_no, bse_mon 에 해당하는 Lane List 조회 
	 * SAQ_075, SAQ_087 에서 사용함..
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSaqMonQtaRhqLaneList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("mqta_step_cd", getParameterValue(params, "mqta_step_cd"));
			param.put("bse_yr", getParameterValue(params, "bse_yr"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			param.put("mqta_ver_no", getParameterValue(params, "mqta_ver_no"));
			param.put("bse_mon", getParameterValue(params, "bse_mon"));
			param.put("sub_trd_cd", getParameterValue(params, "sub_trd_cd"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonQtaRhqLaneListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}	
	
	/**
	 * 2008.04.11 Lee Ho Ik (CSR No. N200804030006)
	 * Lane List 조회 
	 * SAQ_165 에서 사용함..
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSaqMonCfmQtaRhqLaneList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("mqta_rlse_ver_no", getParameterValue(params, "mqta_rlse_ver_no"));
			param.put("bse_yr", getParameterValue(params, "bse_yr"));
			param.put("bse_qtr_cd", getParameterValue(params, "bse_qtr_cd"));
			param.put("qta_tgt_cd", getParameterValue(params, "qta_tgt_cd"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonCfmQtaRhqLaneListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}	
	
	/**
	 * 2008.01.25 Y.S.CHOI
	 * mqta_ver_no, bse_mon 에 해당하는 Lane List 조회 (단, incl_prot_flg 가 "Y" 일 경우) 
	 * SAQ_156, SAQ_159 에서 사용함..
	 * 2010.04.23  ESM_SAQ_0156 에서 하단 조회Lane 리스트 나오게 하기위해  incl_prot_flg 주석처리
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSaqMonQtaStepLodTgtSubtrdList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("mqta_step_cd", getParameterValue(params, "mqta_step_cd"));
			param.put("bse_yr", getParameterValue(params, "bse_yr"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			param.put("mqta_ver_no", getParameterValue(params, "mqta_ver_no"));
			param.put("bse_mon", getParameterValue(params, "bse_mon"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonQtaStepLodTgtSubtrdListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}	
	
	/**
	 * 2008.01.25 Y.S.CHOI 소스수정
	 * mqta_ver_no, bse_mon 에 해당하는 Lane List 조회 (단, incl_prot_flg 가 "Y" 일 경우) 
	 * SAQ_156, SAQ_159 에서 사용함..
	 * 2010.04.23  ESM_SAQ_0156 에서 하단 조회Lane 리스트 나오게 하기위해  incl_prot_flg 주석처리
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSaqMonQtaStepLodTgtLaneList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("mqta_step_cd", getParameterValue(params, "mqta_step_cd"));
			param.put("bse_yr", getParameterValue(params, "bse_yr"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			param.put("mqta_ver_no", getParameterValue(params, "mqta_ver_no"));
			param.put("bse_mon", getParameterValue(params, "bse_mon"));
			param.put("sub_trd_cd", getParameterValue(params, "sub_trd_cd"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonQtaStepLodTgtLaneListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
	
	/**
	 * 2008.02.12 Y.S.CHOI
	 * Office Add 에 사용할 Sub Trade List 조회 
	 * SAQ_162 에서 사용함..
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSaqMonQtaRhqOfficeAddSubtrdList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String mqta_step_cd = getParameterValue(params, "mqta_step_cd");
		try {
			param.put("mqta_step_cd", getParameterValue(params, "mqta_step_cd"));
			param.put("mqta_ver_no", getParameterValue(params, "mqta_ver_no"));
			param.put("bse_yr", getParameterValue(params, "bse_yr"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			
			velParam.put("mqta_step_cd", mqta_step_cd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonQtaRhqOfficeAddSubtrdListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
	
	/**
	 * 2008.02.12 Y.S.CHOI
	 * Office Add 에 사용할 Lane List 조회 
	 * SAQ_162 에서 사용함..
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSaqMonQtaRhqOfficeAddLaneList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String mqta_step_cd = getParameterValue(params, "mqta_step_cd");
		try {
			param.put("mqta_step_cd", getParameterValue(params, "mqta_step_cd"));
			param.put("mqta_ver_no", getParameterValue(params, "mqta_ver_no"));
			param.put("bse_yr", getParameterValue(params, "bse_yr"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			param.put("sub_trd_cd", getParameterValue(params, "sub_trd_cd"));
			
			velParam.put("mqta_step_cd", mqta_step_cd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonQtaRhqOfficeAddLaneListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
	
	/**
	 * 2008.02.12 Y.S.CHOI
	 * Office Add 에 사용할 Area List 조회 
	 * SAQ_162 에서 사용함..
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSaqMonQtaRhqOfficeAddAreaList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String mqta_step_cd = getParameterValue(params, "mqta_step_cd");
		try {
			param.put("rhq_cd", getParameterValue(params, "rhq_cd"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			param.put("rlane_cd", getParameterValue(params, "rlane_cd"));
			param.put("mqta_step_cd", getParameterValue(params, "mqta_step_cd"));
			param.put("bse_yr", getParameterValue(params, "bse_yr"));
			param.put("bse_qtr_cd", getParameterValue(params, "bse_qtr_cd"));
			param.put("mqta_ver_no", getParameterValue(params, "mqta_ver_no"));
			
			velParam.put("mqta_step_cd", mqta_step_cd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonQtaRhqOfficeAddAreaListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
	
	/**
	 * 2008.02.12 Y.S.CHOI
	 * Office Add 에 사용할 Area List 조회 
	 * SAQ_162 에서 사용함..
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSaqMonQtaRhqOfficeAddContOfficeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String mqta_step_cd = getParameterValue(params, "mqta_step_cd");
		String area_cd      = getParameterValue(params, "area_cd");
		try {
			param.put("rhq_cd", getParameterValue(params, "rhq_cd"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			param.put("rlane_cd", getParameterValue(params, "rlane_cd"));
			param.put("area_cd", getParameterValue(params, "area_cd"));
			param.put("mqta_step_cd", getParameterValue(params, "mqta_step_cd"));
			param.put("bse_yr", getParameterValue(params, "bse_yr"));
			param.put("bse_qtr_cd", getParameterValue(params, "bse_qtr_cd"));
			param.put("mqta_ver_no", getParameterValue(params, "mqta_ver_no"));
			
			velParam.put("mqta_step_cd", mqta_step_cd);
			velParam.put("area_cd", area_cd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonQtaRhqOfficeAddContOfficeListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
	
	/**
	 * 2008.03.05 Y.S.CHOI
	 * Regional Group List 조회 
	 * SAQ_163 에서 사용
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRegionalGroupList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchRegionalGroupListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
	
	/**
	 * 2008.03.07 Y.S.CHOI
	 * Target Group List 조회 
	 * SAQ_163 에서 사용
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchLaneBoundSwitchTargetGroupList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchLaneBoundSwitchTargetGroupListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
	
	/**
	 * 2008.03.07 Y.S.CHOI
	 * Target Group List 조회 
	 * SAQ_163 에서 사용
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchLaneBoundSwitchTradeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("trade_group", getParameterValue(params, "trade_group"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchLaneBoundSwitchTradeListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
	
	/**
	 * 2008.03.07 Y.S.CHOI
	 * Sub Trade List 조회 
	 * SAQ_163 에서 사용
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchLaneBoundSwitchSubTradeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchLaneBoundSwitchSubTradeListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
	
	/**
	 * 2008.03.07 Y.S.CHOI
	 * Rlane List 조회 
	 * SAQ_163, SAQ 167 에서 사용
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchLaneBoundSwitchRlaneList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("sub_trd_cd", getParameterValue(params, "sub_trd_cd"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchLaneBoundSwitchRlaneListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
	
	/**
	 * 2008.04.04 Y.S.CHOI
	 * ReleaseVersion 조회 
	 * SAQ_164 에서 사용
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSaqMonthlyQuotaRlseVersionList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("year", getParameterValue(params, "year"));
			param.put("quarter", getParameterValue(params, "quarter"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonthlyQuotaRlseVersionListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
	
	/**
	 * 2008.04.04 Y.S.CHOI
	 * Trade 조회 
	 * SAQ_164 에서 사용
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSaqMonthlyQuotaTrdList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String userChekc = getParameterValue(params, "userCheck");
		try {
			
			param.put("ofcCd", getParameterValue(params, "ofcCd"));
			
			velParam.put("userChekc", userChekc);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonthlyQuotaTrdListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
	
	/**
	 * 2008.04.18 Y.S.CHOI
	 * SAQ_MON_CFM_TGT_VVD의 Lane List 조회 
	 * SAQ_166, SAQ_167 에서 사용
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSaqMappingVVDList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String sub_trd_cd = getParameterValue(params, "sub_trd_cd");
		String lane_cd = getParameterValue(params, "lane_cd");
		try {
			
			param.put("rlse_ver_no", getParameterValue(params, "rlse_ver_no"));
			param.put("year", getParameterValue(params, "year"));
			param.put("qtr_cd", getParameterValue(params, "qtr_cd"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			param.put("sub_trd_cd", getParameterValue(params, "sub_trd_cd"));
			param.put("lane_cd", lane_cd);
			
			velParam.put("sub_trd_cd", sub_trd_cd);
			velParam.put("lane_cd", lane_cd);
						
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMappingVVDListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
	
	/**
	 * 2008.05.19 Y.S.CHOI
	 * MDM_DTL_REV_LANE의 rlane에 해당하는 Sub Trade List 조회 
	 * SAQ_167 에서 사용
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSaqMdmSubTrdList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			param.put("rlane_cd", getParameterValue(params, "rlane_cd"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMdmSubTrdListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage()); 
		}
		return dRs;
	}
	
	/**
	 * 2008.04.30 Y.S.CHOI
	 * SAQ_MON_CFM_TGT_VVD의 Sub Trade List 조회 
	 * SAQ_167 에서 사용
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSaqCfmTgtSubTrdList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("rlse_ver_no", getParameterValue(params, "rlse_ver_no"));
			param.put("bse_year", getParameterValue(params, "bse_year"));
			param.put("bse_qtr_cd", getParameterValue(params, "bse_qtr_cd"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqCfmTgtSubTrdListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage()); 
		}
		return dRs;
	}
	
	/**
	 * 2008.04.30 Y.S.CHOI
	 * SAQ_MON_CFM_TGT_VVD의 Rlane List 조회 
	 * SAQ_167 에서 사용
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSaqCfmTgtLaneList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String param_rlane_cd = getParameterValue(params, "param_rlane_cd");
		try {
			param.put("rlse_ver_no", getParameterValue(params, "rlse_ver_no"));
			param.put("bse_year", getParameterValue(params, "bse_year"));
			param.put("bse_qtr_cd", getParameterValue(params, "bse_qtr_cd"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			param.put("sub_trd_cd", getParameterValue(params, "sub_trd_cd"));
			param.put("param_rlane_cd", getParameterValue(params, "param_rlane_cd"));
			
			velParam.put("param_rlane_cd", param_rlane_cd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqCfmTgtLaneListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage()); 
		}
		return dRs;
	}		
	
	/**
	 * 2008.05.16 Y.S.CHOI
	 * SAQ_MON_CFM_TGT_VVD의 Rhq List 조회 
	 * SAQ_167 에서 사용
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSaqCfmTgtRhqList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String qta_tgt_cd   = getParameterValue(params, "qta_tgt_cd");
		try {
			param.put("bse_year", getParameterValue(params, "bse_year"));
			param.put("bse_qtr_cd", getParameterValue(params, "bse_qtr_cd"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			param.put("rlane_cd", getParameterValue(params, "rlane_cd"));
			
			velParam.put("qta_tgt_cd", qta_tgt_cd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqCfmTgtRhqListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage()); 
		}
		return dRs;
	}				
	
	/**
	 * 2008.05.06 Y.S.CHOI
	 * Office Add 에 사용할 Area List 조회 
	 * SAQ_167 에서 사용함..
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSaqAreaList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String app_tp_cd    = getParameterValue(params, "app_tp_cd");
		try {
			param.put("rlse_ver_no", getParameterValue(params, "rlse_ver_no"));
			param.put("bse_year", getParameterValue(params, "bse_year"));
			param.put("bse_qtr_cd", getParameterValue(params, "bse_qtr_cd"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			param.put("sub_trd_cd", getParameterValue(params, "sub_trd_cd"));
			param.put("rlane_cd", getParameterValue(params, "rlane_cd"));
			param.put("rhq_cd", getParameterValue(params, "rhq_cd"));
			param.put("qta_tgt_cd", getParameterValue(params, "qta_tgt_cd"));
			
			velParam.put("app_tp_cd", app_tp_cd);
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqAreaListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage()); 
		}
		return dRs;
	}				
	
	/**
	 * 2008.05.06 Y.S.CHOI
	 * Office Add 에 사용할 Office List 조회 
	 * SAQ_167 에서 사용함..
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSaqOfficeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String aq_cd        = getParameterValue(params, "aq_cd");
		String app_tp_cd    = getParameterValue(params, "app_tp_cd");
		try {
			param.put("rhq_cd", getParameterValue(params, "rhq_cd"));
			param.put("aq_cd", getParameterValue(params, "aq_cd"));
			param.put("rlse_ver_no", getParameterValue(params, "rlse_ver_no"));
			param.put("bse_year", getParameterValue(params, "bse_year"));
			param.put("bse_qtr_cd", getParameterValue(params, "bse_qtr_cd"));
			param.put("qta_tgt_cd", getParameterValue(params, "qta_tgt_cd"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("rlane_cd", getParameterValue(params, "rlane_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			
			velParam.put("aq_cd", aq_cd);
			velParam.put("app_tp_cd", app_tp_cd);
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqOfficeListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage()); 
		}
		return dRs;
	}			
	
	/**
	 * 
	 * @param mqta_step_cd
	 * @param bse_yr
	 * @param bse_qtr_cd
	 * @param trd_cd
	 * @param dir_cd
	 * @param mqta_ver_no
	 * @param rlane_cd
	 * @param sprt_grp_cd
	 * @param bsa_grp_cd
	 * @param ctrt_rhq_cd
	 * @param bse_mon
	 * @param gline_ver_no
	 * @param login_ofc_cd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchMonthlyQuotaTradeRemarkList(String mqta_step_cd, String bse_yr,
			String bse_qtr_cd, String trd_cd, String dir_cd, String mqta_ver_no, String rlane_cd,
			String sprt_grp_cd, String bsa_grp_cd, String ctrt_rhq_cd, String bse_mon,
			String gline_ver_no, String login_ofc_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("login_ofc_cd", login_ofc_cd);
			param.put("mqta_step_cd", mqta_step_cd);
			param.put("bse_yr", 	  bse_yr      );
			param.put("bse_qtr_cd",   bse_qtr_cd  );
			param.put("trd_cd", 	  trd_cd      );
			param.put("dir_cd", 	  dir_cd      );
			param.put("mqta_ver_no",  mqta_ver_no );
			param.put("rlane_cd", 	  rlane_cd    );
			param.put("sprt_grp_cd",  sprt_grp_cd );
			param.put("bsa_grp_cd",   bsa_grp_cd  );
			param.put("ctrt_rhq_cd",  ctrt_rhq_cd );
			param.put("bse_mon", 	  bse_mon     );
			param.put("gline_ver_no", gline_ver_no);           
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchMonthlyQuotaTradeRemarkListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage()); 
		}
		return dRs;
	}	



	/**
	 * SAQ_MON_QTA_TRD_RMK의 데이타 모델을 DB에 저장한다.<br>
	 * 
	 * @param model SAQ_MON_QTA_TRD_RMK의 데이터 모델
	 * @see ESM_SAQ_112Event
	 * @throws DAOException
	 */								   
	public void addSAQ_MON_QTA_TRD_RMK(SaqMonQtaTrdRmkVO model) throws DAOException,Exception {
		if (model == null) {
			return;
		}
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = model.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CommonDBDAOAddSaqMonQtaTrdRmkCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * @param mqta_step_cd
	 * @param bse_yr
	 * @param bse_qtr_cd
	 * @param trd_cd
	 * @param dir_cd
	 * @param mqta_ver_no
	 * @param rlane_cd
	 * @param sprt_grp_cd
	 * @param bsa_grp_cd
	 * @param ctrt_rgn_ofc_cd
	 * @param bse_mon
	 * @param gline_ver_no
	 * @param login_ofc_cd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchMonthlyQuotaRHQRemarkList(String mqta_step_cd, String bse_yr,
			String bse_qtr_cd, String trd_cd, String dir_cd, String mqta_ver_no, String rlane_cd,
			String sprt_grp_cd, String bsa_grp_cd, String ctrt_rgn_ofc_cd, String bse_mon, 
			String gline_ver_no, String login_ofc_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("login_ofc_cd", 	login_ofc_cd);
			param.put("mqta_step_cd", 	mqta_step_cd);
			param.put("bse_yr", 	  	bse_yr      );
			param.put("bse_qtr_cd",   	bse_qtr_cd  );
			param.put("trd_cd", 	  	trd_cd      );
			param.put("dir_cd", 	  	dir_cd      );
			param.put("mqta_ver_no",  	mqta_ver_no );
			param.put("rlane_cd", 	  	rlane_cd    );
			param.put("sprt_grp_cd",  	sprt_grp_cd );
			param.put("bsa_grp_cd",   	bsa_grp_cd  );
			param.put("ctrt_rgn_ofc_cd",ctrt_rgn_ofc_cd );
			param.put("bse_mon", 	  	bse_mon     );
			param.put("gline_ver_no", 	gline_ver_no);           
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchMonthlyQuotaRHQRemarkListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage()); 
		}
		return dRs;
	}	
	
	/**
	 * ESM_SAQ_112 의 saq_mon_qta_rhq_rmk 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String mqta_step_cd
	 * @param String bse_yr
	 * @param String bse_qtr_cd
	 * @param String trd_cd
	 * @param String dir_cd
	 * @param String mqta_ver_no
	 * @param String rlane_cd
	 * @param String sprt_grp_cd
	 * @param String bsa_grp_cd
	 * @param String rgn_ofc_cd
	 * @param String bse_mon
	 * @param String pol_cd
	 * @param String pod_cd
	 * @param String gline_ver_no
	 * @param String login_ofc_cd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchMonthlyQuotaSlsRHQRemarkList(String mqta_step_cd, String bse_yr,
			String bse_qtr_cd, String trd_cd, String dir_cd, String mqta_ver_no, String rlane_cd,
			String sprt_grp_cd, String bsa_grp_cd, String rgn_ofc_cd, String bse_mon,
			String pol_cd, String pod_cd, String gline_ver_no, String login_ofc_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("login_ofc_cd", 	login_ofc_cd);   
			param.put("mqta_step_cd", 	mqta_step_cd);   
			param.put("bse_yr", 		bse_yr      );   
			param.put("bse_qtr_cd", 	bse_qtr_cd  );   
			param.put("trd_cd", 		trd_cd      );   
			param.put("dir_cd", 		dir_cd      );   
			param.put("mqta_ver_no", 	mqta_ver_no );   
			param.put("rlane_cd", 		rlane_cd    );   
			param.put("sprt_grp_cd", 	sprt_grp_cd );   
			param.put("bsa_grp_cd", 	bsa_grp_cd  );   
			param.put("rgn_ofc_cd", 	rgn_ofc_cd  );   
			param.put("bse_mon", 		bse_mon     );   
			param.put("pol_cd", 		pol_cd      );   
			param.put("pod_cd", 		pod_cd      );   
			param.put("gline_ver_no", 	gline_ver_no);   
       
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchMonthlyQuotaSlsRHQRemarkListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage()); 
		}
		return dRs;
	}	
	
	/**
	 * SAQ_MON_QTA_RHQ_RMK의 데이타 모델을 DB에 저장한다.<br>
	 * 
	 * @param SaqMonQtaRhqRmkVO model
	 * @see ESM_SAQ_112Event
	 * @throws DAOException
	 */
	public void addSAQ_MON_QTA_RHQ_RMK(SaqMonQtaRhqRmkVO model) throws DAOException,Exception {
		if (model == null) {
			return;
		}		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = model.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CommonDBDAOAddSaqMonQtaRhqRmkCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * SAQ_MON_QTA_LOD_TGT_RMK의 데이타 모델을 DB에 저장한다.<br>
	 * 
	 * @param SaqMonQtaLodTgtRmkVO model
	 * @see ESM_SAQ_112Event
	 * @throws DAOException
	 */
	public void addSAQ_MON_QTA_LOD_TGT_RMK(SaqMonQtaLodTgtRmkVO model) throws DAOException,Exception {
		if (model == null) {
			return;
		}		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = model.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CommonDBDAOAddSaqMonQtaLodTgtRmkCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		

	/**
	 * Trade List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchTargetGroupComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String ofc_cd = getParameterValue(params, "ofc");
		String del    = getParameterValue(params, "del");
		
		try {
			param.put("del", del);
			param.put("ofc_cd", ofc_cd);
			velParam.put("ofc_cd", ofc_cd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchTargetGroupComboListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}

	/**
	 * Common의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 월간 판매목표 조정 화면에서 VVD 팝업 조회
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaAdjustmentVVD0116ListVO>
	 * @throws DAOException
	 */
     @SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaAdjustmentVVD0116ListVO>  searchMonthlyQuotaAdjustmentVVD0116List(QuotaConditionVO quotaConditionVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaAdjustmentVVD0116ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}	
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchMonthlyQuotaAdjustmentVVD0116ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaAdjustmentVVD0116ListVO.class); //결과 VO
	    } catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}			

	/**
	 * 
	 * @param  HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchQTGroupToRhqOfficeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("ofc_cd", getParameterValue(params, "ofc_cd"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchQTGroupToRhqOfficeListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	

	/**
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchOfcTo4thParentOfficeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("ofc_cd", getParameterValue(params, "ofc_cd"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchOfcTo4thParentOfficeListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	

	/**
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchMonthlyQtaStatusInquiryBoundList(HashMap params) throws DAOException {	
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("year", getParameterValue(params, "year"));
			param.put("quarter", getParameterValue(params, "quarter"));

			velParam.put("trd_cd", getParameterValue(params, "trd_cd"));

			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchMonthlyQtaStatusInquiryBoundListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}
	
	/**
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchMonthlyQtaStatusInquiryTradeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("year", getParameterValue(params, "year"));
			param.put("quarter", getParameterValue(params, "quarter"));

			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchMonthlyQtaStatusInquiryTradeListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}
	
	 /**
	  * 
	  * @param HashMap params
	  * @return DBRowSet
	  * @throws DAOException
	  */
	 public DBRowSet searchSaqMonQtaWeekList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("mqta_rlse_ver_no", getParameterValue(params, "mqta_rlse_ver_no"));
			param.put("bse_yr", getParameterValue(params, "bse_yr"));
			param.put("bse_qtr_cd", getParameterValue(params, "bse_qtr_cd"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));

			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonQtaWeekListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}

	 /**
	  * 
	  * @param HashMap params
	  * @return DBRowSet
	  * @throws DAOException
	  */
	 public DBRowSet searchSaqMonQtaAdjSmryWeekList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("qta_mst_ver_no", getParameterValue(params, "qta_mst_ver_no"));
			param.put("bse_yr", getParameterValue(params, "bse_yr"));
			param.put("bse_qtr_cd", getParameterValue(params, "bse_qtr_cd"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			param.put("dat_cre_step_cd", getParameterValue(params, "dat_cre_step_cd"));
			param.put("tgt_orz_cd", getParameterValue(params, "tgt_orz_cd"));

			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonQtaAdjSmryWeekListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	 
		
	/**
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchMonthlyQtaStatusInquiryStepList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchMonthlyQtaStatusInquiryStepListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	 
		
	/**
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchMonthlyQtaStatusInquiryStsList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchMonthlyQtaStatusInquiryStsListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	 	 
		
	/**
	 * 월간 조회조건 중 Year/Month 초기값을 최근 확정quota 존재 quarter+1값으로 조회한다. 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSaqMonthlyQuotaCurrentReleaseYearMonthList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonthlyQuotaCurrentReleaseYearMonthListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	

	/**
	 * 월간 조회조건 중 Year/Month 초기값을 최근 확정quota 존재 quarter값으로 조회한다. 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSaqMonthlyQuotaCurrentReleaseQuarterList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonthlyQuotaCurrentReleaseQuarterListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
		
	/**
	 * Common의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param  HashMap params	 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTradeDirComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("bse_yr", getParameterValue(params, "bse_yr"));
			param.put("bse_qtr_cd", getParameterValue(params, "bse_qtr_cd"));
			param.put("rhq_cd", getParameterValue(params, "rhq_cd"));

			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchTradeDirComboListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
		

	/**
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSaqSmryHdrMstVersionList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("targetGrp", getParameterValue(params, "targetGrp"));
			param.put("tgt_orz_cd", getParameterValue(params, "tgt_orz_cd"));
			param.put("year", getParameterValue(params, "year"));
			param.put("bse_qtr_cd", getParameterValue(params, "bse_qtr_cd"));
			param.put("tgt_ofc_cd1", getParameterValue(params, "tgt_ofc_cd1"));
			param.put("tgt_ofc_cd2", getParameterValue(params, "tgt_ofc_cd2"));
			
			velParam.put("tgt_orz_cd", getParameterValue(params, "tgt_orz_cd"));
			velParam.put("stage", getParameterValue(params, "stage"));

			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqSmryHdrMstVersionListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
		
	/**
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchMonthlyTgtOrzCdList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			String stage = getParameterValue(params, "stage");
			String stageText = "";
			if("SQ".equals(stage)){
				stageText = "Sales Quota";
			}else{
				stageText = "Load Target";
			}
			
			param.put("stageText", stageText);
			param.put("targetGrp", getParameterValue(params, "targetGrp"));
			param.put("tgt_orz_cd", getParameterValue(params, "tgt_orz_cd"));
			param.put("year", getParameterValue(params, "year"));
			param.put("bse_qtr_cd", getParameterValue(params, "bse_qtr_cd"));
			param.put("qta_mst_ver_no", getParameterValue(params, "qta_mst_ver_no"));
			param.put("tgt_ofc_cd1", getParameterValue(params, "tgt_ofc_cd1"));
			param.put("tgt_ofc_cd2", getParameterValue(params, "tgt_ofc_cd2"));
			
			velParam.put("stage", stage);

			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchMonthlyTgtOrzCdListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	


	/**
	 * 월간 판매목표 조정 단계에서 Perfomance Data 의 IF 날짜를 조회 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSaqMonthlyQuotaPerfIFDateList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("ofcCd", getParameterValue(params, "ofcCd"));

			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqMonthlyQuotaPerfIFDateListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
		
	/**
	 * 해당년도, 분기의 주차 가져오기
	 *  
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 * 
	 * 2008.05.02 Lee Ho Ik : 신규 생성
	 */
	public DBRowSet searchQtrWeekList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("year", getParameterValue(params, "year"));
			param.put("quarter", getParameterValue(params, "quarter"));
			param.put("bseMon", getParameterValue(params, "bseMon"));

			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchQtrWeekListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}				
		
	/**
	 * 2009.10.19 KIM JONG HO (CSR NO. CHM-200901272)
	 * COA_MON_VVD, SAQ_MON_CFM_TGT_VVD의 Rlane List 조회 
	 * SAQ 164 에서 사용
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCoaSaqRlaneList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bse_yr", getParameterValue(params, "bse_yr"));
			param.put("bse_qtr_cd", getParameterValue(params, "bse_qtr_cd"));
			param.put("trd_cd", getParameterValue(params, "trd_cd"));
			param.put("dir_cd", getParameterValue(params, "dir_cd"));
			param.put("mqta_rlse_ver_no", getParameterValue(params, "mqta_rlse_ver_no"));

			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCoaSaqRlaneListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
	
	/**
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSaqTagetGroupDirList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("targetGrp", getParameterValue(params, "targetGrp"));
			param.put("trdCd", getParameterValue(params, "trdCd"));
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqTagetGroupDirListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}
	
	/**
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSaqTagetGroupTradeAllList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqTagetGroupTradeAllListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}
	
	/**
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSaqTagetGroupDirAllList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSaqTagetGroupDirAllListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}
	
	/**
	 * 2015.03.12 KHS
	 * Base Data Preparation (ESM_SAQ_0078)
	 * COA Interface 버튼 제어
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCoaInferfaceYNList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCoaInferfaceYNListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}	
		
}