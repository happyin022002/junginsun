/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PreCMSimulationDBDAO.java
*@FileTitle : Pre CM/OP Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.15 송호진
* 1.0 Creation
* History
* 2008-05-16 Ari
* 1.0 최초 생성 CSR No.N200804140004, N200804146015, N200804146018
* 2008-6-27 박칠서 CSR N200806240001
* 2008-6-27 전성진 CSR No.N200806247554
* 					Pre CM/OP Remark 변경, 정렬 순서 변경.
* 2008-11-07 전윤주 CSR No.N200810310017
*                  ABC/STP의 매핑정보 월별관리 쿼리 수정 [155]
* 2009-03-05 Ari CSR No.N200902250060 DEM/DET, MRI MISC Rev 추가
* 2009-03-05 Ari CSR No.N200902250060 MRI 쿼리 변경
* 2009-03-06 Ari CSR No.N200902250060 MRI 쿼리 변경
* 2009-04-17 임옥영:N200904080070 D term, R term에 'I', 'O', 'T', 'M'추가
* 2009-04-23 Ari CSR No.N200904070080 CM/OP 변경, 계정 코드 정렬조건 변경 
* 2009-05-19 박수훈 N200905060131,N200905060120 TMFDFL 인 경우 화면에서 보여줄 때 'TMFDMT' 계정으로 보여주게 수정 [155]
* 2009-06-10 박상희 N200905110270 COA_Pre CM/OP Simulation : Temp T/S Route 입력기능 
* 2010.09.28 박은주 OPMS 결함 복구작업 [메소드명 변경]
*                  createCoaCostPkgPreCMAbc => createCoaCostPkgPreCMAbcStp
* 2011.10.13 최성민 [CHM-201113894-01] [COA, PRD] FMX AUBNE 요율 조회문제
* 2012.04.10 최윤성 [CHM-201217066-01] [COA] EMU 로직 보완 - MTY_PKUP_YD_CD 변수 추가
* 2012.08.03 전윤주 [CHM-201216347] [COA] ACM 프로젝트 연동 변경 작업
*                 기존 AGT JAVA 소스를 호출하던 부분을 ACM 프로시져 호출로 변경함
* 2013.09.26 김수정 [CHM-201326654] EMU 로직 보완_Trunk 구간 평균단가 제외 및 BKG DEL 기준에서 MT Return CY 기준으로 변경
*=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.coa.common.vo.CommonCoaRsVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.basic.PreCMSimulationBCImpl;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.vo.PreCMRemarkVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.vo.SearchCondition0153VO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.util.WebKeys;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS PreCMSimulationDBDAO <br>
 * - ALPS-MultiDimensionRPT system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Song Ho Jin
 * @see PreCMSimulationBCImpl 참조
 * @since J2EE 1.6
 */
