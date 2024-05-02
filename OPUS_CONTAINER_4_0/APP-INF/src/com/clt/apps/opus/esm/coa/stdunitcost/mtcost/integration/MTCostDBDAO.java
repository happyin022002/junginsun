/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MTCostDBDAO.java
*@FileTitle : ECC별 MT 표준단가&MT Turntime 생성
*Open Issues :
*Change history : EQ Repo cost(009) 화면 LCC레벨 추가
*@LastModifyDate : 2009.10.23
*@LastModifier 	: Ari
*               : YJ Jeon
*@LastVersion : 1.5
* 2006-11-16 IM OKYOUNG
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.basic.MTCostBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.EqRepoCostVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListPopUpVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO10;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO11;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO12;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO13;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO14;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO2;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO3;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO4;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO5;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO6;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO7;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO8;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO9;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;



/**
 * OPUS MTCostDBDAO <br>
 * - OPUS-STDUnitCost system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author IM OKYOUNG
 * @see MTCostBCImpl 참조
 * @since J2EE 1.5
 */
public class MTCostDBDAO extends DBDAOSupport {
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet1_MT 조회
	 * @param SearchMTCostListVO searchMTCostListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO>
	 * @throws DAOException
	 */
	public List<SearchMTCostListVO> searchMTCostList(SearchMTCostListVO searchMTCostListVO
			                                        ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCostListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCostListVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCostListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCostListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet2_MT 조회
	 * @param SearchMTCostListVO2 searchMTCostListVO2
	 * @param SearchMTCostListVO searchMTCostListVO
	 * @return List<SearchMTCostListVO2>
	 * @throws DAOException
	 */
	public List<SearchMTCostListVO2> searchMTCostList2(SearchMTCostListVO2 searchMTCostListVO2
			                                          ,SearchMTCostListVO searchMTCostListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCostListVO2> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCostListVO2 != null){
				Map<String, String> mapVO = searchMTCostListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCostListVO2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCostListVO2 .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		 
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet3_MT 조회
	 * @param SearchMTCostListVO3 searchMTCostListVO3
	 * @param SearchMTCostListVO2 searchMTCostListVO2
	 * @return List<SearchMTCostListVO3>
	 * @throws DAOException
	 */
	public List<SearchMTCostListVO3> searchMTCostList3(SearchMTCostListVO3 searchMTCostListVO3
			                                          ,SearchMTCostListVO2 searchMTCostListVO2) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCostListVO3> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCostListVO3 != null){
				Map<String, String> mapVO = searchMTCostListVO2 .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCostListVO3RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCostListVO3 .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet4_MT 조회
	 * @param SearchMTCostListVO4 searchMTCostListVO4
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO4>
	 * @throws DAOException
	 */
	public List<SearchMTCostListVO4> searchMTCostList4(SearchMTCostListVO4 searchMTCostListVO4
			                                          ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCostListVO4> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCostListVO4 != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCostListVO4RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCostListVO4 .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet5_MT 조회
	 * @param SearchMTCostListVO5 searchMTCostListVO5
	 * @param SearchMTCostListVO4 searchMTCostListVO4
	 * @return List<SearchMTCostListVO5>
	 * @throws DAOException
	 */
	public List<SearchMTCostListVO5> searchMTCostList5(SearchMTCostListVO5 searchMTCostListVO5
			                                          ,SearchMTCostListVO4 searchMTCostListVO4) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCostListVO5> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCostListVO5 != null){
				Map<String, String> mapVO = searchMTCostListVO4 .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCostListVO5RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCostListVO5 .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
    /**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet6_MT 조회
	 * @param SearchMTCostListVO6 searchMTCostListVO6
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO6>
	 * @throws DAOException
	 */
	public List<SearchMTCostListVO6> searchMTCostList6(SearchMTCostListVO6 searchMTCostListVO6
			                                          ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCostListVO6> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCostListVO6 != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCostListVO6RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCostListVO6 .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		 
    /**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet7_MT 조회
	 * @param SearchMTCostListVO7 searchMTCostListVO7
	 * @param SearchMTCostListVO6 searchMTCostListVO6
	 * @return List<SearchMTCostListVO7>
	 * @throws DAOException
	 */
	public List<SearchMTCostListVO7> searchMTCostList7(SearchMTCostListVO7 searchMTCostListVO7
			                                          ,SearchMTCostListVO6 searchMTCostListVO6) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCostListVO7> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCostListVO7 != null){
				Map<String, String> mapVO = searchMTCostListVO6 .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCostListVO7RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCostListVO7 .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
			 
    /**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet8_FULL 조회
	 * @param SearchMTCostListVO8 searchMTCostListVO8
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO8>
	 * @throws DAOException
	 */
	public List<SearchMTCostListVO8> searchMTCostList8(SearchMTCostListVO8 searchMTCostListVO8
			                                          ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCostListVO8> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCostListVO8 != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCostListVO8RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCostListVO8 .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
 
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet9_FULL 조회
	 * @param SearchMTCostListVO9 searchMTCostListVO9
	 * @param SearchMTCostListVO8 searchMTCostListVO8
	 * @return List<SearchMTCostListVO9>
	 * @throws DAOException
	 */
	public List<SearchMTCostListVO9> searchMTCostList9(SearchMTCostListVO9 searchMTCostListVO9
			                                          ,SearchMTCostListVO8 searchMTCostListVO8) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCostListVO9> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCostListVO9 != null){
				Map<String, String> mapVO = searchMTCostListVO8 .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCostListVO9RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCostListVO9 .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
					 
    /**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet10_FULL 조회
	 * @param SearchMTCostListVO10 searchMTCostListVO10
	 * @param SearchMTCostListVO9 searchMTCostListVO9
	 * @return List<SearchMTCostListVO10>
	 * @throws DAOException
	 */
	public List<SearchMTCostListVO10> searchMTCostList10(SearchMTCostListVO10 searchMTCostListVO10
			                                            ,SearchMTCostListVO9 searchMTCostListVO9) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCostListVO10> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCostListVO10 != null){
				Map<String, String> mapVO = searchMTCostListVO9 .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCostListVO10RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCostListVO10 .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
						 
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet11_FULL 조회
	 * @param SearchMTCostListVO11 searchMTCostListVO11
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO11>
	 * @throws DAOException
	 */
	public List<SearchMTCostListVO11> searchMTCostList11(SearchMTCostListVO11 searchMTCostListVO11
			                                            ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCostListVO11> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCostListVO11 != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCostListVO11RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCostListVO11 .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
							 
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet12_FULL 조회
	 * @param SearchMTCostListVO12 searchMTCostListVO12
	 * @param SearchMTCostListVO11 searchMTCostListVO11
	 * @return List<SearchMTCostListVO12>
	 * @throws DAOException
	 */
	public List<SearchMTCostListVO12> searchMTCostList12(SearchMTCostListVO12 searchMTCostListVO12
			                                            ,SearchMTCostListVO11 searchMTCostListVO11) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCostListVO12> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCostListVO12 != null){
				Map<String, String> mapVO = searchMTCostListVO11 .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCostListVO12RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCostListVO12 .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
								 
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet13_FULL 조회
	 * @param SearchMTCostListVO13 searchMTCostListVO13
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO13>
	 * @throws DAOException
	 */
	public List<SearchMTCostListVO13> searchMTCostList13(SearchMTCostListVO13 searchMTCostListVO13
			                                            ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCostListVO13> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCostListVO13 != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCostListVO13RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCostListVO13 .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}								 
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet14_FULL 조회
	 * @param SearchMTCostListVO14 searchMTCostListVO14
	 * @param SearchMTCostListVO13 searchMTCostListVO13
	 * @return List<SearchMTCostListVO14>
	 * @throws DAOException
	 */
	public List<SearchMTCostListVO14> searchMTCostList14(SearchMTCostListVO14 searchMTCostListVO14
			                                            ,SearchMTCostListVO13 searchMTCostListVO13) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCostListVO14> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCostListVO14 != null){
				Map<String, String> mapVO = searchMTCostListVO13 .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCostListVO14RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCostListVO14 .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
		/**
		 * 조회 이벤트 처리<br>
		 * MTCost화면에 대한 조회 이벤트 처리_팝업<br>
		 * ESM_COA_0010 조회
		 * @param SearchMTCostListPopUpVO searchMTCostListPopUpVO
		 * @param SearchConditionVO searchConditionVO
		 * @return List<SearchMTCostListPopUpVO>
		 * @throws DAOException
		 */
		public List<SearchMTCostListPopUpVO> searchMTCostListPopUp(SearchMTCostListPopUpVO searchMTCostListPopUpVO
																  ,SearchConditionVO searchConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchMTCostListPopUpVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchConditionVO != null){
					Map<String, String> mapVO = searchConditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCostListPopUpVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCostListPopUpVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		
	    /**
	     * COA_MTY_REPO_UT_COST 목록을 가져온다.<br>
	     * 
	     * @param  SearchConditionVO searchVO
	     * @param  CommonCoaRsVO commonCoaRsVO
	     * @param  Event e 
	     * @return CommonCoaRsVO
	     * @throws DAOException
	     * @author SJH.20140922.ADD
	     */
	    public CommonCoaRsVO searchEqRepoCostList(SearchConditionVO searchVO, CommonCoaRsVO commonCoaRsVO, Event e) throws DAOException {
	    	DBRowSet dbRowset = null;
	        CommonCoaRsVO retVO = null;
	        
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
	        try{
	            if( searchVO != null ) {
	            	if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
		            	param.put("f_cost_yrmon",			searchVO.getFCostYrmon());
		            	param.put("f_cost_loc_grp_cd",		searchVO.getFCostLocGrpCd());
		            	param.put("f_trd_cd",				searchVO.getFTrdCd());
		            	param.put("f_ecc_cd",				searchVO.getFEccCd());
		            	param.put("f_cntr_tpsz_cd",	        searchVO.getFCntrTpszCd());
		            	param.put("f_mty_tp_cd",			searchVO.getFTypeCd());	
		            	velParam = param;
		            	
		            	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOEqRepoCostVORSQL(), param, velParam);
	            	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
	            		//SJH.20141106.MOD : 순서, 변수명 변경
		            	param.put("f_cntr_tpsz_cd",			searchVO.getFViewTpsz());
		            	param.put("f_scc_cd",				searchVO.getFEccCd2());
		            	param.put("f_cost_src_fm_yrmon",	searchVO.getFFrom());
		            	param.put("f_cost_src_to_yrmon",	searchVO.getFTo());
		            	velParam = param;
		            	
		            	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOEqRepoCostVO02RSQL(), param, velParam);
	            	} else {
	            		throw new DAOException("Fail to select SQL");
	            	}
		            
		            retVO = new CommonCoaRsVO();
		            retVO.setDbRowset(dbRowset);
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
	        return retVO;
	    }
	    
		/**
		 * 멀티 이벤트 처리<br>
		 * ESM_COA_4003 화면에 대한 멀티 이벤트 처리(INSERT)<br>
		 * 
		 * @param List<EqRepoCostVO> eqRepoCostVO
		 * @param Event e 
		 * @return int[]
		 * @throws DAOException
		 * @throws Exception
		 * @author SJH.20140923.ADD
		 */
		public int[] addEqRepoCost(List<EqRepoCostVO> eqRepoCostVO, Event e) throws DAOException,Exception {
			int insCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if(eqRepoCostVO .size() > 0){
					if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
						insCnt = sqlExe.executeBatch((ISQLTemplate)new MTCostDBDAOEqRepoCostVOCSQL(), eqRepoCostVO,null);
					} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
						insCnt = sqlExe.executeBatch((ISQLTemplate)new MTCostDBDAOEqRepoCostVO02CSQL(), eqRepoCostVO,null);
					}		
					if(insCnt != null) {										//SJH.20150508.소스품질
						for(int i = 0; i < insCnt.length; i++){
							if(insCnt[i]== Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No"+ i + " SQL");
						}						
					}
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return insCnt;
		}    
		
		/**
		 * 멀티 이벤트 처리<br>
		 * ESM_COA_4003 화면에 대한 멀티 이벤트 처리(UPDATE)<br>
		 * 
		 * @param List<EqRepoCostVO> updModels
		 * @param SearchConditionVO searchConditionVO
		 * @param Event e 
		 * @return int[]
		 * @throws DAOException
		 * @throws Exception
		 * @author SJH.20140923.ADD
		 */
		public int[] modifyEqRepoCost(List<EqRepoCostVO> updModels, SearchConditionVO searchConditionVO, Event e) throws DAOException,Exception {
			int updCnt[] = null;		
			//valocity parameter 받아오기
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {
				if(searchConditionVO != null){
					Map<String, String> mapVO = searchConditionVO .getColumnValues();
					
					velParam.putAll(mapVO);
				}
					
				SQLExecuter sqlExe = new SQLExecuter("");
				if(updModels .size() > 0){
					if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
						updCnt = sqlExe.executeBatch((ISQLTemplate)new MTCostDBDAOEqRepoCostVOUSQL(), updModels,velParam);
					} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
						updCnt = sqlExe.executeBatch((ISQLTemplate)new MTCostDBDAOEqRepoCostVO02USQL(), updModels,velParam);
					}
					if(updCnt != null) {										//SJH.20150508.소스품질
						for(int i = 0; i < updCnt.length; i++){
							if(updCnt[i]== Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No"+ i + " SQL");
						}						
					}
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return updCnt;
		}
		
		/**
		 * Eq Repo Cost 정보를 삭제한다.<br>
		 * 
		 * @param List<EqRepoCostVO> delModels
		 * @param Event e 
		 * @exception DAOException
		 * @exception Exception 
		 * @author SJH.20140923.ADD
		 */
		public void removeEqRepoCost(List<EqRepoCostVO> delModels, Event e) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int delCnt[] = null;
				if(delModels.size() > 0){				
					HashMap<String, Object> velParam = new HashMap<String, Object>();	
					if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
						delCnt = sqlExe.executeBatch((ISQLTemplate)new MTCostDBDAOEqRepoCostVODSQL(), delModels, velParam);
					} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
						delCnt = sqlExe.executeBatch((ISQLTemplate)new MTCostDBDAOEqRepoCostVO02DSQL(), delModels, velParam);
					}
					if(delCnt != null) {										//SJH.20150508.소스품질
						for(int i = 0; i < delCnt.length; i++){
							if(delCnt[i]== Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No"+ i + " SQL");
						}						
					}
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}	    
	    
		
		/**
		 * ESM_COA_4003 화면에 대한 EFF_TO_YRMON 일괄 처리(UPDATE).<br>
		 * 
		 * @param Event e
		 * @exception DAOException
		 */
		public void batchUpEqRepoCost(Event e) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new MTCostDBDAOEqRepoCostBatchVOUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");			
	        } catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
	    }
		
	    
		
	}