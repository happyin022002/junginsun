/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostBatchDBDAO.java
*@FileTitle : Cost Batch
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.14
*@LastModifier : 이혜민
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
* 2013.01.14 이혜민  CHM-201322300  [AOC] Batch creation 시 기준 WGT 입력 기능추가 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.basic.CostBatchBCImpl;
import com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.vo.SearchCostCalcListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ESD-AOC에 대한 DB 처리를 담당<br>
 * - ESD-AOC Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 
 * @see CostBatchBCImpl 참조
 * @since J2EE 1.4
 */
public class CostBatchDBDAO extends DBDAOSupport {
	
	/**
	 * Inland Cost Batch Creation 조회.<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCostCalcListVO> searchCostCalcList(SearchCostCalcListVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCostCalcListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			if( inputVO != null ){
				Map<String, String> mapVO = inputVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostBatchDBDAOSearchCostCalcListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCostCalcListVO .class);
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
	 * Inland Cost Batch Queue Insert.<br>
	 * 
	 * @param insertVoList
	 * @throws DAOException
	 */
	public void insertBatchQueue(List<SearchCostCalcListVO> insertVoList) throws DAOException {
		//velocity parameter
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CostBatchDBDAOInsertBatchQueueCSQL(), insertVoList, null);
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
	 * Inland Cost Batch Re-Batch Queue - HDR Tariff Seq. Modify<br>
	 * 
	 * @param updModels
	 * @throws DAOException
	 */
	public void modifyBatchSeq(List<SearchCostCalcListVO> updModels ) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(updModels != null){
				int result = 0;
				for (int i = 0; i < updModels.size(); i++) {
					if (updModels.get(i) != null) {
						Map<String, String> mapVO = updModels.get(i).getColumnValues();

						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					SQLExecuter sqlExe = new SQLExecuter("");
					result = sqlExe.executeUpdate((ISQLTemplate) new CostBatchDBDAOModifyBatchSeqUSQL(), param, velParam);
					if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

					param.clear();
					velParam.clear();
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
	 * @param updateVoList
	 * @throws DAOException
	 */
	public void modifyUsaBatchDtlSeq(List<SearchCostCalcListVO> updateVoList) throws DAOException {
		//velocity parameter
		int updCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostBatchDBDAOModifyUsaBatchDtlSeqUSQL(), updateVoList, null);
				for(int i=0; i<updCnt.length;i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
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
	 * Inland Cost Batch Execute Monitoring.<br>
	 * 
	 * @param searchCostCalcListVO
	 * @return
	 * @throws DAOException
	 */
	public String monitorBatchExec(SearchCostCalcListVO searchCostCalcListVO) throws DAOException {
		DBRowSet dbRowset = null;
		String progFlg = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if( searchCostCalcListVO != null ){
				Map<String, String> mapVO = searchCostCalcListVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostBatchDBDAOMonitorBatchExecRSQL(), param, velParam);
			if ( dbRowset!=null && dbRowset.next() ){
				progFlg = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return progFlg;
	}
	
	/**
	 * Ocean Feeder Cost Batch Creation 조회.<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	public List<SearchCostCalcListVO> searchFeederCostCalcList(SearchCostCalcListVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCostCalcListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			if( inputVO != null ){
				Map<String, String> mapVO = inputVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostBatchDBDAOSearchFeederCostCalcListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCostCalcListVO .class);
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
	 * Ocean Feeder Cost Batch Queue Insert.<br>
	 * 
	 * @param insertVoList
	 * @throws DAOException
	 */
	public void insertFeederBatchQueue(List<SearchCostCalcListVO> insertVoList) throws DAOException {
		//velocity parameter
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CostBatchDBDAOInsertFeederBatchQueueCSQL(), insertVoList, null);
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
	 * Ocean Feeder Cost Batch Execute Monitoring.<br>
	 * 
	 * @param searchCostCalcListVO
	 * @return
	 * @throws DAOException
	 */
	public String monitorFeederBatchExec(SearchCostCalcListVO searchCostCalcListVO) throws DAOException {
		DBRowSet dbRowset = null;
		String progFlg = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if( searchCostCalcListVO != null ){
				Map<String, String> mapVO = searchCostCalcListVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostBatchDBDAOMonitorFeederBatchExecRSQL(), param, velParam);
			if ( dbRowset!=null && dbRowset.next() ){
				progFlg = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return progFlg;
	}
	
	/**
	 * Inland Cost Batch Cancel.<br>
	 * 
	 * @param updateVoList
	 * @throws DAOException
	 */
	public void modifyBatchCancel(List<SearchCostCalcListVO> updateVoList) throws DAOException {
		//velocity parameter
		int updCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostBatchDBDAOModifyBatchCancelUSQL(), updateVoList, null);
				for(int i=0; i<updCnt.length;i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
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
	 * Inland Cost Tariff 0건인 대상의 Confirm.<br>
	 * 
	 * @param updateVoList
	 * @throws DAOException
	 */
	public void modifyInlandCostCfm(List<SearchCostCalcListVO> updateVoList) throws DAOException {
		//velocity parameter
		int updCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostBatchDBDAOModifyInlandCostCfmUSQL(), updateVoList, null);
				for(int i=0; i<updCnt.length;i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
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
	 * Inland Cost Tariff 0건인 대상의 Confirm 시 이전 차수의 Tariff No 에 Effective To Date Update<br>
	 * 
	 * @param updateVoList
	 * @throws DAOException
	 */
	public void modifyInlandCostPreVerByCfm(List<SearchCostCalcListVO> updateVoList) throws DAOException {
		//velocity parameter
		int updCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostBatchDBDAOModifyInlandCostPreVerByCfmUSQL(), updateVoList, null);
				for(int i=0; i<updCnt.length;i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
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
	 * Inland Cost Tariff Confirm Cancel.<br>
	 * 
	 * @param updateVoList
	 * @throws DAOException
	 */
	public void modifyInlandCostCfmCxl(List<SearchCostCalcListVO> updateVoList) throws DAOException {
		//velocity parameter
		int updCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostBatchDBDAOModifyInlandCostCfmCxlUSQL(), updateVoList, null);
				for(int i=0; i<updCnt.length;i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
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
	 * Inland Cost Tariff 0건인 대상의 Confirm 취소 시 이전 차수의 Tariff No 에 Effective To Date Update<br>
	 * 
	 * @param updateVoList
	 * @throws DAOException
	 */
	public void modifyInlandCostPreVerByCfmCxl(List<SearchCostCalcListVO> updateVoList) throws DAOException {
		//velocity parameter
		int updCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostBatchDBDAOModifyInlandCostPreVerByCfmCxlUSQL(), updateVoList, null);
				for(int i=0; i<updCnt.length;i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
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
	 * Inland Cost Batch Status Monitoring.<br>
	 * 
	 * @param seqArr
	 * @return
	 * @throws DAOException
	 */
	public String monitorWaitingSts(String seqArr) throws DAOException {
		DBRowSet dbRowset = null;
		String errFlg = "";
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if( seqArr != null ){
				velParam.put("cost_trf_bat_seq_arr", seqArr);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostBatchDBDAOMonitorWaitingStsRSQL(), null, velParam);
			if ( dbRowset!=null && dbRowset.next() ){
				errFlg = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return errFlg;
	}
	
	
	/**
	 * Guideline 존재 여부 확인.<br>
	 * 
	 * @param costTrfNo
	 * @return
	 * @throws DAOException
	 */
	public String searchGuidelineExist(String costTrfNo) throws DAOException {
		DBRowSet dbRowset = null;
		String existFlg = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if( costTrfNo != null ){
				param.put("cost_trf_no", costTrfNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostBatchDBDAOSearchGuidelineExistRSQL(), param, null);
			if ( dbRowset!=null && dbRowset.next() ){
				existFlg = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return existFlg;
	}
	
}