/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : MultiDimensionRPTDBDAO.java
 *@FileTitle : MultiDimensionRPTDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 2006-11-09 Sangwook_nam
 * 1.0 최초 생성
 * =========================================================
 * History
 =========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.basic.MultiDimensionRPTBCImpl;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo.PnlRptItemVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo.RepoPfmcConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo.SearchReportViewListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration.CostStructureDBDAOCheckMainGrpCostCodeRSQL;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.MainGrpCostCodeVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.CoaRptAuthMgmtVO;


/**
 * OPUS-COA에 대한 DB 처리를 담당<br> - OPUS-COA Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sangwook_nam
 * @see MultiDimensionRPTBCImpl 참조
 * @since J2EE 1.6
 */
public class MultiDimensionRPTDBDAO extends DBDAOSupport {
		
	
	/**
	 * MultiDimensionRPT의 데이타 모델에 해당되는 값을 불러온다.<br> - 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchLaneRgstList(RepoPfmcConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchLaneRgstListRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}	

	/**
	 * MultiDimensionRPT의 데이타 모델에 해당되는 값을 불러온다.<br> - 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchPfitLssRptItmList(RepoPfmcConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();				
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchPfitLssRptItmListRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * P/L By Account<br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased1List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
						
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//header 변수 세팅				
				velParam.put("allcols", cols);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased1ListRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased2List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased2ListRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeeklySalesByOffice3TEUBased3List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased3ListRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * P/L By Lane/Bound <br>
	 * 사용 프로그램 : ESM_COA_072
	 * 
	 * @param RepoPfmcConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
/*	public DBRowSet searchWeeklySalesByOffice3TEUBased3Op4List(RepoPfmcConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased3Op4ListRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	*/	
	/**
	 * Report view 의 목록을 가져온다.<br>
	 * ESM_COA_0130 조회
	 * @param SearchReportViewListVO searchReportViewListVO
	 * @return List<SearchReportViewListVO>
	 * @throws DAOException
	 */
	public List<SearchReportViewListVO> searchReportViewList(SearchReportViewListVO searchReportViewListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchReportViewListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchReportViewListVO != null){
				Map<String, String> mapVO = searchReportViewListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchReportViewListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchReportViewListVO .class);
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
	 * COA_RPT_AUTH_MGMT 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * ESM_COA_0130 수정
	 * @param List<CoaRptAuthMgmtVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyMultiReportView(List<CoaRptAuthMgmtVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MultiDimensionRPTDBDAOCoaRptAuthMgmtVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * P/L Report Item 정보를 조회해 온다.<br>
	 * 
	 * @return List<MainGrpCostCodeVO>
	 * @throws DAOException
	 */
	public List<PnlRptItemVO> searchPnlRptItem() throws DAOException {
		DBRowSet dbRowset = null;
		List<PnlRptItemVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOSearchPnlRptItemRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PnlRptItemVO.class);
			
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
	 * P/L Report Item 중복을 체크한다.<br>
	 * 
	 * @param PnlRptItemVO pnlRptItemVO
	 * @return int
	 * @throws DAOException
	 */
	public int checkPnlRptItem(PnlRptItemVO pnlRptItemVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int checkCnt = 0;

		try{
			Map<String, String> mapVO = pnlRptItemVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MultiDimensionRPTDBDAOCheckPnlRptItemRSQL(), param, velParam);
            while(dbRowset.next()){
            	checkCnt = dbRowset.getInt(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return checkCnt;
	}

	/**
	 * P/L Report Item 정보를 생성한다.<br>
	 * 
	 * @param List<PnlRptItemVO> insertVoList
	 * @throws DAOException
	 */
	public void addPnlRptItem(List<PnlRptItemVO> insertVoList) throws DAOException {
		
		//query parameter
		@SuppressWarnings("unused")
		int creCnt[] = null;
		try{
		
			
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new MultiDimensionRPTDBDAOAddPnlRptItemCSQL(), insertVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
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
	
	}

	/**
	 * P/L Report Item 정보를 수정한다.<br>
	 * 
	 * @param List<PnlRptItemVO> updateVoList
	 * @throws DAOException
	 */
	public void modifyPnlRptItem(List<PnlRptItemVO> updateVoList) throws DAOException {
		//query parameter
		@SuppressWarnings("unused")
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new MultiDimensionRPTDBDAOModifyPnlRptItemUSQL(), updateVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	}
	
	/**
	 * P/L Report Item 정보를 삭제한다.<br>
	 * 
	 * @param List<PnlRptItemVO> deleteVoList
	 * @throws DAOException
	 */
	public void removePnlRptItem(List<PnlRptItemVO> deleteVoList) throws DAOException {
		
		//query parameter
		@SuppressWarnings("unused")
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new MultiDimensionRPTDBDAORemovePnlRptItemDSQL(), deleteVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to delete No"+ i + " SQL");
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

	}
}