public class PreCMSimulationDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5422724766567514549L;
	
	/**
	 * 비용 조회
	 * 
	 * @param SearchCondition0153VO searchCondition0153VO
	 * @return CommonCoaRsVO
	 * @throws DAOException
	 */
	public CommonCoaRsVO searchPreCMSimulationCostList(SearchCondition0153VO searchCondition0153VO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonCoaRsVO commonCoaRsVO = new CommonCoaRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchCondition0153VO != null){
				Map<String, String> mapVO = searchCondition0153VO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PreCMSimulationDBDAOSearchPreCMSimulationCostListRSQL(), param, velParam);
			commonCoaRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonCoaRsVO;
	}
	/**
	 * 기본정보(PARA DATA) 생성
	 * 
	 * 2012.04.10 최윤성 [CHM-201217066-01] [COA] EMU 로직 보완 - MTY_PKUP_YD_CD 변수 추가
	 * 
	 * @param  searchCondition0153VO SearchCondition0153VO
	 * @return String
	 * @throws DAOException
	 */
	public String createCostAssignPreCM(SearchCondition0153VO searchCondition0153VO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		@SuppressWarnings("rawtypes")
		Map rtnMap = null;
		String rtnValue = null;

		log.debug("\n\ncreateCostAssignPreCM " );
		try{
			if(searchCondition0153VO != null){
				
				// Product Catalog Inquiry 화면에서 사용하는 Proc와의 일치화 작업으로 인해 추가됨.
				searchCondition0153VO.setFStartPctlNo(searchCondition0153VO.getFPctlNo());
				searchCondition0153VO.setFEndPctlNo(searchCondition0153VO.getFPctlNo());
				
				Map<String, String> mapVO = searchCondition0153VO .getColumnValues();			
				param.putAll(mapVO);
				param.put("f_mty_pkup_yd", searchCondition0153VO.getFMtyPkupYdCd() + searchCondition0153VO.getFMtyPkupYdNode());
			
				
				if(searchCondition0153VO.getFMtyRtnYdChk().equals("Y") 
						&& !searchCondition0153VO.getFMtyRtnYdCd().equals("") 
						&& !searchCondition0153VO.getFMtyRtnYdNode().equals("")) {
					param.put("f_mty_rtn_yd", searchCondition0153VO.getFMtyRtnYdCd() + searchCondition0153VO.getFMtyRtnYdNode());					
				}
				
				velParam.putAll(mapVO);
				velParam.put("f_call_id", "PRE");
				velParam.put(WebKeys.PROC_SCALE_KEY, "8");
			}
			rtnMap = new SQLExecuter("").executeSP((ISQLTemplate)new PreCMSimulationDBDAOExecuteSPRSQL(), param, velParam);
			log.debug("\n\n\ncoa_cost_assign_precm_prc result : [" + rtnMap.get("f_out_param_number") + "]" );
			rtnValue = ""; //(String)rtnMap.get("f_out_param_number");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
		/*
		 * CALL COA_COST_ASSIGN_PRECM_PRC(	@[f_out_param_number],@[f_start_pctl_no],@[f_end_pctl_no],@[f_user_id],@[f_g_rev],
									@[f_agmt_sgn_ofc_cd],@[f_ppd_ofc_cd],@[f_clt_ofc_cd])		
		
			CREATE OR REPLACE PROCEDURE coa_cost_assign_precm_prc(
			   RESULT               OUT      NUMBER
			  ,in_start_pctl_no     IN       VARCHAR2
			  ,in_end_pctl_no       IN       VARCHAR2
			  ,in_usr_id            IN       VARCHAR2
			  ,in_ttl_rev           IN       NUMBER
			  ,in_agmt_sgn_ofc_cd   IN       VARCHAR2   --ABC계산용
			  ,in_ppd_ofc_cd        IN       VARCHAR2   --ABC계산용
			  ,in_clt_ofc_cd        IN       VARCHAR2   --ABC계산용
			)				
		 */	
	}
	/**
	 * 기준년월 조회
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String searchBzcCostYrmon() throws DAOException{
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String rtnValue = null;

		try{
/*			if(searchCondition0153VO != null){
				Map<String, String> mapVO = searchCondition0153VO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} */
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PreCMSimulationDBDAOSearchBzcCostYrmonRSQL(), param, velParam);
			while ( dbRowset.next()){
				rtnValue = dbRowset.getString("cost_yrmon");
			}
