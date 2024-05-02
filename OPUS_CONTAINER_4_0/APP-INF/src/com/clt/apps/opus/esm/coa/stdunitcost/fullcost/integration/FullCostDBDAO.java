/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FullCostDBDAO.java
*@FileTitle : Node Cost (PA/RA)
*Open Issues :
*Change history :2007-06-07=EMS_COA_008 관련 메소드:prd과 프로그램 공유를 위해 sheet1, 2, 3삭제하고 4를 1로 대체
*@LastModifyDate : 2009-07-24
*@LastModifier : 장영석
*@LastVersion : 1.8
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.fullcost.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.basic.FullCostBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchLinkCostListByPRDVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchLinkCostListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchMonthNodeCostListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchMonthYardCodeListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS-COA에 대한 DB 처리를 담당<br>
 * - OPUS-COA Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author IM OKYOUNG
 * @see FullCostBCImpl 참조
 * @since J2EE 1.5
 */
public class FullCostDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * FullCost의 모든 목록을 가져온다.<br>
	 * ESM_COA_0004 sheet1
	 *
	 * @param SearchMonthYardCodeListVO searchMonthYardCodeListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return  List<SearchMonthYardCodeListVO>
	 * @throws DAOException
	 */
		public List<SearchMonthYardCodeListVO> searchMonthYardCodeList(SearchMonthYardCodeListVO searchMonthYardCodeListVO
				                                                      ,SearchConditionVO searchConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchMonthYardCodeListVO> list = null;
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
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FullCostDBDAOSearchMonthYardCodeListVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthYardCodeListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * FullCost의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * ESM_COA_0004 sheet2
	 * @param SearchMonthYardCodeListVO searchMonthYardCodeListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMonthNodeCostListVO>
	 * @throws DAOException
	 */
		public List<SearchMonthNodeCostListVO> searchMonthNodeCostList (SearchMonthYardCodeListVO searchMonthYardCodeListVO
				                                                       ,SearchConditionVO searchConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchMonthNodeCostListVO> list = null;
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
		
			if(searchMonthYardCodeListVO != null){
				Map<String, String> mapVO = searchMonthYardCodeListVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			//SJH.20150508.소스품질
			if(searchConditionVO != null && "M".equals(searchConditionVO.getFFullMtyCd())) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FullCostDBDAOSearchMonthNodeCostListVORSQL(), param, velParam);
			}else{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FullCostDBDAOSearchMonthNodeCostListVO1RSQL(), param, velParam);
			}
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthNodeCostListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * Full Link cost의 모든 목록을 가져온다.<br>
	 * ESM_COA_0008화면 sheet1
	 * @param SearchLinkCostListVO searchLinkCostListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchLinkCostListVO>
	 * @throws DAOException
	 */
		public List<SearchLinkCostListVO> searchLinkCostList(SearchLinkCostListVO searchLinkCostListVO
				                                            ,SearchConditionVO searchConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchLinkCostListVO> list = null;
			//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchLinkCostListVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			if("M".equals(searchConditionVO.getFFullMtyCd())) {
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FullCostDBDAOSearchLinkCostListVORSQL(), param, velParam);
		}else{
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FullCostDBDAOSearchLinkCostListVO1RSQL(), param, velParam);
					}
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLinkCostListVO .class);
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
	 * Full Link cost 팝업화면의 모든 목록을 가져온다.<br>
	 * ESM_COA_0141화면 sheet
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchLinkCostListByPRDVO>
	 * @throws DAOException
	 */
		public List<SearchLinkCostListByPRDVO> searchLinkCostListByPRD(SearchConditionVO searchConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchLinkCostListByPRDVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				if(searchConditionVO != null){
					Map<String, String> mapVO = searchConditionVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FullCostDBDAOSearchLinkCostListByPRDVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLinkCostListByPRDVO .class);
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