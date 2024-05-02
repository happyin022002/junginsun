/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USA Rail PerformanceDBDAO.java
*@FileTitle : USA Rail Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.27
*@LastModifier : 최 선
*@LastVersion : 1.4
* 2007.12.19 Jun Ho Kim
* 1.0 최초 생성
* -------------------------------------------------------
* history
* 2011.02.18 1.1 손은주 [CHM-201108834-01][TRS] Rail performance Report 부분의 주 단위 data 조회기능 추가 요청
* 2011.05.27 1.2 김종호 [CHM-201110817] [TRS] US Rail report 기능 보완 / 추가 요청
* 2011.06.10 1.3 김종호 [CHM-201110817] [TRS] US Rail report 기능 보완 / 추가 요청 
* 2011.07.27 1.4 최 선     [CHM-201111646] [TRS] US rail report 조회 조건 보완 요청
* 2013.05.15 조인영 [CHM-201324500] Rail performance report by SO (NYCNA) domestic data 추가
* 2013.06.25 조인영 [CHM-201324798] [TRS] Report 메뉴 40ft CNTR 세분화 및 조회조건 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.usarailperformance.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.report.usarailperformance.event.EsdTrs0102Event;
import com.hanjin.apps.alps.esd.trs.report.usarailperformance.event.EsdTrs0103Event;
import com.hanjin.apps.alps.esd.trs.report.usarailperformance.vo.SearchRailPerformanceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ENIS-USA Rail Performance에 대한 DB 처리를 담당<br>
 * - ENIS-USA Rail Performance Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jun Ho Kim
 * @see USA Rail PerformanceBCImpl 참조
 * @since J2EE 1.4
 */
