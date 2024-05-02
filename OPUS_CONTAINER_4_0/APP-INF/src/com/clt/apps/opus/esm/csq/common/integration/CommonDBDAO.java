/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : CommonDBDAO.java
*@FileTitle      : Common
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.06
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.06 CSQ USER
* 1.0 Creation
* 2013.12.10 PEJ [CHM-201328059] searchLaneMasterList 수정
* 2014.01.16 PEJ [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2014.08.16 이혜민 [CHM-201431396] Portion Adjustment 화면의 Office 신규 row add 버튼 생성
=========================================================*/
package com.clt.apps.opus.esm.csq.common.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS CommonDBDAO <br>
 * - ALPS-Common system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CSQ USER
 * @see commonBCImpl 참조
 * @since J2EE 1.6
 */
public class CommonDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Year 콤보의 목록을 가져온다.<br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchYearList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchYearList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), null, velParam);
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
	 * Quarter 콤보의 목록을 가져온다.<br>
	 * COM_INTG_CD_DTL - CD01365
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchQuarterList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchQuarterList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), null, velParam);
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
	 * Office View 콤보의 목록을 가져온다.<br>
	 * COM_INTG_CD_DTL - CD00940
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchOfficeViewList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchOfficeViewList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), null, velParam);
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
	 * Trade 콤보의 목록을 가져온다.<br>
	 * CSQ_QTA_LANE_MGMT 테이블에서 Sector Sale 정보를 제외
	 * 
	 * @param code String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchTradeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		try {
			velParam.put("methodname", "searchTradeList");
			
			if(!code.equals("")){
				String[] codeArr = code.split("[|]");
				param.put("f_bse_tp_cd", codeArr.length>0?codeArr[0]:"");
				velParam.put("f_bse_tp_cd", codeArr.length>0?codeArr[0]:"");
				param.put("f_bse_yr", codeArr.length>1?codeArr[1]:"");
				velParam.put("f_bse_yr", codeArr.length>1?codeArr[1]:"");
				param.put("f_bse_qtr_cd", codeArr.length>2?codeArr[2]:"");
				velParam.put("f_bse_qtr_cd", codeArr.length>2?codeArr[2]:"");
				param.put("sector_include", codeArr.length>3?codeArr[3]:"");
				velParam.put("sector_include", codeArr.length>3?codeArr[3]:"");
				
			}
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * Trade 콤보의 목록을 가져온다.<br>
	 * MDM_TRADE
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchMdmTradeList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchMdmTradeList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), null, velParam);
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
	 * Sub Trade 콤보의 목록을 가져온다.<br>
	 * MDM_SUB_TRD
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchMdmSubTradeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchMdmSubTradeList");
			
			param.put("f_trd_cd", code);
			velParam.put("f_trd_cd", code);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * Sub Trade 콤보의 목록을 가져온다.<br>
	 * CSQ_QTA_LANE_MGMT
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSubTradeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchSubTradeList");
			
			if(!code.equals("")){
				String[] codeArr = code.split("[|]");
				
				param.put("f_trd_cd", codeArr.length>0?codeArr[0]:"");
				velParam.put("f_trd_cd", codeArr.length>0?codeArr[0]:"");
				param.put("f_bse_tp_cd", codeArr.length>1?codeArr[1]:"");
				velParam.put("f_bse_tp_cd", codeArr.length>1?codeArr[1]:"");
				param.put("f_bse_yr", codeArr.length>2?codeArr[2]:"");
				velParam.put("f_bse_yr", codeArr.length>2?codeArr[2]:"");
				param.put("f_bse_qtr_cd", codeArr.length>3?codeArr[3]:"");
				velParam.put("f_bse_qtr_cd", codeArr.length>3?codeArr[3]:"");
				param.put("sector_include", codeArr.length>4?codeArr[4]:"");
				velParam.put("sector_include", codeArr.length>4?codeArr[4]:"");
				
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * H/O Teams 콤보의 목록을 가져온다.<br>
	 * CSQ_DAT_RLT
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchHoTeamsList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchHoTeamsList");
			velParam.put("rhq", code);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), null, velParam);
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
	 * RHQ 콤보의 목록을 가져온다.<br>
	 * CSQ_ORGANIZATION_V
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRhqList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchRhqList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * Create Period 기간을 가져온다.<br>
	 * COA_WK_PRD
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCPeriodList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchCPeriodList");
			
			if(!code.equals("")){
				String[] codeArr = code.split("[|]");
				
				param.put("f_year_wk", codeArr[0]);
				param.put("f_dur", codeArr[1]);
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * 4 level 의 Office code 콤보의 목록을 가져온다.<br>
	 * CSQ_ORGANIZATION_V
	 * 
	 * @param String code
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchOfficeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchOfcList");
			
			if(!"".equals(code)){
				param.put("f_rhq_cd", code);
				velParam.put("f_rhq_cd", code);
			}
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * 현재 주차를 포함한 분기의 다음 분기를 가져온다.<br>
	 * COA_WK_PRD
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchNextQtaList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchNextQtaList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * 계정에 따라 Trade List를 가져온다<br>
	 * CSQ_DAT_RLT
	 * 
	 * @param ConditionVO conditionVO
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchTradeControl(ConditionVO conditionVO, String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchTradeControl");
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				if(!code.equals("")){
					param.put("f_ofc_org_cd", code);
				}
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}		
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * Trade에 따라 rLane List를 가져온다<br>
	 * CSQ_QTA_LANE_MGMT
	 * 
	 * @param ConditionVO conditionVO
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRLaneControl(ConditionVO conditionVO, String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchrLaneControl");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				if(!code.equals("")){
					param.put("f_ofc_org_cd", code);
				}
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * RHQ 콤보의 목록을 가져온다.<br>
	 * CSQ_QTA_OFC
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRhqForPlanList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "rhqForPlan");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * OFC 를 가져온다.<br>
	 * CSQ_QTA_OFC
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchOfcForPlanList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "officeForPlan");
			
			if(!code.equals("")){
				param.put("rhq_cd", code);
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * Groupo Customer 콤보의 목록을 가져온다.<br>
	 * MDM_CUST_PERF_GRP
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchGroupCustomer(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchGroupCustomer");
			
			param.put("f_acc_grp_cd", code);
			velParam.put("f_acc_grp_cd", code);
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * Month를 조회한다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchMonth(ConditionVO conditionVO) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchMonth");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * Week를 조회한다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchWeek(ConditionVO conditionVO) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchWeek");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * Copy VVD List 를 가져온다.<br>
	 * CSQ_CFM_TGT_VVD
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchVvdList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchVvdList");
			
			if(!code.equals("")){
				String[] codeArr = code.split("[|]");
				
				param.put("f_bse_yr",		codeArr[0]);
				param.put("f_bse_qtr_cd",	codeArr[1]);
				param.put("f_trd_cd", 		codeArr[2]);
				param.put("f_sub_trd_cd",	codeArr[3]);
				param.put("f_dir_cd", 		codeArr[4]);
				param.put("f_rlane_cd",		codeArr[5]);
				param.put("f_qta_tgt_cd",	codeArr[6]);
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * Trade에 따라 Bound를 가져온다<br>
	 * CSQ_QTA_LANE_MGMT
	 * 
	 * @param ConditionVO conditionVO
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchBoundControl(ConditionVO conditionVO, String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchBoundControl");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				if(!code.equals("")){
					param.put("f_ofc_org_cd", code);
				}
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * Lane Master 상의 Overall R.Lane 콤보의 목록을 가져온다.<br>
	 * CSQ_QTA_LANE_MGMT
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRLaneList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchRLaneList"); 
			
			if(!code.equals("")){
				String[] codeArr = code.split("[|]");
				
				param.put("f_trd_cd", codeArr.length>0?codeArr[0]:"");
				velParam.put("f_trd_cd", codeArr.length>0?codeArr[0]:"");
				param.put("f_bse_tp_cd", codeArr.length>1?codeArr[1]:"");
				velParam.put("f_bse_tp_cd", codeArr.length>1?codeArr[1]:"");
				param.put("f_bse_yr", codeArr.length>2?codeArr[2]:"");
				velParam.put("f_bse_yr", codeArr.length>2?codeArr[2]:"");
				param.put("f_bse_qtr_cd", codeArr.length>3?codeArr[3]:"");
				velParam.put("f_bse_qtr_cd", codeArr.length>3?codeArr[3]:"");
				param.put("f_sub_trd_cd", codeArr.length>4?codeArr[4]:"");
				velParam.put("f_sub_trd_cd", codeArr.length>4?codeArr[4]:"");
				param.put("sector_include", codeArr.length>5?codeArr[5]:"");
				velParam.put("sector_include", codeArr.length>5?codeArr[5]:"");
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * Lane Master 상의 Sector R.Lane 콤보의 목록을 가져온다.<br>
	 * CSQ_QTA_LANE_MGMT
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRLaneSectorList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchRLaneSectorList"); 
			
			if(!code.equals("")){
				String[] codeArr = code.split("[|]");
				
				param.put("f_trd_cd", codeArr.length>0?codeArr[0]:"");
				velParam.put("f_trd_cd", codeArr.length>0?codeArr[0]:"");
				param.put("f_bse_tp_cd", codeArr.length>1?codeArr[1]:"");
				velParam.put("f_bse_tp_cd", codeArr.length>1?codeArr[1]:"");
				param.put("f_bse_yr", codeArr.length>2?codeArr[2]:"");
				velParam.put("f_bse_yr", codeArr.length>2?codeArr[2]:"");
				param.put("f_bse_qtr_cd", codeArr.length>3?codeArr[3]:"");
				velParam.put("f_bse_qtr_cd", codeArr.length>3?codeArr[3]:"");
				param.put("f_sub_trd_cd", codeArr.length>4?codeArr[4]:"");
				velParam.put("f_sub_trd_cd", codeArr.length>4?codeArr[4]:"");
				
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * MDM 상의 R.Lane 콤보의 목록을 가져온다.<br>
	 * MDM_DTL_REV_LANE
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchMdmRLaneList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchMdmRLaneList"); 
			
			if(!code.equals("")){
				String[] codeArr = code.split("[|]");
				
				param.put("f_trd_cd", codeArr[0]);
				velParam.put("f_trd_cd", codeArr[0]);
				param.put("f_sub_trd_cd", codeArr.length>1?codeArr[1]:"");
				velParam.put("f_sub_trd_cd", codeArr.length>1?codeArr[1]:"");
			
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * 현재 주차의 분기를 가져온다.<br>
	 * COA_WK_PRD
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCurrentQtaList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchCurrentQtaList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * Sub Trade Sector콤보의 목록을 가져온다.<br>
	 * CSQ_QTA_LANE_MGMT
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSubTradeSectorList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchSubTradeSectorList");
			
			if(!code.equals("")){
				String[] codeArr = code.split("[|]");
				
				param.put("f_trd_cd", codeArr.length>0?codeArr[0]:"");
				velParam.put("f_trd_cd", codeArr.length>0?codeArr[0]:"");
				param.put("f_bse_tp_cd", codeArr.length>1?codeArr[1]:"");
				velParam.put("f_bse_tp_cd", codeArr.length>1?codeArr[1]:"");
				param.put("f_bse_yr", codeArr.length>2?codeArr[2]:"");
				velParam.put("f_bse_yr", codeArr.length>2?codeArr[2]:"");
				param.put("f_bse_qtr_cd", codeArr.length>3?codeArr[3]:"");
				velParam.put("f_bse_qtr_cd", codeArr.length>3?codeArr[3]:"");
				
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * R/Lane에 따른 POL Code를 가져온다.<br>
	 * CSQ_SCTR_PAIR_MGMT
	 * 
	 * @param ConditionVO conditionVO
	 * @param String code
	 * @param String codeItem
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchPolCdSectorList(ConditionVO conditionVO, String code, String codeItem) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchPolCdSectorList");
			if(codeItem.equals("polCdSector")){
				velParam.put("tb_nm", "csq_sctr_pair_mgmt");
			}else if(codeItem.equals("polCdSectorOfc")){
				velParam.put("tb_nm", "csq_sctr_lane_ofc");
			}
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * R/Lane에 따른 POD Code를 가져온다.<br>
	 * CSQ_SCTR_PAIR_MGMT
	 * 
	 * @param ConditionVO conditionVO
	 * @param String code
	 * @param String codeItem
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchPodCdSectorList(ConditionVO conditionVO, String code, String codeItem) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchPodCdSectorList");
			if(codeItem.equals("podCdSector")){
				velParam.put("tb_nm", "csq_sctr_pair_mgmt");
			}else if(codeItem.equals("podCdSectorOfc")){
				velParam.put("tb_nm", "csq_sctr_lane_ofc");
			}
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * Multi R/Lane에 따른 POL Code 를 가져온다.<br>
	 * CSQ_SCTR_PAIR_MGMT
	 * 
	 * @param ConditionVO conditionVO
	 * @param String codeItem
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchPolCdSectorMultiList(ConditionVO conditionVO, String codeItem) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchPolCdSectorMultiList");
			
			if(conditionVO != null){
               if (!JSPUtil.getNull(conditionVO.getFRlaneCd()).equals("") && !JSPUtil.getNull(conditionVO.getFRlaneCd()).equals("All")) {
            	   conditionVO.setFRlaneCd("'" + conditionVO.getFRlaneCd().replaceAll("," ,"','") +"'");
				}
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * Multi R/Lane에 따른 POD Code 를 가져온다.<br>
	 * CSQ_SCTR_PAIR_MGMT
	 * 
	 * @param ConditionVO conditionVO
	 * @param String codeItem
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchPodCdSectorMultiList(ConditionVO conditionVO, String codeItem) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchPodCdSectorMultiList");
			
			if(conditionVO != null){
//               if (!JSPUtil.getNull(conditionVO.getFRlaneCd()).equals("") && !JSPUtil.getNull(conditionVO.getFRlaneCd()).equals("All")) {
//            	   conditionVO.setFRlaneCd("'" + conditionVO.getFRlaneCd().replaceAll("," ,"','") +"'");
//				}
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
			
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
	 * PF Group Sector콤보의 목록을 가져온다.<br>
	 * CSQ_SCTR_PAIR_MGMT
	 * 
	 * @param String code
	 * @param String codeItem
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchPfGroupList(String code, String codeItem) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchPfGroupList");
			if(codeItem.equals("pfGroupPair")){
				velParam.put("tb_nm", "csq_sctr_pair_mgmt");
			}else if(codeItem.equals("pfGroupOfc")){
				velParam.put("tb_nm", "csq_sctr_lane_ofc");
			}
			if(code != null){
				code = "'" + code.replaceAll("-" ,"','") +"'";
				velParam.put("f_rlane_cd", code);
			}
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * Lane-Office Relation Setting 상의 R.Lane 콤보의 목록을 가져온다.<br>
	 * CSQ_QTA_LANE_OFC
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchControlRLaneVvdList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			
			velParam.put("methodname", "searchRLaneGroupList"); 
							
			if(!code.equals("")){
				String[] codeArr = code.split("[|]");
				//f_bse_tp_cd|f_bse_yr|f_bse_qta_cd|trd_cd|sub_trd_cd
				
				param.put("f_bse_tp_cd",     codeArr[0]);
				velParam.put("f_bse_tp_cd", codeArr[0]);
				param.put("f_bse_yr",     codeArr.length>1?codeArr[1]:"");
				velParam.put("f_bse_yr", codeArr.length>1?codeArr[1]:"");
				param.put("f_bse_qtr_cd",    codeArr.length>2?codeArr[2]:"");
				velParam.put("f_bse_qtr_cd", codeArr.length>2?codeArr[2]:"");
				param.put("f_trd_cd",    codeArr.length>3?codeArr[3]:"");
				velParam.put("f_trd_cd", codeArr.length>3?codeArr[3]:"");
				param.put("f_sub_trd_cd",    codeArr.length>4?codeArr[4]:"");
				velParam.put("f_sub_trd_cd", codeArr.length>4?codeArr[4]:"");

			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * R.Lane 에 대한 BSA 콤보의 목록을 가져온다.<br>
	 * CSQ_QTA_TGT_VVD
	 * 
	 * @param ConditionVO conditionVO
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLaneBSA(ConditionVO conditionVO) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			
			velParam.put("methodname", "searchBSAList"); 
			
			if(conditionVO != null){
				param.put("f_bse_tp_cd", conditionVO.getFBseTpCd());
				velParam.put("f_bse_tp_cd", conditionVO.getFBseTpCd());
				param.put("f_bse_yr", conditionVO.getFBseYr());
				velParam.put("f_bse_yr", conditionVO.getFBseYr());
				param.put("f_bse_qtr_cd", conditionVO.getFBseQtrCd());
				velParam.put("f_bse_qtr_cd", conditionVO.getFBseQtrCd());
				param.put("f_rlane_cd", conditionVO.getFRlaneCd());
				velParam.put("f_rlane_cd", conditionVO.getFRlaneCd());
				param.put("f_dir_cd", conditionVO.getFDirCd());
				velParam.put("f_dir_cd",conditionVO.getFDirCd());
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * Portion Adjustment by H/O 시트 내 RHQ 목록을 가져온다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRhqListByPortion(ConditionVO conditionVO) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchRhqListByPortion");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * Portion Adjustment by RHQ 시트 내 OFFICE 목록을 가져온다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchOfcListByPortion(ConditionVO conditionVO) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchOfcListByPortion");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * PF Group Sector콤보의 목록을 가져온다.<br>
	 * csq_sctr_lane_ofc
	 * 
	 * @param ConditionVO conditionVO
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchPfGroupPlanList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			
			velParam.put("methodname", "searchPfGroupPlanList"); 
			
			if(conditionVO != null){
				param.put("f_bse_tp_cd", conditionVO.getFBseTpCd());
				velParam.put("f_bse_tp_cd", conditionVO.getFBseTpCd());
				param.put("f_bse_yr", conditionVO.getFBseYr());
				velParam.put("f_bse_yr", conditionVO.getFBseYr());
				param.put("f_bse_qtr_cd", conditionVO.getFBseQtrCd());
				velParam.put("f_bse_qtr_cd", conditionVO.getFBseQtrCd());
				param.put("f_rlane_cd", conditionVO.getFRlaneCd());
				velParam.put("f_rlane_cd", conditionVO.getFRlaneCd());
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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