/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USDomesticDBDAO.java
*@FileTitle : US domestic cost/credit 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.16
*@LastModifier : 김보배
*@LastVersion : 1.0 
* 2012.10.16 김보배
* 1.0 Creation
=========================================================
* History
* 2012.11.19 송호진 [CHM-201221090-01] [MAS] US DOMESTIC 반영 - 컬럼 추가에 의한 Creation Logic 및 변경 저장 로직 수정 
* 2012.11.20 송호진 [CHM-201221090-01] [MAS] US DOMESTIC 반영 - CNTR_SZ_CD -> CNTR_TPSZ_CD 컬럼명 변경에 따른 수정
* 2013.05.10 최성민 [CHM-201324573-01] [MAS] Domestic Saving Credit 화면 버튼 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.basic.AverageRPBBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.vo.AverageRPBVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.integration.USDomesticDBDAOSearchUSDomCreationStatusRSQL;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration.NetworkDistributionDBDAOAddTSAllocationBatchStatusCSQL;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration.NetworkDistributionDBDAOCheckTsAllocationCreateBatchStatusRSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasUtCostCreStsVO;



/**
 * ALPS USDomesticDBDAO <br>
 * - ALPS-STDUnitCost system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author BOBAE KIM	
 * @see USDomesticBCImpl 참조
 * @since J2EE 1.5
 */
public class AverageRPBDBDAO extends DBDAOSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8054340430556693140L;

	/**
	 * searchRouteRPBList 조회
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @return List<AverageRPBVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AverageRPBVO> searchRouteRPBList(AverageRPBVO averageRPBVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AverageRPBVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(averageRPBVO != null){
				Map<String, String> mapVO = averageRPBVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AverageRPBDBDAOSearchRouteRPBListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AverageRPBVO.class);
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
	 * searchCustomerRPBList 조회
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @return List<AverageRPBVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AverageRPBVO> searchCustomerRPBList(AverageRPBVO averageRPBVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AverageRPBVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(averageRPBVO != null){
				Map<String, String> mapVO = averageRPBVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AverageRPBDBDAOSearchCustomerRPBListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AverageRPBVO.class);
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
	 * searchSCCRPBList 조회
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @return List<AverageRPBVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AverageRPBVO> searchSCCRPBList(AverageRPBVO averageRPBVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AverageRPBVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(averageRPBVO != null){
				Map<String, String> mapVO = averageRPBVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AverageRPBDBDAOSearchSCCRPBListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AverageRPBVO.class);
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
	 * searchLaneRPBList 조회
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @return List<AverageRPBVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AverageRPBVO> searchLaneRPBList(AverageRPBVO averageRPBVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AverageRPBVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(averageRPBVO != null){
				Map<String, String> mapVO = averageRPBVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AverageRPBDBDAOSearchLaneRPBListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AverageRPBVO.class);
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
	 * searchTradeRPBList 조회
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @return List<AverageRPBVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AverageRPBVO> searchTradeRPBList(AverageRPBVO averageRPBVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AverageRPBVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(averageRPBVO != null){
				Map<String, String> mapVO = averageRPBVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AverageRPBDBDAOSearchTradeRPBListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AverageRPBVO.class);
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
	 * ESM_MAS_0183 : CREATE 된 기간 조회
	 *
	 * @param String fRpbYrmon
	 * @return String
	 * @throws EventException
	 */
	public String searchAverageRPBCreationStatus(String fRpbYrmon) throws DAOException {
		
		String retVal = "";
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (!fRpbYrmon.equals("")) {
				Map<String, String> mapVO = new HashMap<String, String>();

				mapVO.put("f_rpb_yrmon", fRpbYrmon);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AverageRPBDBDAOSearchAverageRPBCreationStatusRSQL(), param, velParam);

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
	 * Target YRMON 에 대해 AverageRPB 배치가 실행 되었는지 확인한다.
	 * 
	 * @param String fTargetYrMon 
	 * @return List<MasUtCostCreStsVO>
	 * @throws DAOException
	 */
	public List<MasUtCostCreStsVO> searchRPBStatus(String fTargetYrMon) throws DAOException {
        DBRowSet dbRowset = null;
        List<MasUtCostCreStsVO> list = null;
      //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		param.put("f_target_yrmon", fTargetYrMon);
        try{
	        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AverageRPBDBDAOSearchRPBStatusRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, MasUtCostCreStsVO.class);        		
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
	
	/**
	 * Average RPB BATCH 가 실행중인지를 check 한다.
	 * 
	 * @return List<MasUtCostCreStsVO>
	 * @throws DAOException
	 */
	public List<MasUtCostCreStsVO> checkAverageRPBCreateBatchStatus() throws DAOException {
        DBRowSet dbRowset = null;
        List<MasUtCostCreStsVO> list = null;
      //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
	        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AverageRPBDBDAOCheckAverageRPBCreateBatchStatusRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, MasUtCostCreStsVO.class);        		
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
	
	/**
	 * TS Allocation BATCH status 를 생성한다. <br>
	 * 
	 * @param AverageRPBVO averageRPBVO
	 * @throws DAOException
	 */
	public void modifyAverageRPBStatus(AverageRPBVO averageRPBVO) throws DAOException {
      //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
        try{
        	if(averageRPBVO != null){
        		Map<String, String> mapVO = averageRPBVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
        	}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AverageRPBDBDAOModifyAverageRPBStatusRSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
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
	 * ESM_MAS_0183 : CREATE 된 기간 조회
	 *
	 * @param AverageRPBVO averageRPBVO
	 * @return String
	 * @throws EventException
	 */
	public String searchAverageRPBParam(AverageRPBVO averageRPBVO) throws DAOException {
		
		String retVal = "";
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(averageRPBVO != null){
        		Map<String, String> mapVO = averageRPBVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
        	}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AverageRPBDBDAOSearchAverageRPBParamRSQL(), param, velParam);

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
	
}