//			commonCoaRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
		/*
		Connection con = null;// Connection Interface
		PreparedStatement ps = null;// 정적파싱을 지원하는 SQL Statement
		ResultSet rs = null;// DB ResultSet
		int i = 1;// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		String cost_yrmon = "";
		String nullStr = "";
		
		String queryStr = "\n SELECT coa_bzc_cost_yrmon_fnc('', '') cost_yrmon FROM DUAL";
	
		try {
			
			con = getConnection();
	
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr);
			} else {
				ps = con.prepareStatement(queryStr);
			}
			
			ps.setString(i++, nullStr);
			ps.setString(i++, nullStr);	
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				log.info("\n searchBzcCostYrmon SQL :" + ((LoggableStatement) ps).getQueryString());
			} else {
				log.info("\n searchBzcCostYrmon SQL :" + queryStr);
			}
	
			rs = ps.executeQuery();
			while(rs.next()) {
				cost_yrmon = rs.getString("cost_yrmon");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return cost_yrmon;
		*/
	}
	/**
	 * TRS 비용 생성
	 * 
	 * @param  searchCondition0153VO SearchCondition0153VO
	 * @return String
	 * @throws DAOException
	 */
	public String createTrsAgmtApplyToCoa(SearchCondition0153VO searchCondition0153VO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map rtnMap = null;
		String rtnValue = null;

		log.debug("\n\ncreateTrsAgmtApplyToCoa" );
		try{
			if(searchCondition0153VO != null){
				Map<String, String> mapVO = searchCondition0153VO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("f_call_id", "TRS");
				velParam.put(WebKeys.PROC_SCALE_KEY, "8");
			}
			rtnMap = new SQLExecuter("").executeSP((ISQLTemplate)new PreCMSimulationDBDAOExecuteSPRSQL(), param, velParam);
			log.debug("\n\n\ntrs_agmt_apply_to_coa_prc result : [" + rtnMap.get("f_out_param_number") + "]" );
			rtnValue = ""; //(String)rtnMap.get("f_out_param_number");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
		/*
		ESM_COA_153Event event = (ESM_COA_153Event) e;
		Connection con = null; // Connection Interface
		CallableStatement cs = null; // 정적파싱을 지원하는 SQL Statement
		int i = 1; // PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int resultCount = 0; // 수행 결과가 정상인지를 판별하기 위한 변수
		
		String nullStr = "";
		
		String msg = "";		
		String queryStr = "\n CALL trs_agmt_apply_to_coa_prc('','',@[f_pctl_no],@[f_pctl_no],?)";
	
		try {
			con = getConnection();
			cs = con.prepareCall(queryStr);
	
			//
			// ( pi_bkg_no IN COA_COM_PARA.BKG_NO%TYPE 
			// , pi_bkg_no_split IN COA_COM_PARA.BKG_NO_SPLIT%TYPE 
			// , pi_start_pctl_no IN COA_COM_PARA.PCTL_NO%TYPE 
			// , pi_end_pctl_no IN COA_COM_PARA.PCTL_NO%TYPE 
			// , po_rtn_cd OUT NUMBER )
			//
			// 쿼리에 변수 세팅.
			cs.setString(i++, nullStr);
			cs.setString(i++, nullStr);
			cs.setString(i++, JSPUtil.getNull(event.getString("f_pctl_no")));
			cs.setString(i++, JSPUtil.getNull(event.getString("f_pctl_no")));
			cs.registerOutParameter(5, OracleTypes.INTEGER);
	
			// Logging
			log.info("\n createTrsAgmtApplyToCoa SQL :" + queryStr);
			
			//execute
			resultCount = cs.executeUpdate();
			log.debug("\n### createTrsAgmtApplyToCoa Result : " + resultCount);
			if(resultCount>0) msg = null;
	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		} finally {
			closeStatement(cs);
			closeConnection(con);
		}
		return msg;
		*/
	}
	/**
	 * TES 비용 생성
	 * 
	 * @param  searchCondition0153VO SearchCondition0153VO
	 * @return String
	 * @throws DAOException
	 */
	public String createTesCoaRate(SearchCondition0153VO searchCondition0153VO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map rtnMap = null;
		String rtnValue = null;
log.debug("\n\ncreateTesCoaRate=" );

		try{
			if(searchCondition0153VO != null){
				Map<String, String> mapVO = searchCondition0153VO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("f_call_id", "TES");
				velParam.put(WebKeys.PROC_SCALE_KEY, "8");
			}
			rtnMap = new SQLExecuter("").executeSP((ISQLTemplate)new PreCMSimulationDBDAOExecuteSPRSQL(), param, velParam);
			log.debug("\n\n\ntes_coa_rate_prc result : [" + rtnMap.get("f_out_param_number") + "]" );
			rtnValue = ""; //(String)rtnMap.get("f_out_param_number");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
		/*
		ESM_COA_153Event event = (ESM_COA_153Event) e;
		Connection con = null; // Connection Interface
		CallableStatement cs = null; // 정적파싱을 지원하는 SQL Statement
		int i = 1; // PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int resultCount = 0; // 수행 결과가 정상인지를 판별하기 위한 변수
		
		String msg = "";	
		String nullStr = "";
		String queryStr = "\n CALL tes_coa_rate_prc('','',@[f_pctl_no],@[f_pctl_no],?)";
	
		try {
			con = getConnection();
			cs = con.prepareCall(queryStr);
	
			// 쿼리에 변수 세팅.
			cs.setString(i++, nullStr);
			cs.setString(i++, nullStr);
			cs.setString(i++, JSPUtil.getNull(event.getString("f_pctl_no")));
			cs.setString(i++, JSPUtil.getNull(event.getString("f_pctl_no")));
			cs.registerOutParameter(5, OracleTypes.NUMBER);
	
			// Logging
			log.info("\n createTrsAgmtApplyToCoa SQL :" + queryStr);
			
			//execute
			resultCount = cs.executeUpdate();
			log.debug("\n### createTrsAgmtApplyToCoa Result : " + resultCount);
			if(resultCount>0) msg = null;
	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		} finally {
			closeStatement(cs);
			closeConnection(con);
		}
		return msg;
		*/
	}
	/**
	 * COA 평균단가를 이용한 비용 생성
	 * 
	 * @param  searchCondition0153VO SearchCondition0153VO
	 * @return String
	 * @throws DAOException
	 */
	public String createCoaCostPkgMainPreCMAvg(SearchCondition0153VO searchCondition0153VO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map rtnMap = null;
		String rtnValue = null;

		try{
			if(searchCondition0153VO != null){
				Map<String, String> mapVO = searchCondition0153VO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("f_call_id", "AVG");
			}
			rtnMap = new SQLExecuter("").executeSP((ISQLTemplate)new PreCMSimulationDBDAOExecuteSPRSQL(), param, velParam);
			rtnValue = "";
//			rtnValue = (String)rtnMap.get("f_out_param_number");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
		/*
		ESM_COA_153Event event = (ESM_COA_153Event) e;
		Connection con = null; // Connection Interface
		CallableStatement cs = null; // 정적파싱을 지원하는 SQL Statement
		int i = 1; // PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int resultCount = 0; // 수행 결과가 정상인지를 판별하기 위한 변수
		
		String msg = "";		
		String queryStr = "\n CALL coa_cost_para_assign_pkg.main_precm_avg(@[f_pctl_no],@[f_cost_yrmon],@[f_void_qty])";
		
		//
		//   PROCEDURE main_precm_avg(
		//		     in_start_pctl_no   IN   VARCHAR2
		//		     ,in_cost_yrmon      IN   VARCHAR2
		//		     ,in_void_vol IN NUMBER
		//		   );		
		//
		try {
			con = getConnection();
			cs = con.prepareCall(queryStr);
	
			// 쿼리에 변수 세팅.
			cs.setString(i++, JSPUtil.getNull(event.getString("f_pctl_no")));
			cs.setString(i++, event.getCost_yrmon());
			cs.setFloat(i++, Float.parseFloat(JSPUtil.getNull(event.getString("f_void_qty"))));
	
			// Logging
			log.info("\n### createCoaCostPkgMainPreCMAvg SQL :" + queryStr);
			
			//execute
			resultCount = cs.executeUpdate();
			log.debug("\n### createCoaCostPkgMainPreCMAvg Result : " + resultCount);
			if(resultCount>0) msg = null;
	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		} finally {
			closeStatement(cs);
			closeConnection(con);
		}
		return msg;
		*/
	}
	/**
	 * COA ABC 비용 생성
	 * 
	 * @param  searchCondition0153VO SearchCondition0153VO
	 * @return String
	 * @throws DAOException
	 */
	public String createCoaCostPkgPreCMAbcStp(SearchCondition0153VO searchCondition0153VO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map rtnMap = null;
		String rtnValue = null;

		try{
			if(searchCondition0153VO != null){
				Map<String, String> mapVO = searchCondition0153VO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("f_call_id", "ABC");
			}
			rtnMap = new SQLExecuter("").executeSP((ISQLTemplate)new PreCMSimulationDBDAOExecuteSPRSQL(), param, velParam);
			rtnValue = "";
//			rtnValue = (String)rtnMap.get("f_out_param_number");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
		/*
		ESM_COA_153Event event = (ESM_COA_153Event) e;
		Connection con = null; // Connection Interface
		CallableStatement cs = null; // 정적파싱을 지원하는 SQL Statement
		int i = 1; // PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int resultCount = 0; // 수행 결과가 정상인지를 판별하기 위한 변수
		
		String msg = "";		
		String queryStr = "\n CALL coa_cost_para_assign_pkg.main_precm_abc_stp(@[f_pctl_no],@[f_pctl_no],@[f_cost_yrmon])";
	
		try {
			con = getConnection();
			cs = con.prepareCall(queryStr);
	
			// 쿼리에 변수 세팅.
			cs.setString(i++, JSPUtil.getNull(event.getString("f_pctl_no")));
			cs.setString(i++, JSPUtil.getNull(event.getString("f_pctl_no")));
			cs.setString(i++, event.getCost_yrmon());
	
			// Logging
			log.info("\n### createCoaCostPkgPreCMAbc SQL :" + queryStr);
			
			//execute
			resultCount = cs.executeUpdate();
			log.debug("\n### createCoaCostPkgMainPreCMAvg Result : " + resultCount);
			if(resultCount>0) msg = null;
	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		} finally {
			closeStatement(cs);
			closeConnection(con);
		}
		return msg;
		*/
	}
	
	
	/**
	 * AGT Other Comm 비용 생성
	 * 
	 * @param  searchCondition0153VO SearchCondition0153VO
	 * @return String
	 * @throws DAOException
	 */
	public String createAcmAplyOtrCommToCoa(SearchCondition0153VO searchCondition0153VO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map rtnMap = null;
		String rtnValue = null;

		try{
			if(searchCondition0153VO != null){
				Map<String, String> mapVO = searchCondition0153VO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("f_call_id", "AGT");
			}
			rtnMap = new SQLExecuter("").executeSP((ISQLTemplate)new PreCMSimulationDBDAOExecuteSPRSQL(), param, velParam);
			rtnValue = "";
//			rtnValue = (String)rtnMap.get("f_out_param_number");
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
	 * Total 비용 계산 및 USD환산
	 * 
	 * @param  searchCondition0153VO SearchCondition0153VO
	 * @return String
	 * @throws DAOException
	 */
	public String createCoaCostPkgMainComTtl(SearchCondition0153VO searchCondition0153VO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		Map rtnMap = null;
		String rtnValue = null;

		try{
			if(searchCondition0153VO != null){
				Map<String, String> mapVO = searchCondition0153VO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("f_call_id", "TTL");
			}
			rtnMap = new SQLExecuter("").executeSP((ISQLTemplate)new PreCMSimulationDBDAOExecuteSPRSQL(), param, velParam);
			rtnValue = "";
//			rtnValue = (String)rtnMap.get("f_out_param_number");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
		/*
		ESM_COA_153Event event = (ESM_COA_153Event) e;
		Connection con = null; // Connection Interface
		CallableStatement cs = null; // 정적파싱을 지원하는 SQL Statement
		int i = 1; // PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int resultCount = 0; // 수행 결과가 정상인지를 판별하기 위한 변수
		
		String msg = "";	
		String nullStr = "";
		String queryStr = "\n CALL coa_cost_para_assign_pkg.main_com_ttl_para('','',@[f_pctl_no],@[f_pctl_no],@[f_cost_yrmon])";
	
		try {
			con = getConnection();
			cs = con.prepareCall(queryStr);
	
			// 쿼리에 변수 세팅.
			cs.setString(i++, nullStr);
			cs.setString(i++, nullStr);
			cs.setString(i++, JSPUtil.getNull(event.getString("f_pctl_no")));
			cs.setString(i++, JSPUtil.getNull(event.getString("f_pctl_no")));
			cs.setString(i++, event.getCost_yrmon());
	
			// Logging
			log.info("\n### createCoaCostPkgMainComTtl SQL :" + queryStr);
			
			//execute
			resultCount = cs.executeUpdate();
			log.debug("\n### createCoaCostPkgMainComTtl Result : " + resultCount);
			if(resultCount>0) msg = null;
	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		} finally {
			closeStatement(cs);
			closeConnection(con);
		}
		return msg;
		*/
	}
	/**
	 * 비용 RMK 상세조회
	 * 
	 * @param searchCondition0153VO SearchCondition0153VO
	 * @return List<PreCMRemarkVO>
	 * @throws DAOException
	 */
	public List<PreCMRemarkVO> searchPreCMRemarkList(SearchCondition0153VO searchCondition0153VO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreCMRemarkVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchCondition0153VO != null){
				Map<String, String> mapVO = searchCondition0153VO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PreCMSimulationDBDAOSearchPreCMRemarkListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreCMRemarkVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}