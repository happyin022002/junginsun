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
* 
*  Change history : 
*  2008.07.28 전윤주 : CSR NO. N200807170013 COA_EQ Repo 단가 조회 화면 변경
*  2009.08.20 박수훈 : New Framework 생성[0009]           
*  2009.09.14 장영석 : New Framework 생성[0010]    
*  2009.10.23 전윤주 CSR No. CHM-200901392 Simulated Cost 조회 시에도 Full based MT 컬럼이 조회되어 같은 단가가 조회됨
*                          LCC, RCC 일 경우에만. simulated cost column 으로 수정 [009 - sheet 4, sheet 6]     
* 2010.02.05 임옥영 품질검토 결과 반영 - 주석이 원래 있는데 추출되서 공백등 다시한번 작성
* 2010.02.16 임옥영 품질검토 결과 반영 Line No. 186 :  : shall be matched with type of parameter(SearchMTCostListVO vs SearchConditionVO)
* 2011.07.12 최성민 [CHM-201111826] R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
* 2012.09.10 이석준 [CHM-201220070-01] EQ Repo Cost (PA) 화면에 Month Copy 기능 추가 
* 2013.09.04 김수정 [CHM-201326480] EMU_RA 화면 MB Data 없는 경우 Pre Simulation 화면과 동일 조건으로 Data 조회하도록 변경
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.basic.MTCostBCImpl;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost10ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost11ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost12ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost13ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost14ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost2ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost3ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost4ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost5ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost6ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost7ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost8ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost9ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCostDetailListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListPopUpVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;



