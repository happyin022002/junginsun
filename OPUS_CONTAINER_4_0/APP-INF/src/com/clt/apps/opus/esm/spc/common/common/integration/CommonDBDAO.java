/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName       : CommonDBDAO.java
 *@FileTitle      : Common
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : 2006-10-11
 *@LastModifier   : 김원섭
 *@LastVersion    : 1.0
 * 2006-10-11
 * 1.0 최초 생성
 =========================================================*/

package com.clt.apps.opus.esm.spc.common.common.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.clt.apps.opus.esm.spc.common.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.apps.opus.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.clt.framework.support.db.RowSetUtil;

/**
 * Common에 대한 DB 처리를 담당<br> - Common Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
			velParam.put("methodname", "searchTradeComboList");
			
			param.put("del", del);
			velParam.put("isRepTrade", isRepTrade);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
		
		try {
			velParam.put("methodname", "searchSubTradeComboList");
			
			param.put("del", del);
			param.put("trdCd", trdCd);
			velParam.put("isRepTrade", isRepTrade);
			velParam.put("isAll", isAll);
			velParam.put("trdCd", trdCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
		String locTrdCd = getParameterValue(params, "locTrdCd");
		String locSubTrdCd = getParameterValue(params, "locSubTrdCd");
		
		try {
			velParam.put("methodname", "searchRLaneComboList");
			
			param.put("del", del);
			velParam.put("ipc", ipc);

			if(!locTrdCd.equals("")){
				param.put("locTrdCd", locTrdCd);
				velParam.put("locTrdCd", locTrdCd);
			}
			if(!locSubTrdCd.equals("")){
				param.put("locSubTrdCd", locSubTrdCd);
				velParam.put("locSubTrdCd", locSubTrdCd);
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Customer List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchCustAbbrNmList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String custCntCd = getParameterValue(params, "cust_cnt_cd");
		String custSeq   = getParameterValue(params, "cust_seq");
		
		try {
			velParam.put("methodname", "searchCustAbbrNmList");
			
			param.put("custCntCd", custCntCd);
			param.put("custSeq", custSeq);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Salse Office List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchOfficeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String ofcCd = getParameterValue(params, "ofc_cd");
		
		try {
			velParam.put("methodname", "searchOfficeList");
			
			param.put("ofcCd", ofcCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * VVD List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchVVDList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String vvdCd = getParameterValue(params, "vvd_cd");
		
		try {
			velParam.put("methodname", "searchVVDList");
			
			param.put("vvdCd", vvdCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
		
		String code = getParameterValue(params, "codeNo");
		
		try {
			velParam.put("methodname", "searchCommonCodeList");
			
			param.put("code", code);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * @param param
	 * @param key
	 * @param idx
	 * @return String
	 */
	@SuppressWarnings("unchecked")
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
	 * @param param
	 * @param key
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	private String getParameterValue(HashMap param, String key) {
		return getParameterValue(param, key, 0);
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
			velParam.put("methodname", "searchRHQComboList");
			param.put("del", del);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	public DBRowSet searchRHQ2ComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String del = getParameterValue(params, "del");
		String login_usr_ofc_cd = params.get("login_usr_ofc_cd").toString();
		
		try {
			velParam.put("methodname", "searchRHQComboList");
			
			param.put("del", del);
			param.put("login_usr_ofc_cd", login_usr_ofc_cd);
			velParam.put("login_usr_ofc_cd", login_usr_ofc_cd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Child Office List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchChildOfficeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String ofcCd         = getParameterValue(params, "ofc_cd");
		String loginUsrOfcCd = (String) params.get("login_usr_ofc_cd");
		Object level         = getParameterValue(params, "level");
		Object include       = getParameterValue(params, "include");
		
		try {
			velParam.put("methodname", "searchChildOfficeList");
			
			param.put("ofcCd", ofcCd);
			param.put("loginUsrOfcCd", loginUsrOfcCd);
			param.put("lvl", level);
			param.put("inc", include);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Child Team Office List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchChildTeamOfficeList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String ofcCd         = getParameterValue(params, "ofc_cd");
		String loginUsrOfcCd = (String) params.get("login_usr_ofc_cd");
		Object level         = getParameterValue(params, "level");
		Object include       = getParameterValue(params, "include");
		
		try {
			velParam.put("methodname", "searchChildTeamOfficeList");
			
			param.put("ofcCd", ofcCd);
			param.put("loginUsrOfcCd", loginUsrOfcCd);
			param.put("lvl", level);
			param.put("inc", include);
			velParam.put("ofcCd", ofcCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Salse Rep List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSalesRepList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String ofcCd         = getParameterValue(params, "ofc_cd");
		String loginUsrOfcCd = (String) params.get("login_usr_id");
		Object level         = getParameterValue(params, "level");
		
		try {
			velParam.put("methodname", "searchSalesRepList");
			
			param.put("ofcCd", ofcCd);
			param.put("loginUsrOfcCd", loginUsrOfcCd);
			param.put("lvl", level);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Team Salse Rep List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchTeamSalesRepList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String ofcCd         = getParameterValue(params, "ofc_cd");
		String loginUsrOfcCd = (String) params.get("login_usr_id");
		Object level         = getParameterValue(params, "level");
		
		try {
			velParam.put("methodname", "searchTeamSalesRepList");
			
			param.put("ofcCd", ofcCd);
			param.put("loginUsrOfcCd", loginUsrOfcCd);
			param.put("lvl", level);
			velParam.put("ofcCd", ofcCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Port List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchPortList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String portCd = getParameterValue(params, "port_cd");
		
		try {
			velParam.put("methodname", "searchPortList");
			
			param.put("portCd", portCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Yard List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchYardList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String ofcCd  = getParameterValue(params, "ofc_cd");
		String yardCd = getParameterValue(params, "yard_cd");
		
		try {
			velParam.put("methodname", "searchYardList");
			
			param.put("ofcCd", ofcCd);
			param.put("yardCd", yardCd);
			velParam.put("ofcCd", ofcCd);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Week List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchWeekComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String year = getParameterValue(params, "year");
		
		try {
			velParam.put("methodname", "searchWeekComboList");
			
			param.put("year", year);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * Week List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchCurrWeekList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String date = getParameterValue(params, "date");
		
		try {
			velParam.put("methodname", "searchCurrWeekList");
			
			param.put("date", date);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param String ofc_cd
	 * @param String ui_name
	 * @return List<SearchOfficeCondVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchOfficeCondVO> searchOfficeCond(String ofc_cd, String ui_name) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOfficeCondVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofc_cd);
			param.put("ui_name", ui_name);
			velParam.put("ui_name", ui_name); 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchOfficeCondRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOfficeCondVO .class);
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
	 * Operator List를 조회한다. <br>
	 * 
	 * 2010.08.23 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 - Operator List 쿼리 추가
	 * 
	 * @param HashMap params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchOperatorList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			velParam.put("methodname", "searchOperatorList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchListRSQL(), param, velParam);
			log.debug("Operator List : " + dRs.getRowCount());
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
	 * ContiCd List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchContiCdComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		
		try {
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchContiCdComboListRSQL(), param, velParam);
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