/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : CommonDBDAO.java
*@FileTitle      : Common
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.06
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.06 SQM USER
* 1.0 Creation
* 2013.12.10 PEJ [CHM-201328059] searchLaneMasterList 수정
* 2014.01.16 PEJ [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2014.08.16 이혜민 [CHM-201431396] Portion Adjustment 화면의 Office 신규 row add 버튼 생성
* 2015.07.09 김용습 [CHM-201536817] [CSR 전환건] Final QTA Adjustment > Post QTA Adjustment > QTA Edit for IAS Sector 화면 내 Week 조회 로직 수정
* 2016.01.28 최성민 [CHM-201639851] Basic Data Creation for IAS Secotr 화면의 Creation 로직 변경
* 2016.07.15 CHM-201642546 Allocation = QTA Adjustment 화면 Office Add 버튼 추가
* 2016.08.11 Basic CMCB (CM Cost Per Box) 화면 Add Creation 버튼 추가

=========================================================*/
package com.hanjin.apps.alps.esm.sqm.common.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esm.sqm.common.vo.CommonVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS CommonDBDAO <br>
 * - ALPS-Common system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SQM USER
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
	 * SQM_QTA_LANE_MGMT 테이블에서 Sector Sale 정보를 제외
	 * 
	 * @param code String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchTradeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		String currentQTA = null;
		try {
			if (code.equals("") ) {
				// Loading 시에는 현재 쿼터를 조회
				velParam.put("methodname", "searchCurrentQtaList");
				dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), velParam, velParam);
				dRs.next();
				currentQTA = dRs.getObject("CODE").toString();
			} else {
				// Change 시에는 선택한 쿼터를 사용
				currentQTA = code;
			}
			
			velParam.put("methodname", "searchTradeList");
			if ( Integer.parseInt(currentQTA.replace("-","").replace("Q","")) > 20142) {
				velParam.put("sctr_flag", "Y");
			} else {
				velParam.put("sctr_flag", "N");
			}			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), null, velParam);
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
	public DBRowSet searchSubTradeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchSubTradeList");
			
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
	 * H/O Teams 콤보의 목록을 가져온다.<br>
	 * SQM_DAT_RLT
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
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), null, velParam);
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
	 * SQM_ORGANIZATION_V
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
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * MAS_WK_PRD
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
	 * SQM_ORGANIZATION_V
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
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * MAS_WK_PRD
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
	 * SQM_DAT_RLT
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
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * SQM_QTA_LANE_MGMT
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
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * SQM_QTA_OFC
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
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * SQM_QTA_OFC
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
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * Active flg가 Y인 ofc 가져온다<br>
	 * SQM_QTA_LANE_OFC
	 * 
	 * @param ConditionVO conditionVO
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchActiveOfc(ConditionVO conditionVO) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchActiveOfc");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * Week를 조회한다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRevisedWeekForSector(ConditionVO conditionVO) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchRevisedWeekForSector");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	public DBRowSet searchRevisedWeekForOverall(ConditionVO conditionVO) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchRevisedWeekForOverall");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * SQM_CFM_TGT_VVD
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
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * SQM_SPCL_TGT_VVD
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSpclVvdList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchSpclVvdList");
			
			if(!code.equals("")){
				String[] codeArr = code.split("[|]");
				
				param.put("f_bse_yr",		codeArr[0]);
				param.put("f_bse_qtr_cd",	codeArr[1]);
				param.put("f_trd_cd", 		codeArr[2]);
				param.put("f_sub_trd_cd",	codeArr[3]);
				param.put("f_dir_cd", 		codeArr[4]);
				param.put("f_rlane_cd",		codeArr[5]);
			}
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * Adjustment Lane List 를 가져온다.<br>
	 * SQM_CFM_TGT_VVD
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchAdjLaneList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchAdjLaneList");
			
			if(!code.equals("")){
				String[] codeArr = code.split("[|]");
				
				param.put("f_bse_tp_cd",	codeArr[0]);
				param.put("f_bse_yr",		codeArr[1]);
				param.put("f_bse_qtr_cd",	codeArr[2]);
				param.put("f_trd_cd", 		codeArr[3]);
			}
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * SQM_QTA_LANE_MGMT
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
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * Spcl Adjustment Lane List 를 조회한다.<br>
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSpclAdjLaneList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchSpclAdjLaneList");
			
			if(!code.equals("")){
				String[] codeArr = code.split("[|]");
				
				param.put("f_bse_tp_cd",	codeArr[0]);
				param.put("f_bse_yr",		codeArr[1]);
				param.put("f_bse_qtr_cd",	codeArr[2]);
				param.put("f_trd_cd", 		codeArr[3]);
			}
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * Lane Master 상의 R.Lane 콤보의 목록을 가져온다.<br>
	 * SQM_QTA_LANE_MGMT
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
				
				param.put("f_trd_cd", codeArr[0]);
				velParam.put("f_trd_cd", codeArr[0]);
				param.put("f_sub_trd_cd", codeArr.length>1?codeArr[1]:"");
				velParam.put("f_sub_trd_cd", codeArr.length>1?codeArr[1]:"");
				param.put("f_ias_rgn_cd", codeArr.length>2?codeArr[2]:"");
				velParam.put("f_ias_rgn_cd", codeArr.length>2?codeArr[2]:"");
 			
			}
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * Lane Office Relation Setting 하면의 RHQ 목록을 가져온다.<br>
	 * SQM_QTA_LANE_OFC
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLaneRHQList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchLaneRHQList"); 
			
			if(!code.equals("")){
				String[] codeArr = code.split("[|]");
				
				param.put("f_bse_yr", codeArr[0]);
				param.put("f_bse_qtr_cd", codeArr[1]);
				param.put("f_trd_cd", codeArr[2]);
				param.put("f_rlane_cd", codeArr[3]);				

			}
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * Lane Office Relation Setting 하면의 Office 목록을 가져온다.<br>
	 * SQM_QTA_LANE_OFC
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLaneOfficeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchLaneOfficeList"); 
			
			if(!code.equals("")){
				String[] codeArr = code.split("[|]");
				
				param.put("f_bse_yr", codeArr[0]);
				param.put("f_bse_qtr_cd", codeArr[1]);
				param.put("f_trd_cd", codeArr[2]);
				param.put("f_rlane_cd", codeArr[3]);
				param.put("f_rhq_cd", codeArr[4]);				

			}
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * MAS_WK_PRD
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
	 * SQM_QTA_LANE_MGMT
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
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * Sub Trade 또는 IAS Region에 따라 rLane Sector List를 가져온다<br>
	 * SQM_QTA_LANE_MGMT, MAS_LANE_RGST
	 * 
	 * @param ConditionVO conditionVO
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRLaneSector(ConditionVO conditionVO, String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			velParam.put("methodname", "searchRLaneSector");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * SQM_SCTR_PAIR_MGMT
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
				velParam.put("tb_nm", "sqm_sctr_pair_mgmt");
			}else if(codeItem.equals("polCdSectorOfc")){
				velParam.put("tb_nm", "sqm_sctr_lane_ofc");
			}
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * SQM_SCTR_PAIR_MGMT
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
				velParam.put("tb_nm", "sqm_sctr_pair_mgmt");
			}else if(codeItem.equals("podCdSectorOfc")){
				velParam.put("tb_nm", "sqm_sctr_lane_ofc");
			}
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * SQM_SCTR_PAIR_MGMT
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
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * SQM_SCTR_PAIR_MGMT
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
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
			
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
	 * SQM_SCTR_PAIR_MGMT
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
				velParam.put("tb_nm", "sqm_sctr_pair_mgmt");
			}else if(codeItem.equals("pfGroupOfc")){
				velParam.put("tb_nm", "sqm_sctr_lane_ofc");
			}else if(codeItem.equals("pfGroup")){
				velParam.put("tb_nm", "sqm_sctr_pf_grp");
			}
			if(code != null){
				code = "'" + code.replaceAll("-" ,"','") +"'";
				velParam.put("f_rlane_cd", code);
			}
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeRSQL(), param, velParam);
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
	 * SQM_QTA_LANE_OFC
	 * 
	 * @param ConditionVO conditionVO
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRLaneControlSector(ConditionVO conditionVO) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			
			velParam.put("methodname", "searchRLaneControlSectorList"); 
			
			if(conditionVO != null){
				param.put("f_bse_tp_cd", conditionVO.getFBseTpCd());
				velParam.put("f_bse_tp_cd", conditionVO.getFBseTpCd());
				param.put("f_bse_yr", conditionVO.getFBseYr());
				velParam.put("f_bse_yr", conditionVO.getFBseYr());
				param.put("f_bse_qtr_cd", conditionVO.getFBseQtrCd());
				velParam.put("f_bse_qtr_cd", conditionVO.getFBseQtrCd());
				param.put("f_sub_trd_cd", conditionVO.getFSubTrdCd());
				velParam.put("f_sub_trd_cd", conditionVO.getFSubTrdCd());
				param.put("f_ias_rgn_cd", conditionVO.getFIasRgnCd());
				velParam.put("f_ias_rgn_cd",conditionVO.getFIasRgnCd());
			}
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * SQM_QTA_LANE_OFC
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
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * SQM_QTA_TGT_VVD
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
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * Lane-Office Relation의 RLane 목록을 가져온다.<br>
	 * SQM_QTA_LANE_OFC
	 * 
	 * @param ConditionVO conditionVO
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLaneOfcList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param    = new HashMap<String, Object>();	// parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	// velocity parameter
		
		try {
			
			velParam.put("methodname", "searchLaneOfcList"); 
			
			if(conditionVO != null){
				param.put("f_bse_tp_cd", conditionVO.getFBseTpCd());
				velParam.put("f_bse_tp_cd", conditionVO.getFBseTpCd());
				param.put("f_bse_yr", conditionVO.getFBseYr());
				velParam.put("f_bse_yr", conditionVO.getFBseYr());
				param.put("f_bse_qtr_cd", conditionVO.getFBseQtrCd());
				velParam.put("f_bse_qtr_cd", conditionVO.getFBseQtrCd());
				param.put("f_trd_cd", conditionVO.getFTrdCd());
				velParam.put("f_trd_cd", conditionVO.getFTrdCd());
			}
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
			
			dRs = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOSearchCommonCodeForPlanningRSQL(), param, velParam);
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
	 * BATCH status 를 생성한다. <br>
	 *
	 * @param CommonVO commonVO
	 * @throws DAOException
	 */
	public void addBatchStatus(CommonVO commonVO) throws DAOException{	    
		Map<String, Object> param = new HashMap<String, Object>();
		
        try{          
        	SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
        	if(commonVO != null ){
				Map<String, String> mapVO = commonVO.getColumnValues();
				param.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new CommonDBDAOBatchStatusCSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED){							
					throw new DAOException("Fail to insert No SQL");
				}
			}
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
	

	/**
	 * BATCH의 STATUS를 알아본다.<br>

	 * @param  CommonVO commonVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchBatchStatus(CommonVO commonVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String batStsCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(commonVO != null){
				Map<String, String> mapVO = commonVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CommonDBDAOBatchStatusRSQL(), param, velParam);
			if (dbRowset.next()) {
				batStsCd = dbRowset.getString("BAT_STS_CD");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return batStsCd;
	}
	

}