/**
 * ALPS MTCostDBDAO <br>
 * - ALPS-STDUnitCost system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
	 * @param SearchMTCost2ListVO searchMTCost2ListVO
	 * @param SearchMTCostListVO searchMTCostListVO
	 * @return List<SearchMTCost2ListVO>
	 * @throws DAOException
	 */
	public List<SearchMTCost2ListVO> searchMTCost2List(SearchMTCost2ListVO searchMTCost2ListVO
			                                          ,SearchMTCostListVO searchMTCostListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCost2ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCost2ListVO != null){
				Map<String, String> mapVO = searchMTCostListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCost2ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCost2ListVO .class);
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
	 * @param SearchMTCost3ListVO searchMTCost3ListVO
	 * @param SearchMTCost2ListVO searchMTCost2ListVO
	 * @return List<SearchMTCost3ListVO>
	 * @throws DAOException
	 */
	public List<SearchMTCost3ListVO> searchMTCost3List(SearchMTCost3ListVO searchMTCost3ListVO
			                                          ,SearchMTCost2ListVO searchMTCost2ListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCost3ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCost3ListVO != null){
				Map<String, String> mapVO = searchMTCost2ListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCost3ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCost3ListVO .class);
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
	 * @param SearchMTCost4ListVO searchMTCost4ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCost4ListVO>
	 * @throws DAOException
	 */
	public List<SearchMTCost4ListVO> searchMTCost4List(SearchMTCost4ListVO searchMTCost4ListVO
			                                          ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCost4ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCost4ListVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCost4ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCost4ListVO .class);
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
	 * @param SearchMTCost5ListVO searchMTCost5ListVO
	 * @param SearchMTCost4ListVO searchMTCost4ListVO
	 * @return List<SearchMTCost5ListVO>
	 * @throws DAOException
	 */
	public List<SearchMTCost5ListVO> searchMTCost5List(SearchMTCost5ListVO searchMTCost5ListVO
			                                          ,SearchMTCost4ListVO searchMTCost4ListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCost5ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCost5ListVO != null){
				Map<String, String> mapVO = searchMTCost4ListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCost5ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCost5ListVO .class);
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
	 * @param SearchMTCost6ListVO searchMTCost6ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCost6ListVO>
	 * @throws DAOException
	 */
	public List<SearchMTCost6ListVO> searchMTCost6List(SearchMTCost6ListVO searchMTCost6ListVO
			                                          ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCost6ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCost6ListVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCost6ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCost6ListVO .class);
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
	 * @param SearchMTCost7ListVO searchMTCost7ListVO
	 * @param SearchMTCost6ListVO searchMTCost6ListVO
	 * @return List<SearchMTCost7ListVO>
	 * @throws DAOException
	 */
	public List<SearchMTCost7ListVO> searchMTCost7List(SearchMTCost7ListVO searchMTCost7ListVO
			                                          ,SearchMTCost6ListVO searchMTCost6ListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCost7ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCost7ListVO != null){
				Map<String, String> mapVO = searchMTCost6ListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCost7ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCost7ListVO .class);
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
	 * @param SearchMTCost8ListVO searchMTCost8ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCost8ListVO>
	 * @throws DAOException
	 */
	public List<SearchMTCost8ListVO> searchMTCost8List(SearchMTCost8ListVO searchMTCost8ListVO
			                                          ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCost8ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCost8ListVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCost8ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCost8ListVO .class);
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
	 * @param SearchMTCost9ListVO searchMTCost9ListVO
	 * @param SearchMTCost8ListVO searchMTCost8ListVO
	 * @return List<SearchMTCost9ListVO>
	 * @throws DAOException
	 */
	public List<SearchMTCost9ListVO> searchMTCost9List(SearchMTCost9ListVO searchMTCost9ListVO
			                                          ,SearchMTCost8ListVO searchMTCost8ListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCost9ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCost9ListVO != null){
				Map<String, String> mapVO = searchMTCost8ListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCost9ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCost9ListVO .class);
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
	 * @param SearchMTCost10ListVO searchMTCost10ListVO
	 * @param SearchMTCost9ListVO searchMTCost9ListVO
	 * @return List<SearchMTCost10ListVO>
	 * @throws DAOException
	 */
	public List<SearchMTCost10ListVO> searchMTCost10List(SearchMTCost10ListVO searchMTCost10ListVO
			                                            ,SearchMTCost9ListVO searchMTCost9ListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCost10ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCost10ListVO != null){
				Map<String, String> mapVO = searchMTCost9ListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCost10ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCost10ListVO .class);
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
	 * @param SearchMTCost11ListVO searchMTCost11ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCost11ListVO>
	 * @throws DAOException
	 */
	public List<SearchMTCost11ListVO> searchMTCost11List(SearchMTCost11ListVO searchMTCost11ListVO
			                                            ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCost11ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCost11ListVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCost11ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCost11ListVO .class);
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
	 * @param SearchMTCost12ListVO searchMTCost12ListVO
	 * @param SearchMTCost11ListVO searchMTCost11ListVO
	 * @return List<SearchMTCost12ListVO>
	 * @throws DAOException
	 */
	public List<SearchMTCost12ListVO> searchMTCost12List(SearchMTCost12ListVO searchMTCost12ListVO
			                                            ,SearchMTCost11ListVO searchMTCost11ListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCost12ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCost12ListVO != null){
				Map<String, String> mapVO = searchMTCost11ListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCost12ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCost12ListVO .class);
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
	 * @param SearchMTCost13ListVO searchMTCost13ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCost13ListVO>
	 * @throws DAOException
	 */
	public List<SearchMTCost13ListVO> searchMTCost13List(SearchMTCost13ListVO searchMTCost13ListVO
			                                            ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCost13ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCost13ListVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCost13ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCost13ListVO .class);
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
	 * @param SearchMTCost14ListVO searchMTCost14ListVO
	 * @param SearchMTCost13ListVO searchMTCost13ListVO
	 * @return List<SearchMTCost14ListVO>
	 * @throws DAOException
	 */
	public List<SearchMTCost14ListVO> searchMTCost14List(SearchMTCost14ListVO searchMTCost14ListVO
			                                            ,SearchMTCost13ListVO searchMTCost13ListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMTCost14ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMTCost14ListVO != null){
				Map<String, String> mapVO = searchMTCost13ListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCost14ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCost14ListVO .class);
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
		 * EQ Repo Cost 관련 Table을 삭제 한다. 
		 *
		 * @param HashMap<String, String> map
		 * @throws DAOException
		 */
		public void removeEqRepoCost(HashMap<String, String> map) throws DAOException {
			int saveCnt = 0;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();


	        try{
	        	
//	        	System.out.println("\n\n=======>"+map.toString());
	        	
	        	velParam.put("table_name", "COA_MTCH_BAK_INFO");
	        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MTCostDBDAORemoveEqRepoCostDSQL(), map, velParam);
	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL");           

	        	velParam.put("table_name", "COA_FULL_ECC_IMBAL");
	        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MTCostDBDAORemoveEqRepoCostDSQL(), map, velParam);
	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL");  
	            
	        	velParam.put("table_name", "COA_CNTR_MTY_MVMT");
	        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MTCostDBDAORemoveEqRepoCostDSQL(), map, velParam);
	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL");  
	            
	        	velParam.put("table_name", "COA_MTY_CNTR_ROUT_PERF");
	        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MTCostDBDAORemoveEqRepoCostDSQL(), map, velParam);
	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL");  
	            
	        	velParam.put("table_name", "COA_MTY_ECC_CNTR_SMRY");
	        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MTCostDBDAORemoveEqRepoCostDSQL(), map, velParam);
	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL");   
	            
	        	velParam.put("table_name", "COA_MTY_CNTR_ROUT_DTL");
	        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MTCostDBDAORemoveEqRepoCostDSQL(), map, velParam);
	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL");  
	            
	        	velParam.put("table_name", "COA_MTY_ECC_UT_COST");
	        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MTCostDBDAORemoveEqRepoCostDSQL(), map, velParam);
	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL");  
	            
	        	velParam.put("table_name", "COA_MTY_DEST_COST");
	        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MTCostDBDAORemoveEqRepoCostDSQL(), map, velParam);
	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL"); 
	            
	        }catch (SQLException se) {
	            log.error("err " + se.toString(), se);
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error("err " + ex.toString(), ex);
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }

		}	
		
		/**
		 * EQ Repo Cost 관련  데이터를 전월로부터 복사한다.
		 *
		 * @param HashMap<String, String> map
		 * @throws DAOException
		 */
		public void createCopyEqRepoCost(HashMap<String, String> map) throws DAOException {
			int saveCnt = 0;
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();


	        try{
	        	velParam.put("table_name", "COA_MTCH_BAK_INFO");
	        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MTCostDBDAOCreateCopyEqRepoCostCSQL(), map, velParam);
	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL");

	        	velParam.put("table_name", "COA_FULL_ECC_IMBAL");
	        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MTCostDBDAOCreateCopyEqRepoCostCSQL(), map, velParam);
	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL");  
	            
	        	velParam.put("table_name", "COA_CNTR_MTY_MVMT");
	        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MTCostDBDAOCreateCopyEqRepoCostCSQL(), map, velParam);
	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL");
	            
	        	velParam.put("table_name", "COA_MTY_CNTR_ROUT_PERF");
	        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MTCostDBDAOCreateCopyEqRepoCostCSQL(), map, velParam);
	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL");            

	        	velParam.put("table_name", "COA_MTY_ECC_CNTR_SMRY");
	        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MTCostDBDAOCreateCopyEqRepoCostCSQL(), map, velParam);
	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL");             

	        	velParam.put("table_name", "COA_MTY_CNTR_ROUT_DTL");
	        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MTCostDBDAOCreateCopyEqRepoCostCSQL(), map, velParam);
	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL");  
	            
	        	velParam.put("table_name", "COA_MTY_ECC_UT_COST");
	        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MTCostDBDAOCreateCopyEqRepoCostCSQL(), map, velParam);
	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL"); 
	        	
	            velParam.put("table_name", "COA_MTY_DEST_COST");
	        	saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MTCostDBDAOCreateCopyEqRepoCostCSQL(), map, velParam);
	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL"); 
	            
	        }catch (SQLException se) {
	            log.error("err " + se.toString(), se);
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error("err " + ex.toString(), ex);
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }

		}	
		
		/**
		 * MT RepoCost UC 월단가 복사 상태를 단가 관리 table에 update한다.
		 *
		 * @param  HashMap<String, String> map
		 * @throws DAOException
		 */
		public void modifyEqRepoCostCopyCreationStatus(HashMap<String, String> map) throws DAOException {
			int saveCnt = 0;

	        try{
	            saveCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new MTCostDBDAOModifyEqRepoCostCopyCreStsUSQL(), map, null);
	            if(saveCnt== Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to modify SQL");

	        }catch (SQLException se) {
	            log.error("err " + se.toString(), se);
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error("err " + ex.toString(), ex);
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
		}

		/**
		 * EQ Repo Cost 의  M/B 기간을 조회한다.<br>
		 * 
		 * @param fCostYrmon
		 * @return String
		 * @throws DAOException
		 */
		public String searchMTCostCreationStatus(String fCostYrmon) throws DAOException {
			
			String retVal = "";
			DBRowSet dbRowset = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (!fCostYrmon.equals("")) {
					Map<String, String> mapVO = new HashMap<String, String>();

					mapVO.put("f_cost_yrmon", fCostYrmon);
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MTCostDBDAOSearchMTCostCreationStatusRSQL(), param, velParam);

				if(dbRowset.getRowCount() > 0) {
					if (dbRowset.next()) {
						retVal = dbRowset.getString(1);
					}
				}
			} catch (SQLException se) {
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return retVal;
		}

		/**
		 * Route별 MT 단가를 조회한다.
		 * 
		 * @param SearchConditionVO searchConditionVO
		 * @return List<SearchMTCostDetailListVO>
		 * @exception DAOException
		 */
		public List<SearchMTCostDetailListVO> searchMTCostDetailList(SearchConditionVO searchConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchMTCostDetailListVO> list = null;
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
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTCostDBDAOSearchMTCostDetailListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMTCostDetailListVO .class);
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