public class USARailPerformanceDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * USA Rail Performance의 모든 목록을 가져온다.<br>
	 * ENIS - Inv기준, Lane/VVD Unchecked
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchENISInvRailPerformance(EsdTrs0102Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			SearchRailPerformanceVO model = event.getSearchRailPerformanceVo();
			
			if( model != null ){
				Map<String, String> condiParams = model.getColumnValues();

				String input_fm_node = condiParams.get("frm_node")+condiParams.get("frm_yard");
				String input_to_node = condiParams.get("to_node" )+condiParams.get("to_yard");
				if( input_fm_node == null ) input_fm_node = "";
				if( input_to_node == null ) input_to_node = "";
				
				param.put("comp_cd"      , condiParams.get("comp_cd"));
				param.put("vndr_seq"     , condiParams.get("rail_road_code"));
				param.put("cgo_tp_cd"    , condiParams.get("status"));
				param.put("io_bound"     , condiParams.get("io_bound"));
				param.put("ctrl_ofc"     , condiParams.get("ctrl_ofc"));
				param.put("input_fm_node", input_fm_node);
				param.put("input_to_node", input_to_node);
				param.put("fm_month"     , condiParams.get("fm_date"));
				param.put("to_month"     , condiParams.get("to_date"));
				param.put("fm_node_length", input_fm_node.length());
				param.put("to_node_length", input_to_node.length());
				param.put("f_chkprd", condiParams.get("f_chkprd"));
				param.put("loc_on", condiParams.get("loc_on"));
				param.put("agmt_ref_no", condiParams.get("agmt_ref_no"));
				param.put("agmt_chk", condiParams.get("agmt_chk"));
				param.put("cntr_tpsz", condiParams.get("cntr_tpsz"));

			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USARailPerformanceDBDAOSearchENISInvRailPerformanceRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		
		return dbRowset;
	}

	/**
	 * USA Rail Performance의 모든 목록을 가져온다.<br>
	 * ENIS - Inv기준, Lane/VVD checked
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchENISInvRailPerformanceByLaneVvd(EsdTrs0102Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			SearchRailPerformanceVO model = event.getSearchRailPerformanceVo();
			
			if( model != null ){
				Map<String, String> condiParams = model.getColumnValues();

				String input_fm_node = condiParams.get("frm_node")+condiParams.get("frm_yard");
				String input_to_node = condiParams.get("to_node" )+condiParams.get("to_yard");
				if( input_fm_node == null ) input_fm_node = "";
				if( input_to_node == null ) input_to_node = "";
				
				param.put("comp_cd"      , condiParams.get("comp_cd"));
				param.put("vndr_seq"     , condiParams.get("rail_road_code"));
				param.put("cgo_tp_cd"    , condiParams.get("status"));
				param.put("io_bound"     , condiParams.get("io_bound"));
				param.put("ctrl_ofc"     , condiParams.get("ctrl_ofc"));
				param.put("input_fm_node", input_fm_node);
				param.put("input_to_node", input_to_node);
				param.put("fm_node_length", input_fm_node.length());
				param.put("to_node_length", input_to_node.length());
				param.put("fm_month"     , condiParams.get("fm_date"));
				param.put("to_month"     , condiParams.get("to_date"));
				param.put("f_chkprd", condiParams.get("f_chkprd"));
				param.put("loc_on", condiParams.get("loc_on"));
				param.put("agmt_ref_no", condiParams.get("agmt_ref_no"));
				param.put("agmt_chk", condiParams.get("agmt_chk"));
				param.put("cntr_tpsz", condiParams.get("cntr_tpsz"));

			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USARailPerformanceDBDAOSearchENISInvRailPerformanceByLaneVvdRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		
		return dbRowset;
	}
	
	/**
	 * USA Rail Performance의 모든 목록을 가져온다.<br>
	 * ENIS - SO기준 (철도회사별), Lane/VVD Unchecked
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchENISSOCRailPerformance(EsdTrs0103Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			SearchRailPerformanceVO model = event.getSearchRailPerformanceVo();
			
			if( model != null ){
				Map<String, String> condiParams = model.getColumnValues();
				
				String input_fm_node = condiParams.get("frm_node")+condiParams.get("frm_yard");
				String input_to_node = condiParams.get("to_node" )+condiParams.get("to_yard");
				if( input_fm_node == null ) input_fm_node = "";
				if( input_to_node == null ) input_to_node = "";
				
				param.put("vndr_seq"     , condiParams.get("rail_road_code"));
				param.put("cgo_tp_cd"    , condiParams.get("status"));
				param.put("io_bound"     , condiParams.get("io_bound"));
				param.put("ctrl_ofc"     , condiParams.get("ctrl_ofc"));
				param.put("input_fm_node", input_fm_node);
				param.put("input_to_node", input_to_node);
				param.put("fm_month"     , condiParams.get("fm_date"));
				param.put("to_month"     , condiParams.get("to_date"));
				param.put("fm_node_length", input_fm_node.length());
				param.put("to_node_length", input_to_node.length());
				param.put("f_chkprd", condiParams.get("f_chkprd"));
				param.put("loc_on", condiParams.get("loc_on"));
				param.put("agmt_ref_no", condiParams.get("agmt_ref_no"));
				param.put("agmt_chk", condiParams.get("agmt_chk"));
				param.put("cntr_tpsz", condiParams.get("cntr_tpsz"));
				
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USARailPerformanceDBDAOSearchENISSOCRailPerformanceRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		
		return dbRowset;
	}
	
	/**
	 * USA Rail Performance의 모든 목록을 가져온다.<br>
	 * ENIS - SO기준 (철도회사 구분없이), Lane/VVD Unchecked
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchENISSORRailPerformance(EsdTrs0103Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			SearchRailPerformanceVO model = event.getSearchRailPerformanceVo();
			
			if( model != null ){
				Map<String, String> condiParams = model.getColumnValues();
				
				String input_fm_node = condiParams.get("frm_node")+condiParams.get("frm_yard");
				String input_to_node = condiParams.get("to_node" )+condiParams.get("to_yard");
				if( input_fm_node == null ) input_fm_node = "";
				if( input_to_node == null ) input_to_node = "";
				
				param.put("cgo_tp_cd"    , condiParams.get("status"));
				param.put("io_bound"     , condiParams.get("io_bound"));
				param.put("ctrl_ofc"     , condiParams.get("ctrl_ofc"));
				param.put("input_fm_node", input_fm_node);
				param.put("input_to_node", input_to_node);
				param.put("fm_month"     , condiParams.get("fm_date"));
				param.put("to_month"     , condiParams.get("to_date"));
				param.put("f_chkprd", condiParams.get("f_chkprd"));
				param.put("loc_on", condiParams.get("loc_on"));
				param.put("agmt_ref_no", condiParams.get("agmt_ref_no"));
				param.put("agmt_chk", condiParams.get("agmt_chk"));
				param.put("cntr_tpsz", condiParams.get("cntr_tpsz"));
				
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USARailPerformanceDBDAOSearchENISSORRailPerformanceRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		
		return dbRowset;
	}

	/**
	 * USA Rail Performance의 모든 목록을 가져온다.<br>
	 * ENIS - SO기준 (철도회사별), Lane/VVD checked
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchENISSOCRailPerformanceByLaneVvd(EsdTrs0103Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			SearchRailPerformanceVO model = event.getSearchRailPerformanceVo();
			
			if( model != null ){
				Map<String, String> condiParams = model.getColumnValues();
				
				String input_fm_node = condiParams.get("frm_node")+condiParams.get("frm_yard");
				String input_to_node = condiParams.get("to_node" )+condiParams.get("to_yard");
				if( input_fm_node == null ) input_fm_node = "";
				if( input_to_node == null ) input_to_node = "";
				
				param.put("vndr_seq"     , condiParams.get("rail_road_code"));
				param.put("cgo_tp_cd"    , condiParams.get("status"));
				param.put("io_bound"     , condiParams.get("io_bound"));
				param.put("ctrl_ofc"     , condiParams.get("ctrl_ofc"));
				param.put("input_fm_node", input_fm_node);
				param.put("input_to_node", input_to_node);
				param.put("fm_month"     , condiParams.get("fm_date"));
				param.put("to_month"     , condiParams.get("to_date"));
				param.put("fm_node_length", input_fm_node.length());
				param.put("to_node_length", input_to_node.length());
				param.put("f_chkprd", condiParams.get("f_chkprd"));
				param.put("loc_on", condiParams.get("loc_on"));
				param.put("agmt_ref_no", condiParams.get("agmt_ref_no"));
				param.put("agmt_chk", condiParams.get("agmt_chk"));
				param.put("cntr_tpsz", condiParams.get("cntr_tpsz"));
				
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USARailPerformanceDBDAOSearchENISSOCRailPerformanceByLaneVvdRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		
		return dbRowset;
	}
	
	/**
	 * USA Rail Performance의 모든 목록을 가져온다.<br>
	 * ENIS - SO기준 (철도회사 구분없이), Lane/VVD checked
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchENISSORRailPerformanceByLaneVvd(EsdTrs0103Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			SearchRailPerformanceVO model = event.getSearchRailPerformanceVo();
			
			if( model != null ){
				Map<String, String> condiParams = model.getColumnValues();
				
				String input_fm_node = condiParams.get("frm_node")+condiParams.get("frm_yard");
				String input_to_node = condiParams.get("to_node" )+condiParams.get("to_yard");
				if( input_fm_node == null ) input_fm_node = "";
				if( input_to_node == null ) input_to_node = "";
				
				param.put("cgo_tp_cd"    , condiParams.get("status"));
				param.put("io_bound"     , condiParams.get("io_bound"));
				param.put("ctrl_ofc"     , condiParams.get("ctrl_ofc"));
				param.put("input_fm_node", input_fm_node);
				param.put("input_to_node", input_to_node);
				param.put("fm_month"     , condiParams.get("fm_date"));
				param.put("to_month"     , condiParams.get("to_date"));
				param.put("fm_node_length", input_fm_node.length());
				param.put("to_node_length", input_to_node.length());
				param.put("f_chkprd", condiParams.get("f_chkprd"));
				param.put("loc_on", condiParams.get("loc_on"));
				param.put("agmt_ref_no", condiParams.get("agmt_ref_no"));
				param.put("agmt_chk", condiParams.get("agmt_chk"));
				param.put("cntr_tpsz", condiParams.get("cntr_tpsz"));
				
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USARailPerformanceDBDAOSearchENISSORRailPerformanceByLaneVvdRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		
		return dbRowset;
	}
	
	/**
	 * USA Rail Performance의 모든 목록을 가져온다.<br>
	 * NIS - SO기준 (철도회사별)
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchNISSOCRailPerformance(EsdTrs0103Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			SearchRailPerformanceVO model = event.getSearchRailPerformanceVo();
			
			if( model != null ){
				Map<String, String> condiParams = model.getColumnValues();
				
				String input_fm_node = condiParams.get("frm_node")+condiParams.get("frm_yard");
				String input_to_node = condiParams.get("to_node" )+condiParams.get("to_yard");
				if( input_fm_node == null ) input_fm_node = "";
				if( input_to_node == null ) input_to_node = "";
				
				param.put("comp_cd"      , condiParams.get("comp_cd"));
				param.put("vndr_seq"     , condiParams.get("rail_road_code"));
				param.put("cgo_tp_cd"    , condiParams.get("status"));
				param.put("io_bound"     , condiParams.get("io_bound"));
				param.put("ctrl_ofc"     , condiParams.get("ctrl_ofc"));
				param.put("input_fm_node", input_fm_node);
				param.put("input_to_node", input_to_node);
				param.put("fm_month"     , condiParams.get("fm_date"));
				param.put("to_month"     , condiParams.get("to_date"));
				param.put("fm_node_length", input_fm_node.length());
				param.put("to_node_length", input_to_node.length());
				param.put("f_chkprd", condiParams.get("f_chkprd"));
				param.put("agmt_ref_no", condiParams.get("agmt_ref_no"));
				param.put("agmt_chk", condiParams.get("agmt_chk"));
				param.put("cntr_tpsz", condiParams.get("cntr_tpsz"));
				
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USARailPerformanceDBDAOSearchNISSOCRailPerformanceRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		
		return dbRowset;
	}
	
	/**
	 * USA Rail Performance의 모든 목록을 가져온다.<br>
	 * NIS - SO기준 (철도회사 구분없이)
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchNISSORRailPerformance(EsdTrs0103Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			SearchRailPerformanceVO model = event.getSearchRailPerformanceVo();
			
			if( model != null ){
				Map<String, String> condiParams = model.getColumnValues();
				
				String input_fm_node = condiParams.get("frm_node")+condiParams.get("frm_yard");
				String input_to_node = condiParams.get("to_node" )+condiParams.get("to_yard");
				if( input_fm_node == null ) input_fm_node = "";
				if( input_to_node == null ) input_to_node = "";
				
				param.put("comp_cd"      , condiParams.get("comp_cd"));
				param.put("cgo_tp_cd"    , condiParams.get("status"));
				param.put("io_bound"     , condiParams.get("io_bound"));
				param.put("ctrl_ofc"     , condiParams.get("ctrl_ofc"));
				param.put("input_fm_node", input_fm_node);
				param.put("input_to_node", input_to_node);
				param.put("fm_month"     , condiParams.get("fm_date"));
				param.put("to_month"     , condiParams.get("to_date"));
				param.put("fm_node_length", input_fm_node.length());
				param.put("to_node_length", input_to_node.length());
				param.put("f_chkprd", condiParams.get("f_chkprd"));
				param.put("cntr_tpsz", condiParams.get("cntr_tpsz"));
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USARailPerformanceDBDAOSearchNISSORRailPerformanceRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		
		return dbRowset;
	}
	
	/**
	 * USA Rail Performance의 모든 목록을 가져온다.<br>
	 * ALL - SO기준 (철도회사 구분없이), Lane/VVD checked
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchALLSORRailPerformanceByLaneVvd(EsdTrs0103Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			SearchRailPerformanceVO model = event.getSearchRailPerformanceVo();
			
			if( model != null ){
				Map<String, String> condiParams = model.getColumnValues();
				
				String input_fm_node = condiParams.get("frm_node")+condiParams.get("frm_yard");
				String input_to_node = condiParams.get("to_node" )+condiParams.get("to_yard");
				if( input_fm_node == null ) input_fm_node = "";
				if( input_to_node == null ) input_to_node = "";
				
				param.put("cgo_tp_cd"    , condiParams.get("status"));
				param.put("io_bound"     , condiParams.get("io_bound"));
				param.put("ctrl_ofc"     , condiParams.get("ctrl_ofc"));
				param.put("input_fm_node", input_fm_node);
				param.put("input_to_node", input_to_node);
				param.put("fm_month"     , condiParams.get("fm_date"));
				param.put("to_month"     , condiParams.get("to_date"));
				param.put("fm_node_length", input_fm_node.length());
				param.put("to_node_length", input_to_node.length());
				param.put("f_chkprd", condiParams.get("f_chkprd"));
				param.put("loc_on", condiParams.get("loc_on"));
				param.put("agmt_ref_no", condiParams.get("agmt_ref_no"));
				param.put("agmt_chk", condiParams.get("agmt_chk"));
				param.put("cntr_tpsz", condiParams.get("cntr_tpsz"));
				
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USARailPerformanceDBDAOSearchALLSORRailPerformanceByLaneVvdRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		
		return dbRowset;
	}
	
	/**
	 * USA Rail Performance의 모든 목록을 가져온다.<br>
	 * ALL - SO기준 (철도회사 구분없이), Lane/VVD unchecked
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchALLSORRailPerformance(EsdTrs0103Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			SearchRailPerformanceVO model = event.getSearchRailPerformanceVo();
			
			if( model != null ){
				Map<String, String> condiParams = model.getColumnValues();
				
				String input_fm_node = condiParams.get("frm_node")+condiParams.get("frm_yard");
				String input_to_node = condiParams.get("to_node" )+condiParams.get("to_yard");
				if( input_fm_node == null ) input_fm_node = "";
				if( input_to_node == null ) input_to_node = "";
				
				param.put("cgo_tp_cd"    , condiParams.get("status"));
				param.put("io_bound"     , condiParams.get("io_bound"));
				param.put("ctrl_ofc"     , condiParams.get("ctrl_ofc"));
				param.put("input_fm_node", input_fm_node);
				param.put("input_to_node", input_to_node);
				param.put("fm_month"     , condiParams.get("fm_date"));
				param.put("to_month"     , condiParams.get("to_date"));
				param.put("fm_node_length", input_fm_node.length());
				param.put("to_node_length", input_to_node.length());
				param.put("f_chkprd", condiParams.get("f_chkprd"));
				param.put("loc_on", condiParams.get("loc_on"));
				param.put("agmt_ref_no", condiParams.get("agmt_ref_no"));
				param.put("agmt_chk", condiParams.get("agmt_chk"));
				param.put("cntr_tpsz", condiParams.get("cntr_tpsz"));
				
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USARailPerformanceDBDAOSearchALLSORRailPerformanceRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		
		return dbRowset;
	}
	
	/**
	 * USA Rail Performance의 모든 목록을 가져온다.<br>
	 * ALL - SO기준 (철도회사별), Lane/VVD checked
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchALLSOCRailPerformanceByLaneVvd(EsdTrs0103Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			SearchRailPerformanceVO model = event.getSearchRailPerformanceVo();
			
			if( model != null ){
				Map<String, String> condiParams = model.getColumnValues();
				
				String input_fm_node = condiParams.get("frm_node")+condiParams.get("frm_yard");
				String input_to_node = condiParams.get("to_node" )+condiParams.get("to_yard");
				if( input_fm_node == null ) input_fm_node = "";
				if( input_to_node == null ) input_to_node = "";
				
				param.put("vndr_seq"     , condiParams.get("rail_road_code"));
				param.put("cgo_tp_cd"    , condiParams.get("status"));
				param.put("io_bound"     , condiParams.get("io_bound"));
				param.put("ctrl_ofc"     , condiParams.get("ctrl_ofc"));
				param.put("input_fm_node", input_fm_node);
				param.put("input_to_node", input_to_node);
				param.put("fm_month"     , condiParams.get("fm_date"));
				param.put("to_month"     , condiParams.get("to_date"));
				param.put("fm_node_length", input_fm_node.length());
				param.put("to_node_length", input_to_node.length());
				param.put("f_chkprd", condiParams.get("f_chkprd"));
				param.put("loc_on", condiParams.get("loc_on"));
				param.put("agmt_ref_no", condiParams.get("agmt_ref_no"));
				param.put("agmt_chk", condiParams.get("agmt_chk"));
				param.put("cntr_tpsz", condiParams.get("cntr_tpsz"));
				
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USARailPerformanceDBDAOSearchALLSOCRailPerformanceByLaneVvdRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		
		return dbRowset;
	}
	
	/**
	 * USA Rail Performance의 모든 목록을 가져온다.<br>
	 * ALL - SO기준 (철도회사별), Lane/VVD unchecked
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchALLSOCRailPerformance(EsdTrs0103Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			SearchRailPerformanceVO model = event.getSearchRailPerformanceVo();
			
			if( model != null ){
				Map<String, String> condiParams = model.getColumnValues();
				
				String input_fm_node = condiParams.get("frm_node")+condiParams.get("frm_yard");
				String input_to_node = condiParams.get("to_node" )+condiParams.get("to_yard");
				if( input_fm_node == null ) input_fm_node = "";
				if( input_to_node == null ) input_to_node = "";
				
				param.put("vndr_seq"     , condiParams.get("rail_road_code"));
				param.put("cgo_tp_cd"    , condiParams.get("status"));
				param.put("io_bound"     , condiParams.get("io_bound"));
				param.put("ctrl_ofc"     , condiParams.get("ctrl_ofc"));
				param.put("input_fm_node", input_fm_node);
				param.put("input_to_node", input_to_node);
				param.put("fm_month"     , condiParams.get("fm_date"));
				param.put("to_month"     , condiParams.get("to_date"));
				param.put("fm_node_length", input_fm_node.length());
				param.put("to_node_length", input_to_node.length());
				param.put("f_chkprd", condiParams.get("f_chkprd"));
				param.put("loc_on", condiParams.get("loc_on"));
				param.put("agmt_ref_no", condiParams.get("agmt_ref_no"));
				param.put("agmt_chk", condiParams.get("agmt_chk"));
				param.put("cntr_tpsz", condiParams.get("cntr_tpsz"));
				
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USARailPerformanceDBDAOSearchALLSOCRailPerformanceRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		
		return dbRowset;
	}
}